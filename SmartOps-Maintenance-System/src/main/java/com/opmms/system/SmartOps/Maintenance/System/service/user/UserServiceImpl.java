package com.opmms.system.SmartOps.Maintenance.System.service.user;

import com.opmms.system.SmartOps.Maintenance.System.exception.ResourceNotFoundException;
import com.opmms.system.SmartOps.Maintenance.System.model.ResourceType;
import com.opmms.system.SmartOps.Maintenance.System.model.User;
import com.opmms.system.SmartOps.Maintenance.System.payload.user.ApiRequestUser;
import com.opmms.system.SmartOps.Maintenance.System.payload.user.ApiResponseUser;
import com.opmms.system.SmartOps.Maintenance.System.payload.user.UserData;
import com.opmms.system.SmartOps.Maintenance.System.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private  final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public ApiResponseUser getAllUser() {

        List<User> users = userRepository.findAll();
       return buildResponse(200, users, "Successfully Retrieved Users");
    }

    @Override
    public ApiResponseUser createUser(ApiRequestUser apiRequestUser) {

        User createdUser = userRepository.save(mapToUser(apiRequestUser));
        return buildResponse(201, Collections.singletonList(createdUser), "User Created Successfully");
    }

    @Override
    public ApiResponseUser getUserById(Long userId) {

        User user=findByIdOrThrow(userId);
        return buildResponse(200, Collections.singletonList(user), "User Retrieved Successfully");
    }

    @Override
    public ApiResponseUser updateUserById(Long userId, ApiRequestUser apiRequestUser) {

        User user=findByIdOrThrow(userId);
        user.setUsername(apiRequestUser.getUserName());
        user.setPassword(apiRequestUser.getPassword());
        user.setContactNumber(apiRequestUser.getContactNumber());
        user.setEmail(apiRequestUser.getEmail());
        user.setRole(apiRequestUser.getRole());
        User updatedUser=userRepository.save(user);
        return buildResponse(200, Collections.singletonList(updatedUser), "User Updated Successfully");
    }

    @Override
    public ApiResponseUser deleteUserById(Long userId) {

        User user=findByIdOrThrow(userId);
        userRepository.delete(user);
        return buildResponse(200,Collections.singletonList(user), "User Deleted Successfully");
    }

    private ApiResponseUser buildResponse(int status, List<User> userList, String message)
    {
        return new ApiResponseUser(status,new UserData(userList==null?Collections.emptyList():userList), message);
    }

    private User findByIdOrThrow(Long userId)
    {
        return userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(404, ResourceType.USER,"User not found "));
    }

    private User mapToUser(ApiRequestUser apiRequestUser)
    {
        return modelMapper.map(apiRequestUser, User.class);
    }
}
