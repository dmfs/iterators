/*
 * Copyright (C) 2016 Marten Gajda <marten@dmfs.org>
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.dmfs.iterables;

import java.util.Iterator;

import org.dmfs.iterators.CsvIterator;


/**
 * An {@link Iterable} that iterates the elements of a String of a comma (or other character) separated value list.
 * <p />
 * Example:
 * 
 * <pre>
 * <code>
 * 	Iterator<String> i = new CsvIterable<String>("a, b,def,123", ',').iterator();
 * 	i.next(); // returns &quot;a&quot;
 * 	i.next(); // returns &quot; b&quot;
 * 	i.next(); // returns &quot;def&quot;
 * 	i.next(); // returns &quot;123&quot;
 * 	i.hasNext(); // false
 * </code>
 * </pre>
 * 
 * Separators between quote characters (") will be ignored.
 * <p />
 * Example:
 * 
 * <pre>
 * <code>
 * 	Iterator<String> i = new CsvIterable<String>("\"a, b\",\"def,123\"", ',').iterator();
 * 	i.next(); // returns &quot;a, b&quot;
 * 	i.next(); // returns &quot;def,123&quot;
 * 	i.hasNext(); // false
 * </code>
 * </pre>
 * 
 * Iterating an empty String or a string without (unquoted) separators will return exactly one element.
 * <p />
 * Example:
 * 
 * <pre>
 * <code>
 * 	Iterator<String> i = new CsvIterable<String>("", ',').iterator();
 * 	i.next(); // returns &quot;&quot;
 * 	i.hasNext(); // false
 * 
 * 	Iterator<String> i2 = new CsvIterable<String>("\"abc,def\"", ',').iterator();
 * 	i2.next(); // returns &quot;abc,def&quot;
 * 	i2.hasNext(); // false
 * </code>
 * </pre>
 * 
 * 
 * @author Marten Gajda <marten@dmfs.org>
 */
public class CsvIterable implements Iterable<String>
{
	private String mValue;
	private char mSeparator;


	/**
	 * Creates an {@link Iterable} that returns {@link Iterator}s for all elements of the given string which are separated by the given <code>separator</code>.
	 * 
	 * @param value
	 *            The string that contains a list of values.
	 * @param separator
	 *            The separator that separates the values.
	 */
	public CsvIterable(String value, char separator)
	{
		mValue = value;
		mSeparator = separator;
	}


	@Override
	public Iterator<String> iterator()
	{
		return new CsvIterator(mValue, mSeparator);
	}

}
