package com.example.painintheass.Graphics.Particles;

import java.util.Date;

/**
 * Represents a Particle.
 * A particle's only function is to move a certain way and fade away.
 */
public class Particle {
	private double x,y;
	private double vx,vy;
	private int imgIndex;
	private double fadeSpeed;
	private int alpha = 255;
	private long lastFade = new Date().getTime();
	
	/**
	 * Creates a particle.
	 * @param x Position on x axis
	 * @param y Position on y axis
	 * @param imgIndex Index of particle's image
	 * @param fadeSpeed Speed at which the particle fades
	 */
	public Particle(int x, int y, int imgIndex, double fadeSpeed){
		this.x = x;
		this.y = y;
		this.imgIndex = imgIndex;
		this.fadeSpeed = fadeSpeed;
	}
	
	/**
	 * Determines how the particle moves.
	 */
	public void step(){
		//move
		this.setX(this.getX() + this.vx);
		this.setY(this.getY() + this.vy);
		
		//fade
		long time = new Date().getTime();
		if (alpha>0 && (time-lastFade)>fadeSpeed){
			alpha -= 1;
			if (alpha<0) alpha = 0;
			lastFade = time;
		}
	}

	public int getAlpha() {
		return alpha;
	}

	public void setAlpha(int alpha) {
		this.alpha = alpha;
	}

	public double getFadeSpeed() {
		return fadeSpeed;
	}

	public void setFadeSpeed(double fadeSpeed) {
		this.fadeSpeed = fadeSpeed;
	}

	public int getImgIndex() {
		return imgIndex;
	}

	public void setImgIndex(int imgIndex) {
		this.imgIndex = imgIndex;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}
	
	public void setVx(double vx){
		this.vx = vx;
	}
	
	public void setVy(double vy){
		this.vy = vy;
	}
	
}
