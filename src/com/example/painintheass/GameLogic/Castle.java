package com.example.painintheass.GameLogic;

public class Castle extends Unit{
	private static int yMod = -60;
	public Castle(Team unitsTeam) {
		super(unitsTeam);
		super.setyMod(yMod);
		super.setType(4);
		super.setAction(4); //action 4: Being a castle :D
		super.setMaxLife(1000);
		super.setLife(1000);
	}
	
	

}
