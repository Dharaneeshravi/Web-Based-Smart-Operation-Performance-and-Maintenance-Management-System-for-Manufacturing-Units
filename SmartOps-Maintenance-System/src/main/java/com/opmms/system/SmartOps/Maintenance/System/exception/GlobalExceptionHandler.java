package com.opmms.system.SmartOps.Maintenance.System.exception;

import com.opmms.system.SmartOps.Maintenance.System.model.ResourceType;
import com.opmms.system.SmartOps.Maintenance.System.payload.ApiResponseUser;
import com.opmms.system.SmartOps.Maintenance.System.payload.UserData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.opmms.system.SmartOps.Maintenance.System.model.ResourceType.*;

import java.util.Collections;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException exception){

       return switch (exception.getResourceType()) {

           case  USER->
                   buildResponse(new ApiResponseUser(exception.getStatus(),new UserData(Collections.emptyList()), exception.getMessage()));
       };
    }

    private ResponseEntity<?> buildResponse(Object object)
    {
        return ResponseEntity.status(404).body(object);
    }
}


