package com.wora.wrm.models.entities.embeddables;

import jakarta.validation.constraints.Positive;

public record VisitorWaitingRoomId(
        @Positive Long visitorId,
        @Positive Long waitingRoomId
) {
}
