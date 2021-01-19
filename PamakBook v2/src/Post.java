import java.time.*;
import java.util.*;



public class Post implements Comparable{
	
	private String postText;
	private User postUser;
	private Date timestamp;
	
	
	public Post(User postUser,Date timestamp, String postText)
	{
		this.timestamp = timestamp;
		this.postText = postText;
		this.postUser = postUser;
	}
	
	//Implementing compareTo method to compare by Posts' timestamp
	public int compareTo(Object other) {
		Post otherPost = (Post)other;
		return (otherPost.timestamp.compareTo(this.timestamp));
			
	}
	
	
	//Getters
	public Date getTimestamp() {
		return timestamp;
	}

	public String getPostText() {
		return postText;
	}

	public User getPostUser() {
		return postUser;
	}
	
}
