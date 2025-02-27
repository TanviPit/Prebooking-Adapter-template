package com.fastays.adapter_hotel_prebooking.dto.response.responseMngoClass;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookDetailsResponse {
    @JsonProperty("bookingDetailResult")
    private BookingDetailResult bookingDetailResult;
}
