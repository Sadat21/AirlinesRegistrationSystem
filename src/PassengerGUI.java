import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author brain
 * @version 1.0
 * @since 4/1/2017
 */

public class PassengerGUI extends JFrame implements ListSelectionListener
{
	public static void main(String[] args)
	{
		try {
			UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		PassengerGUI test = new PassengerGUI();
		/*
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		test.setLocation(screenWidth/5, screenHeight/5);
		*/
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setVisible(true);
	}

	class Listener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == clearButton)
			{
				TFL1.setText("");
				TFL2.setText("");
				TFL3.setText("");
				TFL4.setText("");
				monthCB.setSelectedItem("-");
				dayCB.setSelectedItem("-");
				yearCB.setSelectedItem("-");
				monthDDCB.setSelectedItem("-");
				dayDDCB.setSelectedItem("-");
				yearDDCB.setSelectedItem("-");
			}
			else if (e.getSource() == getFlightsButton)
			{
				String src = TFL1.getText();
				String dst = TFL2.getText();
				Integer month = monthDDCB.getSelectedIndex();
				String date = (String)dayDDCB.getSelectedItem();
				String year = (String)yearDDCB.getSelectedItem();
				String dd = month.toString();

				if((dd.length() == 1) && (month != 0))
				{
					dd = "0" + dd;
				}

				if(date.length() == 1 && !date.equals("-"))
				{
					date = "0" + date;
				}

				int yr;
				if(yearDDCB.getSelectedIndex() == 0)
				{
					yr = -1;
				}
				else
				{
					yr = yearDDCB.getSelectedIndex();
				}

				if((month != 2) && (month != 8) && (month % 2 == 0) && (date.compareTo("30") > 0))
				{
					JOptionPane.showMessageDialog(null, "Invalid departure date selected");
					return;
				}

				else if((month == 2) && (yr > 0))
				{
					if(yr % 4 == 0)
					{
						if(date.compareTo("29") > 0)
						{
							JOptionPane.showMessageDialog(null, "Invalid departure date selected");
							return;
						}
					}
					else
					{
						if(date.compareTo("28") > 0)
						{
							JOptionPane.showMessageDialog(null, "Invalid departure date selected");
							return;
						}
					}
				}

				String day = "/" + date + "/";
				dd += day;
				dd += year;

				if(src.equals(""))
				{
					src = "-1";
				}

				if(dst.equals(""))
				{
					dst = "-1";
				}

				if(dd.contains("-"))
				{
					dd = "-1";
				}

				if(src.equals("-1") && dst.equals("-1") && dd.equals("-1"))
				{
					JOptionPane.showMessageDialog(null, "Please enter some search info");
					return;
				}

				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				Date curr = new Date();
				Date departure = null;
				if(dd.compareTo("-1") != 0) {
					try {
						departure = df.parse(dd);
					} catch (ParseException parse) {
						JOptionPane.showMessageDialog(null, "Unknown error occurred with the departure date");
						return;
					}
					if(curr.compareTo(departure) > 0)
					{
						JOptionPane.showMessageDialog(null, "The selected departure date has already passed");
						return;
					}
				}

				String test = "GETFLIGHTS\t" + src + "\t" + dst+ "\t" + dd;
				System.out.println(test);
				Global.toGo = test;
			}
			else if (e.getSource() == bookFlightButton)
			{
				String [] inputs = new String [9];
				inputs[0] = TFL3.getText();
				inputs[1] = TFL4.getText();
				inputs[3] = TFR2.getText();
				inputs[4] = TFR3.getText();
				inputs[5] = TFR4.getText();
				inputs[6] = TFR5.getText();
				inputs[7] = TFR6.getText();
				inputs[8] = TFR10.getText();

				Integer month = monthCB.getSelectedIndex();
				String date = (String)dayCB.getSelectedItem();
				String year = (String)yearCB.getSelectedItem();
				String depart = month.toString();

				if((depart.length() == 1) && (month != 0))
				{
					depart = "0" + depart;
				}

				if(date.length() == 1 && !date.equals("-"))
				{
					date = "0" + date;
				}

				int yr;
				if(yearCB.getSelectedIndex() == 0)
				{
					yr = -1;
				}
				else
				{
					yr = yearCB.getSelectedIndex();
				}

				if((month != 2) && (month != 8) && (month % 2 == 0) && (date.compareTo("30") > 0))
				{
					JOptionPane.showMessageDialog(null, "Invalid birthdate selected");
					return;
				}

				else if((month == 2) && (yr > 0))
				{
					if(yr % 4 == 0)
					{
						if(date.compareTo("29") > 0)
						{
							JOptionPane.showMessageDialog(null, "Invalid birthdate selected");
							return;
						}
					}
					else
					{
						if(date.compareTo("28") > 0)
						{
							JOptionPane.showMessageDialog(null, "Invalid birthdate selected");
							return;
						}
					}
				}

				String day = "/" + date + "/";
				depart += day;
				depart += year;

				inputs[2] = depart;
				boolean filled = true;
				for(int i = 0; i < inputs.length; i++)
				{
					if(inputs[i].equals("") || inputs[i].contains("-"))
					{
						filled = false;
						break;
					}
				}

				// I'm assuming that you can't book w/o all of the necessary fields filled out
				if(!filled)
				{
					JOptionPane.showMessageDialog(null, "Please fill out the necessary information");
					return;
				}

				DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
				Date curr = new Date();
				Date birthday = null;
				if(depart.compareTo("-1") != 0) {
					try {
						birthday = df.parse(depart);
					} catch (ParseException parse) {
						JOptionPane.showMessageDialog(null, "Unknown error occured with the birth date");
						return;
					}
					if(curr.compareTo(birthday) <= 0)
					{
						JOptionPane.showMessageDialog(null, "The selected birthdate is invalid");
						return;
					}
				}

				String temp = "BOOKFLIGHT";
				for(int i = 0; i < inputs.length; i++)
				{
					temp += "\t";
					temp += inputs[i];
				}

				System.out.println(temp);
				Global.toGo = temp;
			}
		}
	}

	public void valueChanged(ListSelectionEvent e)
	{
		if (!e.getValueIsAdjusting())
		{
			if (searchResultsFlights.getSelectedIndex() == -1)
			{
			} else {
				int index = searchResultsFlights.getSelectedIndex();
				searchResultsFlights.setSelectedIndex(index);
				TFR1.setText(String.valueOf(listModel.get(index).flightNumber));
				TFR2.setText(listModel.get(index).source);
				TFR3.setText(listModel.get(index).destination);
				TFR4.setText(listModel.get(index).date);
				TFR5.setText(listModel.get(index).time);
				TFR6.setText(listModel.get(index).duration);
				TFR7.setText(String.valueOf(listModel.get(index).totalSeats));
				TFR8.setText(String.valueOf(listModel.get(index).seatsLeft));
				TFR9.setText(String.valueOf(listModel.get(index).price));
				TFR10.setText(new DecimalFormat("##.##").format((listModel.get(index).price) * 1.07));
				System.out.println(index);
			}
		}
	}

	private JPanel MainPanel, PanelOne, PanelTwo, PanelThree;
	private JPanel SepPanel1, SepPanel2, panel1, panel2, panel3, panel4;
	private JPanel MDY1;
	private JLabel LabelR1, LabelR2, LabelR3, LabelR4, LabelR5, LabelR6, LabelR7, LabelR8, LabelR9, LabelR10;
	private JLabel LabelL1, LabelL2, LabelL3, LabelL4, LabelL5, LabelL6;
	private JPanel PanelTwo_One, PanelTwo_Two, PanelTwo_Three;
	protected JTextField TFR1, TFR2, TFR3, TFR4, TFR5, TFR6, TFR7, TFR8, TFR9, TFR10;
	protected JTextField TFL1, TFL2, TFL3, TFL4;
	protected JButton getFlightsButton, clearButton, bookFlightButton;
	private JLabel PassFlightProg, BookFlight, SearchFlight, FlightInfo;
	private JSeparator Sep1, Sep2, Sep3, Sep4, Sep5, Sep6, Sep7, Sep8, Sep9, Sep10, Sep11;
	private JLabel month, day, year;
	private JLabel monthDD, dayDD, yearDD;
	protected JComboBox monthCB, dayCB, yearCB;
	protected JComboBox monthDDCB, dayDDCB, yearDDCB;
	private Container c;
	protected Listener listener;
	private String[] days = {"-", "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
			"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private String[] months = {"-", "January","February","March","April","May","June","July","August","September","October","November","December"};
	private String[] yearsDofB = new String[118];
	private String[] yearsDD = {"-","2017", "2018", "2019", "2020", "2021"};
	private GridBagConstraints gbc;
	private JList<String> searchResultsFlights;
	private DefaultListModel<Flight> listModel = new DefaultListModel<>();
	protected ArrayList<Flight> flights;
	private JScrollPane ScrollPane;

	public PassengerGUI()
	{
		yearsDofB[0] = "-";
		for (int i = 1; i < 118; i++)
		{
			yearsDofB[i] = String.valueOf(i + 1900);
		}
		/*
		for (int i = 0; i < 500; i++)
        {
            listModel.addElement(new Flight(i, "src", "dest", "date","time", "asdf", i, i, i + 0.0));
        }
        */
		setTitle("Client Manager");
		setSize(1035, 680);
		c = getContentPane();
		listener = new Listener();
		MainPanel = new JPanel();
		MainPanel.setLayout(new GridBagLayout());
		c.add(MainPanel);
		PanelOne = new JPanel();
		PanelOne.setLayout(new GridBagLayout());
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
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridheight = 2;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipady = 500;
		SepPanel1.add(Sep11, gbc);
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
		searchResultsFlights = new JList(listModel);
		searchResultsFlights.setSelectedIndex(0);
		searchResultsFlights.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		searchResultsFlights.setLayoutOrientation(JList.VERTICAL);
		ScrollPane = new JScrollPane(searchResultsFlights);
		ScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipadx = 450;
		gbc.ipady = 440;
		gbc.insets = new Insets(0, 0, 0, 0);
		PanelTwo_Two.add(ScrollPane, gbc);
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
		searchResultsFlights.addListSelectionListener(this);
	}

	JPanel getPanelTwo_Three()
	{
		return PanelTwo_Three;
	}

	JPanel getMainPanel()
	{
		return MainPanel;
	}

	JLabel getPassFlightProg()
	{
		return PassFlightProg;
	}

	private void setFlights(ArrayList<Flight> flights)
	{
		for (int i = 0; i < flights.size(); i++)
		{
			listModel.clear();
			listModel.addElement(flights.get(i));
		}
	}

	public void setFlightReference(ArrayList<Flight> flights)
	{
		this.flights = flights;
		this.setFlights(flights);
	}

}
