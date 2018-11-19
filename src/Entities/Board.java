package Entities;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import Media.Image;

public class Board {

	private static double boardX;
	private final int boardY = 530;

	public Board(int boardX) {
		Board.boardX = boardX;
	}

	public void tick() {}

	public void draw(Graphics g) {
		g.drawImage(Image.images[6], (int) boardX - 27, boardY, 55, 13, null);
	}

	public void mouseMoved(MouseEvent e) {
		boardX = e.getX();
		if (boardX <= 25)
			boardX = 25;
		if (boardX >= 373)
			boardX = 373;
	}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void keyPressed(int k) {
		if (k == KeyEvent.VK_A || k == KeyEvent.VK_LEFT)
			boardX -= 5;
		else if (k == KeyEvent.VK_D || k == KeyEvent.VK_RIGHT)
			boardX += 5;
		else {
		}

		if (boardX <= 25)
			boardX = 25;
		else if (boardX >= 373)
			boardX = 373;
	}

	public void keyReleased(int k) {}

	public static double getBoardX() {
		return boardX;
	}
}