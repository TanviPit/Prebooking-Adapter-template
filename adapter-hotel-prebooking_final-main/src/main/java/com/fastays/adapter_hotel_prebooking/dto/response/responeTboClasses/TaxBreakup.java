package com.fastays.adapter_hotel_prebooking.dto.response.responeTboClasses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaxBreakup {
    @JsonProperty("taxType")
    private String taxType;

    @JsonProperty("taxableAmount")
    private double taxableAmount;

    @JsonProperty("taxPercentage")
    private double taxPercentage;

    @JsonProperty("taxAmount")
    private double taxAmount;
}

