package com.envy3d.testiferous.screens;

import com.badlogic.gdx.Screen;
import com.envy3d.testiferous.TestiferousGame;
import com.envy3d.testiferous.actors.Map;
import com.envy3d.testiferous.actors.Player;
import com.envy3d.testiferous.logic.MapGrid;
import com.envy3d.testiferous.utils.Point2;

public class GameScreen implements Screen {
	
	public TestiferousGame game;
	private final int framesBetweenPathFinds = 10;
	private int currentFrameBetweenPathFinds = 0;
	
	public Player player;
	public Map map;
	public MapGrid mapGrid;

	public GameScreen(TestiferousGame game) {
		this.game = game;
	}
	
	@Override
	public void render(float delta) {
		currentFrameBetweenPathFinds++;
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public void findPath(int screenX, int screenY) {
		currentFrameBetweenPathFinds = 0;
		Point2 virtualCoords = convertCoords(screenX, screenY);
		
		
	}
	
	public void tryFindPath(int screenX, int screenY) {
		if (currentFrameBetweenPathFinds >= framesBetweenPathFinds)
			findPath(screenX, screenY);		
	}
	
	public Point2 convertCoords(int screenX, int screenY) {
		return new Point2(screenX / game.pixelMultiplier, screenY / game.pixelMultiplier);
	}
	
}
