package com.cciocau.avionics.b738.pfd;

import com.badlogic.gdx.Input;
import com.cciocau.avionics.InputHandler;
import com.cciocau.avionics.InputResult;
import com.cciocau.avionics.Key;

public class KeyAttitudeHandler implements InputHandler<Key> {
    private static final float ONE_DEGREE = 1.0F;
    private static final float HALF_DEGREE = 0.5F;

    private final AttitudeInstrument attitude;

    public KeyAttitudeHandler(AttitudeInstrument attitude) {
        this.attitude = attitude;
    }

    @Override
    public InputResult handle(Key input) {
        switch(input.getKeycode()) {
            case Input.Keys.UP:
                attitude.setPitch( attitude.getPitch() - HALF_DEGREE);
                return InputResult.handled();

            case Input.Keys.DOWN:
                attitude.setPitch( attitude.getPitch() + HALF_DEGREE);
                return InputResult.handled();

            case Input.Keys.LEFT:
                attitude.setRoll(attitude.getRoll() - ONE_DEGREE);
                return InputResult.handled();

            case Input.Keys.RIGHT:
                attitude.setRoll(attitude.getRoll() + ONE_DEGREE);
                return InputResult.handled();
        }

        return InputResult.notHandled();
    }
}
