package com.cciocau.avionics.b738.pfd;

import com.cciocau.avionics.Instrument;

public class AttitudeInstrument implements Instrument {
    private long pitch;
    private long roll;

    public long getPitch() {
        return pitch;
    }

    public void setPitch(long pitch) {
        this.pitch = pitch;
    }

    public long getRoll() {
        return roll;
    }

    public void setRoll(long roll) {
        this.roll = roll;
    }
}
