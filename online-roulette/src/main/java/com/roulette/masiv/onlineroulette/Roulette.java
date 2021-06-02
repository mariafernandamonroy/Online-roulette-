package com.roulette.masiv.onlineroulette;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;

@Document
public class Roulette {
    @Id
    private String id;
    private Boolean status;
    private Map<String,String> bets = new HashMap<>();

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
    public Map<String, String> getBets() {
        return bets;
    }
    public void setBets(Map<String, String> bets) {
        this.bets = bets;
    }
}