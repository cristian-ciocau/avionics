package com.cciocau.avionics.b738.pfd;

import com.cciocau.avionics.Instrument;

public class AttitudeInstrument implements Instrument {
    private float pitch;
    private float roll;

    public float getPitch() {
        return pitch;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public float getRoll() {
        return roll;
    }

    public void setRoll(float roll) {
        this.roll = roll;
    }
}
