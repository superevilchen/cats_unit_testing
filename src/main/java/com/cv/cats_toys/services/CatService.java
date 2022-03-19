package com.cv.cats_toys.services;

import com.cv.cats_toys.beans.Cat;
import com.cv.cats_toys.exceptions.CatException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CatService {

    void addCat(Cat cat) throws CatException;
    void updateCat(Cat cat) throws CatException;
    void deleteCat(int id);
    List<Cat> getAllCats();
    Cat getOneCat(int id) throws CatException;
    List<Cat> getCatsByNameAndWeight(String name, float weight);
    List<Cat> getCatsByNameOrWeight(String name, float weight);
    List<Cat> getCatsFatToSmall();
    List<Cat> getCatsSmallToFat();
    List<Cat> getCatsByLetter(String letter);
    double getAvgWeight();
}
