package org.dmfs.iterators;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class SingletonIteratorTest
{

    @Test
    public void test()
    {
        List<String> list1 = Arrays.asList(new String[] { "1" });
        List<String> list2 = Arrays.asList(new String[] { "a" });
        List<String> list3 = Arrays.asList(new String[] { null });

        // test trivial cases without or with empty iterators
        assertIterateSame(list1.iterator(), new SingletonIterator<String>("1"));
        assertIterateSame(list2.iterator(), new SingletonIterator<String>("a"));
        assertIterateSame(list3.iterator(), new SingletonIterator<String>(null));
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
