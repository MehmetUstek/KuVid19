package ui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Main {
	private Frame frame = new Frame(Toolkit.getDefaultToolkit().getScreenSize(), "KuVid", this);
	public Main() {
		// TODO Auto-generated constructor stub
		frame.getBuildMode().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new BuildMode();
			}
		});
	}
	public static void main(String[] args) {
		
		new Main();
	}
}
