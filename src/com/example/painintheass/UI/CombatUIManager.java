package com.example.painintheass.UI;

import java.util.Date;

import com.example.painintheass.GameLogic.AI;
import com.example.painintheass.GameLogic.Team;
import com.example.painintheass.UI.widgets.Widget;

/**
 * Link the UI of the combat activity to the game engine.
 */
public class CombatUIManager extends UIManager{
	private AI myAI;
	private Team myPlayerTeam;
	private Team myEnemyTeam;
	/**
	 * Delay between money increase by income.
	 */
	private static final long INCOMEDELAY=5000;
	/**
	 * Whether healing spell must be cast.
	 */
	private boolean healOnTouch = false;
	/**
	 * Whether fire spell must be cast.
	 */
	private boolean spawnProjectile = false;
	
	/**
	 * Creates a UI manager for the combat scene.
	 * @param playerTeam The player's team
	 * @param enemyTeam The enemy's team
	 * @param mainPlayer The player
	 */
	public CombatUIManager(Team playerTeam, Team enemyTeam) {
		super();

		setMyEnemyTeam(enemyTeam);
		setMyPlayerTeam(playerTeam);
		myPlayerTeam.reset();
		myEnemyTeam.reset();
		//getMyAI().startMovingUnits();
		
	}

	/**
	 * Pauses AI and reset teams.
	 */
	public void leave(){
		myAI.stopMovingUnits();
		myPlayerTeam.reset();
		myEnemyTeam.reset();
	}
	
	
	public void updateLabels(){
		Widget[] curState = this.getCurrentState();
		curState[0].setString(Integer.toString(myPlayerTeam.getMoney()));
		curState[2].setString(Integer.toString(myPlayerTeam.getMiners()));
	}
	
	/**
	 * Update the player's team's funds.
	 * Adds income to total funds if <code>INCOMEDELAY</code> has passed since last increase.
	 * @return True if funds have been increase, false otherwise.
	 */
	public boolean updateMoney(){
		long current = new Date().getTime();
		if (current-myPlayerTeam.getLastIncome() > INCOMEDELAY){
			myPlayerTeam.increaseMoney();
			myPlayerTeam.setLastIncome(current);
			updateLabels();
			return true;
		}
		return false;
	}
	
	
	public void quit(){
		myAI.quit();
	}
	
	public void startMovingUnits(){
		myAI.startMovingUnits();
	}
	
	public void stopMovingUnits(){
		myAI.stopMovingUnits();
	}
	
	public void setMyAI(AI myAI) {
		this.myAI = myAI;
	}
		
	
	public Team getMyPlayerTeam() {
		return myPlayerTeam;
	}

	public void setMyPlayerTeam(Team myPlayerTeam) {
		this.myPlayerTeam = myPlayerTeam;
	}

	

	public Team getMyEnemyTeam() {
		return myEnemyTeam;
	}

	public void setMyEnemyTeam(Team myEnemyTeam) {
		this.myEnemyTeam = myEnemyTeam;
	}

	public boolean mustHealOnTouch() {
		return healOnTouch;
	}

	public void setHealOnTouch(boolean healOnTouch) {
		this.healOnTouch = healOnTouch;
	}

	public boolean mustSpawnProjectile() {
		return spawnProjectile;
	}

	public void setSpawnProjectile(boolean spawnProjectile) {
		this.spawnProjectile = spawnProjectile;
	}
	
}
