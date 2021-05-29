package com.ping.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.ping.pong.input.KeyListener;
import com.ping.pong.input.Keys;
import org.mini2Dx.core.game.BasicGame;
import org.mini2Dx.core.graphics.Graphics;

public class PingPong extends BasicGame {

    // basic setup and input stuff
	public static final String GAME_IDENTIFIER = "com.ping.pong";
	public static int WIDTH, HEIGHT;

	private Keys keys;

	// object variables




	public static void scoreLeft() {

    }

    public static void scoreRight() {

    }

    public static Vector2 center() {
        return null;
    }

    public static Vector2 initBallVel() {
	    return null;
    }

    public static void score() {

    }

	private int leftPaddleKey = 0, rightPaddleKey = 0;

	@Override
    public void initialise() {
	    // initialize variables here
        Gdx.input.setInputProcessor(new KeyListener());

        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();

        // create objects


    }
    
    @Override
    public void update(float delta) {
        // per-frame updates ====================

        // gets key input
        keys = new Keys(keys);

        // your update code here ======


	}
    
    @Override
    public void interpolate(float alpha) {
        // interpolation if you need it (shouldn't be necessary for what we're doing)

    }
    
    @Override
    public void render(Graphics g) {
	    // draw to the screen


	}
}
