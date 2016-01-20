package org.dmfs.iterators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;


public class SerialIteratorTest
{

	@Test
	public void test()
	{
		List<String> emptyList = Collections.emptyList();
		List<String> list1 = Arrays.asList(new String[] { "1", "2", "3", "4" });
		List<String> list2 = Arrays.asList(new String[] { "a", "b", "c", "d" });

		// test trivial cases without or with empty iterators
		assertIterateSame(emptyList.iterator(), new SerialIterator<String>());
		assertIterateSame(emptyList.iterator(), new SerialIterator<String>(emptyList.iterator()));
		assertIterateSame(emptyList.iterator(), new SerialIterator<String>(emptyList.iterator(), emptyList.iterator(), emptyList.iterator()));

		// trivial case, only one iterator
		assertIterateSame(list1.iterator(), new SerialIterator<String>(list1.iterator()));

		// test various combinations of empty and non-empty iterators
		assertIterateSame(Arrays.asList(new String[] { "1", "2", "3", "4", "1", "2", "3", "4" }).iterator(),
			new SerialIterator<String>(list1.iterator(), list1.iterator()));
		assertIterateSame(Arrays.asList(new String[] { "1", "2", "3", "4", "a", "b", "c", "d", "1", "2", "3", "4", "a", "b", "c", "d" }).iterator(),
			new SerialIterator<String>(list1.iterator(), list2.iterator(), list1.iterator(), list2.iterator()));

		assertIterateSame(Arrays.asList(new String[] { "1", "2", "3", "4", "a", "b", "c", "d" }).iterator(), new SerialIterator<String>(emptyList.iterator(),
			list1.iterator(), list2.iterator()));

		assertIterateSame(Arrays.asList(new String[] { "1", "2", "3", "4", "a", "b", "c", "d" }).iterator(), new SerialIterator<String>(list1.iterator(),
			emptyList.iterator(), list2.iterator()));

		assertIterateSame(Arrays.asList(new String[] { "1", "2", "3", "4", "a", "b", "c", "d" }).iterator(),
			new SerialIterator<String>(list1.iterator(), list2.iterator(), emptyList.iterator()));

		assertIterateSame(Arrays.asList(new String[] { "a", "b", "c", "d", "1", "2", "3", "4" }).iterator(),
			new SerialIterator<String>(list2.iterator(), list1.iterator(), emptyList.iterator()));
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
