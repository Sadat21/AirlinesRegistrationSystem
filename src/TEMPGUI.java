import javax.swing.*;
import java.awt.*;

/**
 * Created by Brian on 2017-04-04.
 */
public class TEMPGUI extends PassengerGUI
{

    private JButton bookFlightbutton;
    private JButton addFlightButton;
    private JButton addFlightsFromFileButton;
    private JPanel viewTickets;
    private JPanel VTTop;
    private JLabel FlightID;
    private JLabel FlightSource;
    private JLabel FlightDest;
    private JTextField TFRR1;
    private JTextField TFRR2;
    private JTextField TFRR3;
    private JSeparator JSep6;
    private JSeparator JSep7;
    private JLabel viewtickets;
    private JButton searchButtonRR;
    private JPanel ticketSearchResults;
    private JList ticketsSR;
    private JLabel SearchResults;
    private JScrollBar RRSB;
    private JButton CancelTicket;
    //private JSeparator JSep9;
    //private JPanel JPanelButtonsM;
    //private Listener listener;

    public static void main(String[] args)
    {
        try {
            UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        TEMPGUI test = new TEMPGUI();
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setVisible(true);
    }

    public TEMPGUI()
    {
        super();
        setTitle("Admin Client Program");
        setSize(1400, 680);
        JPanel MainPanel = getMainPanel();
        JPanel PanelTwo_Three = getPanelTwo_Three();
        GridBagConstraints gbc;
        addFlightButton = new JButton();
        addFlightButton.setText("Add Flight");
        PanelTwo_Three.add(addFlightButton);
        addFlightsFromFileButton = new JButton();
        addFlightsFromFileButton.setText("Add Flights from File");
        PanelTwo_Three.add(addFlightsFromFileButton);
        JSep6 = new JSeparator();
        JSep6.setOrientation(1);
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipady = 500;
        gbc.insets = new Insets(0, 10, 0, 10);
        MainPanel.add(JSep6, gbc);
        viewTickets = new JPanel();
        viewTickets.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        MainPanel.add(viewTickets, gbc);
        VTTop = new JPanel();
        VTTop.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        viewTickets.add(VTTop, gbc);
        FlightID = new JLabel();
        FlightID.setText("Flight ID");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 0, 10, 10);
        VTTop.add(FlightID, gbc);
        FlightSource = new JLabel();
        FlightSource.setText("Flight Source");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 0, 10, 10);
        VTTop.add(FlightSource, gbc);
        FlightDest = new JLabel();
        FlightDest.setText("Flight Destination");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 0, 10, 10);
        VTTop.add(FlightDest, gbc);
        TFRR2 = new JTextField();
        TFRR2.setColumns(15);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        VTTop.add(TFRR2, gbc);
        TFRR3 = new JTextField();
        TFRR3.setColumns(15);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 4;
        VTTop.add(TFRR3, gbc);
        TFRR1 = new JTextField();
        TFRR1.setColumns(15);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        VTTop.add(TFRR1, gbc);
        viewtickets = new JLabel();
        viewtickets.setFont(new Font(viewtickets.getFont().getName(), Font.BOLD, 24));
        viewtickets.setText("View Tickets");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        VTTop.add(viewtickets, gbc);
        JSep7 = new JSeparator();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 0, 10, 0);
        VTTop.add(JSep7, gbc);
        searchButtonRR = new JButton();
        searchButtonRR.setText("Search");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.insets = new Insets(10, 0, 0, 0);
        VTTop.add(searchButtonRR, gbc);
        ticketSearchResults = new JPanel();
        ticketSearchResults.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 10, 10, 10);
        viewTickets.add(ticketSearchResults, gbc);
        ticketsSR = new JList();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 7;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipadx = 300;
        gbc.ipady = 290;
        gbc.insets = new Insets(0, 0, 10, 0);
        ticketSearchResults.add(ticketsSR, gbc);
        SearchResults = new JLabel();
        SearchResults.setFont(new Font(SearchResults.getFont().getName(), Font.BOLD, 12));
        SearchResults.setText("Search Results");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 7;
        gbc.anchor = GridBagConstraints.WEST;
        ticketSearchResults.add(SearchResults, gbc);
        RRSB = new JScrollBar();
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        ticketSearchResults.add(RRSB, gbc);
        CancelTicket = new JButton();
        CancelTicket.setText("Cancel Selected Ticket");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 2;
        ticketSearchResults.add(CancelTicket, gbc);
        //JSep9 = new JSeparator();
        //JSep9.setOrientation(1);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.ipady = 500;
        gbc.insets = new Insets(0, 10, 0, 10);
        //MainPanel.add(JSep9, gbc);
    }
}
