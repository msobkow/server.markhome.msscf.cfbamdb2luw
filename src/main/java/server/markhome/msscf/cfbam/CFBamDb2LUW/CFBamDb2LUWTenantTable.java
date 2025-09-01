// Description: Java 11 DB/2 LUW Jdbc DbIO implementation for Tenant.

/*
 *	server.markhome.msscf.CFBam
 *
 *	Copyright (c) 2020-2025 Mark Stephen Sobkow
 *	
 *
 *	Manufactured by MSS Code Factory 2.13
 */

package server.markhome.msscf.cfbam.CFBamDb2LUW;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.msscf.msscf.cflib.CFLib.*;
import server.markhome.msscf.cfsec.CFSec.*;
import server.markhome.msscf.cfint.CFInt.*;
import server.markhome.msscf.cfbam.CFBam.*;
import server.markhome.msscf.cfsec.CFSecObj.*;
import server.markhome.msscf.cfint.CFIntObj.*;
import server.markhome.msscf.cfbam.CFBamObj.*;

/*
 *	CFBamDb2LUWTenantTable DB/2 LUW Jdbc DbIO implementation
 *	for Tenant.
 */
public class CFBamDb2LUWTenantTable
	implements ICFBamTenantTable
{
	private CFBamDb2LUWSchema schema;
	protected PreparedStatement stmtReadBuffByPKey = null;
	protected PreparedStatement stmtLockBuffByPKey = null;
	protected PreparedStatement stmtCreateByPKey = null;
	protected PreparedStatement stmtUpdateByPKey = null;
	protected PreparedStatement stmtDeleteByPKey = null;
	protected PreparedStatement stmtReadAllBuff = null;
	protected PreparedStatement stmtPageAllBuff = null;
	protected PreparedStatement stmtReadBuffByIdIdx = null;
	protected PreparedStatement stmtReadBuffByClusterIdx = null;
	protected PreparedStatement stmtReadBuffByUNameIdx = null;
	protected PreparedStatement stmtPageBuffByClusterIdx = null;
	protected PreparedStatement stmtDeleteByIdIdx = null;
	protected PreparedStatement stmtDeleteByClusterIdx = null;
	protected PreparedStatement stmtDeleteByUNameIdx = null;
	protected PreparedStatement stmtSelectNextTSecGroupIdGen = null;
	protected PreparedStatement stmtSelectNextTSecGrpIncIdGen = null;
	protected PreparedStatement stmtSelectNextTSecGrpMembIdGen = null;
	protected PreparedStatement stmtSelectNextMajorVersionIdGen = null;
	protected PreparedStatement stmtSelectNextMinorVersionIdGen = null;
	protected PreparedStatement stmtSelectNextSubProjectIdGen = null;
	protected PreparedStatement stmtSelectNextTldIdGen = null;
	protected PreparedStatement stmtSelectNextTopDomainIdGen = null;
	protected PreparedStatement stmtSelectNextTopProjectIdGen = null;
	protected PreparedStatement stmtSelectNextChainIdGen = null;
	protected PreparedStatement stmtSelectNextEnumTagIdGen = null;
	protected PreparedStatement stmtSelectNextIndexColIdGen = null;
	protected PreparedStatement stmtSelectNextParamIdGen = null;
	protected PreparedStatement stmtSelectNextRelationColIdGen = null;
	protected PreparedStatement stmtSelectNextScopeIdGen = null;
	protected PreparedStatement stmtSelectNextValueIdGen = null;

	public CFBamDb2LUWTenantTable( CFBamDb2LUWSchema argSchema ) {
		schema = argSchema;
	}

	public int nextTSecGroupIdGen( CFSecAuthorization Authorization,
		CFSecTenantPKey PKey )
	{
		final String S_ProcName = "nextTSecGroupIdGen";
		final String sqlSelectNext =
				"call sf_next_tsecgroupidgen("
			+		"?" + " )";

		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet rsSelect = null;
		try {
			Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();

			if( stmtSelectNextTSecGroupIdGen == null ) {
				stmtSelectNextTSecGroupIdGen = cnx.prepareStatement( sqlSelectNext );
			}
			int nextId;
			int argIdx = 1;
			stmtSelectNextTSecGroupIdGen.setLong( argIdx++, Id );
			rsSelect = stmtSelectNextTSecGroupIdGen.executeQuery();
			if( rsSelect.next() ) {
				nextId = rsSelect.getInt( 1 );
				if( rsSelect.wasNull() ) {
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"NextTSecGroupIdGen cannot be null!" );
				}
				if( rsSelect.next() ) {
					rsSelect.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record select response, " + rsSelect.getRow() + " rows selected" );
				}
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 result row to be returned by sf_next_tsecgroupidgen(), not 0" );
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( rsSelect != null ) {
				try {
					rsSelect.close();
				}
				catch( SQLException e ) {
				}
				rsSelect = null;
			}
		}
	}

	public int nextTSecGroupIdGen( CFSecAuthorization Authorization,
		long argId )
	{
		CFSecTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		int retval = nextTSecGroupIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextTSecGrpIncIdGen( CFSecAuthorization Authorization,
		CFSecTenantPKey PKey )
	{
		final String S_ProcName = "nextTSecGrpIncIdGen";
		final String sqlSelectNext =
				"call sf_next_tsecgrpincidgen("
			+		"?" + " )";

		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet rsSelect = null;
		try {
			Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();

			if( stmtSelectNextTSecGrpIncIdGen == null ) {
				stmtSelectNextTSecGrpIncIdGen = cnx.prepareStatement( sqlSelectNext );
			}
			long nextId;
			int argIdx = 1;
			stmtSelectNextTSecGrpIncIdGen.setLong( argIdx++, Id );
			rsSelect = stmtSelectNextTSecGrpIncIdGen.executeQuery();
			if( rsSelect.next() ) {
				nextId = rsSelect.getLong( 1 );
				if( rsSelect.wasNull() ) {
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"NextTSecGrpIncIdGen cannot be null!" );
				}
				if( rsSelect.next() ) {
					rsSelect.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record select response, " + rsSelect.getRow() + " rows selected" );
				}
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 result row to be returned by sf_next_tsecgrpincidgen(), not 0" );
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( rsSelect != null ) {
				try {
					rsSelect.close();
				}
				catch( SQLException e ) {
				}
				rsSelect = null;
			}
		}
	}

	public long nextTSecGrpIncIdGen( CFSecAuthorization Authorization,
		long argId )
	{
		CFSecTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextTSecGrpIncIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextTSecGrpMembIdGen( CFSecAuthorization Authorization,
		CFSecTenantPKey PKey )
	{
		final String S_ProcName = "nextTSecGrpMembIdGen";
		final String sqlSelectNext =
				"call sf_next_tsecgrpmembidgen("
			+		"?" + " )";

		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet rsSelect = null;
		try {
			Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();

			if( stmtSelectNextTSecGrpMembIdGen == null ) {
				stmtSelectNextTSecGrpMembIdGen = cnx.prepareStatement( sqlSelectNext );
			}
			long nextId;
			int argIdx = 1;
			stmtSelectNextTSecGrpMembIdGen.setLong( argIdx++, Id );
			rsSelect = stmtSelectNextTSecGrpMembIdGen.executeQuery();
			if( rsSelect.next() ) {
				nextId = rsSelect.getLong( 1 );
				if( rsSelect.wasNull() ) {
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"NextTSecGrpMembIdGen cannot be null!" );
				}
				if( rsSelect.next() ) {
					rsSelect.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record select response, " + rsSelect.getRow() + " rows selected" );
				}
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 result row to be returned by sf_next_tsecgrpmembidgen(), not 0" );
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( rsSelect != null ) {
				try {
					rsSelect.close();
				}
				catch( SQLException e ) {
				}
				rsSelect = null;
			}
		}
	}

	public long nextTSecGrpMembIdGen( CFSecAuthorization Authorization,
		long argId )
	{
		CFSecTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextTSecGrpMembIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextMajorVersionIdGen( CFSecAuthorization Authorization,
		CFSecTenantPKey PKey )
	{
		final String S_ProcName = "nextMajorVersionIdGen";
		final String sqlSelectNext =
				"call sf_next_majorversionidgen("
			+		"?" + " )";

		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet rsSelect = null;
		try {
			Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();

			if( stmtSelectNextMajorVersionIdGen == null ) {
				stmtSelectNextMajorVersionIdGen = cnx.prepareStatement( sqlSelectNext );
			}
			long nextId;
			int argIdx = 1;
			stmtSelectNextMajorVersionIdGen.setLong( argIdx++, Id );
			rsSelect = stmtSelectNextMajorVersionIdGen.executeQuery();
			if( rsSelect.next() ) {
				nextId = rsSelect.getLong( 1 );
				if( rsSelect.wasNull() ) {
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"NextMajorVersionIdGen cannot be null!" );
				}
				if( rsSelect.next() ) {
					rsSelect.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record select response, " + rsSelect.getRow() + " rows selected" );
				}
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 result row to be returned by sf_next_majorversionidgen(), not 0" );
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( rsSelect != null ) {
				try {
					rsSelect.close();
				}
				catch( SQLException e ) {
				}
				rsSelect = null;
			}
		}
	}

	public long nextMajorVersionIdGen( CFSecAuthorization Authorization,
		long argId )
	{
		CFSecTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextMajorVersionIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextMinorVersionIdGen( CFSecAuthorization Authorization,
		CFSecTenantPKey PKey )
	{
		final String S_ProcName = "nextMinorVersionIdGen";
		final String sqlSelectNext =
				"call sf_next_minorversionidgen("
			+		"?" + " )";

		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet rsSelect = null;
		try {
			Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();

			if( stmtSelectNextMinorVersionIdGen == null ) {
				stmtSelectNextMinorVersionIdGen = cnx.prepareStatement( sqlSelectNext );
			}
			long nextId;
			int argIdx = 1;
			stmtSelectNextMinorVersionIdGen.setLong( argIdx++, Id );
			rsSelect = stmtSelectNextMinorVersionIdGen.executeQuery();
			if( rsSelect.next() ) {
				nextId = rsSelect.getLong( 1 );
				if( rsSelect.wasNull() ) {
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"NextMinorVersionIdGen cannot be null!" );
				}
				if( rsSelect.next() ) {
					rsSelect.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record select response, " + rsSelect.getRow() + " rows selected" );
				}
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 result row to be returned by sf_next_minorversionidgen(), not 0" );
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( rsSelect != null ) {
				try {
					rsSelect.close();
				}
				catch( SQLException e ) {
				}
				rsSelect = null;
			}
		}
	}

	public long nextMinorVersionIdGen( CFSecAuthorization Authorization,
		long argId )
	{
		CFSecTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextMinorVersionIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextSubProjectIdGen( CFSecAuthorization Authorization,
		CFSecTenantPKey PKey )
	{
		final String S_ProcName = "nextSubProjectIdGen";
		final String sqlSelectNext =
				"call sf_next_subprojectidgen("
			+		"?" + " )";

		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet rsSelect = null;
		try {
			Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();

			if( stmtSelectNextSubProjectIdGen == null ) {
				stmtSelectNextSubProjectIdGen = cnx.prepareStatement( sqlSelectNext );
			}
			long nextId;
			int argIdx = 1;
			stmtSelectNextSubProjectIdGen.setLong( argIdx++, Id );
			rsSelect = stmtSelectNextSubProjectIdGen.executeQuery();
			if( rsSelect.next() ) {
				nextId = rsSelect.getLong( 1 );
				if( rsSelect.wasNull() ) {
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"NextSubProjectIdGen cannot be null!" );
				}
				if( rsSelect.next() ) {
					rsSelect.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record select response, " + rsSelect.getRow() + " rows selected" );
				}
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 result row to be returned by sf_next_subprojectidgen(), not 0" );
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( rsSelect != null ) {
				try {
					rsSelect.close();
				}
				catch( SQLException e ) {
				}
				rsSelect = null;
			}
		}
	}

	public long nextSubProjectIdGen( CFSecAuthorization Authorization,
		long argId )
	{
		CFSecTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextSubProjectIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextTldIdGen( CFSecAuthorization Authorization,
		CFSecTenantPKey PKey )
	{
		final String S_ProcName = "nextTldIdGen";
		final String sqlSelectNext =
				"call sf_next_tldidgen("
			+		"?" + " )";

		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet rsSelect = null;
		try {
			Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();

			if( stmtSelectNextTldIdGen == null ) {
				stmtSelectNextTldIdGen = cnx.prepareStatement( sqlSelectNext );
			}
			long nextId;
			int argIdx = 1;
			stmtSelectNextTldIdGen.setLong( argIdx++, Id );
			rsSelect = stmtSelectNextTldIdGen.executeQuery();
			if( rsSelect.next() ) {
				nextId = rsSelect.getLong( 1 );
				if( rsSelect.wasNull() ) {
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"NextTldIdGen cannot be null!" );
				}
				if( rsSelect.next() ) {
					rsSelect.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record select response, " + rsSelect.getRow() + " rows selected" );
				}
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 result row to be returned by sf_next_tldidgen(), not 0" );
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( rsSelect != null ) {
				try {
					rsSelect.close();
				}
				catch( SQLException e ) {
				}
				rsSelect = null;
			}
		}
	}

	public long nextTldIdGen( CFSecAuthorization Authorization,
		long argId )
	{
		CFSecTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextTldIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextTopDomainIdGen( CFSecAuthorization Authorization,
		CFSecTenantPKey PKey )
	{
		final String S_ProcName = "nextTopDomainIdGen";
		final String sqlSelectNext =
				"call sf_next_topdomainidgen("
			+		"?" + " )";

		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet rsSelect = null;
		try {
			Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();

			if( stmtSelectNextTopDomainIdGen == null ) {
				stmtSelectNextTopDomainIdGen = cnx.prepareStatement( sqlSelectNext );
			}
			long nextId;
			int argIdx = 1;
			stmtSelectNextTopDomainIdGen.setLong( argIdx++, Id );
			rsSelect = stmtSelectNextTopDomainIdGen.executeQuery();
			if( rsSelect.next() ) {
				nextId = rsSelect.getLong( 1 );
				if( rsSelect.wasNull() ) {
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"NextTopDomainIdGen cannot be null!" );
				}
				if( rsSelect.next() ) {
					rsSelect.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record select response, " + rsSelect.getRow() + " rows selected" );
				}
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 result row to be returned by sf_next_topdomainidgen(), not 0" );
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( rsSelect != null ) {
				try {
					rsSelect.close();
				}
				catch( SQLException e ) {
				}
				rsSelect = null;
			}
		}
	}

	public long nextTopDomainIdGen( CFSecAuthorization Authorization,
		long argId )
	{
		CFSecTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextTopDomainIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextTopProjectIdGen( CFSecAuthorization Authorization,
		CFSecTenantPKey PKey )
	{
		final String S_ProcName = "nextTopProjectIdGen";
		final String sqlSelectNext =
				"call sf_next_topprojectidgen("
			+		"?" + " )";

		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet rsSelect = null;
		try {
			Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();

			if( stmtSelectNextTopProjectIdGen == null ) {
				stmtSelectNextTopProjectIdGen = cnx.prepareStatement( sqlSelectNext );
			}
			long nextId;
			int argIdx = 1;
			stmtSelectNextTopProjectIdGen.setLong( argIdx++, Id );
			rsSelect = stmtSelectNextTopProjectIdGen.executeQuery();
			if( rsSelect.next() ) {
				nextId = rsSelect.getLong( 1 );
				if( rsSelect.wasNull() ) {
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"NextTopProjectIdGen cannot be null!" );
				}
				if( rsSelect.next() ) {
					rsSelect.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record select response, " + rsSelect.getRow() + " rows selected" );
				}
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 result row to be returned by sf_next_topprojectidgen(), not 0" );
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( rsSelect != null ) {
				try {
					rsSelect.close();
				}
				catch( SQLException e ) {
				}
				rsSelect = null;
			}
		}
	}

	public long nextTopProjectIdGen( CFSecAuthorization Authorization,
		long argId )
	{
		CFSecTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextTopProjectIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextChainIdGen( CFSecAuthorization Authorization,
		CFSecTenantPKey PKey )
	{
		final String S_ProcName = "nextChainIdGen";
		final String sqlSelectNext =
				"call sf_next_chainidgen("
			+		"?" + " )";

		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet rsSelect = null;
		try {
			Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();

			if( stmtSelectNextChainIdGen == null ) {
				stmtSelectNextChainIdGen = cnx.prepareStatement( sqlSelectNext );
			}
			long nextId;
			int argIdx = 1;
			stmtSelectNextChainIdGen.setLong( argIdx++, Id );
			rsSelect = stmtSelectNextChainIdGen.executeQuery();
			if( rsSelect.next() ) {
				nextId = rsSelect.getLong( 1 );
				if( rsSelect.wasNull() ) {
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"NextChainIdGen cannot be null!" );
				}
				if( rsSelect.next() ) {
					rsSelect.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record select response, " + rsSelect.getRow() + " rows selected" );
				}
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 result row to be returned by sf_next_chainidgen(), not 0" );
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( rsSelect != null ) {
				try {
					rsSelect.close();
				}
				catch( SQLException e ) {
				}
				rsSelect = null;
			}
		}
	}

	public long nextChainIdGen( CFSecAuthorization Authorization,
		long argId )
	{
		CFSecTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextChainIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextEnumTagIdGen( CFSecAuthorization Authorization,
		CFSecTenantPKey PKey )
	{
		final String S_ProcName = "nextEnumTagIdGen";
		final String sqlSelectNext =
				"call sf_next_enumtagidgen("
			+		"?" + " )";

		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet rsSelect = null;
		try {
			Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();

			if( stmtSelectNextEnumTagIdGen == null ) {
				stmtSelectNextEnumTagIdGen = cnx.prepareStatement( sqlSelectNext );
			}
			long nextId;
			int argIdx = 1;
			stmtSelectNextEnumTagIdGen.setLong( argIdx++, Id );
			rsSelect = stmtSelectNextEnumTagIdGen.executeQuery();
			if( rsSelect.next() ) {
				nextId = rsSelect.getLong( 1 );
				if( rsSelect.wasNull() ) {
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"NextEnumTagIdGen cannot be null!" );
				}
				if( rsSelect.next() ) {
					rsSelect.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record select response, " + rsSelect.getRow() + " rows selected" );
				}
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 result row to be returned by sf_next_enumtagidgen(), not 0" );
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( rsSelect != null ) {
				try {
					rsSelect.close();
				}
				catch( SQLException e ) {
				}
				rsSelect = null;
			}
		}
	}

	public long nextEnumTagIdGen( CFSecAuthorization Authorization,
		long argId )
	{
		CFSecTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextEnumTagIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextIndexColIdGen( CFSecAuthorization Authorization,
		CFSecTenantPKey PKey )
	{
		final String S_ProcName = "nextIndexColIdGen";
		final String sqlSelectNext =
				"call sf_next_indexcolidgen("
			+		"?" + " )";

		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet rsSelect = null;
		try {
			Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();

			if( stmtSelectNextIndexColIdGen == null ) {
				stmtSelectNextIndexColIdGen = cnx.prepareStatement( sqlSelectNext );
			}
			long nextId;
			int argIdx = 1;
			stmtSelectNextIndexColIdGen.setLong( argIdx++, Id );
			rsSelect = stmtSelectNextIndexColIdGen.executeQuery();
			if( rsSelect.next() ) {
				nextId = rsSelect.getLong( 1 );
				if( rsSelect.wasNull() ) {
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"NextIndexColIdGen cannot be null!" );
				}
				if( rsSelect.next() ) {
					rsSelect.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record select response, " + rsSelect.getRow() + " rows selected" );
				}
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 result row to be returned by sf_next_indexcolidgen(), not 0" );
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( rsSelect != null ) {
				try {
					rsSelect.close();
				}
				catch( SQLException e ) {
				}
				rsSelect = null;
			}
		}
	}

	public long nextIndexColIdGen( CFSecAuthorization Authorization,
		long argId )
	{
		CFSecTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextIndexColIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextParamIdGen( CFSecAuthorization Authorization,
		CFSecTenantPKey PKey )
	{
		final String S_ProcName = "nextParamIdGen";
		final String sqlSelectNext =
				"call sf_next_paramidgen("
			+		"?" + " )";

		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet rsSelect = null;
		try {
			Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();

			if( stmtSelectNextParamIdGen == null ) {
				stmtSelectNextParamIdGen = cnx.prepareStatement( sqlSelectNext );
			}
			long nextId;
			int argIdx = 1;
			stmtSelectNextParamIdGen.setLong( argIdx++, Id );
			rsSelect = stmtSelectNextParamIdGen.executeQuery();
			if( rsSelect.next() ) {
				nextId = rsSelect.getLong( 1 );
				if( rsSelect.wasNull() ) {
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"NextParamIdGen cannot be null!" );
				}
				if( rsSelect.next() ) {
					rsSelect.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record select response, " + rsSelect.getRow() + " rows selected" );
				}
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 result row to be returned by sf_next_paramidgen(), not 0" );
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( rsSelect != null ) {
				try {
					rsSelect.close();
				}
				catch( SQLException e ) {
				}
				rsSelect = null;
			}
		}
	}

	public long nextParamIdGen( CFSecAuthorization Authorization,
		long argId )
	{
		CFSecTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextParamIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextRelationColIdGen( CFSecAuthorization Authorization,
		CFSecTenantPKey PKey )
	{
		final String S_ProcName = "nextRelationColIdGen";
		final String sqlSelectNext =
				"call sf_next_relationcolidgen("
			+		"?" + " )";

		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet rsSelect = null;
		try {
			Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();

			if( stmtSelectNextRelationColIdGen == null ) {
				stmtSelectNextRelationColIdGen = cnx.prepareStatement( sqlSelectNext );
			}
			long nextId;
			int argIdx = 1;
			stmtSelectNextRelationColIdGen.setLong( argIdx++, Id );
			rsSelect = stmtSelectNextRelationColIdGen.executeQuery();
			if( rsSelect.next() ) {
				nextId = rsSelect.getLong( 1 );
				if( rsSelect.wasNull() ) {
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"NextRelationColIdGen cannot be null!" );
				}
				if( rsSelect.next() ) {
					rsSelect.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record select response, " + rsSelect.getRow() + " rows selected" );
				}
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 result row to be returned by sf_next_relationcolidgen(), not 0" );
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( rsSelect != null ) {
				try {
					rsSelect.close();
				}
				catch( SQLException e ) {
				}
				rsSelect = null;
			}
		}
	}

	public long nextRelationColIdGen( CFSecAuthorization Authorization,
		long argId )
	{
		CFSecTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextRelationColIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextScopeIdGen( CFSecAuthorization Authorization,
		CFSecTenantPKey PKey )
	{
		final String S_ProcName = "nextScopeIdGen";
		final String sqlSelectNext =
				"call sf_next_scopeidgen("
			+		"?" + " )";

		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet rsSelect = null;
		try {
			Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();

			if( stmtSelectNextScopeIdGen == null ) {
				stmtSelectNextScopeIdGen = cnx.prepareStatement( sqlSelectNext );
			}
			long nextId;
			int argIdx = 1;
			stmtSelectNextScopeIdGen.setLong( argIdx++, Id );
			rsSelect = stmtSelectNextScopeIdGen.executeQuery();
			if( rsSelect.next() ) {
				nextId = rsSelect.getLong( 1 );
				if( rsSelect.wasNull() ) {
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"NextScopeIdGen cannot be null!" );
				}
				if( rsSelect.next() ) {
					rsSelect.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record select response, " + rsSelect.getRow() + " rows selected" );
				}
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 result row to be returned by sf_next_scopeidgen(), not 0" );
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( rsSelect != null ) {
				try {
					rsSelect.close();
				}
				catch( SQLException e ) {
				}
				rsSelect = null;
			}
		}
	}

	public long nextScopeIdGen( CFSecAuthorization Authorization,
		long argId )
	{
		CFSecTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextScopeIdGen( Authorization, pkey );
		return( retval );
	}

	public long nextValueIdGen( CFSecAuthorization Authorization,
		CFSecTenantPKey PKey )
	{
		final String S_ProcName = "nextValueIdGen";
		final String sqlSelectNext =
				"call sf_next_valueidgen("
			+		"?" + " )";

		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet rsSelect = null;
		try {
			Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();

			if( stmtSelectNextValueIdGen == null ) {
				stmtSelectNextValueIdGen = cnx.prepareStatement( sqlSelectNext );
			}
			long nextId;
			int argIdx = 1;
			stmtSelectNextValueIdGen.setLong( argIdx++, Id );
			rsSelect = stmtSelectNextValueIdGen.executeQuery();
			if( rsSelect.next() ) {
				nextId = rsSelect.getLong( 1 );
				if( rsSelect.wasNull() ) {
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"NextValueIdGen cannot be null!" );
				}
				if( rsSelect.next() ) {
					rsSelect.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record select response, " + rsSelect.getRow() + " rows selected" );
				}
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 result row to be returned by sf_next_valueidgen(), not 0" );
			}
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( rsSelect != null ) {
				try {
					rsSelect.close();
				}
				catch( SQLException e ) {
				}
				rsSelect = null;
			}
		}
	}

	public long nextValueIdGen( CFSecAuthorization Authorization,
		long argId )
	{
		CFSecTenantPKey pkey = schema.getFactoryTenant().newPKey();
		pkey.setRequiredId( argId );
		long retval = nextValueIdGen( Authorization, pkey );
		return( retval );
	}

	public void createTenant( CFSecAuthorization Authorization,
		CFSecTenantBuff Buff )
	{
		final String S_ProcName = "createTenant";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			long ClusterId = Buff.getRequiredClusterId();
			String TenantName = Buff.getRequiredTenantName();
			Connection cnx = schema.getCnx();
			final String sql =
				"CALL sp_create_tenant( ?, ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " )";
			if( stmtCreateByPKey == null ) {
				stmtCreateByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtCreateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtCreateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtCreateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtCreateByPKey.setString( argIdx++, "a015" );
			stmtCreateByPKey.setLong( argIdx++, ClusterId );
			stmtCreateByPKey.setString( argIdx++, TenantName );
			resultSet = stmtCreateByPKey.executeQuery();
			if( resultSet.next() ) {
				CFSecTenantBuff createdBuff = unpackTenantResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					resultSet.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				Buff.setRequiredClusterId( createdBuff.getRequiredClusterId() );
				Buff.setRequiredId( createdBuff.getRequiredId() );
				Buff.setRequiredTenantName( createdBuff.getRequiredTenantName() );
				Buff.setRequiredRevision( createdBuff.getRequiredRevision() );
				Buff.setCreatedByUserId( createdBuff.getCreatedByUserId() );
				Buff.setCreatedAt( createdBuff.getCreatedAt() );
				Buff.setUpdatedByUserId( createdBuff.getUpdatedByUserId() );
				Buff.setUpdatedAt( createdBuff.getUpdatedAt() );
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"Expected a single-record response, " + resultSet.getRow() + " rows selected" );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	protected static String S_sqlSelectTenantDistinctClassCode = null;

	public String getSqlSelectTenantDistinctClassCode() {
		if( S_sqlSelectTenantDistinctClassCode == null ) {
			S_sqlSelectTenantDistinctClassCode =
					"SELECT "
				+		"DISTINCT a015.ClassCode "
				+	"FROM " + schema.getLowerDbSchemaName() + ".tenant AS a015 ";
		}
		return( S_sqlSelectTenantDistinctClassCode );
	}

	protected static String S_sqlSelectTenantBuff = null;

	public String getSqlSelectTenantBuff() {
		if( S_sqlSelectTenantBuff == null ) {
			S_sqlSelectTenantBuff =
					"SELECT "
				+		"a015.Id, "
				+		"a015.ClusterId, "
				+		"a015.TenantName, "
				+		"a015.Revision "
				+	"FROM " + schema.getLowerDbSchemaName() + ".tenant AS a015 ";
		}
		return( S_sqlSelectTenantBuff );
	}

	protected CFSecTenantBuff unpackTenantResultSetToBuff( ResultSet resultSet )
	throws SQLException
	{
		final String S_ProcName = "unpackTenantResultSetToBuff";
		int idxcol = 1;
		CFSecTenantBuff buff = schema.getFactoryTenant().newBuff();
		{
			String colString = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setCreatedByUserId( null );
			}
			else if( ( colString == null ) || ( colString.length() <= 0 ) ) {
				buff.setCreatedByUserId( null );
			}
			else {
				buff.setCreatedByUserId( UUID.fromString( colString ) );
			}
			idxcol ++;

			colString = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setCreatedAt( null );
			}
			else if( ( colString == null ) || ( colString.length() <= 0 ) ) {
				buff.setCreatedAt( null );
			}
			else {
				buff.setCreatedAt( CFBamDb2LUWSchema.convertTimestampString( colString ) );
			}
			idxcol++;
			colString = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setUpdatedByUserId( null );
			}
			else if( ( colString == null ) || ( colString.length() <= 0 ) ) {
				buff.setUpdatedByUserId( null );
			}
			else {
				buff.setUpdatedByUserId( UUID.fromString( colString ) );
			}
			idxcol ++;

			colString = resultSet.getString( idxcol );
			if( resultSet.wasNull() ) {
				buff.setUpdatedAt( null );
			}
			else if( ( colString == null ) || ( colString.length() <= 0 ) ) {
				buff.setUpdatedAt( null );
			}
			else {
				buff.setUpdatedAt( CFBamDb2LUWSchema.convertTimestampString( colString ) );
			}
			idxcol++;
		}
		buff.setRequiredClusterId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredId( resultSet.getLong( idxcol ) );
		idxcol++;
		buff.setRequiredTenantName( resultSet.getString( idxcol ) );
		idxcol++;

		buff.setRequiredRevision( resultSet.getInt( idxcol ) );
		return( buff );
	}

	public CFSecTenantBuff readDerived( CFSecAuthorization Authorization,
		CFSecTenantPKey PKey )
	{
		final String S_ProcName = "readDerived";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFSecTenantBuff buff;
		buff = readBuff( Authorization, PKey );
		return( buff );
	}

	public CFSecTenantBuff lockDerived( CFSecAuthorization Authorization,
		CFSecTenantPKey PKey )
	{
		final String S_ProcName = "lockDerived";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFSecTenantBuff buff;
		buff = lockBuff( Authorization, PKey );
		return( buff );
	}

	public CFSecTenantBuff[] readAllDerived( CFSecAuthorization Authorization ) {
		final String S_ProcName = "readAllDerived";
		CFSecTenantBuff[] buffArray;
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buffArray = readAllBuff( Authorization );
		return( buffArray );
	}

	public CFSecTenantBuff readDerivedByIdIdx( CFSecAuthorization Authorization,
		long Id )
	{
		final String S_ProcName = "CFBamDb2LUWTenantTable.readDerivedByIdIdx() ";
		CFSecTenantBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByIdIdx( Authorization,
				Id );
		return( buff );
	}

	public CFSecTenantBuff[] readDerivedByClusterIdx( CFSecAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "readDerivedByClusterIdx";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		CFSecTenantBuff[] buffList = readBuffByClusterIdx( Authorization,
				ClusterId );
		return( buffList );

	}

	public CFSecTenantBuff readDerivedByUNameIdx( CFSecAuthorization Authorization,
		long ClusterId,
		String TenantName )
	{
		final String S_ProcName = "CFBamDb2LUWTenantTable.readDerivedByUNameIdx() ";
		CFSecTenantBuff buff;
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		buff = readBuffByUNameIdx( Authorization,
				ClusterId,
				TenantName );
		return( buff );
	}

	public CFSecTenantBuff readBuff( CFSecAuthorization Authorization,
		CFSecTenantPKey PKey )
	{
		final String S_ProcName = "readBuff";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();
			final String sql = "CALL sp_read_tenant( ?, ?, ?, ?, ?" + ", "
				+		"?" + " )";
			if( stmtReadBuffByPKey == null ) {
				stmtReadBuffByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByPKey.setLong( argIdx++, Id );
			resultSet = stmtReadBuffByPKey.executeQuery();
			if( resultSet.next() ) {
				CFSecTenantBuff buff = unpackTenantResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					resultSet.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				return( buff );
			}
			else {
				return( null );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public CFSecTenantBuff lockBuff( CFSecAuthorization Authorization,
		CFSecTenantPKey PKey )
	{
		final String S_ProcName = "lockBuff";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			long Id = PKey.getRequiredId();
			final String sql = "CALL sp_lock_tenant( ?, ?, ?, ?, ?" + ", "
				+		"?" + " )";
			if( stmtLockBuffByPKey == null ) {
				stmtLockBuffByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtLockBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtLockBuffByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtLockBuffByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtLockBuffByPKey.setLong( argIdx++, Id );
			resultSet = stmtLockBuffByPKey.executeQuery();
			if( resultSet.next() ) {
				CFSecTenantBuff buff = unpackTenantResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					resultSet.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				return( buff );
			}
			else {
				return( null );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public CFSecTenantBuff[] readAllBuff( CFSecAuthorization Authorization ) {
		final String S_ProcName = "readAllBuff";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			final String sql = "CALL sp_read_tenant_all( ?, ?, ?, ?, ? )";
			if( stmtReadAllBuff == null ) {
				stmtReadAllBuff = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadAllBuff.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadAllBuff.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadAllBuff.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadAllBuff.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadAllBuff.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			resultSet = stmtReadAllBuff.executeQuery();
			List<CFSecTenantBuff> buffList = new LinkedList<CFSecTenantBuff>();
			while( resultSet.next() ) {
				CFSecTenantBuff buff = unpackTenantResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFSecTenantBuff[] retBuff = new CFSecTenantBuff[ buffList.size() ];
			Iterator<CFSecTenantBuff> iter = buffList.iterator();
			while( iter.hasNext() ) {
				retBuff[idx++] = iter.next();
			}
			return( retBuff );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	/**
	 *	Read a page of all the specific Tenant buffer instances.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@return All the specific Tenant instances in the database accessible for the Authorization.
	 */
	public CFSecTenantBuff[] pageAllBuff( CFSecAuthorization Authorization,
		Long priorId )
	{
		final String S_ProcName = "pageAllBuff";
		if( ! schema.isTransactionOpen() ) {
			throw new CFLibUsageException( getClass(),
				S_ProcName,
				"Transaction not open" );
		}
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			final String sql = "CALL sp_page_tenant_all( ?, ?, ?, ?, ?, ? )";
			if( stmtPageAllBuff == null ) {
				stmtPageAllBuff = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtPageAllBuff.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtPageAllBuff.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtPageAllBuff.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtPageAllBuff.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtPageAllBuff.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			if( priorId != null ) {
				stmtPageAllBuff.setLong( argIdx++, priorId.longValue() );
			}
			else {
				stmtPageAllBuff.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			resultSet = stmtPageAllBuff.executeQuery();
			List<CFSecTenantBuff> buffList = new LinkedList<CFSecTenantBuff>();
			while( resultSet.next() ) {
				CFSecTenantBuff buff = unpackTenantResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFSecTenantBuff[] retBuff = new CFSecTenantBuff[ buffList.size() ];
			Iterator<CFSecTenantBuff> iter = buffList.iterator();
			while( iter.hasNext() ) {
				retBuff[idx++] = iter.next();
			}
			return( retBuff );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public CFSecTenantBuff readBuffByIdIdx( CFSecAuthorization Authorization,
		long Id )
	{
		final String S_ProcName = "readBuffByIdIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			final String sql = "CALL sp_read_tenant_by_ididx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " )";
			if( stmtReadBuffByIdIdx == null ) {
				stmtReadBuffByIdIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByIdIdx.setLong( argIdx++, Id );
			resultSet = stmtReadBuffByIdIdx.executeQuery();
			if( resultSet.next() ) {
				CFSecTenantBuff buff = unpackTenantResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					resultSet.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				return( buff );
			}
			else {
				return( null );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public CFSecTenantBuff[] readBuffByClusterIdx( CFSecAuthorization Authorization,
		long ClusterId )
	{
		final String S_ProcName = "readBuffByClusterIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			final String sql = "CALL sp_read_tenant_by_clusteridx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " )";
			if( stmtReadBuffByClusterIdx == null ) {
				stmtReadBuffByClusterIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByClusterIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByClusterIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByClusterIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByClusterIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByClusterIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByClusterIdx.setLong( argIdx++, ClusterId );
			resultSet = stmtReadBuffByClusterIdx.executeQuery();
			List<CFSecTenantBuff> buffList = new LinkedList<CFSecTenantBuff>();
			while( resultSet.next() ) {
				CFSecTenantBuff buff = unpackTenantResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFSecTenantBuff[] retBuff = new CFSecTenantBuff[ buffList.size() ];
			Iterator<CFSecTenantBuff> iter = buffList.iterator();
			while( iter.hasNext() ) {
				retBuff[idx++] = iter.next();
			}
			return( retBuff );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public CFSecTenantBuff readBuffByUNameIdx( CFSecAuthorization Authorization,
		long ClusterId,
		String TenantName )
	{
		final String S_ProcName = "readBuffByUNameIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			final String sql = "CALL sp_read_tenant_by_unameidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " )";
			if( stmtReadBuffByUNameIdx == null ) {
				stmtReadBuffByUNameIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtReadBuffByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByUNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtReadBuffByUNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtReadBuffByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtReadBuffByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtReadBuffByUNameIdx.setLong( argIdx++, ClusterId );
			stmtReadBuffByUNameIdx.setString( argIdx++, TenantName );
			resultSet = stmtReadBuffByUNameIdx.executeQuery();
			if( resultSet.next() ) {
				CFSecTenantBuff buff = unpackTenantResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					resultSet.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				return( buff );
			}
			else {
				return( null );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	/**
	 *	Read a page array of the specific Tenant buffer instances identified by the duplicate key ClusterIdx.
	 *
	 *	@param	Authorization	The session authorization information.
	 *
	 *	@param	argClusterId	The Tenant key attribute of the instance generating the id.
	 *
	 *	@return An array of derived buffer instances for the specified key, potentially with 0 elements in the set.
	 *
	 *	@throws	CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFSecTenantBuff[] pageBuffByClusterIdx( CFSecAuthorization Authorization,
		long ClusterId,
		Long priorId )
	{
		final String S_ProcName = "pageBuffByClusterIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			final String sql = "CALL sp_page_tenant_by_clusteridx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " )";
			if( stmtPageBuffByClusterIdx == null ) {
				stmtPageBuffByClusterIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtPageBuffByClusterIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtPageBuffByClusterIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtPageBuffByClusterIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtPageBuffByClusterIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtPageBuffByClusterIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtPageBuffByClusterIdx.setLong( argIdx++, ClusterId );
			if( priorId != null ) {
				stmtPageBuffByClusterIdx.setLong( argIdx++, priorId.longValue() );
			}
			else {
				stmtPageBuffByClusterIdx.setNull( argIdx++, java.sql.Types.BIGINT );
			}
			resultSet = stmtPageBuffByClusterIdx.executeQuery();
			List<CFSecTenantBuff> buffList = new LinkedList<CFSecTenantBuff>();
			while( resultSet.next() ) {
				CFSecTenantBuff buff = unpackTenantResultSetToBuff( resultSet );
				buffList.add( buff );
			}
			int idx = 0;
			CFSecTenantBuff[] retBuff = new CFSecTenantBuff[ buffList.size() ];
			Iterator<CFSecTenantBuff> iter = buffList.iterator();
			while( iter.hasNext() ) {
				retBuff[idx++] = iter.next();
			}
			return( retBuff );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void updateTenant( CFSecAuthorization Authorization,
		CFSecTenantBuff Buff )
	{
		final String S_ProcName = "updateTenant";
		if( "a015".equals( Buff.getClassCode() )
			&& ( ! schema.isSystemUser( Authorization ) ) )
		{
			throw new CFLibRuntimeException( getClass(),
				S_ProcName,
				"Permission denied -- only system user can modify Tenant data" );
		}
		ResultSet resultSet = null;
		try {
			long ClusterId = Buff.getRequiredClusterId();
			long Id = Buff.getRequiredId();
			String TenantName = Buff.getRequiredTenantName();
			int Revision = Buff.getRequiredRevision();
			Connection cnx = schema.getCnx();
			final String sql =
				"CALL sp_update_tenant( ?, ?, ?, ?, ?, ?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+	"?" + ", "
					+ "?" + " )";
			if( stmtUpdateByPKey == null ) {
				stmtUpdateByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtUpdateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtUpdateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtUpdateByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtUpdateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtUpdateByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtUpdateByPKey.setString( argIdx++, "a015" );
			stmtUpdateByPKey.setLong( argIdx++, ClusterId );
			stmtUpdateByPKey.setLong( argIdx++, Id );
			stmtUpdateByPKey.setString( argIdx++, TenantName );
			stmtUpdateByPKey.setInt( argIdx++, Revision );
			resultSet = stmtUpdateByPKey.executeQuery();
			if( resultSet.next() ) {
				CFSecTenantBuff updatedBuff = unpackTenantResultSetToBuff( resultSet );
				if( resultSet.next() ) {
					resultSet.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
				Buff.setRequiredClusterId( updatedBuff.getRequiredClusterId() );
				Buff.setRequiredTenantName( updatedBuff.getRequiredTenantName() );
				Buff.setRequiredRevision( updatedBuff.getRequiredRevision() );
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"Expected a single-record response, " + resultSet.getRow() + " rows selected" );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteTenant( CFSecAuthorization Authorization,
		CFSecTenantBuff Buff )
	{
		final String S_ProcName = "deleteTenant";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			long Id = Buff.getRequiredId();

			final String sql = "CALL sp_delete_tenant( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " )";
			if( stmtDeleteByPKey == null ) {
				stmtDeleteByPKey = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByPKey.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByPKey.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByPKey.setLong( argIdx++, Id );
			stmtDeleteByPKey.setInt( argIdx++, Buff.getRequiredRevision() );;
			resultSet = stmtDeleteByPKey.executeQuery();
			if( resultSet.next() ) {
				int deleteFlag = resultSet.getInt( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 record result set to be returned by delete, not 0 rows" );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteTenantByIdIdx( CFSecAuthorization Authorization,
		long argId )
	{
		final String S_ProcName = "deleteTenantByIdIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			final String sql = "CALL sp_delete_tenant_by_ididx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " )";
			if( stmtDeleteByIdIdx == null ) {
				stmtDeleteByIdIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByIdIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByIdIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByIdIdx.setLong( argIdx++, argId );
			resultSet = stmtDeleteByIdIdx.executeQuery();
			if( resultSet.next() ) {
				int deleteFlag = resultSet.getInt( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 record result set to be returned by delete, not 0 rows" );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteTenantByIdIdx( CFSecAuthorization Authorization,
		CFSecTenantPKey argKey )
	{
		deleteTenantByIdIdx( Authorization,
			argKey.getRequiredId() );
	}

	public void deleteTenantByClusterIdx( CFSecAuthorization Authorization,
		long argClusterId )
	{
		final String S_ProcName = "deleteTenantByClusterIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			final String sql = "CALL sp_delete_tenant_by_clusteridx( ?, ?, ?, ?, ?" + ", "
				+		"?" + " )";
			if( stmtDeleteByClusterIdx == null ) {
				stmtDeleteByClusterIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByClusterIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByClusterIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByClusterIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByClusterIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByClusterIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByClusterIdx.setLong( argIdx++, argClusterId );
			resultSet = stmtDeleteByClusterIdx.executeQuery();
			if( resultSet.next() ) {
				int deleteFlag = resultSet.getInt( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 record result set to be returned by delete, not 0 rows" );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteTenantByClusterIdx( CFSecAuthorization Authorization,
		CFSecTenantByClusterIdxKey argKey )
	{
		deleteTenantByClusterIdx( Authorization,
			argKey.getRequiredClusterId() );
	}

	public void deleteTenantByUNameIdx( CFSecAuthorization Authorization,
		long argClusterId,
		String argTenantName )
	{
		final String S_ProcName = "deleteTenantByUNameIdx";
		ResultSet resultSet = null;
		try {
			Connection cnx = schema.getCnx();
			final String sql = "CALL sp_delete_tenant_by_unameidx( ?, ?, ?, ?, ?" + ", "
				+		"?" + ", "
				+		"?" + " )";
			if( stmtDeleteByUNameIdx == null ) {
				stmtDeleteByUNameIdx = cnx.prepareStatement( sql );
			}
			int argIdx = 1;
			stmtDeleteByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByUNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecUserId().toString() );
			stmtDeleteByUNameIdx.setString( argIdx++, ( Authorization == null ) ? "" : Authorization.getSecSessionId().toString() );
			stmtDeleteByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecClusterId() );
			stmtDeleteByUNameIdx.setLong( argIdx++, ( Authorization == null ) ? 0 : Authorization.getSecTenantId() );
			stmtDeleteByUNameIdx.setLong( argIdx++, argClusterId );
			stmtDeleteByUNameIdx.setString( argIdx++, argTenantName );
			resultSet = stmtDeleteByUNameIdx.executeQuery();
			if( resultSet.next() ) {
				int deleteFlag = resultSet.getInt( 1 );
				if( resultSet.next() ) {
					resultSet.last();
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Did not expect multi-record response, " + resultSet.getRow() + " rows selected" );
				}
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"Expected 1 record result set to be returned by delete, not 0 rows" );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				S_ProcName,
				e );
		}
		finally {
			if( resultSet != null ) {
				try {
					resultSet.close();
				}
				catch( SQLException e ) {
				}
				resultSet = null;
			}
		}
	}

	public void deleteTenantByUNameIdx( CFSecAuthorization Authorization,
		CFSecTenantByUNameIdxKey argKey )
	{
		deleteTenantByUNameIdx( Authorization,
			argKey.getRequiredClusterId(),
			argKey.getRequiredTenantName() );
	}

	/**
	 *	Release the prepared statements.
	 *	<p>
	 *	When the schema changes connections, the prepared statements
	 *	have to be released because they contain connection-specific
	 *	information for most databases.
	 */
	public void releasePreparedStatements() {
		final String S_ProcName = "releasePreparedStatements";
		S_sqlSelectTenantDistinctClassCode = null;
		S_sqlSelectTenantBuff = null;

		if( stmtReadBuffByPKey != null ) {
			try {
				stmtReadBuffByPKey.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByPKey = null;
		}
		if( stmtReadAllBuff != null ) {
			try {
				stmtReadAllBuff.close();
			}
			catch( SQLException e ) {
			}
			stmtReadAllBuff = null;
		}
		if( stmtLockBuffByPKey != null ) {
			try {
				stmtLockBuffByPKey.close();
			}
			catch( SQLException e ) {
			}
			stmtLockBuffByPKey = null;
		}
		if( stmtCreateByPKey != null ) {
			try {
				stmtCreateByPKey.close();
			}
			catch( SQLException e ) {
			}
			stmtCreateByPKey = null;
		}
		if( stmtUpdateByPKey != null ) {
			try {
				stmtUpdateByPKey.close();
			}
			catch( SQLException e ) {
			}
			stmtUpdateByPKey = null;
		}
		if( stmtDeleteByPKey != null ) {
			try {
				stmtDeleteByPKey.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByPKey = null;
		}
		if( stmtDeleteByIdIdx != null ) {
			try {
				stmtDeleteByIdIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByIdIdx = null;
		}
		if( stmtDeleteByClusterIdx != null ) {
			try {
				stmtDeleteByClusterIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByClusterIdx = null;
		}
		if( stmtDeleteByUNameIdx != null ) {
			try {
				stmtDeleteByUNameIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtDeleteByUNameIdx = null;
		}
		if( stmtReadAllBuff != null ) {
			try {
				stmtReadAllBuff.close();
			}
			catch( SQLException e ) {
			}
			stmtReadAllBuff = null;
		}
		if( stmtPageAllBuff != null ) {
			try {
				stmtPageAllBuff.close();
			}
			catch( SQLException e ) {
			}
			stmtPageAllBuff = null;
		}
		if( stmtReadBuffByIdIdx != null ) {
			try {
				stmtReadBuffByIdIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByIdIdx = null;
		}
		if( stmtReadBuffByClusterIdx != null ) {
			try {
				stmtReadBuffByClusterIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByClusterIdx = null;
		}
		if( stmtReadBuffByUNameIdx != null ) {
			try {
				stmtReadBuffByUNameIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtReadBuffByUNameIdx = null;
		}
		if( stmtPageBuffByClusterIdx != null ) {
			try {
				stmtPageBuffByClusterIdx.close();
			}
			catch( SQLException e ) {
			}
			stmtPageBuffByClusterIdx = null;
		}
		if( stmtSelectNextTSecGroupIdGen != null ) {
			try {
				stmtSelectNextTSecGroupIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextTSecGroupIdGen = null;
		}
		if( stmtSelectNextTSecGrpIncIdGen != null ) {
			try {
				stmtSelectNextTSecGrpIncIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextTSecGrpIncIdGen = null;
		}
		if( stmtSelectNextTSecGrpMembIdGen != null ) {
			try {
				stmtSelectNextTSecGrpMembIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextTSecGrpMembIdGen = null;
		}
		if( stmtSelectNextMajorVersionIdGen != null ) {
			try {
				stmtSelectNextMajorVersionIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextMajorVersionIdGen = null;
		}
		if( stmtSelectNextMinorVersionIdGen != null ) {
			try {
				stmtSelectNextMinorVersionIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextMinorVersionIdGen = null;
		}
		if( stmtSelectNextSubProjectIdGen != null ) {
			try {
				stmtSelectNextSubProjectIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextSubProjectIdGen = null;
		}
		if( stmtSelectNextTldIdGen != null ) {
			try {
				stmtSelectNextTldIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextTldIdGen = null;
		}
		if( stmtSelectNextTopDomainIdGen != null ) {
			try {
				stmtSelectNextTopDomainIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextTopDomainIdGen = null;
		}
		if( stmtSelectNextTopProjectIdGen != null ) {
			try {
				stmtSelectNextTopProjectIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextTopProjectIdGen = null;
		}
		if( stmtSelectNextChainIdGen != null ) {
			try {
				stmtSelectNextChainIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextChainIdGen = null;
		}
		if( stmtSelectNextEnumTagIdGen != null ) {
			try {
				stmtSelectNextEnumTagIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextEnumTagIdGen = null;
		}
		if( stmtSelectNextIndexColIdGen != null ) {
			try {
				stmtSelectNextIndexColIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextIndexColIdGen = null;
		}
		if( stmtSelectNextParamIdGen != null ) {
			try {
				stmtSelectNextParamIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextParamIdGen = null;
		}
		if( stmtSelectNextRelationColIdGen != null ) {
			try {
				stmtSelectNextRelationColIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextRelationColIdGen = null;
		}
		if( stmtSelectNextScopeIdGen != null ) {
			try {
				stmtSelectNextScopeIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextScopeIdGen = null;
		}
		if( stmtSelectNextValueIdGen != null ) {
			try {
				stmtSelectNextValueIdGen.close();
			}
			catch( SQLException e ) {
			}
			stmtSelectNextValueIdGen = null;
		}
	}
}
