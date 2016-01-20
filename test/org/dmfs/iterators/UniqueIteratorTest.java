package org.dmfs.iterators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;


public class UniqueIteratorTest
{

	@Test
	public void test()
	{
		List<String> emptyList = Collections.emptyList();
		List<String> list1 = Arrays.asList(new String[] { "1", "2", "3", "4" });
		List<String> list2 = Arrays.asList(new String[] { "1", "2", "3", "4", "3", "2", "1" });
		List<String> list3 = Arrays.asList(new String[] { "1", "2", "3", "4", "3", "2", "1", "3", "3", "5" });
		List<String> list4 = Arrays.asList(new String[] { "1", "2", "3", "4", "5" });

		// test trivial case with empty iterator
		assertIterateSame(emptyList.iterator(), new UniqueIterator<String>(emptyList.iterator()));

		// no duplicates
		assertIterateSame(list1.iterator(), new UniqueIterator<String>(list1.iterator()));

		// some duplicates
		assertIterateSame(list1.iterator(), new UniqueIterator<String>(list2.iterator()));

		// some more duplicates
		assertIterateSame(list4.iterator(), new UniqueIterator<String>(list3.iterator()));
	}


	/**
	 * Assert that two iterators return equal results.
	 * 
	 * @param iterator1
	 * @param iterator2
	 */
	private <E> void assertIterateSame(Iterator<E> iterator1, Iterator<E> iterator2)
	{
		while (iterator1.hasNext())
		{
			assertEquals(iterator1.next(), iterator2.next());
		}

		assertFalse(iterator2.hasNext());
	}
}
