import java.util.Map;

// Name:Thanakorn Pasangthien
// Student ID: 6088109	
// Section:  1

public class Rating {
	public Movie m;
	public User u;
	public double rating;	//rating can be [0, 5]
	public long timestamp;	//timestamp tells you the time this rating was recorded
	public Rating(User _u, Movie _m, double _rating, long _timestamp) {
		this.u = _u;
		this.m = _m;
		this.rating = _rating;
		this.timestamp = _timestamp;
	}
	public String toString() {
		return "[uid: " + u.getID() +" mid: "+m.getID() +" rating: "+rating+"/5 timestamp: "+timestamp+"]";
	}
}
