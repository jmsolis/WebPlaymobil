package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Clases.ConectaBD;
import Clases.Ventas;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author JuanMi
 */
@WebServlet(urlPatterns = {"/ServletListadoVentas"})
public class ServletListadoVentas extends HttpServlet {

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
        ArrayList listaVentas = new ArrayList();
        String cDia, cMes, cAnno, cFechaFichero, cFechaOrdenada;
        Date dFecha = new Date();
                
        try {
            String cConsulta;
            
            ConectaBD oBD = new ConectaBD();
            Connection oConexion=null;
           
            // Conectar con la BBDD.
            oConexion = oBD.conectar(1);
    
            cConsulta = "SELECT id_venta, id_linea, id_cliente_vt, nombre, id_art_vt, descripcion, fecha_vt, precio_art, und_venta, (precio_art * und_venta) AS total_linea " +
                        "FROM ventas vta " +
                        "JOIN usuarios usu on  usu.id_user = vta.id_cliente_vt " +
                        "JOIN articulos art ON  art.ID_ART = vta.id_art_vt " +
                        "ORDER BY id_venta, id_linea";
            PreparedStatement st = oBD.Preparar( cConsulta );
            // Lanzar el Query.
            ResultSet rInf = st.executeQuery();
            while( rInf.next() ){
                Ventas oVenta = new Ventas();
                oVenta.setId_venta(rInf.getInt("id_venta") );
                oVenta.setId_linea(rInf.getInt("id_linea") );
                oVenta.setId_cliente_vt(rInf.getInt("id_cliente_vt") );
                oVenta.setNombre(rInf.getString("nombre") );
                oVenta.setId_art_vt(rInf.getInt("id_art_vt") );
                oVenta.setDescripcion(rInf.getString("descripcion") );
                 
    //            oVenta.setFecha_vt(rInf.getString("fecha_vt"));
               
                cFechaOrdenada = convertirFechaString( rInf.getDate("fecha_vt")  );
                oVenta.setFecha_vt(cFechaOrdenada);
                
                oVenta.setPrecio_art(rInf.getDouble("precio_art") );
                oVenta.setUnd_venta(rInf.getInt("und_venta") );
                oVenta.setTotal_linea(rInf.getDouble("total_linea") );
                listaVentas.add(oVenta);
            }  // Fin del   while( rInf.next() )
            
            rInf.close();
            oBD.desconectar(); 
            request.getSession().setAttribute("listaVentas", listaVentas);
            response.sendRedirect("ListadoVentas.jsp");
              
            } catch (Exception e) {
        } 
          
    }

    public String convertirFechaString(Date date) {
        return new SimpleDateFormat("dd-MM-yyyy").format(date);
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
