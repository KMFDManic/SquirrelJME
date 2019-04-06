// -*- Mode: Java; indent-tabs-mode: t; tab-width: 4 -*-
// ---------------------------------------------------------------------------
// Multi-Phasic Applications: SquirrelJME
//     Copyright (C) Stephanie Gawroriski <xer@multiphasicapps.net>
//     Copyright (C) Multi-Phasic Applications <multiphasicapps.net>
// ---------------------------------------------------------------------------
// SquirrelJME is under the GNU General Public License v3+, or later.
// See license.mkd for licensing and copyright information.
// ---------------------------------------------------------------------------

package net.multiphasicapps.classfile.register;

/**
 * Represents the type of operation to perform.
 *
 * @since 2019/03/17
 */
public interface RegisterOperationType
{
	/** Encoding: Special. */
	public static final int ENCODING_SPECIAL =
		0x00;
	
	/** Encoding: [U16]. */
	public static final int ENCODING_U16 =
		0x10;
	
	/** Encoding: [U16]. */
	public static final int ENCODING_U16_2 =
		0x20;
	
	/** Encoding: [J16]. */
	public static final int ENCODING_J16 =
		0x30;
	
	/** Encoding: [U16, J16]. */
	public static final int ENCODING_U16_J16 =
		0x40;
	
	/** Encoding: [POOL16, U16]. */
	public static final int ENCODING_POOL16_U16 =
		0x50;
	
	/** Encoding: [U16, U16, J16]. */
	public static final int ENCODING_U16_U16_J16 =
		0x60;
	
	/** Encoding: [POOL16, U16, U16]. */
	public static final int ENCODING_POOL16_U16_U16 =
		0x70;
	
	/** Encoding: [U16, U16] (1). */
	public static final int ENCODING_U16_U16 =
		0x80;
	
	/** Encoding: [U16, U16] (2). */
	public static final int ENCODING_U16_U16_2 =
		0x90;
	
	/** Encoding: [U16, U16, U16]. */
	public static final int ENCODING_U16_U16_U16 =
		0xA0;
	
	/** Encoding: [U16, U16, U16]. */
	public static final int ENCODING_U16_U16_U16_2 =
		0xB0;
	
	/** Encoding: [U16, U16, U16]. */
	public static final int ENCODING_U16_U16_U16_3 =
		0xC0;
	
	/** nop []. */
	public static final int NOP =
		ENCODING_SPECIAL + 0;

	/** return []. */
	public static final int RETURN =
		ENCODING_SPECIAL + 1;

	/** invoke_method [pool16, reglist]. */
	public static final int INVOKE_METHOD =
		ENCODING_SPECIAL + 2;

	/** x32_const [u32, u16]. */
	public static final int X32_CONST =
		ENCODING_SPECIAL + 3;

	/** x64_const [u64, u16]. */
	public static final int X64_CONST =
		ENCODING_SPECIAL + 4;

	/** lookupswitch [u16, u16, [i32, i32, j16]...]. */
	public static final int LOOKUPSWITCH =
		ENCODING_SPECIAL + 5;

	/** tableswitch [u16, i32, i32, i32, u16, [i32, j16]...]. */
	public static final int TABLESWITCH =
		ENCODING_SPECIAL + 6;

	/** jump_if_instance [pool16, u16, j16]. */
	public static final int JUMP_IF_INSTANCE =
		ENCODING_SPECIAL + 7;
	
	/** jump_if_instance_get_exception [pool16, u16, j16, u16]. */
	public static final int JUMP_IF_INSTANCE_GET_EXCEPTION =
		ENCODING_SPECIAL + 8;
	
	/** ref_enqueue [reglist]. */
	public static final int REF_ENQUEUE =
		ENCODING_SPECIAL + 9;
	
	/** ref_clear []. */
	public static final int REF_CLEAR =
		ENCODING_SPECIAL + 10;
	
	/** jump_if_not_instance [pool16, u16, j16]. */
	public static final int JUMP_IF_NOT_INSTANCE =
		ENCODING_SPECIAL + 11;
	
	/** jump_if_not_instance_ref_clear [pool16, u16, j16]. */
	public static final int JUMP_IF_NOT_INSTANCE_REF_CLEAR =
		ENCODING_SPECIAL + 12;
	
	/** ref_reset []. */
	public static final int REF_RESET =
		ENCODING_SPECIAL + 13;
	
	/** jump. */
	public static final int JUMP =
		ENCODING_J16 + 0;

	/** jump_if_exception. */
	public static final int JUMP_IF_EXCEPTION =
		ENCODING_J16 + 1;

	/** jump_if_return. */
	public static final int JUMP_IF_RETURN =
		ENCODING_J16 + 2;
	
	/** field_ifeq. */
	public static final int FIELD_IFEQ =
		ENCODING_J16 + 3;
	
	/** field_ifnull. */
	public static final int FIELD_IFNULL =
		FIELD_IFEQ;
	
	/** field_ifne. */
	public static final int FIELD_IFNE =
		ENCODING_J16 + 4;
	
	/** field_ifnonnull. */
	public static final int FIELD_IFNONNULL =
		FIELD_IFNE;
	
	/** field_iflt. */
	public static final int FIELD_IFLT =
		ENCODING_J16 + 5;
	
	/** field_ifle. */
	public static final int FIELD_IFLE =
		ENCODING_J16 + 6;
	
	/** field_ifgt. */
	public static final int FIELD_IFGT =
		ENCODING_J16 + 7;
	
	/** field_ifge. */
	public static final int FIELD_IFGE =
		ENCODING_J16 + 8;

	/** checkcast. */
	public static final int CHECKCAST =
		ENCODING_POOL16_U16 + 0;

	/** load_pool_value. */
	public static final int LOAD_POOL_VALUE =
		ENCODING_POOL16_U16 + 1;

	/** new. */
	public static final int NEW =
		ENCODING_POOL16_U16 + 2;

	/** sfield_load_object. */
	public static final int SFIELD_LOAD_OBJECT =
		ENCODING_POOL16_U16 + 3;

	/** sfield_load_x16. */
	public static final int SFIELD_LOAD_X16 =
		ENCODING_POOL16_U16 + 4;

	/** sfield_load_x32. */
	public static final int SFIELD_LOAD_X32 =
		ENCODING_POOL16_U16 + 5;

	/** sfield_load_x64. */
	public static final int SFIELD_LOAD_X64 =
		ENCODING_POOL16_U16 + 6;

	/** sfield_load_x8. */
	public static final int SFIELD_LOAD_X8 =
		ENCODING_POOL16_U16 + 7;

	/** sfield_store_object. */
	public static final int SFIELD_STORE_OBJECT =
		ENCODING_POOL16_U16 + 8;

	/** sfield_store_x16. */
	public static final int SFIELD_STORE_X16 =
		ENCODING_POOL16_U16 + 9;

	/** sfield_store_x32. */
	public static final int SFIELD_STORE_X32 =
		ENCODING_POOL16_U16 + 10;

	/** sfield_store_x64. */
	public static final int SFIELD_STORE_X64 =
		ENCODING_POOL16_U16 + 11;

	/** sfield_store_x8. */
	public static final int SFIELD_STORE_X8 =
		ENCODING_POOL16_U16 + 12;

	/** ifield_load_object. */
	public static final int IFIELD_LOAD_OBJECT =
		ENCODING_POOL16_U16_U16 + 0;

	/** ifield_load_x16. */
	public static final int IFIELD_LOAD_X16 =
		ENCODING_POOL16_U16_U16 + 1;

	/** ifield_load_x32. */
	public static final int IFIELD_LOAD_X32 =
		ENCODING_POOL16_U16_U16 + 2;

	/** ifield_load_x64. */
	public static final int IFIELD_LOAD_X64 =
		ENCODING_POOL16_U16_U16 + 3;

	/** ifield_load_x8. */
	public static final int IFIELD_LOAD_X8 =
		ENCODING_POOL16_U16_U16 + 4;

	/** ifield_store_object. */
	public static final int IFIELD_STORE_OBJECT =
		ENCODING_POOL16_U16_U16 + 5;

	/** ifield_store_x16. */
	public static final int IFIELD_STORE_X16 =
		ENCODING_POOL16_U16_U16 + 6;

	/** ifield_store_x32. */
	public static final int IFIELD_STORE_X32 =
		ENCODING_POOL16_U16_U16 + 7;

	/** ifield_store_x64. */
	public static final int IFIELD_STORE_X64 =
		ENCODING_POOL16_U16_U16 + 8;

	/** ifield_store_x8. */
	public static final int IFIELD_STORE_X8 =
		ENCODING_POOL16_U16_U16 + 9;

	/** instanceof. */
	public static final int INSTANCEOF =
		ENCODING_POOL16_U16_U16 + 10;

	/** new_array. */
	public static final int NEW_ARRAY =
		ENCODING_POOL16_U16_U16 + 11;

	/** new_array_const. */
	public static final int NEW_ARRAY_CONST =
		ENCODING_POOL16_U16_U16 + 12;

	/** count. */
	public static final int COUNT =
		ENCODING_U16 + 0;

	/** double_neg. */
	public static final int DOUBLE_NEG =
		ENCODING_U16 + 1;

	/** float_neg. */
	public static final int FLOAT_NEG =
		ENCODING_U16 + 2;

	/** get_and_clear_exception. */
	public static final int GET_AND_CLEAR_EXCEPTION =
		ENCODING_U16 + 3;

	/** get_x32_return_value. */
	public static final int GET_X32_RETURN_VALUE =
		ENCODING_U16 + 4;

	/** get_x64_return_value. */
	public static final int GET_X64_RETURN_VALUE =
		ENCODING_U16 + 5;

	/** int_neg. */
	public static final int INT_NEG =
		ENCODING_U16 + 6;

	/** long_neg. */
	public static final int LONG_NEG =
		ENCODING_U16 + 7;

	/** monitor_enter. */
	public static final int MONITOR_ENTER =
		ENCODING_U16 + 8;

	/** monitor_exit. */
	public static final int MONITOR_EXIT =
		ENCODING_U16 + 9;

	/** set_and_flag_exception. */
	public static final int SET_AND_FLAG_EXCEPTION =
		ENCODING_U16 + 10;

	/** set_x32_return_value. */
	public static final int SET_X32_RETURN_VALUE =
		ENCODING_U16 + 11;

	/** set_x64_return_value. */
	public static final int SET_X64_RETURN_VALUE =
		ENCODING_U16 + 12;

	/** uncount. */
	public static final int UNCOUNT =
		ENCODING_U16 + 13;
	
	/** x32_field_load [u16]. */
	public static final int X32_FIELD_LOAD =
		ENCODING_U16 + 14;
	
	/** x64_field_load [u16]. */
	public static final int X64_FIELD_LOAD =
		ENCODING_U16 + 15;
	
	/** object_field_load [u16]. */
	public static final int OBJECT_FIELD_LOAD =
		ENCODING_U16 + 16;
	
	/** x32_field_store [u16]. */
	public static final int X32_FIELD_STORE =
		ENCODING_U16 + 17;
	
	/** x64_field_store [u16]. */
	public static final int X64_FIELD_STORE =
		ENCODING_U16 + 18;
	
	/** object_field_store [u16]. */
	public static final int OBJECT_FIELD_STORE =
		ENCODING_U16 + 19;
	
	/** sign_x8 [u16]. */
	public static final int SIGN_X8 =
		ENCODING_U16 + 20;
	
	/** sign_x16 [u16]. */
	public static final int SIGN_X16 =
		ENCODING_U16 + 21;

	/** ifeq/ifnull. */
	public static final int IFEQ =
		ENCODING_U16_J16 + 0;

	/** ifeq/ifnull. */
	public static final int IFNULL =
		IFEQ;

	/** ifge. */
	public static final int IFGE =
		ENCODING_U16_J16 + 1;

	/** ifgt. */
	public static final int IFGT =
		ENCODING_U16_J16 + 2;

	/** ifle. */
	public static final int IFLE =
		ENCODING_U16_J16 + 3;

	/** iflt. */
	public static final int IFLT =
		ENCODING_U16_J16 + 4;

	/** ifne/ifnonnull. */
	public static final int IFNE =
		ENCODING_U16_J16 + 5;

	/** ifne/ifnonnull. */
	public static final int IFNONNULL =
		IFNE;

	/** ifeq_ref_clear/ifnull_ref_clear. */
	public static final int IFEQ_REF_CLEAR =
		ENCODING_U16_J16 + 6;

	/** ifeq_ref_clear/ifnull_ref_clear. */
	public static final int IFNULL_REF_CLEAR =
		IFEQ_REF_CLEAR;

	/** ifne_ref_clear/ifnonnull_ref_clear. */
	public static final int IFNE_REF_CLEAR =
		ENCODING_U16_J16 + 7;

	/** ifne_ref_clear/ifnonnull_ref_clear. */
	public static final int IFNONNULL_REF_CLEAR =
		IFNE_REF_CLEAR;

	/** iflt_ref_clear. */
	public static final int IFLT_REF_CLEAR =
		ENCODING_U16_J16 + 8;

	/** double_to_float. */
	public static final int DOUBLE_TO_FLOAT =
		ENCODING_U16_U16 + 0;

	/** double_to_int. */
	public static final int DOUBLE_TO_INT =
		ENCODING_U16_U16 + 1;

	/** double_to_long. */
	public static final int DOUBLE_TO_LONG =
		ENCODING_U16_U16 + 2;

	/** float_to_double. */
	public static final int FLOAT_TO_DOUBLE =
		ENCODING_U16_U16 + 3;

	/** float_to_int. */
	public static final int FLOAT_TO_INT =
		ENCODING_U16_U16 + 4;

	/** float_to_long. */
	public static final int FLOAT_TO_LONG =
		ENCODING_U16_U16 + 5;

	/** int_to_byte. */
	public static final int INT_TO_BYTE =
		ENCODING_U16_U16 + 6;

	/** int_to_char. */
	public static final int INT_TO_CHAR =
		ENCODING_U16_U16 + 7;

	/** int_to_double. */
	public static final int INT_TO_DOUBLE =
		ENCODING_U16_U16 + 8;

	/** int_to_float. */
	public static final int INT_TO_FLOAT =
		ENCODING_U16_U16 + 9;

	/** int_to_long. */
	public static final int INT_TO_LONG =
		ENCODING_U16_U16 + 10;

	/** int_to_short. */
	public static final int INT_TO_SHORT =
		ENCODING_U16_U16 + 11;

	/** long_to_double. */
	public static final int LONG_TO_DOUBLE =
		ENCODING_U16_U16 + 12;

	/** long_to_float. */
	public static final int LONG_TO_FLOAT =
		ENCODING_U16_U16 + 13;

	/** long_to_int. */
	public static final int LONG_TO_INT =
		ENCODING_U16_U16 + 14;

	/** object_copy. */
	public static final int OBJECT_COPY =
		ENCODING_U16_U16 + 15;

	/** x32_copy. */
	public static final int X32_COPY =
		ENCODING_U16_U16 + 16;

	/** x64_copy. */
	public static final int X64_COPY =
		ENCODING_U16_U16 + 17;
	
	/** array_length. */
	public static final int ARRAY_LENGTH =
		ENCODING_U16_U16 + 18;

	/** if_icmpeq/if_acmpeq. */
	public static final int IF_ICMPEQ =
		ENCODING_U16_U16_J16 + 0;

	/** if_icmpeq/if_acmpeq. */
	public static final int IF_ACMPEQ =
		IF_ICMPEQ;

	/** if_icmpgt. */
	public static final int IF_ICMPGT =
		ENCODING_U16_U16_J16 + 1;

	/** if_icmple. */
	public static final int IF_ICMPLE =
		ENCODING_U16_U16_J16 + 2;

	/** if_icmplt. */
	public static final int IF_ICMPLT =
		ENCODING_U16_U16_J16 + 3;

	/** if_icmpne/if_acmpne. */
	public static final int IF_ICMPNE =
		ENCODING_U16_U16_J16 + 4;

	/** if_icmpne/if_acmpne. */
	public static final int IF_ACMPNE =
		IF_ICMPNE;

	/** if_icmpge. */
	public static final int IF_ICMPGE =
		ENCODING_U16_U16_J16 + 5;

	/** if_icmpeq_ref_clear/if_acmpeq_ref_clear. */
	public static final int IF_ICMPEQ_REF_CLEAR =
		ENCODING_U16_U16_J16 + 6;

	/** if_icmpeq_ref_clear/if_acmpeq_ref_clear. */
	public static final int IF_ACMPEQ_REF_CLEAR =
		IF_ICMPEQ_REF_CLEAR;

	/** if_icmpne_ref_clear/if_acmpne_ref_clear. */
	public static final int IF_ICMPNE_REF_CLEAR =
		ENCODING_U16_U16_J16 + 7;

	/** if_icmpne_ref_clear/if_acmpne_ref_clear. */
	public static final int IF_ACMPNE_REF_CLEAR =
		IF_ICMPNE_REF_CLEAR;

	/** array_bound_check_and_ref_clear. */
	public static final int ARRAY_BOUND_CHECK_AND_REF_CLEAR =
		ENCODING_U16_U16_J16 + 8;

	/** array_store_check_and_ref_clear. */
	public static final int ARRAY_STORE_CHECK_AND_REF_CLEAR =
		ENCODING_U16_U16_J16 + 9;

	/** array_load_object. */
	public static final int ARRAY_LOAD_OBJECT =
		ENCODING_U16_U16_U16 + 0;

	/** array_load_x16. */
	public static final int ARRAY_LOAD_X16 =
		ENCODING_U16_U16_U16 + 1;

	/** array_load_x32. */
	public static final int ARRAY_LOAD_X32 =
		ENCODING_U16_U16_U16 + 2;

	/** array_load_x64. */
	public static final int ARRAY_LOAD_X64 =
		ENCODING_U16_U16_U16 + 3;

	/** array_load_x8. */
	public static final int ARRAY_LOAD_X8 =
		ENCODING_U16_U16_U16 + 4;

	/** array_store_object. */
	public static final int ARRAY_STORE_OBJECT =
		ENCODING_U16_U16_U16 + 5;

	/** array_store_x16. */
	public static final int ARRAY_STORE_X16 =
		ENCODING_U16_U16_U16 + 6;

	/** array_store_x32. */
	public static final int ARRAY_STORE_X32 =
		ENCODING_U16_U16_U16 + 7;

	/** array_store_x64. */
	public static final int ARRAY_STORE_X64 =
		ENCODING_U16_U16_U16 + 8;

	/** array_store_x8. */
	public static final int ARRAY_STORE_X8 =
		ENCODING_U16_U16_U16 + 9;

	/** dcmpg. */
	public static final int DCMPG =
		ENCODING_U16_U16_U16 + 10;

	/** dcmpl. */
	public static final int DCMPL =
		ENCODING_U16_U16_U16 + 11;

	/** double_add. */
	public static final int DOUBLE_ADD =
		ENCODING_U16_U16_U16 + 12;

	/** double_div. */
	public static final int DOUBLE_DIV =
		ENCODING_U16_U16_U16 + 13;

	/** double_mul. */
	public static final int DOUBLE_MUL =
		ENCODING_U16_U16_U16 + 14;

	/** double_rem. */
	public static final int DOUBLE_REM =
		ENCODING_U16_U16_U16 + 15;

	/** double_sub. */
	public static final int DOUBLE_SUB =
		ENCODING_U16_U16_U16 + 16;

	/** fcmpg. */
	public static final int FCMPG =
		ENCODING_U16_U16_U16 + 17;

	/** fcmpl. */
	public static final int FCMPL =
		ENCODING_U16_U16_U16 + 18;

	/** float_add. */
	public static final int FLOAT_ADD =
		ENCODING_U16_U16_U16 + 19;

	/** float_div. */
	public static final int FLOAT_DIV =
		ENCODING_U16_U16_U16 + 20;

	/** float_mul. */
	public static final int FLOAT_MUL =
		ENCODING_U16_U16_U16 + 21;

	/** float_rem. */
	public static final int FLOAT_REM =
		ENCODING_U16_U16_U16 + 22;

	/** float_sub. */
	public static final int FLOAT_SUB =
		ENCODING_U16_U16_U16 + 23;

	/** int_add. */
	public static final int INT_ADD =
		ENCODING_U16_U16_U16 + 24;

	/** int_and. */
	public static final int INT_AND =
		ENCODING_U16_U16_U16 + 25;

	/** int_div. */
	public static final int INT_DIV =
		ENCODING_U16_U16_U16 + 26;

	/** int_mul. */
	public static final int INT_MUL =
		ENCODING_U16_U16_U16 + 27;

	/** int_or. */
	public static final int INT_OR =
		ENCODING_U16_U16_U16 + 28;

	/** int_rem. */
	public static final int INT_REM =
		ENCODING_U16_U16_U16 + 29;

	/** int_shl. */
	public static final int INT_SHL =
		ENCODING_U16_U16_U16 + 30;

	/** int_shr. */
	public static final int INT_SHR =
		ENCODING_U16_U16_U16 + 31;

	/** int_sub. */
	public static final int INT_SUB =
		ENCODING_U16_U16_U16 + 32;

	/** int_ushr. */
	public static final int INT_USHR =
		ENCODING_U16_U16_U16 + 33;

	/** int_xor. */
	public static final int INT_XOR =
		ENCODING_U16_U16_U16 + 34;

	/** lcmp. */
	public static final int LCMP =
		ENCODING_U16_U16_U16 + 35;

	/** long_add. */
	public static final int LONG_ADD =
		ENCODING_U16_U16_U16 + 36;

	/** long_and. */
	public static final int LONG_AND =
		ENCODING_U16_U16_U16 + 37;

	/** long_div. */
	public static final int LONG_DIV =
		ENCODING_U16_U16_U16 + 38;

	/** long_mul. */
	public static final int LONG_MUL =
		ENCODING_U16_U16_U16 + 39;

	/** long_or. */
	public static final int LONG_OR =
		ENCODING_U16_U16_U16 + 40;

	/** long_rem. */
	public static final int LONG_REM =
		ENCODING_U16_U16_U16 + 41;

	/** long_shl. */
	public static final int LONG_SHL =
		ENCODING_U16_U16_U16 + 42;

	/** long_shr. */
	public static final int LONG_SHR =
		ENCODING_U16_U16_U16 + 43;

	/** long_sub. */
	public static final int LONG_SUB =
		ENCODING_U16_U16_U16 + 44;

	/** long_ushr. */
	public static final int LONG_USHR =
		ENCODING_U16_U16_U16 + 45;

	/** long_xor. */
	public static final int LONG_XOR =
		ENCODING_U16_U16_U16 + 46;
}

