<%-- 
    Document   : adminpage
    Created on : Nov 14, 2015, 5:11:51 PM
    Author     : KOKOKRUNCH
--%>
<%@page import="model.Report"%>
<%@page import="model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="utilities.DatabaseDriver"%>
<%@page import="utilities.DatabaseHandler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
   <jsp:useBean id="re" class="model.Report" scope="request"/>
   
    <%
            DatabaseDriver dbDriver = (DatabaseDriver)this.getServletContext().getAttribute("dbDriver");
            /*DatabaseHandler dbHandler = (DatabaseHandler) session.getAttribute("dbHandler");
            if (dbHandler == null) {
                dbHandler = new DatabaseHandler(dbDriver);
                session.setAttribute("dbHandler", dbHandler);
            }*/
            DatabaseHandler dbHandler = new DatabaseHandler(dbDriver);
            ArrayList<Report> empList = Student.getAllReport(dbHandler);
            Iterator<Report> itr = empList.iterator();
     %>
    <body>
        <h1>Create Member</h1>
        <form name="createMember" action="" method="POST">
            ID : <input type="text" name="createID" value="" size="10" />
            <br>
            Password : <input type="password" name="createPassword" value="" size="20" />
            <br>
            Address : <input type="text" name="createAddress" value="" size="100" />
            <br>
            Faculty : <input type="text" name="createFaculty" value="" size="20"/>
            <br><br>
            <input type="submit" name="createsubmit" value="Create" />
        </form>
        <br><br><br>
        <h1>List Request</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Report</th>                
            </tr>
        <%
            while(itr.hasNext()){
                re = itr.next();
                out.println("<tr>");
                out.println("<td>"+re.getStdid()+"</td>");
                out.println("<td><a href='editMember.jsp?id="+re.getStdid()+"'>"+re.getReport()+"</a></td>");               
                out.println("</tr>");                
            }
        %>
        </table>
    </body>
</html>
