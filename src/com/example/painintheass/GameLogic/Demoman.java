package com.example.painintheass.GameLogic;


public class Demoman extends Unit{

	public Demoman(Team unitsTeam) {
		super(unitsTeam);
		super.setType(4);
	}
	

	public void hit(int damage, boolean ranged, int type){
		super.hit(damage, ranged,type);
		super.die();
	}
	
	

}
