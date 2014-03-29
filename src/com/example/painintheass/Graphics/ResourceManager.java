package com.example.painintheass.Graphics;

import java.lang.reflect.Field;

import com.example.painintheass.R;
import com.example.painintheass.R.drawable;
//import android.app.Activity;
//import android.R;
import android.content.Context;
import android.content.res.Resources;
//import android.graphics.drawable.Drawable;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
//import android.graphics.drawable.Drawable;
import android.graphics.drawable.AnimationDrawable;

public class ResourceManager {
	private Bitmap[] myImages;
	private Animation[][] myAnimations;
	private boolean runAnimation;
	private int numberOfAnims;
	private Resources res;
	
	public ResourceManager(Context myContext){
		Field[] drawables = android.R.drawable.class.getFields();
		myImages = new Bitmap[drawables.length];
		numberOfAnims = 0;
		myAnimations = new Animation[5][3];
		runAnimation = true;
		res  = myContext.getResources();	
	}
	
	public void load(){
		//myImages[0] = BitmapFactory.decodeResource(res, R.drawable.fond0);
	}
	
	public Resources getRes(){
		return res;
	}
	
	public Bitmap[] getImages(){
		return myImages;
	}
	
	public Bitmap getImage(int index){
		return myImages[index];
	}
	
	public Animation getAnimation(int unitType,int action){
		return myAnimations[unitType][action];
	}
	
	public void addAnimation(int unitType,int action,Animation anim){
		myAnimations[unitType][action] = anim;
	}
	
	
	
	
//	public void animate(){
//		new Thread(new Runnable() {
//	        public void run() {
//				while (runAnimation){
//					for (int i=0;i<numberOfAnims;i++){
//						myAnimations[i]
//					}
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//	        }
//		}).start();	
//	}
	
}
