package ua.shykun.delivery.domain;


import javax.persistence.*;

@Entity
@Table(name="pizzas")
public class Pizza {

    public enum PizzaType { VEGETARIAN, SEA, MEAT, CHEESE }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pizza_id")
    private Long id;

    @Column(name="pizza_name")
    private String name;

    @Column(name="pizza_price")
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name="pizza_type")
    private PizzaType type;

    public Pizza() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PizzaType getType() {
        return type;
    }

    public void setType(PizzaType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name + "[" + id + ", " + price + ", " + type + ']';
    }
}
