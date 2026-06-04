package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime time;

    @NotBlank
    private String title;

    @NotBlank
    @Column(length = 2000)
    private String description;

    @NotBlank
    private String organization;

    @Email
    @NotBlank
    private String emailContactPerson;

    @ManyToOne
    private Location location;

    public Event() {
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getOrganization() {
        return organization;
    }

    public String getEmailContactPerson() {
        return emailContactPerson;
    }

    public Location getLocation() {
        return location;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void setEmailContactPerson(String emailContactPerson) {
        this.emailContactPerson = emailContactPerson;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
