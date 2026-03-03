package com.opmms.system.SmartOps.Maintenance.System.payload.shift;

import com.opmms.system.SmartOps.Maintenance.System.model.ShiftName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationShift {

    private Long ShiftId;
    private ShiftName shiftName;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
