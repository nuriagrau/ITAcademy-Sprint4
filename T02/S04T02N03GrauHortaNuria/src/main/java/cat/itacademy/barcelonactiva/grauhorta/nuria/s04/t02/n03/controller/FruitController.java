package cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n03.controller;

import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n03.exception.FruitNotFoundException;
import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n03.model.domain.Fruit;
import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n03.model.services.impl.FruitServiceImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/fruit")
public class FruitController {

    @Autowired
    private FruitServiceImpl fruitService;


    //http://localhost:8080/fruita/add
    @PostMapping("/add")
    public ResponseEntity<Fruit> createFruit(@RequestBody Fruit fruit) {
           Fruit newFruit = fruitService.savefruit(fruit);

           return new ResponseEntity<>(newFruit, HttpStatus.CREATED);
    }

    //http://localhost:8080/fruita/update
    @PutMapping("/update")
    public ResponseEntity<Fruit> updateFruit(@RequestBody Fruit fruit) {
            Fruit updatedFruit = fruitService.updateFruit(fruit);

            return new ResponseEntity<>(updatedFruit, HttpStatus.OK);
    }

    //http://localhost:8080/fruita/delete/{id}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFruitById(@PathVariable("id") ObjectId id) {
        fruitService.deleteFruitById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //http://localhost:8080/fruita/getOne/{id}

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> findOneFruit(@PathVariable("id") ObjectId id) throws FruitNotFoundException {
        Fruit fruitData = fruitService.findOneFruit(id);

        return new ResponseEntity<>(fruitData, HttpStatus.OK);
    }

    //http://localhost:8080/fruita/getAll
    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> fetchFruitList() {
        List<Fruit> fruits = fruitService.fetchFruitList();

        return new ResponseEntity<>(fruits, HttpStatus.OK);
    }


}
