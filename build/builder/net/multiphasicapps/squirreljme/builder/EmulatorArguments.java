// -*- Mode: Java; indent-tabs-mode: t; tab-width: 4 -*-
// ---------------------------------------------------------------------------
// Multi-Phasic Applications: SquirrelJME
//     Copyright (C) Steven Gawroriski <steven@multiphasicapps.net>
//     Copyright (C) Multi-Phasic Applications <multiphasicapps.net>
// ---------------------------------------------------------------------------
// SquirrelJME is under the GNU General Public License v3+, or later.
// See license.mkd for licensing and copyright information.
// ---------------------------------------------------------------------------

package net.multiphasicapps.squirreljme.builder;

import java.io.InputStream;
import java.io.IOException;
import net.multiphasicapps.squirreljme.jit.base.JITTriplet;
import net.multiphasicapps.zip.blockreader.ZipEntry;
import net.multiphasicapps.zip.blockreader.ZipFile;

/**
 * This class contains the arguments which are needed to setup a target
 * emulator for testing and other such things.
 *
 * @since 2016/07/30
 */
public final class EmulatorArguments
{
	/** The build configuration. */
	protected final BuildConfig config;
	
	/** The bootstrap ZIP. */
	protected final ZipFile zip;
	
	/** The optional alternative executable name. */
	protected final String altexe;
	
	/** Emulator command arguments. */
	protected final String[] args;
	
	/**
	 * Initializes the emulator arguments.
	 *
	 * @param __conf The build configuration.
	 * @param __zip The ZIP which contains the SquirrelJME executable (or
	 * another one).
	 * @param __altexe The alternative executable name, this argument is
	 * optional.
	 * @param __args Arguments to pass to the emulator.
	 * @throws NullPointerException On null arguments, except for optional
	 * ones.
	 * @since 2016/07/30
	 */
	public EmulatorArguments(BuildConfig __conf, ZipFile __zip,
		String __altexe, String[] __args)
		throws NullPointerException
	{
		// Check
		if (__conf == null || __zip == null)
			throw new NullPointerException("NARG");
		
		// Set
		this.config = __conf;
		this.zip = __zip;
		this.altexe = __altexe;
		String[] args;
		this.args = (args = (__args == null ? new String[0] : __args.clone()));
		
		// Check
		for (String s : args)
			if (s == null)
				throw new NullPointerException("NARG");
	}
	
	/**
	 * Returns the arguments to the program to be ran.
	 *
	 * @return The arguments to the running program.
	 * @since 2016/07/30
	 */
	public String[] arguments()
	{
		return args.clone();
	}
	
	/**
	 * Returns either the alternative executable name or the default.
	 *
	 * @param __def The default executable name to use.
	 * @return The name of the executable.
	 * @throws NullPointerException On null arguments.
	 * @since 2016/07/30
	 */
	public String executableName(String __def)
		throws NullPointerException
	{
		// Check
		if (__def == null)
			throw new NullPointerException("NARG");
		
		// Use alternative?
		String alt = this.altexe;
		return (alt != null ? alt : __def);
	}
	
	/**
	 * Returns the full set of arguments to pass to the emulator.
	 *
	 * @param __def The default executable name.
	 * @return The arguments to the emulator.
	 * @throws NullPointerException On null arguments.
	 * @since 2016/07/30
	 */
	public String[] fullArguments(String __def)
		throws NullPointerException
	{
		// Check
		if (__def == null)
			throw new NullPointerException("NARG");
		
		// Get
		String[] args = this.args;
		int n = args.length;
		
		// Setup new array
		String[] rv = new String[n + 1];
		rv[0] = executableName(__def);
		
		// Pass extra arguments
		for (int i = 0, j = 1; i < n; i++, j++)
			rv[j] = args[i];
		
		// Return
		return rv;
	}
	
	/**
	 * Loads the executable into a byte array and then returns it.
	 *
	 * @param __def The default executable name to use, if an alternative was
	 * not specified.
	 * @return The byte array for the executable.
	 * @since 2016/07/30
	 */
	public byte[] loadExecutable(String __def)
		throws IOException, NullPointerException
	{
		// Check
		if (__def == null)
			throw new NullPointerException("NARG");
		
		// Find the entry
		String want;
		ZipEntry e = this.zip.get((want = executableName(__def)));
		
		// {@squirreljme.error DW0w The executed to be read into a byte array
		// does not exist. (The wanted executable)}
		if (e == null)
			throw new IOException(String.format("DW0w %s", want));
		
		// {@squirreljme.error DW0x The executable exceeds 2GiB in length or
		// has a negative length. (The executable size)}
		long lsize = e.size();
		if (lsize < 0 || lsize > Integer.MAX_VALUE)
			throw new IOException(String.format("DW0x %d", lsize));
		int size = (int)lsize;
		
		// Setup target
		byte[] rv = new byte[size];
		
		// Copy data
		int copysize = 4096;
		try (InputStream is = e.open())
		{
			// Debug
			System.err.printf("DEBUG -- Bin Before %d%n", size);
			
			// Debug
			int debuglast = 0;
			
			// Read in all the bytes
			int left = size;
			for (int at = 0; left > 0;)
			{
				// Debug
				if (at > debuglast + copysize)
				{
					System.err.printf("DEBUG -- During %d/%d%n", at, size);
					debuglast = at;
				}
				
				// Read in the data
				int cc = Math.min(copysize, left);
				int rc = is.read(rv, at, cc);
				
				// Adjust amounts
				at += rc;
				left -= rc;
			}
			
			// Debug
			System.err.println("DEBUG -- Bin After");
		}
		
		// Return
		return rv;
	}
	
	/**
	 * Returns the target triplet.
	 *
	 * @return The target triplet.
	 * @since 2016/07/30
	 */
	public JITTriplet triplet()
	{
		return this.config.triplet();
	}
	
	/**
	 * Returns the ZIP file that is associated with the emulator for running.
	 *
	 * @return The ZIP file which is used.
	 * @since 2016/08/21
	 */
	public ZipFile zipFile()
	{
		return this.zip;
	}
}

