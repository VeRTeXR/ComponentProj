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
        <%
            DatabaseDriver dbDriver = (DatabaseDriver)this.getServletContext().getAttribute("dbDriver");
            DatabaseHandler dbHandler = new DatabaseHandler(dbDriver);
            Student std = new Student();
            System.out.println(request.getParameter("id"));
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
            id : <input type="text" name="id" value="<%=request.getParameter("id")%>"/>
            name :<input type="text" name="name" value="<%=std.getName()%>" /><br>
            address :<input type="text" name="address" value="<%=std.getAddress()%>" /><br>
            faculty :<input type="text" name="faculty" value="<%=std.getFaculty()%>" /><br>
            <input type="submit" value="submit" name="submit" />
            <input type="submit" value="delete" name="delete" />
            <input type="submit" value="back" name="back" />

        </form>
    </body>
</html>
