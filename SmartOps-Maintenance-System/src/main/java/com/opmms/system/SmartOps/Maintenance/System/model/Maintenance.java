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
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maintenanceId;
    private MaintenanceType  maintenanceType;
    private LocalDate scheduledDate;
    private LocalDate performedDate;
    private String description;
    private Status status;
    private Double cost;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createdAt;
    @UpdateTimestamp
    private LocalDate updatedAt;
    @Column(name = "machine_number")
    private Long machineId;
    @Column(name = "user_number")
    private Long userId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "machine_id")
    private Machine machine;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;

}
