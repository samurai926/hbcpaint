package hbc.paint;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

	@Test
	public void testCreateCustomers() {
		//fail("Not yet implemented");
		String input = "5\n1 M 3 G 5 G\n2 G 3 M 4 G\n5 M";
		//String input = "1\n1 G\n1 M";
		//String input = "5\n2 M\n5 G\n1 G\n5 G 1 G 4 M\n3 G\n5 G\n3 G 5 G 1 G\n3 G\n2 M\n5 G 1 G\n2 M\n5 G\n4 M\n5 G 4 M\n";
		//String input = "2\n1 G 2 M\n1 M\n";
		App app = new App(input, true);
		app.createCustomers();
		assertEquals(app.getCustomers().size(), 3);
	}

	@Test
	public void testBuildSolutionSet() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSolveForHappiness() {
		//fail("Not yet implemented");
	}

}
