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

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

	/**
	 * Create the frame.
	 */
	public FirstPPGui(Board b, PuzzlePlaneGui p) {
		/*setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\tu\\Screen Shot 2017-09-22 at 4.00.14 PM.png"));
		setTitle("Puzzle Plane");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1035, 784);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.*/
		setLayout(null);
		
		JButton traditionalsetButton = new JButton("chooseShapeSetButton");
		traditionalsetButton.setIcon(new ImageIcon(FirstPPGui.class.getResource("/PuzzlePlane/resources/Screen Shot 2017-09-22 at 4.00.14 PM.png")));
		traditionalsetButton.setBounds(54, 157, 436, 440);
		
		SelectShapesetController selectShapesetController = new SelectShapesetController(p, b);
		selectShapesetController.setFilePath("shapeset.txt");
		traditionalsetButton.addActionListener(selectShapesetController);
		add(traditionalsetButton);
		
		JButton nontraditionalsetButton = new JButton("chooseShapeSetButton");
		nontraditionalsetButton.setIcon(new ImageIcon(FirstPPGui.class.getResource("/PuzzlePlane/resources/Screen Shot 2017-09-22 at 4.10.55 PM.png")));
		nontraditionalsetButton.setBounds(519, 157, 447, 432);
		add(nontraditionalsetButton);
		
		JLabel lblNewLabel = new JLabel("Choose a Shape Set");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(350, 78, 307, 46);
		add(lblNewLabel);
	}
}
