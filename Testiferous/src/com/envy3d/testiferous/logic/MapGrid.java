package com.envy3d.testiferous.logic;

/**
 * A grid which holds data about whether a location is open or closed
 * 
 * @author envy3d
 */

public class MapGrid {
	
	public int[][] colGrid;
	
	public MapGrid() {

	}
	
	/**
	 * Creates the 2 dimensional array and set the values to 0
	 * 
	 * @param height
	 * @param width
	 */
	public void Initialize(int height, int width) {
		colGrid = new int[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				colGrid[i][j] = 0;
			}
		}
	}
	
	public void Initialize(int[][] colGrid) {
		this.colGrid = colGrid;
	}
	
	
}
