package election;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

//Michelle Farrington
public class VotingBooth extends JPanel implements ActionListener, ItemListener {
	// A PANEL WITH CardLayout
	JPanel cards;
	final String LISTPANEL = "View Elections";
	final String TEXTPANEL = "Administrative Access";

	ElectionDAO dao = new ElectionDAO();

	JButton select = new JButton("Select");
	JButton add = new JButton("Add New Election");
	JList list;
	ArrayList<CandidateItem> allCandidates = dao.getAllCandidates();

	JButton submitPassword = new JButton("Submit");
	JLabel passwordEntryMsg = new JLabel("Enter Password Here");
	JTextField passwordEntryField = new JTextField(20);

	String comboBoxItems[] = { LISTPANEL, TEXTPANEL };
	JComboBox cb = new JComboBox(comboBoxItems);

	ElectionTally elect = new ElectionTally();
	JFrame adminFrame;
	JFrame voteFrame;
	VotingBooth voting;

	public VotingBooth() {

		this.voting = this;

		// Put the JComboBox in a JPanel.
		JPanel comboBoxPane = new JPanel();
		cb.setEditable(false);
		ComboListener cListen = new ComboListener();
		cb.addItemListener(cListen);
		comboBoxPane.add(cb);

		// CREATE CARD 1
		JPanel card1 = new JPanel();
		list = new JList(allCandidates.toArray());
		JScrollPane scroll = new JScrollPane(list);

		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(350, 100));

		add(scroll, BorderLayout.CENTER);

		ButtonListener l = new ButtonListener();
		select.addActionListener(l);
		add.addActionListener(l);
		JPanel buttonPanel = new JPanel();

		buttonPanel.add(select);
		buttonPanel.add(add);

		add(buttonPanel, BorderLayout.SOUTH);

		card1.add(scroll);
		card1.add(buttonPanel);

		// CREATE CARD 2
		JPanel card2 = new JPanel();
		card2.add(passwordEntryMsg);
		card2.add(passwordEntryField);
		card2.add(submitPassword);

		// CREATE PANEL THAT CONTAINS THE 'CARDS'.
		cards = new JPanel(new CardLayout());
		cards.add(card1, LISTPANEL);
		cards.add(card2, TEXTPANEL);

		add(comboBoxPane, BorderLayout.PAGE_START);
		add(cards, BorderLayout.CENTER);

		PasswordSubmitClickListener passwordcl = new PasswordSubmitClickListener();
		submitPassword.addActionListener(passwordcl);

	}

	public void newVote() {
		cb.setSelectedItem(LISTPANEL);
		elect = new ElectionTally();
	}

	public void closeAdmin() {
		cb.setSelectedItem(LISTPANEL);
		adminFrame.dispose();
	}

	private class ComboListener implements ItemListener {
		public void itemStateChanged(ItemEvent evt) {
			CardLayout cl = (CardLayout) (cards.getLayout());
			cl.show(cards, (String) evt.getItem());
		}
	}

	

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == select) {
				int index = list.getSelectedIndex();
				System.out.println(index);
				
				voteFrame = new JFrame();
				JPanel newVotingPanel = new VoteCandidatePanel();
				voteFrame.add(newVotingPanel);
				voteFrame.setSize(305, 200);
				voteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				voteFrame.setVisible(true);

			}

			if (e.getSource() == add) {
				System.out.println("Add new election");
				JPanel newPanel = new CreateElectionPanel();
			}
		}
	}

	public JPanel showElectionResults() {
		JPanel results = new JPanel();
		JLabel electionResult = new JLabel("Election Results:");
		JLabel resultsOne = new JLabel("Votes for Louis CK: " + elect.getTotalVotesOne());
		JLabel resultsTwo = new JLabel("Votes for Mitch Hedberg: " + elect.getTotalVotesTwo());
		JLabel resultsThree = new JLabel("Votes for George Carlin: " + elect.getTotalVotesThree());
		JLabel resultsTotal = new JLabel("Total Votes Cast: " + elect.getAllVotesTotal());
		results.add(electionResult);
		results.add(resultsOne);
		results.add(resultsTwo);
		results.add(resultsThree);
		results.add(resultsTotal);
		return results;
	}

	class PasswordSubmitClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Button Clicked to Submit Admin Password");
			String passwordMaster = "soup";
			String passwordEntry = passwordEntryField.getText();
			if (passwordEntry.equals(passwordMaster)) {

				adminFrame = new JFrame();
				JPanel panel = new AdminPanel(voting);

				adminFrame.add(panel);
				adminFrame.setSize(305, 200);
				adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				adminFrame.setVisible(true);

			} else if (!passwordEntryField.equals(passwordMaster)) {
				JOptionPane.showMessageDialog(null, "Password Not Valid");
			}
			passwordEntryField.setText("");
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
