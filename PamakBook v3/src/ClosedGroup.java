import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ClosedGroup  extends Group {
		
		
		public ClosedGroup(String text1,String text2)
		{
			super(text1, text2);
			members = new ArrayList<User>();
			
		}
		
		//Adding members of closed group (or notifying them of unavailability to join)
		public void addMember(User U)
		{

			boolean found=this.membership(U);
			boolean is=false;
			if(found)
				JOptionPane.showMessageDialog(null, "You are already a member of "+this.name);
			else
				if(this.members.isEmpty()==true)
				{
					this.members.add(U);
					JOptionPane.showMessageDialog(null, "You joined successfully");
					is=true;
				}
				else
					for(int i=0;i<this.members.size();i++)
						if(U.friendship(this.members.get(i)))
						{
							this.members.add(U);
							JOptionPane.showMessageDialog(null, "You joined successfully");
							is=true;
						}
			
						if(is==false && this.membership(U)==false)
							JOptionPane.showMessageDialog(null, "You don't fit the criteria of "+this.name+" to join");

		}
		
		
		
}
