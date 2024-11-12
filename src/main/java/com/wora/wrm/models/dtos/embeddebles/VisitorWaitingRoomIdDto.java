package com.wora.wrm.models.dtos.embeddebles;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record VisitorWaitingRoomIdDto(
        @Positive @NotNull Long visitorId,
        @Positive @NotNull Long waitingRoomId
) {
}
