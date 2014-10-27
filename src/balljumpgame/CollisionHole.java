package balljumpgame;

public class CollisionHole {
	public static double distance;

	static boolean handleCollision(float ballX, float ballY, float gX, float gY){
		distance = Math.sqrt((( gX - ballX + 35)*( gX - ballX + 35))+(( gY - ballY + 80)*( gY - ballY + 80)));
		if ( distance <= 40) {
			return true;
		} else {
			return false;
		}
		
	}
}
