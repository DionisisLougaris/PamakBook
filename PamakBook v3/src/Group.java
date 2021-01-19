import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Group implements Serializable{
		protected String name;
		protected String info;
		protected ArrayList<User> members;
		
		
		public Group(String text1,String text2)
		{
			name=text1;
			info=text2;
			members = new ArrayList<>();
		}

		//Analyzing membership
		public boolean membership(User U)
		{
			boolean found=false;
			for(int i=0;i<this.members.size();i++)
				if(this.members.get(i)==U)
					found=true;
			return found;
		}
		
		
		//Adding and printing members of group
		public void addMember(User U)
		{
			boolean found=this.membership(U);
			if(found)
				JOptionPane.showMessageDialog(null, "You are already a member of "+this.name);
			else
			{
				this.members.add(U);
				JOptionPane.showMessageDialog(null, "You joined successfully");
				
			}

		}
		
		public void printMembers()
		{
			System.out.println("*******************************");
			System.out.println("Members of group "+ this.name);
			System.out.println("*******************************");
			for(int i=0;i<this.members.size();i++)
				System.out.println((i+1)+": "+this.members.get(i).getName());
			System.out.println("-----------------------------");
			
		}
		
		
		//Getters
		public String getName() {
			return name;
		}

		public String getInfo() {
			return info;
		}
		
		
}
