package com.cinema.videotecha.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserRequestDTO {

    //@Pattern(regexp = "[A-Za-z0-9_]{3,15}$")
    private String username;
    //@Pattern(regexp = "[A-Za-z0-9_]{3,15}$")
    private String password;
    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 15, message = "Invalid length of name")
    private String name;
    @NotBlank(message = "Surname is mandatory")
    @Size(min = 2, max = 20, message = "Invalid length of surname")
    private String surname;
    @Email(message = "Invalid email")
    @NotNull(message = "Email is mandatory")
    private String email;

    public UserRequestDTO() {
    }

    public UserRequestDTO(String username, String password, String name, String surname, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

}
