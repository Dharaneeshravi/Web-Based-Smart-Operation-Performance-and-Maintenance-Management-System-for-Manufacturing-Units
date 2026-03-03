package com.opmms.system.SmartOps.Maintenance.System.payload.downtime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DowntimeData {

    private List<InformationDowntime> informationDowntimes;
}
