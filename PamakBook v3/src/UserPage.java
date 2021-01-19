import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UserPage extends JFrame{
	
	

	private JPanel panel;
	private JTextField nameField, emailField,addFriendField;
	private JButton backToScreenButton, postButton,addFriendButton,joinButton;
	private JTextArea myPostTextArea,PostTextArea,sugFriendsArea;
	private JLabel recentPosts,sugFriends,addFriend,availableGroups;
	private JList list;
	private DefaultListModel model;
	private ArrayList<User> allUsers = new ArrayList<User>();
	private ArrayList<Group> groups = new ArrayList<Group>();
	private User myUser;
	
	
	
	public UserPage(User aUser,ArrayList<User> Users,ArrayList<Group> groups)
	{
		
		
		myUser =aUser;
		allUsers=Users;
		this.groups=groups;
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
		sugFriendsArea= new JTextArea(" ");
		for(int i=0;i<aUser.SuggestedFriends().size();i++)
			sugFriendsArea.append(aUser.SuggestedFriends().get(i).getName()+ "\n\r");
		JLabel emptyLabel = new JLabel("                      ");
		recentPosts= new JLabel("Recent Posts by Friends");
		JLabel emptyLabel2 = new JLabel("                      ");
		sugFriends = new JLabel("Suggested Friends");
		JLabel emptyLabel3 = new JLabel("                                                                      ");
		addFriend = new JLabel("Add Friend");
		addFriendField = new JTextField("Type username here...");
		addFriendButton = new JButton("Add");
		JLabel emptyLabel4 = new JLabel("                             ");
		list = new JList();
		model = new DefaultListModel();
		for(int i=0;i<groups.size();i++)
			model.addElement(groups.get(i).getName());
		
		list.setModel(model);
		availableGroups = new JLabel("Available Groups");
		joinButton = new JButton("Join");
		
		//adding everything to panel
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
		panel.add(emptyLabel3);
		panel.add(addFriend);
		panel.add(addFriendField);
		panel.add(addFriendButton);
		panel.add(emptyLabel4);
		panel.add(availableGroups);
		panel.add(list);
		panel.add(joinButton);
		
		//giving activity to buttons
		ButtonListener listener = new ButtonListener();
		addFriendButton.addActionListener(listener);
		backToScreenButton.addActionListener(listener);
		postButton.addActionListener(listener);
		joinButton.addActionListener(listener);
		
		
		this.setContentPane(panel);
		this.setVisible(true);
		this.setSize(350,600);
		this.setTitle("Σελίδα Χρήστη");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent element) {
			
			//getting user's input from fields
			String myPost = myPostTextArea.getText();
			String addedFriend = addFriendField.getText();
			
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
				//returning to Main Page
				MainPage GUI = new MainPage(allUsers,groups);
			}
			else if(element.getSource().equals(addFriendButton))
			{
				
				//searching given user amongst all users 
				boolean found=false;
				for(int i=0;i<allUsers.size();i++)
				{
					//adding friend
					if(addedFriend.equals(allUsers.get(i).getName())==true)
					{
						found=true;
						myUser.addFriend(allUsers.get(i));
						JOptionPane.showMessageDialog(null, "You successfully added "+ addedFriend+" !");
					}

				}
				if(found==false)
					{
						JOptionPane.showMessageDialog(null, "No user with this name exists on PamakBook...");
						
					}
			}
			else if(element.getSource().equals(joinButton))
			{
				//User join selected group from list
				String selectedGroupName = (String) list.getSelectedValue();
				Group selectedGroup = null;
				for(int i=0;i<groups.size();i++)
				{
					if(groups.get(i).getName().equals(selectedGroupName))
							selectedGroup= groups.get(i);
					
				}
					selectedGroup.addMember(myUser);
			}
		}
	}
}
