package com.wora.wrm.models.dtos.WaitingRoomDtos;

import com.wora.wrm.models.enumes.AlgorithmType;
import com.wora.wrm.models.enumes.WorkMode;

public record WaitingRoomDto(
        Long id,
        Integer date,
        AlgorithmType algorithmType,
        Integer capacity,
        WorkMode workMode
) {
}
