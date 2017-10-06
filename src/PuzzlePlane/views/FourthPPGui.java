package PuzzlePlane.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;

public class FourthPPGui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FourthPPGui frame = new FourthPPGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FourthPPGui() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\tu\\Screen Shot 2017-09-22 at 4.00.14 PM.png"));
		setTitle("Puzzle Plane");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 602);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(FourthPPGui.class.getResource("/PuzzlePlane/resources/Screen Shot 2017-09-22 at 4.00.14 PM.png")));
		lblNewLabel.setBounds(60, 23, 520, 475);
		contentPane.add(lblNewLabel);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(484, 517, 149, 25);
		contentPane.add(btnReturn);
	}

}
