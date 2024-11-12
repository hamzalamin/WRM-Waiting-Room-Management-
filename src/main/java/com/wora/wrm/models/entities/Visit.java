package com.wora.wrm.models.entities;

import com.wora.wrm.models.entities.embeddables.VisitorWaitingRoomId;
import com.wora.wrm.models.enumes.VisitorStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "visits")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Visit {

    @EmbeddedId
    private VisitorWaitingRoomId id;

    @NotNull
    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    @Column(name = "start_time", nullable = true)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = true)
    private LocalTime endTime;

    @NotNull
    @Column(name = "visitor_status")
    private VisitorStatus visitorStatus;

    @Column(name = "priority")
    @NotNull
    private Byte priority;

    @Column(name = "estimated_proccessing_time")
    private Duration estimatedProcessingTime;

    @ManyToOne
    private Visitor visitor;

    @ManyToOne
    private WaitingRoom waitingRoom;

}
