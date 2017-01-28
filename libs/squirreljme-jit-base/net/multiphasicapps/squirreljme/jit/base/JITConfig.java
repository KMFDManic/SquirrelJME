// -*- Mode: Java; indent-tabs-mode: t; tab-width: 4 -*-
// ---------------------------------------------------------------------------
// Multi-Phasic Applications: SquirrelJME
//     Copyright (C) Steven Gawroriski <steven@multiphasicapps.net>
//     Copyright (C) Multi-Phasic Applications <multiphasicapps.net>
// ---------------------------------------------------------------------------
// SquirrelJME is under the GNU General Public License v3+, or later.
// See license.mkd for licensing and copyright information.
// ---------------------------------------------------------------------------

package net.multiphasicapps.squirreljme.jit.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import net.multiphasicapps.util.unmodifiable.UnmodifiableMap;

/**
 * This represents and stores the configuration which is used to configure
 * how the JIT generates code.
 *
 * This class is serialized to a single string which is then stored in a
 * system property of the resultant executable so that at run-time the JIT may
 * be reconfigured to generate code for a target without requiring assistance.
 *
 * {@squirreljme.property net.multiphasicapps.squirreljme.jit.factory=(class)
 * This specifies an implementation of {@link JITOutputFactory} which is used
 * to generate the actual JIT code.}
 *
 * @since 2016/09/10
 */
@Deprecated
public final class JITConfig
{
	/** The property which defines the target triplet. */
	public static final String TRIPLET_PROPERTY =
		"net.multiphasicapps.squirreljme.jit.triplet";
	
	/** The factory instance to use when performing a compile. */
	public static final String FACTORY_PROPERTY =
		"net.multiphasicapps.squirreljme.jit.factory";
	
	/** The configuration properties. */
	protected final Map<String, String> properties;
	
	/** Key as a given instance of a given class cache. */
	private final Map<String, Reference<Object>> _keyasclass =
		new HashMap<>();
	
	/** The string representation. */
	private volatile Reference<String> _string;
	
	/** The serialized representation. */
	private volatile Reference<String> _serial;
	
	/** The triplet cache. */
	private volatile Reference<JITTriplet> _triplet;
	
	/**
	 * Initializes the configuration from the given builder.
	 *
	 * @param __b The builder to get information from.
	 * @throws NullPointerException On null arguments.
	 * @since 2016/09/10
	 */
	JITConfig(JITConfigBuilder __b)
		throws NullPointerException
	{
		// Check
		if (__b == null)
			throw new NullPointerException("NARG");
		
		// Get keys so that they can be sorted so that they appear in
		// alphabetical order
		Map<String, String> inprops = __b._properties;
		String[] keys = inprops.keySet().<String>toArray(
			new String[inprops.size()]);
		Arrays.<String>sort(keys);
		
		// Copy properties
		Map<String, String> target = new LinkedHashMap<>();
		for (String k : keys)
			target.put(k, inprops.get(k));
		
		// Lock in
		this.properties = UnmodifiableMap.<String, String>of(target);
	}
	
	/**
	 * This deserializes the JIT configuration from the given string and
	 * re-initializes any required fields from it.
	 *
	 * @param __s The string to deserialize.
	 * @throws NullPointerException On null arguments.
	 * @since 2016/09/10
	 */
	public JITConfig(String __s)
		throws NullPointerException
	{
		// Check
		if (__s == null)
			throw new NullPointerException("NARG");
		
		throw new Error("TODO");
	}
	
	/**
	 * Attempts to parse the value of the given pr
	 *
	 * @param <Q> The type of class to the key value as.
	 * @param __k The key to treat as a class name.
	 * @param __cl The class type to get the key as.
	 * @throws JITException If the value is {@code null} or is not of the
	 * given class type.
	 * @throws NullPointerException On null arguments.
	 * @since 2016/09/10
	 */
	public final <Q> Q getAsClass(String __k, Class<Q> __cl)
		throws JITException, NullPointerException
	{
		// Check
		if (__k == null || __cl == null)
			throw new NullPointerException("NARG");
		
		// {@squirreljme.error ED08 The specified property has not been set,
		// therefor it cannot be used to obtain a class. (The key)}
		String prop = getProperty(__k);
		if (prop == null)
			throw new JITException(String.format("ED08 %s", __k));
		
		// Lock
		Map<String, Reference<Object>> keyasclass = this._keyasclass;
		synchronized (keyasclass)
		{
			// Get
			Reference<Object> ref = keyasclass.get(__k);
			Object rv;
			
			// Cache?
			if (ref == null || null == (rv = ref.get()) ||
				!__cl.isInstance(rv))
				try
				{
					// Create instance
					Class<?> cl = Class.forName(prop);
					rv = cl.newInstance();
				
					// Store
					keyasclass.put(__k, new WeakReference<>(rv));
				}
			
				// {@squirreljme.error ED06 Could not initialize an instance
				// of the given class. (The requested key; The key value;
				// The requested class)}
				catch (ClassNotFoundException|InstantiationException|
					IllegalAccessException e)
				{
					throw new JITException(String.format("ED06 %s %s %s", __k,
						prop, __cl.getName()), e);
				}
			
			// Cast return
			return __cl.cast(rv);
		}
	}
	
	/**
	 * Returns a property that was set in the configuration.
	 *
	 * @return The property key to get the value for or {@code null} if it has
	 * not been set.
	 * @throws NUllPointerException On null arguments.
	 * @since 2016/09/10
	 */
	public final String getProperty(String __k)
		throws NullPointerException
	{
		// Check
		if (__k == null)
			throw new NullPointerException("NARG");
		
		// Get
		return this.properties.get(__k);
	}
	
	/**
	 * Serializes this configuration so that it may be stored within a system
	 * property.
	 *
	 * @return The serialized form of the current configuration.
	 * @since 2016/09/10
	 */
	public final String serialize()
	{
		// Get
		Reference<String> ref = this._serial;
		String rv;
		
		// Serialize it?
		if (ref == null || null == (rv = ref.get()))
			throw new Error("TODO");
		
		// Return it
		return rv;
	}
	
	/**
	 * {@inheritDoc]
	 * @since 2016/09/10
	 */
	@Override
	public final String toString()
	{
		// Get
		Reference<String> ref = this._string;
		String rv;
		
		// Cache?
		if (ref == null || null == (rv = ref.get()))
			this._string = new WeakReference<>((rv =
				this.properties.toString()));
		
		// Return
		return rv;
	}
	
	/**
	 * Returns the triplet used in the given configuration.
	 *
	 * @return The target triplet.
	 * @throws JITException If no triplet was specified or it is not valid.
	 * @since 2016/09/10
	 */
	public final JITTriplet triplet()
		throws JITException
	{
		// Get
		Reference<JITTriplet> ref = this._triplet;
		JITTriplet rv;
		
		// Cache?
		if (ref == null || null == (rv = ref.get()))
		{
			// {@squirreljme.error ED07 The triplet has not been specified in
			// the configuration. (This configuration)}
			String prop = getProperty(JITConfig.TRIPLET_PROPERTY);
			if (prop == null)
				throw new JITException(String.format("ED07 %s", this));
			
			// Create it
			this._triplet = new WeakReference<>((rv = new JITTriplet(prop)));
		}
		
		// Return it
		return rv;
	}
}

