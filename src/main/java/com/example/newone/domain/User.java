package com.example.newone.domain;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(
            strategy= GenerationType.IDENTITY
    )
    private int id;
    private String username;
    private String password;
    private String email;
    private String verification;
    private boolean isenabled;

    public User() {
    }

    public User(int id, String username, String password, String email, String verification, boolean isenabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.verification = verification;
        this.isenabled = isenabled;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVerification() {
        return verification;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }

    public boolean isIsenabled() {
        return isenabled;
    }

    public void setIsenabled(boolean isenabled) {
        this.isenabled = isenabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

}
