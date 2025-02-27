package com.fastays.adapter_hotel_prebooking.dto.response.responseMngoClass;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "hotel_booking")
public class HotelBookingResponseMngo {
    @Id
    @JsonProperty("id")
    private String id;
    @JsonProperty("bookingStatus")
    private String bookingStatus;
    @JsonProperty("razorPayOrderId")
    private String razorPayOrderId;
    @JsonProperty("razorPayOrderStatus")
    private String razorPayOrderStatus;
    @JsonProperty("razorPayOrderMessage")
    private String razorPayOrderMessage;
    @JsonProperty("userId")
    private String userId;
    @JsonProperty("bookingCode")
    private String bookingCode;
    @JsonProperty("isVoucherBooking")
    private boolean isVoucherBooking;
    @JsonProperty("requestedBookingMode")
    private int requestedBookingMode;
    @JsonProperty("netAmount")
    private double netAmount;
    @JsonProperty("createdDate")
    private LocalDateTime createdDate;
    @JsonProperty("updatedDate")
    private LocalDateTime updatedDate;
    @JsonProperty("hotelBookRequest")
    private HotelBookRequest hotelBookRequest;
    @JsonProperty("bookResult")
    private BookResult bookResult;
    @JsonProperty("bookDetailsResponse")
    private BookDetailsResponse bookDetailsResponse;
    @JsonProperty("isRefundable")
    private boolean isRefundable;
}
