<%-- 
    Document   : adminpage
    Created on : Nov 14, 2015, 5:11:51 PM
    Author     : KOKOKRUNCH
--%>
<%@page import="model.StudentLogger"%>
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
            DatabaseHandler dbHandler = new DatabaseHandler(dbDriver);
            session.setAttribute("dbHandler", dbHandler);
            ArrayList<Report> empList = StudentLogger.getAllReport(dbHandler);
            Iterator<Report> itr = null;
            if(empList!=null){
                itr = empList.iterator();
            }
     %>
    <body>
        <a href='index.jsp'>Log out</a>
        <h1>Create Member</h1>
        <form name="createMember" action="create" method="POST">
            ID : <input type="text" name="id" value="" size="10" />
            <br>
            Password : <input type="password" name="pwd" value="" size="20" />
            <br>
            Name : <input type="text" name="name" value="" size="20" />
            <br>
            Address : <input type="text" name="address" value="" size="100" />
            <br>
            Faculty : <input type="text" name="faculty" value="" size="20"/>
            <br><br>
            <input type="submit" name="submit" value="Create" />
        </form>
        <br><br>
        <h1>Edit&Delete</h1>
        <form name="edit" action="editMember.jsp" method="POST">
            <input type="text" name="id" value="" /><br>
            <input type="submit" value="submit" name="submit" />
        </form>
        <br><br><br>
        <h1>Report</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Report</th>                
            </tr>
            <%
                while(itr!=null && itr.hasNext()){
                    re = itr.next();
                    out.println("<tr>");
                    out.println("<td>"+re.getStdid()+"</td>");
                    out.println("<td><a href='editMember.jsp?report=y&id="+re.getStdid()+"'>"+re.getReport()+"</a></td>");               
                    out.println("</tr>");                
                }
            %>
        </table>
    </body>
</html>
