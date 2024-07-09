package com.api.school.service;

import com.api.school.dto.UserDto;
import com.api.school.entity.UserEntity;
import com.api.school.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAll() {
        //return new ArrayList<UserDto>(list.values()); Este es un ejemplo de usar un Array
        return this.userRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    public UserDto getById(Long id) {
        //return list.get(id); Este es un ejemplo
        return this.userRepository.findById(id)
                .map(this::toDto)
                .orElse(null);
    }

    public UserDto save(UserDto user) {
        UserEntity entity = new UserEntity();
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        UserEntity entitySaved = this.userRepository.save(entity);
        UserDto saved = this.toDto(entitySaved);
        return saved;
    }

    public UserDto update(UserDto user, Long id) {
        return null;
    }

    public void delete(Long id) {
    }

    private UserDto toDto(UserEntity entity) {
        return new UserDto(entity.getId(), entity.getName(), entity.getEmail());
    }

}