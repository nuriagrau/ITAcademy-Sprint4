package cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n02.model.services.impl;

import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n02.exceptions.FruitAlreadyExistsException;
import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n02.exceptions.FruitNotFoundException;
import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n02.model.domain.Fruit;
import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n02.model.repository.FruitRepository;
import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n02.model.services.FruitService;
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
        fruitRepository.findById(fruit.getId())
                .ifPresent(fruitIn -> {
                    throw new FruitAlreadyExistsException(fruit.getName() + " already exists." );
                });
        return fruitRepository.save(fruit);
    }

    @Override
    public List<Fruit> fetchFruitList() {
        return (List<Fruit>)fruitRepository.findAll();
    }

    public Fruit findOneFruit(int id) {
        Optional<Fruit> requestedFruit = fruitRepository.findById(id);
        return requestedFruit.orElseThrow(() -> new FruitNotFoundException("Fruit with id: " + id + " not found."));
    }

    @Override
    public Fruit updateFruit(Fruit fruit, int id) throws NullPointerException {
        Fruit newFruit = fruitRepository.findById(id).get();
        if (newFruit != null) {
            if (Objects.nonNull((fruit.getName())) && !"".equalsIgnoreCase(fruit.getName())) {
                newFruit.setName(fruit.getName());
            }
            if (Objects.nonNull((fruit.getQuantityKg()))) {
                newFruit.setQuantityKg(fruit.getQuantityKg());
            }
            return fruitRepository.save(newFruit);
        } else {
            throw new NullPointerException();
        }
    }


    @Override
    public void deleteFruitById(int id) {
        fruitRepository.findById(id)
                .orElseThrow(() -> new FruitNotFoundException("Fruit with id: " + id + " not found."));
        fruitRepository.deleteById(id);
    }
}
