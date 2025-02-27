package com.fastays.adapter_hotel_prebooking.dto.response.responeTboClasses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ValidationInfo {
    @JsonProperty("panMandatory")
    private boolean panMandatory;
    @JsonProperty("passportMandatory")
    private boolean passportMandatory;

    @JsonProperty("corporateBookingAllowed")
    private boolean corporateBookingAllowed;

    @JsonProperty("panCountRequired")
    private int panCountRequired;

    @JsonProperty("samePaxNameAllowed")
    private boolean samePaxNameAllowed;

    @JsonProperty("spaceAllowed")
    private boolean spaceAllowed;

    @JsonProperty("specialCharAllowed")
    private boolean specialCharAllowed;

    @JsonProperty("paxNameMinLength")
    private int paxNameMinLength;

    @JsonProperty("paxNameMaxLength")
    private int paxNameMaxLength;

    @JsonProperty("charLimit")
    private boolean charLimit;

    @JsonProperty("packageFare")
    private boolean packageFare;

    @JsonProperty("packageDetailsMandatory")
    private boolean packageDetailsMandatory;

    @JsonProperty("departureDetailsMandatory")
    private boolean departureDetailsMandatory;

    @JsonProperty("gstAllowed")
    private boolean gstAllowed;
}

