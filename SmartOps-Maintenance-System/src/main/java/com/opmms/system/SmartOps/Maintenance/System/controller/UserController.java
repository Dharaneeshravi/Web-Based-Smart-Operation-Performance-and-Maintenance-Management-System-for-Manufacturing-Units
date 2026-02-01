package com.opmms.system.SmartOps.Maintenance.System.controller;

import com.opmms.system.SmartOps.Maintenance.System.payload.ApiRequestUser;
import com.opmms.system.SmartOps.Maintenance.System.payload.ApiResponseUser;
import com.opmms.system.SmartOps.Maintenance.System.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/getAllUser")
    public ResponseEntity<ApiResponseUser> getAllUser()
    {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PostMapping("/createUser")
    public ResponseEntity<ApiResponseUser> createUser(@RequestBody ApiRequestUser apiRequestUser)
    {
        return ResponseEntity.status(201).body(userService.createUser(apiRequestUser));
    }

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<ApiResponseUser> getUserById(@PathVariable Long userId)
    {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PutMapping("/updateUserById/{userId}")
    public ResponseEntity<ApiResponseUser> updateUserById(@PathVariable Long userId,@RequestBody ApiRequestUser apiRequestUser)
    {
        return ResponseEntity.status(200).body(userService.updateUserById(userId,apiRequestUser));
    }

    @DeleteMapping("/deleteUserById/{userId}")
    public ResponseEntity<ApiResponseUser> deleteUserById(@PathVariable Long userId)
    {
        return ResponseEntity.status(200).body(userService.deleteUserById(userId));
    }
}
