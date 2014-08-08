package com.example.painintheass.Graphics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Manages the application's resources (drawable, files, etc...).
 */
public class ResourceManager {
	private Bitmap[] myImages;
	private Animation[][] myAnimations;
	private boolean runAnimation;
	private int numberOfAnims;
	
	//Res loading
	private Resources res;
	private String resFile;
	private String packName;
	private AssetManager AM;
	
	/**
	 * Creates a Resource Manager.
	 * @param myContext Activity's context
	 * @param resFilePath Path to the file containing the resource's names
	 */
	public ResourceManager(Context myContext, String resFilePath){
		Field[] drawables = android.R.drawable.class.getFields();
		myImages = new Bitmap[drawables.length];
		numberOfAnims = 0;
		myAnimations = new Animation[5][3];
		runAnimation = true;
		//Res loading
		res  = myContext.getResources();
		resFile = resFilePath;
		packName = myContext.getPackageName();
		AM = myContext.getAssets();
	}
	
	public ResourceManager(Context myContext){
		Field[] drawables = android.R.drawable.class.getFields();
		myImages = new Bitmap[drawables.length];
		numberOfAnims = 0;
		myAnimations = new Animation[5][3];
		runAnimation = true;
		//Res loading
		res  = myContext.getResources();
		packName = myContext.getPackageName();
	}
	
	
	
	/**
	 * Reads the resource file.
	 * @return An array containing the name of the resources.
	 * @throws IOException If the file doesn't exist.
	 */
	private String[] readResFile() throws IOException{
		InputStream inputStream = AM.open(resFile);
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);        
        //Read lines
        List<String> lines = new ArrayList<String>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }
        bufferedReader.close();
        return lines.toArray(new String[lines.size()]);
	}
	
	
	/**
	 * Loads into memory the drawables.
	 * @throws IOException If the resource file doesn't exist.
	 */
	public void load() throws IOException{
		
		System.out.println("NEW LOADING");
		//To reduce asset size in memory
		BitmapFactory.Options op = new BitmapFactory.Options();
		op.inPreferredConfig = Bitmap.Config.ARGB_4444;
		int height, width;
		int resID;
		Bitmap img;

		String[] imgInfos = readResFile();
		String[] imgInfo;
		String imgName;
		int imgScale;
		
		for (int i=0; i<imgInfos.length; i++){
			imgInfo = imgInfos[i].split(" ");
			imgName = imgInfo[0];
			imgScale = Integer.parseInt(imgInfo[1]);
			
			resID = res.getIdentifier(imgName, "drawable", packName);
			img = BitmapFactory.decodeResource(res, resID, op);
			//Scale
			if (imgScale != 1){
				height = img.getHeight();
				width = img.getWidth();
				img = Bitmap.createScaledBitmap(img, width/imgScale, height/imgScale, false);
			}
			//Append
			myImages[i] = img;
		}		
	}
	
	public Resources getRes(){
		return res;
	}
	
	
	public Bitmap[] getImages(){
		return myImages;
	}
	
	public void setImage(Bitmap img, int index){
		Bitmap[] Images = getImages();
		Images[index] = img;
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
	
	
}
