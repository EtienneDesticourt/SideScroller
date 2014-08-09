package com.example.painintheass;

import com.example.painintheass.GameLogic.AI;
import com.example.painintheass.GameLogic.Player;
import com.example.painintheass.GameLogic.Team;
import com.example.painintheass.Graphics.Views.CombatView;
import com.example.painintheass.UI.CombatUIManager;
import com.example.painintheass.UI.MapUIManager;
import com.example.painintheass.UI.UIManager;
import com.example.painintheass.UI.widgets.Button;
import com.example.painintheass.UI.widgets.Label;
import com.example.painintheass.UI.widgets.TextLabel;
import com.example.painintheass.UI.widgets.Widget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;



/**
 * This <code>Activity</code> is responsible for handling the creation of everything related to the combat scene.
 * Including the UI manager, the view, the victory states, the skills, the AI, and the teams.
 */
public class CombatActivity extends Activity {
	private int type = 2;
	private boolean victoryState;
	CombatUIManager myUIM;
	
	/**
	 * Creates all the necessary widgets and UI states.
	 * @param width screen's width
	 * @param height screen's height
	 * @param myUIM the <code>Activity</code>'s <code>UIManager</code>
	 */
	private void initGUI(int width, int height, CombatUIManager myUIM){
		int left,up;
		int bwidth,bheight;
		
		left = (int) (0.02083*width);
		up = (int) (0.040625*height);
		bwidth = (int) (0.10416*width);
		bheight = (int) (0.15625*height);
		Button menu = new Button(left,up,bwidth,bheight,8,8,8,8) {
			public void onClick(UIManager UIM){
				CombatUIManager myUIM = (CombatUIManager) UIM;
				if (myUIM.getCurrentStateIndex()==3  || myUIM.getCurrentStateIndex()==4){return;}
				if (myUIM.getCurrentStateIndex()!=1){
					myUIM.setCurrentStateIndex(1);
				}
				else{
					myUIM.setCurrentStateIndex(0);
				}
			}
		};
		
		left = (int) (0.16875*width);
		up = (int) (0.040625*height);
		bwidth = (int) (0.12708*width);
		bheight = (int) (0.15625*height);
		Button miner = new Button(left,up,bwidth,bheight,82,82,82,82) {
			public void onClick(UIManager UIM){
				CombatUIManager myUIM = (CombatUIManager) UIM;
				if (myUIM.getCurrentStateIndex()==3  || myUIM.getCurrentStateIndex()==4){return;}
				myUIM.getMyPlayerTeam().spawnMiner();
				myUIM.updateLabels();
			}
		};
		

		left = (int) (0.16875*width) +50 ;
		up = (int) (0.040625*height) +47;
		TextLabel nbrMiner = new TextLabel(left,up,"0");
//		Paint MinerPaint = new Paint();
//		MinerPaint.setTextAlign(Align.CENTER);
//		nbrMiner.setPaint(MinerPaint);
		
		
		
		left = (int) (0.30625*width);
		up = (int) (0.040625*height);
		bwidth = (int) (0.12708*width);
		bheight = (int) (0.15625*height);
		Button archer = new Button(left,up,bwidth,bheight,5,5,5,5) {
			public void onClick(UIManager UIM){
				CombatUIManager myUIM = (CombatUIManager) UIM;
				if (myUIM.getCurrentStateIndex()==3  || myUIM.getCurrentStateIndex()==4){return;}
				myUIM.getMyPlayerTeam().spawnArcher();
			}
		};
		
		left = (int) (0.44375*width);
		up = (int) (0.015625*height);
		bwidth = (int) (0.11041*width);
		bheight = (int) (0.18124*height);
		Button knight = new Button(left,up,bwidth,bheight,6,6,6,6) {
			public void onClick(UIManager UIM){
				CombatUIManager myUIM = (CombatUIManager) UIM;
				if (myUIM.getCurrentStateIndex()==3  || myUIM.getCurrentStateIndex()==4){return;}
				myUIM.getMyPlayerTeam().spawnKnight();
				//System.out.println("Spawned knight hopefully.");
			}
		};
		
		left = (int) (0.572916*width);
		up = (int) (0.040625*height);
		bwidth = (int) (0.10833*width);
		bheight = (int) (0.1875*height);
		Button mage = new Button(left,up,bwidth,bheight,7,7,7,7) {
			public void onClick(UIManager UIM){
				CombatUIManager myUIM = (CombatUIManager) UIM;
				if (myUIM.getCurrentStateIndex()==3  || myUIM.getCurrentStateIndex()==4){return;}
				myUIM.getMyPlayerTeam().spawnMage();
			}
		};
		

		left = (int) (0.798*width);
		up = (int) (0.125*height);
		TextLabel money = new TextLabel(left,up,"0000000");
		
		left = (int) (0.805*width);
		up = (int) (0.075625*height);
		Label coin = new Label(left,up,81);

		
		left = (int) (0.875*width);
		up = (int) (0.040625*height);
		bwidth = (int) (0.10416*width);
		bheight = (int) (0.15625*height);
		Button spell = new Button(left,up,bwidth,bheight,9,9,9,9) {
			public void onClick(UIManager UIM){
				CombatUIManager myUIM = (CombatUIManager) UIM;
				if (myUIM.getCurrentStateIndex()==3  || myUIM.getCurrentStateIndex()==4){return;}
				if (myUIM.getCurrentStateIndex()!=2){
					myUIM.setCurrentStateIndex(2);
				}
				else{
					myUIM.setCurrentStateIndex(0);
				}
			}
		};

		Widget[] state = {money,miner,nbrMiner,menu,archer,knight,mage,spell,coin};
		myUIM.addState(state, true, 0);
		
		//MENU SUBMENU
		left = (int) (0.02083*width);
		up = (int) (0.215625*height);
		bwidth = (int) (0.10416*width);
		bheight = (int) (0.15625*height);
		Button map = new Button(left,up,bwidth,bheight,73,73,73,73) {
			public void onClick(UIManager UIM){
				CombatUIManager myUIM = (CombatUIManager) UIM;
				if (myUIM.getCurrentStateIndex()==3  || myUIM.getCurrentStateIndex()==4){return;}
				myUIM.setCurrentStateIndex(3);
			}
		};
		up = (int) (0.390625*height);
		Button options = new Button(left,up,bwidth,bheight,74,74,74,74) {
			public void onClick(UIManager UIM){
				CombatUIManager myUIM = (CombatUIManager) UIM;
				if (myUIM.getCurrentStateIndex()==3  || myUIM.getCurrentStateIndex()==4){return;}
				myUIM.getMyAI().stopMovingUnits();
				startActivity(myUIM.getIntent(3));	
			}
		};
		up = (int) (0.56875*height);
		Button quit = new Button(left,up,bwidth,bheight,75,75,75,75) {
			public void onClick(UIManager UIM){
				CombatUIManager myUIM = (CombatUIManager) UIM;
				if (myUIM.getCurrentStateIndex()==3  || myUIM.getCurrentStateIndex()==4){return;}
				myUIM.setCurrentStateIndex(4);
			}
		};
		

		Widget[] state2 = {money,miner,nbrMiner,menu,archer,knight,mage,spell,map,options,quit,coin};
		myUIM.addState(state2, true, 0);
		
		//SPELLS SUBMENU
		left = (int) (0.86875*width);
		up = (int) (0.215625*height);
		bwidth = (int) (0.10416*width);
		bheight = (int) (0.15625*height);
		Button fire = new Button(left,up,bwidth,bheight,70,70,70,70) {
			public void onClick(UIManager UIM){
				CombatUIManager myUIM = (CombatUIManager) UIM;
				if (myUIM.getCurrentStateIndex()==3  || myUIM.getCurrentStateIndex()==4){return;}
				CombatUIManager myUIM2 = (CombatUIManager) myUIM;
				myUIM2.setSpawnProjectile(true);
				myUIM.setCurrentStateIndex(0);
			}
		};
		left = (int) (0.85625*width);
		up = (int) (0.390625*height);
		Button meteor = new Button(left,up,bwidth,bheight,71,71,71,71) {
			public void onClick(UIManager UIM){
				CombatUIManager myUIM = (CombatUIManager) UIM;
				if (myUIM.getCurrentStateIndex()==3  || myUIM.getCurrentStateIndex()==4){return;}
				CombatUIManager myUIM2 = (CombatUIManager) myUIM;
				myUIM2.setHealOnTouch(true);
				myUIM.setCurrentStateIndex(0);
				
			}
		};
		left = (int) (0.87083*width);
		up = (int) (0.56875*height);
		Button stars = new Button(left,up,bwidth,bheight,72,72,72,72) {
			public void onClick(UIManager UIM){
				CombatUIManager myUIM = (CombatUIManager) UIM;
				if (myUIM.getCurrentStateIndex()==3  || myUIM.getCurrentStateIndex()==4){return;}
			}
		};
		stars.setVisible(false);
		

		Widget[] state3 = {money,miner,nbrMiner,menu,archer,knight,mage,spell,fire,meteor,stars,coin};
		myUIM.addState(state3, true, 0);
		
		
		//CONFIRM STATE 1
		left = (int) (0.2875*width);
		up = (int) (0.43125*height);
		Label confirmWindow = new Label(left,up,78);
		
		up = (int) (0.63125*height);
		bwidth = (int) (0.10416*width);
		bheight = (int) (0.15625*height);
		Button ok = new Button(left,up,bwidth,bheight,79,79,79,79) {
			public void onClick(UIManager UIM){
				CombatUIManager myUIM = (CombatUIManager) UIM;
				myUIM.setExitFlag(0);
				myUIM.setEndActivity(true);
			}
		};
		
		left = (int) (0.60833333334*width);
		bwidth = (int) (0.10416*width);
		bheight = (int) (0.15625*height);
		Button cancel = new Button(left,up,bwidth,bheight,80,80,80,80) {
			public void onClick(UIManager UIM){
				CombatUIManager myUIM = (CombatUIManager) UIM;
				myUIM.setCurrentStateIndex(0);
			}
		};
		
		Widget[] state4 = {money,miner,nbrMiner,menu,archer,knight,mage,spell,confirmWindow,ok,cancel,coin};
		myUIM.addState(state4, true, 0);
		
		//CONFIRM STATE 2

		left = (int) (0.2875*width);
		up = (int) (0.63125*height);
		bwidth = (int) (0.10416*width);
		bheight = (int) (0.15625*height);
		Button ok2 = new Button(left,up,bwidth,bheight,79,79,79,79) {
			public void onClick(UIManager UIM){
				CombatUIManager myUIM = (CombatUIManager) UIM;
				myUIM.setExitFlag(1);
				myUIM.setEndActivity(true);
			}
		};
		
		Widget[] state5 = {money,miner,nbrMiner,menu,archer,knight,mage,spell,confirmWindow,ok2,cancel,coin};
		myUIM.addState(state5, true, 0);
		
		
		//VICTORY STATE

		up = 110;
		Label victory = new Label(left,up,77);
		
		up = 180;
		left += 75;
		Button ok3 = new Button(left,up,bwidth,bheight,79,79,79,79) {
			public void onClick(UIManager UIM){
				CombatUIManager myUIM = (CombatUIManager) UIM;
				myUIM.setExitFlag(2);	
				myUIM.setEndActivity(true);			
			}			
		};
		Widget[] state6 = {money,miner,nbrMiner,menu,archer,knight,mage,spell,coin,victory,ok3};
		myUIM.addState(state6, true, 0);
		
		
		//DEFEAT STATE
		
		up=110;
		left = (int) (0.2875*width);
		Label defeat = new Label(left,up,76);

		Widget[] state7 = {money,miner,nbrMiner,menu,archer,knight,mage,spell,coin,defeat,ok3};
		myUIM.addState(state7, true, 0);
		
		
	}
	
	/**
	 * Finishes the activity and returns HOME.
	 */
	public void endAll(){
		this.finish();
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_HOME);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);		
	}
	
	/**
	 * Returns the victory state at the end of the activity.
	 */
	public boolean onActivityResult(){
		return victoryState;		
	}
	
	/**
	 * Reactivates unit movement.
	 */
	protected void onResume(){
		super.onResume();
		myUIM.getMyAI().startMovingUnits();
		//System.out.println(myUIM.getMyAI().);
	}
	
	/**
	 * Stops unit movement.
	 */
	protected void onPause(){
		super.onPause();
		myUIM.getMyAI().stopMovingUnits();
	}
	
	/**
	 * Creates <code>Teams</code>, <code>CombatView</code>, and <code>AI</code> and the classes necessary for their work.
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Get screen metrics to scale UI
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int width = metrics.widthPixels;
		int height = metrics.heightPixels;
		
		
		//Initializes teams
		Team friendlyTeam = new Team();
		Team enemyTeam = new Team();
		Player p = new Player(friendlyTeam);
		Team[] myTeams = {friendlyTeam,enemyTeam};
		
		
		//Get skills associated with current country
		int skill1,skill2,skill3,skill4;
		Bundle b = getIntent().getExtras();
		int countryID = b.getInt("ID");
		ApplicationManager globalVariable = (ApplicationManager) getApplicationContext();
		skill1 = globalVariable.getHealth(countryID);
		skill2 = globalVariable.getTime(countryID);
		skill3 = globalVariable.getStrength(countryID);
		skill4 = globalVariable.getCost(countryID);
		
		//Initializes UI and set team skills.
		myUIM = new CombatUIManager(friendlyTeam,enemyTeam,p);
		friendlyTeam.setSkills(skill1, skill2, skill3, skill4);
		enemyTeam.setSkills(skill1, skill2, skill3, skill4);
		
		//Creates and fills view
		setContentView(R.layout.activity_combat);
		CombatView myView = (CombatView) findViewById(R.id.vCombat);
		myView.setUIManager(myUIM);
		myView.setDims(width,height);
		myView.setTeams(friendlyTeam,enemyTeam);
		myView.doneInitialiazing();
		initGUI(width,height, myUIM);

		//Creates AI
		AI myAI = new AI(myTeams,myView.getMyRM()); //resets unit. Spawn after this line
		myUIM.setMyAI(myAI);	
		//myAI.startMovingUnits();

		
		friendlyTeam.spawnCastle();
		enemyTeam.spawnCastle();
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public boolean isVictoryState() {
		return victoryState;
	}
	
	public void setVictoryState(boolean victoryState) {
		this.victoryState = victoryState;
	}
}
