package com.example.painintheass.Graphics;

public class Animation {
	private int start;
	private int end;
	private int frameNumber;
	private long speed;
	
	public Animation(int startIndex, int endIndex, int animSpeed){
		frameNumber = (endIndex - startIndex)+1;
		start = startIndex;
		end = endIndex;
		setSpeed(animSpeed*100);
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
}
