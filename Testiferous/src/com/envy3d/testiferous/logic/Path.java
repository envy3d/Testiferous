package com.envy3d.testiferous.logic;

import com.badlogic.gdx.utils.Array;
//import com.envy3d.testiferous.utils.Point2;

public class Path<T> {

	public Array<T> path;
	private int first, last;
	
	/*public Path(T type) {
		path = new Array<T>(true, 10, type.getClass().);
		first = 0;
		last = 0;
	}*/
	
	public Path(Array<T> array) {
		path = array;
		first = 0;
		last = array.size - 1;
	}
	
	public T popFirst() {
		if (first > last)
			return null;
		else
			return path.items[first++];
	}
	
	public T peekFirst() {
		if (first > last)
			return null;
		else
			return path.items[first];
	}
	
	public T popLast() {
		if (last < first)
			return null;
		else
			return path.items[last];
	}
	
	public T peekLast() {
		if (last < first)
			return null;
		else
			return path.items[last];
	}
	
	public void resetFirst() {
		first = 0;
	}
	
	public void resetLast() {
		last = path.size - 1;
	}
}
