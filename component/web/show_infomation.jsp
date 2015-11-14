<%-- 
    Document   : show_infomation
    Created on : Nov 14, 2015, 3:13:23 PM
    Author     : KOKOKRUNCH
--%>
<%@page import="model.AccountS"%>
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
        <title>JSP Page</title>
    </head>
     <jsp:useBean id="emp" class="model.AccountS" scope="request"/>
    <%
            DatabaseDriver dbDriver = (DatabaseDriver)this.getServletContext().getAttribute("dbDriver");
            /*DatabaseHandler dbHandler = (DatabaseHandler) session.getAttribute("dbHandler");
            if (dbHandler == null) {
                dbHandler = new DatabaseHandler(dbDriver);
                session.setAttribute("dbHandler", dbHandler);
            }*/
            DatabaseHandler dbHandler = new DatabaseHandler(dbDriver);
            ArrayList<AccountS> empList = Student.getStudentById(dbHandler,request.getParameter("username"));
            Iterator<AccountS> itr = empList.iterator();
     %>
    <body>
        <h1>Student Information</h1>
         <%
         while(itr.hasNext()) {
            emp = itr.next();
            out.println("Id      : "+emp.getId()+"<br>");
            out.println("Nanme   : "+emp.getName()+"<br>");
            out.println("Address : "+emp.getAddress()+"<br>");
            out.println("Faculty : "+emp.getFaculty()+"<br>");
         }
         dbHandler.closeDatabase();
         %>
         <br><br>
         <H1>Report</H1>
         <form name="report" action="report_servlet" method="POST">
             <textarea name="text_report" rows="5" cols="20">
             </textarea><br>
             <input type="submit" value="Submit" name="submit" />
             <input type="reset" value="Clear" />
         </form>
    </body>
</html>
