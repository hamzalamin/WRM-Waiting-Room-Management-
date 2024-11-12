package com.wora.wrm.models.entities;

import com.wora.wrm.models.enumes.AlgorithmType;
import com.wora.wrm.models.enumes.WorkMode;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "waiting-rooms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WaitingRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Positive
    @Column(name = "date", nullable = false)
    private Integer date;

    @Column(name = "algorithm_type", nullable = true)
    @Enumerated(EnumType.STRING)
    private AlgorithmType algorithmType;

    @Positive
    @Column(name = "capacity", nullable = true)
    private Integer Capacity;

    @Column(name = "workMode", nullable = true)
    @Enumerated(EnumType.STRING)
    private WorkMode workMode;

    @OneToMany(mappedBy = "waitingRoom", cascade = CascadeType.ALL)
    private List<Visit> visits;
}
