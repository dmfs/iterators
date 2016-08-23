package org.dmfs.iterators;

import org.dmfs.iterables.CachingIterableTest;
import org.dmfs.iterators.filters.AnyOfTest;
import org.dmfs.iterators.filters.NonNullTest;
import org.dmfs.iterators.filters.NoneOfTest;
import org.dmfs.iterators.filters.SkipTest;
import org.dmfs.iterators.utils.SlimSetTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
        ArrayIteratorTest.class, ConvertedIteratorTest.class, CsvIteratorTest.class, FilteredIteratorTest.class,
        SerialIteratorTest.class,
        SerialIterableIteratorTest.class, SerialIteratorIteratorTest.class, SingletonIteratorTest.class,
        DistinctIteratorTest.class, SlimSetTest.class,
        SkipTest.class, NonNullTest.class, AnyOfTest.class, NoneOfTest.class, CachingIterableTest.class })
public class AllTests
{

}
