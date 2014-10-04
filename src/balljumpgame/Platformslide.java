package balljumpgame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Platformslide extends Platform {

	public Platformslide(float x, float y, float vy) throws SlickException {
		super(x, y, vy);
		// TODO Auto-generated constructor stub
	}
	
	public void ImagePlatform() throws SlickException {
		platform = new Image("res/PF2.png");
		
	}
	
	
}
