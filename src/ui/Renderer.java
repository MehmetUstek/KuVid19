package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;


public class Renderer {

	public List<UIGameObject> objects = new LinkedList<UIGameObject>();
	int lives,score;
	boolean gameOver;
	public static double WIDTH= KuVid.WIDTH;
	public static double HEIGHT= KuVid.HEIGHT;
	
	public void render(Graphics2D g) {
		for (int i = 0; i < objects.size(); i++) {
			UIGameObject temp = (UIGameObject) objects.get(i);
			temp.render(g);
		}
		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman",Font.PLAIN,22));
		if(gameOver) {
			g.setFont(new Font("TimesRoman",Font.PLAIN,48));
			g.drawString("GAME OVER", (int) WIDTH/2 - 160,(int)  HEIGHT/2 - 24);
		}
	}

	public void addObject(UIGameObject obj) {
		this.objects.add(obj);
	}

	public void removeObject(UIGameObject obj) {
		this.objects.remove(obj);
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
	
	
	
}