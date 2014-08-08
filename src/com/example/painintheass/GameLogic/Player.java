package com.example.painintheass.GameLogic;

import com.example.painintheass.GameLogic.Missiles.FallingProjectile;
import com.example.painintheass.GameLogic.Units.Unit;

/**
 * Represents the Player.
 */
public class Player {
	private int money;
	private int score;
	private Team myTeam;
	//skills
	////////
	//spells
	////////
	private Unit Target;
	
	
	public Player(Team newTeam){
		myTeam = newTeam;
	}
	
	public void castFallingArrows(){
		if (Target==null) return;
		int x = Target.getX()-50;
		
		
		for (int j=0;j<3;j++){
			for (int i=0; i< 10;i++){
				myTeam.addProjectile(new FallingProjectile(124,2,1,x+i*10,0-j*10,20,20,10));			
			}
		}
	}
	
	public void castMeteor(){
		if (Target==null) return;
		Target.die();
	}
	
	public void castLightning(){
		if (Target==null) return;
		Target.die();
	}
	
	
	
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Unit getTarget() {
		return Target;
	}
	public void setTarget(Unit target) {
		Target = target;
	}
	
	
	
	
}
