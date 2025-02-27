package com.fastays.adapter_hotel_prebooking.dto.response.responseMngoClass;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookResult {
    @JsonProperty("voucherStatus")
    private boolean voucherStatus;
    @JsonProperty("responseStatus")
    private int responseStatus;
    @JsonProperty("error")
    private ErrorInfo error;
    @JsonProperty("traceId")
    private String traceId;
    @JsonProperty(" status")
    private int status;
    @JsonProperty("hotelBookingStatus")
    private String hotelBookingStatus;
    @JsonProperty(" invoiceNumber")
    private String invoiceNumber;
    @JsonProperty(" confirmationNo")
    private String confirmationNo;
    @JsonProperty("bookingRefNo")
    private String bookingRefNo;
    @JsonProperty("bookingId")
    private String bookingId;
    @JsonProperty("isPriceChanged")
    private boolean isPriceChanged;
    @JsonProperty("isCancellationPolicyChanged")
    private boolean isCancellationPolicyChanged;
    @JsonProperty("fastaysId")
    private String fastaysId;
}
