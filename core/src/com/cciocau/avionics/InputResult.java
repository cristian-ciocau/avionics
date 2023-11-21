package com.cciocau.avionics;

public class InputResult {
    private final boolean handled;

    public InputResult(boolean handled) {
        this.handled = handled;
    }

    public static InputResult handled() {
        return new InputResult(true);
    }

    public static InputResult notHandled() {
        return new InputResult(false);
    }

    public boolean isHandled() {
        return handled;
    }
}
