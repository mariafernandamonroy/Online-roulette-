package com.roulette.masiv.onlineroulette;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Roulette {
    @Id
    private String id;
    private Boolean status = Boolean.FALSE;
    private List<User> user = new ArrayList<>();

    public String getId() {

        return id;
    }
    public void setId(String id) {

        this.id = id;
    }
    public Boolean getStatus() {

        return status;
    }
    public void setStatus(Boolean status) {

        this.status = status;
    }
    public List<User> getUser() {

        return user;
    }
    public void setUser(List<User> user) {

        this.user = user;
    }
}