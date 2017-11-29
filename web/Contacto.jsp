<%-- 
    Document   : Contacto
    Created on : 16-11-2017, 16:05:33
    Author     : Matias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="menu.jsp"></jsp:include>
            <link rel="stylesheet" href="css/font-awesome.min.css" >
            <link rel="stylesheet" href="css/mycss.css" >
        </head>
        <body>
            <form action="ServletControlador" method="post">
                <div class="container">
                    <div class="row">
                        <div class="col-md-offset-5 col-md-3">
                            <div class="form-login">
                                <h4>Realize su consulta</h4>
                                </br>
                                <input type="email"  required="true" name="txtemail" class="form-control input-sm chat-input" placeholder="Ingresar correo" />
                                </br>
                                <textarea placeholder="Descripcion" tabindex="6" class="form-control input-sm chat-input" name="txtDescripcion" id="mensaje" rows="7" cols="50" name="txtDescripcion"></textarea>
                                </br>
                                </br>
                                <div class="wrapper">
                                    <span class="group-btn">     
                                        <input type="submit" class="btn btn-primary btn-md" name="btnAccion" value="Enviar Problema">
                                    </span>
                                </div>
                                <div>${mensaje}</div>
                        </div>

                    </div>
                </div>
            </div>


        </form>
    </body>
</html>
