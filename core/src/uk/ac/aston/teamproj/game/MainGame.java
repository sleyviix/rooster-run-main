package uk.ac.aston.teamproj.game;

import java.io.IOException;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import uk.ac.aston.teamproj.game.net.MPServer;
import uk.ac.aston.teamproj.game.screens.MainMenuScreen;
import uk.ac.aston.teamproj.game.screens.MenuScreen;
import uk.ac.aston.teamproj.game.screens.PlayScreen;

public class MainGame extends Game {
	
	/* 
	 * Virtual width and virtual height for our game
	 */
	public static final int V_WIDTH = 400*6;
	public static final int V_HEIGHT = 208*6;
	public static final float PPM = 100*6; // pixels per meter
	
	public SpriteBatch batch;
	
	//category bit for all fixtures 
	public static final short NOTHING_BIT = 0;
	public static final short DEFAULT_BIT = 1;
	public static final short ROOSTER_BIT = 2;
	public static final short BRICK_BIT = 4;
	public static final short BOMB_BIT = 8;
	public static final short DESTROYED_BIT = 16;
	public static final short LIGHTNING_BIT = 32;
	public static final short MUD_BIT = 64;
	public static final short BOUNDARY_BIT = 128;
	public static final short COIN_BIT = 256;
	public static final short PLANE_BIT = 512;
	public static final short ROOSTER_BIT2 = 1024;
	public static final short GROUND_BIT = 2048;


	@Override
	public void create () {
		batch = new SpriteBatch();
		
		if(!MPServer.online)
			try {
				new MPServer();
			} catch (IOException e) {
				e.printStackTrace();
			}
	
		setScreen(new MainMenuScreen(this));
	}
	
	public void startGame() {
		
	}
	
	public void jump() {

	}
	

	public void render () {
		/*
		 * Delegates render method to the play screen or whatever screen is active at that time.
		 */
		super.render();
	

	

	}
}
