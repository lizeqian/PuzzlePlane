package plane.views;

import javax.swing.JPanel;

import plane.config.FilePathConfig;
import plane.controllers.SelectShapesetController;
import plane.models.Board;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.SwingConstants;

/**
 * The Class FirstPPGui.
 */
public class FirstPPGui extends JPanel {

	/**
	 * Serializable key
	 */
	private static final long serialVersionUID = 5177975869801488954L;
	
	/**
	 * Create the panel view.
	 * @param b the board.
	 * @param p the application.
	 */
	public FirstPPGui(Board b, Application p) {
		setLayout(null);
		/**
		 * Set a button for selecting traditional shapeset.
		 */
		JButton traditionalsetButton = new JButton("chooseShapeSetButton");
		traditionalsetButton.setIcon(new ImageIcon(FilePathConfig.getShapesetIconPath("traditional")));
		traditionalsetButton.setBounds(54, 157, 446, 440);
		/**
		 * Call SelectShapesetController and add ActionListener
		 * to jump page and load the traditional puzzle sets.
		 */
		SelectShapesetController selectShapesetController = new SelectShapesetController(p, b, "traditional");
		traditionalsetButton.addActionListener(selectShapesetController);
		add(traditionalsetButton);
		/**
		 * Set a button for selecting non-traditional shapeset.
		 */
		JButton nontraditionalsetButton = new JButton("chooseShapeSetButton");
		nontraditionalsetButton.setIcon(new ImageIcon(FilePathConfig.getShapesetIconPath("nontraditional")));
		nontraditionalsetButton.setBounds(519, 157, 447, 432);
		/**
		 * Call SelectShapesetController and add ActionListener
		 * so that to jump page and load non-traditional puzzle sets.
		 */
		selectShapesetController = new SelectShapesetController(p, b, "nontraditional");
		nontraditionalsetButton.addActionListener(selectShapesetController);
		add(nontraditionalsetButton);
		/**
		 * Add a JLabel to show the title on the page.
		 */
		JLabel lblNewLabel = new JLabel("Choose a Shape Set");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(350, 78, 307, 46);
		add(lblNewLabel);
	}
}
