//package com.example.painintheass;
//
//import com.example.painintheass.GameLogic.AI;
//import com.example.painintheass.GameLogic.Country;
//import com.example.painintheass.GameLogic.Player;
//import com.example.painintheass.GameLogic.Team;
//import com.example.painintheass.Graphics.CustomView;
//import com.example.painintheass.UI.Button;
//import com.example.painintheass.UI.UIManager;
//import com.example.painintheass.UI.Widget;
//
//import android.os.Bundle;
//import android.app.Activity;
//import android.graphics.Canvas;
//import android.util.DisplayMetrics;
//import android.view.Menu;
////import android.view.View;
//
//public class MainActivity extends Activity {
//	private CustomView myView;
//	private Canvas screen;
//	private int refreshSpeed;
//	private boolean drawScreen;
//	private Team[] myTeams;
//	private AI myAI;
//	private UIManager myUIM;
//	private Player myPlayer;
////	private ResourceManager myResourceManager;
//
//	public void refreshDisplay(){
////		Bitmap[] surfaces = myResourceManager.getImages();
////		for (int i=0;i<surfaces.length;i++){
////			screen.drawBitmap(surfaces[i], , top, paint)
////		}
//		//go Through units 
//		//go through map surfaces
//		
//	}
//	
////	public void runMainLoop() {
////		new Thread(new Runnable() {
////	        public void run() {
////				while (drawScreen){
////					myView.draw(screen);
////					try {
////						Thread.sleep(1000);
////					} catch (InterruptedException e) {
////						e.printStackTrace();
////					}
////				}
////	        }
////		}).start();	
////	}
//	
//	public void quit(){
//		drawScreen = false;
//	}
//	
//	
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//
//
//		//init game
//		myTeams = new Team[2];
//		Team Team1 = new Team();
//		Team Team2 = new Team();
//		myTeams[0] = Team1;
//		myTeams[1] = Team2;
//		myPlayer = new Player(Team1);
//		
//		//init gui
//		myUIM = new UIManager(Team1,Team2,myPlayer);
//		
//		
//
//		//init screen
//		screen = new Canvas();
//		drawScreen = true;		
//		setContentView(R.layout.activity_main);		
//		myView = (CustomView) findViewById(R.id.vMain);		
//		myView.setTeams(myTeams);
//		myView.setUIManager(myUIM);
//		myView.doneInitialiazing();
//		
//		//Size
//		DisplayMetrics metrics = new DisplayMetrics();
//		getWindowManager().getDefaultDisplay().getMetrics(metrics);
//		
//		int width = metrics.widthPixels;
//		int height = metrics.heightPixels;
//
//		
//		
//		//0:MENU STATE
//		
//		int left = (int) (0.3*width);
//				
//		//PLAY BUTTON
//		Button playButton0 = new Button(left,200,left,26) {
//			public void onClick(UIManager myUIM){
//				myUIM.setCurrentStateIndex(1);
//				//myUIM.setOn(false);
//			}
//		};
//		playButton0.setBackgroundImage(116);		
//		Button playButton1 = new Button(left,200,left,26) {
//			public void onClick(UIManager myUIM){
//				myUIM.setCurrentStateIndex(1);
//				//myUIM.setOn(false);
//			}
//		};		
//		playButton1.setBackgroundImage(116);
//		//OPTIONS BUTTON
//		Button optionsButton = new Button(left,300,left,26) {
//			public void onClick(UIManager myUIM){				
//			}
//		};		
//		optionsButton.setBackgroundImage(117);
//		//QUIT BUTTON
//		Button quitButton = new Button(left,400,left,26){
//			public void onClick(UIManager myUIM){				
//			}
//		};
//		quitButton.setBackgroundImage(118);
//		
//		Widget[] state = {playButton0,playButton1,optionsButton,quitButton};
//		myUIM.addState(state,false,153);
//		
//		//1:MAP STATE
//		Button pays1 = new Button(133,0,254,156) {
//			public void onClick(UIManager myUIM){
//				Country[] World = myUIM.getWorld();
//				for (int i=0;i<5;i++){
//					World[i].unclickButton();
//				}
//				this.setBackgroundImage(this.getClickedImage());
//				myUIM.setSelected(0);
//				if (World[0].isPlayerControlled()){
//					myUIM.setCurrentStateIndex(3);
//				}
//				else{
//					myUIM.setCurrentStateIndex(2);					
//				}
//			}
//		};
//		pays1.setBackgroundImage(119);		
//		pays1.setHilightedImage(139);		
//		pays1.setGreyedImage(140);		
//		pays1.setClickedImage(141);		
//		Button pays2 = new Button(0,18,170,170) {
//			public void onClick(UIManager myUIM){
//				Country[] World = myUIM.getWorld();
//				for (int i=0;i<5;i++){
//					World[i].unclickButton();
//				}
//				this.setBackgroundImage(this.getClickedImage());
//				myUIM.setSelected(1);
//				if (World[1].isPlayerControlled()){
//					myUIM.setCurrentStateIndex(3);
//				}
//				else{
//					myUIM.setCurrentStateIndex(2);					
//				}
//			}
//		};
//		pays2.setBackgroundImage(120);		
//		pays2.setHilightedImage(142);		
//		pays2.setGreyedImage(143);		
//		pays2.setClickedImage(144);	
//		Button pays3 = new Button(210,90,154,158) {
//			public void onClick(UIManager myUIM){
//				Country[] World = myUIM.getWorld();
//				for (int i=0;i<5;i++){
//					World[i].unclickButton();
//				}
//				this.setBackgroundImage(this.getClickedImage());
//				myUIM.setSelected(2);
//				if (World[2].isPlayerControlled()){
//					myUIM.setCurrentStateIndex(3);
//				}
//				else{
//					myUIM.setCurrentStateIndex(2);					
//				}
//			}
//		};
//		pays3.setBackgroundImage(121);		
//		pays3.setHilightedImage(145);		
//		pays3.setGreyedImage(146);		
//		pays3.setClickedImage(147);	
//		Button pays4 = new Button(102,86,250,175) {
//			public void onClick(UIManager myUIM){
//				Country[] World = myUIM.getWorld();
//				for (int i=0;i<5;i++){
//					World[i].unclickButton();
//				}
//				this.setBackgroundImage(this.getClickedImage());
//				myUIM.setSelected(3);
//				if (World[3].isPlayerControlled()){
//					myUIM.setCurrentStateIndex(3);
//				}
//				else{
//					myUIM.setCurrentStateIndex(2);					
//				}
//			}
//		};
//		pays4.setBackgroundImage(122);		
//		pays4.setHilightedImage(148);		
//		pays4.setGreyedImage(149);		
//		pays4.setClickedImage(150);	
//		Button pays5 = new Button(30,105,164,185) {
//			public void onClick(UIManager myUIM){
//				Country[] World = myUIM.getWorld();
//				for (int i=0;i<5;i++){
//					World[i].unclickButton();
//				}
//				this.setBackgroundImage(this.getClickedImage());
//				myUIM.setSelected(4);
//				if (World[4].isPlayerControlled()){
//					myUIM.setCurrentStateIndex(3);
//				}
//				else{
//					myUIM.setCurrentStateIndex(2);					
//				}
//			}
//		};
//		pays5.setBackgroundImage(123);		
//		pays5.setHilightedImage(151);		
//		pays5.setGreyedImage(152);		
//		pays5.setClickedImage(153);		
//		Button nextTurn = new Button(400,200,86,26) {
//			public void onClick(UIManager myUIM){
//				Country[] World = myUIM.getWorld();
//				for (int i=0;i<5;i++){
//					World[i].nextTurn();
//				}
//			}
//		};
//		nextTurn.setBackgroundImage(136);
//		Widget[] mapState1 = {nextTurn,pays1,pays2,pays3,pays4,pays5};
//		myUIM.addState(mapState1,false);
//		
//
//		Country Country1 = new Country();
//		Country Country2 = new Country();
//		Country Country3 = new Country();
//		Country Country4 = new Country();
//		Country Country5 = new Country();
//		
//		
//		Country[] World = {Country1,Country2,Country3,Country4,Country5}; 
//
//		myUIM.setWorld(World);
//		Country1.setButton(pays1);
//		Country1.setPlayerControlled(true);
//		Country2.setButton(pays2);
//		Country2.setPlayerControlled(false);
//		Country3.setButton(pays3);
//		Country3.setPlayerControlled(false);
//		Country4.setButton(pays4);
//		Country4.setPlayerControlled(false);
//		Country5.setButton(pays5);
//		Country5.setPlayerControlled(false);
//		
//		
//		
//		
//		
//		
//		
//		//2:MAP STATE, ENEMY COUNTRY SELECTED		
//		Button attack = new Button(400,300,86,26) {
//			public void onClick(UIManager myUIM){
//				Country enemyCountry = myUIM.getSelected();
//				if (enemyCountry.isPlayerControlled()) return;
//				myUIM.setCurrentStateIndex(5);
//			}
//		};
//		attack.setBackgroundImage(137);
//		
//		Widget[] mapState2 = {attack,nextTurn,pays1,pays2,pays3,pays4,pays5};
//		myUIM.addState(mapState2,false);
//		
//		
//		//3:MAP STATE, FRIENDLY COUNTRY SELECTED
//		
//
//		
//		Button buyTroups = new Button(300,400,86,26) {
//			public void onClick(UIManager myUIM){
//				Country Selected = myUIM.getSelected();
//				if (Selected.getMoney()>=10){
//					Selected.setMoney(Selected.getMoney()-10);
//					Selected.setTroups(Selected.getTroups()+10);
//				}
//			}
//		};
//		buyTroups.setBackgroundImage(137);
//		
//
//		Widget[] mapState3 = {buyTroups,nextTurn,pays1,pays2,pays3,pays4,pays5};
//		myUIM.addState(mapState3,false);
//		
//		
//		
//		//4:MAP STATE, COUNTRY BEING ATTACKED
//		Button attack2 = new Button(100,100,86,26) {
//			public void onClick(UIManager myUIM){
//				myUIM.setCurrentStateIndex(5);
//			}
//		};
//		attack2.setBackgroundImage(137);
//		Button resolve = new Button(100,100,86,26) {
//			public void onClick(UIManager myUIM){
//				int result = myUIM.getDefending().getTroups()-myUIM.getAttacking().getTroups();//add skill modifier
//				if (result<0){
//					myUIM.getDefending().setPlayerControlled(false);
//				}
//				myUIM.setCurrentStateIndex(1);
//			}
//		};
//		resolve.setBackgroundImage(138);
//		Widget[] mapState4 = {resolve,attack2,nextTurn,pays1,pays2,pays3,pays4,pays5};
//		myUIM.addState(mapState4,false);
//		
//		//5:GAME STATE
//		Button soldierButton = new Button(100,500,86,26) {
//			public void onClick(UIManager myUIM){
//				myUIM.getMyPlayerTeam().spawnSoldier();
//			}
//		};
//		soldierButton.setBackgroundImage(126);
//		Button knightButton = new Button(200,500,86,26) {
//			public void onClick(UIManager myUIM){
//				myUIM.getMyPlayerTeam().spawnKnight();
//			}
//		};
//		knightButton.setBackgroundImage(127);
//		Button mageButton = new Button(300,500,86,26) {
//			public void onClick(UIManager myUIM){
//				myUIM.getMyPlayerTeam().spawnMage();
//			}
//		};
//		mageButton.setBackgroundImage(128);
//		Button archerButton = new Button(400,500,86,26) {
//			public void onClick(UIManager myUIM){
//				myUIM.getMyPlayerTeam().spawnArcher();
//			}
//		};
//		archerButton.setBackgroundImage(129);
//		Button demomanButton = new Button(500,500,86,26) {
//			public void onClick(UIManager myUIM){
//				myUIM.getMyPlayerTeam().spawnDemoman();
//			}
//		};
//		demomanButton.setBackgroundImage(130);
//		Button skillsButton = new Button(900,100,86,26) {
//			public void onClick(UIManager myUIM){
//				myUIM.setCurrentStateIndex(7);
//			}
//		};
//		skillsButton.setBackgroundImage(131);
//		Button spellsButton = new Button(800,100,86,26) {
//			public void onClick(UIManager myUIM){
//				myUIM.setCurrentStateIndex(6);
//			}
//		};
//		spellsButton.setBackgroundImage(132);
//		Widget money = new Widget(1000,100,86,26) {
//			public void onClick(UIManager myUIM){
//			}
//		};
//		money.setBackgroundImage(135);
//		Widget[] gameState1 = {money,soldierButton,mageButton,knightButton,archerButton,demomanButton,skillsButton,spellsButton};
//		myUIM.addState(gameState1,true);
//		
//		
//		//6:GAME STATE, SPELL MENU UNROLLED	
//		Button arrowButton = new Button(810,120,86,26) {
//			public void onClick(UIManager myUIM){
//				myUIM.getMyPlayer().castFallingArrows();
//				myUIM.setCurrentStateIndex(5);
//			}
//		};
//		arrowButton.setBackgroundImage(133);		
//		Button lightningButton = new Button(810,160,86,26) {
//			public void onClick(UIManager myUIM){
//				myUIM.getMyPlayer().castLightning();
//				myUIM.setCurrentStateIndex(5);
//			}
//		};
//		lightningButton.setBackgroundImage(134);		
//		Widget[] gameState2 = {money,soldierButton,mageButton,knightButton,archerButton,demomanButton,skillsButton,spellsButton,arrowButton,lightningButton};
//		myUIM.addState(gameState2,true);
//		
//		
//				
//		
//		//init ai
//		myAI = new AI(myTeams,myView.getMyResourceManager());
//		
//		
//		
//		myUIM.setMyAI(myAI);
//		
//		
////		Unit TestUnit = new Unit(Team1);
////		Unit TestUnit1 = new Unit(Team2);
//		
////		myAI.startMovingUnits();
//		//runMainLoop();
//		
//		
//	}
//
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
//
//}
