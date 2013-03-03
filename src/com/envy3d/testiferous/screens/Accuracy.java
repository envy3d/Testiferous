package com.envy3d.testiferous.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.envy3d.testiferous.TestiferousGame;

public class Accuracy extends InputAdapter implements Screen {
	
	private TestiferousGame game;
	private OrthographicCamera camera;
	private SpriteBatch spriteBatch;
	private Texture[] textures;
	private Sprite[] sprites;
	private ShapeRenderer shapeRender;
	private int[][] locs;
	private Vector2 touchLoc;
	
	public Accuracy(TestiferousGame game) {
		this.game = game;
	}
	
	@Override
	public void render(float delta) {
		
		shapeRender.setProjectionMatrix(camera.combined);
		shapeRender.begin(ShapeType.FilledCircle);
		for (int i = 0; i < locs.length / 2; i++) {
			shapeRender.setColor(0.3f, 0.9f, 1.0f / i, 1);
			shapeRender.filledCircle(locs[i][0], locs[i][1], locs[i][2], 20);
			if (Math.pow(touchLoc.x - locs[i][0], 2) + Math.pow(touchLoc.y - locs[i][1], 2) <= locs[i][2] * locs[i][2]) {
				Gdx.input.vibrate(80);
				Gdx.app.log("Tester", "Hit Circle");
			}
		}
		shapeRender.end();
		shapeRender.begin(ShapeType.FilledRectangle);
		for (int i = locs.length / 2; i < locs.length; i++) {
			shapeRender.setColor(1.0f / i, 0.8f, 0.3f, 1);
			shapeRender.filledRect(locs[i][0], locs[i][1], locs[i][2], locs[i][2]);
			if (touchLoc.x >= locs[i][0] && touchLoc.x <= locs[i][0] + locs[i][2]
				&& touchLoc.y >= locs[i][1] && touchLoc.y <= locs[i][1] + locs[i][2]) {
				Gdx.input.vibrate(80);
				Gdx.app.log("Tester", "Hit Square");
			}
		}
		shapeRender.end();
		
		touchLoc.x = 0;
		touchLoc.y = 0;
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
		camera.update();
		shapeRender = new ShapeRenderer();
		
		int locations[][] = {{100, 100, 12}, {200, 100, 16}, {300, 100, 24}, {400, 100, 32},
						     {100, 300, 24}, {200, 300, 32}, {300, 300, 48}, {400, 300, 64}};
		locs = locations;
		touchLoc = new Vector2();
		touchLoc = Vector2.Zero;
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		shapeRender.dispose();
	}
	
	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		//if (0 == pointer) {
			touchLoc.x = x;
			touchLoc.y = Math.abs(y - Gdx.graphics.getHeight());
			Gdx.app.log("Tester", "Touch at: " + x + ", " + y);
		//}
		return true;
	}
}
