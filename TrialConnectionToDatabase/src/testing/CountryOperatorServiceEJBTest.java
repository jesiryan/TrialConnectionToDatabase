package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import servicesEJB.CountryOperatorServiceEJB;

public class CountryOperatorServiceEJBTest {

//	@Test
//	public final void testSetDao() {
//		fail("Not yet implemented");
//	}

	@Test
	public final void testGetCountryOperators() {
		servicesEJB.CountryOperatorServiceEJB cosEJB = new servicesEJB.CountryOperatorServiceEJB();
		assertEquals(cosEJB.getCountryOperators().get(0).getCallfailures().get(0).getClass(), entities.CallFailure.class);
	}

//	@Test
//	public final void testAddToCountryOperators() {
//		fail("Not yet implemented");
//	}

}
