package Ranking;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;

import GameState.GameState;
import GameState.GameStateManager;
import Game.MenuState;
import Media.Image;

public class RankingMenu extends GameState{
	
	private Connection con;
	private PreparedStatement statement;
	private PreparedStatement find;
	private ResultSet result;
	private boolean[] level = {true, false};
	private boolean onExit = false;
	private int mouseX, mouseY;
	private int[] x = new int[3], y = new int[3];
	private ArrayList<Integer> readScore;
	private String[] player;
	private int[] min;
	private int[] sec;
	private int[] score;
	private Font myFont;
	private Font title;
	private int xOffset;
	private int yOffset;

	public RankingMenu(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		level = new boolean[2];
		level[0] = true;
		for (int i = 1; i < level.length; i++)
			level[i] = false;
		xOffset = 13;
		yOffset = 30;
		myFont = new Font("Arial",Font.BOLD,16);
		title = new Font("Jokerman", Font.PLAIN, 28);
		readScore = new ArrayList<Integer>(1);
		player = new String[15];
		min = new int[15];
		sec = new int[15];
		score = new int[15];
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/summative", "root", "");
			updateSQL();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void updateSQL(){
		//
		for(int i=1;i<15;i++){
			player[i] = null;
			min[i] = 0;
			sec[i] = 0;
			score[i] = 0;
		}
		try {
			if (level[0])
				statement = con.prepareStatement("select * from level_1");
			else if (level[1])
				statement = con.prepareStatement("select * from level_2");
			result = statement.executeQuery();
			while (result.next()) {
				readScore.add(result.getInt(4));
			}
			statement.close();
			Collections.sort(readScore);
			player[0] = "Alex Xu";
			min[0] = 0;
			sec[0] = 0;
			score[0] = 9999999;
			for (int i = readScore.size() - 1, j = 1; i >= readScore.size() - 15 && i >= 0; i--, j++){
				if (level[0])
					find = con.prepareStatement("SELECT * FROM level_1 WHERE Score = ?");
				else if (level[1])
					find = con.prepareStatement("SELECT * FROM level_2 WHERE Score = ?");
				find.setInt(1, readScore.get(i));
				result = find.executeQuery();
				if (result.next()) {
					player[j] = result.getString(1);
					min[j] = result.getInt(2);
					sec[j] = result.getInt(3);
					score[j] = result.getInt(4);
				}
			}
			readScore.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void tick() {}

	public void draw(Graphics g) {
		String output;
		g.drawImage(Image.images[13], 0, 0, 400, 600, null);
		if (onExit)
			g.drawImage(Image.images[8], 250, 570, (int) (400 / 3),
					(int) (86 / 3), null);
		else
			g.drawImage(Image.images[7], 250, 570, (int) (400 / 3),
					(int) (86 / 3), null);
		g.setFont(title);
		
		if(level[0]){
			g.setColor(Color.YELLOW);
			g.drawString("Level  1", 150, 45);
			g.setColor(Color.GREEN);
			x[0] = x[1] = 400-90; x[2] = 400-40;
			y[0] = 10; y[1] = 50; y[2] = 30;
			g.fillPolygon(x, y, 3);
		}else if(level[1]){
			g.setColor(Color.YELLOW);
			g.drawString("Level  2", 150, 45);
			g.setColor(Color.GREEN);
			x[0] = x[1] = 90; x[2] = 40;
			y[0] = 10; y[1] = 50; y[2] = 30;
			g.fillPolygon(x, y, 3);
		}
		g.setFont(myFont);
		g.setColor(Color.YELLOW);
		g.fillRect(18 + xOffset, 60 + yOffset, 70, 3);
		g.fillRect(115 + xOffset, 60 + yOffset, 65, 3);
		g.fillRect(215 + xOffset, 60 + yOffset, 60, 3);
		g.fillRect(295 + xOffset, 60 + yOffset, 60, 3);
		g.drawString("Ranking", 20 + xOffset, 50 + yOffset);
		g.drawString("Player", 120 + xOffset, 50 + yOffset);
		g.drawString("Time", 220 + xOffset, 50 + yOffset);
		g.drawString("Score", 300 + xOffset, 50 + yOffset);
		g.setColor(Color.WHITE);
		for (int i = 0; i < 15; i++) {
			if (sec[i] < 10)
				output = "0" + sec[i];
			else
				output = sec[i] + "";
			if (score[i] > 0) {
				g.drawString("No. " + (i+1), 30 + xOffset, 96 + yOffset + 30 * i);
				g.drawString(player[i], 120 + xOffset, 96 + yOffset + 30 * i);
				g.drawString(min[i] + " : ", 220 + xOffset, 96 + yOffset + 30 * i);
				g.drawString(output, 245 + xOffset, 96 + yOffset + 30 * i);
				g.drawString(score[i] + "", 295 + xOffset, 96 + yOffset + 30 * i);
			} else {
				g.drawString(
						"---------          -------------         -----------      ------------",
						30 + xOffset, 105 + yOffset + 30 * i);
			}
		}
	}

	public void keyPressed(int k) {
		if(k==KeyEvent.VK_LEFT || k==KeyEvent.VK_RIGHT
				|| k==KeyEvent.VK_A || k==KeyEvent.VK_D){
			if(level[0]){
				level[0] = false;
				level[1] = true;
			}else if(level[1]){
				level[0] = true;
				level[1] = false;
			}
			updateSQL();
		}
	}

	public void keyReleased(int k) {}

	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		if(mouseX>=250&&mouseX<=384
				&&mouseY>=570&&mouseY<=599)
			onExit = true;
	}

	public void mousePressed(MouseEvent e) {
		if(onExit)
			gsm.states.push(new MenuState(gsm));
		
		if (level[0] && mouseX >= 310 && mouseX <= 360 
				&& mouseY >= 10 && mouseY <= 40) {
			level[0] = false;
			level[1] = true;
			updateSQL();
		}else if(level[1] && mouseX >= 40 && mouseX <= 90 
				&& mouseY >= 10 && mouseY <= 40){
			level[0] = true;
			level[1] = false;
			updateSQL();
		}
	}

	public void mouseReleased(MouseEvent e) {}

}
