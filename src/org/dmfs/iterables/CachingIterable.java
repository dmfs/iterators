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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * An {@link Iterable} that stores the result of a given {@link Iterator} and allows to re-iterate the values. This is meant to speed up repeated access to slow
 * iterators.
 * <p />
 * Note that {@link CachingIterable} needs to synchronize access to the original iterator (and an internal list), which causes some overhead. So only use this
 * if reiterating the original source is impossible, very time consuming or you need to re-iterate often.
 * 
 * @author Marten Gajda <marten@dmfs.org>
 * 
 * @param <T>
 *            The type of the iterated elements.
 */
public final class CachingIterable<T> implements Iterable<T>
{
	private final List<T> mCache;
	private final Iterator<T> mSourceIterator;


	public CachingIterable(Iterator<T> iterator)
	{
		mCache = new ArrayList<T>(64);
		mSourceIterator = iterator;
	}


	@Override
	public Iterator<T> iterator()
	{
		return new CachingIterator<T>(mSourceIterator, mCache);
	}

	private final static class CachingIterator<T> implements Iterator<T>
	{
		private final Iterator<T> mOriginalIterator;
		private final List<T> mCache;
		private int mPos;


		public CachingIterator(Iterator<T> originalIterator, List<T> cache)
		{
			mOriginalIterator = originalIterator;
			mCache = cache;
		}


		@Override
		public boolean hasNext()
		{
			synchronized (this)
			{
				return mPos < mCache.size() || mOriginalIterator.hasNext();
			}
		}


		@Override
		public T next()
		{
			synchronized (this)
			{
				if (mPos == mCache.size())
				{
					// the list has no more elements, try to append one from the original iterator
					T next = mOriginalIterator.next();
					mCache.add(next);
					mPos++;
					return next;
				}
				return mCache.get(mPos++);
			}
		}


		@Override
		public void remove()
		{
			throw new UnsupportedOperationException("Remove is not supported by this Iterator.");
		}
	}
}
