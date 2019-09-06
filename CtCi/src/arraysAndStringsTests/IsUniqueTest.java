package arraysAndStringsTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import arraysAndStrings.IsUnique;

public class IsUniqueTest {

	String test1;

	String test2;

	IsUnique temp = new IsUnique();

	@Before
	public void setUp() {
		test1 = "qwertyuiopasdfghjklzxcvbnm";
		test2 = "hello";
	}

	@Test
	public void brute() {
		assertEquals(true, temp.isUniqueBrute(test1));
		assertEquals(false, temp.isUniqueBrute(test2));
	}
	
	@Test 
	public void optimized() {
		assertEquals(true, temp.isUniqueOptimized(test1));
		assertEquals(false, temp.isUniqueOptimized(test2));
	}

}
