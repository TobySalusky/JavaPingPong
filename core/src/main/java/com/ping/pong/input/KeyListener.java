package com.ping.pong.input;

import com.badlogic.gdx.InputProcessor;

import java.util.HashMap;
import java.util.HashSet;

public class KeyListener implements InputProcessor {

    private static HashSet<Integer> keysDown = new HashSet<Integer>();

    public static HashSet<Integer> getKeysDown() {
        return new HashSet<Integer>(keysDown);
    }

    @Override
    public boolean keyDown(int keycode) {
        keysDown.add(keycode);
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        keysDown.remove(keycode);
        return true;
    }


    // UNUSED ============
    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
