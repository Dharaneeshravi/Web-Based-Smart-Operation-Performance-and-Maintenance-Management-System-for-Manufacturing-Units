package com.opmms.system.SmartOps.Maintenance.System.controller;

import com.opmms.system.SmartOps.Maintenance.System.payload.shift.ApiRequestShift;
import com.opmms.system.SmartOps.Maintenance.System.payload.shift.ApiResponseShift;
import com.opmms.system.SmartOps.Maintenance.System.service.shift.ShiftService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shift")
@RequiredArgsConstructor
public class ShiftController {

    private final ShiftService shiftService;

    @GetMapping("/getAllShift")
    public ResponseEntity<ApiResponseShift> getAllShift()
    {
        return ResponseEntity.ok(shiftService.getAllShift());
    }

    @PostMapping("/createShift")
    public ResponseEntity<ApiResponseShift> createShift(@RequestBody ApiRequestShift apiRequestShift)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(shiftService.createShift(apiRequestShift));
    }

    @GetMapping("/getShiftById/{ShiftId}")
    public ResponseEntity<ApiResponseShift> getShiftById(@PathVariable Long ShiftId)
    {
        return ResponseEntity.ok(shiftService.getShiftById(ShiftId));
    }

    @PutMapping("/updateShiftById/{ShiftId}")
    public ResponseEntity<ApiResponseShift> updateShiftById(@PathVariable Long ShiftId,@RequestBody ApiRequestShift apiRequestShift)
    {
        return ResponseEntity.ok(shiftService.updateShiftById(ShiftId,apiRequestShift));
    }

    @DeleteMapping("/deleteShiftById/{ShiftId}")
    public ResponseEntity<ApiResponseShift> deleteShiftById(@PathVariable Long ShiftId)
    {
        return ResponseEntity.ok(shiftService.deleteShiftById(ShiftId));
    }
}
