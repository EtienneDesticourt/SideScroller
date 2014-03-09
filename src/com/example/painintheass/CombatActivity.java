package com.example.painintheass;

import com.example.painintheass.GameLogic.AI;
import com.example.painintheass.GameLogic.Player;
import com.example.painintheass.GameLogic.Team;
import com.example.painintheass.Graphics.CombatView;
import com.example.painintheass.UI.Label;
import com.example.painintheass.UI.TextLabel;
import com.example.painintheass.UI.Widget;
import com.example.painintheass.UI.Button;
import com.example.painintheass.UI.CombatUIManager;
import com.example.painintheass.UI.UIManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class CombatActivity extends Activity {
	private int type = 2;
	private boolean victoryState;
	
	private void initGUI(int width, int height, CombatUIManager myUIM){
		int left,up;
		int bwidth,bheight;

		
		left = (int) (0.02083*width);
		up = (int) (0.040625*height);
		bwidth = (int) (0.10416*width);
		bheight = (int) (0.15625*height);
		Button menu = new Button(left,up,bwidth,bheight,8,8,8,8) {
			public void onClick(UIManager myUIM){
				if (myUIM.getCurrentStateIndex()==3){return;}
				if (myUIM.getCurrentStateIndex()!=1){
					myUIM.setCurrentStateIndex(1);
				}
				else{
					myUIM.setCurrentStateIndex(0);
				}
			}
		};
		
		left = (int) (0.30625*width);
		up = (int) (0.040625*height);
		bwidth = (int) (0.12708*width);
		bheight = (int) (0.15625*height);
		Button archer = new Button(left,up,bwidth,bheight,5,5,5,5) {
			public void onClick(UIManager myUIM){
				if (myUIM.getCurrentStateIndex()==3){return;}
				myUIM.getMyPlayerTeam().spawnArcher();
			}
		};
		
		left = (int) (0.44375*width);
		up = (int) (0.015625*height);
		bwidth = (int) (0.11041*width);
		bheight = (int) (0.18124*height);
		Button knight = new Button(left,up,bwidth,bheight,6,6,6,6) {
			public void onClick(UIManager myUIM){
				if (myUIM.getCurrentStateIndex()==3){return;}
				myUIM.getMyPlayerTeam().spawnKnight();
				//System.out.println("Spawned knight hopefully.");
			}
		};
		
		left = (int) (0.572916*width);
		up = (int) (0.040625*height);
		bwidth = (int) (0.10833*width);
		bheight = (int) (0.1875*height);
		Button mage = new Button(left,up,bwidth,bheight,7,7,7,7) {
			public void onClick(UIManager myUIM){
				if (myUIM.getCurrentStateIndex()==3){return;}
				myUIM.getMyPlayerTeam().spawnMage();
			}
		};
		
		left = (int) (0.875*width);
		up = (int) (0.040625*height);
		bwidth = (int) (0.10416*width);
		bheight = (int) (0.15625*height);
		Button spell = new Button(left,up,bwidth,bheight,9,9,9,9) {
			public void onClick(UIManager myUIM){
				if (myUIM.getCurrentStateIndex()==3){return;}
				if (myUIM.getCurrentStateIndex()!=2){
					myUIM.setCurrentStateIndex(2);
				}
				else{
					myUIM.setCurrentStateIndex(0);
				}
			}
		};

		Widget[] state = {menu,archer,knight,mage,spell};
		myUIM.addState(state, true, 0);
		
		//MENU SUBMENU
		left = (int) (0.02083*width);
		up = (int) (0.215625*height);
		bwidth = (int) (0.10416*width);
		bheight = (int) (0.15625*height);
		Button map = new Button(left,up,bwidth,bheight,73,73,73,73) {
			public void onClick(UIManager myUIM){
				if (myUIM.getCurrentStateIndex()==3){return;}
				myUIM.setCurrentStateIndex(3);
			}
		};
		up = (int) (0.390625*height);
		Button options = new Button(left,up,bwidth,bheight,74,74,74,74) {
			public void onClick(UIManager myUIM){
				if (myUIM.getCurrentStateIndex()==3){return;}
			}
		};
		up = (int) (0.56875*height);
		Button quit = new Button(left,up,bwidth,bheight,75,75,75,75) {
			public void onClick(UIManager myUIM){
				if (myUIM.getCurrentStateIndex()==3){return;}
			}
		};
		
		
		//SPELLS SUBMENU
		left = (int) (0.86875*width);
		up = (int) (0.215625*height);
		bwidth = (int) (0.10416*width);
		bheight = (int) (0.15625*height);
		Button fire = new Button(left,up,bwidth,bheight,70,70,70,70) {
			public void onClick(UIManager myUIM){
				if (myUIM.getCurrentStateIndex()==3){return;}
			}
		};
		left = (int) (0.85625*width);
		up = (int) (0.390625*height);
		Button meteor = new Button(left,up,bwidth,bheight,71,71,71,71) {
			public void onClick(UIManager myUIM){
				if (myUIM.getCurrentStateIndex()==3){return;}
			}
		};
		left = (int) (0.87083*width);
		up = (int) (0.56875*height);
		Button stars = new Button(left,up,bwidth,bheight,72,72,72,72) {
			public void onClick(UIManager myUIM){
				if (myUIM.getCurrentStateIndex()==3){return;}
			}
		};
		
	}
	@Override
	public void onWindowFocusChanged (boolean hasFocus)
	{
	}
	public boolean onActivityResult(){
		return victoryState;		
	}
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int width = metrics.widthPixels;
		int height = metrics.heightPixels;
		
		Team friendlyTeam = new Team();
		Team enemyTeam = new Team();
		Player p = new Player(friendlyTeam);
		Team[] myTeams = {friendlyTeam,enemyTeam};
		
		int skill1,skill2,skill3,skill4;

		Bundle b = getIntent().getExtras();
		int countryID = b.getInt("ID");
		ApplicationManager globalVariable = (ApplicationManager) getApplicationContext();
		skill1 = globalVariable.getHealth(countryID);
		skill2 = globalVariable.getSpeed(countryID);
		skill3 = globalVariable.getDamage(countryID);
		skill4 = globalVariable.getCost(countryID);
		
		CombatUIManager myUIM = new CombatUIManager(friendlyTeam,enemyTeam,p);

		friendlyTeam.setSkills(skill1, skill2, skill3, skill4);
		enemyTeam.setSkills(skill1, skill2, skill3, skill4);
		
		setContentView(R.layout.activity_combat);
		CombatView myView = (CombatView) findViewById(R.id.vCombat);
		myView.setUIManager(myUIM);
		myView.setDims(width,height);
		myView.setTeams(friendlyTeam,enemyTeam);
		myView.doneInitialiazing();
		initGUI(width,height, myUIM);

		//init ai
		AI myAI = new AI(myTeams,myView.getMyRM()); //resets unit. Spawn after this line
		myUIM.setMyAI(myAI);	
		myAI.startMovingUnits();

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
