package com.opmms.system.SmartOps.Maintenance.System.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long performanceId;
    private LocalDate date;
    private Double workingHours;
    private Double downtimeHours;
    private Integer productionQty;
    private Double availability;
    private Double performance;
    private Double quality;
    private Double oee;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createdAt;
    @UpdateTimestamp
    private LocalDate updatedAt;

    @Column(name = "machine_number")
    private Long machineId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "machine_id")
    private Machine machine;
}
