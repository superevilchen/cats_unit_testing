package com.cv.cats_toys.repos;

import com.cv.cats_toys.beans.Toy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToyRepository extends JpaRepository<Toy, Integer> {
}
