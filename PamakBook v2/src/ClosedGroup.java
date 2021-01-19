import java.util.ArrayList;

public class ClosedGroup  extends Group {
		
		
		public ClosedGroup(String text1,String text2)
		{
			super(text1, text2);
			members = new ArrayList<User>();
			
		}
		
		//Adding members of closed group
		public void addMember(User U)
		{
			boolean found=this.membership(U);
			boolean is=false;
			if(found)
				System.out.println("The user is already a member!");
			else
				if(this.members.isEmpty()==true)
				{
					this.members.add(U);
					is=true;
				}
				else
					for(int i=0;i<this.members.size();i++)
						if(U.friendship(this.members.get(i)))
						{
							this.members.add(U);
							is=true;
						}
			
						if(is==false)
							System.out.println("FAILED: "+U.getName()+" cannot be enrolled in group "+this.name);

		}
		
		
		
}
