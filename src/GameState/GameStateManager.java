package GameState;

import Game.MenuState;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.Stack;

public class GameStateManager {

	public Stack<GameState> states;

	public GameStateManager() {
		states = new Stack<GameState>();
		states.push(new MenuState(this));
	}

	public void tick() {
		states.peek().tick();
	}

	public void draw(Graphics g) {
		states.peek().draw(g);
	}

	// ------------------------------------key control-------------------------------------

	public void keyPressed(int k) {
		states.peek().keyPressed(k);
	}

	public void keyReleased(int k) {
		states.peek().keyReleased(k);
	}

	public void keyType(int k) {
	}

	// ------------------------------------mouse control------------------------------------

	public void mouseMoved(MouseEvent e) {
		states.peek().mouseMoved(e);
	}

	public void mousePressed(MouseEvent e) {
		states.peek().mousePressed(e);
	}

	public void mouseReleased(MouseEvent e) {
		states.peek().mouseReleased(e);
	}

}
