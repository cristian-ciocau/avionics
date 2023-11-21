package com.cciocau.avionics;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractInstrumentView implements InstrumentView {
    protected List<InstrumentView> instruments = new ArrayList<>();

    @Override
    public void render() {
        instruments.forEach(InstrumentView::render);
    }

    @Override
    public void dispose() {
        instruments.forEach(InstrumentView::dispose);
    }
}
