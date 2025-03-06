package com.fastays.adapter_hotel_prebooking.service.impl;

import com.fastays.adapter_hotel_prebooking.constants.HotelPrebookingConstants;
import com.fastays.adapter_hotel_prebooking.dto.request.HotelRequest;
import com.fastays.adapter_hotel_prebooking.dto.response.responeTboClasses.*;
import com.fastays.adapter_hotel_prebooking.dto.response.responseMngoClass.HotelBookingResponseMngo;
import com.fastays.adapter_hotel_prebooking.exceptions.ResourceNotFoundException;
import com.fastays.adapter_hotel_prebooking.repository.MongoDbRepository;
import com.fastays.adapter_hotel_prebooking.service.interfaces.HotelPrebookingService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class HotelPrebookingServiceImpl implements HotelPrebookingService {

    @Value("${tbo.api.url}")
    private String apiUrl;

    @Value("${tbo.api.username}")
    private String apiUserName;

    @Value("${tbo.api.secret}")
    private String apiSecret;

    private final RestTemplate restTemplate;
    private final Configuration freemarkerConfiguration;
    private final MongoDbRepository mongoDbRepository;

    @Override
    public ResponseEntity<?> bookHotel(HotelRequest hotelRequest) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBasicAuth(apiUserName, apiSecret);
            HttpEntity<HotelRequest> requestEntity = new HttpEntity<>(hotelRequest, headers);

            // API Call
            ResponseEntity<HotelResponseTbo> response =
                    restTemplate.exchange(apiUrl, HttpMethod.POST,requestEntity, HotelResponseTbo.class);

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                HotelResponseTbo hotelResponseTbo = response.getBody();
                HotelBookingResponseMngo fetchedHotels = null;
                if (hotelResponseTbo.getHotelResult() != null) {
                    fetchedHotels = fetchHotelUsingBookingCode(hotelResponseTbo);
                }
                String mappedFTL = maptoFtl(hotelResponseTbo, fetchedHotels);
                return ResponseEntity.ok(mappedFTL);
            } else {
                log.info("Failed to book hotel. Status: {}", response.getStatusCode());
                return ResponseEntity.status(response.getStatusCode())
                        .body("Booking failed: " + response.getStatusCode().toString());
            }
        } catch (ResourceNotFoundException e) {
            log.error("Resource not found: {}", e.getMessage());
            throw new ResourceNotFoundException("Resource not found: " + e.getMessage());
        } catch (Exception e) {
            log.error("Unexpected error occurred: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred: " + e.getMessage());
        }
    }

    public HotelBookingResponseMngo fetchHotelUsingBookingCode(HotelResponseTbo hotelResponseTbo) {
        HotelBookingResponseMngo hotelBookingResponseMngo = null;
        String bookingCode = null;

        List<HotelResult> hotelResults = hotelResponseTbo.getHotelResult();
        for (HotelResult result : hotelResults) {
            List<Room> roomslist = result.getRooms();
            for (Room room : roomslist) {
                bookingCode = room.getBookingCode();
            }
        }

        if (bookingCode == null || bookingCode.isEmpty()) {
            throw new ResourceNotFoundException("Booking code is missing from hotel response.");
        }

        Optional<HotelBookingResponseMngo> result = mongoDbRepository.findByBookingCode(bookingCode);

        if (result.isPresent()) {
            hotelBookingResponseMngo = result.get();


        } else {
            log.info("Data not present in the MongoDB with provided Booking ID");
          //  throw new ResourceNotFoundException("Hotel booking data not found in MongoDB for booking code: " + bookingCode);

        }
        return hotelBookingResponseMngo;
    }

    public String maptoFtl(HotelResponseTbo hotelResponseTbo, HotelBookingResponseMngo hotelBookingResponseMngo) {
        if (hotelResponseTbo.getHotelResult() != null || hotelBookingResponseMngo != null) {
            try {
                Map<String, Object> mapped = new HashMap<>();
                mapped.put(HotelPrebookingConstants.RESULTS_TBO, hotelResponseTbo);
                mapped.put(HotelPrebookingConstants.RESULTS_MNGO, hotelBookingResponseMngo);


                Template template = freemarkerConfiguration.getTemplate("hotelResponse.ftl");
                return FreeMarkerTemplateUtils.processTemplateIntoString(template, mapped);
            } catch (Exception e) {
                throw new RuntimeException("Error processing FreeMarker template: " + e.getMessage(), e);
            }
        } else if (hotelResponseTbo.getHotelResult() == null) {
            throw new ResourceNotFoundException("Hotel response status is available, but no hotel results found.");
        }
        log.info("Not Mapping TO FTL");
        throw new ResourceNotFoundException("Hotel booking response mapping failed");
    }
}
