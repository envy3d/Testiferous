package com.envy3d.testiferous.ai;

import com.badlogic.gdx.utils.Array;
import com.envy3d.testiferous.logic.Path;
import com.envy3d.testiferous.utils.Point2;

public class SmoothedPathfinding {

	private Pathfinding pathfinding;
	private Path smoothedPath;
	
	public SmoothedPathfinding(int[][] map) {
		pathfinding = new Pathfinding();
	}
	
	//public Path createPath() {
	//	smoothedPath = new Path();
	//}
	
	public boolean detectTurn(Array<Point2> nodes, int loc) {
		if (loc == 0 || loc == nodes.size - 1) {
			return false;
		}
		else {
			if ((nodes.items[loc].x - nodes.items[loc + 1].x) * (nodes.items[loc].y - nodes.items[loc - 1].y) != 0 ||
				(nodes.items[loc].x - nodes.items[loc - 1].x) * (nodes.items[loc].y - nodes.items[loc + 1].y) != 0)   {
				return true;
			}
			else
				return false;
		}
	}
}
