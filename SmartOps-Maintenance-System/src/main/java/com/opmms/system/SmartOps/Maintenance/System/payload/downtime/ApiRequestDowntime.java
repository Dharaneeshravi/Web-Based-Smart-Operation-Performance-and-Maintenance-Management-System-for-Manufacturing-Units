package com.opmms.system.SmartOps.Maintenance.System.payload.downtime;

import com.opmms.system.SmartOps.Maintenance.System.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiRequestDowntime {


    private Date date;
    private LocalTime start_time;
    private LocalTime end_time;
    private float duration;
    private String reason;
    private Status status;
    private String remarks;
}
