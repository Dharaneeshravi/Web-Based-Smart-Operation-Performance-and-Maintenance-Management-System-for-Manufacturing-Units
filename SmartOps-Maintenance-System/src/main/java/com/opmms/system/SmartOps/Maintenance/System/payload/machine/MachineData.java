package com.opmms.system.SmartOps.Maintenance.System.payload.machine;

import com.opmms.system.SmartOps.Maintenance.System.model.Machine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MachineData {

    private List<Machine>  machines;
}
