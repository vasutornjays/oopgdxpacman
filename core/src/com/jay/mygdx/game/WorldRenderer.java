package com.jay.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	
	World world;
	private PacmanGame pacmanGame;
	private Pacman pacman;
	private Texture pacmanImg;
	private MazeRenderer mazeRenderer;
	public static final int BLOCK_SIZE = 40;
	
	public WorldRenderer(PacmanGame pacmanGame, World world) {
		SpriteBatch batch = pacmanGame.batch;
        this.pacmanGame = pacmanGame;
        batch = pacmanGame.batch;
        pacman = world.getPacman(); 
        this.world = world;
        mazeRenderer = new MazeRenderer(pacmanGame.batch, world.getMaze());
        pacmanImg = new Texture("pacman.png");
    }
	
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	mazeRenderer.render();
    	SpriteBatch batch = pacmanGame.batch;
        Vector2 pos = world.getPacman().getPosition();
        batch.begin();
        batch.draw(pacmanImg, pos.x - BLOCK_SIZE/2, 
                PacmanGame.HEIGHT - pos.y - BLOCK_SIZE/2);
        batch.end();
    }

}
