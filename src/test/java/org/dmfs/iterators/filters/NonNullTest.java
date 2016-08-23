package org.dmfs.iterators.filters;

import org.dmfs.iterators.AbstractFilteredIterator.IteratorFilter;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


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
