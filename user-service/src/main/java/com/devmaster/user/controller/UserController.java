package com.devmaster.user.controller;

import com.devmaster.user.entity.User;
import com.devmaster.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import model.UserWithDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public UserWithDepartment getUserWithDepartment(@PathVariable("id") Long useId){
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUserWithDepartment(useId);
    }
}
