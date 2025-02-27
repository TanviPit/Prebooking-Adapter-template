package com.fastays.adapter_hotel_prebooking.dto.response.responeTboClasses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Room {
    @JsonProperty("Name")
    private List<String> Name;

    @JsonProperty("BookingCode")
    private String BookingCode;

    @JsonProperty("Inclusion")
    private String Inclusion;

    @JsonProperty("DayRates")
    private List<List<DayRate>> DayRates;

    @JsonProperty("TotalFare")
    private double TotalFare;

    @JsonProperty("TotalTax")
    private double TotalTax;

    @JsonProperty("RoomPromotion")
    private List<String> RoomPromotion;

    @JsonProperty("CancelPolicies")
    private List<CancelPolicy> CancelPolicies;

    @JsonProperty("MealType")
    private String MealType;

    @JsonProperty("isRefundable")
    private boolean isRefundable;

    @JsonProperty("supplements")
    private List<List<Supplement>> supplements;

    @JsonProperty("withTransfers")
    private boolean withTransfers;

    @JsonProperty("amenities")
    private List<String> amenities;

    @JsonProperty("lastCancellationDeadline")
    private String lastCancellationDeadline;

    @JsonProperty("priceBreakUp")
    private List<PriceBreakUp> priceBreakUps;
}

