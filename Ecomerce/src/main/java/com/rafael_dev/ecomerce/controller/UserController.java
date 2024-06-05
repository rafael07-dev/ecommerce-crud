package com.rafael_dev.ecomerce.controller;

import com.rafael_dev.ecomerce.dto.producto.ProductDto;
import com.rafael_dev.ecomerce.dto.user.UserDto;
import com.rafael_dev.ecomerce.mapper.UserMapper;
import com.rafael_dev.ecomerce.model.UserEntity;
import com.rafael_dev.ecomerce.repository.UserRepository;
import com.rafael_dev.ecomerce.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserServiceImpl userServiceImpl;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserController(UserServiceImpl userServiceImpl, UserMapper userMapper, UserRepository userRepository) {
        this.userServiceImpl = userServiceImpl;
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getUsers(){
        return ResponseEntity.ok(userMapper.toListUserDto(userRepository.findAll()) );
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
        return ResponseEntity.ok(userServiceImpl.saveUser(user));
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestParam Long id){

        userRepository.deleteById(id);

        return "User deleted " + id;
    }

    @PutMapping("/{idUser}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,
                                                    @PathVariable Long idUser){
        return ResponseEntity.ok(userServiceImpl.updateUser(idUser, userDto));
    }
}
