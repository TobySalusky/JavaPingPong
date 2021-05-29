package com.ping.pong;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import org.mini2Dx.core.graphics.Graphics;

public class Ball {

    public float radius = 10;
    public Vector2 pos, vel;

    public Ball(Vector2 pos, Vector2 vel) {
        this.pos = pos;
        this.vel = vel;
    }

    public void update(float delta) {
        pos.add(vel.cpy().scl(delta));

        if (pos.y - radius <= 0 || pos.y + radius >= PingPong.HEIGHT) vel.scl(new Vector2(1, -1));

        if (pos.x + radius <= 0) PingPong.scoreRight();
        if (pos.x - radius >= PingPong.WIDTH) PingPong.scoreLeft();
    }

    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillCircle(pos.x, pos.y, radius);
    }
}
