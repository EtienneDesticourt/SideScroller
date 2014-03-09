package com.example.painintheass;

import com.example.painintheass.Graphics.OptionsView;
import com.example.painintheass.Graphics.SkillsView;
import com.example.painintheass.UI.Button;
import com.example.painintheass.UI.Label;
import com.example.painintheass.UI.OptionsUIManager;
import com.example.painintheass.UI.SkillsUIManager;
import com.example.painintheass.UI.UIManager;
import com.example.painintheass.UI.Widget;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class SkillsActivity extends Activity{
	
	SkillsUIManager myUIM;
	private int countryID;
	
	
	
	public Widget[] initCostGUI(int width, int height, OptionsUIManager myUIM){
		int left,up,bwidth,bheight;
		

		left = (int) (0.0*width);
		up = (int) (0.0*height);
		Label title = new Label(left,up,9);

		left = (int) (0.0*width);
		up = (int) (0.0*height);
		Label icon = new Label(left,up,5);
		
		Widget[] state = new Widget[100];
		Button current;
		up = (int) (0.0*height);
		bwidth = (int) (0.0*width);
		bheight = (int) (0.0*height);
		int i;
		for (i=0;i<10;i++){
			left = (int) (0.0*width);
			current= new Button(left,up,bwidth,bheight,2,3,2,2){
				public void onClick(UIManager myUIM){
				}
			};
			state[i] = current;			
		}

		left = (int) (0.0*width);
		up = (int) (0.0*height);
		bwidth = (int) (0.0*width);
		bheight = (int) (0.0*height);
		current = new Button(left,up,bwidth,bheight,12,12,12,12){
			public void onClick(UIManager myUIM){
				int currentCost = myUIM.getCost();
				if (currentCost<10){
					myUIM.increaseCost();
				}
			}
		};

		state[i+1] = title;
		state[i+2] = icon;
		state[i+3] = current;		
		return state;		
	}
	
	public Widget[] initHealthGUI(int width, int height, OptionsUIManager myUIM){
		int left,up,bwidth,bheight;
		

		left = (int) (0.0*width);
		up = (int) (0.0*height);
		Label title = new Label(left,up,8);

		left = (int) (0.0*width);
		up = (int) (0.0*height);
		Label icon = new Label(left,up,7);
		
		Widget[] state = new Widget[100];
		Button current;
		up = (int) (0.0*height);
		bwidth = (int) (0.0*width);
		bheight = (int) (0.0*height);
		int i;
		for (i=0;i<10;i++){
			left = (int) (0.0*width);
			current= new Button(left,up,bwidth,bheight,2,3,2,2){
				public void onClick(UIManager myUIM){
				}
			};
			state[i] = current;			
		}

		left = (int) (0.0*width);
		up = (int) (0.0*height);
		bwidth = (int) (0.0*width);
		bheight = (int) (0.0*height);
		current = new Button(left,up,bwidth,bheight,12,12,12,12){
			public void onClick(UIManager myUIM){
				int currentHealth = myUIM.getHealth();
				if (currentHealth<10){
					myUIM.increaseHealth();
				}
			}
		};

		state[i+1] = title;
		state[i+2] = icon;
		state[i+3] = current;		
		return state;	
	}
	
	public Widget[] initDamageGUI(int width, int height, OptionsUIManager myUIM){
		int left,up,bwidth,bheight;
		

		left = (int) (0.0*width);
		up = (int) (0.0*height);
		Label title = new Label(left,up,11);

		left = (int) (0.0*width);
		up = (int) (0.0*height);
		Label icon = new Label(left,up,6);
		
		Widget[] state = new Widget[100];
		Button current;
		up = (int) (0.0*height);
		bwidth = (int) (0.0*width);
		bheight = (int) (0.0*height);
		int i;
		for (i=0;i<10;i++){
			left = (int) (0.0*width);
			current= new Button(left,up,bwidth,bheight,2,3,2,2){
				public void onClick(UIManager myUIM){
				}
			};
			state[i] = current;			
		}

		left = (int) (0.0*width);
		up = (int) (0.0*height);
		bwidth = (int) (0.0*width);
		bheight = (int) (0.0*height);
		current = new Button(left,up,bwidth,bheight,12,12,12,12){
			public void onClick(UIManager myUIM){
				int currentDamage = myUIM.getDamage();
				if (currentDamage<10){
					myUIM.increaseStrength();
				}
			}
		};

		state[i+1] = title;
		state[i+2] = icon;
		state[i+3] = current;		
		return state;
	}
	
	public Widget[] initSpeedGUI(int width, int height, OptionsUIManager myUIM){
		int left,up,bwidth,bheight;
		

		left = (int) (0.0*width);
		up = (int) (0.0*height);
		Label title = new Label(left,up,10);

		left = (int) (0.0*width);
		up = (int) (0.0*height);
		Label icon = new Label(left,up,4);
		
		Widget[] state = new Widget[100];
		Button current;
		up = (int) (0.0*height);
		bwidth = (int) (0.0*width);
		bheight = (int) (0.0*height);
		int i;
		for (i=0;i<10;i++){
			left = (int) (0.0*width);
			current= new Button(left,up,bwidth,bheight,2,3,2,2){
				public void onClick(UIManager myUIM){
				}
			};
			state[i] = current;			
		}

		left = (int) (0.0*width);
		up = (int) (0.0*height);
		bwidth = (int) (0.0*width);
		bheight = (int) (0.0*height);
		current = new Button(left,up,bwidth,bheight,12,12,12,12){
			public void onClick(UIManager myUIM){
				int currentSpeed = myUIM.getSpeed();
				if (currentSpeed<10){
					myUIM.increaseSpeed();
				}
			}
		};

		state[i+1] = title;
		state[i+2] = icon;
		state[i+3] = current;		
		return state;
	}
	
	public void initGUI(int width, int height, OptionsUIManager myUIM){
		
		
		int left,up,bwidth,bheight;
		

		left = (int) (0.0*width);
		up = (int) (0.0*height);
		Label title = new Label(left,up,10);
		
		left = (int) (0.0*width);
		up = (int) (0.0*height);
		bwidth = (int) (0.0*width);
		bheight = (int) (0.0*height);
		Button ok = new Button(left,up,bwidth,bheight,13,13,13,13){
			public void onClick(UIManager myUIM){
				myUIM.setUpdate(true);
				myUIM.setEndActivity(true);
			}
		};
		left = (int) (0.0*width);
		bwidth = (int) (0.0*width);
		bheight = (int) (0.0*height);
		Button cancel = new Button(left,up,bwidth,bheight,14,14,14,14){
			public void onClick(UIManager myUIM){
				myUIM.setUpdate(false);
				myUIM.setEndActivity(true);
			}
		};
		left = (int) (0.0*width);
		bwidth = (int) (0.0*width);
		bheight = (int) (0.0*height);
		Button reset = new Button(left,up,bwidth,bheight,15,15,15,15){
			public void onClick(UIManager myUIM){
				myUIM.resetMods();
			}
		};
		
		Widget[] state = new Widget[100];
		Widget[] temp1,temp2,temp3,temp4;
		temp1 = initCostGUI(width,height,myUIM);
		temp2 = initHealthGUI(width,height,myUIM);
		temp3 = initDamageGUI(width,height,myUIM);
		temp4 = initSpeedGUI(width,height,myUIM);
		int i;
		for (i=0;i<13;i++){
			state[i] = temp1[i];
			state[i+12] = temp2[i];
			state[i+24] = temp3[i];
			state[i+36] = temp4[i];			
		}
		
		state[i+36+1] = title;
		state[i+36+2] = reset;
		state[i+36+3] = cancel;
		state[i+36+4] = ok;
		myUIM.addState(state, false);
		
		
		
	}
	
	public void end(boolean state){
		ApplicationManager globalVariable = (ApplicationManager) getApplicationContext();
		if (state){
			globalVariable.setHealth(myUIM.getHealth(),countryID);
			globalVariable.setSpeed(myUIM.getSpeed(),countryID);
			globalVariable.setDamage(myUIM.getDamage(),countryID);
			globalVariable.setCost(myUIM.getCost(),countryID);
		}
		this.finish();
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		Bundle b = getIntent().getExtras();
		int cost,health,strength,speed;
		if (b!=null){
			countryID = b.getInt("ID");
			ApplicationManager globalVariable = (ApplicationManager) getApplicationContext();
			cost = globalVariable.getCost(countryID);
			strength = globalVariable.getDamage(countryID);
			health = globalVariable.getHealth(countryID);
			speed = globalVariable.getSpeed(countryID);
		}
		else{
			System.out.println("Skill activity has been started without country ID and skill points.");
			finish();
			return;
		}
		
		
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int width = metrics.widthPixels;
		int height = metrics.heightPixels;
		
		
		myUIM = new SkillsUIManager();
		myUIM.setCost(cost);
		myUIM.setHealth(health);
		myUIM.setDamage(strength);
		myUIM.setSpeed(speed);
		
		
		setContentView(R.layout.activity_options);
		SkillsView myView = (SkillsView) findViewById(R.id.vOptions);
		myView.setUIManager(myUIM);
		myView.doneInitialiazing();
		
		
		
		
	}
}
