package com.example.painintheass.GameLogic;

import java.util.Date;

import com.example.painintheass.Graphics.Animation;
import com.example.painintheass.Graphics.ResourceManager;

import android.graphics.Rect;

public class AI {
	private int NUMBER_OF_TEAM=2;
	private boolean calcMoves;
	private boolean calcCollisions;
	private Team[] MyTeams;
	private boolean gameIsRunning = true;
	private static int moveCalcDelay =  (int) (1000/30.0);
	private ResourceManager myRM;
	
	public AI(Team[] MyTeams, ResourceManager newRM){
		this.MyTeams = MyTeams;
		myRM = newRM;
		updateUnits();
		checkCollision();
	}
	
	
	
	public void updateUnits(){
		new Thread(new Runnable() {
	        public void run() {	        	
	        	while (gameIsRunning){
	        		long lastTime;
	        		long current;
		        	while (calcMoves){	
		        		for (int teamIndex = 0; teamIndex<NUMBER_OF_TEAM; teamIndex++){		        			
		        			Unit[] myUnits = MyTeams[teamIndex].getUnits();
		        			int side = MyTeams[teamIndex].getMovementSide();		        			
			    			for (int i =0; i<100;i++){//MyTeams[teamIndex].getUnitsNumber();i++){
		    					current = new Date().getTime();
			    				if (myUnits[i]==null){
			    					break;
			    				}
			    				myUnits[i].lock();
			    				if (myUnits[i].getType()==4){ //castle doesn't move or attack
				    				myUnits[i].unlock();
			    					continue;
			    				}
			    				
			    				int action = myUnits[i].getAction();
			    				//MOVE UNIT
			    				if (action == 0){
			    					myUnits[i].step(side);
			    				}
			    				//ATTACK TARGET
			    				else if (action == 1){
			    					lastTime = myUnits[i].getLastAttack();
			    					if ( (current-lastTime) >= myUnits[i].getAttackSpeed() ){
			    						myUnits[i].attack();
			    						myUnits[i].setLastAttack(current);
			    					}
			    				}
			    				
			    				//UPDATE ANIMATION
		    					int temp = myUnits[i].getCurrFrame();
		    					Animation currAnim;
		    					lastTime =  myUnits[i].getLastAnimUpdate();
		    					
		    					currAnim = myRM.getAnimation(myUnits[i].getType(), action);
		    					System.out.println(myUnits[i].getType()+" "+action);
		    					if ((current-lastTime)>currAnim.getSpeed()){ //crashes on 0 0
		    						if (temp+1>currAnim.getLength()-1){
			    						myUnits[i].setCurrFrame(0);
			    					}
			    					else{
				    					myUnits[i].setCurrFrame(temp+1);		    						
			    					}
		    						myUnits[i].setLastAnimUpdate(current);
		    					}
		    					myUnits[i].unlock();
			    			}			    			
		        		}
		        		Projectile[][] myProjectiles = { MyTeams[0].getMyProjectiles(),MyTeams[1].getMyProjectiles()};
		        		for (int i=0;i<2;i++){
		        			for (int j=0;j<1000;j++){
		        				if (myProjectiles[i][j]==null){
		        					break;
		        				}
		        				myProjectiles[i][j].step();
		        			}
		        		}
		    			try {
							Thread.sleep(moveCalcDelay);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
		    		}
		        	try {
						Thread.sleep(moveCalcDelay);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	        	}
	        }
	    }).start();	
		//System.out.println("Done starting");
	}
	
	public void checkCollision(){
		new Thread(new Runnable() {
	        public void run() {
	        	Unit[] UnitsTeam0 = MyTeams[0].getUnits();
	        	Unit[] UnitsTeam1 = MyTeams[1].getUnits();
	        	Projectile[] myProjectiles0 = MyTeams[0].getMyProjectiles();
	        	Projectile[] myProjectiles1 = MyTeams[1].getMyProjectiles();
	        	while (gameIsRunning){
		        	while (calcCollisions){
		        		Unit currUnit;
		    			for (int i =0; i<100;i++){//MyTeams[0].getUnitsNumber();i++){
		    				currUnit = UnitsTeam0[i];
		    				if (currUnit==null){
		    					break;
		    				}

		    				currUnit.lock();
		    				if (currUnit.getAction()==3){
			    				currUnit.unlock();
		    					continue;
		    				}
		    				for (int j=0; j<100;j++){//MyTeams[1].getUnitsNumber();j++){
		    					
		    					if (UnitsTeam1[j]==null ){
		    						break;
		    					}
		    					UnitsTeam1[j].lock();
		    					if (UnitsTeam1[j].getAction()==3){
			    					UnitsTeam1[j].unlock();
		    						continue;
		    					}
		    					
		    					if (Rect.intersects(currUnit.getAttackRect(), UnitsTeam1[j].getBodyRect())){
		    						if (currUnit.getType()!=4){
			    						currUnit.setAction(1);
			    						currUnit.setTarget(UnitsTeam1[j]);	
		    						}
		    					}
		    					
		    					if (Rect.intersects(UnitsTeam1[j].getAttackRect(), currUnit.getBodyRect())){
		    						if (UnitsTeam1[j].getType()!=4){
			    						UnitsTeam1[j].setAction(1);
			    						UnitsTeam1[j].setTarget(currUnit);
		    						}
		    					}		 
		    					
		    					UnitsTeam1[j].unlock();
		    				}
		    				currUnit.unlock();
		    			}
		    			
		    			for (int i=0; i<1000;i++){
		    				if (myProjectiles0[i]==null && myProjectiles1[i]==null){
		    					break;
		    				}
		    				for (int j=0;j<100;j++){
		    					if (UnitsTeam1[j]==null && UnitsTeam0[j]==null){ break;}
		    					if (UnitsTeam1[j]!=null){
			    					if (myProjectiles0[i]!=null){
			    						if (Rect.intersects(UnitsTeam1[j].getBodyRect(), myProjectiles0[i].getMyRect() )){
			    							UnitsTeam1[j].hit(myProjectiles0[i].getDamage(), true);
			    							MyTeams[0].delProjectile(i);
			    						}
			    					}
		    					}
		    					if (UnitsTeam0[j]!=null){
			    					if (myProjectiles1[i]!=null){
			    						if(Rect.intersects(UnitsTeam0[j].getBodyRect(), myProjectiles1[i].getMyRect() )){
			    							UnitsTeam0[j].hit(myProjectiles1[i].getDamage(), true);
			    							MyTeams[1].delProjectile(i);
			    						}
			    						
			    					}
		    					}
		    				}
		    			}
		    			
		    			
		    			
		    			
		    			
		    			
		    			
		    			try {
							Thread.sleep(moveCalcDelay);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
		    		}

	    			try {
						Thread.sleep(moveCalcDelay);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	        	}
	        }
	    }).start();			
	}
	
	public void deleteUnits(){
		new Thread(new Runnable() {
	        public void run() {
	        	while (gameIsRunning){
	        		
	        		for (int i=0;i<2;i++){
	        			Unit[] delQueue = MyTeams[i].getDelQueue();
	        			Unit[] UnitsTeam = MyTeams[i].getUnits();
	        			
	        			for (int j=0;j<100;j++){
	        				if (delQueue[j]==null){
								break;
							}
	        				for (int k=0;k<100;k++){
	        					
	        					if (delQueue[j]==UnitsTeam[k]){
	        						while (delQueue[j].isLocked()){ //WHILE BEING USED BY OTHER THREAD
	        							try {
	        								Thread.sleep(10);
	        							} catch (InterruptedException e) {
	        								e.printStackTrace();
	        							}
	        						}
	        						//ELSE DELETE
	        						MyTeams[i].removeUnit(k);
	        						break;
	        					}
	        				}
	        			}
	        			MyTeams[i].setNumberToDelete(0);
	        			
	        		}
	        	}
	        }
		
		}).start();	
	}
	
//	public void deleteProjectiles(){
//		new Thread(new Runnable() {
//	        public void run() {
//	        	while (gameIsRunning){
//	        		
//	        		for (int i=0;i<2;i++){
//	        			Unit[] delQueue = MyTeams[i].getDelQueue();
//	        			Unit[] UnitsTeam = MyTeams[i].getUnits();
//	        			
//	        			for (int j=0;j<100;j++){
//	        				if (delQueue[j]==null){
//								break;
//							}
//	        				for (int k=0;k<100;k++){
//	        					
//	        					if (delQueue[j]==UnitsTeam[k]){
//	        						while (delQueue[j].isLocked()){ //WHILE BEING USED BY OTHER THREAD
//	        							try {
//	        								Thread.sleep(10);
//	        							} catch (InterruptedException e) {
//	        								e.printStackTrace();
//	        							}
//	        						}
//	        						//ELSE DELETE
//	        						MyTeams[i].removeUnit(k);
//	        						break;
//	        					}
//	        				}
//	        			}
//	        			MyTeams[i].setNumberToDelete(0);
//	        			
//	        		}
//	        	}
//	        }
//		
//		}).start();	
//	}
	
	
	
	
	
	
	
	

//	public void removeProjectile(int projIndex){
//		myProjectiles[projIndex] = myProjectiles[numberOfProjectiles-1];
//		myProjectiles[numberOfProjectiles-1] = null;
//		numberOfProjectiles --;
//	}
//		
//	public void appendDelQueue(Projectile toDelete){
//		delQueue[numberToDelete] = toDelete;
//		numberToDelete++;
//	}
	
	public void quit(){
		gameIsRunning = false;
		calcMoves = false;
		calcCollisions = false;
	}
	
	
	public void pause(){
		stopMovingUnits();
	}
	
	public void stopMovingUnits(){
		calcMoves = false;
		calcCollisions = false;
	}
	
	public void startMovingUnits(){
		calcMoves = true;
		calcCollisions = true;
	}
}
