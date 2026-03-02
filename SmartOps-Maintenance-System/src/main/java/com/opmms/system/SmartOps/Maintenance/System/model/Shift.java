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

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ShiftId;
    private ShiftName shiftName;
    private LocalTime startTime;
    private LocalTime endTime;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createdAt;
    @UpdateTimestamp
    private LocalDate updatedAt;
}
