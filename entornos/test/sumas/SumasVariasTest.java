/**
 * 
 */
package sumas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */
class SumasVariasTest {

	@Test
	public void isPositiveTest() {
		SumasVarias s=new SumasVarias(1,7);
		assertTrue(s.isPositive());
		
		s.setX(7);
		s.setY(0);
		assertFalse(s.isPositive());
		
		
	}

}
