package org.dmfs.iterators.filters;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class LimitTest
{

	@Test
	public void testIterate()
	{
		// negative value doesn't iterate anything
		Limit<String> tested1 = new Limit<String>(-1);
		assertFalse(tested1.iterate(null));
		assertFalse(tested1.iterate("MeToo"));
		assertFalse(tested1.iterate("1"));
		assertFalse(tested1.iterate("3"));
		assertFalse(tested1.iterate(""));
		assertFalse(tested1.iterate("IncludeMe"));
		assertFalse(tested1.iterate("Not me"));
		assertFalse(tested1.iterate("2"));

		// 0 value doesn't iterate anything
		Limit<String> tested2 = new Limit<String>(0);
		assertFalse(tested2.iterate(null));
		assertFalse(tested2.iterate("MeToo"));
		assertFalse(tested2.iterate("1"));
		assertFalse(tested2.iterate("3"));
		assertFalse(tested2.iterate(""));
		assertFalse(tested2.iterate("IncludeMe"));
		assertFalse(tested2.iterate("Not me"));
		assertFalse(tested2.iterate("2"));

		Limit<String> tested3 = new Limit<String>(1);
		assertTrue(tested3.iterate(null));
		assertFalse(tested3.iterate("MeToo"));
		assertFalse(tested3.iterate("1"));
		assertFalse(tested3.iterate("3"));
		assertFalse(tested3.iterate(""));
		assertFalse(tested3.iterate("IncludeMe"));
		assertFalse(tested3.iterate("Not me"));
		assertFalse(tested3.iterate("2"));

		Limit<String> tested4 = new Limit<String>(5);
		assertTrue(tested4.iterate(null));
		assertTrue(tested4.iterate("MeToo"));
		assertTrue(tested4.iterate("1"));
		assertTrue(tested4.iterate("3"));
		assertTrue(tested4.iterate(""));
		assertFalse(tested4.iterate("IncludeMe"));
		assertFalse(tested4.iterate("Not me"));
		assertFalse(tested4.iterate("2"));

		Limit<String> tested5 = new Limit<String>(10);
		assertTrue(tested5.iterate(null));
		assertTrue(tested5.iterate("MeToo"));
		assertTrue(tested5.iterate("1"));
		assertTrue(tested5.iterate("3"));
		assertTrue(tested5.iterate(""));
		assertTrue(tested5.iterate("IncludeMe"));
		assertTrue(tested5.iterate("Not me"));
		assertTrue(tested5.iterate("2"));
	}

}
