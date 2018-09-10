/**
 * Test driver for Actor class
 * @author Adrian
 *
 */
public class ActorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Actor actor1 = new Actor("Cher");
		Actor actor2 = new Actor("Tom", "Hanks");
		System.out.println(actor1 + ", " + actor2);
		System.out.println(actor2.getLastName() );
	}

}
