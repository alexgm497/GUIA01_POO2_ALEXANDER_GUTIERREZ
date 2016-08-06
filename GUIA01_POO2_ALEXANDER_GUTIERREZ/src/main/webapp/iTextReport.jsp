<%-- 
    Document   : iTextReport
    Created on : 08-06-2016, 11:38:08 AM
    Author     : Alexander José
--%>

<%@page import="java.io.File"%>
<%@page import="com.itextpdf.text.pdf.PdfPCell"%>
<%@page import="com.itextpdf.text.BaseColor"%>
<%@page import="com.itextpdf.text.FontFactory"%>
<%@page import="com.lowagie.text.pdf.PdfCell"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="com.itextpdf.text.PageSize"%>
<%@page import="com.itextpdf.text.Document"%>
<%@page import="com.itextpdf.text.pdf.PdfPTable"%>
<%@page import="com.itextpdf.text.Paragraph"%>
<%@page import="com.itextpdf.text.Image"%>
<%@page import="com.itextpdf.text.Font"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.sv.udb.recursos.Conexion"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.itextpdf.text.pdf.PdfWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Connection cn = new Conexion().getConn();
            String Consulta = "SELECT CODI_UNID_ORGA, NOMB_UNID_ORGA, DIRE_UNID_ORGA, TELE_UNID_ORGA, FAX_UNID_ORGA, EMAI_UNID_ORGA FROM UNID_ORGA";
            PreparedStatement cmd = cn.prepareStatement(Consulta);
            ResultSet rs = cmd.executeQuery();
            String Encabezado = "\n\n\n\n\n\n\nListado de organizaciones";
            Date Fecha = new Date();
            Font Fuente = new Font(Font.getFamily("ARIAL"),12,Font.BOLD);
            Image Imagen = Image.getInstance(application.getRealPath("img/Titulo.PNG"));
            Imagen.setAlignment(Image.LEFT | Image.TEXTWRAP);
            Paragraph Linea = new Paragraph(Encabezado, Fuente);
            Paragraph Date = new Paragraph(String.valueOf(Fecha)+"\n"+"\n");
            PdfPTable Tabla = new PdfPTable(6);
            Tabla.setWidthPercentage(100);
            Document Documento = new Document(PageSize.A4);            
            File Folder = new File("c:\\Reportes");
            Folder.mkdirs();
            String Ruta = "c:/Reportes/ReporteOrga.pdf";
            PdfWriter.getInstance(Documento, new FileOutputStream(Ruta));
            PdfPCell Celda1 = new PdfPCell(new Paragraph("Id",FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLUE)));
            PdfPCell Celda2 = new PdfPCell(new Paragraph("Nombre",FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLUE)));
            PdfPCell Celda3 = new PdfPCell(new Paragraph("Dirección",FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLUE)));
            PdfPCell Celda4 = new PdfPCell(new Paragraph("Teléfono",FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLUE)));
            PdfPCell Celda5 = new PdfPCell(new Paragraph("FAX",FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLUE)));
            PdfPCell Celda6 = new PdfPCell(new Paragraph("Correo",FontFactory.getFont("arial", 10, Font.BOLD, BaseColor.BLUE)));
            Documento.open();
            Documento.add(Imagen);
            Documento.add(Linea);
            Documento.add(Date);
            Tabla.addCell(Celda1);
            Tabla.addCell(Celda2);
            Tabla.addCell(Celda3);
            Tabla.addCell(Celda4);
            Tabla.addCell(Celda5);
            Tabla.addCell(Celda6);
            while(rs.next()){
               Tabla.addCell(rs.getString(1));
               Tabla.addCell(rs.getString(2));
               Tabla.addCell(rs.getString(3));
               Tabla.addCell(rs.getString(4));
               Tabla.addCell(rs.getString(5));
               Tabla.addCell(rs.getString(6));               
            }
            Documento.add(Tabla);
            Documento.close();
            out.println("<script>");
            out.println("alert('Se ha generado el PDF en C:/Reportes/ReporteOrga.pdf.');");
            out.println("</script>");
            out.println("<script>");
            out.println("location.href='javascript:history.back()';");
            out.println("</script>");
        %>
    </body>
</html>
