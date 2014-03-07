package com.example.painintheass.UI;

public class OptionsUIManager extends UIManager{

	private int musicVolume;
	private int soundVolume;
	private boolean update;
	private boolean endActivity;
	
	public OptionsUIManager(){
		super();
	}
	
	public void setVolume(int volume, int bar){
		if (bar==0){
			musicVolume = volume;
		}
	}

	public int getMusicVolume() {
		return musicVolume;
	}

	public void setMusicVolume(int musicVolume) {
		this.musicVolume = musicVolume;
	}

	public int getSoundVolume() {
		return soundVolume;
	}

	public void setSoundVolume(int soundVolume) {
		this.soundVolume = soundVolume;
	}
	
	public boolean mustUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public boolean isEndActivity() {
		return endActivity;
	}

	public void setEndActivity(boolean endActivity) {
		this.endActivity = endActivity;
	}
	
	
	
}
