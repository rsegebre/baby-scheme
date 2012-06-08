package tests;

import java.util.EmptyStackException;

import main.The_Scheminator;
import junit.framework.TestCase;

public class NewTestCases extends TestCase {
	The_Scheminator n;
	public void setUp() {
		n = new The_Scheminator();
	}
	
	public void testBabyCalculate1() {		
		assertEquals("21", n.terminate("let y = + 4 2 in let x = + 5 + 5 5 in + y x"));
	}
	
 	public void testBabyCalculate2() {
 		assertEquals("31", n.terminate("def twice x = * x 2 in def thrice x = * x 3 in + twice 5 thrice 7"));
 	}
 	
 	public void testBabynCalculate3() {
 		assertEquals("12", n.terminate("let x = 5 in def plus5 y = + y x in plus5 7"));
 	}
 	
 	public void testBabyCalculate4() {
 		assertEquals("14", n.terminate("let x = 5 in def plus x y = + x y in plus 9 x"));
 	}
 	
 	public void testBabyCalculate5() {
 		
 		assertEquals("1", n.terminate("1"));
 	}
 	
 	public void testBabyCalculate6() {
 		
 		try{
 			n.terminate("let x = let y = 7 in = 4 in + x y");
 			fail("Should raise a IllegalArgumentException");
 		} catch (IllegalArgumentException expected) {
 		}
 	}
 	
 	public void testBabyCalculate7() {
 		
 		try{
 			n.terminate("let _5s = 5 in def plus x y = + x y in plus 9 x");
 			fail("Should raise a IllegalArgumentException");
 		} catch (IllegalArgumentException expected) {
 		}
 	}
 	
 	public void testBabyCalculate8() {
 		assertEquals("10",n.terminate("let x = 7 in def f y u i = + y + u + i x in f 1 1 1"));
	
	}
	
	public void testBabyCalculate9() {		
		assertEquals("5", n.terminate("def f x y = + x y in f 2 3"));
	}
	
	public void testBabyCalculate10() {		
		assertEquals("8", n.terminate("def double x = + x x in double 4"));
	}
	
	public void testBabyCalculate11() {		
		assertEquals("12", n.terminate("def tripleadd x y z = + x + y z in tripleadd 3 4 5"));
	}
	
	public void testBabyCalculate12() {		
		assertEquals("7", n.terminate("let y = 5 in let y = 6 in let y = 7 in y"));
	}
	
	public void testBabyCalculate13() {		
		try {
			n.terminate("def BBlah");
			fail("Should raise a IllegalArgumentException");
		} catch (EmptyStackException expected) {
			// Successful
			}
		}
	

	public void testBabyCalculate14() {		
			assertEquals("16", n.terminate("let y = 2 in def f x = * x 2 in f f f y"));
		}
	
	public void testBabyCalculate15() {		
		assertEquals("8", n.terminate("let y = 2 in let x = 2 in def f x y = + x y in f y f x f x y"));
	}

	public void testBabyCalculate16() {		
		try {
			n.terminate("let y = let x = + 5 + 5 5 in + y x");
			fail("Should raise a IllegalArgumentException");
		} catch (IllegalArgumentException expected) {
			// Successful
			}
	}
	
	public void testBabyCalculate17() {		
		try {
			n.terminate("def g y = let x = + 5 + 5 5 in + y x");
			fail("Should raise an EmptyStackException");
		} catch (EmptyStackException expected) {
			// Successful
			}
	}
	
	public void testBabyCalculate18() {		
		try {
			n.terminate("def g y = + y 2 in def hey h = + h y 2 in + y x");
			fail("Should raise an EmptyStackException");
		} catch (EmptyStackException expected) {
			// Successful
			}
	}
	
	
}
	

