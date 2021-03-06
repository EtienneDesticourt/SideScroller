/*
 * 

*/




package com.example.painintheass.menus;

import com.example.painintheass.R;
import com.example.painintheass.Graphics.Views.MenuView;
import com.example.painintheass.R.id;
import com.example.painintheass.R.layout;
import com.example.painintheass.UI.UIManager;
import com.example.painintheass.UI.widgets.Button;
import com.example.painintheass.UI.widgets.Widget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;

/**
 * This <code>Activity</code> is responsible for handling the creation of everything related to the menu scene.
 * Including the UI manager and the view. 
 */
public class MainMenuActivity extends Activity{
	private int type = 0;
	
	/**
	 * Creates the widgets necessary for the menu.
	 * @param width Screen's width
	 * @param height Screen's height
	 * @param myUIM The menu's UI manager
	 */
	public void initMenu(int width, int height, UIManager myUIM){
		int left = (int) (0.58*width);
		int up;
		int buttonWidth = (int) (0.4*width);  
		int buttonHeight = (int) (0.11*height);

		//PLAY BUTTON
		up = (int) (0.03*height);
		Button playButton = new Button(left,up,buttonWidth,buttonHeight) {
			public void onClick(UIManager myUIM){
				startActivity(myUIM.getIntent(1));
			}
		};
		playButton.setBackgroundImage(1);
		//OPTIONS BUTTON
		up = (int) (0.23*height);
		Button optionsButton = new Button(left,up,buttonWidth,buttonHeight) {
			public void onClick(UIManager myUIM){	
				startActivity(myUIM.getIntent(3));		
			}
		};		
		optionsButton.setBackgroundImage(2);
		//QUIT BUTTON
		up = (int) (0.42*height);
		Button quitButton = new Button(left,up,buttonWidth,buttonHeight){
			public void onClick(UIManager myUIM){
				//I know how the activity life cycle works
				//I know this is unnecessary but I've already put the button in
				//and I don't have time to rethink the UI right now
				Intent startMain = new Intent(Intent.ACTION_MAIN);
				startMain.addCategory(Intent.CATEGORY_HOME);
				startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(startMain);	
			}
		};
		quitButton.setBackgroundImage(3);
		//TITLE LABEL
		up = (int) (0.20*height);
		left = (int) (0.04*width);
		Button titleLabel = new Button(left,up,0,0) {
			public void onClick(UIManager myUIM){				
			}
		};
		titleLabel.setBackgroundImage(4);
		
		Widget[] state = {playButton,optionsButton,quitButton,titleLabel};
		myUIM.addState(state,false,0);
	}

	/**
	 * Creates the menu Activity.
	 */
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		
		//Get size to scale UI
		int width = metrics.widthPixels;
		int height = metrics.heightPixels;		
		//Init UI handle and all buttons
		UIManager myUIM = new UIManager(this);
		initMenu(width,height,myUIM);
		
		//Init view
		setContentView(R.layout.activity_main);		
		MenuView myView = (MenuView) findViewById(R.id.vMenuMain);
		myView.setUIManager(myUIM);
		myView.doneInitialiazing();
		
		
		
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
