package com.simac.service;

import com.simac.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDto> getAllUsers();
    Optional<UserDto> getUserById(String id);
    UserDto createUser(UserDto userDto);
    Optional<UserDto> updateUser(String id, UserDto userDto);
    void deleteUser(String id);
}
