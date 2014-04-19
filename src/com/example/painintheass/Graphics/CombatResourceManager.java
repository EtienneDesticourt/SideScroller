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
		images[78] = BitmapFactory.decodeResource(res,R.drawable.confirm_window_combat,op);
		images[79] = BitmapFactory.decodeResource(res,R.drawable.yes_combat,op);
		images[80] = BitmapFactory.decodeResource(res,R.drawable.no_combat,op);
		images[81] = BitmapFactory.decodeResource(res,R.drawable.coin_skills,op);
		images[82] = BitmapFactory.decodeResource(res,R.drawable.combat_miner,op);
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
		int h,w;
		images[49] = BitmapFactory.decodeResource(res, R.drawable.knight0,op);
		h = images[49].getHeight();
		w = images[49].getWidth();
		images[49] = Bitmap.createScaledBitmap(images[49],w/4,h/4,false);
		
		images[50] = BitmapFactory.decodeResource(res, R.drawable.knight1,op);
		h = images[50].getHeight();
		w = images[50].getWidth();
		images[50] = Bitmap.createScaledBitmap(images[50],w/4,h/4,false);
		images[51] = BitmapFactory.decodeResource(res, R.drawable.knight2,op);
		h = images[51].getHeight();
		w = images[51].getWidth();
		images[51] = Bitmap.createScaledBitmap(images[51],w/4,h/4,false);
		images[52] = BitmapFactory.decodeResource(res, R.drawable.knight3,op);
		h = images[52].getHeight();
		w = images[52].getWidth();
		images[52] = Bitmap.createScaledBitmap(images[52],w/4,h/4,false);
		images[53] = BitmapFactory.decodeResource(res, R.drawable.knight4,op);
		h = images[53].getHeight();
		w = images[53].getWidth();
		images[53] = Bitmap.createScaledBitmap(images[53],w/4,h/4,false);
		anim = new Animation(49,53,2);
		this.addAnimation(2, 0, anim);
		//System.out.println("Token 1");
				//fight
		images[54] = BitmapFactory.decodeResource(res, R.drawable.knight5,op);
		h = images[54].getHeight();
		w = images[54].getWidth();
		images[54] = Bitmap.createScaledBitmap(images[54],w/4,h/4,false);
		images[55] = BitmapFactory.decodeResource(res, R.drawable.knight6,op);
		h = images[55].getHeight();
		w = images[55].getWidth();
		images[55] = Bitmap.createScaledBitmap(images[55],w/4,h/4,false);
		images[56] = BitmapFactory.decodeResource(res, R.drawable.knight7,op);
		h = images[56].getHeight();
		w = images[56].getWidth();
		images[56] = Bitmap.createScaledBitmap(images[56],w/4,h/4,false);
		images[57] = BitmapFactory.decodeResource(res, R.drawable.knight8,op);
		h = images[57].getHeight();
		w = images[57].getWidth();
		images[57] = Bitmap.createScaledBitmap(images[57],w/4,h/4,false);
		images[58] = BitmapFactory.decodeResource(res, R.drawable.knight9,op);
		h = images[58].getHeight();
		w = images[58].getWidth();
		images[58] = Bitmap.createScaledBitmap(images[58],w/4,h/4,false);
		anim = new Animation(54,58,2);
		this.addAnimation(2, 1, anim);
		//System.out.println("Token 12");
				//die
		images[59] = BitmapFactory.decodeResource(res, R.drawable.knight10,op);
		h = images[59].getHeight();
		w = images[59].getWidth();
		images[59] = Bitmap.createScaledBitmap(images[59],w/4,h/4,false);
		images[60] = BitmapFactory.decodeResource(res, R.drawable.knight11,op);
		h = images[60].getHeight();
		w = images[60].getWidth();
		images[60] = Bitmap.createScaledBitmap(images[60],w/4,h/4,false);
		images[61] = BitmapFactory.decodeResource(res, R.drawable.knight12,op);
		h = images[61].getHeight();
		w = images[61].getWidth();
		images[61] = Bitmap.createScaledBitmap(images[61],w/4,h/4,false);
		images[62] = BitmapFactory.decodeResource(res, R.drawable.knight13,op);
		h = images[62].getHeight();
		w = images[62].getWidth();
		images[62] = Bitmap.createScaledBitmap(images[62],w/4,h/4,false);
		images[63] = BitmapFactory.decodeResource(res, R.drawable.knight14,op);
		h = images[63].getHeight();
		w = images[63].getWidth();
		images[63] = Bitmap.createScaledBitmap(images[63],w/4,h/4,false);
		images[64] = BitmapFactory.decodeResource(res, R.drawable.knight15,op);
		h = images[64].getHeight();
		w = images[64].getWidth();
		images[64] = Bitmap.createScaledBitmap(images[64],w/4,h/4,false);
		images[65] = BitmapFactory.decodeResource(res, R.drawable.knight16,op);
		h = images[65].getHeight();
		w = images[65].getWidth();
		images[65] = Bitmap.createScaledBitmap(images[65],w/4,h/4,false);
		anim = new Animation(59,65,2,false);
		this.addAnimation(2, 2, anim);
		//System.out.println("Token 13");
			//archer
				//walk
		images[46] = BitmapFactory.decodeResource(res, R.drawable.archer14,op);
		h = images[46].getHeight();
		w = images[46].getWidth();
		images[46] = Bitmap.createScaledBitmap(images[46],w/4,h/4,false);
		images[47] = BitmapFactory.decodeResource(res, R.drawable.archer15,op);
		h = images[47].getHeight();
		w = images[47].getWidth();
		images[47] = Bitmap.createScaledBitmap(images[47],w/4,h/4,false);
		images[48] = BitmapFactory.decodeResource(res, R.drawable.archer16,op);
		h = images[48].getHeight();
		w = images[48].getWidth();
		images[48] = Bitmap.createScaledBitmap(images[48],w/4,h/4,false);
		anim = new Animation(46,48,2);
		this.addAnimation(1, 0, anim);
		//System.out.println("Token 14");
				//fight
		images[40] = BitmapFactory.decodeResource(res, R.drawable.archer8,op);
		h = images[40].getHeight();
		w = images[40].getWidth();
		images[40] = Bitmap.createScaledBitmap(images[40],w/4,h/4,false);
		images[41] = BitmapFactory.decodeResource(res, R.drawable.archer9,op);
		h = images[41].getHeight();
		w = images[41].getWidth();
		images[41] = Bitmap.createScaledBitmap(images[41],w/4,h/4,false);
		images[42] = BitmapFactory.decodeResource(res, R.drawable.archer10,op);
		h = images[42].getHeight();
		w = images[42].getWidth();
		images[42] = Bitmap.createScaledBitmap(images[42],w/4,h/4,false);
		images[43] = BitmapFactory.decodeResource(res, R.drawable.archer11,op);
		h = images[43].getHeight();
		w = images[43].getWidth();
		images[43] = Bitmap.createScaledBitmap(images[43],w/4,h/4,false);
		images[44] = BitmapFactory.decodeResource(res, R.drawable.archer12,op);
		h = images[44].getHeight();
		w = images[44].getWidth();
		images[44] = Bitmap.createScaledBitmap(images[44],w/4,h/4,false);
		images[45] = BitmapFactory.decodeResource(res, R.drawable.archer13,op);
		h = images[45].getHeight();
		w = images[45].getWidth();
		images[45] = Bitmap.createScaledBitmap(images[45],w/4,h/4,false);
		anim = new Animation(40,45,2);
		this.addAnimation(1, 1, anim);
		//System.out.println("Token 15");
				//die
		images[32] = BitmapFactory.decodeResource(res, R.drawable.archer0,op);
		h = images[32].getHeight();
		w = images[32].getWidth();
		images[32] = Bitmap.createScaledBitmap(images[32],w/4,h/4,false);
		images[33] = BitmapFactory.decodeResource(res, R.drawable.archer1,op);
		h = images[33].getHeight();
		w = images[33].getWidth();
		images[33] = Bitmap.createScaledBitmap(images[33],w/4,h/4,false);
		images[34] = BitmapFactory.decodeResource(res, R.drawable.archer2,op);
		h = images[34].getHeight();
		w = images[34].getWidth();
		images[34] = Bitmap.createScaledBitmap(images[34],w/4,h/4,false);
		images[35] = BitmapFactory.decodeResource(res, R.drawable.archer3,op);
		h = images[35].getHeight();
		w = images[35].getWidth();
		images[35] = Bitmap.createScaledBitmap(images[35],w/4,h/4,false);
		images[36] = BitmapFactory.decodeResource(res, R.drawable.archer4,op);
		h = images[36].getHeight();
		w = images[36].getWidth();
		images[36] = Bitmap.createScaledBitmap(images[36],w/4,h/4,false);
		images[37] = BitmapFactory.decodeResource(res, R.drawable.archer5,op);
		h = images[37].getHeight();
		w = images[37].getWidth();
		images[37] = Bitmap.createScaledBitmap(images[37],w/4,h/4,false);
		images[38] = BitmapFactory.decodeResource(res, R.drawable.archer6,op);
		h = images[38].getHeight();
		w = images[38].getWidth();
		images[38] = Bitmap.createScaledBitmap(images[38],w/4,h/4,false);
		anim = new Animation(32,38,2,false);
		this.addAnimation(1, 2, anim);
		//System.out.println("Token 16");
			//mage
				//walk
		images[10] = BitmapFactory.decodeResource(res, R.drawable.mage0,op);
		h = images[10].getHeight();
		w = images[10].getWidth();
		images[10] = Bitmap.createScaledBitmap(images[10],w/4,h/4,false);
		images[11] = BitmapFactory.decodeResource(res, R.drawable.mage1,op);
		h = images[11].getHeight();
		w = images[11].getWidth();
		images[11] = Bitmap.createScaledBitmap(images[11],w/4,h/4,false);
		images[12] = BitmapFactory.decodeResource(res, R.drawable.mage2,op);
		h = images[12].getHeight();
		w = images[12].getWidth();
		images[12] = Bitmap.createScaledBitmap(images[12],w/4,h/4,false);
		images[13] = BitmapFactory.decodeResource(res, R.drawable.mage3,op);
		h = images[13].getHeight();
		w = images[13].getWidth();
		images[13] = Bitmap.createScaledBitmap(images[13],w/4,h/4,false);
		anim = new Animation(10,13,2);
		this.addAnimation(3, 0, anim);
		//System.out.println("Token 17");
				//fight
		images[14] = BitmapFactory.decodeResource(res, R.drawable.mage4,op);
		h = images[14].getHeight();
		w = images[14].getWidth();
		images[14] = Bitmap.createScaledBitmap(images[14],w/4,h/4,false);
		images[15] = BitmapFactory.decodeResource(res, R.drawable.mage5,op);
		h = images[15].getHeight();
		w = images[15].getWidth();
		images[15] = Bitmap.createScaledBitmap(images[15],w/4,h/4,false);
		images[16] = BitmapFactory.decodeResource(res, R.drawable.mage6,op);
		h = images[16].getHeight();
		w = images[16].getWidth();
		images[16] = Bitmap.createScaledBitmap(images[16],w/4,h/4,false);
		images[17] = BitmapFactory.decodeResource(res, R.drawable.mage7,op);
		h = images[17].getHeight();
		w = images[17].getWidth();
		images[17] = Bitmap.createScaledBitmap(images[17],w/4,h/4,false);
		anim = new Animation(14,17,2);
		this.addAnimation(3, 1, anim);
		//System.out.println("Token 18");
				//die
		images[18] = BitmapFactory.decodeResource(res, R.drawable.mage8,op);
		h = images[18].getHeight();
		w = images[18].getWidth();
		images[18] = Bitmap.createScaledBitmap(images[18],w/4,h/4,false);
		images[19] = BitmapFactory.decodeResource(res, R.drawable.mage9,op);
		h = images[19].getHeight();
		w = images[19].getWidth();
		images[19] = Bitmap.createScaledBitmap(images[19],w/4,h/4,false);
		images[20] = BitmapFactory.decodeResource(res, R.drawable.mage10,op);
		h = images[20].getHeight();
		w = images[20].getWidth();
		images[20] = Bitmap.createScaledBitmap(images[20],w/4,h/4,false);
		images[21] = BitmapFactory.decodeResource(res, R.drawable.mage11,op);
		h = images[21].getHeight();
		w = images[21].getWidth();
		images[21] = Bitmap.createScaledBitmap(images[21],w/4,h/4,false);
		images[22] = BitmapFactory.decodeResource(res, R.drawable.mage12,op);
		h = images[22].getHeight();
		w = images[22].getWidth();
		images[22] = Bitmap.createScaledBitmap(images[22],w/4,h/4,false);
		images[23] = BitmapFactory.decodeResource(res, R.drawable.mage13,op);
		h = images[23].getHeight();
		w = images[23].getWidth();
		images[23] = Bitmap.createScaledBitmap(images[23],w/4,h/4,false);
		images[24] = BitmapFactory.decodeResource(res, R.drawable.mage14,op);
		h = images[24].getHeight();
		w = images[24].getWidth();
		images[24] = Bitmap.createScaledBitmap(images[24],w/4,h/4,false);
		images[25] = BitmapFactory.decodeResource(res, R.drawable.mage15,op);
		h = images[25].getHeight();
		w = images[25].getWidth();
		images[25] = Bitmap.createScaledBitmap(images[25],w/4,h/4,false);
		images[26] = BitmapFactory.decodeResource(res, R.drawable.mage16,op);
		h = images[26].getHeight();
		w = images[26].getWidth();
		images[26] = Bitmap.createScaledBitmap(images[26],w/4,h/4,false);
		images[27] = BitmapFactory.decodeResource(res, R.drawable.mage17,op);
		h = images[27].getHeight();
		w = images[27].getWidth();
		images[27] = Bitmap.createScaledBitmap(images[27],w/4,h/4,false);
		images[28] = BitmapFactory.decodeResource(res, R.drawable.mage18,op);
		h = images[28].getHeight();
		w = images[28].getWidth();
		images[28] = Bitmap.createScaledBitmap(images[28],w/4,h/4,false);
		anim = new Animation(18,28,2,false);
		this.addAnimation(3, 2, anim);
		//System.out.println("Token 19");

//		int w,h;
//		for (int i = 10;i<68;i++){
//			if (images[i]!=null){
//				h = images[i].getHeight();
//				w = images[i].getWidth();
//				images[i] = Bitmap.createScaledBitmap(images[i],w/4,h/4,false);
//			}
//		}
		
		
		//projectiles
		images[66] = BitmapFactory.decodeResource(res,R.drawable.projectile_arrow,op);
		images[67] = BitmapFactory.decodeResource(res,R.drawable.projectile_magic,op);
		images[66] = Bitmap.createScaledBitmap(images[66],images[66].getWidth()/4,images[66].getHeight()/4,false);
		images[67] = Bitmap.createScaledBitmap(images[67],images[67].getWidth()/4,images[67].getHeight()/4,false);
		//Castle
		images[68] = BitmapFactory.decodeResource(res,R.drawable.castle,op);
		images[69] = BitmapFactory.decodeResource(res,R.drawable.castle_broken,op);
		
		
		
	}
}
