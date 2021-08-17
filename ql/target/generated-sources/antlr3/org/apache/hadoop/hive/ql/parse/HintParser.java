// $ANTLR 3.5.2 org/apache/hadoop/hive/ql/parse/HintParser.g 2021-08-17 21:23:01

package org.apache.hadoop.hive.ql.parse;

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
public class HintParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AMPERSAND", "BITWISEOR", "BITWISEXOR", 
		"ByteLengthLiteral", "COLON", "COMMA", "CONCATENATE", "CharSetLiteral", 
		"CharSetName", "DIV", "DIVIDE", "DOLLAR", "DOT", "Digit", "EQUAL", "EQUAL_NS", 
		"Exponent", "GREATERTHAN", "GREATERTHANOREQUALTO", "HexDigit", "Identifier", 
		"IntegralLiteral", "KW_ABORT", "KW_ACTIVATE", "KW_ACTIVE", "KW_ADD", "KW_ADMIN", 
		"KW_AFTER", "KW_ALL", "KW_ALLOC_FRACTION", "KW_ALTER", "KW_ANALYZE", "KW_AND", 
		"KW_ANY", "KW_APPLICATION", "KW_ARCHIVE", "KW_ARRAY", "KW_AS", "KW_ASC", 
		"KW_AUTHORIZATION", "KW_AUTOCOMMIT", "KW_BEFORE", "KW_BETWEEN", "KW_BIGINT", 
		"KW_BINARY", "KW_BOOLEAN", "KW_BOTH", "KW_BUCKET", "KW_BUCKETS", "KW_BY", 
		"KW_CACHE", "KW_CASCADE", "KW_CASE", "KW_CAST", "KW_CHANGE", "KW_CHAR", 
		"KW_CHECK", "KW_CLUSTER", "KW_CLUSTERED", "KW_CLUSTERSTATUS", "KW_COLLECTION", 
		"KW_COLUMN", "KW_COLUMNS", "KW_COMMENT", "KW_COMMIT", "KW_COMPACT", "KW_COMPACTIONS", 
		"KW_COMPUTE", "KW_CONCATENATE", "KW_CONF", "KW_CONSTRAINT", "KW_CONTINUE", 
		"KW_CREATE", "KW_CROSS", "KW_CUBE", "KW_CURRENT", "KW_CURRENT_DATE", "KW_CURRENT_TIMESTAMP", 
		"KW_CURSOR", "KW_DATA", "KW_DATABASE", "KW_DATABASES", "KW_DATE", "KW_DATETIME", 
		"KW_DAY", "KW_DBPROPERTIES", "KW_DECIMAL", "KW_DEFAULT", "KW_DEFERRED", 
		"KW_DEFINED", "KW_DELETE", "KW_DELIMITED", "KW_DEPENDENCY", "KW_DESC", 
		"KW_DESCRIBE", "KW_DETAIL", "KW_DIRECTORIES", "KW_DIRECTORY", "KW_DISABLE", 
		"KW_DISTINCT", "KW_DISTRIBUTE", "KW_DO", "KW_DOUBLE", "KW_DOW", "KW_DROP", 
		"KW_DUMP", "KW_ELEM_TYPE", "KW_ELSE", "KW_ENABLE", "KW_END", "KW_ENFORCED", 
		"KW_ESCAPED", "KW_EXCEPT", "KW_EXCHANGE", "KW_EXCLUSIVE", "KW_EXISTS", 
		"KW_EXPLAIN", "KW_EXPORT", "KW_EXPRESSION", "KW_EXTENDED", "KW_EXTERNAL", 
		"KW_EXTRACT", "KW_FALSE", "KW_FETCH", "KW_FIELDS", "KW_FILE", "KW_FILEFORMAT", 
		"KW_FIRST", "KW_FLOAT", "KW_FLOOR", "KW_FOLLOWING", "KW_FOR", "KW_FOREIGN", 
		"KW_FORMAT", "KW_FORMATTED", "KW_FROM", "KW_FULL", "KW_FUNCTION", "KW_FUNCTIONS", 
		"KW_GRANT", "KW_GROUP", "KW_GROUPING", "KW_HAVING", "KW_HOUR", "KW_IDXPROPERTIES", 
		"KW_IF", "KW_IMPORT", "KW_IN", "KW_INDEX", "KW_INDEXES", "KW_INNER", "KW_INPATH", 
		"KW_INPUTDRIVER", "KW_INPUTFORMAT", "KW_INSERT", "KW_INT", "KW_INTERSECT", 
		"KW_INTERVAL", "KW_INTO", "KW_IS", "KW_ISOLATION", "KW_ITEMS", "KW_JAR", 
		"KW_JOIN", "KW_KEY", "KW_KEYS", "KW_KEY_TYPE", "KW_KILL", "KW_LAST", "KW_LATERAL", 
		"KW_LEFT", "KW_LESS", "KW_LEVEL", "KW_LIKE", "KW_LIMIT", "KW_LINES", "KW_LOAD", 
		"KW_LOCAL", "KW_LOCATION", "KW_LOCK", "KW_LOCKS", "KW_LOGICAL", "KW_LONG", 
		"KW_MACRO", "KW_MANAGEMENT", "KW_MAP", "KW_MAPJOIN", "KW_MAPPING", "KW_MATCHED", 
		"KW_MATERIALIZED", "KW_MERGE", "KW_METADATA", "KW_MINUS", "KW_MINUTE", 
		"KW_MONTH", "KW_MORE", "KW_MOVE", "KW_MSCK", "KW_NONE", "KW_NORELY", "KW_NOSCAN", 
		"KW_NOT", "KW_NOVALIDATE", "KW_NULL", "KW_NULLS", "KW_OF", "KW_OFFSET", 
		"KW_ON", "KW_ONLY", "KW_OPERATOR", "KW_OPTION", "KW_OR", "KW_ORDER", "KW_OUT", 
		"KW_OUTER", "KW_OUTPUTDRIVER", "KW_OUTPUTFORMAT", "KW_OVER", "KW_OVERWRITE", 
		"KW_OWNER", "KW_PARTITION", "KW_PARTITIONED", "KW_PARTITIONS", "KW_PATH", 
		"KW_PERCENT", "KW_PLAN", "KW_PLANS", "KW_PLUS", "KW_POOL", "KW_PRECEDING", 
		"KW_PRECISION", "KW_PRESERVE", "KW_PRIMARY", "KW_PRINCIPALS", "KW_PROCEDURE", 
		"KW_PURGE", "KW_QUARTER", "KW_QUERY", "KW_QUERY_PARALLELISM", "KW_RANGE", 
		"KW_READ", "KW_READS", "KW_REBUILD", "KW_RECORDREADER", "KW_RECORDWRITER", 
		"KW_REDUCE", "KW_REFERENCES", "KW_REGEXP", "KW_RELOAD", "KW_RELY", "KW_RENAME", 
		"KW_REOPTIMIZATION", "KW_REPAIR", "KW_REPL", "KW_REPLACE", "KW_REPLICATION", 
		"KW_RESOURCE", "KW_RESTRICT", "KW_REVOKE", "KW_REWRITE", "KW_RIGHT", "KW_RLIKE", 
		"KW_ROLE", "KW_ROLES", "KW_ROLLBACK", "KW_ROLLUP", "KW_ROW", "KW_ROWS", 
		"KW_SCHEDULING_POLICY", "KW_SCHEMA", "KW_SCHEMAS", "KW_SECOND", "KW_SELECT", 
		"KW_SEMI", "KW_SERDE", "KW_SERDEPROPERTIES", "KW_SERVER", "KW_SET", "KW_SETS", 
		"KW_SHARED", "KW_SHOW", "KW_SHOW_DATABASE", "KW_SKEWED", "KW_SMALLINT", 
		"KW_SNAPSHOT", "KW_SORT", "KW_SORTED", "KW_SSL", "KW_START", "KW_STATISTICS", 
		"KW_STATUS", "KW_STORED", "KW_STREAMTABLE", "KW_STRING", "KW_STRUCT", 
		"KW_SUMMARY", "KW_SYNC", "KW_TABLE", "KW_TABLES", "KW_TABLESAMPLE", "KW_TBLPROPERTIES", 
		"KW_TEMPORARY", "KW_TERMINATED", "KW_THEN", "KW_TIME", "KW_TIMESTAMP", 
		"KW_TIMESTAMPLOCALTZ", "KW_TINYINT", "KW_TO", "KW_TOUCH", "KW_TRANSACTION", 
		"KW_TRANSACTIONS", "KW_TRANSFORM", "KW_TRIGGER", "KW_TRUE", "KW_TRUNCATE", 
		"KW_UNARCHIVE", "KW_UNBOUNDED", "KW_UNDO", "KW_UNION", "KW_UNIONTYPE", 
		"KW_UNIQUE", "KW_UNIQUEJOIN", "KW_UNLOCK", "KW_UNMANAGED", "KW_UNSET", 
		"KW_UNSIGNED", "KW_UPDATE", "KW_URI", "KW_USE", "KW_USER", "KW_USING", 
		"KW_UTC", "KW_UTCTIMESTAMP", "KW_VALIDATE", "KW_VALUES", "KW_VALUE_TYPE", 
		"KW_VARCHAR", "KW_VECTORIZATION", "KW_VIEW", "KW_VIEWS", "KW_WAIT", "KW_WEEK", 
		"KW_WHEN", "KW_WHERE", "KW_WHILE", "KW_WINDOW", "KW_WITH", "KW_WORK", 
		"KW_WORKLOAD", "KW_WRITE", "KW_YEAR", "KW_ZONE", "LCURLY", "LESSTHAN", 
		"LESSTHANOREQUALTO", "LINE_COMMENT", "LPAREN", "LSQUARE", "Letter", "MINUS", 
		"MOD", "NOTEQUAL", "Number", "NumberLiteral", "PLUS", "QUERY_HINT", "QUESTION", 
		"QuotedIdentifier", "RCURLY", "RPAREN", "RSQUARE", "RegexComponent", "SEMICOLON", 
		"STAR", "StringLiteral", "TILDE", "WS", "TOK_HINT", "TOK_HINTARGLIST", 
		"TOK_HINTLIST", "TOK_LEFTSEMIJOIN", "TOK_MAPJOIN", "TOK_STREAMTABLE"
	};
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
	public static final int TOK_HINT=382;
	public static final int TOK_HINTARGLIST=383;
	public static final int TOK_HINTLIST=384;
	public static final int TOK_LEFTSEMIJOIN=385;
	public static final int TOK_MAPJOIN=386;
	public static final int TOK_STREAMTABLE=387;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public HintParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public HintParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return HintParser.tokenNames; }
	@Override public String getGrammarFileName() { return "org/apache/hadoop/hive/ql/parse/HintParser.g"; }


	  ArrayList<ParseError> errors = new ArrayList<ParseError>();

	  @Override
	  public void displayRecognitionError(String[] tokenNames,
	                                      RecognitionException e) {
	    errors.add(new ParseError(this, e, tokenNames));
	  }


	public static class hint_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "hint"
	// org/apache/hadoop/hive/ql/parse/HintParser.g:56:1: hint : hintList EOF -> ^( TOK_HINTLIST hintList ) ;
	public final HintParser.hint_return hint() throws RecognitionException {
		HintParser.hint_return retval = new HintParser.hint_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token EOF2=null;
		ParserRuleReturnScope hintList1 =null;

		ASTNode EOF2_tree=null;
		RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
		RewriteRuleSubtreeStream stream_hintList=new RewriteRuleSubtreeStream(adaptor,"rule hintList");

		try {
			// org/apache/hadoop/hive/ql/parse/HintParser.g:57:5: ( hintList EOF -> ^( TOK_HINTLIST hintList ) )
			// org/apache/hadoop/hive/ql/parse/HintParser.g:57:7: hintList EOF
			{
			pushFollow(FOLLOW_hintList_in_hint107);
			hintList1=hintList();
			state._fsp--;

			stream_hintList.add(hintList1.getTree());
			EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_hint109);  
			stream_EOF.add(EOF2);

			// AST REWRITE
			// elements: hintList
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 57:20: -> ^( TOK_HINTLIST hintList )
			{
				// org/apache/hadoop/hive/ql/parse/HintParser.g:57:23: ^( TOK_HINTLIST hintList )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_HINTLIST, "TOK_HINTLIST"), root_1);
				adaptor.addChild(root_1, stream_hintList.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (ASTNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "hint"


	public static class hintList_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "hintList"
	// org/apache/hadoop/hive/ql/parse/HintParser.g:60:1: hintList : hintItem ( COMMA hintItem )* -> ( hintItem )+ ;
	public final HintParser.hintList_return hintList() throws RecognitionException {
		HintParser.hintList_return retval = new HintParser.hintList_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token COMMA4=null;
		ParserRuleReturnScope hintItem3 =null;
		ParserRuleReturnScope hintItem5 =null;

		ASTNode COMMA4_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_hintItem=new RewriteRuleSubtreeStream(adaptor,"rule hintItem");

		try {
			// org/apache/hadoop/hive/ql/parse/HintParser.g:61:5: ( hintItem ( COMMA hintItem )* -> ( hintItem )+ )
			// org/apache/hadoop/hive/ql/parse/HintParser.g:62:5: hintItem ( COMMA hintItem )*
			{
			pushFollow(FOLLOW_hintItem_in_hintList138);
			hintItem3=hintItem();
			state._fsp--;

			stream_hintItem.add(hintItem3.getTree());
			// org/apache/hadoop/hive/ql/parse/HintParser.g:62:14: ( COMMA hintItem )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==COMMA) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// org/apache/hadoop/hive/ql/parse/HintParser.g:62:15: COMMA hintItem
					{
					COMMA4=(Token)match(input,COMMA,FOLLOW_COMMA_in_hintList141);  
					stream_COMMA.add(COMMA4);

					pushFollow(FOLLOW_hintItem_in_hintList143);
					hintItem5=hintItem();
					state._fsp--;

					stream_hintItem.add(hintItem5.getTree());
					}
					break;

				default :
					break loop1;
				}
			}

			// AST REWRITE
			// elements: hintItem
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 62:32: -> ( hintItem )+
			{
				if ( !(stream_hintItem.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_hintItem.hasNext() ) {
					adaptor.addChild(root_0, stream_hintItem.nextTree());
				}
				stream_hintItem.reset();

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (ASTNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "hintList"


	public static class hintItem_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "hintItem"
	// org/apache/hadoop/hive/ql/parse/HintParser.g:65:1: hintItem : hintName ( LPAREN hintArgs RPAREN )? -> ^( TOK_HINT hintName ( hintArgs )? ) ;
	public final HintParser.hintItem_return hintItem() throws RecognitionException {
		HintParser.hintItem_return retval = new HintParser.hintItem_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token LPAREN7=null;
		Token RPAREN9=null;
		ParserRuleReturnScope hintName6 =null;
		ParserRuleReturnScope hintArgs8 =null;

		ASTNode LPAREN7_tree=null;
		ASTNode RPAREN9_tree=null;
		RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
		RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
		RewriteRuleSubtreeStream stream_hintName=new RewriteRuleSubtreeStream(adaptor,"rule hintName");
		RewriteRuleSubtreeStream stream_hintArgs=new RewriteRuleSubtreeStream(adaptor,"rule hintArgs");

		try {
			// org/apache/hadoop/hive/ql/parse/HintParser.g:66:5: ( hintName ( LPAREN hintArgs RPAREN )? -> ^( TOK_HINT hintName ( hintArgs )? ) )
			// org/apache/hadoop/hive/ql/parse/HintParser.g:67:5: hintName ( LPAREN hintArgs RPAREN )?
			{
			pushFollow(FOLLOW_hintName_in_hintItem171);
			hintName6=hintName();
			state._fsp--;

			stream_hintName.add(hintName6.getTree());
			// org/apache/hadoop/hive/ql/parse/HintParser.g:67:14: ( LPAREN hintArgs RPAREN )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==LPAREN) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// org/apache/hadoop/hive/ql/parse/HintParser.g:67:15: LPAREN hintArgs RPAREN
					{
					LPAREN7=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_hintItem174);  
					stream_LPAREN.add(LPAREN7);

					pushFollow(FOLLOW_hintArgs_in_hintItem176);
					hintArgs8=hintArgs();
					state._fsp--;

					stream_hintArgs.add(hintArgs8.getTree());
					RPAREN9=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_hintItem178);  
					stream_RPAREN.add(RPAREN9);

					}
					break;

			}

			// AST REWRITE
			// elements: hintName, hintArgs
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 67:40: -> ^( TOK_HINT hintName ( hintArgs )? )
			{
				// org/apache/hadoop/hive/ql/parse/HintParser.g:67:43: ^( TOK_HINT hintName ( hintArgs )? )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_HINT, "TOK_HINT"), root_1);
				adaptor.addChild(root_1, stream_hintName.nextTree());
				// org/apache/hadoop/hive/ql/parse/HintParser.g:67:63: ( hintArgs )?
				if ( stream_hintArgs.hasNext() ) {
					adaptor.addChild(root_1, stream_hintArgs.nextTree());
				}
				stream_hintArgs.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (ASTNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "hintItem"


	public static class hintName_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "hintName"
	// org/apache/hadoop/hive/ql/parse/HintParser.g:70:1: hintName : ( KW_MAPJOIN -> TOK_MAPJOIN | KW_SEMI -> TOK_LEFTSEMIJOIN | KW_STREAMTABLE -> TOK_STREAMTABLE );
	public final HintParser.hintName_return hintName() throws RecognitionException {
		HintParser.hintName_return retval = new HintParser.hintName_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token KW_MAPJOIN10=null;
		Token KW_SEMI11=null;
		Token KW_STREAMTABLE12=null;

		ASTNode KW_MAPJOIN10_tree=null;
		ASTNode KW_SEMI11_tree=null;
		ASTNode KW_STREAMTABLE12_tree=null;
		RewriteRuleTokenStream stream_KW_MAPJOIN=new RewriteRuleTokenStream(adaptor,"token KW_MAPJOIN");
		RewriteRuleTokenStream stream_KW_STREAMTABLE=new RewriteRuleTokenStream(adaptor,"token KW_STREAMTABLE");
		RewriteRuleTokenStream stream_KW_SEMI=new RewriteRuleTokenStream(adaptor,"token KW_SEMI");

		try {
			// org/apache/hadoop/hive/ql/parse/HintParser.g:71:5: ( KW_MAPJOIN -> TOK_MAPJOIN | KW_SEMI -> TOK_LEFTSEMIJOIN | KW_STREAMTABLE -> TOK_STREAMTABLE )
			int alt3=3;
			switch ( input.LA(1) ) {
			case KW_MAPJOIN:
				{
				alt3=1;
				}
				break;
			case KW_SEMI:
				{
				alt3=2;
				}
				break;
			case KW_STREAMTABLE:
				{
				alt3=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// org/apache/hadoop/hive/ql/parse/HintParser.g:72:5: KW_MAPJOIN
					{
					KW_MAPJOIN10=(Token)match(input,KW_MAPJOIN,FOLLOW_KW_MAPJOIN_in_hintName212);  
					stream_KW_MAPJOIN.add(KW_MAPJOIN10);

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
					// 72:16: -> TOK_MAPJOIN
					{
						adaptor.addChild(root_0, (ASTNode)adaptor.create(TOK_MAPJOIN, "TOK_MAPJOIN"));
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// org/apache/hadoop/hive/ql/parse/HintParser.g:73:7: KW_SEMI
					{
					KW_SEMI11=(Token)match(input,KW_SEMI,FOLLOW_KW_SEMI_in_hintName224);  
					stream_KW_SEMI.add(KW_SEMI11);

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
					// 73:15: -> TOK_LEFTSEMIJOIN
					{
						adaptor.addChild(root_0, (ASTNode)adaptor.create(TOK_LEFTSEMIJOIN, "TOK_LEFTSEMIJOIN"));
					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// org/apache/hadoop/hive/ql/parse/HintParser.g:74:7: KW_STREAMTABLE
					{
					KW_STREAMTABLE12=(Token)match(input,KW_STREAMTABLE,FOLLOW_KW_STREAMTABLE_in_hintName236);  
					stream_KW_STREAMTABLE.add(KW_STREAMTABLE12);

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
					// 74:22: -> TOK_STREAMTABLE
					{
						adaptor.addChild(root_0, (ASTNode)adaptor.create(TOK_STREAMTABLE, "TOK_STREAMTABLE"));
					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (ASTNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "hintName"


	public static class hintArgs_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "hintArgs"
	// org/apache/hadoop/hive/ql/parse/HintParser.g:77:1: hintArgs : hintArgName ( COMMA hintArgName )* -> ^( TOK_HINTARGLIST ( hintArgName )+ ) ;
	public final HintParser.hintArgs_return hintArgs() throws RecognitionException {
		HintParser.hintArgs_return retval = new HintParser.hintArgs_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token COMMA14=null;
		ParserRuleReturnScope hintArgName13 =null;
		ParserRuleReturnScope hintArgName15 =null;

		ASTNode COMMA14_tree=null;
		RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
		RewriteRuleSubtreeStream stream_hintArgName=new RewriteRuleSubtreeStream(adaptor,"rule hintArgName");

		try {
			// org/apache/hadoop/hive/ql/parse/HintParser.g:78:5: ( hintArgName ( COMMA hintArgName )* -> ^( TOK_HINTARGLIST ( hintArgName )+ ) )
			// org/apache/hadoop/hive/ql/parse/HintParser.g:79:5: hintArgName ( COMMA hintArgName )*
			{
			pushFollow(FOLLOW_hintArgName_in_hintArgs261);
			hintArgName13=hintArgName();
			state._fsp--;

			stream_hintArgName.add(hintArgName13.getTree());
			// org/apache/hadoop/hive/ql/parse/HintParser.g:79:17: ( COMMA hintArgName )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==COMMA) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// org/apache/hadoop/hive/ql/parse/HintParser.g:79:18: COMMA hintArgName
					{
					COMMA14=(Token)match(input,COMMA,FOLLOW_COMMA_in_hintArgs264);  
					stream_COMMA.add(COMMA14);

					pushFollow(FOLLOW_hintArgName_in_hintArgs266);
					hintArgName15=hintArgName();
					state._fsp--;

					stream_hintArgName.add(hintArgName15.getTree());
					}
					break;

				default :
					break loop4;
				}
			}

			// AST REWRITE
			// elements: hintArgName
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (ASTNode)adaptor.nil();
			// 79:38: -> ^( TOK_HINTARGLIST ( hintArgName )+ )
			{
				// org/apache/hadoop/hive/ql/parse/HintParser.g:79:41: ^( TOK_HINTARGLIST ( hintArgName )+ )
				{
				ASTNode root_1 = (ASTNode)adaptor.nil();
				root_1 = (ASTNode)adaptor.becomeRoot((ASTNode)adaptor.create(TOK_HINTARGLIST, "TOK_HINTARGLIST"), root_1);
				if ( !(stream_hintArgName.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_hintArgName.hasNext() ) {
					adaptor.addChild(root_1, stream_hintArgName.nextTree());
				}
				stream_hintArgName.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (ASTNode)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (ASTNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "hintArgs"


	public static class hintArgName_return extends ParserRuleReturnScope {
		ASTNode tree;
		@Override
		public ASTNode getTree() { return tree; }
	};


	// $ANTLR start "hintArgName"
	// org/apache/hadoop/hive/ql/parse/HintParser.g:82:1: hintArgName : ( Identifier | Number | KW_NONE );
	public final HintParser.hintArgName_return hintArgName() throws RecognitionException {
		HintParser.hintArgName_return retval = new HintParser.hintArgName_return();
		retval.start = input.LT(1);

		ASTNode root_0 = null;

		Token set16=null;

		ASTNode set16_tree=null;

		try {
			// org/apache/hadoop/hive/ql/parse/HintParser.g:83:5: ( Identifier | Number | KW_NONE )
			// org/apache/hadoop/hive/ql/parse/HintParser.g:
			{
			root_0 = (ASTNode)adaptor.nil();


			set16=input.LT(1);
			if ( input.LA(1)==Identifier||input.LA(1)==KW_NONE||input.LA(1)==Number ) {
				input.consume();
				adaptor.addChild(root_0, (ASTNode)adaptor.create(set16));
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

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (ASTNode)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "hintArgName"

	// Delegated rules



	public static final BitSet FOLLOW_hintList_in_hint107 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_hint109 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_hintItem_in_hintList138 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_COMMA_in_hintList141 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x4000000000000000L,0x0000000000000000L,0x0000010000200000L});
	public static final BitSet FOLLOW_hintItem_in_hintList143 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_hintName_in_hintItem171 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000020000000000L});
	public static final BitSet FOLLOW_LPAREN_in_hintItem174 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000400L,0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_hintArgs_in_hintItem176 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000000L,0x0040000000000000L});
	public static final BitSet FOLLOW_RPAREN_in_hintItem178 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_MAPJOIN_in_hintName212 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_SEMI_in_hintName224 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KW_STREAMTABLE_in_hintName236 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_hintArgName_in_hintArgs261 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_COMMA_in_hintArgs264 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000000L,0x0000000000000000L,0x0000000000000400L,0x0000000000000000L,0x0000800000000000L});
	public static final BitSet FOLLOW_hintArgName_in_hintArgs266 = new BitSet(new long[]{0x0000000000000202L});
}
