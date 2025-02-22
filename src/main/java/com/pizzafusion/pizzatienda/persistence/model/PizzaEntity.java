package com.pizzafusion.pizzatienda.persistence.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
@Setter
@Getter
@Entity
@Table(name = "pizza")
@NoArgsConstructor
public class PizzaEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pizza", nullable = false)
    private Integer idPizza;

    @Column(nullable = false, length = 30, unique = true)
    private String name;

    @Column(nullable = false, length = 150 )
    private String description;

    @Column(nullable = false, columnDefinition = "Decimal(5,2)")
    private double price;

    @Column(columnDefinition = "TINYINT")
    private int vegetarian;

    @Column(columnDefinition = "TINYINT")
    private int vegan;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private int available;

    @Override
    public String toString() {
        return "PizzaEntity{" +
                "idPizza=" + idPizza +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", vegetarian=" + vegetarian +
                ", vegan=" + vegan +
                ", available=" + available +
                '}';
    }

}