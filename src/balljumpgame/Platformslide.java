package balljumpgame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Platformslide extends Platform {

	public Platformslide(float x, float y, float vy) throws SlickException {
		super(x, y, vy);
	}
	@Override
	public void ImagePlatform() throws SlickException {
		platform = new Image("res/PF2.png");
		
	}
	@Override
	public void Features() {
		y += vy;
		if (y == BallJumpGame.GAME_HEIGHT + HEIGHT + 200){
			  y = 0;
			  randomX();
		  }
		x -= 1;
		if(x == -WIDTH){
			x = BallJumpGame.GAME_WIDTH;
		}
	}
}
