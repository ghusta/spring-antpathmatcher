/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.util;

/**
 * PARTIALLY BORROWED FROM SPRING.
 * <p>
 * Miscellaneous object utility methods.
 * <p>
 * <p>Mainly for internal use within the framework.
 * <p>
 * <p>Thanks to Alex Ruiz for contributing several enhancements to this class!
 *
 * @author Juergen Hoeller
 * @author Keith Donald
 * @author Rod Johnson
 * @author Rob Harrop
 * @author Chris Beams
 * @see ClassUtils
 * @see CollectionUtils
 * @see StringUtils
 * @since 19.03.2004
 */
abstract class ObjectUtils
{

    private static final int INITIAL_HASH = 7;
    private static final int MULTIPLIER = 31;

    private static final String EMPTY_STRING = "";
    private static final String NULL_STRING = "null";
    private static final String ARRAY_START = "{";
    private static final String ARRAY_END = "}";
    private static final String EMPTY_ARRAY = ARRAY_START + ARRAY_END;
    private static final String ARRAY_ELEMENT_SEPARATOR = ", ";

    /**
     * Return whether the given throwable is a checked exception:
     * that is, neither a RuntimeException nor an Error.
     *
     * @param ex the throwable to check
     * @return whether the throwable is a checked exception
     * @see java.lang.Exception
     * @see java.lang.RuntimeException
     * @see java.lang.Error
     */
    public static boolean isCheckedException(Throwable ex)
    {
        return !(ex instanceof RuntimeException || ex instanceof Error);
    }

    /**
     * Check whether the given exception is compatible with the specified
     * exception types, as declared in a throws clause.
     *
     * @param ex                 the exception to check
     * @param declaredExceptions the exception types declared in the throws clause
     * @return whether the given exception is compatible
     */
    public static boolean isCompatibleWithThrowsClause(Throwable ex, Class<?>... declaredExceptions)
    {
        if (!isCheckedException(ex))
        {
            return true;
        }
        if (declaredExceptions != null)
        {
            for (Class<?> declaredException : declaredExceptions)
            {
                if (declaredException.isInstance(ex))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Determine whether the given object is an array:
     * either an Object array or a primitive array.
     *
     * @param obj the object to check
     */
    public static boolean isArray(Object obj)
    {
        return (obj != null && obj.getClass().isArray());
    }

    /**
     * Determine whether the given array is empty:
     * i.e. {@code null} or of zero length.
     *
     * @param array the array to check
     */
    public static boolean isEmpty(Object[] array)
    {
        return (array == null || array.length == 0);
    }

}
