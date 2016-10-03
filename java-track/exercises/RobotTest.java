import static org.junit.Assert.*;

import org.junit.Test;

public class RobotTest {

	@Test
	public void testMove() {
		Robot r1, r2;
		r1 = new Robot("Terminator", 5, 7, 6, 180);
		r2 = new Robot("Skynet", 4, 6, 7, 270);
		r1.move();
		r2.move();
		assertTrue("Problem with move()",r1.getX() == 5 && r1.getY() == 1);
		assertTrue("Problem with move()",r2.getX() == -3 && r2.getY() == 6);
	}

	@Test
	public void testRotate() {
		Robot r3, r4;
		r3 = new Robot("Terminator", 5, 7, 6, 180);
		r4 = new Robot("Skynet", 4, 6, 7, 270);
		r3.rotate(90);
		r4.rotate(-90);
		assertTrue("Problem with rotate()", r3.getHeading() == 270);
		assertTrue("Problem with rotate()", r4.getHeading() == 180);
	}

	@Test
	public void testDistance() {
		Robot r5, r6;
		r5 = new Robot("Terminator", 5, 7, 6, 180);
		r6 = new Robot("Skynet", 4, 6, 7, 270);
		assertTrue("Problem with distanceToBot()", r5.distanceToBot(r6) == 1);
	}

}