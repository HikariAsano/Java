<%-- 
    Document   : agregarpedido
    Created on : 27-11-2017, 10:44:32
    Author     : Matias
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar pedido</title>
        <jsp:include page="menu2.jsp"></jsp:include>
        </head>
        <body class="body colorletra">
            <!--Cuerpo-->
            <div class="header" >
                <div class="panel-heading" >
                    <div align="center" >
                        <h4> Bienvenido a John Master, Aqui usted encontrara los mejores productos </h4>
                        <h4> Indiquenos su nombre y rut para identificarlo en el pedido </h4>
                    </div>
                    <div class="panel-body" >
                        <div class="panel-group">
                            <div class="panel-primary" >
                                <div class="form-login">

                                    <!-- no olvidar el form -->
                                    <form method="post" action="ServletControlador" >
                                        <div class="col-md-3" >
                                            <br>
                                            <br>

                                            <input class="form-control input-sm chat-input" type="text" name="txtNombre" placeholder="Nombre" >
                                            <br>
                                            <input class="form-control input-sm chat-input" type="text" name="txtRut" placeholder="Rut">
                                            <br>

                                            <table>
                                                <tr>
                                                    <td>
                                                        <h4>agranda?</h4>
                                                        <input type="radio" name="chkagranda" value="true">si<br>
                                                        <input type="radio" name="chkagranda" value="false">no<br>
                                                    </td>
                                                </tr>
                                            </table>
                                            <table>
                                                <tr>
                                                    <td>
                                                        <h4>Para llevar??</h4>
                                                        <input type="radio" name="chkllevar" value="true">si<br>
                                                        <input type="radio" name="chkllevar" value="false">no<br>
                                                    </td>
                                                </tr>
                                            </table>
                                            <table>
                                                <tr>
                                                    <td>
                                                        <h4>Forma de pago???</h4>
                                                        <input type="radio" name="chkforma" value="Efectivo">Efectivo<br>
                                                        <input type="radio" name="chkforma" value="Tarjeta">Tarjeta debito / Credito<br>
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>

                                        <div class="col-md-offset-3" >
                                            <table>
                                                <tr>
                                                    <td>
                                                        <h4>Seleccione un producto o combo, indique su cantidad y agregue al pedido</h4>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <select class="form-control input-sm chat-input" name="cboProducto">
                                                            <option>Seleccionar</option>
                                                        <c:forEach items="${listaProductos}" var="x">

                                                            <option value="${x.getIdproducto()}">  <c:out value="${x.getDescripcion()}"></c:out> </option>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                                <td>
                                                    <input class="form-control input-sm chat-input"  type="number" name="txtCantidad" >
                                                </td>
                                                <td>
                                                    <input type="submit" class="btn btn-primary btn-md" name="btnAccion" value="Agregar">
                                                </td>
                                            </tr>
                                        </table>
                                        <table class="table table-condensed colorletra" align="center">
                                            <thead class="thead-inverse">
                                                <tr>

                                                    <th>producto: </th>
                                                    <th>cantidad: </th>
                                                    <th>          </th>

                                                </tr>

                                            </thead>
                                           
                                                <c:forEach items="${listaPedidos}" var="a">
                                                    <tr>
                                                    <input type="hidden" name="txtiddp" value="${a.getIddetalle()}" >
                                                    <input type="hidden" name="txtValor" value="${a.getProducto().getValor()}" >
                                                    <td>${a.getProducto().getDescripcion()}</td>
                                                    <td>${a.getPedido().getCantidad()} </td>
                                                    <td>
                                                        <input class="btn btn-primary btn-md" type="submit" name="btnAccion" value="-" >
                                                    </td>
                                                    </tr>
                                                </c:forEach>
                                    
                                            <tr>
                                                <td>Total a pagar: </td>
                                                <td>${totalpagar}</td>
                                            </tr>
                                            <tr>
                                                <td>${mensaje}</td>
                                            </tr>
                                        </table>


                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>



    </body>

</html>
