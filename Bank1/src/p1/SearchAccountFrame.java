package p1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SearchAccountFrame extends JFrame {
    
	private static final long serialVersionUID = 1L;
	private JTextField accountNumberField;

    public SearchAccountFrame() {
        super("Search Account");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 150);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 2));

        panel.add(new JLabel("Account Number:"));
        accountNumberField = new JTextField();
        panel.add(accountNumberField);

        JButton searchButton = new JButton("Search Account");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String accountNumber = accountNumberField.getText();
                    BankAccount account = BankSystem.getInstance().getAccount(accountNumber);

                    if (account != null) {
                        // Display account details
                        JOptionPane.showMessageDialog(SearchAccountFrame.this,
                                "Account Details:\n" +
                                        "Account Number: " + account.getAccountNumber() + "\n" +
                                        "Name: " + account.getName() + "\n" +
                                        "Balance: " + account.getBalance(),
                                "Account Details", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(SearchAccountFrame.this,
                                "Account not found", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SearchAccountFrame.this,
                            "Error searching account", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(searchButton);

        add(panel);
        setVisible(true);
    }
}
