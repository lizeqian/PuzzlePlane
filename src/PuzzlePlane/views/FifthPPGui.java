package PuzzlePlane.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

public class FifthPPGui extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FifthPPGui frame = new FifthPPGui();
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
	public FifthPPGui() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FifthPPGui.class.getResource("/PuzzlePlane/resources/Screen Shot 2017-09-22 at 4.00.14 PM.png")));
		setTitle("Puzzle Plane");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 490);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCongretu = new JButton("Ok");
		btnCongretu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCongretu.setBounds(384, 388, 97, 25);
		contentPane.add(btnCongretu);
		
		JLabel label = new JLabel("9/3/2017");
		label.setBounds(176, 162, 56, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("1");
		label_1.setBounds(46, 162, 56, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("2");
		label_2.setBounds(46, 221, 56, 16);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("3");
		label_3.setBounds(46, 273, 56, 16);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("9/23/2017");
		label_4.setBounds(176, 221, 71, 16);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("9/15/2017");
		label_5.setBounds(176, 273, 71, 16);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("01:02");
		label_6.setBounds(345, 162, 56, 16);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("02:43");
		label_7.setBounds(345, 221, 56, 16);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("03:06");
		label_8.setBounds(345, 273, 56, 16);
		contentPane.add(label_8);
		
		JPanel panel = new JPanel();
		panel.setBounds(24, 221, 431, 16);
		contentPane.add(panel);
		
		JLabel lblCongratulations = new JLabel("Congratulations!");
		lblCongratulations.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCongratulations.setBounds(170, 29, 159, 39);
		contentPane.add(lblCongratulations);
		
		JLabel lblRank = new JLabel("Rank");
		lblRank.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRank.setBounds(46, 102, 56, 21);
		contentPane.add(lblRank);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate.setBounds(176, 102, 71, 21);
		contentPane.add(lblDate);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTime.setBounds(345, 102, 56, 21);
		contentPane.add(lblTime);
	}

}
