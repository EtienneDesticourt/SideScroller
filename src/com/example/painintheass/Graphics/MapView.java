package com.example.painintheass.Graphics;

import com.example.painintheass.UI.Button;
import com.example.painintheass.UI.MapUIManager;
import com.example.painintheass.UI.UIManager;
import com.example.painintheass.UI.Widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MapView extends View{
	private MapResourceManager MyRM;
	private MapUIManager MyUIM;
	private boolean fullyInitialized = false;
	
	public MapView(Context context, AttributeSet attrs) {
		super(context, attrs);
		MyRM = new MapResourceManager(context);
		MyRM.load();
	}
	
	public void setUIManager(MapUIManager UIM){
		MyUIM = UIM;
	}

	public void doneInitialiazing() {
		fullyInitialized = true;
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent e){
		int action = e.getAction();
		Bitmap img;
		int pixel,px,py;
		Color c;
		if (action == MotionEvent.ACTION_DOWN && MyUIM.isOn()){
			Widget[] state = MyUIM.getCurrentState();
			for (int i=0; i<state.length;i++){
				if (state[i].isOver((int) e.getX(),(int) e.getY())){
					img = MyRM.getImage(state[i].getBackgroundImage());
					px = (int) e.getX() -state[i].getX() -1;
					py = (int) e.getY()-state[i].getY() -1;
					if (px >= img.getWidth() || py>= img.getHeight() || px<0 || py<0) { continue;}
					pixel = img.getPixel(px, py);					
					if (Color.alpha(pixel) != 0){
						state[i].onClick(MyUIM);
					}
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
		int troups, income, money;
		
		Bitmap background = MyRM.getImage(MyUIM.getCurrentBackgroundIndex());
		c.drawBitmap(background,0,0,null);
		
		Widget[] state = MyUIM.getCurrentState();
		Widget currWidget;
		Bitmap img;
		for (int i=0;i<state.length;i++){
			currWidget = state[i];
			if (currWidget.getString().equals("")){
				img = MyRM.getImage(currWidget.getCurrentImage());
				c.drawBitmap(img,currWidget.getX(),currWidget.getY(),null);
			}
			else{
				c.drawText(currWidget.getString(), currWidget.getX(), currWidget.getY(), currWidget.getPaint());
			}
		}
		
		
		invalidate();
		
	}

}
