package com.example.painintheass.GameLogic;


import android.graphics.Rect;

public class FallingArrow extends Projectile{

	public FallingArrow(int newImage, int speed, int side, int x, int y, int width, int height, int damage) {
		super(newImage, speed, side, x, y, width, height, damage);
		// TODO Auto-generated constructor stub
	}
	
	
	public void step(){
		int x = super.getX();
		int y = super.getY();
		int side = super.getSide();
		int speed = super.getSpeed();
		Rect myRect = super.getMyRect();
		y += side*speed;
		super.setY(y);
		myRect.offsetTo(x,y);
	}
	

}
