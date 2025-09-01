// Description: Java 11 DB/2 LUW Jdbc DbIO implementation for CFBam.

/*
 *	server.markhome.msscf.CFBam
 *
 *	Copyright (c) 2020-2025 Mark Stephen Sobkow
 *	
 *
 *	Manufactured by MSS Code Factory 2.13
 */

package server.markhome.msscf.cfbam.CFBamDb2LUW;

import java.lang.reflect.*;
import java.math.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;
import org.apache.commons.codec.binary.Base64;
import org.msscf.msscf.cflib.CFLib.*;
import server.markhome.msscf.cfsec.CFSec.*;
import server.markhome.msscf.cfint.CFInt.*;
import server.markhome.msscf.cfbam.CFBam.*;
import server.markhome.msscf.cfbam.CFBamSaxLoader.CFBamSaxLoader;

public class CFBamDb2LUWSchema
	extends CFBamSchema
	implements ICFBamSchema
{
	protected Connection cnx;
	protected boolean inTransaction;
	protected PreparedStatement stmtSelectNextISOCcyIdGen = null;
	protected PreparedStatement stmtSelectNextISOCtryIdGen = null;
	protected PreparedStatement stmtSelectNextISOLangIdGen = null;
	protected PreparedStatement stmtSelectNextISOTZoneIdGen = null;
	protected PreparedStatement stmtSelectNextServiceTypeIdGen = null;
	protected PreparedStatement stmtSelectNextMimeTypeIdGen = null;
	protected PreparedStatement stmtSelectNextURLProtocolIdGen = null;
	protected PreparedStatement stmtSelectNextClusterIdGen = null;
	protected PreparedStatement stmtSelectNextTenantIdGen = null;
	protected PreparedStatement stmtSelectIsSystemUser = null;
	protected PreparedStatement stmtSelectIsClusterUser = null;
	protected PreparedStatement stmtSelectIsTenantUser = null;

	public CFBamDb2LUWSchema() {
		super();
		cnx = null;
		inTransaction = false;
		tableAtom = new CFBamDb2LUWAtomTable( this );
		tableBlobCol = new CFBamDb2LUWBlobColTable( this );
		tableBlobDef = new CFBamDb2LUWBlobDefTable( this );
		tableBlobType = new CFBamDb2LUWBlobTypeTable( this );
		tableBoolCol = new CFBamDb2LUWBoolColTable( this );
		tableBoolDef = new CFBamDb2LUWBoolDefTable( this );
		tableBoolType = new CFBamDb2LUWBoolTypeTable( this );
		tableChain = new CFBamDb2LUWChainTable( this );
		tableClearDep = new CFBamDb2LUWClearDepTable( this );
		tableClearSubDep1 = new CFBamDb2LUWClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamDb2LUWClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamDb2LUWClearSubDep3Table( this );
		tableClearTopDep = new CFBamDb2LUWClearTopDepTable( this );
		tableCluster = new CFBamDb2LUWClusterTable( this );
		tableDateCol = new CFBamDb2LUWDateColTable( this );
		tableDateDef = new CFBamDb2LUWDateDefTable( this );
		tableDateType = new CFBamDb2LUWDateTypeTable( this );
		tableDelDep = new CFBamDb2LUWDelDepTable( this );
		tableDelSubDep1 = new CFBamDb2LUWDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamDb2LUWDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamDb2LUWDelSubDep3Table( this );
		tableDelTopDep = new CFBamDb2LUWDelTopDepTable( this );
		tableDoubleCol = new CFBamDb2LUWDoubleColTable( this );
		tableDoubleDef = new CFBamDb2LUWDoubleDefTable( this );
		tableDoubleType = new CFBamDb2LUWDoubleTypeTable( this );
		tableEnumDef = new CFBamDb2LUWEnumDefTable( this );
		tableEnumTag = new CFBamDb2LUWEnumTagTable( this );
		tableEnumType = new CFBamDb2LUWEnumTypeTable( this );
		tableFloatCol = new CFBamDb2LUWFloatColTable( this );
		tableFloatDef = new CFBamDb2LUWFloatDefTable( this );
		tableFloatType = new CFBamDb2LUWFloatTypeTable( this );
		tableHostNode = new CFBamDb2LUWHostNodeTable( this );
		tableISOCcy = new CFBamDb2LUWISOCcyTable( this );
		tableISOCtry = new CFBamDb2LUWISOCtryTable( this );
		tableISOCtryCcy = new CFBamDb2LUWISOCtryCcyTable( this );
		tableISOCtryLang = new CFBamDb2LUWISOCtryLangTable( this );
		tableISOLang = new CFBamDb2LUWISOLangTable( this );
		tableISOTZone = new CFBamDb2LUWISOTZoneTable( this );
		tableId16Gen = new CFBamDb2LUWId16GenTable( this );
		tableId32Gen = new CFBamDb2LUWId32GenTable( this );
		tableId64Gen = new CFBamDb2LUWId64GenTable( this );
		tableIndex = new CFBamDb2LUWIndexTable( this );
		tableIndexCol = new CFBamDb2LUWIndexColTable( this );
		tableInt16Col = new CFBamDb2LUWInt16ColTable( this );
		tableInt16Def = new CFBamDb2LUWInt16DefTable( this );
		tableInt16Type = new CFBamDb2LUWInt16TypeTable( this );
		tableInt32Col = new CFBamDb2LUWInt32ColTable( this );
		tableInt32Def = new CFBamDb2LUWInt32DefTable( this );
		tableInt32Type = new CFBamDb2LUWInt32TypeTable( this );
		tableInt64Col = new CFBamDb2LUWInt64ColTable( this );
		tableInt64Def = new CFBamDb2LUWInt64DefTable( this );
		tableInt64Type = new CFBamDb2LUWInt64TypeTable( this );
		tableMajorVersion = new CFBamDb2LUWMajorVersionTable( this );
		tableMimeType = new CFBamDb2LUWMimeTypeTable( this );
		tableMinorVersion = new CFBamDb2LUWMinorVersionTable( this );
		tableNmTokenCol = new CFBamDb2LUWNmTokenColTable( this );
		tableNmTokenDef = new CFBamDb2LUWNmTokenDefTable( this );
		tableNmTokenType = new CFBamDb2LUWNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamDb2LUWNmTokensColTable( this );
		tableNmTokensDef = new CFBamDb2LUWNmTokensDefTable( this );
		tableNmTokensType = new CFBamDb2LUWNmTokensTypeTable( this );
		tableNumberCol = new CFBamDb2LUWNumberColTable( this );
		tableNumberDef = new CFBamDb2LUWNumberDefTable( this );
		tableNumberType = new CFBamDb2LUWNumberTypeTable( this );
		tableParam = new CFBamDb2LUWParamTable( this );
		tablePopDep = new CFBamDb2LUWPopDepTable( this );
		tablePopSubDep1 = new CFBamDb2LUWPopSubDep1Table( this );
		tablePopSubDep2 = new CFBamDb2LUWPopSubDep2Table( this );
		tablePopSubDep3 = new CFBamDb2LUWPopSubDep3Table( this );
		tablePopTopDep = new CFBamDb2LUWPopTopDepTable( this );
		tableRelation = new CFBamDb2LUWRelationTable( this );
		tableRelationCol = new CFBamDb2LUWRelationColTable( this );
		tableSchemaDef = new CFBamDb2LUWSchemaDefTable( this );
		tableSchemaRef = new CFBamDb2LUWSchemaRefTable( this );
		tableScope = new CFBamDb2LUWScopeTable( this );
		tableSecApp = new CFBamDb2LUWSecAppTable( this );
		tableSecDevice = new CFBamDb2LUWSecDeviceTable( this );
		tableSecForm = new CFBamDb2LUWSecFormTable( this );
		tableSecGroup = new CFBamDb2LUWSecGroupTable( this );
		tableSecGroupForm = new CFBamDb2LUWSecGroupFormTable( this );
		tableSecGrpInc = new CFBamDb2LUWSecGrpIncTable( this );
		tableSecGrpMemb = new CFBamDb2LUWSecGrpMembTable( this );
		tableSecSession = new CFBamDb2LUWSecSessionTable( this );
		tableSecUser = new CFBamDb2LUWSecUserTable( this );
		tableServerListFunc = new CFBamDb2LUWServerListFuncTable( this );
		tableServerMethod = new CFBamDb2LUWServerMethodTable( this );
		tableServerObjFunc = new CFBamDb2LUWServerObjFuncTable( this );
		tableServerProc = new CFBamDb2LUWServerProcTable( this );
		tableService = new CFBamDb2LUWServiceTable( this );
		tableServiceType = new CFBamDb2LUWServiceTypeTable( this );
		tableStringCol = new CFBamDb2LUWStringColTable( this );
		tableStringDef = new CFBamDb2LUWStringDefTable( this );
		tableStringType = new CFBamDb2LUWStringTypeTable( this );
		tableSubProject = new CFBamDb2LUWSubProjectTable( this );
		tableSysCluster = new CFBamDb2LUWSysClusterTable( this );
		tableTSecGroup = new CFBamDb2LUWTSecGroupTable( this );
		tableTSecGrpInc = new CFBamDb2LUWTSecGrpIncTable( this );
		tableTSecGrpMemb = new CFBamDb2LUWTSecGrpMembTable( this );
		tableTZDateCol = new CFBamDb2LUWTZDateColTable( this );
		tableTZDateDef = new CFBamDb2LUWTZDateDefTable( this );
		tableTZDateType = new CFBamDb2LUWTZDateTypeTable( this );
		tableTZTimeCol = new CFBamDb2LUWTZTimeColTable( this );
		tableTZTimeDef = new CFBamDb2LUWTZTimeDefTable( this );
		tableTZTimeType = new CFBamDb2LUWTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamDb2LUWTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamDb2LUWTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamDb2LUWTZTimestampTypeTable( this );
		tableTable = new CFBamDb2LUWTableTable( this );
		tableTableCol = new CFBamDb2LUWTableColTable( this );
		tableTenant = new CFBamDb2LUWTenantTable( this );
		tableTextCol = new CFBamDb2LUWTextColTable( this );
		tableTextDef = new CFBamDb2LUWTextDefTable( this );
		tableTextType = new CFBamDb2LUWTextTypeTable( this );
		tableTimeCol = new CFBamDb2LUWTimeColTable( this );
		tableTimeDef = new CFBamDb2LUWTimeDefTable( this );
		tableTimeType = new CFBamDb2LUWTimeTypeTable( this );
		tableTimestampCol = new CFBamDb2LUWTimestampColTable( this );
		tableTimestampDef = new CFBamDb2LUWTimestampDefTable( this );
		tableTimestampType = new CFBamDb2LUWTimestampTypeTable( this );
		tableTld = new CFBamDb2LUWTldTable( this );
		tableTokenCol = new CFBamDb2LUWTokenColTable( this );
		tableTokenDef = new CFBamDb2LUWTokenDefTable( this );
		tableTokenType = new CFBamDb2LUWTokenTypeTable( this );
		tableTopDomain = new CFBamDb2LUWTopDomainTable( this );
		tableTopProject = new CFBamDb2LUWTopProjectTable( this );
		tableUInt16Col = new CFBamDb2LUWUInt16ColTable( this );
		tableUInt16Def = new CFBamDb2LUWUInt16DefTable( this );
		tableUInt16Type = new CFBamDb2LUWUInt16TypeTable( this );
		tableUInt32Col = new CFBamDb2LUWUInt32ColTable( this );
		tableUInt32Def = new CFBamDb2LUWUInt32DefTable( this );
		tableUInt32Type = new CFBamDb2LUWUInt32TypeTable( this );
		tableUInt64Col = new CFBamDb2LUWUInt64ColTable( this );
		tableUInt64Def = new CFBamDb2LUWUInt64DefTable( this );
		tableUInt64Type = new CFBamDb2LUWUInt64TypeTable( this );
		tableURLProtocol = new CFBamDb2LUWURLProtocolTable( this );
		tableUuidCol = new CFBamDb2LUWUuidColTable( this );
		tableUuidDef = new CFBamDb2LUWUuidDefTable( this );
		tableUuidGen = new CFBamDb2LUWUuidGenTable( this );
		tableUuidType = new CFBamDb2LUWUuidTypeTable( this );
		tableValue = new CFBamDb2LUWValueTable( this );
	}

	public CFBamDb2LUWSchema( CFBamConfigurationFile conf ) {
		super( conf );
		cnx = null;
		inTransaction = false;
		tableAtom = new CFBamDb2LUWAtomTable( this );
		tableBlobCol = new CFBamDb2LUWBlobColTable( this );
		tableBlobDef = new CFBamDb2LUWBlobDefTable( this );
		tableBlobType = new CFBamDb2LUWBlobTypeTable( this );
		tableBoolCol = new CFBamDb2LUWBoolColTable( this );
		tableBoolDef = new CFBamDb2LUWBoolDefTable( this );
		tableBoolType = new CFBamDb2LUWBoolTypeTable( this );
		tableChain = new CFBamDb2LUWChainTable( this );
		tableClearDep = new CFBamDb2LUWClearDepTable( this );
		tableClearSubDep1 = new CFBamDb2LUWClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamDb2LUWClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamDb2LUWClearSubDep3Table( this );
		tableClearTopDep = new CFBamDb2LUWClearTopDepTable( this );
		tableCluster = new CFBamDb2LUWClusterTable( this );
		tableDateCol = new CFBamDb2LUWDateColTable( this );
		tableDateDef = new CFBamDb2LUWDateDefTable( this );
		tableDateType = new CFBamDb2LUWDateTypeTable( this );
		tableDelDep = new CFBamDb2LUWDelDepTable( this );
		tableDelSubDep1 = new CFBamDb2LUWDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamDb2LUWDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamDb2LUWDelSubDep3Table( this );
		tableDelTopDep = new CFBamDb2LUWDelTopDepTable( this );
		tableDoubleCol = new CFBamDb2LUWDoubleColTable( this );
		tableDoubleDef = new CFBamDb2LUWDoubleDefTable( this );
		tableDoubleType = new CFBamDb2LUWDoubleTypeTable( this );
		tableEnumDef = new CFBamDb2LUWEnumDefTable( this );
		tableEnumTag = new CFBamDb2LUWEnumTagTable( this );
		tableEnumType = new CFBamDb2LUWEnumTypeTable( this );
		tableFloatCol = new CFBamDb2LUWFloatColTable( this );
		tableFloatDef = new CFBamDb2LUWFloatDefTable( this );
		tableFloatType = new CFBamDb2LUWFloatTypeTable( this );
		tableHostNode = new CFBamDb2LUWHostNodeTable( this );
		tableISOCcy = new CFBamDb2LUWISOCcyTable( this );
		tableISOCtry = new CFBamDb2LUWISOCtryTable( this );
		tableISOCtryCcy = new CFBamDb2LUWISOCtryCcyTable( this );
		tableISOCtryLang = new CFBamDb2LUWISOCtryLangTable( this );
		tableISOLang = new CFBamDb2LUWISOLangTable( this );
		tableISOTZone = new CFBamDb2LUWISOTZoneTable( this );
		tableId16Gen = new CFBamDb2LUWId16GenTable( this );
		tableId32Gen = new CFBamDb2LUWId32GenTable( this );
		tableId64Gen = new CFBamDb2LUWId64GenTable( this );
		tableIndex = new CFBamDb2LUWIndexTable( this );
		tableIndexCol = new CFBamDb2LUWIndexColTable( this );
		tableInt16Col = new CFBamDb2LUWInt16ColTable( this );
		tableInt16Def = new CFBamDb2LUWInt16DefTable( this );
		tableInt16Type = new CFBamDb2LUWInt16TypeTable( this );
		tableInt32Col = new CFBamDb2LUWInt32ColTable( this );
		tableInt32Def = new CFBamDb2LUWInt32DefTable( this );
		tableInt32Type = new CFBamDb2LUWInt32TypeTable( this );
		tableInt64Col = new CFBamDb2LUWInt64ColTable( this );
		tableInt64Def = new CFBamDb2LUWInt64DefTable( this );
		tableInt64Type = new CFBamDb2LUWInt64TypeTable( this );
		tableMajorVersion = new CFBamDb2LUWMajorVersionTable( this );
		tableMimeType = new CFBamDb2LUWMimeTypeTable( this );
		tableMinorVersion = new CFBamDb2LUWMinorVersionTable( this );
		tableNmTokenCol = new CFBamDb2LUWNmTokenColTable( this );
		tableNmTokenDef = new CFBamDb2LUWNmTokenDefTable( this );
		tableNmTokenType = new CFBamDb2LUWNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamDb2LUWNmTokensColTable( this );
		tableNmTokensDef = new CFBamDb2LUWNmTokensDefTable( this );
		tableNmTokensType = new CFBamDb2LUWNmTokensTypeTable( this );
		tableNumberCol = new CFBamDb2LUWNumberColTable( this );
		tableNumberDef = new CFBamDb2LUWNumberDefTable( this );
		tableNumberType = new CFBamDb2LUWNumberTypeTable( this );
		tableParam = new CFBamDb2LUWParamTable( this );
		tablePopDep = new CFBamDb2LUWPopDepTable( this );
		tablePopSubDep1 = new CFBamDb2LUWPopSubDep1Table( this );
		tablePopSubDep2 = new CFBamDb2LUWPopSubDep2Table( this );
		tablePopSubDep3 = new CFBamDb2LUWPopSubDep3Table( this );
		tablePopTopDep = new CFBamDb2LUWPopTopDepTable( this );
		tableRelation = new CFBamDb2LUWRelationTable( this );
		tableRelationCol = new CFBamDb2LUWRelationColTable( this );
		tableSchemaDef = new CFBamDb2LUWSchemaDefTable( this );
		tableSchemaRef = new CFBamDb2LUWSchemaRefTable( this );
		tableScope = new CFBamDb2LUWScopeTable( this );
		tableSecApp = new CFBamDb2LUWSecAppTable( this );
		tableSecDevice = new CFBamDb2LUWSecDeviceTable( this );
		tableSecForm = new CFBamDb2LUWSecFormTable( this );
		tableSecGroup = new CFBamDb2LUWSecGroupTable( this );
		tableSecGroupForm = new CFBamDb2LUWSecGroupFormTable( this );
		tableSecGrpInc = new CFBamDb2LUWSecGrpIncTable( this );
		tableSecGrpMemb = new CFBamDb2LUWSecGrpMembTable( this );
		tableSecSession = new CFBamDb2LUWSecSessionTable( this );
		tableSecUser = new CFBamDb2LUWSecUserTable( this );
		tableServerListFunc = new CFBamDb2LUWServerListFuncTable( this );
		tableServerMethod = new CFBamDb2LUWServerMethodTable( this );
		tableServerObjFunc = new CFBamDb2LUWServerObjFuncTable( this );
		tableServerProc = new CFBamDb2LUWServerProcTable( this );
		tableService = new CFBamDb2LUWServiceTable( this );
		tableServiceType = new CFBamDb2LUWServiceTypeTable( this );
		tableStringCol = new CFBamDb2LUWStringColTable( this );
		tableStringDef = new CFBamDb2LUWStringDefTable( this );
		tableStringType = new CFBamDb2LUWStringTypeTable( this );
		tableSubProject = new CFBamDb2LUWSubProjectTable( this );
		tableSysCluster = new CFBamDb2LUWSysClusterTable( this );
		tableTSecGroup = new CFBamDb2LUWTSecGroupTable( this );
		tableTSecGrpInc = new CFBamDb2LUWTSecGrpIncTable( this );
		tableTSecGrpMemb = new CFBamDb2LUWTSecGrpMembTable( this );
		tableTZDateCol = new CFBamDb2LUWTZDateColTable( this );
		tableTZDateDef = new CFBamDb2LUWTZDateDefTable( this );
		tableTZDateType = new CFBamDb2LUWTZDateTypeTable( this );
		tableTZTimeCol = new CFBamDb2LUWTZTimeColTable( this );
		tableTZTimeDef = new CFBamDb2LUWTZTimeDefTable( this );
		tableTZTimeType = new CFBamDb2LUWTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamDb2LUWTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamDb2LUWTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamDb2LUWTZTimestampTypeTable( this );
		tableTable = new CFBamDb2LUWTableTable( this );
		tableTableCol = new CFBamDb2LUWTableColTable( this );
		tableTenant = new CFBamDb2LUWTenantTable( this );
		tableTextCol = new CFBamDb2LUWTextColTable( this );
		tableTextDef = new CFBamDb2LUWTextDefTable( this );
		tableTextType = new CFBamDb2LUWTextTypeTable( this );
		tableTimeCol = new CFBamDb2LUWTimeColTable( this );
		tableTimeDef = new CFBamDb2LUWTimeDefTable( this );
		tableTimeType = new CFBamDb2LUWTimeTypeTable( this );
		tableTimestampCol = new CFBamDb2LUWTimestampColTable( this );
		tableTimestampDef = new CFBamDb2LUWTimestampDefTable( this );
		tableTimestampType = new CFBamDb2LUWTimestampTypeTable( this );
		tableTld = new CFBamDb2LUWTldTable( this );
		tableTokenCol = new CFBamDb2LUWTokenColTable( this );
		tableTokenDef = new CFBamDb2LUWTokenDefTable( this );
		tableTokenType = new CFBamDb2LUWTokenTypeTable( this );
		tableTopDomain = new CFBamDb2LUWTopDomainTable( this );
		tableTopProject = new CFBamDb2LUWTopProjectTable( this );
		tableUInt16Col = new CFBamDb2LUWUInt16ColTable( this );
		tableUInt16Def = new CFBamDb2LUWUInt16DefTable( this );
		tableUInt16Type = new CFBamDb2LUWUInt16TypeTable( this );
		tableUInt32Col = new CFBamDb2LUWUInt32ColTable( this );
		tableUInt32Def = new CFBamDb2LUWUInt32DefTable( this );
		tableUInt32Type = new CFBamDb2LUWUInt32TypeTable( this );
		tableUInt64Col = new CFBamDb2LUWUInt64ColTable( this );
		tableUInt64Def = new CFBamDb2LUWUInt64DefTable( this );
		tableUInt64Type = new CFBamDb2LUWUInt64TypeTable( this );
		tableURLProtocol = new CFBamDb2LUWURLProtocolTable( this );
		tableUuidCol = new CFBamDb2LUWUuidColTable( this );
		tableUuidDef = new CFBamDb2LUWUuidDefTable( this );
		tableUuidGen = new CFBamDb2LUWUuidGenTable( this );
		tableUuidType = new CFBamDb2LUWUuidTypeTable( this );
		tableValue = new CFBamDb2LUWValueTable( this );
		setDbSchemaName( conf.getDbDatabase() );
	}

	public CFBamDb2LUWSchema( String argJndiName ) {
		super( argJndiName );
		cnx = null;
		inTransaction = false;
		tableAtom = new CFBamDb2LUWAtomTable( this );
		tableBlobCol = new CFBamDb2LUWBlobColTable( this );
		tableBlobDef = new CFBamDb2LUWBlobDefTable( this );
		tableBlobType = new CFBamDb2LUWBlobTypeTable( this );
		tableBoolCol = new CFBamDb2LUWBoolColTable( this );
		tableBoolDef = new CFBamDb2LUWBoolDefTable( this );
		tableBoolType = new CFBamDb2LUWBoolTypeTable( this );
		tableChain = new CFBamDb2LUWChainTable( this );
		tableClearDep = new CFBamDb2LUWClearDepTable( this );
		tableClearSubDep1 = new CFBamDb2LUWClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamDb2LUWClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamDb2LUWClearSubDep3Table( this );
		tableClearTopDep = new CFBamDb2LUWClearTopDepTable( this );
		tableCluster = new CFBamDb2LUWClusterTable( this );
		tableDateCol = new CFBamDb2LUWDateColTable( this );
		tableDateDef = new CFBamDb2LUWDateDefTable( this );
		tableDateType = new CFBamDb2LUWDateTypeTable( this );
		tableDelDep = new CFBamDb2LUWDelDepTable( this );
		tableDelSubDep1 = new CFBamDb2LUWDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamDb2LUWDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamDb2LUWDelSubDep3Table( this );
		tableDelTopDep = new CFBamDb2LUWDelTopDepTable( this );
		tableDoubleCol = new CFBamDb2LUWDoubleColTable( this );
		tableDoubleDef = new CFBamDb2LUWDoubleDefTable( this );
		tableDoubleType = new CFBamDb2LUWDoubleTypeTable( this );
		tableEnumDef = new CFBamDb2LUWEnumDefTable( this );
		tableEnumTag = new CFBamDb2LUWEnumTagTable( this );
		tableEnumType = new CFBamDb2LUWEnumTypeTable( this );
		tableFloatCol = new CFBamDb2LUWFloatColTable( this );
		tableFloatDef = new CFBamDb2LUWFloatDefTable( this );
		tableFloatType = new CFBamDb2LUWFloatTypeTable( this );
		tableHostNode = new CFBamDb2LUWHostNodeTable( this );
		tableISOCcy = new CFBamDb2LUWISOCcyTable( this );
		tableISOCtry = new CFBamDb2LUWISOCtryTable( this );
		tableISOCtryCcy = new CFBamDb2LUWISOCtryCcyTable( this );
		tableISOCtryLang = new CFBamDb2LUWISOCtryLangTable( this );
		tableISOLang = new CFBamDb2LUWISOLangTable( this );
		tableISOTZone = new CFBamDb2LUWISOTZoneTable( this );
		tableId16Gen = new CFBamDb2LUWId16GenTable( this );
		tableId32Gen = new CFBamDb2LUWId32GenTable( this );
		tableId64Gen = new CFBamDb2LUWId64GenTable( this );
		tableIndex = new CFBamDb2LUWIndexTable( this );
		tableIndexCol = new CFBamDb2LUWIndexColTable( this );
		tableInt16Col = new CFBamDb2LUWInt16ColTable( this );
		tableInt16Def = new CFBamDb2LUWInt16DefTable( this );
		tableInt16Type = new CFBamDb2LUWInt16TypeTable( this );
		tableInt32Col = new CFBamDb2LUWInt32ColTable( this );
		tableInt32Def = new CFBamDb2LUWInt32DefTable( this );
		tableInt32Type = new CFBamDb2LUWInt32TypeTable( this );
		tableInt64Col = new CFBamDb2LUWInt64ColTable( this );
		tableInt64Def = new CFBamDb2LUWInt64DefTable( this );
		tableInt64Type = new CFBamDb2LUWInt64TypeTable( this );
		tableMajorVersion = new CFBamDb2LUWMajorVersionTable( this );
		tableMimeType = new CFBamDb2LUWMimeTypeTable( this );
		tableMinorVersion = new CFBamDb2LUWMinorVersionTable( this );
		tableNmTokenCol = new CFBamDb2LUWNmTokenColTable( this );
		tableNmTokenDef = new CFBamDb2LUWNmTokenDefTable( this );
		tableNmTokenType = new CFBamDb2LUWNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamDb2LUWNmTokensColTable( this );
		tableNmTokensDef = new CFBamDb2LUWNmTokensDefTable( this );
		tableNmTokensType = new CFBamDb2LUWNmTokensTypeTable( this );
		tableNumberCol = new CFBamDb2LUWNumberColTable( this );
		tableNumberDef = new CFBamDb2LUWNumberDefTable( this );
		tableNumberType = new CFBamDb2LUWNumberTypeTable( this );
		tableParam = new CFBamDb2LUWParamTable( this );
		tablePopDep = new CFBamDb2LUWPopDepTable( this );
		tablePopSubDep1 = new CFBamDb2LUWPopSubDep1Table( this );
		tablePopSubDep2 = new CFBamDb2LUWPopSubDep2Table( this );
		tablePopSubDep3 = new CFBamDb2LUWPopSubDep3Table( this );
		tablePopTopDep = new CFBamDb2LUWPopTopDepTable( this );
		tableRelation = new CFBamDb2LUWRelationTable( this );
		tableRelationCol = new CFBamDb2LUWRelationColTable( this );
		tableSchemaDef = new CFBamDb2LUWSchemaDefTable( this );
		tableSchemaRef = new CFBamDb2LUWSchemaRefTable( this );
		tableScope = new CFBamDb2LUWScopeTable( this );
		tableSecApp = new CFBamDb2LUWSecAppTable( this );
		tableSecDevice = new CFBamDb2LUWSecDeviceTable( this );
		tableSecForm = new CFBamDb2LUWSecFormTable( this );
		tableSecGroup = new CFBamDb2LUWSecGroupTable( this );
		tableSecGroupForm = new CFBamDb2LUWSecGroupFormTable( this );
		tableSecGrpInc = new CFBamDb2LUWSecGrpIncTable( this );
		tableSecGrpMemb = new CFBamDb2LUWSecGrpMembTable( this );
		tableSecSession = new CFBamDb2LUWSecSessionTable( this );
		tableSecUser = new CFBamDb2LUWSecUserTable( this );
		tableServerListFunc = new CFBamDb2LUWServerListFuncTable( this );
		tableServerMethod = new CFBamDb2LUWServerMethodTable( this );
		tableServerObjFunc = new CFBamDb2LUWServerObjFuncTable( this );
		tableServerProc = new CFBamDb2LUWServerProcTable( this );
		tableService = new CFBamDb2LUWServiceTable( this );
		tableServiceType = new CFBamDb2LUWServiceTypeTable( this );
		tableStringCol = new CFBamDb2LUWStringColTable( this );
		tableStringDef = new CFBamDb2LUWStringDefTable( this );
		tableStringType = new CFBamDb2LUWStringTypeTable( this );
		tableSubProject = new CFBamDb2LUWSubProjectTable( this );
		tableSysCluster = new CFBamDb2LUWSysClusterTable( this );
		tableTSecGroup = new CFBamDb2LUWTSecGroupTable( this );
		tableTSecGrpInc = new CFBamDb2LUWTSecGrpIncTable( this );
		tableTSecGrpMemb = new CFBamDb2LUWTSecGrpMembTable( this );
		tableTZDateCol = new CFBamDb2LUWTZDateColTable( this );
		tableTZDateDef = new CFBamDb2LUWTZDateDefTable( this );
		tableTZDateType = new CFBamDb2LUWTZDateTypeTable( this );
		tableTZTimeCol = new CFBamDb2LUWTZTimeColTable( this );
		tableTZTimeDef = new CFBamDb2LUWTZTimeDefTable( this );
		tableTZTimeType = new CFBamDb2LUWTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamDb2LUWTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamDb2LUWTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamDb2LUWTZTimestampTypeTable( this );
		tableTable = new CFBamDb2LUWTableTable( this );
		tableTableCol = new CFBamDb2LUWTableColTable( this );
		tableTenant = new CFBamDb2LUWTenantTable( this );
		tableTextCol = new CFBamDb2LUWTextColTable( this );
		tableTextDef = new CFBamDb2LUWTextDefTable( this );
		tableTextType = new CFBamDb2LUWTextTypeTable( this );
		tableTimeCol = new CFBamDb2LUWTimeColTable( this );
		tableTimeDef = new CFBamDb2LUWTimeDefTable( this );
		tableTimeType = new CFBamDb2LUWTimeTypeTable( this );
		tableTimestampCol = new CFBamDb2LUWTimestampColTable( this );
		tableTimestampDef = new CFBamDb2LUWTimestampDefTable( this );
		tableTimestampType = new CFBamDb2LUWTimestampTypeTable( this );
		tableTld = new CFBamDb2LUWTldTable( this );
		tableTokenCol = new CFBamDb2LUWTokenColTable( this );
		tableTokenDef = new CFBamDb2LUWTokenDefTable( this );
		tableTokenType = new CFBamDb2LUWTokenTypeTable( this );
		tableTopDomain = new CFBamDb2LUWTopDomainTable( this );
		tableTopProject = new CFBamDb2LUWTopProjectTable( this );
		tableUInt16Col = new CFBamDb2LUWUInt16ColTable( this );
		tableUInt16Def = new CFBamDb2LUWUInt16DefTable( this );
		tableUInt16Type = new CFBamDb2LUWUInt16TypeTable( this );
		tableUInt32Col = new CFBamDb2LUWUInt32ColTable( this );
		tableUInt32Def = new CFBamDb2LUWUInt32DefTable( this );
		tableUInt32Type = new CFBamDb2LUWUInt32TypeTable( this );
		tableUInt64Col = new CFBamDb2LUWUInt64ColTable( this );
		tableUInt64Def = new CFBamDb2LUWUInt64DefTable( this );
		tableUInt64Type = new CFBamDb2LUWUInt64TypeTable( this );
		tableURLProtocol = new CFBamDb2LUWURLProtocolTable( this );
		tableUuidCol = new CFBamDb2LUWUuidColTable( this );
		tableUuidDef = new CFBamDb2LUWUuidDefTable( this );
		tableUuidGen = new CFBamDb2LUWUuidGenTable( this );
		tableUuidType = new CFBamDb2LUWUuidTypeTable( this );
		tableValue = new CFBamDb2LUWValueTable( this );
	}

	public CFBamDb2LUWSchema( Connection argCnx ) {
		super();
		cnx = argCnx;
		inTransaction = false;
		tableAtom = new CFBamDb2LUWAtomTable( this );
		tableBlobCol = new CFBamDb2LUWBlobColTable( this );
		tableBlobDef = new CFBamDb2LUWBlobDefTable( this );
		tableBlobType = new CFBamDb2LUWBlobTypeTable( this );
		tableBoolCol = new CFBamDb2LUWBoolColTable( this );
		tableBoolDef = new CFBamDb2LUWBoolDefTable( this );
		tableBoolType = new CFBamDb2LUWBoolTypeTable( this );
		tableChain = new CFBamDb2LUWChainTable( this );
		tableClearDep = new CFBamDb2LUWClearDepTable( this );
		tableClearSubDep1 = new CFBamDb2LUWClearSubDep1Table( this );
		tableClearSubDep2 = new CFBamDb2LUWClearSubDep2Table( this );
		tableClearSubDep3 = new CFBamDb2LUWClearSubDep3Table( this );
		tableClearTopDep = new CFBamDb2LUWClearTopDepTable( this );
		tableCluster = new CFBamDb2LUWClusterTable( this );
		tableDateCol = new CFBamDb2LUWDateColTable( this );
		tableDateDef = new CFBamDb2LUWDateDefTable( this );
		tableDateType = new CFBamDb2LUWDateTypeTable( this );
		tableDelDep = new CFBamDb2LUWDelDepTable( this );
		tableDelSubDep1 = new CFBamDb2LUWDelSubDep1Table( this );
		tableDelSubDep2 = new CFBamDb2LUWDelSubDep2Table( this );
		tableDelSubDep3 = new CFBamDb2LUWDelSubDep3Table( this );
		tableDelTopDep = new CFBamDb2LUWDelTopDepTable( this );
		tableDoubleCol = new CFBamDb2LUWDoubleColTable( this );
		tableDoubleDef = new CFBamDb2LUWDoubleDefTable( this );
		tableDoubleType = new CFBamDb2LUWDoubleTypeTable( this );
		tableEnumDef = new CFBamDb2LUWEnumDefTable( this );
		tableEnumTag = new CFBamDb2LUWEnumTagTable( this );
		tableEnumType = new CFBamDb2LUWEnumTypeTable( this );
		tableFloatCol = new CFBamDb2LUWFloatColTable( this );
		tableFloatDef = new CFBamDb2LUWFloatDefTable( this );
		tableFloatType = new CFBamDb2LUWFloatTypeTable( this );
		tableHostNode = new CFBamDb2LUWHostNodeTable( this );
		tableISOCcy = new CFBamDb2LUWISOCcyTable( this );
		tableISOCtry = new CFBamDb2LUWISOCtryTable( this );
		tableISOCtryCcy = new CFBamDb2LUWISOCtryCcyTable( this );
		tableISOCtryLang = new CFBamDb2LUWISOCtryLangTable( this );
		tableISOLang = new CFBamDb2LUWISOLangTable( this );
		tableISOTZone = new CFBamDb2LUWISOTZoneTable( this );
		tableId16Gen = new CFBamDb2LUWId16GenTable( this );
		tableId32Gen = new CFBamDb2LUWId32GenTable( this );
		tableId64Gen = new CFBamDb2LUWId64GenTable( this );
		tableIndex = new CFBamDb2LUWIndexTable( this );
		tableIndexCol = new CFBamDb2LUWIndexColTable( this );
		tableInt16Col = new CFBamDb2LUWInt16ColTable( this );
		tableInt16Def = new CFBamDb2LUWInt16DefTable( this );
		tableInt16Type = new CFBamDb2LUWInt16TypeTable( this );
		tableInt32Col = new CFBamDb2LUWInt32ColTable( this );
		tableInt32Def = new CFBamDb2LUWInt32DefTable( this );
		tableInt32Type = new CFBamDb2LUWInt32TypeTable( this );
		tableInt64Col = new CFBamDb2LUWInt64ColTable( this );
		tableInt64Def = new CFBamDb2LUWInt64DefTable( this );
		tableInt64Type = new CFBamDb2LUWInt64TypeTable( this );
		tableMajorVersion = new CFBamDb2LUWMajorVersionTable( this );
		tableMimeType = new CFBamDb2LUWMimeTypeTable( this );
		tableMinorVersion = new CFBamDb2LUWMinorVersionTable( this );
		tableNmTokenCol = new CFBamDb2LUWNmTokenColTable( this );
		tableNmTokenDef = new CFBamDb2LUWNmTokenDefTable( this );
		tableNmTokenType = new CFBamDb2LUWNmTokenTypeTable( this );
		tableNmTokensCol = new CFBamDb2LUWNmTokensColTable( this );
		tableNmTokensDef = new CFBamDb2LUWNmTokensDefTable( this );
		tableNmTokensType = new CFBamDb2LUWNmTokensTypeTable( this );
		tableNumberCol = new CFBamDb2LUWNumberColTable( this );
		tableNumberDef = new CFBamDb2LUWNumberDefTable( this );
		tableNumberType = new CFBamDb2LUWNumberTypeTable( this );
		tableParam = new CFBamDb2LUWParamTable( this );
		tablePopDep = new CFBamDb2LUWPopDepTable( this );
		tablePopSubDep1 = new CFBamDb2LUWPopSubDep1Table( this );
		tablePopSubDep2 = new CFBamDb2LUWPopSubDep2Table( this );
		tablePopSubDep3 = new CFBamDb2LUWPopSubDep3Table( this );
		tablePopTopDep = new CFBamDb2LUWPopTopDepTable( this );
		tableRelation = new CFBamDb2LUWRelationTable( this );
		tableRelationCol = new CFBamDb2LUWRelationColTable( this );
		tableSchemaDef = new CFBamDb2LUWSchemaDefTable( this );
		tableSchemaRef = new CFBamDb2LUWSchemaRefTable( this );
		tableScope = new CFBamDb2LUWScopeTable( this );
		tableSecApp = new CFBamDb2LUWSecAppTable( this );
		tableSecDevice = new CFBamDb2LUWSecDeviceTable( this );
		tableSecForm = new CFBamDb2LUWSecFormTable( this );
		tableSecGroup = new CFBamDb2LUWSecGroupTable( this );
		tableSecGroupForm = new CFBamDb2LUWSecGroupFormTable( this );
		tableSecGrpInc = new CFBamDb2LUWSecGrpIncTable( this );
		tableSecGrpMemb = new CFBamDb2LUWSecGrpMembTable( this );
		tableSecSession = new CFBamDb2LUWSecSessionTable( this );
		tableSecUser = new CFBamDb2LUWSecUserTable( this );
		tableServerListFunc = new CFBamDb2LUWServerListFuncTable( this );
		tableServerMethod = new CFBamDb2LUWServerMethodTable( this );
		tableServerObjFunc = new CFBamDb2LUWServerObjFuncTable( this );
		tableServerProc = new CFBamDb2LUWServerProcTable( this );
		tableService = new CFBamDb2LUWServiceTable( this );
		tableServiceType = new CFBamDb2LUWServiceTypeTable( this );
		tableStringCol = new CFBamDb2LUWStringColTable( this );
		tableStringDef = new CFBamDb2LUWStringDefTable( this );
		tableStringType = new CFBamDb2LUWStringTypeTable( this );
		tableSubProject = new CFBamDb2LUWSubProjectTable( this );
		tableSysCluster = new CFBamDb2LUWSysClusterTable( this );
		tableTSecGroup = new CFBamDb2LUWTSecGroupTable( this );
		tableTSecGrpInc = new CFBamDb2LUWTSecGrpIncTable( this );
		tableTSecGrpMemb = new CFBamDb2LUWTSecGrpMembTable( this );
		tableTZDateCol = new CFBamDb2LUWTZDateColTable( this );
		tableTZDateDef = new CFBamDb2LUWTZDateDefTable( this );
		tableTZDateType = new CFBamDb2LUWTZDateTypeTable( this );
		tableTZTimeCol = new CFBamDb2LUWTZTimeColTable( this );
		tableTZTimeDef = new CFBamDb2LUWTZTimeDefTable( this );
		tableTZTimeType = new CFBamDb2LUWTZTimeTypeTable( this );
		tableTZTimestampCol = new CFBamDb2LUWTZTimestampColTable( this );
		tableTZTimestampDef = new CFBamDb2LUWTZTimestampDefTable( this );
		tableTZTimestampType = new CFBamDb2LUWTZTimestampTypeTable( this );
		tableTable = new CFBamDb2LUWTableTable( this );
		tableTableCol = new CFBamDb2LUWTableColTable( this );
		tableTenant = new CFBamDb2LUWTenantTable( this );
		tableTextCol = new CFBamDb2LUWTextColTable( this );
		tableTextDef = new CFBamDb2LUWTextDefTable( this );
		tableTextType = new CFBamDb2LUWTextTypeTable( this );
		tableTimeCol = new CFBamDb2LUWTimeColTable( this );
		tableTimeDef = new CFBamDb2LUWTimeDefTable( this );
		tableTimeType = new CFBamDb2LUWTimeTypeTable( this );
		tableTimestampCol = new CFBamDb2LUWTimestampColTable( this );
		tableTimestampDef = new CFBamDb2LUWTimestampDefTable( this );
		tableTimestampType = new CFBamDb2LUWTimestampTypeTable( this );
		tableTld = new CFBamDb2LUWTldTable( this );
		tableTokenCol = new CFBamDb2LUWTokenColTable( this );
		tableTokenDef = new CFBamDb2LUWTokenDefTable( this );
		tableTokenType = new CFBamDb2LUWTokenTypeTable( this );
		tableTopDomain = new CFBamDb2LUWTopDomainTable( this );
		tableTopProject = new CFBamDb2LUWTopProjectTable( this );
		tableUInt16Col = new CFBamDb2LUWUInt16ColTable( this );
		tableUInt16Def = new CFBamDb2LUWUInt16DefTable( this );
		tableUInt16Type = new CFBamDb2LUWUInt16TypeTable( this );
		tableUInt32Col = new CFBamDb2LUWUInt32ColTable( this );
		tableUInt32Def = new CFBamDb2LUWUInt32DefTable( this );
		tableUInt32Type = new CFBamDb2LUWUInt32TypeTable( this );
		tableUInt64Col = new CFBamDb2LUWUInt64ColTable( this );
		tableUInt64Def = new CFBamDb2LUWUInt64DefTable( this );
		tableUInt64Type = new CFBamDb2LUWUInt64TypeTable( this );
		tableURLProtocol = new CFBamDb2LUWURLProtocolTable( this );
		tableUuidCol = new CFBamDb2LUWUuidColTable( this );
		tableUuidDef = new CFBamDb2LUWUuidDefTable( this );
		tableUuidGen = new CFBamDb2LUWUuidGenTable( this );
		tableUuidType = new CFBamDb2LUWUuidTypeTable( this );
		tableValue = new CFBamDb2LUWValueTable( this );
		try {
			cnx.setAutoCommit( false );
			cnx.setTransactionIsolation( Connection.TRANSACTION_REPEATABLE_READ );
			cnx.rollback();
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"CFBamDb2LUWSchema-constructor",
				e );
		}
	}

	public Connection getCnx() {
		return( cnx );
	}

	public boolean isConnected() {
		final String S_ProcName = "isConnected";
		boolean retval;
		if( cnx == null ) {
			retval = false;
		}
		else {
			try {
				if( cnx.isClosed() ) {
					retval = false;
					cnx = null;
					releasePreparedStatements();
				}
				else {
					retval = true;
				}
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
		}
		return( retval );
	}

	public boolean connect() {
		final String S_ProcName = "connect";
		if( cnx != null ) {
			return( false );
		}

		if( configuration != null ) {
			try {
				Class.forName( "com.ibm.db2.jcc.DB2Driver" );
			}
			catch( ClassNotFoundException e ) {
				throw new CFLibRuntimeException( getClass(),
					"connect",
					"Could not load IBM DB/2 LUW driver",
					e );
			}
			String dbServer = configuration.getDbServer();
			int dbPort = configuration.getDbPort();
			String dbDatabase = configuration.getDbDatabase();
			String dbUserName = configuration.getDbUserName();
			String dbPassword = configuration.getDbPassword();
			String url =
					"jdbc:db2://" + dbServer
				+	":" + Integer.toString( dbPort )
				+	"/" + dbDatabase;
			Properties props = new Properties();
			props.setProperty( "user", dbUserName );
			props.setProperty( "password", dbPassword );
			try {
				cnx = DriverManager.getConnection( url, props );
				cnx.setAutoCommit( false );
				cnx.setTransactionIsolation( Connection.TRANSACTION_REPEATABLE_READ );
				cnx.rollback();
				setDbSchemaName( dbDatabase );
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			return( true );
		}
		if( jndiName != null ) {
			try {
				Context ctx = new InitialContext();
				DataSource ds = (DataSource)ctx.lookup( jndiName );
				if( ds == null ) {
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Could not get resolve DataSource \"" + jndiName + "\"" );
				}
				cnx = ds.getConnection();
				if( cnx == null ) {
					throw new CFLibRuntimeException( getClass(),
						S_ProcName,
						"Could not get Connection from PooledConnection for ConnectionPoolDataSource \"" + jndiName + "\"" );
				}
				cnx.setAutoCommit( false );
				cnx.setTransactionIsolation( Connection.TRANSACTION_REPEATABLE_READ );
				cnx.rollback();
			}
			catch( NamingException e ) {
				cnx = null;
				throw new CFLibRuntimeException( getClass(),
					S_ProcName,
					"NamingException " + e.getMessage(),
					e );
			}
			catch( SQLException e ) {
				cnx = null;
				inTransaction = false;
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			return( true );
		}
		throw new CFLibUsageException( getClass(),
			S_ProcName,
			"Neither configurationFile nor jndiName found, do not know how to connect to database" );
	}

	public boolean connect( String username, String password ) {
		final String S_ProcName = "connect-userpw";
		if( cnx != null ) {
			return( false );
		}
		if( ( username == null ) || ( username.length() <= 0 ) ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"username" );
		}
		if( password == null ) {
			throw new CFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"password" );
		}

		if( configuration != null ) {
			try {
				Class.forName( "com.ibm.db2.jcc.DB2Driver" );
			}
			catch( ClassNotFoundException e ) {
				throw new CFLibRuntimeException( getClass(),
					"connect",
					"Could not load IBM DB/2 LUW driver",
					e );
			}
			String dbServer = configuration.getDbServer();
			int dbPort = configuration.getDbPort();
			String dbDatabase = configuration.getDbDatabase();
			String dbUserName = username;
			String dbPassword = password;
			String url =
					"jdbc:db2://" + dbServer
				+	":" + Integer.toString( dbPort )
				+	"/" + dbDatabase;
			Properties props = new Properties();
			props.setProperty( "user", dbUserName );
			props.setProperty( "password", dbPassword );
			try {
				cnx = DriverManager.getConnection( url, props );
				cnx.setAutoCommit( false );
				cnx.setTransactionIsolation( Connection.TRANSACTION_REPEATABLE_READ );
				cnx.rollback();
				setDbSchemaName( dbDatabase );
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			return( true );
		}
		throw new CFLibUsageException( getClass(),
			S_ProcName,
			"configurationFile not found, do not know how to connect to database" );
	}

	public void disconnect( boolean doCommit ) {
		final String S_ProcName = "disconnect";
		if( cnx != null ) {
			try {
				if( ! cnx.isClosed() ) {
					if( doCommit ) {
						cnx.commit();
					}
					else {
						cnx.rollback();
					}
					releasePreparedStatements();
					cnx.close();
				}
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			finally {
				cnx = null;
			}
		}
		releasePreparedStatements();
	}

	public boolean isTransactionOpen() {
		return( inTransaction );
	}

	public boolean beginTransaction() {
		if( inTransaction ) {
			return( false );
		}
//		try {
//			String sql =
//					"begin transaction";
//			Statement stmt = cnx.createStatement( ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY );
//			stmt.execute( sql );
			inTransaction = true;
//		}
//		catch( SQLException e ) {
//			throw new CFLibDbException( getClass(),
//				"beginTransaction",
//				e );
//		}
		return( inTransaction );
	}

	public void commit() {
		try {
			cnx.commit();
			inTransaction = false;
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"commit",
				e );
		}
	}

	public void rollback() {
		try {
			if( cnx != null ) {
				cnx.rollback();
			}
			inTransaction = false;
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"rollback",
				e );
		}
	}

	public boolean isSystemUser( CFSecAuthorization Authorization) {
		if( ! inTransaction ) {
			throw new CFLibUsageException( getClass(),
				"isSystemUser",
				"Not in a transaction" );
		}
		ResultSet resultSet = null;
		try {
			final String sql = "SELECT sp_is_system_user( ? ) as IsSystemUser FROM sysibm.sysdummy1";
			if( stmtSelectIsSystemUser == null ) {
				stmtSelectIsSystemUser = cnx.prepareStatement( sql );
			}
			stmtSelectIsSystemUser.setString( 1, Authorization.getSecUserId().toString() );
			resultSet = stmtSelectIsSystemUser.executeQuery();
			int resultFlag;
			if( resultSet.next() ) {
				resultFlag = resultSet.getInt( 1 );
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					"isSystemUser",
					"Query of sp_is_system_user() did not return a result row" );
			}
			resultSet.close();
			if( resultFlag == 0 ) {
				return( false );
			}
			else {
				return( true );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"isSystemUser",
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

	public boolean isClusterUser( CFSecAuthorization Authorization,
		long clusterId,
		String groupName )
	{
		if( ! inTransaction ) {
			throw new CFLibUsageException( getClass(),
				"isClusterUser",
				"Not in a transaction" );
		}
		ResultSet resultSet = null;
		try {
			final String sql = "SELECT sp_is_cluster_user( ?, ?, ? ) as IsClusterUser FROM sysibm.sysdummy1";
			if( stmtSelectIsClusterUser == null ) {
				stmtSelectIsClusterUser = cnx.prepareStatement( sql );
			}
			stmtSelectIsClusterUser.setLong( 1, clusterId );
			stmtSelectIsClusterUser.setString( 2, groupName );
			stmtSelectIsClusterUser.setString( 3, Authorization.getSecUserId().toString() );
			resultSet = stmtSelectIsClusterUser.executeQuery();
			int resultFlag;
			if( resultSet.next() ) {
				resultFlag = resultSet.getInt( 1 );
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					"isClusterUser",
					"Query of sp_is_cluster_user() did not return a result row" );
			}
			resultSet.close();
			if( resultFlag == 0 ) {
				return( false );
			}
			else {
				return( true );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"isClusterUser",
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

	public boolean isTenantUser( CFSecAuthorization Authorization,
		long tenantId,
		String groupName )
	{
		if( ! inTransaction ) {
			throw new CFLibUsageException( getClass(),
				"isTenantUser",
				"Not in a transaction" );
		}
		ResultSet resultSet = null;
		try {
			final String sql = "SELECT sp_is_tenant_user( ?, ?, ? ) as IsTenantUser FROM sysibm.sysdummy1";
			if( stmtSelectIsTenantUser == null ) {
				stmtSelectIsTenantUser = cnx.prepareStatement( sql );
			}
			stmtSelectIsTenantUser.setLong( 1, tenantId );
			stmtSelectIsTenantUser.setString( 2, groupName );
			stmtSelectIsTenantUser.setString( 3, Authorization.getSecUserId().toString() );
			resultSet = stmtSelectIsTenantUser.executeQuery();
			int resultFlag;
			if( resultSet.next() ) {
				resultFlag = resultSet.getInt( 1 );
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					"isTenantUser",
					"Query of sp_is_tenant_user() did not return a result row" );
			}
			resultSet.close();
			if( resultFlag == 0 ) {
				return( false );
			}
			else {
				return( true );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"isTenantUser",
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

	public short nextISOCcyIdGen() {
		ResultSet resultSet = null;
		if( ! inTransaction ) {
			throw new CFLibUsageException( getClass(),
				"nextISOCcyIdGen",
				"Not in a transaction" );
		}
		try {
			final String sql = "call sf_next_isoccyidgen()";
			if( stmtSelectNextISOCcyIdGen == null ) {
				stmtSelectNextISOCcyIdGen = cnx.prepareStatement( sql );
			}
			resultSet = stmtSelectNextISOCcyIdGen.executeQuery();
			short nextId;
			if( resultSet.next() ) {
				nextId = resultSet.getShort( 1 );
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					"nextISOCcyIdGen",
					"Query of sf_next_isoccyidgen() did not return a result row" );
			}
			resultSet.close();
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"nextISOCcyIdGen",
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

	public short nextISOCtryIdGen() {
		ResultSet resultSet = null;
		if( ! inTransaction ) {
			throw new CFLibUsageException( getClass(),
				"nextISOCtryIdGen",
				"Not in a transaction" );
		}
		try {
			final String sql = "call sf_next_isoctryidgen()";
			if( stmtSelectNextISOCtryIdGen == null ) {
				stmtSelectNextISOCtryIdGen = cnx.prepareStatement( sql );
			}
			resultSet = stmtSelectNextISOCtryIdGen.executeQuery();
			short nextId;
			if( resultSet.next() ) {
				nextId = resultSet.getShort( 1 );
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					"nextISOCtryIdGen",
					"Query of sf_next_isoctryidgen() did not return a result row" );
			}
			resultSet.close();
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"nextISOCtryIdGen",
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

	public short nextISOLangIdGen() {
		ResultSet resultSet = null;
		if( ! inTransaction ) {
			throw new CFLibUsageException( getClass(),
				"nextISOLangIdGen",
				"Not in a transaction" );
		}
		try {
			final String sql = "call sf_next_isolangidgen()";
			if( stmtSelectNextISOLangIdGen == null ) {
				stmtSelectNextISOLangIdGen = cnx.prepareStatement( sql );
			}
			resultSet = stmtSelectNextISOLangIdGen.executeQuery();
			short nextId;
			if( resultSet.next() ) {
				nextId = resultSet.getShort( 1 );
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					"nextISOLangIdGen",
					"Query of sf_next_isolangidgen() did not return a result row" );
			}
			resultSet.close();
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"nextISOLangIdGen",
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

	public short nextISOTZoneIdGen() {
		ResultSet resultSet = null;
		if( ! inTransaction ) {
			throw new CFLibUsageException( getClass(),
				"nextISOTZoneIdGen",
				"Not in a transaction" );
		}
		try {
			final String sql = "call sf_next_isotzoneidgen()";
			if( stmtSelectNextISOTZoneIdGen == null ) {
				stmtSelectNextISOTZoneIdGen = cnx.prepareStatement( sql );
			}
			resultSet = stmtSelectNextISOTZoneIdGen.executeQuery();
			short nextId;
			if( resultSet.next() ) {
				nextId = resultSet.getShort( 1 );
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					"nextISOTZoneIdGen",
					"Query of sf_next_isotzoneidgen() did not return a result row" );
			}
			resultSet.close();
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"nextISOTZoneIdGen",
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

	public int nextServiceTypeIdGen() {
		if( ! inTransaction ) {
			throw new CFLibUsageException( getClass(),
				"nextServiceTypeIdGen",
				"Not in a transaction" );
		}
		ResultSet resultSet = null;
		try {
			final String sql = "call sf_next_servicetypeidgen()";
			if( stmtSelectNextServiceTypeIdGen == null ) {
				stmtSelectNextServiceTypeIdGen = cnx.prepareStatement( sql );
			}
			resultSet = stmtSelectNextServiceTypeIdGen.executeQuery();
			int nextId;
			if( resultSet.next() ) {
				nextId = resultSet.getInt( 1 );
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					"nextServiceTypeIdGen",
					"Query of sf_next_servicetypeidgen() did not return a result row" );
			}
			resultSet.close();
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"nextServiceTypeIdGen",
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

	public int nextMimeTypeIdGen() {
		if( ! inTransaction ) {
			throw new CFLibUsageException( getClass(),
				"nextMimeTypeIdGen",
				"Not in a transaction" );
		}
		ResultSet resultSet = null;
		try {
			final String sql = "call sf_next_mimetypeidgen()";
			if( stmtSelectNextMimeTypeIdGen == null ) {
				stmtSelectNextMimeTypeIdGen = cnx.prepareStatement( sql );
			}
			resultSet = stmtSelectNextMimeTypeIdGen.executeQuery();
			int nextId;
			if( resultSet.next() ) {
				nextId = resultSet.getInt( 1 );
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					"nextMimeTypeIdGen",
					"Query of sf_next_mimetypeidgen() did not return a result row" );
			}
			resultSet.close();
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"nextMimeTypeIdGen",
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

	public int nextURLProtocolIdGen() {
		if( ! inTransaction ) {
			throw new CFLibUsageException( getClass(),
				"nextURLProtocolIdGen",
				"Not in a transaction" );
		}
		ResultSet resultSet = null;
		try {
			final String sql = "call sf_next_urlprotocolidgen()";
			if( stmtSelectNextURLProtocolIdGen == null ) {
				stmtSelectNextURLProtocolIdGen = cnx.prepareStatement( sql );
			}
			resultSet = stmtSelectNextURLProtocolIdGen.executeQuery();
			int nextId;
			if( resultSet.next() ) {
				nextId = resultSet.getInt( 1 );
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					"nextURLProtocolIdGen",
					"Query of sf_next_urlprotocolidgen() did not return a result row" );
			}
			resultSet.close();
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"nextURLProtocolIdGen",
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

	public long nextClusterIdGen() {
		if( ! inTransaction ) {
			throw new CFLibUsageException( getClass(),
				"nextClusterIdGen",
				"Not in a transaction" );
		}
		ResultSet resultSet = null;
		try {
			final String sql = "call sf_next_clusteridgen()";
			if( stmtSelectNextClusterIdGen == null ) {
				stmtSelectNextClusterIdGen = cnx.prepareStatement( sql );
			}
			resultSet = stmtSelectNextClusterIdGen.executeQuery();
			long nextId;
			if( resultSet.next() ) {
				nextId = resultSet.getLong( 1 );
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					"nextClusterIdGen",
					"Query of sf_next_clusteridgen() did not return a result row" );
			}
			resultSet.close();
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"nextClusterIdGen",
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

	public long nextTenantIdGen() {
		if( ! inTransaction ) {
			throw new CFLibUsageException( getClass(),
				"nextTenantIdGen",
				"Not in a transaction" );
		}
		ResultSet resultSet = null;
		try {
			final String sql = "call sf_next_tenantidgen()";
			if( stmtSelectNextTenantIdGen == null ) {
				stmtSelectNextTenantIdGen = cnx.prepareStatement( sql );
			}
			resultSet = stmtSelectNextTenantIdGen.executeQuery();
			long nextId;
			if( resultSet.next() ) {
				nextId = resultSet.getLong( 1 );
			}
			else {
				throw new CFLibRuntimeException( getClass(),
					"nextTenantIdGen",
					"Query of sf_next_tenantidgen() did not return a result row" );
			}
			resultSet.close();
			return( nextId );
		}
		catch( SQLException e ) {
			throw new CFLibDbException( getClass(),
				"nextTenantIdGen",
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

	public UUID nextSecSessionIdGen() {
		UUID retval = UUID.randomUUID();
		return( retval );
	}

	public UUID nextSecUserIdGen() {
		UUID retval = UUID.randomUUID();
		return( retval );
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

		if( stmtSelectNextISOCcyIdGen != null ) {
			try {
				stmtSelectNextISOCcyIdGen.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtSelectNextISOCcyIdGen = null;
		}
		if( stmtSelectNextISOCtryIdGen != null ) {
			try {
				stmtSelectNextISOCtryIdGen.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtSelectNextISOCtryIdGen = null;
		}
		if( stmtSelectNextISOLangIdGen != null ) {
			try {
				stmtSelectNextISOLangIdGen.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtSelectNextISOLangIdGen = null;
		}
		if( stmtSelectNextISOTZoneIdGen != null ) {
			try {
				stmtSelectNextISOTZoneIdGen.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtSelectNextISOTZoneIdGen = null;
		}
		if( stmtSelectNextServiceTypeIdGen != null ) {
			try {
				stmtSelectNextServiceTypeIdGen.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtSelectNextServiceTypeIdGen = null;
		}
		if( stmtSelectNextMimeTypeIdGen != null ) {
			try {
				stmtSelectNextMimeTypeIdGen.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtSelectNextMimeTypeIdGen = null;
		}
		if( stmtSelectNextURLProtocolIdGen != null ) {
			try {
				stmtSelectNextURLProtocolIdGen.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtSelectNextURLProtocolIdGen = null;
		}
		if( stmtSelectNextClusterIdGen != null ) {
			try {
				stmtSelectNextClusterIdGen.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtSelectNextClusterIdGen = null;
		}
		if( stmtSelectNextTenantIdGen != null ) {
			try {
				stmtSelectNextTenantIdGen.close();
			}
			catch( SQLException e ) {
				throw new CFLibDbException( getClass(),
					S_ProcName,
					e );
			}
			stmtSelectNextTenantIdGen = null;
		}

		if( ( tableAtom != null ) && ( tableAtom instanceof CFBamDb2LUWAtomTable ) ) {
			CFBamDb2LUWAtomTable table = (CFBamDb2LUWAtomTable)tableAtom;
			table.releasePreparedStatements();
		}
		if( ( tableBlobCol != null ) && ( tableBlobCol instanceof CFBamDb2LUWBlobColTable ) ) {
			CFBamDb2LUWBlobColTable table = (CFBamDb2LUWBlobColTable)tableBlobCol;
			table.releasePreparedStatements();
		}
		if( ( tableBlobDef != null ) && ( tableBlobDef instanceof CFBamDb2LUWBlobDefTable ) ) {
			CFBamDb2LUWBlobDefTable table = (CFBamDb2LUWBlobDefTable)tableBlobDef;
			table.releasePreparedStatements();
		}
		if( ( tableBlobType != null ) && ( tableBlobType instanceof CFBamDb2LUWBlobTypeTable ) ) {
			CFBamDb2LUWBlobTypeTable table = (CFBamDb2LUWBlobTypeTable)tableBlobType;
			table.releasePreparedStatements();
		}
		if( ( tableBoolCol != null ) && ( tableBoolCol instanceof CFBamDb2LUWBoolColTable ) ) {
			CFBamDb2LUWBoolColTable table = (CFBamDb2LUWBoolColTable)tableBoolCol;
			table.releasePreparedStatements();
		}
		if( ( tableBoolDef != null ) && ( tableBoolDef instanceof CFBamDb2LUWBoolDefTable ) ) {
			CFBamDb2LUWBoolDefTable table = (CFBamDb2LUWBoolDefTable)tableBoolDef;
			table.releasePreparedStatements();
		}
		if( ( tableBoolType != null ) && ( tableBoolType instanceof CFBamDb2LUWBoolTypeTable ) ) {
			CFBamDb2LUWBoolTypeTable table = (CFBamDb2LUWBoolTypeTable)tableBoolType;
			table.releasePreparedStatements();
		}
		if( ( tableChain != null ) && ( tableChain instanceof CFBamDb2LUWChainTable ) ) {
			CFBamDb2LUWChainTable table = (CFBamDb2LUWChainTable)tableChain;
			table.releasePreparedStatements();
		}
		if( ( tableClearDep != null ) && ( tableClearDep instanceof CFBamDb2LUWClearDepTable ) ) {
			CFBamDb2LUWClearDepTable table = (CFBamDb2LUWClearDepTable)tableClearDep;
			table.releasePreparedStatements();
		}
		if( ( tableClearSubDep1 != null ) && ( tableClearSubDep1 instanceof CFBamDb2LUWClearSubDep1Table ) ) {
			CFBamDb2LUWClearSubDep1Table table = (CFBamDb2LUWClearSubDep1Table)tableClearSubDep1;
			table.releasePreparedStatements();
		}
		if( ( tableClearSubDep2 != null ) && ( tableClearSubDep2 instanceof CFBamDb2LUWClearSubDep2Table ) ) {
			CFBamDb2LUWClearSubDep2Table table = (CFBamDb2LUWClearSubDep2Table)tableClearSubDep2;
			table.releasePreparedStatements();
		}
		if( ( tableClearSubDep3 != null ) && ( tableClearSubDep3 instanceof CFBamDb2LUWClearSubDep3Table ) ) {
			CFBamDb2LUWClearSubDep3Table table = (CFBamDb2LUWClearSubDep3Table)tableClearSubDep3;
			table.releasePreparedStatements();
		}
		if( ( tableClearTopDep != null ) && ( tableClearTopDep instanceof CFBamDb2LUWClearTopDepTable ) ) {
			CFBamDb2LUWClearTopDepTable table = (CFBamDb2LUWClearTopDepTable)tableClearTopDep;
			table.releasePreparedStatements();
		}
		if( ( tableCluster != null ) && ( tableCluster instanceof CFBamDb2LUWClusterTable ) ) {
			CFBamDb2LUWClusterTable table = (CFBamDb2LUWClusterTable)tableCluster;
			table.releasePreparedStatements();
		}
		if( ( tableDateCol != null ) && ( tableDateCol instanceof CFBamDb2LUWDateColTable ) ) {
			CFBamDb2LUWDateColTable table = (CFBamDb2LUWDateColTable)tableDateCol;
			table.releasePreparedStatements();
		}
		if( ( tableDateDef != null ) && ( tableDateDef instanceof CFBamDb2LUWDateDefTable ) ) {
			CFBamDb2LUWDateDefTable table = (CFBamDb2LUWDateDefTable)tableDateDef;
			table.releasePreparedStatements();
		}
		if( ( tableDateType != null ) && ( tableDateType instanceof CFBamDb2LUWDateTypeTable ) ) {
			CFBamDb2LUWDateTypeTable table = (CFBamDb2LUWDateTypeTable)tableDateType;
			table.releasePreparedStatements();
		}
		if( ( tableDelDep != null ) && ( tableDelDep instanceof CFBamDb2LUWDelDepTable ) ) {
			CFBamDb2LUWDelDepTable table = (CFBamDb2LUWDelDepTable)tableDelDep;
			table.releasePreparedStatements();
		}
		if( ( tableDelSubDep1 != null ) && ( tableDelSubDep1 instanceof CFBamDb2LUWDelSubDep1Table ) ) {
			CFBamDb2LUWDelSubDep1Table table = (CFBamDb2LUWDelSubDep1Table)tableDelSubDep1;
			table.releasePreparedStatements();
		}
		if( ( tableDelSubDep2 != null ) && ( tableDelSubDep2 instanceof CFBamDb2LUWDelSubDep2Table ) ) {
			CFBamDb2LUWDelSubDep2Table table = (CFBamDb2LUWDelSubDep2Table)tableDelSubDep2;
			table.releasePreparedStatements();
		}
		if( ( tableDelSubDep3 != null ) && ( tableDelSubDep3 instanceof CFBamDb2LUWDelSubDep3Table ) ) {
			CFBamDb2LUWDelSubDep3Table table = (CFBamDb2LUWDelSubDep3Table)tableDelSubDep3;
			table.releasePreparedStatements();
		}
		if( ( tableDelTopDep != null ) && ( tableDelTopDep instanceof CFBamDb2LUWDelTopDepTable ) ) {
			CFBamDb2LUWDelTopDepTable table = (CFBamDb2LUWDelTopDepTable)tableDelTopDep;
			table.releasePreparedStatements();
		}
		if( ( tableDoubleCol != null ) && ( tableDoubleCol instanceof CFBamDb2LUWDoubleColTable ) ) {
			CFBamDb2LUWDoubleColTable table = (CFBamDb2LUWDoubleColTable)tableDoubleCol;
			table.releasePreparedStatements();
		}
		if( ( tableDoubleDef != null ) && ( tableDoubleDef instanceof CFBamDb2LUWDoubleDefTable ) ) {
			CFBamDb2LUWDoubleDefTable table = (CFBamDb2LUWDoubleDefTable)tableDoubleDef;
			table.releasePreparedStatements();
		}
		if( ( tableDoubleType != null ) && ( tableDoubleType instanceof CFBamDb2LUWDoubleTypeTable ) ) {
			CFBamDb2LUWDoubleTypeTable table = (CFBamDb2LUWDoubleTypeTable)tableDoubleType;
			table.releasePreparedStatements();
		}
		if( ( tableEnumDef != null ) && ( tableEnumDef instanceof CFBamDb2LUWEnumDefTable ) ) {
			CFBamDb2LUWEnumDefTable table = (CFBamDb2LUWEnumDefTable)tableEnumDef;
			table.releasePreparedStatements();
		}
		if( ( tableEnumTag != null ) && ( tableEnumTag instanceof CFBamDb2LUWEnumTagTable ) ) {
			CFBamDb2LUWEnumTagTable table = (CFBamDb2LUWEnumTagTable)tableEnumTag;
			table.releasePreparedStatements();
		}
		if( ( tableEnumType != null ) && ( tableEnumType instanceof CFBamDb2LUWEnumTypeTable ) ) {
			CFBamDb2LUWEnumTypeTable table = (CFBamDb2LUWEnumTypeTable)tableEnumType;
			table.releasePreparedStatements();
		}
		if( ( tableFloatCol != null ) && ( tableFloatCol instanceof CFBamDb2LUWFloatColTable ) ) {
			CFBamDb2LUWFloatColTable table = (CFBamDb2LUWFloatColTable)tableFloatCol;
			table.releasePreparedStatements();
		}
		if( ( tableFloatDef != null ) && ( tableFloatDef instanceof CFBamDb2LUWFloatDefTable ) ) {
			CFBamDb2LUWFloatDefTable table = (CFBamDb2LUWFloatDefTable)tableFloatDef;
			table.releasePreparedStatements();
		}
		if( ( tableFloatType != null ) && ( tableFloatType instanceof CFBamDb2LUWFloatTypeTable ) ) {
			CFBamDb2LUWFloatTypeTable table = (CFBamDb2LUWFloatTypeTable)tableFloatType;
			table.releasePreparedStatements();
		}
		if( ( tableHostNode != null ) && ( tableHostNode instanceof CFBamDb2LUWHostNodeTable ) ) {
			CFBamDb2LUWHostNodeTable table = (CFBamDb2LUWHostNodeTable)tableHostNode;
			table.releasePreparedStatements();
		}
		if( ( tableISOCcy != null ) && ( tableISOCcy instanceof CFBamDb2LUWISOCcyTable ) ) {
			CFBamDb2LUWISOCcyTable table = (CFBamDb2LUWISOCcyTable)tableISOCcy;
			table.releasePreparedStatements();
		}
		if( ( tableISOCtry != null ) && ( tableISOCtry instanceof CFBamDb2LUWISOCtryTable ) ) {
			CFBamDb2LUWISOCtryTable table = (CFBamDb2LUWISOCtryTable)tableISOCtry;
			table.releasePreparedStatements();
		}
		if( ( tableISOCtryCcy != null ) && ( tableISOCtryCcy instanceof CFBamDb2LUWISOCtryCcyTable ) ) {
			CFBamDb2LUWISOCtryCcyTable table = (CFBamDb2LUWISOCtryCcyTable)tableISOCtryCcy;
			table.releasePreparedStatements();
		}
		if( ( tableISOCtryLang != null ) && ( tableISOCtryLang instanceof CFBamDb2LUWISOCtryLangTable ) ) {
			CFBamDb2LUWISOCtryLangTable table = (CFBamDb2LUWISOCtryLangTable)tableISOCtryLang;
			table.releasePreparedStatements();
		}
		if( ( tableISOLang != null ) && ( tableISOLang instanceof CFBamDb2LUWISOLangTable ) ) {
			CFBamDb2LUWISOLangTable table = (CFBamDb2LUWISOLangTable)tableISOLang;
			table.releasePreparedStatements();
		}
		if( ( tableISOTZone != null ) && ( tableISOTZone instanceof CFBamDb2LUWISOTZoneTable ) ) {
			CFBamDb2LUWISOTZoneTable table = (CFBamDb2LUWISOTZoneTable)tableISOTZone;
			table.releasePreparedStatements();
		}
		if( ( tableId16Gen != null ) && ( tableId16Gen instanceof CFBamDb2LUWId16GenTable ) ) {
			CFBamDb2LUWId16GenTable table = (CFBamDb2LUWId16GenTable)tableId16Gen;
			table.releasePreparedStatements();
		}
		if( ( tableId32Gen != null ) && ( tableId32Gen instanceof CFBamDb2LUWId32GenTable ) ) {
			CFBamDb2LUWId32GenTable table = (CFBamDb2LUWId32GenTable)tableId32Gen;
			table.releasePreparedStatements();
		}
		if( ( tableId64Gen != null ) && ( tableId64Gen instanceof CFBamDb2LUWId64GenTable ) ) {
			CFBamDb2LUWId64GenTable table = (CFBamDb2LUWId64GenTable)tableId64Gen;
			table.releasePreparedStatements();
		}
		if( ( tableIndex != null ) && ( tableIndex instanceof CFBamDb2LUWIndexTable ) ) {
			CFBamDb2LUWIndexTable table = (CFBamDb2LUWIndexTable)tableIndex;
			table.releasePreparedStatements();
		}
		if( ( tableIndexCol != null ) && ( tableIndexCol instanceof CFBamDb2LUWIndexColTable ) ) {
			CFBamDb2LUWIndexColTable table = (CFBamDb2LUWIndexColTable)tableIndexCol;
			table.releasePreparedStatements();
		}
		if( ( tableInt16Col != null ) && ( tableInt16Col instanceof CFBamDb2LUWInt16ColTable ) ) {
			CFBamDb2LUWInt16ColTable table = (CFBamDb2LUWInt16ColTable)tableInt16Col;
			table.releasePreparedStatements();
		}
		if( ( tableInt16Def != null ) && ( tableInt16Def instanceof CFBamDb2LUWInt16DefTable ) ) {
			CFBamDb2LUWInt16DefTable table = (CFBamDb2LUWInt16DefTable)tableInt16Def;
			table.releasePreparedStatements();
		}
		if( ( tableInt16Type != null ) && ( tableInt16Type instanceof CFBamDb2LUWInt16TypeTable ) ) {
			CFBamDb2LUWInt16TypeTable table = (CFBamDb2LUWInt16TypeTable)tableInt16Type;
			table.releasePreparedStatements();
		}
		if( ( tableInt32Col != null ) && ( tableInt32Col instanceof CFBamDb2LUWInt32ColTable ) ) {
			CFBamDb2LUWInt32ColTable table = (CFBamDb2LUWInt32ColTable)tableInt32Col;
			table.releasePreparedStatements();
		}
		if( ( tableInt32Def != null ) && ( tableInt32Def instanceof CFBamDb2LUWInt32DefTable ) ) {
			CFBamDb2LUWInt32DefTable table = (CFBamDb2LUWInt32DefTable)tableInt32Def;
			table.releasePreparedStatements();
		}
		if( ( tableInt32Type != null ) && ( tableInt32Type instanceof CFBamDb2LUWInt32TypeTable ) ) {
			CFBamDb2LUWInt32TypeTable table = (CFBamDb2LUWInt32TypeTable)tableInt32Type;
			table.releasePreparedStatements();
		}
		if( ( tableInt64Col != null ) && ( tableInt64Col instanceof CFBamDb2LUWInt64ColTable ) ) {
			CFBamDb2LUWInt64ColTable table = (CFBamDb2LUWInt64ColTable)tableInt64Col;
			table.releasePreparedStatements();
		}
		if( ( tableInt64Def != null ) && ( tableInt64Def instanceof CFBamDb2LUWInt64DefTable ) ) {
			CFBamDb2LUWInt64DefTable table = (CFBamDb2LUWInt64DefTable)tableInt64Def;
			table.releasePreparedStatements();
		}
		if( ( tableInt64Type != null ) && ( tableInt64Type instanceof CFBamDb2LUWInt64TypeTable ) ) {
			CFBamDb2LUWInt64TypeTable table = (CFBamDb2LUWInt64TypeTable)tableInt64Type;
			table.releasePreparedStatements();
		}
		if( ( tableMajorVersion != null ) && ( tableMajorVersion instanceof CFBamDb2LUWMajorVersionTable ) ) {
			CFBamDb2LUWMajorVersionTable table = (CFBamDb2LUWMajorVersionTable)tableMajorVersion;
			table.releasePreparedStatements();
		}
		if( ( tableMimeType != null ) && ( tableMimeType instanceof CFBamDb2LUWMimeTypeTable ) ) {
			CFBamDb2LUWMimeTypeTable table = (CFBamDb2LUWMimeTypeTable)tableMimeType;
			table.releasePreparedStatements();
		}
		if( ( tableMinorVersion != null ) && ( tableMinorVersion instanceof CFBamDb2LUWMinorVersionTable ) ) {
			CFBamDb2LUWMinorVersionTable table = (CFBamDb2LUWMinorVersionTable)tableMinorVersion;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokenCol != null ) && ( tableNmTokenCol instanceof CFBamDb2LUWNmTokenColTable ) ) {
			CFBamDb2LUWNmTokenColTable table = (CFBamDb2LUWNmTokenColTable)tableNmTokenCol;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokenDef != null ) && ( tableNmTokenDef instanceof CFBamDb2LUWNmTokenDefTable ) ) {
			CFBamDb2LUWNmTokenDefTable table = (CFBamDb2LUWNmTokenDefTable)tableNmTokenDef;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokenType != null ) && ( tableNmTokenType instanceof CFBamDb2LUWNmTokenTypeTable ) ) {
			CFBamDb2LUWNmTokenTypeTable table = (CFBamDb2LUWNmTokenTypeTable)tableNmTokenType;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokensCol != null ) && ( tableNmTokensCol instanceof CFBamDb2LUWNmTokensColTable ) ) {
			CFBamDb2LUWNmTokensColTable table = (CFBamDb2LUWNmTokensColTable)tableNmTokensCol;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokensDef != null ) && ( tableNmTokensDef instanceof CFBamDb2LUWNmTokensDefTable ) ) {
			CFBamDb2LUWNmTokensDefTable table = (CFBamDb2LUWNmTokensDefTable)tableNmTokensDef;
			table.releasePreparedStatements();
		}
		if( ( tableNmTokensType != null ) && ( tableNmTokensType instanceof CFBamDb2LUWNmTokensTypeTable ) ) {
			CFBamDb2LUWNmTokensTypeTable table = (CFBamDb2LUWNmTokensTypeTable)tableNmTokensType;
			table.releasePreparedStatements();
		}
		if( ( tableNumberCol != null ) && ( tableNumberCol instanceof CFBamDb2LUWNumberColTable ) ) {
			CFBamDb2LUWNumberColTable table = (CFBamDb2LUWNumberColTable)tableNumberCol;
			table.releasePreparedStatements();
		}
		if( ( tableNumberDef != null ) && ( tableNumberDef instanceof CFBamDb2LUWNumberDefTable ) ) {
			CFBamDb2LUWNumberDefTable table = (CFBamDb2LUWNumberDefTable)tableNumberDef;
			table.releasePreparedStatements();
		}
		if( ( tableNumberType != null ) && ( tableNumberType instanceof CFBamDb2LUWNumberTypeTable ) ) {
			CFBamDb2LUWNumberTypeTable table = (CFBamDb2LUWNumberTypeTable)tableNumberType;
			table.releasePreparedStatements();
		}
		if( ( tableParam != null ) && ( tableParam instanceof CFBamDb2LUWParamTable ) ) {
			CFBamDb2LUWParamTable table = (CFBamDb2LUWParamTable)tableParam;
			table.releasePreparedStatements();
		}
		if( ( tablePopDep != null ) && ( tablePopDep instanceof CFBamDb2LUWPopDepTable ) ) {
			CFBamDb2LUWPopDepTable table = (CFBamDb2LUWPopDepTable)tablePopDep;
			table.releasePreparedStatements();
		}
		if( ( tablePopSubDep1 != null ) && ( tablePopSubDep1 instanceof CFBamDb2LUWPopSubDep1Table ) ) {
			CFBamDb2LUWPopSubDep1Table table = (CFBamDb2LUWPopSubDep1Table)tablePopSubDep1;
			table.releasePreparedStatements();
		}
		if( ( tablePopSubDep2 != null ) && ( tablePopSubDep2 instanceof CFBamDb2LUWPopSubDep2Table ) ) {
			CFBamDb2LUWPopSubDep2Table table = (CFBamDb2LUWPopSubDep2Table)tablePopSubDep2;
			table.releasePreparedStatements();
		}
		if( ( tablePopSubDep3 != null ) && ( tablePopSubDep3 instanceof CFBamDb2LUWPopSubDep3Table ) ) {
			CFBamDb2LUWPopSubDep3Table table = (CFBamDb2LUWPopSubDep3Table)tablePopSubDep3;
			table.releasePreparedStatements();
		}
		if( ( tablePopTopDep != null ) && ( tablePopTopDep instanceof CFBamDb2LUWPopTopDepTable ) ) {
			CFBamDb2LUWPopTopDepTable table = (CFBamDb2LUWPopTopDepTable)tablePopTopDep;
			table.releasePreparedStatements();
		}
		if( ( tableRelation != null ) && ( tableRelation instanceof CFBamDb2LUWRelationTable ) ) {
			CFBamDb2LUWRelationTable table = (CFBamDb2LUWRelationTable)tableRelation;
			table.releasePreparedStatements();
		}
		if( ( tableRelationCol != null ) && ( tableRelationCol instanceof CFBamDb2LUWRelationColTable ) ) {
			CFBamDb2LUWRelationColTable table = (CFBamDb2LUWRelationColTable)tableRelationCol;
			table.releasePreparedStatements();
		}
		if( ( tableSchemaDef != null ) && ( tableSchemaDef instanceof CFBamDb2LUWSchemaDefTable ) ) {
			CFBamDb2LUWSchemaDefTable table = (CFBamDb2LUWSchemaDefTable)tableSchemaDef;
			table.releasePreparedStatements();
		}
		if( ( tableSchemaRef != null ) && ( tableSchemaRef instanceof CFBamDb2LUWSchemaRefTable ) ) {
			CFBamDb2LUWSchemaRefTable table = (CFBamDb2LUWSchemaRefTable)tableSchemaRef;
			table.releasePreparedStatements();
		}
		if( ( tableScope != null ) && ( tableScope instanceof CFBamDb2LUWScopeTable ) ) {
			CFBamDb2LUWScopeTable table = (CFBamDb2LUWScopeTable)tableScope;
			table.releasePreparedStatements();
		}
		if( ( tableSecApp != null ) && ( tableSecApp instanceof CFBamDb2LUWSecAppTable ) ) {
			CFBamDb2LUWSecAppTable table = (CFBamDb2LUWSecAppTable)tableSecApp;
			table.releasePreparedStatements();
		}
		if( ( tableSecDevice != null ) && ( tableSecDevice instanceof CFBamDb2LUWSecDeviceTable ) ) {
			CFBamDb2LUWSecDeviceTable table = (CFBamDb2LUWSecDeviceTable)tableSecDevice;
			table.releasePreparedStatements();
		}
		if( ( tableSecForm != null ) && ( tableSecForm instanceof CFBamDb2LUWSecFormTable ) ) {
			CFBamDb2LUWSecFormTable table = (CFBamDb2LUWSecFormTable)tableSecForm;
			table.releasePreparedStatements();
		}
		if( ( tableSecGroup != null ) && ( tableSecGroup instanceof CFBamDb2LUWSecGroupTable ) ) {
			CFBamDb2LUWSecGroupTable table = (CFBamDb2LUWSecGroupTable)tableSecGroup;
			table.releasePreparedStatements();
		}
		if( ( tableSecGroupForm != null ) && ( tableSecGroupForm instanceof CFBamDb2LUWSecGroupFormTable ) ) {
			CFBamDb2LUWSecGroupFormTable table = (CFBamDb2LUWSecGroupFormTable)tableSecGroupForm;
			table.releasePreparedStatements();
		}
		if( ( tableSecGrpInc != null ) && ( tableSecGrpInc instanceof CFBamDb2LUWSecGrpIncTable ) ) {
			CFBamDb2LUWSecGrpIncTable table = (CFBamDb2LUWSecGrpIncTable)tableSecGrpInc;
			table.releasePreparedStatements();
		}
		if( ( tableSecGrpMemb != null ) && ( tableSecGrpMemb instanceof CFBamDb2LUWSecGrpMembTable ) ) {
			CFBamDb2LUWSecGrpMembTable table = (CFBamDb2LUWSecGrpMembTable)tableSecGrpMemb;
			table.releasePreparedStatements();
		}
		if( ( tableSecSession != null ) && ( tableSecSession instanceof CFBamDb2LUWSecSessionTable ) ) {
			CFBamDb2LUWSecSessionTable table = (CFBamDb2LUWSecSessionTable)tableSecSession;
			table.releasePreparedStatements();
		}
		if( ( tableSecUser != null ) && ( tableSecUser instanceof CFBamDb2LUWSecUserTable ) ) {
			CFBamDb2LUWSecUserTable table = (CFBamDb2LUWSecUserTable)tableSecUser;
			table.releasePreparedStatements();
		}
		if( ( tableServerListFunc != null ) && ( tableServerListFunc instanceof CFBamDb2LUWServerListFuncTable ) ) {
			CFBamDb2LUWServerListFuncTable table = (CFBamDb2LUWServerListFuncTable)tableServerListFunc;
			table.releasePreparedStatements();
		}
		if( ( tableServerMethod != null ) && ( tableServerMethod instanceof CFBamDb2LUWServerMethodTable ) ) {
			CFBamDb2LUWServerMethodTable table = (CFBamDb2LUWServerMethodTable)tableServerMethod;
			table.releasePreparedStatements();
		}
		if( ( tableServerObjFunc != null ) && ( tableServerObjFunc instanceof CFBamDb2LUWServerObjFuncTable ) ) {
			CFBamDb2LUWServerObjFuncTable table = (CFBamDb2LUWServerObjFuncTable)tableServerObjFunc;
			table.releasePreparedStatements();
		}
		if( ( tableServerProc != null ) && ( tableServerProc instanceof CFBamDb2LUWServerProcTable ) ) {
			CFBamDb2LUWServerProcTable table = (CFBamDb2LUWServerProcTable)tableServerProc;
			table.releasePreparedStatements();
		}
		if( ( tableService != null ) && ( tableService instanceof CFBamDb2LUWServiceTable ) ) {
			CFBamDb2LUWServiceTable table = (CFBamDb2LUWServiceTable)tableService;
			table.releasePreparedStatements();
		}
		if( ( tableServiceType != null ) && ( tableServiceType instanceof CFBamDb2LUWServiceTypeTable ) ) {
			CFBamDb2LUWServiceTypeTable table = (CFBamDb2LUWServiceTypeTable)tableServiceType;
			table.releasePreparedStatements();
		}
		if( ( tableStringCol != null ) && ( tableStringCol instanceof CFBamDb2LUWStringColTable ) ) {
			CFBamDb2LUWStringColTable table = (CFBamDb2LUWStringColTable)tableStringCol;
			table.releasePreparedStatements();
		}
		if( ( tableStringDef != null ) && ( tableStringDef instanceof CFBamDb2LUWStringDefTable ) ) {
			CFBamDb2LUWStringDefTable table = (CFBamDb2LUWStringDefTable)tableStringDef;
			table.releasePreparedStatements();
		}
		if( ( tableStringType != null ) && ( tableStringType instanceof CFBamDb2LUWStringTypeTable ) ) {
			CFBamDb2LUWStringTypeTable table = (CFBamDb2LUWStringTypeTable)tableStringType;
			table.releasePreparedStatements();
		}
		if( ( tableSubProject != null ) && ( tableSubProject instanceof CFBamDb2LUWSubProjectTable ) ) {
			CFBamDb2LUWSubProjectTable table = (CFBamDb2LUWSubProjectTable)tableSubProject;
			table.releasePreparedStatements();
		}
		if( ( tableSysCluster != null ) && ( tableSysCluster instanceof CFBamDb2LUWSysClusterTable ) ) {
			CFBamDb2LUWSysClusterTable table = (CFBamDb2LUWSysClusterTable)tableSysCluster;
			table.releasePreparedStatements();
		}
		if( ( tableTSecGroup != null ) && ( tableTSecGroup instanceof CFBamDb2LUWTSecGroupTable ) ) {
			CFBamDb2LUWTSecGroupTable table = (CFBamDb2LUWTSecGroupTable)tableTSecGroup;
			table.releasePreparedStatements();
		}
		if( ( tableTSecGrpInc != null ) && ( tableTSecGrpInc instanceof CFBamDb2LUWTSecGrpIncTable ) ) {
			CFBamDb2LUWTSecGrpIncTable table = (CFBamDb2LUWTSecGrpIncTable)tableTSecGrpInc;
			table.releasePreparedStatements();
		}
		if( ( tableTSecGrpMemb != null ) && ( tableTSecGrpMemb instanceof CFBamDb2LUWTSecGrpMembTable ) ) {
			CFBamDb2LUWTSecGrpMembTable table = (CFBamDb2LUWTSecGrpMembTable)tableTSecGrpMemb;
			table.releasePreparedStatements();
		}
		if( ( tableTZDateCol != null ) && ( tableTZDateCol instanceof CFBamDb2LUWTZDateColTable ) ) {
			CFBamDb2LUWTZDateColTable table = (CFBamDb2LUWTZDateColTable)tableTZDateCol;
			table.releasePreparedStatements();
		}
		if( ( tableTZDateDef != null ) && ( tableTZDateDef instanceof CFBamDb2LUWTZDateDefTable ) ) {
			CFBamDb2LUWTZDateDefTable table = (CFBamDb2LUWTZDateDefTable)tableTZDateDef;
			table.releasePreparedStatements();
		}
		if( ( tableTZDateType != null ) && ( tableTZDateType instanceof CFBamDb2LUWTZDateTypeTable ) ) {
			CFBamDb2LUWTZDateTypeTable table = (CFBamDb2LUWTZDateTypeTable)tableTZDateType;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimeCol != null ) && ( tableTZTimeCol instanceof CFBamDb2LUWTZTimeColTable ) ) {
			CFBamDb2LUWTZTimeColTable table = (CFBamDb2LUWTZTimeColTable)tableTZTimeCol;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimeDef != null ) && ( tableTZTimeDef instanceof CFBamDb2LUWTZTimeDefTable ) ) {
			CFBamDb2LUWTZTimeDefTable table = (CFBamDb2LUWTZTimeDefTable)tableTZTimeDef;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimeType != null ) && ( tableTZTimeType instanceof CFBamDb2LUWTZTimeTypeTable ) ) {
			CFBamDb2LUWTZTimeTypeTable table = (CFBamDb2LUWTZTimeTypeTable)tableTZTimeType;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimestampCol != null ) && ( tableTZTimestampCol instanceof CFBamDb2LUWTZTimestampColTable ) ) {
			CFBamDb2LUWTZTimestampColTable table = (CFBamDb2LUWTZTimestampColTable)tableTZTimestampCol;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimestampDef != null ) && ( tableTZTimestampDef instanceof CFBamDb2LUWTZTimestampDefTable ) ) {
			CFBamDb2LUWTZTimestampDefTable table = (CFBamDb2LUWTZTimestampDefTable)tableTZTimestampDef;
			table.releasePreparedStatements();
		}
		if( ( tableTZTimestampType != null ) && ( tableTZTimestampType instanceof CFBamDb2LUWTZTimestampTypeTable ) ) {
			CFBamDb2LUWTZTimestampTypeTable table = (CFBamDb2LUWTZTimestampTypeTable)tableTZTimestampType;
			table.releasePreparedStatements();
		}
		if( ( tableTable != null ) && ( tableTable instanceof CFBamDb2LUWTableTable ) ) {
			CFBamDb2LUWTableTable table = (CFBamDb2LUWTableTable)tableTable;
			table.releasePreparedStatements();
		}
		if( ( tableTableCol != null ) && ( tableTableCol instanceof CFBamDb2LUWTableColTable ) ) {
			CFBamDb2LUWTableColTable table = (CFBamDb2LUWTableColTable)tableTableCol;
			table.releasePreparedStatements();
		}
		if( ( tableTenant != null ) && ( tableTenant instanceof CFBamDb2LUWTenantTable ) ) {
			CFBamDb2LUWTenantTable table = (CFBamDb2LUWTenantTable)tableTenant;
			table.releasePreparedStatements();
		}
		if( ( tableTextCol != null ) && ( tableTextCol instanceof CFBamDb2LUWTextColTable ) ) {
			CFBamDb2LUWTextColTable table = (CFBamDb2LUWTextColTable)tableTextCol;
			table.releasePreparedStatements();
		}
		if( ( tableTextDef != null ) && ( tableTextDef instanceof CFBamDb2LUWTextDefTable ) ) {
			CFBamDb2LUWTextDefTable table = (CFBamDb2LUWTextDefTable)tableTextDef;
			table.releasePreparedStatements();
		}
		if( ( tableTextType != null ) && ( tableTextType instanceof CFBamDb2LUWTextTypeTable ) ) {
			CFBamDb2LUWTextTypeTable table = (CFBamDb2LUWTextTypeTable)tableTextType;
			table.releasePreparedStatements();
		}
		if( ( tableTimeCol != null ) && ( tableTimeCol instanceof CFBamDb2LUWTimeColTable ) ) {
			CFBamDb2LUWTimeColTable table = (CFBamDb2LUWTimeColTable)tableTimeCol;
			table.releasePreparedStatements();
		}
		if( ( tableTimeDef != null ) && ( tableTimeDef instanceof CFBamDb2LUWTimeDefTable ) ) {
			CFBamDb2LUWTimeDefTable table = (CFBamDb2LUWTimeDefTable)tableTimeDef;
			table.releasePreparedStatements();
		}
		if( ( tableTimeType != null ) && ( tableTimeType instanceof CFBamDb2LUWTimeTypeTable ) ) {
			CFBamDb2LUWTimeTypeTable table = (CFBamDb2LUWTimeTypeTable)tableTimeType;
			table.releasePreparedStatements();
		}
		if( ( tableTimestampCol != null ) && ( tableTimestampCol instanceof CFBamDb2LUWTimestampColTable ) ) {
			CFBamDb2LUWTimestampColTable table = (CFBamDb2LUWTimestampColTable)tableTimestampCol;
			table.releasePreparedStatements();
		}
		if( ( tableTimestampDef != null ) && ( tableTimestampDef instanceof CFBamDb2LUWTimestampDefTable ) ) {
			CFBamDb2LUWTimestampDefTable table = (CFBamDb2LUWTimestampDefTable)tableTimestampDef;
			table.releasePreparedStatements();
		}
		if( ( tableTimestampType != null ) && ( tableTimestampType instanceof CFBamDb2LUWTimestampTypeTable ) ) {
			CFBamDb2LUWTimestampTypeTable table = (CFBamDb2LUWTimestampTypeTable)tableTimestampType;
			table.releasePreparedStatements();
		}
		if( ( tableTld != null ) && ( tableTld instanceof CFBamDb2LUWTldTable ) ) {
			CFBamDb2LUWTldTable table = (CFBamDb2LUWTldTable)tableTld;
			table.releasePreparedStatements();
		}
		if( ( tableTokenCol != null ) && ( tableTokenCol instanceof CFBamDb2LUWTokenColTable ) ) {
			CFBamDb2LUWTokenColTable table = (CFBamDb2LUWTokenColTable)tableTokenCol;
			table.releasePreparedStatements();
		}
		if( ( tableTokenDef != null ) && ( tableTokenDef instanceof CFBamDb2LUWTokenDefTable ) ) {
			CFBamDb2LUWTokenDefTable table = (CFBamDb2LUWTokenDefTable)tableTokenDef;
			table.releasePreparedStatements();
		}
		if( ( tableTokenType != null ) && ( tableTokenType instanceof CFBamDb2LUWTokenTypeTable ) ) {
			CFBamDb2LUWTokenTypeTable table = (CFBamDb2LUWTokenTypeTable)tableTokenType;
			table.releasePreparedStatements();
		}
		if( ( tableTopDomain != null ) && ( tableTopDomain instanceof CFBamDb2LUWTopDomainTable ) ) {
			CFBamDb2LUWTopDomainTable table = (CFBamDb2LUWTopDomainTable)tableTopDomain;
			table.releasePreparedStatements();
		}
		if( ( tableTopProject != null ) && ( tableTopProject instanceof CFBamDb2LUWTopProjectTable ) ) {
			CFBamDb2LUWTopProjectTable table = (CFBamDb2LUWTopProjectTable)tableTopProject;
			table.releasePreparedStatements();
		}
		if( ( tableUInt16Col != null ) && ( tableUInt16Col instanceof CFBamDb2LUWUInt16ColTable ) ) {
			CFBamDb2LUWUInt16ColTable table = (CFBamDb2LUWUInt16ColTable)tableUInt16Col;
			table.releasePreparedStatements();
		}
		if( ( tableUInt16Def != null ) && ( tableUInt16Def instanceof CFBamDb2LUWUInt16DefTable ) ) {
			CFBamDb2LUWUInt16DefTable table = (CFBamDb2LUWUInt16DefTable)tableUInt16Def;
			table.releasePreparedStatements();
		}
		if( ( tableUInt16Type != null ) && ( tableUInt16Type instanceof CFBamDb2LUWUInt16TypeTable ) ) {
			CFBamDb2LUWUInt16TypeTable table = (CFBamDb2LUWUInt16TypeTable)tableUInt16Type;
			table.releasePreparedStatements();
		}
		if( ( tableUInt32Col != null ) && ( tableUInt32Col instanceof CFBamDb2LUWUInt32ColTable ) ) {
			CFBamDb2LUWUInt32ColTable table = (CFBamDb2LUWUInt32ColTable)tableUInt32Col;
			table.releasePreparedStatements();
		}
		if( ( tableUInt32Def != null ) && ( tableUInt32Def instanceof CFBamDb2LUWUInt32DefTable ) ) {
			CFBamDb2LUWUInt32DefTable table = (CFBamDb2LUWUInt32DefTable)tableUInt32Def;
			table.releasePreparedStatements();
		}
		if( ( tableUInt32Type != null ) && ( tableUInt32Type instanceof CFBamDb2LUWUInt32TypeTable ) ) {
			CFBamDb2LUWUInt32TypeTable table = (CFBamDb2LUWUInt32TypeTable)tableUInt32Type;
			table.releasePreparedStatements();
		}
		if( ( tableUInt64Col != null ) && ( tableUInt64Col instanceof CFBamDb2LUWUInt64ColTable ) ) {
			CFBamDb2LUWUInt64ColTable table = (CFBamDb2LUWUInt64ColTable)tableUInt64Col;
			table.releasePreparedStatements();
		}
		if( ( tableUInt64Def != null ) && ( tableUInt64Def instanceof CFBamDb2LUWUInt64DefTable ) ) {
			CFBamDb2LUWUInt64DefTable table = (CFBamDb2LUWUInt64DefTable)tableUInt64Def;
			table.releasePreparedStatements();
		}
		if( ( tableUInt64Type != null ) && ( tableUInt64Type instanceof CFBamDb2LUWUInt64TypeTable ) ) {
			CFBamDb2LUWUInt64TypeTable table = (CFBamDb2LUWUInt64TypeTable)tableUInt64Type;
			table.releasePreparedStatements();
		}
		if( ( tableURLProtocol != null ) && ( tableURLProtocol instanceof CFBamDb2LUWURLProtocolTable ) ) {
			CFBamDb2LUWURLProtocolTable table = (CFBamDb2LUWURLProtocolTable)tableURLProtocol;
			table.releasePreparedStatements();
		}
		if( ( tableUuidCol != null ) && ( tableUuidCol instanceof CFBamDb2LUWUuidColTable ) ) {
			CFBamDb2LUWUuidColTable table = (CFBamDb2LUWUuidColTable)tableUuidCol;
			table.releasePreparedStatements();
		}
		if( ( tableUuidDef != null ) && ( tableUuidDef instanceof CFBamDb2LUWUuidDefTable ) ) {
			CFBamDb2LUWUuidDefTable table = (CFBamDb2LUWUuidDefTable)tableUuidDef;
			table.releasePreparedStatements();
		}
		if( ( tableUuidGen != null ) && ( tableUuidGen instanceof CFBamDb2LUWUuidGenTable ) ) {
			CFBamDb2LUWUuidGenTable table = (CFBamDb2LUWUuidGenTable)tableUuidGen;
			table.releasePreparedStatements();
		}
		if( ( tableUuidType != null ) && ( tableUuidType instanceof CFBamDb2LUWUuidTypeTable ) ) {
			CFBamDb2LUWUuidTypeTable table = (CFBamDb2LUWUuidTypeTable)tableUuidType;
			table.releasePreparedStatements();
		}
		if( ( tableValue != null ) && ( tableValue instanceof CFBamDb2LUWValueTable ) ) {
			CFBamDb2LUWValueTable table = (CFBamDb2LUWValueTable)tableValue;
			table.releasePreparedStatements();
		}
	}

	public static String getQuotedString(String val) {
		if (val == null) {
			return ("null");
		}
		else {
			char c;
			StringBuilder quoted = new StringBuilder();
			quoted.append( "'" );
			int len = val.length();
			for (int i = 0; i < len; i++)
			{
				if (val.charAt( i ) == '\'')
				{
					quoted.append("''");
				}
				else if (val.charAt( i ) == '\\') {
					quoted.append("'||E'\\\\'||'");
				}
				else {
					c = val.charAt( i );
					if (   ( c == '0' )
						|| ( c == '1' )
						|| ( c == '2' )
						|| ( c == '3' )
						|| ( c == '4' )
						|| ( c == '5' )
						|| ( c == '6' )
						|| ( c == '7' )
						|| ( c == '8' )
						|| ( c == '9' )
						|| ( c == 'a' )
						|| ( c == 'b' )
						|| ( c == 'c' )
						|| ( c == 'd' )
						|| ( c == 'e' )
						|| ( c == 'f' )
						|| ( c == 'g' )
						|| ( c == 'h' )
						|| ( c == 'i' )
						|| ( c == 'j' )
						|| ( c == 'k' )
						|| ( c == 'l' )
						|| ( c == 'm' )
						|| ( c == 'n' )
						|| ( c == 'o' )
						|| ( c == 'p' )
						|| ( c == 'q' )
						|| ( c == 'r' )
						|| ( c == 's' )
						|| ( c == 't' )
						|| ( c == 'u' )
						|| ( c == 'v' )
						|| ( c == 'w' )
						|| ( c == 'x' )
						|| ( c == 'y' )
						|| ( c == 'z' )
						|| ( c == 'A' )
						|| ( c == 'B' )
						|| ( c == 'C' )
						|| ( c == 'D' )
						|| ( c == 'E' )
						|| ( c == 'F' )
						|| ( c == 'G' )
						|| ( c == 'H' )
						|| ( c == 'I' )
						|| ( c == 'J' )
						|| ( c == 'K' )
						|| ( c == 'L' )
						|| ( c == 'M' )
						|| ( c == 'N' )
						|| ( c == 'O' )
						|| ( c == 'P' )
						|| ( c == 'Q' )
						|| ( c == 'R' )
						|| ( c == 'S' )
						|| ( c == 'T' )
						|| ( c == 'U' )
						|| ( c == 'V' )
						|| ( c == 'W' )
						|| ( c == 'X' )
						|| ( c == 'Y' )
						|| ( c == 'Z' )
						|| ( c == ' ' )
						|| ( c == '\t' )
						|| ( c == '\r' )
						|| ( c == '\n' )
						|| ( c == '`' )
						|| ( c == '~' )
						|| ( c == '!' )
						|| ( c == '@' )
						|| ( c == '#' )
						|| ( c == '$' )
						|| ( c == '%' )
						|| ( c == '^' )
						|| ( c == '&' )
						|| ( c == '*' )
						|| ( c == '(' )
						|| ( c == ')' )
						|| ( c == '-' )
						|| ( c == '_' )
						|| ( c == '=' )
						|| ( c == '+' )
						|| ( c == '[' )
						|| ( c == ']' )
						|| ( c == '{' )
						|| ( c == '}' )
						|| ( c == '|' )
						|| ( c == ';' )
						|| ( c == ':' )
						|| ( c == '"' )
						|| ( c == '<' )
						|| ( c == '>' )
						|| ( c == ',' )
						|| ( c == '.' )
						|| ( c == '/' )
						|| ( c == '?' ))
					{
						quoted.append(c);
					}
					else {
//						Syslog.warn("\t\t\tReplacing invalid character '" + c + "' with space");
						quoted.append( ' ' );
					}
				}
			}
			quoted.append( "'" );
			return (quoted.toString());
			}
		}

	public static String getNullableString(ResultSet reader, int colidx) {
		try {
			String val = reader.getString( colidx );
			if( reader.wasNull() ) {
				return(null);
			}
			else {
				return( val );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( CFBamDb2LUWSchema.class,
				"getNullableString",
				e );
		}
	}

	public static String getBlobString(byte[] val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( "'" + new String( Base64.encodeBase64( val ) ) + "'" );
		}
	}

	public static String getBoolString(Boolean val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			if( val ) {
				return( "'Y'" );
			}
			else {
				return( "'N'" );
			}
		}
	}

	public static String getBoolString(boolean val) {
		if( val ) {
			return( "'Y'" );
		}
		else {
			return( "'N'" );
		}
	}

	public static String getInt16String(Short val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static String getInt16String(short val) {
		return( Short.toString( val ) );
	}

	public static String getInt32String(Integer val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static String getInt32String(int val) {
		return( Integer.toString( val ) );
	}

	public static String getInt64String(Long val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static String getInt64String(long val) {
		return( Long.toString( val ) );
	}

	public static String getUInt16String(Integer val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static String getUInt16String(int val) {
		return( Integer.toString( val ) );
	}

	public static String getUInt32String(Long val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static String getUInt32String(long val) {
		return( Long.toString( val ) );
	}

	public static String getUInt64String(BigDecimal val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static String getFloatString(Float val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static String getFloatString(float val) {
		return( Float.toString( val ) );
	}

	public static String getDoubleString(Double val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static String getDoubleString(double val) {
		return( Double.toString( val ) );
	}

	public static String getNumberString(BigDecimal val) {
		if( val == null ) {
			return( "null" );
		}
		else {
			return( val.toString() );
		}
	}

	public static Integer getNullableInt32(ResultSet reader, int colidx) {
		try {
			int val = reader.getInt( colidx );
			if( reader.wasNull() ) {
				return(null);
			}
			else {
				return( Integer.valueOf( val ) );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( CFBamDb2LUWSchema.class,
				"getNullableInt32",
				e );
		}
	}

	public static Short getNullableInt16(ResultSet reader, int colidx) {
		try {
			short val = reader.getShort( colidx );
			if( reader.wasNull() ) {
				return(null);
			}
			else {
				return( Short.valueOf( val ) );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( CFBamDb2LUWSchema.class,
				"getNullableInt64",
				e );
		}
	}

	public static Integer getNullableUInt16(ResultSet reader, int colidx) {
		try {
			int val = reader.getInt( colidx );
			if( reader.wasNull() ) {
				return(null);
			}
			else {
				return( Integer.valueOf( val ) );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( CFBamDb2LUWSchema.class,
				"getNullableUInt16",
				e );
		}
	}

	public static Long getNullableUInt32(ResultSet reader, int colidx) {
		try {
			long val = reader.getLong( colidx );
			if( reader.wasNull() ) {
				return(null);
			}
			else {
				return( Long.valueOf( val ) );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( CFBamDb2LUWSchema.class,
				"getNullableUInt32",
				e );
		}
	}

	public static BigDecimal getNullableUInt64(ResultSet reader, int colidx) {
		try {
			String strval = reader.getString( colidx );
			if( reader.wasNull() || ( strval == null ) || ( strval.length() <=0 ) ) {
				return(null);
			}
			else {
				BigDecimal retval = new BigDecimal( strval );
				return( retval );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( CFBamDb2LUWSchema.class,
				"getNullableUInt64",
				e );
		}
	}

	public static Byte getNullableByte(ResultSet reader, int colidx) {
		try {
			byte val = reader.getByte( colidx );
			if( reader.wasNull() ) {
				return(null);
			}
			else {
				return( Byte.valueOf( val ) );
			}
		}
		catch( SQLException e ) {
			throw new CFLibDbException( CFBamDb2LUWSchema.class,
				"getNullableByte",
				e );
		}
	}

	public static String getQuotedDateString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			StringBuffer buff = new StringBuffer( "'" );
			Formatter fmt = new Formatter( buff );
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( "'" );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getQuotedTimeString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			StringBuffer buff = new StringBuffer( "'" );
			Formatter fmt = new Formatter( buff );
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( "." );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( "." );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			buff.append( "'" );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getQuotedTimestampString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			StringBuffer buff = new StringBuffer( "'" );
			Formatter fmt = new Formatter( buff );
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( "." );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( "." );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			buff.append( "'" );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getQuotedTZDateString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			StringBuffer buff = new StringBuffer( "'" );
			Formatter fmt = new Formatter( buff );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( "." );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( "." );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			buff.append( "'" );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getQuotedTZTimeString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			StringBuffer buff = new StringBuffer( "'" );
			Formatter fmt = new Formatter( buff );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( "." );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( "." );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			buff.append( "'" );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getQuotedTZTimestampString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			StringBuffer buff = new StringBuffer( "'" );
			Formatter fmt = new Formatter( buff );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( "." );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( "." );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			buff.append( "'" );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getDateString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			StringBuffer buff = new StringBuffer();
			Formatter fmt = new Formatter( buff );
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getTimeString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			StringBuffer buff = new StringBuffer();
			Formatter fmt = new Formatter( buff );
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( "." );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( "." );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getTimestampString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			StringBuffer buff = new StringBuffer();
			Formatter fmt = new Formatter( buff );
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( "." );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( "." );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getTZDateString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			StringBuffer buff = new StringBuffer();
			Formatter fmt = new Formatter( buff );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( "." );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( "." );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getTZTimeString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			StringBuffer buff = new StringBuffer();
			Formatter fmt = new Formatter( buff );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( "." );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( "." );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getTZTimestampString(Calendar val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			Calendar db = CFLibDbUtil.getDbServerCalendar( val );
			StringBuffer buff = new StringBuffer();
			Formatter fmt = new Formatter( buff );
			fmt.format( "%1$04d", db.get( Calendar.YEAR ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.MONTH ) + 1 );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.DAY_OF_MONTH ) );
			buff.append( "-" );
			fmt.format( "%1$02d", db.get( Calendar.HOUR_OF_DAY ) );
			buff.append( "." );
			fmt.format( "%1$02d", db.get( Calendar.MINUTE ) );
			buff.append( "." );
			fmt.format( "%1$02d", db.get( Calendar.SECOND ) );
			fmt.close();
			return( buff.toString() );
		}
	}

	public static String getUuidString(UUID val) {
		if ( val == null ) {
			return ("null");
		}
		else {
			return( "'" + val.toString() + "'" );
		}
	}

	public static Calendar convertDateString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
		else if ( val.length() != 10 ) {
			throw new CFLibUsageException( CFBamDb2LUWSchema.class,
				"convertDateString",
				"Value must be in YYYY-MM-DD format, \"" + val + "\" is invalid" );
		}
		else if (((val.charAt( 0 ) >= '0') && (val.charAt( 0 ) <= '9'))
			 && ((val.charAt( 1 ) >= '0') && (val.charAt( 1 ) <= '9'))
			 && ((val.charAt( 2 ) >= '0') && (val.charAt( 2 ) <= '9'))
			 && ((val.charAt( 3 ) >= '0') && (val.charAt( 3 ) <= '9'))
			 && (val.charAt( 4 ) == '-')
			 && ((val.charAt( 5 ) >= '0') && (val.charAt( 5 ) <= '1'))
			 && ((val.charAt( 6 ) >= '0') && (val.charAt( 6 ) <= '9'))
			 && (val.charAt( 7 ) == '-' )
			 && ((val.charAt( 8 ) >= '0') && (val.charAt( 8 ) <= '3'))
			 && ((val.charAt( 9 ) >= '0') && (val.charAt( 9 ) <= '9')) )
		{
			/*
			 *	NOTE:
			 *		.Net uses substring( startcol, lengthOfSubstring )
			 *		Java uses substring( startcol, endcol ) and does not
			 *			include charAt( endcol );
			 */
			int year = Integer.parseInt( val.substring( 0, 4 ) );
			int month = Integer.parseInt( val.substring( 5, 7 ) );
			int day = Integer.parseInt( val.substring( 8, 10 ) );
			Calendar retval = new GregorianCalendar( CFLibDbUtil.getDbServerTimeZone() );
			retval.set( Calendar.YEAR, year );
			retval.set( Calendar.MONTH, month - 1 );
			retval.set( Calendar.DAY_OF_MONTH, day );
			retval.set( Calendar.HOUR_OF_DAY, 0 );
			retval.set( Calendar.MINUTE, 0 );
			retval.set( Calendar.SECOND, 0 );
			Calendar local = new GregorianCalendar();
			local.setTimeInMillis( retval.getTimeInMillis() );
			return( local );
		}
		else {
			throw new CFLibUsageException( CFBamDb2LUWSchema.class,
				"convertDateString",
				"Value must be in YYYY-MM-DD format, \"" + val + "\" is invalid" );
		}
	}
	public static Calendar convertTimeString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
		else if ( val.length() != 8 ) {
			throw new CFLibUsageException( CFBamDb2LUWSchema.class,
				"convertTimeString",
				"Value must be in HH24.MI.SS format, \"" + val + "\" is invalid" );
		}
		else if (((val.charAt( 0 ) >= '0') && (val.charAt( 0 ) <= '2'))
			 && ((val.charAt( 1 ) >= '0') && (val.charAt( 1 ) <= '9'))
			 && (val.charAt( 2 ) == '.')
			 && ((val.charAt( 3 ) >= '0') && (val.charAt( 3 ) <= '5'))
			 && ((val.charAt( 4 ) >= '0') && (val.charAt( 4 ) <= '9'))
			 && (val.charAt( 5 ) == '.')
			 && ((val.charAt( 6 ) >= '0') && (val.charAt( 6 ) <= '5'))
			 && ((val.charAt( 7 ) >= '0') && (val.charAt( 7 ) <= '9')) )
		{
			/*
			 *	NOTE:
			 *		.Net uses substring( startcol, lengthOfSubstring )
			 *		Java uses substring( startcol, endcol ) and does not
			 *			include charAt( endcol );
			 */
			int hour = Integer.parseInt( val.substring( 0, 2 ) );
			int minute = Integer.parseInt( val.substring( 3, 5 ) );
			int second = Integer.parseInt( val.substring( 6, 8 ) );
			Calendar retval = new GregorianCalendar( CFLibDbUtil.getDbServerTimeZone() );
			retval.set( Calendar.YEAR, 2000 );
			retval.set( Calendar.MONTH, 0 );
			retval.set( Calendar.DAY_OF_MONTH, 1 );
			retval.set( Calendar.HOUR_OF_DAY, hour );
			retval.set( Calendar.MINUTE, minute );
			retval.set( Calendar.SECOND, second );
			Calendar local = new GregorianCalendar();
			local.setTimeInMillis( retval.getTimeInMillis() );
			return( local );
		}
		else {
			throw new CFLibUsageException( CFBamDb2LUWSchema.class,
				"convertTimeString",
				"Value must be in HH24.MI.SS format \"" + val + "\" is invalid" );
		}
	}
	public static Calendar convertTimestampString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
		else if ( val.length() != 19 ) {
			throw new CFLibUsageException( CFBamDb2LUWSchema.class,
				"convertTimestampString",
				"Value must be in YYYY-MM-DD-HH24.MI.SS format \"" + val + "\" is invalid" );
		}
		else if (((val.charAt( 0 ) >= '0') && (val.charAt( 0 ) <= '9'))
			 && ((val.charAt( 1 ) >= '0') && (val.charAt( 1 ) <= '9'))
			 && ((val.charAt( 2 ) >= '0') && (val.charAt( 2 ) <= '9'))
			 && ((val.charAt( 3 ) >= '0') && (val.charAt( 3 ) <= '9'))
			 && (val.charAt( 4 ) == '-')
			 && ((val.charAt( 5 ) >= '0') && (val.charAt( 5 ) <= '1'))
			 && ((val.charAt( 6 ) >= '0') && (val.charAt( 6 ) <= '9'))
			 && (val.charAt( 7 ) == '-' )
			 && ((val.charAt( 8 ) >= '0') && (val.charAt( 8 ) <= '3'))
			 && ((val.charAt( 9 ) >= '0') && (val.charAt( 9 ) <= '9'))
			 && (val.charAt( 10 ) == '-' )
			 && ((val.charAt( 11 ) >= '0') && (val.charAt( 11 ) <= '2'))
			 && ((val.charAt( 12 ) >= '0') && (val.charAt( 12 ) <= '9'))
			 && (val.charAt( 13 ) == '.' )
			 && ((val.charAt( 14 ) >= '0') && (val.charAt( 14 ) <= '5'))
			 && ((val.charAt( 15 ) >= '0') && (val.charAt( 15 ) <= '9'))
			 && (val.charAt( 16 ) == '.' )
			 && ((val.charAt( 17 ) >= '0') && (val.charAt( 17 ) <= '5'))
			 && ((val.charAt( 18 ) >= '0') && (val.charAt( 18 ) <= '9')) )
		{
			/*
			 *	NOTE:
			 *		.Net uses substring( startcol, lengthOfSubstring )
			 *		Java uses substring( startcol, endcol ) and does not
			 *			include charAt( endcol );
			 */
			int year = Integer.parseInt( val.substring( 0, 4 ) );
			int month = Integer.parseInt( val.substring( 5, 7 ) );
			int day = Integer.parseInt( val.substring( 8, 10 ) );
			int hour = Integer.parseInt( val.substring( 11, 13 ) );
			int minute = Integer.parseInt( val.substring( 14, 16 ) );
			int second = Integer.parseInt( val.substring( 17, 19 ) );
			Calendar retval = new GregorianCalendar( CFLibDbUtil.getDbServerTimeZone() );
			retval.set( Calendar.YEAR, year );
			retval.set( Calendar.MONTH, month - 1 );
			retval.set( Calendar.DAY_OF_MONTH, day );
			retval.set( Calendar.HOUR_OF_DAY, hour );
			retval.set( Calendar.MINUTE, minute );
			retval.set( Calendar.SECOND, second );
			Calendar local = new GregorianCalendar();
			local.setTimeInMillis( retval.getTimeInMillis() );
			return( local );
		}
		else {
			throw new CFLibUsageException( CFBamDb2LUWSchema.class,
				"convertTimestampString",
				"Value must be in YYYY-MM-DD-HH24.MI.SS format \"" + val + "\" is invalid" );
		}
	}

	public static Calendar convertTZDateString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
		else if ( val.length() != 19 ) {
			throw new CFLibUsageException( CFBamDb2LUWSchema.class,
				"convertTZDateString",
				"Value must be in YYYY-MM-DD-HH24.MI.SS format \"" + val + "\" is invalid" );
		}
		else if (((val.charAt( 0 ) >= '0') && (val.charAt( 0 ) <= '9'))
			 && ((val.charAt( 1 ) >= '0') && (val.charAt( 1 ) <= '9'))
			 && ((val.charAt( 2 ) >= '0') && (val.charAt( 2 ) <= '9'))
			 && ((val.charAt( 3 ) >= '0') && (val.charAt( 3 ) <= '9'))
			 && (val.charAt( 4 ) == '-')
			 && ((val.charAt( 5 ) >= '0') && (val.charAt( 5 ) <= '1'))
			 && ((val.charAt( 6 ) >= '0') && (val.charAt( 6 ) <= '9'))
			 && (val.charAt( 7 ) == '-' )
			 && ((val.charAt( 8 ) >= '0') && (val.charAt( 8 ) <= '3'))
			 && ((val.charAt( 9 ) >= '0') && (val.charAt( 9 ) <= '9'))
			 && (val.charAt( 10 ) == '-' )
			 && ((val.charAt( 11 ) >= '0') && (val.charAt( 11 ) <= '2'))
			 && ((val.charAt( 12 ) >= '0') && (val.charAt( 12 ) <= '9'))
			 && (val.charAt( 13 ) == '.' )
			 && ((val.charAt( 14 ) >= '0') && (val.charAt( 14 ) <= '5'))
			 && ((val.charAt( 15 ) >= '0') && (val.charAt( 15 ) <= '9'))
			 && (val.charAt( 16 ) == '.' )
			 && ((val.charAt( 17 ) >= '0') && (val.charAt( 17 ) <= '5'))
			 && ((val.charAt( 18 ) >= '0') && (val.charAt( 18 ) <= '9')) )
		{
			/*
			 *	NOTE:
			 *		.Net uses substring( startcol, lengthOfSubstring )
			 *		Java uses substring( startcol, endcol ) and does not
			 *			include charAt( endcol );
			 */
			int year = Integer.parseInt( val.substring( 0, 4 ) );
			int month = Integer.parseInt( val.substring( 5, 7 ) );
			int day = Integer.parseInt( val.substring( 8, 10 ) );
			int hour = Integer.parseInt( val.substring( 11, 13 ) );
			int minute = Integer.parseInt( val.substring( 14, 16 ) );
			int second = Integer.parseInt( val.substring( 17, 19 ) );
			Calendar retval = new GregorianCalendar( CFLibDbUtil.getDbServerTimeZone() );
			retval.set( Calendar.YEAR, year );
			retval.set( Calendar.MONTH, month - 1 );
			retval.set( Calendar.DAY_OF_MONTH, day );
			retval.set( Calendar.HOUR_OF_DAY, hour );
			retval.set( Calendar.MINUTE, minute );
			retval.set( Calendar.SECOND, second );
			Calendar utc = CFLibDbUtil.getUTCCalendar( retval );
			return( utc );
		}
		else {
			throw new CFLibUsageException( CFBamDb2LUWSchema.class,
				"convertTZDateString",
				"Value must be in YYYY-MM-DD-HH24.MI.SS format \"" + val + "\" is invalid" );
		}
	}

	public static Calendar convertTZTimeString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
		else if ( val.length() != 19 ) {
			throw new CFLibUsageException( CFBamDb2LUWSchema.class,
				"convertTZTimeString",
				"Value must be in YYYY-MM-DD HH24.MI.SS format \"" + val + "\" is invalid" );
		}
		else if (((val.charAt( 0 ) >= '0') && (val.charAt( 0 ) <= '9'))
			 && ((val.charAt( 1 ) >= '0') && (val.charAt( 1 ) <= '9'))
			 && ((val.charAt( 2 ) >= '0') && (val.charAt( 2 ) <= '9'))
			 && ((val.charAt( 3 ) >= '0') && (val.charAt( 3 ) <= '9'))
			 && (val.charAt( 4 ) == '-')
			 && ((val.charAt( 5 ) >= '0') && (val.charAt( 5 ) <= '1'))
			 && ((val.charAt( 6 ) >= '0') && (val.charAt( 6 ) <= '9'))
			 && (val.charAt( 7 ) == '-' )
			 && ((val.charAt( 8 ) >= '0') && (val.charAt( 8 ) <= '3'))
			 && ((val.charAt( 9 ) >= '0') && (val.charAt( 9 ) <= '9'))
			 && (val.charAt( 10 ) == '-' )
			 && ((val.charAt( 11 ) >= '0') && (val.charAt( 11 ) <= '2'))
			 && ((val.charAt( 12 ) >= '0') && (val.charAt( 12 ) <= '9'))
			 && (val.charAt( 13 ) == '.' )
			 && ((val.charAt( 14 ) >= '0') && (val.charAt( 14 ) <= '5'))
			 && ((val.charAt( 15 ) >= '0') && (val.charAt( 15 ) <= '9'))
			 && (val.charAt( 16 ) == '.' )
			 && ((val.charAt( 17 ) >= '0') && (val.charAt( 17 ) <= '5'))
			 && ((val.charAt( 18 ) >= '0') && (val.charAt( 18 ) <= '9')) )
		{
			/*
			 *	NOTE:
			 *		.Net uses substring( startcol, lengthOfSubstring )
			 *		Java uses substring( startcol, endcol ) and does not
			 *			include charAt( endcol );
			 */
			int year = Integer.parseInt( val.substring( 0, 4 ) );
			int month = Integer.parseInt( val.substring( 5, 7 ) );
			int day = Integer.parseInt( val.substring( 8, 10 ) );
			int hour = Integer.parseInt( val.substring( 11, 13 ) );
			int minute = Integer.parseInt( val.substring( 14, 16 ) );
			int second = Integer.parseInt( val.substring( 17, 19 ) );
			Calendar retval = new GregorianCalendar( CFLibDbUtil.getDbServerTimeZone() );
			retval.set( Calendar.YEAR, year );
			retval.set( Calendar.MONTH, month - 1 );
			retval.set( Calendar.DAY_OF_MONTH, day );
			retval.set( Calendar.HOUR_OF_DAY, hour );
			retval.set( Calendar.MINUTE, minute );
			retval.set( Calendar.SECOND, second );
			Calendar utc = CFLibDbUtil.getUTCCalendar( retval );
			return( utc );
		}
		else {
			throw new CFLibUsageException( CFBamDb2LUWSchema.class,
				"convertTZTimeString",
				"Value must be in YYYY-MM-DD-HH24.MI.SS format \"" + val + "\" is invalid" );
		}
	}

	public static Calendar convertTZTimestampString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
		else if ( val.length() != 19 ) {
			throw new CFLibUsageException( CFBamDb2LUWSchema.class,
				"convertTZTimestampString",
				"Value must be in YYYY-MM-DD-HH24.MI.SS format \"" + val + "\" is invalid" );
		}
		else if (((val.charAt( 0 ) >= '0') && (val.charAt( 0 ) <= '9'))
			 && ((val.charAt( 1 ) >= '0') && (val.charAt( 1 ) <= '9'))
			 && ((val.charAt( 2 ) >= '0') && (val.charAt( 2 ) <= '9'))
			 && ((val.charAt( 3 ) >= '0') && (val.charAt( 3 ) <= '9'))
			 && (val.charAt( 4 ) == '-')
			 && ((val.charAt( 5 ) >= '0') && (val.charAt( 5 ) <= '1'))
			 && ((val.charAt( 6 ) >= '0') && (val.charAt( 6 ) <= '9'))
			 && (val.charAt( 7 ) == '-' )
			 && ((val.charAt( 8 ) >= '0') && (val.charAt( 8 ) <= '3'))
			 && ((val.charAt( 9 ) >= '0') && (val.charAt( 9 ) <= '9'))
			 && (val.charAt( 10 ) == '-' )
			 && ((val.charAt( 11 ) >= '0') && (val.charAt( 11 ) <= '2'))
			 && ((val.charAt( 12 ) >= '0') && (val.charAt( 12 ) <= '9'))
			 && (val.charAt( 13 ) == '.' )
			 && ((val.charAt( 14 ) >= '0') && (val.charAt( 14 ) <= '5'))
			 && ((val.charAt( 15 ) >= '0') && (val.charAt( 15 ) <= '9'))
			 && (val.charAt( 16 ) == '.' )
			 && ((val.charAt( 17 ) >= '0') && (val.charAt( 17 ) <= '5'))
			 && ((val.charAt( 18 ) >= '0') && (val.charAt( 18 ) <= '9')) )
		{
			/*
			 *	NOTE:
			 *		.Net uses substring( startcol, lengthOfSubstring )
			 *		Java uses substring( startcol, endcol ) and does not
			 *			include charAt( endcol );
			 */
			int year = Integer.parseInt( val.substring( 0, 4 ) );
			int month = Integer.parseInt( val.substring( 5, 7 ) );
			int day = Integer.parseInt( val.substring( 8, 10 ) );
			int hour = Integer.parseInt( val.substring( 11, 13 ) );
			int minute = Integer.parseInt( val.substring( 14, 16 ) );
			int second = Integer.parseInt( val.substring( 17, 19 ) );
			Calendar retval = new GregorianCalendar( CFLibDbUtil.getDbServerTimeZone() );
			retval.set( Calendar.YEAR, year );
			retval.set( Calendar.MONTH, month - 1 );
			retval.set( Calendar.DAY_OF_MONTH, day );
			retval.set( Calendar.HOUR_OF_DAY, hour );
			retval.set( Calendar.MINUTE, minute );
			retval.set( Calendar.SECOND, second );
			Calendar utc = CFLibDbUtil.getUTCCalendar( retval );
			return( utc );
		}
		else {
			throw new CFLibUsageException( CFBamDb2LUWSchema.class,
				"convertTZTimestampString",
				"Value must be in YYYY-MM-DD-HH24.MI.SS format \"" + val + "\" is invalid" );
		}
	}

	public static UUID convertUuidString(String val) {
		if( ( val == null ) || ( val.length() == 0 ) ) {
			return( null );
		}
		else {
			return( UUID.fromString( val ) );
		}
	}
}
