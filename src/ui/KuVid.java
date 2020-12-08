package ui;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import domain.Controller;
import domain.Saver;
import domain.atom.AlphaAtom;
import domain.atom.Atom;
import domain.atom.BetaAtom;
import domain.atom.GammaAtom;
import domain.atom.SigmaAtom;
import domain.gameState.Statistics;
import domain.utility.Point;

public class KuVid extends Canvas implements Runnable {
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 800;
	public final static int atomNumber= 100;
	public final static int L=FRAME_HEIGHT/10;
	public final static int diameter= L/10;
	Saver player;
	Statistics statistics;
	static Atom alpha;
	static Atom beta;
	static Atom sigma;
	static Atom gamma;
	static ArrayList<Atom> alphaList= new ArrayList<Atom>();
	static ArrayList<Atom> betaList= new ArrayList<Atom>();
	static ArrayList<Atom> sigmaList= new ArrayList<Atom>();
	static ArrayList<Atom> gammaList= new ArrayList<Atom>();
	static JFrame frame;
	static UIController uicontroller;
	private boolean running = false;
	Thread thread;
	static Controller controller;
	
//	public static void main(String []args ) throws IOException {
//		
////		frame= new JFrame("KuVid");
////		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT+L);
////		System.out.println(frame.getSize());
////		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////		frame.setLayout(null);
////		frame.setResizable(true);
////		KuVidGameplay gameplay= new KuVidGameplay(FRAME_WIDTH,FRAME_HEIGHT);
////		frame.setLayeredPane(gameplay);
////		frame.setVisible(true);
//		
//		
//		System.out.println("The game has started");
//	
//	}
	public KuVid() {
		uicontroller= new UIController();
		UIAtom atom = new UIAtom("sigma", diameter);
		
		uicontroller.addObject(atom);
		
	}
	
	public boolean isIn(Point p) {
		return (p.x <= frame.getWidth() && p.x >= 0 && p.y <= frame.getHeight() && p.y >= 0);
}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
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
	
	
}
