/**
 * 
 */
package dndMiscResources;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * @author richa
 *
 */
public class DieRoller_GUI extends JFrame {
	static final long serialVersionUID = 0L;
	/**
	 * Create the frame.
	 */
	public DieRoller_GUI() {
		getContentPane().setBackground(new Color(105, 105, 105));
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DieRoller_GUI.class.getResource("/dndMiscResources/Icon.png")));
		setTitle("Die Roller");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblYourResultIs = new JLabel("Your result is:");
		lblYourResultIs.setHorizontalAlignment(SwingConstants.TRAILING);
		lblYourResultIs.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblYourResultIs.setBounds(89, 11, 116, 30);
		getContentPane().add(lblYourResultIs);
		
		JLabel lblResult = new JLabel("          "); // Give it some default width
		lblResult.setFont(new Font("Malgun Gothic", Font.PLAIN, 27));
		lblResult.setBounds(215, 11, 219, 88);
		getContentPane().add(lblResult);
		lblResult.setText("Not yet rolled"); // Update to default value
		
		JComboBox<Integer> cbboxNoDie = new JComboBox<Integer>();
		cbboxNoDie.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
		cbboxNoDie.setFont(new Font("Malgun Gothic", Font.BOLD, 13));
		cbboxNoDie.setToolTipText("How many dice?");
		cbboxNoDie.setBounds(10, 169, 87, 91);
		getContentPane().add(cbboxNoDie);
		
		JComboBox<Integer> cbboxNoSides = new JComboBox<Integer>();
		cbboxNoSides.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {2, 4, 6, 8, 10, 12, 20, 100}));
		cbboxNoSides.setSelectedIndex(6);
		cbboxNoSides.setFont(new Font("Malgun Gothic", Font.BOLD, 13));
		cbboxNoSides.setToolTipText("How many sides to a die?");
		cbboxNoSides.setBounds(143, 169, 92, 91);
		getContentPane().add(cbboxNoSides);
		
		JLabel lblHowManyDice = new JLabel("How many dice?");
		lblHowManyDice.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblHowManyDice.setBounds(10, 131, 195, 27);
		getContentPane().add(lblHowManyDice);
		
		JLabel lblHowManySides = new JLabel("How many sides?");
		lblHowManySides.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
		lblHowManySides.setBounds(143, 131, 128, 27);
		getContentPane().add(lblHowManySides);
		
		JButton btnNewButton = new JButton("ROLL");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Malgun Gothic", Font.BOLD, 13));
		btnNewButton.setToolTipText("Roll the die!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 int result = new DieRoller().nDr(Integer.parseInt(cbboxNoSides.getSelectedItem().toString()), Integer.parseInt(cbboxNoDie.getSelectedItem().toString()));
				 // create new DieRoller, run the method of nDr from the values in the spinners, do more stuff
				 lblResult.setText("" + result); // Reflect the roll
			}
		});
		btnNewButton.setBounds(260, 169, 174, 91);
		getContentPane().add(btnNewButton);
	}
}
