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
        <title>Reporte con rango</title>
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>
    <body>
        <nav class="teal lighten-2">
            <div class="nav-wrapper">
                <a href="index.jsp" class="brand-logo right">GUIA 1 - POO2</a>
                <ul id="nav-mobile" class="left hide-on-med-and-down">
                    <li><a href="UniOrga.jsp">Visitas a unidades</a></li>
                    <li><a href="VisiPers.jsp">Visitas por personas</a></li>
                    <li><a href="#">Visitas por rango</a></li>
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
                <form method="POST" action="ReportRangOrga.jsp" class="col s12">
                    <div class="input-field col s6">
                        <label for="FechaDesde">Desde</label>
                        <input type="date" class="datepicker" id="FechaDesde" name="desde">
                    </div>
                    <div class="input-field col s6">
                        <label for="FechaHasta">Hasta</label>
                        <input type="date" class="datepicker" id="FechaHasta" name="hasta">
                    </div>
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
                                    <td><p><input id="${fila.idUni}" type="radio" name="codiRangRadi" value="${fila.idUni}"/><label for="${fila.idUni}"></label></p></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <br/>
                    <center><input class="btn waves-effect waves-light" type="submit" name="cursBton" value="Consultar"/></center>
                    <br/>
                </form>
            </div>
            <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
            <script type="text/javascript" src="js/materialize.min.js"></script>
            <script type="text/javascript" src="js/materialize.js"></script>
            <script>
                $('.datepicker').pickadate({
                    selectMonths: true, // Creates a dropdown to control month
                    selectYears: 15 // Creates a dropdown of 15 years to control year
                });
            </script>   
        </div>
    </body>
</html>
