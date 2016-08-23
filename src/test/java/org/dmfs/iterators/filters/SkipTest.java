package org.dmfs.iterators.filters;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class SkipTest
{

    @Test
    public void testIterate()
    {
        // negative value doesn't skip anything
        Skip<String> tested1 = new Skip<String>(-1);
        assertTrue(tested1.iterate(null));
        assertTrue(tested1.iterate("MeToo"));
        assertTrue(tested1.iterate("1"));
        assertTrue(tested1.iterate("3"));
        assertTrue(tested1.iterate(""));
        assertTrue(tested1.iterate("IncludeMe"));
        assertTrue(tested1.iterate("Not me"));
        assertTrue(tested1.iterate("2"));

        // 0 value doesn't skip anything
        Skip<String> tested2 = new Skip<String>(0);
        assertTrue(tested2.iterate(null));
        assertTrue(tested2.iterate("MeToo"));
        assertTrue(tested2.iterate("1"));
        assertTrue(tested2.iterate("3"));
        assertTrue(tested2.iterate(""));
        assertTrue(tested2.iterate("IncludeMe"));
        assertTrue(tested2.iterate("Not me"));
        assertTrue(tested2.iterate("2"));

        Skip<String> tested3 = new Skip<String>(1);
        assertFalse(tested3.iterate(null));
        assertTrue(tested3.iterate("MeToo"));
        assertTrue(tested3.iterate("1"));
        assertTrue(tested3.iterate("3"));
        assertTrue(tested3.iterate(""));
        assertTrue(tested3.iterate("IncludeMe"));
        assertTrue(tested3.iterate("Not me"));
        assertTrue(tested3.iterate("2"));

        Skip<String> tested4 = new Skip<String>(5);
        assertFalse(tested4.iterate(null));
        assertFalse(tested4.iterate("MeToo"));
        assertFalse(tested4.iterate("1"));
        assertFalse(tested4.iterate("3"));
        assertFalse(tested4.iterate(""));
        assertTrue(tested4.iterate("IncludeMe"));
        assertTrue(tested4.iterate("Not me"));
        assertTrue(tested4.iterate("2"));

        Skip<String> tested5 = new Skip<String>(10);
        assertFalse(tested5.iterate(null));
        assertFalse(tested5.iterate("MeToo"));
        assertFalse(tested5.iterate("1"));
        assertFalse(tested5.iterate("3"));
        assertFalse(tested5.iterate(""));
        assertFalse(tested5.iterate("IncludeMe"));
        assertFalse(tested5.iterate("Not me"));
        assertFalse(tested5.iterate("2"));
    }

}
