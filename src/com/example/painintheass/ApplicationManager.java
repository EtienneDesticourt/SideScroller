package com.example.painintheass;

import com.example.painintheass.GameLogic.Country;

import android.app.Application;



/**
 * Stores application wide data.
 */
public class ApplicationManager extends Application {
	private int musicVolume;
	private int soundVolume;
	private boolean updated;
	private Country[] World;
	
	public ApplicationManager(){		
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
	
	public boolean isUpdated() {
		return updated;
	}
	public void setUpdated(boolean updated) {
		this.updated = updated;
	}
	
	public Country getCountry(int countryID){
		return World[countryID];
	}
	public int getHealth(int countryID) {
		return World[countryID].getHealth();
	}
	public void setHealth(int health, int countryID) {
		this.World[countryID].setHealth(health);
	}
	public int getTime(int countryID) {
		return World[countryID].getTime();
	}
	public void setTime(int time, int countryID) {
		this.World[countryID].setTime(time);
	}
	public int getStrength(int countryID) {
		return World[countryID].getStrength();
	}
	public void setDamage(int strength, int countryID) {
		this.World[countryID].setStrength(strength);
	}
	public int getCost(int countryID) {
		return World[countryID].getCost();
	}
	public void setCost(int cost, int countryID) {
		this.World[countryID].setCost(cost);
	}
	public void setWorld(Country[] newWorld){
		this.World = newWorld;
	}

	public void setMoney(int money, int countryID) {
		this.World[countryID].setMoney(money);
		
	}
	
	
}
