import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Brian on 2017-04-07.
 */
public class LoginGUI extends JFrame
{
    private JPanel MainPanel;
    private JButton Sign_InButton;
    private JLabel TitleLabel;
    private JTextField TFR1;
    private JPasswordField TFR2;
    private JPanel PanelTwo;
    private JPanel PasswordPanel;
    private JPanel SignInButtonPanel;
    private JPanel TitlePanel;
    private JPanel PanelOne;
    private JPanel SignUpButtonPanel;
    private JComboBox comboBox;
    private JLabel LabelL1;
    private JLabel LabelL2;
    private JLabel LabelL3;
    private JTextField TFL1;
    private JPasswordField TFL2;
    private JPasswordField TFL3;
    private JLabel LabelR1;
    private JLabel LabelR2;
    private JButton Sign_UpButton;
    private JSeparator JSep1;
    private JSeparator JSep2;
    private Listener listener;
    private Container c;
    private String [] statuses = {"-", "Pass", "Admin"};

    public static void main(String[] args)
    {
        try {
            UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        LoginGUI test = new LoginGUI();
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setVisible(true);
    }

    public LoginGUI() {
        setTitle("Client Manager");
        setSize(800, 380);
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
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        MainPanel.add(PanelOne, gbc);
        SignUpButtonPanel = new JPanel();
        SignUpButtonPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        PanelOne.add(SignUpButtonPanel, gbc);
        LabelL2 = new JLabel();
        LabelL2.setText("Password");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 10);
        SignUpButtonPanel.add(LabelL2, gbc);
        LabelL1 = new JLabel();
        LabelL1.setText("Username");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 10);
        PanelOne.add(LabelL1, gbc);
        TFL1 = new JTextField();
        TFL1.setColumns(20);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        PanelOne.add(TFL1, gbc);
        TFL2 = new JPasswordField();
        TFL2.setColumns(20);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        PanelOne.add(TFL2, gbc);
        LabelL3 = new JLabel();
        LabelL3.setText("Reenter Password");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 0, 10, 10);
        PanelOne.add(LabelL3, gbc);
        TFL3 = new JPasswordField();
        TFL3.setColumns(20);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        PanelOne.add(TFL3, gbc);
        Sign_UpButton = new JButton();
        Sign_UpButton.setText("Sign Up");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.insets = new Insets(10, 10, 10, 10);
        PanelOne.add(Sign_UpButton, gbc);
        comboBox = new JComboBox(statuses);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        PanelOne.add(comboBox, gbc);
        TitlePanel = new JPanel();
        TitlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        MainPanel.add(TitlePanel, gbc);
        TitleLabel = new JLabel();
        TitleLabel.setEnabled(true);
        TitleLabel.setFont(new Font(TitleLabel.getFont().getName(), Font.BOLD, 36));
        TitleLabel.setText("Sign In/Up Panel");
        TitlePanel.add(TitleLabel);
        PanelTwo = new JPanel();
        PanelTwo.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        MainPanel.add(PanelTwo, gbc);
        PasswordPanel = new JPanel();
        PasswordPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        PanelTwo.add(PasswordPanel, gbc);
        SignInButtonPanel = new JPanel();
        SignInButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        PanelTwo.add(SignInButtonPanel, gbc);
        LabelR1 = new JLabel();
        LabelR1.setText("Username");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 10);
        PanelTwo.add(LabelR1, gbc);
        TFR1 = new JTextField();
        TFR1.setColumns(20);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        PanelTwo.add(TFR1, gbc);
        LabelR2 = new JLabel();
        LabelR2.setText("Password");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 10, 10);
        PanelTwo.add(LabelR2, gbc);
        TFR2 = new JPasswordField();
        TFR2.setColumns(20);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        PanelTwo.add(TFR2, gbc);
        Sign_InButton = new JButton();
        Sign_InButton.setText("Sign In");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        PanelTwo.add(Sign_InButton, gbc);
        JSep1 = new JSeparator();
        JSep1.setOrientation(1);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        MainPanel.add(JSep1, gbc);
        JSep2 = new JSeparator();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        MainPanel.add(JSep2, gbc);
        Sign_InButton.addActionListener(listener);
        Sign_UpButton.addActionListener(listener);
    }
    class Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == Sign_UpButton)
            {
                String status = (String)comboBox.getSelectedItem();

                String username = TFL1.getText();
                if(username.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter a username");
                    return;
                }

                char [] password = TFL2.getPassword();
                String pass = new String(password);

                if(pass.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter a password");
                    return;
                }

                char [] rePassword = TFL3.getPassword();
                String rePass = new String(rePassword);

                if(rePassword.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please re-enter the password");
                    return;
                }

                if(!pass.equals(rePass))
                {
                    JOptionPane.showMessageDialog(null, "Password and re-entered password don't match");
                    return;
                }

                if(status.equals("-"))
                {
                    JOptionPane.showMessageDialog(null, "Please select a user status");
                    return;
                }
                String temp = "SIGNUP\t";
                temp += username;
                temp += "\t";
                temp += pass;
                temp += "\t";
                temp += status;
                Global.toGo = temp;
            }

            if(e.getSource() == Sign_InButton)
            {
                String username = TFR1.getText();
                if(username.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter a username");
                    return;
                }

                char [] password = TFR2.getPassword();
                String pass = new String(password);
                if(pass.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Please enter a password");
                    return;
                }

                String temp = "LOGIN\t";
                temp += username;
                temp += "\t";
                temp += pass;
                Global.toGo = temp;
                System.out.println(temp);
            }
            return;
        }
    }
}
