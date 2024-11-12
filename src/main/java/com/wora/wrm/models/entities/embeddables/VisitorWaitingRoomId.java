package com.wora.wrm.models.entities.embeddables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Positive;

@Embeddable
public record VisitorWaitingRoomId(
        @Column(name = "visitor_id")
        @Positive
        Long visitorId,

        @Column(name = "waiting_room_id")
        @Positive
        Long waitingRoomId
) {}
