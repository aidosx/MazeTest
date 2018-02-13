package com.ilya.maze;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class BlackRec extends SpaceBlueprint {

    public BlackRec(){
        color = Color.BLACK;
        type = Type.BLACK;
        canStand = false;
        pos = new Vector2();
    }


}
