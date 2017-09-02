// -*- Mode: Java; indent-tabs-mode: t; tab-width: 4 -*-
// ---------------------------------------------------------------------------
// Multi-Phasic Applications: SquirrelJME
//     Copyright (C) Stephanie Gawroriski <xer@multiphasicapps.net>
//     Copyright (C) Multi-Phasic Applications <multiphasicapps.net>
// ---------------------------------------------------------------------------
// SquirrelJME is under the GNU General Public License v3+, or later.
// See license.mkd for licensing and copyright information.
// ---------------------------------------------------------------------------

package net.multiphasicapps.squirreljme.jit.java;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import net.multiphasicapps.squirreljme.jit.JITException;

/**
 * This represents a single entry within the stack map table which may
 * additionally has a flag indicating if an entry is initialized or not.
 *
 * @since 2017/09/02
 */
public final class StackMapTableEntry
{
	/** The top of a long. */
	public static final StackMapTableEntry TOP_LONG =
		new StackMapTableEntry(JavaType.TOP_LONG, true);
	
	/** The top of a double. */
	public static final StackMapTableEntry TOP_DOUBLE =
		new StackMapTableEntry(JavaType.TOP_DOUBLE, true);
	
	/** The type. */
	protected final JavaType type;
	
	/** Is this type initialized? */
	protected final boolean isinitialized;
	
	/** String representation. */
	private volatile Reference<String> _string;
	
	/**
	 * Initializes the stack map entry.
	 *
	 * @param __t The type of variable to store.
	 * @param __init If {@code true} this variable is initialized.
	 * @throws JITException If a non-object is set as not initialized.
	 * @throws NullPointerException On null arguments.
	 * @since 2017/09/02
	 */
	public StackMapTableEntry(JavaType __t, boolean __init)
		throws JITException, NullPointerException
	{
		// Check
		if (__t == null)
			throw new NullPointerException("NARG");
		
		// {@squirreljme.error JI2c Non-object types cannot be uninitialized.
		// (The type)}
		if (!__init && !__t.isObject())
			throw new JITException(String.format("JI2c %s", __t));
		
		// Set
		this.type = __t;
		this.isinitialized = __init;
	}
	
	/**
	 * {@inheritDoc}
	 * @since 2017/09/02
	 */
	@Override
	public boolean equals(Object __o)
	{
		if (!(__o instanceof StackMapTableEntry))
			return false;
		
		StackMapTableEntry o = (StackMapTableEntry)__o;
		return this.type.equals(o.type) &&
			this.isinitialized == o.isinitialized;
	}
	
	/**
	 * {@inheritDoc}
	 * @since 2017/09/02
	 */
	@Override
	public int hashCode()
	{
		return this.type.hashCode() ^ (this.isinitialized ? 1 : 0);
	}
	
	/**
	 * Has this type been initialized?
	 *
	 * @return {@code true} if this type was initialized.
	 * @since 2017/08/13
	 */
	public boolean isInitialized()
	{
		return this.isinitialized;
	}
	
	/**
	 * {@inheritDoc}
	 * @since 2017/09/02
	 */
	@Override
	public String toString()
	{
		Reference<String> ref = this._string;
		String rv;
		
		// Cache?
		if (ref == null || null == (rv = ref.get()))
			this._string = new WeakReference<>((rv = String.format("%s%s",
				(this.isinitialized ? "!" : ""), this.type)));
		
		return rv;
	}
	
	/**
	 * Returns the type.
	 *
	 * @return The type.
	 * @since 2017/09/02
	 */
	public JavaType type()
	{
		return this.type;
	}
}

