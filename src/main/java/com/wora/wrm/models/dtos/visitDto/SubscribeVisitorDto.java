package com.wora.wrm.models.dtos.visitDto;

import jakarta.validation.constraints.NotNull;

import java.time.Duration;
import java.time.LocalDateTime;

public record SubscribeVisitorDto(
        @NotNull Long visitorId,
        @NotNull Long waitingRoomId,
        @NotNull LocalDateTime arrivalTime,
        Byte priority,
        Duration estimatedProcessingTime
) {
}
