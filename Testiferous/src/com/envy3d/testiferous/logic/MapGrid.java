package com.envy3d.testiferous.logic;

import com.badlogic.gdx.math.MathUtils;

/**
 * A grid which holds data about whether a location is open or closed
 * 
 * @author envy3d
 */

public class MapGrid {
	
	public int[][] colGrid;
	private int width, height;
	
	public MapGrid() {

	}
	
	/**
	 * Creates the 2 dimensional array and set the values to 0
	 * 
	 * @param height
	 * @param width
	 */
	public void initialize(int height, int width) {
		this.width = width;
		this.height = height;
		colGrid = new int[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				colGrid[i][j] = 0;
			}
		}
	}
	
	public void initialize(int[][] colGrid) {
		this.colGrid = colGrid;
	}
	
	public void initializeRandomly(int height, int width) {
		this.width = width;
		this.height = height;
		int solidTile = width * height;
		colGrid = new int[height][];
		for (int i = 0; i < height; i++) {
			colGrid[i] = new int[width];
			for (int j = 0; j < width; j++) {
				colGrid[i][j] = (MathUtils.random(1) * solidTile) + 1;
			}
		}
		
		for (int i = 1; i < height - 1; i++) {
			for (int j = 1; j < width - 1; j++) {
				if (colGrid[i][j] > 1) {
					if (colGrid[i][j-1] != 1 || colGrid[i][j+1] != 1 || colGrid[i-1][j] != 1 || colGrid[i+1][j] != 1)
						colGrid[i][j] = 1;
				}
			}
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
