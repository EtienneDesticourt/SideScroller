package com.example.painintheass;

import com.example.painintheass.GameLogic.Country;
import com.example.painintheass.Graphics.MapView;
import com.example.painintheass.UI.Label;
import com.example.painintheass.UI.TextLabel;
import com.example.painintheass.UI.Widget;
import com.example.painintheass.UI.Button;
import com.example.painintheass.UI.MapUIManager;
import com.example.painintheass.UI.UIManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class MapActivity extends Activity{

	private int type = 1;
	private int lastAttack=0;
	private MapUIManager myUIM; 
	//MUSIC IDEA: SOUND OF ANVIL BEING HIT AS DRUMS
	
	public void initWorld(MapUIManager myUIM, Country[] World,Button[] Countries){
		World[0] = new Country();
		World[1] = new Country();
		World[2] = new Country();
		World[3] = new Country();
		World[4] = new Country();		
		World[5] = new Country();		

		myUIM.setWorld(World);
		World[0].setButton(Countries[0]);
		World[0].setPlayerControlled(true);
		World[1].setButton(Countries[1]);
		World[1].setPlayerControlled(false);
		World[2].setButton(Countries[2]);
		World[2].setPlayerControlled(false);
		World[3].setButton(Countries[3]);
		World[3].setPlayerControlled(false);
		World[4].setButton(Countries[4]);
		World[4].setPlayerControlled(false);
		World[5].setButton(Countries[5]);
		World[5].setPlayerControlled(false);
	}
		
	public void initMap(int width, int height, MapUIManager myUIM, Country[] World){
		//1:MAP STATE
		int left,up;
		int bwidth,bheight;

		
		left = (int) (0.38*width);
		up = (int) (0.70*height);
		

		bwidth = (int) (0.08125*width);
		bheight = (int) (0.08125*height);
		Button pays1 = new Button(left,up,bwidth,bheight,1,2,3,1) {
			public void onClick(UIManager myUIM){
				myUIM.unclickAll();
				this.setBackgroundImage(this.getClickedImage());
				myUIM.setSelected(0);
				if (myUIM.getWorld()[0].isPlayerControlled())	myUIM.setCurrentStateIndex(2);
				else myUIM.setCurrentStateIndex(1);	
			}
		};

		left = (int) (0.197*width);
		up = (int) (0.545*height);
		bwidth = (int) (0.260416666667*width);
		bheight = (int) (0.25625*height);
		Button pays2 = new Button(left,up,bwidth,bheight,4,5,6,4) {
			public void onClick(UIManager myUIM){
				myUIM.unclickAll();
				this.setBackgroundImage(this.getClickedImage());
				myUIM.setSelected(1);
				if (myUIM.getWorld()[1].isPlayerControlled())	myUIM.setCurrentStateIndex(2);
				else myUIM.setCurrentStateIndex(1);				
			}
		};

		left = (int) (0.291*width);
		up = (int) (0.3493*height);
		bwidth = (int) (0.1375*width);
		bheight = (int) (0.253125*height);
		Button pays3 = new Button(left,up,bwidth,bheight,7,8,9,7) {
			public void onClick(UIManager myUIM){
				myUIM.unclickAll();
				this.setBackgroundImage(this.getClickedImage());
				myUIM.setSelected(2);
				if (myUIM.getWorld()[2].isPlayerControlled())	myUIM.setCurrentStateIndex(2);
				else myUIM.setCurrentStateIndex(1);	
			}
		};

		left = (int) (0.238*width);
		up = (int) (0.53*height);
		bwidth = (int) (0.0770833333333*width);
		bheight = (int) (0.096875*height);
		Button pays4 = new Button(left,up,bwidth,bheight,10,11,12,10) {
			public void onClick(UIManager myUIM){
				myUIM.unclickAll();
				this.setBackgroundImage(this.getClickedImage());
				myUIM.setSelected(3);
				if (myUIM.getWorld()[3].isPlayerControlled())	myUIM.setCurrentStateIndex(2);
				else myUIM.setCurrentStateIndex(1);	
			}
		};

		left = (int) (0.18*width);
		up = (int) (0.418*height);
		bwidth = (int) (0.108333333333*width);
		bheight = (int) (0.13125*height);
		Button pays5 = new Button(left,up,bwidth,bheight,13,14,15,13) {
			public void onClick(UIManager myUIM){
				myUIM.unclickAll();
				this.setBackgroundImage(this.getClickedImage());
				myUIM.setSelected(4);
				if (myUIM.getWorld()[4].isPlayerControlled())	myUIM.setCurrentStateIndex(2);
				else myUIM.setCurrentStateIndex(1);				
			}
		};	

		left = (int) (0.185*width);
		up = (int) (0.245*height);
		bwidth = (int) (0.19375*width);
		bheight = (int) (0.29375*height);
		Button pays6 = new Button(left,up,bwidth,bheight,16,17,18,16) {
			public void onClick(UIManager myUIM){
				myUIM.unclickAll();
				this.setBackgroundImage(this.getClickedImage());
				myUIM.setSelected(5);
				if (myUIM.getWorld()[5].isPlayerControlled())	myUIM.setCurrentStateIndex(2);
				else myUIM.setCurrentStateIndex(1);					
			}
		};	

		left = (int) (0.583*width);
		up = (int) (0.578*height);
		bwidth = (int) (0.25*width);
		bheight = (int) (0.0625*height);
		Button attack1 = new Button(left,up,bwidth,bheight) {
			public void onClick(UIManager myUIM){
			}
		};
		attack1.setBackgroundImage(20);

		up = (int) (0.656*height);
		Button resolve1 = new Button(left,up,bwidth,bheight) {
			public void onClick(UIManager myUIM){
			}
		};
		resolve1.setBackgroundImage(21);

		up = (int) (0.734*height);
		bwidth = (int) (0.25*width);
		bheight = (int) (0.1375*height);
		Button nextTurn = new Button(left,up,bwidth,bheight) {
			public void onClick(UIManager myUIM){
				Country[] World = myUIM.getWorld();
				for (int i=0;i<5;i++){
					World[i].nextTurn();
				}

				myUIM.updateLabels();
			}
		};
		nextTurn.setBackgroundImage(19);

		left = (int) (0.77*width);
		up = (int) (0.218*height);
		Label coin1 = new Label(left,up,25);
		up = (int) (0.328*height);
		Label coin2 = new Label(left,up,24);
		up = (int) (0.4375*height);
		Label coin3 = new Label(left,up,24);
		

		left = (int) (0.57*width);
		up = (int) (0.218*height);
		TextLabel troups = new TextLabel(left,up,"0000000");
		up = (int) (0.328*height);
		TextLabel income = new TextLabel(left,up,"0000000");
		up = (int) (0.4375*height);
		TextLabel money = new TextLabel(left,up,"0000000");
		
		
		Widget[] mapState1 = {troups,income,money,nextTurn,attack1,resolve1,coin1,coin2,coin3,pays1,pays2,pays3,pays4,pays5,pays6};
		myUIM.addState(mapState1,false,0);
		
		Button[] Countries = {pays1,pays2,pays3,pays4,pays5,pays6};
		initWorld(myUIM, World, Countries);
		
		
		//2:MAP STATE, ENEMY COUNTRY SELECTED	
		
		left = (int) (0.583*width);
		up = (int) (0.578*height);
		bwidth = (int) (0.25*width);
		bheight = (int) (0.0625*height);
		Button attack = new Button(left,up,bwidth,bheight) {
			public void onClick(UIManager myUIM){
				Country enemyCountry = myUIM.getSelected();
				if (enemyCountry.isPlayerControlled()) return;
				startActivity(myUIM.getIntent(2));
				myUIM.setAttacking(enemyCountry);
				//myUIM.setCurrentStateIndex(5); //Start battle 
			}
		};
		attack.setBackgroundImage(22);
		
		Widget[] mapState2 = {troups,income,money,attack,resolve1,coin1,coin2,coin3,nextTurn,pays1,pays2,pays3,pays4,pays5,pays6};
		myUIM.addState(mapState2,false,0);
		
		
		//3:MAP STATE, FRIENDLY COUNTRY SELECTED

		left = (int) (0.833*width);
		up = (int) (0.25*height);
		bwidth = (int) (0.0416666666667*width);
		bheight = (int) (0.0625*height);
		Button buyTroups = new Button(left,up,bwidth,bheight) {
			public void onClick(UIManager myUIM){
				Country Selected = myUIM.getSelected();
				if (Selected.getMoney()>=10){
					Selected.setMoney(Selected.getMoney()-10);
					Selected.setTroups(Selected.getTroups()+10);
				}
				myUIM.updateLabels();
			}
		};
		buyTroups.setBackgroundImage(26);
		
		Widget[] mapState3 = {troups,income,money,attack1,resolve1,coin1,coin2,coin3,buyTroups,nextTurn,pays1,pays2,pays3,pays4,pays5,pays6};
		myUIM.addState(mapState3,false,0);
		
		
		//4:MAP STATE, COUNTRY BEING ATTACKED
		
		left = (int) (0.583*width);
		up = (int) (0.578*height);
		bwidth = (int) (0.25*width);
		bheight = (int) (0.0625*height);
		Button attack2 = new Button(left,up,bwidth,bheight) {
			public void onClick(UIManager myUIM){
				myUIM.setCurrentStateIndex(5);
				//myUIM.setAttackingIndex()
			}
		};
		attack2.setBackgroundImage(22);
		
		up = (int) (0.656*height);
		Button resolve2 = new Button(left,up,bwidth,bheight) {
			public void onClick(UIManager myUIM){
				int result = myUIM.getDefending().getTroups()-myUIM.getAttacking().getTroups();//add skill modifier
				if (result<0){
					myUIM.getDefending().setPlayerControlled(false);
				}
				myUIM.setCurrentStateIndex(1);
			}
		};
		resolve2.setBackgroundImage(23);
		
		Widget[] mapState4 = {troups,income,money,resolve2,attack2,coin1,coin2,coin3,nextTurn,pays1,pays2,pays3,pays4,pays5,pays6};
		myUIM.addState(mapState4,false,0);
	}
	
	
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1) {
			if(resultCode == RESULT_OK){
				boolean result=data.getBooleanExtra("result",false);
				myUIM.getAttacking().setPlayerControlled(result);				
			}
			if (resultCode == RESULT_CANCELED) {
				//Write your code if there's no result
			}
		}
	}
	

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int width = metrics.widthPixels;
		int height = metrics.heightPixels;
		
		
		myUIM = new MapUIManager(this);
		
		
		setContentView(R.layout.activity_map);
		MapView myView = (MapView) findViewById(R.id.vMap);
		myView.setUIManager(myUIM);
		myView.doneInitialiazing();
		Country[] World = new Country[6];
		initMap(width,height,myUIM,World);
		
		
		
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
