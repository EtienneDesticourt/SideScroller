package com.example.painintheass.UI.widgets;

import android.graphics.Paint;

public class TextLabel extends Label{
	private String text;
	private int initX;
	private Paint myPaint;
	
	public TextLabel(int x, int y, String myText) {
		super(x, y, 0);
		initX = x;
		setString(myText);
		myPaint = new Paint();
		// TODO Auto-generated constructor stub
	}
	
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
