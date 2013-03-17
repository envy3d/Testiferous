package com.envy3d.testiferous.ai;


import com.badlogic.gdx.utils.BinaryHeap.Node;
import com.envy3d.testiferous.utils.Point2;

public class PFPoint extends Node {

	public Point2 pos;
	public int locCost, costG, costH;
	public PFPoint[] neighbors;
	public PFPoint parent;
	private int neighborsLength, maxNeighbors;
	public boolean explored;
	private final int costGDefault = 1000000;
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param cost
	 * @param neighbors
	 */
	public PFPoint(int x, int y, int cost, PFPoint[] neighbors) {
		super(0);
		pos = new Point2(x, y);
		locCost = cost;
		this.neighbors = neighbors;
		costG = costGDefault;
		costH = 0;
		parent = null;
		maxNeighbors = neighbors.length;
		neighborsLength = maxNeighbors;
		explored = false;
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param cost
	 * @param numOfNeighbors
	 */
	public PFPoint(int x, int y, int cost, int numOfNeighbors) {
		super(0);
		pos = new Point2(x, y);
		locCost = cost;
		this.maxNeighbors = numOfNeighbors;
		this.neighbors = new PFPoint[this.maxNeighbors];
		for (int i = 0; i < this.maxNeighbors; i++) {
			neighbors[i] = null;
		}
		costG = costGDefault;
		costH = 0;
		parent = null;
		neighborsLength = 0;
		explored = false;
	}
	
	public void setParent(PFPoint parent) {
		this.parent = parent;
		explored = true;
	}
	
	/**
	 * Recursively resets the used PFPoints
	 * Call from the Start node. 
	 */
	public void reset() {
		parent = null;
		explored = false;
		costG = costGDefault;
		costH = 0;
		for (int i = 0; i < neighborsLength; i++) {
			if (neighbors[i].explored == true)
				neighbors[i].reset();
		}
	}
	
	/**
	 * Recursively resets toward the Start node.
	 */
	public void resetReversed() {
		explored = false;
		costG = costGDefault;
		costH = 0;
		parent.resetReversed();
		parent = null;
	}
	
	/**
	 * BEWARE: Can silently fail!
	 * 
	 * @param neighbor
	 */
	public void addNeighbor(PFPoint neighbor) {
		if (neighborsLength < maxNeighbors && neighbor != null) {
			neighbors[neighborsLength] = neighbor;
			neighborsLength++;
		}
	}
	
	public int neighborsLength() {
		return neighborsLength;
	}
}
