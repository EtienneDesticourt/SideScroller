package com.example.painintheass.UI;

import android.app.Activity;
import android.content.Intent;

import com.example.painintheass.MapActivity;
import com.example.painintheass.CombatActivity;
import com.example.painintheass.GameLogic.AI;
import com.example.painintheass.GameLogic.Country;
import com.example.painintheass.GameLogic.Team;
import com.example.painintheass.UI.widgets.Widget;
import com.example.painintheass.menus.MainMenuActivity;
import com.example.painintheass.menus.OptionsActivity;
import com.example.painintheass.menus.SkillsActivity;

/**
 * Relays information from widgets to the rest of the app.
 */
public class UIManager {
	/**
	 * Holds the widgets to be rendered in current activity.
	 * Only current state is rendered.
	 */
	private Widget[][] states;
	/**
	 * Index of the background image for each state.
	 */
	private int[] statesBackground;
	private boolean[] statesGameValue;
	private int stateNumber;
	/**
	 * Index of the only UI state to be rendered
	 */
	private int currentState;
	private int lastState;
	private Activity MyActivity;
	/**
	 * Whether to render the current state.
	 */
	private boolean on;
	private boolean update;
	private boolean endActivity;
	private int exitFlag; //0:exit to map, 1: exit app to home,2:exit with victory or defeat
	
	/**
	 * Creates a UI Manager with empty states.
	 */
	public UIManager(){		
		states = new Widget[20][];
		statesBackground = new int[20];
		statesGameValue = new boolean[20];
		stateNumber = 0;
		currentState = 0;
		lastState = 0;
		setOn(true);
	}
	
	
	public UIManager(Activity A){
		this();
		this.setMyActivity(A);
	}
	
	
	public Widget getWidget(int stateIndex, int widgetIndex){
		return states[stateIndex][widgetIndex];
	}
	
	
	public void addState(Widget[] state, boolean isAGameState, int backgroundIndex){
		//isAGameState remnant of old drawing system.
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
	
	public Activity getMyActivity() {
		return MyActivity;
	}
	
	public Intent getIntent(int type){
		Intent myIntent;
		if (type==0){
			myIntent = new Intent(MyActivity, MainMenuActivity.class);
		}
		else if (type==1){
			myIntent = new Intent(MyActivity, MapActivity.class);			
		}
		else if (type==2){
			myIntent = new Intent(MyActivity, CombatActivity.class);
		}
		else if (type==3){
			myIntent = new Intent(MyActivity, OptionsActivity.class);
		}
		else{
			myIntent = new Intent(MyActivity, SkillsActivity.class);
		}
		return myIntent;
	}

	public void setMyActivity(Activity myActivity) {
		MyActivity = myActivity;
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
	
	public int getExitFlag() {
		return exitFlag;
	}

	public void setExitFlag(int exitFlag) {
		this.exitFlag = exitFlag;
	}
	
}
