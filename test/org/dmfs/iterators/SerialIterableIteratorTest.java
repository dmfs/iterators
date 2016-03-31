package org.dmfs.iterators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;


public class SerialIterableIteratorTest
{

	@Test
	public void test()
	{
		List<Iterable<String>> emptyList = Collections.emptyList();
		List<String> emptyStringList = Collections.emptyList();
		List<String> list1 = Arrays.asList(new String[] { "1", "2", "3", "4" });
		List<String> list2 = Arrays.asList(new String[] { "a", "b", "c", "d" });

		// test trivial cases with empty iterators
		assertIterateSame(emptyStringList.iterator(), new SerialIterableIterator<String>(emptyList.iterator()));

		// trivial case, only one iterator
		assertIterateSame(list1.iterator(), new SerialIterableIterator<String>(new ArrayIterator<Iterable<String>>(list1)));

		// test various combinations of empty and non-empty iterators
		assertIterateSame(Arrays.asList(new String[] { "1", "2", "3", "4", "1", "2", "3", "4" }).iterator(), new SerialIterableIterator<String>(
			new ArrayIterator<Iterable<String>>(list1, list1)));
		assertIterateSame(Arrays.asList(new String[] { "1", "2", "3", "4", "a", "b", "c", "d", "1", "2", "3", "4", "a", "b", "c", "d" }).iterator(),
			new SerialIterableIterator<String>(new ArrayIterator<Iterable<String>>(list1, list2, list1, list2)));

		assertIterateSame(Arrays.asList(new String[] { "1", "2", "3", "4", "a", "b", "c", "d" }).iterator(), new SerialIterableIterator<String>(
			new ArrayIterator<Iterable<String>>(emptyStringList, list1, list2)));

		assertIterateSame(Arrays.asList(new String[] { "1", "2", "3", "4", "a", "b", "c", "d" }).iterator(), new SerialIterableIterator<String>(
			new ArrayIterator<Iterable<String>>(list1, emptyStringList, list2)));

		assertIterateSame(Arrays.asList(new String[] { "1", "2", "3", "4", "a", "b", "c", "d" }).iterator(), new SerialIterableIterator<String>(
			new ArrayIterator<Iterable<String>>(list1, list2, emptyStringList)));

		assertIterateSame(Arrays.asList(new String[] { "a", "b", "c", "d", "1", "2", "3", "4" }).iterator(), new SerialIterableIterator<String>(
			new ArrayIterator<Iterable<String>>(list2, list1, emptyStringList)));
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
