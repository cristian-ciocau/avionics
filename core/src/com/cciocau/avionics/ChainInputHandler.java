package com.cciocau.avionics;

import java.util.ArrayList;
import java.util.List;

public class ChainInputHandler<T> implements InputHandler<T> {
    private final List<InputHandler<T>> handlers = new ArrayList<>();

    @Override
    public InputResult handle(T input) {
        return handlers.stream()
                .map(handler -> handler.handle(input))
                .filter(InputResult::isHandled)
                .findFirst()
                .orElse(InputResult.notHandled());
    }

    public void addHandler(InputHandler<T> handler) {
        handlers.add(handler);
    }
}
