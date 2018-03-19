// Name: Thanakorn Pasangthien
// Student ID: 6088109
// Section: 1

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SimpleMovieSearchEngine implements BaseMovieSearchEngine {
	public Map<Integer, Movie> movies;
	
	@Override
	public Map<Integer, Movie> loadMovies(String movieFilename) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(movieFilename));
			String line = "";
			String pstr = "([0-9]+),\"?(.*)\\((.*)\\)\"?,(.*)"; // regex
			Pattern p = Pattern.compile(pstr);
			Matcher m;
			while((line = br.readLine()) != null) {
				m = p.matcher(line);
				if(m.matches()) {
					
				}
			}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void loadRating(String ratingFilename) {

		// YOUR CODE GOES HERE
		
	}

	@Override
	public void loadData(String movieFilename, String ratingFilename) {
	
		// YOUR CODE GOES HERE
			
	}

	@Override
	public Map<Integer, Movie> getAllMovies() {

		// YOUR CODE GOES HERE
		
		return null;
	}

	@Override
	public List<Movie> searchByTitle(String title, boolean exactMatch) {

		// YOUR CODE GOES HERE
		
		return null;
	}

	@Override
	public List<Movie> searchByTag(String tag) {

		// YOUR CODE GOES HERE
		
		return null;
	}

	@Override
	public List<Movie>searchByYear(int year) {

		// YOUR CODE GOES HERE
		
		return null;
	}

	@Override
	public List<Movie> advanceSearch(String title, String tag, int year) {

		// YOUR CODE GOES HERE
		
		return null;
	}

	@Override
	public List<Movie> sortByTitle(List<Movie> unsortedMovies, boolean asc) {

		// YOUR CODE GOES HERE
		
		return null;
	}

	@Override
	public List<Movie> sortByRating(List<Movie> unsortedMovies, boolean asc) {

		// YOUR CODE GOES HERE
		
		return null;
	}

}
