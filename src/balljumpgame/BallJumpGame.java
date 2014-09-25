package balljumpgame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;



public class BallJumpGame extends BasicGame{
	private Ball ball;
	private Cloud[] clouds;
	private boolean GameStarted;
	public static final float JUMP_VY = 25;
	public static final int GAME_WIDTH = 640;
	public static final int GAME_HEIGHT = 480;
	public static final float Gravity = (float) 1.5;
	public static final int CLOUD_COUNT = 3 ;
	public static final float CLOUD_VY = 5;

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
		    }
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		ball.render();
		for(Cloud cloud : clouds){
		cloud.render();
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		Color background = new Color(255,192,203 );
	    container.getGraphics().setBackground(background);
	    ball = new Ball(GAME_WIDTH/2,GAME_HEIGHT,JUMP_VY);
	    GameStarted = false;
	    initCloud();
	    
	}
	
	private void initCloud() throws SlickException {
		clouds = new Cloud[CLOUD_COUNT];
	    for (int i = 0; i < CLOUD_COUNT; i++) {
	    	clouds[i] = new Cloud(GAME_WIDTH/2, GAME_HEIGHT - 250*i , CLOUD_VY);
	    }
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		updateMovement(input, delta);
		if(GameStarted == true){
		
		ball.update();
		for(Cloud cloud : clouds){
			cloud.update();
			if (ball.isCollide(cloud) == true){
			      System.out.println("Collision!");
			      ball.jump();
			     
			      }
		
		}
		
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
		      appgc.setDisplayMode(640,480, false);
		      appgc.setMinimumLogicUpdateInterval(1000 / 40);
		      appgc.start();
		    } catch (SlickException e) {
		      e.printStackTrace();
		    }
		  }


}
