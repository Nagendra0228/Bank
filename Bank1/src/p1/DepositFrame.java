package p1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DepositFrame extends JFrame {
   
	private static final long serialVersionUID = 1L;
	private JTextField accountNumberField;
    private JTextField amountField;

    public DepositFrame() {
        super("Deposit to Account");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        panel.add(new JLabel("Account Number:"));
        accountNumberField = new JTextField();
        panel.add(accountNumberField);

        panel.add(new JLabel("Amount to Deposit:"));
        amountField = new JTextField();
        panel.add(amountField);

        JButton depositButton = new JButton("Deposit");
        depositButton.setPreferredSize(new Dimension(150, 30)); // Set a fixed size
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String accountNumber = accountNumberField.getText();
                    double amount = Double.parseDouble(amountField.getText());

                    BankAccount account = BankSystem.getInstance().getAccount(accountNumber);

                    if (account != null) {
                        account.deposit(amount);
                        JOptionPane.showMessageDialog(DepositFrame.this,
                                "Deposit successful. New balance: " + account.getBalance(),
                                "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(DepositFrame.this,
                                "Account not found", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(DepositFrame.this,
                            "Invalid amount", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(depositButton);

        add(panel);
        setVisible(true);
    }
}
