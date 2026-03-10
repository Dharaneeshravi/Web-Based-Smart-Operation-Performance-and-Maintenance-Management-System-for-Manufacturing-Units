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

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MachineAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long MachineAssignmentId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "machine_id")
    private Machine machine;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "user_number")
    private Long userId;
    @Column(name = "machine_number")
    private Long machineId;


    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createdAt;
    @UpdateTimestamp
    private LocalDate updatedAt;
}
