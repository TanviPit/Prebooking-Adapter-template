package com.fastays.adapter_hotel_prebooking.dto.response.responseMngoClass;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BookingHistory {
    @JsonProperty("bookingId")
    private int bookingId;
    @JsonProperty("createdBy")
    private int createdBy;
    @JsonProperty("createdByName")
    private String createdByName;
    @JsonProperty("createdOn")
    private LocalDateTime createdOn;
    @JsonProperty("eventCategory")
    private int eventCategory;
    @JsonProperty("lastModifiedBy")
    private int lastModifiedBy;
    @JsonProperty("lastModifiedByName")
    private String lastModifiedByName;
    @JsonProperty("lastModifiedOn")
    private LocalDateTime lastModifiedOn;
    @JsonProperty("remarks")
    private String remarks;
}
