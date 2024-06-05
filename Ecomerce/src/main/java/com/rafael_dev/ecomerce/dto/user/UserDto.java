package com.rafael_dev.ecomerce.dto.user;

import com.rafael_dev.ecomerce.model.RoleEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;
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

    @NotNull
    private Date userCreateDate;

    @NotNull
    private boolean notificationPermission = true;

    private Set<RoleEntity> roles;

    public UserDto() {
    }

    public UserDto(Long id, String email, String username, String password, Date userCreateDate, boolean notificationPermission) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.userCreateDate = userCreateDate;
        this.notificationPermission = notificationPermission;
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

    public Date getUserCreateDate() {
        return userCreateDate;
    }

    public void setUserCreateDate(Date userCreateDate) {
        this.userCreateDate = userCreateDate;
    }

    public boolean isNotificationPermission() {
        return notificationPermission;
    }

    public void setNotificationPermission(boolean notificationPermission) {
        this.notificationPermission = notificationPermission;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }
}
