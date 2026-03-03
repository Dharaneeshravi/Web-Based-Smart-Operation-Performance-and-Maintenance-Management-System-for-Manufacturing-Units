package com.opmms.system.SmartOps.Maintenance.System.payload.production;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationProduction {

    private Long productionId;
    private LocalDate productionDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Double totalHours;
    private Integer outputQty;
    private Integer defectiveQty;
    private String remarks;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Long machineId;
    private Long userId;
    private Long shiftId;
}
