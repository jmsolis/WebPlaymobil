package Clases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JuanMi
 */
import java.io.FileReader;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JuanMi
 */
public class ConectaBD {
 
 // Variable Globales 
    Connection oConexion = null;
    Statement oSentencia = null;
 /*   String cBBDD = "gesbanco";
    String cUrl = "jdbc:mysql://localhost:3306/" + cBBDD + "?useSSL=false";
    String cUser = "root";
    String cPass = "";
*/
    String cIP;
    String cBBDD;
    String cPuerto;
    String cUrl;
    String cUser;
    String cPass; 
    String cDriver;
    // String cUrl ="jdbc:mysql://localhost:3306/" + cBBDD + "?useSSL=false";
        
    ResultSet rResultado = null;
    
    public PreparedStatement Preparar( String cConsulta) {
        try {
            return oConexion.prepareStatement(cConsulta);
        } catch (SQLException ex) {
            Logger.getLogger(ConectaBD.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
     
    public Connection conectar( int nMsj ){
        try {
        /*
            Properties configura = new Properties();
            configura.load(new FileReader("C:/test/configuracion.ini"));
            cIP = configura.getProperty("ip");
            cPuerto = configura.getProperty("puerto");
            cBBDD = configura.getProperty("bbdd");
            cUser = configura.getProperty("user");
            cPass = configura.getProperty("password");
            cDriver = configura.getProperty("driver");
        */
            cIP = "localhost";
            cPuerto = "3306";
            cBBDD = "bbdd_playmobil";
            cUser = "root";
            cPass = "";
            cDriver = "com.mysql.cj.jdbc.Driver";
            cUrl ="jdbc:mysql://" + cIP + ":" + cPuerto + "/" + cBBDD + "?useSSL=false";
         } catch (Exception ex) {
        }
 
          try {
       //   Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName(cDriver);
           
            oConexion = DriverManager.getConnection(cUrl, cUser, cPass);
            oSentencia = oConexion.createStatement();
            if (nMsj == 0) JOptionPane.showMessageDialog(null,"Conexion a la base de datos "+cBBDD.toUpperCase()+", activa.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"¡¡ Error !!, conexion a la base de datos "+cBBDD.toUpperCase()+", no realizada.");
                e.printStackTrace();
            }
          return oConexion;
        } // Fin conectar()
       
   
    public void desconectar() {
        try {
            oSentencia.close();
            oConexion.close();
        //    JOptionPane.showMessageDialog(null,"Desconexion a la base de datos "+cBBDD.toUpperCase());
        } catch (SQLException ex) {
            Logger.getLogger(ConectaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
