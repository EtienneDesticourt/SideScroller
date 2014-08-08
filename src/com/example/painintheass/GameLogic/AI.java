package com.example.painintheass.GameLogic;

import java.util.Date;

import com.example.painintheass.GameLogic.Missiles.Projectile;
import com.example.painintheass.GameLogic.Units.Unit;
import com.example.painintheass.Graphics.Animation;
import com.example.painintheass.Graphics.ResourceManager;

import android.graphics.Rect;

/**
 * Handles all Units and Projectiles creation, movement, animation, collision and destruction.
 * This class is a collection of threads.
 */
public class AI {
	private int NUMBER_OF_TEAM=2;
	private boolean calcMoves;
	private boolean calcCollisions;
	private boolean spawningUnits=true;
	private Team[] MyTeams;
	private boolean gameIsRunning = true;
	private static int moveCalcDelay =  (int) (1000/30.0);
	private ResourceManager myRM;
	
	/**
	 * Creates an AI.
	 * @param MyTeams - The friendly and enemy teams.
	 * @param newRM	- The Combat Scene's resource manager to handle animations
	 */
	public AI(Team[] MyTeams, ResourceManager newRM){
		this.MyTeams = MyTeams;
		myRM = newRM;
		spawnUnits();
		updateUnits();
		checkCollision();
	}
	
	/**
	 * Skeleton of the future AI spawning decision making.
	 * @return Array of unit types
	 */
	public int[] makeSpawnDecision(){
		int[] result= new int[10];
		return result;
	}
	
	
	/**
	 * Spawns random units.
	 * Will cease if {@link AI#spawningUnits spawningUnits} and {@link AI#gameIsRunning gameIsRunning} are set to false.
	 */
	public void spawnUnits(){
		new Thread(new Runnable() {
	        public void run() {
	        	long lastSpawn= new Date().getTime();;
	        	long current;
	        	int r;
	        	while (gameIsRunning){
//	        		System.out.println("spawnUnits 1 running");
	        		while (spawningUnits){
//		        		System.out.println("spawnUnits 2 running");
	        			
	        			
		        		current = new Date().getTime();
		        		//System.out.println(current-lastSpawn);
		        		if ((current-lastSpawn)>MyTeams[1].getSpawnSpeed()){
//		        			MyTeams[1].spawnMage();
//		        			if (true){ return;}
		        			r = (int)(Math.random() * ((2) + 1));
		        			if (r==0){MyTeams[1].spawnKnight();}
		        			else if (r==1){MyTeams[1].spawnArcher();}
		        			else{MyTeams[1].spawnMage();}
		        			lastSpawn = current;
		        		}
			        	try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}	      
	        		}

		        	try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}	 
		        	
	        	}
	        }
	        		
	    }).start();	
		//System.out.println("Done starting");
	}
	
	/**
	 * Handles move, attack and animation updates.
	 * Will cease if {@link AI#calcMoves calcMoves} and {@link AI#gameIsRunning gameIsRunning} are set to false.
	 */
	public void updateUnits(){
		new Thread(new Runnable() {
	        public void run() {	        	
	        	while (gameIsRunning){
//	        		System.out.println("updateUnits 1 running");
	        		long lastTime;
	        		long current;
		        	while (calcMoves){	

//		        		System.out.println("updateUnits 2 running");
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
		    					//System.out.println(myUnits[i].getType()+" "+action);
		    					if ((current-lastTime)>currAnim.getSpeed()){ //crashes on 0 0 //Was it fixed? I hope so.
		    						if (temp+1>currAnim.getLength()-1){
		    							if (currAnim.isLoop()){
		    								myUnits[i].setCurrFrame(0);
		    							}
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
	
	/**
	 * Handles collision detection of both units and projectiles.
	 * Will cease if {@link AI#calcCollisions calcCollisions} and {@link AI#gameIsRunning gameIsRunning} are set to false. 
	 */
	public void checkCollision(){
		new Thread(new Runnable() {
	        public void run() {
	        	Unit[] UnitsTeam0 = MyTeams[0].getUnits();
	        	Unit[] UnitsTeam1 = MyTeams[1].getUnits();
	        	Projectile[] myProjectiles0 = MyTeams[0].getMyProjectiles();
	        	Projectile[] myProjectiles1 = MyTeams[1].getMyProjectiles();
	        	while (gameIsRunning){
//	        		System.out.println("checkCollision 1 running");
		        	while (calcCollisions){
//		        		System.out.println("checkCollision 2 running");
		        		Unit currUnit;
		    			for (int i =0; i<100;i++){//MyTeams[0].getUnitsNumber();i++){
		    				currUnit = UnitsTeam0[i];
		    				if (currUnit==null){
		    					break;
		    				}

		    				currUnit.lock();
		    				if (currUnit.getAction()==2){
			    				currUnit.unlock();
		    					continue;
		    				}
		    				for (int j=0; j<100;j++){//MyTeams[1].getUnitsNumber();j++){
		    					
		    					if (UnitsTeam1[j]==null ){
		    						break;
		    					}
		    					UnitsTeam1[j].lock();
		    					if (UnitsTeam1[j].getAction()==2){
			    					UnitsTeam1[j].unlock();
		    						continue;
		    					}
		    					
		    					if (Rect.intersects(currUnit.getAttackRect(), UnitsTeam1[j].getBodyRect())){
		    						if (currUnit.getType()!=4 && currUnit.getAction()!=1){
			    						currUnit.setAction(1);
			    						currUnit.setTarget(UnitsTeam1[j]);	
		    						}
		    					}
		    					
		    					if (Rect.intersects(UnitsTeam1[j].getAttackRect(), currUnit.getBodyRect())){
		    						if (UnitsTeam1[j].getType()!=4 && UnitsTeam1[j].getAction()!=1){
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
		    					if (UnitsTeam1[j]!=null ){
			    					if (UnitsTeam1[j].getAction()!= 2 && myProjectiles0[i]!=null){
			    						if (Rect.intersects(UnitsTeam1[j].getBodyRect(), myProjectiles0[i].getMyRect() )){
			    							UnitsTeam1[j].hit(myProjectiles0[i].getDamage(), true, myProjectiles0[i].getType());
			    							MyTeams[0].delProjectile(i);
			    						}
			    					}
		    					}
		    					if (UnitsTeam0[j]!=null){
			    					if (UnitsTeam0[j].getAction()!= 2 && myProjectiles1[i]!=null){
			    						if(Rect.intersects(UnitsTeam0[j].getBodyRect(), myProjectiles1[i].getMyRect() )){
			    							UnitsTeam0[j].hit(myProjectiles1[i].getDamage(), true, myProjectiles1[i].getType());
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
	
	/**
	 * Deletes dead units.
	 * Will cease if {@link AI#gameIsRunning gameIsRunning} is set to false.
	 */
	public void deleteUnits(){
		new Thread(new Runnable() {
	        public void run() {
	        	while (gameIsRunning){
//	        		System.out.println("delete units running");
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
	
	/**
	 * Stops all the running threads.
	 */
	public void quit(){
		gameIsRunning = false;
		calcMoves = false;
		calcCollisions = false;
		spawningUnits = false;
	}
	
	/**
	 * Calls {@link AI#stopMovingUnits()}. 
	 */
	public void pause(){
		stopMovingUnits();
	}
	
	/**
	 * Pauses the update and collision threads.
	 */
	public void stopMovingUnits(){
		calcMoves = false;
		calcCollisions = false;
	}
	
	/**
	 * Resumes the update and collision threads.
	 */
	public void startMovingUnits(){
		calcMoves = true;
		calcCollisions = true;
	}

	public boolean isSpawningUnits() {
		return spawningUnits;
	}

	public void setSpawningUnits(boolean spawningUnits) {
		this.spawningUnits = spawningUnits;
	}
}
