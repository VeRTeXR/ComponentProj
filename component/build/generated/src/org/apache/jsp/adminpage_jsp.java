package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import utilities.DatabaseDriver;
import java.sql.SQLException;
import model.Report;
import model.Student;
import java.util.ArrayList;
import java.util.Iterator;
import utilities.DatabaseDriver;
import utilities.DatabaseHandler;

public final class adminpage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


        private DatabaseDriver dbDriver = null;
        public void jspInit() {
            String derbyClientDriver = "org.apache.derby.jdbc.ClientDriver";
            String url = "jdbc:derby://localhost:1527/Component_db";
            String user = "root";
            String passwd = "root";
            
            try {
                    //dbHandler = new DatabaseHandler(derbyClientDriver, url, user, passwd);
                    dbDriver = new DatabaseDriver(derbyClientDriver, url, user, passwd);
            }
            catch (SQLException ex){
                
            }
            catch (ClassNotFoundException ex) {
                
            }
            this.getServletContext().setAttribute("dbDriver", dbDriver);
      }
      public void jspDestroy() {
          /*try {
              dbHandler.closeConnection();
          }
          catch(SQLException ex) {
              
          }*/
                  
      } 
    
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Admin Page</title>\n");
      out.write("    </head>\n");
      out.write("   ");
      model.Report re = null;
      synchronized (request) {
        re = (model.Report) _jspx_page_context.getAttribute("re", PageContext.REQUEST_SCOPE);
        if (re == null){
          re = new model.Report();
          _jspx_page_context.setAttribute("re", re, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("    ");

            DatabaseDriver dbDriver = (DatabaseDriver)this.getServletContext().getAttribute("dbDriver");
            /*DatabaseHandler dbHandler = (DatabaseHandler) session.getAttribute("dbHandler");
            if (dbHandler == null) {
                dbHandler = new DatabaseHandler(dbDriver);
                session.setAttribute("dbHandler", dbHandler);
            }*/
            DatabaseHandler dbHandler = new DatabaseHandler(dbDriver);
            ArrayList<Report> empList = Student.getAllReport(dbHandler);
            Iterator<Report> itr = empList.iterator();
     
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <h1>Create Member</h1>\n");
      out.write("        <form name=\"createMember\" action=\"\" method=\"POST\">\n");
      out.write("            ID : <input type=\"text\" name=\"createID\" value=\"\" size=\"10\" />\n");
      out.write("            <br>\n");
      out.write("            Password : <input type=\"password\" name=\"createPassword\" value=\"\" size=\"20\" />\n");
      out.write("            <br>\n");
      out.write("            Address : <input type=\"text\" name=\"createAddress\" value=\"\" size=\"100\" />\n");
      out.write("            <br>\n");
      out.write("            Faculty : <input type=\"text\" name=\"createFaculty\" value=\"\" size=\"20\"/>\n");
      out.write("            <br><br>\n");
      out.write("            <input type=\"submit\" name=\"createsubmit\" value=\"Create\" />\n");
      out.write("        </form>\n");
      out.write("        <br><br><br>\n");
      out.write("        <h1>List Request</h1>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <th>ID</th>\n");
      out.write("                <th>Report</th>\n");
      out.write("                <th>Approve</th>            \n");
      out.write("            </tr>\n");
      out.write("        ");

            while(itr.hasNext()){
                re = itr.next();
                out.println("<tr>");
                out.println("<td>"+re.getStdid()+"</td>");
                out.println("<td>"+re.getReport()+"</td>");
                out.println("<a href='editMember.jsp?id="+re.getStdid()+"'>Approve</a>");
                out.println("</tr>");                
            }
        
      out.write("\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
