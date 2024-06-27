package cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n03.model.services;

import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n03.exception.FruitNotFoundException;
import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n03.model.domain.Fruit;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface FruitService {

    Fruit savefruit(Fruit fruit);

    List<Fruit> fetchFruitList();

    Fruit findOneFruit(ObjectId id);

    Fruit updateFruit(Fruit fruit);


    void deleteFruitById(ObjectId id) throws FruitNotFoundException;
}
