package Servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Clases.Cesta;
import Clases.ConectaBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(urlPatterns = {"/ServletFinalizarCompra"})
public class ServletFinalizarCompra extends HttpServlet {

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
        throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        int nVenta = 1; 
        int nLinea = 0;
    //  Fecha del dia
        Calendar dFecha = new GregorianCalendar();
        String dSysDate= dFecha.get(Calendar.YEAR) + "-" + 
               (dFecha.get(Calendar.MONTH)+1) + "-" +
               dFecha.get(Calendar.DAY_OF_MONTH);
                
        try {
            int nUsr = (Integer) request.getSession().getAttribute("nUsuario");
            String cNom = (String) request.getSession().getAttribute("cNombre"); 
            String cInsert, cDelete, cUpdate, cConsulta;
            ArrayList listaCesta = (ArrayList) request.getSession().getAttribute("listaCesta");
                                  
            ConectaBD oBD = new ConectaBD();
            Connection oConexion=null;
           
            // Conectar con la BBDD.
            oConexion = oBD.conectar(1);
            
        //  Actualizar stock del articulo.    
            cUpdate = "UPDATE articulos SET  cantidad = cantidad - ? WHERE id_art = ?";
            PreparedStatement st = oBD.Preparar( cUpdate );  
            Cesta cesta_tmp = new Cesta();
            Iterator itListaCesta = listaCesta.iterator();
            while(itListaCesta.hasNext()){
                cesta_tmp = (Cesta) itListaCesta.next();
                st.setInt(1,cesta_tmp.getCantidad() );
                st.setInt(2,cesta_tmp.getId_art());
                st.executeUpdate();
            }
            st.close();
            
            
        //  Recuperar numero de orden de venta siguiente ( nVenta ).
            cConsulta = "SELECT id_venta from ventas order by id_venta desc limit 1";
            st = oBD.Preparar( cConsulta );
            ResultSet rInf = st.executeQuery();
            if ( rInf.next() ) {
                nVenta = rInf.getInt("id_venta") + 1;
            }
            rInf.close();
            st.close();
 
            
        //  Insertar lineas en tabla de ventas.
            cInsert = "insert into ventas (id_venta, id_linea, id_cliente_vt, id_art_vt, fecha_vt, precio_art, cantidad_art) "+
                      " VALUES (?,?,?,?,?,?,?)";
            st = oBD.Preparar( cInsert );
            Cesta cesta_tmp2 = new Cesta();
 //           ArrayList listaCesta = (ArrayList) request.getSession().getAttribute("listaCesta");
            Iterator itListaCesta2 = listaCesta.iterator();
            while(itListaCesta2.hasNext()){
                cesta_tmp2 = (Cesta) itListaCesta2.next();
                nLinea++;
                st.setInt(1,nVenta);
                st.setInt(2,nLinea);
                st.setInt(3,cesta_tmp2.getId_cliente());
                st.setInt(4,cesta_tmp2.getId_art());
                st.setString(5,dSysDate );
                st.setDouble(6,cesta_tmp2.getPrecio() );
                st.setInt(7,cesta_tmp2.getCantidad() );
                st.executeUpdate();
            }       
            st.close();
            
        //  Limpiar la cesta.    
            cDelete = "delete from cesta where id_cliente = ?";
            st = oBD.Preparar( cDelete );
            st.setInt(1,nUsr);
            st.executeUpdate();
            
        //  Cerrar conexiones.    
            st.close();
            oBD.desconectar(); 
            JOptionPane.showMessageDialog(null,"Se ha creado la orden de venta nº [ "+nVenta+" ]\nUsuario [ "+nUsr+" - "+cNom+" ]\nNº de Lineas de la orden [ "+nLinea+" ]");
            response.sendRedirect("Menu_Usuario.jsp");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletFinalizarCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletFinalizarCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
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
