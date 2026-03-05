package com.opmms.system.SmartOps.Maintenance.System.controller;

import com.opmms.system.SmartOps.Maintenance.System.payload.performance.ApiRequestPerformance;
import com.opmms.system.SmartOps.Maintenance.System.payload.performance.ApiResponsePerformance;
import com.opmms.system.SmartOps.Maintenance.System.service.performance.PerformanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/performance")
@RequiredArgsConstructor
public class PerformanceController {


    private final PerformanceService performanceService;


    @GetMapping("/getAllPerformance")
    public ResponseEntity<ApiResponsePerformance> getAllPerformance()
    {
        return ResponseEntity.ok(performanceService.getAllPerformance());
    }

    @PostMapping("/createPerformance")
    public ResponseEntity<ApiResponsePerformance> createPerformance(@RequestParam Long machineId,@RequestBody ApiRequestPerformance apiRequestPerformance)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(performanceService.createPerformance(machineId,apiRequestPerformance));
    }

    @GetMapping("/getPerformanceById/{performanceId}")
    public ResponseEntity<ApiResponsePerformance> getPerformanceById(@PathVariable Long performanceId)
    {
        return ResponseEntity.ok(performanceService.getPerformanceById(performanceId));
    }

    @PutMapping("/updatePerformanceById/{performanceId}")
    public ResponseEntity<ApiResponsePerformance> updatePerformanceById(@PathVariable Long performanceId,@RequestBody ApiRequestPerformance apiRequestPerformance)
    {
        return ResponseEntity.ok(performanceService.updatePerformanceById(performanceId,apiRequestPerformance));
    }

    @DeleteMapping("/deletePerformanceById/{performanceId}")
    public ResponseEntity<ApiResponsePerformance> deletePerformanceById(@PathVariable Long performanceId)
    {
        return ResponseEntity.ok(performanceService.deletePerformanceById(performanceId));
    }
}
