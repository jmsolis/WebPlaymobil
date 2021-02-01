package Servlet;

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
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JuanMi
 */
@WebServlet(urlPatterns = {"/ServletValidaUser"})
public class ServletValidaUser extends HttpServlet {

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
            String cUser = request.getParameter("user");
            String cPass = request.getParameter("pass");
            String cConsulta;
           
            ConectaBD oBD = new ConectaBD();
            Connection oConexion=null;
           
            // Conectar con la BBDD.
            oConexion = oBD.conectar(0);
        
            // Crear cadena para realizar insercion en tabla clientes.
            cConsulta = "SELECT * FROM usuarios WHERE nombre = ? AND password = ? LIMIT 1";
            PreparedStatement st = oBD.Preparar( cConsulta );
            st.setString(1,cUser);
            st.setString(2,cPass);
                    
            // Lanzar la Consulta.
            ResultSet rInf = st.executeQuery();
            if( rInf.next() ){   // Recuepra el registro leido
                String cTipoUser = rInf.getString("tipo_user");
                  
                int nUsuario = rInf.getInt("id_user");
                String cNombre = rInf.getString("nombre");
                String cDireccion = rInf.getString("direccion");
                request.getSession().setAttribute("nUsuario", nUsuario);
                request.getSession().setAttribute("cNombre", cNombre);
                request.getSession().setAttribute("cDireccion", cDireccion);
                oBD.desconectar(); 
                
                if (cTipoUser.equals("ADM")){
                    response.sendRedirect("Menu_Admin.jsp");
                    }else{
                        response.sendRedirect("Menu_Usuario.jsp");   
                    }
             }else{  // No existe el registro 
                response.sendRedirect("AltaUsuario.jsp");
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
