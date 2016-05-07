package org.dmfs.iterators.filters;

import org.dmfs.iterators.AbstractFilteredIterator;


public class AnyOf<E> implements AbstractFilteredIterator.IteratorFilter<E>
{
	private final E[] mIncludes;


	@SafeVarargs
	public AnyOf(E... includes)
	{
		mIncludes = includes;
	}


	@Override
	public boolean iterate(E element)
	{
		for (E include : mIncludes)
		{
			if (include == null && element == null || include != null && include.equals(element))
			{
				return true;
			}
		}
		return false;
	}

}
