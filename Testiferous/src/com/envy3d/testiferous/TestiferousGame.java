package com.envy3d.testiferous;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.envy3d.testiferous.menu.Menu;
import com.envy3d.testiferous.screens.Accuracy;
import com.envy3d.testiferous.screens.GameScreen;
import com.envy3d.testiferous.screens.PathingScreen;

public class TestiferousGame extends Game {
	
	public static final String VERSION = "0.0.1";
	public static final String LOG = "Testiferous";
	
	public InputMultiplexer inputMultiplexer;
	public Menu menu;
	public boolean loading;
	public int virtualScreenWidth, virtualScreenHeight;
	public int pixelMultiplier;
	/*private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	*/
	
	@Override
	public void create() {		
		loading = false;
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		float tempDim = (h > w) ? h : w;
		
		pixelMultiplier = (int)((tempDim / 1025) + 1);
		virtualScreenWidth = (int)(w / pixelMultiplier);
		virtualScreenHeight = (int)(h / pixelMultiplier);
		
		/*camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		
		sprite = new Sprite(region);
		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		*/
		this.inputMultiplexer = new InputMultiplexer();
		Gdx.input.setInputProcessor(inputMultiplexer);
		menu = new Menu(this);
		
		setScreen(new GameScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
		/*batch.dispose();
		texture.dispose();
		*/
	}

	@Override
	public void render() {	
		super.render();
		/*Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		sprite.draw(batch);
		batch.end();
		*/
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
