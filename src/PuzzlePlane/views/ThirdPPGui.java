package PuzzlePlane.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class ThirdPPGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2395325166341747282L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThirdPPGui frame = new ThirdPPGui();
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
	public ThirdPPGui() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\tu\\Screen Shot 2017-09-22 at 4.00.14 PM.png"));
		setTitle("Puzzle Plane");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 769);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(27, 22, 802, 182);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ThirdPPGui.class.getResource("/PuzzlePlane/resources/\u7D2B\u4E09\u89D2.jpg")));
		lblNewLabel_2.setBounds(368, 124, 56, 27);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(ThirdPPGui.class.getResource("/PuzzlePlane/resources/\u7D2B\u65B9\u5757.jpg")));
		lblNewLabel_3.setBounds(365, 13, 85, 78);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(ThirdPPGui.class.getResource("/PuzzlePlane/resources/\u7EA2\u4E09\u89D2.jpg")));
		lblNewLabel_4.setBounds(462, 36, 130, 133);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(ThirdPPGui.class.getResource("/PuzzlePlane/resources/\u7EFF\u4E09\u89D2.jpg")));
		lblNewLabel_5.setBounds(197, 102, 56, 67);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(ThirdPPGui.class.getResource("/PuzzlePlane/resources/\u84DD\u4E09\u89D2.jpg")));
		lblNewLabel_6.setBounds(599, 30, 120, 139);
		panel.add(lblNewLabel_6);
		
		JLabel label = new JLabel("");
		label.setBounds(155, 13, 150, 113);
		panel.add(label);
		label.setIcon(new ImageIcon(ThirdPPGui.class.getResource("/PuzzlePlane/resources/\u9EC4\u5E73\u884C.jpg")));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(47, 40, 130, 86);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(ThirdPPGui.class.getResource("/PuzzlePlane/resources/\u6A59\u4E09\u89D2.jpg")));
		
		JButton btnNewButton = new JButton("Flip Vertical");
		btnNewButton.setBounds(655, 645, 149, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("Return");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(598, 684, 138, 25);
		contentPane.add(button);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(380, 684, 130, 25);
		contentPane.add(btnReset);
		
		JButton btnViewShapeSet = new JButton("View Shape Set");
		btnViewShapeSet.setBounds(159, 684, 130, 25);
		btnViewShapeSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnViewShapeSet);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(btnViewShapeSet, popupMenu);
		
		JButton button_3 = new JButton("Counterwise Rotate");
		button_3.setBounds(50, 645, 165, 25);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("Anti-Counterwise Rotate");
		button_4.setBounds(258, 645, 171, 25);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("Flip Horizontal");
		button_5.setBounds(462, 645, 165, 25);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(button_5);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ThirdPPGui.class.getResource("/PuzzlePlane/resources/1\u7EB8\u9E64.jpeg")));
		lblNewLabel.setBounds(218, 288, 363, 265);
		contentPane.add(lblNewLabel);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
