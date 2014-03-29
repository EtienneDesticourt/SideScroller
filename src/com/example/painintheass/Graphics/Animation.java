package com.example.painintheass.Graphics;

public class Animation {
	private int start;
	private int end;
	private int frameNumber;
	private long speed;
	private boolean loop;
	
	public Animation(int startIndex, int endIndex, int animSpeed){
		frameNumber = (endIndex - startIndex)+1;
		start = startIndex;
		end = endIndex;
		setSpeed(animSpeed*100);
		setLoop(true);
	}
	
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
