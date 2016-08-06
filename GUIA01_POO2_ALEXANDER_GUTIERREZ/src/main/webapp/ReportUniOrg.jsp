<%-- 
    Document   : ReportUniOrg
    Created on : 08-05-2016, 04:03:30 PM
    Author     : Alexander José
--%>

<%@page import="java.sql.Connection"%>
<%@page import="com.sv.udb.recursos.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page import="net.sf.jasperreports.engine.*"%>
<%@page import="net.sf.jasperreports.view.JasperViewer"%>
<%@page import="javax.servlet.ServletResponse"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Connection cn = new Conexion().getConn();
            File reportfile = new File(application.getRealPath("reportes/UniOrg.jasper"));
            Map<String, Object>parameter = new HashMap<String, Object>();
            String Parametro = String.valueOf(request.getParameter("codiUniRadi") == null ? "0" : request.getParameter("codiUniRadi"));
            parameter.put("UniOrg", new String(Parametro));
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
