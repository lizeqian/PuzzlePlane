package PuzzlePlane.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;

public class FirstPPGui extends JFrame {

	private JPanel contentPane;
	private JTextField txtChooseAShape;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstPPGui frame = new FirstPPGui();
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
	public FirstPPGui() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\tu\\Screen Shot 2017-09-22 at 4.00.14 PM.png"));
		setTitle("Puzzle Plane");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1035, 784);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setIcon(new ImageIcon("D:\\tu\\Screen Shot 2017-09-22 at 4.00.14 PM.png"));
		btnNewButton.setBounds(54, 157, 436, 440);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setIcon(new ImageIcon("D:\\tu\\Screen Shot 2017-09-22 at 4.10.55 PM.png"));
		btnNewButton_1.setBounds(519, 157, 447, 432);
		contentPane.add(btnNewButton_1);
		
		txtChooseAShape = new JTextField();
		txtChooseAShape.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtChooseAShape.setText("Choose a Shape Set");
		txtChooseAShape.setBounds(375, 62, 260, 40);
		contentPane.add(txtChooseAShape);
		txtChooseAShape.setColumns(2);
	}
}
