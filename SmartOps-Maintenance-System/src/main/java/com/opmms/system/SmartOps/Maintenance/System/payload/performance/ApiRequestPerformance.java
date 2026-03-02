package com.opmms.system.SmartOps.Maintenance.System.payload.performance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiRequestPerformance {

    private Date date;
    private Double workingHours;
    private Double downtimeHours;
    private Integer productionQty;
    private Double availability;
    private Double performance;
    private Double quality;
    private Double oee;
}
