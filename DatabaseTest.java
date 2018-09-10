/**
 * Test driver for Database class
 * @author Adrian
 *
 */
public class DatabaseTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database theDatabase = new Database();
		theDatabase.loadDataFromFile("cast-mpaa.txt");
		System.out.println(theDatabase.oldestMovie() );
		//System.out.println(theDatabase.findMoviesReleasedBetween(1984, 1985) );
		//System.out.println(theDatabase.findMoviesWithNumberOfActors(5));
	}
}	//End
