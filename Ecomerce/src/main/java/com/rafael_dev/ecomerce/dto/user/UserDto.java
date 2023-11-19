package com.rafael_dev.ecomerce.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Set;

public class UserDto {

    private Long id;

    @Email
    private String email;

    @NotBlank
    @Size(max = 30)
    private String username;

    @NotBlank
    private String password;

    private Set<String> roles;

    public UserDto() {
    }

    public UserDto(Long id, String email, String username, String password, Set<String> roles) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
