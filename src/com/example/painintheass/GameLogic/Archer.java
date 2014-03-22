package com.example.painintheass.GameLogic;

import android.graphics.Rect;


public class Archer extends Unit{

	private static int xMod = -140/4;
	private static int yMod = -10/4;
	private static int width = 90/4;
	private static int height = 215/4;
	private static int sizeDif = 98;
	public Archer(Team unitsTeam) {
		super(unitsTeam);
		super.setType(1);
		Rect temp = super.getBodyRect();
		super.setBodyRect(temp.left, temp.top+sizeDif, width, height);
		super.setxMod(xMod);		
		super.setyMod(yMod);
		super.setAttackRange(250);
		super.setAttackSpeed(1500);
		super.init();
	}
	
	

	
	public void attack(){
		int side = super.getMyTeam().getMovementSide();
		super.getMyTeam().addProjectile(new Projectile(66,22,side,getX()+50+xMod,getY()+30+yMod,41,7,super.getDamage()));
		if (super.getTarget().getAction()==2 && super.getAction()!=2){
			super.setAction(0);
		}		
	}
	
	
	
}
