package org.dmfs.iterators.filters;

import static org.junit.Assert.*;

import org.junit.Test;

public class NoneOfTest
{

	@Test
	public void testIterate()
	{
		NoneOf<String> tested1 = new NoneOf<String>("IncludeMe", "MeToo", "1", "3", null, "");
		assertFalse(tested1.iterate(null));
		assertFalse(tested1.iterate("MeToo"));
		assertFalse(tested1.iterate("1"));
		assertFalse(tested1.iterate("3"));
		assertFalse(tested1.iterate(""));
		assertFalse(tested1.iterate("IncludeMe"));
		assertTrue(tested1.iterate("Not me"));
		assertTrue(tested1.iterate("2"));
		
		NoneOf<String> tested2 = new NoneOf<String>();
		assertTrue(tested2.iterate(null));
		assertTrue(tested2.iterate("MeToo"));
		assertTrue(tested2.iterate("1"));
		assertTrue(tested2.iterate("3"));
		assertTrue(tested2.iterate(""));
		assertTrue(tested2.iterate("IncludeMe"));
		assertTrue(tested2.iterate("Not me"));
		assertTrue(tested2.iterate("2"));
	}

}
