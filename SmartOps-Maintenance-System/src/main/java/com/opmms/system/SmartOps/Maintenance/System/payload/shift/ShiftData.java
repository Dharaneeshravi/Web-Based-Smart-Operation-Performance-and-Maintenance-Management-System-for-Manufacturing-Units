package com.opmms.system.SmartOps.Maintenance.System.payload.shift;

import com.opmms.system.SmartOps.Maintenance.System.model.Shift;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiftData {

    private List<Shift> shifts;
}
