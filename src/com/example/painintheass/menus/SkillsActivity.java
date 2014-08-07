package com.example.painintheass.menus;

import com.example.painintheass.ApplicationManager;
import com.example.painintheass.R;
import com.example.painintheass.Graphics.OptionsView;
import com.example.painintheass.Graphics.SkillsView;
import com.example.painintheass.R.id;
import com.example.painintheass.R.layout;
import com.example.painintheass.UI.OptionsUIManager;
import com.example.painintheass.UI.SkillsUIManager;
import com.example.painintheass.UI.UIManager;
import com.example.painintheass.UI.widgets.Button;
import com.example.painintheass.UI.widgets.Label;
import com.example.painintheass.UI.widgets.TextLabel;
import com.example.painintheass.UI.widgets.Widget;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class SkillsActivity extends Activity{
	
	SkillsUIManager myUIM;
	private int countryID;
	
	
 	public Widget[] initCostGUI(int width, int height, SkillsUIManager myUIM){
		int left,up,bwidth,bheight;
		

//		left = (int) (0.0*width);
//		up = (int) (0.0*height);
//		Label title = new Label(left,up,9);

		left = (int) (0.0333333333333*width);
		up = (int) (0.19375*height);
		Label icon = new Label(left,up,5);
		
		Widget[] state = new Widget[100];
		Button current;
		up = (int) (0.2*height);
		bwidth = (int) (0.0625*width);
		bheight = (int) (0.140625*height);
		int i;
		for (i=0;i<10;i++){
			left = (int) ((0.175+i*0.072917)*width);
			current= new Button(left,up,bwidth,bheight,2,3,2,2){
				public void onClick(UIManager myUIM){
				}
			};
			state[i] = current;			
		}

		left = (int) ((0.84375+0.072917)*width);
		up = (int) (0.23125*height);
		bwidth = (int) (0.05208*width);
		bheight = (int) (0.078125*height);
		current = new Button(left,up,bwidth,bheight,12,12,12,12){
			public void onClick(UIManager myUIM){
				int currentCost = myUIM.getCost();
				if (currentCost<10){
					myUIM.increaseCost();
				}
			}
		};

//		state[i+1] = title;
		state[i] = icon;
		state[i+1] = current;		
		return state;		
	}
	
	public Widget[] initHealthGUI(int width, int height, SkillsUIManager myUIM){
		int left,up,bwidth,bheight;
		

//		left = (int) (0.0*width);
//		up = (int) (0.0*height);
//		Label title = new Label(left,up,8);
		
		left = (int) (0.0333333333333*width);
		up = (int) ((0.19375+0.1875*1)*height);
		Label icon = new Label(left,up,7);
		
		Widget[] state = new Widget[100];
		Button current;
		up = (int) ((0.2+0.1875*1)*height);
		bwidth = (int) (0.0625*width);
		bheight = (int) (0.140625*height);
		int i;
		for (i=0;i<10;i++){
			left = (int) ((0.175+i*0.072917)*width);
			current= new Button(left,up,bwidth,bheight,2,3,2,2){
				public void onClick(UIManager myUIM){
				}
			};
			state[i] = current;			
		}

		left = (int) ((0.84375+0.072917)*width);
		up = (int) ((0.23125+0.1875*1)*height);
		bwidth = (int) (0.05208*width);
		bheight = (int) ((0.078125)*height);
		current = new Button(left,up,bwidth,bheight,12,12,12,12){
			public void onClick(UIManager myUIM){
				int currentHealth = myUIM.getHealth();
				if (currentHealth<10){
					myUIM.increaseHealth();
				}
			}
		};

//		state[i+1] = title;
		state[i] = icon;
		state[i+1] = current;			
		return state;	
	}
	
	public Widget[] initStrengthGUI(int width, int height, SkillsUIManager myUIM){
		int left,up,bwidth,bheight;
		
//
//		left = (int) (0.0*width);
//		up = (int) (0.0*height);
//		Label title = new Label(left,up,11);

		left = (int) (0.0333333333333*width);
		up = (int) ((0.19375+0.1875*2)*height);
		Label icon = new Label(left,up,6);
		
		Widget[] state = new Widget[100];
		Button current;
		up = (int) ((0.2+0.1875*2)*height);
		bwidth = (int) (0.0625*width);
		bheight = (int) (0.140625*height);
		int i;
		for (i=0;i<10;i++){
			left = (int) ((0.175+i*0.072917)*width);
			current= new Button(left,up,bwidth,bheight,2,3,2,2){
				public void onClick(UIManager myUIM){
				}
			};
			state[i] = current;			
		}

		left = (int) ((0.84375+0.072917)*width);
		up = (int) ((0.23125+0.1875*2)*height);
		bwidth = (int) (0.05208*width);
		bheight = (int) (0.078125*height);
		current = new Button(left,up,bwidth,bheight,12,12,12,12){
			public void onClick(UIManager myUIM){
				int currentDamage = myUIM.getDamage();
				if (currentDamage<10){
					myUIM.increaseStrength();
				}
			}
		};

//		state[i+1] = title;
		state[i] = icon;
		state[i+1] = current;			
		return state;
	}
	
	public Widget[] initTimeGUI(int width, int height, SkillsUIManager myUIM){
		int left,up,bwidth,bheight;
		

//		left = (int) (0.0*width);
//		up = (int) (0.0*height);
//		Label title = new Label(left,up,10);

		left = (int) (0.0333333333333*width);
		up = (int) ((0.19375+0.1875*3)*height);
		Label icon = new Label(left,up,4);
		
		Widget[] state = new Widget[100];
		Button current;
		up = (int) ((0.2+0.1875*3)*height);
		bwidth = (int) (0.0625*width);
		bheight = (int) (0.140625*height);
		int i;
		for (i=0;i<10;i++){
			left = (int) ((0.175+i*0.072917)*width);
			current= new Button(left,up,bwidth,bheight,2,3,2,2){
				public void onClick(UIManager myUIM){
				}
			};
			state[i] = current;			
		}

		left = (int) ((0.84375+0.072917)*width);
		up = (int) ((0.23125+0.1875*3)*height);
		bwidth = (int) (0.05208*width);
		bheight = (int) (0.078125*height);
		current = new Button(left,up,bwidth,bheight,12,12,12,12){
			public void onClick(UIManager myUIM){
				int currentSpeed = myUIM.getSpeed();
				if (currentSpeed<10){
					myUIM.increaseTime();
				}
			}
		};

//		state[i+1] = title;
		state[i] = icon;
		state[i+1] = current;			
		return state;
	}
	
	public void initGUI(int width, int height, SkillsUIManager myUIM){
		
		
		int left,up,bwidth,bheight;
		

		left = (int) (0.0291666666*width);
		up = (int) (0.021875*height);
		Label title = new Label(left,up,1);
		
		left = (int) (0.54375*width);
		up = (int) (0.059375*height);
		bwidth = (int) (0.125*width);
		bheight = (int) (0.078125*height);
		Button ok = new Button(left,up,bwidth,bheight,13,13,13,13){
			public void onClick(UIManager myUIM){
				myUIM.setUpdate(true);
				myUIM.setEndActivity(true);
			}
		};
		left = (int) (0.689584*width);
		Button cancel = new Button(left,up,bwidth,bheight,14,14,14,14){
			public void onClick(UIManager myUIM){
				myUIM.setUpdate(false);
				myUIM.setEndActivity(true);
			}
		};
		left = (int) (0.83333333334*width);
		Button reset = new Button(left,up,bwidth,bheight,15,15,15,15){
			public void onClick(UIManager myUIM){
				myUIM.resetMods();
			}
		};
		left = (int) (0.45625*width);
		Label coin = new Label(left,up,16);	
		up = (int) (0.059375*height) +10;	
		TextLabel money = new TextLabel(left,up, String.valueOf(myUIM.getMoney()));
		
		
		Widget[] state = new Widget[54];
		Widget[] temp1,temp2,temp3,temp4;
		temp1 = initCostGUI(width,height,myUIM);
		temp2 = initHealthGUI(width,height,myUIM);
		temp3 = initStrengthGUI(width,height,myUIM);
		temp4 = initTimeGUI(width,height,myUIM);
		int i;
		for (i=0;i<12;i++){
//			System.out.println(i);
//			System.out.println(i+12);
//			System.out.println(i+24);
//			System.out.println(i+36);
			state[i] = temp1[i];
			state[i+12] = temp2[i];
			state[i+24] = temp3[i];
			state[i+36] = temp4[i];			
		}
		
		state[i+36] = title;
//		System.out.println(i+36);
		state[i+36+1] = reset;
//		System.out.println(i+36+1);
		state[i+36+2] = cancel;
//		System.out.println(i+36+2);
		state[i+36+3] = ok;
//		System.out.println(i+36+3);
		state[i+36+4] = coin;
		state[i+36+5] = money;
		myUIM.addState(state, false,0);
		
		
		
	}
	
	public void end(boolean state){
		ApplicationManager globalVariable = (ApplicationManager) getApplicationContext();
		if (state){
			globalVariable.setHealth(myUIM.getHealth(),countryID);
			globalVariable.setTime(myUIM.getSpeed(),countryID);
			globalVariable.setDamage(myUIM.getDamage(),countryID);
			globalVariable.setCost(myUIM.getCost(),countryID);
			globalVariable.setMoney(myUIM.getMoney(),countryID);
		}
		this.finish();
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		Bundle b = getIntent().getExtras();
		int cost,health,strength,time,money;
		if (b!=null){
			countryID = b.getInt("ID");
			ApplicationManager globalVariable = (ApplicationManager) getApplicationContext();
			cost = globalVariable.getCost(countryID);
			strength = globalVariable.getStrength(countryID);
			health = globalVariable.getHealth(countryID);
			time = globalVariable.getTime(countryID);
			money = globalVariable.getCountry(countryID).getMoney();
			
		}
		else{
			//STANDALONE TEST
			cost = 1;
			health = 2;
			strength = 3;
			time = 4;
			money = 5;
			
			//RELEASE VERSION
//			System.out.println("Skill activity has been started without country ID and skill points.");
//			finish();
//			return;
		}
		
		
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int width = metrics.widthPixels;
		int height = metrics.heightPixels;
		
		
		myUIM = new SkillsUIManager();
		myUIM.setCost(cost);
		myUIM.setHealth(health);
		myUIM.setStrength(strength);
		myUIM.setTime(time);
		initGUI(width,height, myUIM);
		myUIM.setMoney(money);
		myUIM.update();
		
		setContentView(R.layout.activity_skills);
		SkillsView myView = (SkillsView) findViewById(R.id.vSkills);
		myView.setUIManager(myUIM);
		myView.doneInitialiazing();
		
		
		
		
	}
}
