package org.dmfs.iterators.filters;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnyOfTest
{

	@Test
	public void testIterate()
	{
		AnyOf<String> tested1 = new AnyOf<String>("IncludeMe", "MeToo", "1", "3", null, "");
		assertTrue(tested1.iterate(null));
		assertTrue(tested1.iterate("MeToo"));
		assertTrue(tested1.iterate("1"));
		assertTrue(tested1.iterate("3"));
		assertTrue(tested1.iterate(""));
		assertTrue(tested1.iterate("IncludeMe"));
		assertFalse(tested1.iterate("Not me"));
		assertFalse(tested1.iterate("2"));
		
		AnyOf<String> tested2 = new AnyOf<String>();
		assertFalse(tested2.iterate(null));
		assertFalse(tested2.iterate("MeToo"));
		assertFalse(tested2.iterate("1"));
		assertFalse(tested2.iterate("3"));
		assertFalse(tested2.iterate(""));
		assertFalse(tested2.iterate("IncludeMe"));
		assertFalse(tested2.iterate("Not me"));
		assertFalse(tested2.iterate("2"));
	}

}
