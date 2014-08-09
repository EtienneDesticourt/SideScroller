package com.example.painintheass.UI;

import android.app.Activity;

import com.example.painintheass.GameLogic.Country;
import com.example.painintheass.UI.widgets.Widget;

/**
 * Manages the UI of the map activity.
 */
public class MapUIManager extends UIManager{
	private Country[] World;
	private int selectedIndex;
	private Country Selected;
	private Country Attacking;
	private Country Defending;
	
	/**
	 * Creates a manager of the map's UI.
	 */
	public MapUIManager() {
		super();
	}
	
	/**
	 * Creates a manager of the map's UI.
	 */
	public MapUIManager(Activity A){
		super(A);
	}
	
	/**
	 * Changes currently selected country.
	 */
	public void setSelected(int index){
		this.Selected = World[index];
		this.selectedIndex = index;
		updateLabels(index);
	}
	
	/**
	 * Updates currently selected country's money and troups.
	 */
	public void updateLabels(){
		int index = selectedIndex;
		Widget[] curState = this.getCurrentState();
		curState[1].setString(Integer.toString(World[index].getTroups()));
		curState[2].setString(Integer.toString(World[index].getMoney()));
	}
	
	/**
	 * Updates country's money and troups.
	 * @param index Index of the country of which the money and troups will appear. 
	 */
	public void updateLabels(int index){
		Widget[] curState = this.getCurrentState();
		curState[1].setString(Integer.toString(World[index].getTroups()));
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
