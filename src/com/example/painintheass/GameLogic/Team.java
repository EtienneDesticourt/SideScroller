package com.example.painintheass.GameLogic;








public class Team {
	private static int NumberOfTeams = 0;
	private static int Team1SpawnX = 0;
	private static int Team1SpawnY = 100;
	private static int Team2SpawnX = 600;
	private static int Team2SpawnY = 100;
	
	/////////////////////////////////////
	
	private int spawnX;
	private int spawnY;
	private int movementSide;
	private int id;

	private int spawnSpeed;
	private Unit[] myUnits;
	private Unit[] delQueue;
	private int numberToDelete=0;
	private int numberOfUnits=0;
	private int numberOfProjectiles=0;
	private Projectile[] myProjectiles;
	private float[] skills; //health,speed,damages
	
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

	}

	
	public void reset(){
		myUnits = new Unit[100];
		delQueue = new Unit[100];
		myProjectiles = new Projectile[1000];
		numberToDelete=0;
		numberOfUnits=0;
		numberOfProjectiles=0;
		System.gc();
		
		
	}
	
	
	public void spawnSoldier(){
		Unit temp = new Soldier(this);
		int id = addUnit(temp);
		temp.setId(id);
		temp.applySkillModifier(skills[0],skills[1],skills[2]);
		
	}
	public void spawnArcher(){
		Unit temp = new Archer(this);
		int id = addUnit(temp);
		temp.setId(id);
		temp.applySkillModifier(skills[0],skills[1],skills[2]);
	}
	public void spawnMage(){
		Unit temp = new Mage(this);
		int id = addUnit(temp);
		temp.setId(id);
		temp.applySkillModifier(skills[0],skills[1],skills[2]);
	}
	public void spawnKnight(){
		Unit temp = new Knight(this);
		int id = addUnit(temp);
		temp.setId(id);
		temp.applySkillModifier(skills[0],skills[1],skills[2]);		
	}
	public void spawnDemoman(){
		Unit temp = new Demoman(this);
		int id = addUnit(temp);
		temp.setId(id);	
		temp.applySkillModifier(skills[0],skills[1],skills[2]);
	}
	
	public void spawnCastle(){
		Unit temp = new Castle(this);
		int id = addUnit(temp);
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
		myUnits[numberOfUnits] = newUnit;
		numberOfUnits ++;
		return numberOfUnits-1;
	}
	
	public void addProjectile(Projectile newProjectile){
		myProjectiles[numberOfProjectiles] = newProjectile;
		numberOfProjectiles ++;
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


//	public void setUnits(Unit[] myUnits) {
//		this.myUnits = myUnits;
//	}
	
	
	
	
}
