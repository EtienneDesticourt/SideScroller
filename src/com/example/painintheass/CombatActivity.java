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
import android.os.Bundle;
import android.util.DisplayMetrics;

public class CombatActivity extends Activity {
	
	
	private void initGUI(int width, int height, CombatUIManager myUIM){
		int left,up;
		int bwidth,bheight;

		
		left = (int) (0.02083*width);
		up = (int) (0.040625*height);
		bwidth = (int) (0.10416*width);
		bheight = (int) (0.15625*height);
		Button menu = new Button(left,up,bwidth,bheight,8,8,8,8) {
			public void onClick(UIManager myUIM){
			}
		};
		
		left = (int) (0.30625*width);
		up = (int) (0.040625*height);
		bwidth = (int) (0.12708*width);
		bheight = (int) (0.15625*height);
		Button archer = new Button(left,up,bwidth,bheight,5,5,5,5) {
			public void onClick(UIManager myUIM){
				myUIM.getMyPlayerTeam().spawnArcher();
			}
		};
		
		left = (int) (0.44375*width);
		up = (int) (0.015625*height);
		bwidth = (int) (0.11041*width);
		bheight = (int) (0.18124*height);
		Button knight = new Button(left,up,bwidth,bheight,6,6,6,6) {
			public void onClick(UIManager myUIM){
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
				myUIM.getMyPlayerTeam().spawnMage();
			}
		};
		
		left = (int) (0.875*width);
		up = (int) (0.040625*height);
		bwidth = (int) (0.10416*width);
		bheight = (int) (0.15625*height);
		Button spell = new Button(left,up,bwidth,bheight,9,9,9,9) {
			public void onClick(UIManager myUIM){
			}
		};
		
		Widget[] state = {menu,archer,knight,mage,spell};
		myUIM.addState(state, true, 0);
	}
	@Override
	public void onWindowFocusChanged (boolean hasFocus)
	{
		
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
		
		
		CombatUIManager myUIM = new CombatUIManager(friendlyTeam,enemyTeam,p);

		
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
}
