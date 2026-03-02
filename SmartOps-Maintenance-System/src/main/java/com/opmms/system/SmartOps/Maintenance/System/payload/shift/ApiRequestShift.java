package com.opmms.system.SmartOps.Maintenance.System.payload.shift;

import com.opmms.system.SmartOps.Maintenance.System.model.ShiftName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiRequestShift {

    private ShiftName shiftName;
    private LocalTime startTime;
    private LocalTime endTime;
}
