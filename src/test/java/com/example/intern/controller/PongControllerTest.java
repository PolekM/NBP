package com.example.intern.controller;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PongControllerTest {

    @Test
    public void displayPingShouldBeEqualPong(){
        //given
        PongController PongController = new PongController();
        //when
        String shouldBePong = PongController.displayPong();
        //then
        assertThat(shouldBePong, equalTo("Pong"));
    }
}
