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
	private boolean GameStarted;
	public static final float BALL_JUMP_VY = 25;
	public static final int GAME_WIDTH = 640;
	public static final int GAME_HEIGHT = 480;
	public static final float Gravity = (float) 1.5;

	public BallJumpGame(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	@Override
	  public void keyPressed(int key, char c) {
		if (key == Input.KEY_SPACE) {
		      // do something
		    	ball.jump();
		    }
		
	    if (key == Input.KEY_ENTER) {
		      // do something
		    	GameStarted = true;
		    }
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		ball.render();
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		Color background = new Color(255,192,203 );
	    container.getGraphics().setBackground(background);
	    ball = new Ball(GAME_WIDTH/2,GAME_HEIGHT,BALL_JUMP_VY);
	    GameStarted = false;
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		// TODO Auto-generated method stub
		if(GameStarted == true){
		ball.update();
		
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
