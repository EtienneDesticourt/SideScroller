package com.example.painintheass.UI;

import android.graphics.Paint;

public class TextLabel extends Label{
	private String text;
	private Paint myPaint;
	
	public TextLabel(int x, int y, String myText) {
		super(x, y, 0);
		text = myText;
		myPaint = new Paint();
		// TODO Auto-generated constructor stub
	}
	
	public void setString(String newText){
		text = newText;
	}
	
	public String getString(){
		return text;
	}
	
	public Paint getPaint(){
		return myPaint;
	}
	

}
