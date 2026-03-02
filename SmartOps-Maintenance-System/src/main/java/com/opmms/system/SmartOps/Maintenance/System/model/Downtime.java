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
public class Downtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long downtimeId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private float duration;
    private String reason;
    private Status status;
    private String remarks;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createdAt;
    @UpdateTimestamp
    private LocalDate updatedAt;
}
