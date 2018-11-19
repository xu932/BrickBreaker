package Main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

import GameState.GameStateManager;
import Media.Image;
import Media.Music;

public class GamePanel extends JPanel implements Runnable, KeyListener,
		MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 400;
	public static final int HEIGHT = 600;

	private Thread thread;
	private boolean isRunning = false;

	private final int FPS = 60;
	private long targetTime = 1000 / FPS;

	private GameStateManager gsm;

	public GamePanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		addKeyListener(this);
		setFocusable(true);
		addMouseListener(this);
		addMouseMotionListener(this);

		new Image();
		new Music();
		Music.playBGM();
		start();
	}

	private void start() {
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}

	public void run() {
		long start, elapsed, wait;

		gsm = new GameStateManager();

		while (isRunning) {
			start = System.nanoTime();

			tick();
			repaint();

			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;

			if (wait <= 0)
				wait = 5;
			try {
				Thread.sleep(wait);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void tick() {
		gsm.tick();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.clearRect(0, 0, WIDTH, HEIGHT);
		gsm.draw(g);
	}

	public void mouseDragged(MouseEvent e) {}

	public void mouseMoved(MouseEvent e) {
		gsm.mouseMoved(e);
	}

	public void mousePressed(MouseEvent e) {
		gsm.mousePressed(e);
	}

	public void mouseReleased(MouseEvent e) {
		gsm.mouseReleased(e);
	}

	public void mouseClicked(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void keyPressed(KeyEvent e) {
		gsm.keyPressed(e.getKeyCode());
	}

	public void keyReleased(KeyEvent e) {
		gsm.keyReleased(e.getKeyCode());
	}

	public void keyTyped(KeyEvent e) {}
}
