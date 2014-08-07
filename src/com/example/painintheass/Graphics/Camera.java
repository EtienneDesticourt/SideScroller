package com.example.painintheass.Graphics;

/**
 * Represents the Camera.
 */
public class Camera {
	private double x,dx,ddx;
	private double y,dy,ddy;
	private int minX,maxX;
	private boolean isMoving;
	private float speed;
	private int width;
	private int side;
	private boolean shaking = false;
	
	/**
	 * Creates a Camera.
	 * @param initSpeed Initial speed
	 * @param minX Start of the map on the X axis
	 * @param maxX End of the map on the X axis
	 */
	public Camera(int initSpeed,int minX, int maxX){
		this.x = 0;
		this.y = 0;
		this.dx = 0;
		this.dy = 0;
		this.ddx = 0;
		this.ddy = 0;		
		this.minX = minX;
		this.maxX = maxX;
		this.speed = initSpeed;
		this.isMoving = false;
	}
	
	public boolean isMoving(){
		return isMoving;
	}
	
	/**
	 * Moves the camera one step.
	 * @param side Side to which the camera moves.
	 */
	public void step(int side){
		double newX,newY;
		this.dx += ddx+0;
		this.dy += ddy;
		newX = x + dx*side;
		newY = y + dy*side;
		if (newX>minX && newX<maxX)	this.x = newX;
		this.y = newY;
		if (dx < 0){
			dx = 0;
			ddx = 0;
		}
	}
	
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
	
	public double getdX(){
		return this.dx;
	}
	
	public void setX(int newX){
		this.x = newX;
	}
	
	/**
	 * Moves the camera.
	 * Start a thread to repeatedly call {@link Camera#step(int) step()} 
	 * @param speed Speed of movement
	 * @param width Deprecated
	 * @param side Side to which the Camera moves
	 */
	public void pan(float speed, int width, int side){
		float lastSpeed = this.speed;
		this.speed = speed;
		//System.out.println(speed);
		this.dx = speed/100;
		this.ddx = -0.05;
		this.side = side;
		this.width = width;
		new Thread(new Runnable() {
	        public void run() {
	        	while (getdX() != 0){//(getX()*getSide()<getWidth()*10){
	        		step(getSide());
	        		try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	        	}
	        }
		}).start();
		this.speed = lastSpeed;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}
	
	/**
	 * Thread used to shake the Camera.
	 * It does so by randomly and repeatedly changing the speed of the camera
	 */
	public void shakeThread(){
		int dx,dy;
		double initX = this.x;
		double initY = this.y;
		for (int i = 0;i<120;i++){

			dx = -10 + (int)(Math.random()*20); 
			dy = -10 + (int)(Math.random()*20); 
			
			this.x += dx;
			this.y += dy;
			
			try {
	            Thread.sleep(5+i/10);
	        } catch (Exception exc) {}
			

			this.x = initX;
			this.y = initY;

		}
		shaking = false;
		
			
	}
	
	/**
	 * Runs the shaking thread.
	 */
	public void shake(){
		
		if (shaking){
			return;
		}
		shaking = true;
		
		new Thread(new Runnable() {
	        public void run() {
	        	shakeThread();
	        }
		}).start();
		
	}
	
	
	
	
//	public calcLayerPerspective(){
//		
//	}
	
	
	
}
