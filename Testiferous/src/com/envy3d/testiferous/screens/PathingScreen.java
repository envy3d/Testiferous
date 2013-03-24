package com.envy3d.testiferous.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.envy3d.testiferous.TestiferousGame;
import com.envy3d.testiferous.ai.*;
import com.envy3d.testiferous.logic.*;
import com.envy3d.testiferous.utils.Point2;

/**
 * 
 * @author envy3d
 *
 */

public class PathingScreen extends InputAdapter implements Screen {

	private OrthographicCamera cam;
	private TestiferousGame game;
	//private InputMultiplexer inputMultiplexer;
	private MapGrid mapGrid;
	private Pathfinding aStar;
	private Array<Point2> path;
	private boolean testReady = false;
	private boolean testing = false;;
	public SpriteBatch batch;
	public Texture wallT, startT, endT, pathT;
	public Sprite wallS, startS, endS, pathS;
	private Point2 start, end;
	
	public PathingScreen(TestiferousGame game) {
		this.game = game;
		start = new Point2(0,0);
		end = new Point2(5,5);
	}

	
	@Override
	public void render(float delta) {
		Gdx.gl20.glClearColor(0, 0, 0, 1);
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		
		if (testReady == false) {
			for (int i = 1; i < path.size - 1; i++) {
				pathS.setPosition(path.items[i].x * 16, path.items[i].y * 16);
				pathS.draw(batch);
			}		
		}
		
		for (int i = 0; i < mapGrid.getHeight(); i++) {
			for (int j = 0; j < mapGrid.getWidth(); j++) {
				if (mapGrid.colGrid[i][j] > 1) {
					wallS.setPosition(j * 16, i * 16);
					wallS.draw(batch);
				}
			}
		}
		
		startS.setPosition(start.x * 16, start.y * 16);
		startS.draw(batch);
		endS.setPosition(end.x * 16, end.y * 16);
		endS.draw(batch);
		
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		wallT = new Texture(Gdx.files.internal("data/grey16.png"));
		startT = new Texture(Gdx.files.internal("data/green16.png"));
		endT = new Texture(Gdx.files.internal("data/red16.png"));
		pathT = new Texture(Gdx.files.internal("data/blue16.png"));
		
		wallS = new Sprite(wallT);
		startS = new Sprite(startT);
		endS = new Sprite(endT);
		pathS = new Sprite(pathT);
		
		game.inputMultiplexer.addProcessor(this);
		cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
		cam.update();
		mapGrid = new MapGrid();
		mapGrid.initialize(Gdx.graphics.getHeight() / 16, Gdx.graphics.getWidth() / 16);
		aStar = new Pathfinding();
		aStar.buildNodes(mapGrid);
		
		path = new Array<Point2>(true, 10, Point2.class);
		path.add(new Point2(-100, -100));
		
		batch.setProjectionMatrix(cam.combined);
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		wallT.dispose();
		startT.dispose();
		endT.dispose();
		pathT.dispose();
	}
	
	public void buildTest() {
		mapGrid.initializeRandomly(Gdx.graphics.getHeight() / 16, Gdx.graphics.getWidth() / 16);
		aStar.buildNodes(mapGrid);
		
		start = new Point2(MathUtils.random(mapGrid.getWidth() - 1), MathUtils.random(mapGrid.getHeight()- 1));
		end = new Point2(MathUtils.random(mapGrid.getWidth() - 1), MathUtils.random(mapGrid.getHeight() - 1));
		
		while (mapGrid.colGrid[start.y][start.x] != 1 && mapGrid.colGrid[end.y][end.x] != 1) { 
			start.x = MathUtils.random(mapGrid.getWidth());
			start.y = MathUtils.random(mapGrid.getHeight());
			end.x = MathUtils.random(mapGrid.getWidth());
			end.y = MathUtils.random(mapGrid.getHeight());
		}
	}
	
	public void runPathTest() {
		path = aStar.findPath(start, end);
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if (testReady == false) {
			buildTest();
			testReady = true;
		}
		else {
			runPathTest();
			testReady = false;
		}
		
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
