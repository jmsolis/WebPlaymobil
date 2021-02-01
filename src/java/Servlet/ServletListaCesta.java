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
import Clases.Cesta;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JuanMi
 */
@WebServlet(urlPatterns = {"/ServletListaCesta"})
public class ServletListaCesta extends HttpServlet {

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
        ArrayList listaCesta = new ArrayList();
        int nUsr = (Integer) request.getSession().getAttribute("nUsuario");
        String cNom = (String) request.getSession().getAttribute("cNombre"); 
        
        try {
            String cConsulta;
            
            ConectaBD oBD = new ConectaBD();
            Connection oConexion=null;
           
            // Conectar con la BBDD.
            oConexion = oBD.conectar(1);
   
            cConsulta = "SELECT ces.id_cliente, nombre, id_art, titulo, descripcion, foto, cantidad_cesta, "+
                        "precio_cesta, (precio_cesta * cantidad_cesta) AS total_linea " +
                        "from cesta ces " +
                        "JOIN usuarios usu ON usu.id_user = ces.id_cliente " +
                        "JOIN articulos art ON art.id_art = ces.id_artcesta " +
                        "WHERE ces.id_cliente = ?";
            PreparedStatement st = oBD.Preparar( cConsulta );
            st.setInt(1,nUsr);
            // Lanzar el Query.
            int nLineas = 0;
            ResultSet rInf = st.executeQuery();
            while( rInf.next() ){
                Cesta oCesta = new Cesta();
                oCesta.setId_cliente(rInf.getInt("id_cliente") );
                oCesta.setNombre(rInf.getString("nombre") );
                oCesta.setId_art(rInf.getInt("id_art") );
                oCesta.setTitulo(rInf.getString("titulo") );
                oCesta.setDescripcion(rInf.getString("descripcion") );
                oCesta.setFoto(rInf.getString("foto") );
                oCesta.setCantidad(rInf.getInt("cantidad_cesta") );
                oCesta.setPrecio(rInf.getDouble("precio_cesta") );
                oCesta.setTotal_linea(rInf.getDouble("total_linea") );
                listaCesta.add(oCesta);
                nLineas++;
            }  // Fin del   while( rInf.next() )
            
            rInf.close();
            JOptionPane.showMessageDialog(null,"Nº de articulos en la cesta = "+nLineas);
            oBD.desconectar(); 
            request.getSession().setAttribute("listaCesta", listaCesta);
            response.sendRedirect("Comprar_Articulo.jsp");
              
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
