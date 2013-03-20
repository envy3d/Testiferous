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
		path = new Array<Point2>();
		frontier = new BinaryHeap<PFPoint>();
		width = 0;
		height = 0;
	}
	
	public void buildNodes(MapGrid map) {
		if (map != null && (width != map.getWidth() && height != map.getHeight())) {
			width = map.getWidth();
			height = map.getHeight();
			nodeMap = new PFPoint[width * height];
		}
		
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
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {	
				if (j > 0)
					nodeMap[(i * height) + j].addNeighbor(nodeMap[(i * height) + j - 1]);
				else if (j < width - 1)
					nodeMap[(i * height) + j].addNeighbor(nodeMap[(i * height) + j + 1]);
				else if (i > 0)
					nodeMap[(i * height) + j].addNeighbor(nodeMap[((i - 1) * height) + j]);
				else if (i < height - 1)
					nodeMap[(i * height) + j].addNeighbor(nodeMap[((i + 1) * height) + j]);
			}
		}
		
	}
	
	/**
	 * Builds and returns a path.
	 * 
	 * @param start
	 * @param end
	 * @return The path with the end location at index 0 and the start location at the end
	 */
	public Array<Point2> findPath(Point2 start, Point2 end) {
		nodeMap[(start.y * height) + start.x].costG = nodeMap[(start.y * height) + start.x].locCost;
		frontier.add(nodeMap[(start.y * height) + start.x]);
		
		while (nodeMap[(end.y * height) + end.x].explored == false) {
			if (frontier.size != 0)
				exploreNode(frontier.pop(), end);
			else
				break;
		}
		
		buildPath(nodeMap[(end.y * height) + end.x]);
		while (frontier.size != 0) {
			frontier.pop().resetReversed();
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
	
	private void exploreNode(PFPoint node, Point2 end) {
		for (int i = 0; i < node.neighborsLength(); i++) {
			if (node.neighbors[i].explored == false && node.neighbors[i].costG > (node.costG + node.neighbors[i].locCost)) {
				frontier.add(node.neighbors[i]);
				node.neighbors[i].costG = node.neighbors[i].locCost + node.costG;
				node.neighbors[i].costH = distanceToEnd(node.neighbors[i].pos, end);
				frontier.setValue(node.neighbors[i], node.neighbors[i].costG + node.neighbors[i].costH);
			}
		}
		node.explored = true;
	}
	
	private int distanceToEnd(Point2 node, Point2 end) {
		return (int) Math.sqrt((node.x - end.x) * (node.x - end.x) + (node.y - end.y) * (node.y - end.y)) - 1;
	}
}
