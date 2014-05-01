package com.example.painintheass.Graphics;

public class Star extends Particle{
	private static final double fadeSpeed = 0.1;
	private static final int imgIndex = 84;
	
	
	public Star(int x, int y) {
		super(x, y, imgIndex, fadeSpeed);
		
		int dx = -50 + (int)(Math.random()*100); 
		int dy = -50 + (int)(Math.random()*100);

		int vx = -2 + (int)(Math.random()*4) ;//* dx/Math.abs(dx);
		int vy = ( -2 +(int)(Math.random()*4) );//* dx/Math.abs(dx) ;
		
		if (vx==0 && vy==0){
			vx = 1;
			vy = 1;
		}
		
		this.setX(x+dx);
		this.setY(y+dy);
		this.setVx(vx);
		this.setVy(vy);
		
		
		
		
	}
	

}
