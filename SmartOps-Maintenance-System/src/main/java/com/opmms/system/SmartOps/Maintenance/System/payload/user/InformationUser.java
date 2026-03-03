package com.opmms.system.SmartOps.Maintenance.System.payload.user;

import com.opmms.system.SmartOps.Maintenance.System.model.AppRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationUser {

    private Long userId;
    private String username;
    private String password;
    private Set<AppRole> role;
    private String email;
    private String contactNumber;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
