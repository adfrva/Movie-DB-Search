import java.util.ArrayList;

/**
 * This class stores information for a movie, it takes in a string for the title,
 * an object of type Actor for the associated actors, and a String for its release year
 * @author Adrian
 *1/26/2015
 */
public class Movie {
	private String myTitle;
	private String myYear;
	private ArrayList<Actor> myCast;
	
	public Movie(String title, String year){
		myTitle = title;
		myYear = year;
		myCast = new ArrayList<Actor>();
	}
	
	public ArrayList<Actor> getCast(){
		return myCast;
	}
	
	public String getYear(){
		//if(myYear.contains(")"){
			
		//}
			
		//else{
			return myYear;
		//}
	}
	
	public String getTitle(){
		return myTitle;
	}
	
	public void add(Actor anActor){
		myCast.add(anActor);
	}
	
	public void setTitle(String title){
		myTitle = title;
	}
	
	public void setYear(String year){
		myYear = year;
	}
	
	public String toString(){
		return myTitle + " " + myYear + " " + myCast;
	}

	public int parseInt(String year) {
		return Integer.parseInt(year);
	}
	
}	//End
