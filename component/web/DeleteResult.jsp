<%-- 
    Document   : DeleteResult
    Created on : Nov 14, 2015, 11:45:44 PM
    Author     : Sakdinan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%=request.getAttribute("rowDeleted") + " row is deleted " %> </h1>
        <a href="adminpage.jsp">Back to Admin Page</a>
    </body>
</html>
