package com.wora.wrm.models.dtos.visitDto;

import java.time.Duration;

public record WaitingTimeDto(
        Long totalVisits,
        Duration totalWaitTime
) {
}
