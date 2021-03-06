// Autogenerated Jamon proxy
// /home/forsre/git/apache-hive-3.1.2-src/service/src/jamon/org/apache/hive/tmpl/QueryProfileTmpl.jamon

package org.apache.hive.tmpl;

// 24, 1
import java.util.*;
// 25, 1
import org.apache.hadoop.hive.ql.QueryDisplay;
// 26, 1
import org.apache.hadoop.hive.ql.QueryInfo;
// 27, 1
import org.apache.hadoop.hive.conf.HiveConf;

@org.jamon.annotations.Template(
  signature = "8FB8F55A37EB966A1C418DBEC0465527",
  requiredArguments = {
    @org.jamon.annotations.Argument(name = "queryInfo", type = "QueryInfo"),
    @org.jamon.annotations.Argument(name = "hiveConf", type = "HiveConf")})
public class QueryProfileTmpl
  extends org.jamon.AbstractTemplateProxy
{
  
  public QueryProfileTmpl(org.jamon.TemplateManager p_manager)
  {
     super(p_manager);
  }
  
  public QueryProfileTmpl()
  {
     super("/org/apache/hive/tmpl/QueryProfileTmpl");
  }
  
  protected interface Intf
    extends org.jamon.AbstractTemplateProxy.Intf{
    
    void renderNoFlush(final java.io.Writer jamonWriter) throws java.io.IOException;
    
  }
  public static class ImplData
    extends org.jamon.AbstractTemplateProxy.ImplData
  {
    // 20, 1
    public void setQueryInfo(QueryInfo queryInfo)
    {
      // 20, 1
      m_queryInfo = queryInfo;
    }
    public QueryInfo getQueryInfo()
    {
      return m_queryInfo;
    }
    private QueryInfo m_queryInfo;
    // 21, 1
    public void setHiveConf(HiveConf hiveConf)
    {
      // 21, 1
      m_hiveConf = hiveConf;
    }
    public HiveConf getHiveConf()
    {
      return m_hiveConf;
    }
    private HiveConf m_hiveConf;
  }
  @Override
  protected ImplData makeImplData()
  {
    return new ImplData();
  }
  @Override @SuppressWarnings("unchecked") public ImplData getImplData()
  {
    return (ImplData) super.getImplData();
  }
  
  
  @Override
  public org.jamon.AbstractTemplateImpl constructImpl(Class<? extends org.jamon.AbstractTemplateImpl> p_class){
    try
    {
      return p_class
        .getConstructor(new Class [] { org.jamon.TemplateManager.class, ImplData.class })
        .newInstance(new Object [] { getTemplateManager(), getImplData()});
    }
    catch (RuntimeException e)
    {
      throw e;
    }
    catch (Exception e)
    {
      throw new RuntimeException(e);
    }
  }
  
  @Override
  protected org.jamon.AbstractTemplateImpl constructImpl(){
    return new QueryProfileTmplImpl(getTemplateManager(), getImplData());
  }
  public org.jamon.Renderer makeRenderer(final QueryInfo queryInfo, final HiveConf hiveConf)
  {
    return new org.jamon.AbstractRenderer() {
      @Override
      public void renderTo(final java.io.Writer jamonWriter)
        throws java.io.IOException
      {
        render(jamonWriter, queryInfo, hiveConf);
      }
    };
  }
  
  public void render(final java.io.Writer jamonWriter, final QueryInfo queryInfo, final HiveConf hiveConf)
    throws java.io.IOException
  {
    renderNoFlush(jamonWriter, queryInfo, hiveConf);
    jamonWriter.flush();
  }
  public void renderNoFlush(final java.io.Writer jamonWriter, final QueryInfo queryInfo, final HiveConf hiveConf)
    throws java.io.IOException
  {
    ImplData implData = getImplData();
    implData.setQueryInfo(queryInfo);
    implData.setHiveConf(hiveConf);
    Intf instance = (Intf) getTemplateManager().constructImpl(this);
    instance.renderNoFlush(jamonWriter);
    reset();
  }
  
  
}
