package org.dmfs.iterators.filters;

import org.dmfs.iterators.AbstractFilteredIterator;


public class Skip<E> implements AbstractFilteredIterator.IteratorFilter<E>
{
	private int mElementsToSkip;


	public Skip(int elementsToSkip)
	{
		mElementsToSkip = elementsToSkip;
	}


	@Override
	public boolean iterate(E element)
	{
		if (mElementsToSkip > 0)
		{
			--mElementsToSkip;
			return false;
		}
		return true;
	}
}
