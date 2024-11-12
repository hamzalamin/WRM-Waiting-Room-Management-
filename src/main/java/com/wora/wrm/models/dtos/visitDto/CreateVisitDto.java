package com.wora.wrm.models.dtos.visitDto;

import com.wora.wrm.models.enumes.VisitorStatus;
import jakarta.validation.constraints.NotNull;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record CreateVisitDto(
        @NotNull LocalDateTime arrivalTime,
        LocalTime startTime,
        LocalTime endTime,
        @NotNull VisitorStatus visitorStatus,
        @NotNull Byte priority,
        Duration estimatedProcessingTime
) {
}
