<%-- 
    Document   : error
    Created on : 13-11-2017, 20:40:36
    Author     : Matias
--%>
<%@ page isErrorPage="true" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="menu.jsp"></jsp:include>
        <% if (session != null) {
                session.invalidate();
            }
        %>
    </head>
    <body>
        <div align="center" >
            <h1 class="colorletra">Pagina no disponible</h1>
            <h4 class="colorletra">Contancte con el administrador</h4>
            <h6 class="colorletra"> Mas informacion <a href="Contacto.jsp" >click aqui</a> </h6>
        </div>

    </body>
</html>
