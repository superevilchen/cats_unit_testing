package com.cv.cats_toys.controllers;

import com.cv.cats_toys.beans.Cat;
import com.cv.cats_toys.exceptions.CatException;
import com.cv.cats_toys.services.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v2/cats/")
public class CatController {

    private final CatService catService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@Valid @RequestBody Cat cat) throws CatException {
        catService.addCat(cat);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable int id, @Valid @RequestBody Cat cat) throws CatException {
        catService.updateCat(cat);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        catService.deleteCat(id);
    }

    @GetMapping
    public List<Cat> getAll(){
        return catService.getAllCats();
    }

    @GetMapping("{id}")
    public Cat getOne(@PathVariable int id) throws CatException {
        return catService.getOneCat(id);
    }

    @GetMapping("and")
    public List<Cat> getCatsByNameAndWeight(@RequestParam String name, @Valid @RequestParam float weight){
        return catService.getCatsByNameAndWeight(name, weight);
    }

    @GetMapping("or")
    public List<Cat> getCatsByNameOrWeight(@RequestParam String name, @Valid @RequestParam float weight){
        return catService.getCatsByNameOrWeight(name, weight);
    }

    @GetMapping("fat/small")
    public List<Cat> getCatsFatToSmall(){
        return catService.getCatsFatToSmall();
    }

    @GetMapping("small/fat")
    public List<Cat> getCatsSmallToFat(){
        return catService.getCatsSmallToFat();
    }

    @GetMapping("by")
    public List<Cat> getCatsByLetter(@RequestParam String letter){
        return catService.getCatsByLetter(letter);
    }

    @GetMapping("avg")
    public double getAvgWeight(){
        return catService.getAvgWeight();
    }


}
