package com.ping.pong.input;

import java.util.HashSet;

public class Keys {

    private HashSet<Integer> keysDown, lastKeysDown;

    public Keys(Keys lastKeys) {

        keysDown = KeyListener.getKeysDown();

        if (lastKeys == null) {
            lastKeysDown = new HashSet<Integer>();
        } else {
            lastKeysDown = lastKeys.keysDown;
        }
    }

    public boolean up(int keycode) {
        return !keysDown.contains(keycode);
    }

    public boolean down(int keycode) {
        return keysDown.contains(keycode);
    }

    public boolean justDown(int keycode) {
        return keysDown.contains(keycode) && !lastKeysDown.contains(keycode);
    }

    public boolean justUp(int keycode) {
        return !keysDown.contains(keycode) && lastKeysDown.contains(keycode);
    }
}
