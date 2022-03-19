package com.cv.cats_toys.repos;

import com.cv.cats_toys.beans.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CatRepository extends JpaRepository<Cat, Integer> {

    List<Cat> findByNameAndWeight(String name, float weight);

    List<Cat> findByNameOrWeight(String name, float weight);

    List<Cat> findByOrderByWeightDesc();

    List<Cat> findByOrderByWeightAsc();

    List<Cat> findByNameStartingWith(String letter);

    @Query(value = "SELECT AVG(weight) from cats", nativeQuery = true)
    double getAvgWeight();
}
