// Name:Thanakorn Pasangthien
// Student ID:6088109
// Section: 1

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Movie {
	private int mid;
	private String title;
	private int year;
	private Set<String> tags;
	private Map<Integer, Rating> ratings;	//mapping userID -> rating
	private Double avgRating;
	//additional
	
	public Movie(int _mid, String _title, int _year){
		// YOUR CODE GOES HERE
		this.mid = _mid;
		this.title = _title;
		this.year = _year;
		
	}
	
	public int getID() {
		
		// YOUR CODE GOES HERE
		return -1;
	}
	public String getTitle(){
		
		// YOUR CODE GOES HERE
		return null;
	}
	
	public Set<String> getTags() {
		
		// YOUR CODE GOES HERE
		return null;
	}
	
	public void addTag(String tag){
		
		// YOUR CODE GOES HERE
	}
	
	public int getYear(){
		
		// YOUR CODE GOES HERE
		return -1;
	}
	
	public String toString()
	{
		return "[mid: "+mid+":"+title+" ("+year+") "+tags+"] -> avg rating: " + avgRating;
	}
	
	
	public double calMeanRating(){
		
		// YOUR CODE GOES HERE
		return -1;
	}
	
	public Double getMeanRating(){
		
		// YOUR CODE GOES HERE
		return -1.0;
	}
	
	public void addRating(User user, Movie movie, double rating, long timestamp) {
		// YOUR CODE GOES HERE
		
	}
	
	public Map<Integer, Rating> getRating(){
		
		// YOUR CODE GOES HERE
		
		return null;
	}
	
}
