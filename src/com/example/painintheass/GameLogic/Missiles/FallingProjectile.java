package com.example.painintheass.GameLogic.Missiles;


import android.graphics.Rect;

/**
 * Represents a missile moving vertically.
 */
public class FallingProjectile extends Projectile{

	/**
	 * Creates a falling missile.
	 */
	public FallingProjectile(int newImage, int speed, int side, int x, int y, int width, int height, int damage) {
		super(newImage, speed, side, x, y, width, height, damage);
		setType(1);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Lowers the missile.
	 */
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
