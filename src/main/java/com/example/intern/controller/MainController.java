package com.example.intern.controller;

import com.example.intern.dto.sorting.NumbersDto;
import com.example.intern.dto.sorting.SortingDto;
import com.example.intern.exception.MainControllerException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

@RestController
public class MainController {


    @PostMapping("/numbers/sort-command")
    public NumbersDto sortedList(@RequestBody SortingDto sortingDto) throws MainControllerException {
        Optional.ofNullable(sortingDto.getNumbers()).orElseThrow(() -> new MainControllerException("Lista nie może przyjmować wartości null"));
        if (sortingDto.getNumbers().size() <= 0) {
            throw new MainControllerException("Lista nie może być pusta");
        }
        ArrayList<Integer> numbers = sortingDto.getNumbers();
        switch (sortingDto.getOrder()) {
            case "ASC":
                Collections.sort(numbers);
                break;
            case "DESC":
                Collections.sort(numbers);
                Collections.reverse(numbers);
                break;
            default:
                throw new MainControllerException("Order przyjmuje wartości ASC i DESC");
        }
        return numbersDto(sortingDto);
    }

    public NumbersDto numbersDto(SortingDto sortingDto) {

        NumbersDto numbersDto = new NumbersDto();
        numbersDto.setNumbers(sortingDto.getNumbers());
        return numbersDto;
    }
}
