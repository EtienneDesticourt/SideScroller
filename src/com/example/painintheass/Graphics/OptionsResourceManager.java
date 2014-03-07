package com.example.painintheass.Graphics;

import com.example.painintheass.R;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class OptionsResourceManager extends ResourceManager{

		public OptionsResourceManager(Context myContext) {
			super(myContext);
		}
		
		public void load(){
			Bitmap[] images = getImages();
			Resources res = getRes();
			
			images[0] = BitmapFactory.decodeResource(res, R.drawable.background_options);
			images[1] = BitmapFactory.decodeResource(res, R.drawable.volumeKnob);
			images[2] = BitmapFactory.decodeResource(res, R.drawable.volumeKnobInvisible);
			images[3] = BitmapFactory.decodeResource(res, R.drawable.volumeBar);
			
			
			
		}
}
