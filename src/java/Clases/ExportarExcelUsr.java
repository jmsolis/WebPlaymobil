/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author JuanMi
 */

import java.io.*;
import static java.lang.System.out;
import java.sql.*;
 
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
 
public class ExportarExcelUsr {
 
     
    public void exportar() {
     
        String excelFilePath = "C:\\xampp\\tomcat\\webapps\\Excel\\usuarios.xlsx";
      
        try {
            ConectaBD oBD2 = new ConectaBD();
            Connection oConexion2=null;
            oConexion2 = oBD2.conectar(0);
            
            PreparedStatement ps;
            String cConsulta2 = "SELECT * FROM usuarios";
       
            PreparedStatement ct = oBD2.Preparar( cConsulta2 );
            ResultSet rExcel = ct.executeQuery();
           
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("usuarios");
 
            writeHeaderLine(sheet);
            writeDataLines(rExcel, workbook, sheet);
 
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
 
            ct.close();
             
        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }
    }
 
    private void writeHeaderLine(XSSFSheet sheet) {
 
        Row headerRow = sheet.createRow(0);
 
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Id Usuario");
   
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Usuario");
        
        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Password");
 
        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("Nombre");
 
        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("Direccion");
        
        headerCell = headerRow.createCell(5);
        headerCell.setCellValue("telefono");
        
        headerCell = headerRow.createCell(6);
        headerCell.setCellValue("tipo_user");
        
        headerCell = headerRow.createCell(7);
        headerCell.setCellValue("email");
        
        headerCell = headerRow.createCell(8);
        headerCell.setCellValue("Nº Compras");
       
    }
 
    private void writeDataLines(ResultSet result, XSSFWorkbook workbook,
            XSSFSheet sheet) throws SQLException {
        int rowCount = 1;
 
        while (result.next()) {
            int id_user = result.getInt("id_user");
            String usuario = result.getString("usuario");
            String password = result.getString("password");
            String nombre = result.getString("nombre");
            String direccion = result.getString("direccion");
            String telefono = result.getString("telefono");
            String tipo_user = result.getString("tipo_user");
            String email = result.getString("email");
            int compras = result.getInt("compras");
      
            Row row = sheet.createRow(rowCount++);
 
            int columnCount = 0;
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(id_user);
               
            cell = row.createCell(columnCount++);
            cell.setCellValue(usuario);
       
            cell = row.createCell(columnCount++);
            cell.setCellValue(password);
 
            cell = row.createCell(columnCount++);
            cell.setCellValue(nombre);
 
             cell = row.createCell(columnCount++);
            cell.setCellValue(direccion);
           
            cell = row.createCell(columnCount++);
            cell.setCellValue(telefono);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(tipo_user);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(email);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(compras);
 
        }
    }
 
} 
