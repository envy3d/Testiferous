package com.envy3d.testiferous.menu;

import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureAdapter;

public class MenuInput extends GestureAdapter {
	
	public GestureDetector gestureDetector;
	/*
	 * Stuff for later
	 * 
	 */
	
	public MenuInput() {
		
	}
	
	public boolean Initialize() {
		gestureDetector = new GestureDetector(this);		
		return (gestureDetector != null) ? true : false;
	}
	
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		return false;
	}
	
	public boolean tap(int screenX, int screenY, int count, int button) {
		
		return false;
	}
}
