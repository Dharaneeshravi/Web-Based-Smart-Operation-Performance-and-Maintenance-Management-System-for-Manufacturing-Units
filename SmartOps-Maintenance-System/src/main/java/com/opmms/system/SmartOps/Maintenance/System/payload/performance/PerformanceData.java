package com.opmms.system.SmartOps.Maintenance.System.payload.performance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerformanceData {

    private List<InformationPerformance> informationPerformances;
}
