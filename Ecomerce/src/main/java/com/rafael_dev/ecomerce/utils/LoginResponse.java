package com.rafael_dev.ecomerce.utils;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;

@JsonPropertyOrder({"username", "token", "expiresIn", "status"})
public class LoginResponse {


    private String username;

    private String token;

    private Date expiresIn;

    private boolean status;

    public LoginResponse(String username, String token, Date expiresIn, boolean status) {
        this.username = username;
        this.token = token;
        this.expiresIn = expiresIn;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Date expiresIn) {
        this.expiresIn = expiresIn;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
