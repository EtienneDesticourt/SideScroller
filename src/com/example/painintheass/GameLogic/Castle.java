package com.example.painintheass.GameLogic;

public class Castle extends Unit{

	public Castle(Team unitsTeam) {
		super(unitsTeam);
		super.setType(4);
		super.setAction(3); //action 3: Being a castle :D
		super.setMaxLife(1000);
		super.setLife(1000);
	}
	
	

}
