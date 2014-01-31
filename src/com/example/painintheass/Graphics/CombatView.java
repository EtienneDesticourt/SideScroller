package com.example.painintheass.Graphics;

import com.example.painintheass.GameLogic.Projectile;
import com.example.painintheass.GameLogic.Team;
import com.example.painintheass.GameLogic.Unit;
import com.example.painintheass.UI.CombatUIManager;
import com.example.painintheass.UI.UIManager;
import com.example.painintheass.UI.Widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

public class CombatView extends View{
	private CombatResourceManager MyRM;
	private CombatUIManager MyUIM;
	private boolean fullyInitialized = false;
	private int width,height;
	private Camera MyCamera;
	private boolean lastClicked = false;
	private Team[] MyTeams;
	private Paint MyPaint;
	private GestureDetector gestureDetector;
	private View.OnTouchListener gestureListener;// Gesture detection

	public CombatView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		MyCamera = new Camera(10);
		MyRM = new CombatResourceManager(context);
		MyRM.load();
		MyTeams = new Team[2];
		MyPaint = new Paint();
		

	    gestureDetector = new GestureDetector(new MyGestureDetector());
	    gestureListener = new View.OnTouchListener() {
	        public boolean onTouch(View v, MotionEvent event) {
	            if (gestureDetector.onTouchEvent(event)) {
	                return true;
	            }
	            return false;
	        }
	    };
	    this.setOnTouchListener(gestureListener);
	
	
	}
	
	public void setUIManager(CombatUIManager NewUIM){
		MyUIM = NewUIM;
	}
	
	public void setDims(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public void setTeams(Team p, Team e){
		MyTeams[0] = p;
		MyTeams[1] = e;
	}
	
	public void doneInitialiazing(){
		fullyInitialized = true;
	}
	
	public CombatResourceManager getMyRM(){
		return MyRM;
	}
	
	protected class MyGestureDetector extends SimpleOnGestureListener {
		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
			//System.out.println(velocityX);
			int side;
			if (velocityX > 0){
				side = 1;
			}
			else{ 
				side = -1;
				velocityX = -velocityX;
			}
			MyCamera.pan(velocityX,0,side);
			
			return true;
		}
	}
	  
	
	@Override
	public boolean onTouchEvent(MotionEvent e){
		int action = e.getAction();
		
		//System.out.println(e.getX());
		if (action == MotionEvent.ACTION_DOWN){
			
//			if (lastClicked){
//				MyCamera.pan(2, width,1);
//				System.out.println("Camera: pan right.");
//			}
//			else{
//				MyCamera.pan(2, width,-1);
//				System.out.println("Camera: pan left.");
//			}
//			lastClicked = !lastClicked;
			
			Widget[] state = MyUIM.getCurrentState();
			for (int i=0; i<state.length;i++){
				if (state[i].isOver((int) e.getX(),(int) e.getY())){
					if (state[i].isOver((int) e.getX(),(int) e.getY())){
						state[i].onClick(MyUIM);
					}
				}
			}
			
			
		}
//		else 
//		if (action == MotionEvent.ACTION_MOVE){
//			myCamera.setX((int) e.getX());
//		}		
		return true;
	}
	
	
	@Override
	protected void onDraw(Canvas c){
		Rect newRect;
		if (!fullyInitialized){
			return;
		}
		
		//BACKGROUND
		Bitmap sky = MyRM.getImage(0);
		Bitmap clouds = MyRM.getImage(1);
		Bitmap backMoun = MyRM.getImage(2);
		Bitmap frontMoun = MyRM.getImage(3);
		Bitmap grass = MyRM.getImage(4);
		
		
		c.drawBitmap(sky,0,0,null);

		//PARALLAX
		int dX = (int) MyCamera.getX();
		
		for (int i=0; i<6;i++){			
	        c.drawBitmap(clouds, (int) (0.152*width*(i+1))+(clouds.getWidth()*i)-dX/6, (int) (0.10625*height), null);
	        c.drawBitmap(backMoun, 0+(backMoun.getWidth()*i)-dX/4, (int) (0.21875*height), null);
	        c.drawBitmap(frontMoun, 0+(frontMoun.getWidth()*i)-dX/2, (int) (0.33125*height), null);
	        c.drawBitmap(grass, 0+(grass.getWidth()*i)-dX, (int) (0.6875*height), null);
		}
		
		//UNITS
		Unit currUnit;
        Animation currAnim;
		float percent;
		int length;
        for (int teamIndex=0;teamIndex<2;teamIndex++){
        	int unitsNum = MyTeams[teamIndex].getUnitsNumber();
        	for (int unitIndex=0;unitIndex<unitsNum;unitIndex++){
        		currUnit = MyTeams[teamIndex].getUnit(unitIndex);
        		percent = currUnit.getLife()/ (float) currUnit.getMaxLife();
        		length = (int) (percent*255);
        		MyPaint.setARGB(255,200, length,0);
        		MyPaint.setStyle(Paint.Style.STROKE);
        		length =(int) (percent*100);
        		c.drawRect(currUnit.getX()-dX+currUnit.getxMod(),currUnit.getY()-10+currUnit.getyMod(),currUnit.getX()-dX+length+currUnit.getxMod(),currUnit.getY()+currUnit.getyMod(),MyPaint);
        		
        		//System.out.println(currUnit.getX());
        		if (currUnit.getType()==4){//Deals with castles
        			int i;
        			if (percent>0.5){
        				i = 68;
        			}
        			else{
        				i = 69;
        			}
    				c.drawBitmap(MyRM.getImage(i),currUnit.getX()-dX+currUnit.getxMod(),currUnit.getY()+currUnit.getyMod(),null);
    				newRect = currUnit.getBodyRect();
    				c.drawRect(newRect.left-dX, newRect.top,newRect.right-dX,newRect.bottom,MyPaint);
        			continue;
        		}
        		currAnim = MyRM.getAnimation(currUnit.getType(),currUnit.getAction());
//        		currAnim.start();
//        		currAnim.setBounds(currUnit.getBodyRect());
//        		currAnim.draw(c);
        		//c.draw
        		c.drawBitmap(MyRM.getImage(currAnim.getStart()+currUnit.getCurrFrame()),currUnit.getX()-dX+currUnit.getxMod(),currUnit.getY()+currUnit.getyMod(),null);

				newRect = currUnit.getBodyRect();
				c.drawRect(newRect.left-dX, newRect.top,newRect.right-dX,newRect.bottom,MyPaint);
        	}
        }
		//PROJECTILES
        Projectile currProj;
        for (int teamIndex=0;teamIndex<2;teamIndex++){
        	for (int i=0;i<1000;i++){
        		currProj = MyTeams[teamIndex].getProjectile(i);
        		if (currProj == null){
        			break;
        		}
        		c.drawBitmap(MyRM.getImage(currProj.getImage()),currProj.getX()-dX,currProj.getY(),null);
        		newRect = currProj.getMyRect();
        		
        		c.drawRect(newRect.left-dX,newRect.top,newRect.right-dX,newRect.bottom, MyPaint);
        	}
        }
        
        
		//GUI	
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
		
//		try {
//            Thread.sleep(500);
//        } catch (Exception exc) {}
//		
	}
}
