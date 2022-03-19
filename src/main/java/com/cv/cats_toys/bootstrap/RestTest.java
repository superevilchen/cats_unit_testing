package com.cv.cats_toys.bootstrap;

import com.cv.cats_toys.beans.Cat;
import com.cv.cats_toys.beans.Toy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class RestTest implements CommandLineRunner {

    @Autowired
    private RestTemplate restTemplate;

    private final String URL = "http://localhost:8080/api/v2/cats/";

    @Override
    public void run(String... args) throws Exception {

        /// add
        Cat cat = new Cat(10, "Emile", 10f, List.of(new Toy("kaka")));
        ResponseEntity<String> add = restTemplate.postForEntity(URL, cat, String.class);
        System.out.println(add.getStatusCodeValue() == 201 ? "yayyy" : "nayyyy");

        // update
        cat.setWeight(11f);

        HttpEntity catHttpEntity = new HttpEntity(cat);
        ResponseEntity<String> update = restTemplate.exchange(URL+10, HttpMethod.PUT, catHttpEntity, String.class);
        System.out.println(update.getStatusCode().is2xxSuccessful() ? "yay updated" : " nay");

        // delete
        ResponseEntity<String> delete = restTemplate.exchange(URL+1, HttpMethod.DELETE, null, String.class);
        System.out.println(delete.getStatusCode().is2xxSuccessful() ? "delete" : "nay");

        // get all
        Cat[] all = restTemplate.getForObject(URL, Cat[].class);
        System.out.println(Arrays.toString(all));

        ResponseEntity<String> allCats = restTemplate.getForEntity(URL, String.class);
        System.out.println(allCats.getStatusCode().is2xxSuccessful() ? "yay" : "nay");

        // get one
        Cat one = restTemplate.getForObject(URL+2, Cat.class);
        System.out.println(one);

        // getCatsByNameAndWeight
        Cat[] getCatsByNameAndWeight = restTemplate.getForObject(URL+"and?name=pinky&weight=6.1", Cat[].class);
        System.out.println(Arrays.toString(getCatsByNameAndWeight));

        // getCatsByNameOrWeight
        Cat[] getCatsByNameOrWeight = restTemplate.getForObject(URL+"or?name=pinky&weight=2.7", Cat[].class);
        System.out.println(Arrays.toString(getCatsByNameOrWeight));

        // getCatsFatToSmall
        Cat[] getCatsFatToSmall = restTemplate.getForObject(URL+"fat/small", Cat[].class);
        System.out.println(Arrays.toString(getCatsFatToSmall));

        // getCatsSmallToFat
        Cat[] getCatsSmallToFat = restTemplate.getForObject(URL+"small/fat", Cat[].class);
        System.out.println(Arrays.toString(getCatsSmallToFat));

        // getCatsByLetter
        Cat[] getCatsByLetter = restTemplate.getForObject(URL+"by?letter=p", Cat[].class);
        System.out.println(Arrays.toString(getCatsByLetter));

        // getAvgWeight
        double getAvgWeight = restTemplate.getForObject(URL+"avg", Double.class);
        System.out.println(getAvgWeight);
    }
}
