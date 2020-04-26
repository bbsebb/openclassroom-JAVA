package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import junit.Calculator;
import junit.CalculatorImpl;


class CalculatorImplTest {

	@Test
	void testMultiply() {
		
	}

	@Test 
	public final void testDivideByZero() {
		Calculator calc = new CalculatorImpl();

		assertThrows(ArithmeticException.class, () ->  calc.divide(1,0) );
	}

	
	@Test
	public final void testAdd() {
		Calculator calc = new CalculatorImpl();
		int a, b, res;
		a = 5; 
	        b  = 5; 
	        res = a + b;
		assertTrue("a et b positif", calc.add(a, b) == res);
		a = 0; 
	        b  = 5; 
	        res = a + b;
		assertTrue("a nul", calc.add(a, b) == res);
		a = 5; 
	        b  = 0; 
	        res = a + b;
		assertTrue("b nul", calc.add(a, b) == res);
		a = 0; 
	        b  = 0; 
	        res = a + b;
		assertTrue("a et b nuls", calc.add(a, b) == res);
		a = -5; 
	        b  = 5; 
	        res = a+ b;
		assertTrue("a negatif", calc.add(a, b) == res);
		a = 5; 
	        b  = -5; 
	        res = a + b;
		assertTrue("b negatif", calc.add(a, b) == res);
		a = -5; 
	        b  = -5; 
	        res = a + b;
		assertTrue("a et b negatif", calc.add(a, b) == res);
	}


	@Test
	void testSubstract() {
		
	}

}
