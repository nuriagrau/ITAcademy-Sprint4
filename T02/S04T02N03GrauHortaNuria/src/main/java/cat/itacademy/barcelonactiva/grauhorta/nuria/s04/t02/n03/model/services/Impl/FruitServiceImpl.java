package cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n03.model.services.Impl;

import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n03.exception.FruitAlreadyExistsException;
import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n03.exception.FruitNotFoundException;
import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n03.model.domain.Fruit;
import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n03.model.repository.FruitRepository;
import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n03.model.services.FruitService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService {
    @Autowired
    private FruitRepository fruitRepository;


    @Override
    public Fruit savefruit(Fruit fruit) {
        fruitRepository.findByNameIgnoreCase(fruit.getName())
                .ifPresent(fruitIn -> {
                    throw new FruitAlreadyExistsException(fruit.getName() + " already exists.");
                });
        return fruitRepository.save(fruit);
    }

    @Override
    public List<Fruit> fetchFruitList() {
        return fruitRepository.findAll();
    }

    public Fruit findOneFruit(ObjectId id) {
        Optional<Fruit> requestedFruit = fruitRepository.findById(id);

        return requestedFruit.orElseThrow(() -> new FruitNotFoundException("Fruit with id: " + id + " not found."));
            }

    @Override
    public Fruit updateFruit(Fruit fruit) {
        Fruit fruitToUpdate = fruitRepository.findByNameIgnoreCase(fruit.getName())
                .orElseThrow(() -> new FruitNotFoundException("Fruit with name: " + fruit.getName() + " not found."));
        if (fruitToUpdate != null) {
            if (Objects.nonNull((fruit.getName())) && !"".equalsIgnoreCase(fruit.getName())) {
                fruitToUpdate.setName(fruit.getName());
            }
            if (Objects.nonNull((fruit.getQuantityKg()))) {
                fruitToUpdate.setQuantityKg(fruit.getQuantityKg());
            }
        }
            return fruitToUpdate;
    }


    @Override
    public void deleteFruitById(ObjectId id) {
        fruitRepository.findById(id)
                .orElseThrow(() -> new FruitNotFoundException("Fruit with id: " + id + " not found."));
        fruitRepository.deleteById(id);
    }


}
