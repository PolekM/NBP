package com.example.intern.dto.sorting;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SortingDto {

    private ArrayList<Integer> numbers;
    private String order;


}
