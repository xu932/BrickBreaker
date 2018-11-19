package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import Entities.Ball;
import Entities.Board;
import GameState.GameState;
import GameState.GameStateManager;
import Main.GamePanel;
import Mapping.Maps;
import Media.Image;
import Ranking.RecordRanking;

public class Level1 extends GameState {
	private Board board;
	private Ball[] ball;
	private Maps map;
	private static long startTime = 0;
	private long currentTime;
	private static int minute;
	private static int second;
	private static boolean isRunning;
	private static int lifeRemain = 3;
	private static int score;

	public Level1(GameStateManager gsm) {
		super(gsm);
	}

	public void init() {
		isRunning = false;
		map = new Maps("/Maps/map1.map");
		board = new Board(GamePanel.WIDTH / 2 + 4);
		ball = new Ball[Option.returnDiff()];
		for (int i = 0; i < ball.length; i++) {
			ball[i] = new Ball();
			ball[i].init();
		}
		MenuState.levelRunning[0] = true;
		MenuState.levelRunning[1] = false;
	}

	public void tick() {
		currentTime = System.nanoTime() / 1000000000 - startTime;
		if(startTime==0)
			currentTime = 0;
		board.tick();
		for (int i = 0; i < ball.length; i++)
			ball[i].tick();
	}

	public void draw(Graphics g) {
		g.drawImage(Image.gameBackground[0], 0, 0, 400, 600, null);
		board.draw(g);
		for (int i = 0; i < ball.length; i++)
			ball[i].draw(g);
		map.draw(g);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.PLAIN, 22));
		second = (int) (currentTime % 60);
		minute = (int) (currentTime / 60);
		g.drawString("Time  " + minute + " : " + second, 10, 30);
		g.drawString("Score: " + score, 150, 30);
		for (int i = 0; i < lifeRemain; i++)
			g.drawImage(Image.images[10], 370 - 20 * i, 20, 216 / 24, 216 / 24,
					null);
	}

	public void mouseMoved(MouseEvent e) {
		if (Option.ctrlMethod[0]) {
			board.mouseMoved(e);
			for (int i = 0; i < ball.length; i++)
				ball[i].mouseMoved(e);
		}
	}

	public void mousePressed(MouseEvent e) {
		if (Option.ctrlMethod[0]) {
			board.mousePressed(e);
			for (int i = 0; i < ball.length; i++){
				ball[i].mousePressed(e);
			}
			if(!isRunning){
				isRunning = true;
				startTime = System.nanoTime() / 1000000000;
			}
		}
	}

	public void mouseReleased(MouseEvent e) {}

	public void keyPressed(int k) {
		if (Option.ctrlMethod[1]) {
			board.keyPressed(k);
			for (int i = 0; i < ball.length; i++)
				ball[i].keyPressed(k);
		}
	}

	public void keyReleased(int k) {}

	public static void died() {
		lifeRemain--;
		if (lifeRemain == 0) {
			String player = JOptionPane.showInputDialog(
					"You lost all your lives\nPlease enter your name", "Player");
			recordRanking(player);
			gsm.states.push(new MenuState(gsm));
		}
	}
	
	public static void win(){
		score += 50 * (60 * (20 - minute) + 60 - second);
		score += lifeRemain * 5000;
		String player = JOptionPane.showInputDialog(
				"Congradulation, You win!\nYour score is " + score
						+ "\nPlease enter your name", "Player");
		recordRanking(player);
		MenuState.levelRunning[0] = false;
		gsm.states.push(new Level2(gsm));
	}
	
	public static void addScore(int add){
		score+=add;
	}
	
	private static void recordRanking(String player) {
		new RecordRanking(1, player, minute, second, score);
	}

}
