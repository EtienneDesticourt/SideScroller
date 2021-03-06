package com.example.painintheass.GameLogic;

import com.example.painintheass.GameLogic.Missiles.Projectile;
import com.example.painintheass.GameLogic.Units.Archer;
import com.example.painintheass.GameLogic.Units.Castle;
import com.example.painintheass.GameLogic.Units.Knight;
import com.example.painintheass.GameLogic.Units.Mage;
import com.example.painintheass.GameLogic.Units.Unit;







/**
 * Represents a Team.
 * Either enemy, or player's team. 
 */
public class Team {
	private static int NumberOfTeams = 0;
	private static int Team1SpawnX = 0;
	private static int Team1SpawnY = 100;
	private static int Team2SpawnX = 1600;
	private static int Team2SpawnY = 100;
	private final static int ARCHERCOST = 10;
	private final static int KNIGHTCOST = 10;
	private final static int MAGECOST = 10;
	private final static int MINERCOST = 10;
	private final static int INCOMEBOOST = 10;
	/////////////////////////////////////
	
	private int spawnX;
	private int spawnY;
	private int movementSide;
	private int id;

	private long lastIncome;
	private int spawnSpeed;
	private int lastMoneyMod = 0;
	private int money = 1000;
	private int income = 10;
	private int miners = 1;
	private Unit[] myUnits;
	private Unit[] delQueue;
	private int numberToDelete=0;
	private int numberOfUnits=0;
	private int numberOfProjectiles=0;
	private Projectile[] myProjectiles;
	private int[] skills; //health,speed,damages
	
	/**
	 * Creates a Team. 
	 */
	public Team(){
		setSpawnSpeed(5000);
		id = NumberOfTeams;
		NumberOfTeams ++;
		myUnits = new Unit[100];
		delQueue = new Unit[100];
		myProjectiles = new Projectile[1000];
		if (this.id==0){
			this.spawnX = Team1SpawnX;
			this.spawnY = Team1SpawnY;
			this.movementSide = 1;
		}
		else{
			this.spawnX = Team2SpawnX;
			this.spawnY = Team2SpawnY;	
			this.movementSide = -1;		
		}
		skills = new int[4];

	}

	public static void resetNumberOfTeams(){
		NumberOfTeams = 0;
	}
	
 	public int getIncome(){
		return income;
	}
	
	public void increaseMoney(){
		setMoney(money + income);
	}
	
	
	/**
	 * Resets units and missiles arrays as well as the counters associated with them.
	 */
	public void reset(){
		myUnits = new Unit[100];
		delQueue = new Unit[100];
		myProjectiles = new Projectile[1000];
		numberToDelete=0;
		numberOfUnits=0;
		numberOfProjectiles=0;
		System.gc();
		
		
	}
	
	/**
	 * Increases the income and removes some money.
	 */
	public void spawnMiner(){
		if (money < MINERCOST) return;
		income += INCOMEBOOST;
		setMiners(getMiners() + 1);
		setMoney(money - MINERCOST);
	}
	
	
	/**
	 * Spawns an Archer.
	 */
	public void spawnArcher(){
		if (money < ARCHERCOST) return;
		Unit temp = new Archer(this);
		int id = addUnit(temp);
		if (id==-2) return;
		temp.setId(id);
		temp.applySkillModifier(skills[0],skills[1],skills[2]);
		setMoney(money - ARCHERCOST);
		
	}
	
	/**
	 * Spawns a Mage.
	 */
	public void spawnMage(){
		if (money < MAGECOST) return;
		Unit temp = new Mage(this);
		int id = addUnit(temp);
		if (id==-2) return;
		temp.setId(id);
		temp.applySkillModifier(skills[0],skills[1],skills[2]);
		setMoney(money - MAGECOST);
	}
	
	/**
	 * Spawns a Knight.
	 */
	public void spawnKnight(){
		if (money < KNIGHTCOST) return;
		Unit temp = new Knight(this);
		int id = addUnit(temp);
		if (id==-2) return;
		temp.setId(id);
		temp.applySkillModifier(skills[0],skills[1],skills[2]);		
		setMoney(money - KNIGHTCOST);
	}
	
	/**
	 * Spawns a Castle.
	 */
	public void spawnCastle(){
		Unit temp = new Castle(this);
		int id = addUnit(temp);
		if (id==-2) return;
		temp.setId(id);
		temp.applySkillModifier(skills[0],skills[1],skills[2]);
	}
	
	
	
	public void setNumberToDelete(int num){
		numberToDelete = num;
	}
	
	public int getMovementSide(){
		return movementSide;
	}
	
	public int getUnitsNumber(){
		return numberOfUnits;
	}
	
	public int getXSpawn(){
		return this.spawnX;
	}
	
	public int getYSpawn(){
		return this.spawnY;
	}

	public Unit[] getDelQueue(){
		return delQueue;
	}
	
	public Unit getUnit(int index){
		return myUnits[index];
	}
	
	public Projectile getProjectile(int index){
		return myProjectiles[index];
	}
	
	public Unit[] getUnits() {
		return myUnits;
	}
	
	public int addUnit(Unit newUnit){
		if (numberOfUnits>=100) return -2;
		myUnits[numberOfUnits] = newUnit;
		numberOfUnits ++;
		return numberOfUnits-1;
	}
	
	public void addProjectile(Projectile newProjectile){
		if (numberOfProjectiles >= 1000){
			numberOfProjectiles = 0; // Fuck me if this happens
		}
//		System.out.println(numberOfProjectiles);
		myProjectiles[numberOfProjectiles] = newProjectile;
		numberOfProjectiles ++;
	}
	
	
	public void resetProjectiles(){
		
	}
	
	public void delProjectile(int index){
		myProjectiles[index] = myProjectiles[numberOfProjectiles-1];
		myProjectiles[numberOfProjectiles-1] = null;
		numberOfProjectiles --;
	}
	
	
	public void removeUnit(int unitIndex){
		myUnits[unitIndex] = myUnits[numberOfUnits-1];
		myUnits[unitIndex].setId(unitIndex);
		myUnits[numberOfUnits-1] = null;
		numberOfUnits --;
	}
		
	public void appendDelQueue(Unit toDelete){
		delQueue[numberToDelete] = toDelete;
		numberToDelete++;
	}

	public Projectile[] getMyProjectiles() {
		return myProjectiles;
	}

	public void setMyProjectiles(Projectile[] myProjectiles) {
		this.myProjectiles = myProjectiles;
	}


	public int getSpawnSpeed() {
		return spawnSpeed;
	}


	public void setSpawnSpeed(int spawnSpeed) {
		this.spawnSpeed = spawnSpeed;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public void setSkills(int skill1, int skill2, int skill3, int skill4){
		skills[0] = skill1;
		skills[1] = skill2;
		skills[2] = skill3;
		skills[3] = skill4;
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int newMoney) {
		this.setLastMoneyMod(newMoney - money); 
		this.money = newMoney;
	}



	public long getLastIncome() {
		return lastIncome;
	}



	public void setLastIncome(long lastIncome) {
		this.lastIncome = lastIncome;
	}



	public int getMiners() {
		return miners;
	}



	public void setMiners(int miners) {
		this.miners = miners;
	}


	public int getLastMoneyMod() {
		return lastMoneyMod;
	}


	public void setLastMoneyMod(int lastMoneyMod) {
		this.lastMoneyMod = lastMoneyMod;
	}

//	public void setUnits(Unit[] myUnits) {
//		this.myUnits = myUnits;
//	}
	
	
	
	
}
