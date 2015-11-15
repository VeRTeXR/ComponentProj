<%-- 
    Document   : result_report
    Created on : Nov 14, 2015, 6:49:57 PM
    Author     : KOKOKRUNCH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%=request.getAttribute("rowInserted") + " row is added " %> </h1>
        <h1>done!</h1><br>
        <a href="show_infomation.jsp">Back to main Page</a>
    </body>
</html>
