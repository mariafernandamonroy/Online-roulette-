package com.roulette.masiv.onlineroulette;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        List<Roulette> roulettes= rouletteRepository.findAll();
        List<String> roulettesId= new ArrayList<>();
        for (int i = 0; i < roulettes.size(); ++i) {
            Roulette rouletteLocal = roulettes.get(i);
            roulettesId.add(rouletteLocal.getId());
        }
        if(!roulettesId.contains(id)) {
            roulette.setId(id);
        }else{
            roulette = rouletteRepository.findById(id).orElseGet(Roulette::new);
        }

        return rouletteRepository.save(roulette);
    }
    @PostMapping(value = "/roulette/open-roulette")
    public String openRoulette(@RequestParam(value = "id") String id,
                               Roulette roulette){
        String roulletteId = " ";
        if (!rouletteRepository.findById(id).isEmpty()){
            roulette.setStatus(Boolean.TRUE);
            rouletteRepository.save(roulette);
            String rouletteNewStatus = "Abierta";

            return "Acción exitosa. " +
                    "El Id de la ruleta es:" + id + " y se encuentra: " + rouletteNewStatus;
        }
        else{

            return "Acción denegada. " +
                    "El la ruleta con el Id "+ id + " no se encuentra";
        }
    }
    @PostMapping(value ="/roulette/{id}/bets")
    public Roulette betToRoulette(  @PathVariable(value = "id") String id,
                                    @RequestHeader(value = "userId") String userId,
                                    @RequestParam(value = "credit") Double credit,
                                    @RequestParam(value = "bet") String bet,
                                    @RequestParam(value = "betAmount") Double betAmount,
                                    User user,
                                    Roulette roulette
    ){
        roulette = rouletteRepository.findById(id).orElseGet(Roulette::new);
        List<User> users = roulette.getUser();
        List<String> userIds = new ArrayList<>();
        Integer betNumber = -1;
        String betColor = "";
        try{
            betNumber = Integer.parseInt(bet);
            betColor = (betNumber%2) == 0 ? "Rojo" : "Negro";
        }catch (Exception e){
            betColor = bet;
        }
        betAmount = betAmount > credit ? credit : betAmount;
        Double betTotal = betAmount;
        for (int i = 0; i < users.size(); ++i) {
            User userLocal = users.get(i);
            userIds.add(userLocal.getUserId());
            betTotal = betTotal + userLocal.getBetAmount();
        }
        if(!userIds.contains(userId) && betTotal <= 10000.0){
            user.setUserId(userId);
            user.setCredit(credit);
            user.setBetNumber(betNumber);
            user.setBetColor(betColor);
            user.setBetAmount(betAmount);
            user.setResult("");
            users.add(user);
            roulette.setUser(users);
        }

        return rouletteRepository.save(roulette);
    }
    @PostMapping(value ="/roulette/close-roulette")
    public Roulette closeRoulette(@RequestParam(value = "id") String id,
                                  Roulette roulette
    ){
        roulette = rouletteRepository.findById(id).orElseGet(Roulette::new);
        roulette.setStatus(Boolean.FALSE);
        Integer winningNumber = getRandomNumberInts(0, 36);
        String winningColor = (winningNumber%2) == 0 ? "Rojo" : "Negro";
        List<User> users = roulette.getUser();
        for (int i = 0; i < users.size(); ++i) {
            User userLocal = users.get(i);
            if(userLocal.getBetNumber() > 0){
                userLocal.setResult(
                        userLocal.getBetNumber() == winningNumber
                        ? "Ganó número"
                        : "No ganó"
                );
                userLocal.setCredit(
                        userLocal.getBetNumber() == winningNumber
                                ? userLocal.getCredit() + 4 * userLocal.getBetAmount()
                                : userLocal.getCredit() - userLocal.getBetAmount()
                );
                userLocal.setBetAmount(0.0);
            }else {
                userLocal.setResult(
                        userLocal.getBetColor() == winningColor
                                ? "Ganó color"
                                : "No ganó"
                );
                userLocal.setCredit(
                        userLocal.getBetNumber() == winningNumber
                        ? userLocal.getCredit() + 0.8 * userLocal.getBetAmount()
                        : userLocal.getCredit() - userLocal.getBetAmount()
                );
                userLocal.setBetAmount(0.0);
            }
        }

        return rouletteRepository.save(roulette);
    }
    public static int getRandomNumberInts(int min, int max){
        Random random = new Random();

        return random.ints(min,(max+1)).findFirst().getAsInt();
    }
    @GetMapping(value ="/roulette/all-roulettes")
    public List<Roulette> allRoulettes(Roulette roulette){

        return rouletteRepository.findAll();
    }
}


