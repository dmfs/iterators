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
 * An {@link Iterator} that serializes the results of other iterators.
 *
 * @param <E>
 *         The type of the iterated values.
 *
 * @author Marten Gajda <marten@dmfs.org>
 */
public final class SerialIterator<E> extends AbstractBaseIterator<E>
{
    private final Iterator<E>[] mIterators;

    private int mCurrentIterator = 0;


    @SafeVarargs
    public SerialIterator(final Iterator<E>... iterators)
    {
        mIterators = iterators.clone();
    }


    @Override
    public boolean hasNext()
    {
        while (mCurrentIterator < mIterators.length && !mIterators[mCurrentIterator].hasNext())
        {
            // release the reference to this iterator early, we don't need it any longer
            mIterators[mCurrentIterator] = null;
            // move on to the next iterator
            ++mCurrentIterator;
        }

        return mCurrentIterator < mIterators.length;
    }


    @Override
    public E next()
    {
        if (!hasNext())
        {
            throw new NoSuchElementException("No more elements to iterate");
        }

        return mIterators[mCurrentIterator].next();
    }

}