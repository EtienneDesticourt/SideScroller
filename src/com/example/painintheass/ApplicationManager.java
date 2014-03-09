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
	private int[] health;
	private int[] speed;
	private int[] damage;
	private int[] cost;
	
	public ApplicationManager(){
		health = new int[6];
		speed = new int[6];
		damage = new int[6];
		cost = new int[6];
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
	public int getHealth(int countryID) {
		return health[countryID];
	}
	public void setHealth(int health, int countryID) {
		this.health[countryID] = health;
	}
	public int getSpeed(int countryID) {
		return speed[countryID];
	}
	public void setSpeed(int speed, int countryID) {
		this.speed[countryID] = speed;
	}
	public int getDamage(int countryID) {
		return damage[countryID];
	}
	public void setDamage(int damage, int countryID) {
		this.damage[countryID] = damage;
	}
	public int getCost(int countryID) {
		return cost[countryID];
	}
	public void setCost(int cost, int countryID) {
		this.cost[countryID] = cost;
	}
	
	
	
}
