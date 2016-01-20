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

package org.dmfs.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * An abstract {@link Iterator} that iterates the elements of another {@link Iterator}, if an {@link IteratorFilter} permits it.
 * 
 * @author Marten Gajda <marten@dmfs.org>
 * 
 * @param <E>
 *            The type of the iterated values.
 */
public abstract class AbstractFilteredIterator<E> extends AbstractBaseIterator<E>
{

	/**
	 * Interface of a filter for filtered Iterators.
	 * 
	 * @param <E>
	 *            The type of the filtered elements.
	 */
	public interface IteratorFilter<E>
	{
		/**
		 * Determines whether the given element should be iterated by a filtered Iterator or not.
		 * 
		 * @param element
		 *            The element to check.
		 * @return <code>true</code> to return the element as a result of the Iterator, <code>false</code> to omit this element.
		 */
		boolean iterate(E element);
	}

	private final Iterator<E> mIterator;
	private final IteratorFilter<E> mFilter;

	private E mNext;
	private boolean mHasNext;


	/**
	 * Creates a filtered {@link Iterator} that iterates the elements of the given {@link Iterator} if the given {@link IteratorFilter} permits it.
	 * 
	 * @param iterator
	 *            The {@link Iterator} to be filtered.
	 * @param filter
	 *            The {@link IteratorFilter}.
	 */
	public AbstractFilteredIterator(final Iterator<E> iterator, final IteratorFilter<E> filter)
	{
		mIterator = iterator;
		mFilter = filter;
		moveToNext();
	}


	@Override
	public final boolean hasNext()
	{
		return mHasNext;
	}


	@Override
	public final E next()
	{
		if (!mHasNext)
		{
			throw new NoSuchElementException("No more elements to iterate");
		}

		E result = mNext;
		moveToNext();
		return result;
	}


	private void moveToNext()
	{
		while (mIterator.hasNext())
		{
			E next = mIterator.next();
			if (mFilter.iterate(next))
			{
				mNext = next;
				mHasNext = true;
				return;
			}
		}

		mHasNext = false;
	}
}
