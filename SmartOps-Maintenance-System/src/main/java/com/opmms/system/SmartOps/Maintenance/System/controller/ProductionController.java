package com.opmms.system.SmartOps.Maintenance.System.controller;

import com.opmms.system.SmartOps.Maintenance.System.payload.production.ApiRequestProduction;
import com.opmms.system.SmartOps.Maintenance.System.payload.production.ApiResponseProduction;
import com.opmms.system.SmartOps.Maintenance.System.service.production.ProductionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/production")
@RequiredArgsConstructor
public class ProductionController {

    private final ProductionService productionService;

    @GetMapping("/getAllProduction")
    public ResponseEntity<ApiResponseProduction> getAllProduction()
    {
        return ResponseEntity.ok(productionService.getAllProduction());
    }

    @PostMapping("/createProduction")
    public ResponseEntity<ApiResponseProduction> createProduction(@RequestParam Long machineId,@RequestBody ApiRequestProduction apiRequestProduction)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(productionService.createProduction(machineId,apiRequestProduction));
    }

    @GetMapping("/getProductionById/{productionId}")
    public ResponseEntity<ApiResponseProduction> getProductionById(@PathVariable Long productionId)
    {
        return ResponseEntity.ok(productionService.getProductionById(productionId));
    }

    @PutMapping("/updateProductionById/{productionId}")
    public ResponseEntity<ApiResponseProduction> updateProductionById(@PathVariable Long productionId,@RequestBody ApiRequestProduction apiRequestProduction)
    {
        return ResponseEntity.ok(productionService.updateProductionById(productionId,apiRequestProduction));
    }

    @DeleteMapping("/deleteProductionById/{productionId}")
    public ResponseEntity<ApiResponseProduction> deleteProductionById(@PathVariable Long productionId)
    {
        return ResponseEntity.ok(productionService.deleteProductionById(productionId));
    }
}
