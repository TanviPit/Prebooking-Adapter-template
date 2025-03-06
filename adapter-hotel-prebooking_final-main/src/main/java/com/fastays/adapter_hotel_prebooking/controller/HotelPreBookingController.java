package com.fastays.adapter_hotel_prebooking.controller;

import com.fastays.adapter_hotel_prebooking.dto.request.HotelRequest;
import com.fastays.adapter_hotel_prebooking.service.interfaces.HotelPrebookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hotel-prebooking")
@RequiredArgsConstructor
public class HotelPreBookingController {
    private final HotelPrebookingService hotelPreBookingService;

    @PostMapping("/book")
    public ResponseEntity<?> bookHotel(@RequestBody HotelRequest hotelRequest) {
        return ResponseEntity.ok(hotelPreBookingService.bookHotel(hotelRequest).getBody());
    }
}
