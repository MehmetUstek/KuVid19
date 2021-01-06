package ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Random;

import domain.Controller;
import domain.GameObject;
import domain.Save;
import domain.SaveLoadAdapter;
import domain.atom.Atom;
import domain.molecule.Molecule;
import domain.molecule.MoleculeFactory;
import domain.powerup.Powerup;
import domain.powerup.PowerupFactory;
import domain.shooter.AtomShooter;
import ui.molecule.UIMolecule;



/**
 * @author MehmetUstek
 *
 */
public class BuildMode extends Canvas implements Runnable {
	/**
	 * OVERVIEW: This class is a UI class that enables user to specify game object quantities, the speed and username.
	 */
	private static final long serialVersionUID = 1L;
	public static int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()-200,
			HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private Thread thread;
	private boolean running = false;
	private Frame window = new Frame(Toolkit.getDefaultToolkit().getScreenSize(), "KuVid Build Mode", this);
	private Renderer renderer = new Renderer();
	private Controller controller = new Controller(renderer, window);
	public static final double L= HEIGHT/10;
	public static final double diameter = L/10;
	public double speed = 20;
	Random random = new Random();
	boolean moleculesAdded= false;
	private String username= "mehmet";
	ArrayList<GameObject> list = new ArrayList<GameObject>();
	ArrayList<GameObject> pulist = new ArrayList<GameObject>();
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
		/**
		 * @modifies the ui objects's visibility in the frame
		 * @effects display every element which is added to the UI, using Renderer's render method.
		 */
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
		/**
		 * @effects update the UI objects' specifics after every specified time period.
		 */
		controller.update();
		
	}

	public void run() {
		/**
		 * @effects run the thread every second.
		 */
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
//		int frames = 0;
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
//			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
//				System.out.println("FPS: " + frames);
//				frames = 0;
			}
		}
		stop();
	}

	public BuildMode() {
		Atom atom = new Atom("alpha");
		atom.setDiameter(100);
		controller.addObject(atom);
		controller.addObject(new AtomShooter("shooter"));
		UIAtom uiatom = new UIAtom("alpha");
		uiatom.setDiameter(1);
		renderer.addObject(uiatom);
		renderer.addObject(new UIShooter("shooter",1,1));
		
		
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
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!moleculesAdded) {
					addMoleculesAndPowerups(controller, renderer);
				}
				setLengthL();
				getDifficulty(controller);
				addAtoms(controller);
				setUsername();
				SaveLoadAdapter save= new SaveLoadAdapter(new Save(username,controller,list,getTime()));
//				System.out.println(list);
				save.saveGame();
				System.out.println(username);
				
			}
		});
		start();
	}
	public void setLengthL() {
		controller.setLengthL(Integer.parseInt(window.getLengthL().getText()));
		System.out.println(controller.getLengthL());
	}
	public void setUsername() {
		this.username= window.getUsername().getText();
	}
	public void addShields(Controller controller) {
		/**
		 * @requires a valid and initialized controller object which has at least 2 objects
		 * that has to be shootingObject and shooter.
		 * @modifies the building mode controller's shield quantities.
		 * @effects updates the shield quantities which is specified by the player in building mode.
		 */
		String s1 = window.getEtaCount().getText();
		String s2 = window.getLotaCount().getText();
		String s3 = window.getThetaCount().getText();
		String s4 = window.getZetaCount().getText();
		controller.setEtaCount(Integer.parseInt(s1));
		controller.setLotaCount(Integer.parseInt(s2));
		controller.setThetaCount(Integer.parseInt(s3));
		controller.setZetaCount(Integer.parseInt(s4));
	}
	public int getTime() {
		String s1= window.getGameTime().getText();
		return Integer.parseInt(s1);
	}
	public void getDifficulty(Controller controller) {
		/**
		 * @requires a valid and initialized controller object which has at least 2 objects
		 * that has to be shootingObject and shooter.
		 * @modifies the building mode controller's game speed.
		 * @effects updates the game speed according to choice that is specified by the player.
		 * There is three choices. Easy, Medium and Hard.
		 */
		if(window.getbGroup().getSelection().getActionCommand().equals("easy")) {
			System.out.println("Object will fall in 1 second span");
			controller.setSpeed(10);
		}
		else if(window.getbGroup().getSelection().getActionCommand().equals("medium")) {
			System.out.println("Object will fall in 2/3 second span");
			controller.setSpeed(15);
		}
		else {
			System.out.println("Object will fall in 1/2 second span");
			controller.setSpeed(20);
		}
		
	}
	public void addAtoms(Controller controller) {
		/**
		 * @requires a valid and initialized controller object which has at least 2 objects
		 * that has to be shootingObject and shooter.
		 * @modifies the building mode controller's atom quantities.
		 * @effects updates the atom quantities according to number that is specified by the player in building mode.
		 */
		String s1 = window.getAlphaAtomCount().getText();
		String s2 = window.getBetaAtomCount().getText();
		String s3 = window.getSigmaAtomCount().getText();
		String s4 = window.getGammaAtomCount().getText();
		controller.setAlphaCount(Integer.parseInt(s1));
		controller.setBetaCount(Integer.parseInt(s2));
		controller.setSigmaCount(Integer.parseInt(s3));
		controller.setGammaCount(Integer.parseInt(s4));
	}
	public void addPUs(Controller controller) {
		/**
		 * @requires a valid and initialized controller object which has at least 2 objects
		 * that has to be shootingObject and shooter.
		 * @modifies the current controller's powerup quantities.
		 * @effects updates the powerup quantities according to number that is specified by the player in build mode.
		 */
		String s1 = window.getAlphaAtomCount().getText();
		String s2 = window.getBetaAtomCount().getText();
		String s3 = window.getSigmaAtomCount().getText();
		String s4 = window.getGammaAtomCount().getText();
		controller.setAlphaCount(Integer.parseInt(s1));
		controller.setBetaCount(Integer.parseInt(s2));
		controller.setSigmaCount(Integer.parseInt(s3));
		controller.setGammaCount(Integer.parseInt(s4));
	}
	public void addMoleculesAndPowerups(Controller controller, Renderer renderer) {
		/**
		 * @requires a valid and initialized controller object which has at least 2 objects
		 * that has to be shootingObject and shooter. Also a valid and initialized Renderer object which holds
		 * every UI element which corresponds to each domain element.
		 * @modifies the current controller's game objects list and renderer's UI game objects list.
		 * @effects add the new molecule or powerup objects according to their specified number in build mode.
		 * Get the number from window's corresponding object and add that much of that game object to the controller.
		 * The positions are randomly distributed, however it is guaranteed that no two objects will intersect.
		 */
		String s1 = window.getAlphaMoleculeCount().getText();
		String s2 = window.getBetaMoleculeCount().getText();
		String s3 = window.getSigmaMoleculeCount().getText();
		String s4 = window.getGammaMoleculeCount().getText();
		String s5 = window.getPuCount().getText();
		
		ArrayList<String> nameList = new ArrayList<String>();
		nameList.add("AlphaMolecule");
		nameList.add("BetaMolecule");
		nameList.add("SigmaMolecule");
		nameList.add("GammaMolecule");
		ArrayList<Rectangle2D> positionList = new ArrayList<Rectangle2D>();
		for (int i=0;i<Integer.parseInt(s1);i++) {
			Molecule molecule = MoleculeFactory.getMolecule("AlphaMolecule");
			double x= random.nextInt( WIDTH-(int) molecule.getWidth());
			double y= random.nextInt(HEIGHT)-HEIGHT;
			Rectangle2D rect = new Rectangle2D.Double(x,y,molecule.getWidth(),molecule.getHeight());
			
			for (Rectangle2D rectangle: positionList) {
				if(rectangle.intersects(rect) || rect.intersects(rectangle)) {
					x= random.nextInt( WIDTH-(int) molecule.getWidth());
					y= random.nextInt(HEIGHT/8);
					rect.setRect(x, y, molecule.getWidth(), molecule.getHeight());
				}
			}
			positionList.add(rect);
			molecule.setX(x);
			molecule.setY(y);
			controller.addObject(molecule);
			UIMolecule uimolecule = UIMoleculeFactory.getMolecule("AlphaMolecule");
			renderer.objects.add(uimolecule);
			list.add(molecule);
			
		}
		for (int i=0;i<Integer.parseInt(s2);i++) {
			Molecule molecule = MoleculeFactory.getMolecule("BetaMolecule");
			double x= random.nextInt( WIDTH-(int) molecule.getWidth());
			double y= random.nextInt(HEIGHT)-HEIGHT;
			Rectangle2D rect = new Rectangle2D.Double(x,y,molecule.getWidth(),molecule.getHeight());
			
			for (Rectangle2D rectangle: positionList) {
				if(rectangle.intersects(rect) || rect.intersects(rectangle)) {
					x= random.nextInt( WIDTH-(int) molecule.getWidth());
					y= random.nextInt(HEIGHT/8);
					rect.setRect(x, y, molecule.getWidth(), molecule.getHeight());
				}
			}
			positionList.add(rect);
			molecule.setX(x);
			molecule.setY(y);
			controller.addObject(molecule);
			UIMolecule uimolecule = UIMoleculeFactory.getMolecule("BetaMolecule");
			renderer.objects.add(uimolecule);
			list.add(molecule);
		}
		for (int i=0;i<Integer.parseInt(s3);i++) {
			Molecule molecule = MoleculeFactory.getMolecule("SigmaMolecule");
			double x= random.nextInt( WIDTH-(int) molecule.getWidth());
			double y= random.nextInt(HEIGHT)-HEIGHT;
			Rectangle2D rect = new Rectangle2D.Double(x,y,molecule.getWidth(),molecule.getHeight());
			
			for (Rectangle2D rectangle: positionList) {
				if(rectangle.intersects(rect) || rect.intersects(rectangle)) {
					x= random.nextInt( WIDTH-(int) molecule.getWidth());
					y= random.nextInt(HEIGHT/8);
					rect.setRect(x, y, molecule.getWidth(), molecule.getHeight());
				}
			}
			positionList.add(rect);
			molecule.setX(x);
			molecule.setY(y);
			controller.addObject(molecule);
			UIMolecule uimolecule = UIMoleculeFactory.getMolecule("SigmaMolecule");
			renderer.objects.add(uimolecule);
			list.add(molecule);
		}
		for (int i=0;i<Integer.parseInt(s4);i++) {
			Molecule molecule = MoleculeFactory.getMolecule("GammaMolecule");
			double x= random.nextInt( WIDTH-(int) molecule.getWidth());
			double y= random.nextInt(HEIGHT)-HEIGHT;
			Rectangle2D rect = new Rectangle2D.Double(x,y,molecule.getWidth(),molecule.getHeight());
			
			for (Rectangle2D rectangle: positionList) {
				if(rectangle.intersects(rect) || rect.intersects(rectangle)) {
					x= random.nextInt( WIDTH-(int) molecule.getWidth());
					y= random.nextInt(HEIGHT/8);
					rect.setRect(x, y, molecule.getWidth(), molecule.getHeight());
				}
			}
			positionList.add(rect);
			molecule.setX(x);
			molecule.setY(y);
			controller.addObject(molecule);
			UIMolecule uimolecule = UIMoleculeFactory.getMolecule("GammaMolecule");
			renderer.objects.add(uimolecule);
			list.add(molecule);
		}
		for (int i=0;i<Integer.parseInt(s5);i++) {
			Powerup pu = PowerupFactory.getPU();
			pu.setHeight(diameter*2);
			pu.setWidth(diameter*2);
			pu.setRotationAngle(0);
			double x= random.nextInt( WIDTH-(int) pu.getWidth());
//			System.out.println(pu.getWidth());
			double y= random.nextInt(HEIGHT)-HEIGHT-200;
			Rectangle2D rect = new Rectangle2D.Double(x,y,pu.getWidth(),pu.getHeight());
			
			for (Rectangle2D rectangle: positionList) {
				if(rectangle.intersects(rect) || rect.intersects(rectangle)) {
					x= random.nextInt( WIDTH-(int) pu.getWidth());
					y= random.nextInt(HEIGHT/8);
					rect.setRect(x, y, pu.getWidth(), pu.getHeight());
				}
			}
			positionList.add(rect);
			pu.setX(x);
			pu.setY(y);
			controller.addObject(pu);
			UIPowerup uiPu = new UIPowerup(pu.getType());
			renderer.objects.add(uiPu);
			list.add(pu);
		}
		moleculesAdded=true;
	}
	

//	public static void main(String[] args) {
////		new BuildMode();
//	}

}