package com.example.painintheass.GameLogic;

import com.example.painintheass.UI.Button;

public class Country {
	private boolean playerControlled;
	private Building[] myBuildings = {};
	private int troups;
	private int income;
	private int money;
	private int cost;
	private int time;
	private int strength;
	private int health;
	private int ID;
	private Button myButton;
	
	public Country(int ID){
		this.setID(ID);
		cost = 0;
		time = 0;
		strength = 0;
		health = 0;
		income = 10;
		troups = 10;
		money = 100;
	}
	
	public void nextTurn(){
		money += income;
	}
	
	public void setIncome(int newIncome){
		income = newIncome;
	}
	
	public int getIncome(){
		return income;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getTroups() {
		return troups;
	}

	public void setTroups(int troups) {
		this.troups = troups;
	}

	public Building[] getMyBuildings() {
		return myBuildings;
	}

	public void setMyBuildings(Building[] myBuildings) {
		this.myBuildings = myBuildings;
	}

	public boolean isPlayerControlled() {
		return playerControlled;
	}

	public Button getButton(){
		return myButton;
	}
	
	public void setButton(Button newButton){
		myButton = newButton;
	}
	
	
	public void setPlayerControlled(boolean playerControlled) {
		if (playerControlled){
			this.myButton.setCurrentImage(myButton.getHilightedImage()); //in this case: friendly image
		}
		else{
			this.myButton.setCurrentImage(myButton.getGreyedImage());//in this case: enemy image
		}
		
		this.playerControlled = playerControlled;
	}
	
	
	public void unclickButton(){
		if (playerControlled){
			this.myButton.setCurrentImage(myButton.getHilightedImage()); //in this case: friendly image
		}
		else{
			this.myButton.setCurrentImage(myButton.getGreyedImage());//in this case: enemy image
		}
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	
}
