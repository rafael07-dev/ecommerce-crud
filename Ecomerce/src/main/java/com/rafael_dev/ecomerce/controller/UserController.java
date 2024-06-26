package com.rafael_dev.ecomerce.controller;

import com.rafael_dev.ecomerce.dto.user.UserDto;
import com.rafael_dev.ecomerce.mapper.UserMapper;
import com.rafael_dev.ecomerce.repository.UserRepository;
import com.rafael_dev.ecomerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper, UserRepository userRepository) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getUsers(){
        return ResponseEntity.ok(userMapper.toListUserDto(userRepository.findAll()) );
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam Long id){

        userRepository.deleteById(id);

        return "User deleted " + id;
    }

    @PutMapping("/update/{idUser}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,
                                                    @PathVariable Long idUser){
        return ResponseEntity.ok(userService.updateUser(idUser, userDto));
    }
}
