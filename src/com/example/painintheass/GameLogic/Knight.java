package com.example.painintheass.GameLogic;


public class Knight extends Unit {

	private static int yMod = 80;
	public Knight(Team unitsTeam) {
		super(unitsTeam);
		super.setType(2);
		super.setyMod(yMod);
		super.setAttackRange(20);
		super.setAttackSpeed(1000);
	}

	public void hit(int damage, boolean ranged){
		if (ranged==false){
			super.hit(damage, ranged);
		}
	}
}
