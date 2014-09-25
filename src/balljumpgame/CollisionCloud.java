package balljumpgame;

public class CollisionCloud {
	static boolean Collide(float ballX, float ballY, float ballVY, float cX, float cY) {
		if((ballVY < 0)&&(ballY+Ball.HEIGHT >= cY)&&(ballY+Ball.HEIGHT <= cY + Cloud.HEIGHT)&&(ballX+Ball.WIDTH >= cX)&&(ballX <= cX + Cloud.WIDTH)){
			
						return true;
					}
			
		return false;
		
		
	}
}

