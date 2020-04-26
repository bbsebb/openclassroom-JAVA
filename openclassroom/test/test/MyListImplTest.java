package test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MyListImplTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("avant tous les test");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("après tous les test");
	}

	@Before
	void setUp() throws Exception {
		System.out.println("avant un test");

	}

	@After
	void tearDown() throws Exception {
		System.out.println("aprés un test");

	}

	@Test
	void testMyListImpl() {
		fail("Not yet implemented");
	}

	@Test
	void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveAt() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveItem() {
		fail("Not yet implemented");
	}

	@Test
	void testSetAt() {
		fail("Not yet implemented");
	}



}
