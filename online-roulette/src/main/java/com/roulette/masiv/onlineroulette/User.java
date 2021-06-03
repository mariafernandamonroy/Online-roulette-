package com.roulette.masiv.onlineroulette;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    private String userId;
    private Double credit;
    private Integer betNumber;
    private String betColor;
    private Double betAmount;
    private String result;

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public Double getCredit() {

        return credit;
    }
    public void setCredit(Double credit) {

        this.credit = credit;
    }
    public Integer getBetNumber() {
        return betNumber;
    }
    public void setBetNumber(Integer betNumber) {
        this.betNumber = betNumber;
    }
    public String getBetColor() {
        return betColor;
    }
    public void setBetColor(String betColor) {
        this.betColor = betColor;
    }
    public Double getBetAmount() {

        return betAmount;
    }
    public void setBetAmount(Double betAmount) {

        this.betAmount = betAmount;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
}
