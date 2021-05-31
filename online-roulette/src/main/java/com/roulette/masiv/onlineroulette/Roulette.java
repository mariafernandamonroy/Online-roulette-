package com.roulette.masiv.onlineroulette;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document
public class Roulette {
    @Id
    private String id;
    private String status;
    private Map<String,List<BetElement>> bets = new HashMap<>();

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Map<String, List<BetElement>> getBets() {
        return bets;
    }
    public void setBets(Map<String, List<BetElement>> bets) {
        this.bets = bets;
    }

}