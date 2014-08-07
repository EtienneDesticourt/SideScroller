package com.example.painintheass.Graphics;


/**
 * Represents an animation.
 * Holds the frame and speed logic
 */
public class Animation {
	private int start;
	private int end;
	private int frameNumber;
	private long speed;
	private boolean loop;
	
	/**
	 * Creates a looping animation.
	 * @param startIndex Index of the first frame
	 * @param endIndex Index of the last frame
	 * @param animSpeed Speed of the animation
	 */
	public Animation(int startIndex, int endIndex, int animSpeed){
		frameNumber = (endIndex - startIndex)+1;
		start = startIndex;
		end = endIndex;
		setSpeed(animSpeed*100);
		setLoop(true);
	}
	
	/**
	 * Creates an animation.
	 * @param startIndex Index of the first frame
	 * @param endIndex Index of the last frame
	 * @param animSpeed Speed of the animation
	 * @param isLoop Indicates whether the animation loops
	 */
	public Animation(int startIndex, int endIndex, int animSpeed, boolean isLoop){
		frameNumber = (endIndex - startIndex)+1;
		start = startIndex;
		end = endIndex;
		setSpeed(animSpeed*100);
		setLoop(isLoop);		
	}
	
	
	
	public int getStart(){
		return start;
	}
	
	public int getLength(){
		return frameNumber;
	}

	public long getSpeed() {
		return speed;
	}

	public void setSpeed(long speed) {
		this.speed = speed;
	}

	public boolean isLoop() {
		return loop;
	}

	public void setLoop(boolean loop) {
		this.loop = loop;
	}
}
