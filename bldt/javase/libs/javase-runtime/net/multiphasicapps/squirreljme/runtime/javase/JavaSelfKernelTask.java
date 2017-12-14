// -*- Mode: Java; indent-tabs-mode: t; tab-width: 4 -*-
// ---------------------------------------------------------------------------
// Multi-Phasic Applications: SquirrelJME
//     Copyright (C) Stephanie Gawroriski <xer@multiphasicapps.net>
//     Copyright (C) Multi-Phasic Applications <multiphasicapps.net>
// ---------------------------------------------------------------------------
// SquirrelJME is under the GNU General Public License v3+, or later.
// See license.mkd for licensing and copyright information.
// ---------------------------------------------------------------------------

package net.multiphasicapps.squirreljme.runtime.javase;

import net.multiphasicapps.squirreljme.runtime.kernel.KernelTask;

/**
 * This task represents the kernel itself, this task is granted all
 * permissions.
 *
 * @since 2017/12/11
 */
public final class JavaSelfKernelTask
	extends KernelTask
{
	/**
	 * Initializes the self task.
	 *
	 * @since 2017/12/14
	 */
	public JavaSelfKernelTask()
	{
		super(~0);
	}
}

