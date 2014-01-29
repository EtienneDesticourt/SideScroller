//package com.example.painintheass.Graphics;
//
//import com.example.painintheass.GameLogic.AI;
//import com.example.painintheass.GameLogic.Team;
//import com.example.painintheass.GameLogic.Unit;
//import com.example.painintheass.UI.UIManager;
//import com.example.painintheass.UI.Widget;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.Canvas;
//import android.graphics.Paint;
//import android.util.AttributeSet;
//import android.view.KeyEvent;
//import android.view.MotionEvent;
//import android.view.View;
//
//public class CustomView extends View{
//
//	private ResourceManager myResourceManager;
//	private Camera myCamera;
//	private Team[] myTeams;
//	private AI myAI;
//	private Paint myPaint;
//	private UIManager myUIManager;
//	private boolean fullyInitialized = false;
//	
//	public CustomView(Context context, AttributeSet attrs) {
//		super(context, attrs);
//		myResourceManager = new ResourceManager(context);
//		myCamera = new Camera(1);
//		myTeams = new Team[2];
//		myPaint = new Paint();
//	}
//	
//	public ResourceManager getMyResourceManager(){
//		return myResourceManager;
//	}
//
//	public void doneInitialiazing(){
//		//I don't know why I don't just change the init ... guess it's just laziness. 
//		fullyInitialized = true;
//	}
//	
//	public void setTeams(Team[] newTeams){
//		myTeams = newTeams;		
//	}
//	
//	public void setAI(AI newAI){
//		myAI = newAI;
//	}
//	
//	public void setUIManager(UIManager newUIManager){
//		myUIManager = newUIManager;
//	}
//	
//	@Override
//	public boolean onKeyDown(int keyCode, KeyEvent event) {
//	    if (keyCode == KeyEvent.KEYCODE_BACK ) {
//	    	System.out.println("Quitting.");
//	        myAI.quit();
//	    }
//	    return super.onKeyDown(keyCode, event);
//	}
//	
//	
//	@Override
//	public boolean onTouchEvent(MotionEvent e){
//		int action = e.getAction();
//		
//		//System.out.println(e.getX());
//		if (action == MotionEvent.ACTION_DOWN){
//			if (myUIManager.isOn()){
//				System.out.println("Clicking .");
//				Widget[] state = myUIManager.getCurrentState();
//				for (int i=0; i <state.length;i++){
//					if (state[i].isOver((int) e.getX(),(int) e.getY())){
//						System.out.println("Clicking button.");
//						state[i].onClick(myUIManager);
//					}
//				}
//			}
//			
//			Unit[] enemyTeam = myUIManager.getMyEnemyTeam().getUnits();
//			for (int i=0;i<100;i++){
//				if (enemyTeam[i]==null)	break;
//				if (enemyTeam[i].getBodyRect().contains((int) e.getX(), (int) e.getY())){
//					myUIManager.getMyPlayer().setTarget(enemyTeam[i]);
//					break;
//				}
//				
//			}
//			
//			
////			else{
////				myCamera.setX((int) e.getX());
////				System.out.println("Camera:"+myCamera.getX());
////			}
//			
//		}
////		else 
////		if (action == MotionEvent.ACTION_MOVE){
////			myCamera.setX((int) e.getX());
////		}		
//		return true;
//	}
//	
//	
//	
//	@Override
//    protected void onDraw(Canvas canvas)
//    {
//		if (!fullyInitialized){
//			return;
//		}
//		if (myUIManager.isOn()){
//			Widget[] state = myUIManager.getCurrentState();
//			Widget currWidget;
//			Bitmap img;
//			for (int i=0;i<state.length;i++){
//				currWidget = state[i];
//				img = myResourceManager.getImage(currWidget.getCurrentImage());
//				canvas.drawBitmap(img,currWidget.getX(),currWidget.getY(),null);
//			}			
//		}
//		if (myUIManager.isAGameState(myUIManager.getCurrentStateIndex())){		
//			super.onDraw(canvas);
//			
//			
//			//System.out.println("I'm being drawn !");
//			int dX = myCamera.getX();
//			//draw backgrounds
//			
//			canvas.drawBitmap(myResourceManager.getImage(6), 0, 0, null);
//	        canvas.drawBitmap(myResourceManager.getImage(3), 0-dX/6, 0, null);
//	        canvas.drawBitmap(myResourceManager.getImage(2), 0-dX/4, 0, null);
//	        canvas.drawBitmap(myResourceManager.getImage(1), 0-dX/2, 0, null);
//	        canvas.drawBitmap(myResourceManager.getImage(0), 0-dX, 0, null);
//	        canvas.drawBitmap(myResourceManager.getImage(4), 0-dX, 0, null);
//	        canvas.drawBitmap(myResourceManager.getImage(5), 0-dX, 0, null);
//	        
//	        //draw units
//	        Unit currUnit;
//	        Animation currAnim;
//    		float percent;
//    		int length;
//	        for (int teamIndex=0;teamIndex<2;teamIndex++){
//	        	int unitsNum = myTeams[teamIndex].getUnitsNumber();
//	        	for (int unitIndex=0;unitIndex<unitsNum;unitIndex++){
//	        		currUnit = myTeams[teamIndex].getUnit(unitIndex);
//	        		percent = currUnit.getLife()/ (float) currUnit.getMaxLife();
//	        		length = (int) (percent*255);
//	        		myPaint.setARGB(255,200, length,0);
//	        		length =(int) (percent*100);
//	        		canvas.drawRect(currUnit.getX()-dX,currUnit.getY()-10,currUnit.getX()-dX+length,currUnit.getY(),myPaint);
//	        		
//	        		//System.out.println(currUnit.getX());
//	        		currAnim = myResourceManager.getAnimation(currUnit.getType(),currUnit.getAction());
//	        		canvas.drawBitmap(myResourceManager.getImage(currAnim.getStart()+currUnit.getCurrFrame()),currUnit.getX()-dX,currUnit.getY(),null);
//	        	}
//	        }
//			///////////////////
//	        
//	        //app idea : planet thrower
//	//		
//	//		System.out.println(0-myCamera.getX()/6);
//	//		System.out.println(0-myCamera.getX());
//	//		System.out.println(myCamera.getX());
//			
//	//        if (myResourceManager.getImages()[0]!=null){
//	//        	
//	//            System.out.println("Something has been drawn .");
//	//        	canvas.drawBitmap(myResourceManager.getImages()[0], 0, 0,null);
//	//        }
//		}
//        
//        invalidate();
//    }
//	
//}
