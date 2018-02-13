package com.ilya.maze;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

public class Main extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
    OrthographicCamera camera;
    ShapeRenderer shapeRenderer;
    SpaceBlueprint gameSpace[][];
    Player player;


	@Override
	public void create () {
		batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        camera = new OrthographicCamera();
        camera.setToOrtho(false);
        //Gdx.input.setInputProcessor(this);
        player = new Player(this);
        gameSpace = createSpace();


	}

    public void rebuildStage(){
        gameSpace = createSpace();
    }



    private SpaceBlueprint[][] createSpace(){
        SpaceBlueprint[][] space = new SpaceBlueprint[32][24];
        int x = -20;
        int y;

        createFinAndStart(space);

        for (int i = 0;i<32;i++) {
            x+=20;
            y=-20;
            for (int j = 0; j < 24; j++) {
                try {
                    if (space[i][j].type == SpaceBlueprint.Type.START ||
                            space[i][j].type == SpaceBlueprint.Type.FINISH)
                        continue;
                } catch (NullPointerException e){

                }
                y+=20;
                SpaceBlueprint square = null;
                switch (MathUtils.random(0, 1)) {
                    case 0: {
                        square = new EmptyRec();
                        square.setPos(x,y);
                        break;
                    }
                    case 1: {
                        square = new BlackRec();
                        square.setPos(x,y);
                        break;
                    }
                }
                space[i][j] = square;
            }
        }


        return space;
    }

    private void createFinAndStart(SpaceBlueprint[][] space){
        int i = MathUtils.random(0,31);
        int j = MathUtils.random(0,23);
        int x,y;
        SpaceBlueprint startRec = new StartRec();
        FinishRec finishRec = new FinishRec();
        if (MathUtils.random(0,1)==0) {
            x = 20*i;
            y = 0;
            space[i][0] = startRec;
            space[31-i][23] = finishRec;
        }
        else {
            x = 0;
            y = 20*j;
            space[0][j] = startRec;
            space[31][23-j] = finishRec;
        }

        startRec.setPos(x,y);
        finishRec.setCameraPos(camera);
        finishRec.setStartRec((StartRec) startRec);
        finishRec.setPos();

//        for (int k = 0;k<32;k++)
//            for(int v = 0;v<24;v++)
//                if (space[k][v].pos.x==finishRec.pos.x&&
//                        space[k][v].pos.y==finishRec.pos.y)
//                    space[k][v] = finishRec;
        player.setPos((int) startRec.pos.x,(int) startRec.pos.y);
        System.out.println("X "+startRec.pos.x+" Y "+startRec.pos.y);


    }

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        createLines();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for (int i = 0;i<32;i++)
            for (int j = 0;j<24;j++)
                gameSpace[i][j].render(shapeRenderer);
        player.render(shapeRenderer);
        shapeRenderer.end();
		batch.begin();
		batch.end();
	}

    private void createLines(){
        int x;
        int y;
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        for (x = 0;x<camera.viewportWidth;x+=20)
            shapeRenderer.line(x,0,x,camera.viewportHeight);
        for (y = 0;y<camera.viewportHeight;y+=20)
            shapeRenderer.line(0,y,camera.viewportWidth,y);
        shapeRenderer.end();
    }

    @Override
    public boolean keyDown(int keycode) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.R))
            rebuildStage();
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
