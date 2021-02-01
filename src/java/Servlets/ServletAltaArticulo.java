package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Clases.ConectaBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author JuanMi
 */
@WebServlet(urlPatterns = {"/ServletAltaArticulo"})
public class ServletAltaArticulo extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
                
        try {
            String cDescripcion = request.getParameter("descripcion");
            String cFoto = request.getParameter("foto");
            double nPrecio = Double.parseDouble(request.getParameter("precio"));
            int nStock = Integer.parseInt(request.getParameter("stock"));
            String cInsert;
                      
            ConectaBD oBD = new ConectaBD();
            Connection oConexion=null;
           
            // Conectar con la BBDD.
            oConexion = oBD.conectar(1);
       
            // Crear cadena para realizar insercion en tabla articulos.
            cInsert = "insert into articulos (descripcion, foto, precio, stock) "+
                      " VALUES (?,?,?,?)";
            PreparedStatement st = oBD.Preparar( cInsert );
            st.setString(1,cDescripcion);
            st.setString(2,cFoto);
            st.setDouble(3,nPrecio);
            st.setInt(4,nStock);
    //     response.sendRedirect("OK.jsp");
            
            // Lanzar la Insercion de Articulo.
            int nRetorno = st.executeUpdate();
            oBD.desconectar(); 
            if (nRetorno==1) {
                JOptionPane.showMessageDialog(null,"Articulo [ "+cDescripcion+" ], Grabado.");
                response.sendRedirect("AltaArticulo.jsp");
                } else {
                response.sendRedirect("AltaArticulo.jsp");
                }
            } catch (Exception e) {
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
