package com.wora.wrm.models.dtos.WaitingRoomDtos;

import com.wora.wrm.models.enumes.AlgorithmType;
import com.wora.wrm.models.enumes.WorkMode;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record UpdateWaitingRoomDto(
        @NotNull @Positive Integer date,
        AlgorithmType algorithmType,
        @NotNull Integer capacity,
        @NotNull WorkMode workMode
) {
}
