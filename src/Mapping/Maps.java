package Mapping;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import Entities.Block;

public class Maps {

	private String path;

	private int width, height;
	public static Block[][] blocks;

	public Maps(String loadPath) {
		path = loadPath;
		loadMap();
	}

	public void draw(Graphics g) {
		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks[0].length; j++) {
				blocks[i][j].draw(g);
			}
		}
	}

	private void loadMap() {
		InputStream is = this.getClass().getResourceAsStream(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		try {
			width = Integer.parseInt(br.readLine());
			height = Integer.parseInt(br.readLine());

			blocks = new Block[height][width];
			String[] tokens;
			for (int y = 0; y < height; y++) {
				tokens = br.readLine().split(" ");
				for (int x = 0; x < width; x++) {
					blocks[y][x] = new Block(24 + x * Block.blockWidth, 40 + y
							* (Block.blockHeight + 4),
							Integer.parseInt(tokens[x]));
				}
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isWin(){
		for(int i=0;i<blocks.length;i++)
			for(int j=0;j<blocks[i].length;j++)
				if(blocks[i][j].getID()!=0)
					return false;
		return true;
	}
}
