import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;






public class MainPage extends JFrame{
	
	private JPanel panel;
	private JButton newUserButton, enterUserPageButton,showPotInfectionsButton,savePamakBookButton;
	private JTextField nameField,emailField;    
	private ArrayList<User> allUsers = new ArrayList<User>();
	private ArrayList<Group> groups = new ArrayList<Group>();
	
	public MainPage(ArrayList<User> Users,ArrayList<Group> groups) {
	
		
		allUsers=Users;
		this.groups=groups;
		panel= new JPanel();
		newUserButton= new JButton("New User");
		enterUserPageButton = new JButton("Enter User Page");
		showPotInfectionsButton = new JButton("Show Potential Infections");
		savePamakBookButton= new JButton("Save PamakBook");
		nameField=new JTextField("Username");
		emailField=new JTextField("Email");
	
		
		//adding everything to panel
		panel.add(newUserButton);
		panel.add(nameField);
		panel.add(emailField);
		panel.add(enterUserPageButton);
		panel.add(showPotInfectionsButton);
		panel.add(savePamakBookButton);
		
		this.setContentPane(panel);
		
		
		//giving activity to buttons
		ButtonListener listener = new ButtonListener();
		newUserButton.addActionListener(listener);
		showPotInfectionsButton.addActionListener(listener);
		savePamakBookButton.addActionListener(listener);
		enterUserPageButton.addActionListener(listener);
		
		
		
		this.setVisible(true);
		this.setSize(350,180);
		this.setTitle("Κεντρική Σελίδα");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	class ButtonListener implements ActionListener {


		public void actionPerformed(ActionEvent element) {
			
			String name =nameField.getText();
			String email =emailField.getText();
			ArrayList<User> search = allUsers;
			
			if(element.getSource().equals(newUserButton))
			{
				//searching for user in PamakBook and if not found, user is created
				boolean found=false;
				for(int i=0;i<search.size();i++)
				{
					
					if(name.equals(search.get(i).getName())==true)
					{
						found=true;
						JOptionPane.showMessageDialog(null, "User already exists..");
						
					}

				}
				if(found==false)
					{
						User aUser = new User(name,email);
						allUsers.add(aUser);
						JOptionPane.showMessageDialog(null, "User added to PamakBook!");
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
						UserPage hisPage = new UserPage(search.get(i),allUsers,groups);
						
					}

				}
				if(found==false)
					{
						JOptionPane.showMessageDialog(null, "User " + name + " Not Found..");
			
					}
			}
			else if(element.getSource().equals(savePamakBookButton))
			{
				//saving all PamakBook data (Users,Groups,Posts) on PamakBook.ser
				try {
					FileOutputStream fileOut = new FileOutputStream("PamakBook.ser");
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					out.writeObject(allUsers);
					out.close();
					fileOut.close();		
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//confirming saving
				System.out.println("PamakBook saved!");
			}
		}
	}
	public static void FirstTry(ArrayList<User> array)
	{
		ArrayList<User> counted = new ArrayList<User>();
		int max =-1;
		for(int i=0;i<array.size();i++)
		{
			counted.add(array.get(i));
			for(int j=0;j<array.get(i).getFriends().size();j++)
			{
				
			}
	}
	
}
}
