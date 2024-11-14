package com.wora.wrm.models.dtos.visitorDtos;

import jakarta.validation.constraints.NotBlank;

public record UpdateVisitorDto(
        @NotBlank String fName,
        @NotBlank String lName
) {
}
