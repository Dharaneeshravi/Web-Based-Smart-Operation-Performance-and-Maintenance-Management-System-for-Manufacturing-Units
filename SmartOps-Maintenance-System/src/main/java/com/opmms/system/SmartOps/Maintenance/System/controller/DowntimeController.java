package com.opmms.system.SmartOps.Maintenance.System.controller;

import com.opmms.system.SmartOps.Maintenance.System.payload.downtime.ApiRequestDowntime;
import com.opmms.system.SmartOps.Maintenance.System.payload.downtime.ApiResponseDowntime;
import com.opmms.system.SmartOps.Maintenance.System.service.downtime.DowntimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/downtime")
@RequiredArgsConstructor
public class DowntimeController {


    private final DowntimeService downtimeService;

    @GetMapping("/getAllDowntime")
    public ResponseEntity<ApiResponseDowntime> getAllDowntime()
    {
        return ResponseEntity.ok(downtimeService.getAllDowntime());
    }

    @PostMapping("/createDowntime")
    public ResponseEntity<ApiResponseDowntime> createDowntime(@RequestBody ApiRequestDowntime apiRequestDowntime)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(downtimeService.createDowntime(apiRequestDowntime));
    }

    @GetMapping("/getDowntimeById/{downtimeId}")
    public ResponseEntity<ApiResponseDowntime> getDowntimeById(@PathVariable Long downtimeId)
    {
        return ResponseEntity.ok(downtimeService.getDowntimeById(downtimeId));
    }

    @PutMapping("updateDowntimeById/{downtimeId}")
    public ResponseEntity<ApiResponseDowntime> updateDowntimeById(@PathVariable Long downtimeId,@RequestBody ApiRequestDowntime apiRequestDowntime)
    {
        return ResponseEntity.ok(downtimeService.updateDowntimeById(downtimeId,apiRequestDowntime));
    }

    @DeleteMapping("/deleteDowntimeById/{downtimeId}")
    public ResponseEntity<ApiResponseDowntime> deleteDowntimeById(@PathVariable Long downtimeId)
    {
        return ResponseEntity.ok(downtimeService.deleteDowntimeById(downtimeId));
    }
}
