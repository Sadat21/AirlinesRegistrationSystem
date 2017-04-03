import javax.swing.*;
import java.awt.*;

/**
 * @author brain
 * @version 1.0
 * @since 4/2/2017
 */
public class PassengerGUITEMP {

	// TODO: Error check all of the data fields
	// TODO:

	private JPanel BFPanel;
	private JPanel SFPanel;
	private JPanel SRPanel;
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

	{
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
		$$$setupUI$$$();
	}

	/**
	 * Method generated by IntelliJ IDEA GUI Designer
	 * >>> IMPORTANT!! <<<
	 * DO NOT edit this method OR call it in your code!
	 *
	 * @noinspection ALL
	 */
	private void $$$setupUI$$$() {
		final JPanel panel1 = new JPanel();
		panel1.setLayout(new GridBagLayout());
		BFPanel = new JPanel();
		BFPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbc;
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		panel1.add(BFPanel, gbc);
		final JLabel label1 = new JLabel();
		label1.setFont(new Font(label1.getFont().getName(), Font.BOLD, 24));
		label1.setText("Book a Flight");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		BFPanel.add(label1, gbc);
		from = new JLabel();
		from.setText("From:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.WEST;
		BFPanel.add(from, gbc);
		final JPanel spacer1 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 32;
		gbc.fill = GridBagConstraints.VERTICAL;
		BFPanel.add(spacer1, gbc);
		To = new JLabel();
		To.setText("To:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 8;
		gbc.anchor = GridBagConstraints.WEST;
		BFPanel.add(To, gbc);
		textField1 = new JTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 9;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		BFPanel.add(textField1, gbc);
		final JSeparator separator1 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		BFPanel.add(separator1, gbc);
		final JSeparator separator2 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 11;
		gbc.fill = GridBagConstraints.BOTH;
		BFPanel.add(separator2, gbc);
		final JPanel spacer2 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.fill = GridBagConstraints.VERTICAL;
		BFPanel.add(spacer2, gbc);
		final JPanel spacer3 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 7;
		gbc.fill = GridBagConstraints.VERTICAL;
		BFPanel.add(spacer3, gbc);
		final JPanel spacer4 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 10;
		gbc.fill = GridBagConstraints.VERTICAL;
		BFPanel.add(spacer4, gbc);
		final JSeparator separator3 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.fill = GridBagConstraints.BOTH;
		BFPanel.add(separator3, gbc);
		textField2 = new JTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		BFPanel.add(textField2, gbc);
		final JPanel spacer5 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.ipady = 10;
		BFPanel.add(spacer5, gbc);
		MDY = new JPanel();
		MDY.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 24;
		gbc.fill = GridBagConstraints.BOTH;
		BFPanel.add(MDY, gbc);
		final JLabel label2 = new JLabel();
		label2.setText("Month");
		MDY.add(label2);
		final com.intellij.uiDesigner.core.Spacer spacer6 = new com.intellij.uiDesigner.core.Spacer();
		MDY.add(spacer6);
		final JLabel label3 = new JLabel();
		label3.setText("Day");
		MDY.add(label3);
		final com.intellij.uiDesigner.core.Spacer spacer7 = new com.intellij.uiDesigner.core.Spacer();
		MDY.add(spacer7);
		final JLabel label4 = new JLabel();
		label4.setText("Year");
		MDY.add(label4);
		final JPanel spacer8 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 12;
		gbc.fill = GridBagConstraints.VERTICAL;
		BFPanel.add(spacer8, gbc);
		final JLabel label5 = new JLabel();
		label5.setText("First name:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 13;
		gbc.anchor = GridBagConstraints.WEST;
		BFPanel.add(label5, gbc);
		textField3 = new JTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 14;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		BFPanel.add(textField3, gbc);
		final JPanel spacer9 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 15;
		gbc.fill = GridBagConstraints.VERTICAL;
		BFPanel.add(spacer9, gbc);
		final JSeparator separator4 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 16;
		gbc.fill = GridBagConstraints.BOTH;
		BFPanel.add(separator4, gbc);
		final JPanel spacer10 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 17;
		gbc.fill = GridBagConstraints.VERTICAL;
		BFPanel.add(spacer10, gbc);
		final JLabel label6 = new JLabel();
		label6.setText("Last name:");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 18;
		gbc.anchor = GridBagConstraints.WEST;
		BFPanel.add(label6, gbc);
		textField4 = new JTextField();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 19;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		BFPanel.add(textField4, gbc);
		final JPanel spacer11 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 20;
		gbc.fill = GridBagConstraints.VERTICAL;
		BFPanel.add(spacer11, gbc);
		final JSeparator separator5 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 21;
		gbc.fill = GridBagConstraints.BOTH;
		BFPanel.add(separator5, gbc);
		final JPanel spacer12 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 22;
		gbc.fill = GridBagConstraints.VERTICAL;
		BFPanel.add(spacer12, gbc);
		final JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 25;
		gbc.fill = GridBagConstraints.BOTH;
		BFPanel.add(panel2, gbc);
		comboBox1 = new JComboBox();
		panel2.add(comboBox1);
		final com.intellij.uiDesigner.core.Spacer spacer13 = new com.intellij.uiDesigner.core.Spacer();
		panel2.add(spacer13);
		comboBox2 = new JComboBox();
		panel2.add(comboBox2);
		final com.intellij.uiDesigner.core.Spacer spacer14 = new com.intellij.uiDesigner.core.Spacer();
		panel2.add(spacer14);
		comboBox3 = new JComboBox();
		panel2.add(comboBox3);
		final JLabel label7 = new JLabel();
		label7.setText("Date of Birth");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 23;
		gbc.anchor = GridBagConstraints.WEST;
		BFPanel.add(label7, gbc);
		final JPanel spacer15 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 26;
		gbc.fill = GridBagConstraints.VERTICAL;
		BFPanel.add(spacer15, gbc);
		final JSeparator separator6 = new JSeparator();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 27;
		gbc.fill = GridBagConstraints.BOTH;
		BFPanel.add(separator6, gbc);
		final JLabel label8 = new JLabel();
		label8.setText("Departure Date and Time");
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 29;
		gbc.anchor = GridBagConstraints.WEST;
		BFPanel.add(label8, gbc);
		final JPanel spacer16 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 28;
		gbc.fill = GridBagConstraints.VERTICAL;
		BFPanel.add(spacer16, gbc);
		final JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 30;
		gbc.fill = GridBagConstraints.BOTH;
		BFPanel.add(panel3, gbc);
		final JLabel label9 = new JLabel();
		label9.setText("Month");
		panel3.add(label9);
		final com.intellij.uiDesigner.core.Spacer spacer17 = new com.intellij.uiDesigner.core.Spacer();
		panel3.add(spacer17);
		final JLabel label10 = new JLabel();
		label10.setText("Day");
		panel3.add(label10);
		final com.intellij.uiDesigner.core.Spacer spacer18 = new com.intellij.uiDesigner.core.Spacer();
		panel3.add(spacer18);
		final JLabel label11 = new JLabel();
		label11.setText("Year");
		panel3.add(label11);
		final JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 31;
		gbc.fill = GridBagConstraints.BOTH;
		BFPanel.add(panel4, gbc);
		final JComboBox comboBox4 = new JComboBox();
		panel4.add(comboBox4);
		final com.intellij.uiDesigner.core.Spacer spacer19 = new com.intellij.uiDesigner.core.Spacer();
		panel4.add(spacer19);
		final JComboBox comboBox5 = new JComboBox();
		panel4.add(comboBox5);
		final com.intellij.uiDesigner.core.Spacer spacer20 = new com.intellij.uiDesigner.core.Spacer();
		panel4.add(spacer20);
		final JComboBox comboBox6 = new JComboBox();
		panel4.add(comboBox6);
		SFPanel = new JPanel();
		SFPanel.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		panel1.add(SFPanel, gbc);
		final JPanel spacer21 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipadx = 20;
		SFPanel.add(spacer21, gbc);
		final JPanel spacer22 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipadx = 20;
		SFPanel.add(spacer22, gbc);
		final JSeparator separator7 = new JSeparator();
		separator7.setOrientation(1);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.ipady = 450;
		SFPanel.add(separator7, gbc);
		SRPanel = new JPanel();
		SRPanel.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.BOTH;
		panel1.add(SRPanel, gbc);
		final JPanel spacer23 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.VERTICAL;
		panel1.add(spacer23, gbc);
		final JPanel spacer24 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel1.add(spacer24, gbc);
		final JPanel spacer25 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		panel1.add(spacer25, gbc);
		final JPanel spacer26 = new JPanel();
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.VERTICAL;
		panel1.add(spacer26, gbc);
	}
}
