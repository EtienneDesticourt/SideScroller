package com.example.painintheass.GameLogic.Units;

import com.example.painintheass.GameLogic.Team;

import android.graphics.Rect;

/**
 * Represents a Knight unit.
 * Weak against magic, strong against physical attacks.
 */
public class Knight extends Unit {

	private static int[] xMod = {-70/4,-148/4};
	private static int yMod = 0/4;
	private static int width = 115/4;
	private static int height = 295/4;
	private static int sizeDif = 80;
	
	/**
	 * Creates a Knight.
	 * @param unitsTeam The Knight's team
	 */
	public Knight(Team unitsTeam) {
		super(unitsTeam);
		super.setType(2);
		Rect temp = super.getBodyRect();
		super.setBodyRect(temp.left, temp.top+sizeDif, width, height);
		super.setxMod(xMod);		
		super.setyMod(yMod);
		super.setAttackRange(50);
		super.setAttackSpeed(1000);
		super.init();
	}

	/**
	 * Called when the Knight is hit.
	 */
	public void hit(int damage, boolean ranged, int type){
		this.setHit(true);
		super.hit(damage, ranged,type);
	}
}
