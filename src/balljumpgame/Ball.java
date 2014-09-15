package balljumpgame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Ball {
	private float x;
	private float y;
	private Image image;
	private float vy;
	
	public Ball (float x, float y) throws SlickException {
	    this.x = x;
	    this.y = y;	 	  
	    image = new Image("res/Ball.png");
	  }
	 
	  public void render() {
		  image.draw(BallJumpGame.GAME_WIDTH/2 - 20 ,BallJumpGame.GAME_HEIGHT - 40);
	  }

	public void update() {
		// TODO Auto-generated method stub
		 y += vy;
		    vy -= 1.5;
	}
	

}
