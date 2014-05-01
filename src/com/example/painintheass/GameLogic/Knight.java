package com.example.painintheass.GameLogic;

import android.graphics.Rect;


public class Knight extends Unit {

	private static int[] xMod = {-70/4,-148/4};
	private static int yMod = 0/4;
	private static int width = 115/4;
	private static int height = 295/4;
	private static int sizeDif = 80;
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

	public void hit(int damage, boolean ranged, int type){
		this.setHit(true);
		if (ranged==false){
			super.hit(damage, ranged,type);
		}
	}
}
