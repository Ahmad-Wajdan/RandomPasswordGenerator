//package com.springapp.ems_backend.controller;
//
//import java.util.List;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.springapp.ems_backend.dto.UserDto;
//import com.springapp.ems_backend.service.UserService;
//
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//
//@CrossOrigin(origins = "http://localhost:5173")
//@AllArgsConstructor
//@RestController
//@RequestMapping("/api/v1/users")
//@RequiredArgsConstructor
//public class UserController {
//	
//	private final UserService userService = null;
//
//    // 1. Create User
//    @PostMapping
//    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
//        UserDto savedUser = userService.createUser(userDto);
//        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
//    }
//
//    // 2. Get User by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
//        UserDto userDto = userService.getUserById(userId);
//        return ResponseEntity.ok(userDto);
//    }
//
//    // 3. Get All Users
//    @GetMapping
//    public ResponseEntity<List<UserDto>> getAllUsers() {
//        return ResponseEntity.ok(userService.getAllUsers());
//    }
//
//    // 4. Update User
//    @PutMapping("/{id}")
//    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId, 
//                                              @RequestBody UserDto updatedDto) {
//        UserDto userDto = userService.updateUser(userId, updatedDto);
//        return ResponseEntity.ok(userDto);
//    }
//
//    // 5. Delete User
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
//        userService.deleteUser(userId);
//        return ResponseEntity.ok("User deleted successfully!");
//    }
//
//    // 6. Get User by Email
//    @GetMapping("/search")
//    public ResponseEntity<UserDto> getUserByEmail(@RequestParam("email") String email) {
//        UserDto userDto = userService.getUserByEmail(email);
//        return ResponseEntity.ok(userDto);
//    }
//
//}
