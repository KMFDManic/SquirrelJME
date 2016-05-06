// -*- Mode: Java; indent-tabs-mode: t; tab-width: 4 -*-
// ---------------------------------------------------------------------------
// Multi-Phasic Applications: SquirrelJME
//     Copyright (C) 2013-2016 Steven Gawroriski <steven@multiphasicapps.net>
//     Copyright (C) 2013-2016 Multi-Phasic Applications <multiphasicapps.net>
// ---------------------------------------------------------------------------
// SquirrelJME is under the GNU Affero General Public License v3+, or later.
// For more information see license.mkd.
// ---------------------------------------------------------------------------

package net.multiphasicapps.narf.interpreter;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import net.multiphasicapps.descriptors.MethodSymbol;
import net.multiphasicapps.narf.classinterface.NCIMethod;
import net.multiphasicapps.narf.classinterface.NCIMethodFlags;
import net.multiphasicapps.narf.codeparse.NCPCodeParser;
import net.multiphasicapps.narf.program.NRProgram;

/**
 * This represents a method which exists within a class.
 *
 * @since 2016/04/22
 */
public class NIMethod
	extends NIMember<NCIMethod>
{
	/** Internal lock. */
	protected final Object lock =
		new Object();
	
	/** The cached program. */
	private volatile Reference<NRProgram> _program;

	/**
	 * Initializes the method.
	 *
	 * @param __oc The owning class.
	 * @param __m The base method.
	 * @since 2016/04/22
	 */
	public NIMethod(NIClass __oc, NCIMethod __m)
	{
		super(__oc, __m);
	}
	
	/**
	 * {@inheritDoc}
	 * @since 2016/04/26
	 */
	@Override
	public NCIMethodFlags flags()
	{
		return base.flags();
	}
	
	/**
	 * Returns the program which describes the current method.
	 *
	 * @return The decoded program.
	 * @throws NIException If the program is not valid.
	 * @since 2016/04/27
	 */
	public NRProgram program()
		throws NIException
	{
		// {@squirreljme.error AN0k Attempted to invoke an abstract method.
		// (The method to invoke)}
		if (flags().isAbstract())
			throw new NIException(core, NIException.Issue.INVOKE_ABSTRACT,
				String.format("AN0k", this));
		
		// Get reference
		Reference<NRProgram> ref = _program;
		NRProgram rv;
		
		// In the reference?
		if (ref != null)
			if (null != (rv = ref.get()))
				return rv;
		
		// Lock
		synchronized (lock)
		{
			// Get reference again
			ref = _program;
			
			// Needs to be cached?
			if (ref == null || null == (rv = ref.get()))
				_program = new WeakReference<>((rv = new NCPCodeParser(
					core.library(), base).get()));
			
			return rv;
		}
	}
}

