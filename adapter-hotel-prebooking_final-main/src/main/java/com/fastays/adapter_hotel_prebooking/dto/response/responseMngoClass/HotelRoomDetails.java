package com.fastays.adapter_hotel_prebooking.dto.response.responseMngoClass;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class HotelRoomDetails {
    @JsonProperty("hotelPassenger")
    private List<HotelPassenger> hotelPassenger;
}
