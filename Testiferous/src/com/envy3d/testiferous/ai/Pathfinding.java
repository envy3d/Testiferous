package com.envy3d.testiferous.ai;

import com.badlogic.gdx.utils.BinaryHeap;
import com.badlogic.gdx.utils.Array;
import com.envy3d.testiferous.logic.MapGrid;
import com.envy3d.testiferous.utils.Point2;

public class Pathfinding {
	
	public BinaryHeap<PFPoint> frontier;
	//public PFPoint startNode;
	public PFPoint[] nodeMap;
	private int width, height;
	public Array<Point2> path;
	
	public Pathfinding() {
		
	}
	
	public void buildNodes(MapGrid map) {
		width = map.getWidth();
		height = map.getHeight();
		nodeMap = new PFPoint[width * height];
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {	
				if ((j == 0 || j == width - 1) && (i == 0 || i == height - 1))
					nodeMap[(i * height) + j] = new PFPoint(i, j, map.colGrid[i][j], 2);
				else if ((j == 0 || j == width - 1) || (i == 0 || i == height - 1))
					nodeMap[(i * height) + j] = new PFPoint(i, j, map.colGrid[i][j], 3);
				else
					nodeMap[(i * height) + j] = new PFPoint(i, j, map.colGrid[i][j], 4);
			}
		}
		
		path = new Array<Point2>();
		frontier = new BinaryHeap<PFPoint>();
	}
	
	public Array<Point2> findPath(Point2 start, Point2 end) {
		nodeMap[(start.y * height) + start.x].costG = nodeMap[(start.y * height) + start.x].locCost;
		
		while (nodeMap[(end.y * height) + end.x].explored == false) {
			exploreNode(frontier.pop());
		}
		
		return path;
	}
	
	private void buildPath(PFPoint end) {
		path.clear();
		while(end != null) {
			path.add(end.pos);
			end = end.parent;
		}
	}
	
	private void exploreNode(PFPoint node) {
		for (int i = 0; i < node.neighborsLength(); i++) {
			if (node.neighbors[i].explored == false && node.neighbors[i].costG > (node.costG + node.neighbors[i].locCost)) {
				frontier.add(node.neighbors[i]);
				
			}
		}
		node.explored = true;
	}
}
