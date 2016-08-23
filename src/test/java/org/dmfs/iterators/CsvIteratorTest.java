package org.dmfs.iterators;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;


public class CsvIteratorTest
{

    @Test
    public void testEmptyString()
    {
        // there is always at least one element
        Iterator<String> iterator = new CsvIterator("", ';');
        assertTrue(iterator.hasNext());
        assertEquals("", iterator.next());
        assertFalse(iterator.hasNext());
    }


    @Test
    public void testTrivialString()
    {
        Iterator<String> iterator = new CsvIterator("abcde", ';');
        assertTrue(iterator.hasNext());
        assertEquals("abcde", iterator.next());
        assertFalse(iterator.hasNext());
    }


    @Test
    public void testSimpleString()
    {
        Iterator<String> iterator = new CsvIterator("abc;de", ';');
        assertTrue(iterator.hasNext());
        assertEquals("abc", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("de", iterator.next());
        assertFalse(iterator.hasNext());
    }


    @Test
    public void testSimpleSeparatorString()
    {
        Iterator<String> iterator = new CsvIterator(";", ';');
        assertTrue(iterator.hasNext());
        assertEquals("", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("", iterator.next());
        assertFalse(iterator.hasNext());
    }


    @Test
    public void testSimpleSeparatorString2()
    {
        Iterator<String> iterator = new CsvIterator(";;", ';');
        assertTrue(iterator.hasNext());
        assertEquals("", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("", iterator.next());
        assertFalse(iterator.hasNext());
    }


    @Test
    public void testSeparatorString()
    {
        Iterator<String> iterator = new CsvIterator("abcde;fghi;jkl", ';');
        assertTrue(iterator.hasNext());
        assertEquals("abcde", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("fghi", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("jkl", iterator.next());
        assertFalse(iterator.hasNext());
    }


    @Test
    public void testSeparatorString2()
    {
        Iterator<String> iterator = new CsvIterator(";abcde;fghi;jkl", ';');
        assertTrue(iterator.hasNext());
        assertEquals("", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("abcde", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("fghi", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("jkl", iterator.next());
        assertFalse(iterator.hasNext());
    }


    @Test
    public void testSeparatorString3()
    {
        Iterator<String> iterator = new CsvIterator(";abcde;fghi;jkl;", ';');
        assertTrue(iterator.hasNext());
        assertEquals("", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("abcde", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("fghi", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("jkl", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("", iterator.next());
        assertFalse(iterator.hasNext());
    }


    @Test(expected = NoSuchElementException.class)
    public void testSeparatorString4()
    {
        Iterator<String> iterator = new CsvIterator(";abcde;fghi;jkl;", ';');
        assertTrue(iterator.hasNext());
        assertEquals("", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("abcde", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("fghi", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("jkl", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("", iterator.next());
        iterator.next();
    }
}
