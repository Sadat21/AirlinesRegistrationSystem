import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.seaglasslookandfeel.*;

/**
 * @author brain
 * @version 1.0
 * @since 4/1/2017
 */

public class PassengerGUI extends JFrame implements ListSelectionListener
{
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
		/*
		try {
			// Set System L&F
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
		}
		catch (UnsupportedLookAndFeelException e) {
			// handle exception
		}
		catch (ClassNotFoundException e) {
			// handle exception
		}
		catch (InstantiationException e) {
			// handle exception
		}
		catch (IllegalAccessException e) {
			// handle exception
		}
		*/


		test.setLocation(screenWidth/3, screenHeight/3);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setVisible(true);
	}

	class Listener implements ActionListener
	{
		public Listener()
		{
		}

		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == searchButton)
			{
				String key = textField1.getText();
				int index = -1;
				if (clientIDRadioButton.isSelected())
				{
					index = search(listModel, key, 1);
				}
				else if (lastNameRadioButton.isSelected())
				{
					index = search(listModel, key, 2);
				}
				else if (clientTypeRadioButton.isSelected())
				{
					index = search(listModel, key, 3);
				}

				if (index == -1)
				{
					JOptionPane.showMessageDialog(null, "Client not found.");
				}
				else
				{
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
			else if (e.getSource() == clearSearchButton)
			{
				textField1.setText("");
			}
			else if (e.getSource() == saveButton)
			{
				if (!checkTextFields())
				{
				}
				else
				{
					Boolean exist = false;
					int index = search(listModel, textField2.getText(), 1);
					if (index > -1)
					{
						exist = true;
					}
					if (!exist) {
						index = list.getSelectedIndex();
						if (index == -1)
							index = 0;
						else
							index++;
						String type = (String) comboBox1.getSelectedItem();
						type = String.valueOf(type.charAt(0));
						Node temp = new Node(textField2.getText(), textField3.getText(), textField4.getText(), textField5.getText(),
								textField6.getText(), textField7.getText(), type);
						listModel.insertElementAt(temp, index);
						JOptionPane.showMessageDialog(null, "Successfully added.");
						list.setSelectedIndex(index);
						list.ensureIndexIsVisible(index);
					} else {
						listModel.remove(index);
						String type = (String) comboBox1.getSelectedItem();
						type = String.valueOf(type.charAt(0));
						Node temp = new Node(textField2.getText(), textField3.getText(), textField4.getText(), textField5.getText(),
								textField6.getText(), textField7.getText(), type);
						listModel.insertElementAt(temp, index);
						JOptionPane.showMessageDialog(null, "Successfully edited.");
						list.setSelectedIndex(index);
						list.ensureIndexIsVisible(index);
					}
				}
			}
			else if (e.getSource() == deleteButton)
			{
				if (!checkTextFields())
				{
				}
				else
				{
					String key = textField2.getText();
					int index = search(listModel, key, 1);
					if (index > -1) {
						listModel.remove(index);
						JOptionPane.showMessageDialog(null, "Successfully deleted.");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Client not found.");
					}
				}
			}
			else if (e.getSource() == clearButton)
			{
				textField2.setText("");
				textField3.setText("");
				textField4.setText("");
				textField5.setText("");
				textField6.setText("");
				textField7.setText("");
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
	}

	private JButton searchButton;
	private JButton clearSearchButton;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JTextField textField7;
	private JRadioButton clientIDRadioButton;
	private JRadioButton lastNameRadioButton;
	private JRadioButton clientTypeRadioButton;
	private JList<String> list;
	private JComboBox comboBox1;
	private JButton saveButton;
	private JButton deleteButton;
	private JButton clearButton;
	private JPanel MainPanel;
	private JPanel LeftTop;
	private JPanel Right;
	private JPanel Title;
	private JPanel LeftBot;
	private JLabel SearchResults;
	private JPanel LT1;
	private JPanel LT2;
	private JPanel LT3;
	private JPanel LT4;
	private JPanel LT5;
	private JPanel R1;
	private JPanel R2;
	private JPanel R3;
	private JPanel R4;
	private JPanel R5;
	private JPanel R6;
	private JPanel R7;
	private JPanel R8;
	private JPanel R9;
	private JScrollPane ScrollPane;
	private JLabel TitleLabel;
	private Container c;
	private Listener listener;

	public PassengerGUI()
	{
		setTitle("Client Manager");
		setSize(750, 600);
		c = getContentPane();
		listener = new Listener();
		MainPanel = new JPanel();
		MainPanel.setLayout(new GridBagLayout());
		c.add(MainPanel);
		LeftTop = new JPanel();
		LeftTop = new JPanel();
		LeftTop.setLayout(new GridBagLayout());
		GridBagConstraints gbc;
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		MainPanel.add(LeftTop, gbc);
		LT1 = new JPanel();
		LT1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipady = 5;
		LeftTop.add(LT1, gbc);
		final JLabel label1 = new JLabel();
		label1.setFont(new Font(label1.getFont().getName(), Font.BOLD, 14));
		label1.setText("Search Clients");
		LT1.add(label1);
		LT3 = new JPanel();
		LT3.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipady = 5;
		LeftTop.add(LT3, gbc);
		clientIDRadioButton = new JRadioButton();
		clientIDRadioButton.setText("Client ID");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		LT3.add(clientIDRadioButton, gbc);
		lastNameRadioButton = new JRadioButton();
		lastNameRadioButton.setText("Last Name");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		LT3.add(lastNameRadioButton, gbc);
		clientTypeRadioButton = new JRadioButton();
		clientTypeRadioButton.setText("Client Type");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		LT3.add(clientTypeRadioButton, gbc);
		ButtonGroup group = new ButtonGroup();
		group.add(lastNameRadioButton);
		group.add(clientIDRadioButton);
		group.add(clientTypeRadioButton);
		LT4 = new JPanel();
		LT4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipady = 5;
		LeftTop.add(LT4, gbc);
		final JLabel label2 = new JLabel();
		label2.setText("Enter the search parameter here:");
		LT4.add(label2);
		LT5 = new JPanel();
		LT5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipady = 5;
		LeftTop.add(LT5, gbc);
		textField1 = new JTextField();
		textField1.setColumns(20);
		LT5.add(textField1);
		searchButton = new JButton();
		searchButton.setText("Search");
		LT5.add(searchButton);
		clearSearchButton = new JButton();
		clearSearchButton.setText("Clear Search");
		LT5.add(clearSearchButton);
		LT2 = new JPanel();
		LT2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipady = 5;
		LeftTop.add(LT2, gbc);
		final JLabel label3 = new JLabel();
		label3.setText("Select type of search to be performed:");
		LT2.add(label3);
		Right = new JPanel();
		Right.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.gridheight = 4;
		gbc.fill = GridBagConstraints.BOTH;
		MainPanel.add(Right, gbc);
		R2 = new JPanel();
		R2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipady = 5;
		Right.add(R2, gbc);
		final JLabel label4 = new JLabel();
		label4.setText("Client ID:");
		R2.add(label4);
		textField2 = new JTextField();
		textField2.setColumns(10);
		R2.add(textField2);
		R3 = new JPanel();
		R3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipady = 5;
		Right.add(R3, gbc);
		final JLabel label5 = new JLabel();
		label5.setText("First Name:");
		R3.add(label5);
		textField3 = new JTextField();
		textField3.setColumns(10);
		R3.add(textField3);
		R4 = new JPanel();
		R4.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipady = 5;
		Right.add(R4, gbc);
		final JLabel label6 = new JLabel();
		label6.setText("Last Name:");
		R4.add(label6);
		textField4 = new JTextField();
		textField4.setColumns(10);
		R4.add(textField4);
		R5 = new JPanel();
		R5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipady = 5;
		Right.add(R5, gbc);
		final JLabel label7 = new JLabel();
		label7.setText("Address:");
		R5.add(label7);
		textField5 = new JTextField();
		textField5.setColumns(10);
		R5.add(textField5);
		R6 = new JPanel();
		R6.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipady = 5;
		Right.add(R6, gbc);
		final JLabel label8 = new JLabel();
		label8.setText("Postal Code:");
		R6.add(label8);
		textField6 = new JTextField();
		textField6.setColumns(10);
		R6.add(textField6);
		R7 = new JPanel();
		R7.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipady = 5;
		Right.add(R7, gbc);
		final JLabel label9 = new JLabel();
		label9.setText("Phone Number:");
		R7.add(label9);
		textField7 = new JTextField();
		textField7.setColumns(10);
		R7.add(textField7);
		R8 = new JPanel();
		R8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipady = 5;
		Right.add(R8, gbc);
		final JLabel label10 = new JLabel();
		label10.setText("Client Type");
		R8.add(label10);
		String[] types = {"Residential", "Commercial"};
		comboBox1 = new JComboBox(types);
		comboBox1.setEditable(false);
		R8.add(comboBox1);
		R9 = new JPanel();
		R9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipady = 5;
		Right.add(R9, gbc);
		saveButton = new JButton();
		saveButton.setText("Save");
		R9.add(saveButton);
		deleteButton = new JButton();
		deleteButton.setText("Delete");
		R9.add(deleteButton);
		clearButton = new JButton();
		clearButton.setText("Clear");
		R9.add(clearButton);
		R1 = new JPanel();
		R1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		Right.add(R1, gbc);
		final JLabel label11 = new JLabel();
		label11.setFont(new Font(label11.getFont().getName(), Font.BOLD, 14));
		label11.setText("Client Information");
		R1.add(label11);
		LeftBot = new JPanel();
		LeftBot.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		MainPanel.add(LeftBot, gbc);
		list = new JList(listModel);
		list.setSelectedIndex(0);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		ScrollPane = new JScrollPane(list);
		ScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipadx = 100;
		gbc.ipady = 200;
		LeftBot.add(ScrollPane, gbc);
		SearchResults = new JLabel();
		SearchResults.setText("Search Results:");
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.WEST;
		MainPanel.add(SearchResults, gbc);
		final JSeparator separator1 = new JSeparator();
		separator1.setOrientation(1);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridheight = 4;
		gbc.fill = GridBagConstraints.BOTH;
		MainPanel.add(separator1, gbc);
		final JSeparator separator2 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.BOTH;
		MainPanel.add(separator2, gbc);
		Title = new JPanel();
		Title.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.BOTH;
		MainPanel.add(Title, gbc);
		TitleLabel = new JLabel();
		TitleLabel.setFont(new Font(TitleLabel.getFont().getName(), Font.BOLD, 20));
		TitleLabel.setText("Client Management System");
		Title.add(TitleLabel);
		final JSeparator separator3 = new JSeparator();
		Title.add(separator3);
		searchButton.addActionListener(listener);
		clearSearchButton.addActionListener(listener);
		saveButton.addActionListener(listener);
		deleteButton.addActionListener(listener);
		clearButton.addActionListener(listener);
		list.addListSelectionListener(this);
	}

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

}
