package com.example.painintheass.UI;

public class SkillsUIManager extends UIManager{

	private int health,firstHealth;
	private int speed,firstSpeed;
	private int damage,firstDamage;
	private int cost,firstCost;
	private final int HEALTHSTART  = 12;
	private final int STRENGTHSTART = 24;
	private final int COSTSTART = 0;
	private final int SPEEDSTART = 36;
	private boolean endActivity;
	private boolean update;
	
	public SkillsUIManager(){
		super();
	}
	
	public void resetMods(){
		health = firstHealth;
		cost = firstCost;
		damage = firstDamage;
		speed = firstSpeed;
	}
	public void increaseHealth(){
		Widget[] widgets = super.getCurrentState();
		health += 1;
		for (int i=HEALTHSTART;i<HEALTHSTART+health;i++){
			widgets[i].setBackgroundImage(widgets[i].getClickedImage());
		}	
	}
	
	public void increaseCost(){
		Widget[] widgets = super.getCurrentState();
		cost += 1;
		for (int i=COSTSTART;i<COSTSTART+cost;i++){
			widgets[i].setBackgroundImage(widgets[i].getClickedImage());
		}		
	}
	
	public void increaseSpeed(){
		Widget[] widgets = super.getCurrentState();
		speed += 1;
		for (int i=SPEEDSTART;i<SPEEDSTART+health;i++){
			widgets[i].setBackgroundImage(widgets[i].getClickedImage());
		}		
	}
	
	public void increaseStrength(){
		Widget[] widgets = super.getCurrentState();
		damage += 1;
		for (int i=STRENGTHSTART;i<STRENGTHSTART+health;i++){
			widgets[i].setBackgroundImage(widgets[i].getClickedImage());
		}		
	}
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.firstHealth = health;
		this.health = health;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.firstSpeed = speed;
		this.speed = speed;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.firstDamage = damage;
		this.damage = damage;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.firstCost = cost;
		this.cost = cost;
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
