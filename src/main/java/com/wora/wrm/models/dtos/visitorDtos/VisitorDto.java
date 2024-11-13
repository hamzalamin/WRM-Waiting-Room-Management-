package com.wora.wrm.models.dtos.visitorDtos;

import com.wora.wrm.models.dtos.visitDto.EmbeddedVisitDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record VisitorDto(
        @Positive Long id,
        @NotBlank String fName,
        @NotBlank String lName,
        List<EmbeddedVisitDto> visitDtoList
) {
}
