package PuzzlePlane;

import java.awt.event.*;

import javax.swing.*;
//TODO import PuzzlePlane.models.*;
import PuzzlePlane.views.*;
//TODO import PuzzlePlane.controllers.*;

public class Main {
	public static void main(String[] args) {
		Board b = new Board();

		PuzzlePlaneGui g = new PuzzlePlaneGui(b);
		g.addWindowListener (new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				new ExitApplicationController(app).process();
			}

		});

		// Tell app window that we will be responsible for closing application  
		g.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		g.setVisible(true);
	}
}