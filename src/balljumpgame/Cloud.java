package balljumpgame;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;



public class Cloud {
	private Random random = new Random();
	private Image cloud;
	private float x;
	private float y;
	private float vy;
	//private float vcm;
	static public final float WIDTH = 200;
	static public final float HEIGHT = 100; 
	public Cloud(float x, float y, float vy ) throws SlickException{
		 	this.x = x;
		    this.y = y;
		    this.vy = vy;
		    //this.vcm = vcm;
		    cloud = new Image("res/clouds.png");
		
	}
	public void render(){
		cloud.draw(x-WIDTH/2,y-HEIGHT);
		
	}
	public void randomX() {
		  x =100 + random.nextInt(400);
		  
		  }
	 public void update(){
		  y += vy;
		  //vy -= BallJumpGame.Gravity_C;
		  if (y == BallJumpGame.GAME_HEIGHT + HEIGHT + 200){
			  y = 0;
			  randomX();
		  }
		  
	 }
	 //public void cloudMovement(){
		// vy = vcm;
	 //}
	 
	 public float getPositionX() { return x; }
	 public float getPositionY() { return y; }
}
