package com.example.painintheass.GameLogic;

import com.example.painintheass.UI.Button;

public class Country {
	private boolean playerControlled;
	private Building[] myBuildings = {};
	private int troups;
	private int income;
	private int money;
	private Button myButton;
	
	public Country(){
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
	
	
}
