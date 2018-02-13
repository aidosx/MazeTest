package com.ilya.maze;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class StartRec extends SpaceBlueprint {

    public StartRec(){
        color = Color.FOREST;
        type = Type.START;
        canStand = true;
        pos = new Vector2();

    }
}
