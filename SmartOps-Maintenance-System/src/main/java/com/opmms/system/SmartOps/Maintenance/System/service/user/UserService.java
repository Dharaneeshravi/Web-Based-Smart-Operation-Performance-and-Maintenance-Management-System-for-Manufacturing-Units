package com.opmms.system.SmartOps.Maintenance.System.service.user;

import com.opmms.system.SmartOps.Maintenance.System.payload.user.ApiRequestUser;
import com.opmms.system.SmartOps.Maintenance.System.payload.user.ApiResponseUser;

public interface UserService {
    ApiResponseUser getAllUser();

    ApiResponseUser createUser(ApiRequestUser apiRequestUser);

    ApiResponseUser getUserById(Long userId);

    ApiResponseUser updateUserById(Long userId, ApiRequestUser apiRequestUser);

    ApiResponseUser deleteUserById(Long userId);
}
