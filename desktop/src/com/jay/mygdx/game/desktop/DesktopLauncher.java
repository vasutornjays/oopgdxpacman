package com.jay.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jay.mygdx.game.PacmanGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = PacmanGame.WIDTH;
        config.height = PacmanGame.HEIGHT;
        new LwjglApplication(new PacmanGame(), config);
    }
}
