package org.dmfs.iterators.filters;

import org.dmfs.iterators.AbstractFilteredIterator;


public class NoneOf<E> implements AbstractFilteredIterator.IteratorFilter<E>
{
	private final E[] mExcludes;


	@SafeVarargs
	public NoneOf(E... excludes)
	{
		mExcludes = excludes;
	}


	@Override
	public boolean iterate(E element)
	{
		for (E exclude : mExcludes)
		{
			if (exclude == null && element == null || exclude != null && exclude.equals(element))
			{
				return false;
			}
		}
		return true;
	}

}
