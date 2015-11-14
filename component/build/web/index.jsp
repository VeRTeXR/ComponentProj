<%-- 
    Document   : index
    Created on : Nov 14, 2015, 2:34:36 PM
    Author     : KOKOKRUNCH
--%>

<%@page import="utilities.DatabaseDriver"%>
<%@page import="java.sql.SQLException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%!
        private DatabaseDriver dbDriver = null;
        public void jspInit() {
            String derbyClientDriver = "org.apache.derby.jdbc.ClientDriver";
            String url = "jdbc:derby://localhost:1527/accounts";
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
    %>
    <body>
        <form name="student" action="permission" method="POST">
            <input type="text" name="username" value="" /><br>
            <input type="password" name="password" value="" /><br>
            <input type="submit" value="Submit" name="submit" />
            <input type="reset" value="clear" />
        </form>
        <a href="adminpage.jsp">Click</a>
    </body>
</html>
