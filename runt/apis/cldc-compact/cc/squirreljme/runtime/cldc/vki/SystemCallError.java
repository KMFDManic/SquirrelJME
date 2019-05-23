// -*- Mode: Java; indent-tabs-mode: t; tab-width: 4 -*-
// ---------------------------------------------------------------------------
// Multi-Phasic Applications: SquirrelJME
//     Copyright (C) Stephanie Gawroriski <xer@multiphasicapps.net>
// ---------------------------------------------------------------------------
// SquirrelJME is under the GNU General Public License v3+, or later.
// See license.mkd for licensing and copyright information.
// ---------------------------------------------------------------------------

package cc.squirreljme.runtime.cldc.vki;

/**
 * This interface contains the various error codes for all of the system calls.
 *
 * @since 2019/05/23
 */
public interface SystemCallError
{
	/** No error, or success. */
	public static final short NO_ERROR =
		0;
	
	/** The system call is not supported. */
	public static final short UNSUPPORTED_SYSTEM_CALL =
		-1;
}

