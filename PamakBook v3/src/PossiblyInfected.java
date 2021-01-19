import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class PossiblyInfected extends JFrame{
	
	private ArrayList<User> allUsers;
	private ArrayList<Group> groups = new ArrayList<Group>();
	private JPanel panel;
	private JButton backToLoginButton;
	private JTextArea possibleCarriers;
	
	
	public PossiblyInfected(User aUser,ArrayList<User> Users)
	{
		allUsers=Users;
		this.groups=groups;
		panel=new JPanel();
		backToLoginButton = new JButton("Back to Login Screen");
		possibleCarriers = new JTextArea(10,10);
		possibleCarriers.append("**********************************************************"+ "\n");
		possibleCarriers.append(aUser.getName() +" has been infected.The following have to be tested"+ "\n");
		possibleCarriers.append("**********************************************************"+ "\n");
		//Printing potential infected based on User's relationships
		for(int i=0;i<aUser.Infected().size();i++)
		{
			possibleCarriers.append(aUser.Infected().get(i).getName()+"\n");
		}
		
		//adding everything to panel
		panel.add(possibleCarriers);
		panel.add(backToLoginButton);
		
		//giving activity to button
		ButtonListener listener = new ButtonListener();
		backToLoginButton.addActionListener(listener);
		
		
		this.setContentPane(panel);
		this.setVisible(true);
		this.setSize(350,350);
		this.setTitle("Πιθανή Μετάδοση Ιού");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent element) 
		{
			dispose();
			//returning to Main Page 
			MainPage GUI=new MainPage(allUsers,groups);
		}
	}
	
}
