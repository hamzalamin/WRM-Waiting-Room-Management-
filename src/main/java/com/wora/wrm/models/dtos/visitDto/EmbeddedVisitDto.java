package com.wora.wrm.models.dtos.visitDto;

import com.wora.wrm.models.dtos.embeddebles.VisitorWaitingRoomIdDto;
import com.wora.wrm.models.enumes.VisitorStatus;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record EmbeddedVisitDto(
        VisitorWaitingRoomIdDto id,
        LocalDateTime arrivalTime,
        LocalTime startTime,
        LocalTime endTime,
        VisitorStatus visitorStatus,
        Byte priority,
        Duration estimatedProcessingTime
) {
}
