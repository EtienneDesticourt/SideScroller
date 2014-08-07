package com.example.painintheass.Graphics;

import com.example.painintheass.R;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class MenuResourceManager extends ResourceManager{

	public MenuResourceManager(Context myContext) {
		super(myContext);
		// TODO Auto-generated constructor stub
	}
	
	public void load(){
		Bitmap[] images = getImages();
		Resources res = getRes();
		
		images[0] = BitmapFactory.decodeResource(res, R.drawable.background);
		images[1] = BitmapFactory.decodeResource(res, R.drawable.play);
		images[2] = BitmapFactory.decodeResource(res, R.drawable.options);
		images[3] = BitmapFactory.decodeResource(res, R.drawable.quit);
		images[4] = BitmapFactory.decodeResource(res, R.drawable.gametitle);
		images[5] = BitmapFactory.decodeResource(res, R.drawable.grey_overlay);
		
		
		
	}
	

}
