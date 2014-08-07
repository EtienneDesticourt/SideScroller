package com.example.painintheass.Graphics;

import com.example.painintheass.R;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class MapResourceManager extends ResourceManager{

	public MapResourceManager(Context myContext) {
		super(myContext);
		// TODO Auto-generated constructor stub
	}
	
	public void load(){
		Bitmap[] images = getImages();
		Resources res = getRes();
		
		images[0] = BitmapFactory.decodeResource(res, R.drawable.background_map);
		images[1] = BitmapFactory.decodeResource(res, R.drawable.region1_light);
		images[2] = BitmapFactory.decodeResource(res, R.drawable.region1_friend);
		images[3] = BitmapFactory.decodeResource(res, R.drawable.region1_enemy);
		images[4] = BitmapFactory.decodeResource(res, R.drawable.region2_light);
		images[5] = BitmapFactory.decodeResource(res, R.drawable.region2_friend);
		images[6] = BitmapFactory.decodeResource(res, R.drawable.region2_enemy);
		images[7] = BitmapFactory.decodeResource(res, R.drawable.region3_light);
		images[8] = BitmapFactory.decodeResource(res, R.drawable.region3_friend);
		images[9] = BitmapFactory.decodeResource(res, R.drawable.region3_enemy);
		images[10] = BitmapFactory.decodeResource(res, R.drawable.region4_light);
		images[11] = BitmapFactory.decodeResource(res, R.drawable.region4_friend);
		images[12] = BitmapFactory.decodeResource(res, R.drawable.region4_enemy);
		images[13] = BitmapFactory.decodeResource(res, R.drawable.region5_light);
		images[14] = BitmapFactory.decodeResource(res, R.drawable.region5_friend);
		images[15] = BitmapFactory.decodeResource(res, R.drawable.region5_enemy);
		images[16] = BitmapFactory.decodeResource(res, R.drawable.region6_light);
		images[17] = BitmapFactory.decodeResource(res, R.drawable.region6_friend);
		images[18] = BitmapFactory.decodeResource(res, R.drawable.region6_enemy);
		images[19] = BitmapFactory.decodeResource(res, R.drawable.nextturn);
		images[20] = BitmapFactory.decodeResource(res, R.drawable.attackgrey);
		images[21] = BitmapFactory.decodeResource(res, R.drawable.resolvegrey);
		images[22] = BitmapFactory.decodeResource(res, R.drawable.attack);
		images[23] = BitmapFactory.decodeResource(res, R.drawable.resolve);
		images[24] = BitmapFactory.decodeResource(res, R.drawable.mapcoin);
		images[25] = BitmapFactory.decodeResource(res, R.drawable.soldiercoin);
		images[26] = BitmapFactory.decodeResource(res, R.drawable.cross);
		images[27] = BitmapFactory.decodeResource(res, R.drawable.skills_map);
		images[28] = BitmapFactory.decodeResource(res, R.drawable.skills_greyed_map);
		images[29] = BitmapFactory.decodeResource(res, R.drawable.attack_arrow);
		images[30] = BitmapFactory.decodeResource(res, R.drawable.nextturngrey);
		images[31] = BitmapFactory.decodeResource(res, R.drawable.grey_overlay);
		
		
	}

}
