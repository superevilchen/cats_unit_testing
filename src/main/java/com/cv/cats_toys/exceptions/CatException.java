package com.cv.cats_toys.exceptions;

import lombok.Getter;

public class CatException extends Exception{

    @Getter private ExceptionState state;

    public CatException(ExceptionState state) {
        this.state = state;
    }
}
