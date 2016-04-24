// -*- Mode: Java; indent-tabs-mode: t; tab-width: 4 -*-
// ---------------------------------------------------------------------------
// Multi-Phasic Applications: SquirrelJME
//     Copyright (C) 2013-2016 Steven Gawroriski <steven@multiphasicapps.net>
//     Copyright (C) 2013-2016 Multi-Phasic Applications <multiphasicapps.net>
// ---------------------------------------------------------------------------
// SquirrelJME is under the GNU Affero General Public License v3+, or later.
// For more information see license.mkd.
// ---------------------------------------------------------------------------

package net.multiphasicapps.narf.classfile;

import java.io.DataInputStream;
import java.io.IOException;
import net.multiphasicapps.narf.classinterface.NCIConstantEntry;
import net.multiphasicapps.narf.classinterface.NCIConstantPool;
import net.multiphasicapps.narf.classinterface.NCIException;

/**
 * This decodes the constant pool of a class.
 *
 * @since 2016/04/24
 */
class __PoolDecoder__
{
	/** The UTF constant tag. */
	protected static final int TAG_UTF8 =
		1;
	
	/** Integer constant. */
	protected static final int TAG_INTEGER =
		3;
	
	/** Float constant. */
	protected static final int TAG_FLOAT =
		4;
	
	/** Long constant. */
	protected static final int TAG_LONG =
		5;
	
	/** Double constant. */
	protected static final int TAG_DOUBLE =
		6;
	
	/** Reference to another class. */
	protected static final int TAG_CLASS =
		7;
	
	/** String constant. */
	protected static final int TAG_STRING =
		8;
	
	/** Field reference. */
	protected static final int TAG_FIELDREF =
		9;
	
	/** Method reference. */
	protected static final int TAG_METHODREF =
		10;
	
	/** Interface method reference. */
	protected static final int TAG_INTERFACEMETHODREF =
		11;
	
	/** Name and type. */
	protected static final int TAG_NAMEANDTYPE =
		12;
	
	/** Method handle (illegal). */
	protected static final int TAG_METHODHANDLE =
		15;
	
	/** Method type (illegal). */
	protected static final int TAG_METHODTYPE =
		16;
	
	/** Invoke dynamic call site (illegal). */
	protected static final int TAG_INVOKEDYNAMIC =
		18;
	
	/** The outer class. */
	protected final NCFClass outerclass;
	
	/** The input data stream. */
	protected final DataInputStream das;
	
	/** The target pool list. */
	protected final NCIConstantEntry[] entries;
	
	/**
	 * Initializes the constant pool decoder.
	 *
	 * @param __oc The outer class.
	 * @param __das The input data source.
	 * @throws IOException On read errors.
	 * @throws NullPointerException On null arguments.
	 * @since 2016/04/24
	 */
	__PoolDecoder__(NCFClass __oc, DataInputStream __das)
		throws IOException, NullPointerException
	{
		// Check
		if (__oc == null || __das == null)
			throw new NullPointerException("NARG");
		
		// Set
		outerclass = __oc;
		das = __das;
		
		// Read entry count, a class cannot have zero entries in it
		int numentries = __is.readUnsignedShort();
		
		// {@squirreljme.errr CF0k Class has a constant pool with a negative
		// number of entries.}
		if (numentries <= 0)
			throw new NCIException(NCIException.Issue.INVALID_POOL_SIZE,
				"CF0k");
		
		// Setup target array
		entries = new NCIConstantEntry[numentries];
	}
	
	/**
	 * This decodes the constant pool.
	 *
	 * @return The loaded constant pool.
	 * @throws IOException On read errors.
	 * @since 2016/04/24
	 */
	public NCIConstantPool get()
		throws IOException
	{
		// Some entries refer to other entries
		int n = entries.length;
		int[][] dref = new int[n][];
		
		// Decode all entries
		for (int i = 1; i < n; i++)
		{
			// Read tag
			int tag = das.readUnsignedByte();
			switch (tag)
			{
					// UTF string
				case TAG_UTF8:
					throw Error("TODO");
					
					// Integer constant
				case TAG_INTEGER:
					throw Error("TODO");
					
					// Float constant
				case TAG_FLOAT:
					throw Error("TODO");
					
					// Long constant
				case TAG_LONG:
					throw Error("TODO");
					
					// Double constant
				case TAG_DOUBLE:
					throw Error("TODO");
					
					// Single reference
				case TAG_CLASS:
				case TAG_STRING:
					dref[i] = new int[]{tag, das.readUnsignedShort()};
					break;
					
					// Double reference
				case TAG_NAMEANDTYPE:
					dref[i] = new int[]{tag, das.readUnsignedShort(),
						das.readUnsignedShort()};
					break;
					
					// Triple reference
				case TAG_FIELDREF:
				case TAG_METHODREF:
				case TAG_INTERFACEMETHODREF:
					dref[i] = new int[]{tag, das.readUnsignedShort(),
						das.readUnsignedShort(), das.readUnsignedShort()};
					break;
					
					// invokedynamic is not supported!
				case TAG_METHODHANDLE:
				case TAG_METHODTYPE:
				case TAG_INVOKEDYNAMIC:
					// {@squirreljme.error CF0l {@code invokedynamic} is not
					// supported in Java ME.}
					throw new NCIException(NCIException.Issue.INVOKEDYNAMIC,
						"CF0l");
					
					// Unknown
				default:
					// {@squirreljme.error CF0m The specified constant pool
					// tag is not valid. (The illegal constant pool tag).}
					throw new NCIException(NCIException.Issue.ILLEGAL_TAG,
						String.format("CF0m %d", tag));
			}
			
			throw new Error("TODO");
		}
		
		// Build entries for references
		for (int i = 0; i < n; i++)
		{
			// Uses references?
			int refs[] = dref[i];
			
			// Not shared
			if (ref == null)
				continue;
			
			throw new Error("TODO");
		}
		
		// Build it
		return new NCIConstantPool(entries);
	}
}

