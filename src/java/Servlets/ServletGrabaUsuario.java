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
import javax.swing.JOptionPane;

/**
 *
 * @author JuanMi
 */
@WebServlet(urlPatterns = {"/ServletGrabaUsuario"})
public class ServletGrabaUsuario extends HttpServlet {

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
            String cNombre = request.getParameter("nombre");
            String cDireccion = request.getParameter("direccion");
            String cTelefono = request.getParameter("telefono");
            String cEmail = request.getParameter("email");
                       
            String cInsert, cConsulta;
            int nUser =0;
           
            ConectaBD oBD = new ConectaBD();
            Connection oConexion=null;
           
            // Conectar con la BBDD.
            oConexion = oBD.conectar(1);
       
            // Crear cadena para realizar insercion en tabla usuarios.
            cInsert = "insert into usuarios (usuario, password, nombre, direccion, telefono, tipo_user, compras, email) "+
                      " VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement st = oBD.Preparar( cInsert );
            st.setString(1,cUser);
            st.setString(2,cPass);
            st.setString(3,cNombre);
            st.setString(4,cDireccion);
            st.setString(5,cTelefono);
            st.setString(6,"USR");
            st.setInt(7,0);
            st.setString(8,cEmail);
            
    //      response.sendRedirect("OK.jsp");
            
            // Lanzar la Insercion de Usuario.
            int nRetorno = st.executeUpdate();
            if (nRetorno==1) {
                cConsulta = "SELECT * from usuarios order by id_user desc limit 1";
                st = oBD.Preparar( cConsulta );
                // Lanzar el Query.
                ResultSet rInf2 = st.executeQuery();
                //recupera el numero del usuario
                if(rInf2.next())
                    // Recupèro datos del registro en variables.
                    nUser = rInf2.getInt("id_user");
                    cUser = rInf2.getString("usuario");
                    cNombre = rInf2.getString("nombre");
                    cDireccion = rInf2.getString("direccion");
                    cTelefono = rInf2.getString("telefono");
                    String cTipoUser = rInf2.getString("tipo_user");
                    int nCompras = rInf2.getInt("compras");
                    cEmail = rInf2.getString("email");
                
                    //  Guardo los datos del usuario en la sesion.
                    request.getSession().setAttribute("nUsuario", nUser);
                    request.getSession().setAttribute("cUsuario", cUser);
                    request.getSession().setAttribute("cNombre", cNombre);
                    request.getSession().setAttribute("cDireccion", cDireccion);
                    request.getSession().setAttribute("cTelefono", cTelefono);
                    request.getSession().setAttribute("cTipoUser", cTipoUser);
                    request.getSession().setAttribute("nCompras", nCompras);
                    request.getSession().setAttribute("cEmail", cEmail);
                           
                    rInf2.close();
                    oBD.desconectar(); 
                    JOptionPane.showMessageDialog(null,"Usuario [ "+cUser+" ], Grabado.");
                    response.sendRedirect("MenuUsuario.jsp");
                } else {
                JOptionPane.showMessageDialog(null,"¡¡¡ ERROR !!!,  Usuario [ "+cUser+" ], NO Grabado.");
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
