package balljumpgame;

public class CollisionGold {
	public static double distance;

	static boolean handleCollision(float ballX, float ballY, float gX, float gY){
		distance = Math.sqrt(( gX - ballX - 100 )*( gX - ballX - 100 )+( gY - ballY  )*( gY - ballY  ));
		if ( distance < 40 ) {
			return true;
		} else {
			return false;
		}
		
	}
}