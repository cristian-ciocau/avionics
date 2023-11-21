package com.cciocau.avionics;

public interface InputHandler<T> {
    InputResult handle(T input);
}
