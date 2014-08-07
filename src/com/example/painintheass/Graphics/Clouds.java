package com.example.painintheass.Graphics;


/**
 * Represents the cloud layer.
 * Not implemented.
 */
public class Clouds {
	private int x;
	private int speed;
	
	public Clouds(int x, int speed){
		
	}
	
	public void step(int side){
		this.setX(this.getX() + side*this.speed);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
}
