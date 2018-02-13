package com.ilya.maze;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class SpaceBlueprint {
    final Vector2 dim = new Vector2(20,20);
    Color color;
    Vector2 pos;
    boolean canStand;
    enum Type{
        EMPTY,BLACK,START,FINISH
    }
    Type type;

    protected void setPos(int x,int y){
        pos.set(x,y);
    }

    public void render(ShapeRenderer shapeRenderer){
        shapeRenderer.setColor(color);
        shapeRenderer.rect(pos.x,pos.y,dim.x,dim.y);
    }

}
