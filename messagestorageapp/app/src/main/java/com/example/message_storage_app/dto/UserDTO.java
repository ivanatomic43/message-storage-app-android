package com.example.message_storage_app.dto;
import com.example.message_storage_app.model.User;

public class UserDTO {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String password;

    public UserDTO(){}

    public UserDTO(Integer id, String firstName, String lastName, String email, String phoneNumber, String password){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.password=password;
    }

    public UserDTO(User u){
        this.firstName=u.getFirstName();
        this.lastName=u.getLastName();
        this.email=u.getEmail();
        this.phoneNumber=u.getPhoneNumber();
        this.password=u.getPassword();
    }
}
