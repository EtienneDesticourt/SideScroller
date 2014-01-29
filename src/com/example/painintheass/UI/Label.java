package com.example.painintheass.UI;


public class Label extends Widget{
	
	public Label(int x, int y, int backgroundImage) {
		super(x, y, 10,10);
		this.setBackgroundImage(backgroundImage);
	}

	@Override
	public void onClick(UIManager myUIM) {
		
	}
	
	public boolean isOver(int[] pos){
		return false;
	}
	
}
