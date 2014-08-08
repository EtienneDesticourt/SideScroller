package com.example.painintheass.GameLogic;

import com.example.painintheass.UI.widgets.Button;

/**
 * Represents a Country.
 * 
 */
public class Country {
	private boolean playerControlled;
	private Country[] adjacentCountries;
	private boolean underAttack;
	private int troups;
	private int income;
	private int money;
	private int cost;
	private int time;
	private int strength;
	private int health;
	private int ID;
	private int targetID;
	private Button myButton;
	private final int TROUPCOST = 10;
	
	/**
	 * Creates a Country.
	 * @param ID The country's ID
	 */
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
	
	/**
	 * Increases money by the income and deals with AI troups buying.
	 */
	public void handleMoney(){
		money += income;
		if (isPlayerControlled()) return;
		
		while (money >= TROUPCOST){
			buyTroups();
		}
	}
	
	/**
	 * Handles turn logic and AI attacks.
	 * @return Whether the country is going to attack another.
	 */
	public boolean nextTurn(){		
		Country cur;
		int mod;
		boolean attacking=false;
		
		if (isPlayerControlled()) return false;
		
		for (int i=0;i<adjacentCountries.length;i++){
			cur = adjacentCountries[i];
			if (!cur.isPlayerControlled()) continue;			
			
			mod = cur.getCost()+cur.getHealth()+cur.getStrength()+cur.getTime();
			if ( (mod*5+cur.getTroups()) < troups ){
				attacking = true;
				cur.setUnderAttack(true);
				targetID = cur.getID();				
			}
		}		
		return attacking;
	}
	
	
	public void setAdjacentCountries(Country[] adj){
		this.adjacentCountries = adj;
	}
		
	public void buyTroups(){
		if (money>= TROUPCOST){
			money -= TROUPCOST;
			troups += 10;
		}
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

	public int getTargetID() {
		return targetID;
	}

	public void setTargetID(int targetID) {
		this.targetID = targetID;
	}

	public boolean isUnderAttack() {
		return underAttack;
	}

	public void setUnderAttack(boolean underAttack) {
		this.underAttack = underAttack;
	}
	
	
}
