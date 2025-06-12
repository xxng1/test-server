package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.document.MongoUser;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.repository.MongoUserRepository;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private MongoUserRepository mongoUserRepository;
    
    // MongoDB에서 모든 사용자 조회
    public List<MongoUser> getAllUsers() {
        return mongoUserRepository.findAll();
    }
    
    // MySQL에 사용자 생성
    public User createUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        return userRepository.save(user);
    }
    
    // MySQL에서 사용자 정보 업데이트
    public User updateUser(Long userId, UserDto userDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다"));
        
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        return userRepository.save(user);
    }
    
    // MySQL에서 사용자 삭제
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다"));
        
        userRepository.delete(user);
    }
}