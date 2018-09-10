import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class OldestTestDriver {

	public static void main(String[] args) {
		ArrayList<Movie> myMovies = new ArrayList<Movie>();

		
		//List is read into program, database is created
		Scanner theScanner = null;
		try{
			theScanner = new Scanner( new FileInputStream("cast-mpaa.txt") );
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
			Movie theMovie = new Movie(titles, years);
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
		
		//ArrayList containing movies that only have one actor is created here
		ArrayList<Movie> moviesWithOneActor = new ArrayList<Movie>();
		for(Movie aMovie: myMovies){
			if(aMovie.getCast().size() == 1){
				moviesWithOneActor.add(aMovie);
			}
		}
		
		//ArrayList is scanned, finds oldest movie
		Movie oldest = moviesWithOneActor.get(0);
		int myYear = Integer.parseInt(oldest.getYear());
		for(Movie aMovie: moviesWithOneActor){
			if(aMovie.parseInt(aMovie.getYear()) < myYear){
				oldest = aMovie;
			}
		}
		System.out.println(oldest);
		
		theScanner.close();
	}
}
