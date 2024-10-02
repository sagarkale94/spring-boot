package com.skorg.firstapp.controller;

import com.skorg.firstapp.entity.UserEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    private final Map<Integer, UserEntity> userHashMap = new HashMap<Integer, UserEntity>();

    @GetMapping
    public List<UserEntity> getAllUser(){
        return new ArrayList<>(userHashMap.values());
    }

    @PostMapping
    public boolean addUser(@RequestBody UserEntity payloadUserEntity) {
        userHashMap.put(payloadUserEntity.getId(), payloadUserEntity);
        return true;
    }

    @GetMapping("id/{userId}")
    public UserEntity getUserDetails(@PathVariable Integer userId){
        return userHashMap.get(userId);
    }

    @PutMapping("id/{userId}")
    public UserEntity updateUserDetails(@PathVariable Integer userId, @RequestBody UserEntity payloadUserEntity){
        return userHashMap.put(userId, payloadUserEntity);
    }

    @DeleteMapping("id/{userId}")
    public UserEntity deleteUserDetails(@PathVariable Integer userId){
        return userHashMap.remove(userId);
    }

}
