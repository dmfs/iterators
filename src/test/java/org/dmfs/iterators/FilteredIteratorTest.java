package org.dmfs.iterators;

import org.dmfs.iterators.AbstractFilteredIterator.IteratorFilter;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class FilteredIteratorTest
{

    @Test
    public void test()
    {
        List<String> emptyList = Collections.emptyList();
        List<String> list1 = Arrays.asList(new String[] { "1", "2", "3", "4", "3", "2", "1" });

        // test trivial cases with empty iterators
        assertIterateSame(emptyList.iterator(),
                new FilteredIterator<String>(emptyList.iterator(), new IteratorFilter<String>()
                {
                    @Override
                    public boolean iterate(String element)
                    {
                        return true;
                    }
                }));

        assertIterateSame(emptyList.iterator(),
                new FilteredIterator<String>(emptyList.iterator(), new IteratorFilter<String>()
                {
                    @Override
                    public boolean iterate(String element)
                    {
                        return false;
                    }
                }));

        // filter no elements
        assertIterateSame(list1.iterator(), new FilteredIterator<String>(list1.iterator(), new IteratorFilter<String>()
        {
            @Override
            public boolean iterate(String element)
            {
                return true;
            }
        }));

        // filter all elements
        assertIterateSame(emptyList.iterator(),
                new FilteredIterator<String>(list1.iterator(), new IteratorFilter<String>()
                {
                    @Override
                    public boolean iterate(String element)
                    {
                        return false;
                    }
                }));

        // filter one element
        assertIterateSame(Arrays.asList(new String[] { "1", "2", "3", "3", "2", "1" }).iterator(),
                new FilteredIterator<String>(list1.iterator(),
                        new IteratorFilter<String>()
                        {
                            @Override
                            public boolean iterate(String element)
                            {
                                return !"4".equals(element);
                            }
                        }));

        // filter some elements
        assertIterateSame(Arrays.asList(new String[] { "2", "3", "3", "2" }).iterator(),
                new FilteredIterator<String>(list1.iterator(),
                        new IteratorFilter<String>()
                        {
                            @Override
                            public boolean iterate(String element)
                            {
                                return !"1".equals(element) && !"4".equals(element);
                            }
                        }));

        // filter most elements
        assertIterateSame(Arrays.asList(new String[] { "4" }).iterator(),
                new FilteredIterator<String>(list1.iterator(), new IteratorFilter<String>()
                {
                    @Override
                    public boolean iterate(String element)
                    {
                        return "4".equals(element);
                    }
                }));
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
