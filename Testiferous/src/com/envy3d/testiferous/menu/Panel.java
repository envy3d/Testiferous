package com.envy3d.testiferous.menu;

import com.badlogic.gdx.utils.ArrayMap;

public class Panel {
	
	public int x, y, width, height;
	public int state = 0;   // 0 = default, 1 = touched, 2 = released, 3 = unavailable, 4+ = special
	
	private Panel parent = null;
	private ArrayMap<String, Panel> children;
	
	public boolean eatsBubblingInput;
	
	public Panel(String name, int x, int y, int width, int height, int state, boolean eatsInput, Panel parent, ArrayMap<String, Panel> children) {
		children = new ArrayMap<String, Panel>(false, 8);
		this.parent = parent;
		if (children != null) {
			this.children.addAll(children);
		}
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.state = state;
		eatsBubblingInput = eatsInput;
	}
	
	/**
	 * 
	 * @param mouseX
	 * @param mouseY
	 * @param click 1 = pressed, 2 = released, 3 = dragged 
	 * @return
	 */
	
	public Panel update(int mouseX, int mouseY, int click) {
		if (click == 3) {
			
		}	
		else if ((mouseX >= x && mouseX <= (x + width)) && (mouseY >= y && mouseY <= y + height)) {
			if (click == 1) {
				for (int i = 0, n = children.values.length; i < n; i++) {
					if (children.values[i] != null && children.values[i].update(mouseX, mouseY, 1) != null)
						return children.values[i];
				}		
				/*
				 *  Do stuff?
				 */
				if (eatsBubblingInput)
					return this;
				else
					return null;
			}
			else if (click == 2) {
				
				return null;
			}
			else 
				return null;
		}
		if (click == 2) {
			
		}
		return null;
	}
	
	public void destroy() {
		removeChildren();
		
	}
	
	public void addChild(String name, Panel child) {
		children.put(name, child);
	}
	
	public void removeChildren() {
		for (int i = 0, n = children.values.length; i < n; i++) {
			if (children.values[0] != null)
				children.values[i].destroy();
		}
		children.clear();
	}
	
	public boolean removeChild(String name) {
		int index = children.indexOfKey(name);
		children.getValueAt(index).destroy();
		return (children.removeKey(name) != null) ? true : false;
	}
	
	public boolean removeChild(Panel child) {
		int index = children.indexOfValue(child, true);
		children.getValueAt(index).destroy();
		return children.removeValue(child, true);
	}
	
}
