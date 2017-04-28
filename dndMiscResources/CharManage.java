/**
 * 
 */
package dndMiscResources;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

/**
 * @author Richard
 *
 */
public class CharManage extends JFrame {
	static final long serialVersionUID = 10L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CharManage frame = new CharManage();
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
	public CharManage() {
		PlayerCharacter PlayerCharInMemory = null; // Declare ready for manipulation later.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		PlayerCharInMemory = MainMenu.loadPC("Dave");
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("View Character\r\n", null, panel, null);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblPlayerName = new JLabel("Player Name: " + PlayerCharInMemory.getPlayerName());
		panel.add(lblPlayerName);
		
		JLabel lblCharacterName = new JLabel("Character Name: " + PlayerCharInMemory.getName());
		panel.add(lblCharacterName);
		
		JLabel lblCharacterClass = new JLabel("Class: " + PlayerCharInMemory.getPCClass());
		panel.add(lblCharacterClass);
		
		String[] columns = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};
		Object[][] data = {
				columns,
				{PlayerCharInMemory.getStrength(), PlayerCharInMemory.getDexterity(), PlayerCharInMemory.getConstitution(), PlayerCharInMemory.getIntelligence(), PlayerCharInMemory.getWisdom(), PlayerCharInMemory.getCharisma()}
		};
		
		JLabel lblCharacterRace = new JLabel("Race: " + PlayerCharInMemory.getRace());
		panel.add(lblCharacterRace);
		
		JLabel lblLevel = new JLabel("Level: " + 1);
		panel.add(lblLevel);
		

		
		JLabel lblCharacterAge = new JLabel("Age:");
		panel.add(lblCharacterAge);
		
		JLabel lblSpeed = new JLabel("Speed: " + 30);
		panel.add(lblSpeed);
		
		table = new JTable();
		panel.add(table);
		
		table.setModel(new DefaultTableModel(
			data,
			columns
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("View Character\r\n", null, panel_1, null);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblPlayerNameNew = new JLabel("Player Name: " + PlayerCharInMemory.getPlayerName());
		panel_1.add(lblPlayerNameNew);
		
		JLabel lblCharacterNameNew = new JLabel("Character Name: " + PlayerCharInMemory.getName());
		panel_1.add(lblCharacterNameNew);
		
		JLabel lblCharacterClassNew = new JLabel("Class: " + PlayerCharInMemory.getPCClass());
		panel_1.add(lblCharacterClassNew);
		
		JLabel lblLevelNew = new JLabel("Level: " + 1);
		panel_1.add(lblLevelNew);
		
		JLabel lblCharacterRaceNew = new JLabel("Race: " + PlayerCharInMemory.getRace());
		panel_1.add(lblCharacterRaceNew);
		

		
		JLabel lblCharacterAgeNew = new JLabel("Age:");
		panel_1.add(lblCharacterAgeNew);
		
		JLabel lblSpeedNew = new JLabel("Speed: " + 30);
		panel_1.add(lblSpeedNew);

		tabbedPane.addTab("Create a character", null, panel_1, null);
	}

}
