// $ANTLR 3.5.2 FromClauseParser.g 2021-08-17 21:23:00

package org.apache.hadoop.hive.ql.parse;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.conf.HiveConf;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


/**
   Licensed to the Apache Software Foundation (ASF) under one or more 
   contributor license agreements.  See the NOTICE file distributed with 
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with 
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
@SuppressWarnings("all")
public class HiveParser_FromClauseParser extends Parser {
	public static final int EOF=-1;
	public static final int AMPERSAND=4;
	public static final int BITWISEOR=5;
	public static final int BITWISEXOR=6;
	public static final int ByteLengthLiteral=7;
	public static final int COLON=8;
	public static final int COMMA=9;
	public static final int CONCATENATE=10;
	public static final int CharSetLiteral=11;
	public static final int CharSetName=12;
	public static final int DIV=13;
	public static final int DIVIDE=14;
	public static final int DOLLAR=15;
	public static final int DOT=16;
	public static final int Digit=17;
	public static final int EQUAL=18;
	public static final int EQUAL_NS=19;
	public static final int Exponent=20;
	public static final int GREATERTHAN=21;
	public static final int GREATERTHANOREQUALTO=22;
	public static final int HexDigit=23;
	public static final int Identifier=24;
	public static final int IntegralLiteral=25;
	public static final int KW_ABORT=26;
	public static final int KW_ACTIVATE=27;
	public static final int KW_ACTIVE=28;
	public static final int KW_ADD=29;
	public static final int KW_ADMIN=30;
	public static final int KW_AFTER=31;
	public static final int KW_ALL=32;
	public static final int KW_ALLOC_FRACTION=33;
	public static final int KW_ALTER=34;
	public static final int KW_ANALYZE=35;
	public static final int KW_AND=36;
	public static final int KW_ANY=37;
	public static final int KW_APPLICATION=38;
	public static final int KW_ARCHIVE=39;
	public static final int KW_ARRAY=40;
	public static final int KW_AS=41;
	public static final int KW_ASC=42;
	public static final int KW_AUTHORIZATION=43;
	public static final int KW_AUTOCOMMIT=44;
	public static final int KW_BEFORE=45;
	public static final int KW_BETWEEN=46;
	public static final int KW_BIGINT=47;
	public static final int KW_BINARY=48;
	public static final int KW_BOOLEAN=49;
	public static final int KW_BOTH=50;
	public static final int KW_BUCKET=51;
	public static final int KW_BUCKETS=52;
	public static final int KW_BY=53;
	public static final int KW_CACHE=54;
	public static final int KW_CASCADE=55;
	public static final int KW_CASE=56;
	public static final int KW_CAST=57;
	public static final int KW_CHANGE=58;
	public static final int KW_CHAR=59;
	public static final int KW_CHECK=60;
	public static final int KW_CLUSTER=61;
	public static final int KW_CLUSTERED=62;
	public static final int KW_CLUSTERSTATUS=63;
	public static final int KW_COLLECTION=64;
	public static final int KW_COLUMN=65;
	public static final int KW_COLUMNS=66;
	public static final int KW_COMMENT=67;
	public static final int KW_COMMIT=68;
	public static final int KW_COMPACT=69;
	public static final int KW_COMPACTIONS=70;
	public static final int KW_COMPUTE=71;
	public static final int KW_CONCATENATE=72;
	public static final int KW_CONF=73;
	public static final int KW_CONSTRAINT=74;
	public static final int KW_CONTINUE=75;
	public static final int KW_CREATE=76;
	public static final int KW_CROSS=77;
	public static final int KW_CUBE=78;
	public static final int KW_CURRENT=79;
	public static final int KW_CURRENT_DATE=80;
	public static final int KW_CURRENT_TIMESTAMP=81;
	public static final int KW_CURSOR=82;
	public static final int KW_DATA=83;
	public static final int KW_DATABASE=84;
	public static final int KW_DATABASES=85;
	public static final int KW_DATE=86;
	public static final int KW_DATETIME=87;
	public static final int KW_DAY=88;
	public static final int KW_DBPROPERTIES=89;
	public static final int KW_DECIMAL=90;
	public static final int KW_DEFAULT=91;
	public static final int KW_DEFERRED=92;
	public static final int KW_DEFINED=93;
	public static final int KW_DELETE=94;
	public static final int KW_DELIMITED=95;
	public static final int KW_DEPENDENCY=96;
	public static final int KW_DESC=97;
	public static final int KW_DESCRIBE=98;
	public static final int KW_DETAIL=99;
	public static final int KW_DIRECTORIES=100;
	public static final int KW_DIRECTORY=101;
	public static final int KW_DISABLE=102;
	public static final int KW_DISTINCT=103;
	public static final int KW_DISTRIBUTE=104;
	public static final int KW_DO=105;
	public static final int KW_DOUBLE=106;
	public static final int KW_DOW=107;
	public static final int KW_DROP=108;
	public static final int KW_DUMP=109;
	public static final int KW_ELEM_TYPE=110;
	public static final int KW_ELSE=111;
	public static final int KW_ENABLE=112;
	public static final int KW_END=113;
	public static final int KW_ENFORCED=114;
	public static final int KW_ESCAPED=115;
	public static final int KW_EXCEPT=116;
	public static final int KW_EXCHANGE=117;
	public static final int KW_EXCLUSIVE=118;
	public static final int KW_EXISTS=119;
	public static final int KW_EXPLAIN=120;
	public static final int KW_EXPORT=121;
	public static final int KW_EXPRESSION=122;
	public static final int KW_EXTENDED=123;
	public static final int KW_EXTERNAL=124;
	public static final int KW_EXTRACT=125;
	public static final int KW_FALSE=126;
	public static final int KW_FETCH=127;
	public static final int KW_FIELDS=128;
	public static final int KW_FILE=129;
	public static final int KW_FILEFORMAT=130;
	public static final int KW_FIRST=131;
	public static final int KW_FLOAT=132;
	public static final int KW_FLOOR=133;
	public static final int KW_FOLLOWING=134;
	public static final int KW_FOR=135;
	public static final int KW_FOREIGN=136;
	public static final int KW_FORMAT=137;
	public static final int KW_FORMATTED=138;
	public static final int KW_FROM=139;
	public static final int KW_FULL=140;
	public static final int KW_FUNCTION=141;
	public static final int KW_FUNCTIONS=142;
	public static final int KW_GRANT=143;
	public static final int KW_GROUP=144;
	public static final int KW_GROUPING=145;
	public static final int KW_HAVING=146;
	public static final int KW_HOUR=147;
	public static final int KW_IDXPROPERTIES=148;
	public static final int KW_IF=149;
	public static final int KW_IMPORT=150;
	public static final int KW_IN=151;
	public static final int KW_INDEX=152;
	public static final int KW_INDEXES=153;
	public static final int KW_INNER=154;
	public static final int KW_INPATH=155;
	public static final int KW_INPUTDRIVER=156;
	public static final int KW_INPUTFORMAT=157;
	public static final int KW_INSERT=158;
	public static final int KW_INT=159;
	public static final int KW_INTERSECT=160;
	public static final int KW_INTERVAL=161;
	public static final int KW_INTO=162;
	public static final int KW_IS=163;
	public static final int KW_ISOLATION=164;
	public static final int KW_ITEMS=165;
	public static final int KW_JAR=166;
	public static final int KW_JOIN=167;
	public static final int KW_KEY=168;
	public static final int KW_KEYS=169;
	public static final int KW_KEY_TYPE=170;
	public static final int KW_KILL=171;
	public static final int KW_LAST=172;
	public static final int KW_LATERAL=173;
	public static final int KW_LEFT=174;
	public static final int KW_LESS=175;
	public static final int KW_LEVEL=176;
	public static final int KW_LIKE=177;
	public static final int KW_LIMIT=178;
	public static final int KW_LINES=179;
	public static final int KW_LOAD=180;
	public static final int KW_LOCAL=181;
	public static final int KW_LOCATION=182;
	public static final int KW_LOCK=183;
	public static final int KW_LOCKS=184;
	public static final int KW_LOGICAL=185;
	public static final int KW_LONG=186;
	public static final int KW_MACRO=187;
	public static final int KW_MANAGEMENT=188;
	public static final int KW_MAP=189;
	public static final int KW_MAPJOIN=190;
	public static final int KW_MAPPING=191;
	public static final int KW_MATCHED=192;
	public static final int KW_MATERIALIZED=193;
	public static final int KW_MERGE=194;
	public static final int KW_METADATA=195;
	public static final int KW_MINUS=196;
	public static final int KW_MINUTE=197;
	public static final int KW_MONTH=198;
	public static final int KW_MORE=199;
	public static final int KW_MOVE=200;
	public static final int KW_MSCK=201;
	public static final int KW_NONE=202;
	public static final int KW_NORELY=203;
	public static final int KW_NOSCAN=204;
	public static final int KW_NOT=205;
	public static final int KW_NOVALIDATE=206;
	public static final int KW_NULL=207;
	public static final int KW_NULLS=208;
	public static final int KW_OF=209;
	public static final int KW_OFFSET=210;
	public static final int KW_ON=211;
	public static final int KW_ONLY=212;
	public static final int KW_OPERATOR=213;
	public static final int KW_OPTION=214;
	public static final int KW_OR=215;
	public static final int KW_ORDER=216;
	public static final int KW_OUT=217;
	public static final int KW_OUTER=218;
	public static final int KW_OUTPUTDRIVER=219;
	public static final int KW_OUTPUTFORMAT=220;
	public static final int KW_OVER=221;
	public static final int KW_OVERWRITE=222;
	public static final int KW_OWNER=223;
	public static final int KW_PARTITION=224;
	public static final int KW_PARTITIONED=225;
	public static final int KW_PARTITIONS=226;
	public static final int KW_PATH=227;
	public static final int KW_PERCENT=228;
	public static final int KW_PLAN=229;
	public static final int KW_PLANS=230;
	public static final int KW_PLUS=231;
	public static final int KW_POOL=232;
	public static final int KW_PRECEDING=233;
	public static final int KW_PRECISION=234;
	public static final int KW_PRESERVE=235;
	public static final int KW_PRIMARY=236;
	public static final int KW_PRINCIPALS=237;
	public static final int KW_PROCEDURE=238;
	public static final int KW_PURGE=239;
	public static final int KW_QUARTER=240;
	public static final int KW_QUERY=241;
	public static final int KW_QUERY_PARALLELISM=242;
	public static final int KW_RANGE=243;
	public static final int KW_READ=244;
	public static final int KW_READS=245;
	public static final int KW_REBUILD=246;
	public static final int KW_RECORDREADER=247;
	public static final int KW_RECORDWRITER=248;
	public static final int KW_REDUCE=249;
	public static final int KW_REFERENCES=250;
	public static final int KW_REGEXP=251;
	public static final int KW_RELOAD=252;
	public static final int KW_RELY=253;
	public static final int KW_RENAME=254;
	public static final int KW_REOPTIMIZATION=255;
	public static final int KW_REPAIR=256;
	public static final int KW_REPL=257;
	public static final int KW_REPLACE=258;
	public static final int KW_REPLICATION=259;
	public static final int KW_RESOURCE=260;
	public static final int KW_RESTRICT=261;
	public static final int KW_REVOKE=262;
	public static final int KW_REWRITE=263;
	public static final int KW_RIGHT=264;
	public static final int KW_RLIKE=265;
	public static final int KW_ROLE=266;
	public static final int KW_ROLES=267;
	public static final int KW_ROLLBACK=268;
	public static final int KW_ROLLUP=269;
	public static final int KW_ROW=270;
	public static final int KW_ROWS=271;
	public static final int KW_SCHEDULING_POLICY=272;
	public static final int KW_SCHEMA=273;
	public static final int KW_SCHEMAS=274;
	public static final int KW_SECOND=275;
	public static final int KW_SELECT=276;
	public static final int KW_SEMI=277;
	public static final int KW_SERDE=278;
	public static final int KW_SERDEPROPERTIES=279;
	public static final int KW_SERVER=280;
	public static final int KW_SET=281;
	public static final int KW_SETS=282;
	public static final int KW_SHARED=283;
	public static final int KW_SHOW=284;
	public static final int KW_SHOW_DATABASE=285;
	public static final int KW_SKEWED=286;
	public static final int KW_SMALLINT=287;
	public static final int KW_SNAPSHOT=288;
	public static final int KW_SORT=289;
	public static final int KW_SORTED=290;
	public static final int KW_SSL=291;
	public static final int KW_START=292;
	public static final int KW_STATISTICS=293;
	public static final int KW_STATUS=294;
	public static final int KW_STORED=295;
	public static final int KW_STREAMTABLE=296;
	public static final int KW_STRING=297;
	public static final int KW_STRUCT=298;
	public static final int KW_SUMMARY=299;
	public static final int KW_SYNC=300;
	public static final int KW_TABLE=301;
	public static final int KW_TABLES=302;
	public static final int KW_TABLESAMPLE=303;
	public static final int KW_TBLPROPERTIES=304;
	public static final int KW_TEMPORARY=305;
	public static final int KW_TERMINATED=306;
	public static final int KW_THEN=307;
	public static final int KW_TIME=308;
	public static final int KW_TIMESTAMP=309;
	public static final int KW_TIMESTAMPLOCALTZ=310;
	public static final int KW_TINYINT=311;
	public static final int KW_TO=312;
	public static final int KW_TOUCH=313;
	public static final int KW_TRANSACTION=314;
	public static final int KW_TRANSACTIONS=315;
	public static final int KW_TRANSFORM=316;
	public static final int KW_TRIGGER=317;
	public static final int KW_TRUE=318;
	public static final int KW_TRUNCATE=319;
	public static final int KW_UNARCHIVE=320;
	public static final int KW_UNBOUNDED=321;
	public static final int KW_UNDO=322;
	public static final int KW_UNION=323;
	public static final int KW_UNIONTYPE=324;
	public static final int KW_UNIQUE=325;
	public static final int KW_UNIQUEJOIN=326;
	public static final int KW_UNLOCK=327;
	public static final int KW_UNMANAGED=328;
	public static final int KW_UNSET=329;
	public static final int KW_UNSIGNED=330;
	public static final int KW_UPDATE=331;
	public static final int KW_URI=332;
	public static final int KW_USE=333;
	public static final int KW_USER=334;
	public static final int KW_USING=335;
	public static final int KW_UTC=336;
	public static final int KW_UTCTIMESTAMP=337;
	public static final int KW_VALIDATE=338;
	public static final int KW_VALUES=339;
	public static final int KW_VALUE_TYPE=340;
	public static final int KW_VARCHAR=341;
	public static final int KW_VECTORIZATION=342;
	public static final int KW_VIEW=343;
	public static final int KW_VIEWS=344;
	public static final int KW_WAIT=345;
	public static final int KW_WEEK=346;
	public static final int KW_WHEN=347;
	public static final int KW_WHERE=348;
	public static final int KW_WHILE=349;
	public static final int KW_WINDOW=350;
	public static final int KW_WITH=351;
	public static final int KW_WORK=352;
	public static final int KW_WORKLOAD=353;
	public static final int KW_WRITE=354;
	public static final int KW_YEAR=355;
	public static final int KW_ZONE=356;
	public static final int LCURLY=357;
	public static final int LESSTHAN=358;
	public static final int LESSTHANOREQUALTO=359;
	public static final int LINE_COMMENT=360;
	public static final int LPAREN=361;
	public static final int LSQUARE=362;
	public static final int Letter=363;
	public static final int MINUS=364;
	public static final int MOD=365;
	public static final int NOTEQUAL=366;
	public static final int Number=367;
	public static final int NumberLiteral=368;
	public static final int PLUS=369;
	public static final int QUERY_HINT=370;
	public static final int QUESTION=371;
	public static final int QuotedIdentifier=372;
	public static final int RCURLY=373;
	public static final int RPAREN=374;
	public static final int RSQUARE=375;
	public static final int RegexComponent=376;
	public static final int SEMICOLON=377;
	public static final int STAR=378;
	public static final int StringLiteral=379;
	public static final int TILDE=380;
	public static final int WS=381;
	public static final int KW_BATCH=417;
	public static final int KW_DAYOFWEEK=454;
	public static final int KW_HOLD_DDLTIME=501;
	public static final int KW_IGNORE=505;
	public static final int KW_NO_DROP=552;
	public static final int KW_OFFLINE=556;
	public static final int KW_PROTECTION=582;
	public static final int KW_READONLY=589;
	public static final int KW_TIMESTAMPTZ=649;
	public static final int TOK_ABORT_TRANSACTIONS=708;
	public static final int TOK_ACTIVATE=709;
	public static final int TOK_ADD_TRIGGER=710;
	public static final int TOK_ADMIN_OPTION_FOR=711;
	public static final int TOK_ALIASLIST=712;
	public static final int TOK_ALLCOLREF=713;
	public static final int TOK_ALLOC_FRACTION=714;
	public static final int TOK_ALTERDATABASE_LOCATION=715;
	public static final int TOK_ALTERDATABASE_OWNER=716;
	public static final int TOK_ALTERDATABASE_PROPERTIES=717;
	public static final int TOK_ALTERTABLE=718;
	public static final int TOK_ALTERTABLE_ADDCOLS=719;
	public static final int TOK_ALTERTABLE_ADDCONSTRAINT=720;
	public static final int TOK_ALTERTABLE_ADDPARTS=721;
	public static final int TOK_ALTERTABLE_ARCHIVE=722;
	public static final int TOK_ALTERTABLE_BUCKETS=723;
	public static final int TOK_ALTERTABLE_CHANGECOL_AFTER_POSITION=724;
	public static final int TOK_ALTERTABLE_CLUSTER_SORT=725;
	public static final int TOK_ALTERTABLE_COMPACT=726;
	public static final int TOK_ALTERTABLE_DROPCONSTRAINT=727;
	public static final int TOK_ALTERTABLE_DROPPARTS=728;
	public static final int TOK_ALTERTABLE_DROPPROPERTIES=729;
	public static final int TOK_ALTERTABLE_EXCHANGEPARTITION=730;
	public static final int TOK_ALTERTABLE_FILEFORMAT=731;
	public static final int TOK_ALTERTABLE_LOCATION=732;
	public static final int TOK_ALTERTABLE_MERGEFILES=733;
	public static final int TOK_ALTERTABLE_OWNER=734;
	public static final int TOK_ALTERTABLE_PARTCOLTYPE=735;
	public static final int TOK_ALTERTABLE_PROPERTIES=736;
	public static final int TOK_ALTERTABLE_RENAME=737;
	public static final int TOK_ALTERTABLE_RENAMECOL=738;
	public static final int TOK_ALTERTABLE_RENAMEPART=739;
	public static final int TOK_ALTERTABLE_REPLACECOLS=740;
	public static final int TOK_ALTERTABLE_SERDEPROPERTIES=741;
	public static final int TOK_ALTERTABLE_SERIALIZER=742;
	public static final int TOK_ALTERTABLE_SKEWED=743;
	public static final int TOK_ALTERTABLE_SKEWED_LOCATION=744;
	public static final int TOK_ALTERTABLE_TOUCH=745;
	public static final int TOK_ALTERTABLE_UNARCHIVE=746;
	public static final int TOK_ALTERTABLE_UPDATECOLSTATS=747;
	public static final int TOK_ALTERTABLE_UPDATECOLUMNS=748;
	public static final int TOK_ALTERTABLE_UPDATESTATS=749;
	public static final int TOK_ALTERVIEW=750;
	public static final int TOK_ALTERVIEW_ADDPARTS=751;
	public static final int TOK_ALTERVIEW_DROPPARTS=752;
	public static final int TOK_ALTERVIEW_DROPPROPERTIES=753;
	public static final int TOK_ALTERVIEW_PROPERTIES=754;
	public static final int TOK_ALTERVIEW_RENAME=755;
	public static final int TOK_ALTER_MAPPING=756;
	public static final int TOK_ALTER_MATERIALIZED_VIEW=757;
	public static final int TOK_ALTER_MATERIALIZED_VIEW_REBUILD=758;
	public static final int TOK_ALTER_MATERIALIZED_VIEW_REWRITE=759;
	public static final int TOK_ALTER_POOL=760;
	public static final int TOK_ALTER_RP=761;
	public static final int TOK_ALTER_TRIGGER=762;
	public static final int TOK_ANALYZE=763;
	public static final int TOK_ARCHIVE=764;
	public static final int TOK_BIGINT=765;
	public static final int TOK_BINARY=766;
	public static final int TOK_BLOCKING=767;
	public static final int TOK_BOOLEAN=768;
	public static final int TOK_CACHE_METADATA=769;
	public static final int TOK_CASCADE=770;
	public static final int TOK_CHAR=771;
	public static final int TOK_CHARSETLITERAL=772;
	public static final int TOK_CHECK_CONSTRAINT=773;
	public static final int TOK_CLUSTERBY=774;
	public static final int TOK_COLTYPELIST=775;
	public static final int TOK_COL_NAME=776;
	public static final int TOK_COMMIT=777;
	public static final int TOK_CONSTRAINT_NAME=778;
	public static final int TOK_CREATEDATABASE=779;
	public static final int TOK_CREATEFUNCTION=780;
	public static final int TOK_CREATEMACRO=781;
	public static final int TOK_CREATEROLE=782;
	public static final int TOK_CREATETABLE=783;
	public static final int TOK_CREATEVIEW=784;
	public static final int TOK_CREATE_MAPPING=785;
	public static final int TOK_CREATE_MATERIALIZED_VIEW=786;
	public static final int TOK_CREATE_POOL=787;
	public static final int TOK_CREATE_RP=788;
	public static final int TOK_CREATE_TRIGGER=789;
	public static final int TOK_CROSSJOIN=790;
	public static final int TOK_CTE=791;
	public static final int TOK_CUBE_GROUPBY=792;
	public static final int TOK_DATABASECOMMENT=793;
	public static final int TOK_DATABASELOCATION=794;
	public static final int TOK_DATABASEPROPERTIES=795;
	public static final int TOK_DATE=796;
	public static final int TOK_DATELITERAL=797;
	public static final int TOK_DATETIME=798;
	public static final int TOK_DBNAME=799;
	public static final int TOK_DBPROPLIST=800;
	public static final int TOK_DB_TYPE=801;
	public static final int TOK_DECIMAL=802;
	public static final int TOK_DEFAULT_POOL=803;
	public static final int TOK_DEFAULT_VALUE=804;
	public static final int TOK_DELETE=805;
	public static final int TOK_DELETE_FROM=806;
	public static final int TOK_DESCDATABASE=807;
	public static final int TOK_DESCFUNCTION=808;
	public static final int TOK_DESCTABLE=809;
	public static final int TOK_DESTINATION=810;
	public static final int TOK_DETAIL=811;
	public static final int TOK_DIR=812;
	public static final int TOK_DISABLE=813;
	public static final int TOK_DISTRIBUTEBY=814;
	public static final int TOK_DOUBLE=815;
	public static final int TOK_DROPDATABASE=816;
	public static final int TOK_DROPFUNCTION=817;
	public static final int TOK_DROPMACRO=818;
	public static final int TOK_DROPROLE=819;
	public static final int TOK_DROPTABLE=820;
	public static final int TOK_DROPVIEW=821;
	public static final int TOK_DROP_MAPPING=822;
	public static final int TOK_DROP_MATERIALIZED_VIEW=823;
	public static final int TOK_DROP_POOL=824;
	public static final int TOK_DROP_RP=825;
	public static final int TOK_DROP_TRIGGER=826;
	public static final int TOK_ENABLE=827;
	public static final int TOK_EXCEPTALL=828;
	public static final int TOK_EXCEPTDISTINCT=829;
	public static final int TOK_EXPLAIN=830;
	public static final int TOK_EXPLAIN_SQ_REWRITE=831;
	public static final int TOK_EXPLIST=832;
	public static final int TOK_EXPORT=833;
	public static final int TOK_EXPRESSION=834;
	public static final int TOK_FALSE=835;
	public static final int TOK_FILE=836;
	public static final int TOK_FILEFORMAT_GENERIC=837;
	public static final int TOK_FLOAT=838;
	public static final int TOK_FOREIGN_KEY=839;
	public static final int TOK_FROM=840;
	public static final int TOK_FULLOUTERJOIN=841;
	public static final int TOK_FUNCTION=842;
	public static final int TOK_FUNCTIONDI=843;
	public static final int TOK_FUNCTIONSTAR=844;
	public static final int TOK_GRANT=845;
	public static final int TOK_GRANT_OPTION_FOR=846;
	public static final int TOK_GRANT_ROLE=847;
	public static final int TOK_GRANT_WITH_ADMIN_OPTION=848;
	public static final int TOK_GRANT_WITH_OPTION=849;
	public static final int TOK_GROUP=850;
	public static final int TOK_GROUPBY=851;
	public static final int TOK_GROUPING_SETS=852;
	public static final int TOK_GROUPING_SETS_EXPRESSION=853;
	public static final int TOK_HAVING=854;
	public static final int TOK_IFEXISTS=855;
	public static final int TOK_IFNOTEXISTS=856;
	public static final int TOK_IMPORT=857;
	public static final int TOK_INPUTFORMAT=858;
	public static final int TOK_INSERT=859;
	public static final int TOK_INSERT_INTO=860;
	public static final int TOK_INT=861;
	public static final int TOK_INTERSECTALL=862;
	public static final int TOK_INTERSECTDISTINCT=863;
	public static final int TOK_INTERVAL_DAY_LITERAL=864;
	public static final int TOK_INTERVAL_DAY_TIME=865;
	public static final int TOK_INTERVAL_DAY_TIME_LITERAL=866;
	public static final int TOK_INTERVAL_HOUR_LITERAL=867;
	public static final int TOK_INTERVAL_MINUTE_LITERAL=868;
	public static final int TOK_INTERVAL_MONTH_LITERAL=869;
	public static final int TOK_INTERVAL_SECOND_LITERAL=870;
	public static final int TOK_INTERVAL_YEAR_LITERAL=871;
	public static final int TOK_INTERVAL_YEAR_MONTH=872;
	public static final int TOK_INTERVAL_YEAR_MONTH_LITERAL=873;
	public static final int TOK_ISOLATION_LEVEL=874;
	public static final int TOK_ISOLATION_SNAPSHOT=875;
	public static final int TOK_JAR=876;
	public static final int TOK_JOIN=877;
	public static final int TOK_KILL_QUERY=878;
	public static final int TOK_LATERAL_VIEW=879;
	public static final int TOK_LATERAL_VIEW_OUTER=880;
	public static final int TOK_LEFTOUTERJOIN=881;
	public static final int TOK_LEFTSEMIJOIN=882;
	public static final int TOK_LENGTH=883;
	public static final int TOK_LIKERP=884;
	public static final int TOK_LIKETABLE=885;
	public static final int TOK_LIMIT=886;
	public static final int TOK_LIST=887;
	public static final int TOK_LOAD=888;
	public static final int TOK_LOCKDB=889;
	public static final int TOK_LOCKTABLE=890;
	public static final int TOK_MAP=891;
	public static final int TOK_MATCHED=892;
	public static final int TOK_MERGE=893;
	public static final int TOK_METADATA=894;
	public static final int TOK_MSCK=895;
	public static final int TOK_NORELY=896;
	public static final int TOK_NOT_CLUSTERED=897;
	public static final int TOK_NOT_MATCHED=898;
	public static final int TOK_NOT_NULL=899;
	public static final int TOK_NOT_SORTED=900;
	public static final int TOK_NOVALIDATE=901;
	public static final int TOK_NO_DROP=902;
	public static final int TOK_NULL=903;
	public static final int TOK_NULLS_FIRST=904;
	public static final int TOK_NULLS_LAST=905;
	public static final int TOK_OFFLINE=906;
	public static final int TOK_OFFSET=907;
	public static final int TOK_ONLY=908;
	public static final int TOK_OPERATOR=909;
	public static final int TOK_OP_ADD=910;
	public static final int TOK_OP_AND=911;
	public static final int TOK_OP_BITAND=912;
	public static final int TOK_OP_BITNOT=913;
	public static final int TOK_OP_BITOR=914;
	public static final int TOK_OP_BITXOR=915;
	public static final int TOK_OP_DIV=916;
	public static final int TOK_OP_EQ=917;
	public static final int TOK_OP_GE=918;
	public static final int TOK_OP_GT=919;
	public static final int TOK_OP_LE=920;
	public static final int TOK_OP_LIKE=921;
	public static final int TOK_OP_LT=922;
	public static final int TOK_OP_MOD=923;
	public static final int TOK_OP_MUL=924;
	public static final int TOK_OP_NE=925;
	public static final int TOK_OP_NOT=926;
	public static final int TOK_OP_OR=927;
	public static final int TOK_OP_SUB=928;
	public static final int TOK_ORDERBY=929;
	public static final int TOK_ORREPLACE=930;
	public static final int TOK_PARTITIONINGSPEC=931;
	public static final int TOK_PARTITIONLOCATION=932;
	public static final int TOK_PARTSPEC=933;
	public static final int TOK_PARTVAL=934;
	public static final int TOK_PATH=935;
	public static final int TOK_PERCENT=936;
	public static final int TOK_PRIMARY_KEY=937;
	public static final int TOK_PRINCIPAL_NAME=938;
	public static final int TOK_PRIVILEGE=939;
	public static final int TOK_PRIVILEGE_LIST=940;
	public static final int TOK_PRIV_ALL=941;
	public static final int TOK_PRIV_ALTER_DATA=942;
	public static final int TOK_PRIV_ALTER_METADATA=943;
	public static final int TOK_PRIV_CREATE=944;
	public static final int TOK_PRIV_DELETE=945;
	public static final int TOK_PRIV_DROP=946;
	public static final int TOK_PRIV_INSERT=947;
	public static final int TOK_PRIV_LOCK=948;
	public static final int TOK_PRIV_OBJECT=949;
	public static final int TOK_PRIV_OBJECT_COL=950;
	public static final int TOK_PRIV_SELECT=951;
	public static final int TOK_PRIV_SHOW_DATABASE=952;
	public static final int TOK_PTBLFUNCTION=953;
	public static final int TOK_QUERY=954;
	public static final int TOK_QUERY_PARALLELISM=955;
	public static final int TOK_READONLY=956;
	public static final int TOK_RECORDREADER=957;
	public static final int TOK_RECORDWRITER=958;
	public static final int TOK_RELOADFUNCTION=959;
	public static final int TOK_RELY=960;
	public static final int TOK_RENAME=961;
	public static final int TOK_REPLACE=962;
	public static final int TOK_REPLICATION=963;
	public static final int TOK_REPL_CONFIG=964;
	public static final int TOK_REPL_CONFIG_LIST=965;
	public static final int TOK_REPL_DUMP=966;
	public static final int TOK_REPL_LOAD=967;
	public static final int TOK_REPL_STATUS=968;
	public static final int TOK_RESOURCE_ALL=969;
	public static final int TOK_RESOURCE_LIST=970;
	public static final int TOK_RESOURCE_URI=971;
	public static final int TOK_RESTRICT=972;
	public static final int TOK_REVOKE=973;
	public static final int TOK_REVOKE_ROLE=974;
	public static final int TOK_REWRITE_DISABLED=975;
	public static final int TOK_REWRITE_ENABLED=976;
	public static final int TOK_RIGHTOUTERJOIN=977;
	public static final int TOK_ROLE=978;
	public static final int TOK_ROLLBACK=979;
	public static final int TOK_ROLLUP_GROUPBY=980;
	public static final int TOK_ROWCOUNT=981;
	public static final int TOK_SCHEDULING_POLICY=982;
	public static final int TOK_SELECT=983;
	public static final int TOK_SELECTDI=984;
	public static final int TOK_SELEXPR=985;
	public static final int TOK_SERDE=986;
	public static final int TOK_SERDENAME=987;
	public static final int TOK_SERDEPROPS=988;
	public static final int TOK_SERVER_TYPE=989;
	public static final int TOK_SETCOLREF=990;
	public static final int TOK_SET_AUTOCOMMIT=991;
	public static final int TOK_SET_COLUMNS_CLAUSE=992;
	public static final int TOK_SHOWCOLUMNS=993;
	public static final int TOK_SHOWCONF=994;
	public static final int TOK_SHOWDATABASES=995;
	public static final int TOK_SHOWDBLOCKS=996;
	public static final int TOK_SHOWFUNCTIONS=997;
	public static final int TOK_SHOWLOCKS=998;
	public static final int TOK_SHOWMATERIALIZEDVIEWS=999;
	public static final int TOK_SHOWPARTITIONS=1000;
	public static final int TOK_SHOWTABLES=1001;
	public static final int TOK_SHOWVIEWS=1002;
	public static final int TOK_SHOW_COMPACTIONS=1003;
	public static final int TOK_SHOW_CREATEDATABASE=1004;
	public static final int TOK_SHOW_CREATETABLE=1005;
	public static final int TOK_SHOW_GRANT=1006;
	public static final int TOK_SHOW_ROLES=1007;
	public static final int TOK_SHOW_ROLE_GRANT=1008;
	public static final int TOK_SHOW_ROLE_PRINCIPALS=1009;
	public static final int TOK_SHOW_RP=1010;
	public static final int TOK_SHOW_SET_ROLE=1011;
	public static final int TOK_SHOW_TABLESTATUS=1012;
	public static final int TOK_SHOW_TBLPROPERTIES=1013;
	public static final int TOK_SHOW_TRANSACTIONS=1014;
	public static final int TOK_SKEWED_LOCATIONS=1015;
	public static final int TOK_SKEWED_LOCATION_LIST=1016;
	public static final int TOK_SKEWED_LOCATION_MAP=1017;
	public static final int TOK_SMALLINT=1018;
	public static final int TOK_SORTBY=1019;
	public static final int TOK_START_TRANSACTION=1020;
	public static final int TOK_STORAGEHANDLER=1021;
	public static final int TOK_STOREDASDIRS=1022;
	public static final int TOK_STRING=1023;
	public static final int TOK_STRINGLITERALSEQUENCE=1024;
	public static final int TOK_STRUCT=1025;
	public static final int TOK_SUBQUERY=1026;
	public static final int TOK_SUBQUERY_EXPR=1027;
	public static final int TOK_SUBQUERY_OP=1028;
	public static final int TOK_SUBQUERY_OP_NOTEXISTS=1029;
	public static final int TOK_SUBQUERY_OP_NOTIN=1030;
	public static final int TOK_SUMMARY=1031;
	public static final int TOK_SWITCHDATABASE=1032;
	public static final int TOK_TAB=1033;
	public static final int TOK_TABALIAS=1034;
	public static final int TOK_TABCOL=1035;
	public static final int TOK_TABCOLLIST=1036;
	public static final int TOK_TABCOLNAME=1037;
	public static final int TOK_TABCOLVALUE=1038;
	public static final int TOK_TABCOLVALUES=1039;
	public static final int TOK_TABCOLVALUE_PAIR=1040;
	public static final int TOK_TABLEBUCKETSAMPLE=1041;
	public static final int TOK_TABLECOMMENT=1042;
	public static final int TOK_TABLEFILEFORMAT=1043;
	public static final int TOK_TABLELOCATION=1044;
	public static final int TOK_TABLEPARTCOLS=1045;
	public static final int TOK_TABLEPROPERTIES=1046;
	public static final int TOK_TABLEPROPERTY=1047;
	public static final int TOK_TABLEPROPLIST=1048;
	public static final int TOK_TABLEROWFORMAT=1049;
	public static final int TOK_TABLEROWFORMATCOLLITEMS=1050;
	public static final int TOK_TABLEROWFORMATFIELD=1051;
	public static final int TOK_TABLEROWFORMATLINES=1052;
	public static final int TOK_TABLEROWFORMATMAPKEYS=1053;
	public static final int TOK_TABLEROWFORMATNULL=1054;
	public static final int TOK_TABLESERIALIZER=1055;
	public static final int TOK_TABLESKEWED=1056;
	public static final int TOK_TABLESPLITSAMPLE=1057;
	public static final int TOK_TABLE_OR_COL=1058;
	public static final int TOK_TABLE_PARTITION=1059;
	public static final int TOK_TABLE_TYPE=1060;
	public static final int TOK_TABNAME=1061;
	public static final int TOK_TABREF=1062;
	public static final int TOK_TABSORTCOLNAMEASC=1063;
	public static final int TOK_TABSORTCOLNAMEDESC=1064;
	public static final int TOK_TABSRC=1065;
	public static final int TOK_TABTYPE=1066;
	public static final int TOK_TEMPORARY=1067;
	public static final int TOK_TIMESTAMP=1068;
	public static final int TOK_TIMESTAMPLITERAL=1069;
	public static final int TOK_TIMESTAMPLOCALTZ=1070;
	public static final int TOK_TIMESTAMPLOCALTZLITERAL=1071;
	public static final int TOK_TINYINT=1072;
	public static final int TOK_TMP_FILE=1073;
	public static final int TOK_TO=1074;
	public static final int TOK_TRANSFORM=1075;
	public static final int TOK_TRIGGER_EXPRESSION=1076;
	public static final int TOK_TRUE=1077;
	public static final int TOK_TRUNCATETABLE=1078;
	public static final int TOK_TXN_ACCESS_MODE=1079;
	public static final int TOK_TXN_READ_ONLY=1080;
	public static final int TOK_TXN_READ_WRITE=1081;
	public static final int TOK_UNIONALL=1082;
	public static final int TOK_UNIONDISTINCT=1083;
	public static final int TOK_UNIONTYPE=1084;
	public static final int TOK_UNIQUE=1085;
	public static final int TOK_UNIQUEJOIN=1086;
	public static final int TOK_UNLOCKDB=1087;
	public static final int TOK_UNLOCKTABLE=1088;
	public static final int TOK_UNMANAGED=1089;
	public static final int TOK_UPDATE=1090;
	public static final int TOK_UPDATE_TABLE=1091;
	public static final int TOK_URI_TYPE=1092;
	public static final int TOK_USER=1093;
	public static final int TOK_USERSCRIPTCOLNAMES=1094;
	public static final int TOK_USERSCRIPTCOLSCHEMA=1095;
	public static final int TOK_VALIDATE=1096;
	public static final int TOK_VARCHAR=1097;
	public static final int TOK_VIEWPARTCOLS=1098;
	public static final int TOK_WHERE=1099;
	public static final int TOK_WINDOWDEF=1100;
	public static final int TOK_WINDOWRANGE=1101;
	public static final int TOK_WINDOWSPEC=1102;
	public static final int TOK_WINDOWVALUES=1103;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators
	public HiveParser gHiveParser;
	public HiveParser gParent;


	public HiveParser_FromClauseParser(TokenStream input, HiveParser gHiveParser) {
		this(input, new RecognizerSharedState(), gHiveParser);
	}
	public HiveParser_FromClauseParser(TokenStream input, RecognizerSharedState state, HiveParser gHiveParser) {
		super(input, state);
		this.gHiveParser = gHiveParser;
		gParent = gHiveParser;
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return HiveParser.tokenNames; }
	@Override public String getGrammarFileName() { return "FromClauseParser.g"; }


	  @Override
	  public Object recoverFromMismatchedSet(IntStream input,
	      RecognitionException re, BitSet follow) throws RecognitionException {
	    throw re;
	  }
	  @Override
	  public void displayRecognitionError(String[] tokenNames,
	      RecognitionException e) {
	    gParent.errors.add(new ParseError(gParent, e, tokenNames));
	  }


	public static class tableAllColumns_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "tableAllColumns"
	// FromClauseParser.g:48:1: tableAllColumns : ( STAR -> ^( TOK_ALLCOLREF ) | tableName DOT STAR -> ^( TOK_ALLCOLREF tableName ) );
	public final HiveParser_FromClauseParser.tableAllColumns_return tableAllColumns() throws RecognitionException {
		HiveParser_FromClauseParser.tableAllColumns_return retval = new HiveParser_FromClauseParser.tableAllColumns_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token STAR1=null;
		Token DOT3=null;
		Token STAR4=null;
		ParserRuleReturnScope tableName2 =null;

		ASTNode STAR1_tree=null;
		ASTNode DOT3_tree=null;
		ASTNode STAR4_tree=null;
		RewriteRuleTokenStream stream_STAR=new RewriteRuleTokenStream(adaptor,"token STAR");
		RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
		RewriteRuleSubtreeStream stream_tableName=new RewriteRuleSubtreeStream(adaptor,"rule tableName");

		try {
			// FromClauseParser.g:49:5: ( STAR -> ^( TOK_ALLCOLREF ) | tableName DOT STAR -> ^( TOK_ALLCOLREF tableName ) )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==STAR) ) {
				alt1=1;
			}
			else if ( (LA1_0==Identifier||(LA1_0 >= KW_ABORT && LA1_0 <= KW_AFTER)||LA1_0==KW_ALLOC_FRACTION||LA1_0==KW_ANALYZE||LA1_0==KW_ARCHIVE||LA1_0==KW_ASC||(LA1_0 >= KW_AUTOCOMMIT && LA1_0 <= KW_BEFORE)||(LA1_0 >= KW_BUCKET && LA1_0 <= KW_BUCKETS)||(LA1_0 >= KW_CACHE && LA1_0 <= KW_CASCADE)||LA1_0==KW_CHANGE||(LA1_0 >= KW_CHECK && LA1_0 <= KW_COLLECTION)||(LA1_0 >= KW_COLUMNS && LA1_0 <= KW_COMMENT)||(LA1_0 >= KW_COMPACT && LA1_0 <= KW_CONCATENATE)||LA1_0==KW_CONTINUE||LA1_0==KW_DATA||LA1_0==KW_DATABASES||(LA1_0 >= KW_DATETIME && LA1_0 <= KW_DBPROPERTIES)||(LA1_0 >= KW_DEFAULT && LA1_0 <= KW_DEFINED)||(LA1_0 >= KW_DELIMITED && LA1_0 <= KW_DESC)||(LA1_0 >= KW_DETAIL && LA1_0 <= KW_DISABLE)||(LA1_0 >= KW_DISTRIBUTE && LA1_0 <= KW_DO)||LA1_0==KW_DOW||(LA1_0 >= KW_DUMP && LA1_0 <= KW_ELEM_TYPE)||LA1_0==KW_ENABLE||(LA1_0 >= KW_ENFORCED && LA1_0 <= KW_ESCAPED)||LA1_0==KW_EXCLUSIVE||(LA1_0 >= KW_EXPLAIN && LA1_0 <= KW_EXPRESSION)||(LA1_0 >= KW_FIELDS && LA1_0 <= KW_FIRST)||(LA1_0 >= KW_FORMAT && LA1_0 <= KW_FORMATTED)||LA1_0==KW_FUNCTIONS||(LA1_0 >= KW_HOUR && LA1_0 <= KW_IDXPROPERTIES)||(LA1_0 >= KW_INDEX && LA1_0 <= KW_INDEXES)||(LA1_0 >= KW_INPATH && LA1_0 <= KW_INPUTFORMAT)||(LA1_0 >= KW_ISOLATION && LA1_0 <= KW_JAR)||(LA1_0 >= KW_KEY && LA1_0 <= KW_LAST)||LA1_0==KW_LEVEL||(LA1_0 >= KW_LIMIT && LA1_0 <= KW_LOAD)||(LA1_0 >= KW_LOCATION && LA1_0 <= KW_LONG)||LA1_0==KW_MANAGEMENT||(LA1_0 >= KW_MAPJOIN && LA1_0 <= KW_MATERIALIZED)||LA1_0==KW_METADATA||(LA1_0 >= KW_MINUTE && LA1_0 <= KW_MONTH)||(LA1_0 >= KW_MOVE && LA1_0 <= KW_MSCK)||(LA1_0 >= KW_NORELY && LA1_0 <= KW_NOSCAN)||LA1_0==KW_NOVALIDATE||LA1_0==KW_NULLS||LA1_0==KW_OFFSET||(LA1_0 >= KW_OPERATOR && LA1_0 <= KW_OPTION)||(LA1_0 >= KW_OUTPUTDRIVER && LA1_0 <= KW_OUTPUTFORMAT)||(LA1_0 >= KW_OVERWRITE && LA1_0 <= KW_OWNER)||(LA1_0 >= KW_PARTITIONED && LA1_0 <= KW_PATH)||(LA1_0 >= KW_PLAN && LA1_0 <= KW_POOL)||LA1_0==KW_PRINCIPALS||(LA1_0 >= KW_PURGE && LA1_0 <= KW_QUERY_PARALLELISM)||LA1_0==KW_READ||(LA1_0 >= KW_REBUILD && LA1_0 <= KW_RECORDWRITER)||(LA1_0 >= KW_RELOAD && LA1_0 <= KW_RESTRICT)||LA1_0==KW_REWRITE||(LA1_0 >= KW_ROLE && LA1_0 <= KW_ROLES)||(LA1_0 >= KW_SCHEDULING_POLICY && LA1_0 <= KW_SECOND)||(LA1_0 >= KW_SEMI && LA1_0 <= KW_SERVER)||(LA1_0 >= KW_SETS && LA1_0 <= KW_SKEWED)||(LA1_0 >= KW_SNAPSHOT && LA1_0 <= KW_SSL)||(LA1_0 >= KW_STATISTICS && LA1_0 <= KW_SUMMARY)||LA1_0==KW_TABLES||(LA1_0 >= KW_TBLPROPERTIES && LA1_0 <= KW_TERMINATED)||LA1_0==KW_TINYINT||(LA1_0 >= KW_TOUCH && LA1_0 <= KW_TRANSACTIONS)||LA1_0==KW_UNARCHIVE||LA1_0==KW_UNDO||LA1_0==KW_UNIONTYPE||(LA1_0 >= KW_UNLOCK && LA1_0 <= KW_UNSIGNED)||(LA1_0 >= KW_URI && LA1_0 <= KW_USE)||(LA1_0 >= KW_UTC && LA1_0 <= KW_VALIDATE)||LA1_0==KW_VALUE_TYPE||(LA1_0 >= KW_VECTORIZATION && LA1_0 <= KW_WEEK)||LA1_0==KW_WHILE||(LA1_0 >= KW_WORK && LA1_0 <= KW_ZONE)||LA1_0==KW_BATCH||LA1_0==KW_DAYOFWEEK||LA1_0==KW_HOLD_DDLTIME||LA1_0==KW_IGNORE||LA1_0==KW_NO_DROP||LA1_0==KW_OFFLINE||LA1_0==KW_PROTECTION||LA1_0==KW_READONLY||LA1_0==KW_TIMESTAMPTZ) ) {
				alt1=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// FromClauseParser.g:49:7: STAR
					{
					STAR1=(Token)match(input,STAR,FOLLOW_STAR_in_tableAllColumns57); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_STAR.add(STAR1);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 50:9: -> ^( TOK_ALLCOLREF )
					{
						// FromClauseParser.g:50:12: ^( TOK_ALLCOLREF )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ALLCOLREF, "TOK_ALLCOLREF"), root_1);
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// FromClauseParser.g:51:7: tableName DOT STAR
					{
					pushFollow(FOLLOW_tableName_in_tableAllColumns79);
					tableName2=tableName();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_tableName.add(tableName2.getTree());
					DOT3=(Token)match(input,DOT,FOLLOW_DOT_in_tableAllColumns81); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_DOT.add(DOT3);

					STAR4=(Token)match(input,STAR,FOLLOW_STAR_in_tableAllColumns83); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_STAR.add(STAR4);

					// AST REWRITE
					// elements: tableName
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 52:9: -> ^( TOK_ALLCOLREF tableName )
					{
						// FromClauseParser.g:52:12: ^( TOK_ALLCOLREF tableName )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ALLCOLREF, "TOK_ALLCOLREF"), root_1);
						adaptor.addChild(root_1, stream_tableName.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tableAllColumns"


	public static class tableOrColumn_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "tableOrColumn"
	// FromClauseParser.g:56:1: tableOrColumn : identifier -> ^( TOK_TABLE_OR_COL identifier ) ;
	public final HiveParser_FromClauseParser.tableOrColumn_return tableOrColumn() throws RecognitionException {
		HiveParser_FromClauseParser.tableOrColumn_return retval = new HiveParser_FromClauseParser.tableOrColumn_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		ParserRuleReturnScope identifier5 =null;

		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");

		 gParent.pushMsg("table or column identifier", state); 
		try {
			// FromClauseParser.g:59:5: ( identifier -> ^( TOK_TABLE_OR_COL identifier ) )
			// FromClauseParser.g:60:5: identifier
			{
			pushFollow(FOLLOW_identifier_in_tableOrColumn131);
			identifier5=gHiveParser.identifier();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_identifier.add(identifier5.getTree());
			// AST REWRITE
			// elements: identifier
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 60:16: -> ^( TOK_TABLE_OR_COL identifier )
			{
				// FromClauseParser.g:60:19: ^( TOK_TABLE_OR_COL identifier )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_TABLE_OR_COL, "TOK_TABLE_OR_COL"), root_1);
				adaptor.addChild(root_1, stream_identifier.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tableOrColumn"


	public static class expressionList_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "expressionList"
	// FromClauseParser.g:63:1: expressionList : expression ( COMMA expression )* -> ^( TOK_EXPLIST ( expression )+ ) ;
	public final HiveParser_FromClauseParser.expressionList_return expressionList() throws RecognitionException {
		HiveParser_FromClauseParser.expressionList_return retval = new HiveParser_FromClauseParser.expressionList_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token COMMA7=null;
		ParserRuleReturnScope expression6 =null;
		ParserRuleReturnScope expression8 =null;

		ASTNode COMMA7_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		 gParent.pushMsg("expression list", state); 
		try {
			// FromClauseParser.g:66:5: ( expression ( COMMA expression )* -> ^( TOK_EXPLIST ( expression )+ ) )
			// FromClauseParser.g:67:5: expression ( COMMA expression )*
			{
			pushFollow(FOLLOW_expression_in_expressionList170);
			expression6=gHiveParser.expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expression.add(expression6.getTree());
			// FromClauseParser.g:67:16: ( COMMA expression )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==COMMA) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// FromClauseParser.g:67:17: COMMA expression
					{
					COMMA7=(Token)match(input,COMMA,FOLLOW_COMMA_in_expressionList173); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COMMA.add(COMMA7);

					pushFollow(FOLLOW_expression_in_expressionList175);
					expression8=gHiveParser.expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expression.add(expression8.getTree());
					}
					break;

				default :
					break loop2;
				}
			}

			// AST REWRITE
			// elements: expression
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 67:36: -> ^( TOK_EXPLIST ( expression )+ )
			{
				// FromClauseParser.g:67:39: ^( TOK_EXPLIST ( expression )+ )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_EXPLIST, "TOK_EXPLIST"), root_1);
				if ( !(stream_expression.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_expression.hasNext() ) {
					adaptor.addChild(root_1, stream_expression.nextTree());
				}
				stream_expression.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expressionList"


	public static class aliasList_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "aliasList"
	// FromClauseParser.g:70:1: aliasList : identifier ( COMMA identifier )* -> ^( TOK_ALIASLIST ( identifier )+ ) ;
	public final HiveParser_FromClauseParser.aliasList_return aliasList() throws RecognitionException {
		HiveParser_FromClauseParser.aliasList_return retval = new HiveParser_FromClauseParser.aliasList_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token COMMA10=null;
		ParserRuleReturnScope identifier9 =null;
		ParserRuleReturnScope identifier11 =null;

		ASTNode COMMA10_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");

		 gParent.pushMsg("alias list", state); 
		try {
			// FromClauseParser.g:73:5: ( identifier ( COMMA identifier )* -> ^( TOK_ALIASLIST ( identifier )+ ) )
			// FromClauseParser.g:74:5: identifier ( COMMA identifier )*
			{
			pushFollow(FOLLOW_identifier_in_aliasList217);
			identifier9=gHiveParser.identifier();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_identifier.add(identifier9.getTree());
			// FromClauseParser.g:74:16: ( COMMA identifier )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==COMMA) ) {
					int LA3_20 = input.LA(2);
					if ( (LA3_20==Identifier||(LA3_20 >= KW_ABORT && LA3_20 <= KW_AFTER)||LA3_20==KW_ALLOC_FRACTION||LA3_20==KW_ANALYZE||LA3_20==KW_ARCHIVE||LA3_20==KW_ASC||(LA3_20 >= KW_AUTOCOMMIT && LA3_20 <= KW_BEFORE)||(LA3_20 >= KW_BUCKET && LA3_20 <= KW_BUCKETS)||(LA3_20 >= KW_CACHE && LA3_20 <= KW_CASCADE)||LA3_20==KW_CHANGE||(LA3_20 >= KW_CHECK && LA3_20 <= KW_COLLECTION)||(LA3_20 >= KW_COLUMNS && LA3_20 <= KW_COMMENT)||(LA3_20 >= KW_COMPACT && LA3_20 <= KW_CONCATENATE)||LA3_20==KW_CONTINUE||LA3_20==KW_DATA||LA3_20==KW_DATABASES||(LA3_20 >= KW_DATETIME && LA3_20 <= KW_DBPROPERTIES)||(LA3_20 >= KW_DEFAULT && LA3_20 <= KW_DEFINED)||(LA3_20 >= KW_DELIMITED && LA3_20 <= KW_DESC)||(LA3_20 >= KW_DETAIL && LA3_20 <= KW_DISABLE)||(LA3_20 >= KW_DISTRIBUTE && LA3_20 <= KW_DO)||LA3_20==KW_DOW||(LA3_20 >= KW_DUMP && LA3_20 <= KW_ELEM_TYPE)||LA3_20==KW_ENABLE||(LA3_20 >= KW_ENFORCED && LA3_20 <= KW_ESCAPED)||LA3_20==KW_EXCLUSIVE||(LA3_20 >= KW_EXPLAIN && LA3_20 <= KW_EXPRESSION)||(LA3_20 >= KW_FIELDS && LA3_20 <= KW_FIRST)||(LA3_20 >= KW_FORMAT && LA3_20 <= KW_FORMATTED)||LA3_20==KW_FUNCTIONS||(LA3_20 >= KW_HOUR && LA3_20 <= KW_IDXPROPERTIES)||(LA3_20 >= KW_INDEX && LA3_20 <= KW_INDEXES)||(LA3_20 >= KW_INPATH && LA3_20 <= KW_INPUTFORMAT)||(LA3_20 >= KW_ISOLATION && LA3_20 <= KW_JAR)||(LA3_20 >= KW_KEY && LA3_20 <= KW_LAST)||LA3_20==KW_LEVEL||(LA3_20 >= KW_LIMIT && LA3_20 <= KW_LOAD)||(LA3_20 >= KW_LOCATION && LA3_20 <= KW_LONG)||LA3_20==KW_MANAGEMENT||(LA3_20 >= KW_MAPJOIN && LA3_20 <= KW_MATERIALIZED)||LA3_20==KW_METADATA||(LA3_20 >= KW_MINUTE && LA3_20 <= KW_MONTH)||(LA3_20 >= KW_MOVE && LA3_20 <= KW_MSCK)||(LA3_20 >= KW_NORELY && LA3_20 <= KW_NOSCAN)||LA3_20==KW_NOVALIDATE||LA3_20==KW_NULLS||LA3_20==KW_OFFSET||(LA3_20 >= KW_OPERATOR && LA3_20 <= KW_OPTION)||(LA3_20 >= KW_OUTPUTDRIVER && LA3_20 <= KW_OUTPUTFORMAT)||(LA3_20 >= KW_OVERWRITE && LA3_20 <= KW_OWNER)||(LA3_20 >= KW_PARTITIONED && LA3_20 <= KW_PATH)||(LA3_20 >= KW_PLAN && LA3_20 <= KW_POOL)||LA3_20==KW_PRINCIPALS||(LA3_20 >= KW_PURGE && LA3_20 <= KW_QUERY_PARALLELISM)||LA3_20==KW_READ||(LA3_20 >= KW_REBUILD && LA3_20 <= KW_RECORDWRITER)||(LA3_20 >= KW_RELOAD && LA3_20 <= KW_RESTRICT)||LA3_20==KW_REWRITE||(LA3_20 >= KW_ROLE && LA3_20 <= KW_ROLES)||(LA3_20 >= KW_SCHEDULING_POLICY && LA3_20 <= KW_SECOND)||(LA3_20 >= KW_SEMI && LA3_20 <= KW_SERVER)||(LA3_20 >= KW_SETS && LA3_20 <= KW_SKEWED)||(LA3_20 >= KW_SNAPSHOT && LA3_20 <= KW_SSL)||(LA3_20 >= KW_STATISTICS && LA3_20 <= KW_SUMMARY)||LA3_20==KW_TABLES||(LA3_20 >= KW_TBLPROPERTIES && LA3_20 <= KW_TERMINATED)||LA3_20==KW_TINYINT||(LA3_20 >= KW_TOUCH && LA3_20 <= KW_TRANSACTIONS)||LA3_20==KW_UNARCHIVE||LA3_20==KW_UNDO||LA3_20==KW_UNIONTYPE||(LA3_20 >= KW_UNLOCK && LA3_20 <= KW_UNSIGNED)||(LA3_20 >= KW_URI && LA3_20 <= KW_USE)||(LA3_20 >= KW_UTC && LA3_20 <= KW_VALIDATE)||LA3_20==KW_VALUE_TYPE||(LA3_20 >= KW_VECTORIZATION && LA3_20 <= KW_WEEK)||LA3_20==KW_WHILE||(LA3_20 >= KW_WORK && LA3_20 <= KW_ZONE)||LA3_20==KW_BATCH||LA3_20==KW_DAYOFWEEK||LA3_20==KW_HOLD_DDLTIME||LA3_20==KW_IGNORE||LA3_20==KW_NO_DROP||LA3_20==KW_OFFLINE||LA3_20==KW_PROTECTION||LA3_20==KW_READONLY||LA3_20==KW_TIMESTAMPTZ) ) {
						alt3=1;
					}

				}

				switch (alt3) {
				case 1 :
					// FromClauseParser.g:74:17: COMMA identifier
					{
					COMMA10=(Token)match(input,COMMA,FOLLOW_COMMA_in_aliasList220); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COMMA.add(COMMA10);

					pushFollow(FOLLOW_identifier_in_aliasList222);
					identifier11=gHiveParser.identifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_identifier.add(identifier11.getTree());
					}
					break;

				default :
					break loop3;
				}
			}

			// AST REWRITE
			// elements: identifier
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 74:36: -> ^( TOK_ALIASLIST ( identifier )+ )
			{
				// FromClauseParser.g:74:39: ^( TOK_ALIASLIST ( identifier )+ )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ALIASLIST, "TOK_ALIASLIST"), root_1);
				if ( !(stream_identifier.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_identifier.hasNext() ) {
					adaptor.addChild(root_1, stream_identifier.nextTree());
				}
				stream_identifier.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "aliasList"


	public static class fromClause_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "fromClause"
	// FromClauseParser.g:79:1: fromClause : KW_FROM fromSource -> ^( TOK_FROM fromSource ) ;
	public final HiveParser_FromClauseParser.fromClause_return fromClause() throws RecognitionException {
		HiveParser_FromClauseParser.fromClause_return retval = new HiveParser_FromClauseParser.fromClause_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_FROM12=null;
		ParserRuleReturnScope fromSource13 =null;

		ASTNode KW_FROM12_tree=null;
		RewriteRuleTokenStream stream_KW_FROM=new RewriteRuleTokenStream(adaptor,"token KW_FROM");
		RewriteRuleSubtreeStream stream_fromSource=new RewriteRuleSubtreeStream(adaptor,"rule fromSource");

		 gParent.pushMsg("from clause", state); 
		try {
			// FromClauseParser.g:82:5: ( KW_FROM fromSource -> ^( TOK_FROM fromSource ) )
			// FromClauseParser.g:83:5: KW_FROM fromSource
			{
			KW_FROM12=(Token)match(input,KW_FROM,FOLLOW_KW_FROM_in_fromClause266); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_KW_FROM.add(KW_FROM12);

			pushFollow(FOLLOW_fromSource_in_fromClause268);
			fromSource13=fromSource();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_fromSource.add(fromSource13.getTree());
			// AST REWRITE
			// elements: fromSource
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 83:24: -> ^( TOK_FROM fromSource )
			{
				// FromClauseParser.g:83:27: ^( TOK_FROM fromSource )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_FROM, "TOK_FROM"), root_1);
				adaptor.addChild(root_1, stream_fromSource.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "fromClause"


	public static class fromSource_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "fromSource"
	// FromClauseParser.g:86:1: fromSource : ( uniqueJoinToken ^ uniqueJoinSource ( COMMA ! uniqueJoinSource )+ | joinSource );
	public final HiveParser_FromClauseParser.fromSource_return fromSource() throws RecognitionException {
		HiveParser_FromClauseParser.fromSource_return retval = new HiveParser_FromClauseParser.fromSource_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token COMMA16=null;
		ParserRuleReturnScope uniqueJoinToken14 =null;
		ParserRuleReturnScope uniqueJoinSource15 =null;
		ParserRuleReturnScope uniqueJoinSource17 =null;
		ParserRuleReturnScope joinSource18 =null;

		ASTNode COMMA16_tree=null;

		 gParent.pushMsg("join source", state); 
		try {
			// FromClauseParser.g:89:5: ( uniqueJoinToken ^ uniqueJoinSource ( COMMA ! uniqueJoinSource )+ | joinSource )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==KW_UNIQUEJOIN) ) {
				alt5=1;
			}
			else if ( (LA5_0==Identifier||(LA5_0 >= KW_ABORT && LA5_0 <= KW_AFTER)||LA5_0==KW_ALLOC_FRACTION||LA5_0==KW_ANALYZE||LA5_0==KW_ARCHIVE||LA5_0==KW_ASC||(LA5_0 >= KW_AUTOCOMMIT && LA5_0 <= KW_BEFORE)||(LA5_0 >= KW_BUCKET && LA5_0 <= KW_BUCKETS)||(LA5_0 >= KW_CACHE && LA5_0 <= KW_CASCADE)||LA5_0==KW_CHANGE||(LA5_0 >= KW_CHECK && LA5_0 <= KW_COLLECTION)||(LA5_0 >= KW_COLUMNS && LA5_0 <= KW_COMMENT)||(LA5_0 >= KW_COMPACT && LA5_0 <= KW_CONCATENATE)||LA5_0==KW_CONTINUE||LA5_0==KW_DATA||LA5_0==KW_DATABASES||(LA5_0 >= KW_DATETIME && LA5_0 <= KW_DBPROPERTIES)||(LA5_0 >= KW_DEFAULT && LA5_0 <= KW_DEFINED)||(LA5_0 >= KW_DELIMITED && LA5_0 <= KW_DESC)||(LA5_0 >= KW_DETAIL && LA5_0 <= KW_DISABLE)||(LA5_0 >= KW_DISTRIBUTE && LA5_0 <= KW_DO)||LA5_0==KW_DOW||(LA5_0 >= KW_DUMP && LA5_0 <= KW_ELEM_TYPE)||LA5_0==KW_ENABLE||(LA5_0 >= KW_ENFORCED && LA5_0 <= KW_ESCAPED)||LA5_0==KW_EXCLUSIVE||(LA5_0 >= KW_EXPLAIN && LA5_0 <= KW_EXPRESSION)||(LA5_0 >= KW_FIELDS && LA5_0 <= KW_FIRST)||(LA5_0 >= KW_FORMAT && LA5_0 <= KW_FORMATTED)||LA5_0==KW_FUNCTIONS||(LA5_0 >= KW_HOUR && LA5_0 <= KW_IDXPROPERTIES)||(LA5_0 >= KW_INDEX && LA5_0 <= KW_INDEXES)||(LA5_0 >= KW_INPATH && LA5_0 <= KW_INPUTFORMAT)||(LA5_0 >= KW_ISOLATION && LA5_0 <= KW_JAR)||(LA5_0 >= KW_KEY && LA5_0 <= KW_LAST)||LA5_0==KW_LEVEL||(LA5_0 >= KW_LIMIT && LA5_0 <= KW_LOAD)||(LA5_0 >= KW_LOCATION && LA5_0 <= KW_LONG)||LA5_0==KW_MANAGEMENT||(LA5_0 >= KW_MAPJOIN && LA5_0 <= KW_MATERIALIZED)||LA5_0==KW_METADATA||(LA5_0 >= KW_MINUTE && LA5_0 <= KW_MONTH)||(LA5_0 >= KW_MOVE && LA5_0 <= KW_MSCK)||(LA5_0 >= KW_NORELY && LA5_0 <= KW_NOSCAN)||LA5_0==KW_NOVALIDATE||LA5_0==KW_NULLS||LA5_0==KW_OFFSET||(LA5_0 >= KW_OPERATOR && LA5_0 <= KW_OPTION)||(LA5_0 >= KW_OUTPUTDRIVER && LA5_0 <= KW_OUTPUTFORMAT)||(LA5_0 >= KW_OVERWRITE && LA5_0 <= KW_OWNER)||(LA5_0 >= KW_PARTITIONED && LA5_0 <= KW_PATH)||(LA5_0 >= KW_PLAN && LA5_0 <= KW_POOL)||LA5_0==KW_PRINCIPALS||(LA5_0 >= KW_PURGE && LA5_0 <= KW_QUERY_PARALLELISM)||LA5_0==KW_READ||(LA5_0 >= KW_REBUILD && LA5_0 <= KW_RECORDWRITER)||(LA5_0 >= KW_RELOAD && LA5_0 <= KW_RESTRICT)||LA5_0==KW_REWRITE||(LA5_0 >= KW_ROLE && LA5_0 <= KW_ROLES)||(LA5_0 >= KW_SCHEDULING_POLICY && LA5_0 <= KW_SECOND)||(LA5_0 >= KW_SEMI && LA5_0 <= KW_SERVER)||(LA5_0 >= KW_SETS && LA5_0 <= KW_SKEWED)||(LA5_0 >= KW_SNAPSHOT && LA5_0 <= KW_SSL)||(LA5_0 >= KW_STATISTICS && LA5_0 <= KW_SUMMARY)||(LA5_0 >= KW_TABLE && LA5_0 <= KW_TABLES)||(LA5_0 >= KW_TBLPROPERTIES && LA5_0 <= KW_TERMINATED)||LA5_0==KW_TINYINT||(LA5_0 >= KW_TOUCH && LA5_0 <= KW_TRANSACTIONS)||LA5_0==KW_UNARCHIVE||LA5_0==KW_UNDO||LA5_0==KW_UNIONTYPE||(LA5_0 >= KW_UNLOCK && LA5_0 <= KW_UNSIGNED)||(LA5_0 >= KW_URI && LA5_0 <= KW_USE)||(LA5_0 >= KW_UTC && LA5_0 <= KW_VALIDATE)||LA5_0==KW_VALUE_TYPE||(LA5_0 >= KW_VECTORIZATION && LA5_0 <= KW_WEEK)||LA5_0==KW_WHILE||(LA5_0 >= KW_WORK && LA5_0 <= KW_ZONE)||LA5_0==LPAREN||LA5_0==KW_BATCH||LA5_0==KW_DAYOFWEEK||LA5_0==KW_HOLD_DDLTIME||LA5_0==KW_IGNORE||LA5_0==KW_NO_DROP||LA5_0==KW_OFFLINE||LA5_0==KW_PROTECTION||LA5_0==KW_READONLY||LA5_0==KW_TIMESTAMPTZ) ) {
				alt5=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// FromClauseParser.g:90:5: uniqueJoinToken ^ uniqueJoinSource ( COMMA ! uniqueJoinSource )+
					{
					root_0 = (ASTNode)adaptor.nil();


					pushFollow(FOLLOW_uniqueJoinToken_in_fromSource307);
					uniqueJoinToken14=uniqueJoinToken();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) root_0 = (ASTNode)adaptor.becomeRoot(uniqueJoinToken14.getTree(), root_0);
					pushFollow(FOLLOW_uniqueJoinSource_in_fromSource310);
					uniqueJoinSource15=uniqueJoinSource();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, uniqueJoinSource15.getTree());

					// FromClauseParser.g:90:39: ( COMMA ! uniqueJoinSource )+
					int cnt4=0;
					loop4:
					while (true) {
						int alt4=2;
						int LA4_0 = input.LA(1);
						if ( (LA4_0==COMMA) ) {
							alt4=1;
						}

						switch (alt4) {
						case 1 :
							// FromClauseParser.g:90:40: COMMA ! uniqueJoinSource
							{
							COMMA16=(Token)match(input,COMMA,FOLLOW_COMMA_in_fromSource313); if (state.failed) return retval;
							pushFollow(FOLLOW_uniqueJoinSource_in_fromSource316);
							uniqueJoinSource17=uniqueJoinSource();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, uniqueJoinSource17.getTree());

							}
							break;

						default :
							if ( cnt4 >= 1 ) break loop4;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(4, input);
							throw eee;
						}
						cnt4++;
					}

					}
					break;
				case 2 :
					// FromClauseParser.g:92:5: joinSource
					{
					root_0 = (ASTNode)adaptor.nil();


					pushFollow(FOLLOW_joinSource_in_fromSource330);
					joinSource18=joinSource();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, joinSource18.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "fromSource"


	public static class atomjoinSource_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "atomjoinSource"
	// FromClauseParser.g:96:1: atomjoinSource : ( tableSource ( lateralView ^)* | virtualTableSource ( lateralView ^)* | ( LPAREN ( KW_WITH | KW_SELECT | KW_MAP | KW_REDUCE | KW_FROM ) )=> subQuerySource ( lateralView ^)* | ( LPAREN LPAREN atomSelectStatement RPAREN setOperator )=> subQuerySource ( lateralView ^)* | partitionedTableFunction ( lateralView ^)* | LPAREN ! joinSource RPAREN !);
	public final HiveParser_FromClauseParser.atomjoinSource_return atomjoinSource() throws RecognitionException {
		HiveParser_FromClauseParser.atomjoinSource_return retval = new HiveParser_FromClauseParser.atomjoinSource_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token LPAREN29=null;
		Token RPAREN31=null;
		ParserRuleReturnScope tableSource19 =null;
		ParserRuleReturnScope lateralView20 =null;
		ParserRuleReturnScope virtualTableSource21 =null;
		ParserRuleReturnScope lateralView22 =null;
		ParserRuleReturnScope subQuerySource23 =null;
		ParserRuleReturnScope lateralView24 =null;
		ParserRuleReturnScope subQuerySource25 =null;
		ParserRuleReturnScope lateralView26 =null;
		ParserRuleReturnScope partitionedTableFunction27 =null;
		ParserRuleReturnScope lateralView28 =null;
		ParserRuleReturnScope joinSource30 =null;

		ASTNode LPAREN29_tree=null;
		ASTNode RPAREN31_tree=null;

		 gParent.pushMsg("joinSource", state); 
		try {
			// FromClauseParser.g:99:5: ( tableSource ( lateralView ^)* | virtualTableSource ( lateralView ^)* | ( LPAREN ( KW_WITH | KW_SELECT | KW_MAP | KW_REDUCE | KW_FROM ) )=> subQuerySource ( lateralView ^)* | ( LPAREN LPAREN atomSelectStatement RPAREN setOperator )=> subQuerySource ( lateralView ^)* | partitionedTableFunction ( lateralView ^)* | LPAREN ! joinSource RPAREN !)
			int alt11=6;
			alt11 = dfa11.predict(input);
			switch (alt11) {
				case 1 :
					// FromClauseParser.g:99:8: tableSource ( lateralView ^)*
					{
					root_0 = (ASTNode)adaptor.nil();


					pushFollow(FOLLOW_tableSource_in_atomjoinSource359);
					tableSource19=tableSource();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, tableSource19.getTree());

					// FromClauseParser.g:99:20: ( lateralView ^)*
					loop6:
					while (true) {
						int alt6=2;
						int LA6_0 = input.LA(1);
						if ( (LA6_0==COMMA) ) {
							int LA6_3 = input.LA(2);
							if ( (LA6_3==KW_LATERAL) ) {
								alt6=1;
							}

						}
						else if ( (LA6_0==KW_LATERAL) ) {
							alt6=1;
						}

						switch (alt6) {
						case 1 :
							// FromClauseParser.g:99:21: lateralView ^
							{
							pushFollow(FOLLOW_lateralView_in_atomjoinSource362);
							lateralView20=lateralView();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) root_0 = (ASTNode)adaptor.becomeRoot(lateralView20.getTree(), root_0);
							}
							break;

						default :
							break loop6;
						}
					}

					}
					break;
				case 2 :
					// FromClauseParser.g:100:8: virtualTableSource ( lateralView ^)*
					{
					root_0 = (ASTNode)adaptor.nil();


					pushFollow(FOLLOW_virtualTableSource_in_atomjoinSource374);
					virtualTableSource21=virtualTableSource();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, virtualTableSource21.getTree());

					// FromClauseParser.g:100:27: ( lateralView ^)*
					loop7:
					while (true) {
						int alt7=2;
						int LA7_0 = input.LA(1);
						if ( (LA7_0==COMMA) ) {
							int LA7_3 = input.LA(2);
							if ( (LA7_3==KW_LATERAL) ) {
								alt7=1;
							}

						}
						else if ( (LA7_0==KW_LATERAL) ) {
							alt7=1;
						}

						switch (alt7) {
						case 1 :
							// FromClauseParser.g:100:28: lateralView ^
							{
							pushFollow(FOLLOW_lateralView_in_atomjoinSource377);
							lateralView22=lateralView();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) root_0 = (ASTNode)adaptor.becomeRoot(lateralView22.getTree(), root_0);
							}
							break;

						default :
							break loop7;
						}
					}

					}
					break;
				case 3 :
					// FromClauseParser.g:101:8: ( LPAREN ( KW_WITH | KW_SELECT | KW_MAP | KW_REDUCE | KW_FROM ) )=> subQuerySource ( lateralView ^)*
					{
					root_0 = (ASTNode)adaptor.nil();


					pushFollow(FOLLOW_subQuerySource_in_atomjoinSource407);
					subQuerySource23=subQuerySource();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, subQuerySource23.getTree());

					// FromClauseParser.g:101:80: ( lateralView ^)*
					loop8:
					while (true) {
						int alt8=2;
						int LA8_0 = input.LA(1);
						if ( (LA8_0==COMMA) ) {
							int LA8_3 = input.LA(2);
							if ( (LA8_3==KW_LATERAL) ) {
								alt8=1;
							}

						}
						else if ( (LA8_0==KW_LATERAL) ) {
							alt8=1;
						}

						switch (alt8) {
						case 1 :
							// FromClauseParser.g:101:81: lateralView ^
							{
							pushFollow(FOLLOW_lateralView_in_atomjoinSource410);
							lateralView24=lateralView();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) root_0 = (ASTNode)adaptor.becomeRoot(lateralView24.getTree(), root_0);
							}
							break;

						default :
							break loop8;
						}
					}

					}
					break;
				case 4 :
					// FromClauseParser.g:102:8: ( LPAREN LPAREN atomSelectStatement RPAREN setOperator )=> subQuerySource ( lateralView ^)*
					{
					root_0 = (ASTNode)adaptor.nil();


					pushFollow(FOLLOW_subQuerySource_in_atomjoinSource437);
					subQuerySource25=subQuerySource();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, subQuerySource25.getTree());

					// FromClauseParser.g:102:82: ( lateralView ^)*
					loop9:
					while (true) {
						int alt9=2;
						int LA9_0 = input.LA(1);
						if ( (LA9_0==COMMA) ) {
							int LA9_3 = input.LA(2);
							if ( (LA9_3==KW_LATERAL) ) {
								alt9=1;
							}

						}
						else if ( (LA9_0==KW_LATERAL) ) {
							alt9=1;
						}

						switch (alt9) {
						case 1 :
							// FromClauseParser.g:102:83: lateralView ^
							{
							pushFollow(FOLLOW_lateralView_in_atomjoinSource440);
							lateralView26=lateralView();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) root_0 = (ASTNode)adaptor.becomeRoot(lateralView26.getTree(), root_0);
							}
							break;

						default :
							break loop9;
						}
					}

					}
					break;
				case 5 :
					// FromClauseParser.g:103:8: partitionedTableFunction ( lateralView ^)*
					{
					root_0 = (ASTNode)adaptor.nil();


					pushFollow(FOLLOW_partitionedTableFunction_in_atomjoinSource452);
					partitionedTableFunction27=partitionedTableFunction();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, partitionedTableFunction27.getTree());

					// FromClauseParser.g:103:33: ( lateralView ^)*
					loop10:
					while (true) {
						int alt10=2;
						int LA10_0 = input.LA(1);
						if ( (LA10_0==COMMA) ) {
							int LA10_3 = input.LA(2);
							if ( (LA10_3==KW_LATERAL) ) {
								alt10=1;
							}

						}
						else if ( (LA10_0==KW_LATERAL) ) {
							alt10=1;
						}

						switch (alt10) {
						case 1 :
							// FromClauseParser.g:103:34: lateralView ^
							{
							pushFollow(FOLLOW_lateralView_in_atomjoinSource455);
							lateralView28=lateralView();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) root_0 = (ASTNode)adaptor.becomeRoot(lateralView28.getTree(), root_0);
							}
							break;

						default :
							break loop10;
						}
					}

					}
					break;
				case 6 :
					// FromClauseParser.g:104:8: LPAREN ! joinSource RPAREN !
					{
					root_0 = (ASTNode)adaptor.nil();


					LPAREN29=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_atomjoinSource467); if (state.failed) return retval;
					pushFollow(FOLLOW_joinSource_in_atomjoinSource470);
					joinSource30=joinSource();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, joinSource30.getTree());

					RPAREN31=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_atomjoinSource472); if (state.failed) return retval;
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atomjoinSource"


	public static class joinSource_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "joinSource"
	// FromClauseParser.g:107:1: joinSource : atomjoinSource ( joinToken ^ joinSourcePart ( KW_ON ! expression {...}?| KW_USING ! columnParenthesesList {...}?)? )* ;
	public final HiveParser_FromClauseParser.joinSource_return joinSource() throws RecognitionException {
		HiveParser_FromClauseParser.joinSource_return retval = new HiveParser_FromClauseParser.joinSource_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_ON35=null;
		Token KW_USING37=null;
		ParserRuleReturnScope atomjoinSource32 =null;
		ParserRuleReturnScope joinToken33 =null;
		ParserRuleReturnScope joinSourcePart34 =null;
		ParserRuleReturnScope expression36 =null;
		ParserRuleReturnScope columnParenthesesList38 =null;

		ASTNode KW_ON35_tree=null;
		ASTNode KW_USING37_tree=null;

		try {
			// FromClauseParser.g:108:5: ( atomjoinSource ( joinToken ^ joinSourcePart ( KW_ON ! expression {...}?| KW_USING ! columnParenthesesList {...}?)? )* )
			// FromClauseParser.g:109:5: atomjoinSource ( joinToken ^ joinSourcePart ( KW_ON ! expression {...}?| KW_USING ! columnParenthesesList {...}?)? )*
			{
			root_0 = (ASTNode)adaptor.nil();


			pushFollow(FOLLOW_atomjoinSource_in_joinSource494);
			atomjoinSource32=atomjoinSource();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, atomjoinSource32.getTree());

			// FromClauseParser.g:109:20: ( joinToken ^ joinSourcePart ( KW_ON ! expression {...}?| KW_USING ! columnParenthesesList {...}?)? )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==COMMA||LA13_0==KW_CROSS||LA13_0==KW_FULL||LA13_0==KW_INNER||LA13_0==KW_JOIN||LA13_0==KW_LEFT||LA13_0==KW_RIGHT) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// FromClauseParser.g:109:21: joinToken ^ joinSourcePart ( KW_ON ! expression {...}?| KW_USING ! columnParenthesesList {...}?)?
					{
					pushFollow(FOLLOW_joinToken_in_joinSource497);
					joinToken33=joinToken();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) root_0 = (ASTNode)adaptor.becomeRoot(joinToken33.getTree(), root_0);
					pushFollow(FOLLOW_joinSourcePart_in_joinSource500);
					joinSourcePart34=joinSourcePart();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, joinSourcePart34.getTree());

					// FromClauseParser.g:109:47: ( KW_ON ! expression {...}?| KW_USING ! columnParenthesesList {...}?)?
					int alt12=3;
					int LA12_0 = input.LA(1);
					if ( (LA12_0==KW_ON) ) {
						alt12=1;
					}
					else if ( (LA12_0==KW_USING) ) {
						alt12=2;
					}
					switch (alt12) {
						case 1 :
							// FromClauseParser.g:109:48: KW_ON ! expression {...}?
							{
							KW_ON35=(Token)match(input,KW_ON,FOLLOW_KW_ON_in_joinSource503); if (state.failed) return retval;
							pushFollow(FOLLOW_expression_in_joinSource506);
							expression36=gHiveParser.expression();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, expression36.getTree());

							if ( !(((joinToken33!=null?(joinToken33.start):null).getType() != COMMA)) ) {
								if (state.backtracking>0) {state.failed=true; return retval;}
								throw new FailedPredicateException(input, "joinSource", "$joinToken.start.getType() != COMMA");
							}
							}
							break;
						case 2 :
							// FromClauseParser.g:109:107: KW_USING ! columnParenthesesList {...}?
							{
							KW_USING37=(Token)match(input,KW_USING,FOLLOW_KW_USING_in_joinSource512); if (state.failed) return retval;
							pushFollow(FOLLOW_columnParenthesesList_in_joinSource515);
							columnParenthesesList38=gHiveParser.columnParenthesesList();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, columnParenthesesList38.getTree());

							if ( !(((joinToken33!=null?(joinToken33.start):null).getType() != COMMA)) ) {
								if (state.backtracking>0) {state.failed=true; return retval;}
								throw new FailedPredicateException(input, "joinSource", "$joinToken.start.getType() != COMMA");
							}
							}
							break;

					}

					}
					break;

				default :
					break loop13;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "joinSource"


	public static class joinSourcePart_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "joinSourcePart"
	// FromClauseParser.g:112:1: joinSourcePart : ( tableSource | virtualTableSource | subQuerySource | partitionedTableFunction ) ( lateralView ^)* ;
	public final HiveParser_FromClauseParser.joinSourcePart_return joinSourcePart() throws RecognitionException {
		HiveParser_FromClauseParser.joinSourcePart_return retval = new HiveParser_FromClauseParser.joinSourcePart_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		ParserRuleReturnScope tableSource39 =null;
		ParserRuleReturnScope virtualTableSource40 =null;
		ParserRuleReturnScope subQuerySource41 =null;
		ParserRuleReturnScope partitionedTableFunction42 =null;
		ParserRuleReturnScope lateralView43 =null;


		 gParent.pushMsg("joinSourcePart", state); 
		try {
			// FromClauseParser.g:115:5: ( ( tableSource | virtualTableSource | subQuerySource | partitionedTableFunction ) ( lateralView ^)* )
			// FromClauseParser.g:116:5: ( tableSource | virtualTableSource | subQuerySource | partitionedTableFunction ) ( lateralView ^)*
			{
			root_0 = (ASTNode)adaptor.nil();


			// FromClauseParser.g:116:5: ( tableSource | virtualTableSource | subQuerySource | partitionedTableFunction )
			int alt14=4;
			alt14 = dfa14.predict(input);
			switch (alt14) {
				case 1 :
					// FromClauseParser.g:116:6: tableSource
					{
					pushFollow(FOLLOW_tableSource_in_joinSourcePart553);
					tableSource39=tableSource();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, tableSource39.getTree());

					}
					break;
				case 2 :
					// FromClauseParser.g:116:20: virtualTableSource
					{
					pushFollow(FOLLOW_virtualTableSource_in_joinSourcePart557);
					virtualTableSource40=virtualTableSource();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, virtualTableSource40.getTree());

					}
					break;
				case 3 :
					// FromClauseParser.g:116:41: subQuerySource
					{
					pushFollow(FOLLOW_subQuerySource_in_joinSourcePart561);
					subQuerySource41=subQuerySource();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, subQuerySource41.getTree());

					}
					break;
				case 4 :
					// FromClauseParser.g:116:58: partitionedTableFunction
					{
					pushFollow(FOLLOW_partitionedTableFunction_in_joinSourcePart565);
					partitionedTableFunction42=partitionedTableFunction();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, partitionedTableFunction42.getTree());

					}
					break;

			}

			// FromClauseParser.g:116:84: ( lateralView ^)*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==COMMA) ) {
					int LA15_24 = input.LA(2);
					if ( (LA15_24==KW_LATERAL) ) {
						alt15=1;
					}

				}
				else if ( (LA15_0==KW_LATERAL) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// FromClauseParser.g:116:85: lateralView ^
					{
					pushFollow(FOLLOW_lateralView_in_joinSourcePart569);
					lateralView43=lateralView();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) root_0 = (ASTNode)adaptor.becomeRoot(lateralView43.getTree(), root_0);
					}
					break;

				default :
					break loop15;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "joinSourcePart"


	public static class uniqueJoinSource_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "uniqueJoinSource"
	// FromClauseParser.g:119:1: uniqueJoinSource : ( KW_PRESERVE )? uniqueJoinTableSource uniqueJoinExpr ;
	public final HiveParser_FromClauseParser.uniqueJoinSource_return uniqueJoinSource() throws RecognitionException {
		HiveParser_FromClauseParser.uniqueJoinSource_return retval = new HiveParser_FromClauseParser.uniqueJoinSource_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_PRESERVE44=null;
		ParserRuleReturnScope uniqueJoinTableSource45 =null;
		ParserRuleReturnScope uniqueJoinExpr46 =null;

		ASTNode KW_PRESERVE44_tree=null;

		 gParent.pushMsg("unique join source", state); 
		try {
			// FromClauseParser.g:122:5: ( ( KW_PRESERVE )? uniqueJoinTableSource uniqueJoinExpr )
			// FromClauseParser.g:122:7: ( KW_PRESERVE )? uniqueJoinTableSource uniqueJoinExpr
			{
			root_0 = (ASTNode)adaptor.nil();


			// FromClauseParser.g:122:7: ( KW_PRESERVE )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==KW_PRESERVE) ) {
				alt16=1;
			}
			switch (alt16) {
				case 1 :
					// FromClauseParser.g:122:7: KW_PRESERVE
					{
					KW_PRESERVE44=(Token)match(input,KW_PRESERVE,FOLLOW_KW_PRESERVE_in_uniqueJoinSource599); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					KW_PRESERVE44_tree = (ASTNode)adaptor.create(KW_PRESERVE44);
					adaptor.addChild(root_0, KW_PRESERVE44_tree);
					}

					}
					break;

			}

			pushFollow(FOLLOW_uniqueJoinTableSource_in_uniqueJoinSource602);
			uniqueJoinTableSource45=uniqueJoinTableSource();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, uniqueJoinTableSource45.getTree());

			pushFollow(FOLLOW_uniqueJoinExpr_in_uniqueJoinSource604);
			uniqueJoinExpr46=uniqueJoinExpr();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, uniqueJoinExpr46.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "uniqueJoinSource"


	public static class uniqueJoinExpr_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "uniqueJoinExpr"
	// FromClauseParser.g:125:1: uniqueJoinExpr : LPAREN ! expressionList RPAREN !;
	public final HiveParser_FromClauseParser.uniqueJoinExpr_return uniqueJoinExpr() throws RecognitionException {
		HiveParser_FromClauseParser.uniqueJoinExpr_return retval = new HiveParser_FromClauseParser.uniqueJoinExpr_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token LPAREN47=null;
		Token RPAREN49=null;
		ParserRuleReturnScope expressionList48 =null;

		ASTNode LPAREN47_tree=null;
		ASTNode RPAREN49_tree=null;

		 gParent.pushMsg("unique join expression list", state); 
		try {
			// FromClauseParser.g:128:5: ( LPAREN ! expressionList RPAREN !)
			// FromClauseParser.g:128:7: LPAREN ! expressionList RPAREN !
			{
			root_0 = (ASTNode)adaptor.nil();


			LPAREN47=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_uniqueJoinExpr631); if (state.failed) return retval;
			pushFollow(FOLLOW_expressionList_in_uniqueJoinExpr634);
			expressionList48=expressionList();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionList48.getTree());

			RPAREN49=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_uniqueJoinExpr636); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "uniqueJoinExpr"


	public static class uniqueJoinToken_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "uniqueJoinToken"
	// FromClauseParser.g:131:1: uniqueJoinToken : KW_UNIQUEJOIN -> TOK_UNIQUEJOIN ;
	public final HiveParser_FromClauseParser.uniqueJoinToken_return uniqueJoinToken() throws RecognitionException {
		HiveParser_FromClauseParser.uniqueJoinToken_return retval = new HiveParser_FromClauseParser.uniqueJoinToken_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_UNIQUEJOIN50=null;

		ASTNode KW_UNIQUEJOIN50_tree=null;
		RewriteRuleTokenStream stream_KW_UNIQUEJOIN=new RewriteRuleTokenStream(adaptor,"token KW_UNIQUEJOIN");

		 gParent.pushMsg("unique join", state); 
		try {
			// FromClauseParser.g:134:5: ( KW_UNIQUEJOIN -> TOK_UNIQUEJOIN )
			// FromClauseParser.g:134:7: KW_UNIQUEJOIN
			{
			KW_UNIQUEJOIN50=(Token)match(input,KW_UNIQUEJOIN,FOLLOW_KW_UNIQUEJOIN_in_uniqueJoinToken664); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_KW_UNIQUEJOIN.add(KW_UNIQUEJOIN50);

			// AST REWRITE
			// elements: 
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 134:21: -> TOK_UNIQUEJOIN
			{
				adaptor.addChild(root_0, (ASTNode)adaptor.create(TOK_UNIQUEJOIN, "TOK_UNIQUEJOIN"));
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "uniqueJoinToken"


	public static class joinToken_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "joinToken"
	// FromClauseParser.g:136:1: joinToken : ( KW_JOIN -> TOK_JOIN | KW_INNER KW_JOIN -> TOK_JOIN | COMMA -> TOK_JOIN | KW_CROSS KW_JOIN -> TOK_CROSSJOIN | KW_LEFT ( KW_OUTER )? KW_JOIN -> TOK_LEFTOUTERJOIN | KW_RIGHT ( KW_OUTER )? KW_JOIN -> TOK_RIGHTOUTERJOIN | KW_FULL ( KW_OUTER )? KW_JOIN -> TOK_FULLOUTERJOIN | KW_LEFT KW_SEMI KW_JOIN -> TOK_LEFTSEMIJOIN );
	public final HiveParser_FromClauseParser.joinToken_return joinToken() throws RecognitionException {
		HiveParser_FromClauseParser.joinToken_return retval = new HiveParser_FromClauseParser.joinToken_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_JOIN51=null;
		Token KW_INNER52=null;
		Token KW_JOIN53=null;
		Token COMMA54=null;
		Token KW_CROSS55=null;
		Token KW_JOIN56=null;
		Token KW_LEFT57=null;
		Token KW_OUTER58=null;
		Token KW_JOIN59=null;
		Token KW_RIGHT60=null;
		Token KW_OUTER61=null;
		Token KW_JOIN62=null;
		Token KW_FULL63=null;
		Token KW_OUTER64=null;
		Token KW_JOIN65=null;
		Token KW_LEFT66=null;
		Token KW_SEMI67=null;
		Token KW_JOIN68=null;

		ASTNode KW_JOIN51_tree=null;
		ASTNode KW_INNER52_tree=null;
		ASTNode KW_JOIN53_tree=null;
		ASTNode COMMA54_tree=null;
		ASTNode KW_CROSS55_tree=null;
		ASTNode KW_JOIN56_tree=null;
		ASTNode KW_LEFT57_tree=null;
		ASTNode KW_OUTER58_tree=null;
		ASTNode KW_JOIN59_tree=null;
		ASTNode KW_RIGHT60_tree=null;
		ASTNode KW_OUTER61_tree=null;
		ASTNode KW_JOIN62_tree=null;
		ASTNode KW_FULL63_tree=null;
		ASTNode KW_OUTER64_tree=null;
		ASTNode KW_JOIN65_tree=null;
		ASTNode KW_LEFT66_tree=null;
		ASTNode KW_SEMI67_tree=null;
		ASTNode KW_JOIN68_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_KW_RIGHT=new RewriteRuleTokenStream(adaptor,"token KW_RIGHT");
		RewriteRuleTokenStream stream_KW_CROSS=new RewriteRuleTokenStream(adaptor,"token KW_CROSS");
		RewriteRuleTokenStream stream_KW_FULL=new RewriteRuleTokenStream(adaptor,"token KW_FULL");
		RewriteRuleTokenStream stream_KW_JOIN=new RewriteRuleTokenStream(adaptor,"token KW_JOIN");
		RewriteRuleTokenStream stream_KW_OUTER=new RewriteRuleTokenStream(adaptor,"token KW_OUTER");
		RewriteRuleTokenStream stream_KW_SEMI=new RewriteRuleTokenStream(adaptor,"token KW_SEMI");
		RewriteRuleTokenStream stream_KW_LEFT=new RewriteRuleTokenStream(adaptor,"token KW_LEFT");
		RewriteRuleTokenStream stream_KW_INNER=new RewriteRuleTokenStream(adaptor,"token KW_INNER");

		 gParent.pushMsg("join type specifier", state); 
		try {
			// FromClauseParser.g:139:5: ( KW_JOIN -> TOK_JOIN | KW_INNER KW_JOIN -> TOK_JOIN | COMMA -> TOK_JOIN | KW_CROSS KW_JOIN -> TOK_CROSSJOIN | KW_LEFT ( KW_OUTER )? KW_JOIN -> TOK_LEFTOUTERJOIN | KW_RIGHT ( KW_OUTER )? KW_JOIN -> TOK_RIGHTOUTERJOIN | KW_FULL ( KW_OUTER )? KW_JOIN -> TOK_FULLOUTERJOIN | KW_LEFT KW_SEMI KW_JOIN -> TOK_LEFTSEMIJOIN )
			int alt20=8;
			switch ( input.LA(1) ) {
			case KW_JOIN:
				{
				alt20=1;
				}
				break;
			case KW_INNER:
				{
				alt20=2;
				}
				break;
			case COMMA:
				{
				alt20=3;
				}
				break;
			case KW_CROSS:
				{
				alt20=4;
				}
				break;
			case KW_LEFT:
				{
				int LA20_5 = input.LA(2);
				if ( (LA20_5==KW_SEMI) ) {
					alt20=8;
				}
				else if ( (LA20_5==KW_JOIN||LA20_5==KW_OUTER) ) {
					alt20=5;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 20, 5, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case KW_RIGHT:
				{
				alt20=6;
				}
				break;
			case KW_FULL:
				{
				alt20=7;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}
			switch (alt20) {
				case 1 :
					// FromClauseParser.g:140:7: KW_JOIN
					{
					KW_JOIN51=(Token)match(input,KW_JOIN,FOLLOW_KW_JOIN_in_joinToken696); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KW_JOIN.add(KW_JOIN51);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 140:36: -> TOK_JOIN
					{
						adaptor.addChild(root_0, (ASTNode)adaptor.create(TOK_JOIN, "TOK_JOIN"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// FromClauseParser.g:141:7: KW_INNER KW_JOIN
					{
					KW_INNER52=(Token)match(input,KW_INNER,FOLLOW_KW_INNER_in_joinToken729); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KW_INNER.add(KW_INNER52);

					KW_JOIN53=(Token)match(input,KW_JOIN,FOLLOW_KW_JOIN_in_joinToken731); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KW_JOIN.add(KW_JOIN53);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 141:36: -> TOK_JOIN
					{
						adaptor.addChild(root_0, (ASTNode)adaptor.create(TOK_JOIN, "TOK_JOIN"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// FromClauseParser.g:142:7: COMMA
					{
					COMMA54=(Token)match(input,COMMA,FOLLOW_COMMA_in_joinToken755); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_COMMA.add(COMMA54);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 142:36: -> TOK_JOIN
					{
						adaptor.addChild(root_0, (ASTNode)adaptor.create(TOK_JOIN, "TOK_JOIN"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// FromClauseParser.g:143:7: KW_CROSS KW_JOIN
					{
					KW_CROSS55=(Token)match(input,KW_CROSS,FOLLOW_KW_CROSS_in_joinToken790); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KW_CROSS.add(KW_CROSS55);

					KW_JOIN56=(Token)match(input,KW_JOIN,FOLLOW_KW_JOIN_in_joinToken792); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KW_JOIN.add(KW_JOIN56);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 143:36: -> TOK_CROSSJOIN
					{
						adaptor.addChild(root_0, (ASTNode)adaptor.create(TOK_CROSSJOIN, "TOK_CROSSJOIN"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					// FromClauseParser.g:144:7: KW_LEFT ( KW_OUTER )? KW_JOIN
					{
					KW_LEFT57=(Token)match(input,KW_LEFT,FOLLOW_KW_LEFT_in_joinToken816); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KW_LEFT.add(KW_LEFT57);

					// FromClauseParser.g:144:16: ( KW_OUTER )?
					int alt17=2;
					int LA17_0 = input.LA(1);
					if ( (LA17_0==KW_OUTER) ) {
						alt17=1;
					}
					switch (alt17) {
						case 1 :
							// FromClauseParser.g:144:17: KW_OUTER
							{
							KW_OUTER58=(Token)match(input,KW_OUTER,FOLLOW_KW_OUTER_in_joinToken820); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_KW_OUTER.add(KW_OUTER58);

							}
							break;

					}

					KW_JOIN59=(Token)match(input,KW_JOIN,FOLLOW_KW_JOIN_in_joinToken824); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KW_JOIN.add(KW_JOIN59);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 144:36: -> TOK_LEFTOUTERJOIN
					{
						adaptor.addChild(root_0, (ASTNode)adaptor.create(TOK_LEFTOUTERJOIN, "TOK_LEFTOUTERJOIN"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 6 :
					// FromClauseParser.g:145:7: KW_RIGHT ( KW_OUTER )? KW_JOIN
					{
					KW_RIGHT60=(Token)match(input,KW_RIGHT,FOLLOW_KW_RIGHT_in_joinToken836); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KW_RIGHT.add(KW_RIGHT60);

					// FromClauseParser.g:145:16: ( KW_OUTER )?
					int alt18=2;
					int LA18_0 = input.LA(1);
					if ( (LA18_0==KW_OUTER) ) {
						alt18=1;
					}
					switch (alt18) {
						case 1 :
							// FromClauseParser.g:145:17: KW_OUTER
							{
							KW_OUTER61=(Token)match(input,KW_OUTER,FOLLOW_KW_OUTER_in_joinToken839); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_KW_OUTER.add(KW_OUTER61);

							}
							break;

					}

					KW_JOIN62=(Token)match(input,KW_JOIN,FOLLOW_KW_JOIN_in_joinToken843); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KW_JOIN.add(KW_JOIN62);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 145:36: -> TOK_RIGHTOUTERJOIN
					{
						adaptor.addChild(root_0, (ASTNode)adaptor.create(TOK_RIGHTOUTERJOIN, "TOK_RIGHTOUTERJOIN"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 7 :
					// FromClauseParser.g:146:7: KW_FULL ( KW_OUTER )? KW_JOIN
					{
					KW_FULL63=(Token)match(input,KW_FULL,FOLLOW_KW_FULL_in_joinToken855); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KW_FULL.add(KW_FULL63);

					// FromClauseParser.g:146:16: ( KW_OUTER )?
					int alt19=2;
					int LA19_0 = input.LA(1);
					if ( (LA19_0==KW_OUTER) ) {
						alt19=1;
					}
					switch (alt19) {
						case 1 :
							// FromClauseParser.g:146:17: KW_OUTER
							{
							KW_OUTER64=(Token)match(input,KW_OUTER,FOLLOW_KW_OUTER_in_joinToken859); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_KW_OUTER.add(KW_OUTER64);

							}
							break;

					}

					KW_JOIN65=(Token)match(input,KW_JOIN,FOLLOW_KW_JOIN_in_joinToken863); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KW_JOIN.add(KW_JOIN65);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 146:36: -> TOK_FULLOUTERJOIN
					{
						adaptor.addChild(root_0, (ASTNode)adaptor.create(TOK_FULLOUTERJOIN, "TOK_FULLOUTERJOIN"));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 8 :
					// FromClauseParser.g:147:7: KW_LEFT KW_SEMI KW_JOIN
					{
					KW_LEFT66=(Token)match(input,KW_LEFT,FOLLOW_KW_LEFT_in_joinToken875); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KW_LEFT.add(KW_LEFT66);

					KW_SEMI67=(Token)match(input,KW_SEMI,FOLLOW_KW_SEMI_in_joinToken877); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KW_SEMI.add(KW_SEMI67);

					KW_JOIN68=(Token)match(input,KW_JOIN,FOLLOW_KW_JOIN_in_joinToken879); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KW_JOIN.add(KW_JOIN68);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 147:36: -> TOK_LEFTSEMIJOIN
					{
						adaptor.addChild(root_0, (ASTNode)adaptor.create(TOK_LEFTSEMIJOIN, "TOK_LEFTSEMIJOIN"));
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "joinToken"


	public static class lateralView_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "lateralView"
	// FromClauseParser.g:150:1: lateralView : ( ( ( COMMA )? KW_LATERAL KW_VIEW KW_OUTER )=> KW_LATERAL KW_VIEW KW_OUTER function tableAlias ( KW_AS identifier ( ( COMMA )=> COMMA identifier )* )? -> ^( TOK_LATERAL_VIEW_OUTER ^( TOK_SELECT ^( TOK_SELEXPR function ( identifier )* tableAlias ) ) ) | ( COMMA )? KW_LATERAL KW_VIEW function tableAlias ( KW_AS identifier ( ( COMMA )=> COMMA identifier )* )? -> ^( TOK_LATERAL_VIEW ^( TOK_SELECT ^( TOK_SELEXPR function ( identifier )* tableAlias ) ) ) | ( COMMA )? KW_LATERAL KW_TABLE LPAREN valuesClause RPAREN ( KW_AS )? tableAlias ( LPAREN identifier ( COMMA identifier )* RPAREN )? -> ^( TOK_LATERAL_VIEW ^( TOK_SELECT ^( TOK_SELEXPR ^( TOK_FUNCTION Identifier[\"inline\"] valuesClause ) ( identifier )* tableAlias ) ) ) );
	public final HiveParser_FromClauseParser.lateralView_return lateralView() throws RecognitionException {
		HiveParser_FromClauseParser.lateralView_return retval = new HiveParser_FromClauseParser.lateralView_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_LATERAL69=null;
		Token KW_VIEW70=null;
		Token KW_OUTER71=null;
		Token KW_AS74=null;
		Token COMMA76=null;
		Token COMMA78=null;
		Token KW_LATERAL79=null;
		Token KW_VIEW80=null;
		Token KW_AS83=null;
		Token COMMA85=null;
		Token COMMA87=null;
		Token KW_LATERAL88=null;
		Token KW_TABLE89=null;
		Token LPAREN90=null;
		Token RPAREN92=null;
		Token KW_AS93=null;
		Token LPAREN95=null;
		Token COMMA97=null;
		Token RPAREN99=null;
		ParserRuleReturnScope function72 =null;
		ParserRuleReturnScope tableAlias73 =null;
		ParserRuleReturnScope identifier75 =null;
		ParserRuleReturnScope identifier77 =null;
		ParserRuleReturnScope function81 =null;
		ParserRuleReturnScope tableAlias82 =null;
		ParserRuleReturnScope identifier84 =null;
		ParserRuleReturnScope identifier86 =null;
		ParserRuleReturnScope valuesClause91 =null;
		ParserRuleReturnScope tableAlias94 =null;
		ParserRuleReturnScope identifier96 =null;
		ParserRuleReturnScope identifier98 =null;

		ASTNode KW_LATERAL69_tree=null;
		ASTNode KW_VIEW70_tree=null;
		ASTNode KW_OUTER71_tree=null;
		ASTNode KW_AS74_tree=null;
		ASTNode COMMA76_tree=null;
		ASTNode COMMA78_tree=null;
		ASTNode KW_LATERAL79_tree=null;
		ASTNode KW_VIEW80_tree=null;
		ASTNode KW_AS83_tree=null;
		ASTNode COMMA85_tree=null;
		ASTNode COMMA87_tree=null;
		ASTNode KW_LATERAL88_tree=null;
		ASTNode KW_TABLE89_tree=null;
		ASTNode LPAREN90_tree=null;
		ASTNode RPAREN92_tree=null;
		ASTNode KW_AS93_tree=null;
		ASTNode LPAREN95_tree=null;
		ASTNode COMMA97_tree=null;
		ASTNode RPAREN99_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_KW_VIEW=new RewriteRuleTokenStream(adaptor,"token KW_VIEW");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_KW_OUTER=new RewriteRuleTokenStream(adaptor,"token KW_OUTER");
		RewriteRuleTokenStream stream_KW_TABLE=new RewriteRuleTokenStream(adaptor,"token KW_TABLE");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_KW_AS=new RewriteRuleTokenStream(adaptor,"token KW_AS");
		RewriteRuleTokenStream stream_KW_LATERAL=new RewriteRuleTokenStream(adaptor,"token KW_LATERAL");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
		RewriteRuleSubtreeStream stream_valuesClause=new RewriteRuleSubtreeStream(adaptor,"rule valuesClause");
		RewriteRuleSubtreeStream stream_function=new RewriteRuleSubtreeStream(adaptor,"rule function");
		RewriteRuleSubtreeStream stream_tableAlias=new RewriteRuleSubtreeStream(adaptor,"rule tableAlias");

		gParent.pushMsg("lateral view", state); 
		try {
			// FromClauseParser.g:153:2: ( ( ( COMMA )? KW_LATERAL KW_VIEW KW_OUTER )=> KW_LATERAL KW_VIEW KW_OUTER function tableAlias ( KW_AS identifier ( ( COMMA )=> COMMA identifier )* )? -> ^( TOK_LATERAL_VIEW_OUTER ^( TOK_SELECT ^( TOK_SELEXPR function ( identifier )* tableAlias ) ) ) | ( COMMA )? KW_LATERAL KW_VIEW function tableAlias ( KW_AS identifier ( ( COMMA )=> COMMA identifier )* )? -> ^( TOK_LATERAL_VIEW ^( TOK_SELECT ^( TOK_SELEXPR function ( identifier )* tableAlias ) ) ) | ( COMMA )? KW_LATERAL KW_TABLE LPAREN valuesClause RPAREN ( KW_AS )? tableAlias ( LPAREN identifier ( COMMA identifier )* RPAREN )? -> ^( TOK_LATERAL_VIEW ^( TOK_SELECT ^( TOK_SELEXPR ^( TOK_FUNCTION Identifier[\"inline\"] valuesClause ) ( identifier )* tableAlias ) ) ) )
			int alt30=3;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==KW_LATERAL) ) {
				int LA30_1 = input.LA(2);
				if ( (LA30_1==KW_VIEW) ) {
					int LA30_3 = input.LA(3);
					if ( (LA30_3==KW_OUTER) && (synpred3_FromClauseParser())) {
						alt30=1;
					}
					else if ( (LA30_3==Identifier||(LA30_3 >= KW_ABORT && LA30_3 <= KW_AFTER)||LA30_3==KW_ALLOC_FRACTION||LA30_3==KW_ANALYZE||(LA30_3 >= KW_ARCHIVE && LA30_3 <= KW_ARRAY)||LA30_3==KW_ASC||(LA30_3 >= KW_AUTOCOMMIT && LA30_3 <= KW_BEFORE)||(LA30_3 >= KW_BIGINT && LA30_3 <= KW_BOOLEAN)||(LA30_3 >= KW_BUCKET && LA30_3 <= KW_BUCKETS)||(LA30_3 >= KW_CACHE && LA30_3 <= KW_CASCADE)||LA30_3==KW_CHANGE||(LA30_3 >= KW_CHECK && LA30_3 <= KW_COLLECTION)||(LA30_3 >= KW_COLUMNS && LA30_3 <= KW_COMMENT)||(LA30_3 >= KW_COMPACT && LA30_3 <= KW_CONCATENATE)||LA30_3==KW_CONTINUE||(LA30_3 >= KW_CURRENT_DATE && LA30_3 <= KW_CURRENT_TIMESTAMP)||LA30_3==KW_DATA||(LA30_3 >= KW_DATABASES && LA30_3 <= KW_DBPROPERTIES)||(LA30_3 >= KW_DEFAULT && LA30_3 <= KW_DEFINED)||(LA30_3 >= KW_DELIMITED && LA30_3 <= KW_DESC)||(LA30_3 >= KW_DETAIL && LA30_3 <= KW_DISABLE)||(LA30_3 >= KW_DISTRIBUTE && LA30_3 <= KW_DOW)||(LA30_3 >= KW_DUMP && LA30_3 <= KW_ELEM_TYPE)||LA30_3==KW_ENABLE||(LA30_3 >= KW_ENFORCED && LA30_3 <= KW_ESCAPED)||LA30_3==KW_EXCLUSIVE||(LA30_3 >= KW_EXPLAIN && LA30_3 <= KW_EXPRESSION)||(LA30_3 >= KW_FIELDS && LA30_3 <= KW_FLOAT)||(LA30_3 >= KW_FORMAT && LA30_3 <= KW_FORMATTED)||LA30_3==KW_FUNCTIONS||LA30_3==KW_GROUPING||(LA30_3 >= KW_HOUR && LA30_3 <= KW_IF)||(LA30_3 >= KW_INDEX && LA30_3 <= KW_INDEXES)||(LA30_3 >= KW_INPATH && LA30_3 <= KW_INPUTFORMAT)||LA30_3==KW_INT||(LA30_3 >= KW_ISOLATION && LA30_3 <= KW_JAR)||(LA30_3 >= KW_KEY && LA30_3 <= KW_LAST)||LA30_3==KW_LEVEL||(LA30_3 >= KW_LIMIT && LA30_3 <= KW_LOAD)||(LA30_3 >= KW_LOCATION && LA30_3 <= KW_LONG)||(LA30_3 >= KW_MANAGEMENT && LA30_3 <= KW_MATERIALIZED)||LA30_3==KW_METADATA||(LA30_3 >= KW_MINUTE && LA30_3 <= KW_MONTH)||(LA30_3 >= KW_MOVE && LA30_3 <= KW_MSCK)||(LA30_3 >= KW_NORELY && LA30_3 <= KW_NOSCAN)||LA30_3==KW_NOVALIDATE||LA30_3==KW_NULLS||LA30_3==KW_OFFSET||(LA30_3 >= KW_OPERATOR && LA30_3 <= KW_OPTION)||(LA30_3 >= KW_OUTPUTDRIVER && LA30_3 <= KW_OUTPUTFORMAT)||(LA30_3 >= KW_OVERWRITE && LA30_3 <= KW_OWNER)||(LA30_3 >= KW_PARTITIONED && LA30_3 <= KW_PATH)||(LA30_3 >= KW_PLAN && LA30_3 <= KW_POOL)||LA30_3==KW_PRINCIPALS||(LA30_3 >= KW_PURGE && LA30_3 <= KW_QUERY_PARALLELISM)||LA30_3==KW_READ||(LA30_3 >= KW_REBUILD && LA30_3 <= KW_RECORDWRITER)||(LA30_3 >= KW_RELOAD && LA30_3 <= KW_RESTRICT)||LA30_3==KW_REWRITE||(LA30_3 >= KW_ROLE && LA30_3 <= KW_ROLES)||(LA30_3 >= KW_SCHEDULING_POLICY && LA30_3 <= KW_SECOND)||(LA30_3 >= KW_SEMI && LA30_3 <= KW_SERVER)||(LA30_3 >= KW_SETS && LA30_3 <= KW_SSL)||(LA30_3 >= KW_STATISTICS && LA30_3 <= KW_SUMMARY)||LA30_3==KW_TABLES||(LA30_3 >= KW_TBLPROPERTIES && LA30_3 <= KW_TERMINATED)||LA30_3==KW_TIMESTAMP||LA30_3==KW_TINYINT||(LA30_3 >= KW_TOUCH && LA30_3 <= KW_TRANSACTIONS)||LA30_3==KW_UNARCHIVE||LA30_3==KW_UNDO||LA30_3==KW_UNIONTYPE||(LA30_3 >= KW_UNLOCK && LA30_3 <= KW_UNSIGNED)||(LA30_3 >= KW_URI && LA30_3 <= KW_USE)||(LA30_3 >= KW_UTC && LA30_3 <= KW_VALIDATE)||LA30_3==KW_VALUE_TYPE||(LA30_3 >= KW_VECTORIZATION && LA30_3 <= KW_WEEK)||LA30_3==KW_WHILE||(LA30_3 >= KW_WORK && LA30_3 <= KW_ZONE)||LA30_3==KW_BATCH||LA30_3==KW_DAYOFWEEK||LA30_3==KW_HOLD_DDLTIME||LA30_3==KW_IGNORE||LA30_3==KW_NO_DROP||LA30_3==KW_OFFLINE||LA30_3==KW_PROTECTION||LA30_3==KW_READONLY||LA30_3==KW_TIMESTAMPTZ) ) {
						alt30=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 30, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA30_1==KW_TABLE) ) {
					alt30=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 30, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA30_0==COMMA) ) {
				int LA30_2 = input.LA(2);
				if ( (LA30_2==KW_LATERAL) ) {
					int LA30_5 = input.LA(3);
					if ( (LA30_5==KW_VIEW) ) {
						alt30=2;
					}
					else if ( (LA30_5==KW_TABLE) ) {
						alt30=3;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 30, 5, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 30, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}

			switch (alt30) {
				case 1 :
					// FromClauseParser.g:154:2: ( ( COMMA )? KW_LATERAL KW_VIEW KW_OUTER )=> KW_LATERAL KW_VIEW KW_OUTER function tableAlias ( KW_AS identifier ( ( COMMA )=> COMMA identifier )* )?
					{
					KW_LATERAL69=(Token)match(input,KW_LATERAL,FOLLOW_KW_LATERAL_in_lateralView926); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KW_LATERAL.add(KW_LATERAL69);

					KW_VIEW70=(Token)match(input,KW_VIEW,FOLLOW_KW_VIEW_in_lateralView928); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KW_VIEW.add(KW_VIEW70);

					KW_OUTER71=(Token)match(input,KW_OUTER,FOLLOW_KW_OUTER_in_lateralView930); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KW_OUTER.add(KW_OUTER71);

					pushFollow(FOLLOW_function_in_lateralView932);
					function72=gHiveParser.function();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_function.add(function72.getTree());
					pushFollow(FOLLOW_tableAlias_in_lateralView934);
					tableAlias73=tableAlias();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_tableAlias.add(tableAlias73.getTree());
					// FromClauseParser.g:154:90: ( KW_AS identifier ( ( COMMA )=> COMMA identifier )* )?
					int alt22=2;
					int LA22_0 = input.LA(1);
					if ( (LA22_0==KW_AS) ) {
						alt22=1;
					}
					switch (alt22) {
						case 1 :
							// FromClauseParser.g:154:91: KW_AS identifier ( ( COMMA )=> COMMA identifier )*
							{
							KW_AS74=(Token)match(input,KW_AS,FOLLOW_KW_AS_in_lateralView937); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_KW_AS.add(KW_AS74);

							pushFollow(FOLLOW_identifier_in_lateralView939);
							identifier75=gHiveParser.identifier();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_identifier.add(identifier75.getTree());
							// FromClauseParser.g:154:108: ( ( COMMA )=> COMMA identifier )*
							loop21:
							while (true) {
								int alt21=2;
								alt21 = dfa21.predict(input);
								switch (alt21) {
								case 1 :
									// FromClauseParser.g:154:109: ( COMMA )=> COMMA identifier
									{
									COMMA76=(Token)match(input,COMMA,FOLLOW_COMMA_in_lateralView947); if (state.failed) return retval; 
									if ( state.backtracking==0 ) stream_COMMA.add(COMMA76);

									pushFollow(FOLLOW_identifier_in_lateralView949);
									identifier77=gHiveParser.identifier();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) stream_identifier.add(identifier77.getTree());
									}
									break;

								default :
									break loop21;
								}
							}

							}
							break;

					}

					// AST REWRITE
					// elements: tableAlias, identifier, function
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 155:2: -> ^( TOK_LATERAL_VIEW_OUTER ^( TOK_SELECT ^( TOK_SELEXPR function ( identifier )* tableAlias ) ) )
					{
						// FromClauseParser.g:155:5: ^( TOK_LATERAL_VIEW_OUTER ^( TOK_SELECT ^( TOK_SELEXPR function ( identifier )* tableAlias ) ) )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_LATERAL_VIEW_OUTER, "TOK_LATERAL_VIEW_OUTER"), root_1);
						// FromClauseParser.g:155:30: ^( TOK_SELECT ^( TOK_SELEXPR function ( identifier )* tableAlias ) )
						{
						ASTNode root_2 = (ASTNode)adaptor.nil();
						root_2 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_SELECT, "TOK_SELECT"), root_2);
						// FromClauseParser.g:155:43: ^( TOK_SELEXPR function ( identifier )* tableAlias )
						{
						ASTNode root_3 = (ASTNode)adaptor.nil();
						root_3 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_SELEXPR, "TOK_SELEXPR"), root_3);
						adaptor.addChild(root_3, stream_function.nextTree());
						// FromClauseParser.g:155:66: ( identifier )*
						while ( stream_identifier.hasNext() ) {
							adaptor.addChild(root_3, stream_identifier.nextTree());
						}
						stream_identifier.reset();

						adaptor.addChild(root_3, stream_tableAlias.nextTree());
						adaptor.addChild(root_2, root_3);
						}

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// FromClauseParser.g:157:2: ( COMMA )? KW_LATERAL KW_VIEW function tableAlias ( KW_AS identifier ( ( COMMA )=> COMMA identifier )* )?
					{
					// FromClauseParser.g:157:2: ( COMMA )?
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0==COMMA) ) {
						alt23=1;
					}
					switch (alt23) {
						case 1 :
							// FromClauseParser.g:157:2: COMMA
							{
							COMMA78=(Token)match(input,COMMA,FOLLOW_COMMA_in_lateralView981); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA78);

							}
							break;

					}

					KW_LATERAL79=(Token)match(input,KW_LATERAL,FOLLOW_KW_LATERAL_in_lateralView984); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KW_LATERAL.add(KW_LATERAL79);

					KW_VIEW80=(Token)match(input,KW_VIEW,FOLLOW_KW_VIEW_in_lateralView986); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KW_VIEW.add(KW_VIEW80);

					pushFollow(FOLLOW_function_in_lateralView988);
					function81=gHiveParser.function();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_function.add(function81.getTree());
					pushFollow(FOLLOW_tableAlias_in_lateralView990);
					tableAlias82=tableAlias();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_tableAlias.add(tableAlias82.getTree());
					// FromClauseParser.g:157:48: ( KW_AS identifier ( ( COMMA )=> COMMA identifier )* )?
					int alt25=2;
					int LA25_0 = input.LA(1);
					if ( (LA25_0==KW_AS) ) {
						alt25=1;
					}
					switch (alt25) {
						case 1 :
							// FromClauseParser.g:157:49: KW_AS identifier ( ( COMMA )=> COMMA identifier )*
							{
							KW_AS83=(Token)match(input,KW_AS,FOLLOW_KW_AS_in_lateralView993); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_KW_AS.add(KW_AS83);

							pushFollow(FOLLOW_identifier_in_lateralView995);
							identifier84=gHiveParser.identifier();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_identifier.add(identifier84.getTree());
							// FromClauseParser.g:157:66: ( ( COMMA )=> COMMA identifier )*
							loop24:
							while (true) {
								int alt24=2;
								alt24 = dfa24.predict(input);
								switch (alt24) {
								case 1 :
									// FromClauseParser.g:157:67: ( COMMA )=> COMMA identifier
									{
									COMMA85=(Token)match(input,COMMA,FOLLOW_COMMA_in_lateralView1003); if (state.failed) return retval; 
									if ( state.backtracking==0 ) stream_COMMA.add(COMMA85);

									pushFollow(FOLLOW_identifier_in_lateralView1005);
									identifier86=gHiveParser.identifier();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) stream_identifier.add(identifier86.getTree());
									}
									break;

								default :
									break loop24;
								}
							}

							}
							break;

					}

					// AST REWRITE
					// elements: identifier, function, tableAlias
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 158:2: -> ^( TOK_LATERAL_VIEW ^( TOK_SELECT ^( TOK_SELEXPR function ( identifier )* tableAlias ) ) )
					{
						// FromClauseParser.g:158:5: ^( TOK_LATERAL_VIEW ^( TOK_SELECT ^( TOK_SELEXPR function ( identifier )* tableAlias ) ) )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_LATERAL_VIEW, "TOK_LATERAL_VIEW"), root_1);
						// FromClauseParser.g:158:24: ^( TOK_SELECT ^( TOK_SELEXPR function ( identifier )* tableAlias ) )
						{
						ASTNode root_2 = (ASTNode)adaptor.nil();
						root_2 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_SELECT, "TOK_SELECT"), root_2);
						// FromClauseParser.g:158:37: ^( TOK_SELEXPR function ( identifier )* tableAlias )
						{
						ASTNode root_3 = (ASTNode)adaptor.nil();
						root_3 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_SELEXPR, "TOK_SELEXPR"), root_3);
						adaptor.addChild(root_3, stream_function.nextTree());
						// FromClauseParser.g:158:60: ( identifier )*
						while ( stream_identifier.hasNext() ) {
							adaptor.addChild(root_3, stream_identifier.nextTree());
						}
						stream_identifier.reset();

						adaptor.addChild(root_3, stream_tableAlias.nextTree());
						adaptor.addChild(root_2, root_3);
						}

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// FromClauseParser.g:160:5: ( COMMA )? KW_LATERAL KW_TABLE LPAREN valuesClause RPAREN ( KW_AS )? tableAlias ( LPAREN identifier ( COMMA identifier )* RPAREN )?
					{
					// FromClauseParser.g:160:5: ( COMMA )?
					int alt26=2;
					int LA26_0 = input.LA(1);
					if ( (LA26_0==COMMA) ) {
						alt26=1;
					}
					switch (alt26) {
						case 1 :
							// FromClauseParser.g:160:5: COMMA
							{
							COMMA87=(Token)match(input,COMMA,FOLLOW_COMMA_in_lateralView1043); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA87);

							}
							break;

					}

					KW_LATERAL88=(Token)match(input,KW_LATERAL,FOLLOW_KW_LATERAL_in_lateralView1046); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KW_LATERAL.add(KW_LATERAL88);

					KW_TABLE89=(Token)match(input,KW_TABLE,FOLLOW_KW_TABLE_in_lateralView1048); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KW_TABLE.add(KW_TABLE89);

					LPAREN90=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_lateralView1050); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN90);

					pushFollow(FOLLOW_valuesClause_in_lateralView1052);
					valuesClause91=valuesClause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_valuesClause.add(valuesClause91.getTree());
					RPAREN92=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_lateralView1054); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN92);

					// FromClauseParser.g:160:59: ( KW_AS )?
					int alt27=2;
					int LA27_0 = input.LA(1);
					if ( (LA27_0==KW_AS) ) {
						alt27=1;
					}
					switch (alt27) {
						case 1 :
							// FromClauseParser.g:160:59: KW_AS
							{
							KW_AS93=(Token)match(input,KW_AS,FOLLOW_KW_AS_in_lateralView1056); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_KW_AS.add(KW_AS93);

							}
							break;

					}

					pushFollow(FOLLOW_tableAlias_in_lateralView1059);
					tableAlias94=tableAlias();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_tableAlias.add(tableAlias94.getTree());
					// FromClauseParser.g:160:77: ( LPAREN identifier ( COMMA identifier )* RPAREN )?
					int alt29=2;
					int LA29_0 = input.LA(1);
					if ( (LA29_0==LPAREN) ) {
						alt29=1;
					}
					switch (alt29) {
						case 1 :
							// FromClauseParser.g:160:78: LPAREN identifier ( COMMA identifier )* RPAREN
							{
							LPAREN95=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_lateralView1062); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN95);

							pushFollow(FOLLOW_identifier_in_lateralView1064);
							identifier96=gHiveParser.identifier();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_identifier.add(identifier96.getTree());
							// FromClauseParser.g:160:96: ( COMMA identifier )*
							loop28:
							while (true) {
								int alt28=2;
								int LA28_0 = input.LA(1);
								if ( (LA28_0==COMMA) ) {
									alt28=1;
								}

								switch (alt28) {
								case 1 :
									// FromClauseParser.g:160:97: COMMA identifier
									{
									COMMA97=(Token)match(input,COMMA,FOLLOW_COMMA_in_lateralView1067); if (state.failed) return retval; 
									if ( state.backtracking==0 ) stream_COMMA.add(COMMA97);

									pushFollow(FOLLOW_identifier_in_lateralView1069);
									identifier98=gHiveParser.identifier();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) stream_identifier.add(identifier98.getTree());
									}
									break;

								default :
									break loop28;
								}
							}

							RPAREN99=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_lateralView1073); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN99);

							}
							break;

					}

					// AST REWRITE
					// elements: valuesClause, tableAlias, identifier
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 161:5: -> ^( TOK_LATERAL_VIEW ^( TOK_SELECT ^( TOK_SELEXPR ^( TOK_FUNCTION Identifier[\"inline\"] valuesClause ) ( identifier )* tableAlias ) ) )
					{
						// FromClauseParser.g:161:8: ^( TOK_LATERAL_VIEW ^( TOK_SELECT ^( TOK_SELEXPR ^( TOK_FUNCTION Identifier[\"inline\"] valuesClause ) ( identifier )* tableAlias ) ) )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_LATERAL_VIEW, "TOK_LATERAL_VIEW"), root_1);
						// FromClauseParser.g:161:27: ^( TOK_SELECT ^( TOK_SELEXPR ^( TOK_FUNCTION Identifier[\"inline\"] valuesClause ) ( identifier )* tableAlias ) )
						{
						ASTNode root_2 = (ASTNode)adaptor.nil();
						root_2 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_SELECT, "TOK_SELECT"), root_2);
						// FromClauseParser.g:161:40: ^( TOK_SELEXPR ^( TOK_FUNCTION Identifier[\"inline\"] valuesClause ) ( identifier )* tableAlias )
						{
						ASTNode root_3 = (ASTNode)adaptor.nil();
						root_3 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_SELEXPR, "TOK_SELEXPR"), root_3);
						// FromClauseParser.g:161:54: ^( TOK_FUNCTION Identifier[\"inline\"] valuesClause )
						{
						ASTNode root_4 = (ASTNode)adaptor.nil();
						root_4 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_FUNCTION, "TOK_FUNCTION"), root_4);
						adaptor.addChild(root_4, (ASTNode)adaptor.create(Identifier, "inline"));
						adaptor.addChild(root_4, stream_valuesClause.nextTree());
						adaptor.addChild(root_3, root_4);
						}

						// FromClauseParser.g:161:104: ( identifier )*
						while ( stream_identifier.hasNext() ) {
							adaptor.addChild(root_3, stream_identifier.nextTree());
						}
						stream_identifier.reset();

						adaptor.addChild(root_3, stream_tableAlias.nextTree());
						adaptor.addChild(root_2, root_3);
						}

						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "lateralView"


	public static class tableAlias_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "tableAlias"
	// FromClauseParser.g:164:1: tableAlias : identifier -> ^( TOK_TABALIAS identifier ) ;
	public final HiveParser_FromClauseParser.tableAlias_return tableAlias() throws RecognitionException {
		HiveParser_FromClauseParser.tableAlias_return retval = new HiveParser_FromClauseParser.tableAlias_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		ParserRuleReturnScope identifier100 =null;

		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");

		gParent.pushMsg("table alias", state); 
		try {
			// FromClauseParser.g:167:5: ( identifier -> ^( TOK_TABALIAS identifier ) )
			// FromClauseParser.g:168:5: identifier
			{
			pushFollow(FOLLOW_identifier_in_tableAlias1135);
			identifier100=gHiveParser.identifier();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_identifier.add(identifier100.getTree());
			// AST REWRITE
			// elements: identifier
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 168:16: -> ^( TOK_TABALIAS identifier )
			{
				// FromClauseParser.g:168:19: ^( TOK_TABALIAS identifier )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_TABALIAS, "TOK_TABALIAS"), root_1);
				adaptor.addChild(root_1, stream_identifier.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tableAlias"


	public static class tableBucketSample_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "tableBucketSample"
	// FromClauseParser.g:171:1: tableBucketSample : KW_TABLESAMPLE LPAREN KW_BUCKET (numerator= Number ) KW_OUT KW_OF (denominator= Number ) ( KW_ON expr+= expression ( COMMA expr+= expression )* )? RPAREN -> ^( TOK_TABLEBUCKETSAMPLE $numerator $denominator ( $expr)* ) ;
	public final HiveParser_FromClauseParser.tableBucketSample_return tableBucketSample() throws RecognitionException {
		HiveParser_FromClauseParser.tableBucketSample_return retval = new HiveParser_FromClauseParser.tableBucketSample_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token numerator=null;
		Token denominator=null;
		Token KW_TABLESAMPLE101=null;
		Token LPAREN102=null;
		Token KW_BUCKET103=null;
		Token KW_OUT104=null;
		Token KW_OF105=null;
		Token KW_ON106=null;
		Token COMMA107=null;
		Token RPAREN108=null;
		List<Object> list_expr=null;
		RuleReturnScope expr = null;
		ASTNode numerator_tree=null;
		ASTNode denominator_tree=null;
		ASTNode KW_TABLESAMPLE101_tree=null;
		ASTNode LPAREN102_tree=null;
		ASTNode KW_BUCKET103_tree=null;
		ASTNode KW_OUT104_tree=null;
		ASTNode KW_OF105_tree=null;
		ASTNode KW_ON106_tree=null;
		ASTNode COMMA107_tree=null;
		ASTNode RPAREN108_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_KW_TABLESAMPLE=new RewriteRuleTokenStream(adaptor,"token KW_TABLESAMPLE");
		RewriteRuleTokenStream stream_KW_OF=new RewriteRuleTokenStream(adaptor,"token KW_OF");
		RewriteRuleTokenStream stream_Number=new RewriteRuleTokenStream(adaptor,"token Number");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_KW_OUT=new RewriteRuleTokenStream(adaptor,"token KW_OUT");
		RewriteRuleTokenStream stream_KW_ON=new RewriteRuleTokenStream(adaptor,"token KW_ON");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_KW_BUCKET=new RewriteRuleTokenStream(adaptor,"token KW_BUCKET");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		 gParent.pushMsg("table bucket sample specification", state); 
		try {
			// FromClauseParser.g:174:5: ( KW_TABLESAMPLE LPAREN KW_BUCKET (numerator= Number ) KW_OUT KW_OF (denominator= Number ) ( KW_ON expr+= expression ( COMMA expr+= expression )* )? RPAREN -> ^( TOK_TABLEBUCKETSAMPLE $numerator $denominator ( $expr)* ) )
			// FromClauseParser.g:175:5: KW_TABLESAMPLE LPAREN KW_BUCKET (numerator= Number ) KW_OUT KW_OF (denominator= Number ) ( KW_ON expr+= expression ( COMMA expr+= expression )* )? RPAREN
			{
			KW_TABLESAMPLE101=(Token)match(input,KW_TABLESAMPLE,FOLLOW_KW_TABLESAMPLE_in_tableBucketSample1174); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_KW_TABLESAMPLE.add(KW_TABLESAMPLE101);

			LPAREN102=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_tableBucketSample1176); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN102);

			KW_BUCKET103=(Token)match(input,KW_BUCKET,FOLLOW_KW_BUCKET_in_tableBucketSample1178); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_KW_BUCKET.add(KW_BUCKET103);

			// FromClauseParser.g:175:37: (numerator= Number )
			// FromClauseParser.g:175:38: numerator= Number
			{
			numerator=(Token)match(input,Number,FOLLOW_Number_in_tableBucketSample1183); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Number.add(numerator);

			}

			KW_OUT104=(Token)match(input,KW_OUT,FOLLOW_KW_OUT_in_tableBucketSample1186); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_KW_OUT.add(KW_OUT104);

			KW_OF105=(Token)match(input,KW_OF,FOLLOW_KW_OF_in_tableBucketSample1188); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_KW_OF.add(KW_OF105);

			// FromClauseParser.g:175:69: (denominator= Number )
			// FromClauseParser.g:175:70: denominator= Number
			{
			denominator=(Token)match(input,Number,FOLLOW_Number_in_tableBucketSample1193); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_Number.add(denominator);

			}

			// FromClauseParser.g:175:90: ( KW_ON expr+= expression ( COMMA expr+= expression )* )?
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==KW_ON) ) {
				alt32=1;
			}
			switch (alt32) {
				case 1 :
					// FromClauseParser.g:175:91: KW_ON expr+= expression ( COMMA expr+= expression )*
					{
					KW_ON106=(Token)match(input,KW_ON,FOLLOW_KW_ON_in_tableBucketSample1197); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KW_ON.add(KW_ON106);

					pushFollow(FOLLOW_expression_in_tableBucketSample1201);
					expr=gHiveParser.expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expression.add(expr.getTree());
					if (list_expr==null) list_expr=new ArrayList<Object>();
					list_expr.add(expr.getTree());
					// FromClauseParser.g:175:114: ( COMMA expr+= expression )*
					loop31:
					while (true) {
						int alt31=2;
						int LA31_0 = input.LA(1);
						if ( (LA31_0==COMMA) ) {
							alt31=1;
						}

						switch (alt31) {
						case 1 :
							// FromClauseParser.g:175:115: COMMA expr+= expression
							{
							COMMA107=(Token)match(input,COMMA,FOLLOW_COMMA_in_tableBucketSample1204); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA107);

							pushFollow(FOLLOW_expression_in_tableBucketSample1208);
							expr=gHiveParser.expression();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_expression.add(expr.getTree());
							if (list_expr==null) list_expr=new ArrayList<Object>();
							list_expr.add(expr.getTree());
							}
							break;

						default :
							break loop31;
						}
					}

					}
					break;

			}

			RPAREN108=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_tableBucketSample1214); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN108);

			// AST REWRITE
			// elements: denominator, numerator, expr
			// token labels: denominator, numerator
			// rule labels: retval
			// token list labels: 
			// rule list labels: expr
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_denominator=new RewriteRuleTokenStream(adaptor,"token denominator",denominator);
			RewriteRuleTokenStream stream_numerator=new RewriteRuleTokenStream(adaptor,"token numerator",numerator);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
			RewriteRuleSubtreeStream stream_expr=new RewriteRuleSubtreeStream(adaptor,"token expr",list_expr);
			root_0 = (ASTNode)adaptor.nil();
			// 175:149: -> ^( TOK_TABLEBUCKETSAMPLE $numerator $denominator ( $expr)* )
			{
				// FromClauseParser.g:175:152: ^( TOK_TABLEBUCKETSAMPLE $numerator $denominator ( $expr)* )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_TABLEBUCKETSAMPLE, "TOK_TABLEBUCKETSAMPLE"), root_1);
				adaptor.addChild(root_1, stream_numerator.nextNode());
				adaptor.addChild(root_1, stream_denominator.nextNode());
				// FromClauseParser.g:175:201: ( $expr)*
				while ( stream_expr.hasNext() ) {
					adaptor.addChild(root_1, stream_expr.nextTree());
				}
				stream_expr.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tableBucketSample"


	public static class splitSample_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "splitSample"
	// FromClauseParser.g:178:1: splitSample : ( KW_TABLESAMPLE LPAREN (numerator= Number ) (percent= KW_PERCENT | KW_ROWS ) RPAREN -> {percent != null}? ^( TOK_TABLESPLITSAMPLE TOK_PERCENT $numerator) -> ^( TOK_TABLESPLITSAMPLE TOK_ROWCOUNT $numerator) | KW_TABLESAMPLE LPAREN (numerator= ByteLengthLiteral ) RPAREN -> ^( TOK_TABLESPLITSAMPLE TOK_LENGTH $numerator) );
	public final HiveParser_FromClauseParser.splitSample_return splitSample() throws RecognitionException {
		HiveParser_FromClauseParser.splitSample_return retval = new HiveParser_FromClauseParser.splitSample_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token numerator=null;
		Token percent=null;
		Token KW_TABLESAMPLE109=null;
		Token LPAREN110=null;
		Token KW_ROWS111=null;
		Token RPAREN112=null;
		Token KW_TABLESAMPLE113=null;
		Token LPAREN114=null;
		Token RPAREN115=null;

		ASTNode numerator_tree=null;
		ASTNode percent_tree=null;
		ASTNode KW_TABLESAMPLE109_tree=null;
		ASTNode LPAREN110_tree=null;
		ASTNode KW_ROWS111_tree=null;
		ASTNode RPAREN112_tree=null;
		ASTNode KW_TABLESAMPLE113_tree=null;
		ASTNode LPAREN114_tree=null;
		ASTNode RPAREN115_tree=null;
		RewriteRuleTokenStream stream_KW_TABLESAMPLE=new RewriteRuleTokenStream(adaptor,"token KW_TABLESAMPLE");
		RewriteRuleTokenStream stream_Number=new RewriteRuleTokenStream(adaptor,"token Number");
		RewriteRuleTokenStream stream_KW_ROWS=new RewriteRuleTokenStream(adaptor,"token KW_ROWS");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_KW_PERCENT=new RewriteRuleTokenStream(adaptor,"token KW_PERCENT");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_ByteLengthLiteral=new RewriteRuleTokenStream(adaptor,"token ByteLengthLiteral");

		 gParent.pushMsg("table split sample specification", state); 
		try {
			// FromClauseParser.g:181:5: ( KW_TABLESAMPLE LPAREN (numerator= Number ) (percent= KW_PERCENT | KW_ROWS ) RPAREN -> {percent != null}? ^( TOK_TABLESPLITSAMPLE TOK_PERCENT $numerator) -> ^( TOK_TABLESPLITSAMPLE TOK_ROWCOUNT $numerator) | KW_TABLESAMPLE LPAREN (numerator= ByteLengthLiteral ) RPAREN -> ^( TOK_TABLESPLITSAMPLE TOK_LENGTH $numerator) )
			int alt34=2;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==KW_TABLESAMPLE) ) {
				int LA34_1 = input.LA(2);
				if ( (LA34_1==LPAREN) ) {
					int LA34_2 = input.LA(3);
					if ( (LA34_2==Number) ) {
						alt34=1;
					}
					else if ( (LA34_2==ByteLengthLiteral) ) {
						alt34=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 34, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 34, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 34, 0, input);
				throw nvae;
			}

			switch (alt34) {
				case 1 :
					// FromClauseParser.g:182:5: KW_TABLESAMPLE LPAREN (numerator= Number ) (percent= KW_PERCENT | KW_ROWS ) RPAREN
					{
					KW_TABLESAMPLE109=(Token)match(input,KW_TABLESAMPLE,FOLLOW_KW_TABLESAMPLE_in_splitSample1261); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KW_TABLESAMPLE.add(KW_TABLESAMPLE109);

					LPAREN110=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_splitSample1263); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN110);

					// FromClauseParser.g:182:28: (numerator= Number )
					// FromClauseParser.g:182:29: numerator= Number
					{
					numerator=(Token)match(input,Number,FOLLOW_Number_in_splitSample1269); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Number.add(numerator);

					}

					// FromClauseParser.g:182:47: (percent= KW_PERCENT | KW_ROWS )
					int alt33=2;
					int LA33_0 = input.LA(1);
					if ( (LA33_0==KW_PERCENT) ) {
						alt33=1;
					}
					else if ( (LA33_0==KW_ROWS) ) {
						alt33=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 33, 0, input);
						throw nvae;
					}

					switch (alt33) {
						case 1 :
							// FromClauseParser.g:182:48: percent= KW_PERCENT
							{
							percent=(Token)match(input,KW_PERCENT,FOLLOW_KW_PERCENT_in_splitSample1275); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_KW_PERCENT.add(percent);

							}
							break;
						case 2 :
							// FromClauseParser.g:182:67: KW_ROWS
							{
							KW_ROWS111=(Token)match(input,KW_ROWS,FOLLOW_KW_ROWS_in_splitSample1277); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_KW_ROWS.add(KW_ROWS111);

							}
							break;

					}

					RPAREN112=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_splitSample1280); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN112);

					// AST REWRITE
					// elements: numerator, numerator
					// token labels: numerator
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_numerator=new RewriteRuleTokenStream(adaptor,"token numerator",numerator);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 183:5: -> {percent != null}? ^( TOK_TABLESPLITSAMPLE TOK_PERCENT $numerator)
					if (percent != null) {
						// FromClauseParser.g:183:27: ^( TOK_TABLESPLITSAMPLE TOK_PERCENT $numerator)
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_TABLESPLITSAMPLE, "TOK_TABLESPLITSAMPLE"), root_1);
						adaptor.addChild(root_1, (ASTNode)adaptor.create(TOK_PERCENT, "TOK_PERCENT"));
						adaptor.addChild(root_1, stream_numerator.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}

					else // 184:5: -> ^( TOK_TABLESPLITSAMPLE TOK_ROWCOUNT $numerator)
					{
						// FromClauseParser.g:184:8: ^( TOK_TABLESPLITSAMPLE TOK_ROWCOUNT $numerator)
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_TABLESPLITSAMPLE, "TOK_TABLESPLITSAMPLE"), root_1);
						adaptor.addChild(root_1, (ASTNode)adaptor.create(TOK_ROWCOUNT, "TOK_ROWCOUNT"));
						adaptor.addChild(root_1, stream_numerator.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// FromClauseParser.g:186:5: KW_TABLESAMPLE LPAREN (numerator= ByteLengthLiteral ) RPAREN
					{
					KW_TABLESAMPLE113=(Token)match(input,KW_TABLESAMPLE,FOLLOW_KW_TABLESAMPLE_in_splitSample1324); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KW_TABLESAMPLE.add(KW_TABLESAMPLE113);

					LPAREN114=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_splitSample1326); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN114);

					// FromClauseParser.g:186:28: (numerator= ByteLengthLiteral )
					// FromClauseParser.g:186:29: numerator= ByteLengthLiteral
					{
					numerator=(Token)match(input,ByteLengthLiteral,FOLLOW_ByteLengthLiteral_in_splitSample1332); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_ByteLengthLiteral.add(numerator);

					}

					RPAREN115=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_splitSample1335); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN115);

					// AST REWRITE
					// elements: numerator
					// token labels: numerator
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_numerator=new RewriteRuleTokenStream(adaptor,"token numerator",numerator);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 187:5: -> ^( TOK_TABLESPLITSAMPLE TOK_LENGTH $numerator)
					{
						// FromClauseParser.g:187:8: ^( TOK_TABLESPLITSAMPLE TOK_LENGTH $numerator)
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_TABLESPLITSAMPLE, "TOK_TABLESPLITSAMPLE"), root_1);
						adaptor.addChild(root_1, (ASTNode)adaptor.create(TOK_LENGTH, "TOK_LENGTH"));
						adaptor.addChild(root_1, stream_numerator.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "splitSample"


	public static class tableSample_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "tableSample"
	// FromClauseParser.g:190:1: tableSample : ( tableBucketSample | splitSample );
	public final HiveParser_FromClauseParser.tableSample_return tableSample() throws RecognitionException {
		HiveParser_FromClauseParser.tableSample_return retval = new HiveParser_FromClauseParser.tableSample_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		ParserRuleReturnScope tableBucketSample116 =null;
		ParserRuleReturnScope splitSample117 =null;


		 gParent.pushMsg("table sample specification", state); 
		try {
			// FromClauseParser.g:193:5: ( tableBucketSample | splitSample )
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==KW_TABLESAMPLE) ) {
				int LA35_1 = input.LA(2);
				if ( (LA35_1==LPAREN) ) {
					int LA35_2 = input.LA(3);
					if ( (LA35_2==KW_BUCKET) ) {
						alt35=1;
					}
					else if ( (LA35_2==ByteLengthLiteral||LA35_2==Number) ) {
						alt35=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 35, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 35, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 35, 0, input);
				throw nvae;
			}

			switch (alt35) {
				case 1 :
					// FromClauseParser.g:194:5: tableBucketSample
					{
					root_0 = (ASTNode)adaptor.nil();


					pushFollow(FOLLOW_tableBucketSample_in_tableSample1381);
					tableBucketSample116=tableBucketSample();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, tableBucketSample116.getTree());

					}
					break;
				case 2 :
					// FromClauseParser.g:195:5: splitSample
					{
					root_0 = (ASTNode)adaptor.nil();


					pushFollow(FOLLOW_splitSample_in_tableSample1389);
					splitSample117=splitSample();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, splitSample117.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tableSample"


	public static class tableSource_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "tableSource"
	// FromClauseParser.g:198:1: tableSource : tabname= tableName (props= tableProperties )? (ts= tableSample )? ( ( KW_AS )? alias= identifier )? -> ^( TOK_TABREF $tabname ( $props)? ( $ts)? ( $alias)? ) ;
	public final HiveParser_FromClauseParser.tableSource_return tableSource() throws RecognitionException {
		HiveParser_FromClauseParser.tableSource_return retval = new HiveParser_FromClauseParser.tableSource_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_AS118=null;
		ParserRuleReturnScope tabname =null;
		ParserRuleReturnScope props =null;
		ParserRuleReturnScope ts =null;
		ParserRuleReturnScope alias =null;

		ASTNode KW_AS118_tree=null;
		RewriteRuleTokenStream stream_KW_AS=new RewriteRuleTokenStream(adaptor,"token KW_AS");
		RewriteRuleSubtreeStream stream_tableSample=new RewriteRuleSubtreeStream(adaptor,"rule tableSample");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
		RewriteRuleSubtreeStream stream_tableProperties=new RewriteRuleSubtreeStream(adaptor,"rule tableProperties");
		RewriteRuleSubtreeStream stream_tableName=new RewriteRuleSubtreeStream(adaptor,"rule tableName");

		 gParent.pushMsg("table source", state); 
		try {
			// FromClauseParser.g:201:5: (tabname= tableName (props= tableProperties )? (ts= tableSample )? ( ( KW_AS )? alias= identifier )? -> ^( TOK_TABREF $tabname ( $props)? ( $ts)? ( $alias)? ) )
			// FromClauseParser.g:201:7: tabname= tableName (props= tableProperties )? (ts= tableSample )? ( ( KW_AS )? alias= identifier )?
			{
			pushFollow(FOLLOW_tableName_in_tableSource1418);
			tabname=tableName();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_tableName.add(tabname.getTree());
			// FromClauseParser.g:201:30: (props= tableProperties )?
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==LPAREN) ) {
				alt36=1;
			}
			switch (alt36) {
				case 1 :
					// FromClauseParser.g:201:30: props= tableProperties
					{
					pushFollow(FOLLOW_tableProperties_in_tableSource1422);
					props=gHiveParser.tableProperties();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_tableProperties.add(props.getTree());
					}
					break;

			}

			// FromClauseParser.g:201:50: (ts= tableSample )?
			int alt37=2;
			int LA37_0 = input.LA(1);
			if ( (LA37_0==KW_TABLESAMPLE) ) {
				alt37=1;
			}
			switch (alt37) {
				case 1 :
					// FromClauseParser.g:201:50: ts= tableSample
					{
					pushFollow(FOLLOW_tableSample_in_tableSource1427);
					ts=tableSample();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_tableSample.add(ts.getTree());
					}
					break;

			}

			// FromClauseParser.g:201:64: ( ( KW_AS )? alias= identifier )?
			int alt39=2;
			alt39 = dfa39.predict(input);
			switch (alt39) {
				case 1 :
					// FromClauseParser.g:201:65: ( KW_AS )? alias= identifier
					{
					// FromClauseParser.g:201:65: ( KW_AS )?
					int alt38=2;
					int LA38_0 = input.LA(1);
					if ( (LA38_0==KW_AS) ) {
						alt38=1;
					}
					switch (alt38) {
						case 1 :
							// FromClauseParser.g:201:65: KW_AS
							{
							KW_AS118=(Token)match(input,KW_AS,FOLLOW_KW_AS_in_tableSource1431); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_KW_AS.add(KW_AS118);

							}
							break;

					}

					pushFollow(FOLLOW_identifier_in_tableSource1436);
					alias=gHiveParser.identifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_identifier.add(alias.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: tabname, alias, ts, props
			// token labels: 
			// rule labels: tabname, alias, retval, ts, props
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_tabname=new RewriteRuleSubtreeStream(adaptor,"rule tabname",tabname!=null?tabname.getTree():null);
			RewriteRuleSubtreeStream stream_alias=new RewriteRuleSubtreeStream(adaptor,"rule alias",alias!=null?alias.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
			RewriteRuleSubtreeStream stream_ts=new RewriteRuleSubtreeStream(adaptor,"rule ts",ts!=null?ts.getTree():null);
			RewriteRuleSubtreeStream stream_props=new RewriteRuleSubtreeStream(adaptor,"rule props",props!=null?props.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 202:5: -> ^( TOK_TABREF $tabname ( $props)? ( $ts)? ( $alias)? )
			{
				// FromClauseParser.g:202:8: ^( TOK_TABREF $tabname ( $props)? ( $ts)? ( $alias)? )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_TABREF, "TOK_TABREF"), root_1);
				adaptor.addChild(root_1, stream_tabname.nextTree());
				// FromClauseParser.g:202:31: ( $props)?
				if ( stream_props.hasNext() ) {
					adaptor.addChild(root_1, stream_props.nextTree());
				}
				stream_props.reset();

				// FromClauseParser.g:202:39: ( $ts)?
				if ( stream_ts.hasNext() ) {
					adaptor.addChild(root_1, stream_ts.nextTree());
				}
				stream_ts.reset();

				// FromClauseParser.g:202:44: ( $alias)?
				if ( stream_alias.hasNext() ) {
					adaptor.addChild(root_1, stream_alias.nextTree());
				}
				stream_alias.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tableSource"


	public static class uniqueJoinTableSource_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "uniqueJoinTableSource"
	// FromClauseParser.g:205:1: uniqueJoinTableSource : tabname= tableName (ts= tableSample )? ( ( KW_AS )? alias= identifier )? -> ^( TOK_TABREF $tabname ( $ts)? ( $alias)? ) ;
	public final HiveParser_FromClauseParser.uniqueJoinTableSource_return uniqueJoinTableSource() throws RecognitionException {
		HiveParser_FromClauseParser.uniqueJoinTableSource_return retval = new HiveParser_FromClauseParser.uniqueJoinTableSource_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_AS119=null;
		ParserRuleReturnScope tabname =null;
		ParserRuleReturnScope ts =null;
		ParserRuleReturnScope alias =null;

		ASTNode KW_AS119_tree=null;
		RewriteRuleTokenStream stream_KW_AS=new RewriteRuleTokenStream(adaptor,"token KW_AS");
		RewriteRuleSubtreeStream stream_tableSample=new RewriteRuleSubtreeStream(adaptor,"rule tableSample");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
		RewriteRuleSubtreeStream stream_tableName=new RewriteRuleSubtreeStream(adaptor,"rule tableName");

		 gParent.pushMsg("unique join table source", state); 
		try {
			// FromClauseParser.g:208:5: (tabname= tableName (ts= tableSample )? ( ( KW_AS )? alias= identifier )? -> ^( TOK_TABREF $tabname ( $ts)? ( $alias)? ) )
			// FromClauseParser.g:208:7: tabname= tableName (ts= tableSample )? ( ( KW_AS )? alias= identifier )?
			{
			pushFollow(FOLLOW_tableName_in_uniqueJoinTableSource1492);
			tabname=tableName();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_tableName.add(tabname.getTree());
			// FromClauseParser.g:208:27: (ts= tableSample )?
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( (LA40_0==KW_TABLESAMPLE) ) {
				alt40=1;
			}
			switch (alt40) {
				case 1 :
					// FromClauseParser.g:208:27: ts= tableSample
					{
					pushFollow(FOLLOW_tableSample_in_uniqueJoinTableSource1496);
					ts=tableSample();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_tableSample.add(ts.getTree());
					}
					break;

			}

			// FromClauseParser.g:208:41: ( ( KW_AS )? alias= identifier )?
			int alt42=2;
			int LA42_0 = input.LA(1);
			if ( (LA42_0==Identifier||(LA42_0 >= KW_ABORT && LA42_0 <= KW_AFTER)||LA42_0==KW_ALLOC_FRACTION||LA42_0==KW_ANALYZE||LA42_0==KW_ARCHIVE||(LA42_0 >= KW_AS && LA42_0 <= KW_ASC)||(LA42_0 >= KW_AUTOCOMMIT && LA42_0 <= KW_BEFORE)||(LA42_0 >= KW_BUCKET && LA42_0 <= KW_BUCKETS)||(LA42_0 >= KW_CACHE && LA42_0 <= KW_CASCADE)||LA42_0==KW_CHANGE||(LA42_0 >= KW_CHECK && LA42_0 <= KW_COLLECTION)||(LA42_0 >= KW_COLUMNS && LA42_0 <= KW_COMMENT)||(LA42_0 >= KW_COMPACT && LA42_0 <= KW_CONCATENATE)||LA42_0==KW_CONTINUE||LA42_0==KW_DATA||LA42_0==KW_DATABASES||(LA42_0 >= KW_DATETIME && LA42_0 <= KW_DBPROPERTIES)||(LA42_0 >= KW_DEFAULT && LA42_0 <= KW_DEFINED)||(LA42_0 >= KW_DELIMITED && LA42_0 <= KW_DESC)||(LA42_0 >= KW_DETAIL && LA42_0 <= KW_DISABLE)||(LA42_0 >= KW_DISTRIBUTE && LA42_0 <= KW_DO)||LA42_0==KW_DOW||(LA42_0 >= KW_DUMP && LA42_0 <= KW_ELEM_TYPE)||LA42_0==KW_ENABLE||(LA42_0 >= KW_ENFORCED && LA42_0 <= KW_ESCAPED)||LA42_0==KW_EXCLUSIVE||(LA42_0 >= KW_EXPLAIN && LA42_0 <= KW_EXPRESSION)||(LA42_0 >= KW_FIELDS && LA42_0 <= KW_FIRST)||(LA42_0 >= KW_FORMAT && LA42_0 <= KW_FORMATTED)||LA42_0==KW_FUNCTIONS||(LA42_0 >= KW_HOUR && LA42_0 <= KW_IDXPROPERTIES)||(LA42_0 >= KW_INDEX && LA42_0 <= KW_INDEXES)||(LA42_0 >= KW_INPATH && LA42_0 <= KW_INPUTFORMAT)||(LA42_0 >= KW_ISOLATION && LA42_0 <= KW_JAR)||(LA42_0 >= KW_KEY && LA42_0 <= KW_LAST)||LA42_0==KW_LEVEL||(LA42_0 >= KW_LIMIT && LA42_0 <= KW_LOAD)||(LA42_0 >= KW_LOCATION && LA42_0 <= KW_LONG)||LA42_0==KW_MANAGEMENT||(LA42_0 >= KW_MAPJOIN && LA42_0 <= KW_MATERIALIZED)||LA42_0==KW_METADATA||(LA42_0 >= KW_MINUTE && LA42_0 <= KW_MONTH)||(LA42_0 >= KW_MOVE && LA42_0 <= KW_MSCK)||(LA42_0 >= KW_NORELY && LA42_0 <= KW_NOSCAN)||LA42_0==KW_NOVALIDATE||LA42_0==KW_NULLS||LA42_0==KW_OFFSET||(LA42_0 >= KW_OPERATOR && LA42_0 <= KW_OPTION)||(LA42_0 >= KW_OUTPUTDRIVER && LA42_0 <= KW_OUTPUTFORMAT)||(LA42_0 >= KW_OVERWRITE && LA42_0 <= KW_OWNER)||(LA42_0 >= KW_PARTITIONED && LA42_0 <= KW_PATH)||(LA42_0 >= KW_PLAN && LA42_0 <= KW_POOL)||LA42_0==KW_PRINCIPALS||(LA42_0 >= KW_PURGE && LA42_0 <= KW_QUERY_PARALLELISM)||LA42_0==KW_READ||(LA42_0 >= KW_REBUILD && LA42_0 <= KW_RECORDWRITER)||(LA42_0 >= KW_RELOAD && LA42_0 <= KW_RESTRICT)||LA42_0==KW_REWRITE||(LA42_0 >= KW_ROLE && LA42_0 <= KW_ROLES)||(LA42_0 >= KW_SCHEDULING_POLICY && LA42_0 <= KW_SECOND)||(LA42_0 >= KW_SEMI && LA42_0 <= KW_SERVER)||(LA42_0 >= KW_SETS && LA42_0 <= KW_SKEWED)||(LA42_0 >= KW_SNAPSHOT && LA42_0 <= KW_SSL)||(LA42_0 >= KW_STATISTICS && LA42_0 <= KW_SUMMARY)||LA42_0==KW_TABLES||(LA42_0 >= KW_TBLPROPERTIES && LA42_0 <= KW_TERMINATED)||LA42_0==KW_TINYINT||(LA42_0 >= KW_TOUCH && LA42_0 <= KW_TRANSACTIONS)||LA42_0==KW_UNARCHIVE||LA42_0==KW_UNDO||LA42_0==KW_UNIONTYPE||(LA42_0 >= KW_UNLOCK && LA42_0 <= KW_UNSIGNED)||(LA42_0 >= KW_URI && LA42_0 <= KW_USE)||(LA42_0 >= KW_UTC && LA42_0 <= KW_VALIDATE)||LA42_0==KW_VALUE_TYPE||(LA42_0 >= KW_VECTORIZATION && LA42_0 <= KW_WEEK)||LA42_0==KW_WHILE||(LA42_0 >= KW_WORK && LA42_0 <= KW_ZONE)||LA42_0==KW_BATCH||LA42_0==KW_DAYOFWEEK||LA42_0==KW_HOLD_DDLTIME||LA42_0==KW_IGNORE||LA42_0==KW_NO_DROP||LA42_0==KW_OFFLINE||LA42_0==KW_PROTECTION||LA42_0==KW_READONLY||LA42_0==KW_TIMESTAMPTZ) ) {
				alt42=1;
			}
			switch (alt42) {
				case 1 :
					// FromClauseParser.g:208:42: ( KW_AS )? alias= identifier
					{
					// FromClauseParser.g:208:42: ( KW_AS )?
					int alt41=2;
					int LA41_0 = input.LA(1);
					if ( (LA41_0==KW_AS) ) {
						alt41=1;
					}
					switch (alt41) {
						case 1 :
							// FromClauseParser.g:208:42: KW_AS
							{
							KW_AS119=(Token)match(input,KW_AS,FOLLOW_KW_AS_in_uniqueJoinTableSource1500); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_KW_AS.add(KW_AS119);

							}
							break;

					}

					pushFollow(FOLLOW_identifier_in_uniqueJoinTableSource1505);
					alias=gHiveParser.identifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_identifier.add(alias.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: tabname, ts, alias
			// token labels: 
			// rule labels: tabname, alias, retval, ts
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_tabname=new RewriteRuleSubtreeStream(adaptor,"rule tabname",tabname!=null?tabname.getTree():null);
			RewriteRuleSubtreeStream stream_alias=new RewriteRuleSubtreeStream(adaptor,"rule alias",alias!=null?alias.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
			RewriteRuleSubtreeStream stream_ts=new RewriteRuleSubtreeStream(adaptor,"rule ts",ts!=null?ts.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 209:5: -> ^( TOK_TABREF $tabname ( $ts)? ( $alias)? )
			{
				// FromClauseParser.g:209:8: ^( TOK_TABREF $tabname ( $ts)? ( $alias)? )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_TABREF, "TOK_TABREF"), root_1);
				adaptor.addChild(root_1, stream_tabname.nextTree());
				// FromClauseParser.g:209:31: ( $ts)?
				if ( stream_ts.hasNext() ) {
					adaptor.addChild(root_1, stream_ts.nextTree());
				}
				stream_ts.reset();

				// FromClauseParser.g:209:36: ( $alias)?
				if ( stream_alias.hasNext() ) {
					adaptor.addChild(root_1, stream_alias.nextTree());
				}
				stream_alias.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "uniqueJoinTableSource"


	public static class tableName_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "tableName"
	// FromClauseParser.g:212:1: tableName : (db= identifier DOT tab= identifier -> ^( TOK_TABNAME $db $tab) |tab= identifier -> ^( TOK_TABNAME $tab) );
	public final HiveParser_FromClauseParser.tableName_return tableName() throws RecognitionException {
		HiveParser_FromClauseParser.tableName_return retval = new HiveParser_FromClauseParser.tableName_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token DOT120=null;
		ParserRuleReturnScope db =null;
		ParserRuleReturnScope tab =null;

		ASTNode DOT120_tree=null;
		RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");

		 gParent.pushMsg("table name", state); 
		try {
			// FromClauseParser.g:215:5: (db= identifier DOT tab= identifier -> ^( TOK_TABNAME $db $tab) |tab= identifier -> ^( TOK_TABNAME $tab) )
			int alt43=2;
			alt43 = dfa43.predict(input);
			switch (alt43) {
				case 1 :
					// FromClauseParser.g:216:5: db= identifier DOT tab= identifier
					{
					pushFollow(FOLLOW_identifier_in_tableName1561);
					db=gHiveParser.identifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_identifier.add(db.getTree());
					DOT120=(Token)match(input,DOT,FOLLOW_DOT_in_tableName1563); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_DOT.add(DOT120);

					pushFollow(FOLLOW_identifier_in_tableName1567);
					tab=gHiveParser.identifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_identifier.add(tab.getTree());
					// AST REWRITE
					// elements: db, tab
					// token labels: 
					// rule labels: tab, db, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_tab=new RewriteRuleSubtreeStream(adaptor,"rule tab",tab!=null?tab.getTree():null);
					RewriteRuleSubtreeStream stream_db=new RewriteRuleSubtreeStream(adaptor,"rule db",db!=null?db.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 217:5: -> ^( TOK_TABNAME $db $tab)
					{
						// FromClauseParser.g:217:8: ^( TOK_TABNAME $db $tab)
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_TABNAME, "TOK_TABNAME"), root_1);
						adaptor.addChild(root_1, stream_db.nextTree());
						adaptor.addChild(root_1, stream_tab.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// FromClauseParser.g:219:5: tab= identifier
					{
					pushFollow(FOLLOW_identifier_in_tableName1597);
					tab=gHiveParser.identifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_identifier.add(tab.getTree());
					// AST REWRITE
					// elements: tab
					// token labels: 
					// rule labels: tab, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_tab=new RewriteRuleSubtreeStream(adaptor,"rule tab",tab!=null?tab.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 220:5: -> ^( TOK_TABNAME $tab)
					{
						// FromClauseParser.g:220:8: ^( TOK_TABNAME $tab)
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_TABNAME, "TOK_TABNAME"), root_1);
						adaptor.addChild(root_1, stream_tab.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tableName"


	public static class viewName_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "viewName"
	// FromClauseParser.g:223:1: viewName : (db= identifier DOT )? view= identifier -> ^( TOK_TABNAME ( $db)? $view) ;
	public final HiveParser_FromClauseParser.viewName_return viewName() throws RecognitionException {
		HiveParser_FromClauseParser.viewName_return retval = new HiveParser_FromClauseParser.viewName_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token DOT121=null;
		ParserRuleReturnScope db =null;
		ParserRuleReturnScope view =null;

		ASTNode DOT121_tree=null;
		RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");

		 gParent.pushMsg("view name", state); 
		try {
			// FromClauseParser.g:226:5: ( (db= identifier DOT )? view= identifier -> ^( TOK_TABNAME ( $db)? $view) )
			// FromClauseParser.g:227:5: (db= identifier DOT )? view= identifier
			{
			// FromClauseParser.g:227:5: (db= identifier DOT )?
			int alt44=2;
			int LA44_0 = input.LA(1);
			if ( (LA44_0==Identifier) ) {
				int LA44_1 = input.LA(2);
				if ( (LA44_1==DOT) ) {
					alt44=1;
				}
			}
			else if ( ((LA44_0 >= KW_ABORT && LA44_0 <= KW_AFTER)||LA44_0==KW_ALLOC_FRACTION||LA44_0==KW_ANALYZE||LA44_0==KW_ARCHIVE||LA44_0==KW_ASC||(LA44_0 >= KW_AUTOCOMMIT && LA44_0 <= KW_BEFORE)||(LA44_0 >= KW_BUCKET && LA44_0 <= KW_BUCKETS)||(LA44_0 >= KW_CACHE && LA44_0 <= KW_CASCADE)||LA44_0==KW_CHANGE||(LA44_0 >= KW_CHECK && LA44_0 <= KW_COLLECTION)||(LA44_0 >= KW_COLUMNS && LA44_0 <= KW_COMMENT)||(LA44_0 >= KW_COMPACT && LA44_0 <= KW_CONCATENATE)||LA44_0==KW_CONTINUE||LA44_0==KW_DATA||LA44_0==KW_DATABASES||(LA44_0 >= KW_DATETIME && LA44_0 <= KW_DBPROPERTIES)||(LA44_0 >= KW_DEFAULT && LA44_0 <= KW_DEFINED)||(LA44_0 >= KW_DELIMITED && LA44_0 <= KW_DESC)||(LA44_0 >= KW_DETAIL && LA44_0 <= KW_DISABLE)||(LA44_0 >= KW_DISTRIBUTE && LA44_0 <= KW_DO)||LA44_0==KW_DOW||(LA44_0 >= KW_DUMP && LA44_0 <= KW_ELEM_TYPE)||LA44_0==KW_ENABLE||(LA44_0 >= KW_ENFORCED && LA44_0 <= KW_ESCAPED)||LA44_0==KW_EXCLUSIVE||(LA44_0 >= KW_EXPLAIN && LA44_0 <= KW_EXPRESSION)||(LA44_0 >= KW_FIELDS && LA44_0 <= KW_FIRST)||(LA44_0 >= KW_FORMAT && LA44_0 <= KW_FORMATTED)||LA44_0==KW_FUNCTIONS||(LA44_0 >= KW_HOUR && LA44_0 <= KW_IDXPROPERTIES)||(LA44_0 >= KW_INDEX && LA44_0 <= KW_INDEXES)||(LA44_0 >= KW_INPATH && LA44_0 <= KW_INPUTFORMAT)||(LA44_0 >= KW_ISOLATION && LA44_0 <= KW_JAR)||(LA44_0 >= KW_KEY && LA44_0 <= KW_LAST)||LA44_0==KW_LEVEL||(LA44_0 >= KW_LIMIT && LA44_0 <= KW_LOAD)||(LA44_0 >= KW_LOCATION && LA44_0 <= KW_LONG)||LA44_0==KW_MANAGEMENT||(LA44_0 >= KW_MAPJOIN && LA44_0 <= KW_MATERIALIZED)||LA44_0==KW_METADATA||(LA44_0 >= KW_MINUTE && LA44_0 <= KW_MONTH)||(LA44_0 >= KW_MOVE && LA44_0 <= KW_MSCK)||(LA44_0 >= KW_NORELY && LA44_0 <= KW_NOSCAN)||LA44_0==KW_NOVALIDATE||LA44_0==KW_NULLS||LA44_0==KW_OFFSET||(LA44_0 >= KW_OPERATOR && LA44_0 <= KW_OPTION)||(LA44_0 >= KW_OUTPUTDRIVER && LA44_0 <= KW_OUTPUTFORMAT)||(LA44_0 >= KW_OVERWRITE && LA44_0 <= KW_OWNER)||(LA44_0 >= KW_PARTITIONED && LA44_0 <= KW_PATH)||(LA44_0 >= KW_PLAN && LA44_0 <= KW_POOL)||LA44_0==KW_PRINCIPALS||(LA44_0 >= KW_PURGE && LA44_0 <= KW_QUERY_PARALLELISM)||LA44_0==KW_READ||(LA44_0 >= KW_REBUILD && LA44_0 <= KW_RECORDWRITER)||(LA44_0 >= KW_RELOAD && LA44_0 <= KW_RESTRICT)||LA44_0==KW_REWRITE||(LA44_0 >= KW_ROLE && LA44_0 <= KW_ROLES)||(LA44_0 >= KW_SCHEDULING_POLICY && LA44_0 <= KW_SECOND)||(LA44_0 >= KW_SEMI && LA44_0 <= KW_SERVER)||(LA44_0 >= KW_SETS && LA44_0 <= KW_SKEWED)||(LA44_0 >= KW_SNAPSHOT && LA44_0 <= KW_SSL)||(LA44_0 >= KW_STATISTICS && LA44_0 <= KW_SUMMARY)||LA44_0==KW_TABLES||(LA44_0 >= KW_TBLPROPERTIES && LA44_0 <= KW_TERMINATED)||LA44_0==KW_TINYINT||(LA44_0 >= KW_TOUCH && LA44_0 <= KW_TRANSACTIONS)||LA44_0==KW_UNARCHIVE||LA44_0==KW_UNDO||LA44_0==KW_UNIONTYPE||(LA44_0 >= KW_UNLOCK && LA44_0 <= KW_UNSIGNED)||(LA44_0 >= KW_URI && LA44_0 <= KW_USE)||(LA44_0 >= KW_UTC && LA44_0 <= KW_VALIDATE)||LA44_0==KW_VALUE_TYPE||(LA44_0 >= KW_VECTORIZATION && LA44_0 <= KW_WEEK)||LA44_0==KW_WHILE||(LA44_0 >= KW_WORK && LA44_0 <= KW_ZONE)||LA44_0==KW_BATCH||LA44_0==KW_DAYOFWEEK||LA44_0==KW_HOLD_DDLTIME||LA44_0==KW_IGNORE||LA44_0==KW_NO_DROP||LA44_0==KW_OFFLINE||LA44_0==KW_PROTECTION||LA44_0==KW_READONLY||LA44_0==KW_TIMESTAMPTZ) ) {
				int LA44_2 = input.LA(2);
				if ( (LA44_2==DOT) ) {
					alt44=1;
				}
			}
			switch (alt44) {
				case 1 :
					// FromClauseParser.g:227:6: db= identifier DOT
					{
					pushFollow(FOLLOW_identifier_in_viewName1644);
					db=gHiveParser.identifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_identifier.add(db.getTree());
					DOT121=(Token)match(input,DOT,FOLLOW_DOT_in_viewName1646); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_DOT.add(DOT121);

					}
					break;

			}

			pushFollow(FOLLOW_identifier_in_viewName1652);
			view=gHiveParser.identifier();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_identifier.add(view.getTree());
			// AST REWRITE
			// elements: db, view
			// token labels: 
			// rule labels: view, db, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_view=new RewriteRuleSubtreeStream(adaptor,"rule view",view!=null?view.getTree():null);
			RewriteRuleSubtreeStream stream_db=new RewriteRuleSubtreeStream(adaptor,"rule db",db!=null?db.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 228:5: -> ^( TOK_TABNAME ( $db)? $view)
			{
				// FromClauseParser.g:228:8: ^( TOK_TABNAME ( $db)? $view)
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_TABNAME, "TOK_TABNAME"), root_1);
				// FromClauseParser.g:228:23: ( $db)?
				if ( stream_db.hasNext() ) {
					adaptor.addChild(root_1, stream_db.nextTree());
				}
				stream_db.reset();

				adaptor.addChild(root_1, stream_view.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "viewName"


	public static class subQuerySource_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "subQuerySource"
	// FromClauseParser.g:231:1: subQuerySource : LPAREN queryStatementExpression RPAREN ( KW_AS )? identifier -> ^( TOK_SUBQUERY queryStatementExpression identifier ) ;
	public final HiveParser_FromClauseParser.subQuerySource_return subQuerySource() throws RecognitionException {
		HiveParser_FromClauseParser.subQuerySource_return retval = new HiveParser_FromClauseParser.subQuerySource_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token LPAREN122=null;
		Token RPAREN124=null;
		Token KW_AS125=null;
		ParserRuleReturnScope queryStatementExpression123 =null;
		ParserRuleReturnScope identifier126 =null;

		ASTNode LPAREN122_tree=null;
		ASTNode RPAREN124_tree=null;
		ASTNode KW_AS125_tree=null;
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_KW_AS=new RewriteRuleTokenStream(adaptor,"token KW_AS");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
		RewriteRuleSubtreeStream stream_queryStatementExpression=new RewriteRuleSubtreeStream(adaptor,"rule queryStatementExpression");

		 gParent.pushMsg("subquery source", state); 
		try {
			// FromClauseParser.g:234:5: ( LPAREN queryStatementExpression RPAREN ( KW_AS )? identifier -> ^( TOK_SUBQUERY queryStatementExpression identifier ) )
			// FromClauseParser.g:235:5: LPAREN queryStatementExpression RPAREN ( KW_AS )? identifier
			{
			LPAREN122=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_subQuerySource1700); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN122);

			pushFollow(FOLLOW_queryStatementExpression_in_subQuerySource1702);
			queryStatementExpression123=gHiveParser.queryStatementExpression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_queryStatementExpression.add(queryStatementExpression123.getTree());
			RPAREN124=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_subQuerySource1704); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN124);

			// FromClauseParser.g:235:44: ( KW_AS )?
			int alt45=2;
			int LA45_0 = input.LA(1);
			if ( (LA45_0==KW_AS) ) {
				alt45=1;
			}
			switch (alt45) {
				case 1 :
					// FromClauseParser.g:235:44: KW_AS
					{
					KW_AS125=(Token)match(input,KW_AS,FOLLOW_KW_AS_in_subQuerySource1706); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KW_AS.add(KW_AS125);

					}
					break;

			}

			pushFollow(FOLLOW_identifier_in_subQuerySource1709);
			identifier126=gHiveParser.identifier();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_identifier.add(identifier126.getTree());
			// AST REWRITE
			// elements: queryStatementExpression, identifier
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 235:62: -> ^( TOK_SUBQUERY queryStatementExpression identifier )
			{
				// FromClauseParser.g:235:65: ^( TOK_SUBQUERY queryStatementExpression identifier )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_SUBQUERY, "TOK_SUBQUERY"), root_1);
				adaptor.addChild(root_1, stream_queryStatementExpression.nextTree());
				adaptor.addChild(root_1, stream_identifier.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "subQuerySource"


	public static class partitioningSpec_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "partitioningSpec"
	// FromClauseParser.g:239:1: partitioningSpec : ( partitionByClause ( orderByClause )? -> ^( TOK_PARTITIONINGSPEC partitionByClause ( orderByClause )? ) | orderByClause -> ^( TOK_PARTITIONINGSPEC orderByClause ) | distributeByClause ( sortByClause )? -> ^( TOK_PARTITIONINGSPEC distributeByClause ( sortByClause )? ) | sortByClause -> ^( TOK_PARTITIONINGSPEC sortByClause ) | clusterByClause -> ^( TOK_PARTITIONINGSPEC clusterByClause ) );
	public final HiveParser_FromClauseParser.partitioningSpec_return partitioningSpec() throws RecognitionException {
		HiveParser_FromClauseParser.partitioningSpec_return retval = new HiveParser_FromClauseParser.partitioningSpec_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		ParserRuleReturnScope partitionByClause127 =null;
		ParserRuleReturnScope orderByClause128 =null;
		ParserRuleReturnScope orderByClause129 =null;
		ParserRuleReturnScope distributeByClause130 =null;
		ParserRuleReturnScope sortByClause131 =null;
		ParserRuleReturnScope sortByClause132 =null;
		ParserRuleReturnScope clusterByClause133 =null;

		RewriteRuleSubtreeStream stream_clusterByClause=new RewriteRuleSubtreeStream(adaptor,"rule clusterByClause");
		RewriteRuleSubtreeStream stream_sortByClause=new RewriteRuleSubtreeStream(adaptor,"rule sortByClause");
		RewriteRuleSubtreeStream stream_partitionByClause=new RewriteRuleSubtreeStream(adaptor,"rule partitionByClause");
		RewriteRuleSubtreeStream stream_distributeByClause=new RewriteRuleSubtreeStream(adaptor,"rule distributeByClause");
		RewriteRuleSubtreeStream stream_orderByClause=new RewriteRuleSubtreeStream(adaptor,"rule orderByClause");

		 gParent.pushMsg("partitioningSpec clause", state); 
		try {
			// FromClauseParser.g:242:4: ( partitionByClause ( orderByClause )? -> ^( TOK_PARTITIONINGSPEC partitionByClause ( orderByClause )? ) | orderByClause -> ^( TOK_PARTITIONINGSPEC orderByClause ) | distributeByClause ( sortByClause )? -> ^( TOK_PARTITIONINGSPEC distributeByClause ( sortByClause )? ) | sortByClause -> ^( TOK_PARTITIONINGSPEC sortByClause ) | clusterByClause -> ^( TOK_PARTITIONINGSPEC clusterByClause ) )
			int alt48=5;
			switch ( input.LA(1) ) {
			case KW_PARTITION:
				{
				alt48=1;
				}
				break;
			case KW_ORDER:
				{
				alt48=2;
				}
				break;
			case KW_DISTRIBUTE:
				{
				alt48=3;
				}
				break;
			case KW_SORT:
				{
				alt48=4;
				}
				break;
			case KW_CLUSTER:
				{
				alt48=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 48, 0, input);
				throw nvae;
			}
			switch (alt48) {
				case 1 :
					// FromClauseParser.g:243:4: partitionByClause ( orderByClause )?
					{
					pushFollow(FOLLOW_partitionByClause_in_partitioningSpec1750);
					partitionByClause127=gHiveParser.partitionByClause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_partitionByClause.add(partitionByClause127.getTree());
					// FromClauseParser.g:243:22: ( orderByClause )?
					int alt46=2;
					int LA46_0 = input.LA(1);
					if ( (LA46_0==KW_ORDER) ) {
						alt46=1;
					}
					switch (alt46) {
						case 1 :
							// FromClauseParser.g:243:22: orderByClause
							{
							pushFollow(FOLLOW_orderByClause_in_partitioningSpec1752);
							orderByClause128=gHiveParser.orderByClause();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_orderByClause.add(orderByClause128.getTree());
							}
							break;

					}

					// AST REWRITE
					// elements: orderByClause, partitionByClause
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 243:37: -> ^( TOK_PARTITIONINGSPEC partitionByClause ( orderByClause )? )
					{
						// FromClauseParser.g:243:40: ^( TOK_PARTITIONINGSPEC partitionByClause ( orderByClause )? )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_PARTITIONINGSPEC, "TOK_PARTITIONINGSPEC"), root_1);
						adaptor.addChild(root_1, stream_partitionByClause.nextTree());
						// FromClauseParser.g:243:81: ( orderByClause )?
						if ( stream_orderByClause.hasNext() ) {
							adaptor.addChild(root_1, stream_orderByClause.nextTree());
						}
						stream_orderByClause.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// FromClauseParser.g:244:4: orderByClause
					{
					pushFollow(FOLLOW_orderByClause_in_partitioningSpec1771);
					orderByClause129=gHiveParser.orderByClause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_orderByClause.add(orderByClause129.getTree());
					// AST REWRITE
					// elements: orderByClause
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 244:18: -> ^( TOK_PARTITIONINGSPEC orderByClause )
					{
						// FromClauseParser.g:244:21: ^( TOK_PARTITIONINGSPEC orderByClause )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_PARTITIONINGSPEC, "TOK_PARTITIONINGSPEC"), root_1);
						adaptor.addChild(root_1, stream_orderByClause.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// FromClauseParser.g:245:4: distributeByClause ( sortByClause )?
					{
					pushFollow(FOLLOW_distributeByClause_in_partitioningSpec1786);
					distributeByClause130=gHiveParser.distributeByClause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_distributeByClause.add(distributeByClause130.getTree());
					// FromClauseParser.g:245:23: ( sortByClause )?
					int alt47=2;
					int LA47_0 = input.LA(1);
					if ( (LA47_0==KW_SORT) ) {
						alt47=1;
					}
					switch (alt47) {
						case 1 :
							// FromClauseParser.g:245:23: sortByClause
							{
							pushFollow(FOLLOW_sortByClause_in_partitioningSpec1788);
							sortByClause131=gHiveParser.sortByClause();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_sortByClause.add(sortByClause131.getTree());
							}
							break;

					}

					// AST REWRITE
					// elements: distributeByClause, sortByClause
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 245:37: -> ^( TOK_PARTITIONINGSPEC distributeByClause ( sortByClause )? )
					{
						// FromClauseParser.g:245:40: ^( TOK_PARTITIONINGSPEC distributeByClause ( sortByClause )? )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_PARTITIONINGSPEC, "TOK_PARTITIONINGSPEC"), root_1);
						adaptor.addChild(root_1, stream_distributeByClause.nextTree());
						// FromClauseParser.g:245:82: ( sortByClause )?
						if ( stream_sortByClause.hasNext() ) {
							adaptor.addChild(root_1, stream_sortByClause.nextTree());
						}
						stream_sortByClause.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 4 :
					// FromClauseParser.g:246:4: sortByClause
					{
					pushFollow(FOLLOW_sortByClause_in_partitioningSpec1807);
					sortByClause132=gHiveParser.sortByClause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_sortByClause.add(sortByClause132.getTree());
					// AST REWRITE
					// elements: sortByClause
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 246:17: -> ^( TOK_PARTITIONINGSPEC sortByClause )
					{
						// FromClauseParser.g:246:20: ^( TOK_PARTITIONINGSPEC sortByClause )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_PARTITIONINGSPEC, "TOK_PARTITIONINGSPEC"), root_1);
						adaptor.addChild(root_1, stream_sortByClause.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 5 :
					// FromClauseParser.g:247:4: clusterByClause
					{
					pushFollow(FOLLOW_clusterByClause_in_partitioningSpec1822);
					clusterByClause133=gHiveParser.clusterByClause();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_clusterByClause.add(clusterByClause133.getTree());
					// AST REWRITE
					// elements: clusterByClause
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 247:20: -> ^( TOK_PARTITIONINGSPEC clusterByClause )
					{
						// FromClauseParser.g:247:23: ^( TOK_PARTITIONINGSPEC clusterByClause )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_PARTITIONINGSPEC, "TOK_PARTITIONINGSPEC"), root_1);
						adaptor.addChild(root_1, stream_clusterByClause.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "partitioningSpec"


	public static class partitionTableFunctionSource_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "partitionTableFunctionSource"
	// FromClauseParser.g:250:1: partitionTableFunctionSource : ( subQuerySource | tableSource | partitionedTableFunction );
	public final HiveParser_FromClauseParser.partitionTableFunctionSource_return partitionTableFunctionSource() throws RecognitionException {
		HiveParser_FromClauseParser.partitionTableFunctionSource_return retval = new HiveParser_FromClauseParser.partitionTableFunctionSource_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		ParserRuleReturnScope subQuerySource134 =null;
		ParserRuleReturnScope tableSource135 =null;
		ParserRuleReturnScope partitionedTableFunction136 =null;


		 gParent.pushMsg("partitionTableFunctionSource clause", state); 
		try {
			// FromClauseParser.g:253:4: ( subQuerySource | tableSource | partitionedTableFunction )
			int alt49=3;
			switch ( input.LA(1) ) {
			case LPAREN:
				{
				alt49=1;
				}
				break;
			case Identifier:
				{
				int LA49_2 = input.LA(2);
				if ( (LA49_2==EOF||LA49_2==DOT||LA49_2==Identifier||(LA49_2 >= KW_ABORT && LA49_2 <= KW_AFTER)||LA49_2==KW_ALLOC_FRACTION||LA49_2==KW_ANALYZE||LA49_2==KW_ARCHIVE||(LA49_2 >= KW_AS && LA49_2 <= KW_ASC)||(LA49_2 >= KW_AUTOCOMMIT && LA49_2 <= KW_BEFORE)||(LA49_2 >= KW_BUCKET && LA49_2 <= KW_BUCKETS)||(LA49_2 >= KW_CACHE && LA49_2 <= KW_CASCADE)||LA49_2==KW_CHANGE||(LA49_2 >= KW_CHECK && LA49_2 <= KW_COLLECTION)||(LA49_2 >= KW_COLUMNS && LA49_2 <= KW_COMMENT)||(LA49_2 >= KW_COMPACT && LA49_2 <= KW_CONCATENATE)||LA49_2==KW_CONTINUE||LA49_2==KW_DATA||LA49_2==KW_DATABASES||(LA49_2 >= KW_DATETIME && LA49_2 <= KW_DBPROPERTIES)||(LA49_2 >= KW_DEFAULT && LA49_2 <= KW_DEFINED)||(LA49_2 >= KW_DELIMITED && LA49_2 <= KW_DESC)||(LA49_2 >= KW_DETAIL && LA49_2 <= KW_DISABLE)||(LA49_2 >= KW_DISTRIBUTE && LA49_2 <= KW_DO)||LA49_2==KW_DOW||(LA49_2 >= KW_DUMP && LA49_2 <= KW_ELEM_TYPE)||LA49_2==KW_ENABLE||(LA49_2 >= KW_ENFORCED && LA49_2 <= KW_ESCAPED)||LA49_2==KW_EXCLUSIVE||(LA49_2 >= KW_EXPLAIN && LA49_2 <= KW_EXPRESSION)||(LA49_2 >= KW_FIELDS && LA49_2 <= KW_FIRST)||(LA49_2 >= KW_FORMAT && LA49_2 <= KW_FORMATTED)||LA49_2==KW_FUNCTIONS||(LA49_2 >= KW_HOUR && LA49_2 <= KW_IDXPROPERTIES)||(LA49_2 >= KW_INDEX && LA49_2 <= KW_INDEXES)||(LA49_2 >= KW_INPATH && LA49_2 <= KW_INPUTFORMAT)||(LA49_2 >= KW_ISOLATION && LA49_2 <= KW_JAR)||(LA49_2 >= KW_KEY && LA49_2 <= KW_LAST)||LA49_2==KW_LEVEL||(LA49_2 >= KW_LIMIT && LA49_2 <= KW_LOAD)||(LA49_2 >= KW_LOCATION && LA49_2 <= KW_LONG)||LA49_2==KW_MANAGEMENT||(LA49_2 >= KW_MAPJOIN && LA49_2 <= KW_MATERIALIZED)||LA49_2==KW_METADATA||(LA49_2 >= KW_MINUTE && LA49_2 <= KW_MONTH)||(LA49_2 >= KW_MOVE && LA49_2 <= KW_MSCK)||(LA49_2 >= KW_NORELY && LA49_2 <= KW_NOSCAN)||LA49_2==KW_NOVALIDATE||LA49_2==KW_NULLS||LA49_2==KW_OFFSET||(LA49_2 >= KW_OPERATOR && LA49_2 <= KW_OPTION)||LA49_2==KW_ORDER||(LA49_2 >= KW_OUTPUTDRIVER && LA49_2 <= KW_OUTPUTFORMAT)||(LA49_2 >= KW_OVERWRITE && LA49_2 <= KW_PATH)||(LA49_2 >= KW_PLAN && LA49_2 <= KW_POOL)||LA49_2==KW_PRINCIPALS||(LA49_2 >= KW_PURGE && LA49_2 <= KW_QUERY_PARALLELISM)||LA49_2==KW_READ||(LA49_2 >= KW_REBUILD && LA49_2 <= KW_RECORDWRITER)||(LA49_2 >= KW_RELOAD && LA49_2 <= KW_RESTRICT)||LA49_2==KW_REWRITE||(LA49_2 >= KW_ROLE && LA49_2 <= KW_ROLES)||(LA49_2 >= KW_SCHEDULING_POLICY && LA49_2 <= KW_SECOND)||(LA49_2 >= KW_SEMI && LA49_2 <= KW_SERVER)||(LA49_2 >= KW_SETS && LA49_2 <= KW_SKEWED)||(LA49_2 >= KW_SNAPSHOT && LA49_2 <= KW_SSL)||(LA49_2 >= KW_STATISTICS && LA49_2 <= KW_SUMMARY)||(LA49_2 >= KW_TABLES && LA49_2 <= KW_TERMINATED)||LA49_2==KW_TINYINT||(LA49_2 >= KW_TOUCH && LA49_2 <= KW_TRANSACTIONS)||LA49_2==KW_UNARCHIVE||LA49_2==KW_UNDO||LA49_2==KW_UNIONTYPE||(LA49_2 >= KW_UNLOCK && LA49_2 <= KW_UNSIGNED)||(LA49_2 >= KW_URI && LA49_2 <= KW_USE)||(LA49_2 >= KW_UTC && LA49_2 <= KW_VALIDATE)||LA49_2==KW_VALUE_TYPE||(LA49_2 >= KW_VECTORIZATION && LA49_2 <= KW_WEEK)||LA49_2==KW_WHILE||(LA49_2 >= KW_WORK && LA49_2 <= KW_ZONE)||LA49_2==RPAREN||LA49_2==KW_BATCH||LA49_2==KW_DAYOFWEEK||LA49_2==KW_HOLD_DDLTIME||LA49_2==KW_IGNORE||LA49_2==KW_NO_DROP||LA49_2==KW_OFFLINE||LA49_2==KW_PROTECTION||LA49_2==KW_READONLY||LA49_2==KW_TIMESTAMPTZ) ) {
					alt49=2;
				}
				else if ( (LA49_2==LPAREN) ) {
					int LA49_5 = input.LA(3);
					if ( (LA49_5==KW_ON) ) {
						alt49=3;
					}
					else if ( (LA49_5==StringLiteral) ) {
						alt49=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 49, 5, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 49, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case KW_ABORT:
			case KW_ACTIVATE:
			case KW_ACTIVE:
			case KW_ADD:
			case KW_ADMIN:
			case KW_AFTER:
			case KW_ALLOC_FRACTION:
			case KW_ANALYZE:
			case KW_ARCHIVE:
			case KW_ASC:
			case KW_AUTOCOMMIT:
			case KW_BEFORE:
			case KW_BUCKET:
			case KW_BUCKETS:
			case KW_CACHE:
			case KW_CASCADE:
			case KW_CHANGE:
			case KW_CHECK:
			case KW_CLUSTER:
			case KW_CLUSTERED:
			case KW_CLUSTERSTATUS:
			case KW_COLLECTION:
			case KW_COLUMNS:
			case KW_COMMENT:
			case KW_COMPACT:
			case KW_COMPACTIONS:
			case KW_COMPUTE:
			case KW_CONCATENATE:
			case KW_CONTINUE:
			case KW_DATA:
			case KW_DATABASES:
			case KW_DATETIME:
			case KW_DAY:
			case KW_DBPROPERTIES:
			case KW_DEFAULT:
			case KW_DEFERRED:
			case KW_DEFINED:
			case KW_DELIMITED:
			case KW_DEPENDENCY:
			case KW_DESC:
			case KW_DETAIL:
			case KW_DIRECTORIES:
			case KW_DIRECTORY:
			case KW_DISABLE:
			case KW_DISTRIBUTE:
			case KW_DO:
			case KW_DOW:
			case KW_DUMP:
			case KW_ELEM_TYPE:
			case KW_ENABLE:
			case KW_ENFORCED:
			case KW_ESCAPED:
			case KW_EXCLUSIVE:
			case KW_EXPLAIN:
			case KW_EXPORT:
			case KW_EXPRESSION:
			case KW_FIELDS:
			case KW_FILE:
			case KW_FILEFORMAT:
			case KW_FIRST:
			case KW_FORMAT:
			case KW_FORMATTED:
			case KW_FUNCTIONS:
			case KW_HOUR:
			case KW_IDXPROPERTIES:
			case KW_INDEX:
			case KW_INDEXES:
			case KW_INPATH:
			case KW_INPUTDRIVER:
			case KW_INPUTFORMAT:
			case KW_ISOLATION:
			case KW_ITEMS:
			case KW_JAR:
			case KW_KEY:
			case KW_KEYS:
			case KW_KEY_TYPE:
			case KW_KILL:
			case KW_LAST:
			case KW_LEVEL:
			case KW_LIMIT:
			case KW_LINES:
			case KW_LOAD:
			case KW_LOCATION:
			case KW_LOCK:
			case KW_LOCKS:
			case KW_LOGICAL:
			case KW_LONG:
			case KW_MANAGEMENT:
			case KW_MAPJOIN:
			case KW_MAPPING:
			case KW_MATCHED:
			case KW_MATERIALIZED:
			case KW_METADATA:
			case KW_MINUTE:
			case KW_MONTH:
			case KW_MOVE:
			case KW_MSCK:
			case KW_NORELY:
			case KW_NOSCAN:
			case KW_NOVALIDATE:
			case KW_NULLS:
			case KW_OFFSET:
			case KW_OPERATOR:
			case KW_OPTION:
			case KW_OUTPUTDRIVER:
			case KW_OUTPUTFORMAT:
			case KW_OVERWRITE:
			case KW_OWNER:
			case KW_PARTITIONED:
			case KW_PARTITIONS:
			case KW_PATH:
			case KW_PLAN:
			case KW_PLANS:
			case KW_PLUS:
			case KW_POOL:
			case KW_PRINCIPALS:
			case KW_PURGE:
			case KW_QUARTER:
			case KW_QUERY:
			case KW_QUERY_PARALLELISM:
			case KW_READ:
			case KW_REBUILD:
			case KW_RECORDREADER:
			case KW_RECORDWRITER:
			case KW_RELOAD:
			case KW_RELY:
			case KW_RENAME:
			case KW_REOPTIMIZATION:
			case KW_REPAIR:
			case KW_REPL:
			case KW_REPLACE:
			case KW_REPLICATION:
			case KW_RESOURCE:
			case KW_RESTRICT:
			case KW_REWRITE:
			case KW_ROLE:
			case KW_ROLES:
			case KW_SCHEDULING_POLICY:
			case KW_SCHEMA:
			case KW_SCHEMAS:
			case KW_SECOND:
			case KW_SEMI:
			case KW_SERDE:
			case KW_SERDEPROPERTIES:
			case KW_SERVER:
			case KW_SETS:
			case KW_SHARED:
			case KW_SHOW:
			case KW_SHOW_DATABASE:
			case KW_SKEWED:
			case KW_SNAPSHOT:
			case KW_SORT:
			case KW_SORTED:
			case KW_SSL:
			case KW_STATISTICS:
			case KW_STATUS:
			case KW_STORED:
			case KW_STREAMTABLE:
			case KW_STRING:
			case KW_STRUCT:
			case KW_SUMMARY:
			case KW_TABLES:
			case KW_TBLPROPERTIES:
			case KW_TEMPORARY:
			case KW_TERMINATED:
			case KW_TINYINT:
			case KW_TOUCH:
			case KW_TRANSACTION:
			case KW_TRANSACTIONS:
			case KW_UNARCHIVE:
			case KW_UNDO:
			case KW_UNIONTYPE:
			case KW_UNLOCK:
			case KW_UNMANAGED:
			case KW_UNSET:
			case KW_UNSIGNED:
			case KW_URI:
			case KW_USE:
			case KW_UTC:
			case KW_UTCTIMESTAMP:
			case KW_VALIDATE:
			case KW_VALUE_TYPE:
			case KW_VECTORIZATION:
			case KW_VIEW:
			case KW_VIEWS:
			case KW_WAIT:
			case KW_WEEK:
			case KW_WHILE:
			case KW_WORK:
			case KW_WORKLOAD:
			case KW_WRITE:
			case KW_YEAR:
			case KW_ZONE:
			case KW_BATCH:
			case KW_DAYOFWEEK:
			case KW_HOLD_DDLTIME:
			case KW_IGNORE:
			case KW_NO_DROP:
			case KW_OFFLINE:
			case KW_PROTECTION:
			case KW_READONLY:
			case KW_TIMESTAMPTZ:
				{
				int LA49_3 = input.LA(2);
				if ( (LA49_3==EOF||LA49_3==DOT||LA49_3==Identifier||(LA49_3 >= KW_ABORT && LA49_3 <= KW_AFTER)||LA49_3==KW_ALLOC_FRACTION||LA49_3==KW_ANALYZE||LA49_3==KW_ARCHIVE||(LA49_3 >= KW_AS && LA49_3 <= KW_ASC)||(LA49_3 >= KW_AUTOCOMMIT && LA49_3 <= KW_BEFORE)||(LA49_3 >= KW_BUCKET && LA49_3 <= KW_BUCKETS)||(LA49_3 >= KW_CACHE && LA49_3 <= KW_CASCADE)||LA49_3==KW_CHANGE||(LA49_3 >= KW_CHECK && LA49_3 <= KW_COLLECTION)||(LA49_3 >= KW_COLUMNS && LA49_3 <= KW_COMMENT)||(LA49_3 >= KW_COMPACT && LA49_3 <= KW_CONCATENATE)||LA49_3==KW_CONTINUE||LA49_3==KW_DATA||LA49_3==KW_DATABASES||(LA49_3 >= KW_DATETIME && LA49_3 <= KW_DBPROPERTIES)||(LA49_3 >= KW_DEFAULT && LA49_3 <= KW_DEFINED)||(LA49_3 >= KW_DELIMITED && LA49_3 <= KW_DESC)||(LA49_3 >= KW_DETAIL && LA49_3 <= KW_DISABLE)||(LA49_3 >= KW_DISTRIBUTE && LA49_3 <= KW_DO)||LA49_3==KW_DOW||(LA49_3 >= KW_DUMP && LA49_3 <= KW_ELEM_TYPE)||LA49_3==KW_ENABLE||(LA49_3 >= KW_ENFORCED && LA49_3 <= KW_ESCAPED)||LA49_3==KW_EXCLUSIVE||(LA49_3 >= KW_EXPLAIN && LA49_3 <= KW_EXPRESSION)||(LA49_3 >= KW_FIELDS && LA49_3 <= KW_FIRST)||(LA49_3 >= KW_FORMAT && LA49_3 <= KW_FORMATTED)||LA49_3==KW_FUNCTIONS||(LA49_3 >= KW_HOUR && LA49_3 <= KW_IDXPROPERTIES)||(LA49_3 >= KW_INDEX && LA49_3 <= KW_INDEXES)||(LA49_3 >= KW_INPATH && LA49_3 <= KW_INPUTFORMAT)||(LA49_3 >= KW_ISOLATION && LA49_3 <= KW_JAR)||(LA49_3 >= KW_KEY && LA49_3 <= KW_LAST)||LA49_3==KW_LEVEL||(LA49_3 >= KW_LIMIT && LA49_3 <= KW_LOAD)||(LA49_3 >= KW_LOCATION && LA49_3 <= KW_LONG)||LA49_3==KW_MANAGEMENT||(LA49_3 >= KW_MAPJOIN && LA49_3 <= KW_MATERIALIZED)||LA49_3==KW_METADATA||(LA49_3 >= KW_MINUTE && LA49_3 <= KW_MONTH)||(LA49_3 >= KW_MOVE && LA49_3 <= KW_MSCK)||(LA49_3 >= KW_NORELY && LA49_3 <= KW_NOSCAN)||LA49_3==KW_NOVALIDATE||LA49_3==KW_NULLS||LA49_3==KW_OFFSET||(LA49_3 >= KW_OPERATOR && LA49_3 <= KW_OPTION)||LA49_3==KW_ORDER||(LA49_3 >= KW_OUTPUTDRIVER && LA49_3 <= KW_OUTPUTFORMAT)||(LA49_3 >= KW_OVERWRITE && LA49_3 <= KW_PATH)||(LA49_3 >= KW_PLAN && LA49_3 <= KW_POOL)||LA49_3==KW_PRINCIPALS||(LA49_3 >= KW_PURGE && LA49_3 <= KW_QUERY_PARALLELISM)||LA49_3==KW_READ||(LA49_3 >= KW_REBUILD && LA49_3 <= KW_RECORDWRITER)||(LA49_3 >= KW_RELOAD && LA49_3 <= KW_RESTRICT)||LA49_3==KW_REWRITE||(LA49_3 >= KW_ROLE && LA49_3 <= KW_ROLES)||(LA49_3 >= KW_SCHEDULING_POLICY && LA49_3 <= KW_SECOND)||(LA49_3 >= KW_SEMI && LA49_3 <= KW_SERVER)||(LA49_3 >= KW_SETS && LA49_3 <= KW_SKEWED)||(LA49_3 >= KW_SNAPSHOT && LA49_3 <= KW_SSL)||(LA49_3 >= KW_STATISTICS && LA49_3 <= KW_SUMMARY)||(LA49_3 >= KW_TABLES && LA49_3 <= KW_TERMINATED)||LA49_3==KW_TINYINT||(LA49_3 >= KW_TOUCH && LA49_3 <= KW_TRANSACTIONS)||LA49_3==KW_UNARCHIVE||LA49_3==KW_UNDO||LA49_3==KW_UNIONTYPE||(LA49_3 >= KW_UNLOCK && LA49_3 <= KW_UNSIGNED)||(LA49_3 >= KW_URI && LA49_3 <= KW_USE)||(LA49_3 >= KW_UTC && LA49_3 <= KW_VALIDATE)||LA49_3==KW_VALUE_TYPE||(LA49_3 >= KW_VECTORIZATION && LA49_3 <= KW_WEEK)||LA49_3==KW_WHILE||(LA49_3 >= KW_WORK && LA49_3 <= KW_ZONE)||LA49_3==RPAREN||LA49_3==KW_BATCH||LA49_3==KW_DAYOFWEEK||LA49_3==KW_HOLD_DDLTIME||LA49_3==KW_IGNORE||LA49_3==KW_NO_DROP||LA49_3==KW_OFFLINE||LA49_3==KW_PROTECTION||LA49_3==KW_READONLY||LA49_3==KW_TIMESTAMPTZ) ) {
					alt49=2;
				}
				else if ( (LA49_3==LPAREN) ) {
					int LA49_18 = input.LA(3);
					if ( (LA49_18==KW_ON) ) {
						alt49=3;
					}
					else if ( (LA49_18==StringLiteral) ) {
						alt49=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 49, 18, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 49, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 49, 0, input);
				throw nvae;
			}
			switch (alt49) {
				case 1 :
					// FromClauseParser.g:254:4: subQuerySource
					{
					root_0 = (ASTNode)adaptor.nil();


					pushFollow(FOLLOW_subQuerySource_in_partitionTableFunctionSource1859);
					subQuerySource134=subQuerySource();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, subQuerySource134.getTree());

					}
					break;
				case 2 :
					// FromClauseParser.g:255:4: tableSource
					{
					root_0 = (ASTNode)adaptor.nil();


					pushFollow(FOLLOW_tableSource_in_partitionTableFunctionSource1866);
					tableSource135=tableSource();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, tableSource135.getTree());

					}
					break;
				case 3 :
					// FromClauseParser.g:256:4: partitionedTableFunction
					{
					root_0 = (ASTNode)adaptor.nil();


					pushFollow(FOLLOW_partitionedTableFunction_in_partitionTableFunctionSource1873);
					partitionedTableFunction136=partitionedTableFunction();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, partitionedTableFunction136.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "partitionTableFunctionSource"


	public static class partitionedTableFunction_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "partitionedTableFunction"
	// FromClauseParser.g:259:1: partitionedTableFunction : name= identifier LPAREN KW_ON ( ( partitionTableFunctionSource )=> (ptfsrc= partitionTableFunctionSource (spec= partitioningSpec )? ) ) ( ( Identifier LPAREN expression RPAREN )=> Identifier LPAREN expression RPAREN ( COMMA Identifier LPAREN expression RPAREN )* )? ( ( RPAREN )=> ( RPAREN ) ) ( ( Identifier )=>alias= identifier )? -> ^( TOK_PTBLFUNCTION $name ( $alias)? $ptfsrc ( $spec)? ( expression )* ) ;
	public final HiveParser_FromClauseParser.partitionedTableFunction_return partitionedTableFunction() throws RecognitionException {
		HiveParser_FromClauseParser.partitionedTableFunction_return retval = new HiveParser_FromClauseParser.partitionedTableFunction_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token LPAREN137=null;
		Token KW_ON138=null;
		Token Identifier139=null;
		Token LPAREN140=null;
		Token RPAREN142=null;
		Token COMMA143=null;
		Token Identifier144=null;
		Token LPAREN145=null;
		Token RPAREN147=null;
		Token RPAREN148=null;
		ParserRuleReturnScope name =null;
		ParserRuleReturnScope ptfsrc =null;
		ParserRuleReturnScope spec =null;
		ParserRuleReturnScope alias =null;
		ParserRuleReturnScope expression141 =null;
		ParserRuleReturnScope expression146 =null;

		ASTNode LPAREN137_tree=null;
		ASTNode KW_ON138_tree=null;
		ASTNode Identifier139_tree=null;
		ASTNode LPAREN140_tree=null;
		ASTNode RPAREN142_tree=null;
		ASTNode COMMA143_tree=null;
		ASTNode Identifier144_tree=null;
		ASTNode LPAREN145_tree=null;
		ASTNode RPAREN147_tree=null;
		ASTNode RPAREN148_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_KW_ON=new RewriteRuleTokenStream(adaptor,"token KW_ON");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_partitionTableFunctionSource=new RewriteRuleSubtreeStream(adaptor,"rule partitionTableFunctionSource");
		RewriteRuleSubtreeStream stream_partitioningSpec=new RewriteRuleSubtreeStream(adaptor,"rule partitioningSpec");

		 gParent.pushMsg("ptf clause", state); 
		try {
			// FromClauseParser.g:262:4: (name= identifier LPAREN KW_ON ( ( partitionTableFunctionSource )=> (ptfsrc= partitionTableFunctionSource (spec= partitioningSpec )? ) ) ( ( Identifier LPAREN expression RPAREN )=> Identifier LPAREN expression RPAREN ( COMMA Identifier LPAREN expression RPAREN )* )? ( ( RPAREN )=> ( RPAREN ) ) ( ( Identifier )=>alias= identifier )? -> ^( TOK_PTBLFUNCTION $name ( $alias)? $ptfsrc ( $spec)? ( expression )* ) )
			// FromClauseParser.g:263:4: name= identifier LPAREN KW_ON ( ( partitionTableFunctionSource )=> (ptfsrc= partitionTableFunctionSource (spec= partitioningSpec )? ) ) ( ( Identifier LPAREN expression RPAREN )=> Identifier LPAREN expression RPAREN ( COMMA Identifier LPAREN expression RPAREN )* )? ( ( RPAREN )=> ( RPAREN ) ) ( ( Identifier )=>alias= identifier )?
			{
			pushFollow(FOLLOW_identifier_in_partitionedTableFunction1904);
			name=gHiveParser.identifier();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_identifier.add(name.getTree());
			LPAREN137=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_partitionedTableFunction1906); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN137);

			KW_ON138=(Token)match(input,KW_ON,FOLLOW_KW_ON_in_partitionedTableFunction1908); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_KW_ON.add(KW_ON138);

			// FromClauseParser.g:264:4: ( ( partitionTableFunctionSource )=> (ptfsrc= partitionTableFunctionSource (spec= partitioningSpec )? ) )
			// FromClauseParser.g:264:5: ( partitionTableFunctionSource )=> (ptfsrc= partitionTableFunctionSource (spec= partitioningSpec )? )
			{
			// FromClauseParser.g:264:39: (ptfsrc= partitionTableFunctionSource (spec= partitioningSpec )? )
			// FromClauseParser.g:264:40: ptfsrc= partitionTableFunctionSource (spec= partitioningSpec )?
			{
			pushFollow(FOLLOW_partitionTableFunctionSource_in_partitionedTableFunction1923);
			ptfsrc=partitionTableFunctionSource();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_partitionTableFunctionSource.add(ptfsrc.getTree());
			// FromClauseParser.g:264:80: (spec= partitioningSpec )?
			int alt50=2;
			int LA50_0 = input.LA(1);
			if ( (LA50_0==KW_CLUSTER||LA50_0==KW_DISTRIBUTE||LA50_0==KW_ORDER||LA50_0==KW_PARTITION||LA50_0==KW_SORT) ) {
				alt50=1;
			}
			switch (alt50) {
				case 1 :
					// FromClauseParser.g:264:80: spec= partitioningSpec
					{
					pushFollow(FOLLOW_partitioningSpec_in_partitionedTableFunction1927);
					spec=partitioningSpec();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_partitioningSpec.add(spec.getTree());
					}
					break;

			}

			}

			}

			// FromClauseParser.g:265:4: ( ( Identifier LPAREN expression RPAREN )=> Identifier LPAREN expression RPAREN ( COMMA Identifier LPAREN expression RPAREN )* )?
			int alt52=2;
			int LA52_0 = input.LA(1);
			if ( (LA52_0==Identifier) && (synpred7_FromClauseParser())) {
				alt52=1;
			}
			switch (alt52) {
				case 1 :
					// FromClauseParser.g:265:5: ( Identifier LPAREN expression RPAREN )=> Identifier LPAREN expression RPAREN ( COMMA Identifier LPAREN expression RPAREN )*
					{
					Identifier139=(Token)match(input,Identifier,FOLLOW_Identifier_in_partitionedTableFunction1949); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_Identifier.add(Identifier139);

					LPAREN140=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_partitionedTableFunction1951); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN140);

					pushFollow(FOLLOW_expression_in_partitionedTableFunction1953);
					expression141=gHiveParser.expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expression.add(expression141.getTree());
					RPAREN142=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_partitionedTableFunction1955); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN142);

					// FromClauseParser.g:265:83: ( COMMA Identifier LPAREN expression RPAREN )*
					loop51:
					while (true) {
						int alt51=2;
						int LA51_0 = input.LA(1);
						if ( (LA51_0==COMMA) ) {
							alt51=1;
						}

						switch (alt51) {
						case 1 :
							// FromClauseParser.g:265:85: COMMA Identifier LPAREN expression RPAREN
							{
							COMMA143=(Token)match(input,COMMA,FOLLOW_COMMA_in_partitionedTableFunction1959); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA143);

							Identifier144=(Token)match(input,Identifier,FOLLOW_Identifier_in_partitionedTableFunction1961); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_Identifier.add(Identifier144);

							LPAREN145=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_partitionedTableFunction1963); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN145);

							pushFollow(FOLLOW_expression_in_partitionedTableFunction1965);
							expression146=gHiveParser.expression();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_expression.add(expression146.getTree());
							RPAREN147=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_partitionedTableFunction1967); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN147);

							}
							break;

						default :
							break loop51;
						}
					}

					}
					break;

			}

			// FromClauseParser.g:266:4: ( ( RPAREN )=> ( RPAREN ) )
			// FromClauseParser.g:266:5: ( RPAREN )=> ( RPAREN )
			{
			// FromClauseParser.g:266:17: ( RPAREN )
			// FromClauseParser.g:266:18: RPAREN
			{
			RPAREN148=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_partitionedTableFunction1984); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN148);

			}

			}

			// FromClauseParser.g:266:27: ( ( Identifier )=>alias= identifier )?
			int alt53=2;
			alt53 = dfa53.predict(input);
			switch (alt53) {
				case 1 :
					// FromClauseParser.g:266:28: ( Identifier )=>alias= identifier
					{
					pushFollow(FOLLOW_identifier_in_partitionedTableFunction1997);
					alias=gHiveParser.identifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_identifier.add(alias.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: ptfsrc, name, expression, spec, alias
			// token labels: 
			// rule labels: ptfsrc, name, alias, spec, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_ptfsrc=new RewriteRuleSubtreeStream(adaptor,"rule ptfsrc",ptfsrc!=null?ptfsrc.getTree():null);
			RewriteRuleSubtreeStream stream_name=new RewriteRuleSubtreeStream(adaptor,"rule name",name!=null?name.getTree():null);
			RewriteRuleSubtreeStream stream_alias=new RewriteRuleSubtreeStream(adaptor,"rule alias",alias!=null?alias.getTree():null);
			RewriteRuleSubtreeStream stream_spec=new RewriteRuleSubtreeStream(adaptor,"rule spec",spec!=null?spec.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 267:4: -> ^( TOK_PTBLFUNCTION $name ( $alias)? $ptfsrc ( $spec)? ( expression )* )
			{
				// FromClauseParser.g:267:9: ^( TOK_PTBLFUNCTION $name ( $alias)? $ptfsrc ( $spec)? ( expression )* )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_PTBLFUNCTION, "TOK_PTBLFUNCTION"), root_1);
				adaptor.addChild(root_1, stream_name.nextTree());
				// FromClauseParser.g:267:35: ( $alias)?
				if ( stream_alias.hasNext() ) {
					adaptor.addChild(root_1, stream_alias.nextTree());
				}
				stream_alias.reset();

				adaptor.addChild(root_1, stream_ptfsrc.nextTree());
				// FromClauseParser.g:267:51: ( $spec)?
				if ( stream_spec.hasNext() ) {
					adaptor.addChild(root_1, stream_spec.nextTree());
				}
				stream_spec.reset();

				// FromClauseParser.g:267:57: ( expression )*
				while ( stream_expression.hasNext() ) {
					adaptor.addChild(root_1, stream_expression.nextTree());
				}
				stream_expression.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "partitionedTableFunction"


	public static class whereClause_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "whereClause"
	// FromClauseParser.g:272:1: whereClause : KW_WHERE searchCondition -> ^( TOK_WHERE searchCondition ) ;
	public final HiveParser_FromClauseParser.whereClause_return whereClause() throws RecognitionException {
		HiveParser_FromClauseParser.whereClause_return retval = new HiveParser_FromClauseParser.whereClause_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_WHERE149=null;
		ParserRuleReturnScope searchCondition150 =null;

		ASTNode KW_WHERE149_tree=null;
		RewriteRuleTokenStream stream_KW_WHERE=new RewriteRuleTokenStream(adaptor,"token KW_WHERE");
		RewriteRuleSubtreeStream stream_searchCondition=new RewriteRuleSubtreeStream(adaptor,"rule searchCondition");

		 gParent.pushMsg("where clause", state); 
		try {
			// FromClauseParser.g:275:5: ( KW_WHERE searchCondition -> ^( TOK_WHERE searchCondition ) )
			// FromClauseParser.g:276:5: KW_WHERE searchCondition
			{
			KW_WHERE149=(Token)match(input,KW_WHERE,FOLLOW_KW_WHERE_in_whereClause2060); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_KW_WHERE.add(KW_WHERE149);

			pushFollow(FOLLOW_searchCondition_in_whereClause2062);
			searchCondition150=searchCondition();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_searchCondition.add(searchCondition150.getTree());
			// AST REWRITE
			// elements: searchCondition
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 276:30: -> ^( TOK_WHERE searchCondition )
			{
				// FromClauseParser.g:276:33: ^( TOK_WHERE searchCondition )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_WHERE, "TOK_WHERE"), root_1);
				adaptor.addChild(root_1, stream_searchCondition.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "whereClause"


	public static class searchCondition_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "searchCondition"
	// FromClauseParser.g:279:1: searchCondition : expression ;
	public final HiveParser_FromClauseParser.searchCondition_return searchCondition() throws RecognitionException {
		HiveParser_FromClauseParser.searchCondition_return retval = new HiveParser_FromClauseParser.searchCondition_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		ParserRuleReturnScope expression151 =null;


		 gParent.pushMsg("search condition", state); 
		try {
			// FromClauseParser.g:282:5: ( expression )
			// FromClauseParser.g:283:5: expression
			{
			root_0 = (ASTNode)adaptor.nil();


			pushFollow(FOLLOW_expression_in_searchCondition2101);
			expression151=gHiveParser.expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expression151.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "searchCondition"


	public static class valuesClause_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "valuesClause"
	// FromClauseParser.g:297:1: valuesClause : KW_VALUES valuesTableConstructor -> ^( TOK_FUNCTION Identifier[\"array\"] valuesTableConstructor ) ;
	public final HiveParser_FromClauseParser.valuesClause_return valuesClause() throws RecognitionException {
		HiveParser_FromClauseParser.valuesClause_return retval = new HiveParser_FromClauseParser.valuesClause_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_VALUES152=null;
		ParserRuleReturnScope valuesTableConstructor153 =null;

		ASTNode KW_VALUES152_tree=null;
		RewriteRuleTokenStream stream_KW_VALUES=new RewriteRuleTokenStream(adaptor,"token KW_VALUES");
		RewriteRuleSubtreeStream stream_valuesTableConstructor=new RewriteRuleSubtreeStream(adaptor,"rule valuesTableConstructor");

		 gParent.pushMsg("values clause", state); 
		try {
			// FromClauseParser.g:300:5: ( KW_VALUES valuesTableConstructor -> ^( TOK_FUNCTION Identifier[\"array\"] valuesTableConstructor ) )
			// FromClauseParser.g:301:5: KW_VALUES valuesTableConstructor
			{
			KW_VALUES152=(Token)match(input,KW_VALUES,FOLLOW_KW_VALUES_in_valuesClause2140); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_KW_VALUES.add(KW_VALUES152);

			pushFollow(FOLLOW_valuesTableConstructor_in_valuesClause2142);
			valuesTableConstructor153=valuesTableConstructor();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_valuesTableConstructor.add(valuesTableConstructor153.getTree());
			// AST REWRITE
			// elements: valuesTableConstructor
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 301:38: -> ^( TOK_FUNCTION Identifier[\"array\"] valuesTableConstructor )
			{
				// FromClauseParser.g:301:41: ^( TOK_FUNCTION Identifier[\"array\"] valuesTableConstructor )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_FUNCTION, "TOK_FUNCTION"), root_1);
				adaptor.addChild(root_1, (ASTNode)adaptor.create(Identifier, "array"));
				adaptor.addChild(root_1, stream_valuesTableConstructor.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "valuesClause"


	public static class valuesTableConstructor_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "valuesTableConstructor"
	// FromClauseParser.g:304:1: valuesTableConstructor : valueRowConstructor ( COMMA ! valueRowConstructor )* ;
	public final HiveParser_FromClauseParser.valuesTableConstructor_return valuesTableConstructor() throws RecognitionException {
		HiveParser_FromClauseParser.valuesTableConstructor_return retval = new HiveParser_FromClauseParser.valuesTableConstructor_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token COMMA155=null;
		ParserRuleReturnScope valueRowConstructor154 =null;
		ParserRuleReturnScope valueRowConstructor156 =null;

		ASTNode COMMA155_tree=null;

		 gParent.pushMsg("values table constructor", state); 
		try {
			// FromClauseParser.g:307:5: ( valueRowConstructor ( COMMA ! valueRowConstructor )* )
			// FromClauseParser.g:308:5: valueRowConstructor ( COMMA ! valueRowConstructor )*
			{
			root_0 = (ASTNode)adaptor.nil();


			pushFollow(FOLLOW_valueRowConstructor_in_valuesTableConstructor2184);
			valueRowConstructor154=valueRowConstructor();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, valueRowConstructor154.getTree());

			// FromClauseParser.g:308:25: ( COMMA ! valueRowConstructor )*
			loop54:
			while (true) {
				int alt54=2;
				int LA54_0 = input.LA(1);
				if ( (LA54_0==COMMA) ) {
					alt54=1;
				}

				switch (alt54) {
				case 1 :
					// FromClauseParser.g:308:26: COMMA ! valueRowConstructor
					{
					COMMA155=(Token)match(input,COMMA,FOLLOW_COMMA_in_valuesTableConstructor2187); if (state.failed) return retval;
					pushFollow(FOLLOW_valueRowConstructor_in_valuesTableConstructor2190);
					valueRowConstructor156=valueRowConstructor();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, valueRowConstructor156.getTree());

					}
					break;

				default :
					break loop54;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "valuesTableConstructor"


	public static class valueRowConstructor_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "valueRowConstructor"
	// FromClauseParser.g:311:1: valueRowConstructor : expressionsInParenthesis[true, true] ;
	public final HiveParser_FromClauseParser.valueRowConstructor_return valueRowConstructor() throws RecognitionException {
		HiveParser_FromClauseParser.valueRowConstructor_return retval = new HiveParser_FromClauseParser.valueRowConstructor_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		ParserRuleReturnScope expressionsInParenthesis157 =null;


		 gParent.pushMsg("value row constructor", state); 
		try {
			// FromClauseParser.g:314:5: ( expressionsInParenthesis[true, true] )
			// FromClauseParser.g:315:5: expressionsInParenthesis[true, true]
			{
			root_0 = (ASTNode)adaptor.nil();


			pushFollow(FOLLOW_expressionsInParenthesis_in_valueRowConstructor2223);
			expressionsInParenthesis157=gHiveParser.expressionsInParenthesis(true, true);
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expressionsInParenthesis157.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "valueRowConstructor"


	public static class virtualTableSource_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "virtualTableSource"
	// FromClauseParser.g:322:1: virtualTableSource : KW_TABLE LPAREN valuesClause RPAREN ( KW_AS )? tabAlias= tableAlias ( LPAREN identifier ( COMMA identifier )* )? RPAREN -> ^( TOK_SUBQUERY ^( TOK_QUERY ^( TOK_FROM ^( TOK_SUBQUERY ^( TOK_QUERY ^( TOK_INSERT ^( TOK_DESTINATION ^( TOK_DIR TOK_TMP_FILE ) ) ^( TOK_SELECT ^( TOK_SELEXPR IntegralLiteral[\"0\"] ) ) ) ) ) ) ^( TOK_INSERT ^( TOK_DESTINATION ^( TOK_DIR TOK_TMP_FILE ) ) ^( TOK_SELECT ^( TOK_SELEXPR ^( TOK_FUNCTION Identifier[\"inline\"] valuesClause ) ( identifier )* ) ) ) ) ) ;
	public final HiveParser_FromClauseParser.virtualTableSource_return virtualTableSource() throws RecognitionException {
		HiveParser_FromClauseParser.virtualTableSource_return retval = new HiveParser_FromClauseParser.virtualTableSource_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_TABLE158=null;
		Token LPAREN159=null;
		Token RPAREN161=null;
		Token KW_AS162=null;
		Token LPAREN163=null;
		Token COMMA165=null;
		Token RPAREN167=null;
		ParserRuleReturnScope tabAlias =null;
		ParserRuleReturnScope valuesClause160 =null;
		ParserRuleReturnScope identifier164 =null;
		ParserRuleReturnScope identifier166 =null;

		ASTNode KW_TABLE158_tree=null;
		ASTNode LPAREN159_tree=null;
		ASTNode RPAREN161_tree=null;
		ASTNode KW_AS162_tree=null;
		ASTNode LPAREN163_tree=null;
		ASTNode COMMA165_tree=null;
		ASTNode RPAREN167_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_KW_TABLE=new RewriteRuleTokenStream(adaptor,"token KW_TABLE");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleTokenStream stream_KW_AS=new RewriteRuleTokenStream(adaptor,"token KW_AS");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
		RewriteRuleSubtreeStream stream_valuesClause=new RewriteRuleSubtreeStream(adaptor,"rule valuesClause");
		RewriteRuleSubtreeStream stream_tableAlias=new RewriteRuleSubtreeStream(adaptor,"rule tableAlias");

		 gParent.pushMsg("virtual table source", state); 
		try {
			// FromClauseParser.g:325:5: ( KW_TABLE LPAREN valuesClause RPAREN ( KW_AS )? tabAlias= tableAlias ( LPAREN identifier ( COMMA identifier )* )? RPAREN -> ^( TOK_SUBQUERY ^( TOK_QUERY ^( TOK_FROM ^( TOK_SUBQUERY ^( TOK_QUERY ^( TOK_INSERT ^( TOK_DESTINATION ^( TOK_DIR TOK_TMP_FILE ) ) ^( TOK_SELECT ^( TOK_SELEXPR IntegralLiteral[\"0\"] ) ) ) ) ) ) ^( TOK_INSERT ^( TOK_DESTINATION ^( TOK_DIR TOK_TMP_FILE ) ) ^( TOK_SELECT ^( TOK_SELEXPR ^( TOK_FUNCTION Identifier[\"inline\"] valuesClause ) ( identifier )* ) ) ) ) ) )
			// FromClauseParser.g:326:5: KW_TABLE LPAREN valuesClause RPAREN ( KW_AS )? tabAlias= tableAlias ( LPAREN identifier ( COMMA identifier )* )? RPAREN
			{
			KW_TABLE158=(Token)match(input,KW_TABLE,FOLLOW_KW_TABLE_in_virtualTableSource2257); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_KW_TABLE.add(KW_TABLE158);

			LPAREN159=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_virtualTableSource2259); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN159);

			pushFollow(FOLLOW_valuesClause_in_virtualTableSource2261);
			valuesClause160=valuesClause();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_valuesClause.add(valuesClause160.getTree());
			RPAREN161=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_virtualTableSource2263); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN161);

			// FromClauseParser.g:326:41: ( KW_AS )?
			int alt55=2;
			int LA55_0 = input.LA(1);
			if ( (LA55_0==KW_AS) ) {
				alt55=1;
			}
			switch (alt55) {
				case 1 :
					// FromClauseParser.g:326:41: KW_AS
					{
					KW_AS162=(Token)match(input,KW_AS,FOLLOW_KW_AS_in_virtualTableSource2265); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KW_AS.add(KW_AS162);

					}
					break;

			}

			pushFollow(FOLLOW_tableAlias_in_virtualTableSource2270);
			tabAlias=tableAlias();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_tableAlias.add(tabAlias.getTree());
			// FromClauseParser.g:326:68: ( LPAREN identifier ( COMMA identifier )* )?
			int alt57=2;
			int LA57_0 = input.LA(1);
			if ( (LA57_0==LPAREN) ) {
				alt57=1;
			}
			switch (alt57) {
				case 1 :
					// FromClauseParser.g:326:69: LPAREN identifier ( COMMA identifier )*
					{
					LPAREN163=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_virtualTableSource2273); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN163);

					pushFollow(FOLLOW_identifier_in_virtualTableSource2275);
					identifier164=gHiveParser.identifier();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_identifier.add(identifier164.getTree());
					// FromClauseParser.g:326:87: ( COMMA identifier )*
					loop56:
					while (true) {
						int alt56=2;
						int LA56_0 = input.LA(1);
						if ( (LA56_0==COMMA) ) {
							alt56=1;
						}

						switch (alt56) {
						case 1 :
							// FromClauseParser.g:326:88: COMMA identifier
							{
							COMMA165=(Token)match(input,COMMA,FOLLOW_COMMA_in_virtualTableSource2278); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_COMMA.add(COMMA165);

							pushFollow(FOLLOW_identifier_in_virtualTableSource2280);
							identifier166=gHiveParser.identifier();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_identifier.add(identifier166.getTree());
							}
							break;

						default :
							break loop56;
						}
					}

					}
					break;

			}

			RPAREN167=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_virtualTableSource2286); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN167);

			// AST REWRITE
			// elements: identifier, valuesClause
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 327:5: -> ^( TOK_SUBQUERY ^( TOK_QUERY ^( TOK_FROM ^( TOK_SUBQUERY ^( TOK_QUERY ^( TOK_INSERT ^( TOK_DESTINATION ^( TOK_DIR TOK_TMP_FILE ) ) ^( TOK_SELECT ^( TOK_SELEXPR IntegralLiteral[\"0\"] ) ) ) ) ) ) ^( TOK_INSERT ^( TOK_DESTINATION ^( TOK_DIR TOK_TMP_FILE ) ) ^( TOK_SELECT ^( TOK_SELEXPR ^( TOK_FUNCTION Identifier[\"inline\"] valuesClause ) ( identifier )* ) ) ) ) )
			{
				// FromClauseParser.g:327:8: ^( TOK_SUBQUERY ^( TOK_QUERY ^( TOK_FROM ^( TOK_SUBQUERY ^( TOK_QUERY ^( TOK_INSERT ^( TOK_DESTINATION ^( TOK_DIR TOK_TMP_FILE ) ) ^( TOK_SELECT ^( TOK_SELEXPR IntegralLiteral[\"0\"] ) ) ) ) ) ) ^( TOK_INSERT ^( TOK_DESTINATION ^( TOK_DIR TOK_TMP_FILE ) ) ^( TOK_SELECT ^( TOK_SELEXPR ^( TOK_FUNCTION Identifier[\"inline\"] valuesClause ) ( identifier )* ) ) ) ) )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_SUBQUERY, "TOK_SUBQUERY"), root_1);
				// FromClauseParser.g:328:10: ^( TOK_QUERY ^( TOK_FROM ^( TOK_SUBQUERY ^( TOK_QUERY ^( TOK_INSERT ^( TOK_DESTINATION ^( TOK_DIR TOK_TMP_FILE ) ) ^( TOK_SELECT ^( TOK_SELEXPR IntegralLiteral[\"0\"] ) ) ) ) ) ) ^( TOK_INSERT ^( TOK_DESTINATION ^( TOK_DIR TOK_TMP_FILE ) ) ^( TOK_SELECT ^( TOK_SELEXPR ^( TOK_FUNCTION Identifier[\"inline\"] valuesClause ) ( identifier )* ) ) ) )
				{
				ASTNode root_2 = (ASTNode)adaptor.nil();
				root_2 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_QUERY, "TOK_QUERY"), root_2);
				// FromClauseParser.g:329:12: ^( TOK_FROM ^( TOK_SUBQUERY ^( TOK_QUERY ^( TOK_INSERT ^( TOK_DESTINATION ^( TOK_DIR TOK_TMP_FILE ) ) ^( TOK_SELECT ^( TOK_SELEXPR IntegralLiteral[\"0\"] ) ) ) ) ) )
				{
				ASTNode root_3 = (ASTNode)adaptor.nil();
				root_3 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_FROM, "TOK_FROM"), root_3);
				// FromClauseParser.g:330:14: ^( TOK_SUBQUERY ^( TOK_QUERY ^( TOK_INSERT ^( TOK_DESTINATION ^( TOK_DIR TOK_TMP_FILE ) ) ^( TOK_SELECT ^( TOK_SELEXPR IntegralLiteral[\"0\"] ) ) ) ) )
				{
				ASTNode root_4 = (ASTNode)adaptor.nil();
				root_4 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_SUBQUERY, "TOK_SUBQUERY"), root_4);
				// FromClauseParser.g:331:16: ^( TOK_QUERY ^( TOK_INSERT ^( TOK_DESTINATION ^( TOK_DIR TOK_TMP_FILE ) ) ^( TOK_SELECT ^( TOK_SELEXPR IntegralLiteral[\"0\"] ) ) ) )
				{
				ASTNode root_5 = (ASTNode)adaptor.nil();
				root_5 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_QUERY, "TOK_QUERY"), root_5);
				// FromClauseParser.g:332:18: ^( TOK_INSERT ^( TOK_DESTINATION ^( TOK_DIR TOK_TMP_FILE ) ) ^( TOK_SELECT ^( TOK_SELEXPR IntegralLiteral[\"0\"] ) ) )
				{
				ASTNode root_6 = (ASTNode)adaptor.nil();
				root_6 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_INSERT, "TOK_INSERT"), root_6);
				// FromClauseParser.g:333:20: ^( TOK_DESTINATION ^( TOK_DIR TOK_TMP_FILE ) )
				{
				ASTNode root_7 = (ASTNode)adaptor.nil();
				root_7 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_DESTINATION, "TOK_DESTINATION"), root_7);
				// FromClauseParser.g:333:38: ^( TOK_DIR TOK_TMP_FILE )
				{
				ASTNode root_8 = (ASTNode)adaptor.nil();
				root_8 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_DIR, "TOK_DIR"), root_8);
				adaptor.addChild(root_8, (ASTNode)adaptor.create(TOK_TMP_FILE, "TOK_TMP_FILE"));
				adaptor.addChild(root_7, root_8);
				}

				adaptor.addChild(root_6, root_7);
				}

				// FromClauseParser.g:334:20: ^( TOK_SELECT ^( TOK_SELEXPR IntegralLiteral[\"0\"] ) )
				{
				ASTNode root_7 = (ASTNode)adaptor.nil();
				root_7 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_SELECT, "TOK_SELECT"), root_7);
				// FromClauseParser.g:334:33: ^( TOK_SELEXPR IntegralLiteral[\"0\"] )
				{
				ASTNode root_8 = (ASTNode)adaptor.nil();
				root_8 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_SELEXPR, "TOK_SELEXPR"), root_8);
				adaptor.addChild(root_8, (ASTNode)adaptor.create(IntegralLiteral, "0"));
				adaptor.addChild(root_7, root_8);
				}

				adaptor.addChild(root_6, root_7);
				}

				adaptor.addChild(root_5, root_6);
				}

				adaptor.addChild(root_4, root_5);
				}

				adaptor.addChild(root_4, adaptor.create(Identifier, (tabAlias!=null?((ASTNode)tabAlias.getTree()):null).getChild(0).getText()));
				adaptor.addChild(root_3, root_4);
				}

				adaptor.addChild(root_2, root_3);
				}

				// FromClauseParser.g:336:12: ^( TOK_INSERT ^( TOK_DESTINATION ^( TOK_DIR TOK_TMP_FILE ) ) ^( TOK_SELECT ^( TOK_SELEXPR ^( TOK_FUNCTION Identifier[\"inline\"] valuesClause ) ( identifier )* ) ) )
				{
				ASTNode root_3 = (ASTNode)adaptor.nil();
				root_3 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_INSERT, "TOK_INSERT"), root_3);
				// FromClauseParser.g:337:14: ^( TOK_DESTINATION ^( TOK_DIR TOK_TMP_FILE ) )
				{
				ASTNode root_4 = (ASTNode)adaptor.nil();
				root_4 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_DESTINATION, "TOK_DESTINATION"), root_4);
				// FromClauseParser.g:337:32: ^( TOK_DIR TOK_TMP_FILE )
				{
				ASTNode root_5 = (ASTNode)adaptor.nil();
				root_5 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_DIR, "TOK_DIR"), root_5);
				adaptor.addChild(root_5, (ASTNode)adaptor.create(TOK_TMP_FILE, "TOK_TMP_FILE"));
				adaptor.addChild(root_4, root_5);
				}

				adaptor.addChild(root_3, root_4);
				}

				// FromClauseParser.g:338:14: ^( TOK_SELECT ^( TOK_SELEXPR ^( TOK_FUNCTION Identifier[\"inline\"] valuesClause ) ( identifier )* ) )
				{
				ASTNode root_4 = (ASTNode)adaptor.nil();
				root_4 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_SELECT, "TOK_SELECT"), root_4);
				// FromClauseParser.g:338:27: ^( TOK_SELEXPR ^( TOK_FUNCTION Identifier[\"inline\"] valuesClause ) ( identifier )* )
				{
				ASTNode root_5 = (ASTNode)adaptor.nil();
				root_5 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_SELEXPR, "TOK_SELEXPR"), root_5);
				// FromClauseParser.g:338:41: ^( TOK_FUNCTION Identifier[\"inline\"] valuesClause )
				{
				ASTNode root_6 = (ASTNode)adaptor.nil();
				root_6 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_FUNCTION, "TOK_FUNCTION"), root_6);
				adaptor.addChild(root_6, (ASTNode)adaptor.create(Identifier, "inline"));
				adaptor.addChild(root_6, stream_valuesClause.nextTree());
				adaptor.addChild(root_5, root_6);
				}

				// FromClauseParser.g:338:91: ( identifier )*
				while ( stream_identifier.hasNext() ) {
					adaptor.addChild(root_5, stream_identifier.nextTree());
				}
				stream_identifier.reset();

				adaptor.addChild(root_4, root_5);
				}

				adaptor.addChild(root_3, root_4);
				}

				adaptor.addChild(root_2, root_3);
				}

				adaptor.addChild(root_1, root_2);
				}

				adaptor.addChild(root_1, adaptor.create(Identifier, (tabAlias!=null?((ASTNode)tabAlias.getTree()):null).getChild(0).getText()));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { gParent.popMsg(state); }
		}

		catch (RecognitionException e) {
		  throw e;
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "virtualTableSource"

	// $ANTLR start synpred1_FromClauseParser
	public final void synpred1_FromClauseParser_fragment() throws RecognitionException {
		// FromClauseParser.g:101:8: ( LPAREN ( KW_WITH | KW_SELECT | KW_MAP | KW_REDUCE | KW_FROM ) )
		// FromClauseParser.g:101:9: LPAREN ( KW_WITH | KW_SELECT | KW_MAP | KW_REDUCE | KW_FROM )
		{
		match(input,LPAREN,FOLLOW_LPAREN_in_synpred1_FromClauseParser390); if (state.failed) return;

		if ( input.LA(1)==KW_FROM||input.LA(1)==KW_MAP||input.LA(1)==KW_REDUCE||input.LA(1)==KW_SELECT||input.LA(1)==KW_WITH ) {
			input.consume();
			state.errorRecovery=false;
			state.failed=false;
		}
		else {
			if (state.backtracking>0) {state.failed=true; return;}
			MismatchedSetException mse = new MismatchedSetException(null,input);
			throw mse;
		}
		}

	}
	// $ANTLR end synpred1_FromClauseParser

	// $ANTLR start synpred2_FromClauseParser
	public final void synpred2_FromClauseParser_fragment() throws RecognitionException {
		// FromClauseParser.g:102:8: ( LPAREN LPAREN atomSelectStatement RPAREN setOperator )
		// FromClauseParser.g:102:9: LPAREN LPAREN atomSelectStatement RPAREN setOperator
		{
		match(input,LPAREN,FOLLOW_LPAREN_in_synpred2_FromClauseParser423); if (state.failed) return;

		match(input,LPAREN,FOLLOW_LPAREN_in_synpred2_FromClauseParser425); if (state.failed) return;

		pushFollow(FOLLOW_atomSelectStatement_in_synpred2_FromClauseParser427);
		gHiveParser.atomSelectStatement();
		state._fsp--;
		if (state.failed) return;

		match(input,RPAREN,FOLLOW_RPAREN_in_synpred2_FromClauseParser429); if (state.failed) return;

		pushFollow(FOLLOW_setOperator_in_synpred2_FromClauseParser431);
		gHiveParser.setOperator();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred2_FromClauseParser

	// $ANTLR start synpred3_FromClauseParser
	public final void synpred3_FromClauseParser_fragment() throws RecognitionException {
		// FromClauseParser.g:154:2: ( ( COMMA )? KW_LATERAL KW_VIEW KW_OUTER )
		// FromClauseParser.g:154:3: ( COMMA )? KW_LATERAL KW_VIEW KW_OUTER
		{
		// FromClauseParser.g:154:3: ( COMMA )?
		int alt58=2;
		int LA58_0 = input.LA(1);
		if ( (LA58_0==COMMA) ) {
			alt58=1;
		}
		switch (alt58) {
			case 1 :
				// FromClauseParser.g:154:3: COMMA
				{
				match(input,COMMA,FOLLOW_COMMA_in_synpred3_FromClauseParser914); if (state.failed) return;

				}
				break;

		}

		match(input,KW_LATERAL,FOLLOW_KW_LATERAL_in_synpred3_FromClauseParser917); if (state.failed) return;

		match(input,KW_VIEW,FOLLOW_KW_VIEW_in_synpred3_FromClauseParser919); if (state.failed) return;

		match(input,KW_OUTER,FOLLOW_KW_OUTER_in_synpred3_FromClauseParser921); if (state.failed) return;

		}

	}
	// $ANTLR end synpred3_FromClauseParser

	// $ANTLR start synpred4_FromClauseParser
	public final void synpred4_FromClauseParser_fragment() throws RecognitionException {
		// FromClauseParser.g:154:109: ( COMMA )
		// FromClauseParser.g:154:110: COMMA
		{
		match(input,COMMA,FOLLOW_COMMA_in_synpred4_FromClauseParser943); if (state.failed) return;

		}

	}
	// $ANTLR end synpred4_FromClauseParser

	// $ANTLR start synpred5_FromClauseParser
	public final void synpred5_FromClauseParser_fragment() throws RecognitionException {
		// FromClauseParser.g:157:67: ( COMMA )
		// FromClauseParser.g:157:68: COMMA
		{
		match(input,COMMA,FOLLOW_COMMA_in_synpred5_FromClauseParser999); if (state.failed) return;

		}

	}
	// $ANTLR end synpred5_FromClauseParser

	// $ANTLR start synpred7_FromClauseParser
	public final void synpred7_FromClauseParser_fragment() throws RecognitionException {
		// FromClauseParser.g:265:5: ( Identifier LPAREN expression RPAREN )
		// FromClauseParser.g:265:6: Identifier LPAREN expression RPAREN
		{
		match(input,Identifier,FOLLOW_Identifier_in_synpred7_FromClauseParser1937); if (state.failed) return;

		match(input,LPAREN,FOLLOW_LPAREN_in_synpred7_FromClauseParser1939); if (state.failed) return;

		pushFollow(FOLLOW_expression_in_synpred7_FromClauseParser1941);
		gHiveParser.expression();
		state._fsp--;
		if (state.failed) return;

		match(input,RPAREN,FOLLOW_RPAREN_in_synpred7_FromClauseParser1943); if (state.failed) return;

		}

	}
	// $ANTLR end synpred7_FromClauseParser

	// $ANTLR start synpred9_FromClauseParser
	public final void synpred9_FromClauseParser_fragment() throws RecognitionException {
		// FromClauseParser.g:266:28: ( Identifier )
		// FromClauseParser.g:266:29: Identifier
		{
		match(input,Identifier,FOLLOW_Identifier_in_synpred9_FromClauseParser1990); if (state.failed) return;

		}

	}
	// $ANTLR end synpred9_FromClauseParser

	// Delegated rules

	public final boolean synpred9_FromClauseParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred9_FromClauseParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred3_FromClauseParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred3_FromClauseParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred4_FromClauseParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred4_FromClauseParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred2_FromClauseParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_FromClauseParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred1_FromClauseParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_FromClauseParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred7_FromClauseParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred7_FromClauseParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred5_FromClauseParser() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred5_FromClauseParser_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}


	protected DFA11 dfa11 = new DFA11(this);
	protected DFA14 dfa14 = new DFA14(this);
	protected DFA21 dfa21 = new DFA21(this);
	protected DFA24 dfa24 = new DFA24(this);
	protected DFA39 dfa39 = new DFA39(this);
	protected DFA43 dfa43 = new DFA43(this);
	protected DFA53 dfa53 = new DFA53(this);
	static final String DFA11_eotS =
		"\u00bc\uffff";
	static final String DFA11_eofS =
		"\1\uffff\2\5\u00b9\uffff";
	static final String DFA11_minS =
		"\1\30\2\11\1\uffff\1\30\1\uffff\1\u00d3\40\uffff\1\u00d3\37\uffff\2\30"+
		"\1\u00a2\3\14\1\30\7\uffff\137\0\10\uffff";
	static final String DFA11_maxS =
		"\3\u0289\1\uffff\1\u0289\1\uffff\1\u017b\40\uffff\1\u017b\37\uffff\2\u0289"+
		"\1\u00de\4\u0289\7\uffff\137\0\10\uffff";
	static final String DFA11_acceptS =
		"\3\uffff\1\2\1\uffff\1\1\110\uffff\1\6\2\uffff\1\5\150\uffff\1\3\1\4";
	static final String DFA11_specialS =
		"\125\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1"+
		"\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1"+
		"\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1"+
		"\51\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65\1\66\1"+
		"\67\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\77\1\100\1\101\1\102\1\103\1"+
		"\104\1\105\1\106\1\107\1\110\1\111\1\112\1\113\1\114\1\115\1\116\1\117"+
		"\1\120\1\121\1\122\1\123\1\124\1\125\1\126\1\127\1\130\1\131\1\132\1\133"+
		"\1\134\1\135\1\136\10\uffff}>";
	static final String[] DFA11_transitionS = {
			"\1\1\1\uffff\6\2\1\uffff\1\2\1\uffff\1\2\3\uffff\1\2\2\uffff\1\2\1\uffff"+
			"\2\2\5\uffff\2\2\1\uffff\2\2\2\uffff\1\2\1\uffff\5\2\1\uffff\2\2\1\uffff"+
			"\4\2\2\uffff\1\2\7\uffff\1\2\1\uffff\1\2\1\uffff\3\2\1\uffff\3\2\1\uffff"+
			"\3\2\1\uffff\4\2\1\uffff\2\2\1\uffff\1\2\1\uffff\2\2\1\uffff\1\2\1\uffff"+
			"\2\2\2\uffff\1\2\1\uffff\3\2\5\uffff\4\2\5\uffff\2\2\3\uffff\1\2\4\uffff"+
			"\2\2\3\uffff\2\2\1\uffff\3\2\6\uffff\3\2\1\uffff\5\2\3\uffff\1\2\1\uffff"+
			"\3\2\1\uffff\5\2\1\uffff\1\2\1\uffff\4\2\1\uffff\1\2\1\uffff\2\2\1\uffff"+
			"\2\2\1\uffff\2\2\1\uffff\1\2\1\uffff\1\2\1\uffff\1\2\2\uffff\2\2\4\uffff"+
			"\2\2\1\uffff\2\2\1\uffff\3\2\1\uffff\4\2\4\uffff\1\2\1\uffff\4\2\1\uffff"+
			"\1\2\1\uffff\3\2\3\uffff\12\2\1\uffff\1\2\2\uffff\2\2\4\uffff\4\2\1\uffff"+
			"\4\2\1\uffff\5\2\1\uffff\4\2\1\uffff\7\2\1\uffff\1\3\1\2\1\uffff\3\2"+
			"\4\uffff\1\2\1\uffff\3\2\4\uffff\1\2\1\uffff\1\2\1\uffff\1\2\2\uffff"+
			"\4\2\1\uffff\2\2\2\uffff\3\2\1\uffff\1\2\1\uffff\5\2\2\uffff\1\2\2\uffff"+
			"\5\2\4\uffff\1\4\67\uffff\1\2\44\uffff\1\2\56\uffff\1\2\3\uffff\1\2\56"+
			"\uffff\1\2\3\uffff\1\2\31\uffff\1\2\6\uffff\1\2\73\uffff\1\2",
			"\1\5\6\uffff\1\5\7\uffff\1\5\1\uffff\6\5\1\uffff\1\5\1\uffff\1\5\3\uffff"+
			"\1\5\1\uffff\2\5\1\uffff\2\5\5\uffff\2\5\1\uffff\2\5\2\uffff\1\5\1\uffff"+
			"\5\5\1\uffff\2\5\1\uffff\4\5\2\uffff\1\5\1\uffff\1\5\5\uffff\1\5\1\uffff"+
			"\1\5\1\uffff\3\5\1\uffff\3\5\1\uffff\3\5\1\uffff\4\5\1\uffff\2\5\1\uffff"+
			"\1\5\1\uffff\2\5\1\uffff\1\5\1\uffff\3\5\1\uffff\1\5\1\uffff\3\5\5\uffff"+
			"\4\5\5\uffff\2\5\1\uffff\1\5\1\uffff\1\5\1\uffff\1\5\1\uffff\3\5\3\uffff"+
			"\7\5\1\uffff\1\5\3\uffff\13\5\1\uffff\1\5\1\uffff\3\5\1\uffff\5\5\1\uffff"+
			"\6\5\1\uffff\4\5\1\uffff\2\5\1\uffff\2\5\1\uffff\1\5\1\uffff\1\5\1\uffff"+
			"\1\5\2\uffff\2\5\1\uffff\1\5\2\uffff\2\5\1\uffff\2\5\1\uffff\3\5\1\uffff"+
			"\4\5\4\uffff\1\5\1\uffff\4\5\1\uffff\1\5\1\uffff\4\5\2\uffff\12\5\1\uffff"+
			"\2\5\1\uffff\2\5\4\uffff\11\5\1\uffff\5\5\1\uffff\4\5\1\uffff\7\5\2\uffff"+
			"\5\5\4\uffff\1\5\1\uffff\3\5\4\uffff\1\5\1\uffff\3\5\2\uffff\4\5\1\uffff"+
			"\2\5\2\uffff\3\5\1\uffff\1\5\1\uffff\5\5\1\uffff\3\5\1\uffff\5\5\4\uffff"+
			"\1\6\14\uffff\1\5\52\uffff\1\5\44\uffff\1\5\56\uffff\1\5\3\uffff\1\5"+
			"\56\uffff\1\5\3\uffff\1\5\31\uffff\1\5\6\uffff\1\5\73\uffff\1\5",
			"\1\5\6\uffff\1\5\7\uffff\1\5\1\uffff\6\5\1\uffff\1\5\1\uffff\1\5\3\uffff"+
			"\1\5\1\uffff\2\5\1\uffff\2\5\5\uffff\2\5\1\uffff\2\5\2\uffff\1\5\1\uffff"+
			"\5\5\1\uffff\2\5\1\uffff\4\5\2\uffff\1\5\1\uffff\1\5\5\uffff\1\5\1\uffff"+
			"\1\5\1\uffff\3\5\1\uffff\3\5\1\uffff\3\5\1\uffff\4\5\1\uffff\2\5\1\uffff"+
			"\1\5\1\uffff\2\5\1\uffff\1\5\1\uffff\3\5\1\uffff\1\5\1\uffff\3\5\5\uffff"+
			"\4\5\5\uffff\2\5\1\uffff\1\5\1\uffff\1\5\1\uffff\1\5\1\uffff\3\5\3\uffff"+
			"\7\5\1\uffff\1\5\3\uffff\13\5\1\uffff\1\5\1\uffff\3\5\1\uffff\5\5\1\uffff"+
			"\6\5\1\uffff\4\5\1\uffff\2\5\1\uffff\2\5\1\uffff\1\5\1\uffff\1\5\1\uffff"+
			"\1\5\2\uffff\2\5\1\uffff\1\5\2\uffff\2\5\1\uffff\2\5\1\uffff\3\5\1\uffff"+
			"\4\5\4\uffff\1\5\1\uffff\4\5\1\uffff\1\5\1\uffff\4\5\2\uffff\12\5\1\uffff"+
			"\2\5\1\uffff\2\5\4\uffff\11\5\1\uffff\5\5\1\uffff\4\5\1\uffff\7\5\2\uffff"+
			"\5\5\4\uffff\1\5\1\uffff\3\5\4\uffff\1\5\1\uffff\3\5\2\uffff\4\5\1\uffff"+
			"\2\5\2\uffff\3\5\1\uffff\1\5\1\uffff\5\5\1\uffff\3\5\1\uffff\5\5\4\uffff"+
			"\1\47\14\uffff\1\5\52\uffff\1\5\44\uffff\1\5\56\uffff\1\5\3\uffff\1\5"+
			"\56\uffff\1\5\3\uffff\1\5\31\uffff\1\5\6\uffff\1\5\73\uffff\1\5",
			"",
			"\1\116\1\uffff\6\116\1\uffff\1\116\1\uffff\1\116\3\uffff\1\116\2\uffff"+
			"\1\116\1\uffff\2\116\5\uffff\2\116\1\uffff\2\116\2\uffff\1\116\1\uffff"+
			"\5\116\1\uffff\2\116\1\uffff\4\116\2\uffff\1\116\7\uffff\1\116\1\uffff"+
			"\1\116\1\uffff\3\116\1\uffff\3\116\1\uffff\3\116\1\uffff\4\116\1\uffff"+
			"\2\116\1\uffff\1\116\1\uffff\2\116\1\uffff\1\116\1\uffff\2\116\2\uffff"+
			"\1\116\1\uffff\3\116\5\uffff\4\116\5\uffff\2\116\1\110\2\uffff\1\116"+
			"\4\uffff\2\116\3\uffff\2\116\1\uffff\3\116\1\111\5\uffff\3\116\1\uffff"+
			"\5\116\3\uffff\1\116\1\uffff\3\116\1\uffff\5\116\1\uffff\1\116\1\113"+
			"\4\116\1\uffff\1\116\1\uffff\2\116\1\uffff\2\116\1\uffff\2\116\1\uffff"+
			"\1\116\1\uffff\1\116\1\uffff\1\116\2\uffff\2\116\4\uffff\2\116\1\uffff"+
			"\2\116\1\uffff\3\116\1\uffff\4\116\4\uffff\1\116\1\uffff\4\116\1\uffff"+
			"\1\116\1\uffff\3\116\1\114\2\uffff\12\116\1\uffff\1\116\2\uffff\2\116"+
			"\4\uffff\4\116\1\112\4\116\1\uffff\5\116\1\uffff\4\116\1\uffff\7\116"+
			"\1\uffff\2\116\1\uffff\3\116\4\uffff\1\116\1\uffff\3\116\4\uffff\1\116"+
			"\1\uffff\1\116\1\uffff\1\116\2\uffff\4\116\1\uffff\2\116\2\uffff\3\116"+
			"\1\uffff\1\116\1\uffff\5\116\2\uffff\1\116\1\uffff\1\107\5\116\4\uffff"+
			"\1\115\67\uffff\1\116\44\uffff\1\116\56\uffff\1\116\3\uffff\1\116\56"+
			"\uffff\1\116\3\uffff\1\116\31\uffff\1\116\6\uffff\1\116\73\uffff\1\116",
			"",
			"\1\121\u00a7\uffff\1\5",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\121\u00a7\uffff\1\5",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\125\1\uffff\6\126\1\uffff\1\126\1\uffff\1\126\3\uffff\1\126\2\uffff"+
			"\1\126\1\uffff\2\126\5\uffff\2\126\1\uffff\2\126\2\uffff\1\126\1\uffff"+
			"\5\126\1\uffff\2\126\1\uffff\4\126\2\uffff\1\126\7\uffff\1\126\1\uffff"+
			"\1\126\1\uffff\3\126\1\uffff\3\126\1\uffff\3\126\1\uffff\4\126\1\uffff"+
			"\2\126\1\uffff\1\126\1\uffff\2\126\1\uffff\1\126\1\uffff\2\126\2\uffff"+
			"\1\126\1\uffff\3\126\5\uffff\4\126\5\uffff\2\126\3\uffff\1\126\4\uffff"+
			"\2\126\3\uffff\2\126\1\uffff\3\126\6\uffff\3\126\1\uffff\5\126\3\uffff"+
			"\1\126\1\uffff\3\126\1\uffff\5\126\1\uffff\1\126\1\uffff\4\126\1\uffff"+
			"\1\126\1\uffff\2\126\1\uffff\2\126\1\uffff\2\126\1\uffff\1\126\1\uffff"+
			"\1\126\1\uffff\1\126\2\uffff\2\126\4\uffff\2\126\1\uffff\2\126\1\uffff"+
			"\3\126\1\uffff\4\126\4\uffff\1\126\1\uffff\4\126\1\uffff\1\126\1\uffff"+
			"\3\126\3\uffff\12\126\1\uffff\1\126\2\uffff\2\126\4\uffff\4\126\1\uffff"+
			"\4\126\1\uffff\5\126\1\uffff\4\126\1\uffff\7\126\2\uffff\1\126\1\uffff"+
			"\3\126\4\uffff\1\126\1\uffff\3\126\4\uffff\1\126\1\uffff\1\126\1\uffff"+
			"\1\126\2\uffff\4\126\1\uffff\2\126\2\uffff\3\126\1\uffff\1\126\1\uffff"+
			"\5\126\2\uffff\1\126\2\uffff\5\126\74\uffff\1\126\44\uffff\1\126\56\uffff"+
			"\1\126\3\uffff\1\126\56\uffff\1\126\3\uffff\1\126\31\uffff\1\126\6\uffff"+
			"\1\126\73\uffff\1\126",
			"\1\130\1\uffff\6\131\1\uffff\1\131\1\uffff\1\131\3\uffff\1\131\2\uffff"+
			"\1\131\1\uffff\2\131\5\uffff\2\131\1\uffff\2\131\2\uffff\1\131\1\uffff"+
			"\5\131\1\uffff\2\131\1\uffff\4\131\2\uffff\1\131\7\uffff\1\131\1\uffff"+
			"\1\131\1\uffff\3\131\1\uffff\3\131\1\uffff\3\131\1\uffff\4\131\1\uffff"+
			"\2\131\1\uffff\1\131\1\uffff\2\131\1\uffff\1\131\1\uffff\2\131\2\uffff"+
			"\1\131\1\uffff\3\131\5\uffff\4\131\5\uffff\2\131\3\uffff\1\131\4\uffff"+
			"\2\131\3\uffff\2\131\1\uffff\3\131\6\uffff\3\131\1\uffff\5\131\3\uffff"+
			"\1\131\1\uffff\3\131\1\uffff\5\131\1\uffff\1\131\1\uffff\4\131\1\uffff"+
			"\1\131\1\uffff\2\131\1\uffff\2\131\1\uffff\2\131\1\uffff\1\131\1\uffff"+
			"\1\131\1\uffff\1\131\2\uffff\2\131\4\uffff\2\131\1\uffff\2\131\1\uffff"+
			"\3\131\1\uffff\4\131\4\uffff\1\131\1\uffff\4\131\1\uffff\1\131\1\uffff"+
			"\3\131\3\uffff\12\131\1\uffff\1\131\2\uffff\2\131\4\uffff\4\131\1\uffff"+
			"\4\131\1\uffff\5\131\1\uffff\4\131\1\uffff\7\131\1\uffff\1\132\1\131"+
			"\1\uffff\3\131\4\uffff\1\131\1\uffff\3\131\4\uffff\1\131\1\uffff\1\131"+
			"\1\uffff\1\131\1\uffff\1\127\4\131\1\uffff\2\131\2\uffff\3\131\1\uffff"+
			"\1\131\1\uffff\5\131\2\uffff\1\131\2\uffff\5\131\4\uffff\1\133\67\uffff"+
			"\1\131\44\uffff\1\131\56\uffff\1\131\3\uffff\1\131\56\uffff\1\131\3\uffff"+
			"\1\131\31\uffff\1\131\6\uffff\1\131\73\uffff\1\131",
			"\1\135\73\uffff\1\134",
			"\1\157\13\uffff\1\142\1\155\6\143\1\137\1\143\1\uffff\1\143\3\uffff"+
			"\1\143\1\171\1\uffff\1\143\1\uffff\2\143\1\uffff\3\171\1\uffff\2\143"+
			"\1\uffff\2\143\1\170\1\165\1\143\1\uffff\5\143\1\uffff\2\143\1\uffff"+
			"\4\143\2\uffff\1\143\4\uffff\1\151\1\153\1\uffff\1\143\1\uffff\1\143"+
			"\1\150\3\143\1\uffff\3\143\1\uffff\3\143\1\uffff\4\143\1\140\2\143\1"+
			"\171\1\143\1\uffff\2\143\1\uffff\1\143\1\uffff\2\143\2\uffff\1\143\1"+
			"\172\3\143\2\uffff\1\166\1\161\1\uffff\4\143\1\171\1\167\3\uffff\2\143"+
			"\3\uffff\1\143\2\uffff\1\171\1\uffff\2\143\1\171\2\uffff\2\143\1\uffff"+
			"\3\143\1\uffff\1\171\1\uffff\1\164\2\uffff\3\143\1\uffff\5\143\3\uffff"+
			"\1\143\1\uffff\3\143\1\uffff\5\143\1\uffff\1\143\1\171\4\143\1\uffff"+
			"\1\143\1\uffff\2\143\1\uffff\2\143\1\uffff\2\143\1\144\1\143\1\162\1"+
			"\143\1\uffff\1\143\2\uffff\2\143\4\uffff\2\143\1\uffff\2\143\1\uffff"+
			"\3\143\1\uffff\4\143\4\uffff\1\143\1\uffff\4\143\1\uffff\1\143\1\uffff"+
			"\3\143\3\uffff\12\143\1\uffff\1\143\2\uffff\2\143\4\uffff\4\143\1\uffff"+
			"\4\143\1\uffff\5\143\1\171\4\143\1\uffff\7\143\2\uffff\1\143\1\uffff"+
			"\3\143\2\uffff\1\152\1\154\1\143\1\uffff\3\143\1\173\1\uffff\1\160\1"+
			"\uffff\1\143\1\uffff\1\143\1\uffff\1\143\2\uffff\4\143\1\uffff\2\143"+
			"\2\uffff\3\143\1\uffff\1\143\1\uffff\5\143\2\uffff\1\143\2\uffff\5\143"+
			"\4\uffff\1\163\2\uffff\1\145\2\uffff\1\146\1\156\1\145\1\136\7\uffff"+
			"\1\141\1\147\1\145\44\uffff\1\143\44\uffff\1\143\56\uffff\1\143\3\uffff"+
			"\1\143\56\uffff\1\143\3\uffff\1\143\31\uffff\1\143\6\uffff\1\143\73\uffff"+
			"\1\143",
			"\1\u008a\13\uffff\1\175\1\u0088\6\176\1\uffff\1\176\1\uffff\1\176\3"+
			"\uffff\1\176\1\u0094\1\uffff\1\176\1\uffff\2\176\1\uffff\3\u0094\1\uffff"+
			"\2\176\1\uffff\2\176\1\u0093\1\u0090\1\176\1\uffff\5\176\1\uffff\2\176"+
			"\1\uffff\4\176\2\uffff\1\176\4\uffff\1\u0084\1\u0086\1\uffff\1\176\1"+
			"\uffff\1\176\1\u0083\3\176\1\uffff\3\176\1\uffff\3\176\1\uffff\4\176"+
			"\1\uffff\2\176\1\u0094\1\176\1\uffff\2\176\1\uffff\1\176\1\uffff\2\176"+
			"\2\uffff\1\176\1\u0095\3\176\2\uffff\1\u0091\1\u008c\1\uffff\4\176\1"+
			"\u0094\1\u0092\3\uffff\2\176\3\uffff\1\176\2\uffff\1\u0094\1\uffff\2"+
			"\176\1\u0094\2\uffff\2\176\1\uffff\3\176\1\uffff\1\u0094\1\uffff\1\u008f"+
			"\2\uffff\3\176\1\uffff\5\176\3\uffff\1\176\1\uffff\3\176\1\uffff\5\176"+
			"\1\uffff\1\176\1\u0094\4\176\1\uffff\1\176\1\uffff\2\176\1\uffff\2\176"+
			"\1\uffff\2\176\1\177\1\176\1\u008d\1\176\1\uffff\1\176\2\uffff\2\176"+
			"\4\uffff\2\176\1\uffff\2\176\1\uffff\3\176\1\uffff\4\176\4\uffff\1\176"+
			"\1\uffff\4\176\1\uffff\1\176\1\uffff\3\176\3\uffff\12\176\1\uffff\1\176"+
			"\2\uffff\2\176\4\uffff\4\176\1\uffff\4\176\1\uffff\5\176\1\u0094\4\176"+
			"\1\uffff\7\176\2\uffff\1\176\1\uffff\3\176\2\uffff\1\u0085\1\u0087\1"+
			"\176\1\uffff\3\176\2\uffff\1\u008b\1\uffff\1\176\1\uffff\1\176\1\uffff"+
			"\1\176\2\uffff\4\176\1\uffff\2\176\2\uffff\3\176\1\uffff\1\176\1\uffff"+
			"\5\176\2\uffff\1\176\2\uffff\5\176\4\uffff\1\u008e\2\uffff\1\u0080\2"+
			"\uffff\1\u0081\1\u0089\1\u0080\10\uffff\1\174\1\u0082\1\u0080\44\uffff"+
			"\1\176\44\uffff\1\176\56\uffff\1\176\3\uffff\1\176\56\uffff\1\176\3\uffff"+
			"\1\176\31\uffff\1\176\6\uffff\1\176\73\uffff\1\176",
			"\1\u00a4\13\uffff\1\u0097\1\u00a2\6\u0098\1\uffff\1\u0098\1\uffff\1"+
			"\u0098\3\uffff\1\u0098\1\u00ae\1\uffff\1\u0098\1\uffff\2\u0098\1\uffff"+
			"\3\u00ae\1\uffff\2\u0098\1\uffff\2\u0098\1\u00ad\1\u00aa\1\u0098\1\uffff"+
			"\5\u0098\1\uffff\2\u0098\1\uffff\4\u0098\2\uffff\1\u0098\4\uffff\1\u009e"+
			"\1\u00a0\1\uffff\1\u0098\1\uffff\1\u0098\1\u009d\3\u0098\1\uffff\3\u0098"+
			"\1\uffff\3\u0098\1\uffff\4\u0098\1\uffff\2\u0098\1\u00ae\1\u0098\1\uffff"+
			"\2\u0098\1\uffff\1\u0098\1\uffff\2\u0098\2\uffff\1\u0098\1\u00af\3\u0098"+
			"\2\uffff\1\u00ab\1\u00a6\1\uffff\4\u0098\1\u00ae\1\u00ac\3\uffff\2\u0098"+
			"\3\uffff\1\u0098\2\uffff\1\u00ae\1\uffff\2\u0098\1\u00ae\2\uffff\2\u0098"+
			"\1\uffff\3\u0098\1\uffff\1\u00ae\1\uffff\1\u00a9\2\uffff\3\u0098\1\uffff"+
			"\5\u0098\3\uffff\1\u0098\1\uffff\3\u0098\1\uffff\5\u0098\1\uffff\1\u0098"+
			"\1\u00ae\4\u0098\1\uffff\1\u0098\1\uffff\2\u0098\1\uffff\2\u0098\1\uffff"+
			"\2\u0098\1\u0099\1\u0098\1\u00a7\1\u0098\1\uffff\1\u0098\2\uffff\2\u0098"+
			"\4\uffff\2\u0098\1\uffff\2\u0098\1\uffff\3\u0098\1\uffff\4\u0098\4\uffff"+
			"\1\u0098\1\uffff\4\u0098\1\uffff\1\u0098\1\uffff\3\u0098\3\uffff\12\u0098"+
			"\1\uffff\1\u0098\2\uffff\2\u0098\4\uffff\4\u0098\1\uffff\4\u0098\1\uffff"+
			"\5\u0098\1\u00ae\4\u0098\1\uffff\7\u0098\2\uffff\1\u0098\1\uffff\3\u0098"+
			"\2\uffff\1\u009f\1\u00a1\1\u0098\1\uffff\3\u0098\2\uffff\1\u00a5\1\uffff"+
			"\1\u0098\1\uffff\1\u0098\1\uffff\1\u0098\2\uffff\4\u0098\1\uffff\2\u0098"+
			"\2\uffff\3\u0098\1\uffff\1\u0098\1\uffff\5\u0098\2\uffff\1\u0098\2\uffff"+
			"\5\u0098\4\uffff\1\u00a8\2\uffff\1\u009a\2\uffff\1\u009b\1\u00a3\1\u009a"+
			"\10\uffff\1\u0096\1\u009c\1\u009a\44\uffff\1\u0098\44\uffff\1\u0098\56"+
			"\uffff\1\u0098\3\uffff\1\u0098\56\uffff\1\u0098\3\uffff\1\u0098\31\uffff"+
			"\1\u0098\6\uffff\1\u0098\73\uffff\1\u0098",
			"\1\116\1\uffff\6\116\1\uffff\1\116\1\uffff\1\116\3\uffff\1\116\2\uffff"+
			"\1\116\1\uffff\2\116\5\uffff\2\116\1\uffff\2\116\2\uffff\1\116\1\uffff"+
			"\5\116\1\uffff\2\116\1\uffff\4\116\2\uffff\1\116\7\uffff\1\116\1\uffff"+
			"\1\116\1\uffff\3\116\1\uffff\3\116\1\uffff\3\116\1\uffff\4\116\1\uffff"+
			"\2\116\1\uffff\1\116\1\uffff\2\116\1\uffff\1\116\1\uffff\2\116\2\uffff"+
			"\1\116\1\uffff\3\116\5\uffff\4\116\5\uffff\3\116\2\uffff\1\116\4\uffff"+
			"\2\116\3\uffff\2\116\1\uffff\4\116\5\uffff\3\116\1\uffff\5\116\3\uffff"+
			"\1\116\1\uffff\3\116\1\uffff\5\116\1\uffff\1\116\1\u00b1\4\116\1\uffff"+
			"\1\116\1\uffff\2\116\1\uffff\2\116\1\uffff\2\116\1\uffff\1\116\1\uffff"+
			"\1\116\1\uffff\1\116\2\uffff\2\116\4\uffff\2\116\1\uffff\2\116\1\uffff"+
			"\3\116\1\uffff\4\116\4\uffff\1\116\1\uffff\4\116\1\uffff\1\116\1\uffff"+
			"\3\116\1\u00b2\2\uffff\12\116\1\uffff\1\116\2\uffff\2\116\4\uffff\4\116"+
			"\1\u00b0\4\116\1\uffff\5\116\1\uffff\4\116\1\uffff\7\116\1\uffff\2\116"+
			"\1\uffff\3\116\4\uffff\1\116\1\uffff\3\116\4\uffff\1\116\1\uffff\1\116"+
			"\1\uffff\1\116\2\uffff\4\116\1\uffff\2\116\2\uffff\3\116\1\uffff\1\116"+
			"\1\uffff\5\116\2\uffff\1\116\1\uffff\6\116\4\uffff\1\u00b3\67\uffff\1"+
			"\116\44\uffff\1\116\56\uffff\1\116\3\uffff\1\116\56\uffff\1\116\3\uffff"+
			"\1\116\31\uffff\1\116\6\uffff\1\116\73\uffff\1\116",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"\1\uffff",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
	static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
	static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
	static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
	static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
	static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
	static final short[][] DFA11_transition;

	static {
		int numStates = DFA11_transitionS.length;
		DFA11_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
		}
	}

	protected class DFA11 extends DFA {

		public DFA11(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 11;
			this.eot = DFA11_eot;
			this.eof = DFA11_eof;
			this.min = DFA11_min;
			this.max = DFA11_max;
			this.accept = DFA11_accept;
			this.special = DFA11_special;
			this.transition = DFA11_transition;
		}
		@Override
		public String getDescription() {
			return "96:1: atomjoinSource : ( tableSource ( lateralView ^)* | virtualTableSource ( lateralView ^)* | ( LPAREN ( KW_WITH | KW_SELECT | KW_MAP | KW_REDUCE | KW_FROM ) )=> subQuerySource ( lateralView ^)* | ( LPAREN LPAREN atomSelectStatement RPAREN setOperator )=> subQuerySource ( lateralView ^)* | partitionedTableFunction ( lateralView ^)* | LPAREN ! joinSource RPAREN !);";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA11_85 = input.LA(1);
						 
						int index11_85 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_85);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA11_86 = input.LA(1);
						 
						int index11_86 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_86);
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA11_87 = input.LA(1);
						 
						int index11_87 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_87);
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA11_88 = input.LA(1);
						 
						int index11_88 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_88);
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA11_89 = input.LA(1);
						 
						int index11_89 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_89);
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA11_90 = input.LA(1);
						 
						int index11_90 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_90);
						if ( s>=0 ) return s;
						break;

					case 6 : 
						int LA11_91 = input.LA(1);
						 
						int index11_91 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_91);
						if ( s>=0 ) return s;
						break;

					case 7 : 
						int LA11_92 = input.LA(1);
						 
						int index11_92 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_92);
						if ( s>=0 ) return s;
						break;

					case 8 : 
						int LA11_93 = input.LA(1);
						 
						int index11_93 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_93);
						if ( s>=0 ) return s;
						break;

					case 9 : 
						int LA11_94 = input.LA(1);
						 
						int index11_94 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_94);
						if ( s>=0 ) return s;
						break;

					case 10 : 
						int LA11_95 = input.LA(1);
						 
						int index11_95 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_95);
						if ( s>=0 ) return s;
						break;

					case 11 : 
						int LA11_96 = input.LA(1);
						 
						int index11_96 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_96);
						if ( s>=0 ) return s;
						break;

					case 12 : 
						int LA11_97 = input.LA(1);
						 
						int index11_97 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_97);
						if ( s>=0 ) return s;
						break;

					case 13 : 
						int LA11_98 = input.LA(1);
						 
						int index11_98 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_98);
						if ( s>=0 ) return s;
						break;

					case 14 : 
						int LA11_99 = input.LA(1);
						 
						int index11_99 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_99);
						if ( s>=0 ) return s;
						break;

					case 15 : 
						int LA11_100 = input.LA(1);
						 
						int index11_100 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_100);
						if ( s>=0 ) return s;
						break;

					case 16 : 
						int LA11_101 = input.LA(1);
						 
						int index11_101 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_101);
						if ( s>=0 ) return s;
						break;

					case 17 : 
						int LA11_102 = input.LA(1);
						 
						int index11_102 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_102);
						if ( s>=0 ) return s;
						break;

					case 18 : 
						int LA11_103 = input.LA(1);
						 
						int index11_103 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_103);
						if ( s>=0 ) return s;
						break;

					case 19 : 
						int LA11_104 = input.LA(1);
						 
						int index11_104 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_104);
						if ( s>=0 ) return s;
						break;

					case 20 : 
						int LA11_105 = input.LA(1);
						 
						int index11_105 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_105);
						if ( s>=0 ) return s;
						break;

					case 21 : 
						int LA11_106 = input.LA(1);
						 
						int index11_106 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_106);
						if ( s>=0 ) return s;
						break;

					case 22 : 
						int LA11_107 = input.LA(1);
						 
						int index11_107 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_107);
						if ( s>=0 ) return s;
						break;

					case 23 : 
						int LA11_108 = input.LA(1);
						 
						int index11_108 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_108);
						if ( s>=0 ) return s;
						break;

					case 24 : 
						int LA11_109 = input.LA(1);
						 
						int index11_109 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_109);
						if ( s>=0 ) return s;
						break;

					case 25 : 
						int LA11_110 = input.LA(1);
						 
						int index11_110 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_110);
						if ( s>=0 ) return s;
						break;

					case 26 : 
						int LA11_111 = input.LA(1);
						 
						int index11_111 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_111);
						if ( s>=0 ) return s;
						break;

					case 27 : 
						int LA11_112 = input.LA(1);
						 
						int index11_112 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_112);
						if ( s>=0 ) return s;
						break;

					case 28 : 
						int LA11_113 = input.LA(1);
						 
						int index11_113 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_113);
						if ( s>=0 ) return s;
						break;

					case 29 : 
						int LA11_114 = input.LA(1);
						 
						int index11_114 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_114);
						if ( s>=0 ) return s;
						break;

					case 30 : 
						int LA11_115 = input.LA(1);
						 
						int index11_115 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_115);
						if ( s>=0 ) return s;
						break;

					case 31 : 
						int LA11_116 = input.LA(1);
						 
						int index11_116 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_116);
						if ( s>=0 ) return s;
						break;

					case 32 : 
						int LA11_117 = input.LA(1);
						 
						int index11_117 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_117);
						if ( s>=0 ) return s;
						break;

					case 33 : 
						int LA11_118 = input.LA(1);
						 
						int index11_118 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_118);
						if ( s>=0 ) return s;
						break;

					case 34 : 
						int LA11_119 = input.LA(1);
						 
						int index11_119 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_119);
						if ( s>=0 ) return s;
						break;

					case 35 : 
						int LA11_120 = input.LA(1);
						 
						int index11_120 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_120);
						if ( s>=0 ) return s;
						break;

					case 36 : 
						int LA11_121 = input.LA(1);
						 
						int index11_121 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_121);
						if ( s>=0 ) return s;
						break;

					case 37 : 
						int LA11_122 = input.LA(1);
						 
						int index11_122 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_122);
						if ( s>=0 ) return s;
						break;

					case 38 : 
						int LA11_123 = input.LA(1);
						 
						int index11_123 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_123);
						if ( s>=0 ) return s;
						break;

					case 39 : 
						int LA11_124 = input.LA(1);
						 
						int index11_124 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_124);
						if ( s>=0 ) return s;
						break;

					case 40 : 
						int LA11_125 = input.LA(1);
						 
						int index11_125 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_125);
						if ( s>=0 ) return s;
						break;

					case 41 : 
						int LA11_126 = input.LA(1);
						 
						int index11_126 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_126);
						if ( s>=0 ) return s;
						break;

					case 42 : 
						int LA11_127 = input.LA(1);
						 
						int index11_127 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_127);
						if ( s>=0 ) return s;
						break;

					case 43 : 
						int LA11_128 = input.LA(1);
						 
						int index11_128 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_128);
						if ( s>=0 ) return s;
						break;

					case 44 : 
						int LA11_129 = input.LA(1);
						 
						int index11_129 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_129);
						if ( s>=0 ) return s;
						break;

					case 45 : 
						int LA11_130 = input.LA(1);
						 
						int index11_130 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_130);
						if ( s>=0 ) return s;
						break;

					case 46 : 
						int LA11_131 = input.LA(1);
						 
						int index11_131 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_131);
						if ( s>=0 ) return s;
						break;

					case 47 : 
						int LA11_132 = input.LA(1);
						 
						int index11_132 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_132);
						if ( s>=0 ) return s;
						break;

					case 48 : 
						int LA11_133 = input.LA(1);
						 
						int index11_133 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_133);
						if ( s>=0 ) return s;
						break;

					case 49 : 
						int LA11_134 = input.LA(1);
						 
						int index11_134 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_134);
						if ( s>=0 ) return s;
						break;

					case 50 : 
						int LA11_135 = input.LA(1);
						 
						int index11_135 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_135);
						if ( s>=0 ) return s;
						break;

					case 51 : 
						int LA11_136 = input.LA(1);
						 
						int index11_136 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_136);
						if ( s>=0 ) return s;
						break;

					case 52 : 
						int LA11_137 = input.LA(1);
						 
						int index11_137 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_137);
						if ( s>=0 ) return s;
						break;

					case 53 : 
						int LA11_138 = input.LA(1);
						 
						int index11_138 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_138);
						if ( s>=0 ) return s;
						break;

					case 54 : 
						int LA11_139 = input.LA(1);
						 
						int index11_139 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_139);
						if ( s>=0 ) return s;
						break;

					case 55 : 
						int LA11_140 = input.LA(1);
						 
						int index11_140 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_140);
						if ( s>=0 ) return s;
						break;

					case 56 : 
						int LA11_141 = input.LA(1);
						 
						int index11_141 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_141);
						if ( s>=0 ) return s;
						break;

					case 57 : 
						int LA11_142 = input.LA(1);
						 
						int index11_142 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_142);
						if ( s>=0 ) return s;
						break;

					case 58 : 
						int LA11_143 = input.LA(1);
						 
						int index11_143 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_143);
						if ( s>=0 ) return s;
						break;

					case 59 : 
						int LA11_144 = input.LA(1);
						 
						int index11_144 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_144);
						if ( s>=0 ) return s;
						break;

					case 60 : 
						int LA11_145 = input.LA(1);
						 
						int index11_145 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_145);
						if ( s>=0 ) return s;
						break;

					case 61 : 
						int LA11_146 = input.LA(1);
						 
						int index11_146 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_146);
						if ( s>=0 ) return s;
						break;

					case 62 : 
						int LA11_147 = input.LA(1);
						 
						int index11_147 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_147);
						if ( s>=0 ) return s;
						break;

					case 63 : 
						int LA11_148 = input.LA(1);
						 
						int index11_148 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_148);
						if ( s>=0 ) return s;
						break;

					case 64 : 
						int LA11_149 = input.LA(1);
						 
						int index11_149 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_149);
						if ( s>=0 ) return s;
						break;

					case 65 : 
						int LA11_150 = input.LA(1);
						 
						int index11_150 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_150);
						if ( s>=0 ) return s;
						break;

					case 66 : 
						int LA11_151 = input.LA(1);
						 
						int index11_151 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_151);
						if ( s>=0 ) return s;
						break;

					case 67 : 
						int LA11_152 = input.LA(1);
						 
						int index11_152 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_152);
						if ( s>=0 ) return s;
						break;

					case 68 : 
						int LA11_153 = input.LA(1);
						 
						int index11_153 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_153);
						if ( s>=0 ) return s;
						break;

					case 69 : 
						int LA11_154 = input.LA(1);
						 
						int index11_154 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_154);
						if ( s>=0 ) return s;
						break;

					case 70 : 
						int LA11_155 = input.LA(1);
						 
						int index11_155 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_155);
						if ( s>=0 ) return s;
						break;

					case 71 : 
						int LA11_156 = input.LA(1);
						 
						int index11_156 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_156);
						if ( s>=0 ) return s;
						break;

					case 72 : 
						int LA11_157 = input.LA(1);
						 
						int index11_157 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_157);
						if ( s>=0 ) return s;
						break;

					case 73 : 
						int LA11_158 = input.LA(1);
						 
						int index11_158 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_158);
						if ( s>=0 ) return s;
						break;

					case 74 : 
						int LA11_159 = input.LA(1);
						 
						int index11_159 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_159);
						if ( s>=0 ) return s;
						break;

					case 75 : 
						int LA11_160 = input.LA(1);
						 
						int index11_160 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_160);
						if ( s>=0 ) return s;
						break;

					case 76 : 
						int LA11_161 = input.LA(1);
						 
						int index11_161 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_161);
						if ( s>=0 ) return s;
						break;

					case 77 : 
						int LA11_162 = input.LA(1);
						 
						int index11_162 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_162);
						if ( s>=0 ) return s;
						break;

					case 78 : 
						int LA11_163 = input.LA(1);
						 
						int index11_163 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_163);
						if ( s>=0 ) return s;
						break;

					case 79 : 
						int LA11_164 = input.LA(1);
						 
						int index11_164 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_164);
						if ( s>=0 ) return s;
						break;

					case 80 : 
						int LA11_165 = input.LA(1);
						 
						int index11_165 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_165);
						if ( s>=0 ) return s;
						break;

					case 81 : 
						int LA11_166 = input.LA(1);
						 
						int index11_166 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_166);
						if ( s>=0 ) return s;
						break;

					case 82 : 
						int LA11_167 = input.LA(1);
						 
						int index11_167 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_167);
						if ( s>=0 ) return s;
						break;

					case 83 : 
						int LA11_168 = input.LA(1);
						 
						int index11_168 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_168);
						if ( s>=0 ) return s;
						break;

					case 84 : 
						int LA11_169 = input.LA(1);
						 
						int index11_169 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_169);
						if ( s>=0 ) return s;
						break;

					case 85 : 
						int LA11_170 = input.LA(1);
						 
						int index11_170 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_170);
						if ( s>=0 ) return s;
						break;

					case 86 : 
						int LA11_171 = input.LA(1);
						 
						int index11_171 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_171);
						if ( s>=0 ) return s;
						break;

					case 87 : 
						int LA11_172 = input.LA(1);
						 
						int index11_172 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_172);
						if ( s>=0 ) return s;
						break;

					case 88 : 
						int LA11_173 = input.LA(1);
						 
						int index11_173 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_173);
						if ( s>=0 ) return s;
						break;

					case 89 : 
						int LA11_174 = input.LA(1);
						 
						int index11_174 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_174);
						if ( s>=0 ) return s;
						break;

					case 90 : 
						int LA11_175 = input.LA(1);
						 
						int index11_175 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						 
						input.seek(index11_175);
						if ( s>=0 ) return s;
						break;

					case 91 : 
						int LA11_176 = input.LA(1);
						 
						int index11_176 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						else if ( (true) ) {s = 78;}
						 
						input.seek(index11_176);
						if ( s>=0 ) return s;
						break;

					case 92 : 
						int LA11_177 = input.LA(1);
						 
						int index11_177 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						else if ( (true) ) {s = 78;}
						 
						input.seek(index11_177);
						if ( s>=0 ) return s;
						break;

					case 93 : 
						int LA11_178 = input.LA(1);
						 
						int index11_178 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						else if ( (true) ) {s = 78;}
						 
						input.seek(index11_178);
						if ( s>=0 ) return s;
						break;

					case 94 : 
						int LA11_179 = input.LA(1);
						 
						int index11_179 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred1_FromClauseParser()) ) {s = 186;}
						else if ( (synpred2_FromClauseParser()) ) {s = 187;}
						else if ( (true) ) {s = 78;}
						 
						input.seek(index11_179);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 11, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA14_eotS =
		"\117\uffff";
	static final String DFA14_eofS =
		"\1\uffff\2\5\114\uffff";
	static final String DFA14_minS =
		"\1\30\2\11\3\uffff\1\u00d3\42\uffff\1\u00d3\45\uffff";
	static final String DFA14_maxS =
		"\3\u0289\3\uffff\1\u017b\42\uffff\1\u017b\45\uffff";
	static final String DFA14_acceptS =
		"\3\uffff\1\2\1\3\1\1\105\uffff\1\4\3\uffff";
	static final String DFA14_specialS =
		"\117\uffff}>";
	static final String[] DFA14_transitionS = {
			"\1\1\1\uffff\6\2\1\uffff\1\2\1\uffff\1\2\3\uffff\1\2\2\uffff\1\2\1\uffff"+
			"\2\2\5\uffff\2\2\1\uffff\2\2\2\uffff\1\2\1\uffff\5\2\1\uffff\2\2\1\uffff"+
			"\4\2\2\uffff\1\2\7\uffff\1\2\1\uffff\1\2\1\uffff\3\2\1\uffff\3\2\1\uffff"+
			"\3\2\1\uffff\4\2\1\uffff\2\2\1\uffff\1\2\1\uffff\2\2\1\uffff\1\2\1\uffff"+
			"\2\2\2\uffff\1\2\1\uffff\3\2\5\uffff\4\2\5\uffff\2\2\3\uffff\1\2\4\uffff"+
			"\2\2\3\uffff\2\2\1\uffff\3\2\6\uffff\3\2\1\uffff\5\2\3\uffff\1\2\1\uffff"+
			"\3\2\1\uffff\5\2\1\uffff\1\2\1\uffff\4\2\1\uffff\1\2\1\uffff\2\2\1\uffff"+
			"\2\2\1\uffff\2\2\1\uffff\1\2\1\uffff\1\2\1\uffff\1\2\2\uffff\2\2\4\uffff"+
			"\2\2\1\uffff\2\2\1\uffff\3\2\1\uffff\4\2\4\uffff\1\2\1\uffff\4\2\1\uffff"+
			"\1\2\1\uffff\3\2\3\uffff\12\2\1\uffff\1\2\2\uffff\2\2\4\uffff\4\2\1\uffff"+
			"\4\2\1\uffff\5\2\1\uffff\4\2\1\uffff\7\2\1\uffff\1\3\1\2\1\uffff\3\2"+
			"\4\uffff\1\2\1\uffff\3\2\4\uffff\1\2\1\uffff\1\2\1\uffff\1\2\2\uffff"+
			"\4\2\1\uffff\2\2\2\uffff\3\2\1\uffff\1\2\1\uffff\5\2\2\uffff\1\2\2\uffff"+
			"\5\2\4\uffff\1\4\67\uffff\1\2\44\uffff\1\2\56\uffff\1\2\3\uffff\1\2\56"+
			"\uffff\1\2\3\uffff\1\2\31\uffff\1\2\6\uffff\1\2\73\uffff\1\2",
			"\1\5\6\uffff\1\5\7\uffff\1\5\1\uffff\6\5\1\uffff\1\5\1\uffff\1\5\3\uffff"+
			"\1\5\1\uffff\2\5\1\uffff\2\5\5\uffff\2\5\1\uffff\2\5\2\uffff\1\5\1\uffff"+
			"\5\5\1\uffff\2\5\1\uffff\4\5\2\uffff\1\5\1\uffff\1\5\5\uffff\1\5\1\uffff"+
			"\1\5\1\uffff\3\5\1\uffff\3\5\1\uffff\3\5\1\uffff\4\5\1\uffff\2\5\1\uffff"+
			"\1\5\1\uffff\2\5\1\uffff\1\5\1\uffff\3\5\1\uffff\1\5\1\uffff\3\5\5\uffff"+
			"\4\5\5\uffff\2\5\1\uffff\1\5\1\uffff\1\5\1\uffff\1\5\1\uffff\3\5\3\uffff"+
			"\7\5\1\uffff\1\5\3\uffff\13\5\1\uffff\1\5\1\uffff\3\5\1\uffff\5\5\1\uffff"+
			"\6\5\1\uffff\4\5\1\uffff\2\5\1\uffff\2\5\1\uffff\1\5\1\uffff\1\5\1\uffff"+
			"\2\5\1\uffff\2\5\1\uffff\1\5\2\uffff\2\5\1\uffff\2\5\1\uffff\3\5\1\uffff"+
			"\4\5\4\uffff\1\5\1\uffff\4\5\1\uffff\1\5\1\uffff\4\5\2\uffff\12\5\1\uffff"+
			"\2\5\1\uffff\2\5\4\uffff\11\5\1\uffff\5\5\1\uffff\4\5\1\uffff\7\5\2\uffff"+
			"\5\5\4\uffff\1\5\1\uffff\3\5\4\uffff\1\5\1\uffff\3\5\2\uffff\4\5\1\uffff"+
			"\2\5\1\uffff\4\5\1\uffff\1\5\1\uffff\5\5\1\uffff\3\5\1\uffff\5\5\4\uffff"+
			"\1\6\14\uffff\1\5\52\uffff\1\5\44\uffff\1\5\56\uffff\1\5\3\uffff\1\5"+
			"\56\uffff\1\5\3\uffff\1\5\31\uffff\1\5\6\uffff\1\5\73\uffff\1\5",
			"\1\5\6\uffff\1\5\7\uffff\1\5\1\uffff\6\5\1\uffff\1\5\1\uffff\1\5\3\uffff"+
			"\1\5\1\uffff\2\5\1\uffff\2\5\5\uffff\2\5\1\uffff\2\5\2\uffff\1\5\1\uffff"+
			"\5\5\1\uffff\2\5\1\uffff\4\5\2\uffff\1\5\1\uffff\1\5\5\uffff\1\5\1\uffff"+
			"\1\5\1\uffff\3\5\1\uffff\3\5\1\uffff\3\5\1\uffff\4\5\1\uffff\2\5\1\uffff"+
			"\1\5\1\uffff\2\5\1\uffff\1\5\1\uffff\3\5\1\uffff\1\5\1\uffff\3\5\5\uffff"+
			"\4\5\5\uffff\2\5\1\uffff\1\5\1\uffff\1\5\1\uffff\1\5\1\uffff\3\5\3\uffff"+
			"\7\5\1\uffff\1\5\3\uffff\13\5\1\uffff\1\5\1\uffff\3\5\1\uffff\5\5\1\uffff"+
			"\6\5\1\uffff\4\5\1\uffff\2\5\1\uffff\2\5\1\uffff\1\5\1\uffff\1\5\1\uffff"+
			"\2\5\1\uffff\2\5\1\uffff\1\5\2\uffff\2\5\1\uffff\2\5\1\uffff\3\5\1\uffff"+
			"\4\5\4\uffff\1\5\1\uffff\4\5\1\uffff\1\5\1\uffff\4\5\2\uffff\12\5\1\uffff"+
			"\2\5\1\uffff\2\5\4\uffff\11\5\1\uffff\5\5\1\uffff\4\5\1\uffff\7\5\2\uffff"+
			"\5\5\4\uffff\1\5\1\uffff\3\5\4\uffff\1\5\1\uffff\3\5\2\uffff\4\5\1\uffff"+
			"\2\5\1\uffff\4\5\1\uffff\1\5\1\uffff\5\5\1\uffff\3\5\1\uffff\5\5\4\uffff"+
			"\1\51\14\uffff\1\5\52\uffff\1\5\44\uffff\1\5\56\uffff\1\5\3\uffff\1\5"+
			"\56\uffff\1\5\3\uffff\1\5\31\uffff\1\5\6\uffff\1\5\73\uffff\1\5",
			"",
			"",
			"",
			"\1\113\u00a7\uffff\1\5",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\113\u00a7\uffff\1\5",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
	static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
	static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
	static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
	static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
	static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
	static final short[][] DFA14_transition;

	static {
		int numStates = DFA14_transitionS.length;
		DFA14_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
		}
	}

	protected class DFA14 extends DFA {

		public DFA14(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 14;
			this.eot = DFA14_eot;
			this.eof = DFA14_eof;
			this.min = DFA14_min;
			this.max = DFA14_max;
			this.accept = DFA14_accept;
			this.special = DFA14_special;
			this.transition = DFA14_transition;
		}
		@Override
		public String getDescription() {
			return "116:5: ( tableSource | virtualTableSource | subQuerySource | partitionedTableFunction )";
		}
	}

	static final String DFA21_eotS =
		"\152\uffff";
	static final String DFA21_eofS =
		"\1\1\151\uffff";
	static final String DFA21_minS =
		"\1\11\2\uffff\1\30\32\uffff\2\0\112\uffff";
	static final String DFA21_maxS =
		"\1\u0176\2\uffff\1\u0289\32\uffff\2\0\112\uffff";
	static final String DFA21_acceptS =
		"\1\uffff\1\2\104\uffff\1\1\43\uffff";
	static final String DFA21_specialS =
		"\36\uffff\1\0\1\1\112\uffff}>";
	static final String[] DFA21_transitionS = {
			"\1\3\63\uffff\1\1\17\uffff\1\1\32\uffff\1\1\13\uffff\1\1\27\uffff\1\1"+
			"\3\uffff\1\1\1\uffff\1\1\7\uffff\1\1\3\uffff\1\1\1\uffff\1\1\6\uffff"+
			"\1\1\5\uffff\2\1\3\uffff\1\1\12\uffff\1\1\6\uffff\1\1\16\uffff\1\1\4"+
			"\uffff\1\1\40\uffff\1\1\16\uffff\1\1\13\uffff\1\1\14\uffff\1\1\41\uffff"+
			"\1\1\13\uffff\1\1\14\uffff\1\1\1\uffff\1\1\27\uffff\1\1",
			"",
			"",
			"\1\36\1\uffff\6\37\1\uffff\1\37\1\uffff\1\37\3\uffff\1\37\2\uffff\1"+
			"\37\1\uffff\2\37\5\uffff\2\37\1\uffff\2\37\2\uffff\1\37\1\uffff\5\37"+
			"\1\uffff\2\37\1\uffff\4\37\2\uffff\1\37\7\uffff\1\37\1\uffff\1\37\1\uffff"+
			"\3\37\1\uffff\3\37\1\uffff\3\37\1\uffff\4\37\1\uffff\2\37\1\uffff\1\37"+
			"\1\uffff\2\37\1\uffff\1\37\1\uffff\2\37\2\uffff\1\37\1\uffff\3\37\5\uffff"+
			"\4\37\5\uffff\2\37\3\uffff\1\37\4\uffff\2\37\3\uffff\2\37\1\uffff\3\37"+
			"\6\uffff\3\37\1\uffff\5\37\1\1\2\uffff\1\37\1\uffff\3\37\1\uffff\5\37"+
			"\1\uffff\1\37\1\uffff\4\37\1\uffff\1\37\1\uffff\2\37\1\uffff\2\37\1\uffff"+
			"\2\37\1\uffff\1\37\1\uffff\1\37\1\uffff\1\37\2\uffff\2\37\4\uffff\2\37"+
			"\1\uffff\2\37\1\uffff\3\37\1\uffff\4\37\4\uffff\1\37\1\uffff\4\37\1\uffff"+
			"\1\37\1\uffff\3\37\3\uffff\12\37\1\uffff\1\37\2\uffff\2\37\4\uffff\4"+
			"\37\1\uffff\4\37\1\uffff\5\37\1\uffff\4\37\1\uffff\7\37\1\uffff\1\1\1"+
			"\37\1\uffff\3\37\4\uffff\1\37\1\uffff\3\37\4\uffff\1\37\1\uffff\1\37"+
			"\1\uffff\1\37\2\uffff\4\37\1\uffff\2\37\2\uffff\3\37\1\uffff\1\37\1\uffff"+
			"\5\37\2\uffff\1\37\2\uffff\5\37\4\uffff\1\1\67\uffff\1\37\44\uffff\1"+
			"\37\56\uffff\1\37\3\uffff\1\37\56\uffff\1\37\3\uffff\1\37\31\uffff\1"+
			"\37\6\uffff\1\37\73\uffff\1\37",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\uffff",
			"\1\uffff",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
	static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
	static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
	static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
	static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
	static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
	static final short[][] DFA21_transition;

	static {
		int numStates = DFA21_transitionS.length;
		DFA21_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
		}
	}

	protected class DFA21 extends DFA {

		public DFA21(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 21;
			this.eot = DFA21_eot;
			this.eof = DFA21_eof;
			this.min = DFA21_min;
			this.max = DFA21_max;
			this.accept = DFA21_accept;
			this.special = DFA21_special;
			this.transition = DFA21_transition;
		}
		@Override
		public String getDescription() {
			return "()* loopback of 154:108: ( ( COMMA )=> COMMA identifier )*";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA21_30 = input.LA(1);
						 
						int index21_30 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred4_FromClauseParser()) ) {s = 70;}
						else if ( (true) ) {s = 1;}
						 
						input.seek(index21_30);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA21_31 = input.LA(1);
						 
						int index21_31 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred4_FromClauseParser()) ) {s = 70;}
						else if ( (true) ) {s = 1;}
						 
						input.seek(index21_31);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 21, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA24_eotS =
		"\152\uffff";
	static final String DFA24_eofS =
		"\1\1\151\uffff";
	static final String DFA24_minS =
		"\1\11\2\uffff\1\30\32\uffff\2\0\112\uffff";
	static final String DFA24_maxS =
		"\1\u0176\2\uffff\1\u0289\32\uffff\2\0\112\uffff";
	static final String DFA24_acceptS =
		"\1\uffff\1\2\104\uffff\1\1\43\uffff";
	static final String DFA24_specialS =
		"\36\uffff\1\0\1\1\112\uffff}>";
	static final String[] DFA24_transitionS = {
			"\1\3\63\uffff\1\1\17\uffff\1\1\32\uffff\1\1\13\uffff\1\1\27\uffff\1\1"+
			"\3\uffff\1\1\1\uffff\1\1\7\uffff\1\1\3\uffff\1\1\1\uffff\1\1\6\uffff"+
			"\1\1\5\uffff\2\1\3\uffff\1\1\12\uffff\1\1\6\uffff\1\1\16\uffff\1\1\4"+
			"\uffff\1\1\40\uffff\1\1\16\uffff\1\1\13\uffff\1\1\14\uffff\1\1\41\uffff"+
			"\1\1\13\uffff\1\1\14\uffff\1\1\1\uffff\1\1\27\uffff\1\1",
			"",
			"",
			"\1\36\1\uffff\6\37\1\uffff\1\37\1\uffff\1\37\3\uffff\1\37\2\uffff\1"+
			"\37\1\uffff\2\37\5\uffff\2\37\1\uffff\2\37\2\uffff\1\37\1\uffff\5\37"+
			"\1\uffff\2\37\1\uffff\4\37\2\uffff\1\37\7\uffff\1\37\1\uffff\1\37\1\uffff"+
			"\3\37\1\uffff\3\37\1\uffff\3\37\1\uffff\4\37\1\uffff\2\37\1\uffff\1\37"+
			"\1\uffff\2\37\1\uffff\1\37\1\uffff\2\37\2\uffff\1\37\1\uffff\3\37\5\uffff"+
			"\4\37\5\uffff\2\37\3\uffff\1\37\4\uffff\2\37\3\uffff\2\37\1\uffff\3\37"+
			"\6\uffff\3\37\1\uffff\5\37\1\1\2\uffff\1\37\1\uffff\3\37\1\uffff\5\37"+
			"\1\uffff\1\37\1\uffff\4\37\1\uffff\1\37\1\uffff\2\37\1\uffff\2\37\1\uffff"+
			"\2\37\1\uffff\1\37\1\uffff\1\37\1\uffff\1\37\2\uffff\2\37\4\uffff\2\37"+
			"\1\uffff\2\37\1\uffff\3\37\1\uffff\4\37\4\uffff\1\37\1\uffff\4\37\1\uffff"+
			"\1\37\1\uffff\3\37\3\uffff\12\37\1\uffff\1\37\2\uffff\2\37\4\uffff\4"+
			"\37\1\uffff\4\37\1\uffff\5\37\1\uffff\4\37\1\uffff\7\37\1\uffff\1\1\1"+
			"\37\1\uffff\3\37\4\uffff\1\37\1\uffff\3\37\4\uffff\1\37\1\uffff\1\37"+
			"\1\uffff\1\37\2\uffff\4\37\1\uffff\2\37\2\uffff\3\37\1\uffff\1\37\1\uffff"+
			"\5\37\2\uffff\1\37\2\uffff\5\37\4\uffff\1\1\67\uffff\1\37\44\uffff\1"+
			"\37\56\uffff\1\37\3\uffff\1\37\56\uffff\1\37\3\uffff\1\37\31\uffff\1"+
			"\37\6\uffff\1\37\73\uffff\1\37",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\uffff",
			"\1\uffff",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
	static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
	static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
	static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
	static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
	static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
	static final short[][] DFA24_transition;

	static {
		int numStates = DFA24_transitionS.length;
		DFA24_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
		}
	}

	protected class DFA24 extends DFA {

		public DFA24(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 24;
			this.eot = DFA24_eot;
			this.eof = DFA24_eof;
			this.min = DFA24_min;
			this.max = DFA24_max;
			this.accept = DFA24_accept;
			this.special = DFA24_special;
			this.transition = DFA24_transition;
		}
		@Override
		public String getDescription() {
			return "()* loopback of 157:66: ( ( COMMA )=> COMMA identifier )*";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA24_30 = input.LA(1);
						 
						int index24_30 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred5_FromClauseParser()) ) {s = 70;}
						else if ( (true) ) {s = 1;}
						 
						input.seek(index24_30);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA24_31 = input.LA(1);
						 
						int index24_31 = input.index();
						input.rewind();
						s = -1;
						if ( (synpred5_FromClauseParser()) ) {s = 70;}
						else if ( (true) ) {s = 1;}
						 
						input.seek(index24_31);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 24, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	static final String DFA39_eotS =
		"\u00c2\uffff";
	static final String DFA39_eofS =
		"\1\4\1\uffff\2\1\27\uffff\3\1\u00a4\uffff";
	static final String DFA39_minS =
		"\1\11\1\uffff\2\11\27\uffff\3\11\u00a4\uffff";
	static final String DFA39_maxS =
		"\1\u0289\1\uffff\2\u0176\27\uffff\3\u0176\u00a4\uffff";
	static final String DFA39_acceptS =
		"\1\uffff\1\1\2\uffff\1\2\u00bd\uffff";
	static final String DFA39_specialS =
		"\u00c2\uffff}>";
	static final String[] DFA39_transitionS = {
			"\1\4\16\uffff\1\2\1\uffff\6\1\1\uffff\1\1\1\uffff\1\1\3\uffff\1\1\1\uffff"+
			"\2\1\1\uffff\2\1\5\uffff\2\1\1\uffff\2\1\2\uffff\1\1\1\uffff\1\1\1\3"+
			"\3\1\1\uffff\2\1\1\uffff\4\1\2\uffff\1\1\1\uffff\1\4\5\uffff\1\1\1\uffff"+
			"\1\1\1\uffff\3\1\1\uffff\3\1\1\uffff\3\1\1\uffff\4\1\1\uffff\1\33\1\1"+
			"\1\uffff\1\1\1\uffff\2\1\1\uffff\1\1\1\uffff\2\1\1\4\1\uffff\1\1\1\uffff"+
			"\3\1\5\uffff\4\1\5\uffff\2\1\1\uffff\1\4\1\uffff\1\1\1\uffff\1\4\1\uffff"+
			"\1\4\2\1\3\uffff\2\1\1\4\3\1\1\4\1\uffff\1\4\3\uffff\3\1\1\4\5\1\2\4"+
			"\1\uffff\1\1\1\uffff\1\35\2\1\1\uffff\5\1\1\uffff\1\1\1\4\4\1\1\uffff"+
			"\1\1\1\4\2\1\1\uffff\2\1\1\uffff\2\1\1\uffff\1\1\1\uffff\1\1\1\uffff"+
			"\1\1\1\4\1\uffff\2\1\1\uffff\1\4\2\uffff\2\1\1\uffff\2\1\1\4\3\1\1\uffff"+
			"\4\1\4\uffff\1\1\1\uffff\4\1\1\uffff\1\1\1\uffff\3\1\1\4\2\uffff\12\1"+
			"\1\uffff\1\1\1\4\1\uffff\2\1\4\uffff\4\1\1\4\4\1\1\uffff\5\1\1\uffff"+
			"\1\1\1\34\2\1\1\uffff\7\1\2\uffff\1\1\1\uffff\3\1\4\uffff\1\1\1\uffff"+
			"\3\1\4\uffff\1\1\1\uffff\1\1\1\4\1\1\2\uffff\4\1\1\uffff\2\1\1\uffff"+
			"\1\4\3\1\1\uffff\1\1\1\uffff\5\1\1\uffff\1\4\1\1\1\4\1\uffff\5\1\21\uffff"+
			"\1\4\52\uffff\1\1\44\uffff\1\1\56\uffff\1\1\3\uffff\1\1\56\uffff\1\1"+
			"\3\uffff\1\1\31\uffff\1\1\6\uffff\1\1\73\uffff\1\1",
			"",
			"\1\1\16\uffff\1\1\44\uffff\1\1\17\uffff\1\1\32\uffff\1\1\13\uffff\1"+
			"\1\27\uffff\1\1\3\uffff\1\1\1\uffff\1\1\7\uffff\1\1\3\uffff\1\1\1\uffff"+
			"\1\1\6\uffff\1\1\5\uffff\2\1\3\uffff\1\1\12\uffff\1\1\6\uffff\1\1\16"+
			"\uffff\1\1\4\uffff\1\1\7\uffff\1\1\30\uffff\1\1\16\uffff\1\1\13\uffff"+
			"\1\1\14\uffff\1\1\41\uffff\1\1\13\uffff\1\1\14\uffff\1\1\1\uffff\1\1"+
			"\12\uffff\1\4\14\uffff\1\1",
			"\1\1\16\uffff\1\1\34\uffff\1\4\7\uffff\1\1\17\uffff\1\1\32\uffff\1\1"+
			"\13\uffff\1\1\27\uffff\1\1\3\uffff\1\1\1\uffff\1\1\7\uffff\1\1\3\uffff"+
			"\1\1\1\uffff\1\1\6\uffff\1\1\5\uffff\2\1\3\uffff\1\1\12\uffff\1\1\6\uffff"+
			"\1\1\16\uffff\1\1\4\uffff\1\1\7\uffff\1\1\30\uffff\1\1\16\uffff\1\1\13"+
			"\uffff\1\1\14\uffff\1\1\41\uffff\1\1\13\uffff\1\1\14\uffff\1\1\1\uffff"+
			"\1\1\27\uffff\1\1",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\1\16\uffff\1\1\34\uffff\1\4\7\uffff\1\1\17\uffff\1\1\32\uffff\1\1"+
			"\13\uffff\1\1\27\uffff\1\1\3\uffff\1\1\1\uffff\1\1\7\uffff\1\1\3\uffff"+
			"\1\1\1\uffff\1\1\6\uffff\1\1\5\uffff\2\1\3\uffff\1\1\12\uffff\1\1\6\uffff"+
			"\1\1\16\uffff\1\1\4\uffff\1\1\7\uffff\1\1\30\uffff\1\1\16\uffff\1\1\13"+
			"\uffff\1\1\14\uffff\1\1\41\uffff\1\1\13\uffff\1\1\14\uffff\1\1\1\uffff"+
			"\1\1\27\uffff\1\1",
			"\1\1\16\uffff\1\1\34\uffff\1\4\7\uffff\1\1\17\uffff\1\1\32\uffff\1\1"+
			"\13\uffff\1\1\27\uffff\1\1\3\uffff\1\1\1\uffff\1\1\7\uffff\1\1\3\uffff"+
			"\1\1\1\uffff\1\1\6\uffff\1\1\5\uffff\2\1\3\uffff\1\1\12\uffff\1\1\6\uffff"+
			"\1\1\16\uffff\1\1\4\uffff\1\1\7\uffff\1\1\30\uffff\1\1\16\uffff\1\1\13"+
			"\uffff\1\1\14\uffff\1\1\41\uffff\1\1\13\uffff\1\1\14\uffff\1\1\1\uffff"+
			"\1\1\27\uffff\1\1",
			"\1\1\16\uffff\1\1\44\uffff\1\1\17\uffff\1\1\32\uffff\1\1\13\uffff\1"+
			"\1\27\uffff\1\1\3\uffff\1\1\1\uffff\1\1\7\uffff\1\1\3\uffff\1\1\1\uffff"+
			"\1\1\6\uffff\1\1\5\uffff\2\1\3\uffff\1\1\12\uffff\1\1\6\uffff\1\1\16"+
			"\uffff\1\1\4\uffff\1\1\7\uffff\1\1\30\uffff\1\1\16\uffff\1\1\13\uffff"+
			"\1\1\14\uffff\1\1\41\uffff\1\1\13\uffff\1\1\14\uffff\1\1\1\uffff\1\1"+
			"\20\uffff\1\4\6\uffff\1\1",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] DFA39_eot = DFA.unpackEncodedString(DFA39_eotS);
	static final short[] DFA39_eof = DFA.unpackEncodedString(DFA39_eofS);
	static final char[] DFA39_min = DFA.unpackEncodedStringToUnsignedChars(DFA39_minS);
	static final char[] DFA39_max = DFA.unpackEncodedStringToUnsignedChars(DFA39_maxS);
	static final short[] DFA39_accept = DFA.unpackEncodedString(DFA39_acceptS);
	static final short[] DFA39_special = DFA.unpackEncodedString(DFA39_specialS);
	static final short[][] DFA39_transition;

	static {
		int numStates = DFA39_transitionS.length;
		DFA39_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA39_transition[i] = DFA.unpackEncodedString(DFA39_transitionS[i]);
		}
	}

	protected class DFA39 extends DFA {

		public DFA39(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 39;
			this.eot = DFA39_eot;
			this.eof = DFA39_eof;
			this.min = DFA39_min;
			this.max = DFA39_max;
			this.accept = DFA39_accept;
			this.special = DFA39_special;
			this.transition = DFA39_transition;
		}
		@Override
		public String getDescription() {
			return "201:64: ( ( KW_AS )? alias= identifier )?";
		}
	}

	static final String DFA43_eotS =
		"\u00a7\uffff";
	static final String DFA43_eofS =
		"\1\uffff\2\4\u00a4\uffff";
	static final String DFA43_minS =
		"\1\30\2\11\1\30\116\uffff\1\30\124\uffff";
	static final String DFA43_maxS =
		"\4\u0289\116\uffff\1\u0289\124\uffff";
	static final String DFA43_acceptS =
		"\4\uffff\1\2\u009d\uffff\1\1\4\uffff";
	static final String DFA43_specialS =
		"\u00a7\uffff}>";
	static final String[] DFA43_transitionS = {
			"\1\1\1\uffff\6\2\1\uffff\1\2\1\uffff\1\2\3\uffff\1\2\2\uffff\1\2\1\uffff"+
			"\2\2\5\uffff\2\2\1\uffff\2\2\2\uffff\1\2\1\uffff\5\2\1\uffff\2\2\1\uffff"+
			"\4\2\2\uffff\1\2\7\uffff\1\2\1\uffff\1\2\1\uffff\3\2\1\uffff\3\2\1\uffff"+
			"\3\2\1\uffff\4\2\1\uffff\2\2\1\uffff\1\2\1\uffff\2\2\1\uffff\1\2\1\uffff"+
			"\2\2\2\uffff\1\2\1\uffff\3\2\5\uffff\4\2\5\uffff\2\2\3\uffff\1\2\4\uffff"+
			"\2\2\3\uffff\2\2\1\uffff\3\2\6\uffff\3\2\1\uffff\5\2\3\uffff\1\2\1\uffff"+
			"\3\2\1\uffff\5\2\1\uffff\1\2\1\uffff\4\2\1\uffff\1\2\1\uffff\2\2\1\uffff"+
			"\2\2\1\uffff\2\2\1\uffff\1\2\1\uffff\1\2\1\uffff\1\2\2\uffff\2\2\4\uffff"+
			"\2\2\1\uffff\2\2\1\uffff\3\2\1\uffff\4\2\4\uffff\1\2\1\uffff\4\2\1\uffff"+
			"\1\2\1\uffff\3\2\3\uffff\12\2\1\uffff\1\2\2\uffff\2\2\4\uffff\4\2\1\uffff"+
			"\4\2\1\uffff\5\2\1\uffff\4\2\1\uffff\7\2\2\uffff\1\2\1\uffff\3\2\4\uffff"+
			"\1\2\1\uffff\3\2\4\uffff\1\2\1\uffff\1\2\1\uffff\1\2\2\uffff\4\2\1\uffff"+
			"\2\2\2\uffff\3\2\1\uffff\1\2\1\uffff\5\2\2\uffff\1\2\2\uffff\5\2\74\uffff"+
			"\1\2\44\uffff\1\2\56\uffff\1\2\3\uffff\1\2\56\uffff\1\2\3\uffff\1\2\31"+
			"\uffff\1\2\6\uffff\1\2\73\uffff\1\2",
			"\1\4\6\uffff\1\3\7\uffff\1\4\1\uffff\6\4\1\uffff\1\4\1\uffff\1\4\3\uffff"+
			"\1\4\1\uffff\2\4\1\uffff\2\4\5\uffff\2\4\1\uffff\2\4\2\uffff\1\4\1\uffff"+
			"\5\4\1\uffff\2\4\1\uffff\4\4\2\uffff\1\4\1\uffff\1\4\5\uffff\1\4\1\uffff"+
			"\1\4\1\uffff\3\4\1\uffff\3\4\1\uffff\3\4\1\uffff\4\4\1\uffff\2\4\1\uffff"+
			"\4\4\1\uffff\1\4\1\uffff\5\4\1\uffff\3\4\5\uffff\4\4\3\uffff\1\4\1\uffff"+
			"\4\4\1\uffff\1\4\1\uffff\1\4\1\uffff\4\4\1\uffff\10\4\1\uffff\1\4\1\uffff"+
			"\1\4\1\uffff\13\4\1\uffff\5\4\1\uffff\5\4\1\uffff\6\4\1\uffff\4\4\1\uffff"+
			"\2\4\1\uffff\4\4\1\uffff\1\4\1\uffff\2\4\1\uffff\2\4\1\uffff\1\4\2\uffff"+
			"\2\4\1\uffff\6\4\1\uffff\4\4\4\uffff\1\4\1\uffff\4\4\1\uffff\1\4\1\uffff"+
			"\4\4\2\uffff\12\4\1\uffff\2\4\1\uffff\2\4\2\uffff\1\4\1\uffff\17\4\1"+
			"\uffff\4\4\1\uffff\10\4\1\uffff\5\4\4\uffff\5\4\4\uffff\1\4\1\uffff\3"+
			"\4\2\uffff\7\4\1\uffff\6\4\1\uffff\5\4\1\uffff\11\4\4\uffff\1\4\14\uffff"+
			"\1\4\4\uffff\1\4\45\uffff\1\4\44\uffff\1\4\56\uffff\1\4\3\uffff\1\4\56"+
			"\uffff\1\4\3\uffff\1\4\31\uffff\1\4\6\uffff\1\4\73\uffff\1\4",
			"\1\4\6\uffff\1\122\7\uffff\1\4\1\uffff\6\4\1\uffff\1\4\1\uffff\1\4\3"+
			"\uffff\1\4\1\uffff\2\4\1\uffff\2\4\5\uffff\2\4\1\uffff\2\4\2\uffff\1"+
			"\4\1\uffff\5\4\1\uffff\2\4\1\uffff\4\4\2\uffff\1\4\1\uffff\1\4\5\uffff"+
			"\1\4\1\uffff\1\4\1\uffff\3\4\1\uffff\3\4\1\uffff\3\4\1\uffff\4\4\1\uffff"+
			"\2\4\1\uffff\4\4\1\uffff\1\4\1\uffff\5\4\1\uffff\3\4\5\uffff\4\4\3\uffff"+
			"\1\4\1\uffff\4\4\1\uffff\1\4\1\uffff\1\4\1\uffff\4\4\1\uffff\10\4\1\uffff"+
			"\1\4\1\uffff\1\4\1\uffff\13\4\1\uffff\5\4\1\uffff\5\4\1\uffff\6\4\1\uffff"+
			"\4\4\1\uffff\2\4\1\uffff\4\4\1\uffff\1\4\1\uffff\2\4\1\uffff\2\4\1\uffff"+
			"\1\4\2\uffff\2\4\1\uffff\6\4\1\uffff\4\4\4\uffff\1\4\1\uffff\4\4\1\uffff"+
			"\1\4\1\uffff\4\4\2\uffff\12\4\1\uffff\2\4\1\uffff\2\4\2\uffff\1\4\1\uffff"+
			"\17\4\1\uffff\4\4\1\uffff\10\4\1\uffff\5\4\4\uffff\5\4\4\uffff\1\4\1"+
			"\uffff\3\4\2\uffff\7\4\1\uffff\6\4\1\uffff\5\4\1\uffff\11\4\4\uffff\1"+
			"\4\14\uffff\1\4\4\uffff\1\4\45\uffff\1\4\44\uffff\1\4\56\uffff\1\4\3"+
			"\uffff\1\4\56\uffff\1\4\3\uffff\1\4\31\uffff\1\4\6\uffff\1\4\73\uffff"+
			"\1\4",
			"\1\u00a2\1\uffff\6\u00a2\1\uffff\1\u00a2\1\uffff\1\u00a2\3\uffff\1\u00a2"+
			"\2\uffff\1\u00a2\1\uffff\2\u00a2\5\uffff\2\u00a2\1\uffff\2\u00a2\2\uffff"+
			"\1\u00a2\1\uffff\5\u00a2\1\uffff\2\u00a2\1\uffff\4\u00a2\2\uffff\1\u00a2"+
			"\7\uffff\1\u00a2\1\uffff\1\u00a2\1\uffff\3\u00a2\1\uffff\3\u00a2\1\uffff"+
			"\3\u00a2\1\uffff\4\u00a2\1\uffff\2\u00a2\1\uffff\1\u00a2\1\uffff\2\u00a2"+
			"\1\uffff\1\u00a2\1\uffff\2\u00a2\2\uffff\1\u00a2\1\uffff\3\u00a2\5\uffff"+
			"\4\u00a2\5\uffff\2\u00a2\3\uffff\1\u00a2\4\uffff\2\u00a2\3\uffff\2\u00a2"+
			"\1\uffff\3\u00a2\6\uffff\3\u00a2\1\uffff\5\u00a2\3\uffff\1\u00a2\1\uffff"+
			"\3\u00a2\1\uffff\5\u00a2\1\uffff\1\u00a2\1\uffff\4\u00a2\1\uffff\1\u00a2"+
			"\1\uffff\2\u00a2\1\uffff\2\u00a2\1\uffff\2\u00a2\1\uffff\1\u00a2\1\uffff"+
			"\1\u00a2\1\uffff\1\u00a2\2\uffff\2\u00a2\4\uffff\2\u00a2\1\uffff\2\u00a2"+
			"\1\uffff\3\u00a2\1\uffff\4\u00a2\4\uffff\1\u00a2\1\uffff\4\u00a2\1\uffff"+
			"\1\u00a2\1\uffff\3\u00a2\3\uffff\12\u00a2\1\uffff\1\u00a2\2\uffff\2\u00a2"+
			"\4\uffff\4\u00a2\1\uffff\4\u00a2\1\uffff\5\u00a2\1\uffff\4\u00a2\1\uffff"+
			"\7\u00a2\2\uffff\1\u00a2\1\uffff\3\u00a2\4\uffff\1\u00a2\1\uffff\3\u00a2"+
			"\4\uffff\1\u00a2\1\uffff\1\u00a2\1\uffff\1\u00a2\2\uffff\4\u00a2\1\uffff"+
			"\2\u00a2\2\uffff\3\u00a2\1\uffff\1\u00a2\1\uffff\5\u00a2\2\uffff\1\u00a2"+
			"\2\uffff\5\u00a2\25\uffff\1\4\46\uffff\1\u00a2\44\uffff\1\u00a2\56\uffff"+
			"\1\u00a2\3\uffff\1\u00a2\56\uffff\1\u00a2\3\uffff\1\u00a2\31\uffff\1"+
			"\u00a2\6\uffff\1\u00a2\73\uffff\1\u00a2",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\u00a2\1\uffff\6\u00a2\1\uffff\1\u00a2\1\uffff\1\u00a2\3\uffff\1\u00a2"+
			"\2\uffff\1\u00a2\1\uffff\2\u00a2\5\uffff\2\u00a2\1\uffff\2\u00a2\2\uffff"+
			"\1\u00a2\1\uffff\5\u00a2\1\uffff\2\u00a2\1\uffff\4\u00a2\2\uffff\1\u00a2"+
			"\7\uffff\1\u00a2\1\uffff\1\u00a2\1\uffff\3\u00a2\1\uffff\3\u00a2\1\uffff"+
			"\3\u00a2\1\uffff\4\u00a2\1\uffff\2\u00a2\1\uffff\1\u00a2\1\uffff\2\u00a2"+
			"\1\uffff\1\u00a2\1\uffff\2\u00a2\2\uffff\1\u00a2\1\uffff\3\u00a2\5\uffff"+
			"\4\u00a2\5\uffff\2\u00a2\3\uffff\1\u00a2\4\uffff\2\u00a2\3\uffff\2\u00a2"+
			"\1\uffff\3\u00a2\6\uffff\3\u00a2\1\uffff\5\u00a2\3\uffff\1\u00a2\1\uffff"+
			"\3\u00a2\1\uffff\5\u00a2\1\uffff\1\u00a2\1\uffff\4\u00a2\1\uffff\1\u00a2"+
			"\1\uffff\2\u00a2\1\uffff\2\u00a2\1\uffff\2\u00a2\1\uffff\1\u00a2\1\uffff"+
			"\1\u00a2\1\uffff\1\u00a2\2\uffff\2\u00a2\4\uffff\2\u00a2\1\uffff\2\u00a2"+
			"\1\uffff\3\u00a2\1\uffff\4\u00a2\4\uffff\1\u00a2\1\uffff\4\u00a2\1\uffff"+
			"\1\u00a2\1\uffff\3\u00a2\3\uffff\12\u00a2\1\uffff\1\u00a2\2\uffff\2\u00a2"+
			"\4\uffff\4\u00a2\1\uffff\4\u00a2\1\uffff\5\u00a2\1\uffff\4\u00a2\1\uffff"+
			"\7\u00a2\2\uffff\1\u00a2\1\uffff\3\u00a2\4\uffff\1\u00a2\1\uffff\3\u00a2"+
			"\4\uffff\1\u00a2\1\uffff\1\u00a2\1\uffff\1\u00a2\2\uffff\4\u00a2\1\uffff"+
			"\2\u00a2\2\uffff\3\u00a2\1\uffff\1\u00a2\1\uffff\5\u00a2\2\uffff\1\u00a2"+
			"\2\uffff\5\u00a2\25\uffff\1\4\46\uffff\1\u00a2\44\uffff\1\u00a2\56\uffff"+
			"\1\u00a2\3\uffff\1\u00a2\56\uffff\1\u00a2\3\uffff\1\u00a2\31\uffff\1"+
			"\u00a2\6\uffff\1\u00a2\73\uffff\1\u00a2",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] DFA43_eot = DFA.unpackEncodedString(DFA43_eotS);
	static final short[] DFA43_eof = DFA.unpackEncodedString(DFA43_eofS);
	static final char[] DFA43_min = DFA.unpackEncodedStringToUnsignedChars(DFA43_minS);
	static final char[] DFA43_max = DFA.unpackEncodedStringToUnsignedChars(DFA43_maxS);
	static final short[] DFA43_accept = DFA.unpackEncodedString(DFA43_acceptS);
	static final short[] DFA43_special = DFA.unpackEncodedString(DFA43_specialS);
	static final short[][] DFA43_transition;

	static {
		int numStates = DFA43_transitionS.length;
		DFA43_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA43_transition[i] = DFA.unpackEncodedString(DFA43_transitionS[i]);
		}
	}

	protected class DFA43 extends DFA {

		public DFA43(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 43;
			this.eot = DFA43_eot;
			this.eof = DFA43_eof;
			this.min = DFA43_min;
			this.max = DFA43_max;
			this.accept = DFA43_accept;
			this.special = DFA43_special;
			this.transition = DFA43_transition;
		}
		@Override
		public String getDescription() {
			return "212:1: tableName : (db= identifier DOT tab= identifier -> ^( TOK_TABNAME $db $tab) |tab= identifier -> ^( TOK_TABNAME $tab) );";
		}
	}

	static final String DFA53_eotS =
		"\u00c1\uffff";
	static final String DFA53_eofS =
		"\1\3\1\52\1\112\27\uffff\1\152\1\u008a\1\u00aa\u00a4\uffff";
	static final String DFA53_minS =
		"\3\11\27\uffff\3\11\u00a4\uffff";
	static final String DFA53_maxS =
		"\1\u0289\2\u0176\27\uffff\3\u0176\u00a4\uffff";
	static final String DFA53_acceptS =
		"\3\uffff\1\2\31\uffff\1\1\4\uffff\37\1\1\uffff\37\1\1\uffff\37\1\1\uffff"+
		"\37\1\1\uffff\37\1";
	static final String DFA53_specialS =
		"\1\0\1\1\1\2\27\uffff\1\3\1\4\1\5\u00a4\uffff}>";
	static final String[] DFA53_transitionS = {
			"\1\3\16\uffff\1\1\1\uffff\6\35\1\uffff\1\35\1\uffff\1\35\3\uffff\1\35"+
			"\2\uffff\1\35\1\uffff\2\35\5\uffff\2\35\1\uffff\2\35\2\uffff\1\35\1\uffff"+
			"\1\35\1\2\3\35\1\uffff\2\35\1\uffff\4\35\2\uffff\1\35\1\uffff\1\3\5\uffff"+
			"\1\35\1\uffff\1\35\1\uffff\3\35\1\uffff\3\35\1\uffff\3\35\1\uffff\4\35"+
			"\1\uffff\1\32\1\35\1\uffff\1\35\1\uffff\2\35\1\uffff\1\35\1\uffff\2\35"+
			"\1\3\1\uffff\1\35\1\uffff\3\35\5\uffff\4\35\5\uffff\2\35\1\uffff\1\3"+
			"\1\uffff\1\35\1\uffff\1\3\1\uffff\1\3\2\35\3\uffff\2\35\1\3\3\35\1\3"+
			"\1\uffff\1\3\3\uffff\3\35\1\3\5\35\2\3\1\uffff\1\35\1\uffff\1\34\2\35"+
			"\1\uffff\5\35\1\uffff\1\35\1\3\4\35\1\uffff\1\35\1\3\2\35\1\uffff\2\35"+
			"\1\uffff\2\35\1\uffff\1\35\1\uffff\1\35\1\uffff\1\35\1\3\1\uffff\2\35"+
			"\1\uffff\1\3\2\uffff\2\35\1\uffff\2\35\1\3\3\35\1\uffff\4\35\4\uffff"+
			"\1\35\1\uffff\4\35\1\uffff\1\35\1\uffff\3\35\1\3\2\uffff\12\35\1\uffff"+
			"\1\35\1\3\1\uffff\2\35\4\uffff\4\35\1\3\4\35\1\uffff\5\35\1\uffff\1\35"+
			"\1\33\2\35\1\uffff\7\35\2\uffff\1\35\1\uffff\3\35\4\uffff\1\35\1\uffff"+
			"\3\35\4\uffff\1\35\1\uffff\1\35\1\3\1\35\2\uffff\4\35\1\uffff\2\35\1"+
			"\uffff\1\3\3\35\1\uffff\1\35\1\uffff\5\35\1\uffff\1\3\1\35\1\3\1\uffff"+
			"\5\35\21\uffff\1\3\52\uffff\1\35\44\uffff\1\35\56\uffff\1\35\3\uffff"+
			"\1\35\56\uffff\1\35\3\uffff\1\35\31\uffff\1\35\6\uffff\1\35\73\uffff"+
			"\1\35",
			"\1\43\16\uffff\1\100\44\uffff\1\71\17\uffff\1\46\32\uffff\1\72\13\uffff"+
			"\1\66\27\uffff\1\51\3\uffff\1\60\1\uffff\1\61\7\uffff\1\45\3\uffff\1"+
			"\53\1\uffff\1\65\6\uffff\1\44\5\uffff\1\42\1\47\3\uffff\1\74\12\uffff"+
			"\1\55\6\uffff\1\67\16\uffff\1\75\4\uffff\1\70\7\uffff\1\77\30\uffff\1"+
			"\56\16\uffff\1\50\13\uffff\1\54\14\uffff\1\73\41\uffff\1\64\13\uffff"+
			"\1\76\14\uffff\1\57\1\uffff\1\62\12\uffff\1\3\14\uffff\1\63",
			"\1\103\16\uffff\1\140\34\uffff\1\3\7\uffff\1\131\17\uffff\1\106\32\uffff"+
			"\1\132\13\uffff\1\126\27\uffff\1\111\3\uffff\1\120\1\uffff\1\121\7\uffff"+
			"\1\105\3\uffff\1\113\1\uffff\1\125\6\uffff\1\104\5\uffff\1\102\1\107"+
			"\3\uffff\1\134\12\uffff\1\115\6\uffff\1\127\16\uffff\1\135\4\uffff\1"+
			"\130\7\uffff\1\137\30\uffff\1\116\16\uffff\1\110\13\uffff\1\114\14\uffff"+
			"\1\133\41\uffff\1\124\13\uffff\1\136\14\uffff\1\117\1\uffff\1\122\27"+
			"\uffff\1\123",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\143\16\uffff\1\u0080\34\uffff\1\3\7\uffff\1\171\17\uffff\1\146\32"+
			"\uffff\1\172\13\uffff\1\166\27\uffff\1\151\3\uffff\1\160\1\uffff\1\161"+
			"\7\uffff\1\145\3\uffff\1\153\1\uffff\1\165\6\uffff\1\144\5\uffff\1\142"+
			"\1\147\3\uffff\1\174\12\uffff\1\155\6\uffff\1\167\16\uffff\1\175\4\uffff"+
			"\1\170\7\uffff\1\177\30\uffff\1\156\16\uffff\1\150\13\uffff\1\154\14"+
			"\uffff\1\173\41\uffff\1\164\13\uffff\1\176\14\uffff\1\157\1\uffff\1\162"+
			"\27\uffff\1\163",
			"\1\u0083\16\uffff\1\u00a0\34\uffff\1\3\7\uffff\1\u0099\17\uffff\1\u0086"+
			"\32\uffff\1\u009a\13\uffff\1\u0096\27\uffff\1\u0089\3\uffff\1\u0090\1"+
			"\uffff\1\u0091\7\uffff\1\u0085\3\uffff\1\u008b\1\uffff\1\u0095\6\uffff"+
			"\1\u0084\5\uffff\1\u0082\1\u0087\3\uffff\1\u009c\12\uffff\1\u008d\6\uffff"+
			"\1\u0097\16\uffff\1\u009d\4\uffff\1\u0098\7\uffff\1\u009f\30\uffff\1"+
			"\u008e\16\uffff\1\u0088\13\uffff\1\u008c\14\uffff\1\u009b\41\uffff\1"+
			"\u0094\13\uffff\1\u009e\14\uffff\1\u008f\1\uffff\1\u0092\27\uffff\1\u0093",
			"\1\u00a3\16\uffff\1\u00c0\44\uffff\1\u00b9\17\uffff\1\u00a6\32\uffff"+
			"\1\u00ba\13\uffff\1\u00b6\27\uffff\1\u00a9\3\uffff\1\u00b0\1\uffff\1"+
			"\u00b1\7\uffff\1\u00a5\3\uffff\1\u00ab\1\uffff\1\u00b5\6\uffff\1\u00a4"+
			"\5\uffff\1\u00a2\1\u00a7\3\uffff\1\u00bc\12\uffff\1\u00ad\6\uffff\1\u00b7"+
			"\16\uffff\1\u00bd\4\uffff\1\u00b8\7\uffff\1\u00bf\30\uffff\1\u00ae\16"+
			"\uffff\1\u00a8\13\uffff\1\u00ac\14\uffff\1\u00bb\41\uffff\1\u00b4\13"+
			"\uffff\1\u00be\14\uffff\1\u00af\1\uffff\1\u00b2\20\uffff\1\3\6\uffff"+
			"\1\u00b3",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			""
	};

	static final short[] DFA53_eot = DFA.unpackEncodedString(DFA53_eotS);
	static final short[] DFA53_eof = DFA.unpackEncodedString(DFA53_eofS);
	static final char[] DFA53_min = DFA.unpackEncodedStringToUnsignedChars(DFA53_minS);
	static final char[] DFA53_max = DFA.unpackEncodedStringToUnsignedChars(DFA53_maxS);
	static final short[] DFA53_accept = DFA.unpackEncodedString(DFA53_acceptS);
	static final short[] DFA53_special = DFA.unpackEncodedString(DFA53_specialS);
	static final short[][] DFA53_transition;

	static {
		int numStates = DFA53_transitionS.length;
		DFA53_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA53_transition[i] = DFA.unpackEncodedString(DFA53_transitionS[i]);
		}
	}

	protected class DFA53 extends DFA {

		public DFA53(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 53;
			this.eot = DFA53_eot;
			this.eof = DFA53_eof;
			this.min = DFA53_min;
			this.max = DFA53_max;
			this.accept = DFA53_accept;
			this.special = DFA53_special;
			this.transition = DFA53_transition;
		}
		@Override
		public String getDescription() {
			return "266:27: ( ( Identifier )=>alias= identifier )?";
		}
		@Override
		public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
			TokenStream input = (TokenStream)_input;
			int _s = s;
			switch ( s ) {
					case 0 : 
						int LA53_0 = input.LA(1);
						 
						int index53_0 = input.index();
						input.rewind();
						s = -1;
						if ( (LA53_0==Identifier) ) {s = 1;}
						else if ( (LA53_0==KW_CLUSTER) ) {s = 2;}
						else if ( (LA53_0==EOF||LA53_0==COMMA||LA53_0==KW_CROSS||LA53_0==KW_EXCEPT||LA53_0==KW_FULL||LA53_0==KW_GROUP||LA53_0==KW_HAVING||LA53_0==KW_INNER||LA53_0==KW_INSERT||LA53_0==KW_INTERSECT||LA53_0==KW_JOIN||(LA53_0 >= KW_LATERAL && LA53_0 <= KW_LEFT)||LA53_0==KW_MAP||LA53_0==KW_MINUS||LA53_0==KW_ON||LA53_0==KW_ORDER||LA53_0==KW_PARTITION||LA53_0==KW_REDUCE||LA53_0==KW_RIGHT||LA53_0==KW_SELECT||LA53_0==KW_UNION||LA53_0==KW_USING||LA53_0==KW_WHERE||LA53_0==KW_WINDOW||LA53_0==RPAREN) ) {s = 3;}
						else if ( (LA53_0==KW_DISTRIBUTE) ) {s = 26;}
						else if ( (LA53_0==KW_SORT) ) {s = 27;}
						else if ( (LA53_0==KW_LIMIT) ) {s = 28;}
						else if ( ((LA53_0 >= KW_ABORT && LA53_0 <= KW_AFTER)||LA53_0==KW_ALLOC_FRACTION||LA53_0==KW_ANALYZE||LA53_0==KW_ARCHIVE||LA53_0==KW_ASC||(LA53_0 >= KW_AUTOCOMMIT && LA53_0 <= KW_BEFORE)||(LA53_0 >= KW_BUCKET && LA53_0 <= KW_BUCKETS)||(LA53_0 >= KW_CACHE && LA53_0 <= KW_CASCADE)||LA53_0==KW_CHANGE||LA53_0==KW_CHECK||(LA53_0 >= KW_CLUSTERED && LA53_0 <= KW_COLLECTION)||(LA53_0 >= KW_COLUMNS && LA53_0 <= KW_COMMENT)||(LA53_0 >= KW_COMPACT && LA53_0 <= KW_CONCATENATE)||LA53_0==KW_CONTINUE||LA53_0==KW_DATA||LA53_0==KW_DATABASES||(LA53_0 >= KW_DATETIME && LA53_0 <= KW_DBPROPERTIES)||(LA53_0 >= KW_DEFAULT && LA53_0 <= KW_DEFINED)||(LA53_0 >= KW_DELIMITED && LA53_0 <= KW_DESC)||(LA53_0 >= KW_DETAIL && LA53_0 <= KW_DISABLE)||LA53_0==KW_DO||LA53_0==KW_DOW||(LA53_0 >= KW_DUMP && LA53_0 <= KW_ELEM_TYPE)||LA53_0==KW_ENABLE||(LA53_0 >= KW_ENFORCED && LA53_0 <= KW_ESCAPED)||LA53_0==KW_EXCLUSIVE||(LA53_0 >= KW_EXPLAIN && LA53_0 <= KW_EXPRESSION)||(LA53_0 >= KW_FIELDS && LA53_0 <= KW_FIRST)||(LA53_0 >= KW_FORMAT && LA53_0 <= KW_FORMATTED)||LA53_0==KW_FUNCTIONS||(LA53_0 >= KW_HOUR && LA53_0 <= KW_IDXPROPERTIES)||(LA53_0 >= KW_INDEX && LA53_0 <= KW_INDEXES)||(LA53_0 >= KW_INPATH && LA53_0 <= KW_INPUTFORMAT)||(LA53_0 >= KW_ISOLATION && LA53_0 <= KW_JAR)||(LA53_0 >= KW_KEY && LA53_0 <= KW_LAST)||LA53_0==KW_LEVEL||(LA53_0 >= KW_LINES && LA53_0 <= KW_LOAD)||(LA53_0 >= KW_LOCATION && LA53_0 <= KW_LONG)||LA53_0==KW_MANAGEMENT||(LA53_0 >= KW_MAPJOIN && LA53_0 <= KW_MATERIALIZED)||LA53_0==KW_METADATA||(LA53_0 >= KW_MINUTE && LA53_0 <= KW_MONTH)||(LA53_0 >= KW_MOVE && LA53_0 <= KW_MSCK)||(LA53_0 >= KW_NORELY && LA53_0 <= KW_NOSCAN)||LA53_0==KW_NOVALIDATE||LA53_0==KW_NULLS||LA53_0==KW_OFFSET||(LA53_0 >= KW_OPERATOR && LA53_0 <= KW_OPTION)||(LA53_0 >= KW_OUTPUTDRIVER && LA53_0 <= KW_OUTPUTFORMAT)||(LA53_0 >= KW_OVERWRITE && LA53_0 <= KW_OWNER)||(LA53_0 >= KW_PARTITIONED && LA53_0 <= KW_PATH)||(LA53_0 >= KW_PLAN && LA53_0 <= KW_POOL)||LA53_0==KW_PRINCIPALS||(LA53_0 >= KW_PURGE && LA53_0 <= KW_QUERY_PARALLELISM)||LA53_0==KW_READ||(LA53_0 >= KW_REBUILD && LA53_0 <= KW_RECORDWRITER)||(LA53_0 >= KW_RELOAD && LA53_0 <= KW_RESTRICT)||LA53_0==KW_REWRITE||(LA53_0 >= KW_ROLE && LA53_0 <= KW_ROLES)||(LA53_0 >= KW_SCHEDULING_POLICY && LA53_0 <= KW_SECOND)||(LA53_0 >= KW_SEMI && LA53_0 <= KW_SERVER)||(LA53_0 >= KW_SETS && LA53_0 <= KW_SKEWED)||LA53_0==KW_SNAPSHOT||(LA53_0 >= KW_SORTED && LA53_0 <= KW_SSL)||(LA53_0 >= KW_STATISTICS && LA53_0 <= KW_SUMMARY)||LA53_0==KW_TABLES||(LA53_0 >= KW_TBLPROPERTIES && LA53_0 <= KW_TERMINATED)||LA53_0==KW_TINYINT||(LA53_0 >= KW_TOUCH && LA53_0 <= KW_TRANSACTIONS)||LA53_0==KW_UNARCHIVE||LA53_0==KW_UNDO||LA53_0==KW_UNIONTYPE||(LA53_0 >= KW_UNLOCK && LA53_0 <= KW_UNSIGNED)||(LA53_0 >= KW_URI && LA53_0 <= KW_USE)||(LA53_0 >= KW_UTC && LA53_0 <= KW_VALIDATE)||LA53_0==KW_VALUE_TYPE||(LA53_0 >= KW_VECTORIZATION && LA53_0 <= KW_WEEK)||LA53_0==KW_WHILE||(LA53_0 >= KW_WORK && LA53_0 <= KW_ZONE)||LA53_0==KW_BATCH||LA53_0==KW_DAYOFWEEK||LA53_0==KW_HOLD_DDLTIME||LA53_0==KW_IGNORE||LA53_0==KW_NO_DROP||LA53_0==KW_OFFLINE||LA53_0==KW_PROTECTION||LA53_0==KW_READONLY||LA53_0==KW_TIMESTAMPTZ) && (synpred9_FromClauseParser())) {s = 29;}
						 
						input.seek(index53_0);
						if ( s>=0 ) return s;
						break;

					case 1 : 
						int LA53_1 = input.LA(1);
						 
						int index53_1 = input.index();
						input.rewind();
						s = -1;
						if ( (LA53_1==LPAREN) ) {s = 3;}
						else if ( (LA53_1==KW_LATERAL) && (synpred9_FromClauseParser())) {s = 34;}
						else if ( (LA53_1==COMMA) && (synpred9_FromClauseParser())) {s = 35;}
						else if ( (LA53_1==KW_JOIN) && (synpred9_FromClauseParser())) {s = 36;}
						else if ( (LA53_1==KW_INNER) && (synpred9_FromClauseParser())) {s = 37;}
						else if ( (LA53_1==KW_CROSS) && (synpred9_FromClauseParser())) {s = 38;}
						else if ( (LA53_1==KW_LEFT) && (synpred9_FromClauseParser())) {s = 39;}
						else if ( (LA53_1==KW_RIGHT) && (synpred9_FromClauseParser())) {s = 40;}
						else if ( (LA53_1==KW_FULL) && (synpred9_FromClauseParser())) {s = 41;}
						else if ( (LA53_1==EOF) && (synpred9_FromClauseParser())) {s = 42;}
						else if ( (LA53_1==KW_INSERT) && (synpred9_FromClauseParser())) {s = 43;}
						else if ( (LA53_1==KW_SELECT) && (synpred9_FromClauseParser())) {s = 44;}
						else if ( (LA53_1==KW_MAP) && (synpred9_FromClauseParser())) {s = 45;}
						else if ( (LA53_1==KW_REDUCE) && (synpred9_FromClauseParser())) {s = 46;}
						else if ( (LA53_1==KW_WHERE) && (synpred9_FromClauseParser())) {s = 47;}
						else if ( (LA53_1==KW_GROUP) && (synpred9_FromClauseParser())) {s = 48;}
						else if ( (LA53_1==KW_HAVING) && (synpred9_FromClauseParser())) {s = 49;}
						else if ( (LA53_1==KW_WINDOW) && (synpred9_FromClauseParser())) {s = 50;}
						else if ( (LA53_1==RPAREN) && (synpred9_FromClauseParser())) {s = 51;}
						else if ( (LA53_1==KW_UNION) && (synpred9_FromClauseParser())) {s = 52;}
						else if ( (LA53_1==KW_INTERSECT) && (synpred9_FromClauseParser())) {s = 53;}
						else if ( (LA53_1==KW_EXCEPT) && (synpred9_FromClauseParser())) {s = 54;}
						else if ( (LA53_1==KW_MINUS) && (synpred9_FromClauseParser())) {s = 55;}
						else if ( (LA53_1==KW_ORDER) && (synpred9_FromClauseParser())) {s = 56;}
						else if ( (LA53_1==KW_CLUSTER) && (synpred9_FromClauseParser())) {s = 57;}
						else if ( (LA53_1==KW_DISTRIBUTE) && (synpred9_FromClauseParser())) {s = 58;}
						else if ( (LA53_1==KW_SORT) && (synpred9_FromClauseParser())) {s = 59;}
						else if ( (LA53_1==KW_LIMIT) && (synpred9_FromClauseParser())) {s = 60;}
						else if ( (LA53_1==KW_ON) && (synpred9_FromClauseParser())) {s = 61;}
						else if ( (LA53_1==KW_USING) && (synpred9_FromClauseParser())) {s = 62;}
						else if ( (LA53_1==KW_PARTITION) && (synpred9_FromClauseParser())) {s = 63;}
						else if ( (LA53_1==Identifier) && (synpred9_FromClauseParser())) {s = 64;}
						 
						input.seek(index53_1);
						if ( s>=0 ) return s;
						break;

					case 2 : 
						int LA53_2 = input.LA(1);
						 
						int index53_2 = input.index();
						input.rewind();
						s = -1;
						if ( (LA53_2==KW_BY) ) {s = 3;}
						else if ( (LA53_2==KW_LATERAL) && (synpred9_FromClauseParser())) {s = 66;}
						else if ( (LA53_2==COMMA) && (synpred9_FromClauseParser())) {s = 67;}
						else if ( (LA53_2==KW_JOIN) && (synpred9_FromClauseParser())) {s = 68;}
						else if ( (LA53_2==KW_INNER) && (synpred9_FromClauseParser())) {s = 69;}
						else if ( (LA53_2==KW_CROSS) && (synpred9_FromClauseParser())) {s = 70;}
						else if ( (LA53_2==KW_LEFT) && (synpred9_FromClauseParser())) {s = 71;}
						else if ( (LA53_2==KW_RIGHT) && (synpred9_FromClauseParser())) {s = 72;}
						else if ( (LA53_2==KW_FULL) && (synpred9_FromClauseParser())) {s = 73;}
						else if ( (LA53_2==EOF) && (synpred9_FromClauseParser())) {s = 74;}
						else if ( (LA53_2==KW_INSERT) && (synpred9_FromClauseParser())) {s = 75;}
						else if ( (LA53_2==KW_SELECT) && (synpred9_FromClauseParser())) {s = 76;}
						else if ( (LA53_2==KW_MAP) && (synpred9_FromClauseParser())) {s = 77;}
						else if ( (LA53_2==KW_REDUCE) && (synpred9_FromClauseParser())) {s = 78;}
						else if ( (LA53_2==KW_WHERE) && (synpred9_FromClauseParser())) {s = 79;}
						else if ( (LA53_2==KW_GROUP) && (synpred9_FromClauseParser())) {s = 80;}
						else if ( (LA53_2==KW_HAVING) && (synpred9_FromClauseParser())) {s = 81;}
						else if ( (LA53_2==KW_WINDOW) && (synpred9_FromClauseParser())) {s = 82;}
						else if ( (LA53_2==RPAREN) && (synpred9_FromClauseParser())) {s = 83;}
						else if ( (LA53_2==KW_UNION) && (synpred9_FromClauseParser())) {s = 84;}
						else if ( (LA53_2==KW_INTERSECT) && (synpred9_FromClauseParser())) {s = 85;}
						else if ( (LA53_2==KW_EXCEPT) && (synpred9_FromClauseParser())) {s = 86;}
						else if ( (LA53_2==KW_MINUS) && (synpred9_FromClauseParser())) {s = 87;}
						else if ( (LA53_2==KW_ORDER) && (synpred9_FromClauseParser())) {s = 88;}
						else if ( (LA53_2==KW_CLUSTER) && (synpred9_FromClauseParser())) {s = 89;}
						else if ( (LA53_2==KW_DISTRIBUTE) && (synpred9_FromClauseParser())) {s = 90;}
						else if ( (LA53_2==KW_SORT) && (synpred9_FromClauseParser())) {s = 91;}
						else if ( (LA53_2==KW_LIMIT) && (synpred9_FromClauseParser())) {s = 92;}
						else if ( (LA53_2==KW_ON) && (synpred9_FromClauseParser())) {s = 93;}
						else if ( (LA53_2==KW_USING) && (synpred9_FromClauseParser())) {s = 94;}
						else if ( (LA53_2==KW_PARTITION) && (synpred9_FromClauseParser())) {s = 95;}
						else if ( (LA53_2==Identifier) && (synpred9_FromClauseParser())) {s = 96;}
						 
						input.seek(index53_2);
						if ( s>=0 ) return s;
						break;

					case 3 : 
						int LA53_26 = input.LA(1);
						 
						int index53_26 = input.index();
						input.rewind();
						s = -1;
						if ( (LA53_26==KW_BY) ) {s = 3;}
						else if ( (LA53_26==KW_LATERAL) && (synpred9_FromClauseParser())) {s = 98;}
						else if ( (LA53_26==COMMA) && (synpred9_FromClauseParser())) {s = 99;}
						else if ( (LA53_26==KW_JOIN) && (synpred9_FromClauseParser())) {s = 100;}
						else if ( (LA53_26==KW_INNER) && (synpred9_FromClauseParser())) {s = 101;}
						else if ( (LA53_26==KW_CROSS) && (synpred9_FromClauseParser())) {s = 102;}
						else if ( (LA53_26==KW_LEFT) && (synpred9_FromClauseParser())) {s = 103;}
						else if ( (LA53_26==KW_RIGHT) && (synpred9_FromClauseParser())) {s = 104;}
						else if ( (LA53_26==KW_FULL) && (synpred9_FromClauseParser())) {s = 105;}
						else if ( (LA53_26==EOF) && (synpred9_FromClauseParser())) {s = 106;}
						else if ( (LA53_26==KW_INSERT) && (synpred9_FromClauseParser())) {s = 107;}
						else if ( (LA53_26==KW_SELECT) && (synpred9_FromClauseParser())) {s = 108;}
						else if ( (LA53_26==KW_MAP) && (synpred9_FromClauseParser())) {s = 109;}
						else if ( (LA53_26==KW_REDUCE) && (synpred9_FromClauseParser())) {s = 110;}
						else if ( (LA53_26==KW_WHERE) && (synpred9_FromClauseParser())) {s = 111;}
						else if ( (LA53_26==KW_GROUP) && (synpred9_FromClauseParser())) {s = 112;}
						else if ( (LA53_26==KW_HAVING) && (synpred9_FromClauseParser())) {s = 113;}
						else if ( (LA53_26==KW_WINDOW) && (synpred9_FromClauseParser())) {s = 114;}
						else if ( (LA53_26==RPAREN) && (synpred9_FromClauseParser())) {s = 115;}
						else if ( (LA53_26==KW_UNION) && (synpred9_FromClauseParser())) {s = 116;}
						else if ( (LA53_26==KW_INTERSECT) && (synpred9_FromClauseParser())) {s = 117;}
						else if ( (LA53_26==KW_EXCEPT) && (synpred9_FromClauseParser())) {s = 118;}
						else if ( (LA53_26==KW_MINUS) && (synpred9_FromClauseParser())) {s = 119;}
						else if ( (LA53_26==KW_ORDER) && (synpred9_FromClauseParser())) {s = 120;}
						else if ( (LA53_26==KW_CLUSTER) && (synpred9_FromClauseParser())) {s = 121;}
						else if ( (LA53_26==KW_DISTRIBUTE) && (synpred9_FromClauseParser())) {s = 122;}
						else if ( (LA53_26==KW_SORT) && (synpred9_FromClauseParser())) {s = 123;}
						else if ( (LA53_26==KW_LIMIT) && (synpred9_FromClauseParser())) {s = 124;}
						else if ( (LA53_26==KW_ON) && (synpred9_FromClauseParser())) {s = 125;}
						else if ( (LA53_26==KW_USING) && (synpred9_FromClauseParser())) {s = 126;}
						else if ( (LA53_26==KW_PARTITION) && (synpred9_FromClauseParser())) {s = 127;}
						else if ( (LA53_26==Identifier) && (synpred9_FromClauseParser())) {s = 128;}
						 
						input.seek(index53_26);
						if ( s>=0 ) return s;
						break;

					case 4 : 
						int LA53_27 = input.LA(1);
						 
						int index53_27 = input.index();
						input.rewind();
						s = -1;
						if ( (LA53_27==KW_BY) ) {s = 3;}
						else if ( (LA53_27==KW_LATERAL) && (synpred9_FromClauseParser())) {s = 130;}
						else if ( (LA53_27==COMMA) && (synpred9_FromClauseParser())) {s = 131;}
						else if ( (LA53_27==KW_JOIN) && (synpred9_FromClauseParser())) {s = 132;}
						else if ( (LA53_27==KW_INNER) && (synpred9_FromClauseParser())) {s = 133;}
						else if ( (LA53_27==KW_CROSS) && (synpred9_FromClauseParser())) {s = 134;}
						else if ( (LA53_27==KW_LEFT) && (synpred9_FromClauseParser())) {s = 135;}
						else if ( (LA53_27==KW_RIGHT) && (synpred9_FromClauseParser())) {s = 136;}
						else if ( (LA53_27==KW_FULL) && (synpred9_FromClauseParser())) {s = 137;}
						else if ( (LA53_27==EOF) && (synpred9_FromClauseParser())) {s = 138;}
						else if ( (LA53_27==KW_INSERT) && (synpred9_FromClauseParser())) {s = 139;}
						else if ( (LA53_27==KW_SELECT) && (synpred9_FromClauseParser())) {s = 140;}
						else if ( (LA53_27==KW_MAP) && (synpred9_FromClauseParser())) {s = 141;}
						else if ( (LA53_27==KW_REDUCE) && (synpred9_FromClauseParser())) {s = 142;}
						else if ( (LA53_27==KW_WHERE) && (synpred9_FromClauseParser())) {s = 143;}
						else if ( (LA53_27==KW_GROUP) && (synpred9_FromClauseParser())) {s = 144;}
						else if ( (LA53_27==KW_HAVING) && (synpred9_FromClauseParser())) {s = 145;}
						else if ( (LA53_27==KW_WINDOW) && (synpred9_FromClauseParser())) {s = 146;}
						else if ( (LA53_27==RPAREN) && (synpred9_FromClauseParser())) {s = 147;}
						else if ( (LA53_27==KW_UNION) && (synpred9_FromClauseParser())) {s = 148;}
						else if ( (LA53_27==KW_INTERSECT) && (synpred9_FromClauseParser())) {s = 149;}
						else if ( (LA53_27==KW_EXCEPT) && (synpred9_FromClauseParser())) {s = 150;}
						else if ( (LA53_27==KW_MINUS) && (synpred9_FromClauseParser())) {s = 151;}
						else if ( (LA53_27==KW_ORDER) && (synpred9_FromClauseParser())) {s = 152;}
						else if ( (LA53_27==KW_CLUSTER) && (synpred9_FromClauseParser())) {s = 153;}
						else if ( (LA53_27==KW_DISTRIBUTE) && (synpred9_FromClauseParser())) {s = 154;}
						else if ( (LA53_27==KW_SORT) && (synpred9_FromClauseParser())) {s = 155;}
						else if ( (LA53_27==KW_LIMIT) && (synpred9_FromClauseParser())) {s = 156;}
						else if ( (LA53_27==KW_ON) && (synpred9_FromClauseParser())) {s = 157;}
						else if ( (LA53_27==KW_USING) && (synpred9_FromClauseParser())) {s = 158;}
						else if ( (LA53_27==KW_PARTITION) && (synpred9_FromClauseParser())) {s = 159;}
						else if ( (LA53_27==Identifier) && (synpred9_FromClauseParser())) {s = 160;}
						 
						input.seek(index53_27);
						if ( s>=0 ) return s;
						break;

					case 5 : 
						int LA53_28 = input.LA(1);
						 
						int index53_28 = input.index();
						input.rewind();
						s = -1;
						if ( (LA53_28==Number) ) {s = 3;}
						else if ( (LA53_28==KW_LATERAL) && (synpred9_FromClauseParser())) {s = 162;}
						else if ( (LA53_28==COMMA) && (synpred9_FromClauseParser())) {s = 163;}
						else if ( (LA53_28==KW_JOIN) && (synpred9_FromClauseParser())) {s = 164;}
						else if ( (LA53_28==KW_INNER) && (synpred9_FromClauseParser())) {s = 165;}
						else if ( (LA53_28==KW_CROSS) && (synpred9_FromClauseParser())) {s = 166;}
						else if ( (LA53_28==KW_LEFT) && (synpred9_FromClauseParser())) {s = 167;}
						else if ( (LA53_28==KW_RIGHT) && (synpred9_FromClauseParser())) {s = 168;}
						else if ( (LA53_28==KW_FULL) && (synpred9_FromClauseParser())) {s = 169;}
						else if ( (LA53_28==EOF) && (synpred9_FromClauseParser())) {s = 170;}
						else if ( (LA53_28==KW_INSERT) && (synpred9_FromClauseParser())) {s = 171;}
						else if ( (LA53_28==KW_SELECT) && (synpred9_FromClauseParser())) {s = 172;}
						else if ( (LA53_28==KW_MAP) && (synpred9_FromClauseParser())) {s = 173;}
						else if ( (LA53_28==KW_REDUCE) && (synpred9_FromClauseParser())) {s = 174;}
						else if ( (LA53_28==KW_WHERE) && (synpred9_FromClauseParser())) {s = 175;}
						else if ( (LA53_28==KW_GROUP) && (synpred9_FromClauseParser())) {s = 176;}
						else if ( (LA53_28==KW_HAVING) && (synpred9_FromClauseParser())) {s = 177;}
						else if ( (LA53_28==KW_WINDOW) && (synpred9_FromClauseParser())) {s = 178;}
						else if ( (LA53_28==RPAREN) && (synpred9_FromClauseParser())) {s = 179;}
						else if ( (LA53_28==KW_UNION) && (synpred9_FromClauseParser())) {s = 180;}
						else if ( (LA53_28==KW_INTERSECT) && (synpred9_FromClauseParser())) {s = 181;}
						else if ( (LA53_28==KW_EXCEPT) && (synpred9_FromClauseParser())) {s = 182;}
						else if ( (LA53_28==KW_MINUS) && (synpred9_FromClauseParser())) {s = 183;}
						else if ( (LA53_28==KW_ORDER) && (synpred9_FromClauseParser())) {s = 184;}
						else if ( (LA53_28==KW_CLUSTER) && (synpred9_FromClauseParser())) {s = 185;}
						else if ( (LA53_28==KW_DISTRIBUTE) && (synpred9_FromClauseParser())) {s = 186;}
						else if ( (LA53_28==KW_SORT) && (synpred9_FromClauseParser())) {s = 187;}
						else if ( (LA53_28==KW_LIMIT) && (synpred9_FromClauseParser())) {s = 188;}
						else if ( (LA53_28==KW_ON) && (synpred9_FromClauseParser())) {s = 189;}
						else if ( (LA53_28==KW_USING) && (synpred9_FromClauseParser())) {s = 190;}
						else if ( (LA53_28==KW_PARTITION) && (synpred9_FromClauseParser())) {s = 191;}
						else if ( (LA53_28==Identifier) && (synpred9_FromClauseParser())) {s = 192;}
						 
						input.seek(index53_28);
						if ( s>=0 ) return s;
						break;
			}
			if (state.backtracking>0) {state.failed=true; return -1;}
			NoViableAltException nvae =
				new NoViableAltException(getDescription(), 53, _s, input);
			error(nvae);
			throw nvae;
		}
	}

	public static final BitSet FOLLOW_STAR_in_tableAllColumns57 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tableName_in_tableAllColumns79 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_DOT_in_tableAllColumns81 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0400000000000000L});
	public static final BitSet FOLLOW_STAR_in_tableAllColumns83 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_tableOrColumn131 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_expressionList170 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_COMMA_in_expressionList173 = new BitSet(new long[]{0xF7DBB58AFF001000L,0x67CD6F7BBBEB09EDL,0xF7DD1F72BB3A463FL,0xF1D7A1EED865FB6BL,0x4EE74FEFFDEF0CBFL,0x1803921F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_expression_in_expressionList175 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_identifier_in_aliasList217 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_COMMA_in_aliasList220 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_aliasList222 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_KW_FROM_in_fromClause266 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E876FEF7DEF0CBFL,0x0000021F27D737D5L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_fromSource_in_fromClause268 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_uniqueJoinToken_in_fromSource307 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A9EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_uniqueJoinSource_in_fromSource310 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_COMMA_in_fromSource313 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A9EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_uniqueJoinSource_in_fromSource316 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_joinSource_in_fromSource330 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tableSource_in_atomjoinSource359 = new BitSet(new long[]{0x0000000000000202L,0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_lateralView_in_atomjoinSource362 = new BitSet(new long[]{0x0000000000000202L,0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_virtualTableSource_in_atomjoinSource374 = new BitSet(new long[]{0x0000000000000202L,0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_lateralView_in_atomjoinSource377 = new BitSet(new long[]{0x0000000000000202L,0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_subQuerySource_in_atomjoinSource407 = new BitSet(new long[]{0x0000000000000202L,0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_lateralView_in_atomjoinSource410 = new BitSet(new long[]{0x0000000000000202L,0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_subQuerySource_in_atomjoinSource437 = new BitSet(new long[]{0x0000000000000202L,0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_lateralView_in_atomjoinSource440 = new BitSet(new long[]{0x0000000000000202L,0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_partitionedTableFunction_in_atomjoinSource452 = new BitSet(new long[]{0x0000000000000202L,0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_lateralView_in_atomjoinSource455 = new BitSet(new long[]{0x0000000000000202L,0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_LPAREN_in_atomjoinSource467 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E876FEF7DEF0CBFL,0x0000021F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_joinSource_in_atomjoinSource470 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_atomjoinSource472 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atomjoinSource_in_joinSource494 = new BitSet(new long[]{0x0000000000000202L,0x0000000000002000L,0x0000408004001000L,0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_joinToken_in_joinSource497 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E876FEF7DEF0CBFL,0x0000021F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_joinSourcePart_in_joinSource500 = new BitSet(new long[]{0x0000000000000202L,0x0000000000002000L,0x0000408004001000L,0x0000000000080000L,0x0000000000000100L,0x0000000000008000L});
	public static final BitSet FOLLOW_KW_ON_in_joinSource503 = new BitSet(new long[]{0xF7DBB58AFF001000L,0x67CD6F7BBBEB09EDL,0xF7DD1F72BB3A463FL,0xF1D7A1EED865FB6BL,0x4EE74FEFFDEF0CBFL,0x1803921F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_expression_in_joinSource506 = new BitSet(new long[]{0x0000000000000202L,0x0000000000002000L,0x0000408004001000L,0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_KW_USING_in_joinSource512 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_columnParenthesesList_in_joinSource515 = new BitSet(new long[]{0x0000000000000202L,0x0000000000002000L,0x0000408004001000L,0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_tableSource_in_joinSourcePart553 = new BitSet(new long[]{0x0000000000000202L,0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_virtualTableSource_in_joinSourcePart557 = new BitSet(new long[]{0x0000000000000202L,0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_subQuerySource_in_joinSourcePart561 = new BitSet(new long[]{0x0000000000000202L,0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_partitionedTableFunction_in_joinSourcePart565 = new BitSet(new long[]{0x0000000000000202L,0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_lateralView_in_joinSourcePart569 = new BitSet(new long[]{0x0000000000000202L,0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_KW_PRESERVE_in_uniqueJoinSource599 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_uniqueJoinTableSource_in_uniqueJoinSource602 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_uniqueJoinExpr_in_uniqueJoinSource604 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_uniqueJoinExpr631 = new BitSet(new long[]{0xF7DBB58AFF001000L,0x67CD6F7BBBEB09EDL,0xF7DD1F72BB3A463FL,0xF1D7A1EED865FB6BL,0x4EE74FEFFDEF0CBFL,0x1803921F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_expressionList_in_uniqueJoinExpr634 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_uniqueJoinExpr636 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_UNIQUEJOIN_in_uniqueJoinToken664 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_JOIN_in_joinToken696 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_INNER_in_joinToken729 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_KW_JOIN_in_joinToken731 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_joinToken755 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_CROSS_in_joinToken790 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_KW_JOIN_in_joinToken792 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_LEFT_in_joinToken816 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_KW_OUTER_in_joinToken820 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_KW_JOIN_in_joinToken824 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_RIGHT_in_joinToken836 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_KW_OUTER_in_joinToken839 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_KW_JOIN_in_joinToken843 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_FULL_in_joinToken855 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_KW_OUTER_in_joinToken859 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_KW_JOIN_in_joinToken863 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_LEFT_in_joinToken875 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_KW_SEMI_in_joinToken877 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_KW_JOIN_in_joinToken879 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_LATERAL_in_lateralView926 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_KW_VIEW_in_lateralView928 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_KW_OUTER_in_lateralView930 = new BitSet(new long[]{0xF4DBB58AFD000000L,0x074D6F7BBBEB09EDL,0xF7DD1F70BB3A461FL,0xF1D7A1EED8655B6BL,0x0EA74FEFFDEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_function_in_lateralView932 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_tableAlias_in_lateralView934 = new BitSet(new long[]{0x0000020000000002L});
	public static final BitSet FOLLOW_KW_AS_in_lateralView937 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_lateralView939 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_COMMA_in_lateralView947 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_lateralView949 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_COMMA_in_lateralView981 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_KW_LATERAL_in_lateralView984 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_KW_VIEW_in_lateralView986 = new BitSet(new long[]{0xF4DBB58AFD000000L,0x074D6F7BBBEB09EDL,0xF7DD1F70BB3A461FL,0xF1D7A1EED8655B6BL,0x0EA74FEFFDEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_function_in_lateralView988 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_tableAlias_in_lateralView990 = new BitSet(new long[]{0x0000020000000002L});
	public static final BitSet FOLLOW_KW_AS_in_lateralView993 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_lateralView995 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_COMMA_in_lateralView1003 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_lateralView1005 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_COMMA_in_lateralView1043 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_KW_LATERAL_in_lateralView1046 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_KW_TABLE_in_lateralView1048 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_LPAREN_in_lateralView1050 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_valuesClause_in_lateralView1052 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_lateralView1054 = new BitSet(new long[]{0xF4D8368AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_KW_AS_in_lateralView1056 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_tableAlias_in_lateralView1059 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_LPAREN_in_lateralView1062 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_lateralView1064 = new BitSet(new long[]{0x0000000000000200L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_COMMA_in_lateralView1067 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_lateralView1069 = new BitSet(new long[]{0x0000000000000200L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_lateralView1073 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_tableAlias1135 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_TABLESAMPLE_in_tableBucketSample1174 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_LPAREN_in_tableBucketSample1176 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_KW_BUCKET_in_tableBucketSample1178 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_Number_in_tableBucketSample1183 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_KW_OUT_in_tableBucketSample1186 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000020000L});
	public static final BitSet FOLLOW_KW_OF_in_tableBucketSample1188 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_Number_in_tableBucketSample1193 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000080000L,0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_KW_ON_in_tableBucketSample1197 = new BitSet(new long[]{0xF7DBB58AFF001000L,0x67CD6F7BBBEB09EDL,0xF7DD1F72BB3A463FL,0xF1D7A1EED865FB6BL,0x4EE74FEFFDEF0CBFL,0x1803921F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_expression_in_tableBucketSample1201 = new BitSet(new long[]{0x0000000000000200L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_COMMA_in_tableBucketSample1204 = new BitSet(new long[]{0xF7DBB58AFF001000L,0x67CD6F7BBBEB09EDL,0xF7DD1F72BB3A463FL,0xF1D7A1EED865FB6BL,0x4EE74FEFFDEF0CBFL,0x1803921F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_expression_in_tableBucketSample1208 = new BitSet(new long[]{0x0000000000000200L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_tableBucketSample1214 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_TABLESAMPLE_in_splitSample1261 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_LPAREN_in_splitSample1263 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_Number_in_splitSample1269 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000001000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_KW_PERCENT_in_splitSample1275 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_KW_ROWS_in_splitSample1277 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_splitSample1280 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_TABLESAMPLE_in_splitSample1324 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_LPAREN_in_splitSample1326 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_ByteLengthLiteral_in_splitSample1332 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_splitSample1335 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tableBucketSample_in_tableSample1381 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_splitSample_in_tableSample1389 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tableName_in_tableSource1418 = new BitSet(new long[]{0xF4D8368AFD000002L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E87CFEF7DEF0CBFL,0x0000021F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_tableProperties_in_tableSource1422 = new BitSet(new long[]{0xF4D8368AFD000002L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E87CFEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_tableSample_in_tableSource1427 = new BitSet(new long[]{0xF4D8368AFD000002L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_KW_AS_in_tableSource1431 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_tableSource1436 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tableName_in_uniqueJoinTableSource1492 = new BitSet(new long[]{0xF4D8368AFD000002L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E87CFEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_tableSample_in_uniqueJoinTableSource1496 = new BitSet(new long[]{0xF4D8368AFD000002L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_KW_AS_in_uniqueJoinTableSource1500 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_uniqueJoinTableSource1505 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_tableName1561 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_DOT_in_tableName1563 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_tableName1567 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_tableName1597 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_viewName1644 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_DOT_in_viewName1646 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_viewName1652 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_subQuerySource1700 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000040000800L,0x0200000000000000L,0x0000000000100000L,0x0000020080000000L});
	public static final BitSet FOLLOW_queryStatementExpression_in_subQuerySource1702 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_subQuerySource1704 = new BitSet(new long[]{0xF4D8368AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_KW_AS_in_subQuerySource1706 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_subQuerySource1709 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_partitionByClause_in_partitioningSpec1750 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_orderByClause_in_partitioningSpec1752 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_orderByClause_in_partitioningSpec1771 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_distributeByClause_in_partitioningSpec1786 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_sortByClause_in_partitioningSpec1788 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sortByClause_in_partitioningSpec1807 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_clusterByClause_in_partitioningSpec1822 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_subQuerySource_in_partitionTableFunctionSource1859 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tableSource_in_partitionTableFunctionSource1866 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_partitionedTableFunction_in_partitionTableFunctionSource1873 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_partitionedTableFunction1904 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_LPAREN_in_partitionedTableFunction1906 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_KW_ON_in_partitionedTableFunction1908 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000021F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_partitionTableFunctionSource_in_partitionedTableFunction1923 = new BitSet(new long[]{0x2000000001000000L,0x0000010000000000L,0x0000000000000000L,0x0000000101000000L,0x0000000200000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_partitioningSpec_in_partitionedTableFunction1927 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_Identifier_in_partitionedTableFunction1949 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_LPAREN_in_partitionedTableFunction1951 = new BitSet(new long[]{0xF7DBB58AFF001000L,0x67CD6F7BBBEB09EDL,0xF7DD1F72BB3A463FL,0xF1D7A1EED865FB6BL,0x4EE74FEFFDEF0CBFL,0x1803921F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_expression_in_partitionedTableFunction1953 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_partitionedTableFunction1955 = new BitSet(new long[]{0x0000000000000200L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_COMMA_in_partitionedTableFunction1959 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_Identifier_in_partitionedTableFunction1961 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_LPAREN_in_partitionedTableFunction1963 = new BitSet(new long[]{0xF7DBB58AFF001000L,0x67CD6F7BBBEB09EDL,0xF7DD1F72BB3A463FL,0xF1D7A1EED865FB6BL,0x4EE74FEFFDEF0CBFL,0x1803921F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_expression_in_partitionedTableFunction1965 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_partitionedTableFunction1967 = new BitSet(new long[]{0x0000000000000200L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_partitionedTableFunction1984 = new BitSet(new long[]{0xF4D8348AFD000002L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_partitionedTableFunction1997 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_WHERE_in_whereClause2060 = new BitSet(new long[]{0xF7DBB58AFF001000L,0x67CD6F7BBBEB09EDL,0xF7DD1F72BB3A463FL,0xF1D7A1EED865FB6BL,0x4EE74FEFFDEF0CBFL,0x1803921F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_searchCondition_in_whereClause2062 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_searchCondition2101 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_VALUES_in_valuesClause2140 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_valuesTableConstructor_in_valuesClause2142 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_valueRowConstructor_in_valuesTableConstructor2184 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_COMMA_in_valuesTableConstructor2187 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_valueRowConstructor_in_valuesTableConstructor2190 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_expressionsInParenthesis_in_valueRowConstructor2223 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_TABLE_in_virtualTableSource2257 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_LPAREN_in_virtualTableSource2259 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_valuesClause_in_virtualTableSource2261 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_virtualTableSource2263 = new BitSet(new long[]{0xF4D8368AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_KW_AS_in_virtualTableSource2265 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_tableAlias_in_virtualTableSource2270 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040020000000000L});
	public static final BitSet FOLLOW_LPAREN_in_virtualTableSource2273 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_virtualTableSource2275 = new BitSet(new long[]{0x0000000000000200L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_COMMA_in_virtualTableSource2278 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_virtualTableSource2280 = new BitSet(new long[]{0x0000000000000200L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_virtualTableSource2286 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_synpred1_FromClauseParser390 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000800L,0x0200000000000000L,0x0000000000100000L,0x0000000080000000L});
	public static final BitSet FOLLOW_set_in_synpred1_FromClauseParser392 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_synpred2_FromClauseParser423 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_LPAREN_in_synpred2_FromClauseParser425 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x2000000000000000L,0x0200000000000000L,0x0000000000100000L,0x0000020000000000L});
	public static final BitSet FOLLOW_atomSelectStatement_in_synpred2_FromClauseParser427 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_synpred2_FromClauseParser429 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L,0x0000000100000000L,0x0000000000000010L,0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_setOperator_in_synpred2_FromClauseParser431 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_synpred3_FromClauseParser914 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_KW_LATERAL_in_synpred3_FromClauseParser917 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_KW_VIEW_in_synpred3_FromClauseParser919 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_KW_OUTER_in_synpred3_FromClauseParser921 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_synpred4_FromClauseParser943 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COMMA_in_synpred5_FromClauseParser999 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_synpred7_FromClauseParser1937 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_LPAREN_in_synpred7_FromClauseParser1939 = new BitSet(new long[]{0xF7DBB58AFF001000L,0x67CD6F7BBBEB09EDL,0xF7DD1F72BB3A463FL,0xF1D7A1EED865FB6BL,0x4EE74FEFFDEF0CBFL,0x1803921F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_expression_in_synpred7_FromClauseParser1941 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_synpred7_FromClauseParser1943 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Identifier_in_synpred9_FromClauseParser1990 = new BitSet(new long[]{0x0000000000000002L});
}
