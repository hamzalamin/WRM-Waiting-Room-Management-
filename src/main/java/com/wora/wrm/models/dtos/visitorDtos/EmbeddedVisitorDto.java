package com.wora.wrm.models.dtos.visitorDtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record EmbeddedVisitorDto(
        @Positive Long id,
        @NotBlank String firstName,
        @NotBlank String lastName
) {
}
