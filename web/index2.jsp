<%-- 
    Document   : index2
    Created on : 29-11-2017, 14:27:54
    Author     : Matias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendedor</title>
        <jsp:include page="menu2.jsp" ></jsp:include>
        </head>
        <body class="body colorletra">
            <!--Cuerpo-->
            <div class="header" >
                <div class="panel-heading" >
                    <div align="center" >
                        <h4> Bienvenido a John Master, Aqui usted encontrara los mejores productos </h4>
                    </div>
                ${mensaje}
                ${totalpagar}
            </div>
        </div>
    </body>
</html>
