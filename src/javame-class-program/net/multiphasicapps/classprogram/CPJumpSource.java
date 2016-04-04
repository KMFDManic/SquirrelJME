// -*- Mode: Java; indent-tabs-mode: t; tab-width: 4 -*-
// ---------------------------------------------------------------------------
// Multi-Phasic Applications: SquirrelJME
//     Copyright (C) 2013-2016 Steven Gawroriski <steven@multiphasicapps.net>
//     Copyright (C) 2013-2016 Multi-Phasic Applications <multiphasicapps.net>
// ---------------------------------------------------------------------------
// SquirrelJME is under the GNU Affero General Public License v3+, or later.
// For more information see license.mkd.
// ---------------------------------------------------------------------------

package net.multiphasicapps.classprogram;

import net.multiphasicapps.descriptors.BinaryNameSymbol;

/**
 * This represents the source of a jump (which is not natural) to get to this
 * specific location from another instruction.
 *
 * It should be noted that the address ranges are both inclusive.
 *
 * @since 2016/03/30
 */
public class CPJumpSource
{
	/** The owning program. */
	protected final CPProgram program;
	
	/** The type of jump. */
	protected final CPJumpType type;
	
	/** The low address (inclusive). */
	protected final int lowaddr;
	
	/** The high address (inclusive). */
	protected final int highaddr;
	
	/** The exception to catch. */
	protected final BinaryNameSymbol exception;
	
	/**
	 * Initializes the jump source.
	 *
	 * @param __prg The program containing the jump source.
	 * @param __jt The type of jump this is.
	 * @param __addr The source address of the jump.
	 * @throws NullPointerException On null arguments.
	 * @since 2016/03/30
	 */
	CPJumpSource(CPProgram __prg, CPJumpType __jt, int __addr)
		throws NullPointerException
	{
		this(__prg, __jt, __addr, __addr);
	}
	
	/**
	 * Initializes the jump source.
	 *
	 * @param __prg The program containing the jump source.
	 * @param __jt The type of jump this is.
	 * @param __lo The inclusive starting address of the jump.
	 * @param __hi The inclusive ending address of the jump.
	 * @throws IllegalArgumentException If the jump type is not exceptional
	 * and the low address is not equal to the high address.
	 * @throws CPProgramException If the low or high address are negative or
	 * exceed the program size, or the high address is lower than the lower
	 * address.
	 * @throws NullPointerException On null arguments.
	 * @since 2016/03/30
	 */
	CPJumpSource(CPProgram __prg, CPJumpType __jt, int __lo, int __hi)
		throws IllegalArgumentException, CPProgramException,
			NullPointerException
	{
		this(__prg, __jt, null, __lo, __hi);
	}
	
	/**
	 * Initializes the jump source.
	 *
	 * @param __prg The program containing the jump source.
	 * @param __jt The type of jump this is.
	 * @param __bn If an exception, this is the exception which is handled.
	 * @param __lo The inclusive starting address of the jump.
	 * @param __hi The inclusive ending address of the jump.
	 * @throws IllegalArgumentException If the jump type is not exceptional
	 * and the low address is not equal to the high address, it is not
	 * exceptional and a binary name was specified, or a binary name was
	 * not specified and this is an exception.
	 * @throws CPProgramException If the low or high address are negative or
	 * exceed the program size, or the high address is lower than the lower
	 * address.
	 * @throws NullPointerException On null arguments, except for {@link __bn}
	 * unless the jump type is an exception.
	 * @since 2016/03/30
	 */
	CPJumpSource(CPProgram __prg, CPJumpType __jt, BinaryNameSymbol __bn,
		int __lo, int __hi)
		throws IllegalArgumentException, CPProgramException,
			NullPointerException
	{
		// Check
		if (__prg == null || __jt == null)
			throw new NullPointerException("NARG");
			
		// {@squirreljme.error CP05 The low address is higher than the higher
		// address or the low or high address are outside the bounds of the
		// program. (The low address; The high address)}
		if (__lo < 0 || __hi < 0 || __hi < __lo || __lo >= __prg.size() ||
			__hi >= __prg.size())
			throw new CPProgramException(String.format("CP05 %d %d",
				__lo, __hi));
		
		// {@squirreljme.error CP06 Non-exceptional jump sources must only
		// have a source which consists of a single address.}
		if (__jt != CPJumpType.EXCEPTIONAL && __lo != __hi)
			throw new IllegalArgumentException("CP06");
		
		// {@squirreljme.error CP07 A binary name must be specified with an
		// exceptional jump source and if not an exception then one must not
		// be specified.}
		if ((__jt == CPJumpType.EXCEPTIONAL) != (__bn != null))
			throw new IllegalArgumentException("CP07");
		
		// Set
		program = __prg;
		type = __jt;
		exception = __bn;
		lowaddr = Math.min(__lo, __hi);
		highaddr = Math.max(__lo, __hi);
	}
}

