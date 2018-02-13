package com.ilya.maze;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player implements InputProcessor {

    Main main;
    Rectangle body;
    Vector2 pos;
    Vector2 dim;
    Color color;

    public Player(Main main){
        this.main = main;
        Gdx.input.setInputProcessor(this);
        pos = new Vector2(0,0);
        dim = new Vector2(20,20);
        color = new Color();
        color.set(Color.RED);
        setBody();
    }

    private void setBody(){
        body = new Rectangle(pos.x,pos.y,dim.x,dim.y);
    }

    public void setPos(int x,int y){
        pos.x = x;
        pos.y = y;
    }

    public void update(){
        body.set(pos.x,pos.y,dim.x,dim.y);
    }

    public void render(ShapeRenderer shapeRenderer){
        update();
        shapeRenderer.setColor(color);
        shapeRenderer.rect(body.x,body.y,body.width,body.height);
    }

    @Override
    public boolean keyDown(int keycode) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.R))
            main.rebuildStage();
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP))
            pos.y+=20;
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN))
            pos.y-=20;
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT))
            pos.x-=20;
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT))
            pos.x+=20;
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

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
