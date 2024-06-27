package cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n03.model.repository;

import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n03.model.domain.Fruit;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FruitRepository extends MongoRepository<Fruit, ObjectId> {

    Optional<Fruit> findByNameIgnoreCase (String name);

}
