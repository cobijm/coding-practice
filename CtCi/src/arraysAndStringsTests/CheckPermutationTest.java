package arraysAndStringsTests;

import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

import arraysAndStrings.CheckPermutation;

public class CheckPermutationTest {
	
	String test1;
	String test2;
	String test3;

	CheckPermutation temp = new CheckPermutation();

	@Before
	public void setUp() {
		test1 = "dog";
		test2 = "god";
		test3 = "you";
		
	}

	@Test
	public void brute() {
		assertEquals(true, temp.checkPermutation(test1, test2));
		assertEquals(false, temp.checkPermutation(test2, test3));
	}
	
//	@Test 
//	public void optimized() {
//		assertEquals(true, temp.isUniqueOptimized(test1));
//		assertEquals(false, temp.isUniqueOptimized(test2));
//	}
}
