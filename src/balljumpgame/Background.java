package balljumpgame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Background {
	private Image image;
	private float vy;
	private float x;
	private float y;

	public Background (float x, float y, float vy) throws SlickException {
	    this.x = x;
	    this.y = y;	 
	    this.vy = vy;
	    image = new Image("res/BG1.png");
	  }
	 
	public void render() {
		  image.draw(0,0);
	  }

	public void update() {
		// TODO Auto-generated method stub
		 y += vy;
		    
		 if(y == 0){
			 y = BallJumpGame.GAME_HEIGHT;
		 }
		 if(y == BallJumpGame.GAME_HEIGHT){
			 y = 0;
		 }
	}
	
}
