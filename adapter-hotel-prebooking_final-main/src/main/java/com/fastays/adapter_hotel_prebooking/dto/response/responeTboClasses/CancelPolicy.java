package com.fastays.adapter_hotel_prebooking.dto.response.responeTboClasses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CancelPolicy {
    @JsonProperty("Index")
    private String Index;

    @JsonProperty("FromDate")
    private String FromDate;

    @JsonProperty("ChargeType")
    private String ChargeType;

    @JsonProperty("CancellationCharge")
    private double CancellationCharge;
}

