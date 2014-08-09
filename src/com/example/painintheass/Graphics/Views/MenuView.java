package com.example.painintheass.Graphics.Views;

import java.io.IOException;
import java.util.Date;

import com.example.painintheass.Graphics.ResourceManager;
import com.example.painintheass.UI.UIManager;
import com.example.painintheass.UI.widgets.Button;
import com.example.painintheass.UI.widgets.Widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Bitmap.Config;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;



/**
 * The view responsible for displaying the main menu and relaying events to the UI.
 */
public class MenuView extends View{
	private ResourceManager MyRM;
	private UIManager MyUIM;
	private boolean fullyInitialized = false;
	
	/**
	 * Creates a new <code>MenuView</code> and loads all necessary assets.
	 */
	public MenuView(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		//Create resource handle and load all required assets
		MyRM = new ResourceManager(context, "menu");
		try {
			MyRM.load();
		} catch (IOException e) {
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
		//If action is a touch and the UI is active
		if (e.getAction() == MotionEvent.ACTION_DOWN && MyUIM.isOn()){	
			Widget[] state = MyUIM.getCurrentState();
			//Activate widget under touch
			for (int i=0; i<state.length;i++){
				if (state[i].isOver((int) e.getX(),(int) e.getY())){
					state[i].onClickWrap(MyUIM);
				}
			}			
		}			
		return true;
	}
	
	protected Bitmap applyRedOverlay(Bitmap original,Bitmap mask){
		//Create empty bitmap and canvas of same size
		Bitmap result = Bitmap.createBitmap(original.getWidth(), original.getHeight(), Config.ARGB_8888);
		Canvas mCanvas = new Canvas(result);
		//Create multiplication paint
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
		//Multiply red overlay and original bitmap
		mCanvas.drawBitmap(original, 0, 0, null);
		mCanvas.drawBitmap(mask, 0, 0, paint);
		
		return result;
	}
	
	/**
	 * Draws the UI's <code>Widgets</code> on screen. 
	 * It will not draw anything until the view's UI manager has been set and the  {@link MenuView#doneInitialiazing() doneInitializing} function has been called.
	 */
	@Override
	protected void onDraw(Canvas c){		
		if (!fullyInitialized){ //Don't draw anything until UI handle is set.
			return;
		}
		
		Bitmap background = MyRM.getImage(MyUIM.getCurrentBackgroundIndex());
		c.drawBitmap(background,0,0,null);
		
		
		Widget[] state = MyUIM.getCurrentState();
		Widget currWidget;
		Bitmap img;
		
		//Draw all widgets in current state 
		for (int i=0;i<state.length;i++){
			currWidget = state[i];
			img = MyRM.getImage(currWidget.getCurrentImage());
			
			//TOUCH FEEDBACK
			if (currWidget instanceof Button){ 
				Button B = (Button) currWidget;
				if (B.isClicked()){
					img = applyRedOverlay(img, MyRM.getImage(5)); //Red overlay
					
					long cur = new Date().getTime(); 
					if (cur-B.getFirstClicked() > 500){//FEEDBACK LENGTH
						B.setClicked(false);
					}					
				}    			
			}
			/////////////////////
			
			//Draw widget
			c.drawBitmap(img,currWidget.getX(),currWidget.getY(),null);
		}
		
		invalidate();
		
	}


}
