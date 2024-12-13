package p1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DeleteAccountFrame extends JFrame {
    
	private static final long serialVersionUID = 1L;
	private JTextField accountNumberField;

    public DeleteAccountFrame() {
        super("Delete Account");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 150);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 2));

        panel.add(new JLabel("Account Number:"));
        accountNumberField = new JTextField();
        panel.add(accountNumberField);

        JButton deleteButton = new JButton("Delete Account");
        deleteButton.setPreferredSize(new Dimension(150, 30)); // Set a fixed size
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String accountNumber = accountNumberField.getText();

                    BankSystem bankSystem = BankSystem.getInstance();
                    BankAccount account = bankSystem.getAccount(accountNumber);

                    if (account != null) {
                        bankSystem.deleteAccount(accountNumber);
                        JOptionPane.showMessageDialog(DeleteAccountFrame.this, "Account deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                        dispose(); // Close the delete account frame
                    } else {
                        JOptionPane.showMessageDialog(DeleteAccountFrame.this, "Account not found", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(DeleteAccountFrame.this, "Error deleting account", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(deleteButton);

        add(panel);
        setVisible(true);
    }
}
