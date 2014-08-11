//package com.example.painintheass.GameLogic.UnitHandlers;
//
//import java.util.Date;
//
//import com.example.painintheass.GameLogic.Team;
//
///**
// * In charge of moving the units.
// */
//public class UnitMover implements UnitHandler{	
//	
//	public UnitMover(){
//		super();
//	}
//	
//
//	/**
//	 * Spawns an enemy unit if time passed since last spawn is superior to spawn speed.
//	 * @param currTime Time at the moment the function was called.
//	 * @param lastSpawn Time when the last unit was spawned.
//	 * @return Whether a unit was spawned.
//	 */
//	private boolean spawnUnit(long currTime, long lastSpawn, Team EnemyTeam){				
//		//IF enough time has passed since last spawn: spawn a random unit
//		if ((currTime-lastSpawn)>EnemyTeam.getSpawnSpeed()){
//			//Random unit type selection between 0 and 2
//			int r = (int)(Math.random() * ((2) + 1));
//			
//			if (r==0){ EnemyTeam.spawnKnight(); }
//			else if (r==1){ EnemyTeam.spawnArcher(); }
//			else{ EnemyTeam.spawnMage(); }
//			
//			return true;
//		}		
//		return false;
//	}
//	
//	private void spawnUnits(){
//		while (spawningUnits){
//	}
//
//	public void startSpawnThread(){
//		new Thread(new Runnable() {
//	        public void run() {
//	        	long lastSpawn= new Date().getTime();;
//	        	long current;
//	        	int r;
//	        	while (gameIsRunning){
////	        		System.out.println("spawnUnits 1 running");
//	        		while (spawningUnits){
////		        		System.out.println("spawnUnits 2 running");
//	        			
//	        			
//		        		current = new Date().getTime();
//		        		//System.out.println(current-lastSpawn);
//		        		
//			        	try {
//							Thread.sleep(500);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}	      
//	        		}
//
//		        	try {
//						Thread.sleep(500);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}	 
//		        	
//	        	}
//	        }
//	        		
//	    }).start();	
//}
