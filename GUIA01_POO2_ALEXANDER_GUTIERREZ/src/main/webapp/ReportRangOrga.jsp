<%-- 
    Document   : ReportRangOrga
    Created on : 08-05-2016, 10:40:49 PM
    Author     : Alexander José
--%>

<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%@page import="com.sv.udb.recursos.Conexion"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte con rango</title>
    </head>
    <body>
        <%
            Connection cn = new Conexion().getConn();
            File reportfile = new File(application.getRealPath("reportes/RangOrg.jasper"));
            Map<String, Object>parameter = new HashMap<String, Object>();
            String Parametro = String.valueOf(request.getParameter("codiRangRadi") == null ? "0" : request.getParameter("codiRangRadi"));
            String Desde = request.getParameter("desde");
            String Hasta = request.getParameter("hasta");
            parameter.put("Org", new String(Parametro));
            parameter.put("Desde", Desde);
            parameter.put("Hasta", Hasta);
            byte[] bytes = JasperRunManager.runReportToPdf(reportfile.getPath(), parameter, cn);
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream output = response.getOutputStream();
            output.write(bytes, 0, bytes.length);
            output.flush();
            output.close();
        %>
    </body>
</html>
