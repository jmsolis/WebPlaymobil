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
import java.sql.SQLException;
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
@WebServlet(urlPatterns = {"/ServletCompraArticulo"})
public class ServletCompraArticulo extends HttpServlet {

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
            String cUsr = (String) request.getSession().getAttribute("cUsuario");
            int nUsr = (Integer) request.getSession().getAttribute("nUsuario");
            String cNom = (String) request.getSession().getAttribute("cNombre"); 
            String cInsert, cUpdate, cConsulta;
            boolean lUpdateInsert;
                      
            ConectaBD oBD = new ConectaBD();
            Connection oConexion=null;
           
            // Conectar con la BBDD.
            oConexion = oBD.conectar(1);
            
            cConsulta = "SELECT * from articulos where id_art = ? limit 1";
            PreparedStatement st = oBD.Preparar( cConsulta );
            st.setInt(1,nArt);
            
            // Lanzar el Query.
            ResultSet rInf = st.executeQuery();
            if ( rInf.next() ) {
                String cDes = rInf.getString("descripcion");
                int nStk = rInf.getInt("stock");
                double nPrecio = rInf.getDouble("precio");
                request.getSession().setAttribute("nArt", nArt);
                request.getSession().setAttribute("nUnd", nUnd);
                request.getSession().setAttribute("cDes", cDes);
                request.getSession().setAttribute("nStk", nStk);
                if( rInf.getInt("stock") < nUnd ){
                    response.sendRedirect("SinUnidades.jsp");
                    }else{
                    //  Comprobar si en la cesta ya esta el articulo, 
                    //  si es asi, se añade a la linea, sino se crea una linea nueva.
                    lUpdateInsert = comprobarCesta( nUsr, nArt );
                    if ( lUpdateInsert == true ) {  // Ya esta en la cesta realizar Update en cesta.
                        cUpdate = "UPDATE CESTA SET und_cesta = und_cesta + ? WHERE id_cliente = ? AND id_artcesta = ?";
                        PreparedStatement act = oBD.Preparar( cUpdate );
                        act.setInt(1,nUnd);
                        act.setInt(2,nUsr);
                        act.setInt(3,nArt);
                        int nRetorno2 = act.executeUpdate();
                        if (nRetorno2==1) {
                            JOptionPane.showMessageDialog(null,"¡¡ ACTUALIZACION DE LA CESTA!! \n\n Articulo [ "+nArt+" - "+cDes+" ].\n\n ");
                            response.sendRedirect("ServletListaCesta");
                        }
                    }else{  // No existe en la cesta, realizar Insert en cesta.
                        cInsert = "INSERT INTO CESTA (id_cliente,id_artcesta, precio_cesta,und_cesta) VALUES ( ?,?,?,? )";
                        PreparedStatement act = oBD.Preparar( cInsert );
                        act.setInt(1,nUsr);
                        act.setInt(2,nArt);
                        act.setDouble(3,nPrecio);
                        act.setInt(4,nUnd);
                        int nRetorno2 = act.executeUpdate();
                        if (nRetorno2==1) {
                            JOptionPane.showMessageDialog(null,"¡¡ ARTICULO AÑADIDO A LA CESTA!!\n\n Articulo [ "+nArt+" - "+cDes+" ,  Unidades = " + nUnd + " ].\n\n ");
                            response.sendRedirect("ServletListaCesta");
                        }
                       }
                    }
                }else{ 
                    request.getSession().setAttribute("nArt", nArt);
                    response.sendRedirect("NoExiste.jsp");
                }
 
            } catch (Exception e) {
        } 
          
    }

    public boolean comprobarCesta(int nUsr, int nArt ) throws SQLException {
        boolean lExisteEnCesta = false;
        ConectaBD oBD2 = new ConectaBD();
        Connection oConexion2=null;
        oConexion2 = oBD2.conectar(1);
        String cConsulta2 = "SELECT * from cesta where id_cliente = ? and id_artcesta = ? limit 1";
        PreparedStatement ct = oBD2.Preparar( cConsulta2 );
        ct.setInt(1,nUsr);
        ct.setInt(2,nArt);    
        ResultSet rInf2 = ct.executeQuery();
        if ( rInf2.next() ) lExisteEnCesta = true;
        oBD2.desconectar();
        rInf2.close();
        ct.close();
        return lExisteEnCesta;  
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
