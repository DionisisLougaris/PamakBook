import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.LocalDateTime;  

public class Main {

	public static void main(String[] args) 
	{
		Group g1 = new Group("WebGurus","A group for web passionates");
		Group g3 = new Group("Stack Overflow","Share your problems and your solutions");
		ClosedGroup g2 = new ClosedGroup("ExamSolutions","Solutions to common exam questions");
		ClosedGroup g4 = new ClosedGroup("GitPub","Github but for exclusive members only");
		
		//Creating all Groups available to users
		
		ArrayList<Group> groups = new ArrayList<Group>();
		groups.add(g1);
		groups.add(g2);
		groups.add(g3);
		groups.add(g4);
		
		//Retrieving PamakBook users from PamakBook.ser
		
		ArrayList<User> PamakBook = new ArrayList<User>();
		try {
			FileInputStream fileIn = new FileInputStream("PamakBook.ser");
			ObjectInputStream  in = new ObjectInputStream(fileIn);
			PamakBook = (ArrayList<User>) in.readObject();
		    in.close();
		    fileIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Starting the GUI sequence
		
		MainPage GUI = new MainPage(PamakBook,groups);
		
		
		
		
	
		
			
}
	
}
