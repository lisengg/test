package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;
import inputs.keyBoardInputs;
import inputs.mouseInputs;

public class GamePanel extends JPanel {

	private mouseInputs mouseinputs;
	private float xDelta = 100, yDelta = 100;
	private float xDir = 1f, yDir = 1f;
	private int frames = 0;
	private long lastCheck = 0;
	private Color color = new Color(122,24,89);
	private Random random;
	public GamePanel() {
		random = new Random();
		addKeyListener(new keyBoardInputs(this));
		setPanelSize();
		mouseinputs = new mouseInputs(this);
		addMouseListener(mouseinputs);
		addMouseMotionListener(mouseinputs);
	}

	private void setPanelSize() {
		
		
	}

	public void changeXDelta(int value) {
		this.xDelta += value;
		repaint();
	}

	public void changeYDelta(int value) {
		this.yDelta += value;
		repaint();
	}

	public void RectPosition(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		updateRectangle();
		g.setColor(color);
		g.fillRect((int) xDelta, (int) yDelta, 200, 50);
		
	}

	private void updateRectangle() {
		xDelta += xDir;
		if (xDelta > 400 || xDelta < 0) {
			xDir *= -1;
			color = getRndColor();
		}

		yDelta += yDir;
		if (yDelta > 400 || yDelta < 0) {
			yDir *= -1;
			color = getRndColor();
		}
	}

	private Color getRndColor() {
		int r = random.nextInt(255);
		int g = random.nextInt(255);
		int b = random.nextInt(255);
		return new Color(r,g,b);
	}
}
