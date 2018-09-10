/**
 * This class creates an actor, it takes in a string for both first and last name.
 * 
 * @author Adrian
 *1/26/2014
 */
public class Actor {
	private String myFirstName;
	private String myLastName;
	
	public Actor(String first){
		this(first, "");
		myFirstName = first;
	}
	public Actor(String firstName, String lastName){
		myFirstName = firstName;
		myLastName = lastName;
	}
	
	public String getFirstName(){
		return myFirstName;
	}
	
	public String getLastName(){
		return myLastName;
	}
	
	public void setFirstName(String aName){
		myFirstName = aName;
	}
	
	public void setLastName(String aName){
		myLastName = aName;
	}
	
	public String toString(){
	 return myFirstName + " " + myLastName;
	}
}	//End
