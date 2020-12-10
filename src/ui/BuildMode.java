package ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.Random;

import domain.Controller;
import domain.DatabaseController;
import domain.atom.AlphaAtom;
import domain.atom.Atom;
import domain.molecule.Molecule;
import domain.molecule.MoleculeFactory;



public class BuildMode extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public static int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
			HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private Thread thread;
	private boolean running = false;
	private Frame a = new Frame(Toolkit.getDefaultToolkit().getScreenSize(), "KuVid Build Mode", this);
	private UIController UIC = new UIController();
	private Controller GC = new Controller(UIC, a);
	private DatabaseController DC = new DatabaseController(GC, UIC);
	private BuildModeKeys bmKeys = new BuildModeKeys(GC, UIC);

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
		Graphics g = bs.getDrawGraphics();
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
		this.addKeyListener(bmKeys);
		this.addMouseListener(bmKeys);
		this.addMouseMotionListener(bmKeys);

		a.getSaveButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("SAVED");
				DC.saveGame("saves.ser");
			}
		});
		a.getLoadButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("LOADED");
				DC.loadGame("saves.ser");

			}
		});
		a.getQuitButton().addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// are you sure to go back sorucak
				a.dispose();
				thread.stop();
				running = false;
				new Main();
			}
		});

		a.getPauseButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});


	}

	public void addMolecules(Controller GC, UIController UIC) throws IOException {
		String s1 = a.getMoleculeCount().getText();
		System.out.println(s1);
		String s2 = a.getBetaCount().getText();
		System.out.println(s2);
		if (!s1.equals(null)) {

			int simpleCount = Integer.parseInt(s1);
			

			for (int i = 0; i < simpleCount; i++) {
				
				int x = new Random().nextInt(WIDTH - WIDTH / 50);
				int y = new Random().nextInt(HEIGHT / 2 + 80);
				Atom a = new AlphaAtom(x,y,0.5, 2, 50,"alpha");
				

				UIAtom a1 = new UIAtom("alpha",50,x,y);

				GC.addObject(a);
				UIC.addObject(a1);

			}
			
		}
		if (!s2.equals(null)) {

			int simpleCount = Integer.parseInt(s2);
			

			for (int i = 0; i < simpleCount; i++) {
				
				int x = new Random().nextInt(WIDTH - WIDTH / 50);
				int y = new Random().nextInt(HEIGHT / 2 + 80);
				Atom a = new AlphaAtom(x,y,0.5, 2, 50,"beta");
				

				UIAtom a1 = new UIAtom("beta",50,100,100);

				GC.addObject(a);
				UIC.addObject(a1);

			}
			
		}
	}

	public static void main(String[] args) {
		new BuildMode();
	}

}