package com.cv.cats_toys.repos;

import com.cv.cats_toys.beans.Cat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CatRepositoryTest {

    @Autowired
    private CatRepository catRepository;

    @AfterEach
    void tearDown() {
        catRepository.deleteAll();
    }

    @Test
    void findByNameAndWeight() {
        Cat a = new Cat("maran", 6f);
        catRepository.saveAndFlush(a);

        List<Cat> result = catRepository.findByNameAndWeight("maran", 6f);

        assertEquals(List.of(a), result);
    }

    @Test
    void findByNameOrWeight() {
        Cat a = new Cat("maran", 6f);
        catRepository.saveAndFlush(a);

        List<Cat> result = catRepository.findByNameOrWeight("maran", 5f);

        assertEquals(List.of(a), result);
    }

    @Test
    void findByOrderByWeightDesc() {
        Cat a = new Cat("maran", 6f);
        Cat b = new Cat("matan", 4f);
        catRepository.saveAll(List.of(a, b));

        List<Cat> result = catRepository.findByOrderByWeightDesc();

        assertEquals(List.of(a, b), result);
    }

    @Test
    void findByOrderByWeightAsc() {
        Cat a = new Cat("maran", 6f);
        Cat b = new Cat("matan", 4f);
        catRepository.saveAll(List.of(a, b));

        List<Cat> result = catRepository.findByOrderByWeightAsc();

        assertEquals(List.of(b, a), result);
    }

    @Test
    void findByNameStartingWith() {
        Cat a = new Cat("maran", 6f);
        catRepository.saveAndFlush(a);

        List<Cat> result = catRepository.findByNameStartingWith("m");

        assertEquals(List.of(a), result);
    }

    @Test
    void getAvgWeight() {
        Cat a = new Cat("maran", 6f);
        Cat b = new Cat("matan", 4f);
        catRepository.saveAll(List.of(a, b));

        double result = catRepository.getAvgWeight();

        assertEquals((a.getWeight() + b.getWeight())/2, result);
    }
}