package com.opmms.system.SmartOps.Maintenance.System.payload;

import com.opmms.system.SmartOps.Maintenance.System.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserData {

    private List<User> users;
}
