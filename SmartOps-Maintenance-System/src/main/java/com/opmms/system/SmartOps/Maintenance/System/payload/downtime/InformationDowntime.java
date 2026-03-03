package com.opmms.system.SmartOps.Maintenance.System.payload.downtime;

import com.opmms.system.SmartOps.Maintenance.System.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationDowntime {

    private Long downtimeId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private float duration;
    private String reason;
    private Status status;
    private String remarks;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
