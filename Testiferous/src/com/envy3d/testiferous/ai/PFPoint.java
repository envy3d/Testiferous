package com.envy3d.testiferous.ai;

import com.badlogic.gdx.utils.BinaryHeap.Node;

public class PFPoint extends Node {

	public int x, y, locCost, costG, costH;
	public PFPoint[] neighbors;
	public PFPoint parent;
	private int highestNeighborIndex, numOfNeighbors;
	public boolean explored;
	
	public PFPoint(int x, int y, int cost, PFPoint[] neighbors) {
		super(0);
		this.x = x;
		this.y = y;
		locCost = cost;
		this.neighbors = neighbors;
		costG = 0;
		costH = 0;
		parent = null;
		numOfNeighbors = neighbors.length;
		highestNeighborIndex = numOfNeighbors;
		explored = false;
	}
	
	public PFPoint(int x, int y, int cost, int numOfNeighbors) {
		super(0);
		this.x = x;
		this.y = y;
		locCost = cost;
		this.numOfNeighbors = numOfNeighbors;
		this.neighbors = new PFPoint[this.numOfNeighbors];
		for (int i = 0; i < this.numOfNeighbors; i++) {
			neighbors[i] = null;
		}
		costG = 0;
		costH = 0;
		parent = null;
		highestNeighborIndex = 0;
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
		costG = 0;
		costH = 0;
		for (int i = 0; i < highestNeighborIndex; i++) {
			if (neighbors[i].explored == true)
				neighbors[i].reset();
		}
	}
	
	/**
	 * BEWARE: Can silently fail!
	 * 
	 * @param neighbor
	 */
	public void addNeighbor(PFPoint neighbor) {
		if (highestNeighborIndex < numOfNeighbors && neighbor != null) {
			neighbors[highestNeighborIndex] = neighbor;
			highestNeighborIndex++;
		}
	}
}
