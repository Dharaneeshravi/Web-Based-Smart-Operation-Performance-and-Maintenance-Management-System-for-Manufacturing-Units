package com.opmms.system.SmartOps.Maintenance.System.payload;

import com.opmms.system.SmartOps.Maintenance.System.model.AppRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiRequestUser {

    private String userName;
    private String password;
    private Set<AppRole> role;
    private String email;
    private  String contactNumber;
}
