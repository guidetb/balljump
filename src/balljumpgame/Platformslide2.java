package balljumpgame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Platformslide2 extends Platform {

	public Platformslide2(float x, float y, float vy) throws SlickException {
		super(x, y, vy);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void ImagePlatform() throws SlickException {
		platform = new Image("res/PF3.png");
		
	}
	@Override
	public void Features() {
		y += vy;
		if (y == BallJumpGame.GAME_HEIGHT + HEIGHT + 200){
			  y = 0;
			  randomX();
		  }
		x += 1;
		if(x == BallJumpGame.GAME_WIDTH + 100){
			x = -WIDTH;
		}
	}

}
