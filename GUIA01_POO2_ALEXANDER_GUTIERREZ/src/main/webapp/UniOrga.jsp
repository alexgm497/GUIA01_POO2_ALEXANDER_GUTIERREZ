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
        <title>Unidades Organizativas</title>
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>
    <body>
        <nav class="teal lighten-2">
            <div class="nav-wrapper">
                <a href="index.jsp" class="brand-logo right">GUIA 1 - POO2</a>
                <ul id="nav-mobile" class="left hide-on-med-and-down">
                    <li><a href="#">Unidades Organizativas</a></li>
                </ul>
            </div>
        </nav>
        <br/>
        <br/>
        <br/>
        <br/>
        <div class="container">
            <form method="POST" action="ReportUniOrg.jsp">
                <jsp:useBean id="beanUniOrgCtrl" class="com.sv.udb.controlador.UniOrgCtrl" scope="page"/>
                <table border="1" class="striped">
                    <thead>
                        <tr>
                            <th class="card-panel teal lighten-2">Nombre</th>
                            <th class="card-panel teal lighten-2">Dirección</th>
                            <th class="card-panel teal lighten-2">Teléfono</th>
                            <th class="card-panel teal lighten-2">FAX</th>
                            <th class="card-panel teal lighten-2">Correo</th>
                            <th class="card-panel teal lighten-2">--</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${beanUniOrgCtrl.consTodo()}" var="fila">
                            <tr>
                                <td><c:out value="${fila.nombUni}"></c:out></td>
                                <td><c:out value="${fila.dirUni}"></c:out></td>
                                <td><c:out value="${fila.telUni}"></c:out></td>
                                <td><c:out value="${fila.faxUni}"></c:out></td>
                                <td><c:out value="${fila.emaUni}"></c:out></td>
                                <td><p><input id="${fila.idUni}" type="radio" name="codiUniRadi" value="${fila.idUni}"/><label for="${fila.idUni}"></label></p></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <br/>
                <center><input class="btn waves-effect waves-light" type="submit" name="cursBton" value="Consultar"/></center>
                <br/>
            </form>
        </div>
    </body>
</html>
