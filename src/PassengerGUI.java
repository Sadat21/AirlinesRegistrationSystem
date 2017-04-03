import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author brain
 * @version 1.0
 * @since 4/1/2017
 */

public class PassengerGUI extends JFrame
{
	//implements ListSelectionListener
	DefaultListModel<Node> listModel = new DefaultListModel<>();

	public static void main(String[] args)
	{
		try {
			UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		PassengerGUI test = new PassengerGUI();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;


		//test.setLocation(screenWidth/3, screenHeight/3);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setVisible(true);
	}


	class Listener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{

		}
	}
	/*
		public Listener()
		{
		}

		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == searchButton)
			{
			}
			else if (e.getSource() == clearSearchButton)
			{
				textField1.setText("");
			}
			else if (e.getSource() == saveButton)
			{

			}
			else if (e.getSource() == deleteButton)
			{

			}
		}
	}

	public void valueChanged(ListSelectionEvent e)
	{
		if (!e.getValueIsAdjusting())
		{
			if (list.getSelectedIndex() == -1)
			{
			} else {
				int index = list.getSelectedIndex();
				list.setSelectedIndex(index);
				textField2.setText(listModel.get(index).ID);
				textField3.setText(listModel.get(index).FN);
				textField4.setText(listModel.get(index).LN);
				textField5.setText(listModel.get(index).Address);
				textField6.setText(listModel.get(index).PC);
				textField7.setText(listModel.get(index).PN);
				String temp;
				if (listModel.get(index).CT.equals("R"))
					temp = "Residential";
				else
					temp = "Commercial";
				comboBox1.setSelectedItem(temp);
			}
		}

	}*/

	private JPanel BFPanel;
	private JPanel asdf;
	private JPanel SFPanel;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JComboBox comboBox1;
	private JComboBox comboBox2;
	private JComboBox comboBox3;
	private JPanel MDY;
	private JLabel from;
	private JLabel To;
	private JPanel Search;
	private JButton searchButton;
	private JList list1;
	private JTextField textField6;
	private JTextField textField7;
	private JButton getFlightsButton;
	private JTextField textField8;
	private JPanel SRPanel;
	private JPanel asdf2;
	private JPanel FIPanel;
	private JButton clearButton;
	private JPanel MainPanel;
	private Container c;
	private Listener listener;

	public PassengerGUI()
	{
		setTitle("Client Manager");
		setSize(900, 700);
		c = getContentPane();
		//listener = new Listener();
		MainPanel = new JPanel();
		MainPanel.setLayout(new GridBagLayout());
		c.add(MainPanel);
		BFPanel = new JPanel();
		BFPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc;
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);
		MainPanel.add(BFPanel, gbc);
		final JLabel label1 = new JLabel();
		label1.setFont(new Font(label1.getFont().getName(), Font.BOLD, 24));
		label1.setText("Book a Flight");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		BFPanel.add(label1, gbc);
		from = new JLabel();
		from.setText("From:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 0, 0);
		BFPanel.add(from, gbc);
		To = new JLabel();
		To.setText("To:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 0, 0);
		BFPanel.add(To, gbc);
		textField1 = new JTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 10, 0);
		BFPanel.add(textField1, gbc);
		final JSeparator separator1 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 0, 10, 0);
		BFPanel.add(separator1, gbc);
		final JSeparator separator2 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.fill = GridBagConstraints.BOTH;
		BFPanel.add(separator2, gbc);
		final JSeparator separator3 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.BOTH;
		BFPanel.add(separator3, gbc);
		textField2 = new JTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 10, 0);
		BFPanel.add(textField2, gbc);
		MDY = new JPanel();
		MDY.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 15;
		gbc.fill = GridBagConstraints.BOTH;
		BFPanel.add(MDY, gbc);
		final JLabel label2 = new JLabel();
		label2.setText("Month");
		MDY.add(label2);
		final JLabel label3 = new JLabel();
		label3.setText("Day");
		MDY.add(label3);
		final JLabel label4 = new JLabel();
		label4.setText("Year");
		MDY.add(label4);
		final JLabel label5 = new JLabel();
		label5.setText("First name:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 0, 0);
		BFPanel.add(label5, gbc);
		textField3 = new JTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 10, 0);
		BFPanel.add(textField3, gbc);
		final JSeparator separator4 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 10;
		gbc.fill = GridBagConstraints.BOTH;
		BFPanel.add(separator4, gbc);
		final JLabel label6 = new JLabel();
		label6.setText("Last name:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 11;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 0, 0);
		BFPanel.add(label6, gbc);
		textField4 = new JTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 12;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 10, 0);
		BFPanel.add(textField4, gbc);
		final JSeparator separator5 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 13;
		gbc.fill = GridBagConstraints.BOTH;
		BFPanel.add(separator5, gbc);
		final JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 16;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 0, 10, 0);
		BFPanel.add(panel1, gbc);
		comboBox1 = new JComboBox();
		panel1.add(comboBox1);
		comboBox2 = new JComboBox();
		panel1.add(comboBox2);
		comboBox3 = new JComboBox();
		panel1.add(comboBox3);
		final JLabel label7 = new JLabel();
		label7.setText("Date of Birth");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 14;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 0, 0);
		BFPanel.add(label7, gbc);
		final JSeparator separator6 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 17;
		gbc.fill = GridBagConstraints.BOTH;
		BFPanel.add(separator6, gbc);
		final JLabel label8 = new JLabel();
		label8.setText("Departure Date");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 18;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 0, 0);
		BFPanel.add(label8, gbc);
		final JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 19;
		gbc.fill = GridBagConstraints.BOTH;
		BFPanel.add(panel2, gbc);
		final JLabel label9 = new JLabel();
		label9.setText("Month");
		panel2.add(label9);
		final JLabel label10 = new JLabel();
		label10.setText("Day");
		panel2.add(label10);
		final JLabel label11 = new JLabel();
		label11.setText("Year");
		panel2.add(label11);
		final JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 20;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 0, 10, 0);
		BFPanel.add(panel3, gbc);
		final JComboBox comboBox4 = new JComboBox();
		panel3.add(comboBox4);
		final JComboBox comboBox5 = new JComboBox();
		panel3.add(comboBox5);
		final JComboBox comboBox6 = new JComboBox();
		panel3.add(comboBox6);
		final JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 21;
		gbc.fill = GridBagConstraints.BOTH;
		BFPanel.add(panel4, gbc);
		getFlightsButton = new JButton();
		getFlightsButton.setText("Get Flights");
		panel4.add(getFlightsButton);
		clearButton = new JButton();
		clearButton.setText("Clear");
		panel4.add(clearButton);
		asdf = new JPanel();
		asdf.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 10, 0, 10);
		MainPanel.add(asdf, gbc);
		final JSeparator separator7 = new JSeparator();
		separator7.setOrientation(1);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipady = 500;
		asdf.add(separator7, gbc);
		SFPanel = new JPanel();
		SFPanel.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		MainPanel.add(SFPanel, gbc);
		Search = new JPanel();
		Search.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 10, 10, 10);
		SFPanel.add(Search, gbc);
		final JLabel label12 = new JLabel();
		label12.setText("From");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		Search.add(label12, gbc);
		final JLabel label13 = new JLabel();
		label13.setText("Destination");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		Search.add(label13, gbc);
		final JLabel label14 = new JLabel();
		label14.setText("Depature Date");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		Search.add(label14, gbc);
		final JTextField textField5 = new JTextField();
		textField5.setColumns(15);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 3;
		Search.add(textField5, gbc);
		textField8 = new JTextField();
		textField8.setColumns(15);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 4;
		Search.add(textField8, gbc);
		final JTextField textField9 = new JTextField();
		textField9.setColumns(15);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 2;
		Search.add(textField9, gbc);
		final JLabel label15 = new JLabel();
		label15.setFont(new Font(label15.getFont().getName(), Font.BOLD, 24));
		label15.setText("Search for a Flight");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		Search.add(label15, gbc);
		final JSeparator separator8 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 0, 10, 0);
		Search.add(separator8, gbc);
		searchButton = new JButton();
		searchButton.setText("Search");
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 5;
		gbc.insets = new Insets(10, 0, 0, 0);
		Search.add(searchButton, gbc);
		SRPanel = new JPanel();
		SRPanel.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 10, 10, 10);
		SFPanel.add(SRPanel, gbc);
		list1 = new JList();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipadx = 300;
		gbc.ipady = 300;
		SRPanel.add(list1, gbc);
		final JLabel label16 = new JLabel();
		label16.setText("Search Results");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		SRPanel.add(label16, gbc);
		asdf2 = new JPanel();
		asdf2.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.fill = GridBagConstraints.BOTH;
		SFPanel.add(asdf2, gbc);
		final JSeparator separator9 = new JSeparator();
		separator9.setOrientation(1);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipady = 500;
		gbc.insets = new Insets(0, 10, 0, 10);
		asdf2.add(separator9, gbc);
		FIPanel = new JPanel();
		FIPanel.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);
		MainPanel.add(FIPanel, gbc);
		final JLabel label17 = new JLabel();
		label17.setFont(new Font(label17.getFont().getName(), Font.BOLD, 24));
		label17.setText("Flight Information");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		FIPanel.add(label17, gbc);
		final JLabel label18 = new JLabel();
		label18.setText("From:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		FIPanel.add(label18, gbc);
		textField7 = new JTextField();
		textField7.setColumns(10);
		textField7.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		FIPanel.add(textField7, gbc);
		final JLabel label19 = new JLabel();
		label19.setText("To:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		FIPanel.add(label19, gbc);
		final JTextField textField10 = new JTextField();
		textField10.setColumns(10);
		textField10.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		FIPanel.add(textField10, gbc);
		final JLabel label20 = new JLabel();
		label20.setText("Date:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		FIPanel.add(label20, gbc);
		final JLabel label21 = new JLabel();
		label21.setText("Time:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		FIPanel.add(label21, gbc);
		final JLabel label22 = new JLabel();
		label22.setText("Duration:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		FIPanel.add(label22, gbc);
		final JLabel label23 = new JLabel();
		label23.setText("Total Number of Seats:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		FIPanel.add(label23, gbc);
		final JLabel label24 = new JLabel();
		label24.setText("Remaining Seats:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		FIPanel.add(label24, gbc);
		final JLabel label25 = new JLabel();
		label25.setText("Price:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 10;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		FIPanel.add(label25, gbc);
		final JTextField textField11 = new JTextField();
		textField11.setColumns(10);
		textField11.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		FIPanel.add(textField11, gbc);
		final JTextField textField12 = new JTextField();
		textField12.setColumns(10);
		textField12.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		FIPanel.add(textField12, gbc);
		final JTextField textField13 = new JTextField();
		textField13.setColumns(10);
		textField13.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		FIPanel.add(textField13, gbc);
		final JTextField textField14 = new JTextField();
		textField14.setColumns(10);
		textField14.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 8;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		FIPanel.add(textField14, gbc);
		final JTextField textField15 = new JTextField();
		textField15.setColumns(10);
		textField15.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 9;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		FIPanel.add(textField15, gbc);
		final JTextField textField16 = new JTextField();
		textField16.setColumns(10);
		textField16.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 10;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		FIPanel.add(textField16, gbc);
		final JSeparator separator10 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 0, 10, 0);
		FIPanel.add(separator10, gbc);
		textField6 = new JTextField();
		textField6.setColumns(10);
		textField6.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		FIPanel.add(textField6, gbc);
		final JLabel label26 = new JLabel();
		label26.setText("Flight Number:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		FIPanel.add(label26, gbc);
		final JSeparator separator11 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 0, 10, 0);
		MainPanel.add(separator11, gbc);
		final JLabel label27 = new JLabel();
		label27.setFont(new Font(label27.getFont().getName(), Font.BOLD, 28));
		label27.setHorizontalAlignment(0);
		label27.setHorizontalTextPosition(0);
		label27.setText("Passenger Flight Program");
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 0;
		MainPanel.add(label27, gbc);
	}

	/*
	public int search(DefaultListModel<Node> data, String key, int type)
	{
		if (type == 1) {
			for (int i = 0; i < data.size(); i++) {
				if (data.get(i).ID.equals(key))
					return i;
			}
			return -1;
		}
		else if (type == 2) {
			for (int i = 0; i < data.size(); i++) {
				if (data.get(i).LN.equals(key))
					return i;
			}
			return -1;
		}
		else if (type == 3) {
			for (int i = 0; i < data.size(); i++) {
				if (data.get(i).CT.equals(key))
					return i;
			}
			return -1;
		}
		return -1;
	}

	public boolean checkTextFields()
	{
		// Empty fields check
		if (textField2.getText().equals("") || textField3.getText().equals("") || textField4.getText().equals("")
				|| textField5.getText().equals("") || textField6.getText().equals("") || textField7.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Not enough fields filled.");
			return false;
		}
		// Invalid length of text check
		if (textField3.getText().length() > 20 ||
				textField4.getText().length() > 20 || textField5.getText().length() > 50)
		{
			JOptionPane.showMessageDialog(null, "Invalid length for either first name, last name, or address.");
			return false;
		}
		// Postal Code check
		char[] temp = textField6.getText().toCharArray();
		if (temp.length != 7 || !Character.isLetter(temp[0]) || !Character.isLetter(temp[2]) || !Character.isLetter(temp[5])
				|| !Character.isDigit(temp[1]) || !Character.isDigit(temp[4]) || !Character.isDigit(temp[6]) || !Character.isSpaceChar(temp[3]))
		{
			JOptionPane.showMessageDialog(null, "Invalid postal code. Must be in the format A#A #A#");
			return false;
		}
		// Phone number check
		temp = textField7.getText().toCharArray();
		if (temp.length != 12 || !Character.isDigit(temp[0]) || !Character.isDigit(temp[1]) || !Character.isDigit(temp[2])
				|| !Character.isDigit(temp[4]) || !Character.isDigit(temp[5]) || !Character.isDigit(temp[6])
				|| !Character.isDigit(temp[8]) || !Character.isDigit(temp[9]) || !Character.isDigit(temp[10])
				|| !Character.isDigit(temp[11]) || temp[3] != '-' || temp[7] != '-')
		{
			JOptionPane.showMessageDialog(null, "Invalid phone number. Must be in the format ###-###-###.");
			return false;
		}
		return true;
	}
	*/

}
