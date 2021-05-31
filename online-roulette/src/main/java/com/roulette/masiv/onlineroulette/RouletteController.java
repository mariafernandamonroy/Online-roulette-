package com.roulette.masiv.onlineroulette;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RouletteController {
    @Autowired
    private RouletteRepository rouletteRepository;
    @PostMapping("/")
    public String homePage(){
        return "HomePage";
    }
    @GetMapping("/bets-roulette")
    public Roulette createRoulette(@RequestBody final String rouletteId){
        rouletteRepository.save(rouletteId);
    }
    public Roulette openRoulette(@RequestBody final String rouletteId){
        rouletteRepository.findById(rouletteId).orElseGet(Roulette::new);
    }
    @GetMapping("/bets-roulette/{bet}/{betAmount}")

    public Roulette betToRoulette(

    ) {
        //List<BetElement> betElements
        rouletteRepository.saveAll()
    }
    @GetMapping("/bets-roulette")
    public Roulette closeBets(@RequestBody final String rouletteId){

    }
    public Roulette winningRoulette(){

    }

}
