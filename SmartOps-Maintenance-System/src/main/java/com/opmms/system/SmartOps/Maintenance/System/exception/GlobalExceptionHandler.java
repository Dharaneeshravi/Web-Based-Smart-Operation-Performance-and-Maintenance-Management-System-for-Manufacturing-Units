package com.opmms.system.SmartOps.Maintenance.System.exception;

import com.opmms.system.SmartOps.Maintenance.System.payload.machine.ApiResponseMachine;
import com.opmms.system.SmartOps.Maintenance.System.payload.machine.MachineData;
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
       };
    }

    private ResponseEntity<?> buildResponse(Object object)
    {
        return ResponseEntity.status(404).body(object);
    }
}


