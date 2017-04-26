/**
 * 			JUST POINTING OUT
 * 			PROBABLY ABOUT 90% OF THIS CODE
 * 			IS MADE BY WINDOWBUILDER
 */
package dndMiscResources;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * @author Richard
 *
 */
public class MainMenu_GUI extends JFrame {
	static final long serialVersionUID = 0L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu_GUI frame = new MainMenu_GUI();
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
	public MainMenu_GUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenu_GUI.class.getResource("/dndMiscResources/Icon.png")));
		setResizable(false);
		setTitle("Richard's Dungeons and Dragons thing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 424);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHelloWhatWould = new JLabel("Hello! What would you like to do today?");
		lblHelloWhatWould.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelloWhatWould.setIcon(null);
		lblHelloWhatWould.setBounds(27, 13, 553, 54);
		lblHelloWhatWould.setBackground(Color.BLACK);
		lblHelloWhatWould.setForeground(Color.BLACK);
		lblHelloWhatWould.setFont(new Font("Malgun Gothic", Font.BOLD, 17));
		contentPane.add(lblHelloWhatWould);
		
		JButton btnManageCharacters = new JButton("<html>\r\nManage <br>\r\nCharacters\r\n</html>");
		btnManageCharacters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Yeah this doesn't actually do anything yet. Sorry-not-sorry.", "THIS IS A TITLE, ISN'T IT EXCITING", JOptionPane.PLAIN_MESSAGE);
				JOptionPane.showMessageDialog(contentPane, "I may have lied. Oops.", "THIS IS A TITLE PART TWO: THE TITLING", JOptionPane.PLAIN_MESSAGE);
				CharManage cm = new CharManage(); // Create cm object
				cm.setVisible(true);	// Set it visible
				cm.setAlwaysOnTop(true);	// Fuck it, it's a top now
			}
		});
		btnManageCharacters.setHorizontalTextPosition(SwingConstants.CENTER);
		btnManageCharacters.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		btnManageCharacters.setBounds(27, 71, 263, 136);
		btnManageCharacters.setBackground(new Color(220, 220, 220));
		btnManageCharacters.setForeground(Color.BLACK);
		contentPane.add(btnManageCharacters);
		
		JButton btnRollDie = new JButton("Roll Die");
		btnRollDie.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		btnRollDie.setBounds(317, 71, 263, 136);
		btnRollDie.setBackground(new Color(220, 220, 220));
		btnRollDie.setForeground(Color.BLACK);
		btnRollDie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DieRoller_GUI dr = new DieRoller_GUI(); // Great new window with the dieroller
				dr.setVisible(true); // Set that window to be visible
			}
		});
		contentPane.add(btnRollDie);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setLabelFor(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(MainMenu_GUI.class.getResource("/dndMiscResources/Dungeons_and_Dragons.png")));
		lblNewLabel.setBounds(27, 220, 568, 151);
		contentPane.add(lblNewLabel);
	}
}
