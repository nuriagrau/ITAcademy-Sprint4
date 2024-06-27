package cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n02.Controllers;

import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n02.model.domain.Fruit;
import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n02.model.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruits")
public class FruitController {

    @Autowired
    private FruitService fruitService;


    //http://localhost:8080/fruita/add
    @PostMapping("/add")
    public ResponseEntity<Fruit> createFruit(@RequestBody Fruit fruit) {
        Fruit addedFruit = fruitService.savefruit(fruit);
        return new ResponseEntity<>(addedFruit, HttpStatus.CREATED);
    }

    //http://localhost:8080/fruita/update
    @PutMapping("/update")
    public ResponseEntity<Fruit> updateFruit(@RequestBody Fruit fruit) {
        Fruit updatedFruit = fruitService.updateFruit(fruit, fruit.getId());
        return new ResponseEntity<>(updatedFruit, HttpStatus.OK);
    }

    //http://localhost:8080/fruita/delete/{id}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFruitById(@PathVariable("id") Long id) {
        fruitService.deleteFruitById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //http://localhost:8080/fruita/getOne/{id}

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> findOneFruit(@PathVariable("id") Long id) {
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
