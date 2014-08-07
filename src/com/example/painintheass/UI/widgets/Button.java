package com.example.painintheass.UI.widgets;

import java.util.Date;

import com.example.painintheass.UI.UIManager;


public abstract class Button extends Widget{
	private boolean clicked = false;
	private long firstClicked = 0;
	
	public Button(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public Button(int x, int y, int width, int height,int backgroundImage, int highlighted, int grayed, int click) {
		super(x, y, width, height, backgroundImage, highlighted, grayed, click);
	}

	
	
	public void onClickWrap(UIManager myUIM){
		setFirstClicked(new Date().getTime());
		setClicked(true);
		onClick(myUIM);
	}
	
	public abstract void onClick(UIManager myUIM);

	public boolean isClicked() {
		return clicked;
	}

	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

	public long getFirstClicked() {
		return firstClicked;
	}

	public void setFirstClicked(long firstClicked) {
		this.firstClicked = firstClicked;
	}

	
	
	
}
