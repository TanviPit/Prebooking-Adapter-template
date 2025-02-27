package com.fastays.adapter_hotel_prebooking.dto.response.responeTboClasses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HotelResult {
    @JsonProperty("HotelCode")
    private String HotelCode;

    @JsonProperty("Currency")
    private String Currency;

    @JsonProperty("Rooms")
    private List<Room> Rooms;

    @JsonProperty("RateConditions")
    private List<String> RateConditions;
}

