package com.opmms.system.SmartOps.Maintenance.System.exception;

import com.opmms.system.SmartOps.Maintenance.System.model.ResourceType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException{

    private int status;
    private ResourceType resourceType;
    private String message;
}
