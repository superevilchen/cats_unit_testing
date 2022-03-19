package com.cv.cats_toys.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="toys")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 40)
    private String name;

    public Toy(String name) {
        this.name = name;
    }
}
