package balljumpgame;

public class CollisionPlatform {
	static boolean Collide(float ballX, float ballY, float ballVY, float cX, float cY) {
		if((ballVY < 0)&&(ballY+Ball.HEIGHT >= cY+Ball.HEIGHT)&&(ballY+Ball.HEIGHT <= cY + Platform.HEIGHT)&&
				(ballX+Ball.WIDTH >= cX - (Ball.WIDTH*2))&&(ballX <= cX + Platform.WIDTH - (Ball.WIDTH*2))){
			
						return true;
					}
			
		return false;
		
		
	}
	static boolean Collide2(float ballX, float ballY, float ballVY, float dX, float dY) {
		if((ballVY < 0)&&(ballY+Ball.HEIGHT >= dY+Ball.HEIGHT)&&(ballY+Ball.HEIGHT <= dY + Platform.HEIGHT)&&
				(ballX+Ball.WIDTH >= dX - (Ball.WIDTH))&&(ballX <= dX + Platform.WIDTH - (Ball.WIDTH))){
			
						return true;
					}
			
		return false;
		
		
	}
}

