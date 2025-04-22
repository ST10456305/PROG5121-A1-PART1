package chatapp;

import java.awt.*;
import javax.swing.*;

public class LoginGUI extends JFrame {

    // Instance Variables
    private JTextField usernameField, phoneField, loginUsernameField;
    private JPasswordField passwordField, loginPasswordField;
    private JButton registerButton, loginButton;
    private JTextArea outputArea;
    private Login loginInstance = new Login();

    // Constructor
    public LoginGUI() {
        setTitle("ChatApp Login & Registration");
        setSize(600, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        // Registration Panel
        JPanel registerPanel = new JPanel(new GridLayout(5, 2));
        registerPanel.setBorder(BorderFactory.createTitledBorder("Register"));
        registerPanel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        registerPanel.add(usernameField);

        registerPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        registerPanel.add(passwordField);

        registerPanel.add(new JLabel("Cell Phone (+27...):"));
        phoneField = new JTextField();
        registerPanel.add(phoneField);

        registerButton = new JButton("Register");
        registerPanel.add(registerButton);

        // Login Panel
        JPanel loginPanel = new JPanel(new GridLayout(4, 2));
        loginPanel.setBorder(BorderFactory.createTitledBorder("Login"));
        loginPanel.add(new JLabel("Username:"));
        loginUsernameField = new JTextField();
        loginPanel.add(loginUsernameField);

        loginPanel.add(new JLabel("Password:"));
        loginPasswordField = new JPasswordField();
        loginPanel.add(loginPasswordField);

        loginButton = new JButton("Login");
        loginPanel.add(loginButton);

        // Output
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(registerPanel);
        add(loginPanel);
        add(scrollPane, BorderLayout.SOUTH);

        // Register Action
        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String phone = phoneField.getText();
            String result = loginInstance.registerUser(username, password, phone);
            outputArea.setText(result);
        });

        // Login Action
        loginButton.addActionListener(e -> {
            String username = loginUsernameField.getText();
            String password = new String(loginPasswordField.getPassword());
            boolean success = loginInstance.loginUser(username, password);
            String result = loginInstance.returnLoginStatus(success, "User", "Name");
            outputArea.setText(result);
        });

        setVisible(true);
    }
}
