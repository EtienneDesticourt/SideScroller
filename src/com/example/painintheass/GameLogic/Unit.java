package com.example.painintheass.GameLogic;

import java.util.Date;


import android.graphics.Rect;


/*mdpi stats --> /4
archer 140,10, 90, 215  
knight 70, 0, 115, 295 
mage 45 50, 85, 230
castle 30 0 200 235
*/

public class Unit {
	private Team myTeam;
	boolean isMoving;
	private boolean inUse;
	private int x;
	private int y;
	private int yMod=0;
	private int xMod=0;
	private int width;
	private int height;
	private int speed;
	private int life;
	private int maxLife;
	private int type;
	private int damage;
	private int attackRange;
	private long attackSpeed;
	private int action; //0:move 1:attack
	private int lastAction;
	private int currFrame;
	private int maxFrame;
	private Rect bodyRect;
	private Rect attackRect;
	private Unit Target;
	private long delTime;
	private long lastAttack;
	private long lastAnimUpdate;
	private int id;
	
	public Unit(Team unitsTeam){
		this.unlock();
		//System.out.println("I'm a new unit.");
		myTeam = unitsTeam;
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
		bodyRect.left = x;
		bodyRect.right = x+128;
		bodyRect.top = y;
		bodyRect.bottom = y+128;
		attackRect.left = x;
		attackRect.right = x+attackRange;
		attackRect.top = y;
		attackRect.bottom = y+128;
		speed = 1;
		damage = 10;
		life = 100;
		setMaxLife(life);
		setType(0);
		setLastAttack(new Date().getTime());
		setLastAnimUpdate(new Date().getTime());
		
	}
	
	public void init(){ //only adds to ai processing after subclass has finished init
		myTeam.addUnit(this); //to avoid ai crash for anim type 0 action 0
	}
	
	public void step(int side){
		this.x += side*this.speed;
		bodyRect.offsetTo(x, y);
		attackRect.offsetTo(x, y);
	}
	
	
	public void attack(){
		Target.hit(damage,false);
		if (Target.getAction()==3){
			action = 0;
		}
	}
	
	public void hit(int damage,boolean ranged){
		this.life -= damage;
		if (this.life < 0 && action != 3){
			die();
		}
	}
	
	public void setAttackRange(int range){
		this.attackRange = range;
		this.attackRect.right = this.attackRect.left+range;
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
		action = 3;
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
		bodyRect.left = left;
		bodyRect.top = top;
		bodyRect.right = left+width;
		x = left;
		y = top;
		setAttackRectFromBRect();
		
	}
	
	public void setAttackRectFromBRect(){
		attackRect.top = bodyRect.top;
		attackRect.left = bodyRect.left;
		attackRect.bottom = bodyRect.bottom;
		attackRect.right = bodyRect.left+attackRange;
	}

	public Rect getBodyRect(){
		return this.bodyRect;
	}
	
	public Rect getAttackRect(){
		return this.attackRect;
	}
	
	public void setAction(int newAction){
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

	public int getxMod() {
		return xMod;
	}

	public void setxMod(int xMod) {
		this.xMod = xMod;
	}

	
}


 



