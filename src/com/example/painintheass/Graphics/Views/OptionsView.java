package com.example.painintheass.Graphics.Views;

import java.io.IOException;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.painintheass.CombatActivity;
import com.example.painintheass.Graphics.ResourceManager;
import com.example.painintheass.UI.UIManager;
import com.example.painintheass.UI.widgets.Widget;
import com.example.painintheass.menus.OptionsActivity;

/**
 * The view responsible for displaying the options menu and relaying events to the UI.
 */
public class OptionsView extends View{	
	private ResourceManager MyRM;
	private UIManager MyUIM;
	private boolean fullyInitialized;

	/**
	 * Creates a new <code>OptionsView</code> and loads all necessary assets.
	 */
	public OptionsView(Context context, AttributeSet attrs) {
		super(context, attrs);
		MyRM = new ResourceManager(context,"options");
		try {
			MyRM.load();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets the <code>UIManager</code> for this view. 
	 */
	public void setUIManager(UIManager UIM){
		MyUIM = UIM;
	}

	/**
	 * Indicates the <code>UIManager</code> has been set and allows view to start drawing.
	 */
	public void doneInitialiazing() {
		fullyInitialized = true;
		
	}
	
	/**
	 * Handles touch events and relays them to the individual touched widgets.
	 */
	@Override
	public boolean onTouchEvent(MotionEvent e){
		int action = e.getAction();
		if (action == MotionEvent.ACTION_DOWN && MyUIM.isOn()){
			Widget[] state = MyUIM.getCurrentState();
			for (int i=0; i<state.length;i++){
				if (state[i].isOver((int) e.getX(),(int) e.getY())){
					state[i].onClickWrap(MyUIM);
				}
			}
			
		}			
		return true;
	}
	
	public void endActivity(boolean state){
		OptionsActivity dad = ((OptionsActivity)getContext());
        dad.end(state); //I KNOW I KNOW, IT'S WRONG
	}
	
	/**
	 * Draws the UI's <code>Widgets</code> on screen. 
	 * It will not draw anything until the view's UI manager has been set and the  {@link OptionsView#doneInitialiazing() doneInitializing} function has been called.
	 */
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
