/*
 * Copyright (C) 2016 Marten Gajda <marten@dmfs.org>
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
 *
 */

package org.dmfs.iterators.filters;

import org.dmfs.iterators.AbstractFilteredIterator.IteratorFilter;


/**
 * An {@link IteratorFilter} that removes all <code>null</code> elements.
 *
 * @author Marten Gajda <marten@dmfs.org>
 */
public final class NonNull<T> implements IteratorFilter<T>
{
    public final static IteratorFilter<Object> INSTANCE = new NonNull<Object>();


    @SuppressWarnings("unchecked")
    public static <T> NonNull<T> instance()
    {
        return (NonNull<T>) INSTANCE;
    }


    @Override
    public boolean iterate(T element)
    {
        return element != null;
    }
}
