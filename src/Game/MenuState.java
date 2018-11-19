package Game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import GameState.GameStateManager;
import GameState.GameState;
import Media.Image;
import Ranking.RankingMenu;

public class MenuState extends GameState {

	private boolean[] imageChose = { false, false, false, false };
	private int currentSelection = 0;
	private int mouseX, mouseY;
	private int time, stdTime;
	
	public static boolean[] levelRunning;

	public MenuState(GameStateManager gsm) {
		super(gsm);
	}

	public void init() {
		levelRunning = new boolean[2];
	}

	public void tick() {}

	public void draw(Graphics g) {
		g.drawImage(Image.images[0], 0, 0, 400, 600, null);
		if (currentSelection == 1) {
			g.drawImage(Image.images[3], 230, 500, 126, 43, null);
			g.drawImage(Image.images[4], 230, 550, 129, 24, null);
			g.drawImage(Image.Option[0], 310, 440, 40, 40, null);
			g.drawImage(Image.images[11], 230, 430, 60, 60, null);
		} else if (currentSelection == 2) {
			g.drawImage(Image.images[5], 230, 550, 129, 24, null);
			g.drawImage(Image.images[2], 230, 500, 126, 43, null);
			g.drawImage(Image.Option[0], 310, 440, 40, 40, null);
			g.drawImage(Image.images[11], 230, 430, 60, 60, null);
		} else if (currentSelection == 3) {
			g.drawImage(Image.images[2], 230, 500, 126, 43, null);
			g.drawImage(Image.images[4], 230, 550, 129, 24, null);
			g.drawImage(Image.images[11], 230, 430, 60, 60, null);
			time = (int) (System.nanoTime() / 1000000) - stdTime;
			if (time >= 0 && time < 100)
				g.drawImage(Image.Option[0], 310, 440, 40, 40, null);
			else if (time >= 100 && time < 200)
				g.drawImage(Image.Option[1], 310, 440, 40, 40, null);
			else if (time >= 200 && time < 300)
				g.drawImage(Image.Option[2], 310, 440, 40, 40, null);
			else if (time >= 300 && time < 400)
				g.drawImage(Image.Option[3], 310, 440, 40, 40, null);
			else if (time >= 400 && time < 500)
				g.drawImage(Image.Option[4], 310, 440, 40, 40, null);
			else if (time >= 500 && time < 600)
				g.drawImage(Image.Option[5], 310, 440, 40, 40, null);
			else if (time >= 600 && time < 700)
				g.drawImage(Image.Option[6], 310, 440, 40, 40, null);
			else if (time >= 700 && time < 800)
				g.drawImage(Image.Option[7], 310, 440, 40, 40, null);
			else if (time >= 800 && time < 900)
				g.drawImage(Image.Option[8], 310, 440, 40, 40, null);
			else if (time >= 900 && time < 1000)
				g.drawImage(Image.Option[7], 310, 440, 40, 40, null);
			else if (time >= 1000 && time < 1100)
				g.drawImage(Image.Option[6], 310, 440, 40, 40, null);
			else if (time >= 1100 && time < 1200)
				g.drawImage(Image.Option[5], 310, 440, 40, 40, null);
			else if (time >= 1200 && time < 1300)
				g.drawImage(Image.Option[4], 310, 440, 40, 40, null);
			else if (time >= 1300 && time < 1400)
				g.drawImage(Image.Option[3], 310, 440, 40, 40, null);
			else if (time >= 1400 && time < 1500)
				g.drawImage(Image.Option[2], 310, 440, 40, 40, null);
			else if (time >= 1500 && time < 1600)
				g.drawImage(Image.Option[1], 310, 440, 40, 40, null);
			else if (time >= 1600 && time < 1700) {
				g.drawImage(Image.Option[0], 310, 440, 40, 40, null);
				stdTime = (int) (System.nanoTime() / 1000000);
			}

		} else if(currentSelection == 4){
			g.drawImage(Image.images[12], 230, 430, 60, 60, null);
			g.drawImage(Image.Option[0], 310, 440, 40, 40, null);
			g.drawImage(Image.images[2], 230, 500, 126, 43, null);
			g.drawImage(Image.images[4], 230, 550, 129, 24, null);
		}
		else {
			g.drawImage(Image.images[2], 230, 500, 126, 43, null);
			g.drawImage(Image.images[4], 230, 550, 129, 24, null);
			g.drawImage(Image.Option[0], 310, 440, 40, 40, null);
			g.drawImage(Image.images[11], 230, 430, 60, 60, null);
			
		}
	}

	public void keyPressed(int k) {
		if (k == KeyEvent.VK_DOWN || k == KeyEvent.VK_S) {
			currentSelection++;
			if (currentSelection == 3)
				currentSelection = 1;
		}

		if (k == KeyEvent.VK_UP || k == KeyEvent.VK_W) {
			currentSelection--;
			if (currentSelection == 0)
				currentSelection = 2;
		}

		if (k == KeyEvent.VK_ENTER)
			if (currentSelection == 1)
				gsm.states.push(new Level1(gsm));
			else if (currentSelection == 2)
				gsm.states.push(new Help(gsm));
	}

	public void keyReleased(int k) {}

	// --------------------------------------------mouse--------------------------------------------

	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		if (mouseX >= 230 && mouseX <= 360 && mouseY >= 500 && mouseY <= 543) {
			imageChose[0] = true;
			imageChose[1] = false;
			imageChose[2] = false;
			imageChose[3] = false;
			currentSelection = 1;
		} else if (mouseX >= 230 && mouseX <= 360 && mouseY >= 550
				&& mouseY <= 575) {
			imageChose[1] = true;
			imageChose[0] = false;
			imageChose[2] = false;
			imageChose[3] = false;
			currentSelection = 2;
		} else if (mouseX > 310 && mouseX < 350 && mouseY > 440 && mouseY < 480) {
			if (currentSelection != 3) {
				imageChose[2] = true;
				imageChose[0] = false;
				imageChose[1] = false;
				imageChose[3] = false;
				stdTime = (int) (System.nanoTime() / 1000000);
				currentSelection = 3;
			}
		} else if(mouseX > 230 && mouseX < 290 && mouseY > 430 && mouseY < 490){
			imageChose[3] = true;
			for(int i=0;i<3;i++)
				imageChose[i] = false;
			currentSelection = 4;
		}
		else {
			for (int i = 0; i < imageChose.length; i++)
				imageChose[i] = false;
			currentSelection = 0;
		}

	}

	public void mousePressed(MouseEvent e) {
		if (imageChose[0]) {
			gsm.states.push(new Level1(gsm));
		} else if (imageChose[1])
			gsm.states.push(new Help(gsm));
		else if (imageChose[2])
			gsm.states.push(new Option(gsm));
		else if(imageChose[3])
			gsm.states.push(new RankingMenu(gsm));
	}

	public void mouseReleased(MouseEvent e) {}

}