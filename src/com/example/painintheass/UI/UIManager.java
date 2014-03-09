package com.example.painintheass.UI;

import android.app.Activity;
import android.content.Intent;

import com.example.painintheass.MapActivity;
import com.example.painintheass.CombatActivity;
import com.example.painintheass.MainMenuActivity;
import com.example.painintheass.OptionsActivity;
import com.example.painintheass.SkillsActivity;
import com.example.painintheass.GameLogic.Country;
import com.example.painintheass.GameLogic.Team;


public class UIManager {
	private Widget[][] states;
	private int[] statesBackground;
	private boolean[] statesGameValue;
	private int stateNumber;
	private int currentState;
	private int lastState;
	private Activity MyActivity;
	private boolean on;
	private int musicVolume;
	private int soundVolume;
	private boolean update;
	private boolean endActivity;
	private int health;
	private int speed;
	private int damage;
	private int cost;
	
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

	public void setAttacking(Country enemyCountry) {
		// TODO Auto-generated method stub
		
	}
	
	public void setVolume(int volume, int bar){
		
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
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public void increaseHealth(){
	}
	
	public void increaseCost(){	
	}
	
	public void increaseSpeed(){		
	}
	
	public void increaseStrength(){		
	}
	public void resetMods(){
		
	}
}
