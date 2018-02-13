package com.ilya.maze;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class EmptyRec extends SpaceBlueprint {

    public EmptyRec(){
        color = Color.WHITE;
        type = Type.EMPTY;
        canStand = true;
        pos = new Vector2();

    }

}
