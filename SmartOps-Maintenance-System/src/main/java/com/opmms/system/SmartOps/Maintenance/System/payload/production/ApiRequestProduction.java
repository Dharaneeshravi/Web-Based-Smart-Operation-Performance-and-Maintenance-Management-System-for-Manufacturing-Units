package com.opmms.system.SmartOps.Maintenance.System.payload.production;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiRequestProduction {

    private Date productionDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Double totalHours;
    private Integer outputQty;
    private Integer defectiveQty;
    private String remarks;
}
