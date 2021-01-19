import java.util.ArrayList;

public class Main {

	public static void main(String[] args) 
	{
		//info input
		User u1 = new User("Makis", "iis1998@uom.edu.gr");
		User u2 = new User("Petros", "ics1924@uom.edu.gr");
		User u3 = new User("Maria", "iis2012@uom.edu.gr");
		User u4 = new User("Gianna", "iis19133@uom.edu.gr");
		User u5 = new User("Nikos", "dai1758@uom.edu.gr");
		User u6 = new User("Babis", "ics19104@uom.edu.gr");
		User u7 = new User("Stella", "dai1827@uom.edu.gr");
		User u8 = new User("Eleni", "ics2086@gmail.com");
		Group g1 = new Group("WebGurus","A group for web passionates");
		ClosedGroup g2 = new ClosedGroup("ExamSolutions","Solutions to common exam questions");
		ArrayList<User> Mutual= new ArrayList<User>();
		
		//Creating Relations
		u1.addFriend(u2);
		u1.addFriend(u5);
		u5.addFriend(u6);
		u3.addFriend(u4);
		u3.addFriend(u2);
		u4.addFriend(u6);
		u5.addFriend(u3);
		u1.addFriend(u6);
		u5.addFriend(u2);
		u7.addFriend(u1);
		
		//Common friends
		Mutual=u5.MutualFriends(u4);
		u5.printMutual(Mutual,u4);
		Mutual=u1.MutualFriends(u5);
		u1.printMutual(Mutual,u5);
		
		//All friends of user
		u1.printFriends();
		u3.printFriends();
		
		//Creating memberships
		u4.addGroups(g1);
		u3.addGroups(g1);
		u2.addGroups(g1);
		u4.addGroups(g2);
		u5.addGroups(g2);
		u6.addGroups(g2);
		u5.addGroups(g2);
		
		//All groups of user
		u4.printGroups();
		
		//All members of group
		g1.printMembers();
		g2.printMembers();
	
		//Possibly infected
		u4.Infected();

}
	
}
