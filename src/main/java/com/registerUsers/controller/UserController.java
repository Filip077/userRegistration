package com.registerUsers.controller;

import com.registerUsers.entity.User;
import com.registerUsers.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api", method =  RequestMethod.POST)
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService theUserService){
        userService = theUserService;
    }

    @PostMapping("/users")
        public @ResponseBody User saveUser(@RequestBody User user){
        userService.save(user);
        return user;
    }

}
