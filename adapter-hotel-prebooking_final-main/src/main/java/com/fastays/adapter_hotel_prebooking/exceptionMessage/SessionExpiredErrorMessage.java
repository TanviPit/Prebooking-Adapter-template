package com.fastays.adapter_hotel_prebooking.exceptionMessage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SessionExpiredErrorMessage {
    private int status;
    private String message;
    private LocalDateTime timestamp;
}
