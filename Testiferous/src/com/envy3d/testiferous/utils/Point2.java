package com.envy3d.testiferous.utils;

public class Point2 {
	public int x, y;
	
	public Point2() {
		x = 0;
		y = 0;
	}
	
	public Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point2(Point2 point2) {
		this.set(point2.x, point2.y);
	}
	
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void set(Point2 point2) {
		this.set(point2.x, point2.y);
	}
}
