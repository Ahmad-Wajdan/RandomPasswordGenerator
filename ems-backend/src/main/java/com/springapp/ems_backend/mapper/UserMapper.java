//package com.springapp.ems_backend.mapper;
//
//import com.springapp.ems_backend.dto.UserDto;
//import com.springapp.ems_backend.entity.User;
//
//public class UserMapper {
//
//	public static UserDto mapToUserDto(User user) {
//        return new UserDto(
//            user.getId(),
//            user.getEmail(),
//            user.getName(),
//            user.getProvider()
//            // We omit password and googleId for security
//        );
//    }
//
//    // Convert UserDto to User Entity
//    public static User mapToUser(UserDto userDto) {
//        User user = new User();
//        user.setId(userDto.getId());
//        user.setEmail(userDto.getEmail());
//        user.setName(userDto.getName());
//        user.setProvider(userDto.getProvider());
//        return user;
//    }
//}
