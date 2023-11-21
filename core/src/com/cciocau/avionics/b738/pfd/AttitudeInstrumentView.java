package com.cciocau.avionics.b738.pfd;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cciocau.avionics.InstrumentView;

public class AttitudeInstrumentView implements InstrumentView {
    private final Texture attitudeTexture = new Texture("737-800-pfd-attitude.png");
    private final Sprite attitude;

    private final SpriteBatch batch;

    private final AttitudeInstrument instrument;

    public AttitudeInstrumentView(SpriteBatch batch, AttitudeInstrument instrument) {
        this.batch = batch;

        attitude = new Sprite(attitudeTexture);
        attitude.setOrigin(452, attitudeTexture.getHeight() / 2F);

        this.instrument = instrument;
    }

    @Override
    public void render() {
        attitude.setRotation(instrument.getRoll() * -1);
        attitude.draw(batch);
    }

    @Override
    public void dispose() {
        attitudeTexture.dispose();
    }
}
