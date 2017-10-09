// -*- Mode: Java; indent-tabs-mode: t; tab-width: 4 -*-
// ---------------------------------------------------------------------------
// Multi-Phasic Applications: SquirrelJME
//     Copyright (C) Stephanie Gawroriski <xer@multiphasicapps.net>
//     Copyright (C) Multi-Phasic Applications <multiphasicapps.net>
// ---------------------------------------------------------------------------
// SquirrelJME is under the GNU General Public License v3+, or later.
// See license.mkd for licensing and copyright information.
// ---------------------------------------------------------------------------

package net.multiphasicapps.squirreljme.unsafe;

/**
 * This class contains the internal methods which are to be rewritten if they
 * are called.
 *
 * @see SystemVM
 * @since 2017/08/10
 */
final class __Ext_systemvm__
{
	/**
	 * Not used.
	 *
	 * @since 2017/08/10
	 */
	private __Ext_systemvm__()
	{
	}
	
	/**
	 * This is used to detect whether the environment truly is running on
	 * SquirrelJME, that is if the virtual machine is SquirrelJME itself.
	 *
	 * SquirrelJME's libraries could potentially be used with other virtual
	 * machines. This is used to detect that case to determine how some
	 * methods should perform when they are called (for consistency).
	 *
	 * A SquirrelJME JVM is one that is generated by the build enviroment or
	 * interpreted environment, not a third party virtual machine (such as
	 * Hotspot or JamVM, which in that case this will return {@code false}).
	 *
	 * @return {@code true} if running on a SquirrelJME JVM,
	 * otherwise {@code false}.
	 * @since 2016/10/11
	 */
	static native boolean isSquirrelJMEJVM();
	
	/**
	 * Returns the e-mail to contact for the virtual machine.
	 *
	 * @return The contact e-mail for the virtual machine, if this is a
	 * SquirrelJME VM then the return value can be {@code null} because it is
	 * not used.
	 * @since 2017/10/02
	 */
	static native String javaVMEmail();
	
	/**
	 * Returns the name of the Java virtual machine.
	 *
	 * @return The name of the virtual machine, if this is a
	 * SquirrelJME VM then the return value can be {@code null} because it is
	 * not used.
	 * @since 2017/10/02
	 */
	static native String javaVMName();
	
	/**
	 * Returns the URL to the virtual machine's vendor's URL.
	 *
	 * @return The URL of the JVM's virtual machine, if this is a
	 * SquirrelJME VM then the return value can be {@code null} because it is
	 * not used.
	 * @since 2017/10/02
	 */
	static native String javaVMURL();
	
	/**
	 * Returns the vendor of the Java virtual machine.
	 *
	 * @return The vendor of the Java virtual machine, if this is a
	 * SquirrelJME VM then the return value can be {@code null} because it is
	 * not used.
	 * @since 2017/10/02
	 */
	static native String javaVMVendor();
	
	/**
	 * Returns the full version of the Java virtual machine.
	 *
	 * @return The full Java virtual machine version, if this is a
	 * SquirrelJME VM then the return value can be {@code null} because it is
	 * not used.
	 * @since 2017/08/13
	 */
	static native String javaVMVersionFull();
	
	/**
	 * Returns the short version of the Java virtual machine.
	 *
	 * @return The short Java virtual machine version, if this is a
	 * SquirrelJME VM then the return value can be {@code null} because it is
	 * not used.
	 * @since 2017/08/13
	 */
	static native String javaVMVersionShort();
}

