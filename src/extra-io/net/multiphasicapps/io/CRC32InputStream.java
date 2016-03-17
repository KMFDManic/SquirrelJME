// -*- Mode: Java; indent-tabs-mode: t; tab-width: 4 -*-
// ---------------------------------------------------------------------------
// Multi-Phasic Applications: SquirrelJME
//     Copyright (C) 2013-2016 Steven Gawroriski <steven@multiphasicapps.net>
//     Copyright (C) 2013-2016 Multi-Phasic Applications <multiphasicapps.net>
// ---------------------------------------------------------------------------
// SquirrelJME is under the GNU Affero General Public License v3+, or later.
// For more information see license.mkd.
// ---------------------------------------------------------------------------

package net.multiphasicapps.io;

import java.io.InputStream;
import java.io.IOException;

/**
 * This is an input stream which is used for calculating the CRC32 checksum to
 * make sure that data is valid.
 *
 * If CRC32 value checking is enabled, then closing the stream will read the
 * wrapped stream until the end is reached to determine if the checksum is
 * valid.
 *
 * @since 2016/03/09
 */
public class CRC32InputStream
	extends InputStream
{
	/** Lock. */
	protected final Object lock =
		new Object();
	
	/** The wrapped stream. */
	protected final InputStream wrapped;
	
	/** Match input CRC? */
	protected final boolean match;
	
	/** The input CRC to match at the end of the stream. */
	protected final int wantcrc;
	
	/** Magic number. */
	protected final int magic;
	
	/** Working value. */
	private volatile int _work;
	
	/**
	 * Initializes a CRC32 input stream which just calculates the CRC32.
	 *
	 * @param __w The stream to wrap.
	 * @param __mag Magic number.
	 * @param __pre Precondition.
	 * @throws NullPointerException On null arguments.
	 * @since 2016/03/09
	 */
	public CRC32InputStream(InputStream __w, int __mag, int __pre)	
		throws NullPointerException
	{
		this(__w, __mag, __pre, false, 0);
	}
	
	/**
	 * Initializes a CRC32 input stream which calculates the CRC32 and when
	 * the wrapped stream ends, a check is made to determine if the checksum is
	 * valid.
	 *
	 * @param __w The stream to wrap.
	 * @param __mag Magic number.
	 * @param __pre Precondition.
	 * @param __sum The checksum that the input stream must calculate to.
	 * @throws NullPointerException On null arguments.
	 * @since 2016/03/09
	 */
	public CRC32InputStream(InputStream __w, int __mag, int __pre, int __sum)
		throws NullPointerException
	{
		this(__w, __mag, __pre, true, __sum);
	}
	
	/**
	 * Initializes a CRC32 input stream which calculates the CRC32 and
	 * optionally checks it.
	 *
	 * @param __w The stream to wrap.
	 * @param __mag Magic number.
	 * @param __pre Precondition.
	 * @param __check If {@code true} then the CRC is checked at the close
	 * or end of the stream.
	 * @param __sum The checksum that the input stream must calculate to.
	 * @throws NullPointerException On null arguments.
	 * @since 2016/03/09
	 */
	public CRC32InputStream(InputStream __w, int __mag, int __pre,
		boolean __check, int __sum)
		throws NullPointerException
	{
		// Check
		if (__w == null)
			throw new NullPointerException("NARG");
		
		// Set
		wrapped = __w;
		match = __check;
		wantcrc = __sum;
		magic = __mag;
		
		// Initialize value is the precondition
		_work = __pre;
	}
	
	/**
	 * {@inheritDoc}
	 * @since 2016/03/09
	 */
	@Override
	public int available()
		throws IOException
	{
		return wrapped.available();
	}
	
	/**
	 * {@inheritDoc}
	 * @since 2016/03/09
	 */
	@Override
	public void close()
		throws IOException
	{
		throw new Error("TODO");
	}
	
	/**
	 * {@inheritDoc}
	 * @since 2016/03/09
	 */
	@Override
	public int read()
		throws IOException
	{
		throw new Error("TODO");
	}
}

