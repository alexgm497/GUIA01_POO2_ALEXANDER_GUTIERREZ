/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.PiezasCtrl;
import com.sv.udb.modelo.Piezas;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexander José
 */
@WebServlet(name = "PiezasServ", urlPatterns = {"/PiezasServ"})
public class PiezasServ extends HttpServlet {

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
                    Piezas obje = new Piezas();
                    obje.setNombPiez(request.getParameter("nombPiez"));
                    obje.setTipoPiez(request.getParameter("tipoPiez"));
                    obje.setCantPiez(Integer.parseInt(request.getParameter("cantPiez")));
                    mens = new PiezasCtrl().guar(obje) ? "Datos guardados." : "Datos NO guardados.";
                    break;
                }
                case "Consultar": {
                    int codiPiez = Integer.parseInt(request.getParameter("codiPiezRadi") == null ? "0" : request.getParameter("codiPiezRadi"));
                    Piezas obje = new PiezasCtrl().cons(codiPiez);
                    if (obje != null) {
                        request.setAttribute("codiPiez", obje.getIdPiez());
                        request.setAttribute("nombPiez", obje.getNombPiez());
                        request.setAttribute("tipoPiez", obje.getTipoPiez());
                        request.setAttribute("cantPiez", obje.getCantPiez());
                    }
                    break;
                }
                case "Modificar": {
                    String valor = request.getParameter("codiPiez");
                    if (!valor.equals("")) {
                        Piezas obje = new Piezas();
                        obje.setIdPiez(Integer.parseInt(request.getParameter("codiPiez")));
                        obje.setNombPiez(request.getParameter("nombPiez"));
                        obje.setTipoPiez(request.getParameter("tipoPiez"));
                        obje.setCantPiez(Integer.parseInt(request.getParameter("cantPiez")));
                        mens = new PiezasCtrl().actu(obje) ? "Datos modificados." : "Datos NO modificados.";
                    } else {
                        mens = "Seleccione un dato.";
                    }
                    break;
                }
                case "Eliminar": {
                    String valor = request.getParameter("codiPiez");
                    if (!valor.equals("")) {
                        Piezas obje = new Piezas();
                        obje.setIdPiez(Integer.parseInt(request.getParameter("codiPiez")));
                        mens = new PiezasCtrl().elim(obje) ? "Datos eliminados." : "Datos NO eliminados.";
                    } else {
                        mens = "Seleccione un dato.";
                    }
                    break;
                }
                default:
                    break;
            }
            request.setAttribute("mensAlert", mens);
            request.getRequestDispatcher("/piezas.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/piezas.jsp");
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
