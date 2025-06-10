package com.simac.service;

import com.simac.dto.UserDto;
import com.simac.entity.User;
import com.simac.mapper.UserMapper;
import com.simac.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDto> getUserById(String id) {
        return userRepository.findById(id)
                .map(userMapper::toDto);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public Optional<UserDto> updateUser(String id, UserDto userDto) {
        return userRepository.findById(id).map(existing -> {
            userMapper.updateEntityFromDto(userDto, existing);
            return userMapper.toDto(userRepository.save(existing));
        });
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
