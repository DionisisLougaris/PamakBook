import java.util.ArrayList;

public class User {
		private String name;
		private String email;
		private ArrayList<User> friends= new ArrayList<User>();
		private ArrayList<Group> Clubs= new ArrayList<Group>();


		public User(String text1,String text2)
		{
				
				if(text2.substring(text2.indexOf("@") + 1).contentEquals("uom.edu.gr")==false)
					System.out.println("User "+text1 +" has not been created. Email format is not acceptable.");
				else
				{
					name=text1;
					email=text2;
				}	
		}

		//Analyzing friendship
		public boolean friendship(User U)
		{
			if(this!=U)
			{
				boolean found=false;
				for(int i=0;i<this.friends.size();i++)
					if(this.friends.contains(U))
						found=true;
				return found;
			}
			return false;
		}
		
		
		//Adding and printing friends
		public void addFriend(User U)
		{
			boolean found=this.friendship(U);
			if(found)
				System.out.println("Users are already friends!");
			else
			{
				this.friends.add(U);
				U.friends.add(this);
				System.out.println(this.name + " and "+ U.getName() +" are now friends!");
			}
		}
		
		public void printFriends()
		{
			System.out.println("************************");
			System.out.println("Friends of "+this.name);
			System.out.println("************************");
			for(int i = 0; i < friends.size(); i++) 
			{   
			    System.out.println((i+1)+": "+friends.get(i).getName());
			}
			System.out.println("-----------------------");
		}
		
		
		//Finding and printing mutual friends
		public ArrayList<User> MutualFriends(User U)
		{
			ArrayList<User> Mutual= new ArrayList<User>();
			for(int i=0;i<this.friends.size();i++)
			{
				User  item=this.friends.get(i);
				for(int j=0;j<U.friends.size();j++)
					if(U.friends.get(j)==item)
						Mutual.add(item);
			}
			return Mutual;
		}
		
		public void printMutual(ArrayList<User> Array,User U)
		{
			Array=this.MutualFriends(U);
			System.out.println("**************************************");
			System.out.println("Common Friends of "+this.name +" and "+U.name);
			System.out.println("**************************************");
			for(int i = 0; i < Array.size(); i++)  
			    System.out.println((i+1)+": "+Array.get(i).getName());
			System.out.println("--------------------------------------");
		}
		
		
		
		//Adding and printing user's clubs
		public void addGroups(Group G)
		{
				this.Clubs.add(G);
				G.addMember(this);
				if(G.members.contains(this))
					System.out.println(this.name + " has been successfully enrolled in group "+G.name);
			
		
		}
	
		public void printGroups()
		{
			
			System.out.println("**************************************");
			System.out.println("Groups that "+this.name +" has been enrolled in");
			System.out.println("**************************************");
			for(int i = 0; i < this.Clubs.size(); i++) 
			    System.out.println((i+1)+": "+ Clubs.get(i).name);
			System.out.println("--------------------------------------");
		}
		
		//Finds possibly infected users
		public void Infected()
		{
			ArrayList<User> toTest= new ArrayList<User>();
			System.out.println("*******************************");
			System.out.println(this.name+" has been infected. The following have to be tested");
			System.out.println("*******************************");
			for(int i=0;i<this.friends.size();i++)
				toTest.add(this.friends.get(i));
			for(int i=0;i<this.friends.size();i++)
			{
				ArrayList<User> search=this.friends.get(i).friends;
				for(int j=0;j<search.size();j++)
				{
					if(toTest.contains(search.get(j))==false)
						toTest.add(search.get(j));
				}	
			}
			toTest.remove(this);
			for(int z=0;z<toTest.size();z++)
					System.out.println(toTest.get(z).getName());
			System.out.println("-----------------------------");
			
		}
		
		
		//Getters and Setters
		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}
}
