package org.dmfs.iterators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;


public class ArrayIteratorTest
{

	@Test
	public void test()
	{
		List<String> emptyList = Arrays.asList(new String[] {});
		List<String> list1 = Arrays.asList(new String[] { "1" });
		List<String> list2 = Arrays.asList(new String[] { "a", "1", "3" });
		List<String> list3 = Arrays.asList(new String[] { "a", "1", null, "3" });

		assertIterateSame(emptyList.iterator(), new ArrayIterator<String>());
		assertIterateSame(list1.iterator(), new ArrayIterator<String>("1"));
		assertIterateSame(list2.iterator(), new ArrayIterator<String>("a", "1", "3"));
		assertIterateSame(list3.iterator(), new ArrayIterator<String>("a", "1", null, "3"));

		assertIterateSame(list1.iterator(), new ArrayIterator<String>(new String[] { "1" }));
		assertIterateSame(list2.iterator(), new ArrayIterator<String>(new String[] { "a", "1", "3" }));
		assertIterateSame(list3.iterator(), new ArrayIterator<String>(new String[] { "a", "1", null, "3" }));
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
