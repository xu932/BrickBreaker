package GameState;

import java.awt.Graphics;
import java.awt.event.MouseEvent;

public abstract class GameState {

	protected static GameStateManager gsm;

	public GameState(GameStateManager gsm) {
		GameState.gsm = gsm;
		init();
	}

	public abstract void init();

	public abstract void tick();

	public abstract void draw(Graphics g);

	public abstract void keyPressed(int k);

	public abstract void keyReleased(int k);

	public abstract void mouseMoved(MouseEvent e);

	public abstract void mousePressed(MouseEvent e);

	public abstract void mouseReleased(MouseEvent e);

}