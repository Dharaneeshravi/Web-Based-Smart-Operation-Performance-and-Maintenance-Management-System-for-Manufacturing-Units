package com.opmms.system.SmartOps.Maintenance.System.payload.performance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationPerformance {

    private Long performanceId;
    private LocalDate date;
    private Double workingHours;
    private Double downtimeHours;
    private Integer productionQty;
    private Double availability;
    private Double performance;
    private Double quality;
    private Double oee;
    private Long machineId;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
