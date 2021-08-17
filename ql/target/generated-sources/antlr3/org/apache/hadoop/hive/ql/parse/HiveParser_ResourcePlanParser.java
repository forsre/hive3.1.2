// $ANTLR 3.5.2 ResourcePlanParser.g 2021-08-17 21:23:01

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
public class HiveParser_ResourcePlanParser extends Parser {
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


	public HiveParser_ResourcePlanParser(TokenStream input, HiveParser gHiveParser) {
		this(input, new RecognizerSharedState(), gHiveParser);
	}
	public HiveParser_ResourcePlanParser(TokenStream input, RecognizerSharedState state, HiveParser gHiveParser) {
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
	@Override public String getGrammarFileName() { return "ResourcePlanParser.g"; }


	  @Override
	  public Object recoverFromMismatchedSet(IntStream input,
	      RecognitionException re, BitSet follow) throws RecognitionException {
	    return gParent.recoverFromMismatchedSet(input, re, follow);
	  }

	  @Override
	  public void displayRecognitionError(String[] tokenNames,
	      RecognitionException e) {
	    gParent.displayRecognitionError(tokenNames, e);
	  }


	public static class resourcePlanDdlStatements_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "resourcePlanDdlStatements"
	// ResourcePlanParser.g:46:1: resourcePlanDdlStatements : ( createResourcePlanStatement | alterResourcePlanStatement | dropResourcePlanStatement | globalWmStatement | replaceResourcePlanStatement | createTriggerStatement | alterTriggerStatement | dropTriggerStatement | createPoolStatement | alterPoolStatement | dropPoolStatement | createMappingStatement | alterMappingStatement | dropMappingStatement );
	public final HiveParser_ResourcePlanParser.resourcePlanDdlStatements_return resourcePlanDdlStatements() throws RecognitionException {
		HiveParser_ResourcePlanParser.resourcePlanDdlStatements_return retval = new HiveParser_ResourcePlanParser.resourcePlanDdlStatements_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		ParserRuleReturnScope createResourcePlanStatement1 =null;
		ParserRuleReturnScope alterResourcePlanStatement2 =null;
		ParserRuleReturnScope dropResourcePlanStatement3 =null;
		ParserRuleReturnScope globalWmStatement4 =null;
		ParserRuleReturnScope replaceResourcePlanStatement5 =null;
		ParserRuleReturnScope createTriggerStatement6 =null;
		ParserRuleReturnScope alterTriggerStatement7 =null;
		ParserRuleReturnScope dropTriggerStatement8 =null;
		ParserRuleReturnScope createPoolStatement9 =null;
		ParserRuleReturnScope alterPoolStatement10 =null;
		ParserRuleReturnScope dropPoolStatement11 =null;
		ParserRuleReturnScope createMappingStatement12 =null;
		ParserRuleReturnScope alterMappingStatement13 =null;
		ParserRuleReturnScope dropMappingStatement14 =null;


		try {
			// ResourcePlanParser.g:47:5: ( createResourcePlanStatement | alterResourcePlanStatement | dropResourcePlanStatement | globalWmStatement | replaceResourcePlanStatement | createTriggerStatement | alterTriggerStatement | dropTriggerStatement | createPoolStatement | alterPoolStatement | dropPoolStatement | createMappingStatement | alterMappingStatement | dropMappingStatement )
			int alt1=14;
			switch ( input.LA(1) ) {
			case KW_CREATE:
				{
				switch ( input.LA(2) ) {
				case KW_RESOURCE:
					{
					alt1=1;
					}
					break;
				case KW_TRIGGER:
					{
					alt1=6;
					}
					break;
				case KW_POOL:
					{
					alt1=9;
					}
					break;
				case KW_APPLICATION:
				case KW_GROUP:
				case KW_USER:
					{
					alt1=12;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case KW_ALTER:
				{
				switch ( input.LA(2) ) {
				case KW_RESOURCE:
					{
					alt1=2;
					}
					break;
				case KW_TRIGGER:
					{
					alt1=7;
					}
					break;
				case KW_POOL:
					{
					alt1=10;
					}
					break;
				case KW_APPLICATION:
				case KW_GROUP:
				case KW_USER:
					{
					alt1=13;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case KW_DROP:
				{
				switch ( input.LA(2) ) {
				case KW_RESOURCE:
					{
					alt1=3;
					}
					break;
				case KW_TRIGGER:
					{
					alt1=8;
					}
					break;
				case KW_POOL:
					{
					alt1=11;
					}
					break;
				case KW_APPLICATION:
				case KW_GROUP:
				case KW_USER:
					{
					alt1=14;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 1, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case KW_DISABLE:
			case KW_ENABLE:
				{
				alt1=4;
				}
				break;
			case KW_REPLACE:
				{
				alt1=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// ResourcePlanParser.g:47:7: createResourcePlanStatement
					{
					root_0 = (ASTNode)adaptor.nil();


					pushFollow(FOLLOW_createResourcePlanStatement_in_resourcePlanDdlStatements63);
					createResourcePlanStatement1=createResourcePlanStatement();
					state._fsp--;

					adaptor.addChild(root_0, createResourcePlanStatement1.getTree());

					}
					break;
				case 2 :
					// ResourcePlanParser.g:48:7: alterResourcePlanStatement
					{
					root_0 = (ASTNode)adaptor.nil();


					pushFollow(FOLLOW_alterResourcePlanStatement_in_resourcePlanDdlStatements71);
					alterResourcePlanStatement2=alterResourcePlanStatement();
					state._fsp--;

					adaptor.addChild(root_0, alterResourcePlanStatement2.getTree());

					}
					break;
				case 3 :
					// ResourcePlanParser.g:49:7: dropResourcePlanStatement
					{
					root_0 = (ASTNode)adaptor.nil();


					pushFollow(FOLLOW_dropResourcePlanStatement_in_resourcePlanDdlStatements79);
					dropResourcePlanStatement3=dropResourcePlanStatement();
					state._fsp--;

					adaptor.addChild(root_0, dropResourcePlanStatement3.getTree());

					}
					break;
				case 4 :
					// ResourcePlanParser.g:50:7: globalWmStatement
					{
					root_0 = (ASTNode)adaptor.nil();


					pushFollow(FOLLOW_globalWmStatement_in_resourcePlanDdlStatements87);
					globalWmStatement4=globalWmStatement();
					state._fsp--;

					adaptor.addChild(root_0, globalWmStatement4.getTree());

					}
					break;
				case 5 :
					// ResourcePlanParser.g:51:7: replaceResourcePlanStatement
					{
					root_0 = (ASTNode)adaptor.nil();


					pushFollow(FOLLOW_replaceResourcePlanStatement_in_resourcePlanDdlStatements95);
					replaceResourcePlanStatement5=replaceResourcePlanStatement();
					state._fsp--;

					adaptor.addChild(root_0, replaceResourcePlanStatement5.getTree());

					}
					break;
				case 6 :
					// ResourcePlanParser.g:52:7: createTriggerStatement
					{
					root_0 = (ASTNode)adaptor.nil();


					pushFollow(FOLLOW_createTriggerStatement_in_resourcePlanDdlStatements103);
					createTriggerStatement6=createTriggerStatement();
					state._fsp--;

					adaptor.addChild(root_0, createTriggerStatement6.getTree());

					}
					break;
				case 7 :
					// ResourcePlanParser.g:53:7: alterTriggerStatement
					{
					root_0 = (ASTNode)adaptor.nil();


					pushFollow(FOLLOW_alterTriggerStatement_in_resourcePlanDdlStatements111);
					alterTriggerStatement7=alterTriggerStatement();
					state._fsp--;

					adaptor.addChild(root_0, alterTriggerStatement7.getTree());

					}
					break;
				case 8 :
					// ResourcePlanParser.g:54:7: dropTriggerStatement
					{
					root_0 = (ASTNode)adaptor.nil();


					pushFollow(FOLLOW_dropTriggerStatement_in_resourcePlanDdlStatements119);
					dropTriggerStatement8=dropTriggerStatement();
					state._fsp--;

					adaptor.addChild(root_0, dropTriggerStatement8.getTree());

					}
					break;
				case 9 :
					// ResourcePlanParser.g:55:7: createPoolStatement
					{
					root_0 = (ASTNode)adaptor.nil();


					pushFollow(FOLLOW_createPoolStatement_in_resourcePlanDdlStatements127);
					createPoolStatement9=createPoolStatement();
					state._fsp--;

					adaptor.addChild(root_0, createPoolStatement9.getTree());

					}
					break;
				case 10 :
					// ResourcePlanParser.g:56:7: alterPoolStatement
					{
					root_0 = (ASTNode)adaptor.nil();


					pushFollow(FOLLOW_alterPoolStatement_in_resourcePlanDdlStatements135);
					alterPoolStatement10=alterPoolStatement();
					state._fsp--;

					adaptor.addChild(root_0, alterPoolStatement10.getTree());

					}
					break;
				case 11 :
					// ResourcePlanParser.g:57:7: dropPoolStatement
					{
					root_0 = (ASTNode)adaptor.nil();


					pushFollow(FOLLOW_dropPoolStatement_in_resourcePlanDdlStatements143);
					dropPoolStatement11=dropPoolStatement();
					state._fsp--;

					adaptor.addChild(root_0, dropPoolStatement11.getTree());

					}
					break;
				case 12 :
					// ResourcePlanParser.g:58:7: createMappingStatement
					{
					root_0 = (ASTNode)adaptor.nil();


					pushFollow(FOLLOW_createMappingStatement_in_resourcePlanDdlStatements151);
					createMappingStatement12=createMappingStatement();
					state._fsp--;

					adaptor.addChild(root_0, createMappingStatement12.getTree());

					}
					break;
				case 13 :
					// ResourcePlanParser.g:59:7: alterMappingStatement
					{
					root_0 = (ASTNode)adaptor.nil();


					pushFollow(FOLLOW_alterMappingStatement_in_resourcePlanDdlStatements159);
					alterMappingStatement13=alterMappingStatement();
					state._fsp--;

					adaptor.addChild(root_0, alterMappingStatement13.getTree());

					}
					break;
				case 14 :
					// ResourcePlanParser.g:60:7: dropMappingStatement
					{
					root_0 = (ASTNode)adaptor.nil();


					pushFollow(FOLLOW_dropMappingStatement_in_resourcePlanDdlStatements167);
					dropMappingStatement14=dropMappingStatement();
					state._fsp--;

					adaptor.addChild(root_0, dropMappingStatement14.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "resourcePlanDdlStatements"


	public static class rpAssign_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "rpAssign"
	// ResourcePlanParser.g:63:1: rpAssign : ( ( KW_QUERY_PARALLELISM EQUAL parallelism= Number ) -> ^( TOK_QUERY_PARALLELISM $parallelism) | ( KW_DEFAULT KW_POOL EQUAL poolPath ) -> ^( TOK_DEFAULT_POOL poolPath ) ) ;
	public final HiveParser_ResourcePlanParser.rpAssign_return rpAssign() throws RecognitionException {
		HiveParser_ResourcePlanParser.rpAssign_return retval = new HiveParser_ResourcePlanParser.rpAssign_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token parallelism=null;
		Token KW_QUERY_PARALLELISM15=null;
		Token EQUAL16=null;
		Token KW_DEFAULT17=null;
		Token KW_POOL18=null;
		Token EQUAL19=null;
		ParserRuleReturnScope poolPath20 =null;

		ASTNode parallelism_tree=null;
		ASTNode KW_QUERY_PARALLELISM15_tree=null;
		ASTNode EQUAL16_tree=null;
		ASTNode KW_DEFAULT17_tree=null;
		ASTNode KW_POOL18_tree=null;
		ASTNode EQUAL19_tree=null;
		RewriteRuleTokenStream stream_Number=new RewriteRuleTokenStream(adaptor,"token Number");
		RewriteRuleTokenStream stream_EQUAL=new RewriteRuleTokenStream(adaptor,"token EQUAL");
		RewriteRuleTokenStream stream_KW_POOL=new RewriteRuleTokenStream(adaptor,"token KW_POOL");
		RewriteRuleTokenStream stream_KW_DEFAULT=new RewriteRuleTokenStream(adaptor,"token KW_DEFAULT");
		RewriteRuleTokenStream stream_KW_QUERY_PARALLELISM=new RewriteRuleTokenStream(adaptor,"token KW_QUERY_PARALLELISM");
		RewriteRuleSubtreeStream stream_poolPath=new RewriteRuleSubtreeStream(adaptor,"rule poolPath");

		 gParent.pushMsg("rpAssign", state); 
		try {
			// ResourcePlanParser.g:66:3: ( ( ( KW_QUERY_PARALLELISM EQUAL parallelism= Number ) -> ^( TOK_QUERY_PARALLELISM $parallelism) | ( KW_DEFAULT KW_POOL EQUAL poolPath ) -> ^( TOK_DEFAULT_POOL poolPath ) ) )
			// ResourcePlanParser.g:66:5: ( ( KW_QUERY_PARALLELISM EQUAL parallelism= Number ) -> ^( TOK_QUERY_PARALLELISM $parallelism) | ( KW_DEFAULT KW_POOL EQUAL poolPath ) -> ^( TOK_DEFAULT_POOL poolPath ) )
			{
			// ResourcePlanParser.g:66:5: ( ( KW_QUERY_PARALLELISM EQUAL parallelism= Number ) -> ^( TOK_QUERY_PARALLELISM $parallelism) | ( KW_DEFAULT KW_POOL EQUAL poolPath ) -> ^( TOK_DEFAULT_POOL poolPath ) )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==KW_QUERY_PARALLELISM) ) {
				alt2=1;
			}
			else if ( (LA2_0==KW_DEFAULT) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// ResourcePlanParser.g:67:7: ( KW_QUERY_PARALLELISM EQUAL parallelism= Number )
					{
					// ResourcePlanParser.g:67:7: ( KW_QUERY_PARALLELISM EQUAL parallelism= Number )
					// ResourcePlanParser.g:67:8: KW_QUERY_PARALLELISM EQUAL parallelism= Number
					{
					KW_QUERY_PARALLELISM15=(Token)match(input,KW_QUERY_PARALLELISM,FOLLOW_KW_QUERY_PARALLELISM_in_rpAssign201);  
					stream_KW_QUERY_PARALLELISM.add(KW_QUERY_PARALLELISM15);

					EQUAL16=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_rpAssign203);  
					stream_EQUAL.add(EQUAL16);

					parallelism=(Token)match(input,Number,FOLLOW_Number_in_rpAssign207);  
					stream_Number.add(parallelism);

					}

					// AST REWRITE
					// elements: parallelism
					// token labels: parallelism
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleTokenStream stream_parallelism=new RewriteRuleTokenStream(adaptor,"token parallelism",parallelism);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 67:55: -> ^( TOK_QUERY_PARALLELISM $parallelism)
					{
						// ResourcePlanParser.g:67:58: ^( TOK_QUERY_PARALLELISM $parallelism)
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_QUERY_PARALLELISM, "TOK_QUERY_PARALLELISM"), root_1);
						adaptor.addChild(root_1, stream_parallelism.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// ResourcePlanParser.g:68:7: ( KW_DEFAULT KW_POOL EQUAL poolPath )
					{
					// ResourcePlanParser.g:68:7: ( KW_DEFAULT KW_POOL EQUAL poolPath )
					// ResourcePlanParser.g:68:8: KW_DEFAULT KW_POOL EQUAL poolPath
					{
					KW_DEFAULT17=(Token)match(input,KW_DEFAULT,FOLLOW_KW_DEFAULT_in_rpAssign226);  
					stream_KW_DEFAULT.add(KW_DEFAULT17);

					KW_POOL18=(Token)match(input,KW_POOL,FOLLOW_KW_POOL_in_rpAssign228);  
					stream_KW_POOL.add(KW_POOL18);

					EQUAL19=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_rpAssign230);  
					stream_EQUAL.add(EQUAL19);

					pushFollow(FOLLOW_poolPath_in_rpAssign232);
					poolPath20=poolPath();
					state._fsp--;

					stream_poolPath.add(poolPath20.getTree());
					}

					// AST REWRITE
					// elements: poolPath
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 68:43: -> ^( TOK_DEFAULT_POOL poolPath )
					{
						// ResourcePlanParser.g:68:46: ^( TOK_DEFAULT_POOL poolPath )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_DEFAULT_POOL, "TOK_DEFAULT_POOL"), root_1);
						adaptor.addChild(root_1, stream_poolPath.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rpAssign"


	public static class rpAssignList_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "rpAssignList"
	// ResourcePlanParser.g:72:1: rpAssignList : rpAssign ( COMMA rpAssign )* -> ( rpAssign )+ ;
	public final HiveParser_ResourcePlanParser.rpAssignList_return rpAssignList() throws RecognitionException {
		HiveParser_ResourcePlanParser.rpAssignList_return retval = new HiveParser_ResourcePlanParser.rpAssignList_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token COMMA22=null;
		ParserRuleReturnScope rpAssign21 =null;
		ParserRuleReturnScope rpAssign23 =null;

		ASTNode COMMA22_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_rpAssign=new RewriteRuleSubtreeStream(adaptor,"rule rpAssign");

		 gParent.pushMsg("rpAssignList", state); 
		try {
			// ResourcePlanParser.g:75:3: ( rpAssign ( COMMA rpAssign )* -> ( rpAssign )+ )
			// ResourcePlanParser.g:75:5: rpAssign ( COMMA rpAssign )*
			{
			pushFollow(FOLLOW_rpAssign_in_rpAssignList270);
			rpAssign21=rpAssign();
			state._fsp--;

			stream_rpAssign.add(rpAssign21.getTree());
			// ResourcePlanParser.g:75:14: ( COMMA rpAssign )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==COMMA) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// ResourcePlanParser.g:75:15: COMMA rpAssign
					{
					COMMA22=(Token)match(input,COMMA,FOLLOW_COMMA_in_rpAssignList273);  
					stream_COMMA.add(COMMA22);

					pushFollow(FOLLOW_rpAssign_in_rpAssignList275);
					rpAssign23=rpAssign();
					state._fsp--;

					stream_rpAssign.add(rpAssign23.getTree());
					}
					break;

				default :
					break loop3;
				}
			}

			// AST REWRITE
			// elements: rpAssign
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 75:32: -> ( rpAssign )+
			{
				if ( !(stream_rpAssign.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_rpAssign.hasNext() ) {
					adaptor.addChild(root_0, stream_rpAssign.nextTree());
				}
				stream_rpAssign.reset();

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rpAssignList"


	public static class rpUnassign_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "rpUnassign"
	// ResourcePlanParser.g:78:1: rpUnassign : ( ( KW_QUERY_PARALLELISM ) -> ^( TOK_QUERY_PARALLELISM TOK_NULL ) | ( KW_DEFAULT KW_POOL ) -> ^( TOK_DEFAULT_POOL TOK_NULL ) ) ;
	public final HiveParser_ResourcePlanParser.rpUnassign_return rpUnassign() throws RecognitionException {
		HiveParser_ResourcePlanParser.rpUnassign_return retval = new HiveParser_ResourcePlanParser.rpUnassign_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_QUERY_PARALLELISM24=null;
		Token KW_DEFAULT25=null;
		Token KW_POOL26=null;

		ASTNode KW_QUERY_PARALLELISM24_tree=null;
		ASTNode KW_DEFAULT25_tree=null;
		ASTNode KW_POOL26_tree=null;
		RewriteRuleTokenStream stream_KW_POOL=new RewriteRuleTokenStream(adaptor,"token KW_POOL");
		RewriteRuleTokenStream stream_KW_DEFAULT=new RewriteRuleTokenStream(adaptor,"token KW_DEFAULT");
		RewriteRuleTokenStream stream_KW_QUERY_PARALLELISM=new RewriteRuleTokenStream(adaptor,"token KW_QUERY_PARALLELISM");

		 gParent.pushMsg("rpAssign", state); 
		try {
			// ResourcePlanParser.g:81:3: ( ( ( KW_QUERY_PARALLELISM ) -> ^( TOK_QUERY_PARALLELISM TOK_NULL ) | ( KW_DEFAULT KW_POOL ) -> ^( TOK_DEFAULT_POOL TOK_NULL ) ) )
			// ResourcePlanParser.g:81:5: ( ( KW_QUERY_PARALLELISM ) -> ^( TOK_QUERY_PARALLELISM TOK_NULL ) | ( KW_DEFAULT KW_POOL ) -> ^( TOK_DEFAULT_POOL TOK_NULL ) )
			{
			// ResourcePlanParser.g:81:5: ( ( KW_QUERY_PARALLELISM ) -> ^( TOK_QUERY_PARALLELISM TOK_NULL ) | ( KW_DEFAULT KW_POOL ) -> ^( TOK_DEFAULT_POOL TOK_NULL ) )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==KW_QUERY_PARALLELISM) ) {
				alt4=1;
			}
			else if ( (LA4_0==KW_DEFAULT) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// ResourcePlanParser.g:82:7: ( KW_QUERY_PARALLELISM )
					{
					// ResourcePlanParser.g:82:7: ( KW_QUERY_PARALLELISM )
					// ResourcePlanParser.g:82:8: KW_QUERY_PARALLELISM
					{
					KW_QUERY_PARALLELISM24=(Token)match(input,KW_QUERY_PARALLELISM,FOLLOW_KW_QUERY_PARALLELISM_in_rpUnassign314);  
					stream_KW_QUERY_PARALLELISM.add(KW_QUERY_PARALLELISM24);

					}

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 82:30: -> ^( TOK_QUERY_PARALLELISM TOK_NULL )
					{
						// ResourcePlanParser.g:82:33: ^( TOK_QUERY_PARALLELISM TOK_NULL )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_QUERY_PARALLELISM, "TOK_QUERY_PARALLELISM"), root_1);
						adaptor.addChild(root_1, (ASTNode)adaptor.create(TOK_NULL, "TOK_NULL"));
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// ResourcePlanParser.g:83:7: ( KW_DEFAULT KW_POOL )
					{
					// ResourcePlanParser.g:83:7: ( KW_DEFAULT KW_POOL )
					// ResourcePlanParser.g:83:8: KW_DEFAULT KW_POOL
					{
					KW_DEFAULT25=(Token)match(input,KW_DEFAULT,FOLLOW_KW_DEFAULT_in_rpUnassign332);  
					stream_KW_DEFAULT.add(KW_DEFAULT25);

					KW_POOL26=(Token)match(input,KW_POOL,FOLLOW_KW_POOL_in_rpUnassign334);  
					stream_KW_POOL.add(KW_POOL26);

					}

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 83:28: -> ^( TOK_DEFAULT_POOL TOK_NULL )
					{
						// ResourcePlanParser.g:83:31: ^( TOK_DEFAULT_POOL TOK_NULL )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_DEFAULT_POOL, "TOK_DEFAULT_POOL"), root_1);
						adaptor.addChild(root_1, (ASTNode)adaptor.create(TOK_NULL, "TOK_NULL"));
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rpUnassign"


	public static class rpUnassignList_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "rpUnassignList"
	// ResourcePlanParser.g:87:1: rpUnassignList : rpUnassign ( COMMA rpUnassign )* -> ( rpUnassign )+ ;
	public final HiveParser_ResourcePlanParser.rpUnassignList_return rpUnassignList() throws RecognitionException {
		HiveParser_ResourcePlanParser.rpUnassignList_return retval = new HiveParser_ResourcePlanParser.rpUnassignList_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token COMMA28=null;
		ParserRuleReturnScope rpUnassign27 =null;
		ParserRuleReturnScope rpUnassign29 =null;

		ASTNode COMMA28_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_rpUnassign=new RewriteRuleSubtreeStream(adaptor,"rule rpUnassign");

		 gParent.pushMsg("rpAssignList", state); 
		try {
			// ResourcePlanParser.g:90:3: ( rpUnassign ( COMMA rpUnassign )* -> ( rpUnassign )+ )
			// ResourcePlanParser.g:90:5: rpUnassign ( COMMA rpUnassign )*
			{
			pushFollow(FOLLOW_rpUnassign_in_rpUnassignList372);
			rpUnassign27=rpUnassign();
			state._fsp--;

			stream_rpUnassign.add(rpUnassign27.getTree());
			// ResourcePlanParser.g:90:16: ( COMMA rpUnassign )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==COMMA) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// ResourcePlanParser.g:90:17: COMMA rpUnassign
					{
					COMMA28=(Token)match(input,COMMA,FOLLOW_COMMA_in_rpUnassignList375);  
					stream_COMMA.add(COMMA28);

					pushFollow(FOLLOW_rpUnassign_in_rpUnassignList377);
					rpUnassign29=rpUnassign();
					state._fsp--;

					stream_rpUnassign.add(rpUnassign29.getTree());
					}
					break;

				default :
					break loop5;
				}
			}

			// AST REWRITE
			// elements: rpUnassign
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 90:36: -> ( rpUnassign )+
			{
				if ( !(stream_rpUnassign.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_rpUnassign.hasNext() ) {
					adaptor.addChild(root_0, stream_rpUnassign.nextTree());
				}
				stream_rpUnassign.reset();

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "rpUnassignList"


	public static class createResourcePlanStatement_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "createResourcePlanStatement"
	// ResourcePlanParser.g:93:1: createResourcePlanStatement : KW_CREATE KW_RESOURCE KW_PLAN ( (name= identifier KW_LIKE likeName= identifier -> ^( TOK_CREATE_RP $name ^( TOK_LIKERP $likeName) ) ) | (name= identifier ( KW_WITH rpAssignList )? -> ^( TOK_CREATE_RP $name ( rpAssignList )? ) ) ) ;
	public final HiveParser_ResourcePlanParser.createResourcePlanStatement_return createResourcePlanStatement() throws RecognitionException {
		HiveParser_ResourcePlanParser.createResourcePlanStatement_return retval = new HiveParser_ResourcePlanParser.createResourcePlanStatement_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_CREATE30=null;
		Token KW_RESOURCE31=null;
		Token KW_PLAN32=null;
		Token KW_LIKE33=null;
		Token KW_WITH34=null;
		ParserRuleReturnScope name =null;
		ParserRuleReturnScope likeName =null;
		ParserRuleReturnScope rpAssignList35 =null;

		ASTNode KW_CREATE30_tree=null;
		ASTNode KW_RESOURCE31_tree=null;
		ASTNode KW_PLAN32_tree=null;
		ASTNode KW_LIKE33_tree=null;
		ASTNode KW_WITH34_tree=null;
		RewriteRuleTokenStream stream_KW_CREATE=new RewriteRuleTokenStream(adaptor,"token KW_CREATE");
		RewriteRuleTokenStream stream_KW_PLAN=new RewriteRuleTokenStream(adaptor,"token KW_PLAN");
		RewriteRuleTokenStream stream_KW_WITH=new RewriteRuleTokenStream(adaptor,"token KW_WITH");
		RewriteRuleTokenStream stream_KW_RESOURCE=new RewriteRuleTokenStream(adaptor,"token KW_RESOURCE");
		RewriteRuleTokenStream stream_KW_LIKE=new RewriteRuleTokenStream(adaptor,"token KW_LIKE");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
		RewriteRuleSubtreeStream stream_rpAssignList=new RewriteRuleSubtreeStream(adaptor,"rule rpAssignList");

		 gParent.pushMsg("create resource plan statement", state); 
		try {
			// ResourcePlanParser.g:96:5: ( KW_CREATE KW_RESOURCE KW_PLAN ( (name= identifier KW_LIKE likeName= identifier -> ^( TOK_CREATE_RP $name ^( TOK_LIKERP $likeName) ) ) | (name= identifier ( KW_WITH rpAssignList )? -> ^( TOK_CREATE_RP $name ( rpAssignList )? ) ) ) )
			// ResourcePlanParser.g:96:7: KW_CREATE KW_RESOURCE KW_PLAN ( (name= identifier KW_LIKE likeName= identifier -> ^( TOK_CREATE_RP $name ^( TOK_LIKERP $likeName) ) ) | (name= identifier ( KW_WITH rpAssignList )? -> ^( TOK_CREATE_RP $name ( rpAssignList )? ) ) )
			{
			KW_CREATE30=(Token)match(input,KW_CREATE,FOLLOW_KW_CREATE_in_createResourcePlanStatement409);  
			stream_KW_CREATE.add(KW_CREATE30);

			KW_RESOURCE31=(Token)match(input,KW_RESOURCE,FOLLOW_KW_RESOURCE_in_createResourcePlanStatement411);  
			stream_KW_RESOURCE.add(KW_RESOURCE31);

			KW_PLAN32=(Token)match(input,KW_PLAN,FOLLOW_KW_PLAN_in_createResourcePlanStatement413);  
			stream_KW_PLAN.add(KW_PLAN32);

			// ResourcePlanParser.g:96:37: ( (name= identifier KW_LIKE likeName= identifier -> ^( TOK_CREATE_RP $name ^( TOK_LIKERP $likeName) ) ) | (name= identifier ( KW_WITH rpAssignList )? -> ^( TOK_CREATE_RP $name ( rpAssignList )? ) ) )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==Identifier) ) {
				int LA7_1 = input.LA(2);
				if ( (LA7_1==KW_LIKE) ) {
					alt7=1;
				}
				else if ( (LA7_1==EOF||LA7_1==KW_WITH) ) {
					alt7=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 7, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( ((LA7_0 >= KW_ABORT && LA7_0 <= KW_AFTER)||LA7_0==KW_ALLOC_FRACTION||LA7_0==KW_ANALYZE||LA7_0==KW_ARCHIVE||LA7_0==KW_ASC||(LA7_0 >= KW_AUTOCOMMIT && LA7_0 <= KW_BEFORE)||(LA7_0 >= KW_BUCKET && LA7_0 <= KW_BUCKETS)||(LA7_0 >= KW_CACHE && LA7_0 <= KW_CASCADE)||LA7_0==KW_CHANGE||(LA7_0 >= KW_CHECK && LA7_0 <= KW_COLLECTION)||(LA7_0 >= KW_COLUMNS && LA7_0 <= KW_COMMENT)||(LA7_0 >= KW_COMPACT && LA7_0 <= KW_CONCATENATE)||LA7_0==KW_CONTINUE||LA7_0==KW_DATA||LA7_0==KW_DATABASES||(LA7_0 >= KW_DATETIME && LA7_0 <= KW_DBPROPERTIES)||(LA7_0 >= KW_DEFAULT && LA7_0 <= KW_DEFINED)||(LA7_0 >= KW_DELIMITED && LA7_0 <= KW_DESC)||(LA7_0 >= KW_DETAIL && LA7_0 <= KW_DISABLE)||(LA7_0 >= KW_DISTRIBUTE && LA7_0 <= KW_DO)||LA7_0==KW_DOW||(LA7_0 >= KW_DUMP && LA7_0 <= KW_ELEM_TYPE)||LA7_0==KW_ENABLE||(LA7_0 >= KW_ENFORCED && LA7_0 <= KW_ESCAPED)||LA7_0==KW_EXCLUSIVE||(LA7_0 >= KW_EXPLAIN && LA7_0 <= KW_EXPRESSION)||(LA7_0 >= KW_FIELDS && LA7_0 <= KW_FIRST)||(LA7_0 >= KW_FORMAT && LA7_0 <= KW_FORMATTED)||LA7_0==KW_FUNCTIONS||(LA7_0 >= KW_HOUR && LA7_0 <= KW_IDXPROPERTIES)||(LA7_0 >= KW_INDEX && LA7_0 <= KW_INDEXES)||(LA7_0 >= KW_INPATH && LA7_0 <= KW_INPUTFORMAT)||(LA7_0 >= KW_ISOLATION && LA7_0 <= KW_JAR)||(LA7_0 >= KW_KEY && LA7_0 <= KW_LAST)||LA7_0==KW_LEVEL||(LA7_0 >= KW_LIMIT && LA7_0 <= KW_LOAD)||(LA7_0 >= KW_LOCATION && LA7_0 <= KW_LONG)||LA7_0==KW_MANAGEMENT||(LA7_0 >= KW_MAPJOIN && LA7_0 <= KW_MATERIALIZED)||LA7_0==KW_METADATA||(LA7_0 >= KW_MINUTE && LA7_0 <= KW_MONTH)||(LA7_0 >= KW_MOVE && LA7_0 <= KW_MSCK)||(LA7_0 >= KW_NORELY && LA7_0 <= KW_NOSCAN)||LA7_0==KW_NOVALIDATE||LA7_0==KW_NULLS||LA7_0==KW_OFFSET||(LA7_0 >= KW_OPERATOR && LA7_0 <= KW_OPTION)||(LA7_0 >= KW_OUTPUTDRIVER && LA7_0 <= KW_OUTPUTFORMAT)||(LA7_0 >= KW_OVERWRITE && LA7_0 <= KW_OWNER)||(LA7_0 >= KW_PARTITIONED && LA7_0 <= KW_PATH)||(LA7_0 >= KW_PLAN && LA7_0 <= KW_POOL)||LA7_0==KW_PRINCIPALS||(LA7_0 >= KW_PURGE && LA7_0 <= KW_QUERY_PARALLELISM)||LA7_0==KW_READ||(LA7_0 >= KW_REBUILD && LA7_0 <= KW_RECORDWRITER)||(LA7_0 >= KW_RELOAD && LA7_0 <= KW_RESTRICT)||LA7_0==KW_REWRITE||(LA7_0 >= KW_ROLE && LA7_0 <= KW_ROLES)||(LA7_0 >= KW_SCHEDULING_POLICY && LA7_0 <= KW_SECOND)||(LA7_0 >= KW_SEMI && LA7_0 <= KW_SERVER)||(LA7_0 >= KW_SETS && LA7_0 <= KW_SKEWED)||(LA7_0 >= KW_SNAPSHOT && LA7_0 <= KW_SSL)||(LA7_0 >= KW_STATISTICS && LA7_0 <= KW_SUMMARY)||LA7_0==KW_TABLES||(LA7_0 >= KW_TBLPROPERTIES && LA7_0 <= KW_TERMINATED)||LA7_0==KW_TINYINT||(LA7_0 >= KW_TOUCH && LA7_0 <= KW_TRANSACTIONS)||LA7_0==KW_UNARCHIVE||LA7_0==KW_UNDO||LA7_0==KW_UNIONTYPE||(LA7_0 >= KW_UNLOCK && LA7_0 <= KW_UNSIGNED)||(LA7_0 >= KW_URI && LA7_0 <= KW_USE)||(LA7_0 >= KW_UTC && LA7_0 <= KW_VALIDATE)||LA7_0==KW_VALUE_TYPE||(LA7_0 >= KW_VECTORIZATION && LA7_0 <= KW_WEEK)||LA7_0==KW_WHILE||(LA7_0 >= KW_WORK && LA7_0 <= KW_ZONE)||LA7_0==KW_BATCH||LA7_0==KW_DAYOFWEEK||LA7_0==KW_HOLD_DDLTIME||LA7_0==KW_IGNORE||LA7_0==KW_NO_DROP||LA7_0==KW_OFFLINE||LA7_0==KW_PROTECTION||LA7_0==KW_READONLY||LA7_0==KW_TIMESTAMPTZ) ) {
				int LA7_2 = input.LA(2);
				if ( (LA7_2==KW_LIKE) ) {
					alt7=1;
				}
				else if ( (LA7_2==EOF||LA7_2==KW_WITH) ) {
					alt7=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 7, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// ResourcePlanParser.g:97:11: (name= identifier KW_LIKE likeName= identifier -> ^( TOK_CREATE_RP $name ^( TOK_LIKERP $likeName) ) )
					{
					// ResourcePlanParser.g:97:11: (name= identifier KW_LIKE likeName= identifier -> ^( TOK_CREATE_RP $name ^( TOK_LIKERP $likeName) ) )
					// ResourcePlanParser.g:97:12: name= identifier KW_LIKE likeName= identifier
					{
					pushFollow(FOLLOW_identifier_in_createResourcePlanStatement430);
					name=gHiveParser.identifier();
					state._fsp--;

					stream_identifier.add(name.getTree());
					KW_LIKE33=(Token)match(input,KW_LIKE,FOLLOW_KW_LIKE_in_createResourcePlanStatement432);  
					stream_KW_LIKE.add(KW_LIKE33);

					pushFollow(FOLLOW_identifier_in_createResourcePlanStatement436);
					likeName=gHiveParser.identifier();
					state._fsp--;

					stream_identifier.add(likeName.getTree());
					// AST REWRITE
					// elements: likeName, name
					// token labels: 
					// rule labels: likeName, name, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_likeName=new RewriteRuleSubtreeStream(adaptor,"rule likeName",likeName!=null?likeName.getTree():null);
					RewriteRuleSubtreeStream stream_name=new RewriteRuleSubtreeStream(adaptor,"rule name",name!=null?name.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 97:56: -> ^( TOK_CREATE_RP $name ^( TOK_LIKERP $likeName) )
					{
						// ResourcePlanParser.g:97:59: ^( TOK_CREATE_RP $name ^( TOK_LIKERP $likeName) )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_CREATE_RP, "TOK_CREATE_RP"), root_1);
						adaptor.addChild(root_1, stream_name.nextTree());
						// ResourcePlanParser.g:97:81: ^( TOK_LIKERP $likeName)
						{
						ASTNode root_2 = (ASTNode)adaptor.nil();
						root_2 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_LIKERP, "TOK_LIKERP"), root_2);
						adaptor.addChild(root_2, stream_likeName.nextTree());
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
					// ResourcePlanParser.g:98:11: (name= identifier ( KW_WITH rpAssignList )? -> ^( TOK_CREATE_RP $name ( rpAssignList )? ) )
					{
					// ResourcePlanParser.g:98:11: (name= identifier ( KW_WITH rpAssignList )? -> ^( TOK_CREATE_RP $name ( rpAssignList )? ) )
					// ResourcePlanParser.g:98:12: name= identifier ( KW_WITH rpAssignList )?
					{
					pushFollow(FOLLOW_identifier_in_createResourcePlanStatement468);
					name=gHiveParser.identifier();
					state._fsp--;

					stream_identifier.add(name.getTree());
					// ResourcePlanParser.g:98:28: ( KW_WITH rpAssignList )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==KW_WITH) ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// ResourcePlanParser.g:98:29: KW_WITH rpAssignList
							{
							KW_WITH34=(Token)match(input,KW_WITH,FOLLOW_KW_WITH_in_createResourcePlanStatement471);  
							stream_KW_WITH.add(KW_WITH34);

							pushFollow(FOLLOW_rpAssignList_in_createResourcePlanStatement473);
							rpAssignList35=rpAssignList();
							state._fsp--;

							stream_rpAssignList.add(rpAssignList35.getTree());
							}
							break;

					}

					// AST REWRITE
					// elements: rpAssignList, name
					// token labels: 
					// rule labels: name, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_name=new RewriteRuleSubtreeStream(adaptor,"rule name",name!=null?name.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 98:52: -> ^( TOK_CREATE_RP $name ( rpAssignList )? )
					{
						// ResourcePlanParser.g:98:55: ^( TOK_CREATE_RP $name ( rpAssignList )? )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_CREATE_RP, "TOK_CREATE_RP"), root_1);
						adaptor.addChild(root_1, stream_name.nextTree());
						// ResourcePlanParser.g:98:77: ( rpAssignList )?
						if ( stream_rpAssignList.hasNext() ) {
							adaptor.addChild(root_1, stream_rpAssignList.nextTree());
						}
						stream_rpAssignList.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "createResourcePlanStatement"


	public static class withReplace_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "withReplace"
	// ResourcePlanParser.g:103:1: withReplace : KW_WITH KW_REPLACE -> ^( TOK_REPLACE ) ;
	public final HiveParser_ResourcePlanParser.withReplace_return withReplace() throws RecognitionException {
		HiveParser_ResourcePlanParser.withReplace_return retval = new HiveParser_ResourcePlanParser.withReplace_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_WITH36=null;
		Token KW_REPLACE37=null;

		ASTNode KW_WITH36_tree=null;
		ASTNode KW_REPLACE37_tree=null;
		RewriteRuleTokenStream stream_KW_WITH=new RewriteRuleTokenStream(adaptor,"token KW_WITH");
		RewriteRuleTokenStream stream_KW_REPLACE=new RewriteRuleTokenStream(adaptor,"token KW_REPLACE");

		try {
			// ResourcePlanParser.g:103:13: ( KW_WITH KW_REPLACE -> ^( TOK_REPLACE ) )
			// ResourcePlanParser.g:103:15: KW_WITH KW_REPLACE
			{
			KW_WITH36=(Token)match(input,KW_WITH,FOLLOW_KW_WITH_in_withReplace510);  
			stream_KW_WITH.add(KW_WITH36);

			KW_REPLACE37=(Token)match(input,KW_REPLACE,FOLLOW_KW_REPLACE_in_withReplace512);  
			stream_KW_REPLACE.add(KW_REPLACE37);

			// AST REWRITE
			// elements: 
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 103:34: -> ^( TOK_REPLACE )
			{
				// ResourcePlanParser.g:103:37: ^( TOK_REPLACE )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_REPLACE, "TOK_REPLACE"), root_1);
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "withReplace"


	public static class activate_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "activate"
	// ResourcePlanParser.g:104:1: activate : KW_ACTIVATE ( withReplace )? -> ^( TOK_ACTIVATE ( withReplace )? ) ;
	public final HiveParser_ResourcePlanParser.activate_return activate() throws RecognitionException {
		HiveParser_ResourcePlanParser.activate_return retval = new HiveParser_ResourcePlanParser.activate_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_ACTIVATE38=null;
		ParserRuleReturnScope withReplace39 =null;

		ASTNode KW_ACTIVATE38_tree=null;
		RewriteRuleTokenStream stream_KW_ACTIVATE=new RewriteRuleTokenStream(adaptor,"token KW_ACTIVATE");
		RewriteRuleSubtreeStream stream_withReplace=new RewriteRuleSubtreeStream(adaptor,"rule withReplace");

		try {
			// ResourcePlanParser.g:104:10: ( KW_ACTIVATE ( withReplace )? -> ^( TOK_ACTIVATE ( withReplace )? ) )
			// ResourcePlanParser.g:104:12: KW_ACTIVATE ( withReplace )?
			{
			KW_ACTIVATE38=(Token)match(input,KW_ACTIVATE,FOLLOW_KW_ACTIVATE_in_activate525);  
			stream_KW_ACTIVATE.add(KW_ACTIVATE38);

			// ResourcePlanParser.g:104:24: ( withReplace )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==KW_WITH) ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// ResourcePlanParser.g:104:24: withReplace
					{
					pushFollow(FOLLOW_withReplace_in_activate527);
					withReplace39=withReplace();
					state._fsp--;

					stream_withReplace.add(withReplace39.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: withReplace
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 104:37: -> ^( TOK_ACTIVATE ( withReplace )? )
			{
				// ResourcePlanParser.g:104:40: ^( TOK_ACTIVATE ( withReplace )? )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ACTIVATE, "TOK_ACTIVATE"), root_1);
				// ResourcePlanParser.g:104:55: ( withReplace )?
				if ( stream_withReplace.hasNext() ) {
					adaptor.addChild(root_1, stream_withReplace.nextTree());
				}
				stream_withReplace.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "activate"


	public static class enable_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "enable"
	// ResourcePlanParser.g:105:1: enable : KW_ENABLE -> ^( TOK_ENABLE ) ;
	public final HiveParser_ResourcePlanParser.enable_return enable() throws RecognitionException {
		HiveParser_ResourcePlanParser.enable_return retval = new HiveParser_ResourcePlanParser.enable_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_ENABLE40=null;

		ASTNode KW_ENABLE40_tree=null;
		RewriteRuleTokenStream stream_KW_ENABLE=new RewriteRuleTokenStream(adaptor,"token KW_ENABLE");

		try {
			// ResourcePlanParser.g:105:8: ( KW_ENABLE -> ^( TOK_ENABLE ) )
			// ResourcePlanParser.g:105:10: KW_ENABLE
			{
			KW_ENABLE40=(Token)match(input,KW_ENABLE,FOLLOW_KW_ENABLE_in_enable544);  
			stream_KW_ENABLE.add(KW_ENABLE40);

			// AST REWRITE
			// elements: 
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 105:20: -> ^( TOK_ENABLE )
			{
				// ResourcePlanParser.g:105:23: ^( TOK_ENABLE )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ENABLE, "TOK_ENABLE"), root_1);
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "enable"


	public static class disable_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "disable"
	// ResourcePlanParser.g:106:1: disable : KW_DISABLE -> ^( TOK_DISABLE ) ;
	public final HiveParser_ResourcePlanParser.disable_return disable() throws RecognitionException {
		HiveParser_ResourcePlanParser.disable_return retval = new HiveParser_ResourcePlanParser.disable_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_DISABLE41=null;

		ASTNode KW_DISABLE41_tree=null;
		RewriteRuleTokenStream stream_KW_DISABLE=new RewriteRuleTokenStream(adaptor,"token KW_DISABLE");

		try {
			// ResourcePlanParser.g:106:9: ( KW_DISABLE -> ^( TOK_DISABLE ) )
			// ResourcePlanParser.g:106:11: KW_DISABLE
			{
			KW_DISABLE41=(Token)match(input,KW_DISABLE,FOLLOW_KW_DISABLE_in_disable557);  
			stream_KW_DISABLE.add(KW_DISABLE41);

			// AST REWRITE
			// elements: 
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 106:22: -> ^( TOK_DISABLE )
			{
				// ResourcePlanParser.g:106:25: ^( TOK_DISABLE )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_DISABLE, "TOK_DISABLE"), root_1);
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "disable"


	public static class unmanaged_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "unmanaged"
	// ResourcePlanParser.g:107:1: unmanaged : KW_UNMANAGED -> ^( TOK_UNMANAGED ) ;
	public final HiveParser_ResourcePlanParser.unmanaged_return unmanaged() throws RecognitionException {
		HiveParser_ResourcePlanParser.unmanaged_return retval = new HiveParser_ResourcePlanParser.unmanaged_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_UNMANAGED42=null;

		ASTNode KW_UNMANAGED42_tree=null;
		RewriteRuleTokenStream stream_KW_UNMANAGED=new RewriteRuleTokenStream(adaptor,"token KW_UNMANAGED");

		try {
			// ResourcePlanParser.g:107:11: ( KW_UNMANAGED -> ^( TOK_UNMANAGED ) )
			// ResourcePlanParser.g:107:13: KW_UNMANAGED
			{
			KW_UNMANAGED42=(Token)match(input,KW_UNMANAGED,FOLLOW_KW_UNMANAGED_in_unmanaged570);  
			stream_KW_UNMANAGED.add(KW_UNMANAGED42);

			// AST REWRITE
			// elements: 
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 107:26: -> ^( TOK_UNMANAGED )
			{
				// ResourcePlanParser.g:107:29: ^( TOK_UNMANAGED )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_UNMANAGED, "TOK_UNMANAGED"), root_1);
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "unmanaged"


	public static class alterResourcePlanStatement_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "alterResourcePlanStatement"
	// ResourcePlanParser.g:110:1: alterResourcePlanStatement : KW_ALTER KW_RESOURCE KW_PLAN name= identifier ( ( KW_VALIDATE -> ^( TOK_ALTER_RP $name TOK_VALIDATE ) ) | ( KW_DISABLE -> ^( TOK_ALTER_RP $name TOK_DISABLE ) ) | ( KW_SET rpAssignList -> ^( TOK_ALTER_RP $name rpAssignList ) ) | ( KW_UNSET rpUnassignList -> ^( TOK_ALTER_RP $name rpUnassignList ) ) | ( KW_RENAME KW_TO newName= identifier -> ^( TOK_ALTER_RP $name ^( TOK_RENAME $newName) ) ) | ( ( activate ( enable )? | enable ( activate )? ) -> ^( TOK_ALTER_RP $name ( activate )? ( enable )? ) ) ) ;
	public final HiveParser_ResourcePlanParser.alterResourcePlanStatement_return alterResourcePlanStatement() throws RecognitionException {
		HiveParser_ResourcePlanParser.alterResourcePlanStatement_return retval = new HiveParser_ResourcePlanParser.alterResourcePlanStatement_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_ALTER43=null;
		Token KW_RESOURCE44=null;
		Token KW_PLAN45=null;
		Token KW_VALIDATE46=null;
		Token KW_DISABLE47=null;
		Token KW_SET48=null;
		Token KW_UNSET50=null;
		Token KW_RENAME52=null;
		Token KW_TO53=null;
		ParserRuleReturnScope name =null;
		ParserRuleReturnScope newName =null;
		ParserRuleReturnScope rpAssignList49 =null;
		ParserRuleReturnScope rpUnassignList51 =null;
		ParserRuleReturnScope activate54 =null;
		ParserRuleReturnScope enable55 =null;
		ParserRuleReturnScope enable56 =null;
		ParserRuleReturnScope activate57 =null;

		ASTNode KW_ALTER43_tree=null;
		ASTNode KW_RESOURCE44_tree=null;
		ASTNode KW_PLAN45_tree=null;
		ASTNode KW_VALIDATE46_tree=null;
		ASTNode KW_DISABLE47_tree=null;
		ASTNode KW_SET48_tree=null;
		ASTNode KW_UNSET50_tree=null;
		ASTNode KW_RENAME52_tree=null;
		ASTNode KW_TO53_tree=null;
		RewriteRuleTokenStream stream_KW_RENAME=new RewriteRuleTokenStream(adaptor,"token KW_RENAME");
		RewriteRuleTokenStream stream_KW_VALIDATE=new RewriteRuleTokenStream(adaptor,"token KW_VALIDATE");
		RewriteRuleTokenStream stream_KW_UNSET=new RewriteRuleTokenStream(adaptor,"token KW_UNSET");
		RewriteRuleTokenStream stream_KW_PLAN=new RewriteRuleTokenStream(adaptor,"token KW_PLAN");
		RewriteRuleTokenStream stream_KW_TO=new RewriteRuleTokenStream(adaptor,"token KW_TO");
		RewriteRuleTokenStream stream_KW_ALTER=new RewriteRuleTokenStream(adaptor,"token KW_ALTER");
		RewriteRuleTokenStream stream_KW_DISABLE=new RewriteRuleTokenStream(adaptor,"token KW_DISABLE");
		RewriteRuleTokenStream stream_KW_RESOURCE=new RewriteRuleTokenStream(adaptor,"token KW_RESOURCE");
		RewriteRuleTokenStream stream_KW_SET=new RewriteRuleTokenStream(adaptor,"token KW_SET");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
		RewriteRuleSubtreeStream stream_rpAssignList=new RewriteRuleSubtreeStream(adaptor,"rule rpAssignList");
		RewriteRuleSubtreeStream stream_enable=new RewriteRuleSubtreeStream(adaptor,"rule enable");
		RewriteRuleSubtreeStream stream_rpUnassignList=new RewriteRuleSubtreeStream(adaptor,"rule rpUnassignList");
		RewriteRuleSubtreeStream stream_activate=new RewriteRuleSubtreeStream(adaptor,"rule activate");

		 gParent.pushMsg("alter resource plan statement", state); 
		try {
			// ResourcePlanParser.g:113:5: ( KW_ALTER KW_RESOURCE KW_PLAN name= identifier ( ( KW_VALIDATE -> ^( TOK_ALTER_RP $name TOK_VALIDATE ) ) | ( KW_DISABLE -> ^( TOK_ALTER_RP $name TOK_DISABLE ) ) | ( KW_SET rpAssignList -> ^( TOK_ALTER_RP $name rpAssignList ) ) | ( KW_UNSET rpUnassignList -> ^( TOK_ALTER_RP $name rpUnassignList ) ) | ( KW_RENAME KW_TO newName= identifier -> ^( TOK_ALTER_RP $name ^( TOK_RENAME $newName) ) ) | ( ( activate ( enable )? | enable ( activate )? ) -> ^( TOK_ALTER_RP $name ( activate )? ( enable )? ) ) ) )
			// ResourcePlanParser.g:113:7: KW_ALTER KW_RESOURCE KW_PLAN name= identifier ( ( KW_VALIDATE -> ^( TOK_ALTER_RP $name TOK_VALIDATE ) ) | ( KW_DISABLE -> ^( TOK_ALTER_RP $name TOK_DISABLE ) ) | ( KW_SET rpAssignList -> ^( TOK_ALTER_RP $name rpAssignList ) ) | ( KW_UNSET rpUnassignList -> ^( TOK_ALTER_RP $name rpUnassignList ) ) | ( KW_RENAME KW_TO newName= identifier -> ^( TOK_ALTER_RP $name ^( TOK_RENAME $newName) ) ) | ( ( activate ( enable )? | enable ( activate )? ) -> ^( TOK_ALTER_RP $name ( activate )? ( enable )? ) ) )
			{
			KW_ALTER43=(Token)match(input,KW_ALTER,FOLLOW_KW_ALTER_in_alterResourcePlanStatement599);  
			stream_KW_ALTER.add(KW_ALTER43);

			KW_RESOURCE44=(Token)match(input,KW_RESOURCE,FOLLOW_KW_RESOURCE_in_alterResourcePlanStatement601);  
			stream_KW_RESOURCE.add(KW_RESOURCE44);

			KW_PLAN45=(Token)match(input,KW_PLAN,FOLLOW_KW_PLAN_in_alterResourcePlanStatement603);  
			stream_KW_PLAN.add(KW_PLAN45);

			pushFollow(FOLLOW_identifier_in_alterResourcePlanStatement607);
			name=gHiveParser.identifier();
			state._fsp--;

			stream_identifier.add(name.getTree());
			// ResourcePlanParser.g:113:52: ( ( KW_VALIDATE -> ^( TOK_ALTER_RP $name TOK_VALIDATE ) ) | ( KW_DISABLE -> ^( TOK_ALTER_RP $name TOK_DISABLE ) ) | ( KW_SET rpAssignList -> ^( TOK_ALTER_RP $name rpAssignList ) ) | ( KW_UNSET rpUnassignList -> ^( TOK_ALTER_RP $name rpUnassignList ) ) | ( KW_RENAME KW_TO newName= identifier -> ^( TOK_ALTER_RP $name ^( TOK_RENAME $newName) ) ) | ( ( activate ( enable )? | enable ( activate )? ) -> ^( TOK_ALTER_RP $name ( activate )? ( enable )? ) ) )
			int alt12=6;
			switch ( input.LA(1) ) {
			case KW_VALIDATE:
				{
				alt12=1;
				}
				break;
			case KW_DISABLE:
				{
				alt12=2;
				}
				break;
			case KW_SET:
				{
				alt12=3;
				}
				break;
			case KW_UNSET:
				{
				alt12=4;
				}
				break;
			case KW_RENAME:
				{
				alt12=5;
				}
				break;
			case KW_ACTIVATE:
			case KW_ENABLE:
				{
				alt12=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// ResourcePlanParser.g:114:11: ( KW_VALIDATE -> ^( TOK_ALTER_RP $name TOK_VALIDATE ) )
					{
					// ResourcePlanParser.g:114:11: ( KW_VALIDATE -> ^( TOK_ALTER_RP $name TOK_VALIDATE ) )
					// ResourcePlanParser.g:114:12: KW_VALIDATE
					{
					KW_VALIDATE46=(Token)match(input,KW_VALIDATE,FOLLOW_KW_VALIDATE_in_alterResourcePlanStatement622);  
					stream_KW_VALIDATE.add(KW_VALIDATE46);

					// AST REWRITE
					// elements: name
					// token labels: 
					// rule labels: name, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_name=new RewriteRuleSubtreeStream(adaptor,"rule name",name!=null?name.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 114:24: -> ^( TOK_ALTER_RP $name TOK_VALIDATE )
					{
						// ResourcePlanParser.g:114:27: ^( TOK_ALTER_RP $name TOK_VALIDATE )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ALTER_RP, "TOK_ALTER_RP"), root_1);
						adaptor.addChild(root_1, stream_name.nextTree());
						adaptor.addChild(root_1, (ASTNode)adaptor.create(TOK_VALIDATE, "TOK_VALIDATE"));
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}

					}
					break;
				case 2 :
					// ResourcePlanParser.g:115:11: ( KW_DISABLE -> ^( TOK_ALTER_RP $name TOK_DISABLE ) )
					{
					// ResourcePlanParser.g:115:11: ( KW_DISABLE -> ^( TOK_ALTER_RP $name TOK_DISABLE ) )
					// ResourcePlanParser.g:115:12: KW_DISABLE
					{
					KW_DISABLE47=(Token)match(input,KW_DISABLE,FOLLOW_KW_DISABLE_in_alterResourcePlanStatement647);  
					stream_KW_DISABLE.add(KW_DISABLE47);

					// AST REWRITE
					// elements: name
					// token labels: 
					// rule labels: name, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_name=new RewriteRuleSubtreeStream(adaptor,"rule name",name!=null?name.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 115:23: -> ^( TOK_ALTER_RP $name TOK_DISABLE )
					{
						// ResourcePlanParser.g:115:26: ^( TOK_ALTER_RP $name TOK_DISABLE )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ALTER_RP, "TOK_ALTER_RP"), root_1);
						adaptor.addChild(root_1, stream_name.nextTree());
						adaptor.addChild(root_1, (ASTNode)adaptor.create(TOK_DISABLE, "TOK_DISABLE"));
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}

					}
					break;
				case 3 :
					// ResourcePlanParser.g:116:11: ( KW_SET rpAssignList -> ^( TOK_ALTER_RP $name rpAssignList ) )
					{
					// ResourcePlanParser.g:116:11: ( KW_SET rpAssignList -> ^( TOK_ALTER_RP $name rpAssignList ) )
					// ResourcePlanParser.g:116:12: KW_SET rpAssignList
					{
					KW_SET48=(Token)match(input,KW_SET,FOLLOW_KW_SET_in_alterResourcePlanStatement672);  
					stream_KW_SET.add(KW_SET48);

					pushFollow(FOLLOW_rpAssignList_in_alterResourcePlanStatement674);
					rpAssignList49=rpAssignList();
					state._fsp--;

					stream_rpAssignList.add(rpAssignList49.getTree());
					// AST REWRITE
					// elements: rpAssignList, name
					// token labels: 
					// rule labels: name, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_name=new RewriteRuleSubtreeStream(adaptor,"rule name",name!=null?name.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 116:32: -> ^( TOK_ALTER_RP $name rpAssignList )
					{
						// ResourcePlanParser.g:116:35: ^( TOK_ALTER_RP $name rpAssignList )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ALTER_RP, "TOK_ALTER_RP"), root_1);
						adaptor.addChild(root_1, stream_name.nextTree());
						adaptor.addChild(root_1, stream_rpAssignList.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}

					}
					break;
				case 4 :
					// ResourcePlanParser.g:117:11: ( KW_UNSET rpUnassignList -> ^( TOK_ALTER_RP $name rpUnassignList ) )
					{
					// ResourcePlanParser.g:117:11: ( KW_UNSET rpUnassignList -> ^( TOK_ALTER_RP $name rpUnassignList ) )
					// ResourcePlanParser.g:117:12: KW_UNSET rpUnassignList
					{
					KW_UNSET50=(Token)match(input,KW_UNSET,FOLLOW_KW_UNSET_in_alterResourcePlanStatement699);  
					stream_KW_UNSET.add(KW_UNSET50);

					pushFollow(FOLLOW_rpUnassignList_in_alterResourcePlanStatement701);
					rpUnassignList51=rpUnassignList();
					state._fsp--;

					stream_rpUnassignList.add(rpUnassignList51.getTree());
					// AST REWRITE
					// elements: rpUnassignList, name
					// token labels: 
					// rule labels: name, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_name=new RewriteRuleSubtreeStream(adaptor,"rule name",name!=null?name.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 117:36: -> ^( TOK_ALTER_RP $name rpUnassignList )
					{
						// ResourcePlanParser.g:117:39: ^( TOK_ALTER_RP $name rpUnassignList )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ALTER_RP, "TOK_ALTER_RP"), root_1);
						adaptor.addChild(root_1, stream_name.nextTree());
						adaptor.addChild(root_1, stream_rpUnassignList.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}

					}
					break;
				case 5 :
					// ResourcePlanParser.g:118:11: ( KW_RENAME KW_TO newName= identifier -> ^( TOK_ALTER_RP $name ^( TOK_RENAME $newName) ) )
					{
					// ResourcePlanParser.g:118:11: ( KW_RENAME KW_TO newName= identifier -> ^( TOK_ALTER_RP $name ^( TOK_RENAME $newName) ) )
					// ResourcePlanParser.g:118:12: KW_RENAME KW_TO newName= identifier
					{
					KW_RENAME52=(Token)match(input,KW_RENAME,FOLLOW_KW_RENAME_in_alterResourcePlanStatement726);  
					stream_KW_RENAME.add(KW_RENAME52);

					KW_TO53=(Token)match(input,KW_TO,FOLLOW_KW_TO_in_alterResourcePlanStatement728);  
					stream_KW_TO.add(KW_TO53);

					pushFollow(FOLLOW_identifier_in_alterResourcePlanStatement732);
					newName=gHiveParser.identifier();
					state._fsp--;

					stream_identifier.add(newName.getTree());
					// AST REWRITE
					// elements: name, newName
					// token labels: 
					// rule labels: newName, name, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_newName=new RewriteRuleSubtreeStream(adaptor,"rule newName",newName!=null?newName.getTree():null);
					RewriteRuleSubtreeStream stream_name=new RewriteRuleSubtreeStream(adaptor,"rule name",name!=null?name.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 118:47: -> ^( TOK_ALTER_RP $name ^( TOK_RENAME $newName) )
					{
						// ResourcePlanParser.g:118:50: ^( TOK_ALTER_RP $name ^( TOK_RENAME $newName) )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ALTER_RP, "TOK_ALTER_RP"), root_1);
						adaptor.addChild(root_1, stream_name.nextTree());
						// ResourcePlanParser.g:118:71: ^( TOK_RENAME $newName)
						{
						ASTNode root_2 = (ASTNode)adaptor.nil();
						root_2 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_RENAME, "TOK_RENAME"), root_2);
						adaptor.addChild(root_2, stream_newName.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}

					}
					break;
				case 6 :
					// ResourcePlanParser.g:119:11: ( ( activate ( enable )? | enable ( activate )? ) -> ^( TOK_ALTER_RP $name ( activate )? ( enable )? ) )
					{
					// ResourcePlanParser.g:119:11: ( ( activate ( enable )? | enable ( activate )? ) -> ^( TOK_ALTER_RP $name ( activate )? ( enable )? ) )
					// ResourcePlanParser.g:119:12: ( activate ( enable )? | enable ( activate )? )
					{
					// ResourcePlanParser.g:119:12: ( activate ( enable )? | enable ( activate )? )
					int alt11=2;
					int LA11_0 = input.LA(1);
					if ( (LA11_0==KW_ACTIVATE) ) {
						alt11=1;
					}
					else if ( (LA11_0==KW_ENABLE) ) {
						alt11=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 11, 0, input);
						throw nvae;
					}

					switch (alt11) {
						case 1 :
							// ResourcePlanParser.g:119:13: activate ( enable )?
							{
							pushFollow(FOLLOW_activate_in_alterResourcePlanStatement763);
							activate54=activate();
							state._fsp--;

							stream_activate.add(activate54.getTree());
							// ResourcePlanParser.g:119:22: ( enable )?
							int alt9=2;
							int LA9_0 = input.LA(1);
							if ( (LA9_0==KW_ENABLE) ) {
								alt9=1;
							}
							switch (alt9) {
								case 1 :
									// ResourcePlanParser.g:119:22: enable
									{
									pushFollow(FOLLOW_enable_in_alterResourcePlanStatement765);
									enable55=enable();
									state._fsp--;

									stream_enable.add(enable55.getTree());
									}
									break;

							}

							}
							break;
						case 2 :
							// ResourcePlanParser.g:119:32: enable ( activate )?
							{
							pushFollow(FOLLOW_enable_in_alterResourcePlanStatement770);
							enable56=enable();
							state._fsp--;

							stream_enable.add(enable56.getTree());
							// ResourcePlanParser.g:119:39: ( activate )?
							int alt10=2;
							int LA10_0 = input.LA(1);
							if ( (LA10_0==KW_ACTIVATE) ) {
								alt10=1;
							}
							switch (alt10) {
								case 1 :
									// ResourcePlanParser.g:119:39: activate
									{
									pushFollow(FOLLOW_activate_in_alterResourcePlanStatement772);
									activate57=activate();
									state._fsp--;

									stream_activate.add(activate57.getTree());
									}
									break;

							}

							}
							break;

					}

					// AST REWRITE
					// elements: activate, name, enable
					// token labels: 
					// rule labels: name, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_name=new RewriteRuleSubtreeStream(adaptor,"rule name",name!=null?name.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 119:50: -> ^( TOK_ALTER_RP $name ( activate )? ( enable )? )
					{
						// ResourcePlanParser.g:119:53: ^( TOK_ALTER_RP $name ( activate )? ( enable )? )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ALTER_RP, "TOK_ALTER_RP"), root_1);
						adaptor.addChild(root_1, stream_name.nextTree());
						// ResourcePlanParser.g:119:74: ( activate )?
						if ( stream_activate.hasNext() ) {
							adaptor.addChild(root_1, stream_activate.nextTree());
						}
						stream_activate.reset();

						// ResourcePlanParser.g:119:84: ( enable )?
						if ( stream_enable.hasNext() ) {
							adaptor.addChild(root_1, stream_enable.nextTree());
						}
						stream_enable.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "alterResourcePlanStatement"


	public static class globalWmStatement_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "globalWmStatement"
	// ResourcePlanParser.g:125:1: globalWmStatement : ( enable | disable ) KW_WORKLOAD KW_MANAGEMENT -> ^( TOK_ALTER_RP ( enable )? ( disable )? ) ;
	public final HiveParser_ResourcePlanParser.globalWmStatement_return globalWmStatement() throws RecognitionException {
		HiveParser_ResourcePlanParser.globalWmStatement_return retval = new HiveParser_ResourcePlanParser.globalWmStatement_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_WORKLOAD60=null;
		Token KW_MANAGEMENT61=null;
		ParserRuleReturnScope enable58 =null;
		ParserRuleReturnScope disable59 =null;

		ASTNode KW_WORKLOAD60_tree=null;
		ASTNode KW_MANAGEMENT61_tree=null;
		RewriteRuleTokenStream stream_KW_WORKLOAD=new RewriteRuleTokenStream(adaptor,"token KW_WORKLOAD");
		RewriteRuleTokenStream stream_KW_MANAGEMENT=new RewriteRuleTokenStream(adaptor,"token KW_MANAGEMENT");
		RewriteRuleSubtreeStream stream_enable=new RewriteRuleSubtreeStream(adaptor,"rule enable");
		RewriteRuleSubtreeStream stream_disable=new RewriteRuleSubtreeStream(adaptor,"rule disable");

		 gParent.pushMsg("global WM statement", state); 
		try {
			// ResourcePlanParser.g:128:5: ( ( enable | disable ) KW_WORKLOAD KW_MANAGEMENT -> ^( TOK_ALTER_RP ( enable )? ( disable )? ) )
			// ResourcePlanParser.g:128:7: ( enable | disable ) KW_WORKLOAD KW_MANAGEMENT
			{
			// ResourcePlanParser.g:128:7: ( enable | disable )
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==KW_ENABLE) ) {
				alt13=1;
			}
			else if ( (LA13_0==KW_DISABLE) ) {
				alt13=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// ResourcePlanParser.g:128:8: enable
					{
					pushFollow(FOLLOW_enable_in_globalWmStatement828);
					enable58=enable();
					state._fsp--;

					stream_enable.add(enable58.getTree());
					}
					break;
				case 2 :
					// ResourcePlanParser.g:128:17: disable
					{
					pushFollow(FOLLOW_disable_in_globalWmStatement832);
					disable59=disable();
					state._fsp--;

					stream_disable.add(disable59.getTree());
					}
					break;

			}

			KW_WORKLOAD60=(Token)match(input,KW_WORKLOAD,FOLLOW_KW_WORKLOAD_in_globalWmStatement835);  
			stream_KW_WORKLOAD.add(KW_WORKLOAD60);

			KW_MANAGEMENT61=(Token)match(input,KW_MANAGEMENT,FOLLOW_KW_MANAGEMENT_in_globalWmStatement837);  
			stream_KW_MANAGEMENT.add(KW_MANAGEMENT61);

			// AST REWRITE
			// elements: disable, enable
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 128:52: -> ^( TOK_ALTER_RP ( enable )? ( disable )? )
			{
				// ResourcePlanParser.g:128:55: ^( TOK_ALTER_RP ( enable )? ( disable )? )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ALTER_RP, "TOK_ALTER_RP"), root_1);
				// ResourcePlanParser.g:128:70: ( enable )?
				if ( stream_enable.hasNext() ) {
					adaptor.addChild(root_1, stream_enable.nextTree());
				}
				stream_enable.reset();

				// ResourcePlanParser.g:128:78: ( disable )?
				if ( stream_disable.hasNext() ) {
					adaptor.addChild(root_1, stream_disable.nextTree());
				}
				stream_disable.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "globalWmStatement"


	public static class replaceResourcePlanStatement_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "replaceResourcePlanStatement"
	// ResourcePlanParser.g:131:1: replaceResourcePlanStatement : KW_REPLACE ( ( KW_ACTIVE KW_RESOURCE KW_PLAN KW_WITH src= identifier -> ^( TOK_ALTER_RP $src TOK_REPLACE ) ) | ( KW_RESOURCE KW_PLAN dest= identifier KW_WITH src= identifier -> ^( TOK_ALTER_RP $src ^( TOK_REPLACE $dest) ) ) ) ;
	public final HiveParser_ResourcePlanParser.replaceResourcePlanStatement_return replaceResourcePlanStatement() throws RecognitionException {
		HiveParser_ResourcePlanParser.replaceResourcePlanStatement_return retval = new HiveParser_ResourcePlanParser.replaceResourcePlanStatement_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_REPLACE62=null;
		Token KW_ACTIVE63=null;
		Token KW_RESOURCE64=null;
		Token KW_PLAN65=null;
		Token KW_WITH66=null;
		Token KW_RESOURCE67=null;
		Token KW_PLAN68=null;
		Token KW_WITH69=null;
		ParserRuleReturnScope src =null;
		ParserRuleReturnScope dest =null;

		ASTNode KW_REPLACE62_tree=null;
		ASTNode KW_ACTIVE63_tree=null;
		ASTNode KW_RESOURCE64_tree=null;
		ASTNode KW_PLAN65_tree=null;
		ASTNode KW_WITH66_tree=null;
		ASTNode KW_RESOURCE67_tree=null;
		ASTNode KW_PLAN68_tree=null;
		ASTNode KW_WITH69_tree=null;
		RewriteRuleTokenStream stream_KW_PLAN=new RewriteRuleTokenStream(adaptor,"token KW_PLAN");
		RewriteRuleTokenStream stream_KW_WITH=new RewriteRuleTokenStream(adaptor,"token KW_WITH");
		RewriteRuleTokenStream stream_KW_REPLACE=new RewriteRuleTokenStream(adaptor,"token KW_REPLACE");
		RewriteRuleTokenStream stream_KW_ACTIVE=new RewriteRuleTokenStream(adaptor,"token KW_ACTIVE");
		RewriteRuleTokenStream stream_KW_RESOURCE=new RewriteRuleTokenStream(adaptor,"token KW_RESOURCE");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");

		 gParent.pushMsg("replace resource plan statement", state); 
		try {
			// ResourcePlanParser.g:134:5: ( KW_REPLACE ( ( KW_ACTIVE KW_RESOURCE KW_PLAN KW_WITH src= identifier -> ^( TOK_ALTER_RP $src TOK_REPLACE ) ) | ( KW_RESOURCE KW_PLAN dest= identifier KW_WITH src= identifier -> ^( TOK_ALTER_RP $src ^( TOK_REPLACE $dest) ) ) ) )
			// ResourcePlanParser.g:134:7: KW_REPLACE ( ( KW_ACTIVE KW_RESOURCE KW_PLAN KW_WITH src= identifier -> ^( TOK_ALTER_RP $src TOK_REPLACE ) ) | ( KW_RESOURCE KW_PLAN dest= identifier KW_WITH src= identifier -> ^( TOK_ALTER_RP $src ^( TOK_REPLACE $dest) ) ) )
			{
			KW_REPLACE62=(Token)match(input,KW_REPLACE,FOLLOW_KW_REPLACE_in_replaceResourcePlanStatement876);  
			stream_KW_REPLACE.add(KW_REPLACE62);

			// ResourcePlanParser.g:134:18: ( ( KW_ACTIVE KW_RESOURCE KW_PLAN KW_WITH src= identifier -> ^( TOK_ALTER_RP $src TOK_REPLACE ) ) | ( KW_RESOURCE KW_PLAN dest= identifier KW_WITH src= identifier -> ^( TOK_ALTER_RP $src ^( TOK_REPLACE $dest) ) ) )
			int alt14=2;
			int LA14_0 = input.LA(1);
			if ( (LA14_0==KW_ACTIVE) ) {
				alt14=1;
			}
			else if ( (LA14_0==KW_RESOURCE) ) {
				alt14=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}

			switch (alt14) {
				case 1 :
					// ResourcePlanParser.g:135:11: ( KW_ACTIVE KW_RESOURCE KW_PLAN KW_WITH src= identifier -> ^( TOK_ALTER_RP $src TOK_REPLACE ) )
					{
					// ResourcePlanParser.g:135:11: ( KW_ACTIVE KW_RESOURCE KW_PLAN KW_WITH src= identifier -> ^( TOK_ALTER_RP $src TOK_REPLACE ) )
					// ResourcePlanParser.g:135:12: KW_ACTIVE KW_RESOURCE KW_PLAN KW_WITH src= identifier
					{
					KW_ACTIVE63=(Token)match(input,KW_ACTIVE,FOLLOW_KW_ACTIVE_in_replaceResourcePlanStatement891);  
					stream_KW_ACTIVE.add(KW_ACTIVE63);

					KW_RESOURCE64=(Token)match(input,KW_RESOURCE,FOLLOW_KW_RESOURCE_in_replaceResourcePlanStatement893);  
					stream_KW_RESOURCE.add(KW_RESOURCE64);

					KW_PLAN65=(Token)match(input,KW_PLAN,FOLLOW_KW_PLAN_in_replaceResourcePlanStatement895);  
					stream_KW_PLAN.add(KW_PLAN65);

					KW_WITH66=(Token)match(input,KW_WITH,FOLLOW_KW_WITH_in_replaceResourcePlanStatement897);  
					stream_KW_WITH.add(KW_WITH66);

					pushFollow(FOLLOW_identifier_in_replaceResourcePlanStatement901);
					src=gHiveParser.identifier();
					state._fsp--;

					stream_identifier.add(src.getTree());
					// AST REWRITE
					// elements: src
					// token labels: 
					// rule labels: src, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_src=new RewriteRuleSubtreeStream(adaptor,"rule src",src!=null?src.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 135:65: -> ^( TOK_ALTER_RP $src TOK_REPLACE )
					{
						// ResourcePlanParser.g:135:68: ^( TOK_ALTER_RP $src TOK_REPLACE )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ALTER_RP, "TOK_ALTER_RP"), root_1);
						adaptor.addChild(root_1, stream_src.nextTree());
						adaptor.addChild(root_1, (ASTNode)adaptor.create(TOK_REPLACE, "TOK_REPLACE"));
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}

					}
					break;
				case 2 :
					// ResourcePlanParser.g:136:11: ( KW_RESOURCE KW_PLAN dest= identifier KW_WITH src= identifier -> ^( TOK_ALTER_RP $src ^( TOK_REPLACE $dest) ) )
					{
					// ResourcePlanParser.g:136:11: ( KW_RESOURCE KW_PLAN dest= identifier KW_WITH src= identifier -> ^( TOK_ALTER_RP $src ^( TOK_REPLACE $dest) ) )
					// ResourcePlanParser.g:136:12: KW_RESOURCE KW_PLAN dest= identifier KW_WITH src= identifier
					{
					KW_RESOURCE67=(Token)match(input,KW_RESOURCE,FOLLOW_KW_RESOURCE_in_replaceResourcePlanStatement926);  
					stream_KW_RESOURCE.add(KW_RESOURCE67);

					KW_PLAN68=(Token)match(input,KW_PLAN,FOLLOW_KW_PLAN_in_replaceResourcePlanStatement928);  
					stream_KW_PLAN.add(KW_PLAN68);

					pushFollow(FOLLOW_identifier_in_replaceResourcePlanStatement932);
					dest=gHiveParser.identifier();
					state._fsp--;

					stream_identifier.add(dest.getTree());
					KW_WITH69=(Token)match(input,KW_WITH,FOLLOW_KW_WITH_in_replaceResourcePlanStatement934);  
					stream_KW_WITH.add(KW_WITH69);

					pushFollow(FOLLOW_identifier_in_replaceResourcePlanStatement938);
					src=gHiveParser.identifier();
					state._fsp--;

					stream_identifier.add(src.getTree());
					// AST REWRITE
					// elements: src, dest
					// token labels: 
					// rule labels: src, dest, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_src=new RewriteRuleSubtreeStream(adaptor,"rule src",src!=null?src.getTree():null);
					RewriteRuleSubtreeStream stream_dest=new RewriteRuleSubtreeStream(adaptor,"rule dest",dest!=null?dest.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 136:71: -> ^( TOK_ALTER_RP $src ^( TOK_REPLACE $dest) )
					{
						// ResourcePlanParser.g:136:74: ^( TOK_ALTER_RP $src ^( TOK_REPLACE $dest) )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ALTER_RP, "TOK_ALTER_RP"), root_1);
						adaptor.addChild(root_1, stream_src.nextTree());
						// ResourcePlanParser.g:136:94: ^( TOK_REPLACE $dest)
						{
						ASTNode root_2 = (ASTNode)adaptor.nil();
						root_2 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_REPLACE, "TOK_REPLACE"), root_2);
						adaptor.addChild(root_2, stream_dest.nextTree());
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

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "replaceResourcePlanStatement"


	public static class dropResourcePlanStatement_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "dropResourcePlanStatement"
	// ResourcePlanParser.g:140:1: dropResourcePlanStatement : KW_DROP KW_RESOURCE KW_PLAN name= identifier -> ^( TOK_DROP_RP $name) ;
	public final HiveParser_ResourcePlanParser.dropResourcePlanStatement_return dropResourcePlanStatement() throws RecognitionException {
		HiveParser_ResourcePlanParser.dropResourcePlanStatement_return retval = new HiveParser_ResourcePlanParser.dropResourcePlanStatement_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_DROP70=null;
		Token KW_RESOURCE71=null;
		Token KW_PLAN72=null;
		ParserRuleReturnScope name =null;

		ASTNode KW_DROP70_tree=null;
		ASTNode KW_RESOURCE71_tree=null;
		ASTNode KW_PLAN72_tree=null;
		RewriteRuleTokenStream stream_KW_DROP=new RewriteRuleTokenStream(adaptor,"token KW_DROP");
		RewriteRuleTokenStream stream_KW_PLAN=new RewriteRuleTokenStream(adaptor,"token KW_PLAN");
		RewriteRuleTokenStream stream_KW_RESOURCE=new RewriteRuleTokenStream(adaptor,"token KW_RESOURCE");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");

		 gParent.pushMsg("drop resource plan statement", state); 
		try {
			// ResourcePlanParser.g:143:5: ( KW_DROP KW_RESOURCE KW_PLAN name= identifier -> ^( TOK_DROP_RP $name) )
			// ResourcePlanParser.g:143:7: KW_DROP KW_RESOURCE KW_PLAN name= identifier
			{
			KW_DROP70=(Token)match(input,KW_DROP,FOLLOW_KW_DROP_in_dropResourcePlanStatement990);  
			stream_KW_DROP.add(KW_DROP70);

			KW_RESOURCE71=(Token)match(input,KW_RESOURCE,FOLLOW_KW_RESOURCE_in_dropResourcePlanStatement992);  
			stream_KW_RESOURCE.add(KW_RESOURCE71);

			KW_PLAN72=(Token)match(input,KW_PLAN,FOLLOW_KW_PLAN_in_dropResourcePlanStatement994);  
			stream_KW_PLAN.add(KW_PLAN72);

			pushFollow(FOLLOW_identifier_in_dropResourcePlanStatement998);
			name=gHiveParser.identifier();
			state._fsp--;

			stream_identifier.add(name.getTree());
			// AST REWRITE
			// elements: name
			// token labels: 
			// rule labels: name, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_name=new RewriteRuleSubtreeStream(adaptor,"rule name",name!=null?name.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 143:51: -> ^( TOK_DROP_RP $name)
			{
				// ResourcePlanParser.g:143:54: ^( TOK_DROP_RP $name)
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_DROP_RP, "TOK_DROP_RP"), root_1);
				adaptor.addChild(root_1, stream_name.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "dropResourcePlanStatement"


	public static class poolPath_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "poolPath"
	// ResourcePlanParser.g:146:1: poolPath : identifier ^ ( DOT identifier )* ;
	public final HiveParser_ResourcePlanParser.poolPath_return poolPath() throws RecognitionException {
		HiveParser_ResourcePlanParser.poolPath_return retval = new HiveParser_ResourcePlanParser.poolPath_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token DOT74=null;
		ParserRuleReturnScope identifier73 =null;
		ParserRuleReturnScope identifier75 =null;

		ASTNode DOT74_tree=null;

		 gParent.pushMsg("poolPath", state); 
		try {
			// ResourcePlanParser.g:149:5: ( identifier ^ ( DOT identifier )* )
			// ResourcePlanParser.g:149:7: identifier ^ ( DOT identifier )*
			{
			root_0 = (ASTNode)adaptor.nil();


			pushFollow(FOLLOW_identifier_in_poolPath1034);
			identifier73=gHiveParser.identifier();
			state._fsp--;

			root_0 = (ASTNode)adaptor.becomeRoot(identifier73.getTree(), root_0);
			// ResourcePlanParser.g:149:19: ( DOT identifier )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==DOT) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// ResourcePlanParser.g:149:20: DOT identifier
					{
					DOT74=(Token)match(input,DOT,FOLLOW_DOT_in_poolPath1038); 
					DOT74_tree = (ASTNode)adaptor.create(DOT74);
					adaptor.addChild(root_0, DOT74_tree);

					pushFollow(FOLLOW_identifier_in_poolPath1040);
					identifier75=gHiveParser.identifier();
					state._fsp--;

					adaptor.addChild(root_0, identifier75.getTree());

					}
					break;

				default :
					break loop15;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "poolPath"


	public static class triggerExpression_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "triggerExpression"
	// ResourcePlanParser.g:152:1: triggerExpression : triggerAtomExpression -> ^( TOK_TRIGGER_EXPRESSION triggerAtomExpression ) ;
	public final HiveParser_ResourcePlanParser.triggerExpression_return triggerExpression() throws RecognitionException {
		HiveParser_ResourcePlanParser.triggerExpression_return retval = new HiveParser_ResourcePlanParser.triggerExpression_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		ParserRuleReturnScope triggerAtomExpression76 =null;

		RewriteRuleSubtreeStream stream_triggerAtomExpression=new RewriteRuleSubtreeStream(adaptor,"rule triggerAtomExpression");

		 gParent.pushMsg("triggerExpression", state); 
		try {
			// ResourcePlanParser.g:155:5: ( triggerAtomExpression -> ^( TOK_TRIGGER_EXPRESSION triggerAtomExpression ) )
			// ResourcePlanParser.g:155:7: triggerAtomExpression
			{
			pushFollow(FOLLOW_triggerAtomExpression_in_triggerExpression1069);
			triggerAtomExpression76=triggerAtomExpression();
			state._fsp--;

			stream_triggerAtomExpression.add(triggerAtomExpression76.getTree());
			// AST REWRITE
			// elements: triggerAtomExpression
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 155:29: -> ^( TOK_TRIGGER_EXPRESSION triggerAtomExpression )
			{
				// ResourcePlanParser.g:155:32: ^( TOK_TRIGGER_EXPRESSION triggerAtomExpression )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_TRIGGER_EXPRESSION, "TOK_TRIGGER_EXPRESSION"), root_1);
				adaptor.addChild(root_1, stream_triggerAtomExpression.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "triggerExpression"


	public static class triggerExpressionStandalone_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "triggerExpressionStandalone"
	// ResourcePlanParser.g:158:1: triggerExpressionStandalone : triggerExpression EOF ;
	public final HiveParser_ResourcePlanParser.triggerExpressionStandalone_return triggerExpressionStandalone() throws RecognitionException {
		HiveParser_ResourcePlanParser.triggerExpressionStandalone_return retval = new HiveParser_ResourcePlanParser.triggerExpressionStandalone_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token EOF78=null;
		ParserRuleReturnScope triggerExpression77 =null;

		ASTNode EOF78_tree=null;

		try {
			// ResourcePlanParser.g:158:29: ( triggerExpression EOF )
			// ResourcePlanParser.g:158:31: triggerExpression EOF
			{
			root_0 = (ASTNode)adaptor.nil();


			pushFollow(FOLLOW_triggerExpression_in_triggerExpressionStandalone1090);
			triggerExpression77=triggerExpression();
			state._fsp--;

			adaptor.addChild(root_0, triggerExpression77.getTree());

			EOF78=(Token)match(input,EOF,FOLLOW_EOF_in_triggerExpressionStandalone1092); 
			EOF78_tree = (ASTNode)adaptor.create(EOF78);
			adaptor.addChild(root_0, EOF78_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "triggerExpressionStandalone"


	public static class triggerOrExpression_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "triggerOrExpression"
	// ResourcePlanParser.g:164:1: triggerOrExpression : triggerAndExpression ( KW_OR triggerAndExpression )* ;
	public final HiveParser_ResourcePlanParser.triggerOrExpression_return triggerOrExpression() throws RecognitionException {
		HiveParser_ResourcePlanParser.triggerOrExpression_return retval = new HiveParser_ResourcePlanParser.triggerOrExpression_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_OR80=null;
		ParserRuleReturnScope triggerAndExpression79 =null;
		ParserRuleReturnScope triggerAndExpression81 =null;

		ASTNode KW_OR80_tree=null;

		 gParent.pushMsg("triggerOrExpression", state); 
		try {
			// ResourcePlanParser.g:167:5: ( triggerAndExpression ( KW_OR triggerAndExpression )* )
			// ResourcePlanParser.g:167:7: triggerAndExpression ( KW_OR triggerAndExpression )*
			{
			root_0 = (ASTNode)adaptor.nil();


			pushFollow(FOLLOW_triggerAndExpression_in_triggerOrExpression1117);
			triggerAndExpression79=triggerAndExpression();
			state._fsp--;

			adaptor.addChild(root_0, triggerAndExpression79.getTree());

			// ResourcePlanParser.g:167:28: ( KW_OR triggerAndExpression )*
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==KW_OR) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// ResourcePlanParser.g:167:29: KW_OR triggerAndExpression
					{
					KW_OR80=(Token)match(input,KW_OR,FOLLOW_KW_OR_in_triggerOrExpression1120); 
					KW_OR80_tree = (ASTNode)adaptor.create(KW_OR80);
					adaptor.addChild(root_0, KW_OR80_tree);

					pushFollow(FOLLOW_triggerAndExpression_in_triggerOrExpression1122);
					triggerAndExpression81=triggerAndExpression();
					state._fsp--;

					adaptor.addChild(root_0, triggerAndExpression81.getTree());

					}
					break;

				default :
					break loop16;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "triggerOrExpression"


	public static class triggerAndExpression_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "triggerAndExpression"
	// ResourcePlanParser.g:170:1: triggerAndExpression : triggerAtomExpression ( KW_AND triggerAtomExpression )* ;
	public final HiveParser_ResourcePlanParser.triggerAndExpression_return triggerAndExpression() throws RecognitionException {
		HiveParser_ResourcePlanParser.triggerAndExpression_return retval = new HiveParser_ResourcePlanParser.triggerAndExpression_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_AND83=null;
		ParserRuleReturnScope triggerAtomExpression82 =null;
		ParserRuleReturnScope triggerAtomExpression84 =null;

		ASTNode KW_AND83_tree=null;

		 gParent.pushMsg("triggerAndExpression", state); 
		try {
			// ResourcePlanParser.g:173:5: ( triggerAtomExpression ( KW_AND triggerAtomExpression )* )
			// ResourcePlanParser.g:173:7: triggerAtomExpression ( KW_AND triggerAtomExpression )*
			{
			root_0 = (ASTNode)adaptor.nil();


			pushFollow(FOLLOW_triggerAtomExpression_in_triggerAndExpression1151);
			triggerAtomExpression82=triggerAtomExpression();
			state._fsp--;

			adaptor.addChild(root_0, triggerAtomExpression82.getTree());

			// ResourcePlanParser.g:173:29: ( KW_AND triggerAtomExpression )*
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==KW_AND) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// ResourcePlanParser.g:173:30: KW_AND triggerAtomExpression
					{
					KW_AND83=(Token)match(input,KW_AND,FOLLOW_KW_AND_in_triggerAndExpression1154); 
					KW_AND83_tree = (ASTNode)adaptor.create(KW_AND83);
					adaptor.addChild(root_0, KW_AND83_tree);

					pushFollow(FOLLOW_triggerAtomExpression_in_triggerAndExpression1156);
					triggerAtomExpression84=triggerAtomExpression();
					state._fsp--;

					adaptor.addChild(root_0, triggerAtomExpression84.getTree());

					}
					break;

				default :
					break loop17;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "triggerAndExpression"


	public static class triggerAtomExpression_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "triggerAtomExpression"
	// ResourcePlanParser.g:176:1: triggerAtomExpression : identifier comparisionOperator triggerLiteral ;
	public final HiveParser_ResourcePlanParser.triggerAtomExpression_return triggerAtomExpression() throws RecognitionException {
		HiveParser_ResourcePlanParser.triggerAtomExpression_return retval = new HiveParser_ResourcePlanParser.triggerAtomExpression_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		ParserRuleReturnScope identifier85 =null;
		ParserRuleReturnScope comparisionOperator86 =null;
		ParserRuleReturnScope triggerLiteral87 =null;


		 gParent.pushMsg("triggerAtomExpression", state); 
		try {
			// ResourcePlanParser.g:179:5: ( identifier comparisionOperator triggerLiteral )
			// ResourcePlanParser.g:179:7: identifier comparisionOperator triggerLiteral
			{
			root_0 = (ASTNode)adaptor.nil();


			pushFollow(FOLLOW_identifier_in_triggerAtomExpression1185);
			identifier85=gHiveParser.identifier();
			state._fsp--;

			adaptor.addChild(root_0, identifier85.getTree());

			pushFollow(FOLLOW_comparisionOperator_in_triggerAtomExpression1187);
			comparisionOperator86=comparisionOperator();
			state._fsp--;

			adaptor.addChild(root_0, comparisionOperator86.getTree());

			pushFollow(FOLLOW_triggerLiteral_in_triggerAtomExpression1189);
			triggerLiteral87=triggerLiteral();
			state._fsp--;

			adaptor.addChild(root_0, triggerLiteral87.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "triggerAtomExpression"


	public static class triggerLiteral_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "triggerLiteral"
	// ResourcePlanParser.g:183:1: triggerLiteral : ( Number | StringLiteral );
	public final HiveParser_ResourcePlanParser.triggerLiteral_return triggerLiteral() throws RecognitionException {
		HiveParser_ResourcePlanParser.triggerLiteral_return retval = new HiveParser_ResourcePlanParser.triggerLiteral_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token set88=null;

		ASTNode set88_tree=null;

		 gParent.pushMsg("triggerLiteral", state); 
		try {
			// ResourcePlanParser.g:186:5: ( Number | StringLiteral )
			// ResourcePlanParser.g:
			{
			root_0 = (ASTNode)adaptor.nil();


			set88=input.LT(1);
			if ( input.LA(1)==Number||input.LA(1)==StringLiteral ) {
				input.consume();
				adaptor.addChild(root_0, (ASTNode)adaptor.create(set88));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "triggerLiteral"


	public static class comparisionOperator_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "comparisionOperator"
	// ResourcePlanParser.g:190:1: comparisionOperator : GREATERTHAN ;
	public final HiveParser_ResourcePlanParser.comparisionOperator_return comparisionOperator() throws RecognitionException {
		HiveParser_ResourcePlanParser.comparisionOperator_return retval = new HiveParser_ResourcePlanParser.comparisionOperator_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token GREATERTHAN89=null;

		ASTNode GREATERTHAN89_tree=null;

		 gParent.pushMsg("comparisionOperator", state); 
		try {
			// ResourcePlanParser.g:193:5: ( GREATERTHAN )
			// ResourcePlanParser.g:193:7: GREATERTHAN
			{
			root_0 = (ASTNode)adaptor.nil();


			GREATERTHAN89=(Token)match(input,GREATERTHAN,FOLLOW_GREATERTHAN_in_comparisionOperator1252); 
			GREATERTHAN89_tree = (ASTNode)adaptor.create(GREATERTHAN89);
			adaptor.addChild(root_0, GREATERTHAN89_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "comparisionOperator"


	public static class triggerActionExpression_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "triggerActionExpression"
	// ResourcePlanParser.g:196:1: triggerActionExpression : ( KW_KILL | ( KW_MOVE ^ KW_TO ! poolPath ) );
	public final HiveParser_ResourcePlanParser.triggerActionExpression_return triggerActionExpression() throws RecognitionException {
		HiveParser_ResourcePlanParser.triggerActionExpression_return retval = new HiveParser_ResourcePlanParser.triggerActionExpression_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_KILL90=null;
		Token KW_MOVE91=null;
		Token KW_TO92=null;
		ParserRuleReturnScope poolPath93 =null;

		ASTNode KW_KILL90_tree=null;
		ASTNode KW_MOVE91_tree=null;
		ASTNode KW_TO92_tree=null;

		 gParent.pushMsg("triggerActionExpression", state); 
		try {
			// ResourcePlanParser.g:199:5: ( KW_KILL | ( KW_MOVE ^ KW_TO ! poolPath ) )
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==KW_KILL) ) {
				alt18=1;
			}
			else if ( (LA18_0==KW_MOVE) ) {
				alt18=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}

			switch (alt18) {
				case 1 :
					// ResourcePlanParser.g:199:7: KW_KILL
					{
					root_0 = (ASTNode)adaptor.nil();


					KW_KILL90=(Token)match(input,KW_KILL,FOLLOW_KW_KILL_in_triggerActionExpression1279); 
					KW_KILL90_tree = (ASTNode)adaptor.create(KW_KILL90);
					adaptor.addChild(root_0, KW_KILL90_tree);

					}
					break;
				case 2 :
					// ResourcePlanParser.g:200:7: ( KW_MOVE ^ KW_TO ! poolPath )
					{
					root_0 = (ASTNode)adaptor.nil();


					// ResourcePlanParser.g:200:7: ( KW_MOVE ^ KW_TO ! poolPath )
					// ResourcePlanParser.g:200:8: KW_MOVE ^ KW_TO ! poolPath
					{
					KW_MOVE91=(Token)match(input,KW_MOVE,FOLLOW_KW_MOVE_in_triggerActionExpression1288); 
					KW_MOVE91_tree = (ASTNode)adaptor.create(KW_MOVE91);
					root_0 = (ASTNode)adaptor.becomeRoot(KW_MOVE91_tree, root_0);

					KW_TO92=(Token)match(input,KW_TO,FOLLOW_KW_TO_in_triggerActionExpression1291); 
					pushFollow(FOLLOW_poolPath_in_triggerActionExpression1294);
					poolPath93=poolPath();
					state._fsp--;

					adaptor.addChild(root_0, poolPath93.getTree());

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "triggerActionExpression"


	public static class triggerActionExpressionStandalone_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "triggerActionExpressionStandalone"
	// ResourcePlanParser.g:203:1: triggerActionExpressionStandalone : triggerActionExpression EOF ;
	public final HiveParser_ResourcePlanParser.triggerActionExpressionStandalone_return triggerActionExpressionStandalone() throws RecognitionException {
		HiveParser_ResourcePlanParser.triggerActionExpressionStandalone_return retval = new HiveParser_ResourcePlanParser.triggerActionExpressionStandalone_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token EOF95=null;
		ParserRuleReturnScope triggerActionExpression94 =null;

		ASTNode EOF95_tree=null;

		try {
			// ResourcePlanParser.g:203:35: ( triggerActionExpression EOF )
			// ResourcePlanParser.g:203:37: triggerActionExpression EOF
			{
			root_0 = (ASTNode)adaptor.nil();


			pushFollow(FOLLOW_triggerActionExpression_in_triggerActionExpressionStandalone1308);
			triggerActionExpression94=triggerActionExpression();
			state._fsp--;

			adaptor.addChild(root_0, triggerActionExpression94.getTree());

			EOF95=(Token)match(input,EOF,FOLLOW_EOF_in_triggerActionExpressionStandalone1310); 
			EOF95_tree = (ASTNode)adaptor.create(EOF95);
			adaptor.addChild(root_0, EOF95_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "triggerActionExpressionStandalone"


	public static class createTriggerStatement_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "createTriggerStatement"
	// ResourcePlanParser.g:205:1: createTriggerStatement : KW_CREATE KW_TRIGGER rpName= identifier DOT triggerName= identifier KW_WHEN triggerExpression KW_DO triggerActionExpression -> ^( TOK_CREATE_TRIGGER $rpName $triggerName triggerExpression triggerActionExpression ) ;
	public final HiveParser_ResourcePlanParser.createTriggerStatement_return createTriggerStatement() throws RecognitionException {
		HiveParser_ResourcePlanParser.createTriggerStatement_return retval = new HiveParser_ResourcePlanParser.createTriggerStatement_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_CREATE96=null;
		Token KW_TRIGGER97=null;
		Token DOT98=null;
		Token KW_WHEN99=null;
		Token KW_DO101=null;
		ParserRuleReturnScope rpName =null;
		ParserRuleReturnScope triggerName =null;
		ParserRuleReturnScope triggerExpression100 =null;
		ParserRuleReturnScope triggerActionExpression102 =null;

		ASTNode KW_CREATE96_tree=null;
		ASTNode KW_TRIGGER97_tree=null;
		ASTNode DOT98_tree=null;
		ASTNode KW_WHEN99_tree=null;
		ASTNode KW_DO101_tree=null;
		RewriteRuleTokenStream stream_KW_TRIGGER=new RewriteRuleTokenStream(adaptor,"token KW_TRIGGER");
		RewriteRuleTokenStream stream_KW_WHEN=new RewriteRuleTokenStream(adaptor,"token KW_WHEN");
		RewriteRuleTokenStream stream_KW_CREATE=new RewriteRuleTokenStream(adaptor,"token KW_CREATE");
		RewriteRuleTokenStream stream_KW_DO=new RewriteRuleTokenStream(adaptor,"token KW_DO");
		RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
		RewriteRuleSubtreeStream stream_triggerExpression=new RewriteRuleSubtreeStream(adaptor,"rule triggerExpression");
		RewriteRuleSubtreeStream stream_triggerActionExpression=new RewriteRuleSubtreeStream(adaptor,"rule triggerActionExpression");

		 gParent.pushMsg("create trigger statement", state); 
		try {
			// ResourcePlanParser.g:208:5: ( KW_CREATE KW_TRIGGER rpName= identifier DOT triggerName= identifier KW_WHEN triggerExpression KW_DO triggerActionExpression -> ^( TOK_CREATE_TRIGGER $rpName $triggerName triggerExpression triggerActionExpression ) )
			// ResourcePlanParser.g:208:7: KW_CREATE KW_TRIGGER rpName= identifier DOT triggerName= identifier KW_WHEN triggerExpression KW_DO triggerActionExpression
			{
			KW_CREATE96=(Token)match(input,KW_CREATE,FOLLOW_KW_CREATE_in_createTriggerStatement1333);  
			stream_KW_CREATE.add(KW_CREATE96);

			KW_TRIGGER97=(Token)match(input,KW_TRIGGER,FOLLOW_KW_TRIGGER_in_createTriggerStatement1335);  
			stream_KW_TRIGGER.add(KW_TRIGGER97);

			pushFollow(FOLLOW_identifier_in_createTriggerStatement1339);
			rpName=gHiveParser.identifier();
			state._fsp--;

			stream_identifier.add(rpName.getTree());
			DOT98=(Token)match(input,DOT,FOLLOW_DOT_in_createTriggerStatement1341);  
			stream_DOT.add(DOT98);

			pushFollow(FOLLOW_identifier_in_createTriggerStatement1345);
			triggerName=gHiveParser.identifier();
			state._fsp--;

			stream_identifier.add(triggerName.getTree());
			KW_WHEN99=(Token)match(input,KW_WHEN,FOLLOW_KW_WHEN_in_createTriggerStatement1353);  
			stream_KW_WHEN.add(KW_WHEN99);

			pushFollow(FOLLOW_triggerExpression_in_createTriggerStatement1355);
			triggerExpression100=triggerExpression();
			state._fsp--;

			stream_triggerExpression.add(triggerExpression100.getTree());
			KW_DO101=(Token)match(input,KW_DO,FOLLOW_KW_DO_in_createTriggerStatement1357);  
			stream_KW_DO.add(KW_DO101);

			pushFollow(FOLLOW_triggerActionExpression_in_createTriggerStatement1359);
			triggerActionExpression102=triggerActionExpression();
			state._fsp--;

			stream_triggerActionExpression.add(triggerActionExpression102.getTree());
			// AST REWRITE
			// elements: triggerExpression, rpName, triggerActionExpression, triggerName
			// token labels: 
			// rule labels: triggerName, rpName, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_triggerName=new RewriteRuleSubtreeStream(adaptor,"rule triggerName",triggerName!=null?triggerName.getTree():null);
			RewriteRuleSubtreeStream stream_rpName=new RewriteRuleSubtreeStream(adaptor,"rule rpName",rpName!=null?rpName.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 210:5: -> ^( TOK_CREATE_TRIGGER $rpName $triggerName triggerExpression triggerActionExpression )
			{
				// ResourcePlanParser.g:210:8: ^( TOK_CREATE_TRIGGER $rpName $triggerName triggerExpression triggerActionExpression )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_CREATE_TRIGGER, "TOK_CREATE_TRIGGER"), root_1);
				adaptor.addChild(root_1, stream_rpName.nextTree());
				adaptor.addChild(root_1, stream_triggerName.nextTree());
				adaptor.addChild(root_1, stream_triggerExpression.nextTree());
				adaptor.addChild(root_1, stream_triggerActionExpression.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "createTriggerStatement"


	public static class alterTriggerStatement_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "alterTriggerStatement"
	// ResourcePlanParser.g:213:1: alterTriggerStatement : KW_ALTER KW_TRIGGER rpName= identifier DOT triggerName= identifier ( ( KW_WHEN triggerExpression KW_DO triggerActionExpression -> ^( TOK_ALTER_TRIGGER $rpName $triggerName triggerExpression triggerActionExpression ) ) | ( KW_ADD KW_TO KW_POOL poolName= poolPath -> ^( TOK_ALTER_POOL $rpName $poolName ^( TOK_ADD_TRIGGER $triggerName) ) ) | ( KW_DROP KW_FROM KW_POOL poolName= poolPath -> ^( TOK_ALTER_POOL $rpName $poolName ^( TOK_DROP_TRIGGER $triggerName) ) ) | ( KW_ADD KW_TO KW_UNMANAGED -> ^( TOK_ALTER_POOL $rpName TOK_UNMANAGED ^( TOK_ADD_TRIGGER $triggerName) ) ) | ( KW_DROP KW_FROM KW_UNMANAGED -> ^( TOK_ALTER_POOL $rpName TOK_UNMANAGED ^( TOK_DROP_TRIGGER $triggerName) ) ) ) ;
	public final HiveParser_ResourcePlanParser.alterTriggerStatement_return alterTriggerStatement() throws RecognitionException {
		HiveParser_ResourcePlanParser.alterTriggerStatement_return retval = new HiveParser_ResourcePlanParser.alterTriggerStatement_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_ALTER103=null;
		Token KW_TRIGGER104=null;
		Token DOT105=null;
		Token KW_WHEN106=null;
		Token KW_DO108=null;
		Token KW_ADD110=null;
		Token KW_TO111=null;
		Token KW_POOL112=null;
		Token KW_DROP113=null;
		Token KW_FROM114=null;
		Token KW_POOL115=null;
		Token KW_ADD116=null;
		Token KW_TO117=null;
		Token KW_UNMANAGED118=null;
		Token KW_DROP119=null;
		Token KW_FROM120=null;
		Token KW_UNMANAGED121=null;
		ParserRuleReturnScope rpName =null;
		ParserRuleReturnScope triggerName =null;
		ParserRuleReturnScope poolName =null;
		ParserRuleReturnScope triggerExpression107 =null;
		ParserRuleReturnScope triggerActionExpression109 =null;

		ASTNode KW_ALTER103_tree=null;
		ASTNode KW_TRIGGER104_tree=null;
		ASTNode DOT105_tree=null;
		ASTNode KW_WHEN106_tree=null;
		ASTNode KW_DO108_tree=null;
		ASTNode KW_ADD110_tree=null;
		ASTNode KW_TO111_tree=null;
		ASTNode KW_POOL112_tree=null;
		ASTNode KW_DROP113_tree=null;
		ASTNode KW_FROM114_tree=null;
		ASTNode KW_POOL115_tree=null;
		ASTNode KW_ADD116_tree=null;
		ASTNode KW_TO117_tree=null;
		ASTNode KW_UNMANAGED118_tree=null;
		ASTNode KW_DROP119_tree=null;
		ASTNode KW_FROM120_tree=null;
		ASTNode KW_UNMANAGED121_tree=null;
		RewriteRuleTokenStream stream_KW_TRIGGER=new RewriteRuleTokenStream(adaptor,"token KW_TRIGGER");
		RewriteRuleTokenStream stream_KW_WHEN=new RewriteRuleTokenStream(adaptor,"token KW_WHEN");
		RewriteRuleTokenStream stream_KW_DROP=new RewriteRuleTokenStream(adaptor,"token KW_DROP");
		RewriteRuleTokenStream stream_KW_POOL=new RewriteRuleTokenStream(adaptor,"token KW_POOL");
		RewriteRuleTokenStream stream_KW_DO=new RewriteRuleTokenStream(adaptor,"token KW_DO");
		RewriteRuleTokenStream stream_KW_TO=new RewriteRuleTokenStream(adaptor,"token KW_TO");
		RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
		RewriteRuleTokenStream stream_KW_ALTER=new RewriteRuleTokenStream(adaptor,"token KW_ALTER");
		RewriteRuleTokenStream stream_KW_FROM=new RewriteRuleTokenStream(adaptor,"token KW_FROM");
		RewriteRuleTokenStream stream_KW_UNMANAGED=new RewriteRuleTokenStream(adaptor,"token KW_UNMANAGED");
		RewriteRuleTokenStream stream_KW_ADD=new RewriteRuleTokenStream(adaptor,"token KW_ADD");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
		RewriteRuleSubtreeStream stream_poolPath=new RewriteRuleSubtreeStream(adaptor,"rule poolPath");
		RewriteRuleSubtreeStream stream_triggerExpression=new RewriteRuleSubtreeStream(adaptor,"rule triggerExpression");
		RewriteRuleSubtreeStream stream_triggerActionExpression=new RewriteRuleSubtreeStream(adaptor,"rule triggerActionExpression");

		 gParent.pushMsg("alter trigger statement", state); 
		try {
			// ResourcePlanParser.g:216:5: ( KW_ALTER KW_TRIGGER rpName= identifier DOT triggerName= identifier ( ( KW_WHEN triggerExpression KW_DO triggerActionExpression -> ^( TOK_ALTER_TRIGGER $rpName $triggerName triggerExpression triggerActionExpression ) ) | ( KW_ADD KW_TO KW_POOL poolName= poolPath -> ^( TOK_ALTER_POOL $rpName $poolName ^( TOK_ADD_TRIGGER $triggerName) ) ) | ( KW_DROP KW_FROM KW_POOL poolName= poolPath -> ^( TOK_ALTER_POOL $rpName $poolName ^( TOK_DROP_TRIGGER $triggerName) ) ) | ( KW_ADD KW_TO KW_UNMANAGED -> ^( TOK_ALTER_POOL $rpName TOK_UNMANAGED ^( TOK_ADD_TRIGGER $triggerName) ) ) | ( KW_DROP KW_FROM KW_UNMANAGED -> ^( TOK_ALTER_POOL $rpName TOK_UNMANAGED ^( TOK_DROP_TRIGGER $triggerName) ) ) ) )
			// ResourcePlanParser.g:216:7: KW_ALTER KW_TRIGGER rpName= identifier DOT triggerName= identifier ( ( KW_WHEN triggerExpression KW_DO triggerActionExpression -> ^( TOK_ALTER_TRIGGER $rpName $triggerName triggerExpression triggerActionExpression ) ) | ( KW_ADD KW_TO KW_POOL poolName= poolPath -> ^( TOK_ALTER_POOL $rpName $poolName ^( TOK_ADD_TRIGGER $triggerName) ) ) | ( KW_DROP KW_FROM KW_POOL poolName= poolPath -> ^( TOK_ALTER_POOL $rpName $poolName ^( TOK_DROP_TRIGGER $triggerName) ) ) | ( KW_ADD KW_TO KW_UNMANAGED -> ^( TOK_ALTER_POOL $rpName TOK_UNMANAGED ^( TOK_ADD_TRIGGER $triggerName) ) ) | ( KW_DROP KW_FROM KW_UNMANAGED -> ^( TOK_ALTER_POOL $rpName TOK_UNMANAGED ^( TOK_DROP_TRIGGER $triggerName) ) ) )
			{
			KW_ALTER103=(Token)match(input,KW_ALTER,FOLLOW_KW_ALTER_in_alterTriggerStatement1406);  
			stream_KW_ALTER.add(KW_ALTER103);

			KW_TRIGGER104=(Token)match(input,KW_TRIGGER,FOLLOW_KW_TRIGGER_in_alterTriggerStatement1408);  
			stream_KW_TRIGGER.add(KW_TRIGGER104);

			pushFollow(FOLLOW_identifier_in_alterTriggerStatement1412);
			rpName=gHiveParser.identifier();
			state._fsp--;

			stream_identifier.add(rpName.getTree());
			DOT105=(Token)match(input,DOT,FOLLOW_DOT_in_alterTriggerStatement1414);  
			stream_DOT.add(DOT105);

			pushFollow(FOLLOW_identifier_in_alterTriggerStatement1418);
			triggerName=gHiveParser.identifier();
			state._fsp--;

			stream_identifier.add(triggerName.getTree());
			// ResourcePlanParser.g:216:72: ( ( KW_WHEN triggerExpression KW_DO triggerActionExpression -> ^( TOK_ALTER_TRIGGER $rpName $triggerName triggerExpression triggerActionExpression ) ) | ( KW_ADD KW_TO KW_POOL poolName= poolPath -> ^( TOK_ALTER_POOL $rpName $poolName ^( TOK_ADD_TRIGGER $triggerName) ) ) | ( KW_DROP KW_FROM KW_POOL poolName= poolPath -> ^( TOK_ALTER_POOL $rpName $poolName ^( TOK_DROP_TRIGGER $triggerName) ) ) | ( KW_ADD KW_TO KW_UNMANAGED -> ^( TOK_ALTER_POOL $rpName TOK_UNMANAGED ^( TOK_ADD_TRIGGER $triggerName) ) ) | ( KW_DROP KW_FROM KW_UNMANAGED -> ^( TOK_ALTER_POOL $rpName TOK_UNMANAGED ^( TOK_DROP_TRIGGER $triggerName) ) ) )
			int alt19=5;
			switch ( input.LA(1) ) {
			case KW_WHEN:
				{
				alt19=1;
				}
				break;
			case KW_ADD:
				{
				int LA19_2 = input.LA(2);
				if ( (LA19_2==KW_TO) ) {
					int LA19_4 = input.LA(3);
					if ( (LA19_4==KW_POOL) ) {
						alt19=2;
					}
					else if ( (LA19_4==KW_UNMANAGED) ) {
						alt19=4;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 19, 4, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 19, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case KW_DROP:
				{
				int LA19_3 = input.LA(2);
				if ( (LA19_3==KW_FROM) ) {
					int LA19_5 = input.LA(3);
					if ( (LA19_5==KW_POOL) ) {
						alt19=3;
					}
					else if ( (LA19_5==KW_UNMANAGED) ) {
						alt19=5;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 19, 5, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 19, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}
			switch (alt19) {
				case 1 :
					// ResourcePlanParser.g:217:9: ( KW_WHEN triggerExpression KW_DO triggerActionExpression -> ^( TOK_ALTER_TRIGGER $rpName $triggerName triggerExpression triggerActionExpression ) )
					{
					// ResourcePlanParser.g:217:9: ( KW_WHEN triggerExpression KW_DO triggerActionExpression -> ^( TOK_ALTER_TRIGGER $rpName $triggerName triggerExpression triggerActionExpression ) )
					// ResourcePlanParser.g:217:10: KW_WHEN triggerExpression KW_DO triggerActionExpression
					{
					KW_WHEN106=(Token)match(input,KW_WHEN,FOLLOW_KW_WHEN_in_alterTriggerStatement1431);  
					stream_KW_WHEN.add(KW_WHEN106);

					pushFollow(FOLLOW_triggerExpression_in_alterTriggerStatement1433);
					triggerExpression107=triggerExpression();
					state._fsp--;

					stream_triggerExpression.add(triggerExpression107.getTree());
					KW_DO108=(Token)match(input,KW_DO,FOLLOW_KW_DO_in_alterTriggerStatement1435);  
					stream_KW_DO.add(KW_DO108);

					pushFollow(FOLLOW_triggerActionExpression_in_alterTriggerStatement1437);
					triggerActionExpression109=triggerActionExpression();
					state._fsp--;

					stream_triggerActionExpression.add(triggerActionExpression109.getTree());
					// AST REWRITE
					// elements: triggerName, triggerActionExpression, rpName, triggerExpression
					// token labels: 
					// rule labels: triggerName, rpName, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_triggerName=new RewriteRuleSubtreeStream(adaptor,"rule triggerName",triggerName!=null?triggerName.getTree():null);
					RewriteRuleSubtreeStream stream_rpName=new RewriteRuleSubtreeStream(adaptor,"rule rpName",rpName!=null?rpName.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 218:11: -> ^( TOK_ALTER_TRIGGER $rpName $triggerName triggerExpression triggerActionExpression )
					{
						// ResourcePlanParser.g:218:14: ^( TOK_ALTER_TRIGGER $rpName $triggerName triggerExpression triggerActionExpression )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ALTER_TRIGGER, "TOK_ALTER_TRIGGER"), root_1);
						adaptor.addChild(root_1, stream_rpName.nextTree());
						adaptor.addChild(root_1, stream_triggerName.nextTree());
						adaptor.addChild(root_1, stream_triggerExpression.nextTree());
						adaptor.addChild(root_1, stream_triggerActionExpression.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}

					}
					break;
				case 2 :
					// ResourcePlanParser.g:219:9: ( KW_ADD KW_TO KW_POOL poolName= poolPath -> ^( TOK_ALTER_POOL $rpName $poolName ^( TOK_ADD_TRIGGER $triggerName) ) )
					{
					// ResourcePlanParser.g:219:9: ( KW_ADD KW_TO KW_POOL poolName= poolPath -> ^( TOK_ALTER_POOL $rpName $poolName ^( TOK_ADD_TRIGGER $triggerName) ) )
					// ResourcePlanParser.g:219:10: KW_ADD KW_TO KW_POOL poolName= poolPath
					{
					KW_ADD110=(Token)match(input,KW_ADD,FOLLOW_KW_ADD_in_alterTriggerStatement1475);  
					stream_KW_ADD.add(KW_ADD110);

					KW_TO111=(Token)match(input,KW_TO,FOLLOW_KW_TO_in_alterTriggerStatement1477);  
					stream_KW_TO.add(KW_TO111);

					KW_POOL112=(Token)match(input,KW_POOL,FOLLOW_KW_POOL_in_alterTriggerStatement1479);  
					stream_KW_POOL.add(KW_POOL112);

					pushFollow(FOLLOW_poolPath_in_alterTriggerStatement1483);
					poolName=poolPath();
					state._fsp--;

					stream_poolPath.add(poolName.getTree());
					// AST REWRITE
					// elements: rpName, poolName, triggerName
					// token labels: 
					// rule labels: triggerName, rpName, retval, poolName
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_triggerName=new RewriteRuleSubtreeStream(adaptor,"rule triggerName",triggerName!=null?triggerName.getTree():null);
					RewriteRuleSubtreeStream stream_rpName=new RewriteRuleSubtreeStream(adaptor,"rule rpName",rpName!=null?rpName.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
					RewriteRuleSubtreeStream stream_poolName=new RewriteRuleSubtreeStream(adaptor,"rule poolName",poolName!=null?poolName.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 219:49: -> ^( TOK_ALTER_POOL $rpName $poolName ^( TOK_ADD_TRIGGER $triggerName) )
					{
						// ResourcePlanParser.g:219:52: ^( TOK_ALTER_POOL $rpName $poolName ^( TOK_ADD_TRIGGER $triggerName) )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ALTER_POOL, "TOK_ALTER_POOL"), root_1);
						adaptor.addChild(root_1, stream_rpName.nextTree());
						adaptor.addChild(root_1, stream_poolName.nextTree());
						// ResourcePlanParser.g:219:87: ^( TOK_ADD_TRIGGER $triggerName)
						{
						ASTNode root_2 = (ASTNode)adaptor.nil();
						root_2 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ADD_TRIGGER, "TOK_ADD_TRIGGER"), root_2);
						adaptor.addChild(root_2, stream_triggerName.nextTree());
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
					// ResourcePlanParser.g:220:9: ( KW_DROP KW_FROM KW_POOL poolName= poolPath -> ^( TOK_ALTER_POOL $rpName $poolName ^( TOK_DROP_TRIGGER $triggerName) ) )
					{
					// ResourcePlanParser.g:220:9: ( KW_DROP KW_FROM KW_POOL poolName= poolPath -> ^( TOK_ALTER_POOL $rpName $poolName ^( TOK_DROP_TRIGGER $triggerName) ) )
					// ResourcePlanParser.g:220:10: KW_DROP KW_FROM KW_POOL poolName= poolPath
					{
					KW_DROP113=(Token)match(input,KW_DROP,FOLLOW_KW_DROP_in_alterTriggerStatement1514);  
					stream_KW_DROP.add(KW_DROP113);

					KW_FROM114=(Token)match(input,KW_FROM,FOLLOW_KW_FROM_in_alterTriggerStatement1516);  
					stream_KW_FROM.add(KW_FROM114);

					KW_POOL115=(Token)match(input,KW_POOL,FOLLOW_KW_POOL_in_alterTriggerStatement1518);  
					stream_KW_POOL.add(KW_POOL115);

					pushFollow(FOLLOW_poolPath_in_alterTriggerStatement1522);
					poolName=poolPath();
					state._fsp--;

					stream_poolPath.add(poolName.getTree());
					// AST REWRITE
					// elements: triggerName, rpName, poolName
					// token labels: 
					// rule labels: triggerName, rpName, retval, poolName
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_triggerName=new RewriteRuleSubtreeStream(adaptor,"rule triggerName",triggerName!=null?triggerName.getTree():null);
					RewriteRuleSubtreeStream stream_rpName=new RewriteRuleSubtreeStream(adaptor,"rule rpName",rpName!=null?rpName.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
					RewriteRuleSubtreeStream stream_poolName=new RewriteRuleSubtreeStream(adaptor,"rule poolName",poolName!=null?poolName.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 220:52: -> ^( TOK_ALTER_POOL $rpName $poolName ^( TOK_DROP_TRIGGER $triggerName) )
					{
						// ResourcePlanParser.g:220:55: ^( TOK_ALTER_POOL $rpName $poolName ^( TOK_DROP_TRIGGER $triggerName) )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ALTER_POOL, "TOK_ALTER_POOL"), root_1);
						adaptor.addChild(root_1, stream_rpName.nextTree());
						adaptor.addChild(root_1, stream_poolName.nextTree());
						// ResourcePlanParser.g:220:90: ^( TOK_DROP_TRIGGER $triggerName)
						{
						ASTNode root_2 = (ASTNode)adaptor.nil();
						root_2 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_DROP_TRIGGER, "TOK_DROP_TRIGGER"), root_2);
						adaptor.addChild(root_2, stream_triggerName.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}

					}
					break;
				case 4 :
					// ResourcePlanParser.g:221:9: ( KW_ADD KW_TO KW_UNMANAGED -> ^( TOK_ALTER_POOL $rpName TOK_UNMANAGED ^( TOK_ADD_TRIGGER $triggerName) ) )
					{
					// ResourcePlanParser.g:221:9: ( KW_ADD KW_TO KW_UNMANAGED -> ^( TOK_ALTER_POOL $rpName TOK_UNMANAGED ^( TOK_ADD_TRIGGER $triggerName) ) )
					// ResourcePlanParser.g:221:10: KW_ADD KW_TO KW_UNMANAGED
					{
					KW_ADD116=(Token)match(input,KW_ADD,FOLLOW_KW_ADD_in_alterTriggerStatement1553);  
					stream_KW_ADD.add(KW_ADD116);

					KW_TO117=(Token)match(input,KW_TO,FOLLOW_KW_TO_in_alterTriggerStatement1555);  
					stream_KW_TO.add(KW_TO117);

					KW_UNMANAGED118=(Token)match(input,KW_UNMANAGED,FOLLOW_KW_UNMANAGED_in_alterTriggerStatement1557);  
					stream_KW_UNMANAGED.add(KW_UNMANAGED118);

					// AST REWRITE
					// elements: triggerName, rpName
					// token labels: 
					// rule labels: triggerName, rpName, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_triggerName=new RewriteRuleSubtreeStream(adaptor,"rule triggerName",triggerName!=null?triggerName.getTree():null);
					RewriteRuleSubtreeStream stream_rpName=new RewriteRuleSubtreeStream(adaptor,"rule rpName",rpName!=null?rpName.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 221:36: -> ^( TOK_ALTER_POOL $rpName TOK_UNMANAGED ^( TOK_ADD_TRIGGER $triggerName) )
					{
						// ResourcePlanParser.g:221:39: ^( TOK_ALTER_POOL $rpName TOK_UNMANAGED ^( TOK_ADD_TRIGGER $triggerName) )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ALTER_POOL, "TOK_ALTER_POOL"), root_1);
						adaptor.addChild(root_1, stream_rpName.nextTree());
						adaptor.addChild(root_1, (ASTNode)adaptor.create(TOK_UNMANAGED, "TOK_UNMANAGED"));
						// ResourcePlanParser.g:221:78: ^( TOK_ADD_TRIGGER $triggerName)
						{
						ASTNode root_2 = (ASTNode)adaptor.nil();
						root_2 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ADD_TRIGGER, "TOK_ADD_TRIGGER"), root_2);
						adaptor.addChild(root_2, stream_triggerName.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}

					}
					break;
				case 5 :
					// ResourcePlanParser.g:222:9: ( KW_DROP KW_FROM KW_UNMANAGED -> ^( TOK_ALTER_POOL $rpName TOK_UNMANAGED ^( TOK_DROP_TRIGGER $triggerName) ) )
					{
					// ResourcePlanParser.g:222:9: ( KW_DROP KW_FROM KW_UNMANAGED -> ^( TOK_ALTER_POOL $rpName TOK_UNMANAGED ^( TOK_DROP_TRIGGER $triggerName) ) )
					// ResourcePlanParser.g:222:10: KW_DROP KW_FROM KW_UNMANAGED
					{
					KW_DROP119=(Token)match(input,KW_DROP,FOLLOW_KW_DROP_in_alterTriggerStatement1587);  
					stream_KW_DROP.add(KW_DROP119);

					KW_FROM120=(Token)match(input,KW_FROM,FOLLOW_KW_FROM_in_alterTriggerStatement1589);  
					stream_KW_FROM.add(KW_FROM120);

					KW_UNMANAGED121=(Token)match(input,KW_UNMANAGED,FOLLOW_KW_UNMANAGED_in_alterTriggerStatement1591);  
					stream_KW_UNMANAGED.add(KW_UNMANAGED121);

					// AST REWRITE
					// elements: triggerName, rpName
					// token labels: 
					// rule labels: triggerName, rpName, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_triggerName=new RewriteRuleSubtreeStream(adaptor,"rule triggerName",triggerName!=null?triggerName.getTree():null);
					RewriteRuleSubtreeStream stream_rpName=new RewriteRuleSubtreeStream(adaptor,"rule rpName",rpName!=null?rpName.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 222:39: -> ^( TOK_ALTER_POOL $rpName TOK_UNMANAGED ^( TOK_DROP_TRIGGER $triggerName) )
					{
						// ResourcePlanParser.g:222:42: ^( TOK_ALTER_POOL $rpName TOK_UNMANAGED ^( TOK_DROP_TRIGGER $triggerName) )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ALTER_POOL, "TOK_ALTER_POOL"), root_1);
						adaptor.addChild(root_1, stream_rpName.nextTree());
						adaptor.addChild(root_1, (ASTNode)adaptor.create(TOK_UNMANAGED, "TOK_UNMANAGED"));
						// ResourcePlanParser.g:222:81: ^( TOK_DROP_TRIGGER $triggerName)
						{
						ASTNode root_2 = (ASTNode)adaptor.nil();
						root_2 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_DROP_TRIGGER, "TOK_DROP_TRIGGER"), root_2);
						adaptor.addChild(root_2, stream_triggerName.nextTree());
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

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "alterTriggerStatement"


	public static class dropTriggerStatement_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "dropTriggerStatement"
	// ResourcePlanParser.g:227:1: dropTriggerStatement : KW_DROP KW_TRIGGER rpName= identifier DOT triggerName= identifier -> ^( TOK_DROP_TRIGGER $rpName $triggerName) ;
	public final HiveParser_ResourcePlanParser.dropTriggerStatement_return dropTriggerStatement() throws RecognitionException {
		HiveParser_ResourcePlanParser.dropTriggerStatement_return retval = new HiveParser_ResourcePlanParser.dropTriggerStatement_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_DROP122=null;
		Token KW_TRIGGER123=null;
		Token DOT124=null;
		ParserRuleReturnScope rpName =null;
		ParserRuleReturnScope triggerName =null;

		ASTNode KW_DROP122_tree=null;
		ASTNode KW_TRIGGER123_tree=null;
		ASTNode DOT124_tree=null;
		RewriteRuleTokenStream stream_KW_DROP=new RewriteRuleTokenStream(adaptor,"token KW_DROP");
		RewriteRuleTokenStream stream_KW_TRIGGER=new RewriteRuleTokenStream(adaptor,"token KW_TRIGGER");
		RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");

		 gParent.pushMsg("drop trigger statement", state); 
		try {
			// ResourcePlanParser.g:230:5: ( KW_DROP KW_TRIGGER rpName= identifier DOT triggerName= identifier -> ^( TOK_DROP_TRIGGER $rpName $triggerName) )
			// ResourcePlanParser.g:230:7: KW_DROP KW_TRIGGER rpName= identifier DOT triggerName= identifier
			{
			KW_DROP122=(Token)match(input,KW_DROP,FOLLOW_KW_DROP_in_dropTriggerStatement1644);  
			stream_KW_DROP.add(KW_DROP122);

			KW_TRIGGER123=(Token)match(input,KW_TRIGGER,FOLLOW_KW_TRIGGER_in_dropTriggerStatement1646);  
			stream_KW_TRIGGER.add(KW_TRIGGER123);

			pushFollow(FOLLOW_identifier_in_dropTriggerStatement1650);
			rpName=gHiveParser.identifier();
			state._fsp--;

			stream_identifier.add(rpName.getTree());
			DOT124=(Token)match(input,DOT,FOLLOW_DOT_in_dropTriggerStatement1652);  
			stream_DOT.add(DOT124);

			pushFollow(FOLLOW_identifier_in_dropTriggerStatement1656);
			triggerName=gHiveParser.identifier();
			state._fsp--;

			stream_identifier.add(triggerName.getTree());
			// AST REWRITE
			// elements: triggerName, rpName
			// token labels: 
			// rule labels: triggerName, rpName, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_triggerName=new RewriteRuleSubtreeStream(adaptor,"rule triggerName",triggerName!=null?triggerName.getTree():null);
			RewriteRuleSubtreeStream stream_rpName=new RewriteRuleSubtreeStream(adaptor,"rule rpName",rpName!=null?rpName.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 231:5: -> ^( TOK_DROP_TRIGGER $rpName $triggerName)
			{
				// ResourcePlanParser.g:231:8: ^( TOK_DROP_TRIGGER $rpName $triggerName)
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_DROP_TRIGGER, "TOK_DROP_TRIGGER"), root_1);
				adaptor.addChild(root_1, stream_rpName.nextTree());
				adaptor.addChild(root_1, stream_triggerName.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "dropTriggerStatement"


	public static class poolAssign_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "poolAssign"
	// ResourcePlanParser.g:234:1: poolAssign : ( ( KW_ALLOC_FRACTION EQUAL allocFraction= Number ) -> ^( TOK_ALLOC_FRACTION $allocFraction) | ( KW_QUERY_PARALLELISM EQUAL parallelism= Number ) -> ^( TOK_QUERY_PARALLELISM $parallelism) | ( KW_SCHEDULING_POLICY EQUAL policy= StringLiteral ) -> ^( TOK_SCHEDULING_POLICY $policy) | ( KW_PATH EQUAL path= poolPath ) -> ^( TOK_PATH $path) ) ;
	public final HiveParser_ResourcePlanParser.poolAssign_return poolAssign() throws RecognitionException {
		HiveParser_ResourcePlanParser.poolAssign_return retval = new HiveParser_ResourcePlanParser.poolAssign_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token allocFraction=null;
		Token parallelism=null;
		Token policy=null;
		Token KW_ALLOC_FRACTION125=null;
		Token EQUAL126=null;
		Token KW_QUERY_PARALLELISM127=null;
		Token EQUAL128=null;
		Token KW_SCHEDULING_POLICY129=null;
		Token EQUAL130=null;
		Token KW_PATH131=null;
		Token EQUAL132=null;
		ParserRuleReturnScope path =null;

		ASTNode allocFraction_tree=null;
		ASTNode parallelism_tree=null;
		ASTNode policy_tree=null;
		ASTNode KW_ALLOC_FRACTION125_tree=null;
		ASTNode EQUAL126_tree=null;
		ASTNode KW_QUERY_PARALLELISM127_tree=null;
		ASTNode EQUAL128_tree=null;
		ASTNode KW_SCHEDULING_POLICY129_tree=null;
		ASTNode EQUAL130_tree=null;
		ASTNode KW_PATH131_tree=null;
		ASTNode EQUAL132_tree=null;
		RewriteRuleTokenStream stream_KW_PATH=new RewriteRuleTokenStream(adaptor,"token KW_PATH");
		RewriteRuleTokenStream stream_Number=new RewriteRuleTokenStream(adaptor,"token Number");
		RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
		RewriteRuleTokenStream stream_KW_ALLOC_FRACTION=new RewriteRuleTokenStream(adaptor,"token KW_ALLOC_FRACTION");
		RewriteRuleTokenStream stream_KW_SCHEDULING_POLICY=new RewriteRuleTokenStream(adaptor,"token KW_SCHEDULING_POLICY");
		RewriteRuleTokenStream stream_EQUAL=new RewriteRuleTokenStream(adaptor,"token EQUAL");
		RewriteRuleTokenStream stream_KW_QUERY_PARALLELISM=new RewriteRuleTokenStream(adaptor,"token KW_QUERY_PARALLELISM");
		RewriteRuleSubtreeStream stream_poolPath=new RewriteRuleSubtreeStream(adaptor,"rule poolPath");

		 gParent.pushMsg("poolAssign", state); 
		try {
			// ResourcePlanParser.g:237:5: ( ( ( KW_ALLOC_FRACTION EQUAL allocFraction= Number ) -> ^( TOK_ALLOC_FRACTION $allocFraction) | ( KW_QUERY_PARALLELISM EQUAL parallelism= Number ) -> ^( TOK_QUERY_PARALLELISM $parallelism) | ( KW_SCHEDULING_POLICY EQUAL policy= StringLiteral ) -> ^( TOK_SCHEDULING_POLICY $policy) | ( KW_PATH EQUAL path= poolPath ) -> ^( TOK_PATH $path) ) )
			// ResourcePlanParser.g:237:7: ( ( KW_ALLOC_FRACTION EQUAL allocFraction= Number ) -> ^( TOK_ALLOC_FRACTION $allocFraction) | ( KW_QUERY_PARALLELISM EQUAL parallelism= Number ) -> ^( TOK_QUERY_PARALLELISM $parallelism) | ( KW_SCHEDULING_POLICY EQUAL policy= StringLiteral ) -> ^( TOK_SCHEDULING_POLICY $policy) | ( KW_PATH EQUAL path= poolPath ) -> ^( TOK_PATH $path) )
			{
			// ResourcePlanParser.g:237:7: ( ( KW_ALLOC_FRACTION EQUAL allocFraction= Number ) -> ^( TOK_ALLOC_FRACTION $allocFraction) | ( KW_QUERY_PARALLELISM EQUAL parallelism= Number ) -> ^( TOK_QUERY_PARALLELISM $parallelism) | ( KW_SCHEDULING_POLICY EQUAL policy= StringLiteral ) -> ^( TOK_SCHEDULING_POLICY $policy) | ( KW_PATH EQUAL path= poolPath ) -> ^( TOK_PATH $path) )
			int alt20=4;
			switch ( input.LA(1) ) {
			case KW_ALLOC_FRACTION:
				{
				alt20=1;
				}
				break;
			case KW_QUERY_PARALLELISM:
				{
				alt20=2;
				}
				break;
			case KW_SCHEDULING_POLICY:
				{
				alt20=3;
				}
				break;
			case KW_PATH:
				{
				alt20=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}
			switch (alt20) {
				case 1 :
					// ResourcePlanParser.g:238:9: ( KW_ALLOC_FRACTION EQUAL allocFraction= Number )
					{
					// ResourcePlanParser.g:238:9: ( KW_ALLOC_FRACTION EQUAL allocFraction= Number )
					// ResourcePlanParser.g:238:10: KW_ALLOC_FRACTION EQUAL allocFraction= Number
					{
					KW_ALLOC_FRACTION125=(Token)match(input,KW_ALLOC_FRACTION,FOLLOW_KW_ALLOC_FRACTION_in_poolAssign1710);  
					stream_KW_ALLOC_FRACTION.add(KW_ALLOC_FRACTION125);

					EQUAL126=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_poolAssign1712);  
					stream_EQUAL.add(EQUAL126);

					allocFraction=(Token)match(input,Number,FOLLOW_Number_in_poolAssign1716);  
					stream_Number.add(allocFraction);

					}

					// AST REWRITE
					// elements: allocFraction
					// token labels: allocFraction
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleTokenStream stream_allocFraction=new RewriteRuleTokenStream(adaptor,"token allocFraction",allocFraction);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 238:56: -> ^( TOK_ALLOC_FRACTION $allocFraction)
					{
						// ResourcePlanParser.g:238:59: ^( TOK_ALLOC_FRACTION $allocFraction)
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ALLOC_FRACTION, "TOK_ALLOC_FRACTION"), root_1);
						adaptor.addChild(root_1, stream_allocFraction.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// ResourcePlanParser.g:239:9: ( KW_QUERY_PARALLELISM EQUAL parallelism= Number )
					{
					// ResourcePlanParser.g:239:9: ( KW_QUERY_PARALLELISM EQUAL parallelism= Number )
					// ResourcePlanParser.g:239:10: KW_QUERY_PARALLELISM EQUAL parallelism= Number
					{
					KW_QUERY_PARALLELISM127=(Token)match(input,KW_QUERY_PARALLELISM,FOLLOW_KW_QUERY_PARALLELISM_in_poolAssign1737);  
					stream_KW_QUERY_PARALLELISM.add(KW_QUERY_PARALLELISM127);

					EQUAL128=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_poolAssign1739);  
					stream_EQUAL.add(EQUAL128);

					parallelism=(Token)match(input,Number,FOLLOW_Number_in_poolAssign1743);  
					stream_Number.add(parallelism);

					}

					// AST REWRITE
					// elements: parallelism
					// token labels: parallelism
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleTokenStream stream_parallelism=new RewriteRuleTokenStream(adaptor,"token parallelism",parallelism);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 239:57: -> ^( TOK_QUERY_PARALLELISM $parallelism)
					{
						// ResourcePlanParser.g:239:60: ^( TOK_QUERY_PARALLELISM $parallelism)
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_QUERY_PARALLELISM, "TOK_QUERY_PARALLELISM"), root_1);
						adaptor.addChild(root_1, stream_parallelism.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// ResourcePlanParser.g:240:9: ( KW_SCHEDULING_POLICY EQUAL policy= StringLiteral )
					{
					// ResourcePlanParser.g:240:9: ( KW_SCHEDULING_POLICY EQUAL policy= StringLiteral )
					// ResourcePlanParser.g:240:10: KW_SCHEDULING_POLICY EQUAL policy= StringLiteral
					{
					KW_SCHEDULING_POLICY129=(Token)match(input,KW_SCHEDULING_POLICY,FOLLOW_KW_SCHEDULING_POLICY_in_poolAssign1764);  
					stream_KW_SCHEDULING_POLICY.add(KW_SCHEDULING_POLICY129);

					EQUAL130=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_poolAssign1766);  
					stream_EQUAL.add(EQUAL130);

					policy=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_poolAssign1770);  
					stream_StringLiteral.add(policy);

					}

					// AST REWRITE
					// elements: policy
					// token labels: policy
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleTokenStream stream_policy=new RewriteRuleTokenStream(adaptor,"token policy",policy);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 240:59: -> ^( TOK_SCHEDULING_POLICY $policy)
					{
						// ResourcePlanParser.g:240:62: ^( TOK_SCHEDULING_POLICY $policy)
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_SCHEDULING_POLICY, "TOK_SCHEDULING_POLICY"), root_1);
						adaptor.addChild(root_1, stream_policy.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					// ResourcePlanParser.g:241:9: ( KW_PATH EQUAL path= poolPath )
					{
					// ResourcePlanParser.g:241:9: ( KW_PATH EQUAL path= poolPath )
					// ResourcePlanParser.g:241:10: KW_PATH EQUAL path= poolPath
					{
					KW_PATH131=(Token)match(input,KW_PATH,FOLLOW_KW_PATH_in_poolAssign1791);  
					stream_KW_PATH.add(KW_PATH131);

					EQUAL132=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_poolAssign1793);  
					stream_EQUAL.add(EQUAL132);

					pushFollow(FOLLOW_poolPath_in_poolAssign1797);
					path=poolPath();
					state._fsp--;

					stream_poolPath.add(path.getTree());
					}

					// AST REWRITE
					// elements: path
					// token labels: 
					// rule labels: path, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_path=new RewriteRuleSubtreeStream(adaptor,"rule path",path!=null?path.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 241:39: -> ^( TOK_PATH $path)
					{
						// ResourcePlanParser.g:241:42: ^( TOK_PATH $path)
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_PATH, "TOK_PATH"), root_1);
						adaptor.addChild(root_1, stream_path.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "poolAssign"


	public static class poolAssignList_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "poolAssignList"
	// ResourcePlanParser.g:245:1: poolAssignList : poolAssign ( COMMA poolAssign )* -> ( poolAssign )+ ;
	public final HiveParser_ResourcePlanParser.poolAssignList_return poolAssignList() throws RecognitionException {
		HiveParser_ResourcePlanParser.poolAssignList_return retval = new HiveParser_ResourcePlanParser.poolAssignList_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token COMMA134=null;
		ParserRuleReturnScope poolAssign133 =null;
		ParserRuleReturnScope poolAssign135 =null;

		ASTNode COMMA134_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_poolAssign=new RewriteRuleSubtreeStream(adaptor,"rule poolAssign");

		 gParent.pushMsg("poolAssignList", state); 
		try {
			// ResourcePlanParser.g:248:5: ( poolAssign ( COMMA poolAssign )* -> ( poolAssign )+ )
			// ResourcePlanParser.g:248:7: poolAssign ( COMMA poolAssign )*
			{
			pushFollow(FOLLOW_poolAssign_in_poolAssignList1842);
			poolAssign133=poolAssign();
			state._fsp--;

			stream_poolAssign.add(poolAssign133.getTree());
			// ResourcePlanParser.g:248:18: ( COMMA poolAssign )*
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==COMMA) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// ResourcePlanParser.g:248:19: COMMA poolAssign
					{
					COMMA134=(Token)match(input,COMMA,FOLLOW_COMMA_in_poolAssignList1845);  
					stream_COMMA.add(COMMA134);

					pushFollow(FOLLOW_poolAssign_in_poolAssignList1847);
					poolAssign135=poolAssign();
					state._fsp--;

					stream_poolAssign.add(poolAssign135.getTree());
					}
					break;

				default :
					break loop21;
				}
			}

			// AST REWRITE
			// elements: poolAssign
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 248:38: -> ( poolAssign )+
			{
				if ( !(stream_poolAssign.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_poolAssign.hasNext() ) {
					adaptor.addChild(root_0, stream_poolAssign.nextTree());
				}
				stream_poolAssign.reset();

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "poolAssignList"


	public static class createPoolStatement_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "createPoolStatement"
	// ResourcePlanParser.g:251:1: createPoolStatement : KW_CREATE KW_POOL rpName= identifier DOT poolPath KW_WITH poolAssignList -> ^( TOK_CREATE_POOL $rpName poolPath poolAssignList ) ;
	public final HiveParser_ResourcePlanParser.createPoolStatement_return createPoolStatement() throws RecognitionException {
		HiveParser_ResourcePlanParser.createPoolStatement_return retval = new HiveParser_ResourcePlanParser.createPoolStatement_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_CREATE136=null;
		Token KW_POOL137=null;
		Token DOT138=null;
		Token KW_WITH140=null;
		ParserRuleReturnScope rpName =null;
		ParserRuleReturnScope poolPath139 =null;
		ParserRuleReturnScope poolAssignList141 =null;

		ASTNode KW_CREATE136_tree=null;
		ASTNode KW_POOL137_tree=null;
		ASTNode DOT138_tree=null;
		ASTNode KW_WITH140_tree=null;
		RewriteRuleTokenStream stream_KW_CREATE=new RewriteRuleTokenStream(adaptor,"token KW_CREATE");
		RewriteRuleTokenStream stream_KW_WITH=new RewriteRuleTokenStream(adaptor,"token KW_WITH");
		RewriteRuleTokenStream stream_KW_POOL=new RewriteRuleTokenStream(adaptor,"token KW_POOL");
		RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
		RewriteRuleSubtreeStream stream_poolAssignList=new RewriteRuleSubtreeStream(adaptor,"rule poolAssignList");
		RewriteRuleSubtreeStream stream_poolPath=new RewriteRuleSubtreeStream(adaptor,"rule poolPath");

		 gParent.pushMsg("create pool statement", state); 
		try {
			// ResourcePlanParser.g:254:5: ( KW_CREATE KW_POOL rpName= identifier DOT poolPath KW_WITH poolAssignList -> ^( TOK_CREATE_POOL $rpName poolPath poolAssignList ) )
			// ResourcePlanParser.g:254:7: KW_CREATE KW_POOL rpName= identifier DOT poolPath KW_WITH poolAssignList
			{
			KW_CREATE136=(Token)match(input,KW_CREATE,FOLLOW_KW_CREATE_in_createPoolStatement1881);  
			stream_KW_CREATE.add(KW_CREATE136);

			KW_POOL137=(Token)match(input,KW_POOL,FOLLOW_KW_POOL_in_createPoolStatement1883);  
			stream_KW_POOL.add(KW_POOL137);

			pushFollow(FOLLOW_identifier_in_createPoolStatement1887);
			rpName=gHiveParser.identifier();
			state._fsp--;

			stream_identifier.add(rpName.getTree());
			DOT138=(Token)match(input,DOT,FOLLOW_DOT_in_createPoolStatement1889);  
			stream_DOT.add(DOT138);

			pushFollow(FOLLOW_poolPath_in_createPoolStatement1891);
			poolPath139=poolPath();
			state._fsp--;

			stream_poolPath.add(poolPath139.getTree());
			KW_WITH140=(Token)match(input,KW_WITH,FOLLOW_KW_WITH_in_createPoolStatement1899);  
			stream_KW_WITH.add(KW_WITH140);

			pushFollow(FOLLOW_poolAssignList_in_createPoolStatement1901);
			poolAssignList141=poolAssignList();
			state._fsp--;

			stream_poolAssignList.add(poolAssignList141.getTree());
			// AST REWRITE
			// elements: rpName, poolAssignList, poolPath
			// token labels: 
			// rule labels: rpName, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_rpName=new RewriteRuleSubtreeStream(adaptor,"rule rpName",rpName!=null?rpName.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 256:5: -> ^( TOK_CREATE_POOL $rpName poolPath poolAssignList )
			{
				// ResourcePlanParser.g:256:8: ^( TOK_CREATE_POOL $rpName poolPath poolAssignList )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_CREATE_POOL, "TOK_CREATE_POOL"), root_1);
				adaptor.addChild(root_1, stream_rpName.nextTree());
				adaptor.addChild(root_1, stream_poolPath.nextTree());
				adaptor.addChild(root_1, stream_poolAssignList.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "createPoolStatement"


	public static class alterPoolStatement_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "alterPoolStatement"
	// ResourcePlanParser.g:259:1: alterPoolStatement : KW_ALTER KW_POOL rpName= identifier DOT poolPath ( ( KW_SET poolAssignList -> ^( TOK_ALTER_POOL $rpName poolPath poolAssignList ) ) | ( KW_UNSET KW_SCHEDULING_POLICY -> ^( TOK_ALTER_POOL $rpName poolPath ^( TOK_SCHEDULING_POLICY TOK_NULL ) ) ) | ( KW_ADD KW_TRIGGER triggerName= identifier -> ^( TOK_ALTER_POOL $rpName poolPath ^( TOK_ADD_TRIGGER $triggerName) ) ) | ( KW_DROP KW_TRIGGER triggerName= identifier -> ^( TOK_ALTER_POOL $rpName poolPath ^( TOK_DROP_TRIGGER $triggerName) ) ) ) ;
	public final HiveParser_ResourcePlanParser.alterPoolStatement_return alterPoolStatement() throws RecognitionException {
		HiveParser_ResourcePlanParser.alterPoolStatement_return retval = new HiveParser_ResourcePlanParser.alterPoolStatement_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_ALTER142=null;
		Token KW_POOL143=null;
		Token DOT144=null;
		Token KW_SET146=null;
		Token KW_UNSET148=null;
		Token KW_SCHEDULING_POLICY149=null;
		Token KW_ADD150=null;
		Token KW_TRIGGER151=null;
		Token KW_DROP152=null;
		Token KW_TRIGGER153=null;
		ParserRuleReturnScope rpName =null;
		ParserRuleReturnScope triggerName =null;
		ParserRuleReturnScope poolPath145 =null;
		ParserRuleReturnScope poolAssignList147 =null;

		ASTNode KW_ALTER142_tree=null;
		ASTNode KW_POOL143_tree=null;
		ASTNode DOT144_tree=null;
		ASTNode KW_SET146_tree=null;
		ASTNode KW_UNSET148_tree=null;
		ASTNode KW_SCHEDULING_POLICY149_tree=null;
		ASTNode KW_ADD150_tree=null;
		ASTNode KW_TRIGGER151_tree=null;
		ASTNode KW_DROP152_tree=null;
		ASTNode KW_TRIGGER153_tree=null;
		RewriteRuleTokenStream stream_KW_TRIGGER=new RewriteRuleTokenStream(adaptor,"token KW_TRIGGER");
		RewriteRuleTokenStream stream_KW_DROP=new RewriteRuleTokenStream(adaptor,"token KW_DROP");
		RewriteRuleTokenStream stream_KW_UNSET=new RewriteRuleTokenStream(adaptor,"token KW_UNSET");
		RewriteRuleTokenStream stream_KW_SCHEDULING_POLICY=new RewriteRuleTokenStream(adaptor,"token KW_SCHEDULING_POLICY");
		RewriteRuleTokenStream stream_KW_POOL=new RewriteRuleTokenStream(adaptor,"token KW_POOL");
		RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
		RewriteRuleTokenStream stream_KW_ALTER=new RewriteRuleTokenStream(adaptor,"token KW_ALTER");
		RewriteRuleTokenStream stream_KW_SET=new RewriteRuleTokenStream(adaptor,"token KW_SET");
		RewriteRuleTokenStream stream_KW_ADD=new RewriteRuleTokenStream(adaptor,"token KW_ADD");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
		RewriteRuleSubtreeStream stream_poolAssignList=new RewriteRuleSubtreeStream(adaptor,"rule poolAssignList");
		RewriteRuleSubtreeStream stream_poolPath=new RewriteRuleSubtreeStream(adaptor,"rule poolPath");

		 gParent.pushMsg("alter pool statement", state); 
		try {
			// ResourcePlanParser.g:262:5: ( KW_ALTER KW_POOL rpName= identifier DOT poolPath ( ( KW_SET poolAssignList -> ^( TOK_ALTER_POOL $rpName poolPath poolAssignList ) ) | ( KW_UNSET KW_SCHEDULING_POLICY -> ^( TOK_ALTER_POOL $rpName poolPath ^( TOK_SCHEDULING_POLICY TOK_NULL ) ) ) | ( KW_ADD KW_TRIGGER triggerName= identifier -> ^( TOK_ALTER_POOL $rpName poolPath ^( TOK_ADD_TRIGGER $triggerName) ) ) | ( KW_DROP KW_TRIGGER triggerName= identifier -> ^( TOK_ALTER_POOL $rpName poolPath ^( TOK_DROP_TRIGGER $triggerName) ) ) ) )
			// ResourcePlanParser.g:262:7: KW_ALTER KW_POOL rpName= identifier DOT poolPath ( ( KW_SET poolAssignList -> ^( TOK_ALTER_POOL $rpName poolPath poolAssignList ) ) | ( KW_UNSET KW_SCHEDULING_POLICY -> ^( TOK_ALTER_POOL $rpName poolPath ^( TOK_SCHEDULING_POLICY TOK_NULL ) ) ) | ( KW_ADD KW_TRIGGER triggerName= identifier -> ^( TOK_ALTER_POOL $rpName poolPath ^( TOK_ADD_TRIGGER $triggerName) ) ) | ( KW_DROP KW_TRIGGER triggerName= identifier -> ^( TOK_ALTER_POOL $rpName poolPath ^( TOK_DROP_TRIGGER $triggerName) ) ) )
			{
			KW_ALTER142=(Token)match(input,KW_ALTER,FOLLOW_KW_ALTER_in_alterPoolStatement1945);  
			stream_KW_ALTER.add(KW_ALTER142);

			KW_POOL143=(Token)match(input,KW_POOL,FOLLOW_KW_POOL_in_alterPoolStatement1947);  
			stream_KW_POOL.add(KW_POOL143);

			pushFollow(FOLLOW_identifier_in_alterPoolStatement1951);
			rpName=gHiveParser.identifier();
			state._fsp--;

			stream_identifier.add(rpName.getTree());
			DOT144=(Token)match(input,DOT,FOLLOW_DOT_in_alterPoolStatement1953);  
			stream_DOT.add(DOT144);

			pushFollow(FOLLOW_poolPath_in_alterPoolStatement1955);
			poolPath145=poolPath();
			state._fsp--;

			stream_poolPath.add(poolPath145.getTree());
			// ResourcePlanParser.g:262:55: ( ( KW_SET poolAssignList -> ^( TOK_ALTER_POOL $rpName poolPath poolAssignList ) ) | ( KW_UNSET KW_SCHEDULING_POLICY -> ^( TOK_ALTER_POOL $rpName poolPath ^( TOK_SCHEDULING_POLICY TOK_NULL ) ) ) | ( KW_ADD KW_TRIGGER triggerName= identifier -> ^( TOK_ALTER_POOL $rpName poolPath ^( TOK_ADD_TRIGGER $triggerName) ) ) | ( KW_DROP KW_TRIGGER triggerName= identifier -> ^( TOK_ALTER_POOL $rpName poolPath ^( TOK_DROP_TRIGGER $triggerName) ) ) )
			int alt22=4;
			switch ( input.LA(1) ) {
			case KW_SET:
				{
				alt22=1;
				}
				break;
			case KW_UNSET:
				{
				alt22=2;
				}
				break;
			case KW_ADD:
				{
				alt22=3;
				}
				break;
			case KW_DROP:
				{
				alt22=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}
			switch (alt22) {
				case 1 :
					// ResourcePlanParser.g:263:9: ( KW_SET poolAssignList -> ^( TOK_ALTER_POOL $rpName poolPath poolAssignList ) )
					{
					// ResourcePlanParser.g:263:9: ( KW_SET poolAssignList -> ^( TOK_ALTER_POOL $rpName poolPath poolAssignList ) )
					// ResourcePlanParser.g:263:10: KW_SET poolAssignList
					{
					KW_SET146=(Token)match(input,KW_SET,FOLLOW_KW_SET_in_alterPoolStatement1968);  
					stream_KW_SET.add(KW_SET146);

					pushFollow(FOLLOW_poolAssignList_in_alterPoolStatement1970);
					poolAssignList147=poolAssignList();
					state._fsp--;

					stream_poolAssignList.add(poolAssignList147.getTree());
					// AST REWRITE
					// elements: rpName, poolAssignList, poolPath
					// token labels: 
					// rule labels: rpName, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_rpName=new RewriteRuleSubtreeStream(adaptor,"rule rpName",rpName!=null?rpName.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 263:32: -> ^( TOK_ALTER_POOL $rpName poolPath poolAssignList )
					{
						// ResourcePlanParser.g:263:35: ^( TOK_ALTER_POOL $rpName poolPath poolAssignList )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ALTER_POOL, "TOK_ALTER_POOL"), root_1);
						adaptor.addChild(root_1, stream_rpName.nextTree());
						adaptor.addChild(root_1, stream_poolPath.nextTree());
						adaptor.addChild(root_1, stream_poolAssignList.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}

					}
					break;
				case 2 :
					// ResourcePlanParser.g:264:11: ( KW_UNSET KW_SCHEDULING_POLICY -> ^( TOK_ALTER_POOL $rpName poolPath ^( TOK_SCHEDULING_POLICY TOK_NULL ) ) )
					{
					// ResourcePlanParser.g:264:11: ( KW_UNSET KW_SCHEDULING_POLICY -> ^( TOK_ALTER_POOL $rpName poolPath ^( TOK_SCHEDULING_POLICY TOK_NULL ) ) )
					// ResourcePlanParser.g:264:12: KW_UNSET KW_SCHEDULING_POLICY
					{
					KW_UNSET148=(Token)match(input,KW_UNSET,FOLLOW_KW_UNSET_in_alterPoolStatement1997);  
					stream_KW_UNSET.add(KW_UNSET148);

					KW_SCHEDULING_POLICY149=(Token)match(input,KW_SCHEDULING_POLICY,FOLLOW_KW_SCHEDULING_POLICY_in_alterPoolStatement1999);  
					stream_KW_SCHEDULING_POLICY.add(KW_SCHEDULING_POLICY149);

					// AST REWRITE
					// elements: rpName, poolPath
					// token labels: 
					// rule labels: rpName, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_rpName=new RewriteRuleSubtreeStream(adaptor,"rule rpName",rpName!=null?rpName.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 264:42: -> ^( TOK_ALTER_POOL $rpName poolPath ^( TOK_SCHEDULING_POLICY TOK_NULL ) )
					{
						// ResourcePlanParser.g:264:45: ^( TOK_ALTER_POOL $rpName poolPath ^( TOK_SCHEDULING_POLICY TOK_NULL ) )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ALTER_POOL, "TOK_ALTER_POOL"), root_1);
						adaptor.addChild(root_1, stream_rpName.nextTree());
						adaptor.addChild(root_1, stream_poolPath.nextTree());
						// ResourcePlanParser.g:264:79: ^( TOK_SCHEDULING_POLICY TOK_NULL )
						{
						ASTNode root_2 = (ASTNode)adaptor.nil();
						root_2 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_SCHEDULING_POLICY, "TOK_SCHEDULING_POLICY"), root_2);
						adaptor.addChild(root_2, (ASTNode)adaptor.create(TOK_NULL, "TOK_NULL"));
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
					// ResourcePlanParser.g:265:11: ( KW_ADD KW_TRIGGER triggerName= identifier -> ^( TOK_ALTER_POOL $rpName poolPath ^( TOK_ADD_TRIGGER $triggerName) ) )
					{
					// ResourcePlanParser.g:265:11: ( KW_ADD KW_TRIGGER triggerName= identifier -> ^( TOK_ALTER_POOL $rpName poolPath ^( TOK_ADD_TRIGGER $triggerName) ) )
					// ResourcePlanParser.g:265:12: KW_ADD KW_TRIGGER triggerName= identifier
					{
					KW_ADD150=(Token)match(input,KW_ADD,FOLLOW_KW_ADD_in_alterPoolStatement2030);  
					stream_KW_ADD.add(KW_ADD150);

					KW_TRIGGER151=(Token)match(input,KW_TRIGGER,FOLLOW_KW_TRIGGER_in_alterPoolStatement2032);  
					stream_KW_TRIGGER.add(KW_TRIGGER151);

					pushFollow(FOLLOW_identifier_in_alterPoolStatement2036);
					triggerName=gHiveParser.identifier();
					state._fsp--;

					stream_identifier.add(triggerName.getTree());
					// AST REWRITE
					// elements: triggerName, poolPath, rpName
					// token labels: 
					// rule labels: triggerName, rpName, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_triggerName=new RewriteRuleSubtreeStream(adaptor,"rule triggerName",triggerName!=null?triggerName.getTree():null);
					RewriteRuleSubtreeStream stream_rpName=new RewriteRuleSubtreeStream(adaptor,"rule rpName",rpName!=null?rpName.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 266:13: -> ^( TOK_ALTER_POOL $rpName poolPath ^( TOK_ADD_TRIGGER $triggerName) )
					{
						// ResourcePlanParser.g:266:16: ^( TOK_ALTER_POOL $rpName poolPath ^( TOK_ADD_TRIGGER $triggerName) )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ALTER_POOL, "TOK_ALTER_POOL"), root_1);
						adaptor.addChild(root_1, stream_rpName.nextTree());
						adaptor.addChild(root_1, stream_poolPath.nextTree());
						// ResourcePlanParser.g:266:50: ^( TOK_ADD_TRIGGER $triggerName)
						{
						ASTNode root_2 = (ASTNode)adaptor.nil();
						root_2 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ADD_TRIGGER, "TOK_ADD_TRIGGER"), root_2);
						adaptor.addChild(root_2, stream_triggerName.nextTree());
						adaptor.addChild(root_1, root_2);
						}

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}

					}
					break;
				case 4 :
					// ResourcePlanParser.g:267:11: ( KW_DROP KW_TRIGGER triggerName= identifier -> ^( TOK_ALTER_POOL $rpName poolPath ^( TOK_DROP_TRIGGER $triggerName) ) )
					{
					// ResourcePlanParser.g:267:11: ( KW_DROP KW_TRIGGER triggerName= identifier -> ^( TOK_ALTER_POOL $rpName poolPath ^( TOK_DROP_TRIGGER $triggerName) ) )
					// ResourcePlanParser.g:267:12: KW_DROP KW_TRIGGER triggerName= identifier
					{
					KW_DROP152=(Token)match(input,KW_DROP,FOLLOW_KW_DROP_in_alterPoolStatement2080);  
					stream_KW_DROP.add(KW_DROP152);

					KW_TRIGGER153=(Token)match(input,KW_TRIGGER,FOLLOW_KW_TRIGGER_in_alterPoolStatement2082);  
					stream_KW_TRIGGER.add(KW_TRIGGER153);

					pushFollow(FOLLOW_identifier_in_alterPoolStatement2086);
					triggerName=gHiveParser.identifier();
					state._fsp--;

					stream_identifier.add(triggerName.getTree());
					// AST REWRITE
					// elements: rpName, poolPath, triggerName
					// token labels: 
					// rule labels: triggerName, rpName, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_triggerName=new RewriteRuleSubtreeStream(adaptor,"rule triggerName",triggerName!=null?triggerName.getTree():null);
					RewriteRuleSubtreeStream stream_rpName=new RewriteRuleSubtreeStream(adaptor,"rule rpName",rpName!=null?rpName.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (ASTNode)adaptor.nil();
					// 268:13: -> ^( TOK_ALTER_POOL $rpName poolPath ^( TOK_DROP_TRIGGER $triggerName) )
					{
						// ResourcePlanParser.g:268:16: ^( TOK_ALTER_POOL $rpName poolPath ^( TOK_DROP_TRIGGER $triggerName) )
						{
						ASTNode root_1 = (ASTNode)adaptor.nil();
						root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ALTER_POOL, "TOK_ALTER_POOL"), root_1);
						adaptor.addChild(root_1, stream_rpName.nextTree());
						adaptor.addChild(root_1, stream_poolPath.nextTree());
						// ResourcePlanParser.g:268:50: ^( TOK_DROP_TRIGGER $triggerName)
						{
						ASTNode root_2 = (ASTNode)adaptor.nil();
						root_2 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_DROP_TRIGGER, "TOK_DROP_TRIGGER"), root_2);
						adaptor.addChild(root_2, stream_triggerName.nextTree());
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

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "alterPoolStatement"


	public static class dropPoolStatement_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "dropPoolStatement"
	// ResourcePlanParser.g:272:1: dropPoolStatement : KW_DROP KW_POOL rpName= identifier DOT poolPath -> ^( TOK_DROP_POOL $rpName poolPath ) ;
	public final HiveParser_ResourcePlanParser.dropPoolStatement_return dropPoolStatement() throws RecognitionException {
		HiveParser_ResourcePlanParser.dropPoolStatement_return retval = new HiveParser_ResourcePlanParser.dropPoolStatement_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_DROP154=null;
		Token KW_POOL155=null;
		Token DOT156=null;
		ParserRuleReturnScope rpName =null;
		ParserRuleReturnScope poolPath157 =null;

		ASTNode KW_DROP154_tree=null;
		ASTNode KW_POOL155_tree=null;
		ASTNode DOT156_tree=null;
		RewriteRuleTokenStream stream_KW_DROP=new RewriteRuleTokenStream(adaptor,"token KW_DROP");
		RewriteRuleTokenStream stream_KW_POOL=new RewriteRuleTokenStream(adaptor,"token KW_POOL");
		RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
		RewriteRuleSubtreeStream stream_poolPath=new RewriteRuleSubtreeStream(adaptor,"rule poolPath");

		 gParent.pushMsg("drop pool statement", state); 
		try {
			// ResourcePlanParser.g:275:5: ( KW_DROP KW_POOL rpName= identifier DOT poolPath -> ^( TOK_DROP_POOL $rpName poolPath ) )
			// ResourcePlanParser.g:275:7: KW_DROP KW_POOL rpName= identifier DOT poolPath
			{
			KW_DROP154=(Token)match(input,KW_DROP,FOLLOW_KW_DROP_in_dropPoolStatement2152);  
			stream_KW_DROP.add(KW_DROP154);

			KW_POOL155=(Token)match(input,KW_POOL,FOLLOW_KW_POOL_in_dropPoolStatement2154);  
			stream_KW_POOL.add(KW_POOL155);

			pushFollow(FOLLOW_identifier_in_dropPoolStatement2158);
			rpName=gHiveParser.identifier();
			state._fsp--;

			stream_identifier.add(rpName.getTree());
			DOT156=(Token)match(input,DOT,FOLLOW_DOT_in_dropPoolStatement2160);  
			stream_DOT.add(DOT156);

			pushFollow(FOLLOW_poolPath_in_dropPoolStatement2162);
			poolPath157=poolPath();
			state._fsp--;

			stream_poolPath.add(poolPath157.getTree());
			// AST REWRITE
			// elements: poolPath, rpName
			// token labels: 
			// rule labels: rpName, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_rpName=new RewriteRuleSubtreeStream(adaptor,"rule rpName",rpName!=null?rpName.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 276:5: -> ^( TOK_DROP_POOL $rpName poolPath )
			{
				// ResourcePlanParser.g:276:8: ^( TOK_DROP_POOL $rpName poolPath )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_DROP_POOL, "TOK_DROP_POOL"), root_1);
				adaptor.addChild(root_1, stream_rpName.nextTree());
				adaptor.addChild(root_1, stream_poolPath.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "dropPoolStatement"


	public static class createMappingStatement_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "createMappingStatement"
	// ResourcePlanParser.g:279:1: createMappingStatement : ( KW_CREATE mappingType= ( KW_USER | KW_GROUP | KW_APPLICATION ) KW_MAPPING name= StringLiteral KW_IN rpName= identifier ( ( KW_TO path= poolPath ) | unmanaged ) ( KW_WITH KW_ORDER order= Number )? ) -> ^( TOK_CREATE_MAPPING $rpName $mappingType $name ( $path)? ( unmanaged )? ( $order)? ) ;
	public final HiveParser_ResourcePlanParser.createMappingStatement_return createMappingStatement() throws RecognitionException {
		HiveParser_ResourcePlanParser.createMappingStatement_return retval = new HiveParser_ResourcePlanParser.createMappingStatement_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token mappingType=null;
		Token name=null;
		Token order=null;
		Token KW_CREATE158=null;
		Token KW_MAPPING159=null;
		Token KW_IN160=null;
		Token KW_TO161=null;
		Token KW_WITH163=null;
		Token KW_ORDER164=null;
		ParserRuleReturnScope rpName =null;
		ParserRuleReturnScope path =null;
		ParserRuleReturnScope unmanaged162 =null;

		ASTNode mappingType_tree=null;
		ASTNode name_tree=null;
		ASTNode order_tree=null;
		ASTNode KW_CREATE158_tree=null;
		ASTNode KW_MAPPING159_tree=null;
		ASTNode KW_IN160_tree=null;
		ASTNode KW_TO161_tree=null;
		ASTNode KW_WITH163_tree=null;
		ASTNode KW_ORDER164_tree=null;
		RewriteRuleTokenStream stream_KW_IN=new RewriteRuleTokenStream(adaptor,"token KW_IN");
		RewriteRuleTokenStream stream_KW_CREATE=new RewriteRuleTokenStream(adaptor,"token KW_CREATE");
		RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
		RewriteRuleTokenStream stream_Number=new RewriteRuleTokenStream(adaptor,"token Number");
		RewriteRuleTokenStream stream_KW_USER=new RewriteRuleTokenStream(adaptor,"token KW_USER");
		RewriteRuleTokenStream stream_KW_WITH=new RewriteRuleTokenStream(adaptor,"token KW_WITH");
		RewriteRuleTokenStream stream_KW_MAPPING=new RewriteRuleTokenStream(adaptor,"token KW_MAPPING");
		RewriteRuleTokenStream stream_KW_TO=new RewriteRuleTokenStream(adaptor,"token KW_TO");
		RewriteRuleTokenStream stream_KW_APPLICATION=new RewriteRuleTokenStream(adaptor,"token KW_APPLICATION");
		RewriteRuleTokenStream stream_KW_ORDER=new RewriteRuleTokenStream(adaptor,"token KW_ORDER");
		RewriteRuleTokenStream stream_KW_GROUP=new RewriteRuleTokenStream(adaptor,"token KW_GROUP");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
		RewriteRuleSubtreeStream stream_unmanaged=new RewriteRuleSubtreeStream(adaptor,"rule unmanaged");
		RewriteRuleSubtreeStream stream_poolPath=new RewriteRuleSubtreeStream(adaptor,"rule poolPath");

		 gParent.pushMsg("create mapping statement", state); 
		try {
			// ResourcePlanParser.g:282:5: ( ( KW_CREATE mappingType= ( KW_USER | KW_GROUP | KW_APPLICATION ) KW_MAPPING name= StringLiteral KW_IN rpName= identifier ( ( KW_TO path= poolPath ) | unmanaged ) ( KW_WITH KW_ORDER order= Number )? ) -> ^( TOK_CREATE_MAPPING $rpName $mappingType $name ( $path)? ( unmanaged )? ( $order)? ) )
			// ResourcePlanParser.g:282:7: ( KW_CREATE mappingType= ( KW_USER | KW_GROUP | KW_APPLICATION ) KW_MAPPING name= StringLiteral KW_IN rpName= identifier ( ( KW_TO path= poolPath ) | unmanaged ) ( KW_WITH KW_ORDER order= Number )? )
			{
			// ResourcePlanParser.g:282:7: ( KW_CREATE mappingType= ( KW_USER | KW_GROUP | KW_APPLICATION ) KW_MAPPING name= StringLiteral KW_IN rpName= identifier ( ( KW_TO path= poolPath ) | unmanaged ) ( KW_WITH KW_ORDER order= Number )? )
			// ResourcePlanParser.g:282:8: KW_CREATE mappingType= ( KW_USER | KW_GROUP | KW_APPLICATION ) KW_MAPPING name= StringLiteral KW_IN rpName= identifier ( ( KW_TO path= poolPath ) | unmanaged ) ( KW_WITH KW_ORDER order= Number )?
			{
			KW_CREATE158=(Token)match(input,KW_CREATE,FOLLOW_KW_CREATE_in_createMappingStatement2205);  
			stream_KW_CREATE.add(KW_CREATE158);

			// ResourcePlanParser.g:282:30: ( KW_USER | KW_GROUP | KW_APPLICATION )
			int alt23=3;
			switch ( input.LA(1) ) {
			case KW_USER:
				{
				alt23=1;
				}
				break;
			case KW_GROUP:
				{
				alt23=2;
				}
				break;
			case KW_APPLICATION:
				{
				alt23=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				throw nvae;
			}
			switch (alt23) {
				case 1 :
					// ResourcePlanParser.g:282:31: KW_USER
					{
					mappingType=(Token)match(input,KW_USER,FOLLOW_KW_USER_in_createMappingStatement2210);  
					stream_KW_USER.add(mappingType);

					}
					break;
				case 2 :
					// ResourcePlanParser.g:282:41: KW_GROUP
					{
					mappingType=(Token)match(input,KW_GROUP,FOLLOW_KW_GROUP_in_createMappingStatement2214);  
					stream_KW_GROUP.add(mappingType);

					}
					break;
				case 3 :
					// ResourcePlanParser.g:282:52: KW_APPLICATION
					{
					mappingType=(Token)match(input,KW_APPLICATION,FOLLOW_KW_APPLICATION_in_createMappingStatement2218);  
					stream_KW_APPLICATION.add(mappingType);

					}
					break;

			}

			KW_MAPPING159=(Token)match(input,KW_MAPPING,FOLLOW_KW_MAPPING_in_createMappingStatement2230);  
			stream_KW_MAPPING.add(KW_MAPPING159);

			name=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_createMappingStatement2234);  
			stream_StringLiteral.add(name);

			KW_IN160=(Token)match(input,KW_IN,FOLLOW_KW_IN_in_createMappingStatement2245);  
			stream_KW_IN.add(KW_IN160);

			pushFollow(FOLLOW_identifier_in_createMappingStatement2249);
			rpName=gHiveParser.identifier();
			state._fsp--;

			stream_identifier.add(rpName.getTree());
			// ResourcePlanParser.g:284:34: ( ( KW_TO path= poolPath ) | unmanaged )
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==KW_TO) ) {
				alt24=1;
			}
			else if ( (LA24_0==KW_UNMANAGED) ) {
				alt24=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				throw nvae;
			}

			switch (alt24) {
				case 1 :
					// ResourcePlanParser.g:284:35: ( KW_TO path= poolPath )
					{
					// ResourcePlanParser.g:284:35: ( KW_TO path= poolPath )
					// ResourcePlanParser.g:284:36: KW_TO path= poolPath
					{
					KW_TO161=(Token)match(input,KW_TO,FOLLOW_KW_TO_in_createMappingStatement2253);  
					stream_KW_TO.add(KW_TO161);

					pushFollow(FOLLOW_poolPath_in_createMappingStatement2257);
					path=poolPath();
					state._fsp--;

					stream_poolPath.add(path.getTree());
					}

					}
					break;
				case 2 :
					// ResourcePlanParser.g:284:59: unmanaged
					{
					pushFollow(FOLLOW_unmanaged_in_createMappingStatement2262);
					unmanaged162=unmanaged();
					state._fsp--;

					stream_unmanaged.add(unmanaged162.getTree());
					}
					break;

			}

			// ResourcePlanParser.g:285:10: ( KW_WITH KW_ORDER order= Number )?
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==KW_WITH) ) {
				alt25=1;
			}
			switch (alt25) {
				case 1 :
					// ResourcePlanParser.g:285:11: KW_WITH KW_ORDER order= Number
					{
					KW_WITH163=(Token)match(input,KW_WITH,FOLLOW_KW_WITH_in_createMappingStatement2275);  
					stream_KW_WITH.add(KW_WITH163);

					KW_ORDER164=(Token)match(input,KW_ORDER,FOLLOW_KW_ORDER_in_createMappingStatement2277);  
					stream_KW_ORDER.add(KW_ORDER164);

					order=(Token)match(input,Number,FOLLOW_Number_in_createMappingStatement2281);  
					stream_Number.add(order);

					}
					break;

			}

			}

			// AST REWRITE
			// elements: path, unmanaged, order, name, mappingType, rpName
			// token labels: mappingType, name, order
			// rule labels: path, rpName, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleTokenStream stream_mappingType=new RewriteRuleTokenStream(adaptor,"token mappingType",mappingType);
			RewriteRuleTokenStream stream_name=new RewriteRuleTokenStream(adaptor,"token name",name);
			RewriteRuleTokenStream stream_order=new RewriteRuleTokenStream(adaptor,"token order",order);
			RewriteRuleSubtreeStream stream_path=new RewriteRuleSubtreeStream(adaptor,"rule path",path!=null?path.getTree():null);
			RewriteRuleSubtreeStream stream_rpName=new RewriteRuleSubtreeStream(adaptor,"rule rpName",rpName!=null?rpName.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 286:5: -> ^( TOK_CREATE_MAPPING $rpName $mappingType $name ( $path)? ( unmanaged )? ( $order)? )
			{
				// ResourcePlanParser.g:286:8: ^( TOK_CREATE_MAPPING $rpName $mappingType $name ( $path)? ( unmanaged )? ( $order)? )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_CREATE_MAPPING, "TOK_CREATE_MAPPING"), root_1);
				adaptor.addChild(root_1, stream_rpName.nextTree());
				adaptor.addChild(root_1, stream_mappingType.nextNode());
				adaptor.addChild(root_1, stream_name.nextNode());
				// ResourcePlanParser.g:286:57: ( $path)?
				if ( stream_path.hasNext() ) {
					adaptor.addChild(root_1, stream_path.nextTree());
				}
				stream_path.reset();

				// ResourcePlanParser.g:286:63: ( unmanaged )?
				if ( stream_unmanaged.hasNext() ) {
					adaptor.addChild(root_1, stream_unmanaged.nextTree());
				}
				stream_unmanaged.reset();

				// ResourcePlanParser.g:286:75: ( $order)?
				if ( stream_order.hasNext() ) {
					adaptor.addChild(root_1, stream_order.nextNode());
				}
				stream_order.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "createMappingStatement"


	public static class alterMappingStatement_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "alterMappingStatement"
	// ResourcePlanParser.g:289:1: alterMappingStatement : ( KW_ALTER mappingType= ( KW_USER | KW_GROUP | KW_APPLICATION ) KW_MAPPING name= StringLiteral KW_IN rpName= identifier ( ( KW_TO path= poolPath ) | unmanaged ) ( KW_WITH KW_ORDER order= Number )? ) -> ^( TOK_ALTER_MAPPING $rpName $mappingType $name ( $path)? ( unmanaged )? ( $order)? ) ;
	public final HiveParser_ResourcePlanParser.alterMappingStatement_return alterMappingStatement() throws RecognitionException {
		HiveParser_ResourcePlanParser.alterMappingStatement_return retval = new HiveParser_ResourcePlanParser.alterMappingStatement_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token mappingType=null;
		Token name=null;
		Token order=null;
		Token KW_ALTER165=null;
		Token KW_MAPPING166=null;
		Token KW_IN167=null;
		Token KW_TO168=null;
		Token KW_WITH170=null;
		Token KW_ORDER171=null;
		ParserRuleReturnScope rpName =null;
		ParserRuleReturnScope path =null;
		ParserRuleReturnScope unmanaged169 =null;

		ASTNode mappingType_tree=null;
		ASTNode name_tree=null;
		ASTNode order_tree=null;
		ASTNode KW_ALTER165_tree=null;
		ASTNode KW_MAPPING166_tree=null;
		ASTNode KW_IN167_tree=null;
		ASTNode KW_TO168_tree=null;
		ASTNode KW_WITH170_tree=null;
		ASTNode KW_ORDER171_tree=null;
		RewriteRuleTokenStream stream_KW_IN=new RewriteRuleTokenStream(adaptor,"token KW_IN");
		RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
		RewriteRuleTokenStream stream_Number=new RewriteRuleTokenStream(adaptor,"token Number");
		RewriteRuleTokenStream stream_KW_USER=new RewriteRuleTokenStream(adaptor,"token KW_USER");
		RewriteRuleTokenStream stream_KW_WITH=new RewriteRuleTokenStream(adaptor,"token KW_WITH");
		RewriteRuleTokenStream stream_KW_MAPPING=new RewriteRuleTokenStream(adaptor,"token KW_MAPPING");
		RewriteRuleTokenStream stream_KW_TO=new RewriteRuleTokenStream(adaptor,"token KW_TO");
		RewriteRuleTokenStream stream_KW_APPLICATION=new RewriteRuleTokenStream(adaptor,"token KW_APPLICATION");
		RewriteRuleTokenStream stream_KW_ALTER=new RewriteRuleTokenStream(adaptor,"token KW_ALTER");
		RewriteRuleTokenStream stream_KW_ORDER=new RewriteRuleTokenStream(adaptor,"token KW_ORDER");
		RewriteRuleTokenStream stream_KW_GROUP=new RewriteRuleTokenStream(adaptor,"token KW_GROUP");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
		RewriteRuleSubtreeStream stream_unmanaged=new RewriteRuleSubtreeStream(adaptor,"rule unmanaged");
		RewriteRuleSubtreeStream stream_poolPath=new RewriteRuleSubtreeStream(adaptor,"rule poolPath");

		 gParent.pushMsg("alter mapping statement", state); 
		try {
			// ResourcePlanParser.g:292:5: ( ( KW_ALTER mappingType= ( KW_USER | KW_GROUP | KW_APPLICATION ) KW_MAPPING name= StringLiteral KW_IN rpName= identifier ( ( KW_TO path= poolPath ) | unmanaged ) ( KW_WITH KW_ORDER order= Number )? ) -> ^( TOK_ALTER_MAPPING $rpName $mappingType $name ( $path)? ( unmanaged )? ( $order)? ) )
			// ResourcePlanParser.g:292:7: ( KW_ALTER mappingType= ( KW_USER | KW_GROUP | KW_APPLICATION ) KW_MAPPING name= StringLiteral KW_IN rpName= identifier ( ( KW_TO path= poolPath ) | unmanaged ) ( KW_WITH KW_ORDER order= Number )? )
			{
			// ResourcePlanParser.g:292:7: ( KW_ALTER mappingType= ( KW_USER | KW_GROUP | KW_APPLICATION ) KW_MAPPING name= StringLiteral KW_IN rpName= identifier ( ( KW_TO path= poolPath ) | unmanaged ) ( KW_WITH KW_ORDER order= Number )? )
			// ResourcePlanParser.g:292:8: KW_ALTER mappingType= ( KW_USER | KW_GROUP | KW_APPLICATION ) KW_MAPPING name= StringLiteral KW_IN rpName= identifier ( ( KW_TO path= poolPath ) | unmanaged ) ( KW_WITH KW_ORDER order= Number )?
			{
			KW_ALTER165=(Token)match(input,KW_ALTER,FOLLOW_KW_ALTER_in_alterMappingStatement2342);  
			stream_KW_ALTER.add(KW_ALTER165);

			// ResourcePlanParser.g:292:29: ( KW_USER | KW_GROUP | KW_APPLICATION )
			int alt26=3;
			switch ( input.LA(1) ) {
			case KW_USER:
				{
				alt26=1;
				}
				break;
			case KW_GROUP:
				{
				alt26=2;
				}
				break;
			case KW_APPLICATION:
				{
				alt26=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 26, 0, input);
				throw nvae;
			}
			switch (alt26) {
				case 1 :
					// ResourcePlanParser.g:292:30: KW_USER
					{
					mappingType=(Token)match(input,KW_USER,FOLLOW_KW_USER_in_alterMappingStatement2347);  
					stream_KW_USER.add(mappingType);

					}
					break;
				case 2 :
					// ResourcePlanParser.g:292:40: KW_GROUP
					{
					mappingType=(Token)match(input,KW_GROUP,FOLLOW_KW_GROUP_in_alterMappingStatement2351);  
					stream_KW_GROUP.add(mappingType);

					}
					break;
				case 3 :
					// ResourcePlanParser.g:292:51: KW_APPLICATION
					{
					mappingType=(Token)match(input,KW_APPLICATION,FOLLOW_KW_APPLICATION_in_alterMappingStatement2355);  
					stream_KW_APPLICATION.add(mappingType);

					}
					break;

			}

			KW_MAPPING166=(Token)match(input,KW_MAPPING,FOLLOW_KW_MAPPING_in_alterMappingStatement2367);  
			stream_KW_MAPPING.add(KW_MAPPING166);

			name=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_alterMappingStatement2371);  
			stream_StringLiteral.add(name);

			KW_IN167=(Token)match(input,KW_IN,FOLLOW_KW_IN_in_alterMappingStatement2382);  
			stream_KW_IN.add(KW_IN167);

			pushFollow(FOLLOW_identifier_in_alterMappingStatement2386);
			rpName=gHiveParser.identifier();
			state._fsp--;

			stream_identifier.add(rpName.getTree());
			// ResourcePlanParser.g:294:34: ( ( KW_TO path= poolPath ) | unmanaged )
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==KW_TO) ) {
				alt27=1;
			}
			else if ( (LA27_0==KW_UNMANAGED) ) {
				alt27=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 27, 0, input);
				throw nvae;
			}

			switch (alt27) {
				case 1 :
					// ResourcePlanParser.g:294:35: ( KW_TO path= poolPath )
					{
					// ResourcePlanParser.g:294:35: ( KW_TO path= poolPath )
					// ResourcePlanParser.g:294:36: KW_TO path= poolPath
					{
					KW_TO168=(Token)match(input,KW_TO,FOLLOW_KW_TO_in_alterMappingStatement2390);  
					stream_KW_TO.add(KW_TO168);

					pushFollow(FOLLOW_poolPath_in_alterMappingStatement2394);
					path=poolPath();
					state._fsp--;

					stream_poolPath.add(path.getTree());
					}

					}
					break;
				case 2 :
					// ResourcePlanParser.g:294:59: unmanaged
					{
					pushFollow(FOLLOW_unmanaged_in_alterMappingStatement2399);
					unmanaged169=unmanaged();
					state._fsp--;

					stream_unmanaged.add(unmanaged169.getTree());
					}
					break;

			}

			// ResourcePlanParser.g:295:10: ( KW_WITH KW_ORDER order= Number )?
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==KW_WITH) ) {
				alt28=1;
			}
			switch (alt28) {
				case 1 :
					// ResourcePlanParser.g:295:11: KW_WITH KW_ORDER order= Number
					{
					KW_WITH170=(Token)match(input,KW_WITH,FOLLOW_KW_WITH_in_alterMappingStatement2412);  
					stream_KW_WITH.add(KW_WITH170);

					KW_ORDER171=(Token)match(input,KW_ORDER,FOLLOW_KW_ORDER_in_alterMappingStatement2414);  
					stream_KW_ORDER.add(KW_ORDER171);

					order=(Token)match(input,Number,FOLLOW_Number_in_alterMappingStatement2418);  
					stream_Number.add(order);

					}
					break;

			}

			}

			// AST REWRITE
			// elements: rpName, path, order, unmanaged, mappingType, name
			// token labels: mappingType, name, order
			// rule labels: path, rpName, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleTokenStream stream_mappingType=new RewriteRuleTokenStream(adaptor,"token mappingType",mappingType);
			RewriteRuleTokenStream stream_name=new RewriteRuleTokenStream(adaptor,"token name",name);
			RewriteRuleTokenStream stream_order=new RewriteRuleTokenStream(adaptor,"token order",order);
			RewriteRuleSubtreeStream stream_path=new RewriteRuleSubtreeStream(adaptor,"rule path",path!=null?path.getTree():null);
			RewriteRuleSubtreeStream stream_rpName=new RewriteRuleSubtreeStream(adaptor,"rule rpName",rpName!=null?rpName.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 296:5: -> ^( TOK_ALTER_MAPPING $rpName $mappingType $name ( $path)? ( unmanaged )? ( $order)? )
			{
				// ResourcePlanParser.g:296:8: ^( TOK_ALTER_MAPPING $rpName $mappingType $name ( $path)? ( unmanaged )? ( $order)? )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_ALTER_MAPPING, "TOK_ALTER_MAPPING"), root_1);
				adaptor.addChild(root_1, stream_rpName.nextTree());
				adaptor.addChild(root_1, stream_mappingType.nextNode());
				adaptor.addChild(root_1, stream_name.nextNode());
				// ResourcePlanParser.g:296:56: ( $path)?
				if ( stream_path.hasNext() ) {
					adaptor.addChild(root_1, stream_path.nextTree());
				}
				stream_path.reset();

				// ResourcePlanParser.g:296:62: ( unmanaged )?
				if ( stream_unmanaged.hasNext() ) {
					adaptor.addChild(root_1, stream_unmanaged.nextTree());
				}
				stream_unmanaged.reset();

				// ResourcePlanParser.g:296:74: ( $order)?
				if ( stream_order.hasNext() ) {
					adaptor.addChild(root_1, stream_order.nextNode());
				}
				stream_order.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "alterMappingStatement"


	public static class dropMappingStatement_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "dropMappingStatement"
	// ResourcePlanParser.g:299:1: dropMappingStatement : KW_DROP mappingType= ( KW_USER | KW_GROUP | KW_APPLICATION ) KW_MAPPING name= StringLiteral KW_IN rpName= identifier -> ^( TOK_DROP_MAPPING $rpName $mappingType $name) ;
	public final HiveParser_ResourcePlanParser.dropMappingStatement_return dropMappingStatement() throws RecognitionException {
		HiveParser_ResourcePlanParser.dropMappingStatement_return retval = new HiveParser_ResourcePlanParser.dropMappingStatement_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token mappingType=null;
		Token name=null;
		Token KW_DROP172=null;
		Token KW_MAPPING173=null;
		Token KW_IN174=null;
		ParserRuleReturnScope rpName =null;

		ASTNode mappingType_tree=null;
		ASTNode name_tree=null;
		ASTNode KW_DROP172_tree=null;
		ASTNode KW_MAPPING173_tree=null;
		ASTNode KW_IN174_tree=null;
		RewriteRuleTokenStream stream_KW_DROP=new RewriteRuleTokenStream(adaptor,"token KW_DROP");
		RewriteRuleTokenStream stream_KW_IN=new RewriteRuleTokenStream(adaptor,"token KW_IN");
		RewriteRuleTokenStream stream_StringLiteral=new RewriteRuleTokenStream(adaptor,"token StringLiteral");
		RewriteRuleTokenStream stream_KW_USER=new RewriteRuleTokenStream(adaptor,"token KW_USER");
		RewriteRuleTokenStream stream_KW_MAPPING=new RewriteRuleTokenStream(adaptor,"token KW_MAPPING");
		RewriteRuleTokenStream stream_KW_APPLICATION=new RewriteRuleTokenStream(adaptor,"token KW_APPLICATION");
		RewriteRuleTokenStream stream_KW_GROUP=new RewriteRuleTokenStream(adaptor,"token KW_GROUP");
		RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");

		 gParent.pushMsg("drop mapping statement", state); 
		try {
			// ResourcePlanParser.g:302:5: ( KW_DROP mappingType= ( KW_USER | KW_GROUP | KW_APPLICATION ) KW_MAPPING name= StringLiteral KW_IN rpName= identifier -> ^( TOK_DROP_MAPPING $rpName $mappingType $name) )
			// ResourcePlanParser.g:302:7: KW_DROP mappingType= ( KW_USER | KW_GROUP | KW_APPLICATION ) KW_MAPPING name= StringLiteral KW_IN rpName= identifier
			{
			KW_DROP172=(Token)match(input,KW_DROP,FOLLOW_KW_DROP_in_dropMappingStatement2478);  
			stream_KW_DROP.add(KW_DROP172);

			// ResourcePlanParser.g:302:27: ( KW_USER | KW_GROUP | KW_APPLICATION )
			int alt29=3;
			switch ( input.LA(1) ) {
			case KW_USER:
				{
				alt29=1;
				}
				break;
			case KW_GROUP:
				{
				alt29=2;
				}
				break;
			case KW_APPLICATION:
				{
				alt29=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 29, 0, input);
				throw nvae;
			}
			switch (alt29) {
				case 1 :
					// ResourcePlanParser.g:302:28: KW_USER
					{
					mappingType=(Token)match(input,KW_USER,FOLLOW_KW_USER_in_dropMappingStatement2483);  
					stream_KW_USER.add(mappingType);

					}
					break;
				case 2 :
					// ResourcePlanParser.g:302:38: KW_GROUP
					{
					mappingType=(Token)match(input,KW_GROUP,FOLLOW_KW_GROUP_in_dropMappingStatement2487);  
					stream_KW_GROUP.add(mappingType);

					}
					break;
				case 3 :
					// ResourcePlanParser.g:302:49: KW_APPLICATION
					{
					mappingType=(Token)match(input,KW_APPLICATION,FOLLOW_KW_APPLICATION_in_dropMappingStatement2491);  
					stream_KW_APPLICATION.add(mappingType);

					}
					break;

			}

			KW_MAPPING173=(Token)match(input,KW_MAPPING,FOLLOW_KW_MAPPING_in_dropMappingStatement2494);  
			stream_KW_MAPPING.add(KW_MAPPING173);

			name=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_dropMappingStatement2507);  
			stream_StringLiteral.add(name);

			KW_IN174=(Token)match(input,KW_IN,FOLLOW_KW_IN_in_dropMappingStatement2509);  
			stream_KW_IN.add(KW_IN174);

			pushFollow(FOLLOW_identifier_in_dropMappingStatement2513);
			rpName=gHiveParser.identifier();
			state._fsp--;

			stream_identifier.add(rpName.getTree());
			// AST REWRITE
			// elements: name, rpName, mappingType
			// token labels: mappingType, name
			// rule labels: rpName, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleTokenStream stream_mappingType=new RewriteRuleTokenStream(adaptor,"token mappingType",mappingType);
			RewriteRuleTokenStream stream_name=new RewriteRuleTokenStream(adaptor,"token name",name);
			RewriteRuleSubtreeStream stream_rpName=new RewriteRuleSubtreeStream(adaptor,"rule rpName",rpName!=null?rpName.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 304:5: -> ^( TOK_DROP_MAPPING $rpName $mappingType $name)
			{
				// ResourcePlanParser.g:304:8: ^( TOK_DROP_MAPPING $rpName $mappingType $name)
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_DROP_MAPPING, "TOK_DROP_MAPPING"), root_1);
				adaptor.addChild(root_1, stream_rpName.nextTree());
				adaptor.addChild(root_1, stream_mappingType.nextNode());
				adaptor.addChild(root_1, stream_name.nextNode());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

			 gParent.popMsg(state); 
		}

		  catch (RecognitionException e) {
		    throw e;
		  }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "dropMappingStatement"

	// Delegated rules



	public static final BitSet FOLLOW_createResourcePlanStatement_in_resourcePlanDdlStatements63 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_alterResourcePlanStatement_in_resourcePlanDdlStatements71 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dropResourcePlanStatement_in_resourcePlanDdlStatements79 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_globalWmStatement_in_resourcePlanDdlStatements87 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_replaceResourcePlanStatement_in_resourcePlanDdlStatements95 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_createTriggerStatement_in_resourcePlanDdlStatements103 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_alterTriggerStatement_in_resourcePlanDdlStatements111 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dropTriggerStatement_in_resourcePlanDdlStatements119 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_createPoolStatement_in_resourcePlanDdlStatements127 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_alterPoolStatement_in_resourcePlanDdlStatements135 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dropPoolStatement_in_resourcePlanDdlStatements143 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_createMappingStatement_in_resourcePlanDdlStatements151 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_alterMappingStatement_in_resourcePlanDdlStatements159 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dropMappingStatement_in_resourcePlanDdlStatements167 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_QUERY_PARALLELISM_in_rpAssign201 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_EQUAL_in_rpAssign203 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_Number_in_rpAssign207 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_DEFAULT_in_rpAssign226 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_KW_POOL_in_rpAssign228 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_EQUAL_in_rpAssign230 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_poolPath_in_rpAssign232 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rpAssign_in_rpAssignList270 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_COMMA_in_rpAssignList273 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L,0x0000000000000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_rpAssign_in_rpAssignList275 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_KW_QUERY_PARALLELISM_in_rpUnassign314 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_DEFAULT_in_rpUnassign332 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_KW_POOL_in_rpUnassign334 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rpUnassign_in_rpUnassignList372 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_COMMA_in_rpUnassignList375 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L,0x0000000000000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_rpUnassign_in_rpUnassignList377 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_KW_CREATE_in_createResourcePlanStatement409 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_KW_RESOURCE_in_createResourcePlanStatement411 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_KW_PLAN_in_createResourcePlanStatement413 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_createResourcePlanStatement430 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_KW_LIKE_in_createResourcePlanStatement432 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_createResourcePlanStatement436 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_createResourcePlanStatement468 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_KW_WITH_in_createResourcePlanStatement471 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L,0x0000000000000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_rpAssignList_in_createResourcePlanStatement473 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_WITH_in_withReplace510 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_KW_REPLACE_in_withReplace512 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_ACTIVATE_in_activate525 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_withReplace_in_activate527 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_ENABLE_in_enable544 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_DISABLE_in_disable557 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_UNMANAGED_in_unmanaged570 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_ALTER_in_alterResourcePlanStatement599 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_KW_RESOURCE_in_alterResourcePlanStatement601 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_KW_PLAN_in_alterResourcePlanStatement603 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_alterResourcePlanStatement607 = new BitSet(new long[]{0x0000000008000000L,0x0001004000000000L,0x0000000000000000L,0x4000000000000000L,0x0000000002000000L,0x0000000000040200L});
	public static final BitSet FOLLOW_KW_VALIDATE_in_alterResourcePlanStatement622 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_DISABLE_in_alterResourcePlanStatement647 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_SET_in_alterResourcePlanStatement672 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L,0x0000000000000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_rpAssignList_in_alterResourcePlanStatement674 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_UNSET_in_alterResourcePlanStatement699 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L,0x0000000000000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_rpUnassignList_in_alterResourcePlanStatement701 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_RENAME_in_alterResourcePlanStatement726 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_KW_TO_in_alterResourcePlanStatement728 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_alterResourcePlanStatement732 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_activate_in_alterResourcePlanStatement763 = new BitSet(new long[]{0x0000000000000002L,0x0001000000000000L});
	public static final BitSet FOLLOW_enable_in_alterResourcePlanStatement765 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_enable_in_alterResourcePlanStatement770 = new BitSet(new long[]{0x0000000008000002L});
	public static final BitSet FOLLOW_activate_in_alterResourcePlanStatement772 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_enable_in_globalWmStatement828 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_disable_in_globalWmStatement832 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_KW_WORKLOAD_in_globalWmStatement835 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x1000000000000000L});
	public static final BitSet FOLLOW_KW_MANAGEMENT_in_globalWmStatement837 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_REPLACE_in_replaceResourcePlanStatement876 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_KW_ACTIVE_in_replaceResourcePlanStatement891 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_KW_RESOURCE_in_replaceResourcePlanStatement893 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_KW_PLAN_in_replaceResourcePlanStatement895 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_KW_WITH_in_replaceResourcePlanStatement897 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_replaceResourcePlanStatement901 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_RESOURCE_in_replaceResourcePlanStatement926 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_KW_PLAN_in_replaceResourcePlanStatement928 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_replaceResourcePlanStatement932 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_KW_WITH_in_replaceResourcePlanStatement934 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_replaceResourcePlanStatement938 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_DROP_in_dropResourcePlanStatement990 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_KW_RESOURCE_in_dropResourcePlanStatement992 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000002000000000L});
	public static final BitSet FOLLOW_KW_PLAN_in_dropResourcePlanStatement994 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_dropResourcePlanStatement998 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_identifier_in_poolPath1034 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_DOT_in_poolPath1038 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_poolPath1040 = new BitSet(new long[]{0x0000000000010002L});
	public static final BitSet FOLLOW_triggerAtomExpression_in_triggerExpression1069 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_triggerExpression_in_triggerExpressionStandalone1090 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_triggerExpressionStandalone1092 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_triggerAndExpression_in_triggerOrExpression1117 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_KW_OR_in_triggerOrExpression1120 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_triggerAndExpression_in_triggerOrExpression1122 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_triggerAtomExpression_in_triggerAndExpression1151 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_KW_AND_in_triggerAndExpression1154 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_triggerAtomExpression_in_triggerAndExpression1156 = new BitSet(new long[]{0x0000001000000002L});
	public static final BitSet FOLLOW_identifier_in_triggerAtomExpression1185 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_comparisionOperator_in_triggerAtomExpression1187 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800800000000000L});
	public static final BitSet FOLLOW_triggerLiteral_in_triggerAtomExpression1189 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GREATERTHAN_in_comparisionOperator1252 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_KILL_in_triggerActionExpression1279 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_MOVE_in_triggerActionExpression1288 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_KW_TO_in_triggerActionExpression1291 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_poolPath_in_triggerActionExpression1294 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_triggerActionExpression_in_triggerActionExpressionStandalone1308 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_triggerActionExpressionStandalone1310 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_CREATE_in_createTriggerStatement1333 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_KW_TRIGGER_in_createTriggerStatement1335 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_createTriggerStatement1339 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_DOT_in_createTriggerStatement1341 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_createTriggerStatement1345 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_KW_WHEN_in_createTriggerStatement1353 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_triggerExpression_in_createTriggerStatement1355 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_KW_DO_in_createTriggerStatement1357 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000080000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_triggerActionExpression_in_createTriggerStatement1359 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_ALTER_in_alterTriggerStatement1406 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_KW_TRIGGER_in_alterTriggerStatement1408 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_alterTriggerStatement1412 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_DOT_in_alterTriggerStatement1414 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_alterTriggerStatement1418 = new BitSet(new long[]{0x0000000020000000L,0x0000100000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_KW_WHEN_in_alterTriggerStatement1431 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_triggerExpression_in_alterTriggerStatement1433 = new BitSet(new long[]{0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_KW_DO_in_alterTriggerStatement1435 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000080000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_triggerActionExpression_in_alterTriggerStatement1437 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_ADD_in_alterTriggerStatement1475 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_KW_TO_in_alterTriggerStatement1477 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_KW_POOL_in_alterTriggerStatement1479 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_poolPath_in_alterTriggerStatement1483 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_DROP_in_alterTriggerStatement1514 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_KW_FROM_in_alterTriggerStatement1516 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_KW_POOL_in_alterTriggerStatement1518 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_poolPath_in_alterTriggerStatement1522 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_ADD_in_alterTriggerStatement1553 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_KW_TO_in_alterTriggerStatement1555 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_KW_UNMANAGED_in_alterTriggerStatement1557 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_DROP_in_alterTriggerStatement1587 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_KW_FROM_in_alterTriggerStatement1589 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_KW_UNMANAGED_in_alterTriggerStatement1591 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_DROP_in_dropTriggerStatement1644 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_KW_TRIGGER_in_dropTriggerStatement1646 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_dropTriggerStatement1650 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_DOT_in_dropTriggerStatement1652 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_dropTriggerStatement1656 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_ALLOC_FRACTION_in_poolAssign1710 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_EQUAL_in_poolAssign1712 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_Number_in_poolAssign1716 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_QUERY_PARALLELISM_in_poolAssign1737 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_EQUAL_in_poolAssign1739 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_Number_in_poolAssign1743 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_SCHEDULING_POLICY_in_poolAssign1764 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_EQUAL_in_poolAssign1766 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800000000000000L});
	public static final BitSet FOLLOW_StringLiteral_in_poolAssign1770 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_PATH_in_poolAssign1791 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_EQUAL_in_poolAssign1793 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_poolPath_in_poolAssign1797 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_poolAssign_in_poolAssignList1842 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_COMMA_in_poolAssignList1845 = new BitSet(new long[]{0x0000000200000000L,0x0000000000000000L,0x0000000000000000L,0x0004000800000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_poolAssign_in_poolAssignList1847 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_KW_CREATE_in_createPoolStatement1881 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_KW_POOL_in_createPoolStatement1883 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_createPoolStatement1887 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_DOT_in_createPoolStatement1889 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_poolPath_in_createPoolStatement1891 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_KW_WITH_in_createPoolStatement1899 = new BitSet(new long[]{0x0000000200000000L,0x0000000000000000L,0x0000000000000000L,0x0004000800000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_poolAssignList_in_createPoolStatement1901 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_ALTER_in_alterPoolStatement1945 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_KW_POOL_in_alterPoolStatement1947 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_alterPoolStatement1951 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_DOT_in_alterPoolStatement1953 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_poolPath_in_alterPoolStatement1955 = new BitSet(new long[]{0x0000000020000000L,0x0000100000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000002000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_KW_SET_in_alterPoolStatement1968 = new BitSet(new long[]{0x0000000200000000L,0x0000000000000000L,0x0000000000000000L,0x0004000800000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_poolAssignList_in_alterPoolStatement1970 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_UNSET_in_alterPoolStatement1997 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_KW_SCHEDULING_POLICY_in_alterPoolStatement1999 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_ADD_in_alterPoolStatement2030 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_KW_TRIGGER_in_alterPoolStatement2032 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_alterPoolStatement2036 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_DROP_in_alterPoolStatement2080 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_KW_TRIGGER_in_alterPoolStatement2082 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_alterPoolStatement2086 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_DROP_in_dropPoolStatement2152 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_KW_POOL_in_dropPoolStatement2154 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_dropPoolStatement2158 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_DOT_in_dropPoolStatement2160 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_poolPath_in_dropPoolStatement2162 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_CREATE_in_createMappingStatement2205 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000000L,0x0000000000010000L,0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
	public static final BitSet FOLLOW_KW_USER_in_createMappingStatement2210 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x8000000000000000L});
	public static final BitSet FOLLOW_KW_GROUP_in_createMappingStatement2214 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x8000000000000000L});
	public static final BitSet FOLLOW_KW_APPLICATION_in_createMappingStatement2218 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x8000000000000000L});
	public static final BitSet FOLLOW_KW_MAPPING_in_createMappingStatement2230 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800000000000000L});
	public static final BitSet FOLLOW_StringLiteral_in_createMappingStatement2234 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_KW_IN_in_createMappingStatement2245 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_createMappingStatement2249 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0100000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_KW_TO_in_createMappingStatement2253 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_poolPath_in_createMappingStatement2257 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_unmanaged_in_createMappingStatement2262 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_KW_WITH_in_createMappingStatement2275 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_KW_ORDER_in_createMappingStatement2277 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_Number_in_createMappingStatement2281 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_ALTER_in_alterMappingStatement2342 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000000L,0x0000000000010000L,0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
	public static final BitSet FOLLOW_KW_USER_in_alterMappingStatement2347 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x8000000000000000L});
	public static final BitSet FOLLOW_KW_GROUP_in_alterMappingStatement2351 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x8000000000000000L});
	public static final BitSet FOLLOW_KW_APPLICATION_in_alterMappingStatement2355 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x8000000000000000L});
	public static final BitSet FOLLOW_KW_MAPPING_in_alterMappingStatement2367 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800000000000000L});
	public static final BitSet FOLLOW_StringLiteral_in_alterMappingStatement2371 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_KW_IN_in_alterMappingStatement2382 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_alterMappingStatement2386 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0100000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_KW_TO_in_alterMappingStatement2390 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_poolPath_in_alterMappingStatement2394 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_unmanaged_in_alterMappingStatement2399 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_KW_WITH_in_alterMappingStatement2412 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_KW_ORDER_in_alterMappingStatement2414 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_Number_in_alterMappingStatement2418 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_DROP_in_dropMappingStatement2478 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000000L,0x0000000000010000L,0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
	public static final BitSet FOLLOW_KW_USER_in_dropMappingStatement2483 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x8000000000000000L});
	public static final BitSet FOLLOW_KW_GROUP_in_dropMappingStatement2487 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x8000000000000000L});
	public static final BitSet FOLLOW_KW_APPLICATION_in_dropMappingStatement2491 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x8000000000000000L});
	public static final BitSet FOLLOW_KW_MAPPING_in_dropMappingStatement2494 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0800000000000000L});
	public static final BitSet FOLLOW_StringLiteral_in_dropMappingStatement2507 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_KW_IN_in_dropMappingStatement2509 = new BitSet(new long[]{0xF4D8348AFD000000L,0x074D6B7BBBA809EDL,0xD7DD1F703B18460FL,0xF1D7A1EED8655B6BL,0x0E874FEF7DEF0CBFL,0x0000001F27D73795L,0x0000000200000000L,0x0220000000000040L,0x0000110000000000L,0x0000000000002040L,0x0000000000000200L});
	public static final BitSet FOLLOW_identifier_in_dropMappingStatement2513 = new BitSet(new long[]{0x0000000000000002L});
}
