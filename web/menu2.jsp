<%-- 
    Document   : menu2
    Created on : 28-11-2017, 17:21:37
    Author     : Matias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu vendedor</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/mycss.css" >
    </head>
    <body>

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="index2.jsp">John Master</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a  href="index2.jsp">Home</a></li>
                    <li class="active"><a  href="ServletListas?op=pedido">Agregar Pedido</a></li>

                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href=""><span class="glyphicon glyphicon-user"></span>${usuario}</a></li>
                    <li><a href="ServletListas?op=cerrar"><span class="glyphicon glyphicon-log-in"></span>cerrar session</a></li>
                </ul>
            </div>
        </nav>
    </body>
</html>
