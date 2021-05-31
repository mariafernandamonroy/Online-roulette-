package com.roulette.masiv.onlineroulette;

import javax.swing.plaf.DimensionUIResource;

public class BetElement {
    private Double betNumber;
    private String bet;
    private Double betAmount;

    public Double getBetNumber() {
        return betNumber;
    }
    public void setBetNumber(Double betNumber) {
        this.betNumber = betNumber;
    }
    public String getBet() {
        return bet;
    }
    public void setBet(String bet) {
        this.bet = bet;
    }
    public Double getBetAmount() {
        return betAmount;
    }
    public void setBetAmount(Double betAmount) {
        this.betAmount = betAmount;
    }
}
