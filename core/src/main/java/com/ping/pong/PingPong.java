package com.ping.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.ping.pong.input.KeyListener;
import com.ping.pong.input.Keys;
import org.mini2Dx.core.font.GameFont;
import org.mini2Dx.core.game.BasicGame;
import org.mini2Dx.core.graphics.Graphics;

public class PingPong extends BasicGame {
	public static final String GAME_IDENTIFIER = "com.ping.pong";
	public static int WIDTH, HEIGHT;

	private Keys keys;
	private Paddle left, right;

	public static Ball ball;

	public static int leftScore, rightScore;
	public static int nextBallSpawnDirection = 1;

	public static void scoreLeft() {
	    leftScore++;
	    score();
    }

    public static void scoreRight() {
        rightScore++;
        score();
    }

    public static Vector2 center() {
	    return new Vector2(WIDTH/2F, HEIGHT/2F);
    }

    public static Vector2 initBallVel() {
	    Vector2 vel = new Vector2(150 * nextBallSpawnDirection, 150);
	    nextBallSpawnDirection *= -1;
	    return vel;
    }

    public static void score() {
	    ball.pos = center();
	    ball.vel = initBallVel();
    }

	private int leftPaddleKey = 0, rightPaddleKey = 0;

	@Override
    public void initialise() {
	    // initialize variables here
        Gdx.input.setInputProcessor(new KeyListener());

        WIDTH = Gdx.graphics.getWidth();
        HEIGHT = Gdx.graphics.getHeight();

        ball = new Ball(center(), initBallVel());

        left = new Paddle(new Vector2(40, HEIGHT / 2), new Vector2(20, 100));
        right = new Paddle(new Vector2(WIDTH - 40, HEIGHT / 2), new Vector2(20, 100));
    }
    
    @Override
    public void update(float delta) {
        // per-frame updates ====================

        // gets key input
        keys = new Keys(keys);

        // your update code here ======

        ball.update(delta);

        left.update(delta, keys.down(Input.Keys.W), keys.down(Input.Keys.S));
        right.update(delta, keys.down(Input.Keys.UP), keys.down(Input.Keys.DOWN));
	}
    
    @Override
    public void interpolate(float alpha) {
        // interpolation if you need it (shouldn't be necessary for what we're doing)

    }
    
    @Override
    public void render(Graphics g) {
	    // draw to the screen
        g.setColor(Color.WHITE);
        g.drawLineSegment(WIDTH / 2, 0, WIDTH / 2, HEIGHT);
        g.drawString("" + leftScore, WIDTH * 1f / 4, 20);
        g.drawString("" + rightScore, WIDTH * 3f / 4, 20);

        ball.render(g);

		left.render(g);
		right.render(g);

	}
}
