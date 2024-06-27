package cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n01.model.service;

import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n01.exceptions.FruitNotFoundException;
import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n01.model.domain.Fruit;

import java.util.List;

public interface FruitService {

    // Save operation
    Fruit savefruit(Fruit fruit);

    // Read operation
    List<Fruit> fetchFruitList();

    // Read one operation
    Fruit findOneFruit(Long id);

    // Update operation
    Fruit updateFruit(Fruit fruit);

    // Delete operation
    void deleteFruitById(Long id) throws FruitNotFoundException;
}
