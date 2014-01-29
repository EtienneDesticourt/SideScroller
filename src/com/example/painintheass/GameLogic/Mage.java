package com.example.painintheass.GameLogic;


public class Mage extends Unit{

	private static int yMod = 25;
	public Mage(Team unitsTeam) {
		super(unitsTeam);
		super.setType(3);
		super.setyMod(yMod);
	}


	public void attack(){
		int side = super.getMyTeam().getMovementSide();
		super.getMyTeam().addProjectile(new Projectile(125,1,side,getX(),getY(),20,20, super.getDamage()));
	}
	
	
	
}
