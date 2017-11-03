package PuzzlePlane.views;

import javax.swing.JPanel;

import PuzzlePlane.controllers.SelectShapesetController;
import PuzzlePlane.models.Board;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FirstPPGui extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5177975869801488954L;
	private static final String traditionalShapesetPath = "shapeset.txt";
	private static final String nonTraditionalShapesetPath = "shapeset.txt";
	/**
	 * Create the frame.
	 */
	public FirstPPGui(Board b, PuzzlePlaneGui p) {
		setLayout(null);
		
		JButton traditionalsetButton = new JButton("chooseShapeSetButton");
		traditionalsetButton.setIcon(new ImageIcon(FirstPPGui.class.getResource("/PuzzlePlane/resources/Screen Shot 2017-09-22 at 4.00.14 PM.png")));
		traditionalsetButton.setBounds(54, 157, 436, 440);
		
		SelectShapesetController selectShapesetController = new SelectShapesetController(p, b);
		selectShapesetController.setFilePath(FirstPPGui.traditionalShapesetPath);
		traditionalsetButton.addActionListener(selectShapesetController);
		add(traditionalsetButton);
		
		JButton nontraditionalsetButton = new JButton("chooseShapeSetButton");
		nontraditionalsetButton.setIcon(new ImageIcon(FirstPPGui.class.getResource("/PuzzlePlane/resources/Screen Shot 2017-09-22 at 4.10.55 PM.png")));
		nontraditionalsetButton.setBounds(519, 157, 447, 432);
		
		selectShapesetController = new SelectShapesetController(p, b);
		selectShapesetController.setFilePath(FirstPPGui.nonTraditionalShapesetPath);
		nontraditionalsetButton.addActionListener(selectShapesetController);
		
		add(nontraditionalsetButton);
		
		JLabel lblNewLabel = new JLabel("Choose a Shape Set");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(350, 78, 307, 46);
		add(lblNewLabel);
	}
}
