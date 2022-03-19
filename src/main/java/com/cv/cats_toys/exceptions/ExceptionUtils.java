package com.cv.cats_toys.exceptions;

import static com.cv.cats_toys.exceptions.ExceptionState.*;

public class ExceptionUtils {

    public static CatException idNotFound() {
        return new CatException(NOT_FOUND);
    }

    public static void alreadyExists() throws CatException {
        throw new CatException(ALREADY_EXISTS);
    }

    public static CatException invalidRequest(){
        return new CatException(INVALID_REQUEST);
    }
}
