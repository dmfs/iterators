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
import java.util.Set;

import org.dmfs.iterators.utils.SlimSet;


/**
 * An {@link Iterator} that returns the elements of another Iterator exactly once, not matter how often they are iterated by the decorated {@link Iterator}.
 * Only the first occurrence of each element will be iterated.
 * 
 * @author Marten Gajda <marten@dmfs.org>
 * 
 * @param <E>
 *            The type of the iterated values.
 */
public final class DistinctIterator<E> extends AbstractFilteredIterator<E>
{

	/**
	 * Return the values of the given {@link Iterator} exactly once.
	 * 
	 * @param iterator
	 */
	public DistinctIterator(final Iterator<E> iterator)
	{
		super(iterator, new IteratorFilter<E>()
		{
			private final Set<E> mIteratedElements = new SlimSet<E>(32);


			@Override
			public boolean iterate(E element)
			{
				// iterate the element only if it hasn't been added before
				return mIteratedElements.add(element);
			}
		});
	}
}
