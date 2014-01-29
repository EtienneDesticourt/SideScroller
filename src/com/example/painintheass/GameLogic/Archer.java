package com.example.painintheass.GameLogic;


public class Archer extends Unit{

	private static int yMod = 50;
	public Archer(Team unitsTeam) {
		super(unitsTeam);
		super.setType(1);
		super.setyMod(yMod);
	}

	
	public void attack(){
		int side = super.getMyTeam().getMovementSide();
		super.getMyTeam().addProjectile(new Projectile(124,1,side,getX(),getY(),20,20,super.getDamage()));
	}
	
	
	
}
