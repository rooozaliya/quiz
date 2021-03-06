package com.clarkngo.quizme.web.domain;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class User {
    private int userId;
    private String name;
    private String email;
    private String password;
    private int result;
    private String result1;
    private String result2;
    private String result3;

    public String getResult1() {
        return result1;
    }

    public void setResult1(String result1) {
        this.result1 = result1;
    }

    public String getResult2() {
        return result2;
    }

    public void setResult2(String result2) {
        this.result2 = result2;
    }


    public String getResult3() {
        return result3;
    }

    public void setResult3(String result3) {
        this.result3 = result3;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @PersistenceContext
    private EntityManager em;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", results=" + result +
                '}';
    }


}
