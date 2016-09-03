/*
 * Copyright 2017 dmfs GmbH
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


/**
 * An {@link Iterable} that iterates the elements of a CharSequence of a comma (or other character) separated value
 * list.
 * <p/>
 * Example:
 * <p>
 * <pre>
 * <code>
 * 	Iterator<CharSequence> i = new Split("a, b,def,123", ',').iterator();
 * 	i.next(); // returns &quot;a&quot;
 * 	i.next(); // returns &quot; b&quot;
 * 	i.next(); // returns &quot;def&quot;
 * 	i.next(); // returns &quot;123&quot;
 * 	i.hasNext(); // false
 * </code>
 * </pre>
 * <p>
 * Separators between quote characters (") will be ignored.
 * <p/>
 * Example:
 * <p>
 * <pre>
 * <code>
 * 	Iterator<CharSequence> i = new Split("\"a, b\",\"def,123\"", ',').iterator();
 * 	i.next(); // returns &quot;a, b&quot;
 * 	i.next(); // returns &quot;def,123&quot;
 * 	i.hasNext(); // false
 * </code>
 * </pre>
 * <p>
 * Iterating an empty CharSequence or a CharSequence without (unquoted) separators will return exactly one element.
 * <p/>
 * Example:
 * <p>
 * <pre>
 * <code>
 * 	Iterator<CharSequence> i = new Split("", ',').iterator();
 * 	i.next(); // returns &quot;&quot;
 * 	i.hasNext(); // false
 *
 * 	Iterator<CharSequence> i2 = new Split("\"abc,def\"", ',').iterator();
 * 	i2.next(); // returns &quot;abc,def&quot;
 * 	i2.hasNext(); // false
 * </code>
 * </pre>
 *
 * @author Marten Gajda
 */
public final class UnquotedSplit implements Iterable<CharSequence>
{
    private CharSequence mValue;
    private char mSeparator;
    private char mQuotingChar;


    /**
     * Creates an {@link Iterable} that returns {@link Iterator}s for all elements of the given CharSequence which are
     * separated by the given <code>separator</code>, unless it's quoted in {@code "}.
     *
     * @param value
     *         The CharSequence that contains a list of values.
     * @param separator
     *         The separator that separates the values.
     */
    public UnquotedSplit(CharSequence value, char separator)
    {
        this(value, separator, '"');
    }


    /**
     * Creates an {@link Iterable} that returns {@link Iterator}s for all elements of the given CharSequence which are
     * separated by the given <code>separator</code>, unless it's quoted in a pair of the given quote character.
     *
     * @param value
     *         The CharSequence that contains a list of values.
     * @param separator
     *         The separator that separates the values.
     */
    public UnquotedSplit(CharSequence value, char separator, char quotingChar)
    {
        mValue = value;
        mSeparator = separator;
        mQuotingChar = quotingChar;
    }


    @Override
    public Iterator<CharSequence> iterator()
    {
        return new org.dmfs.iterators.UnquotedSplit(mValue, mSeparator, mQuotingChar);
    }

}
