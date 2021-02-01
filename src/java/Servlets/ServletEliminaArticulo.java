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
@WebServlet(urlPatterns = {"/ServletEliminaArticulo"})
public class ServletEliminaArticulo extends HttpServlet {

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
            int nArt = Integer.parseInt(request.getParameter("articulo"));
            int nUsr = (Integer) request.getSession().getAttribute("nUsuario");
            String cUsr = (String) request.getSession().getAttribute("cUsuario");
            String cNom = (String) request.getSession().getAttribute("cNombre"); 
            String cDelete;
                      
            ConectaBD oBD = new ConectaBD();
            Connection oConexion=null;
           
            // Conectar con la BBDD.
            oConexion = oBD.conectar(1);
       
            // Crear cadena para realizar la limpieza de la tabla cesta del usuario asignado.
            cDelete = "delete from cesta where id_cliente = ? and id_artcesta = ? ";
            PreparedStatement st = oBD.Preparar( cDelete );
            st.setInt(1,nUsr);
            st.setInt(2,nArt);
         
            // Lanzar el delete de la tabla.
            int nRetorno = st.executeUpdate();
            oBD.desconectar(); 
            if (nRetorno > 0) {
                JOptionPane.showMessageDialog(null,"Cesta del usuario [ "+cUsr+" - "+cNom+" ] \n\n Articulo [ "+nArt+" ]        ¡¡ ELIMINADO!!.\n ");
                }else{
                    JOptionPane.showMessageDialog(null,"La Cesta del usuario [ "+cUsr+" - "+cNom+" ]\n\n El Articulo [ "+ nArt +" ],  No existe en la cesta.\n ");
                }
            response.sendRedirect("ServletListaCesta");
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
