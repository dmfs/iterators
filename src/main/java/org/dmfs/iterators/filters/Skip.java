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

package org.dmfs.iterators.filters;

import org.dmfs.iterators.AbstractFilteredIterator;
import org.dmfs.iterators.AbstractFilteredIterator.IteratorFilter;


/**
 * An {@link IteratorFilter} that skips a specific number of elements.
 *
 * @param <E>
 *         The element type.
 *
 * @author Marten Gajda <marten@dmfs.org>
 */
public final class Skip<E> implements AbstractFilteredIterator.IteratorFilter<E>
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
