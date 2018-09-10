import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class acts as the movie database, it takes in no parameters
 * @author Adrian
 *1/26/2015
 */
public class Database {
	private ArrayList<Movie> myMovies = new ArrayList<Movie>();
	private ArrayList<Actor> myActors = new ArrayList<Actor>();

	public Database(){

	}
	/**
	 * Loads data from the file typed in TestDriver.
	 * Once the data is loaded, "Data Loaded" will appear on the console.
	 * @param fileName
	 */
	public void loadDataFromFile(String fileName){
		Scanner theScanner = null;
		try{
			theScanner = new Scanner( new FileInputStream(fileName) );
		}
		catch(Exception ex){
			ex.printStackTrace();
		}

		while(theScanner.hasNext() ){

			//Split lines into words that split string by "/"
			String theLines = theScanner.nextLine();
			String[] theWords = theLines.split("/");

			//Words within "(" and ")" are stored as years
			int firstParen = theWords[0].lastIndexOf('(');
			int lastParen = theWords[0].lastIndexOf(')');
			String titles = theWords[0].substring(0, firstParen);
			String years = theWords[0].substring(firstParen + 1, lastParen);


			String firstName;
			String lastName;

			Actor theActor;
			Movie theMovie;
			theMovie = new Movie(titles, years);
			myMovies.add(theMovie);
			for(int i = 1; i < theWords.length; i++){
				//If name does not contain "," actors name is cascaded
				if(theWords[i].contains(",") ){
					String[] names = theWords[i].split(",");
					firstName = names[1];
					lastName = names[0];
				}

				else{
					firstName = theWords[i];
					lastName = "";
				}
				theActor = new Actor(firstName, lastName);

				theMovie.add(theActor);
			}

		}
		System.out.println("Data Loaded");
		theScanner.close();
	}

	/**
	 *
	 * @param movieName
	 * @return - returns ArrayList containing actors featured in the movie that is typed
	 *
	 */

	public ArrayList<Actor> findActorsIn(String movieName){
		//if movieName matches a movie title in the database, return ArrrayList of actor names in that movie
		ArrayList<Actor> actorsIn = new ArrayList<Actor>();
		for(Movie aMovie: myMovies){
			if( ( aMovie.getTitle() ).contains(movieName)){
				return aMovie.getCast();
			}
		}
		return actorsIn;
	}


	/**
	 *
	 * @param firstName
	 * @param lastName
	 * @return - returns ArrayList of movies actors typed have appeared in
	 */
	
	public ArrayList<Movie> findMovieAppearancesOf(String firstName, String lastName){
		//if actorName matches an actors name, return list of movies that actor has appeared in
		ArrayList<Movie> movieAppearancesOf = new ArrayList<Movie>();
		for(Movie aMovie: myMovies){
			if( ( aMovie.getActor().getFirstName() ).contains(firstName)
			&&    aMovie.getActor().getLastName().contains(lastName)){
				movieAppearancesOf.add(aMovie);
			}
		}
		return movieAppearancesOf;
	}

	/**
	 *
	 * @param movieYear - Year is stored as a String, not an int
	 * @return - returns ArrayList containing movies that were released in the year typed
	 */
	public ArrayList<Movie> findMoviesReleasedIn(String movieYear){
		//if movieYear matches year movie is released, return name of movies released in that year
		ArrayList<Movie> moviesReleasedIn = new ArrayList<Movie>();
		for(Movie aMovie: myMovies){
			if(aMovie.getYear().equals( movieYear) ){
				moviesReleasedIn.add(aMovie);
			}
		}
		return moviesReleasedIn;
	}
	/**
	 *
	 * @param movieName
	 * @return - returns ArrayList of movies with names containing the String typed in TestDriver
	 */
	public ArrayList<Movie> findMoviesWithNamesContaining(String movieName){
		//if title of movie contains movieName, return list of movies containing name
		ArrayList<Movie> moviesWithNameContaining = new ArrayList<Movie>();
		for(Movie aTitle: myMovies){
			if( ( aTitle.getTitle() ).contains(movieName) ){
				moviesWithNameContaining.add(aTitle);

			}
		}
		return moviesWithNameContaining;
	}
	/**
	 *
	 * @param actorName
	 * @return - returns ArrayList of actors with names containing String in TestDriver
	 */
	public ArrayList<Actor> findActorsWithNamesContaining(String actorName){
		//if name of actor contains actorName, return list of actors containing name
		ArrayList<Actor> actorsWithNameContaining = new ArrayList<Actor>();
		for(Actor anActor: myActors){
			if( ( anActor.toString() ).contains(actorName) ){
				actorsWithNameContaining.add(anActor);
			}
		}
		return actorsWithNameContaining;
	}
	/**
	 *
	 * @param first
	 * @param second
	 * @return - Returns an ArrayList of movies released between the two ints taken
	 */
	public ArrayList<Movie> findMoviesReleasedBetween(int first, int second){
		ArrayList<Movie> moviesReleasedBetween = new ArrayList<Movie>();
		for(Movie aMovie: myMovies){
			int years = Integer.parseInt(aMovie.getYear() );
			if(years >= first && years <= second){
				moviesReleasedBetween.add(aMovie);
			}
		}
		return moviesReleasedBetween;
	}
	/**
	 *
	 * @param actors
	 * @return - Returns ArrayList containing movies with the same number of actors as int taken as parameter
	 */
	public ArrayList<Movie> findMoviesWithNumberOfActors(int numOfActors){
		ArrayList<Movie> movieWithNumberOfActors = new ArrayList<Movie>();
		for(Movie aMovie: myMovies){
			if( aMovie.getCast().size() == numOfActors){
				movieWithNumberOfActors.add(aMovie);
			}
		}
		return movieWithNumberOfActors;
	}
	/**
	 *
	 * @return - returns oldest movie in database
	 */
	public Movie oldestMovie(){
		Movie oldest = myMovies.get(0);
		int myYear = Integer.parseInt(oldest.getYear());
		for(Movie aMovie: myMovies){
			if(aMovie.parseInt(aMovie.getYear()) < myYear){
				oldest = aMovie;
			}
		}
		return oldest;
	}

	public int size(){
		//return number of movies in database
		return myMovies.size();
	}

	public String toString(){
		// return string of all info in database
		return myMovies.toString() + myActors.toString();
	}


}	//End
