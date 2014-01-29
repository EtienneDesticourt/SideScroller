package com.example.painintheass;

import com.example.painintheass.Graphics.MenuView;
import com.example.painintheass.UI.Button;
import com.example.painintheass.UI.UIManager;
import com.example.painintheass.UI.Widget;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class MainMenuActivity extends Activity{

	
	public void initMenu(int width, int height, UIManager myUIM){
		

		int left = (int) (0.58*width);
		int up;
		int buttonWidth = (int) (0.4*width);  
		int buttonHeight = (int) (0.11*height);
				
		//PLAY BUTTON
		up = (int) (0.03*height);
		Button playButton = new Button(left,up,buttonWidth,buttonHeight) {
			public void onClick(UIManager myUIM){
				System.out.println("Pressed play.");
			}
		};
		playButton.setBackgroundImage(1);
		//OPTIONS BUTTON
		up = (int) (0.23*height);
		Button optionsButton = new Button(left,up,buttonWidth,buttonHeight) {
			public void onClick(UIManager myUIM){	
				System.out.println("Pressed options.");			
			}
		};		
		optionsButton.setBackgroundImage(2);
		//QUIT BUTTON
		up = (int) (0.42*height);
		Button quitButton = new Button(left,up,buttonWidth,buttonHeight){
			public void onClick(UIManager myUIM){	
				System.out.println("Pressed quit.");			
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
	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int width = metrics.widthPixels;
		int height = metrics.heightPixels;
		
		
		UIManager myUIM = new UIManager();
		
		initMenu(width,height,myUIM);
		
		setContentView(R.layout.activity_main);		
		MenuView myView = (MenuView) findViewById(R.id.vMenuMain);
		myView.setUIManager(myUIM);
		myView.doneInitialiazing();
		
		
		
	}
	
}
