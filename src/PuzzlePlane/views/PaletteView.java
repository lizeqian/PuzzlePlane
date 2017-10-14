package PuzzlePlane.views;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class PaletteView extends JPanel {

	/**
	 * Create the panel.
	 */
	public PaletteView() {
		setLayout(null);
		
		JLabel lblPalette = new JLabel("Palette");
		lblPalette.setBounds(147, 11, 46, 14);
		add(lblPalette);

	}
}
