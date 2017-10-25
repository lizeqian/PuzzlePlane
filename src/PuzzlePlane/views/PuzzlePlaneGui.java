package PuzzlePlane.views;
import PuzzlePlane.models.*;
import PuzzlePlane.controllers.*;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
 

//This JFrame is the main Frame of application. Use JPanels as content, and switch JPanels for each different view
public class PuzzlePlaneGui extends JFrame {
	Board board;
	private JPanel pane = null; //Main panel be set to cardlayout
	private CardLayout card = null; // CardLayout manager
    private JPanel p_1 = null, p_2 = null, p_3 = null, p_4 = null, p_5 = null; // 3 JPanel
    private int height = 700, width = 1000;
	
	public PuzzlePlaneGui(Board b) {
		super ("Puzzle Plane");
		
		this.board = b;
		
		
		card = new CardLayout(5, 5);//Creates a new card layout with the specified horizontal and vertical gaps.
		pane = new JPanel(card); 	//Set pane layout to cardlayout
        p_1 = new FirstPPGui(b, this);
        p_2 = new SecondPPGui(b, this);  //Please uncomment when this class is correctly implemented
        p_3 = new PuzzleSolvingView(b, this, this.width, this.height);
        p_4 = new JPanel();
        p_5 = new JPanel();
        pane.add(p_1, "p1");
        pane.add(p_2, "p2");
        pane.add(p_3, "p3");
        pane.add(p_4, "p4");
        pane.add(p_5, "p5");
            

        this.getContentPane().add(pane);	//add pane to this frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setSize(this.width, this.height);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void jumpPage(String page) {
		card.show(pane, page);
	}
	
}