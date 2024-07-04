package com.api.school.controller;

import com.api.school.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> findAll(){
        ArrayList<UserDto> lista = new ArrayList<UserDto>();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable("id") Long id){
        UserDto user = new UserDto(id, "Luis", "luis@testDeId.com");
        return ResponseEntity.ok(user);
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto, @PathVariable("id") Long id){
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        return ResponseEntity.noContent().build();
    }

}