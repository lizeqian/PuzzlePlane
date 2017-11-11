package plane.views;
import plane.controllers.PuzzleStatusChecker;
import plane.models.*;

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

	public JPanel pane;
	public CardLayout card;
    public JPanel p_1, p_2, p_3, p_4, p_5;

	public int height = 700, width = 1000;
	
	public JPanel getPane() {
		return pane;
	}
	
	public Application(Board b) {
		super ("Puzzle Plane");
		
		this.board = b;
		
		card = new CardLayout(5, 5);
		pane = new JPanel(card); 	
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
            

        this.getContentPane().add(pane);
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