// -*- Mode: Java; indent-tabs-mode: t; tab-width: 4 -*-
// ---------------------------------------------------------------------------
// Multi-Phasic Applications: SquirrelJME
//     Copyright (C) Steven Gawroriski <steven@multiphasicapps.net>
//     Copyright (C) Multi-Phasic Applications <multiphasicapps.net>
// ---------------------------------------------------------------------------
// SquirrelJME is under the GNU General Public License v3+, or later.
// See license.mkd for licensing and copyright information.
// ---------------------------------------------------------------------------

package net.multiphasicapps.squirreljme.jit.java;

/**
 * This holds the name and type strings, the type descriptor is not checked.
 *
 * @since 2017/06/12
 */
public final class NameAndType
{
	/**
	 * Initializes the name and type information.
	 *
	 * @param __n The name.
	 * @param __t The type.
	 * @throws NullPointerException On null arguments.
	 * @since 2017/06/12
	 */
	public NameAndType(Identifier __n, String __t)
		throws NullPointerException
	{
		// Check
		if (__n == null || __t == null)
			throw new NullPointerException("NARG");
		
		throw new todo.TODO();
	}
	
	/**
	 * {@inheritDoc}
	 * @since 2017/06/12
	 */
	@Override
	public boolean equals(Object __o)
	{
		throw new todo.TODO();
	}
	
	/**
	 * {@inheritDoc}
	 * @since 2017/06/12
	 */
	@Override
	public int hashCode()
	{
		throw new todo.TODO();
	}
	
	/**
	 * Returns the identifier.
	 *
	 * @return The identifier.
	 * @since 2017/06/12
	 */
	public Identifier name()
	{
		throw new todo.TODO();
	}
	
	/**
	 * {@inheritDoc}
	 * @since 2017/06/12
	 */
	@Override
	public String toString()
	{
		throw new todo.TODO();
	}
	
	/**
	 * Returns the type.
	 *
	 * @return The type.
	 * @since 2017/06/12
	 */
	public String type()
	{
		throw new todo.TODO();
	}
}

