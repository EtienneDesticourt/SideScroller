package com.example.painintheass.GameLogic;

import android.graphics.Rect;

public class Castle extends Unit{
	private static int xMod = -30;
	private static int yMod = 0;
	private static int width = 200;
	private static int height = 235;
	private static int sizeDif = -60;
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
	
	
	
	

}
