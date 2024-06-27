package cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n02.model.repository;

import cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n02.model.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {
}
