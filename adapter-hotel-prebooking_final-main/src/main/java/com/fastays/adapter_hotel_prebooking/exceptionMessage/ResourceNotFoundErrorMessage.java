package com.fastays.adapter_hotel_prebooking.exceptionMessage;

import lombok.*;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResourceNotFoundErrorMessage {
    private int status;
    private String message;
    private LocalDateTime timestamp;
}
