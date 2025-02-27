package com.fastays.adapter_hotel_prebooking.dto.response.responseMngoClass;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ErrorInfo {
    @JsonProperty("errorCode")
    private int errorCode;
    @JsonProperty("errorMessage")
    private String errorMessage;
}
