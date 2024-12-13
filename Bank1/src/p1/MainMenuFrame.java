package p1;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MainMenuFrame extends JFrame {
   
	private static final long serialVersionUID = 1L;

	public MainMenuFrame() {
        super("Banking System - Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JButton createAccountButton = new JButton("Create Account");
        JButton deleteAccountButton = new JButton("Delete Account");
        JButton searchAccountButton = new JButton("Search Account");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");

        createAccountButton.addActionListener(e -> new CreateAccountFrame());
        deleteAccountButton.addActionListener(e -> new DeleteAccountFrame());
        searchAccountButton.addActionListener(e -> new SearchAccountFrame());
        depositButton.addActionListener(e -> new DepositFrame());
        withdrawButton.addActionListener(e -> new WithdrawFrame());

        JPanel panel = new JPanel(new GridLayout(5, 1));
        panel.add(createAccountButton);
        panel.add(deleteAccountButton);
        panel.add(searchAccountButton);
        panel.add(depositButton);
        panel.add(withdrawButton);

        add(panel);
        setVisible(true);
    }
}
