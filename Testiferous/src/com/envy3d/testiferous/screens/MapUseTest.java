package com.envy3d.testiferous.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.envy3d.testiferous.TestiferousGame;
import com.envy3d.testiferous.actors.Player;
import com.envy3d.testiferous.logic.GameLogic;
import com.envy3d.testiferous.menu.Menu;

/**
 * 
 * @author envy3d
 *
 */

public class MapUseTest extends InputAdapter implements Screen {

	private OrthographicCamera cam;
	private Menu menu;
	private Player player;
	private GameLogic gameLogic;
	private TestiferousGame game;
	private InputMultiplexer inputMultiplexer;
	
	public MapUseTest(TestiferousGame game) {
		this.game = game;
	}
	
	public void initialize(InputMultiplexer inputMultiplexer) {
		this.inputMultiplexer = inputMultiplexer;
	}
	
	@Override
	public void render(float delta) {
		menu.render();
		
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		inputMultiplexer.addProcessor(this);
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
		
	}
	
	

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
