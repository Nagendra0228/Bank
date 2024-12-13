package p1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class WithdrawFrame extends JFrame {
  
	private static final long serialVersionUID = 1L;
	private JTextField accountNumberField;
    private JTextField amountField;

    public WithdrawFrame() {
        super("Withdraw from Account");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        panel.add(new JLabel("Account Number:"));
        accountNumberField = new JTextField();
        panel.add(accountNumberField);

        panel.add(new JLabel("Amount to Withdraw:"));
        amountField = new JTextField();
        panel.add(amountField);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String accountNumber = accountNumberField.getText();
                    double amount = Double.parseDouble(amountField.getText());

                    BankAccount account = BankSystem.getInstance().getAccount(accountNumber);

                    if (account != null) {
                        if (account.withdraw(amount)) {
                            JOptionPane.showMessageDialog(WithdrawFrame.this,
                                    "Withdrawal successful. New balance: " + account.getBalance(),
                                    "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(WithdrawFrame.this,
                                    "Insufficient funds or below minimum balance requirement",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(WithdrawFrame.this,
                                "Account not found", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(WithdrawFrame.this,
                            "Invalid amount", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(withdrawButton);

        add(panel);
        setVisible(true);
    }
}
