package com.example.painintheass.GameLogic.UnitHandlers;

import com.example.painintheass.GameLogic.Team;

/**
 * Interface for all classes who handle threads accessing the units.
 */
public class UnitHandler {
	/**
	 * The player and enemy teams.
	 * Necessary to get the units and modify them.
	 */
	private Team[] MyTeams;
	/**
	 * Ends definitively the thread, unlike <code>pauseThread</code>
	 */
	private boolean endThread;
	private boolean pauseThread;
	
	
	public void stop(){
	}
	
	
	
	
}
