package com.opmms.system.SmartOps.Maintenance.System.service;

import com.opmms.system.SmartOps.Maintenance.System.payload.ApiRequestUser;
import com.opmms.system.SmartOps.Maintenance.System.payload.ApiResponseUser;

public interface UserService {
    ApiResponseUser getAllUser();

    ApiResponseUser createUser(ApiRequestUser apiRequestUser);

    ApiResponseUser getUserById(Long userId);

    ApiResponseUser updateUserById(Long userId, ApiRequestUser apiRequestUser);

    ApiResponseUser deleteUserById(Long userId);
}
