package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import servicesEJB.FailureClassServiceEJB;

public class FailureClassServiceEJBTest {

//	@Test
//	public final void testSetDao() {
//		fail("Not yet implemented");
//	}
	
	@Test
	public final void testGetFailureClasses() {
		FailureClassServiceEJB fcsejb = new servicesEJB.FailureClassServiceEJB();
		assertEquals(fcsejb.getFailureClasses().get(0).getCallFailures().get(0).getClass(), entities.CallFailure.class);
	}
	
//	@Test
//	public final void testAddToFailureClasses() {
//		fail("Not yet implemented");
//	}
	
}
