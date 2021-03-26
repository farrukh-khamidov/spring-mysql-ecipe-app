package guru.springframework.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal amount;

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure uom;

    @ManyToOne
    private Recipe recipe;

    public Ingredient() {
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure oum) {
        this.description = description;
        this.amount = amount;
        this.uom = oum;
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure oum, Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.uom = oum;
        this.recipe = recipe;
    }

}
