package com.example.painintheass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.example.painintheass.GameLogic.Country;
import com.example.painintheass.Graphics.MapView;
import com.example.painintheass.UI.MapUIManager;
import com.example.painintheass.UI.UIManager;
import com.example.painintheass.UI.widgets.Button;
import com.example.painintheass.UI.widgets.Label;
import com.example.painintheass.UI.widgets.TextLabel;
import com.example.painintheass.UI.widgets.Widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class MapActivity extends Activity{

	private int type = 1;
	private int lastAttack=0;
	private MapUIManager myUIM;
	private final String saveFileName = "/SAVE";
	//MUSIC IDEA: SOUND OF ANVIL BEING HIT AS DRUMS
	
 	public void initWorld(MapUIManager myUIM, Country[] World,Button[] Countries){
		World[0] = new Country(0);
		World[1] = new Country(1);
		World[2] = new Country(2);
		World[3] = new Country(3);
		World[4] = new Country(4);		
		World[5] = new Country(5);		

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
		
		Country[] adj;
		adj = new Country[1];
		adj[0] = World[1];
		World[0].setAdjacentCountries(adj);
		
		adj = new Country[3];
		adj[0] = World[0];
		adj[1] = World[2];
		adj[2] = World[3];
		World[1].setAdjacentCountries(adj);
		
		adj = new Country[3];
		adj[0] = World[1];
		adj[1] = World[3];
		adj[2] = World[5];
		World[2].setAdjacentCountries(adj);
		
		adj = new Country[4];
		adj[0] = World[1];
		adj[1] = World[2];
		adj[2] = World[4];
		adj[3] = World[5];
		World[3].setAdjacentCountries(adj);
		
		adj = new Country[2];
		adj[0] = World[3];
		adj[1] = World[5];
		World[4].setAdjacentCountries(adj);
		
		adj = new Country[3];
		adj[0] = World[3];
		adj[1] = World[2];
		adj[2] = World[4];
		World[5].setAdjacentCountries(adj);
		
		
		
		
		
		
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
				if (myUIM.getCurrentStateIndex()==3 || myUIM.getCurrentStateIndex()==4){
					//if under attack
					if (myUIM.getAttacking().getID()==0){
						//if clicking on attacking country
						myUIM.setCurrentStateIndex(3);		//set resolve state
						return;
					}					
					//if clicking on any other country
					myUIM.setCurrentStateIndex(4);		//set all buttons disabled state
					return;					
				}
				if (myUIM.getWorld()[0].isPlayerControlled())	myUIM.setCurrentStateIndex(2);
				else myUIM.setCurrentStateIndex(1);	
			}
		};
		left = (int) 167;
		up = (int) 228;
		Label attackArrow0 = new Label(left,up,29);
		attackArrow0.setVisible(false);
		
		
		left = (int) (0.197*width);
		up = (int) (0.545*height);
		bwidth = (int) (0.260416666667*width);
		bheight = (int) (0.25625*height);
		Button pays2 = new Button(left,up,bwidth,bheight,4,5,6,4) {
			public void onClick(UIManager myUIM){
				myUIM.unclickAll();
				this.setBackgroundImage(this.getClickedImage());
				myUIM.setSelected(1);
				if (myUIM.getCurrentStateIndex()==3 || myUIM.getCurrentStateIndex()==4){
					//if under attack
					if (myUIM.getAttacking().getID()==1){
						//if clicking on attacking country
						myUIM.setCurrentStateIndex(3);		//set resolve state
						return;
					}					
					//if clicking on any other country
					myUIM.setCurrentStateIndex(4);		//set all buttons disabled state
					return;					
				}
				if (myUIM.getWorld()[1].isPlayerControlled())	myUIM.setCurrentStateIndex(2);
				else myUIM.setCurrentStateIndex(1);				
			}
		};
		left = (int) 100;
		up = (int) 215;
		Label attackArrow1 = new Label(left,up,29);
		attackArrow1.setVisible(false);
		
		
		left = (int) (0.291*width);
		up = (int) (0.3493*height);
		bwidth = (int) (0.1375*width);
		bheight = (int) (0.253125*height);
		Button pays3 = new Button(left,up,bwidth,bheight,7,8,9,7) {
			public void onClick(UIManager myUIM){
				myUIM.unclickAll();
				this.setBackgroundImage(this.getClickedImage());
				myUIM.setSelected(2);
				if (myUIM.getCurrentStateIndex()==3 || myUIM.getCurrentStateIndex()==4){
					//if under attack
					if (myUIM.getAttacking().getID()==2){
						//if clicking on attacking country
						myUIM.setCurrentStateIndex(3);		//set resolve state
						return;
					}					
					//if clicking on any other country
					myUIM.setCurrentStateIndex(4);		//set all buttons disabled state
					return;					
				}
				if (myUIM.getWorld()[2].isPlayerControlled())	myUIM.setCurrentStateIndex(2);
				else myUIM.setCurrentStateIndex(1);	
			}
		};
		left = (int) 132;
		up = (int) 147;
		Label attackArrow2 = new Label(left,up,29);
		attackArrow2.setVisible(false);
		
		
		left = (int) (0.238*width);
		up = (int) (0.53*height);
		bwidth = (int) (0.0770833333333*width);
		bheight = (int) (0.096875*height);
		Button pays4 = new Button(left,up,bwidth,bheight,10,11,12,10) {
			public void onClick(UIManager myUIM){
				myUIM.unclickAll();
				this.setBackgroundImage(this.getClickedImage());
				myUIM.setSelected(3);
				if (myUIM.getCurrentStateIndex()==3 || myUIM.getCurrentStateIndex()==4){
					//if under attack
					if (myUIM.getAttacking().getID()==3){
						//if clicking on attacking country
						myUIM.setCurrentStateIndex(3);		//set resolve state
						return;
					}					
					//if clicking on any other country
					myUIM.setCurrentStateIndex(4);		//set all buttons disabled state
					return;					
				}
				if (myUIM.getWorld()[3].isPlayerControlled())	myUIM.setCurrentStateIndex(2);
				else myUIM.setCurrentStateIndex(1);	
			}
		};
		left = (int) 100;
		up = (int) 173;
		Label attackArrow3 = new Label(left,up,29);
		attackArrow3.setVisible(false);
		
		
		left = (int) (0.18*width);
		up = (int) (0.418*height);
		bwidth = (int) (0.108333333333*width);
		bheight = (int) (0.13125*height);
		Button pays5 = new Button(left,up,bwidth,bheight,13,14,15,13) {
			public void onClick(UIManager myUIM){
				myUIM.unclickAll();
				this.setBackgroundImage(this.getClickedImage());
				myUIM.setSelected(4);if (myUIM.getCurrentStateIndex()==3 || myUIM.getCurrentStateIndex()==4){
					//if under attack
					if (myUIM.getAttacking().getID()==4){
						//if clicking on attacking country
						myUIM.setCurrentStateIndex(3);		//set resolve state
						return;
					}					
					//if clicking on any other country
					myUIM.setCurrentStateIndex(4);		//set all buttons disabled state
					return;					
				}
				if (myUIM.getWorld()[4].isPlayerControlled())	myUIM.setCurrentStateIndex(2);
				else myUIM.setCurrentStateIndex(1);				
			}
		};	
		left = (int) 80;
		up = (int) 145;
		Label attackArrow4 = new Label(left,up,29);
		attackArrow4.setVisible(false);
		
		
		left = (int) (0.185*width);
		up = (int) (0.245*height);
		bwidth = (int) (0.19375*width);
		bheight = (int) (0.29375*height);
		Button pays6 = new Button(left,up,bwidth,bheight,16,17,18,16) {
			public void onClick(UIManager myUIM){
				myUIM.unclickAll();
				this.setBackgroundImage(this.getClickedImage());
				myUIM.setSelected(5);if (myUIM.getCurrentStateIndex()==3 || myUIM.getCurrentStateIndex()==4){
					//if under attack
					if (myUIM.getAttacking().getID()==5){
						//if clicking on attacking country
						myUIM.setCurrentStateIndex(3);		//set resolve state
						return;
					}					
					//if clicking on any other country
					myUIM.setCurrentStateIndex(4);		//set all buttons disabled state
					return;					
				}
				if (myUIM.getWorld()[5].isPlayerControlled())	myUIM.setCurrentStateIndex(2);
				else myUIM.setCurrentStateIndex(1);					
			}
		};	
		left = (int) 110;
		up = (int) 102;
		Label attackArrow5 = new Label(left,up,29);
		attackArrow5.setVisible(false);
		
		
		left = (int) (0.583*width);
		up = (int) (0.499875*height);
		bwidth = (int) (0.25*width);
		bheight = (int) (0.0625*height);
		Button skills = new Button(left,up,bwidth,bheight,27,27,27,27) {
			public void onClick(UIManager myUIM){
				Country cur = myUIM.getSelected();
				if (cur==null){return;}
				if (cur.isPlayerControlled()){
					Intent intent = myUIM.getIntent(4);
					Bundle b = new Bundle();
					b.putInt("ID", cur.getID()); 
					intent.putExtras(b); 
					startActivityForResult(intent,1);
				}
			}
		};
		//System.out.println("fuck you android.");
		up = (int) (0.578*height);
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
			public void onClick(UIManager uim){
				MapUIManager myUIM = ((MapUIManager)uim);
				Country[] World = myUIM.getWorld();
				
				for (int i=0;i<6;i++){
					World[i].handleMoney();
				}
				
				int i=0;
				boolean attack = false;
				while (!attack && i<6){
					attack = World[i].nextTurn();
					i++;
				}
				
				if (attack) {
					myUIM.setAttacking(World[i-1]);
					myUIM.setDefending(World[World[i-1].getTargetID()]);
					if ( myUIM.getSelected().getID() == (i-1) ){
						myUIM.setCurrentStateIndex(3);
					}
					else{
						myUIM.setCurrentStateIndex(4);
					}

					Widget[] state = myUIM.getCurrentState();
					int index0 = state.length-(6-(i-1));
					int index1 = state.length-(6-(World[i-1].getTargetID()));
					state[index0].setVisible(true);
					state[index1].setVisible(true);
					
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
//		up = (int) (0.4375*height);
//		Label coin3 = new Label(left,up,24);
		

		left = (int) (0.77*width);
		up = (int) (0.29*height);
		TextLabel troups = new TextLabel(left,up,"0000000");
		up = (int) (0.39*height);
		TextLabel money = new TextLabel(left,up,"0000000");
//		up = (int) (0.4375*height);
//		TextLabel income = new TextLabel(left,up,"0000000");
		
		left = (int) (0.583*width);
		up = (int) (0.499875*height);
		bwidth = (int) (0.25*width);
		bheight = (int) (0.0625*height);
		Button skills2 = new Button(left,up,bwidth,bheight,28,28,28,28) {
			public void onClick(UIManager myUIM){
			}
		};
		
		left = 400;
		up = 40;
		TextLabel victory = new TextLabel(left,up,"Congratulations! You're victorious!");
		victory.setVisible(false);
		left = 350;
		TextLabel defeat = new TextLabel(left,up,"Sadly, you were defeated...");
		defeat.setVisible(false);
		
		
		Widget[] mapState1 = {skills2,troups,money,victory,defeat,nextTurn,attack1,resolve1,coin1,coin2,pays1,pays2,pays3,pays4,pays5,pays6};
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
				Country cur = myUIM.getSelected();
				if (cur==null){return;}
				if (!cur.isPlayerControlled()){
					Intent intent = myUIM.getIntent(2);
					Bundle b = new Bundle();
					b.putInt("ID", cur.getID()); 
					intent.putExtras(b); 
					startActivityForResult(intent,1);
					myUIM.setAttacking(cur);
				}
				//myUIM.setCurrentStateIndex(5); //Start battle 
			}
		};
		attack.setBackgroundImage(22);

		
		
		
		
		Widget[] mapState2 = {skills2,troups,money,victory,defeat,attack,resolve1,coin1,coin2,nextTurn,pays1,pays2,pays3,pays4,pays5,pays6};
		myUIM.addState(mapState2,false,0);
		
		
		//3:MAP STATE, FRIENDLY COUNTRY SELECTED

		left = (int) (0.833*width);
		up = (int) (0.25*height);
		bwidth = (int) (0.0416666666667*width);
		bheight = (int) (0.0625*height);
		Button buyTroups = new Button(left,up,bwidth,bheight) {
			public void onClick(UIManager myUIM){
				myUIM.getSelected().buyTroups();
				myUIM.updateLabels();
			}
		};
		buyTroups.setBackgroundImage(26);
		
		Widget[] mapState3 = {skills,troups,money,victory,defeat,attack1,resolve1,coin1,coin2,buyTroups,nextTurn,pays1,pays2,pays3,pays4,pays5,pays6};
		myUIM.addState(mapState3,false,0);
		
		
		//4:MAP STATE, COUNTRY BEING ATTACKED, ATTACKING COUNTRY SELECTED
		
		left = (int) (0.583*width);
		up = (int) (0.578*height);
		bwidth = (int) (0.25*width);
		bheight = (int) (0.0625*height);
		Button attack2 = new Button(left,up,bwidth,bheight) {
			public void onClick(UIManager myUIM){
				


				Widget[] state = myUIM.getCurrentState();
				
				int index0 = state.length-(6-myUIM.getAttacking().getID());
				int index1 = state.length-(6-myUIM.getDefending().getID());
				state[index0].setVisible(false);
				state[index1].setVisible(false);
				
				Country cur = myUIM.getSelected();
				if (cur==null){return;}
				if (!cur.isPlayerControlled()){
					Intent intent = myUIM.getIntent(2);
					Bundle b = new Bundle();
					b.putInt("ID", cur.getID()); 
					intent.putExtras(b); 
					startActivityForResult(intent,1);
					myUIM.setAttacking(cur);
				}
				//myUIM.setCurrentStateIndex(5); //Start battle 
				//myUIM.setCurrentStateIndex(5);
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
				
				

				Widget[] state = myUIM.getCurrentState();
				
				int index0 = state.length-(6-myUIM.getAttacking().getID());
				int index1 = state.length-(6-myUIM.getDefending().getID());
				state[index0].setVisible(false);
				state[index1].setVisible(false);
				
				
				myUIM.setCurrentStateIndex(1);
				
				if (playerIsVictorious()){
					myUIM.getCurrentState()[3].setVisible(true);
					return;
				}
				if (playerIsDefeated()){
					myUIM.getCurrentState()[4].setVisible(true);
				}
				
			}
		};
		resolve2.setBackgroundImage(23);

		left = (int) (0.583*width);
		up = (int) (0.734*height);
		bwidth = (int) (0.25*width);
		bheight = (int) (0.1375*height);
		Button nextTurn1 = new Button(left,up,bwidth,bheight) {			
			public void onClick(UIManager myUIM) {
												
			}			
		};
		nextTurn1.setBackgroundImage(30);
		
		Widget[] mapState4 = {skills2,troups,money,victory,defeat,resolve2,attack2,coin1,coin2,nextTurn1,pays1,pays2,pays3,pays4,pays5,pays6,attackArrow0,attackArrow1,attackArrow2,attackArrow3,attackArrow4,attackArrow5};
		myUIM.addState(mapState4,false,0);
		
		//5: COUNTRY BEING ATTACKED, ATTACKING COUNTRY NOT SELECTED
		
		
		
		
		
		Widget[] mapState5 = {skills2,troups,money,victory,defeat,attack1,resolve1,coin1,coin2,nextTurn1,pays1,pays2,pays3,pays4,pays5,pays6,attackArrow0,attackArrow1,attackArrow2,attackArrow3,attackArrow4,attackArrow5};
		myUIM.addState(mapState5,false,0);
		
		pays1.onClick(myUIM);
		
	}
	
	public boolean playerIsVictorious(){
		Country[] World = myUIM.getWorld();
				
		for (int i=0;i<6;i++){
			if (!World[i].isPlayerControlled()) return false;
		}
		return true;
	}
	
	public boolean playerIsDefeated(){
		Country[] World = myUIM.getWorld();
		

		for (int i=0;i<6;i++){
			if (World[i].isPlayerControlled()) return false;
		}
		return true;
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
		myUIM.setAttacking(null);
		myUIM.setDefending(null);
		myUIM.setCurrentStateIndex(0);
		
		if (playerIsVictorious()){
			myUIM.getCurrentState()[3].setVisible(true);
			return;
		}
		if (playerIsDefeated()){
			myUIM.getCurrentState()[4].setVisible(true);
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
		ApplicationManager globalVariable = (ApplicationManager) getApplicationContext();
		globalVariable.setWorld(World);
		
//		System.out.println(3);
		
		
		
	}

	private String getSaveData(){
		Country[] World = myUIM.getWorld();
		String result = "";
		for (int i=0;i<6;i++){
			if (World[i].isPlayerControlled()){
				result += "1 ";
			}
			else{
				result += "0 ";
			}
			result += Integer.toString(World[i].getTroups())+" ";
			result += Integer.toString(World[i].getIncome())+" ";
			result += Integer.toString(World[i].getMoney())+" ";
			result += Integer.toString(World[i].getCost())+" ";
			result += Integer.toString(World[i].getTime())+" ";
			result += Integer.toString(World[i].getHealth())+" ";
			result += Integer.toString(World[i].getStrength())+" ";
			result += "\n";
			
		}
		return result;
	}
	
	protected void onPause(){
		super.onPause();
		File saveFile = new File(getFilesDir()+saveFileName);
		String string = getSaveData();
		
		
		
		try {
			  FileOutputStream outputStream = openFileOutput(getFilesDir()+saveFileName, Context.MODE_PRIVATE);
			  outputStream.write(string.getBytes());
			  outputStream.close();
		} catch (Exception e) {
			  e.printStackTrace();
		}	
		
	}
	
	public void loadData(String data){
//		if (data == null){
//			System.out.println("No save file.");
//			Country[] World = myUIM.getWorld();
//			
//			for (int i=0;i<6;i++){
//				if (i==0){
//					World[i].setPlayerControlled(true);
//				}
//				else{
//					World[i].setPlayerControlled(false);				
//				}
//				World[i].setTroups(0);
//				World[i].setIncome(10);
//				World[i].setMoney(0);
//			}	
//			return;
//		}
		
		
		
		String[] countryData = data.split("\n");
		Country[] World = myUIM.getWorld();
		
		for (int i=0;i<6;i++){
			String[] current = countryData[i].split(" ");
			if (Integer.valueOf(current[0])==1){
				World[i].setPlayerControlled(true);
			}
			else{
				World[i].setPlayerControlled(false);				
			}
			World[i].setTroups(Integer.valueOf(current[1]));
			World[i].setIncome(Integer.valueOf(current[2]));
			World[i].setMoney(Integer.valueOf(current[3]));
			World[i].setCost(Integer.valueOf(current[4]));
			World[i].setTime(Integer.valueOf(current[5]));
			World[i].setHealth(Integer.valueOf(current[6]));
			World[i].setStrength(Integer.valueOf(current[7]));
		}	
		

		ApplicationManager globalVariable = (ApplicationManager) getApplicationContext();
		globalVariable.setWorld(World);
		
	}
	
	protected void onResume(){
		super.onResume();
		
		myUIM.updateLabels();
		
		
		
		
		//Read file in Internal Storage
		//System.out.println(getFilesDir());
		
		
		File file = new File(getFilesDir()+saveFileName);
		if(!file.exists()) 
		     return;
		
		
		FileInputStream fis;
		String content = "";
		try {
			fis = openFileInput(getFilesDir()+saveFileName);
			byte[] input = new byte[fis.available()];
			while (fis.read(input) != -1) {}
			content += new String(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		loadData(content);
	}
	
 	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
