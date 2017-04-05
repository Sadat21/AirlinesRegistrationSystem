import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * @author brain
 * @version 1.0
 * @since 4/1/2017
 */

public class PassengerGUI extends JFrame
{
	//implements ListSelectionListener
	//DefaultListModel<PassengerGUITEMP.Node> listModel = new DefaultListModel<>();

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
		test.setLocation(screenWidth/5, screenHeight/5);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setVisible(true);
	}

	class Listener implements ActionListener
	{
		// CB - Combo box
		// DD - Departure date
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == clearButton)
			{

			}
			else if (e.getSource() == getFlightsButton)
			{

			}
			else if (e.getSource() == bookFlightButton)
			{

			}
			else if (e.getSource() == monthDDCB)
			{

			}
			else if (e.getSource() == dayDDCB)
			{

			}
			else if (e.getSource() == yearDDCB)
			{

			}
			else if (e.getSource() == monthCB)
			{

			}
			else if (e.getSource() == dayCB)
			{

			}
			else if (e.getSource() == yearCB)
			{

			}
		}
	}
	/*
		public Listener()
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

	private JPanel MainPanel, PanelOne, PanelTwo, PanelThree;
	private JPanel SepPanel1, SepPanel2, panel1, panel2, panel3, panel4;
	private JPanel MDY1;
	private JLabel LabelR1, LabelR2, LabelR3, LabelR4, LabelR5, LabelR6, LabelR7, LabelR8, LabelR9, LabelR10;
	private JLabel LabelL1, LabelL2, LabelL3, LabelL4, LabelL5, LabelL6;
	private JPanel PanelTwo_One, PanelTwo_Two, PanelTwo_Three;
	private JList searchResultsList;
	private JTextField TFR1, TFR2, TFR3, TFR4, TFR5, TFR6, TFR7, TFR8, TFR9, TFR10;
	private JTextField TFL1, TFL2, TFL3, TFL4;
	private JButton getFlightsButton, clearButton, bookFlightButton;
	private JScrollBar scrollBar;
	private JLabel PassFlightProg, BookFlight, SearchFlight, FlightInfo;
	private JSeparator Sep1, Sep2, Sep3, Sep4, Sep5, Sep6, Sep7, Sep8, Sep9, Sep10, Sep11;
	private JLabel month, day, year;
	private JLabel monthDD, dayDD, yearDD;
	private JComboBox monthCB, dayCB, yearCB;
	private JComboBox monthDDCB, dayDDCB, yearDDCB;
	private Container c;
	private Listener listener;
	private String[] days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
			"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	private String[] yearsDofB = new String[118];
	private String[] yearsDD = {"2017", "2018", "2019", "2020", "2021"};

	public PassengerGUI()
	{
		for (int i = 0; i < 118; i++)
		{
			yearsDofB[i] = String.valueOf(i + 1900);
		}
		setTitle("Client Manager");
		setSize(856, 680);
		c = getContentPane();
		listener = new Listener();
		MainPanel = new JPanel();
		MainPanel.setLayout(new GridBagLayout());
		c.add(MainPanel);
		PanelOne = new JPanel();
		PanelOne.setLayout(new GridBagLayout());
		GridBagConstraints gbc;
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);
		MainPanel.add(PanelOne, gbc);
		BookFlight = new JLabel();
		BookFlight.setFont(new Font(BookFlight.getFont().getName(), Font.BOLD, 24));
		BookFlight.setText("Book a Flight");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		PanelOne.add(BookFlight, gbc);
		LabelL1 = new JLabel();
		LabelL1.setText("From:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		PanelOne.add(LabelL1, gbc);
		TFL2 = new JTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 10, 0);
		PanelOne.add(TFL2, gbc);
		Sep1 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 0, 10, 0);
		PanelOne.add(Sep1, gbc);
		Sep7 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.fill = GridBagConstraints.BOTH;
		PanelOne.add(Sep7, gbc);
		Sep8 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.BOTH;
		PanelOne.add(Sep8, gbc);
		TFL1 = new JTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 10, 0);
		PanelOne.add(TFL1, gbc);
		MDY1 = new JPanel();
		MDY1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 15;
		gbc.fill = GridBagConstraints.BOTH;
		PanelOne.add(MDY1, gbc);
		month = new JLabel();
		month.setText("Month");
		MDY1.add(month);
		day = new JLabel();
		day.setText("Day");
		MDY1.add(day);
		year = new JLabel();
		year.setText("Year");
		MDY1.add(year);
		LabelL3 = new JLabel();
		LabelL3.setText("First name:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 0, 0);
		PanelOne.add(LabelL3, gbc);
		TFL3 = new JTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 10, 0);
		PanelOne.add(TFL3, gbc);
		Sep9 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 10;
		gbc.fill = GridBagConstraints.BOTH;
		PanelOne.add(Sep9, gbc);
		LabelL4 = new JLabel();
		LabelL4.setText("Last name:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 11;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 0, 0);
		PanelOne.add(LabelL4, gbc);
		TFL4 = new JTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 12;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 10, 0);
		PanelOne.add(TFL4, gbc);
		Sep10 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 13;
		gbc.fill = GridBagConstraints.BOTH;
		PanelOne.add(Sep10, gbc);
		panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 16;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 0, 10, 0);
		PanelOne.add(panel1, gbc);
		monthCB = new JComboBox(months);
		panel1.add(monthCB);
		dayCB = new JComboBox(days);
		panel1.add(dayCB);
		yearCB = new JComboBox(yearsDofB);
		panel1.add(yearCB);
		LabelL5 = new JLabel();
		LabelL5.setText("Date of Birth");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 14;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 0, 0);
		PanelOne.add(LabelL5, gbc);
		Sep4 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 17;
		gbc.fill = GridBagConstraints.BOTH;
		PanelOne.add(Sep4, gbc);
		LabelL6 = new JLabel();
		LabelL6.setText("Departure Date");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 18;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 0, 0);
		PanelOne.add(LabelL6, gbc);
		panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 19;
		gbc.fill = GridBagConstraints.BOTH;
		PanelOne.add(panel2, gbc);
		monthDD = new JLabel();
		monthDD.setText("Month");
		panel2.add(monthDD);
		dayDD = new JLabel();
		dayDD.setText("Day");
		panel2.add(dayDD);
		yearDD = new JLabel();
		yearDD.setText("Year");
		panel2.add(yearDD);
		panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 20;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 0, 10, 0);
		PanelOne.add(panel3, gbc);
		monthDDCB = new JComboBox(months);
		panel3.add(monthDDCB);
		dayDDCB = new JComboBox(days);
		panel3.add(dayDDCB);
		yearDDCB = new JComboBox(yearsDD);
		panel3.add(yearDDCB);
		panel4 = new JPanel();
		panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 21;
		gbc.fill = GridBagConstraints.BOTH;
		PanelOne.add(panel4, gbc);
		getFlightsButton = new JButton();
		getFlightsButton.setText("Get Flights");
		panel4.add(getFlightsButton);
		clearButton = new JButton();
		clearButton.setText("Clear");
		panel4.add(clearButton);
		LabelL2 = new JLabel();
		LabelL2.setText("To:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 0, 0);
		PanelOne.add(LabelL2, gbc);
		SepPanel1 = new JPanel();
		SepPanel1.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 10, 0, 10);
		MainPanel.add(SepPanel1, gbc);
		Sep11 = new JSeparator();
		Sep11.setOrientation(1);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipady = 500;
		SepPanel1.add(Sep9, gbc);
		PanelTwo = new JPanel();
		PanelTwo.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		MainPanel.add(PanelTwo, gbc);
		PanelTwo_One = new JPanel();
		PanelTwo_One.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 10, 0, 10);
		PanelTwo.add(PanelTwo_One, gbc);
		SearchFlight = new JLabel();
		SearchFlight.setFont(new Font(SearchFlight.getFont().getName(), Font.BOLD, 24));
		SearchFlight.setText("Flights");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		PanelTwo_One.add(SearchFlight, gbc);
		Sep2 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipadx = 280;
		gbc.insets = new Insets(10, 0, 10, 0);
		PanelTwo_One.add(Sep2, gbc);
		PanelTwo_Two = new JPanel();
		PanelTwo_Two.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 10, 10, 10);
		PanelTwo.add(PanelTwo_Two, gbc);
		searchResultsList = new JList();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipadx = 300;
		gbc.ipady = 450;
		gbc.insets = new Insets(0, 0, 10, 0);
		PanelTwo_Two.add(searchResultsList, gbc);
		scrollBar = new JScrollBar();
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.VERTICAL;
		PanelTwo_Two.add(scrollBar, gbc);
		PanelTwo_Three = new JPanel();
		PanelTwo_Three.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.BOTH;
		PanelTwo.add(PanelTwo_Three, gbc);
		bookFlightButton = new JButton();
		bookFlightButton.setText("Book Selected Flight");
		PanelTwo_Three.add(bookFlightButton);
		SepPanel2 = new JPanel();
		SepPanel2.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.fill = GridBagConstraints.BOTH;
		PanelTwo.add(SepPanel2, gbc);
		Sep6 = new JSeparator();
		Sep6.setOrientation(1);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipady = 500;
		gbc.insets = new Insets(0, 10, 0, 10);
		SepPanel2.add(Sep6, gbc);
		PanelThree = new JPanel();
		PanelThree.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);
		MainPanel.add(PanelThree, gbc);
		FlightInfo = new JLabel();
		FlightInfo.setFont(new Font(FlightInfo.getFont().getName(), Font.BOLD, 24));
		FlightInfo.setText("Flight Information");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		PanelThree.add(FlightInfo, gbc);
		LabelR2 = new JLabel();
		LabelR2.setText("From");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		PanelThree.add(LabelR2, gbc);
		TFR2 = new JTextField();
		TFR2.setColumns(10);
		TFR2.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		PanelThree.add(TFR2, gbc);
		LabelR3 = new JLabel();
		LabelR3.setText("To");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		PanelThree.add(LabelR3, gbc);
		TFR3 = new JTextField();
		TFR3.setColumns(10);
		TFR3.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		PanelThree.add(TFR3, gbc);
		LabelR4 = new JLabel();
		LabelR4.setText("Date");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		PanelThree.add(LabelR4, gbc);
		LabelR5 = new JLabel();
		LabelR5.setText("Time");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		PanelThree.add(LabelR5, gbc);
		LabelR6 = new JLabel();
		LabelR6.setText("Duration");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		PanelThree.add(LabelR6, gbc);
		LabelR7 = new JLabel();
		LabelR7.setText("Total Seats");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		PanelThree.add(LabelR7, gbc);
		LabelR8 = new JLabel();
		LabelR8.setText("Remaining Seats");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		PanelThree.add(LabelR8, gbc);
		LabelR9 = new JLabel();
		LabelR9.setText("Price");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 10;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		PanelThree.add(LabelR9, gbc);
		TFR4 = new JTextField();
		TFR4.setColumns(10);
		TFR4.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		PanelThree.add(TFR4, gbc);
		TFR5 = new JTextField();
		TFR5.setColumns(10);
		TFR5.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		PanelThree.add(TFR5, gbc);
		TFR6 = new JTextField();
		TFR6.setColumns(10);
		TFR6.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		PanelThree.add(TFR6, gbc);
		TFR7 = new JTextField();
		TFR7.setColumns(10);
		TFR7.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 8;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		PanelThree.add(TFR7, gbc);
		TFR8 = new JTextField();
		TFR8.setColumns(10);
		TFR8.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 9;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		PanelThree.add(TFR8, gbc);
		TFR9 = new JTextField();
		TFR9.setColumns(10);
		TFR9.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 10;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		PanelThree.add(TFR9, gbc);
		Sep3 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 0, 10, 0);
		PanelThree.add(Sep3, gbc);
		TFR1 = new JTextField();
		TFR1.setColumns(10);
		TFR1.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		PanelThree.add(TFR1, gbc);
		LabelR1 = new JLabel();
		LabelR1.setText("Flight Number");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		PanelThree.add(LabelR1, gbc);
		LabelR10 = new JLabel();
		LabelR10.setText("Price + Tax");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 11;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		PanelThree.add(LabelR10, gbc);
		TFR10 = new JTextField();
		TFR10.setColumns(10);
		TFR10.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 11;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		PanelThree.add(TFR10, gbc);
		Sep5 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 0, 10, 0);
		MainPanel.add(Sep5, gbc);
		PassFlightProg = new JLabel();
		PassFlightProg.setFont(new Font(PassFlightProg.getFont().getName(), Font.BOLD, 28));
		PassFlightProg.setHorizontalAlignment(0);
		PassFlightProg.setHorizontalTextPosition(0);
		PassFlightProg.setText("Passenger Flight Program");
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 0;
		MainPanel.add(PassFlightProg, gbc);
		getFlightsButton.addActionListener(listener);
		clearButton.addActionListener(listener);
		bookFlightButton.addActionListener(listener);
		monthDDCB.addActionListener(listener);
		dayDDCB.addActionListener(listener);
		yearDDCB.addActionListener(listener);
		monthCB.addActionListener(listener);
		dayCB.addActionListener(listener);
		yearCB.addActionListener(listener);
	}

	/*
	public int search(DefaultListModel<PassengerGUITEMP.Node> data, String key, int type)
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
	public static class Node
	{
		public String ID, FN, LN, Address, PC, PN, CT;

		public Node(String ID, String FN, String LN, String Address, String PC, String PN, String CT)
		{
			this.ID = ID;
			this.FN = FN;
			this.LN = LN;
			this.Address = Address;
			this.PC = PC;
			this.PN = PN;
			this.CT = CT;
		}

		@Override
		public String toString()
		{
			return (ID + " " + FN + " " + LN + " " + Address + " " + PC + " " + PN + " " + CT);
		}
	}

	JPanel getPanelTwo_Three()
	{
		return PanelTwo_Three;
	}

	JPanel getMainPanel()
	{
		return MainPanel;
	}

}
