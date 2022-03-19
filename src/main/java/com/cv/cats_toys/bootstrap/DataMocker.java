package com.cv.cats_toys.bootstrap;

import com.cv.cats_toys.beans.Cat;
import com.cv.cats_toys.beans.Toy;
import com.cv.cats_toys.services.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Component
public class DataMocker implements CommandLineRunner {

    private final CatService catService;

    @Override
    public void run(String... args) throws Exception {
        Cat samir = new Cat("samir", 3.5f, List.of(new Toy("hair tie")));
        Cat verka = new Cat("Verka", 5.6f, List.of(new Toy("Bambi"), new Toy("whip")));
        Cat pinky = new Cat("pinky", 6.1f);
        Cat misty = new Cat("misty", 2.7f);

        catService.addCat(samir);
        catService.addCat(verka);
        catService.addCat(pinky);
        catService.addCat(misty);

        // update
        samir.setWeight(3.6f);
        catService.updateCat(samir);

//        // delete
//        catService.deleteCat(4);

        // get all
        System.out.println("all: " + catService.getAllCats());

        // get one
        System.out.println("one: " + catService.getOneCat(3));

        // name && weight
        System.out.println("name+weight: " + catService.getCatsByNameAndWeight(samir.getName(), samir.getWeight()));

        // name || weight
        System.out.println("name || weight: " + catService.getCatsByNameOrWeight("Verka", 3.6f));

        // desc
        System.out.println("fat to small: " + catService.getCatsFatToSmall());

        // asc
        System.out.println("small to fat: " + catService.getCatsSmallToFat());

        // by let
        System.out.println("letter: " + catService.getCatsByLetter("p"));

        // avg weight
        System.out.println("avg: " + catService.getAvgWeight());

    }
}
