package com.example.painintheass.UI.widgets;


import com.example.painintheass.UI.UIManager;

import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Represents a Widget.
 * A Widget is the basic element of the UI.
 */
public abstract class Widget {
	private int x;
	private int y;
	private int width;
	private int height;
	private int backgroundImage;
	private int hilightedImage;
	private int clickedImage;
	private int greyedImage;
	private int currentImage;
	private Rect myRect;
	private String text;
	private boolean visible;
	
	/**
	 * Creates a Widget.
	 * @param x Position on the x axis
	 * @param y Position on the y axis
	 * @param width Width of the widget
	 * @param height height of the widget
	 */
	public Widget(int x, int y, int width, int height){
		myRect = new Rect();
		myRect.left = x;
		myRect.right = x+width;
		myRect.top = y;
		myRect.bottom = y+height;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		setCurrentImage(backgroundImage);
		this.visible = true;
	}
	
	/**
	 * Creates a Widget.
	 * @param x Position on the x axis
	 * @param y Position on the y axis
	 * @param width Width of the Widget
	 * @param height Height of the Widget
	 * @param backgroundImage Index of the background bitmap
	 * @param highlighted Index of the highlighted bitmap
	 * @param grayed Index of the grayed bitmap
	 * @param click Index of the clicked bitmap
	 */
	public Widget(int x, int y, int width, int height,int backgroundImage, int highlighted, int grayed, int click){
		myRect = new Rect();
		myRect.left = x;
		myRect.right = x+width;
		myRect.top = y;
		myRect.bottom = y+height;
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.backgroundImage = backgroundImage;
		this.hilightedImage = highlighted;
		this.greyedImage = grayed;
		this.clickedImage = click;
		setCurrentImage(backgroundImage);
		this.visible = true;
		
	}
	
	

	public void onClickWrap(UIManager myUIM){
		
	}
	
	public abstract void onClick(UIManager myUIM);
	
	public void onHover(){
		setCurrentImage(hilightedImage); 
	}
	
	public void onHoverOff(){
		setCurrentImage(backgroundImage);
	}
	
	
	
	public void onDrag(){
		//do something		
	}
	
	public boolean isOver(int[] pos){
		if (pos[0] >= x && pos[0] <= x+width && pos[1] >= y && pos[1] <= y+height){
			return true;
		}
		return false;
	}	
	
	public boolean isOver(int ex, int ey){
		if (myRect.contains(ex, ey)) return true;
		return false;
		
//		if (ex >= x && ex <= x+width && ey >= y && ey <= y+height){
//			return true;
//		}
//		return false;
	}	
	

	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getBackgroundImage() {
		return backgroundImage;
	}


	public void setBackgroundImage(int backgroundImage) {
		this.backgroundImage = backgroundImage;
		this.currentImage = backgroundImage;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHilightedImage() {
		return hilightedImage;
	}


	public void setHilightedImage(int hilightedImage) {
		this.hilightedImage = hilightedImage;
	}


	public int getClickedImage() {
		return clickedImage;
	}


	public void setClickedImage(int clickedImage) {
		this.clickedImage = clickedImage;
	}


	public int getGreyedImage() {
		return greyedImage;
	}


	public void setGreyedImage(int greyedImage) {
		this.greyedImage = greyedImage;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public int getCurrentImage() {
		return currentImage;
	}


	public void setCurrentImage(int currentImage) {
		this.currentImage = currentImage;
	}
	
	public void setString(String text){
	}
	
	public void updateLeft(){
		
	}
	
	
	public String getString(){
		//Only for labels
		return "";
	}
	
	public Paint getPaint(){
		//Only for labels
		return new Paint();
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
}
