package PuzzlePlane.views;

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

import PuzzlePlane.models.*;

import PuzzlePlane.controllers.*;
import PuzzlePlane.controllers.actions.ShapeHorizontalFlipController;
import PuzzlePlane.controllers.actions.ShapeLeftRotateController;
import PuzzlePlane.controllers.actions.ShapeRightRotateController;
import PuzzlePlane.controllers.actions.ShapeVerticalFlipController;
import PuzzlePlane.controllers.windowJump.ExitPuzzleSolvingController;
import PuzzlePlane.controllers.windowJump.ViewShapesetController;

public class PuzzleSolvingView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5102883105475450390L;
	
	Board board;
	int palette_h;
	int palette_w;
	int solution_w;
	int solution_h;
	int buttonAreaHeight;
	// Current mouse listener
	MouseListener        activeListener;
	MouseMotionListener  activeMotionListener;
	
	
	public PuzzleSolvingView(Board b, Application p, int w, int h) {
		setLayout(null);		
		
		this.buttonAreaHeight = 300;
		this.palette_w = w;
		this.solution_w = w;
		this.palette_h = (int)(h*0.3);
		this.solution_h = h - palette_h;
		this.board = b;
		SolutionCheckController solutionCheckController = new SolutionCheckController(b, p);
		MoveShapePaletteSolutionController moveShapePaletteSolution = new MoveShapePaletteSolutionController(b, p, this, this.palette_w, this.palette_h, solutionCheckController);
		this.addMouseListener(moveShapePaletteSolution);
		this.addMouseMotionListener(moveShapePaletteSolution);
		
		ExitPuzzleSolvingController exitPuzzleSolving = new ExitPuzzleSolvingController(b, p);
		JButton button_next = new JButton("Exit");
		button_next.setBounds(w-100, h-80, 80, 30);
		button_next.addActionListener(exitPuzzleSolving);
		this.add(button_next);
		
		AbstractAction leftRotateControl = new ShapeLeftRotateController(b, this, solutionCheckController);
		JButton buttonLeftRotation = new JButton("L Rotate");
		buttonLeftRotation.setBounds(w-200, h-80, 90, 30);
		buttonLeftRotation.addActionListener(leftRotateControl);
		this.add(buttonLeftRotation);
		
		AbstractAction rightRotateControl = new ShapeRightRotateController(b, this, solutionCheckController);
		JButton buttonRightRotation = new JButton("R Rotate");
		buttonRightRotation.setBounds(w-300, h-80, 90, 30);
		buttonRightRotation.addActionListener(rightRotateControl);
		this.add(buttonRightRotation);
		
		AbstractAction hFlipControl = new ShapeHorizontalFlipController(b, this, solutionCheckController);
		JButton buttonHorizonFlipped = new JButton("H Flip");
		buttonHorizonFlipped.setBounds(w-400, h-80, 90, 30);
		buttonHorizonFlipped.addActionListener(hFlipControl);
		this.add(buttonHorizonFlipped);
		
		AbstractAction vFlipControl = new ShapeVerticalFlipController(b, this, solutionCheckController);
		JButton buttonVerticalFlipped = new JButton("V Flip");
		buttonVerticalFlipped.setBounds(w-500, h-80, 90, 30);
		buttonVerticalFlipped.addActionListener(vFlipControl);
		this.add(buttonVerticalFlipped);
		
		UndoController undoControl = new UndoController(b, this);
		JButton buttonUndo= new JButton("undo");
		buttonUndo.setBounds(w-600, h-80, 90, 30);
		buttonUndo.addActionListener(undoControl);
		this.add(buttonUndo);
		
		RedoController redoControl = new RedoController(b, this);
		JButton buttonRedo= new JButton("redo");
		buttonRedo.setBounds(w-700, h-80, 90, 30);
		buttonRedo.addActionListener(redoControl);
		this.add(buttonRedo);
		
		ViewShapesetController viewShapesetControl = new ViewShapesetController(p);
		JButton buttonViewShapeset = new JButton("view shapeset");
		buttonViewShapeset.setBounds(w-820, h-80, 120, 30);;
		buttonViewShapeset.addActionListener(viewShapesetControl);
		this.add(buttonViewShapeset);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
	    /*RenderingHints rh = new RenderingHints(
	             RenderingHints.KEY_ANTIALIASING,
	             RenderingHints.VALUE_ANTIALIAS_ON);
	    g2.setRenderingHints(rh);*/
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
