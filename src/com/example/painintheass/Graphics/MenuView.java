package com.example.painintheass.Graphics;

import com.example.painintheass.UI.UIManager;
import com.example.painintheass.UI.Widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MenuView extends View{
	private MenuResourceManager MyRM;
	private UIManager MyUIM;
	private boolean fullyInitialized = false;
	
	public MenuView(Context context, AttributeSet attrs) {
		super(context, attrs);
		MyRM = new MenuResourceManager(context);
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
		invalidate();
		
	}


}
