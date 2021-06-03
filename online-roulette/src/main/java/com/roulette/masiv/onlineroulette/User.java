package com.roulette.masiv.onlineroulette;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
    @Id
    private String userId;
    private String credit;
    private String betNumberOrColor;
    private Double betAmount;

    public String getuserId() {

        return userId;
    }
    public void setuserId(String userId) {

        this.userId = userId;
    }
    public String getCredit() {

        return credit;
    }
    public void setCredit(String credit) {

        this.credit = credit;
    }

    public String getBetNumberOrColor() {

        return betNumberOrColor;
    }
    public void setBetNumberOrColor(String betNumberOrColor) {

        this.betNumberOrColor = betNumberOrColor;
    }
    public Double getBetAmount() {

        return betAmount;
    }
    public void setBetAmount(Double betAmount) {

        this.betAmount = betAmount;
    }

}
