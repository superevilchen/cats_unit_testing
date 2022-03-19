package com.cv.cats_toys.services;

import com.cv.cats_toys.beans.Cat;
import com.cv.cats_toys.exceptions.CatException;
import com.cv.cats_toys.exceptions.ExceptionState;
import com.cv.cats_toys.exceptions.ExceptionUtils;
import com.cv.cats_toys.repos.CatRepository;
import com.cv.cats_toys.repos.ToyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatServiceImpl implements CatService{

    private final CatRepository catRepository;

    @Override
    public void addCat(Cat cat) throws CatException{
        if (catRepository.existsById(cat.getId())) ExceptionUtils.alreadyExists();

        catRepository.save(cat);
    }

    @Override
    public void updateCat(Cat cat) throws CatException {
        if (!catRepository.existsById(cat.getId())){
            ExceptionUtils.idNotFound();
        }

        catRepository.saveAndFlush(cat);
    }

    @Override
    public void deleteCat(int id) {
        if (!catRepository.existsById(id)) ExceptionUtils.idNotFound();

        catRepository.deleteById(id);
    }

    @Override
    public List<Cat> getAllCats() {
        return catRepository.findAll();
    }

    @Override
    public Cat getOneCat(int id) throws CatException {
        return catRepository.findById(id).orElseThrow(ExceptionUtils::idNotFound);
    }

    @Override
    public List<Cat> getCatsByNameAndWeight(String name, float weight) {
        if (weight < 0){
            ExceptionUtils.invalidRequest();
        }
        return catRepository.findByNameAndWeight(name, weight);
    }

    @Override
    public List<Cat> getCatsByNameOrWeight(String name, float weight) {
        if (weight < 0){
            ExceptionUtils.invalidRequest();
        }
        return catRepository.findByNameOrWeight(name, weight);
    }

    @Override
    public List<Cat> getCatsFatToSmall() {
        return catRepository.findByOrderByWeightDesc();
    }

    @Override
    public List<Cat> getCatsSmallToFat() {
        return catRepository.findByOrderByWeightAsc();
    }

    @Override
    public List<Cat> getCatsByLetter(String letter) {

        return catRepository.findByNameStartingWith(letter);
    }

    @Override
    public double getAvgWeight() {
        return catRepository.getAvgWeight();
    }
}
