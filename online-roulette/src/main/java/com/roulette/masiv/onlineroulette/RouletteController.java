package com.roulette.masiv.onlineroulette;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class RouletteController {
    @Autowired
    private RouletteRepository rouletteRepository;
    @GetMapping("/")
    public String homePage(){

        return "HomePage";
    }
    @PostMapping(value = "/roulette/new-roulette")
    public Roulette createRoullete(@RequestParam("id") String id, Roulette roulette){
        roulette.setId(id);
        return rouletteRepository.save(roulette);
    }
    @GetMapping(value = "/roulette/open-roulette")
    public String openRoulette(@RequestParam(value = "id") String id,
                               Roulette roulette){
        String roulletteId = " ";
        if (rouletteRepository.findById(id).isEmpty() == Boolean.FALSE){
            roulette.setStatus(Boolean.TRUE);
            String rouletteNewStatus = "Abierta";
            roulletteId = "Acción exitosa. " +
                    "El Id de la ruleta es:" + id + " y se encuentra: " + rouletteNewStatus;
        }
        else{
            roulletteId = "Acción denegada. " +
                    "El la ruleta con el Id "+ id + " no se encuentra";
        }
        return roulletteId;
    }
    @PostMapping(value ="/roulette/{id}/bets")
    public Roulette betToRoulette(  @PathVariable(value = "id") String id,
                                    @RequestHeader(value = "userId") String userId,
                                    @RequestParam(value = "credit") String credit,
                                    @RequestParam(value = "betNumberOrColor") String betNumberOrColor,
                                    @RequestParam(value = "betAmount") Double betAmount,
                                    User user,
                                    Roulette roulette
    ){
        roulette.setStatus(Boolean.TRUE);
        roulette = rouletteRepository.findById(id).orElseGet(Roulette::new);
        user.setuserId(userId);
        user.setCredit(credit);
        user.setBetNumberOrColor(betNumberOrColor);
        user.setBetAmount(betAmount);
        List<User> users = roulette.getUser();
        users.add(user);
        roulette.setUser(users);
        return rouletteRepository.save(roulette);
    }



//        Double doubleCredit = Double.parseDouble(credit);
    //        if(betAmount<doubleCredit){
//            credit = Double.toString(doubleCredit - betAmount);
//        }
}


