package plane.views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import plane.controllers.*;
import plane.controllers.actions.ShapeHorizontalFlipController;
import plane.controllers.actions.ShapeLeftRotateController;
import plane.controllers.actions.ShapeRightRotateController;
import plane.controllers.actions.ShapeVerticalFlipController;
import plane.controllers.windowJump.ExitPuzzleSolvingController;
import plane.controllers.windowJump.ViewShapesetController;
import plane.models.*;

/**
 * The Class PuzzleSolvingView.
 */
public class PuzzleSolvingView extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5102883105475450390L;
	
	/** The board. */
	Board board;
	
	/** The palette height. */
	int palette_h;
	
	/** The palette width. */
	int palette_w;
	
	/** The width of the solution plate. */
	int solution_w;
	
	/** The height of the solution plate. */
	int solution_h;
	
	/** The height of button area . */
	int buttonAreaHeight;
	
	/** The active listener. */
	// Current mouse listener
	MouseListener        activeListener;
	
	/** The active motion listener. */
	MouseMotionListener  activeMotionListener;
	
	
	/**
	 * Instantiates a new puzzle solving view.
	 *
	 * @param b the board
	 * @param p the pane
	 * @param w the width
	 * @param h the height
	 */
	public PuzzleSolvingView(Board b, Application p, int w, int h) {
		setLayout(null);		
		
		this.buttonAreaHeight = 300;
		this.palette_w = w;
		this.solution_w = w;
		this.palette_h = (int)(h*0.3);
		this.solution_h = h - palette_h;
		this.board = b;
		/**
		 * Call SolutionCheckController, MoveShapePalletteSolutionController
		 * and add ActionListener
		 * to check whether the puzzle is solved whenever the mouse is released.
		 */
		SolutionCheckController solutionCheckController = new SolutionCheckController(b, p);
		MoveShapePaletteSolutionController moveShapePaletteSolution = new MoveShapePaletteSolutionController(b, p, this, this.palette_w, this.palette_h, solutionCheckController);
		this.addMouseListener(moveShapePaletteSolution);
		this.addMouseMotionListener(moveShapePaletteSolution);
		
		/** Add button to exit and call ExitPuzzleSolvingController to jump page. */
		ExitPuzzleSolvingController exitPuzzleSolving = new ExitPuzzleSolvingController(b, p);
		JButton button_next = new JButton("Exit");
		button_next.setBounds(w-100, h-80, 80, 30);
		button_next.addActionListener(exitPuzzleSolving);
		this.add(button_next);
		
		/** Add button for left rotate and call AbstractAction leftRotateControl */
		AbstractAction leftRotateControl = new ShapeLeftRotateController(b, this, solutionCheckController);
		JButton buttonLeftRotation = new JButton("L Rotate");
		buttonLeftRotation.setBounds(w-200, h-80, 90, 30);
		buttonLeftRotation.addActionListener(leftRotateControl);
		this.add(buttonLeftRotation);
		
		/** Add button for right rotate and call AbstractAction rightRotateControl */
		AbstractAction rightRotateControl = new ShapeRightRotateController(b, this, solutionCheckController);
		JButton buttonRightRotation = new JButton("R Rotate");
		buttonRightRotation.setBounds(w-300, h-80, 90, 30);
		buttonRightRotation.addActionListener(rightRotateControl);
		this.add(buttonRightRotation);
		
		/** Add button for horizontal flip and call AbstractAction hFlipControl */
		AbstractAction hFlipControl = new ShapeHorizontalFlipController(b, this, solutionCheckController);
		JButton buttonHorizonFlipped = new JButton("H Flip");
		buttonHorizonFlipped.setBounds(w-400, h-80, 90, 30);
		buttonHorizonFlipped.addActionListener(hFlipControl);
		this.add(buttonHorizonFlipped);
		
		/** Add button for vertical flip and call AbstractAction vFlipControl */
		AbstractAction vFlipControl = new ShapeVerticalFlipController(b, this, solutionCheckController);
		JButton buttonVerticalFlipped = new JButton("V Flip");
		buttonVerticalFlipped.setBounds(w-500, h-80, 90, 30);
		buttonVerticalFlipped.addActionListener(vFlipControl);
		this.add(buttonVerticalFlipped);
		
		/** Add button for undo and call UndoController undoControl */
		UndoController undoControl = new UndoController(b, this);
		JButton buttonUndo= new JButton("undo");
		buttonUndo.setBounds(w-600, h-80, 90, 30);
		buttonUndo.addActionListener(undoControl);
		this.add(buttonUndo);
		
		/** Add button for redo and call RedoController redoControl */
		RedoController redoControl = new RedoController(b, this);
		JButton buttonRedo= new JButton("redo");
		buttonRedo.setBounds(w-700, h-80, 90, 30);
		buttonRedo.addActionListener(redoControl);
		this.add(buttonRedo);
		
		/**
		 * Add button for reset and call SolutionResetController resetControl 
		 * All the shapes that in the solution plate will be return to palette
		 */
		SolutionResetController resetControl = new SolutionResetController(b, p, this);
		JButton buttonReset= new JButton("reset");
		buttonReset.setBounds(w-800, h-80, 90, 30);
		buttonReset.addActionListener(resetControl);
		this.add(buttonReset);
		
		/**
		 * Add button for viewing current shapeset and call ViewShapesetController viewShapesetControl 
		 * The current shapeset will be displayed when the button is pressed.
		 */
		ViewShapesetController viewShapesetControl = new ViewShapesetController(p);
		JButton buttonViewShapeset = new JButton("view shapeset");
		buttonViewShapeset.setBounds(w-920, h-80, 120, 30);;
		buttonViewShapeset.addActionListener(viewShapesetControl);
		this.add(buttonViewShapeset);
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.drawLine(0, this.palette_h, this.palette_w, this.palette_h);
		
		List<PlacedShape> puzzleShape = this.board.getPuzzle().getPuzzleShape();
		g2.setColor(Color.GRAY);
		for (PlacedShape shape : puzzleShape) {
			g2.fillPolygon(shape.getOriginalPolygon());
		}
		
		for (PlacedShape shape : this.board.getShapes()) {
			Polygon p = shape.getChangedPolygon();
			g2.setColor(shape.getColor());
			g2.fillPolygon(p);
			
			if (shape.isSelected()) {
				g2.setColor(Color.BLACK);
				g2.drawPolygon(p);
			}
		}
	}
	
}
