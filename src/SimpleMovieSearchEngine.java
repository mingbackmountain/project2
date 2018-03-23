
// Name: Thanakorn Pasangthien
// Student ID: 6088109
// Section: 1

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class SimpleMovieSearchEngine implements BaseMovieSearchEngine {
	public Map<Integer, Movie> movies;

	public Map<Integer, Movie> loadMovies(String movieFilename) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(movieFilename));
			this.movies = new HashMap<Integer, Movie>();
			String line = "";
			String pstr = "([\\d]+),\"?(.*)\\(([\\d]+)\\)\"?,(.*)"; // regex
			Pattern p = Pattern.compile(pstr);
			Matcher m;
			while ((line = br.readLine()) != null) {
				m = p.matcher(line);
				if (m.matches()) {
					int mid = Integer.parseInt(m.group(1));
					String title = m.group(2);
					int year = Integer.parseInt(m.group(3));
					String tags = m.group(4);
					
					this.movies.put(mid, new Movie(mid, title, year));
					this.movies.get(mid).addTag(tags);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return movies;
	}
	@Override
	public void loadRating(String ratingFilename) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(ratingFilename));
			String line = "";
			String pstr = "([0-9]+),([0-9]+),([0-9]\\.[0-9]),([0-9]+)"; // regex
			Pattern p = Pattern.compile(pstr);
			Matcher m;
			br.readLine();
			while ((line = br.readLine()) != null) {
				m = p.matcher(line);
				if (m.matches()) {
					 int uid = Integer.parseInt(m.group(1));
					 int mid = Integer.parseInt(m.group(2));
					 double rating =  Double.parseDouble(m.group(3));
					 long timestamp = Long.parseLong(m.group(4));
					 if(movies.get(mid) != null) {
						 movies.get(mid).addRating(new User(uid),movies.get(mid), rating, timestamp);
					 }
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void loadData(String movieFilename, String ratingFilename) {
		loadMovies(movieFilename);
		loadRating(ratingFilename);
	}

	@Override
	public Map<Integer, Movie> getAllMovies() {
		return movies;
	}

	@Override
	public List<Movie> searchByTitle(String title, boolean exactMatch) {
		List<Movie> result = new ArrayList<Movie>();
		for(Integer key: movies.keySet()) {
			String temp = movies.get(key).getTitle().toLowerCase();
			if(temp.contains(title)) {
				result.add(movies.get(key));
			}
		}
		return result;
	}
	@Override
	public List<Movie> searchByTag(String tag) {
		List<Movie> result = new ArrayList<Movie>();
		for(Integer key: movies.keySet()) {
			Set<String> list = movies.get(key).getTags();
			for(String x : list) {
				if(x.contains(tag)) {
					result.add(movies.get(key));
				}
			}
		}
		return result;
	}
	@Override
	public List<Movie> searchByYear(int year) {
		List<Movie> result = new ArrayList<Movie>();
		for(Integer key: movies.keySet()) {
			if(movies.get(key).getYear()==year) {
				result.add(movies.get(key));
			}
		}
		return result;
	}
	@Override
	public List<Movie> advanceSearch(String title, String tag, int year) {
		List<Movie> result = new ArrayList<Movie>();
		for(Integer key: movies.keySet()) {
				if(title == null) {
					Set<String> list = movies.get(key).getTags();
					for(String x : list) {
						if(x.contains(tag)) {
							if(movies.get(key).getYear()==year) {
								result.add(movies.get(key));
							}
						}
					}
				}else if(tag == null) {
					String temp = movies.get(key).getTitle().toLowerCase();
					if(temp.contains(title)) {
						if(movies.get(key).getYear()==year) {
							result.add(movies.get(key));
						}
					}
				}else if(year == -1) {
					Set<String> list = movies.get(key).getTags();
					String temp = movies.get(key).getTitle().toLowerCase();
					for(String x : list) {
						if(temp.contains(title)) {
							if(x.contains(tag)) {
								result.add(movies.get(key));
							}
						}
					}
				}else {
					Set<String> list = movies.get(key).getTags();
					String temp = movies.get(key).getTitle().toLowerCase();
					for(String x : list) {
						if(temp.contains(title)) {
							if(x.contains(tag)) {
							  if(movies.get(key).getYear() == year)
								result.add(movies.get(key));
							}
						}
					}
				}
		}
		return result;
	}
	@Override
	public List<Movie> sortByTitle(List<Movie> unsortedMovies, boolean asc) {
		if(asc == true) {
			unsortedMovies.sort(Comparator.comparing(Movie::getTitle));
			return unsortedMovies;
		}else if(asc == false) {
			unsortedMovies.sort(Comparator.comparing(Movie::getTitle).reversed());
			return unsortedMovies;
		}
		return null;
	}
	@Override
	public List<Movie> sortByRating(List<Movie> unsortedMovies, boolean asc){
		if(asc) {
			unsortedMovies.sort(Comparator.comparingDouble(Movie::getMeanRating));
		}else if(asc == false) {
			unsortedMovies.sort(Comparator.comparingDouble(Movie::getMeanRating).reversed());
		}	
		return unsortedMovies;
	}

}
