/* -*- Mode: C; indent-tabs-mode: t; tab-width: 4 -*-
// ---------------------------------------------------------------------------
// Multi-Phasic Applications: SquirrelJME
//     Copyright (C) Stephanie Gawroriski <xer@multiphasicapps.net>
// ---------------------------------------------------------------------------
// SquirrelJME is under the GNU General Public License v3+, or later.
// See license.mkd for licensing and copyright information.
// --------------------------------------------------------------------------*/

/**
 * RatufaCoat main library header.
 *
 * @since 2019/01/14
 */

/** Header guard. */
#ifndef SJME_hGRATUFACOATRATACHRATUFACH
#define SJME_hGRATUFACOATRATACHRATUFACH

/** Common includes. */
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <string.h>

/** Anti-C++. */
#ifdef _cplusplus
#ifndef SJME_CXX_IS_EXTERNED
#define SJME_CXX_IS_EXTERNED
#define SJME_cXRATUFACOATRATACHRATUFACH
extern "C"
{
#endif /** #ifdef SJME_CXX_IS_EXTERNED */
#endif /** #ifdef __cplusplus */

/****************************************************************************/

/**
 * Native functions support for RatufaCoat.
 * 
 * @since 2019/05/28
 */
typedef struct ratufacoat_native_t
{
} ratufacoat_native_t;

/**
 * RatufaCoat active machine definition.
 * 
 * @since 2019/05/28
 */
typedef struct ratufacoat_machine_t
{
	/** Native function handlers. */
	ratufacoat_native_t* native;
} ratufacoat_machine_t;

/**
 * Creates a RatufaCoat machine.
 * 
 * @param argc Argument count.
 * @param argv Arguments.
 * @since 2019/05/28
 */
ratufacoat_machine_t* ratufacoat_createmachine(ratufacoat_native_t* native,
	int argc, char** argv);

/**
 * Fails the VM with a fatal ToDo.
 *
 * @since 2019/05/28
 */
void ratufacoat_todo(void);

/****************************************************************************/

/** Anti-C++. */
#ifdef __cplusplus
#ifdef SJME_cXRATUFACOATRATACHRATUFACH
}
#undef SJME_cXRATUFACOATRATACHRATUFACH
#undef SJME_CXX_IS_EXTERNED
#endif /** #ifdef SJME_cXRATUFACOATRATACHRATUFACH */
#endif /** #ifdef __cplusplus */

/** Header guard. */
#endif /* #ifndef SJME_hGRATUFACOATRATACHRATUFACH */

