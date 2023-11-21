package com.cciocau.avionics.b738.pfd;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cciocau.avionics.AbstractInstrumentView;
import com.cciocau.avionics.InstrumentView;

public class PFDInstrumentView extends AbstractInstrumentView implements InstrumentView {
    private final Texture backgroundTexture = new Texture("737-800-pfd-background.png");

    private final SpriteBatch batch;

    public PFDInstrumentView(SpriteBatch batch, PFDInstrument pfdInstrument) {
        this.batch = batch;
        var attitudeView = new AttitudeInstrumentView(batch, pfdInstrument.getAttitude());
        instruments.add(attitudeView);
    }

    @Override
    public void render() {
        super.render();

        batch.draw(backgroundTexture, 0, 0);
    }

    public void dispose() {
        super.dispose();

        backgroundTexture.dispose();
    }
}
