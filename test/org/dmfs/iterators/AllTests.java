package org.dmfs.iterators;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ ArrayIteratorTest.class, ConvertedIteratorTest.class, FilteredIteratorTest.class, SerialIteratorTest.class, SerialIteratorIteratorTest.class,
	SingletonIteratorTest.class, DistinctIteratorTest.class })
public class AllTests
{

}
