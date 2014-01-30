package com.example.painintheass.GameLogic;


public class Archer extends Unit{

	private static int yMod = 98;
	public Archer(Team unitsTeam) {
		super(unitsTeam);
		super.setType(1);
		super.setyMod(yMod);
		super.setAttackRange(250);
		super.setAttackSpeed(1000);
	}

	
	public void attack(){
		int side = super.getMyTeam().getMovementSide();
		super.getMyTeam().addProjectile(new Projectile(66,1,side,getX()+50,getY()+30+yMod,41,7,super.getDamage()));
		if (super.getTarget().getAction()==3){
			super.setAction(0);
		}		
	}
	
	
	
}
