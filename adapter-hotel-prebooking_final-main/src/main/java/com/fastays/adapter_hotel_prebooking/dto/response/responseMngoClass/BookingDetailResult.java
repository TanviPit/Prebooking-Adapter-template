package com.fastays.adapter_hotel_prebooking.dto.response.responseMngoClass;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
public class BookingDetailResult {
    @JsonProperty("voucherStatus")
    private boolean voucherStatus;
    @JsonProperty("responseStatus")
    private int responseStatus;
    @JsonProperty("error")
    private ErrorInfo error;
    @JsonProperty("traceId")
    private String traceId;
    @JsonProperty(" status")
    private int status;
    @JsonProperty("hotelBookingStatus")
    private String hotelBookingStatus;
    @JsonProperty("confirmationNo")
    private String confirmationNo;
    @JsonProperty("bookingRefNo")
    private String bookingRefNo;
    @JsonProperty("bookingId")
    private int bookingId;
    @JsonProperty("isPriceChanged")
    private boolean isPriceChanged;
    @JsonProperty("isCancellationPolicyChanged")
    private boolean isCancellationPolicyChanged;
    @JsonProperty("hotelRoomsDetails")
    private List<HotelRoomDetails> hotelRoomsDetails;
    @JsonProperty("agentRemarks")
    private String agentRemarks;
    @JsonProperty("bookingHistory")
    private List<BookingHistory> bookingHistory;
    @JsonProperty(" bookingSource")
    private String bookingSource;
    @JsonProperty(" guestNationality")
    private String guestNationality;
    @JsonProperty("hotelPolicyDetail")
    private String hotelPolicyDetail;
    @JsonProperty("invoiceAmount")
    private double invoiceAmount;
    @JsonProperty("invoiceCreatedOn")
    private LocalDateTime invoiceCreatedOn;
    @JsonProperty("invoiceNo")
    private String invoiceNo;
    @JsonProperty("isCorporate")
    private boolean isCorporate;
    @JsonProperty("validationInfo")
    private Map<String, Object> validationInfo;
    @JsonProperty("hotelCode")
    private String hotelCode;
    @JsonProperty("hotelId")
    private int hotelId;
    @JsonProperty("hotelName")
    private String hotelName;
    @JsonProperty("tBOHotelCode")
    private String tBOHotelCode;
    @JsonProperty("starRating")
    private int starRating;
    @JsonProperty("addressLine1")
    private String addressLine1;
    @JsonProperty("addressLine2")
    private String addressLine2;
    @JsonProperty("countryCode")
    private String countryCode;
    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("longitude")
    private String longitude;
    @JsonProperty(" city")
    private String city;
    @JsonProperty("cityId")
    private int cityId;
    @JsonProperty("checkInDate")
    private LocalDateTime checkInDate;
    @JsonProperty("initialCheckInDate")
    private LocalDateTime initialCheckInDate;
    @JsonProperty("checkOutDate")
    private LocalDateTime checkOutDate;
    @JsonProperty("initialCheckOutDate")
    private LocalDateTime initialCheckOutDate;
    @JsonProperty("lastCancellationDate")
    private LocalDateTime lastCancellationDate;
    @JsonProperty("lastVoucherDate")
    private LocalDateTime lastVoucherDate;
    @JsonProperty("noOfRooms")
    private int noOfRooms;
    @JsonProperty("bookingDate")
    private LocalDateTime bookingDate;
    @JsonProperty("specialRequest")
    private String specialRequest;
    @JsonProperty("isDomestic")
    private boolean isDomestic;
    @JsonProperty("bookingAllowedForRoamer")
    private boolean bookingAllowedForRoamer;
}
