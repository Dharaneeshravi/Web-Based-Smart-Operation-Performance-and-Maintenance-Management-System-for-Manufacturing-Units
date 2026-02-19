package com.opmms.system.SmartOps.Maintenance.System.payload.downtime;

import com.opmms.system.SmartOps.Maintenance.System.model.Downtime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DowntimeData {

    private List<Downtime> downtime;
}
