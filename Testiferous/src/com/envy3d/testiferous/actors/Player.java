package com.envy3d.testiferous.actors;

import com.badlogic.gdx.Game;
import com.envy3d.testiferous.ai.Pathfinding;
import com.envy3d.testiferous.logic.Path;
import com.envy3d.testiferous.utils.Point2;


/**
 * The huge Player class filled with all sorts of crap.
 * 
 * @author envy3d
 *
 */

public class Player {
	
	public Point2 virtualPosition;
	public Point2 currentTile;
	public Point2 targetTileCoords;
	public Path path;
	public Pathfinding pathing;
	public Game game;
	
	
	public Player() {
		
	}
	
	public boolean Initialize() {
		return true;
	}
	
	
	
}
