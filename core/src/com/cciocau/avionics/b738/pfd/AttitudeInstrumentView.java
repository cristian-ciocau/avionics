package com.cciocau.avionics.b738.pfd;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cciocau.avionics.InstrumentView;

public class AttitudeInstrumentView implements InstrumentView {
    private static final float TEXTURE_CENTER_X = 453;
    private static final float TEXTURE_CENTER_Y = 523;
    private static final float PITCH_STEP_PIXELS = 10.75F;

    private final Texture attitudeTexture = new Texture("737-800-pfd-attitude.png");
    private final Sprite attitude;

    private final SpriteBatch batch;

    private final AttitudeInstrument instrument;

    public AttitudeInstrumentView(SpriteBatch batch, AttitudeInstrument instrument) {
        this.batch = batch;

        attitude = new Sprite(attitudeTexture);
        attitude.setOrigin(TEXTURE_CENTER_X, TEXTURE_CENTER_Y);

        this.instrument = instrument;
    }

    @Override
    public void render() {
        final var y = instrument.getPitch() * PITCH_STEP_PIXELS * -1F;
        final var textureOriginY = TEXTURE_CENTER_Y - y;

        attitude.setOrigin(TEXTURE_CENTER_X, textureOriginY);
        attitude.setY(y);
        attitude.setRotation(instrument.getRoll());
        attitude.draw(batch);
    }

    @Override
    public void dispose() {
        attitudeTexture.dispose();
    }
}
