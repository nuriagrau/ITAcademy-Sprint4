package cat.itacademy.barcelonactiva.grauhorta.nuria.s04.t02.n02.model.domain;

import jakarta.persistence.*;

@Entity
public class Fruit {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;

        private String name;

        private int quantityKg;

        public Fruit(String name, int quantityKg) {
            this.name = name;
            this.quantityKg = quantityKg;
        }

        public Fruit() {}

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getQuantityKg() {
            return quantityKg;
        }

        public void setQuantityKg(int quantityKg) {
            this.quantityKg = quantityKg;
        }

}
