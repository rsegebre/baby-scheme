//package babyScheme;
////package cosc303.calculator;
//
//import java.util.EmptyStackException;
//import java.util.Stack;
//import junit.framework.TestCase;
//
//public class OriginalTests extends TestCase {
//	private PrefixCalculator d = new PrefixCalculator();
//	
//	//testing individual  helper method: stacker
//	public void testStacker() {
//		Stack<String> g = new Stack<String>();
//		g.push("+");
//		g.push("1");
//		g.push("5");
//		assertEquals(g, d.stacker("+ 1 5"));
//	}
//
//	//testing individual helper method: isOp
//	public void testIsOp(){
//		assertEquals(false, d.isOp("^"));
//		assertEquals(true, d.isOp("*"));
//	}
//	
//	//testing individual helper method: isOp
//	public void testIsNumber(){
//		assertEquals(false, d.isNumber("2423432*432"));
//	}
//	
//	//testing individual helper method: Calculate
//	public void testInnerCalc() {
//		assertEquals(5%6, d.innercalc('%',5,6));
//	}
//	
//	
//	//testing individual method: Calculate
//	public void testCalculate0() {
//		assertEquals("12", d.calculate("+ 7 5"));
//	}
//	
//	public void testCalculate1() {
//		assertEquals("3", d.calculate("+ 4 - 3 4"));
//	}
//	
//	public void testCalculate2() {
//		assertEquals("-7", d.calculate("* - 5 6 + 3 4"));
//	}
//	
//	public void testCalculate3() {
//		assertEquals("4", d.calculate("/ 9 2"));
//	}
//	
//	public void testCalculate4() {
//		assertEquals("2", d.calculate("% 8 3"));
//	}
//	
//	public void testCalculate5() {
//		try {
//			 d.calculate("+ 7 5 5");
//			 fail("Should raise a EmptyStackException");
//
//		} catch (EmptyStackException expected){
//			//Successful
//		}
//	}
//	
//	public void testCalculate6() {
//		try {
//			 d.calculate("/ 8 0");
//			 fail("Should raise a IllegalArgumentException");
//
//		} catch (IllegalArgumentException expected){
//			//Successful
//		}
//	}
//	
//	public void testCalculate7() {
//		try {
//			 d.calculate("+ 5");
//			 fail("Should raise a EmptyStackException");
//
//		} catch (EmptyStackException expected){
//			//Successful
//		}
//	}
//	
//	public void testCalculate8() {
//		try {
//			 d.calculate("+ - 5");
//			 fail("Should raise a EmptyStackException");
//
//		} catch (EmptyStackException expected){
//			//Successful
//		}
//	}
//	
//	public void testCalculate9() {
//			assertEquals("5", d.calculate("5"));
//			
//	}
//	
//	public void testCalculate10() {
//		try {
//			 d.calculate(" ");
//			 fail("Should raise a IllegalArgumentException");
//
//		} catch (IllegalArgumentException expected){
//			//Successful
//		}
//	}
//	
//	public void testCalculate11() {
//		assertEquals("10", d.calculate("+  5      5"));
//}
//	//new and improved calculate for baby scheme
//	public void testBabyCalculate2() {
//		assertEquals("31", d.calculate("def twice x =* x 2 in def thrice x = * x 3 in + twice 5 thrice 7"));
//	}
//	
//	public void testBabyCalculate3() {
//		assertEquals("15", d.calculate("let x = 5 in def plus5 y = + y x in plus5 7"));
//	}
//	
//	public void testBabyCalculate4() {
//		assertEquals("14", d.calculate("let x = 5 in def plus x y = + x y in plus 9 x"));
//	}
//	
//	public void testBabyCalculate5() {
//		
//		try{
//			d.calculate("def plus5 y = + y x in let x = 5 in plus5 7");
//			fail("Should raise a IllegalArgumentException");
//		} catch (IllegalArgumentException expected) {
//		}
//	}
//	
//	public void testBabyCalculate6() {
//		
//		try{
//			d.calculate("let x = let y = 7 in = 4 in + x y");
//			fail("Should raise a IllegalArgumentException");
//		} catch (IllegalArgumentException expected) {
//		}
//	}
//	
//	public void testBabyCalculate7() {
//		
//		try{
//			d.calculate("let _5s = 5 in def plus x y = + x y in plus 9 x");
//			fail("Should raise a IllegalArgumentException");
//		} catch (IllegalArgumentException expected) {
//		}
//	}
//	
//	public void testBabyCalculate8() {
//		
//		try{
//			d.calculate("letx = 7 in +x x");
//			fail("Should raise a IllegalArgumentException");
//		} catch (IllegalArgumentException expected) {
//		}
//	}
//	
//	public void testBabyCalculate9() {		
//		assertEquals("5", d.calculate("def f x y = + x y in f 2 3"));
//	}
//	
//	public void testBabyCalculate10() {		
//		assertEquals("8", d.calculate("def double x = + x x in double 4"));
//	}
//	
//	public void testBabyCalculate11() {		
//		assertEquals("12", d.calculate("def tripleadd x y z = + x + y z in tripleadd 3 4 5"));
//	}
//	
//	public void testBabyCalculate12() {		
//		assertEquals("", d.calculate("def blah"));
//	}
//	
//	public void testBabyCalculate13() {		
//		try {
//			d.calculate("def BBlah");
//			fail("Should raise a IllegalArgumentException");
//		} catch (IllegalArgumentException expected) {
//			//Successful
//			}
//		}
//	
//
//	public void testBabyCalculate14() {		
//		try {
//			d.calculate("def f x   y = +   x  y in   f 2   3");
//			fail("Should raise a IllegalArgumentException");
//		} catch (IllegalArgumentException expected) {
//			//Successful
//			}
//		}
//	
//}
//
//	
//	
//	
//	
//
//
//
//

