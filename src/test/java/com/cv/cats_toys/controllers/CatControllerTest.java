package com.cv.cats_toys.controllers;

import com.cv.cats_toys.services.CatService;
import com.cv.cats_toys.services.CatServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(CatController.class)
class CatControllerTest {

    @MockBean
    private CatServiceImpl catService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void add() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getOne() {
    }

    @Test
    void getCatsByNameAndWeight() {
    }

    @Test
    void getCatsByNameOrWeight() {
    }

    @Test
    void getCatsFatToSmall() {
    }

    @Test
    void getCatsSmallToFat() {
    }

    @Test
    void getCatsByLetter() {
    }

    @Test
    void getAvgWeight() {
    }
}