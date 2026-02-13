package com.opmms.system.SmartOps.Maintenance.System.payload.production;

import com.opmms.system.SmartOps.Maintenance.System.model.Production;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductionData {

    private List<Production> productionList;
}
