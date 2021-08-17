package org.apache.hive.generated.hiveserver2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.conf.HiveConf.ConfVars;
import org.apache.hive.common.util.HiveVersionInfo;
import org.apache.hive.http.HttpServer;
import org.apache.hive.service.cli.operation.Operation;
import org.apache.hive.service.cli.operation.SQLOperation;
import org.apache.hadoop.hive.ql.QueryInfo;
import org.apache.hive.service.cli.session.SessionManager;
import org.apache.hive.service.cli.session.HiveSession;
import javax.servlet.ServletContext;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import jodd.util.HtmlEncoder;

public final class hiveserver2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n\n\n");

ServletContext ctx = getServletContext();
Configuration conf = (Configuration)ctx.getAttribute("hive.conf");
long startcode = conf.getLong("startcode", System.currentTimeMillis());
SessionManager sessionManager =
  (SessionManager)ctx.getAttribute("hive.sm");
String remoteUser = request.getRemoteUser();

      out.write("\n\n<!--[if IE]>\n<!DOCTYPE html>\n<![endif]-->\n<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n<html lang=\"en\">\n  <head>\n    <meta charset=\"utf-8\">\n    <title>HiveServer2</title>\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <meta name=\"description\" content=\"\">\n\n    <link href=\"/static/css/bootstrap.min.css\" rel=\"stylesheet\">\n    <link href=\"/static/css/bootstrap-theme.min.css\" rel=\"stylesheet\">\n    <link href=\"/static/css/hive.css\" rel=\"stylesheet\">\n  </head>\n\n  <body>\n  <div class=\"navbar  navbar-fixed-top navbar-default\">\n      <div class=\"container\">\n          <div class=\"navbar-header\">\n              <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n                  <span class=\"icon-bar\"></span>\n                  <span class=\"icon-bar\"></span>\n                  <span class=\"icon-bar\"></span>\n              </button>\n              <a class=\"navbar-brand\" href=\"/hiveserver2.jsp\"><img src=\"/static/hive_logo.jpeg\" alt=\"Hive Logo\"/></a>\n          </div>\n");
      out.write("          <div class=\"collapse navbar-collapse\">\n              <ul class=\"nav navbar-nav\">\n                <li class=\"active\"><a href=\"/\">Home</a></li>\n                <li><a href=\"/logs/\">Local logs</a></li>\n                <li><a href=\"/jmx\">Metrics Dump</a></li>\n                <li><a href=\"/conf\">Hive Configuration</a></li>\n                <li><a href=\"/stacks\">Stack Trace</a></li>\n                <li><a href=\"/llap.html\">Llap Daemons</a></li>\n            </ul>\n          </div><!--/.nav-collapse -->\n        </div>\n      </div>\n    </div>\n\n<div class=\"container\">\n    <div class=\"row inner_header\">\n        <div class=\"page-header\">\n            <h1>HiveServer2</h1>\n        </div>\n    </div>\n    <div class=\"row\">\n\n");

if (sessionManager != null) { 
  long currentTime = System.currentTimeMillis();

      out.write(" \n\n<section>\n<h2>Active Sessions</h2>\n<table class=\"table table-striped\">\n    <tr>\n        <th>User Name</th>\n        <th>IP Address</th>\n        <th>Operation Count</th>\n        <th>Active Time (s)</th>\n        <th>Idle Time (s)</th>\n    </tr>\n");

Collection<HiveSession> hiveSessions = sessionManager.getSessions();
int sessionCount = 0;
for (HiveSession hiveSession: hiveSessions) {
    // Permission check
    if (!HttpServer.hasAccess(remoteUser, hiveSession.getUserName(), ctx, request)) {
        continue;
    }
    sessionCount++;

      out.write("\n    <tr>\n        <td>");
      out.print( hiveSession.getUserName() );
      out.write("</td>\n        <td>");
      out.print( hiveSession.getIpAddress() );
      out.write("</td>\n        <td>");
      out.print( hiveSession.getOpenOperationCount() );
      out.write("</td>\n        <td>");
      out.print( (currentTime - hiveSession.getCreationTime())/1000 );
      out.write("</td>\n        <td>");
      out.print( (currentTime - hiveSession.getLastAccessTime())/1000 );
      out.write("</td>\n    </tr>\n");

}

      out.write("\n<tr>\n  <td colspan=\"5\">Total number of sessions: ");
      out.print( sessionCount );
      out.write("</td>\n</tr>\n</table>\n</section>\n\n<section>\n<h2>Open Queries</h2>\n<table class=\"table table-striped\">\n    <tr>\n        <th>User Name</th>\n        <th>Query</th>\n        <th>Execution Engine</th>\n        <th>State</th>\n        <th>Opened Timestamp</th>\n        <th>Opened (s)</th>\n        <th>Latency (s)</th>\n        <th>Drilldown Link</th>\n    </tr>\n    ");

      int queries = 0;
      Collection<QueryInfo> operations = sessionManager.getOperationManager().getLiveQueryInfos();
      for (QueryInfo operation : operations) {
          if (!HttpServer.hasAccess(remoteUser, operation.getUserName(), ctx, request)) {
              continue;
          }
          queries++;
    
      out.write("\n    <tr>\n        <td>");
      out.print( operation.getUserName() );
      out.write("</td>\n        <td>");
      out.print( HtmlEncoder.strict(operation.getQueryDisplay() == null ? "Unknown" : operation.getQueryDisplay().getQueryString()) );
      out.write("</td>\n        <td>");
      out.print( operation.getExecutionEngine() );
      out.write("\n        <td>");
      out.print( operation.getState() );
      out.write("</td>\n        <td>");
      out.print( new Date(operation.getBeginTime()) );
      out.write("</td>\n        <td>");
      out.print( operation.getElapsedTime()/1000 );
      out.write("</td>\n        <td>");
      out.print( operation.getRuntime() == null ? "Not finished" : operation.getRuntime()/1000 );
      out.write("</td>\n        ");
 String link = "/query_page?operationId=" + operation.getOperationId(); 
      out.write("\n        <td>  <a href= ");
      out.print( link );
      out.write(">Drilldown</a> </td>\n    </tr>\n\n");

  }

      out.write("\n<tr>\n  <td colspan=\"8\">Total number of queries: ");
      out.print( queries );
      out.write("</td>\n</tr>\n</table>\n</section>\n\n\n<section>\n<h2>Last Max ");
      out.print( conf.get(ConfVars.HIVE_SERVER2_WEBUI_MAX_HISTORIC_QUERIES.varname) );
      out.write(" Closed Queries</h2>\n<table class=\"table table-striped\">\n    <tr>\n        <th>User Name</th>\n        <th>Query</th>\n        <th>Execution Engine</th>\n        <th>State</th>\n        <th>Opened (s)</th>\n        <th>Closed Timestamp</th>\n        <th>Latency (s)</th>\n        <th>Drilldown Link</th>\n    </tr>\n    ");

      queries = 0;
      operations = sessionManager.getOperationManager().getHistoricalQueryInfos();
      for (QueryInfo operation : operations) {
          if (!HttpServer.hasAccess(remoteUser, operation.getUserName(), ctx, request)) {
              continue;
          }
          queries++;
    
      out.write("\n    <tr>\n        <td>");
      out.print( operation.getUserName() );
      out.write("</td>\n        <td>");
      out.print( HtmlEncoder.strict(operation.getQueryDisplay() == null ? "Unknown" : operation.getQueryDisplay().getQueryString()) );
      out.write("</td>\n        <td>");
      out.print( operation.getExecutionEngine() );
      out.write("\n        <td>");
      out.print( operation.getState() );
      out.write("</td>\n        <td>");
      out.print( operation.getElapsedTime()/1000 );
      out.write("</td>\n        <td>");
      out.print( operation.getEndTime() == null ? "In Progress" : new Date(operation.getEndTime()) );
      out.write("</td>\n        <td>");
      out.print( operation.getRuntime() == null ? "n/a" : operation.getRuntime()/1000 );
      out.write("</td>\n        ");
 String link = "/query_page?operationId=" + operation.getOperationId(); 
      out.write("\n        <td>  <a href= ");
      out.print( link );
      out.write(">Drilldown</a> </td>\n    </tr>\n\n");

  }

      out.write("\n<tr>\n  <td colspan=\"8\">Total number of queries: ");
      out.print( queries );
      out.write("</td>\n</tr>\n</table>\n</section>\n\n");

 }

      out.write("\n\n    <section>\n    <h2>Software Attributes</h2>\n    <table class=\"table table-striped\">\n        <tr>\n            <th>Attribute Name</th>\n            <th>Value</th>\n            <th>Description</th>\n        </tr>\n        <tr>\n            <td>Hive Version</td>\n            <td>");
      out.print( HiveVersionInfo.getVersion() );
      out.write(", r");
      out.print( HiveVersionInfo.getRevision() );
      out.write("</td>\n            <td>Hive version and revision</td>\n        </tr>\n        <tr>\n            <td>Hive Compiled</td>\n            <td>");
      out.print( HiveVersionInfo.getDate() );
      out.write(',');
      out.write(' ');
      out.print( HiveVersionInfo.getUser() );
      out.write("</td>\n            <td>When Hive was compiled and by whom</td>\n        </tr>\n        <tr>\n            <td>HiveServer2 Start Time</td>\n            <td>");
      out.print( new Date(startcode) );
      out.write("</td>\n            <td>Date stamp of when this HiveServer2 was started</td>\n        </tr>\n    </table>\n    </section>\n    </div>\n</div>\n</body>\n</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
