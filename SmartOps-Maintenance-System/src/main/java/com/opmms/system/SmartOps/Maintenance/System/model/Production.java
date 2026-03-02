package com.opmms.system.SmartOps.Maintenance.System.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Production {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productionId;
    private LocalDate productionDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Double totalHours;
    private Integer outputQty;
    private Integer defectiveQty;
    private String remarks;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createdAt;
    @UpdateTimestamp
    private LocalDate updatedAt;
}
