package com.example.painintheass.GameLogic;

import android.graphics.Rect;


public class Mage extends Unit{

	private static int xMod = -45/4;
	private static int yMod = -50/4;
	private static int width = 85/4;
	private static int height = 230/4;
	private static int sizeDif = 95;//85
	public Mage(Team unitsTeam) {
		super(unitsTeam);
		super.setType(3);
		Rect temp = super.getBodyRect();
		super.setBodyRect(temp.left, temp.top+sizeDif, width, height);
		super.setxMod(xMod);		
		super.setyMod(yMod);
		super.setAttackRange(200);
		super.setAttackSpeed(700);
		super.init();
	}


	public void attack(){
		int side = super.getMyTeam().getMovementSide();
		super.getMyTeam().addProjectile(new Projectile(67,15,side,getX()+50,getY()+40+yMod,17,8, super.getDamage()));
		super.getMyTeam().addProjectile(new Projectile(67,15,side,getX()+10,getY()+40+yMod,17,8, super.getDamage()));
		super.getMyTeam().addProjectile(new Projectile(67,15,side,getX()+30,getY()+40+yMod,17,8, super.getDamage()));
		if (super.getTarget().getAction()==2){
			super.setAction(0);
		}
	}
	
	
	
}
