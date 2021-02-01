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
        boolean lValido=true;
                
        try {
            String cUser = request.getParameter("user");
            String cPass = request.getParameter("pass");
            String cConsulta;
           
            ConectaBD oBD = new ConectaBD();
            Connection oConexion=null;
           
            // Conectar con la BBDD.
            oConexion = oBD.conectar(0);
        
            // Crear cadena para realizar insercion en tabla clientes.
            cConsulta = "SELECT * FROM usuarios WHERE usuario = ? LIMIT 1";
            PreparedStatement st = oBD.Preparar( cConsulta );
            st.setString(1,cUser);
                               
            // Lanzar la Consulta.
            ResultSet rInf = st.executeQuery();
            if( rInf.next() ){   // Recupera el registro leido
                String cUsuario = rInf.getString("usuario");
                request.getSession().setAttribute("cUsuario", cUsuario);
                String cPassword = rInf.getString("password");
                if ( cPassword.equals(cPass) ){
                    lValido = true;
                }else{
                    lValido = false;
                    response.sendRedirect("PasswordNoValido.jsp");
                }
                int nUsuario = rInf.getInt("id_user");
                String cNombre = rInf.getString("nombre");
                String cDireccion = rInf.getString("direccion");
                String cTelefono = rInf.getString("telefono");
                String cTipoUser = rInf.getString("tipo_user");
                int nCompras = rInf.getInt("compras");
                String cEmail = rInf.getString("email");
                
                request.getSession().setAttribute("nUsuario", nUsuario);
                request.getSession().setAttribute("cNombre", cNombre);
                request.getSession().setAttribute("cDireccion", cDireccion);
                request.getSession().setAttribute("cTelefono", cTelefono);
                request.getSession().setAttribute("cTipoUser", cTipoUser);
                request.getSession().setAttribute("nCompras", nCompras);
                request.getSession().setAttribute("cEmail", cEmail);
                oBD.desconectar(); 
                
                if (cTipoUser.equals("ADM")){
                    response.sendRedirect("MenuAdmin.jsp");
                    }else{
                        response.sendRedirect("MenuUsuario.jsp");   
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
