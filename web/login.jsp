<%-- 
    Document   : login
    Created on : 28-11-2017, 16:59:18
    Author     : Matias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <jsp:include page="menu.jsp"></jsp:include>
        </head>
        <body>

            <form action="ServletControlador" method="post">
                <div class="container">
                    <div class="row">
                        <div class="col-md-offset-5 col-md-3">
                            <div class="form-login">
                                <h4>Bienvenido</h4>
                                <input type="text" name="txtUser" class="form-control input-sm chat-input" placeholder="username" />
                                </br>
                                <input type="password" name="txtPass" class="form-control input-sm chat-input" placeholder="password" />
                                </br>
                                <div class="wrapper">

                                    <input type="submit" class="btn btn-primary btn-lg" name="btnAccion" value="Ingresar">

                                </div>
                            ${mensaje}
                        </div>

                    </div>
                </div>
            </div>
        </form>    
    </body>
</html>
