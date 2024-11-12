package com.wora.wrm.models.dtos.visitDto;

import com.wora.wrm.models.enumes.VisitorStatus;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public record UpdateVisitorStatusDto(
        LocalTime startTime,
        LocalTime endTime,
        @NotNull VisitorStatus visitorStatus
){
}
