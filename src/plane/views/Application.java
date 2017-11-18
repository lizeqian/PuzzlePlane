package plane.views;

import plane.models.*;

import java.awt.CardLayout;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
 

/**
 * Create the Class Application.
 * The containing Frame for the application. This class is just a
 * GUI shell, and the real logic happens in the Board.
 * @author Zeqian Li
 */

public class Application extends JFrame {
	/**
	 * Serializable key
	 */
	private static final long serialVersionUID = 4590308406322961931L;
	
	/** The board, which contains the real logic. */
	Board board;

	/** This is a JPanel, pane.
	 *  JPanel is switched within JFrame. */
	public JPanel pane;
	
	/** This CardLayout allows the JPanel be switched within JFrame. */
	public CardLayout card;
    
    /** Create five JPanel. */
    public JPanel p_1, p_2, p_3, p_4, p_5;

	/** The height and width of the application view. */
	public int height = 700, width = 1000;
	
	/**
	 * Gets the pane.
	 *
	 * @return the pane
	 */
	public JPanel getPane() {
		return pane;
	}
	
	/**
	 * Instantiates a new application.
	 *
	 * @param b the board.
	 */
	public Application(Board b) {
		super ("Puzzle Plane");
		
		this.board = b;
	
		
		/**
		 * Create new CardLayout and JPanel.
		 * Add name to each pane.
		 *
		 * @param page the page
		 */	
		card = new CardLayout(5, 5);
		pane = new JPanel(card); 	
        p_1 = new FirstPPGui(this.board, this);
        p_2 = new SecondPPGui(this.board, this); 
        p_3 = new PuzzleSolvingView(this.board, this, this.width, this.height);
        p_4 = new PuzzleSolvedView(this.board, this);
        p_5 = new ViewShapesetPPGui(this.board, this);
        pane.add(p_1, "p1");
        pane.add(p_2, "p2");
        pane.add(p_3, "p3");
        pane.add(p_4, "p4");
        pane.add(p_5, "p5");
            

        this.getContentPane().add(pane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setSize(this.width, this.height);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	/**
	 * Jump page.
	 *
	 * @param page the page.
	 */
	public void jumpPage(String page) {
		card.show(pane, page);
	}
}