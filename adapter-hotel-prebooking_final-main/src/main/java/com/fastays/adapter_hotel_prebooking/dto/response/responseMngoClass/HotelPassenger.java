package com.fastays.adapter_hotel_prebooking.dto.response.responseMngoClass;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HotelPassenger {
    @JsonProperty("title")
    private String title;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("middleName")
    private String middleName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("paxType")
    private int paxType;
    @JsonProperty("leadPassenger")
    private boolean leadPassenger;
    @JsonProperty("age")
    private int age;
    @JsonProperty("phoneno")
    private String phoneno;
    @JsonProperty("paxId")
    private int paxId;
}
