package com.example.painintheass.menus;

import com.example.painintheass.ApplicationManager;
import com.example.painintheass.R;
import com.example.painintheass.GameLogic.Country;
import com.example.painintheass.Graphics.Views.MapView;
import com.example.painintheass.Graphics.Views.OptionsView;
import com.example.painintheass.R.id;
import com.example.painintheass.R.layout;
import com.example.painintheass.UI.MapUIManager;
import com.example.painintheass.UI.OptionsUIManager;
import com.example.painintheass.UI.UIManager;
import com.example.painintheass.UI.widgets.Button;
import com.example.painintheass.UI.widgets.Label;
import com.example.painintheass.UI.widgets.Widget;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class OptionsActivity extends Activity{
	//Edits application wide variables
	//Each button changes a variable in the UI Manager corresponding to the application wide variable
	//When the activity is paused with the "ok" or "cancel" button the global variables are updated or not using the UIManager
	
	private OptionsUIManager myUIM;

	public void end(boolean state){
		ApplicationManager globalVariable = (ApplicationManager) getApplicationContext();
		if (state){
			globalVariable.setMusicVolume(myUIM.getMusicVolume());
			globalVariable.setSoundVolume(myUIM.getSoundVolume());
		}
		this.finish();
	}
	
 	public void initUI(int width, int height, OptionsUIManager myUIM){
		
		int left,up;
		
		
		left = (int) (0.0*width);
		up = (int) (0.0*height);
		Label musicBar = new Label(left,up,3);

		up = (int) (0.0*height);
		Label soundBar = new Label(left,up,3);

		Button[] musicKnobs = new Button[10];
		Button[] soundKnobs = new Button[10];
		
		int bwidth,bheight;

		left = (int) (0.0*width);
		up = (int) (0.0*height);
		bwidth = (int) (0.0*width);
		bheight = (int) (0.0*height);
		musicKnobs[0] = new Button(left,up,bwidth,bheight,2,1,2,2) {
			public void onClick(UIManager myUIM){
				myUIM.setVolume(0,0);
			}
		};
		left = (int) (0.0*width);
		musicKnobs[1] = new Button(left,up,bwidth,bheight,2,1,2,2) {
			public void onClick(UIManager myUIM){
				myUIM.setVolume(1,0);
			}
		};
		left = (int) (0.0*width);
		musicKnobs[2] = new Button(left,up,bwidth,bheight,2,1,2,2) {
			public void onClick(UIManager myUIM){
				myUIM.setVolume(2,0);
			}
		};
		left = (int) (0.0*width);
		musicKnobs[3] = new Button(left,up,bwidth,bheight,2,1,2,2) {
			public void onClick(UIManager myUIM){
				myUIM.setVolume(3,0);
			}
		};
		left = (int) (0.0*width);
		musicKnobs[4] = new Button(left,up,bwidth,bheight,2,1,2,2) {
			public void onClick(UIManager myUIM){
				myUIM.setVolume(4,0);
			}
		};
		left = (int) (0.0*width);
		musicKnobs[5] = new Button(left,up,bwidth,bheight,2,1,2,2) {
			public void onClick(UIManager myUIM){
				myUIM.setVolume(5,0);
			}
		};
		left = (int) (0.0*width);
		musicKnobs[6] = new Button(left,up,bwidth,bheight,2,1,2,2) {
			public void onClick(UIManager myUIM){
				myUIM.setVolume(6,0);
			}
		};
		left = (int) (0.0*width);
		musicKnobs[7] = new Button(left,up,bwidth,bheight,2,1,2,2) {
			public void onClick(UIManager myUIM){
				myUIM.setVolume(7,0);
			}
		};
		left = (int) (0.0*width);
		musicKnobs[8] = new Button(left,up,bwidth,bheight,2,1,2,2) {
			public void onClick(UIManager myUIM){
				myUIM.setVolume(8,0);
			}
		};
		left = (int) (0.0*width);
		musicKnobs[9] = new Button(left,up,bwidth,bheight,2,1,2,2) {
			public void onClick(UIManager myUIM){
				myUIM.setVolume(9,0);
			}
		};
		
		
		
		
		
		
		

		up = (int) (0.0*height);
		left = (int) (0.0*width);
		soundKnobs[0] = new Button(left,up,bwidth,bheight,2,1,2,2) {
			public void onClick(UIManager myUIM){
				myUIM.setVolume(0,1);
			}
		};
		left = (int) (0.0*width);
		soundKnobs[1] = new Button(left,up,bwidth,bheight,2,1,2,2) {
			public void onClick(UIManager myUIM){
				myUIM.setVolume(1,1);
			}
		};
		left = (int) (0.0*width);
		soundKnobs[2] = new Button(left,up,bwidth,bheight,2,1,2,2) {
			public void onClick(UIManager myUIM){
				myUIM.setVolume(2,1);
			}
		};
		left = (int) (0.0*width);
		soundKnobs[3] = new Button(left,up,bwidth,bheight,2,1,2,2) {
			public void onClick(UIManager myUIM){
				myUIM.setVolume(3,1);
			}
		};
		left = (int) (0.0*width);
		soundKnobs[4] = new Button(left,up,bwidth,bheight,2,1,2,2) {
			public void onClick(UIManager myUIM){
				myUIM.setVolume(4,1);
			}
		};
		left = (int) (0.0*width);
		soundKnobs[5] = new Button(left,up,bwidth,bheight,2,1,2,2) {
			public void onClick(UIManager myUIM){
				myUIM.setVolume(5,1);
			}
		};
		left = (int) (0.0*width);
		soundKnobs[6] = new Button(left,up,bwidth,bheight,2,1,2,2) {
			public void onClick(UIManager myUIM){
				myUIM.setVolume(6,1);
			}
		};
		left = (int) (0.0*width);
		soundKnobs[7] = new Button(left,up,bwidth,bheight,2,1,2,2) {
			public void onClick(UIManager myUIM){
				myUIM.setVolume(7,1);
			}
		};
		left = (int) (0.0*width);
		soundKnobs[8] = new Button(left,up,bwidth,bheight,2,1,2,2) {
			public void onClick(UIManager myUIM){
				myUIM.setVolume(8,1);
			}
		};
		left = (int) (0.0*width);
		soundKnobs[9] = new Button(left,up,bwidth,bheight,2,1,2,2) {
			public void onClick(UIManager myUIM){
				myUIM.setVolume(9,1);
			}
		};
		
		
		
		Button Cancel = new Button(left,up,bwidth,bheight,4,4,4,4){
			public void onClick(UIManager myUIM){
				myUIM.setUpdate(false);
				myUIM.setEndActivity(true);
			}
		};
		
		Button Ok = new Button(left,up,bwidth,bheight,4,4,4,4){
			public void onClick(UIManager myUIM){
				myUIM.setUpdate(true);
				myUIM.setEndActivity(true);
			}
		};
		
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
				
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int width = metrics.widthPixels;
		int height = metrics.heightPixels;
		
		
		myUIM = new OptionsUIManager();
		
		
		setContentView(R.layout.activity_options);
		OptionsView myView = (OptionsView) findViewById(R.id.vOptions);
		myView.setUIManager(myUIM);
		myView.doneInitialiazing();
		
		
		
		
	}
}
