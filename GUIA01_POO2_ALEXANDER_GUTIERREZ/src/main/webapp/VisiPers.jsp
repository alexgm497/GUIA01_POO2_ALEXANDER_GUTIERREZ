<%-- 
    Document   : UniOrga
    Created on : 08-05-2016, 11:07:49 AM
    Author     : Alexander José
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="com.sv.udb.controlador.UniOrgCtrl"%>
<!DOCTYPE html>
<html>
    <head>
        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visitas por personas</title>
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>
    <body>
        <nav class="teal lighten-2">
            <div class="nav-wrapper">
                <a href="index.jsp" class="brand-logo right">GUIA 1 - POO2</a>
                <ul id="nav-mobile" class="left hide-on-med-and-down">
                    <li><a href="UniOrga.jsp">Visitas a unidades</a></li>
                    <li><a href="#">Visitas por personas</a></li>
                    <li><a href="RangOrga.jsp">Visitas por rango</a></li>
                    <li><a href="RangOrga.jsp">Visitas por rango</a></li>
                    <li><a href="EsquemaBD.html">Esquema BD</a></li>
                </ul>
            </div>
        </nav>
        <br/>
        <br/>
        <br/>
        <br/>
        <div class="container">
            <div class="row">
                <form method="POST" action="ReportVisiPers.jsp" class="col s12">
                    <jsp:useBean id="beanPersVisiCtrl" class="com.sv.udb.controlador.PersVisiCtrl" scope="page"/>
                    <table border="1" class="striped">
                        <thead>
                            <tr>
                                <th class="card-panel teal lighten-2">Nombre</th>
                                <th class="card-panel teal lighten-2">Apellido</th>
                                <th class="card-panel teal lighten-2">DUI</th>
                                <th class="card-panel teal lighten-2">Genero</th>
                                <th class="card-panel teal lighten-2">--</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${beanPersVisiCtrl.consTodo()}" var="fila">
                                <tr>
                                    <td><c:out value="${fila.nombPers}"></c:out></td>
                                    <td><c:out value="${fila.apelPers}"></c:out></td>
                                    <td><c:out value="${fila.duiPers}"></c:out></td>
                                    <td><c:out value="${fila.genePers}"></c:out></td>
                                    <td><p><input id="${fila.idPers}" type="radio" name="codiPersRadi" value="${fila.idPers}"/><label for="${fila.idPers}"></label></p></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <br/>
                    <center><input class="btn waves-effect waves-light" type="submit" name="cursBton" value="Consultar"/></center>
                    <br/>
                </form>
            </div>
        </div>
    </body>
</html>
