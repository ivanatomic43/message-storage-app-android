package com.example.message_storage_app.dto;

public class LoginResponseDTO {


    private String email;
    private String accessToken;

    public LoginResponseDTO(){}

    public LoginResponseDTO(String email, String accessToken){
        this.email= email;
        this.accessToken= accessToken;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
