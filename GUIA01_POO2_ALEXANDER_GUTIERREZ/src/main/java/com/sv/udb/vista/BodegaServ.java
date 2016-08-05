/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.BodegaCtrl;
import com.sv.udb.modelo.Bodega;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Laboratorio
 */
@WebServlet(name = "BodegaServ", urlPatterns = {"/BodegaServ"})
public class BodegaServ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean esValido = request.getMethod().equals("POST");
        if (esValido) {
            String mens = "";
            String CRUD = request.getParameter("cursBton");
            switch (CRUD) {
                case "Guardar": {
                    Bodega obje = new Bodega();
                    obje.setIdPieza(Integer.parseInt(request.getParameter("cmbPieza")));
                    obje.setIdProveedor(Integer.parseInt(request.getParameter("cmbProv")));
                    obje.setBodeCanti(Integer.parseInt(request.getParameter("cantBode")));
                    Date ahora = new Date();
                    obje.setFechComp(ahora.getDate() + "-" + (ahora.getMonth() + 1) + "-" + (ahora.getYear() + 1900));
                    mens = new BodegaCtrl().guar(obje) ? "Datos guardados." : "Datos NO guardados.";
                    break;
                }
                case "Consultar": {
                    int codiBode = Integer.parseInt(request.getParameter("codiBodeRadi") == null ? "0" : request.getParameter("codiBodeRadi"));
                    Bodega obje = new BodegaCtrl().cons(codiBode);
                    if (obje != null) {
                        request.setAttribute("codiBod", obje.getIdBodega());
                        request.setAttribute("cmbPieza", obje.getIdPieza());
                        request.setAttribute("cmbProv", obje.getIdProveedor());
                        request.setAttribute("cantBode", obje.getBodeCanti());
                    }
                    break;
                }
                case "Modificar": {
                    String valor = request.getParameter("codiBod");
                    if (!valor.equals("")) {
                        Bodega obje = new Bodega();
                        obje.setIdBodega(Integer.parseInt(request.getParameter("codiBod")));
                        obje.setIdPieza(Integer.parseInt(request.getParameter("cmbPieza")));
                        obje.setIdProveedor(Integer.parseInt(request.getParameter("cmbProv")));
                        obje.setBodeCanti(Integer.parseInt(request.getParameter("cantBode")));
                        mens = new BodegaCtrl().actu(obje) ? "Datos modificados." : "Datos NO modificados.";
                    } else {
                        mens = "Seleccione un dato.";
                    }
                    break;
                }
                case "Eliminar": {
                    String valor = request.getParameter("codiBod");
                    if (!valor.equals("")) {
                        Bodega obje = new Bodega();
                        obje.setIdBodega(Integer.parseInt(request.getParameter("codiBod")));
                        mens = new BodegaCtrl().elim(obje) ? "Datos eliminados." : "Datos NO eliminados.";
                    } else {
                        mens = "Seleccione un dato.";
                    }
                    break;
                }
                default:
                    break;
            }
            request.setAttribute("mensAlert", mens);
            request.getRequestDispatcher("/bodega.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/bodega.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
