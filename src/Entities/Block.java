package Entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import Media.Image;

public class Block extends Rectangle {

	private static final long serialVersionUID = 1L;
	
	private int id;
	public static final int blockWidth = 25, blockHeight = 8;

	public Block(int x, int y, int id) {
		setBounds(x, y, x + 15, y + 5);
		this.id = id;
	}

	public void tick() {}

	public void draw(Graphics g) {
		if (id == 1)
			g.drawImage(Image.blocks[0], x, y, blockWidth, blockHeight, null);
		else if (id == 2)
			g.drawImage(Image.blocks[1], x, y, blockWidth, blockHeight, null);
		else if (id == 3)
			g.drawImage(Image.blocks[2], x, y, blockWidth, blockHeight, null);
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getID() {
		return id;
	}
}