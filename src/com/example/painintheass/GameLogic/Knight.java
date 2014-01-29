package com.example.painintheass.GameLogic;


public class Knight extends Unit {

	private static int yMod = 20;
	public Knight(Team unitsTeam) {
		super(unitsTeam);
		super.setType(2);
		super.setyMod(yMod);
	}

	public void hit(int damage, boolean ranged){
		if (ranged==false){
			super.hit(damage, ranged);
		}
	}
}
