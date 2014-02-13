package com.example.painintheass.Graphics;

import com.example.painintheass.R;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;

public class CombatResourceManager extends ResourceManager{

	public CombatResourceManager(Context myContext) {
		super(myContext);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void load(){
		Bitmap[] images = getImages();
		Resources res = getRes();
		BitmapFactory.Options op = new BitmapFactory.Options();
		op.inPreferredConfig = Bitmap.Config.ARGB_4444;

		images[0] = BitmapFactory.decodeResource(res, R.drawable.background_sky,op);
		images[1] = BitmapFactory.decodeResource(res, R.drawable.background_clouds,op);
		images[2] = BitmapFactory.decodeResource(res, R.drawable.background_backmountains,op);
		images[3] = BitmapFactory.decodeResource(res, R.drawable.background_frontmountains,op);
		images[4] = BitmapFactory.decodeResource(res, R.drawable.background_grass,op);
		images[5] = BitmapFactory.decodeResource(res, R.drawable.combat_archer,op);
		images[6] = BitmapFactory.decodeResource(res, R.drawable.combat_knights,op);
		images[7] = BitmapFactory.decodeResource(res, R.drawable.combat_mage,op);
		images[8] = BitmapFactory.decodeResource(res, R.drawable.menu_mainmenu,op);
		images[9] = BitmapFactory.decodeResource(res, R.drawable.spells_spells,op);
		images[70] = BitmapFactory.decodeResource(res, R.drawable.spells_fire,op);
		images[71] = BitmapFactory.decodeResource(res, R.drawable.spells_light,op);
		images[72] = BitmapFactory.decodeResource(res, R.drawable.spells_stars,op);
		images[73] = BitmapFactory.decodeResource(res, R.drawable.menu_map,op);
		images[74] = BitmapFactory.decodeResource(res, R.drawable.menu_options,op);
		images[75] = BitmapFactory.decodeResource(res, R.drawable.menu_quit,op);
		images[76] = BitmapFactory.decodeResource(res, R.drawable.defeat,op);
		images[77] = BitmapFactory.decodeResource(res, R.drawable.victory,op);
		//Anims
		
//		AnimationDrawable anim;
//		anim = (AnimationDrawable) res.getDrawable(R.drawable.knightwalk);
//		anim.stop();
//		anim.start();
//		this.addAnimation(2,0,anim);
		
//		//Anim frames
		Animation anim;
//			//knight
//				//walk
		images[49] = BitmapFactory.decodeResource(res, R.drawable.knight0,op);
		
		images[50] = BitmapFactory.decodeResource(res, R.drawable.knight1,op);
		images[51] = BitmapFactory.decodeResource(res, R.drawable.knight2,op);
		images[52] = BitmapFactory.decodeResource(res, R.drawable.knight3,op);
		images[53] = BitmapFactory.decodeResource(res, R.drawable.knight4,op);
		anim = new Animation(49,53,2);
		this.addAnimation(2, 0, anim);
		//System.out.println("Token 1");
				//fight
		images[54] = BitmapFactory.decodeResource(res, R.drawable.knight5,op);
		images[55] = BitmapFactory.decodeResource(res, R.drawable.knight6,op);
		images[56] = BitmapFactory.decodeResource(res, R.drawable.knight7,op);
		images[57] = BitmapFactory.decodeResource(res, R.drawable.knight8,op);
		images[58] = BitmapFactory.decodeResource(res, R.drawable.knight9,op);
		anim = new Animation(54,58,2);
		this.addAnimation(2, 1, anim);
		//System.out.println("Token 12");
				//die
		images[59] = BitmapFactory.decodeResource(res, R.drawable.knight10,op);
		images[60] = BitmapFactory.decodeResource(res, R.drawable.knight11,op);
		images[61] = BitmapFactory.decodeResource(res, R.drawable.knight12,op);
		images[62] = BitmapFactory.decodeResource(res, R.drawable.knight13,op);
		images[63] = BitmapFactory.decodeResource(res, R.drawable.knight14,op);
		images[64] = BitmapFactory.decodeResource(res, R.drawable.knight15,op);
		images[65] = BitmapFactory.decodeResource(res, R.drawable.knight16,op);
		anim = new Animation(59,65,2);
		this.addAnimation(2, 2, anim);
		//System.out.println("Token 13");
			//archer
				//walk
		images[46] = BitmapFactory.decodeResource(res, R.drawable.archer14,op);
		images[47] = BitmapFactory.decodeResource(res, R.drawable.archer15,op);
		images[48] = BitmapFactory.decodeResource(res, R.drawable.archer16,op);
		anim = new Animation(46,48,2);
		this.addAnimation(1, 0, anim);
		//System.out.println("Token 14");
				//fight
		images[40] = BitmapFactory.decodeResource(res, R.drawable.archer8,op);
		images[41] = BitmapFactory.decodeResource(res, R.drawable.archer9,op);
		images[42] = BitmapFactory.decodeResource(res, R.drawable.archer10,op);
		images[43] = BitmapFactory.decodeResource(res, R.drawable.archer11,op);
		images[44] = BitmapFactory.decodeResource(res, R.drawable.archer12,op);
		images[45] = BitmapFactory.decodeResource(res, R.drawable.archer13,op);
		anim = new Animation(40,45,2);
		this.addAnimation(1, 1, anim);
		//System.out.println("Token 15");
				//die
		images[32] = BitmapFactory.decodeResource(res, R.drawable.archer0,op);
		images[33] = BitmapFactory.decodeResource(res, R.drawable.archer1,op);
		images[34] = BitmapFactory.decodeResource(res, R.drawable.archer2,op);
		images[35] = BitmapFactory.decodeResource(res, R.drawable.archer3,op);
		images[36] = BitmapFactory.decodeResource(res, R.drawable.archer4,op);
		images[37] = BitmapFactory.decodeResource(res, R.drawable.archer5,op);
		images[38] = BitmapFactory.decodeResource(res, R.drawable.archer6,op);
		anim = new Animation(32,38,2);
		this.addAnimation(1, 2, anim);
		//System.out.println("Token 16");
			//mage
				//walk
		images[10] = BitmapFactory.decodeResource(res, R.drawable.mage0,op);
		images[11] = BitmapFactory.decodeResource(res, R.drawable.mage1,op);
		images[12] = BitmapFactory.decodeResource(res, R.drawable.mage2,op);
		images[13] = BitmapFactory.decodeResource(res, R.drawable.mage3,op);
		anim = new Animation(10,13,2);
		this.addAnimation(3, 0, anim);
		//System.out.println("Token 17");
				//fight
		images[14] = BitmapFactory.decodeResource(res, R.drawable.mage4,op);
		images[15] = BitmapFactory.decodeResource(res, R.drawable.mage5,op);
		images[16] = BitmapFactory.decodeResource(res, R.drawable.mage6,op);
		images[17] = BitmapFactory.decodeResource(res, R.drawable.mage7,op);
		anim = new Animation(14,17,2);
		this.addAnimation(3, 1, anim);
		//System.out.println("Token 18");
				//die
		images[18] = BitmapFactory.decodeResource(res, R.drawable.mage8,op);
		images[19] = BitmapFactory.decodeResource(res, R.drawable.mage9,op);
		images[20] = BitmapFactory.decodeResource(res, R.drawable.mage10,op);
		images[21] = BitmapFactory.decodeResource(res, R.drawable.mage11,op);
		images[22] = BitmapFactory.decodeResource(res, R.drawable.mage12,op);
		images[23] = BitmapFactory.decodeResource(res, R.drawable.mage13,op);
		images[24] = BitmapFactory.decodeResource(res, R.drawable.mage14,op);
		images[25] = BitmapFactory.decodeResource(res, R.drawable.mage15,op);
		images[26] = BitmapFactory.decodeResource(res, R.drawable.mage16,op);
		images[27] = BitmapFactory.decodeResource(res, R.drawable.mage17,op);
		images[28] = BitmapFactory.decodeResource(res, R.drawable.mage18,op);
		anim = new Animation(18,28,2);
		this.addAnimation(3, 2, anim);
		//System.out.println("Token 19");

		//projectiles
		images[66] = BitmapFactory.decodeResource(res,R.drawable.projectile_arrow,op);
		images[67] = BitmapFactory.decodeResource(res,R.drawable.projectile_magic,op);
		//Castle
		images[68] = BitmapFactory.decodeResource(res,R.drawable.castle,op);
		images[69] = BitmapFactory.decodeResource(res,R.drawable.castle_broken,op);
//		images[66] = Bitmap.createScaledBitmap(images[66],images[66].getWidth()/2,images[66].getHeight()/2,false);
//		images[67] = Bitmap.createScaledBitmap(images[67],images[67].getWidth()/2,images[67].getHeight()/2,false);
		
		
		int w,h;
		for (int i = 10;i<68;i++){
			if (images[i]!=null){
				h = images[i].getHeight();
				w = images[i].getWidth();
				images[i] = Bitmap.createScaledBitmap(images[i],w/4,h/4,false);
			}
		}
		
	}
}
