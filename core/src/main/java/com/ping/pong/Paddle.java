package com.ping.pong;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import org.mini2Dx.core.graphics.Graphics;


public class Paddle {

    Vector2 pos, dimension;

    int speed = 500;

    public Paddle(Vector2 pos, Vector2 dimension) {

        this.pos = pos;
        this.dimension = dimension;

    }

    public void update(float delta, boolean up, boolean down) {

        int movement = 0;
        if (up) movement = -1;
        if (down) movement = 1;

        pos.y += speed * movement * delta;
        pos.y = Math.max(Math.min(pos.y, PingPong.HEIGHT - dimension.y/2 - 10), dimension.y/2 + 10);

        Ball ball = PingPong.ball;
        if (Math.signum(ball.vel.x) == Math.signum(pos.x - PingPong.WIDTH/2F) && collidesWith(ball)) {
            ball.vel.x *= -1.2F;
            ball.vel.y += speed * movement;
            ball.vel.y = Math.min(400, Math.max(-400, ball.vel.y));
        }
    }

    public boolean collidesWith(Ball ball) {
        return (ball.pos.x + ball.radius >= pos.x - dimension.x/2 &&
                ball.pos.x - ball.radius <= pos.x + dimension.x/2 &&
                ball.pos.y + ball.radius >= pos.y - dimension.y/2 &&
                ball.pos.y - ball.radius <= pos.y + dimension.y/2);
    }

    public void render(Graphics g) {

        g.setColor(Color.WHITE);
        g.fillRect((int)(pos.x - dimension.x / 2f), (int)(pos.y - dimension.y / 2f), dimension.x, dimension.y);
    }
}
