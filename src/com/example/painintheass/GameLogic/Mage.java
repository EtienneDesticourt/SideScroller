package com.example.painintheass.GameLogic;


public class Mage extends Unit{

	private static int yMod = 85;
	public Mage(Team unitsTeam) {
		super(unitsTeam);
		super.setType(3);
		super.setyMod(yMod);
		super.setAttackRange(200);
		super.setAttackSpeed(1000);
	}


	public void attack(){
		int side = super.getMyTeam().getMovementSide();
		super.getMyTeam().addProjectile(new Projectile(67,1,side,getX()+50,getY()+40+yMod,17,8, super.getDamage()));
		if (super.getTarget().getAction()==3){
			super.setAction(0);
		}
	}
	
	
	
}
