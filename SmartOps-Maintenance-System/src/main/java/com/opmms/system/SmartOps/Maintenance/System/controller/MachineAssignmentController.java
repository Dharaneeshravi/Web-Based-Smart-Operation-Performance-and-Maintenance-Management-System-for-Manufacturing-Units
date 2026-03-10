package com.opmms.system.SmartOps.Maintenance.System.controller;

import com.opmms.system.SmartOps.Maintenance.System.payload.machineassignment.ApiResponseMachineAssignment;
import com.opmms.system.SmartOps.Maintenance.System.service.machineassignment.MachineAssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/machineAssignment")
@RequiredArgsConstructor
public class MachineAssignmentController {
    private final MachineAssignmentService machineAssignmentService;

    @GetMapping("/getAllMachineAssignment")
    public ResponseEntity<ApiResponseMachineAssignment> getAllMachineAssignment()
    {
        return ResponseEntity.ok(machineAssignmentService.getAllMachineAssignment());
    }

    @PostMapping("/createMachineAssignment")
    public ResponseEntity<ApiResponseMachineAssignment> createMachineAssignment(@RequestParam Long machineId,@RequestParam Long userId)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(machineAssignmentService.createMachineAssignment(machineId,userId));
    }

    @GetMapping("/getMachineAssignment/{MachineAssignmentId}")
    public ResponseEntity<ApiResponseMachineAssignment> getMachineAssignment(@PathVariable Long machineAssignmentId)
    {
        return ResponseEntity.ok(machineAssignmentService.getMachineAssignment(machineAssignmentId));
    }
}
