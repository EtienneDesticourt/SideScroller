package com.example.painintheass.Graphics.Particles;

import java.util.Date;

/**
 * Handles the particles.
 * Spawning, deleting and moving.
 */
public class ParticleHandler {
	private Particle[] Particles;
	private boolean gameIsRunning = true;
	
	/**
	 * Creates a Particle Handler.
	 */
	public ParticleHandler(){
		Particles = new Particle[1000];	
		run();
	}
	
	/**
	 * Spawns numerous stars.
	 * @param number Number of stars to spawn
	 * @param x Position on the x axis
	 * @param y Position on the y axis
	 */
	public void spawnStars(int number, int x, int y){
		Particle currParticle;
		int leftToSpawn = number;
		
		for (int i=0; i<1000; i ++){
			currParticle = Particles[i];
			
			if (currParticle ==  null || currParticle.getAlpha() <= 0){
				Particles[i] = new Star(x,y);
				leftToSpawn -= 1;
			}		
			if (leftToSpawn <= 0){
				break;
			}
		}	
	}
	
	/**
	 * Spawns coins representing income.
	 * @param dX 
	 */
	public void spawnIncomeParticle(int dX){
		Particle P = new Particle(330+dX,30,85,0.1);
		P.setVx(0.5);
		P.setVy(0.5);
		Particles[0] = P;
		
		
	}
	
	public Particle[] getParticles(){
		return Particles;
	}
	
	/**
	 * Runs a thread to move the particles.
	 * Ceases when {@link ParticleHandler#gameIsRunning gameIsRunning} is set to False.
	 */
	public void run(){
		new Thread(new Runnable() {
	        public void run() {
	        	while (gameIsRunning){	   
	        		Particle P;
	        		for (int i = 0;i<1000;i++){
	        			P = Particles[i];
	        			if (P!=null){
		        			Particles[i].step();	        				
	        			}
	        		}
	        			
	        		
		        	try {
						Thread.sleep(5);
					} 
		        	catch (InterruptedException e) {
						e.printStackTrace();
					}	  	        	
	        	}
	        }
	        		
	    }).start();	
	}
}

