package PuzzlePlane.views;
import PuzzlePlane.controllers.PuzzleStatusChecker;
import PuzzlePlane.models.*;

import java.awt.CardLayout;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
 

//This JFrame is the main Frame of application. Use JPanels as content, and switch JPanels for each different view
public class Application extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4590308406322961931L;
	
	Board board;
	
	public String shapesetName;
	public String puzzleName;
	public Set<String> solvedPuzzleNames;

	public JPanel pane = null; //Main panel be set to cardlayout
	public CardLayout card = null; // CardLayout manager
    public JPanel p_1 = null, p_2 = null, p_3 = null, p_4 = null, p_5 = null; // 3 JPanel

	public int height = 700, width = 1000;
	
	public Application() {
		super ("Puzzle Plane");
		
		this.board = new Board();
		//StatusFileOperator statusFileOperator = new StatusFileOperator ();
		
		card = new CardLayout(5, 5);//Creates a new card layout with the specified horizontal and vertical gaps.
		pane = new JPanel(card); 	//Set pane layout to cardlayout
        p_1 = new FirstPPGui(this.board, this);
        p_2 = new SecondPPGui(this.board, this); 
        p_3 = new PuzzleSolvingView(this.board, this, this.width, this.height);
        p_4 = new PuzzleSolvedView(this.board, this);
        p_5 = new ViewShapesetPPGui(this);
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
	
	public String getPuzzleName() {
		return puzzleName;
	}

	public void setPuzzleName(String puzzleName) {
		this.puzzleName = puzzleName;
	}
	
	public String getShapesetName() {
		return shapesetName;
	}

	public void setShapesetName(String shapesetName) {
		this.shapesetName = shapesetName;
		this.solvedPuzzleNames = (new PuzzleStatusChecker(this.board, this)).getSolvedPuzzleNames();
		((SecondPPGui)p_2).reset();
		((ViewShapesetPPGui)p_5).reset();
	}
	
	public Set<String> getSolvedPuzzleNames() {
		return solvedPuzzleNames;
	}
	
	public void setSolvedPuzzleNames(Set<String> solvedPuzzleNames) {
		this.solvedPuzzleNames = solvedPuzzleNames;
		((SecondPPGui)p_2).reset();
	}
}