package com.example.painintheass.UI;

public class SkillsUIManager extends UIManager{

	private int health,firstHealth;
	private int time,firstTime;
	private int strength,firstStrength;
	private int cost,firstCost;
	private int money,firstMoney;
	private final static int TIMECOST = 50; 
	private final static int COSTCOST = 50; 
	private final static int STRENGTHCOST = 50; 
	private final static int HEALTHCOST = 50; 
	private final int HEALTHSTART  = 12;
	private final int STRENGTHSTART = 24;
	private final int COSTSTART = 0;
	private final int TIMESTART = 36;
	private boolean endActivity;
	private boolean update;
	
	public SkillsUIManager(){
		super();
	}
	
	public void resetMods(){
		health = firstHealth;
		cost = firstCost;
		strength = firstStrength;
		time = firstTime;
		money = firstMoney;
		update();
	}
	public void increaseHealth(){
		if (money>=HEALTHCOST){ money -= HEALTHCOST; getWidget(0,53).setString(String.valueOf(money));}
		else return;
		Widget[] widgets = super.getCurrentState();
		health += 1;
		for (int i=HEALTHSTART;i<HEALTHSTART+health;i++){
			widgets[i].setCurrentImage(widgets[i].getHilightedImage());
		}	
	}
	
	public void increaseCost(){
		if (money>=COSTCOST){ money -= COSTCOST; getWidget(0,53).setString(String.valueOf(money));}
		else return;
		Widget[] widgets = super.getCurrentState();
		cost += 1;
		for (int i=COSTSTART;i<COSTSTART+cost;i++){
			widgets[i].setCurrentImage(widgets[i].getHilightedImage());
		}		
	}
	
	public void increaseTime(){
		if (money>=TIMECOST){ money -= TIMECOST; getWidget(0,53).setString(String.valueOf(money));}
		else return;
		Widget[] widgets = super.getCurrentState();
		time += 1;
		for (int i=TIMESTART;i<TIMESTART+time;i++){
			widgets[i].setCurrentImage(widgets[i].getHilightedImage());
		}		
	}
	
	public void increaseStrength(){
		if (money>=STRENGTHCOST){ money -= STRENGTHCOST; getWidget(0,53).setString(String.valueOf(money));}
		else return;
		Widget[] widgets = super.getCurrentState();
		strength += 1;
		for (int i=STRENGTHSTART;i<STRENGTHSTART+strength;i++){
			widgets[i].setCurrentImage(widgets[i].getHilightedImage());
		}		
	}
	
	public void update(){

		Widget[] widgets = super.getCurrentState();
		for (int i=HEALTHSTART;i<HEALTHSTART+health;i++){
			widgets[i].setCurrentImage(widgets[i].getHilightedImage());
		}
		for (int i=HEALTHSTART+health;i<HEALTHSTART+11;i++){
			widgets[i].setCurrentImage(widgets[i].getBackgroundImage());
		}	
		for (int i=COSTSTART;i<COSTSTART+cost;i++){
			widgets[i].setCurrentImage(widgets[i].getHilightedImage());
		}	
		for (int i=COSTSTART+cost;i<COSTSTART+11;i++){
			widgets[i].setCurrentImage(widgets[i].getBackgroundImage());
		}	
		for (int i=TIMESTART;i<TIMESTART+time;i++){
			widgets[i].setCurrentImage(widgets[i].getHilightedImage());
		}	
		for (int i=TIMESTART+time;i<TIMESTART+11;i++){
			widgets[i].setCurrentImage(widgets[i].getBackgroundImage());
		}	
		for (int i=STRENGTHSTART;i<STRENGTHSTART+strength;i++){
			widgets[i].setCurrentImage(widgets[i].getHilightedImage());
		}	
		for (int i=STRENGTHSTART+strength;i<STRENGTHSTART+11;i++){
			widgets[i].setCurrentImage(widgets[i].getBackgroundImage());
		}	
		getWidget(0,53).setString(String.valueOf(money));
	}
	
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.firstHealth = health;
		this.health = health;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.firstTime = time;
		this.time = time;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.firstStrength = strength;
		this.strength = strength;
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

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.firstMoney = money;
		this.money = money;
		getWidget(0,53).setString(String.valueOf(money));
	}
	
}
