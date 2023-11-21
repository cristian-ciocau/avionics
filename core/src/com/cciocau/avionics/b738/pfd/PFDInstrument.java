package com.cciocau.avionics.b738.pfd;

import com.cciocau.avionics.Instrument;

public class PFDInstrument implements Instrument {
    private final AttitudeInstrument attitude;

    public PFDInstrument(AttitudeInstrument attitude) {
        this.attitude = attitude;
    }

    public AttitudeInstrument getAttitude() {
        return attitude;
    }
}
