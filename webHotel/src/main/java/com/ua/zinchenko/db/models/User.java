package com.ua.zinchenko.db.models;

/**
 * Created by Zinchenko Yelizaveta on 30.09.2021.
 */

public class User {

    private int id;
    private String email;
    private String name;
    private boolean isAdmin;
    private String password;

    public User() {
    }

    public User(String email, String name, boolean isAdmin, String password) {
        this.email = email;
        this.name = name;
        this.isAdmin = isAdmin;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public boolean getAdmin() {
        return isAdmin;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public boolean isAdmin() {
//        return isAdmin;
//    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", isAdmin=" + isAdmin +
                ", password=" + password +
                '}';
    }
}