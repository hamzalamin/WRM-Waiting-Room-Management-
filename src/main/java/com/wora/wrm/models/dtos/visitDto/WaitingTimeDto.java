package com.wora.wrm.models.dtos.visitDto;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record WaitingTimeDto(
        LocalDateTime arrivalTime,
        LocalTime startTime,
        Integer numberOfPeopleWaiting,
        String estimatedWaitingTime
) {
}
