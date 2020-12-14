package ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.Random;

import domain.Controller;
import domain.atom.Atom;
import domain.molecule.Molecule;
import domain.molecule.MoleculeFactory;



public class BuildMode extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public static int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
			HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private Thread thread;
	private boolean running = false;
	private Frame window = new Frame(Toolkit.getDefaultToolkit().getScreenSize(), "KuVid Build Mode", this);
	private Renderer UIC = new Renderer();
	private Controller GC = new Controller(UIC, window);

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		g.setColor(new Color(238, 238, 238));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		UIC.render(g);
		g.dispose();
		bs.show();
	}

	public void update() {
		GC.update();
		
			try {
				addMolecules(GC, UIC);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			bmKeys.setBuild(false);
		


	}

	public void run() {
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

	public BuildMode() {

		window.getQuitButton().addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				window.dispose();
				thread.stop();
				running = false;
				new Main();
			}
		});


	}

	public void addMolecules(Controller GC, Renderer UIC) throws IOException {
		//
			
			
		}
	

	public static void main(String[] args) {
//		new BuildMode();
	}

}