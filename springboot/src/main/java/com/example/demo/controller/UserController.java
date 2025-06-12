package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.document.MongoUser;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    // GET /users : 모든 사용자 조회 (MongoDB 사용)
    @GetMapping("/users")
    public ResponseEntity<List<MongoUser>> getUsers() {
        List<MongoUser> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    
    // POST /users : 사용자 생성 (MySQL 사용)
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        User createdUser = userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
    
    // PUT /users/{userId} : 사용자 정보 업데이트 (MySQL 사용)
    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(
            @PathVariable Long userId,
            @RequestBody UserDto userDto) {
        try {
            User updatedUser = userService.updateUser(userId, userDto);
            return ResponseEntity.ok(updatedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
    // DELETE /users/{userId} : 사용자 삭제 (MySQL 사용)
    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        try {
            userService.deleteUser(userId);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}