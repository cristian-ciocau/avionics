package com.cciocau.avionics;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.cciocau.avionics.b738.pfd.AttitudeInstrument;
import com.cciocau.avionics.b738.pfd.KeyAttitudeHandler;
import com.cciocau.avionics.b738.pfd.PFDInstrument;
import com.cciocau.avionics.b738.pfd.PFDInstrumentView;

import java.util.ArrayList;
import java.util.List;

public class Avionics extends ApplicationAdapter {
	private Camera camera;
	private Viewport viewport;

	private SpriteBatch batch;

	private final List<InstrumentView> instruments = new ArrayList<>();
	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		viewport = new FitViewport(1024, 1024, camera);

		batch = new SpriteBatch();

		// create everything else
		var attitude = new AttitudeInstrument();
		var attitudeHandler = new KeyAttitudeHandler(attitude);

		ChainInputHandler<Key> chainHandler = new ChainInputHandler<>();
		chainHandler.addHandler(attitudeHandler);

		var handler = new KeyboardInput(chainHandler);
		Gdx.input.setInputProcessor(handler);

		instruments.add(new PFDInstrumentView(batch, new PFDInstrument(attitude)));
	}

	@Override
	public void render () {
		camera.update();
		ScreenUtils.clear(0, 0, 0, 1);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();

		// render everything else
		instruments.forEach(InstrumentView::render);

		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
		camera.position.set(camera.viewportWidth / 2,camera.viewportHeight / 2,0);
	}
	
	@Override
	public void dispose () {
		batch.dispose();

		// dispose everything else
		instruments.forEach(InstrumentView::dispose);
	}
}
