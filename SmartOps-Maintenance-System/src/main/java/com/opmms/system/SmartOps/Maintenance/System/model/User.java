package com.opmms.system.SmartOps.Maintenance.System.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String password;
    private Set<AppRole> role;
    private String email;
    private String contactNumber;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createdAt;
    @UpdateTimestamp
    private LocalDate updatedAt;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private Set<Production>  production;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private Set<Downtime> downtime;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private Set<Maintenance> maintenance;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private Set<MachineAssignment> machineAssignments;

}
