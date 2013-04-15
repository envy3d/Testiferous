package com.envy3d.testiferous.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureAdapter;

public class MenuInput extends GestureAdapter implements InputProcessor {
	
	private GestureDetector gestureDetector;
	private InputMultiplexer inputMultiplexer;
	/*
	 * Stuff for later
	 * 
	 */
	
	public MenuInput() {
		
	}
	
	public boolean initialize(InputMultiplexer inputMultiplexer) {
		this.inputMultiplexer = inputMultiplexer;
		gestureDetector = new GestureDetector(this);
		inputMultiplexer.addProcessor(gestureDetector);
		return (gestureDetector != null) ? true : false;
	}
	
	public void destroy() {
		inputMultiplexer.removeProcessor(gestureDetector);
	}
	
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		return true;
	}
	
	public boolean tap(int screenX, int screenY, int count, int button) {
		
		return true;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return true;
	}
}
