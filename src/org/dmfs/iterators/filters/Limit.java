package org.dmfs.iterators.filters;

import org.dmfs.iterators.AbstractFilteredIterator;


public class Limit<E> implements AbstractFilteredIterator.IteratorFilter<E>
{
	private int mElementsLeft;


	public Limit(int maxElements)
	{
		mElementsLeft = maxElements;
	}


	@Override
	public boolean iterate(E element)
	{
		if (mElementsLeft > 0)
		{
			--mElementsLeft;
			return true;
		}
		return false;
	}
}
