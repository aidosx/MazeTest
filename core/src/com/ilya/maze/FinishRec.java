package com.ilya.maze;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class FinishRec extends SpaceBlueprint {


    private StartRec startRec;
    private OrthographicCamera camera;

    public FinishRec(){
        color = Color.YELLOW;
        type = Type.FINISH;
        canStand = true;
        pos = new Vector2();
    }

    @Override
    protected void setPos(int x, int y) {
        setPos();
    }

    public void setPos() {
        int x = (int) (camera.viewportWidth-startRec.pos.x);
        int y = (int) (camera.viewportHeight-startRec.pos.y);
        super.setPos(x-20,y-20);
    }

    public void setStartRec(StartRec startRec) {
        this.startRec = startRec;
    }

    public void setCameraPos(OrthographicCamera camera) {
        this.camera = camera;
    }

}
