package cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n01.model.service.impl;


import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n01.exceptions.FruitAlreadyExistsException;
import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n01.exceptions.FruitNotFoundException;
import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n01.model.domain.Fruit;
import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n01.model.repository.FruitRepository;
import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n01.model.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class FruitServiceImpl implements FruitService {

    @Autowired
    private FruitRepository fruitRepository;
    @Override
    public Fruit savefruit(Fruit fruit) {
        fruitRepository.findById(fruit.getId())
                .ifPresent(fruitIn -> {
                    throw new FruitAlreadyExistsException(fruit.getName() + " already exists.");
                });
        return fruitRepository.save(fruit);
    }

    @Override
    public List<Fruit> fetchFruitList() {
        return fruitRepository.findAll();
    }

    public Fruit findOneFruit(Long id) {
        Optional<Fruit> requestedFruit = fruitRepository.findById(id);
        return requestedFruit.orElseThrow(() -> new FruitNotFoundException("Fruit with id: " + id + " not found."));
    }

    @Override
    public Fruit updateFruit(Fruit fruit) {
        Fruit fruitToUpdate = fruitRepository.findById(fruit.getId())
                .orElseThrow(() -> new FruitNotFoundException("Fruit with id: " + id + " does not exist."));
        if (Objects.nonNull((fruit.getName())) && !"".equalsIgnoreCase(fruit.getName())) {
            fruitToUpdate.setName(fruit.getName());
        }
        if (Objects.nonNull((fruit.getQuantityKg()))) {
            fruitToUpdate.setQuantityKg(fruit.getQuantityKg());
        }
        return fruitToUpdate;
    }


    @Override
    public void deleteFruitById(Long id) {
        fruitRepository.findById(id)
                .orElseThrow(() -> new FruitNotFoundException("Fruit with id: " + id + " not found."));
        fruitRepository.deleteById(id);
    }
}
