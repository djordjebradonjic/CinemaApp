package com.valcon.videotechaivana.model;

import com.valcon.videotechaivana.model.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "[A-Za-z0-9_]{3,15}$")
    @Column(nullable = false, unique = true)
    private String username;

    @Pattern(regexp = "[A-Za-z0-9_]{3,15}$")
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 15, message = "Invalid length of name")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Surname is mandatory")
    @Size(min = 2, max = 20, message = "Invalid length of surname")
    @Column(nullable = false)
    private String surname;

    @Email(message = "Invalid email")
    @NotNull(message = "Email is mandatory")
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull(message = "User role is mandatory")
    @Column(name = "user_role", nullable = false)
    private UserRole userRole;

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations = new ArrayList<>();


    public User() {

    }

    public User(String username, String password, String name, String surname, String email, UserRole userRole) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.userRole = userRole;
    }

    public User(Long id, String username, String password, String name, String surname, String email, UserRole userRole) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.userRole = userRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}