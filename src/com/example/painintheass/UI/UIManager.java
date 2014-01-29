package com.example.painintheass.UI;

import com.example.painintheass.GameLogic.Country;
import com.example.painintheass.GameLogic.Team;


public class UIManager {
	private Widget[][] states;
	private int[] statesBackground;
	private boolean[] statesGameValue;
	private int stateNumber;
	private int currentState;
	private int lastState;
	private boolean on;
	
	public UIManager(){
		states = new Widget[20][];
		statesBackground = new int[20];
		statesGameValue = new boolean[20];
		stateNumber = 0;
		currentState = 0;
		lastState = 0;
		setOn(true);
	}
	
	public void addState(Widget[] state, boolean isAGameState, int backgroundIndex){
		states[stateNumber] = state;
		statesBackground[stateNumber] = backgroundIndex; 
		statesGameValue[stateNumber] = isAGameState;
		stateNumber++;
	}
	
	public void addState(Widget[] state, boolean isAGameState){
		states[stateNumber] = state;
		statesBackground[stateNumber] = 153; 
		statesGameValue[stateNumber] = isAGameState;
		stateNumber++;
	}
	
	public boolean isAGameState(int index){
		return statesGameValue[index];
	}
	
	public Widget[] getCurrentState(){
		return states[currentState];
	}

	public int getCurrentBackgroundIndex(){
		return statesBackground[currentState];
	}
	
	public boolean isOn() {
		return on;
	}
	
	public void setOn(boolean on) {
		this.on = on;
	}
	
	public int getCurrentStateIndex() {
		return currentState;
	}
	
	public int getLastState() {
		return lastState;
	}

	public void setLastState(int lastState) {
		this.lastState = lastState;
	}
	
	public void leave(){		
	}
	
		
	public void setCurrentStateIndex(int currentState) {
		this.lastState = this.currentState;
		this.currentState = currentState;
	}
	
	public Team getMyPlayerTeam() {
		return null;
	}

	public Country[] getWorld() {
		return null;
	}
	public void setSelected(int i) {
	}
	public Country getSelected() {
		return null;
	}
	public Country getDefending() {
		return null;
	}
	public Country getAttacking() {
		return null;
	}
	public void unclickAll(){		
		System.out.println("Unclicking nothign");
	}

	public void updateLabels(int index){
		
	}
	
	public void updateLabels(){
		
	}
	

	
	
}
