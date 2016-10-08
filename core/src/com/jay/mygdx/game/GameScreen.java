package com.jay.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {
	
	private PacmanGame pacmanGame;
	private Pacman pacman;
	World world;
	private WorldRenderer worldRenderer;
	 
    public GameScreen(PacmanGame pacmanGame) {
        this.pacmanGame = pacmanGame;
        world = new World(pacmanGame);
        worldRenderer = new WorldRenderer(pacmanGame,world);
        pacman = world.getPacman();
    }
    
    @Override
    public void render(float delta) {
    	update(delta);
    	if(Pacman.Score == 128){
    		System.out.println("End");
    	}
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
 
        worldRenderer.render(delta);
    }
    
    private void update(float delta) {
    	updatePacmanDirection();
    	world.update(delta);
    }
    
    private void updatePacmanDirection() {
    	if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            pacman.setNextDirection(Pacman.DIRECTION_LEFT);
        }
    	if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            pacman.setNextDirection(Pacman.DIRECTION_RIGHT);
        }
    	if(Gdx.input.isKeyPressed(Keys.DOWN)) {
            pacman.setNextDirection(Pacman.DIRECTION_DOWN);
        }
    	if(Gdx.input.isKeyPressed(Keys.UP)) {
            pacman.setNextDirection(Pacman.DIRECTION_UP);
        }
    	if((!Gdx.input.isKeyPressed(Keys.UP))& (!Gdx.input.isKeyPressed(Keys.DOWN))&
    			(!Gdx.input.isKeyPressed(Keys.LEFT))&(!Gdx.input.isKeyPressed(Keys.RIGHT)))
    	{
    	pacman.setNextDirection(Pacman.DIRECTION_STILL);
    	}
    }

}
