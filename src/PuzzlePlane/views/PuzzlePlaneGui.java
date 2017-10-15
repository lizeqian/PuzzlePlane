package PuzzlePlane.views;
import PuzzlePlane.models.*;
import PuzzlePlane.controllers.*;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
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
	private JPanel p = null;	//Panel contain buttons
	private CardLayout card = null; // CardLayout manager
    private JButton button_1 = null; // pre JPanel
    private JButton button_2 = null; // next Jpanel
    private JButton first_b = null; // first Jpanel
    private JPanel p_1 = null, p_2 = null, p_3 = null, p_4 = null, p_5 = null; // 3 JPanel
    private int height = 900, width = 1100;
    
    private JButton testAddShape = null;

	
	public PuzzlePlaneGui(Board b) {
		super ("Puzzle Plane");
		
		this.board = b;
		
		
		card = new CardLayout(5, 5);//Creates a new card layout with the specified horizontal and vertical gaps.
		pane = new JPanel(card); 	//Set pane layout to cardlayout
		p = new JPanel();			//construct a button JPanel
		button_1 = new JButton("Pre");
		button_2 = new JButton("Next");	//Construct two buttons
		first_b = new JButton("Main");
		first_b.setMargin(new Insets(2,2,2,2));//set margin for buttons
		testAddShape = new JButton("AddShape"); //TODO Delete and Replace
        p.add(button_1);
        p.add(button_2);
        p.add(first_b);
        p_1 = new FirstPPGui();
        p_2 = new JPanel();//SecondPPGui();  //Please uncomment when this class is correctly implemented
        p_3 = new PuzzleSolvingView(b, this, this.width, this.height);
        p_4 = new JPanel();
        p_5 = new JPanel();
        p_1.add(new JLabel("JPanel_1"));
        p_2.add(new JLabel("JPanel_2"));
        p_2.add(testAddShape);
        p_4.add(new JLabel("JPanel_4"));
        p_5.add(new JLabel("JPanel_5"));
        pane.add(p_1, "p1");
        pane.add(p_2, "p2");
        pane.add(p_3, "p3");
        pane.add(p_4, "p4");
        pane.add(p_5, "p5");
        
        //TODO Test code, please remove
        AddShapeTest addShapeTest = new AddShapeTest(this, b.getPalette());
        testAddShape.addActionListener(addShapeTest);
        
        //These methods should be implemented in a controller
        button_1.addActionListener(new ActionListener(){ 		//action when a button clicked
            public void actionPerformed(ActionEvent e) {
                card.previous(pane);
            }
        });
        button_2.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e) {
                card.next(pane);
            }
        });
        first_b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //card.show(pane, "p1");
                jumpPage("p1");
            }
        });
        this.getContentPane().add(pane);	//add pane to this frame
        this.getContentPane().add(p, BorderLayout.SOUTH);	//add p to this frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setSize(this.width, this.height);
		this.setVisible(true);
	}
	
	public void jumpPage(String page) {
		card.show(pane, page);
	}
	
}