package com.example.painintheass;

import android.app.Application;

public class ApplicationManager extends Application {
	private int musicVolume;
	private int soundVolume;
	private boolean updated;
	private float costMod;
	private float timeMod;
	private float manaMod;
	private float StrengthMod;
	
	
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
	
	public boolean isUpdated() {
		return updated;
	}
	public void setUpdated(boolean updated) {
		this.updated = updated;
	}
	
	public float getCostMod() {
		return costMod;
	}
	public void setCostMod(float costMod) {
		this.costMod = costMod;
	}
	
	public float getTimeMod() {
		return timeMod;
	}
	public void setTimeMod(float timeMod) {
		this.timeMod = timeMod;
	}
	
	public float getManaMod() {
		return manaMod;
	}
	public void setManaMod(float manaMod) {
		this.manaMod = manaMod;
	}
	
	public float getStrengthMod() {
		return StrengthMod;
	}
	public void setStrengthMod(float strengthMod) {
		StrengthMod = strengthMod;
	}
	
	
	
}
