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
@WebServlet(urlPatterns = {"/ServletEntradaSalidaStock"})
public class ServletEntradaSalidaStock extends HttpServlet {

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
            int nUnd = Integer.parseInt(request.getParameter("unidades"));
            String cUpdate, cConsulta;
            String cDes = "";
            String cMvt = "se descontaron ";
            int nStk = 0;
            if (nUnd > 0 ){
                cMvt = "se añadieron ";
            }        
            
            ConectaBD oBD = new ConectaBD();
            Connection oConexion=null;
           
            // Conectar con la BBDD.
            oConexion = oBD.conectar(1);
            
            cConsulta = "SELECT stock, descripcion from articulos where id_art = ? limit 1";
            PreparedStatement st = oBD.Preparar( cConsulta );
            st.setInt(1,nArt);
            
             // Lanzar la Consulta.
            ResultSet rInf = st.executeQuery();
            if( rInf.next() ){   // Recupera el registro leido
                cDes = rInf.getString("descripcion");
                nStk = rInf.getInt("stock");
            }else{
                rInf.close();
                st.close();
                JOptionPane.showMessageDialog(null,"El articulo [ "+nArt+" ]\n\n¡¡¡ NO EXISTE !!!\n\n ");
                response.sendRedirect("EntradaSalidaStock.jsp");
            }  
            rInf.close();
            st.close();    
                       
            //  Actualizar Nº de compras del cliente/usuario.    
            cUpdate = "UPDATE articulos SET stock = stock + ? WHERE id_art = ?";
            st = oBD.Preparar( cUpdate );  
            st.setInt(1,nUnd);
            st.setInt(2,nArt);
            st.executeUpdate();
            st.close();    
            
            //  Cerrar conexiones.  
            oBD.desconectar(); 
               
            JOptionPane.showMessageDialog(null,"Articulo [ "+nArt+" - "+cDes+" ], "+cMvt+nUnd+" und.\n\nStock actual = "+(nStk+nUnd)+"\n\n¡¡¡ Stock Actualizado !!!\n\n ");
            response.sendRedirect("EntradaSalidaStock.jsp");
   
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
