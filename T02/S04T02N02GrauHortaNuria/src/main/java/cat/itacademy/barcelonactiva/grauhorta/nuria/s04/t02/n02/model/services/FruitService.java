package cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n02.model.services;

import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n02.exceptions.FruitNotFoundException;
import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n02.model.domain.Fruit;

import java.util.List;
import java.util.Optional;

public interface FruitService {
    // Save operation
    Fruit savefruit(Fruit fruit);

    // Read operation
    List<Fruit> fetchFruitList();

    // Read one operation
   Fruit findOneFruit(int id);

    // Update operation
    Fruit updateFruit(Fruit fruit, int id);

    // Delete operation
    void deleteFruitById(int id) throws FruitNotFoundException;
}
