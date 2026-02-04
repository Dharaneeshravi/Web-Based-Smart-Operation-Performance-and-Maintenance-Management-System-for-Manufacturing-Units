package com.opmms.system.SmartOps.Maintenance.System.payload.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseUser {

    @JsonProperty("status")
    private Integer status;
    @JsonProperty("data")
    private UserData userData;
    @JsonProperty("message")
    private String message;
}
