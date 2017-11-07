package PuzzlePlane.views;

import javax.swing.JPanel;

import PuzzlePlane.config.FilePathConfig;
import PuzzlePlane.controllers.SelectShapesetController;
import PuzzlePlane.models.Board;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.SwingConstants;

public class FirstPPGui extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5177975869801488954L;

	/**
	 * Create the frame.
	 */
	public FirstPPGui(Board b, Applicatoin p) {
		setLayout(null);
		
		JButton traditionalsetButton = new JButton("chooseShapeSetButton");
		traditionalsetButton.setIcon(new ImageIcon(FirstPPGui.class.getResource(FilePathConfig.traditionalImgPath)));
		traditionalsetButton.setBounds(54, 157, 446, 440);
		
		Map<String, String> traditionalPath = new HashMap<>();
		traditionalPath.put("shapeset", FilePathConfig.traditionalShapesetPath);
		traditionalPath.put("puzzleFolder", FilePathConfig.traditionalPuzzleFolder);
		traditionalPath.put("shapesetImg", FilePathConfig.traditionalImgPath);
		traditionalPath.put("solutionFolder", FilePathConfig.traditionalSolutionFolder);
		
		SelectShapesetController selectShapesetController = new SelectShapesetController(p, b, traditionalPath);
		traditionalsetButton.addActionListener(selectShapesetController);
		add(traditionalsetButton);
		
		JButton nontraditionalsetButton = new JButton("chooseShapeSetButton");
		nontraditionalsetButton.setIcon(new ImageIcon(FirstPPGui.class.getResource(FilePathConfig.nontraditionalImgPath)));
		nontraditionalsetButton.setBounds(519, 157, 447, 432);
		
		Map<String, String> nontraditionalPath = new HashMap<>();
		nontraditionalPath.put("shapeset", FilePathConfig.nontraditionalShapesetPath);
		nontraditionalPath.put("puzzleFolder", FilePathConfig.nontraditionalPuzzleFolder);
		nontraditionalPath.put("shapesetImg", FilePathConfig.nontraditionalImgPath);
		nontraditionalPath.put("solutionFolder", FilePathConfig.nontraditionalPuzzleFolder);

		selectShapesetController = new SelectShapesetController(p, b, nontraditionalPath);
		nontraditionalsetButton.addActionListener(selectShapesetController);
		add(nontraditionalsetButton);
		
		JLabel lblNewLabel = new JLabel("Choose a Shape Set");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(350, 78, 307, 46);
		add(lblNewLabel);
	}
}
