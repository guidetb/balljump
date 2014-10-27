package balljumpgame;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;



public class Platform {
	private Random random = new Random();
	protected Image platform ;
	protected float x;
	protected float y;
	protected float vy;
	static public final float WIDTH = 200;
	static public final float HEIGHT = 100; 
	public Platform(float x, float y, float vy ) throws SlickException{
		 	this.x = x;
		    this.y = y;
		    this.vy = vy;
		    
		    ImagePlatform();
		
	}
	public void ImagePlatform() throws SlickException {
		platform = new Image("res/PF1.png");
	}
	public void render(){
		platform.draw(x-WIDTH/2,y-HEIGHT);
		
	}
	public void randomX() {
		  x = 100 + random.nextInt(450);
		  
		  }
	 public void update(){
		 Features();
		  
	 }
	 
	public void Features() {
		y += vy;
		if (y == BallJumpGame.GAME_HEIGHT + HEIGHT + 200){
			  y = 0;
			  randomX();
		  }
	}
	 
	 public float getPositionX() { return x; }
	 public float getPositionY() { return y; }
}
