package com.roulette.masiv.onlineroulette;

import com.sun.source.tree.PackageTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@Validated
public class RouletteController {
    @Autowired
    private RouletteRepository rouletteRepository;
    private UserRepository userRepository;
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
        String roulletteId = "";
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
//    @PostMapping(value = "/roulette/new-user")
//    public User createRoullete(@RequestParam("userId") String userId,
//                               @RequestParam("credit") Double credit,
//                               User user){
//        user.setUserId(userId);
//        return userRepository.save(user);
//    }

    @PutMapping(value ="/roulette/{id}/bets")
    public Roulette betToRoulette(  @PathVariable("id") String id,
                                    @RequestParam("userId") String userId,
                                    @RequestParam("credit") Double credit,
                                    @RequestParam("betNumberOrColor") String betNumberOrColor,
                                    @RequestParam("betAmount") Double betAmount,
                                    BetElement betElement,
                                    User user,
                                    Roulette roulette
    ){  roulette.setId(id);

        Map<String, String> bets = user.getBets();
        Map<String, String> users = roulette.getUsers();
        user.setUserId(userId);
        user.setCredit(credit);
        betElement.setBetNumberOrColor(betNumberOrColor);
        betElement.setBetAmount(betAmount);
        bets.put("betNumberOrColor",betNumberOrColor);
        bets.put("betAmount",betAmount.toString());
        user.setBets(bets);

        return roulette;
    }
}
