package com.example.painintheass.GameLogic;

public class Smoke {
	private int x;
	private int speed;
	
	public Smoke(int initX, int initSpeed){
		x = initX;
		speed = initSpeed;
	}
	
	public void step(int side){
		this.x += side*this.speed;
	}
	
	public void setSpeed(int newSpeed){
		this.speed = newSpeed;
	}
	
	public int getX(){
		return this.x;
	}
	
}
