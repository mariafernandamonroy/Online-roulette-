package com.roulette.masiv.onlineroulette;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface RouletteRepository extends MongoRepository<Roulette, String> {


}
