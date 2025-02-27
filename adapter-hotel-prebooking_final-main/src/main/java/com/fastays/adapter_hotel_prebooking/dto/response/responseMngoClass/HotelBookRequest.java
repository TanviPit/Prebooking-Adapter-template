package com.fastays.adapter_hotel_prebooking.dto.response.responseMngoClass;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class HotelBookRequest {
    @JsonProperty("bookingCode")
    private String bookingCode;
    @JsonProperty("isVoucherBooking")
    private boolean isVoucherBooking;
    @JsonProperty("guestNationality")
    private String guestNationality;
    @JsonProperty(" endUserIp")
    private String endUserIp;
    @JsonProperty("requestedBookingMode")
    private int requestedBookingMode;
    @JsonProperty("netAmount")
    private double netAmount;
    @JsonProperty("priceSummary")
    private PriceSummary priceSummary;
    @JsonProperty("hotelRoomsDetails")
    private List<HotelRoomDetails> hotelRoomsDetails;
    @JsonProperty("isRefundable")
    private boolean isRefundable;
}
