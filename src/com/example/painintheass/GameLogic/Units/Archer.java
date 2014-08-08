package com.example.painintheass.GameLogic.Units;

import com.example.painintheass.GameLogic.Team;
import com.example.painintheass.GameLogic.Missiles.Projectile;

import android.graphics.Rect;

/**
 * Represents an Archer unit.
 */
public class Archer extends Unit{

	private static int[] xMod = {-140/4,-100/4};
	private static int yMod = -10/4;
	private static int width = 90/4;
	private static int height = 215/4;
	private static int sizeDif = 98;
	private static int teamIndex; 
	
	/**
	 * Create an Archer.
	 * @param unitsTeam Team to which the Archer was added
	 */
	public Archer(Team unitsTeam) {
		super(unitsTeam);
		teamIndex = unitsTeam.getId();
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
		super.getMyTeam().addProjectile(new Projectile(66,22,side,getX()+50+xMod[teamIndex],getY()+30+yMod,41,7,super.getDamage()));
		if (super.getTarget().getAction()==2 && super.getAction()!=2){
			super.setAction(0);
		}		
	}
	
	
	
}
