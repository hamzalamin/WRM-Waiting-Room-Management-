package com.wora.wrm.models.dtos.visitorDtos;

import jakarta.validation.constraints.NotBlank;

public record CreateVisitorDto(
        @NotBlank String firstName,
        @NotBlank String lastName
) {
}