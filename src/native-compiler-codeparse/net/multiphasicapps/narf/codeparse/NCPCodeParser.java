// -*- Mode: Java; indent-tabs-mode: t; tab-width: 4 -*-
// ---------------------------------------------------------------------------
// Multi-Phasic Applications: SquirrelJME
//     Copyright (C) 2013-2016 Steven Gawroriski <steven@multiphasicapps.net>
//     Copyright (C) 2013-2016 Multi-Phasic Applications <multiphasicapps.net>
// ---------------------------------------------------------------------------
// SquirrelJME is under the GNU Affero General Public License v3+, or later.
// For more information see license.mkd.
// ---------------------------------------------------------------------------

package net.multiphasicapps.narf.codeparse;

import net.multiphasicapps.narf.classinterface.NCIClass;
import net.multiphasicapps.narf.classinterface.NCILibrary;
import net.multiphasicapps.narf.classinterface.NCIMethod;
import net.multiphasicapps.narf.classinterface.NCIPool;

/**
 * This class is given a method which is then parsed.
 *
 * @since 2016/04/20
 */
public class NCPCodeParser
{
	/** The library for class lookup (optimization). */
	protected final NCILibrary library;
	
	/** The containing class. */
	protected final NCIClass outerclass;
	
	/** The constant pool. */
	protected final NCIPool constantpool;
	
	/** The method to parse. */
	protected final NCIMethod method;
	
	/**
	 * Initializes the code parser.
	 *
	 * @param __lib The library used to lookup other class definitions.
	 * @param __m The method to parse.
	 * @throws NullPointerException On null arguments.
	 * @since 2016/04/27
	 */
	public NCPCodeParse(NCILibrary __lib, NCIMethod __m)
		throws NullPointerException
	{
		// Check
		if (__lib == null || __m == null)
			throw new NullPointerException("NARG");
		
		// Set
		library = __lib;
		method = __m;
		outerclass = __m.outerClass();
		constantpool = outerclass.constantPool();
	}
}

