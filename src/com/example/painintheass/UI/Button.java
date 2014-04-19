package com.example.painintheass.UI;


public abstract class Button extends Widget{
	public Button(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public Button(int x, int y, int width, int height,int backgroundImage, int highlighted, int grayed, int click) {
		super(x, y, width, height, backgroundImage, highlighted, grayed, click);
	}

	
	public abstract void onClick(UIManager myUIM);

	
	
	
}
