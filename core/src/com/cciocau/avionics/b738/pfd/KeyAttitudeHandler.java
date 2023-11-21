package com.cciocau.avionics.b738.pfd;

import com.badlogic.gdx.Input;
import com.cciocau.avionics.InputHandler;
import com.cciocau.avionics.InputResult;
import com.cciocau.avionics.Key;

public class KeyAttitudeHandler implements InputHandler<Key> {
    private final AttitudeInstrument attitude;

    public KeyAttitudeHandler(AttitudeInstrument attitude) {
        this.attitude = attitude;
    }

    @Override
    public InputResult handle(Key input) {
        switch(input.getKeycode()) {
            case Input.Keys.UP:
                attitude.setPitch( attitude.getPitch() - 1);
                return InputResult.handled();

            case Input.Keys.DOWN:
                attitude.setPitch( attitude.getPitch() + 1);
                return InputResult.handled();

            case Input.Keys.LEFT:
                attitude.setRoll(attitude.getRoll() - 1 );
                return InputResult.handled();

            case Input.Keys.RIGHT:
                attitude.setRoll(attitude.getRoll() + 1 );
                return InputResult.handled();
        }

        return InputResult.notHandled();
    }
}
