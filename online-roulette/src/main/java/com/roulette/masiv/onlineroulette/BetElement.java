package com.roulette.masiv.onlineroulette;

public class BetElement {
    private String betNumberOrColor;
    private Double betAmount;

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
