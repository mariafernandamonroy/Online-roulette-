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
    @GetMapping("/")
    public String homePage(){
        return "HomePage";
    }
    @PostMapping(value = "/roulette/new-roulette")
    public Roulette createRoullete(@RequestParam("id") String id, Roulette roulette){
        roulette.setId(id);
        return rouletteRepository.save(roulette);
    }
    //-------------------
    @GetMapping(value = "/roulette") // BORRAR ESTE MÉTODO
    public List<Roulette> findProducts(){
        return rouletteRepository.findAll();
    }
    //-------------------
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
    @PutMapping(value ="/roulette/{id}/bets")
    public Roulette betToRoulette(  @PathVariable("id") String id,
                                    @RequestParam("betNumberOrColor") String betNumberOrColor,
                                    @RequestParam("betAmount") Double betAmount,
                                    BetElement betElement,
                                    Roulette roulette
    ){
        betElement.setBetNumberOrColor(betNumberOrColor);
        betElement.setBetAmount(betAmount);
        Map<String, String> bets = roulette.getBets();
        bets.put("betNumberOrColor",betNumberOrColor);
        bets.put("betAmount",betAmount.toString());
        roulette.setId(id);
        roulette.setBets(bets);
        return roulette;
    }
}
