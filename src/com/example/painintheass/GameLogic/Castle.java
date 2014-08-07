package com.example.painintheass.GameLogic;

import android.graphics.Rect;

/**
 * Represents a Castle.
 */
public class Castle extends Unit{
	private static int[] xMod = {-30,-30};
	private static int yMod = 0;
	private static int width = 200;
	private static int height = 235;
	private static int sizeDif = -60;
	private int lastPercent = 3;
	
	/**
	 * Creates a castle for a team.
	 * @param unitsTeam Team for which the castle is created.
	 */
	public Castle(Team unitsTeam) {
		super(unitsTeam);
		Rect temp = super.getBodyRect();
		super.setBodyRect(temp.left, temp.top+sizeDif, width, height);
		super.setxMod(xMod);		
		super.setyMod(yMod);
		super.setType(4);
		super.setAction(4); //action 4: Being a castle :D
		super.setMaxLife(1000);
		super.setLife(1000);
		super.init();
	}

	
	public int getLastPercent() {
		return lastPercent;
	}


	public void setLastPercent(int lastPercent) {
		this.lastPercent = lastPercent;
	}
	
	public void hit(int damage, boolean ranged, int type){
		if (type == 1){
			return;
		}
		super.hit(damage,ranged,type);
	}
	
	

}
