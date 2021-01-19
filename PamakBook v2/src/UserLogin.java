import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class UserLogin extends JFrame{
	
	
	private JPanel panel;
	private JTextField userField;    
	private JButton enterUserPageButton, showPotInfectionsButton;
	private ArrayList<User> allUsers = new ArrayList<User>();
	
	public UserLogin(ArrayList<User> Users)
	{
		allUsers=Users;
		
	
		panel= new JPanel();
		userField=new JTextField("Please enter your name...");
		enterUserPageButton = new JButton("Enter User Page");
		showPotInfectionsButton = new JButton("Show Potential Infections");
		panel.add(userField);
		panel.add(enterUserPageButton);
		panel.add(showPotInfectionsButton);
		
		this.setContentPane(panel);
		
		ButtonListener listener = new ButtonListener();
		enterUserPageButton.addActionListener(listener);
		showPotInfectionsButton.addActionListener(listener);
		
		
		this.setVisible(true);
		this.setSize(280,250);
		this.setTitle("Είσοδος χρήστη");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	class ButtonListener implements ActionListener {

		//Implementing actionPerformed method in order to give activity to our buttons
		public void actionPerformed(ActionEvent element) 
		{
			
			String name =userField.getText();
			ArrayList<User> search = allUsers;
			
			if(element.getSource().equals(enterUserPageButton))
			{
				//searching given user amongst all users
				boolean found=false;
				for(int i=0;i<search.size();i++)
				{
					
					if(name.equals(search.get(i).getName())==true)
					{
						dispose();
						found=true;
						UserPage hisPage = new UserPage(search.get(i),allUsers);
						
					}

				}
				if(found==false)
					{
						JOptionPane.showMessageDialog(null, "User " + name + " Not Found..");
				
					
					}
			}
			else if((element.getSource().equals(showPotInfectionsButton)))
				{
				    //searching given user amongst all users
					boolean found=false;
					for(int i=0;i<search.size();i++)
					{
						
						if(name.equals(search.get(i).getName())==true)
						{
							dispose();
							found=true;
							//Showing potential infected based on User's relationships
							PossiblyInfected inf = new PossiblyInfected(search.get(i),allUsers);
							
						}
					}
					if(found==false)
					{
						JOptionPane.showMessageDialog(null, "User " + name + " Not Found..");
						
					}
						
				}
		
			}
			
		}
		
	}



