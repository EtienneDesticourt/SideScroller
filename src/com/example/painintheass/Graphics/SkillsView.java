package com.example.painintheass.Graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.painintheass.OptionsActivity;
import com.example.painintheass.SkillsActivity;
import com.example.painintheass.UI.UIManager;
import com.example.painintheass.UI.Widget;

public class SkillsView extends View{
	
	private SkillsResourceManager MyRM;
	private UIManager MyUIM;
	private boolean fullyInitialized;


	public SkillsView(Context context, AttributeSet attrs) {
		super(context, attrs);
		MyRM = new SkillsResourceManager(context);
		MyRM.load();
	}
	
	public void setUIManager(UIManager UIM){
		MyUIM = UIM;
	}

	public void doneInitialiazing() {
		fullyInitialized = true;
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent e){
		int action = e.getAction();
		if (action == MotionEvent.ACTION_DOWN && MyUIM.isOn()){
			Widget[] state = MyUIM.getCurrentState();
			for (int i=0; i<state.length;i++){
				if (state[i].isOver((int) e.getX(),(int) e.getY())){
					state[i].onClick(MyUIM);
				}
			}
			
		}			
		return true;
	}
	
	public void endActivity(boolean state){
		SkillsActivity dad = ((SkillsActivity)getContext());
        dad.end(state); //I KNOW I KNOW, IT'S WRONG
	}
	
	
	@Override
	protected void onDraw(Canvas c){		
		if (!fullyInitialized){
			return;
		}
		
		Bitmap background = MyRM.getImage(MyUIM.getCurrentBackgroundIndex());
		c.drawBitmap(background,0,0,null);
		
		Widget[] state = MyUIM.getCurrentState();
		Widget currWidget;
		Bitmap img;
		for (int i=0;i<state.length;i++){
			currWidget = state[i];
			img = MyRM.getImage(currWidget.getCurrentImage());
			c.drawBitmap(img,currWidget.getX(),currWidget.getY(),null);
		}
		
		if (MyUIM.isEndActivity()){
			endActivity(MyUIM.mustUpdate());
		}
		
		invalidate();
		
	}



}
