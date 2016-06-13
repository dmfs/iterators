package org.dmfs.iterators.filters;

import static org.junit.Assert.*;

import org.dmfs.iterators.AbstractFilteredIterator.IteratorFilter;
import org.junit.Test;

public class NonNullTest
{

	@Test
	public void testIterate()
	{
		IteratorFilter<String> filter = new NonNull<String>();
		assertFalse(filter.iterate(null));
		assertTrue(filter.iterate("value"));
		assertTrue(filter.iterate(""));
			}

}
