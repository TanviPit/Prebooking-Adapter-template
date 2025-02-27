package com.fastays.adapter_hotel_prebooking.dto.response.responseMngoClass;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PriceSummary {
    @JsonProperty("netAmount")
    private double netAmount;
    @JsonProperty("taxesAndOtherCharges")
    private double taxesAndOtherCharges;
    @JsonProperty("otalAmountBeforeDiscount")
    private double totalAmountBeforeDiscount;
    @JsonProperty("isOfferApplied")
    private boolean isOfferApplied;
    @JsonProperty("discountInPercentage")
    private double discountInPercentage;
    @JsonProperty("discountedPrice")
    private double discountedPrice;
    @JsonProperty("netAmountAfterDiscount")
    private double netAmountAfterDiscount;
    @JsonProperty("totalAmountAfterDiscount")
    private double totalAmountAfterDiscount;
}

