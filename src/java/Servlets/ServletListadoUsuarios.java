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
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Clases.Usuarios;
import java.util.ArrayList;

/**
 *
 * @author JuanMi
 */
@WebServlet(urlPatterns = {"/ServletListadoUsuarios"})
public class ServletListadoUsuarios extends HttpServlet {

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
        ArrayList listaUsuarios = new ArrayList();
                
        try {
            String cConsulta;
            
            ConectaBD oBD = new ConectaBD();
            Connection oConexion=null;
           
            // Conectar con la BBDD.
            oConexion = oBD.conectar(1);
   
            cConsulta = "SELECT * from usuarios where tipo_user <> 'ADM' order by id_user";
            PreparedStatement st = oBD.Preparar( cConsulta );
            // Lanzar el Query.
            ResultSet rInf = st.executeQuery();
            while( rInf.next() ){
                Usuarios oUsuarios = new Usuarios();
                oUsuarios.setId_user( rInf.getInt("id_user") );
                oUsuarios.setUsuario(rInf.getString("usuario") );
                oUsuarios.setPassword( rInf.getString("password") );
                oUsuarios.setNombre( rInf.getString("nombre") );
                oUsuarios.setDireccion( rInf.getString("direccion") );
                oUsuarios.setTelefono(rInf.getString("telefono") );
                oUsuarios.setCompras(rInf.getInt("compras") );
                oUsuarios.setEmail(rInf.getString("email") );        
                listaUsuarios.add(oUsuarios);
            }  // Fin del   while( rInf.next() )
            
            rInf.close();
            oBD.desconectar(); 
            request.getSession().setAttribute("listaUsuarios", listaUsuarios);
            response.sendRedirect("ListaUsuarios.jsp");
              
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
