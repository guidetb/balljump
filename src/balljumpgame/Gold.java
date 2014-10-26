package balljumpgame;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Gold {
	private float x;
	private float y;
	private float vy;
	private Image image;
	private Random random = new Random();
	public static final float WIDTH = 35;
	public static final float HEIGHT = 35;

	public Gold(float x, float y, float vy ) throws SlickException{
		this.x = x;
	    this.y = y;
	    this.vy = vy;
	    image = new Image("res/Coinn.png");
}
	public void render(){
		image.draw(x/2,y/2);
	}
	
	public void update(){
		y += vy;
		if (y == BallJumpGame.GAME_HEIGHT + BallJumpGame.GAME_HEIGHT ){
			  y = 0;
			  randomX();
		}
	}
	public void randomX() {
			  x = 100 +  random.nextInt(400);
			  
			  }
	public float getPositionX() { return x; }
	public float getPositionY() { return y; }
}
