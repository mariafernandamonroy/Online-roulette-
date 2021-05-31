package com.roulette.masiv.onlineroulette;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RouletteRepository extends MongoRepository<Roulette, String> {

}
