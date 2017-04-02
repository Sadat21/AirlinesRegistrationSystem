import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author brain
 * @version 1.0
 * @since 4/2/2017
 */
public class AdminGUI extends JFrame {
	private JList TicketDisplay;
	private JPanel MainPanel;
	private JButton addFlightButton;
	private JButton addFlightFromFileButton;
	private JButton cancelTicketButton;
	private JPanel SouthPanel;
	private JPanel NorthPanel;
	private Listener listener;
	private Container c;

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		AdminGUI test = new AdminGUI();
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;

		test.setLocation(screenWidth/3, screenHeight/3);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setVisible(true);
	}

	public AdminGUI()
	{
		setTitle("Admin Client Program");
		setSize(750, 600);
		c = getContentPane();
		MainPanel = new JPanel();
		MainPanel.setLayout(new BorderLayout(0, 0));
		c.add(MainPanel);
		TicketDisplay = new JList();
		TicketDisplay.setSelectionMode(0);
		MainPanel.add(TicketDisplay, BorderLayout.CENTER);
		SouthPanel = new JPanel();
		SouthPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		MainPanel.add(SouthPanel, BorderLayout.SOUTH);
		addFlightButton = new JButton();
		addFlightButton.setText("Add Flight");
		SouthPanel.add(addFlightButton);
		addFlightFromFileButton = new JButton();
		addFlightFromFileButton.setText("Add Flight from File");
		SouthPanel.add(addFlightFromFileButton);
		cancelTicketButton = new JButton();
		cancelTicketButton.setText("Cancel Ticket");
		SouthPanel.add(cancelTicketButton);
		NorthPanel = new JPanel();
		NorthPanel.setLayout(new BorderLayout(0, 0));
		MainPanel.add(NorthPanel, BorderLayout.NORTH);
		final JLabel label1 = new JLabel();
		label1.setText("Admin Management System");
		NorthPanel.add(label1, BorderLayout.NORTH);
		final JLabel label2 = new JLabel();
		label2.setText("Tickets");
		NorthPanel.add(label2, BorderLayout.CENTER);
		final JSeparator separator1 = new JSeparator();
		NorthPanel.add(separator1, BorderLayout.SOUTH);

		addFlightButton.addActionListener(listener);
		addFlightFromFileButton.addActionListener(listener);
		cancelTicketButton.addActionListener(listener);
	}

	class Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == addFlightButton)
			{

			}
			else if (e.getSource() == addFlightFromFileButton)
			{

			}
			else if (e.getSource() == cancelTicketButton)
			{

			}
		}
	}
}
