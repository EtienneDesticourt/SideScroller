package com.example.painintheass.UI.widgets;

import java.util.Date;

import com.example.painintheass.UI.UIManager;

/**
 * Represents a Button Widget.
 * A Button is a Widget that can be clicked.
 */
public abstract class Button extends Widget{
	private boolean clicked = false;
	private long firstClicked = 0;
	
	/**
	 * Creates a Button.
	 * @param x Position on x axis
	 * @param y Position on y axis
	 * @param width Width of the button
	 * @param height Height of the button
	 */
	public Button(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	/**
	 * Creates a Button.
	 * @param x Position on the x axis
	 * @param y Position on the y axis
	 * @param width Width of the button
	 * @param height Height of the button
	 * @param backgroundImage Index of the background bitmap
	 * @param highlighted Index of the highlighted bitmap
	 * @param grayed Index of the grayed bitmap
	 * @param click Index of the clicked bitmap
	 */
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
