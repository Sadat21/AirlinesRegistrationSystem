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

	class Listener implements ActionListener, ConnectionConstants
	{
		// CB - Combo box
		// DD - Departure date
		//Notes: Each function should create a String querry. Once you have it finalized, set it to Global.toGo. Can
		// look at the first one as an example even though it does the wrong function.

		//FORMAT FOR Global.toGo
		// 			OPERATION, [String stuff]
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == clearButton)
			{
				Global.toGo = "INSERT INTO flights (Source, Destination, Date, Time, Duration, TotalSeats, SeatsLeft, Price)"
						+ "VALUES('Sadat', 'Hell', '66/66/66', '04:20', '00:00:00', 1, 1, 0.99)";


			}
			else if (e.getSource() == getFlightsButton)
			{
				//Format should be "GETFLIGHTS Src Dest Date"
				//Src is mandatory
				//Other fields can be null, but make sure they are null


			}
			else if (e.getSource() == bookFlightbutton)
			{
				//Get inputs for each String value

				//Put into the format "BOOKFLIGHT\tTicketinputetc"



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

	private JPanel BFPanel;
	private JPanel LeftSepPanel;
	private JPanel SFPanel;
	private JTextField TFL2;
	private JTextField TFL1;
	private JTextField TFL3;
	private JTextField TFL4;
	private JComboBox monthCB;
	private JComboBox dayCB;
	private JComboBox yearCB;
	private JPanel MDY;
	private JLabel LabelL1;
	private JPanel Search;
	private JList searchResultsList;
	private JTextField TFR1;
	private JTextField TFR2;
	private JButton getFlightsButton;
	private JPanel SRPanel;
	private JPanel RightSepPanel;
	private JPanel FIPanel;
	private JButton clearButton;
	private JPanel MainPanel;
	private JScrollBar scrollBar;
	private JLabel PassFlightProg;
	private JSeparator TopSep;
	private JSeparator RightSep;
	private JLabel BookFlight;
	private JLabel SearchFlight;
	private JLabel FlightInfo;
	private JSeparator Sep1;
	private JSeparator Sep2;
	private JSeparator Sep3;
	private JLabel LabelL3;
	private JLabel LabelL4;
	private JLabel LabelL5;
	private JLabel month;
	private JLabel day;
	private JLabel year;
	private JSeparator Sep4;
	private JLabel LabelL6;
	private JLabel monthDD;
	private JLabel dayDD;
	private JLabel yearDD;
	private JComboBox monthDDCB;
	private JComboBox dayDDCB;
	private JComboBox yearDDCB;
	private JButton bookFlightbutton;
	private JLabel LabelR1;
	private JLabel LabelR2;
	private JLabel LabelR3;
	private JLabel LabelR4;
	private JLabel LabelR5;
	private JLabel LabelR6;
	private JLabel LabelR7;
	private JLabel LabelR8;
	private JLabel LabelR9;
	private JLabel LabelR10;
	private JTextField TFR3;
	private JTextField TFR4;
	private JTextField TFR5;
	private JTextField TFR6;
	private JTextField TFR7;
	private JTextField TFR8;
	private JTextField TFR9;
	private JTextField TFR10;
	private JLabel LabelL2;
	private Container c;
	private Listener listener;

	public PassengerGUI()
	{
		setTitle("Client Manager");
		setSize(825, 680);
		c = getContentPane();
		listener = new Listener();
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
		BookFlight = new JLabel();
		BookFlight.setFont(new Font(BookFlight.getFont().getName(), Font.BOLD, 24));
		BookFlight.setText("Book a Flight");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		BFPanel.add(BookFlight, gbc);
		LabelL1 = new JLabel();
		LabelL1.setText("From:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		BFPanel.add(LabelL1, gbc);
		TFL2 = new JTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 10, 0);
		BFPanel.add(TFL2, gbc);
		Sep1 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 0, 10, 0);
		BFPanel.add(Sep1, gbc);
		final JSeparator separator1 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.fill = GridBagConstraints.BOTH;
		BFPanel.add(separator1, gbc);
		final JSeparator separator2 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.BOTH;
		BFPanel.add(separator2, gbc);
		TFL1 = new JTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 10, 0);
		BFPanel.add(TFL1, gbc);
		MDY = new JPanel();
		MDY.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 15;
		gbc.fill = GridBagConstraints.BOTH;
		BFPanel.add(MDY, gbc);
		month = new JLabel();
		month.setText("Month");
		MDY.add(month);
		day = new JLabel();
		day.setText("Day");
		MDY.add(day);
		year = new JLabel();
		year.setText("Year");
		MDY.add(year);
		LabelL3 = new JLabel();
		LabelL3.setText("First name:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 0, 0);
		BFPanel.add(LabelL3, gbc);
		TFL3 = new JTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 10, 0);
		BFPanel.add(TFL3, gbc);
		final JSeparator separator3 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 10;
		gbc.fill = GridBagConstraints.BOTH;
		BFPanel.add(separator3, gbc);
		LabelL4 = new JLabel();
		LabelL4.setText("Last name:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 11;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 0, 0);
		BFPanel.add(LabelL4, gbc);
		TFL4 = new JTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 12;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(0, 0, 10, 0);
		BFPanel.add(TFL4, gbc);
		final JSeparator separator4 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 13;
		gbc.fill = GridBagConstraints.BOTH;
		BFPanel.add(separator4, gbc);
		final JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 16;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 0, 10, 0);
		BFPanel.add(panel1, gbc);
		monthCB = new JComboBox();
		panel1.add(monthCB);
		dayCB = new JComboBox();
		panel1.add(dayCB);
		yearCB = new JComboBox();
		panel1.add(yearCB);
		LabelL5 = new JLabel();
		LabelL5.setText("Date of Birth");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 14;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 0, 0);
		BFPanel.add(LabelL5, gbc);
		Sep4 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 17;
		gbc.fill = GridBagConstraints.BOTH;
		BFPanel.add(Sep4, gbc);
		LabelL6 = new JLabel();
		LabelL6.setText("Departure Date");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 18;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 0, 0);
		BFPanel.add(LabelL6, gbc);
		final JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 19;
		gbc.fill = GridBagConstraints.BOTH;
		BFPanel.add(panel2, gbc);
		monthDD = new JLabel();
		monthDD.setText("Month");
		panel2.add(monthDD);
		dayDD = new JLabel();
		dayDD.setText("Day");
		panel2.add(dayDD);
		yearDD = new JLabel();
		yearDD.setText("Year");
		panel2.add(yearDD);
		final JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 20;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 0, 10, 0);
		BFPanel.add(panel3, gbc);
		monthDDCB = new JComboBox();
		panel3.add(monthDDCB);
		dayDDCB = new JComboBox();
		panel3.add(dayDDCB);
		yearDDCB = new JComboBox();
		panel3.add(yearDDCB);
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
		LabelL2 = new JLabel();
		LabelL2.setText("To:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 0, 0);
		BFPanel.add(LabelL2, gbc);
		LeftSepPanel = new JPanel();
		LeftSepPanel.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 10, 0, 10);
		MainPanel.add(LeftSepPanel, gbc);
		final JSeparator separator5 = new JSeparator();
		separator5.setOrientation(1);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipady = 500;
		LeftSepPanel.add(separator5, gbc);
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
		gbc.insets = new Insets(10, 10, 0, 10);
		SFPanel.add(Search, gbc);
		SearchFlight = new JLabel();
		SearchFlight.setFont(new Font(SearchFlight.getFont().getName(), Font.BOLD, 24));
		SearchFlight.setText("Flights");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		Search.add(SearchFlight, gbc);
		Sep2 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipadx = 280;
		gbc.insets = new Insets(10, 0, 10, 0);
		Search.add(Sep2, gbc);
		SRPanel = new JPanel();
		SRPanel.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0, 10, 10, 10);
		SFPanel.add(SRPanel, gbc);
		searchResultsList = new JList();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipadx = 300;
		gbc.ipady = 465;
		gbc.insets = new Insets(0, 0, 10, 0);
		SRPanel.add(searchResultsList, gbc);
		bookFlightbutton = new JButton();
		bookFlightbutton.setText("Book Selected Flight");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		SRPanel.add(bookFlightbutton, gbc);
		scrollBar = new JScrollBar();
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.VERTICAL;
		SRPanel.add(scrollBar, gbc);
		RightSepPanel = new JPanel();
		RightSepPanel.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.fill = GridBagConstraints.BOTH;
		SFPanel.add(RightSepPanel, gbc);
		RightSep = new JSeparator();
		RightSep.setOrientation(1);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipady = 500;
		gbc.insets = new Insets(0, 10, 0, 10);
		RightSepPanel.add(RightSep, gbc);
		FIPanel = new JPanel();
		FIPanel.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);
		MainPanel.add(FIPanel, gbc);
		FlightInfo = new JLabel();
		FlightInfo.setFont(new Font(FlightInfo.getFont().getName(), Font.BOLD, 24));
		FlightInfo.setText("Flight Information");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		FIPanel.add(FlightInfo, gbc);
		LabelR2 = new JLabel();
		LabelR2.setText("From");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		FIPanel.add(LabelR2, gbc);
		TFR2 = new JTextField();
		TFR2.setColumns(10);
		TFR2.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		FIPanel.add(TFR2, gbc);
		LabelR3 = new JLabel();
		LabelR3.setText("To");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		FIPanel.add(LabelR3, gbc);
		TFR3 = new JTextField();
		TFR3.setColumns(10);
		TFR3.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		FIPanel.add(TFR3, gbc);
		LabelR4 = new JLabel();
		LabelR4.setText("Date");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		FIPanel.add(LabelR4, gbc);
		LabelR5 = new JLabel();
		LabelR5.setText("Time");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		FIPanel.add(LabelR5, gbc);
		LabelR6 = new JLabel();
		LabelR6.setText("Duration");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		FIPanel.add(LabelR6, gbc);
		LabelR7 = new JLabel();
		LabelR7.setText("Total Seats");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		FIPanel.add(LabelR7, gbc);
		LabelR8 = new JLabel();
		LabelR8.setText("Remaining Seats");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		FIPanel.add(LabelR8, gbc);
		LabelR9 = new JLabel();
		LabelR9.setText("Price");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 10;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		FIPanel.add(LabelR9, gbc);
		TFR4 = new JTextField();
		TFR4.setColumns(10);
		TFR4.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		FIPanel.add(TFR4, gbc);
		TFR5 = new JTextField();
		TFR5.setColumns(10);
		TFR5.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 6;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		FIPanel.add(TFR5, gbc);
		TFR6 = new JTextField();
		TFR6.setColumns(10);
		TFR6.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 7;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		FIPanel.add(TFR6, gbc);
		TFR7 = new JTextField();
		TFR7.setColumns(10);
		TFR7.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 8;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		FIPanel.add(TFR7, gbc);
		TFR8 = new JTextField();
		TFR8.setColumns(10);
		TFR8.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 9;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		FIPanel.add(TFR8, gbc);
		TFR9 = new JTextField();
		TFR9.setColumns(10);
		TFR9.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 10;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		FIPanel.add(TFR9, gbc);
		Sep3 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 0, 10, 0);
		FIPanel.add(Sep3, gbc);
		TFR1 = new JTextField();
		TFR1.setColumns(10);
		TFR1.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		FIPanel.add(TFR1, gbc);
		LabelR1 = new JLabel();
		LabelR1.setText("Flight Number");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		FIPanel.add(LabelR1, gbc);
		LabelR10 = new JLabel();
		LabelR10.setText("Price + Tax");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 11;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 0, 10, 10);
		FIPanel.add(LabelR10, gbc);
		TFR10 = new JTextField();
		TFR10.setColumns(10);
		TFR10.setEditable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 11;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		FIPanel.add(TFR10, gbc);
		TopSep = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 4;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(10, 0, 10, 0);
		MainPanel.add(TopSep, gbc);
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
		bookFlightbutton.addActionListener(listener);
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

}
