package PuzzlePlane.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class SecondPPGui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecondPPGui frame = new SecondPPGui();
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
	public SecondPPGui() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\tu\\Screen Shot 2017-09-22 at 4.00.14 PM.png"));
		setTitle("Puzzle Plane");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 806);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(199, 155, 95, 101);
		btnNewButton.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/9\u72D0100.jpeg")));
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("New button");
		button.setBounds(349, 155, 95, 101);
		button.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/10\u72D7100.jpeg")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(501, 155, 95, 101);
		button_1.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/8\u623F100.jpg")));
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(656, 155, 95, 101);
		button_2.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/7\u9F9F.jpeg")));
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("New button");
		button_3.setBounds(199, 317, 95, 101);
		button_3.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/6\u7AD9\u9E2D.jpeg")));
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("New button");
		button_4.setBounds(349, 317, 95, 101);
		button_4.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/5\u9E2D.jpeg")));
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("New button");
		button_5.setBounds(501, 317, 95, 101);
		button_5.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/4\u9C7C.jpeg")));
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("New button");
		button_6.setBounds(656, 317, 95, 101);
		button_6.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/3\u6C34\u6676.jpeg")));
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("New button");
		button_7.setBounds(199, 483, 95, 101);
		button_7.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/2\u5154\u5B50.jpeg")));
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("New button");
		button_8.setBounds(349, 483, 95, 101);
		button_8.setIcon(new ImageIcon(SecondPPGui.class.getResource("/PuzzlePlane/resources/1\u7EB8\u9E64100.jpg")));
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("Return");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_9.setBounds(656, 555, 95, 46);
		contentPane.add(button_9);
	}

}
