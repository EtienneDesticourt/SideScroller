package com.example.painintheass.Graphics;

import java.util.Date;


public class ParticleHandler {
	private Particle[] Particles;
	private boolean gameIsRunning = true;
	
	
	public ParticleHandler(){
		Particles = new Particle[1000];	
		run();
	}
	
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
	
	public void spawnIncomeParticle(int dX){
		Particle P = new Particle(330+dX,30,85,0.1);
		P.setVx(0.5);
		P.setVy(0.5);
		Particles[0] = P;
		
		
	}
	
	public Particle[] getParticles(){
		return Particles;
	}
	
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

