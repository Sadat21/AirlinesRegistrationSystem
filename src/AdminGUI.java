
                    boolean error = flightErrorCheck(inputs, null, false);
                    if(!error)
                    {
    public boolean flightErrorCheck(String input, PrintWriter out, boolean enable) {
        if ((temp[3].length() > 5) || (temp[4].length() > 8)) {
            if(enable) {
                out.println("Time and/or duration are too long");
                }
            else {
                JOptionPane.showMessageDialog(null, "Time and/or date are too long");
            }
            return true;
        }
        if (!temp[3].matches("([01]?[0-9]|2[0-3]):([0-5][0-9])")) {
            if(enable) {
                out.println("Time is formatted incorrectly. Should be HH:mm");
            }
            else {
                JOptionPane.showMessageDialog(null, "Time is formatted incorrectly. Should be HH:mm");
            }
            return true;
        }
        if (!temp[4].matches("([0-9]{2}):([01]?[0-9]|2[0-3]):([0-5][0-9])")) {
            if(enable) {
                out.println("Duration is formatted incorrectly. Should be XX:XX:XX");
            }
            else {
                JOptionPane.showMessageDialog(null, "Duration is formatted incorrectly. Should be XX:XX:XX");
            }
            return true;
        }
        try {
            if (seats < seatsLeft) {
                if(enable) {
                    out.println("There are more 'seats left' than total seats");
                }
                else {
                    JOptionPane.showMessageDialog(null, "There are more 'seats left' than total seats");
                }
                return true;
            }
            if (seats <= 0 || seatsLeft < 0) {
                if(enable) {
                    out.println("The total number of seats and/or the remaining seats isn't a positive integer");
                }
                else {
                    JOptionPane.showMessageDialog(null, "The total number of seats and/or the remaining seats isn't a positive integer");
                }
                return true;
            }
        } catch (NumberFormatException ex) {
            if(enable) {
                out.println("Either total seats or seats remaining is not an integer");
            }
            else {
                JOptionPane.showMessageDialog(null, "Either total seats or seats remaining is not an integer");
            }
            return true;
        try {
            if (price < 0) {
                if(enable) {
                    out.println("The price is a negative value");
                }
                else {
                    JOptionPane.showMessageDialog(null, "The price is a negative value");
                }
                return true;
            }
        } catch (NumberFormatException ex) {
            if(enable) {
                out.println("Price is not a double");
            }
            else {
                JOptionPane.showMessageDialog(null, "Price is not a double");
            }
            return true;
        if (temp[7].charAt(temp[7].length() - 3) != '.') {
            if(enable) {
                out.println("The price entered can only have 2 digits after the decimal");
            }
            else {
                JOptionPane.showMessageDialog(null, "The price entered can only have 2 digits after the decimal");
            }
            return true;
        }
            if (curr.compareTo(depart) > 0) {
                if(enable) {
                    out.println("The inputted departure date has already passed");
                }
                else {
                    JOptionPane.showMessageDialog(null, "The inputted departure date has already passed");
                }
                return true;
            }
        } catch (ParseException ex) {
            if(enable) {
                out.println("Unknown error occured while parsing the 'Date' text field");
            }
            else {
                            JOptionPane.showMessageDialog(null, "Unknown error occured while parsing the 'Date' text field");

                            }

                            return true;
                            \ No newline at end of file
                            }

                            return false;

                            }





                    public AdminGUI()

                            {

                            super();

                            for (int i = 0; i < 500; i++)

                            {

                            listModel.insertElementAt(new Ticket(i, i, "FN", "LN", "DOB", "SRC", "DEST", "asdf", "TIME", "DUR", 0.0), i);

                            }

                            listener = new Listener();

                            setTitle("Admin Client Program");

                            setSize(1400, 680);

                            MainPanel = getMainPanel();

                            PanelTwo_Three = getPanelTwo_Three();

                            addFlightButton = new JButton();

                            addFlightButton.setText("Add Flight");

                            PanelTwo_Three.add(addFlightButton);

                            addFlightsFromFileButton = new JButton();

                            addFlightsFromFileButton.setText("Add Flights from File");

                            PanelTwo_Three.add(addFlightsFromFileButton);

                            Sep12 = new JSeparator();

                            Sep12.setOrientation(1);

                            gbc = new GridBagConstraints();

                            gbc.gridx = 4;

                            gbc.gridy = 2;

                            gbc.fill = GridBagConstraints.BOTH;

                            gbc.ipady = 500;

                            gbc.insets = new Insets(0, 10, 0, 10);

                            MainPanel.add(Sep12, gbc);

                            PanelFour = new JPanel();

                            PanelFour.setLayout(new GridBagLayout());

                            gbc = new GridBagConstraints();

                            gbc.gridx = 5;

                            gbc.gridy = 2;

                            gbc.anchor = GridBagConstraints.NORTH;

                            gbc.fill = GridBagConstraints.HORIZONTAL;

                            MainPanel.add(PanelFour, gbc);

                            PanelFour_One = new JPanel();

                            PanelFour_One.setLayout(new GridBagLayout());

                            gbc = new GridBagConstraints();

                            gbc.gridx = 0;

                            gbc.gridy = 0;

                            gbc.fill = GridBagConstraints.BOTH;

                            gbc.insets = new Insets(10, 10, 10, 10);

                            PanelFour.add(PanelFour_One, gbc);

                            FlightID = new JLabel();

                            FlightID.setText("Flight ID");

                            gbc = new GridBagConstraints();

                            gbc.gridx = 0;

                            gbc.gridy = 2;

                            gbc.anchor = GridBagConstraints.WEST;

                            gbc.insets = new Insets(10, 0, 10, 10);

                            PanelFour_One.add(FlightID, gbc);

                            FlightSource = new JLabel();

                            FlightSource.setText("Flight Source");

                            gbc = new GridBagConstraints();

                            gbc.gridx = 0;

                            gbc.gridy = 3;

                            gbc.anchor = GridBagConstraints.WEST;

                            gbc.insets = new Insets(10, 0, 10, 10);

                            PanelFour_One.add(FlightSource, gbc);

                            FlightDest = new JLabel();

                            FlightDest.setText("Flight Destination");

                            gbc = new GridBagConstraints();

                            gbc.gridx = 0;

                            gbc.gridy = 4;

                            gbc.anchor = GridBagConstraints.WEST;

                            gbc.insets = new Insets(10, 0, 10, 10);

                            PanelFour_One.add(FlightDest, gbc);

                            TFRR2 = new JTextField();

                            TFRR2.setColumns(15);

                            gbc = new GridBagConstraints();

                            gbc.gridx = 2;

                            gbc.gridy = 3;

                            PanelFour_One.add(TFRR2, gbc);

                            TFRR3 = new JTextField();

                            TFRR3.setColumns(15);

                            gbc = new GridBagConstraints();

                            gbc.gridx = 2;

                            gbc.gridy = 4;

                            PanelFour_One.add(TFRR3, gbc);

                            TFRR1 = new JTextField();

                            TFRR1.setColumns(15);

                            gbc = new GridBagConstraints();

                            gbc.gridx = 2;

                            gbc.gridy = 2;

                            PanelFour_One.add(TFRR1, gbc);

                            ViewTickets = new JLabel();

                            ViewTickets.setFont(new Font(ViewTickets.getFont().getName(), Font.BOLD, 24));

                            ViewTickets.setText("View Tickets");

                            gbc = new GridBagConstraints();

                            gbc.gridx = 0;

                            gbc.gridy = 0;

                            gbc.gridwidth = 3;

                            PanelFour_One.add(ViewTickets, gbc);

                            Sep13 = new JSeparator();

                            gbc = new GridBagConstraints();

                            gbc.gridx = 0;

                            gbc.gridy = 1;

                            gbc.gridwidth = 3;

                            gbc.fill = GridBagConstraints.BOTH;

                            gbc.insets = new Insets(10, 0, 10, 0);

                            PanelFour_One.add(Sep13, gbc);

                            searchButton = new JButton();

                            searchButton.setText("Search");

                            gbc = new GridBagConstraints();

                            gbc.gridx = 2;

                            gbc.gridy = 5;

                            gbc.insets = new Insets(10, 0, 0, 0);

                            PanelFour_One.add(searchButton, gbc);

                            PanelFour_Two = new JPanel();

                            PanelFour_Two.setLayout(new GridBagLayout());

                            gbc = new GridBagConstraints();

                            gbc.gridx = 0;

                            gbc.gridy = 1;

                            gbc.fill = GridBagConstraints.BOTH;

                            gbc.insets = new Insets(0, 10, 10, 10);

                            PanelFour.add(PanelFour_Two, gbc);

                            searchResultsTickets = new JList(listModel);

                            searchResultsTickets.setSelectedIndex(0);

                            searchResultsTickets.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

                            searchResultsTickets.setLayoutOrientation(JList.VERTICAL);

                            ScrollPane = new JScrollPane(searchResultsTickets);

                            ScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

                            gbc = new GridBagConstraints();

                            gbc.gridx = 0;

                            gbc.gridy = 1;

                            gbc.gridwidth = 7;

                            gbc.fill = GridBagConstraints.BOTH;

                            gbc.ipadx = 300;

                            gbc.ipady = 265;

                            gbc.insets = new Insets(0, 0, 10, 0);

                            PanelFour_Two.add(ScrollPane, gbc);

                            SearchResults = new JLabel();

                            SearchResults.setFont(new Font(SearchResults.getFont().getName(), Font.BOLD, 12));

                            SearchResults.setText("Search Results");

                            gbc = new GridBagConstraints();

                            gbc.gridx = 0;

                            gbc.gridy = 0;

                            gbc.gridwidth = 7;

                            gbc.anchor = GridBagConstraints.WEST;

                            PanelFour_Two.add(SearchResults, gbc);

                            cancelTicket = new JButton();

                            cancelTicket.setText("Cancel Selected Ticket");

                            gbc = new GridBagConstraints();

                            gbc.gridx = 6;

                            gbc.gridy = 2;

                            PanelFour_Two.add(cancelTicket, gbc);

                            getPassFlightProg().setText("Administrator Flight Program");

                            gbc = new GridBagConstraints();

                            gbc.gridx = 1;

                            gbc.gridy = 0;

                            gbc.gridwidth = 4;

                            MainPanel.add(getPassFlightProg(), gbc);

                            JSeparator TopSep = new JSeparator();

                            gbc = new GridBagConstraints();

                            gbc.gridx = 0;

                            gbc.gridy = 1;

                            gbc.gridwidth = 6;

                            gbc.fill = GridBagConstraints.BOTH;

                            gbc.insets = new Insets(10, 0, 10, 0);

                            MainPanel.add(TopSep, gbc);

                            searchResultsTickets.addListSelectionListener(this);

                            clearButton.addActionListener(listener);

                            addFlightButton.addActionListener(listener);

                            addFlightsFromFileButton.addActionListener(listener);

                            searchButton.addActionListener(listener);

                            cancelTicket.addActionListener(listener);



                            }



                    private void setTickets(ArrayList<Ticket> tickets)

                            {

                            for (int i = 0; i < tickets.size(); i++)

                            {

                            listModel.clear();

                            listModel.addElement(tickets.get(i));

                            }

                            }



                            void setTicketReference(ArrayList<Ticket> tickets)

                            {

                            this.tickets = tickets;

                            //this.setTickets(tickets);

                            }

                            }
 
