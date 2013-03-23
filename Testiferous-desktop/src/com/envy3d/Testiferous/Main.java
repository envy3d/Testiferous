package com.envy3d.Testiferous;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.envy3d.testiferous.TestiferousGame;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Testiferous";
		cfg.useGL20 = true;
		cfg.width = 480;
		cfg.height = 360;
		
		new LwjglApplication(new TestiferousGame(), cfg);
	}
}
