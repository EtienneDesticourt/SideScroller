package com.example.painintheass.UI.widgets;

import android.graphics.Paint;

/**
 * Represents a Text Label
 * A Label on which text is displayed.
 */
public class TextLabel extends Label{
	private String text;
	private int initX;
	private Paint myPaint;
	
	/**
	 * Creates a Text Label.
	 * @param x Position on the x axis
	 * @param y Position on the y axis
	 * @param myText Text to display
	 */
	public TextLabel(int x, int y, String myText) {
		super(x, y, 0);
		initX = x;
		setString(myText);
		myPaint = new Paint();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Changes the text and adjust the position according to its length
	 */
	public void setString(String newText){
		text = newText;
		int sizeOfText = newText.length()*7;
		int newX = initX - sizeOfText;
		super.setX(newX);
	}
	
	public String getString(){
		return text;
	}
	
	public Paint getPaint(){
		return myPaint;
	}
	
	public void setPaint(Paint newPaint){
		myPaint = newPaint;
	}

}
