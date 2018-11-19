package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import GameState.GameState;
import GameState.GameStateManager;
import Media.Image;

public class Option extends GameState {

	public static boolean[] ctrlMethod = { true, false };
	private boolean[] ctrlMethod_mouse = { false, false };
	public static boolean[] ballAmount = { true, false, false };
	private boolean[] ballAmount_mouse = { false, false, false };

	private double mouseX, mouseY;
	private boolean mouseOnButton = false;

	public Option(GameStateManager gsm) {
		super(gsm);
	}

	public void init() {
	}

	public void tick() {
	}

	public void draw(Graphics g) {
		g.drawImage(Image.images[1], 0, 0, null);

		g.setColor(new Color(255, 0, 0));
		g.setFont(new Font("AR DESTINE", Font.BOLD, 40));
		g.drawString("OPTIONS", 125, 70);
		g.setColor(new Color(255, 0, 0));
		g.setFont(new Font("AR DESTINE", Font.BOLD, 32));
		g.drawString("CONTROL:", 50, 120);

		for (int i = 0; i < ctrlMethod.length; i++) {
			if (ctrlMethod[i] || ctrlMethod_mouse[i])
				g.drawImage(Image.Option[10 + 2 * i], 30 + 160 * i, 150,
						138 + 40 * i, 96, null);
			else if ((!ctrlMethod[i]) || (!ctrlMethod_mouse[i]))
				g.drawImage(Image.Option[9 + 2 * i], 30 + 160 * i, 150,
						138 + 40 * i, 96, null);
		}

		g.drawString("DIFFICULTY:", 50, 300);
		for (int i = 0; i < ballAmount.length; i++) {
			if (ballAmount[i] || ballAmount_mouse[i])
				g.drawImage(Image.Option[14 + 2 * i], 30 + 120 * i, 335, 100,
						100, null);
			else if ((!ballAmount[i]) || (!ballAmount_mouse[i]))
				g.drawImage(Image.Option[13 + 2 * i], 30 + 120 * i, 335, 100,
						100, null);
		}

		if (mouseOnButton)
			g.drawImage(Image.images[8], 220, 520, (int) (400 / 3),
					(int) (86 / 3), null);
		else
			g.drawImage(Image.images[7], 220, 520, (int) (400 / 3),
					(int) (86 / 3), null);
	}

	public void keyPressed(int k) {
	}

	public void keyReleased(int k) {
	}

	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		if (mouseX >= 30 && mouseX <= 168 && mouseY >= 150 && mouseY <= 246)
			ctrlMethod_mouse[0] = true;
		else
			ctrlMethod_mouse[0] = false;

		if (mouseX >= 190 && mouseX <= 368 && mouseY >= 150 && mouseY <= 246)
			ctrlMethod_mouse[1] = true;
		else
			ctrlMethod_mouse[1] = false;

		if (mouseX >= 30 && mouseX <= 130 && mouseY >= 335 && mouseY <= 435)
			ballAmount_mouse[0] = true;
		else
			ballAmount_mouse[0] = false;

		if (mouseX >= 150 && mouseX <= 250 && mouseY >= 335 && mouseY <= 435)
			ballAmount_mouse[1] = true;
		else
			ballAmount_mouse[1] = false;

		if (mouseX >= 270 && mouseX <= 370 && mouseY >= 335 && mouseY <= 435)
			ballAmount_mouse[2] = true;
		else
			ballAmount_mouse[2] = false;

		if (mouseX >= 220 && mouseX <= 350 && mouseY >= 520 && mouseY <= 550)
			mouseOnButton = true;
		else
			mouseOnButton = false;
	}

	public void mousePressed(MouseEvent e) {
		if (ctrlMethod_mouse[0]) {
			ctrlMethod[0] = true;
			ctrlMethod[1] = false;
		} else if (ctrlMethod_mouse[1]) {
			ctrlMethod[1] = true;
			ctrlMethod[0] = false;
		}

		if (ballAmount_mouse[0]) {
			ballAmount[0] = true;
			ballAmount[1] = false;
			ballAmount[2] = false;
		} else if (ballAmount_mouse[1]) {
			ballAmount[1] = true;
			ballAmount[0] = false;
			ballAmount[2] = false;
		} else if (ballAmount_mouse[2]) {
			ballAmount[2] = true;
			ballAmount[0] = false;
			ballAmount[1] = false;
		}

		if (mouseOnButton)
			gsm.states.push(new MenuState(gsm));
	}

	public void mouseReleased(MouseEvent e) {}
	
	public static int returnDiff(){
		if(ballAmount[0])
			return 1;
		else if(ballAmount[1])
			return 2;
		else if(ballAmount[2])
			return 3;
		else
			return 0;
	}

}