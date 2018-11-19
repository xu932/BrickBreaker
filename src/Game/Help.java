package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import GameState.GameState;
import GameState.GameStateManager;
import Media.Image;

public class Help extends GameState {

	private boolean mouseOnButton = false;

	private double mouseX, mouseY;

	public Help(GameStateManager gsm) {
		super(gsm);
	}

	public void init() {}

	public void tick() {}

	public void draw(Graphics g) {
		g.drawImage(Image.images[1], 0, 0, 400, 600, null);

		g.setColor(new Color(255, 100, 50));
		g.setFont(new Font("Arial", Font.PLAIN, 32));
		g.drawString("This game is called", 40, 70);
		g.drawString("brick breaker. Your job ", 40, 110);
		g.drawString("is don't let the ball fall", 40, 150);
		g.drawString("off the bottom of off the", 40, 190);
		g.drawString("screen by moving the", 40, 230);
		g.drawString("mouse to control the ", 40, 270);
		g.drawString("bottom board.", 40, 310);

		g.drawImage(Image.images[9], 80, 360, 225 / 4 * 3, 177 / 4 * 3, null);

		if (mouseOnButton)
			g.drawImage(Image.images[8], 220, 520, (int) (400 / 3),
					(int) (86 / 3), null);
		else
			g.drawImage(Image.images[7], 220, 520, (int) (400 / 3),
					(int) (86 / 3), null);
	}

	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		if (mouseX >= 220 && mouseX <= 350 && mouseY >= 520 && mouseY <= 550)
			mouseOnButton = true;
		else
			mouseOnButton = false;
	}

	public void mousePressed(MouseEvent e) {
		if (mouseOnButton)
			gsm.states.push(new MenuState(gsm));
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void keyPressed(int k) {
	}

	public void keyReleased(int k) {
	}

}
