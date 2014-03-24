package com.example.painintheass.Graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.painintheass.R;

public class SkillsResourceManager extends ResourceManager{
	

		public SkillsResourceManager(Context myContext) {
			super(myContext);
		}
		
		public void load(){
			Bitmap[] images = getImages();
			Resources res = getRes();
			
			images[0] = BitmapFactory.decodeResource(res, R.drawable.background_skills);
			images[1] = BitmapFactory.decodeResource(res, R.drawable.title_skills);
			images[2] = BitmapFactory.decodeResource(res, R.drawable.arrow_greyed_skills);
			images[3] = BitmapFactory.decodeResource(res, R.drawable.arrow_skills);
			images[4] = BitmapFactory.decodeResource(res, R.drawable.upgrade_time);
			images[5] = BitmapFactory.decodeResource(res, R.drawable.upgrade_cost);
			images[6] = BitmapFactory.decodeResource(res, R.drawable.upgrade_strength);
			images[7] = BitmapFactory.decodeResource(res, R.drawable.upgrade_mana);
//			images[8] = BitmapFactory.decodeResource(res, R.drawable.label_mana);
//			images[9] = BitmapFactory.decodeResource(res, R.drawable.label_cost);
//			images[10] = BitmapFactory.decodeResource(res, R.drawable.label_time);
//			images[11] = BitmapFactory.decodeResource(res, R.drawable.label_strength);
			images[12] = BitmapFactory.decodeResource(res, R.drawable.cross_skills);
			images[13] = BitmapFactory.decodeResource(res, R.drawable.ok_skills);
			images[14] = BitmapFactory.decodeResource(res, R.drawable.cancel_skills);
			images[15] = BitmapFactory.decodeResource(res, R.drawable.reset_skills);
			images[16] = BitmapFactory.decodeResource(res, R.drawable.coin_skills);
			
			
			
			
			
		}
}
