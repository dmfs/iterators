package org.dmfs.iterators;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class SerialIteratorIteratorTest
{

    @Test
    public void test()
    {
        List<Iterator<String>> emptyList = Collections.emptyList();
        List<String> emptyStringList = Collections.emptyList();
        List<String> list1 = Arrays.asList(new String[] { "1", "2", "3", "4" });
        List<String> list2 = Arrays.asList(new String[] { "a", "b", "c", "d" });

        // test trivial cases with empty iterators
        assertIterateSame(emptyStringList.iterator(), new SerialIteratorIterator<String>(emptyList.iterator()));

        // trivial case, only one iterator
        assertIterateSame(list1.iterator(),
                new SerialIteratorIterator<String>(new ArrayIterator<Iterator<String>>(list1.iterator())));

        // test various combinations of empty and non-empty iterators
        assertIterateSame(Arrays.asList(new String[] { "1", "2", "3", "4", "1", "2", "3", "4" }).iterator(),
                new SerialIteratorIterator<String>(
                        new ArrayIterator<Iterator<String>>(list1.iterator(), list1.iterator())));
        assertIterateSame(Arrays.asList(
                new String[] { "1", "2", "3", "4", "a", "b", "c", "d", "1", "2", "3", "4", "a", "b", "c", "d" })
                        .iterator(),
                new SerialIteratorIterator<String>(
                        new ArrayIterator<Iterator<String>>(list1.iterator(), list2.iterator(), list1.iterator(),
                                list2.iterator())));

        assertIterateSame(Arrays.asList(new String[] { "1", "2", "3", "4", "a", "b", "c", "d" }).iterator(),
                new SerialIteratorIterator<String>(
                        new ArrayIterator<Iterator<String>>(emptyStringList.iterator(), list1.iterator(),
                                list2.iterator())));

        assertIterateSame(Arrays.asList(new String[] { "1", "2", "3", "4", "a", "b", "c", "d" }).iterator(),
                new SerialIteratorIterator<String>(
                        new ArrayIterator<Iterator<String>>(list1.iterator(), emptyStringList.iterator(),
                                list2.iterator())));

        assertIterateSame(Arrays.asList(new String[] { "1", "2", "3", "4", "a", "b", "c", "d" }).iterator(),
                new SerialIteratorIterator<String>(
                        new ArrayIterator<Iterator<String>>(list1.iterator(), list2.iterator(),
                                emptyStringList.iterator())));

        assertIterateSame(Arrays.asList(new String[] { "a", "b", "c", "d", "1", "2", "3", "4" }).iterator(),
                new SerialIteratorIterator<String>(
                        new ArrayIterator<Iterator<String>>(list2.iterator(), list1.iterator(),
                                emptyStringList.iterator())));
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
