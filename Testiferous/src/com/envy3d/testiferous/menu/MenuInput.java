package com.envy3d.testiferous.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureAdapter;

public class MenuInput extends GestureAdapter {
	
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
		
		return false;
	}
	
	public boolean tap(int screenX, int screenY, int count, int button) {
		
		return false;
	}
}
