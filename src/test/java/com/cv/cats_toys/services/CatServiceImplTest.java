package com.cv.cats_toys.services;

import com.cv.cats_toys.beans.Cat;
import com.cv.cats_toys.exceptions.CatException;
import com.cv.cats_toys.repos.CatRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CatServiceImplTest {

    @Mock
    private CatRepository catRepository;

    @Autowired
    @InjectMocks
    private CatServiceImpl catService;

    @Captor
    private ArgumentCaptor<Cat> catArgumentCaptor;

    @Test
    void addCat() throws CatException {
        Cat a = new Cat(10,"emile", 10f, List.of());
        catService.addCat(a);

        verify(catRepository).saveAndFlush(catArgumentCaptor.capture());
        Cat captored = catArgumentCaptor.getValue();

        assertEquals(a, captored);
    }

    @Test
    @DisplayName("add cat that already exists")
    void addExistingCat() throws CatException {
        Cat a = new Cat(10,"emile", 10f, List.of());
        catService.addCat(a);

        given(catRepository.existsById(10)).willReturn(true);

        assertThatThrownBy(() -> catService.addCat(a)).isInstanceOf(CatException.class);

        verify(catRepository, never()).save(a);
    }

    @Test
    void updateCat() throws CatException {
        Cat a = new Cat(10,"emile", 10f, List.of());
        catService.addCat(a);

        a.setWeight(11f);
        verify(catRepository).saveAndFlush(catArgumentCaptor.capture());
        Cat result = catArgumentCaptor.getValue();

        assertEquals(a, result);
    }

    @Test
    void deleteCat() throws CatException {

    }


    @Test
    void getAllCats() {
        catService.getAllCats();

        verify(catRepository).findAll();
    }

    @Test
    void getOneCat() throws CatException {
        Cat a = new Cat(10,"emile", 10f, List.of());

        given(catRepository.findById(10)).willReturn(Optional.of(a));

        catService.getOneCat(10);
        verify(catRepository).findById(10);
    }

    @Test
    void getCatsByNameAndWeight() {
        catService.getCatsByNameAndWeight("maran", 5f);
        verify(catRepository).findByNameAndWeight("maran", 5f);
    }

    @Test
    void getCatsByNameOrWeight() {
        catService.getCatsByNameOrWeight("maran", 5f);
        verify(catRepository).findByNameOrWeight("maran", 5f);
    }

    @Test
    void getCatsFatToSmall() {
        catService.getCatsFatToSmall();
        verify(catRepository).findByOrderByWeightDesc();
    }

    @Test
    void getCatsSmallToFat() {
        catService.getCatsSmallToFat();
        verify(catRepository).findByOrderByWeightAsc();
    }

    @Test
    void getCatsByLetter() {
        catService.getCatsByLetter("m");
        verify(catRepository).findByNameStartingWith("m");
    }

    @Test
    void getAvgWeight() {
        catService.getAvgWeight();
        verify(catRepository).getAvgWeight();
    }
}