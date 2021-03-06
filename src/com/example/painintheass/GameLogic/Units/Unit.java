package com.example.painintheass.GameLogic.Units;

import java.util.Date;




import com.example.painintheass.GameLogic.Team;

import android.graphics.Rect;


/*mdpi stats --> /4
archer 140,10, 90, 215  
knight 70, 0, 115, 295 
mage 45 50, 85, 230
castle 30 0 200 235
*/

/**
 * Represents a basic Unit.
 * Extended by Archer, Mage and Knight.
 */
public class Unit {
	//team
	private Team myTeam;
	private int teamID;	
	//Positioning
	private int x;
	private int y;
	private int yMod=0;
	private int[] xMod={0,0};
	private int width;
	private int height;	
	//Unit characteristics
	private int id;
	private int speed;
	private int life;
	private int maxLife;
	private int type;
	private int damage;
	private int attackRange;
	private long attackSpeed;	
	//AI
	private int action; //0:move 1:attack 2:die
	private int lastAction;
	private boolean inUse;
	boolean isMoving;
	private Unit Target;
	private long delTime;
	private long lastAttack;
	private boolean hitFlag;	
	//Rendering
	private int currFrame;
	private int maxFrame;
	private Rect bodyRect;
	private Rect attackRect;
	private long lastAnimUpdate;
	private int hitFrames = 0;
	
	/**
	 * Creates and spawns a unit.
	 * @param unitsTeam The Unit's Team.
	 */
	public Unit(Team unitsTeam){
		this.unlock();
		//System.out.println("I'm a new unit.");
		myTeam = unitsTeam;
		teamID = myTeam.getId();
		isMoving = false;
		currFrame = 0;
		maxFrame = 4;
		action = 0;
		x = myTeam.getXSpawn();
		y = myTeam.getYSpawn();
		width = 128;
		height = 128;
		attackRange = 10;
		bodyRect = new Rect();
		attackRect = new Rect();
		if (teamID == 0 || true){
			bodyRect.left = x;
			bodyRect.right = x+128;
		}
		bodyRect.top = y;
		bodyRect.bottom = y+128;
		attackRect.top = y;
		attackRect.bottom = y+128;
		//System.out.println(teamID);
		if (teamID == 0){
			attackRect.left = x;
			attackRect.right = x+attackRange;
		}
		else{
			attackRect.right = bodyRect.right;
			attackRect.left = bodyRect.right-attackRange;
		}
		speed = 1;
		damage = 10;
		life = 100;
		setMaxLife(life);
		setType(0);
		setLastAttack(new Date().getTime());
		setLastAnimUpdate(new Date().getTime());
		
	}
	
	
	/**
	 * Multiply attributes by modifier.
	 * @param health Health modifier.
	 * @param speed Speed modifier.
	 * @param damage Damage modifier.
	 */
	public void applySkillModifier(float health,float speed, float damage){
		this.life += this.life*health;
		this.speed += this.life*speed;
		this.damage += this.life*damage;
	}
	
	/**
	 * Adds the Unit to its Team.
	 */
	public void init(){ //only adds to ai processing after subclass has finished init
		myTeam.addUnit(this); //to avoid ai crash for anim type 0 action 0
	}
	
	public void step(int side){
//		if (true) return;
		this.x += side*this.speed;
		bodyRect.offsetTo(x, y);
		setAttackRectFromBRect();
	}
	
	
	public void attack(){
		Target.hit(damage,false,0);
		if (Target.getAction()==2){
			action = 0;
		}
	}
	
	/**
	 * The Unit gets hit.
	 */
	public void hit(int damage,boolean ranged, int type){
		this.setHit(true);
		this.life -= damage;
		if (this.life < 0 && action != 2){
			die();
		}
	}
	
	public void setAttackRange(int range){
		this.attackRange = range;
		if (teamID == 0){
			this.attackRect.right = this.attackRect.left+range;
		}
		else{
			this.attackRect.left = this.attackRect.right-range;
		}
	}

	public Unit getTarget(){
		return Target;
	}
	
	public int getDamage(){
		return damage;
	}
	
	public void setDamage(int newDamage){
		this.damage = newDamage;
	}
	
	public void die(){
//		System.out.println("I'm so dead right now.");
		action = 2;
		delTime = new Date().getTime();
		myTeam.appendDelQueue(this);
	}
	
	public int getX(){
		return this.x;
	}
	
	public void setY(int newY){
		this.y = newY;
		int height = bodyRect.top-bodyRect.bottom;
		bodyRect.top = y+height;
		setAttackRectFromBRect();
	}
	public int getY(){
		return this.y;
	}
	
	public void setBodyRect(Rect newRect){
		this.bodyRect = newRect;
	}
	
	public void setBodyRect(int left, int top, int width, int height){
		bodyRect.bottom = top+height;
		bodyRect.top = top;
		y = top;
		if (teamID==0 || true){
			bodyRect.left = left;
			bodyRect.right = left+width;
		}
		x = left;
		setAttackRectFromBRect();
	}
	
	public void setAttackRectFromBRect(){
		attackRect.top = bodyRect.top;
		attackRect.bottom = bodyRect.bottom;
		if (teamID==0){
			attackRect.left = bodyRect.left;
			attackRect.right = bodyRect.left+attackRange;
		}
		else{
			attackRect.right = bodyRect.right;
			attackRect.left = bodyRect.right-attackRange;
		}
	}

	public Rect getBodyRect(){
		return this.bodyRect;
	}
	
	public Rect getAttackRect(){
		return this.attackRect;
	}
	
	public void setAction(int newAction){
//		System.out.println("Someone is setting my action to "+newAction);
		this.action = newAction;
	}	

	public int getAction(){
		return this.action;
	}
	
	public void setTarget(Unit newTarget){
		this.Target = newTarget;
	}
	
	public int getCurrFrame(){
		return this.currFrame;
	}
	
	public void  setCurrFrame(int newFrame){
		this.currFrame = newFrame;		
	}
	
	
	public int getMaxFrame(){
		return this.maxFrame;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public long getLastAnimUpdate() {
		return lastAnimUpdate;
	}

	public void setLastAnimUpdate(long lastAnimUpdate) {
		this.lastAnimUpdate = lastAnimUpdate;
	}
	
	public Team getMyTeam(){
		return myTeam;
	}

	public long getLastAttack() {
		return lastAttack;
	}

	public void setLastAttack(long lastAttack) {
		this.lastAttack = lastAttack;
	}

	

	public void setAttackSpeed(long attackSpeed) {
		this.attackSpeed = attackSpeed;
	}

	public long getAttackSpeed() {
		return  attackSpeed;
	}

	public boolean isLocked() {
		return inUse;
	}

	public void lock() {
		this.inUse = true;
	}
	
	public void unlock(){
		this.inUse = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaxLife() {
		return maxLife;
	}

	public void setMaxLife(int maxLife) {
		this.maxLife = maxLife;
	}
	
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getyMod() {
		return yMod;
	}

	public void setyMod(int yMod) {
		this.yMod = yMod;		
	}

	public int getxMod(int teamIndex) {
		return xMod[teamIndex];
	}

	public void setxMod(int[] xMod) {
		this.xMod = xMod;
	}

	public boolean isHit() {
		return hitFlag;
	}

	public void setHit(boolean hit) {
		this.hitFlag = hit;
	}

	public int getHitFrames() {
		return hitFrames;
	}

	public void setHitFrames(int hitFrames) {
		this.hitFrames = hitFrames;
	}

	public void increaseHitFrames(){
		this.hitFrames += 1;
	}
	
}


 



