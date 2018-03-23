// Name:Thanakorn Pasangthien
// Student ID:6088109
// Section: 1

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
		this.mid = _mid;
		this.title = _title;
		this.year = _year;
		 this.ratings = new HashMap<Integer, Rating>();
		 this.tags = new HashSet<String>();
		 this.avgRating = 0.0;
	}
	public int getID() {
		return this.mid;
	}
	public String getTitle(){
		return this.title;
	}
	public Set<String> getTags() {
		return this.tags;
	}
	public void addTag(String tag){
		tags.add(tag);
	}
	public int getYear(){
		return this.year;
	}
	public String toString()
	{
		return "[mid: "+mid+":"+title+" ("+year+") "+tags+"] -> avg rating: " + getMeanRating();
	}
	public double calMeanRating(){
		double sum = 0;
		int count = 0;
		for(Integer key: ratings.keySet()) {
			sum += ratings.get(key).rating;
			count++;
		}
		this.avgRating = sum/count;
		return this.avgRating;
	}
	public Double getMeanRating(){
		this.avgRating = calMeanRating();
		return this.avgRating;
	}
	public void addRating(User user, Movie movie, double rating, long timestamp) {
	    ratings.put(user.uid, new Rating(new User(user.uid), new Movie(this.mid, this.title, this.year), rating,timestamp));
	}
	public Map<Integer, Rating> getRating(){
		return this.ratings;
	}
	
}
