package com.cv.cats_toys.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Table(name = "cats")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 40)
    private String name;

    @Min(1)
    private float weight;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Toy> toys;

    public Cat(String name, float weight, List<Toy> toys) {
        this(0, name, weight, toys);
    }

    public Cat(String name, float weight){
        this(0, name, weight, null);
    }
}
