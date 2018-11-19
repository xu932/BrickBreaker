package Entities;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import Game.Level1;
import Game.Level2;
import Game.MenuState;
import Mapping.Maps;
import Media.Image;
import Media.Music;

public class Ball {

	private double ballX = 198, ballY = 524;
	private double velocityX = 0, velocityY = 0;
	private final double minVelocityX = 1.3, minVelocityY = 1.4;
	private final double maxVelocityX = 1.9, maxVelocityY = 2.0;

	private boolean isRunning = false;

	public Ball() {}

	public void init() {
		ballX = Board.getBoardX() - 3;
	}

	public void tick() {
		ballX += velocityX;
		ballY += velocityY;

		if (isRunning) {
			bounceSide();
			bounceTop();
			bounceBottom();
			hitBoard(returnJ(),returnI());
			
			if(Maps.isWin()){
				isRunning = false;
				for (int i = 0; i < MenuState.levelRunning.length; i++) {
					if (MenuState.levelRunning[i] && i == 0)
						Level1.win();
					else if (MenuState.levelRunning[i] && i == 1)
						Level2.win();
				}
			}
		}
		
	}

	public void draw(Graphics g) {
		g.drawImage(Image.images[10], (int) ballX, (int) ballY, 216 / 24,
				216 / 24, null);
	}

	public void mouseMoved(MouseEvent e) {
		if (!isRunning) {
			ballX = e.getX() - 3;
			if (e.getX() <= 24)
				ballX = 22;
			else if (e.getX() >= 373)
				ballX = 370;
		}
	}

	public void mousePressed(MouseEvent e) {
		if (!isRunning) {
			int temp = (int) (Math.random() + 0.5);
			if (temp == 1) {
				velocityX = 1.6;
				velocityY = -1.7;
			} else if (temp == 0) {
				velocityX = -1.6;
				velocityY = -1.7;
			}
			isRunning = true;
		}
	}

	public void keyPressed(int k) {
		if (!isRunning) {
			if (k == KeyEvent.VK_A || k == KeyEvent.VK_LEFT)
				ballX -= 5;
			if (k == KeyEvent.VK_D || k == KeyEvent.VK_RIGHT)
				ballX += 5;
			if (k == KeyEvent.VK_SPACE) {
				if ((int) (Math.random() + 0.5) == 1) {
					velocityX = 1.6;
					velocityY = -1.7;
				} else if ((int) (Math.random() + 0.5) == 0) {
					velocityX = -1.6;
					velocityY = -1.7;
				}
				isRunning = true;
			}

			if (ballX <= 21)
				ballX = 21;
			else if (ballX >= 370)
				ballX = 370;
		}
	}

	private void bounceSide(){
		if (ballX <= 0) {
			ballX = 0;
			velocityX = velocityX * -1 + (Math.random() * 1.2 - 0.6);
			if (velocityX > 0) {
				if (velocityX < minVelocityX)
					velocityX = minVelocityX;
				else if (velocityX > maxVelocityX)
					velocityX = maxVelocityX;
			} else if (velocityX < 0) {
				if (Math.abs(velocityX) < minVelocityX)
					velocityX = -minVelocityX;
				else if (Math.abs(velocityX) > maxVelocityX)
					velocityX = -maxVelocityX;
			}
		} else if (ballX >= 391) {
			ballX = 391;
			velocityX = velocityX * -1 + (Math.random() * 1.2 - 0.6);
			if (velocityX > 0) {
				if (velocityX < minVelocityX)
					velocityX = minVelocityX;
				else if (velocityX > maxVelocityX)
					velocityX = maxVelocityX;
			} else if (velocityX < 0) {
				if (Math.abs(velocityX) < minVelocityX)
					velocityX = -minVelocityX;
				else if (Math.abs(velocityX) > maxVelocityX)
					velocityX = -maxVelocityX;
			}
		}
	}
	
	private void bounceTop(){
		if (ballY <= 0) {
			ballY = 0;
			velocityY = velocityY * -1 + (Math.random() * 1.2 - 0.6);
			if (velocityY > 0) {
				if (velocityY < minVelocityY)
					velocityY = minVelocityY;
				else if (velocityY > maxVelocityY)
					velocityY = maxVelocityY;
			} else if (velocityY < 0) {
				if (Math.abs(velocityY) < minVelocityY)
					velocityY = -minVelocityY;
				else if (Math.abs(velocityY) > maxVelocityY)
					velocityY = -maxVelocityY;
			}
		}
	}
	
	private void bounceBottom(){
		
		if (ballY >= 525 && ballY <= 530) {
			if (ballX >= (Board.getBoardX() - 30)
					&& ballX <= (Board.getBoardX() + 30)) {
				ballY = 525;
				velocityY = velocityY * -1 + (Math.random() * 1.2 - 0.6);
				if (velocityY > 0) {
					if (velocityY < minVelocityY)
						velocityY = minVelocityY;
					else if (velocityY > maxVelocityY)
						velocityY = maxVelocityY;
				} else if (velocityY < 0) {
					if (Math.abs(velocityY) < minVelocityY)
						velocityY = -minVelocityY;
					else if (Math.abs(velocityY) > maxVelocityY)
						velocityY = -maxVelocityY;
				}
			}
		}else if(ballY>=600){
			isRunning = false;
			ballY = 524;
			velocityX = 0;
			velocityY = 0;
			for (int i = 0; i < MenuState.levelRunning.length; i++) {
				if (MenuState.levelRunning[i] && i == 0)
					Level1.died();
				else if (MenuState.levelRunning[i] && i == 1)
					Level2.died();
			}
		}
	}
	
	private int returnI(){
		int i = (int) ((ballX - 24) / Block.blockWidth) - 1;
		if(i<0)
			i = 0;
		else if(i>Maps.blocks[0].length)
			i = Maps.blocks[0].length - 4;
		return i;
	}
	
	private int returnJ(){
		int j = (int) ((ballY - 40) / (Block.blockHeight + 4)) - 1;
		if(j<0)
			j = 0;
		else if(j>Maps.blocks.length)
			j = Maps.blocks.length - 4;
		return j;
	}
	
	private void hitBoard(int x, int y) {
		for (int i = x; i <= (x + 3) && i < Maps.blocks.length; i++) {
			for (int j = y; j <= (y + 3) && j < Maps.blocks[i].length; j++) {
				if (Maps.blocks[i][j].getID() != 0) {
					switch (Collision.collisionCheck(ballX, ballY, velocityX,
							velocityY, i, j)) {
					case 1:
					case 3:
						Maps.blocks[i][j].setID(Maps.blocks[i][j].getID()-1);
						velocityY *= -1;
						for (int k = 0; k < MenuState.levelRunning.length; k++) {
							if (MenuState.levelRunning[k] && k == 0)
								Level1.addScore(100);
							else if (MenuState.levelRunning[k] && k == 1)
								Level2.addScore(100);
						}
						Music.crush();
						break;
					case 2:
					case 4:
						Maps.blocks[i][j].setID(Maps.blocks[i][j].getID()-1);
						for (int k = 0; k < MenuState.levelRunning.length; k++) {
							if (MenuState.levelRunning[k] && k == 0)
								Level1.addScore(100);
							else if (MenuState.levelRunning[k] && k == 1)
								Level2.addScore(100);
						}
						Music.crush();
						velocityX *= -1;
						break;
					default:
					}
				}
			}
		}
	}
}