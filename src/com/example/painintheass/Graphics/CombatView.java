package com.example.painintheass.Graphics;

import java.io.IOException;
import java.util.Date;

import com.example.painintheass.CombatActivity;
import com.example.painintheass.MapActivity;
import com.example.painintheass.GameLogic.Castle;
import com.example.painintheass.GameLogic.FallingProjectile;
import com.example.painintheass.GameLogic.Projectile;
import com.example.painintheass.GameLogic.Team;
import com.example.painintheass.GameLogic.Unit;
import com.example.painintheass.UI.CombatUIManager;
import com.example.painintheass.UI.UIManager;
import com.example.painintheass.UI.widgets.Button;
import com.example.painintheass.UI.widgets.Widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.AvoidXfermode.Mode;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

public class CombatView extends View{
	private ResourceManager MyRM;
	private CombatUIManager MyUIM;
	private boolean fullyInitialized = false;
	private int width,height;
	private Camera MyCamera;
	private boolean lastClicked = false;
	private Team[] MyTeams;
	private Paint MyPaint;
	private Paint ParticlePaint;
	private Paint IncomePaint;
	private Rect HealingRect;
	private boolean victoryState;
	private GestureDetector gestureDetector;
	private View.OnTouchListener gestureListener;// Gesture detection
	private boolean gameEnded;
	private ParticleHandler MyParticleHandler;

	public CombatView(Context context, AttributeSet attrs) {
		super(context, attrs);
		gameEnded = false;
		MyCamera = new Camera(10,0,1000);
		MyParticleHandler = new ParticleHandler();
		
		
		MyRM = new ResourceManager(context,"combat");
		try {
			MyRM.load();
			MyRM.loadAnim();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
		MyTeams = new Team[2];
		MyPaint = new Paint();
		ParticlePaint = new Paint();
//		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
//		    setLayerType(LAYER_TYPE_SOFTWARE, IncomePaint);
//		}
		
		IncomePaint = new Paint();
		IncomePaint.setTextAlign(Align.LEFT);
		IncomePaint.setAlpha(255);
		IncomePaint.setTextSize(IncomePaint.getTextSize()*2);
		Typeface tf = Typeface.create("Helvetica",Typeface.BOLD);
		IncomePaint.setTypeface(tf);
		IncomePaint.setFakeBoldText(true);
        IncomePaint.setStyle(Paint.Style.FILL);
        IncomePaint.setAntiAlias(true);
		IncomePaint.setColor(Color.GREEN);
		HealingRect = new Rect();
		

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
	
	public ResourceManager getMyRM(){
		return MyRM;
	}
	
	public void endGame(boolean state){
		gameEnded = true;
		CombatActivity dad = ((CombatActivity)getContext());
		MyUIM.getMyAI().quit();
		Intent returnIntent = new Intent();
		returnIntent.putExtra("result",state);
		dad.setResult(dad.RESULT_OK,returnIntent);
		Team.resetNumberOfTeams();
//		if (state==true){
//			//display win
//		}
//		else{
//			//display loss
//		}
        dad.finish(); //I KNOW I KNOW, IT'S WRONG
	}
	
	public void quitGame(int full){
		CombatActivity dad = ((CombatActivity)getContext());
		if (full==1){
			dad.endAll();
		}
		else if (full==2){
			endGame(victoryState);
		}
		else{
			dad.finish();
		}
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
			
//			MyCamera.shake();
			int dX = (int) MyCamera.getX();	
			int dY = (int) MyCamera.getY();	
			
			if (MyUIM.mustHealOnTouch()){ //HEALING SPELL
				HealingRect.set((int) e.getX()-100+dX, 0,(int) e.getX()+100+dX, 800);
				Unit[] Units = MyTeams[0].getUnits();
				Unit U;
				if (MyTeams[0].getMoney()<100) {
					MyUIM.setHealOnTouch(false);
					return true;
				}
				MyTeams[0].setMoney(MyTeams[0].getMoney()-100);
				for (int i=0;i<100;i++){
					U = Units[i];
					if (U == null) break;
					if (U.getType()==4) continue; //no healing castles
					if (Rect.intersects(U.getBodyRect(),HealingRect)){
						U.setLife(U.getMaxLife());
						MyParticleHandler.spawnStars(50,(int) U.getX()+U.getxMod(0)+20,(int) U.getY()+U.getyMod()+20);
						//System.out.println((U.getX()-dX+U.getxMod(0))+" "+dX+" "+e.getX());
					}
					
					
				}
				MyUIM.setHealOnTouch(false);
			}
			
			if (MyUIM.mustSpawnProjectile()){ //FIRE SPELL
				FallingProjectile P;
				int x,y;

				if (MyTeams[0].getMoney()<100) {
					MyUIM.setSpawnProjectile(false);
					return true;
				}
				MyTeams[0].setMoney(MyTeams[0].getMoney()-100);
				for (int i=0;i<5;i++){
					y = 0 -30*i;
					
					int mod=0;
					int jmax = 5;
					
					if (i/2 == i/2.0){
						mod = 15;
						jmax = 4;
					}
				
					
					
					
					for (int j = 0; j<jmax;j++){					
						
						x = (int)  e.getX()+dX -60 +30*j +mod ;
						P = new FallingProjectile(86,15,1,x,y,8,17,15);
						MyTeams[0].addProjectile(P);
					}
				
				MyUIM.setSpawnProjectile(false);
				}
			}
			
			
			Widget[] state = MyUIM.getCurrentState();
			for (int i=0; i<state.length;i++){
				if (state[i].isOver((int) e.getX(),(int) e.getY())){
					if (state[i].isOver((int) e.getX(),(int) e.getY())){
						state[i].onClickWrap(MyUIM);
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
	
	
	public void spawnStar(int centerX, int centerY){
		
	}
	
	public void spawnStars(int centerX, int centerY){
		
		
	}

	
 	protected void drawBackground(Canvas c){
		Bitmap sky = MyRM.getImage(0);
		Bitmap clouds = MyRM.getImage(1);
		Bitmap backMoun = MyRM.getImage(2);
		Bitmap frontMoun = MyRM.getImage(3);
		Bitmap grass = MyRM.getImage(4);
		

		int dX = (int) MyCamera.getX();
		int dY = (int) MyCamera.getY();
		
		c.drawBitmap(sky,0,0,null);	
		for (int i=0; i<6;i++){			
	        c.drawBitmap(clouds, (int) (0.152*width*(i+1))+(clouds.getWidth()*i)-dX/6, (int) (0.10625*height)-dY, null);
	        c.drawBitmap(backMoun, (backMoun.getWidth()*i)-dX/4, (int) (0.21875*height)-dY, null);
	        c.drawBitmap(frontMoun, (frontMoun.getWidth()*i)-dX/2, (int) (0.33125*height)-dY, null);
	        c.drawBitmap(grass, (grass.getWidth()*i)-dX, (int) (0.6875*height)-dY, null);
		}
	}
		
	protected void checkVictory(Unit currUnit, Canvas c){
		
		if (currUnit.getAction() == 2){ //IF DESTROYED
			
			if (currUnit.getMyTeam().getId()==0){ //IF MY TEAM: LOSE
				victoryState=false;
				MyUIM.setCurrentStateIndex(6);
//				c.drawBitmap(MyRM.getImage(77),c.getWidth()/2,c.getHeight()/2,null);
			}
			else{ //IF NOT MY TEAM: WIN
				victoryState=true;
				MyUIM.setCurrentStateIndex(5);
//				c.drawBitmap(MyRM.getImage(76),c.getWidth()/2,c.getHeight()/2,null);
			}
			
//			endGame(state);
		}
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
	
	
	protected void drawUnits(Canvas c){
		Rect newRect;
		Unit currUnit;
        Animation currAnim;
		float percent;
		int length;
		Bitmap image;
		int i,x,y,xmod;
		Matrix matrix = new Matrix();
		matrix.preScale(-1.0f, 1.0f);
		

		int dX = (int) MyCamera.getX();	
		int dY = (int) MyCamera.getY();		
		
		
        for (int teamIndex=0;teamIndex<2;teamIndex++){
  
        	int unitsNum = MyTeams[teamIndex].getUnitsNumber();
        	
        	for (int unitIndex=0;unitIndex<unitsNum;unitIndex++){
        		currUnit = MyTeams[teamIndex].getUnit(unitIndex);
        		
        		percent = currUnit.getLife()/ (float) currUnit.getMaxLife();
        		
        		length = (int) (percent*255);
        		MyPaint.setARGB(255,200, length,0);
        		MyPaint.setStyle(Paint.Style.STROKE);
//        		length =(int) (percent*100);
        		//c.drawRect(currUnit.getX()-dX+currUnit.getxMod(),currUnit.getY()-10+currUnit.getyMod(),currUnit.getX()-dX+length+currUnit.getxMod(),currUnit.getY()+currUnit.getyMod(),MyPaint);
        		
        		
        		
        		if (currUnit.getType()==4){// IF CASTLE
        			
        			Castle currUnit2 = (Castle) currUnit;
        			if ((int) (percent*100)/30 != currUnit2.getLastPercent()){ //shake every ten percent
        				currUnit2.setLastPercent( (int) (percent*100)/30);
        				MyCamera.shake();
        			}
        			checkVictory(currUnit,c);
        			
        			
        			
        			
        			if (percent>0.5) i = 68;
        			else i = 69;        			
        			image = MyRM.getImage(i);
        			
        			
    				c.drawBitmap(image,currUnit.getX()-dX+currUnit.getxMod(teamIndex),currUnit.getY()+currUnit.getyMod()-dY,null);
    				//newRect = currUnit.getBodyRect();
    				//c.drawRect(newRect.left-dX, newRect.top,newRect.right-dX,newRect.bottom,MyPaint);
        			continue; //Castles don't deal with animations
        		}
        		
        		x = currUnit.getX();
        		y = currUnit.getY();
        		
        		currAnim = MyRM.getAnimation(currUnit.getType(),currUnit.getAction());
        		image = MyRM.getImage(currAnim.getStart()+currUnit.getCurrFrame());
        		if (teamIndex==1) image = Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, false); 
        		if (currUnit.isHit()){
        			image = applyRedOverlay(image, MyRM.getImage(83)); //Red overlay
        			currUnit.increaseHitFrames();
        			if (currUnit.getHitFrames() > 8){
        				currUnit.setHitFrames(0);
        				currUnit.setHit(false);
        			}
        		}
        		c.drawBitmap(image,x-dX+currUnit.getxMod(teamIndex),currUnit.getY()+currUnit.getyMod()-dY,null);

        		

//				newRect = currUnit.getAttackRect();
//				c.drawRect(newRect.left-dX, newRect.top,newRect.right-dX,newRect.bottom,MyPaint);
//
//				newRect = currUnit.getBodyRect();
//				c.drawRect(newRect.left-dX, newRect.top,newRect.right-dX,newRect.bottom,MyPaint);
//				
//        		MyPaint.setARGB(255,255,0,0);
//        		MyPaint.setStyle(Paint.Style.FILL);
//        		c.drawRect(currUnit.getX()-dX, currUnit.getY(),currUnit.getX()+10-dX,currUnit.getY()+10,MyPaint);
        	}
        }
	}
	
	protected void drawParticles(Canvas c){
		
		Particle[] Particles = MyParticleHandler.getParticles();
		Particle P;
		Bitmap image;
		int dX = (int) MyCamera.getX();	
		int dY = (int) MyCamera.getY();	
		
		
		for (int i = 0;i<1000;i++){
			P = Particles[i];
			if (P == null) break;
			if (P.getAlpha() == 0) continue;
			image = MyRM.getImage(P.getImgIndex());
			
			ParticlePaint.setAlpha(P.getAlpha());
    		c.drawBitmap(image, (int) P.getX()-dX, (int) P.getY()-dY,ParticlePaint);			
		}
		
		
		
	}
	
	
	protected void drawGUI(Canvas c){
		
		Widget[] state = MyUIM.getCurrentState();
		Widget currWidget;
		Bitmap image;
		
		for (int i=0;i<state.length;i++){
			currWidget = state[i];
			
			if (currWidget.getString().equals("")){ //IF WIDGET NOT TEXT
				image = MyRM.getImage(currWidget.getCurrentImage());
				
				if (currWidget instanceof Button){ //TOUCH FEEDBACK
					Button B = (Button) currWidget;
					if (B.isClicked()){
						image = applyRedOverlay(image, MyRM.getImage(87)); //Red overlay
						
						long cur = new Date().getTime(); 
						if (cur-B.getFirstClicked() > 500){//FEEDBACK LENGTH
							B.setClicked(false);
						}
						
					}
        			
				}
				

				c.drawBitmap(image,currWidget.getX(),currWidget.getY(),null);
				
				
			}
			
			else{ //IF WIDGET TEXT
				c.drawText(currWidget.getString(), currWidget.getX(), currWidget.getY(), currWidget.getPaint());
			}
			
		}
	}
	
	protected void drawProjectiles(Canvas c){

        Projectile currProj;
		Bitmap image;

		int dX = (int) MyCamera.getX();
		int dY = (int) MyCamera.getY();
        
        for (int teamIndex=0;teamIndex<2;teamIndex++){
        	
        	for (int i=0;i<1000;i++){
        		currProj = MyTeams[teamIndex].getProjectile(i);
        		if (currProj == null) break;
        		
        		image = MyRM.getImage(currProj.getImage());
        		c.drawBitmap(image,currProj.getX()-dX,currProj.getY()-dY,null);
        		
        		
        		//Rect newRect = currProj.getMyRect();        		
        		//c.drawRect(newRect.left-dX,newRect.top,newRect.right-dX,newRect.bottom, MyPaint);
        	}
        	
        }
	}
	
	public Bitmap getIncomeImage(int amount){
		Bitmap result = Bitmap.createBitmap(100, 100, Config.ARGB_8888);
		Canvas c = new Canvas(result);
		Bitmap Coin = MyRM.getImage(81);
		String incomeStr;
		if (amount < 0) {
			IncomePaint.setColor(Color.RED);
			incomeStr = ""+String.valueOf(MyTeams[0].getLastMoneyMod());
		}
		else {		
			IncomePaint.setColor(Color.GREEN);
			incomeStr = "+"+String.valueOf(MyTeams[0].getLastMoneyMod());
		}
//		System.out.println(incomeStr);
		c.drawText(incomeStr,0,20,IncomePaint);
		c.drawBitmap(Coin, 14*incomeStr.length(),0,null);
		
		
		return result;
		
		
		
	}
	
	@Override
	protected void onDraw(Canvas c){
		if (!fullyInitialized || gameEnded){
			return;
		}
		
		if (MyUIM.isEndActivity()){
			quitGame(MyUIM.getExitFlag());
		}
		

		int dX = (int) MyCamera.getX();
		drawBackground(c);
		drawUnits(c);        
        drawProjectiles(c);
        drawParticles(c);
		drawGUI(c);
		MyUIM.updateMoney();
		if (MyTeams[0].getLastMoneyMod() != 0){
			MyRM.setImage(getIncomeImage(MyTeams[0].getLastMoneyMod()), 85);
			MyParticleHandler.spawnIncomeParticle(dX);
			MyTeams[0].setLastMoneyMod(0);
		}
		MyUIM.updateLabels();
		invalidate();
		
//		try {
//            Thread.sleep(500);
//        } catch (Exception exc) {}

	}
}
