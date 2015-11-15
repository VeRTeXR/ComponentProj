<%-- 
    Document   : editMember
    Created on : Nov 14, 2015, 5:57:19 PM
    Author     : KOKOKRUNCH
--%>
<%@page import="helperclasses.UpdatingRecord"%>
<%@page import="model.Student"%>
<%@page import="model.StudentLogger"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="utilities.DatabaseHandler"%>
<%@page import="utilities.DatabaseDriver"%>
<%@page import="model.Report"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Member</title>
    </head>
    <body>
    <center>
        <h2>Edit and Delete your member</h2>
        <%
            DatabaseDriver dbDriver = (DatabaseDriver)this.getServletContext().getAttribute("dbDriver");
            DatabaseHandler dbHandler = new DatabaseHandler(dbDriver);
            Student std = new Student();
            synchronized(this.getServletContext()) {
                if (UpdatingRecord.isUpdating(this.getServletContext(), Integer.parseInt(request.getParameter("id")))) {
                    dbHandler.closeDatabase();
                    request.getRequestDispatcher("notifylocked.jsp").forward(request, response);
                }
            ArrayList<Student> stdList = StudentLogger.findStudent(dbHandler,new Integer(request.getParameter("id")));
            Iterator<Student> itr = stdList.iterator();
            std = itr.next();
            session.setAttribute("id", request.getParameter("id"));
            session.setAttribute("report", request.getParameter("report"));
            }
        %>
        <form action="confirmEdit_" method="POST">
            ID : <input type="text" name="id" value="<%=request.getParameter("id")%>"/><br><br>
            Name :<input type="text" name="name" value="<%=std.getName()%>" /><br><br>
            Address :<textarea name="address" rows="10" cols="40"><%=std.getAddress()%></textarea><br><br>
            Faculty :<input type="text" name="faculty" value="<%=std.getFaculty()%>" /><br><br>
            <input type="submit" value="submit" name="submit" />
            <input type="submit" value="delete" name="delete" />
        </form>
    </center>
    </body>
</html>
