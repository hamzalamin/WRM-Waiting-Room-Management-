package com.wora.wrm.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "visitors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Visitor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(name = "f_name", nullable = false)
    private String fName;

    @NotBlank
    @Column(name = "l_name", nullable = false)
    private String lName;

    @OneToMany(mappedBy = "visitor", cascade = CascadeType.ALL)
    private List<Visit> visits;
}
