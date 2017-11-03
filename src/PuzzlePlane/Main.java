package PuzzlePlane;

import java.awt.event.*;

import javax.swing.*;
import PuzzlePlane.views.*;
import PuzzlePlane.controllers.*;
import PuzzlePlane.controllers.windowJump.ExitApplicationController;

public class Main {
	public static void main(String[] args) {
		PuzzlePlaneGui g = new PuzzlePlaneGui();
		g.addWindowListener (new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				new ExitApplicationController(g).process();
			}

		});

		// Tell app window that we will be responsible for closing application  
		g.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		g.setVisible(true);
	}
}