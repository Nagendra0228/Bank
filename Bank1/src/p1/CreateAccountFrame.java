package p1;

import javax.swing.JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CreateAccountFrame extends JFrame {
   
	private static final long serialVersionUID = 1L;
	private JTextField accountNumberField;
    private JTextField nameField;
    private JTextField initialDepositField;

    public CreateAccountFrame() {
        super("Create Account");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        panel.add(new JLabel("Account Number:"));
        accountNumberField = new JTextField();
        panel.add(accountNumberField);

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Initial Deposit:"));
        initialDepositField = new JTextField();
        panel.add(initialDepositField);

        JButton createButton = new JButton("Create Account");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String accountNumber = accountNumberField.getText();
                    String name = nameField.getText();
                    double initialDeposit = Double.parseDouble(initialDepositField.getText());

                    if (initialDeposit < 500) {
                        JOptionPane.showMessageDialog(CreateAccountFrame.this, "Initial deposit must be at least 500", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        BankSystem.getInstance().createAccount(accountNumber, name, initialDeposit);
                        JOptionPane.showMessageDialog(CreateAccountFrame.this, "Account created successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                        dispose(); // Close the create account frame
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(CreateAccountFrame.this, "Invalid initial deposit amount", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(createButton);

        add(panel);
        setVisible(true);
    }
}



