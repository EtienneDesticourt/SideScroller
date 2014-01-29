package com.example.painintheass.UI;

import com.example.painintheass.GameLogic.Country;

public class MapUIManager extends UIManager{


	private Country[] World;
	private Country Selected;
	private int selectedIndex;
	private Country Attacking;
	private Country Defending;
	
	
	public MapUIManager() {
		super();
	}

	public void setSelected(int index){
		this.Selected = World[index];
		this.selectedIndex = index;
		updateLabels(index);
	}
	
	public void updateLabels(){
		int index = selectedIndex;
		Widget[] curState = this.getCurrentState();
		curState[0].setString(Integer.toString(World[index].getTroups()));
		curState[1].setString(Integer.toString(World[index].getIncome()));
		curState[2].setString(Integer.toString(World[index].getMoney()));
		
	}
	
	public void updateLabels(int index){
		Widget[] curState = this.getCurrentState();
		curState[0].setString(Integer.toString(World[index].getTroups()));
		curState[1].setString(Integer.toString(World[index].getIncome()));
		curState[2].setString(Integer.toString(World[index].getMoney()));
	}
	
	
		
	public Country[] getWorld() {
		return World;
	}

	public void setWorld(Country[] world) {
		World = world;
	}

	public Country getSelected() {
		return Selected;
	}

	public void setSelected(Country selected) {
		Selected = selected;
	}

	public Country getAttacking() {
		return Attacking;
	}

	public void setAttacking(Country attacking) {
		Attacking = attacking;
	}

	public Country getDefending() {
		return Defending;
	}

	public void setDefending(Country defending) {
		Defending = defending;
	}
	
	public void unclickAll(){
		for (int i=0;i<6;i++){
			World[i].unclickButton();
		}
	}
	
	//Countries and turn logic should be in separate class but I need to ship soon
	
	public void rollTurn(){
		
	}
	
	
}
