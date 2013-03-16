package com.envy3d.testiferous.menu;

import com.badlogic.gdx.InputMultiplexer;
import com.envy3d.testiferous.TestiferousGame;

public class Menu {
	
	private TestiferousGame game;
	public MenuInput menuInput;
	private Panel[] menuPages;
	private boolean visible;
	private int current
	private InputMultiplexer inputMultiplexer;
	
	public Menu(TestiferousGame game) {
		this.game = game;
		
		visible = false;
	}
	
	public boolean initialize(InputMultiplexer inputMultiplexer) {
		menuInput = new MenuInput();
		return menuInput.initialize(inputMultiplexer);	
	}
	
	public boolean setMenu(String menuSetUp) {
		return false;
	}
	
	public void clearMenu() {
		for (int i = 0; i < menuPages.length; i++) {
			if (menuPages[i] != null)
				menuPages[i].destroy();
		}
	}
	
	public void hide() {
		visible = false;
	}
	
	public void show() {
		visible = true;
	}
	
	public void update() {
		
	}
	
	public void render() {
		if (visible) {
			
		}
	}
	
	public void destroy() {
		menuInput.destroy();
	}
}
