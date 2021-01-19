import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UserPage extends JFrame{
	
	

	private JPanel panel;
	private JTextField nameField, emailField;
	private JButton backToScreenButton, postButton;
	private JTextArea myPostTextArea,PostTextArea,sugFriendsArea;
	private JLabel recentPosts,sugFriends;
	private ArrayList<User> allUsers = new ArrayList<User>();
	private User myUser;
	
	
	public UserPage(User aUser,ArrayList<User> Users)
	{
		myUser =aUser;
		allUsers=Users;
		panel=new JPanel();
		nameField=new JTextField(aUser.getName());
		emailField=new JTextField(aUser.getEmail());
		backToScreenButton= new JButton("Back to Login Screen");
		postButton = new JButton("Post");
		myPostTextArea = new JTextArea(10,10);
		
		PostTextArea= new JTextArea(10,10);
		
		ArrayList<Post> allPosts = new ArrayList<Post>();
		allPosts=aUser.retrnPosts();
		for(int i=0;i<allPosts.size();i++)
		{
			//Converting and formatting date to String
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String formatedDate = format.format(allPosts.get(i).getTimestamp());
			PostTextArea.append(allPosts.get(i).getPostUser().getName()+" ,"+formatedDate+" ,"+allPosts.get(i).getPostText()+ "\n\r");
	
		}
		sugFriendsArea= new JTextArea();
		for(int i=0;i<aUser.SuggestedFriends().size();i++)
			sugFriendsArea.append(aUser.SuggestedFriends().get(i).getName()+ "\n\r");
		JLabel emptyLabel = new JLabel("                      ");
		recentPosts= new JLabel("Recent Posts by Friends");
		JLabel emptyLabel2 = new JLabel("                      ");
		sugFriends = new JLabel("Suggested Friends");
		
		panel.add(nameField);
		panel.add(emailField);
		panel.add(backToScreenButton);
		panel.add(myPostTextArea);
		panel.add(postButton);
		panel.add(emptyLabel);
		panel.add(recentPosts);
		panel.add(PostTextArea);
		panel.add(emptyLabel2);
		panel.add(sugFriends);
		panel.add(sugFriendsArea);
		
		ButtonListener listener = new ButtonListener();
		backToScreenButton.addActionListener(listener);
		postButton.addActionListener(listener);
		
		this.setContentPane(panel);
		this.setVisible(true);
		this.setSize(400,500);
		this.setTitle("Σελίδα Χρήστη");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	class ButtonListener implements ActionListener{

		//Implementing actionPerformed method in order to give activity to our button
		public void actionPerformed(ActionEvent element) {
			
			String myPost = myPostTextArea.getText();
			
			if(element.getSource().equals(postButton))
			{
				//Creating a post when user hits "Post" button
				Post p1 = new Post(myUser,new Date(),myPost);
				myUser.addPost(p1);
				PostTextArea.selectAll();
				PostTextArea.replaceSelection("");
				for(int i=0;i<myUser.retrnPosts().size();i++)
				{
					//Converting and formatting date to String
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String formatedDate = format.format(myUser.retrnPosts().get(i).getTimestamp());
					PostTextArea.append(myUser.retrnPosts().get(i).getPostUser().getName()+" ,"+formatedDate+" ,"+myUser.retrnPosts().get(i).getPostText()+ "\n\r");
			
				}
			}
			else if(element.getSource().equals(backToScreenButton))
			{
				dispose();
				//returning to User Login screen
				UserLogin UsLog=new UserLogin(allUsers);
			}
				
			
			
			
		}
		
	}
}
