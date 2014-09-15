package balljumpgame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Ball {
	private float x;
	private float y;
	private Image image;
	private float vy;
	private float vjump;
	
	public Ball (float x, float y, float vjump) throws SlickException {
	    this.x = x;
	    this.y = y;	 
	    this.vy = vjump;
	    this.vjump = vjump;
	    image = new Image("res/Ball.png");
	  }
	 
	  public void render() {
		  image.draw(x - 20 ,y - 40);
	  }

	public void update() {
		// TODO Auto-generated method stub
		 y -= vy;
		    vy -= BallJumpGame.Gravity;
	}
	public void jump(){
		vy = vjump;
	}
	public void moveLeft() {
		x -=5;
	}


	public void moveRight() {
		x +=5;
	}




}
