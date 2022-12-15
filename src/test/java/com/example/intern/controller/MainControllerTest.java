package com.example.intern.controller;


import com.example.intern.dto.sorting.NumbersDto;
import com.example.intern.dto.sorting.SortingDto;
import com.example.intern.exception.MainControllerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MainControllerTest {

    private MainController mainController;
    @BeforeEach
    public void initEach(){
        mainController = new MainController();
    }


    @Test
    public void sortedListWithASCParamShouldReturnSortedList() throws MainControllerException {
        //given
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1,3,6,10,5));
        SortingDto sortingDto = new SortingDto(integers, "ASC");

        //when
        NumbersDto sortedIntegers = mainController.sortedList(sortingDto);

        //then
        assertThat(sortedIntegers.getNumbers(),contains(1,3,5,6,10));
    }
    @Test
    public void sortedListWithDESCParamShouldReturnSortedList() throws MainControllerException {
        //given
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1,3,6,10,5));
        SortingDto sortingDto = new SortingDto(integers, "DESC");

        //when
        NumbersDto sortedIntegers = mainController.sortedList(sortingDto);

        //then
        assertThat(sortedIntegers.getNumbers(),contains(10,6,5,3,1));
    }

    @Test
    public void sortedListWithEmptyListShouldThrowException() throws MainControllerException {
        //given
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList());
        SortingDto sortingDto = new SortingDto(integers, "DESC");

        //when


        //then
        assertThrows(MainControllerException.class,() -> mainController.sortedList(sortingDto));

    }
    @Test
    public void sortedListWithNullListShouldThrowException(){
        //given
        SortingDto sortingDto = new SortingDto(null, "DESC");
        //when

        //then
        assertThrows(MainControllerException.class,() -> mainController.sortedList(sortingDto));
    }
    @Test
    public void sortedListWithWrongOrderParamShouldThrowException(){
        //given
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1,3,6,10,5));
        SortingDto sortingDto = new SortingDto(integers, "WRONG");
        //when

        //then
        assertThrows(MainControllerException.class,() -> mainController.sortedList(sortingDto));
    }

}