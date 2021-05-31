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
    @GetMapping("/bets-roulette") // CREAR NUEVA RULETA Y DEVOLVER EL ID
    public Roulette createRoulette(@RequestBody final String rouletteId){
        rouletteRepository.save(rouletteId);
    }
    @GetMapping("/bets-roulette") // ABRIR UNA RULETA CON EL ID CREADO Y DEVOLVER SI ESTA ABIERTA O CERRADA
    public Roulette openRoulette(@RequestBody final String rouletteId){
        rouletteRepository.findById(rouletteId).orElseGet(Roulette::new);
    }
    @GetMapping("/bets-roulette/{bet}/{betAmount}")
    //APOSTAR UN NÚMERO O COLOR ADEMÁS DE UNA CANTIDAD DE DINERO, MÁXIMO 10.000 SI LA RULETA ESTÁ ABIERTA
    public Roulette betToRoulette(

    ) {
        //List<BetElement> betElements
        rouletteRepository.saveAll()
    }
    @GetMapping("/bets-roulette")
    //CERRAR APUESTAS SEGÚN EL ID DE RULETA, DEVOLVER TODAS LAS APUESTAS HECHAS
    //SELECCIONAR UNA APUESTA GANADORA SI ES DE TIPO NUMERICO r 5 veces el dinero
    //apostado para las apuestas de color se debe entrega 1.8
    //veces el dinero apostado
    public Roulette closeBets(@RequestBody final String rouletteId){

    }
    public Roulette winningRoulette(){
        //generar un numero aleatorio entre los betNumber
    }

}
