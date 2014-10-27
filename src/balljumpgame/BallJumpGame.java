package balljumpgame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;



public class BallJumpGame extends BasicGame{
	private Ball ball;
	private Background bg;
	private Platform[] platforms;
	private BlackHole[] blackholes; 
	private boolean GameStarted;
	private boolean GameOver;
	public static final float JUMP_VY = 23;
	public static final int GAME_WIDTH = 640;
	public static final int GAME_HEIGHT = 720;
	public static final float Gravity = (float) 1.5;
	public static final float Gravity_C = (float) 0.3;
	public static final int PLATFORM_COUNT = 5 ;
	public static final float PLATFORM_VY = 4;
	public static final int HOLE_COUNT = 5;
	public static final float HOLE_VY = 4;
	int score;
	Sound JumpSound;
	
	

	public BallJumpGame(String title) {
		super(title);
		
	}
	
	@Override
	public void keyPressed(int key, char c) {
		if (key == Input.KEY_SPACE) {		 
		    	ball.jump();
		    }
	    if (key == Input.KEY_ENTER) {		      
		    	GameStarted = true;
		    	GameOver = false;
		    }
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		bg.render();
		for(BlackHole hole : blackholes){
			hole.render();
		}
		ball.render();
		for(Platform platform : platforms){
			platform.render();
		}
		g.drawString("Score " + score, 520, 0);
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		Color background = new Color(255,192,203 );
	    container.getGraphics().setBackground(background);
	    bg = new Background(0,0,PLATFORM_VY);
	    ball = new Ball(GAME_WIDTH/2,GAME_HEIGHT,JUMP_VY);
	    GameStarted = false;
	    initPlatform();
	    initHole();
	    JumpSound = new Sound("res/Jumping.wav");
	}
	
	private void initPlatform() throws SlickException {
		platforms = new Platform[PLATFORM_COUNT];
	    for (int i = 0; i < PLATFORM_COUNT; i++) {
	    	Platform Plat;
	    	if(i == PLATFORM_COUNT - 2){
	    		Plat = new Platformslide(GAME_WIDTH/2, GAME_HEIGHT - 220*i , PLATFORM_VY);
	    	}
	    	else if(i == PLATFORM_COUNT -4 ){
	    		Plat = new Platformslide2(GAME_WIDTH/2, GAME_HEIGHT - 220*i , PLATFORM_VY);
	    	}
	    	else{
	    	Plat = new Platform(GAME_WIDTH/2, GAME_HEIGHT - 220*i , PLATFORM_VY);
	    }
	    	platforms[i] = Plat;
	}
	}
	
	private void initHole() throws SlickException {
		blackholes = new BlackHole[HOLE_COUNT];
		for (int i = 0; i < HOLE_COUNT; i++){
			blackholes[i] = new BlackHole(GAME_WIDTH/2, GAME_HEIGHT - 450*i, HOLE_VY);
		}
	}
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		updateMovement(input, delta);
		if(GameStarted == true){		
		ball.update();		
		for(BlackHole hole : blackholes){
			hole.update();
			if(ball.closeToblackHole(hole) == true){
				System.out.println("Hole!");
				GameOver = true;
				GameStarted = false;
				
			}
		}
		
		for(Platform platform : platforms){
			bg.update();
			platform.update();
			if (ball.isCollide(platform) == true){
			      System.out.println("Collision!");	      
			      ball.jump();
			      JumpSound.play();
			      
			      }
		
			}
		score += PLATFORM_VY/4;
		}
		
		
	}
	
	void updateMovement(Input input, int delta) {
		if (input.isKeyDown(Input.KEY_LEFT)) {
	    	ball.moveLeft();  
	    }
	    if (input.isKeyDown(Input.KEY_RIGHT)) {
	    	 ball.moveRight();     
	    }
		}
	
	public static void main(String[] args) {
		try {
			BallJumpGame game = new BallJumpGame ("BallJump");
		      AppGameContainer appgc = new AppGameContainer(game);
		      appgc.setDisplayMode(GAME_WIDTH,GAME_HEIGHT, false);
		      appgc.setMinimumLogicUpdateInterval(1000 / 42);
		      appgc.start();
		    } catch (SlickException e) {
		      e.printStackTrace();
		    }
		  }
}
