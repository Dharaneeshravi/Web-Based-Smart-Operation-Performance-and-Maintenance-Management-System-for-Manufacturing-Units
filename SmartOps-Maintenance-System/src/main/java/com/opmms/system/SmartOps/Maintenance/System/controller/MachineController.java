package com.opmms.system.SmartOps.Maintenance.System.controller;

import com.opmms.system.SmartOps.Maintenance.System.payload.machine.ApiRequestMachine;
import com.opmms.system.SmartOps.Maintenance.System.payload.machine.ApiResponseMachine;
import com.opmms.system.SmartOps.Maintenance.System.service.machine.MachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/machine")
@RequiredArgsConstructor
public class MachineController {

    private final MachineService machineService;


    @GetMapping("/getAllMachine")
    public ResponseEntity<ApiResponseMachine> getAllMachine()
    {
        return ResponseEntity.ok(machineService.getAllMachine());
    }

    @PostMapping("/createMachine")
    public ResponseEntity<ApiResponseMachine> createMachine(@RequestBody ApiRequestMachine apiRequestMachine)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(machineService.createMachine(apiRequestMachine));
    }

    @GetMapping("/getMachineById/{machineId}")
    public ResponseEntity<ApiResponseMachine> getMachineById(@PathVariable Long machineId)
    {
        return ResponseEntity.ok(machineService.getMachineById(machineId));
    }

    @PutMapping("/updateMachineById/{machineId}")
    public ResponseEntity<ApiResponseMachine> updateMachineById(@PathVariable Long machineId,@RequestBody ApiRequestMachine apiRequestMachine)
    {
        return ResponseEntity.ok(machineService.updateMachineById(machineId,apiRequestMachine));
    }

    @DeleteMapping("/deleteMachineById/{machineId}")
    public ResponseEntity<ApiResponseMachine>  deleteMachine(@PathVariable Long machineId)
    {
        return ResponseEntity.ok(machineService.deleteMachine(machineId));
    }
}