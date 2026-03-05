package com.opmms.system.SmartOps.Maintenance.System.controller;

import com.opmms.system.SmartOps.Maintenance.System.payload.maintenance.ApiRequestMaintenance;
import com.opmms.system.SmartOps.Maintenance.System.payload.maintenance.ApiResponseMaintenance;
import com.opmms.system.SmartOps.Maintenance.System.service.maintenance.MaintenanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/maintenance")
@RequiredArgsConstructor
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    @GetMapping("/getAllMaintenance")
    public ResponseEntity<ApiResponseMaintenance>  getAllMaintenance()
    {
        return ResponseEntity.ok().body(maintenanceService.getAllMaintenance());
    }

    @PostMapping("/createMaintenance")
    public ResponseEntity<ApiResponseMaintenance> createMaintenance(@RequestParam Long machineId,@RequestParam Long userId,@RequestBody ApiRequestMaintenance apiRequestMaintenance)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(maintenanceService.createMaintenance(machineId,userId,apiRequestMaintenance));
    }

    @GetMapping("/getMaintenanceById/{maintenanceId}")
    public ResponseEntity<ApiResponseMaintenance>   getMaintenanceById(@PathVariable Long maintenanceId)
    {
        return ResponseEntity.ok(maintenanceService.getMaintenanceById(maintenanceId));
    }

    @PutMapping("/updateMaintenanceById/{maintenanceId}")
    public ResponseEntity<ApiResponseMaintenance> updateMaintenanceById(@PathVariable Long maintenanceId,@RequestBody ApiRequestMaintenance apiRequestMaintenance)
    {
        return ResponseEntity.ok(maintenanceService.updateMaintenanceById(maintenanceId,apiRequestMaintenance));
    }

    @DeleteMapping("/deleteMaintenanceById/{maintenanceId}")
    public ResponseEntity<ApiResponseMaintenance> deleteMaintenanceById(@PathVariable Long maintenanceId)
    {
        return ResponseEntity.ok(maintenanceService.deleteMaintenanceById(maintenanceId));
    }
}
