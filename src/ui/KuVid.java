package ui;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import domain.Controller;
import domain.DatabaseController;
import domain.atom.Atom;

import domain.gameState.Statistics;

public class KuVid extends Canvas implements Runnable {
	private boolean running = false;
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 800;
	public final static int atomNumber= 100;
	public final static int L=FRAME_HEIGHT/10;
	public final static int diameter= L/10;
	Statistics statistics;
	static Atom alpha;
	static Atom beta;
	static Atom sigma;
	static Atom gamma;
	private static KuVid game;
	static ArrayList<Atom> alphaList= new ArrayList<Atom>();
	static ArrayList<Atom> betaList= new ArrayList<Atom>();
	static ArrayList<Atom> sigmaList= new ArrayList<Atom>();
	private JLayeredPane maingui = new JLayeredPane();
	static ArrayList<Atom> gammaList= new ArrayList<Atom>();
	static JFrame frame;
	private Frame window = new Frame(Toolkit.getDefaultToolkit().getScreenSize(), "KuVid", this);
	static UIController uicontroller;
	
	private Thread thread;
	Controller controller;

	public KuVid() {
			
			uicontroller = window.controller;
			controller = window.GC;
			
			int diameter= 40;
			int x= WIDTH/2+diameter;
			int y = HEIGHT - 2*diameter;
			
//			for(UIGameObject object:uicontroller.objects) {
//				object.setBounds(object.getX(),object.getY(),object.getX()+object.getLength(),getY()+object.getLength());
//				maingui.add(object,new Integer(1));
//				System.out.println("refresh");
//			}
			maingui.setBounds(0 , 0  , WIDTH, HEIGHT);
			window.getLoadButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("LOADED");
//					for (UIGameObject object : uicontroller.objects) {
//						object.setBounds(object.getX(),object.getY(),object.getX()+object.getLength(),getY()+object.getLength());
//						
//						
//					}


				}
			});
			
		
	}
	
	public boolean isIn(int x, int y) {
		return (x <= frame.getWidth() && x >= 0 && y <= frame.getHeight() && y >= 0);
}

	public synchronized void start() {
		System.out.println("Started");
		thread = new Thread(this);
		running = true;
		thread.start();
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				delta--;
			}
			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void render() {
		// TODO Auto-generated method stub
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.cyan);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		uicontroller.render(g);
		g.dispose();
		bs.show();
	}


	public void update() {     
		controller.update();
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static KuVid getGame() {
		return game;
	}
	public static void setGame(KuVid game) {
		KuVid.game = game;
	}
	public static void main(String[] args) {
		game = new KuVid();
	}
	
}
