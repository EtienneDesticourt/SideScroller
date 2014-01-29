package com.example.painintheass.UI;

import com.example.painintheass.GameLogic.AI;
import com.example.painintheass.GameLogic.Player;
import com.example.painintheass.GameLogic.Team;

public class CombatUIManager extends UIManager{

	private Team myPlayerTeam;
	private Team myEnemyTeam;
	private Player myPlayer;
	private AI myAI;
	
	public CombatUIManager(Team playerTeam, Team enemyTeam, Player mainPlayer) {
		super();

		setMyEnemyTeam(enemyTeam);
		setMyPlayer(mainPlayer);
		setMyPlayerTeam(playerTeam);
		myPlayerTeam.reset();
		myEnemyTeam.reset();
		//getMyAI().startMovingUnits();
		
	}

	public void leave(){
		getMyAI().stopMovingUnits();
		myPlayerTeam.reset();
		myEnemyTeam.reset();
	}
	
	public AI getMyAI() {
		return myAI;
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

	public Player getMyPlayer() {
		return myPlayer;
	}

	public void setMyPlayer(Player myPlayer) {
		this.myPlayer = myPlayer;
	}

	public Team getMyEnemyTeam() {
		return myEnemyTeam;
	}

	public void setMyEnemyTeam(Team myEnemyTeam) {
		this.myEnemyTeam = myEnemyTeam;
	}
	
}
