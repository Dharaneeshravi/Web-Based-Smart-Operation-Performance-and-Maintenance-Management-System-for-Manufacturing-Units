package com.opmms.system.SmartOps.Maintenance.System.exception;

import com.opmms.system.SmartOps.Maintenance.System.payload.downtime.ApiResponseDowntime;
import com.opmms.system.SmartOps.Maintenance.System.payload.downtime.DowntimeData;
import com.opmms.system.SmartOps.Maintenance.System.payload.machine.ApiResponseMachine;
import com.opmms.system.SmartOps.Maintenance.System.payload.machine.MachineData;
import com.opmms.system.SmartOps.Maintenance.System.payload.production.ApiResponseProduction;
import com.opmms.system.SmartOps.Maintenance.System.payload.production.ProductionData;
import com.opmms.system.SmartOps.Maintenance.System.payload.user.ApiResponseUser;
import com.opmms.system.SmartOps.Maintenance.System.payload.user.UserData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException exception){

       return switch (exception.getResourceType()) {

           case  USER->
                   buildResponse(new ApiResponseUser(exception.getStatus(),new UserData(Collections.emptyList()), exception.getMessage()));

           case MACHINE ->
                 buildResponse(new ApiResponseMachine(exception.getStatus(),new MachineData(Collections.emptyList()), exception.getMessage()));

           case PRODUCTION ->
               buildResponse(new ApiResponseProduction(exception.getStatus(),new ProductionData(Collections.emptyList()), exception.getMessage()));

           case DOWNTIME ->
                buildResponse(new ApiResponseDowntime(exception.getStatus(),new DowntimeData(Collections.emptyList()), exception.getMessage()));
       };
    }

    private ResponseEntity<?> buildResponse(Object object)
    {
        return ResponseEntity.status(404).body(object);
    }
}


