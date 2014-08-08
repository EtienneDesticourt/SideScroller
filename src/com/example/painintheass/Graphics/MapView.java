package com.example.painintheass.Graphics;

import java.io.IOException;
import java.util.Date;

import com.example.painintheass.UI.MapUIManager;
import com.example.painintheass.UI.UIManager;
import com.example.painintheass.UI.widgets.Button;
import com.example.painintheass.UI.widgets.Widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Bitmap.Config;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MapView extends View{
	private ResourceManager MyRM;
	private MapUIManager MyUIM;
	private boolean fullyInitialized = false;
	
	public MapView(Context context, AttributeSet attrs) {
		super(context, attrs);
		MyRM = new ResourceManager(context,"map");
		try {
			MyRM.load();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
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
						state[i].onClickWrap(MyUIM);
					}
				}
			}
			
		}			
		return true;
	}
	
	
	protected Bitmap applyRedOverlay(Bitmap original,Bitmap mask){
		
		Bitmap result = Bitmap.createBitmap(original.getWidth(), original.getHeight(), Config.ARGB_8888);
		Canvas mCanvas = new Canvas(result);
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
		mCanvas.drawBitmap(original, 0, 0, null);
		mCanvas.drawBitmap(mask, 0, 0, paint);
		
		return result;
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
//			int x,y,image;
//			String type;
//			if (currWidget instanceof Button){
//				type = ((Button) currWidget).getType();
//				x = currWidget.getX();
//				y = currWidget.getY();
//				image = currWidget.getCurrentImage();
//				type = ((Button) currWidget).getType();
//			}
			if (!currWidget.isVisible()) continue;
			if (currWidget.getString().equals("")){
				img = MyRM.getImage(currWidget.getCurrentImage());		
				
				if (currWidget instanceof Button){ //TOUCH FEEDBACK
					Button B = (Button) currWidget;
					if (B.isClicked()){
						img = applyRedOverlay(img, MyRM.getImage(31)); //Red overlay
						
						long cur = new Date().getTime(); 
						if (cur-B.getFirstClicked() > 500){//FEEDBACK LENGTH
							B.setClicked(false);
						}
						
					}
	    			
				}
				
				
				
				c.drawBitmap(img,currWidget.getX(),currWidget.getY(),null);
			}
			else{
				c.drawText(currWidget.getString(), currWidget.getX(), currWidget.getY(), currWidget.getPaint());
			}
		}
		
		
		invalidate();
		
	}

}
