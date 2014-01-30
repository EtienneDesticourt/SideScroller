package com.example.painintheass.GameLogic;

import android.graphics.Rect;

public class Projectile {
	private int speed;
	private int side;
	private int x;
	private int y;
	private Rect myRect; 
	private int image;
	private int damage;
	
	public Projectile(int newImage,int speed, int side, int x, int y, int width, int height, int damage){//int initX, int initY, int initSpeed, int angle){
		this.speed = speed;
		this.x = x;
		this.y = y;
		this.image = newImage;
		this.setDamage(damage);
		this.side = side;
		myRect = new Rect();
		myRect.left = x;
		myRect.right = x+width;
		myRect.top = y;
		myRect.bottom = y+height;
		
	}
	
	//public void step(){
	//	t ++;
	//	x = (int) (speed*Math.cos(Math.toRadians(angle))*t + initX);
	//	y = (int) ((-0.5)*9.8*(Math.pow(t,2)) + speed*Math.sin(Math.toRadians(angle))*t + initY);
	//}
	
	public int getX(){
		return x;
	}
	
	public void setY(int newY){
		this.y = newY;
	}
	
	public int getY(){
		return y;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public int getSide(){
		return side;
	}
	
	public Rect getMyRect(){
		return myRect;
	}
	
	
	
	public void step(){
//		System.out.println("x"+x);
//		System.out.println("Side"+side);
//		System.out.println("Speed"+speed);
		x += side*speed;
		myRect.offsetTo(x,y);
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
}
