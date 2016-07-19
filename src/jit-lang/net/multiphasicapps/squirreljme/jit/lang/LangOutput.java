// -*- Mode: Java; indent-tabs-mode: t; tab-width: 4 -*-
// ---------------------------------------------------------------------------
// Multi-Phasic Applications: SquirrelJME
//     Copyright (C) 2013-2016 Steven Gawroriski <steven@multiphasicapps.net>
//     Copyright (C) 2013-2016 Multi-Phasic Applications <multiphasicapps.net>
// ---------------------------------------------------------------------------
// SquirrelJME is under the GNU General Public License v3+, or later.
// For more information see license.mkd.
// ---------------------------------------------------------------------------

package net.multiphasicapps.squirreljme.jit.lang;

import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import net.multiphasicapps.squirreljme.jit.JITOutput;
import net.multiphasicapps.squirreljme.jit.JITOutputConfig;
import net.multiphasicapps.zip.ZipCompressionType;
import net.multiphasicapps.zip.streamwriter.ZipStreamWriter;

/**
 * This provides generic language output support which places files within a
 * TAR archive.
 *
 * @since 2016/07/09
 */
public abstract class LangOutput
	implements JITOutput
{
	/** The used configuration. */
	protected final JITOutputConfig.Immutable config;
	
	/**
	 * Initializes the base language output.
	 *
	 * @param __config The target configuration.
	 * @throws NullPointerException On null arguments.
	 * @since 2016/07/09
	 */
	public LangOutput(JITOutputConfig.Immutable __config)
		throws NullPointerException
	{
		// Check
		if (__config == null)
			throw new NullPointerException("NARG");
		
		// Set
		this.config = __config;
	}
	
	/**
	 * {@inheritDoc}
	 * @since 2016/07/18
	 */
	@Override
	public void linkBinary(OutputStream __os, String[] __names,
		InputStream[] __data)
		throws IOException, JITException, NullPointerException
	{
		// Check
		if (__os == null || __names == null || __data == null)
			throw new NullPointerException("NARG");
		
		// Setup output ZIP file which contains all the source code combined
		try (ZipStreamWriter zsw = new ZipStreamWriter(__os))
		{
			// Go through all input files and add them to the output ZIP
			int n = __names.length;
			for (int i = 0; i < n; i++)
			{
				// Get details
				String name = __names[i];
				
				// Stream the input ZIP and copy all entries
				throw new Error("TODO");
			}
		}
	}
}

