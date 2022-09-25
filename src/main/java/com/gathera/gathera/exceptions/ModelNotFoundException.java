package com.gathera.gathera.exceptions;

public class ModelNotFoundException extends RuntimeException {
    public ModelNotFoundException() {
        super("Model not found for the given id!");
    }
}
