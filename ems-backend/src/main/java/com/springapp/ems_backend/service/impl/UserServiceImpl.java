//package com.springapp.ems_backend.service.impl;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.stereotype.Service;
//
//import com.springapp.ems_backend.dto.UserDto;
//import com.springapp.ems_backend.entity.User;
//import com.springapp.ems_backend.mapper.UserMapper;
//import com.springapp.ems_backend.repository.UserRepository;
//import com.springapp.ems_backend.service.UserService;
//
//import lombok.RequiredArgsConstructor;
//
//@Service
//@RequiredArgsConstructor
//public class UserServiceImpl implements UserService {
//
//    private final UserRepository userRepository = null;
//
//    @Override
//    public UserDto createUser(UserDto userDto) {
//        // 1. Convert DTO to Entity
//        User user = UserMapper.mapToUser(userDto);
//        
//        // 2. Save to Database
//        User savedUser = userRepository.save(user);
//        
//        // 3. Convert saved Entity back to DTO and return
//        return UserMapper.mapToUserDto(savedUser);
//    }
//
//    @Override
//    public UserDto getUserById(Long userId) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User does not exist with id: " + userId));
//        return UserMapper.mapToUserDto(user);
//    }
//
//    @Override
//    public List<UserDto> getAllUsers() {
//        List<User> users = userRepository.findAll();
//        return users.stream()
//                .map(UserMapper::mapToUserDto)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public UserDto updateUser(Long userId, UserDto updatedUserDto) {
//        // 1. Find the existing user or throw an error
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
//
//        // 2. Update the fields (Mapping DTO values to the existing Entity)
//        user.setName(updatedUserDto.getName());
//        user.setEmail(updatedUserDto.getEmail());
//
//        // 3. Save the updated entity
//        User updatedUserObj = userRepository.save(user);
//
//        // 4. Return the mapped DTO
//        return UserMapper.mapToUserDto(updatedUserObj);
//    }
//
//    @Override
//    public void deleteUser(Long userId) {
//        // Check if user exists before deleting
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
//        
//        userRepository.deleteById(userId);
//    }
//
//    @Override
//    public UserDto getUserByEmail(String email) {
//        // Uses the custom method you added to your UserRepository
//        User user = userRepository.findByEmail(email)
//                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
//        
//        return UserMapper.mapToUserDto(user);
//    }
//
//}