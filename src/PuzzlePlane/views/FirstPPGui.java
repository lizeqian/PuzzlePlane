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
	public FirstPPGui(Board b, Application p) {
		setLayout(null);
		
		JButton traditionalsetButton = new JButton("chooseShapeSetButton");
		traditionalsetButton.setIcon(new ImageIcon(FirstPPGui.class.getResource(FilePathConfig.getShapesetIconPath("traditional"))));
		traditionalsetButton.setBounds(54, 157, 446, 440);
		
		SelectShapesetController selectShapesetController = new SelectShapesetController(p, b, "traditional");
		traditionalsetButton.addActionListener(selectShapesetController);
		add(traditionalsetButton);
		
		JButton nontraditionalsetButton = new JButton("chooseShapeSetButton");
		nontraditionalsetButton.setIcon(new ImageIcon(FirstPPGui.class.getResource("nontraditional")));
		nontraditionalsetButton.setBounds(519, 157, 447, 432);
		

		selectShapesetController = new SelectShapesetController(p, b, FilePathConfig.getShapesetIconPath("nontraditional"));
		nontraditionalsetButton.addActionListener(selectShapesetController);
		add(nontraditionalsetButton);
		
		JLabel lblNewLabel = new JLabel("Choose a Shape Set");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(350, 78, 307, 46);
		add(lblNewLabel);
	}
}
