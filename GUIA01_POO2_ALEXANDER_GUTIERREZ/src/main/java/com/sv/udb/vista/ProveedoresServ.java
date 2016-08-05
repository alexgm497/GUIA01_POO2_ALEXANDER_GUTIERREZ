/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.ProveedoresCtrl;
import com.sv.udb.modelo.Proveedores;
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
@WebServlet(name = "ProveedoresServ", urlPatterns = {"/ProveedoresServ"})
public class ProveedoresServ extends HttpServlet {

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
                    Proveedores obje = new Proveedores();
                    obje.setNombProv(request.getParameter("nombProv"));
                    obje.setDireProv(request.getParameter("direProv"));
                    obje.setTeleProv(request.getParameter("teleProv"));
                    mens = new ProveedoresCtrl().guar(obje) ? "Datos guardados." : "Datos NO guardados.";
                    break;
                }
                case "Consultar": {
                    int codiProv = Integer.parseInt(request.getParameter("codiProvRadi") == null ? "0" : request.getParameter("codiProvRadi"));
                    Proveedores obje = new ProveedoresCtrl().cons(codiProv);
                    if (obje != null) {
                        request.setAttribute("codiProv", obje.getIdProv());
                        request.setAttribute("nombProv", obje.getNombProv());
                        request.setAttribute("direProv", obje.getDireProv());
                        request.setAttribute("teleProv", obje.getTeleProv());
                    }
                    break;
                }
                case "Modificar": {
                    String valor = request.getParameter("codiProv");
                    if (!valor.equals("")) {
                        Proveedores obje = new Proveedores();
                        obje.setIdProv(Integer.parseInt(request.getParameter("codiProv")));
                        obje.setNombProv(request.getParameter("nombProv"));
                        obje.setDireProv(request.getParameter("direProv"));
                        obje.setTeleProv(request.getParameter("teleProv"));
                        mens = new ProveedoresCtrl().actu(obje) ? "Datos modificados." : "Datos NO modificados.";
                    } else {
                        mens = "Seleccione un dato.";
                    }
                    break;
                }
                case "Eliminar": {
                    String valor = request.getParameter("codiProv");
                    if (!valor.equals("")) {
                        Proveedores obje = new Proveedores();
                        obje.setIdProv(Integer.parseInt(request.getParameter("codiProv")));
                        mens = new ProveedoresCtrl().elim(obje) ? "Datos eliminados." : "Datos NO eliminados.";
                    } else {
                        mens = "Seleccione un dato.";
                    }
                    break;
                }
                default:
                    break;
            }
            request.setAttribute("mensAlert", mens);
            request.getRequestDispatcher("/proveedores.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/proveedores.jsp");
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
