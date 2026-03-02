package com.opmms.system.SmartOps.Maintenance.System.payload.performance;

import com.opmms.system.SmartOps.Maintenance.System.model.Performance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerformanceData {

    private List<Performance> performanceList;
}
