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


/**
 * The abstract super class of all {@link Iterator}s in this package. Classes that inherit from this class will always throw an
 * {@link UnsupportedOperationException} when {@link #remove()} is called.
 * 
 * @author Marten Gajda <marten@dmfs.org>
 * 
 * @param <E>
 *            The type of the iterated values.
 */
public abstract class AbstractBaseIterator<E> implements Iterator<E>
{

	@Override
	public final void remove()
	{
		throw new UnsupportedOperationException("Removing elements is not supported by this iterator.");
	}

}
