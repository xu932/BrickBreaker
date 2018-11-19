package Entities;

public class Collision {

	private static double ballX, ballY, velocityX, velocityY;
	private static double blockX, blockY;

	public static int collisionCheck(double ballX, double ballY,
			double velocityX, double velocityY, int row, int col) {
		Collision.ballX = ballX;
		Collision.ballY = ballY;
		Collision.velocityX = velocityX;
		Collision.velocityY = velocityY;
		Collision.blockX = 24 + col * Block.blockWidth;
		Collision.blockY = 40 + row * (Block.blockHeight + 4);

		if (checkTop())
			return 1;
		if (checkRight())
			return 2;
		if (checkBottom())
			return 3;
		if (checkLeft())
			return 4;
		return 0;
	}

	private static boolean checkTop() {
		if (ballX >= blockX - 4.5 && ballX <= blockX + Block.blockWidth + 4.5
				&& ballY >= blockY - 9 && ballY <= blockY + Block.blockHeight + 2
				&& velocityY > 0)
			return true;
		return false;
	}

	private static boolean checkBottom() {
		if (ballX >= blockX - 4.5 && ballX <= blockX + Block.blockWidth + 4.5
				&& ballY >= blockY - 9 && ballY <= blockY + Block.blockHeight + 2
				&& velocityY < 0)
			return true;
		return false;
	}

	private static boolean checkLeft() {
		if (ballX >= blockX - 9 && ballX <= blockX + 9
				&& ballY >= blockY - 4.5 && ballY <= blockY + Block.blockHeight - 4.5
				&& velocityX > 0)
			return true;
		return false;
	}

	private static boolean checkRight() {
		if (ballX >= blockX + Block.blockWidth - 9 && ballX <= blockX + Block.blockWidth + 9
				&& ballY >= blockY - 4.5 && ballY <= blockY + Block.blockHeight - 4.5
				&& velocityX < 0)
			return true;
		return false;
	}

}
