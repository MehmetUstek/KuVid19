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
import java.util.ArrayList;
import java.util.Random;

import domain.Controller;
import domain.atom.Atom;
import domain.molecule.Molecule;
import domain.molecule.MoleculeFactory;
import domain.shooter.AtomShooter;
import ui.molecule.UIMolecule;



public class BuildMode extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public static int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
			HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private Thread thread;
	private boolean running = false;
	private Frame window = new Frame(Toolkit.getDefaultToolkit().getScreenSize(), "KuVid Build Mode", this);
	private Renderer renderer = new Renderer();
	private Controller controller = new Controller(renderer, window);
	public static final double L= HEIGHT/10;
	Random random = new Random();
	boolean moleculesAdded= false;
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
		renderer.render(g);
		g.dispose();
		bs.show();
	}

	public void update() {
		controller.update();
		if(!moleculesAdded) {
			addMolecules(controller, renderer);
		}
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
		controller.addObject(new Atom("alpha"));
		controller.addObject(new AtomShooter("shooter"));
		renderer.addObject(new UIAtom("alpha"));
		renderer.addObject(new UIShooter("shooter",L,L/2));
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
		window.getApplyButton().addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});


	}

	public void addMolecules(Controller controller, Renderer renderer) {
		String s1 = window.getBetaCount().getText();
		String s2 = window.getMoleculeCount().getText();
		String s3 = window.getSigmaCount().getText();
		String s4 = window.getGammaCount().getText();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> nameList = new ArrayList<String>();
		nameList.add("AlphaMolecule");
		nameList.add("BetaMolecule");
		nameList.add("SigmaMolecule");
		nameList.add("GammaMolecule");
		list.add(s1);
		list.add(s2);
		for (int i=0;i<Integer.parseInt(s1);i++) {
			Molecule molecule = MoleculeFactory.getMolecule("AlphaMolecule");
			molecule.setX(random.nextInt( WIDTH-(int) molecule.getWidth()));
			molecule.setY(random.nextInt(HEIGHT/8));
			controller.addObject(molecule);
			UIMolecule uimolecule = UIMoleculeFactory.getMolecule("AlphaMolecule");
			renderer.objects.add(uimolecule);
		}
		for (int i=0;i<Integer.parseInt(s2);i++) {
			Molecule molecule = MoleculeFactory.getMolecule("BetaMolecule");
			molecule.setX(random.nextInt(WIDTH));
			molecule.setY(random.nextInt(HEIGHT/8));
			controller.addObject(molecule);
			UIMolecule uimolecule = UIMoleculeFactory.getMolecule("BetaMolecule");
			renderer.objects.add(uimolecule);
		}
		for (int i=0;i<Integer.parseInt(s3);i++) {
			Molecule molecule = MoleculeFactory.getMolecule("SigmaMolecule");
			molecule.setX(random.nextInt(WIDTH));
			molecule.setY(random.nextInt(HEIGHT/8));
			controller.addObject(molecule);
			UIMolecule uimolecule = UIMoleculeFactory.getMolecule("SigmaMolecule");
			renderer.objects.add(uimolecule);
		}
		for (int i=0;i<Integer.parseInt(s4);i++) {
			Molecule molecule = MoleculeFactory.getMolecule("GammaMolecule");
			molecule.setX(random.nextInt(WIDTH));
			molecule.setY(random.nextInt(HEIGHT/8));
			controller.addObject(molecule);
			UIMolecule uimolecule = UIMoleculeFactory.getMolecule("GammaMolecule");
			renderer.objects.add(uimolecule);
		}
		
		moleculesAdded=true;
	}
	

	public static void main(String[] args) {
//		new BuildMode();
	}

}