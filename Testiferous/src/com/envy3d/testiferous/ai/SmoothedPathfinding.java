package com.envy3d.testiferous.ai;

import com.envy3d.testiferous.logic.Path;

public class SmoothedPathfinding {

	private Pathfinding pathfinding;
	private Path smoothedPath;
	
	public SmoothedPathfinding(int[][] map) {
		pathfinding = new Pathfinding(map);
	}
	
	public Path createPath() {
		smoothedPath = new Path();
	}
}
