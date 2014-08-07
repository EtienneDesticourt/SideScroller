package com.example.painintheass.UI.widgets;

import com.example.painintheass.UI.UIManager;

/**
 * Represents a Label.
 * A Label is a simple Widget with a background image and a position.
 */
public class Label extends Widget{
	
	public Label(int x, int y, int backgroundImage) {
		super(x, y, 10,10);
		this.setBackgroundImage(backgroundImage);
	}

	@Override
	public void onClick(UIManager myUIM) {
		
	}
	
	public boolean isOver(int[] pos){
		return false;
	}
	
}
