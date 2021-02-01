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
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
 
public class ExportarExcelVta {
 
     
    public void exportar() {
     
        String excelFilePath = "C:\\xampp\\tomcat\\webapps\\Excel\\ventas.xlsx";
      
        try {
            ConectaBD oBD2 = new ConectaBD();
            Connection oConexion2=null;
            oConexion2 = oBD2.conectar(0);
            
            PreparedStatement ps;
//            String cConsulta2 = "SELECT * FROM ventas";
            
            String cConsulta2 = "SELECT id_venta, id_linea, id_cliente_vt, nombre, id_art_vt, descripcion, fecha_vt, precio_art, und_venta, (precio_art * und_venta) AS total_linea " +
                                "FROM ventas vta " +
                                "JOIN usuarios usu on  usu.id_user = vta.id_cliente_vt " +
                                "JOIN articulos art ON  art.ID_ART = vta.id_art_vt " +
                                "ORDER BY id_venta, id_linea";
       
            PreparedStatement ct = oBD2.Preparar( cConsulta2 );
            ResultSet rExcel = ct.executeQuery();
           
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("ventas");
 
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
        headerCell.setCellValue("Nº Venta");
   
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Nº Linea");
        
        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Cod. Cliente");
 
        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("Nombre");
 
        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("Nº Articulo");
        
        headerCell = headerRow.createCell(5);
        headerCell.setCellValue("Descripción");
        
        headerCell = headerRow.createCell(6);
        headerCell.setCellValue("Fecha Venta");
        
        headerCell = headerRow.createCell(7);
        headerCell.setCellValue("Precio Articulo");
        
        headerCell = headerRow.createCell(8);
        headerCell.setCellValue("Unidades");
        
        headerCell = headerRow.createCell(9);
        headerCell.setCellValue("Total Linea");
        
    }
 
    private void writeDataLines(ResultSet result, XSSFWorkbook workbook,
            XSSFSheet sheet) throws SQLException {
        int rowCount = 1;
 
        while (result.next()) {
            int id_venta = result.getInt("id_venta");
            int id_linea = result.getInt("id_linea");
            int id_cliente_vt = result.getInt("id_cliente_vt");
            String nombre = result.getString("nombre");
            int id_art_vt = result.getInt("id_art_vt");
            String descripcion = result.getString("descripcion");
            Date fecha_vt = result.getDate("fecha_vt");
            String cFechaOrdenada = convertirFechaString( result.getDate("fecha_vt")  );
            double precio_art = result.getDouble("precio_art");
            int und_venta = result.getInt("und_venta");
            double total_linea = result.getDouble("total_linea");
      
            Row row = sheet.createRow(rowCount++);
 
            int columnCount = 0;
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(id_venta);
               
            cell = row.createCell(columnCount++);
            cell.setCellValue(id_linea);
       
            cell = row.createCell(columnCount++);
            cell.setCellValue(id_cliente_vt);
 
            cell = row.createCell(columnCount++);
            cell.setCellValue(nombre);
 
            cell = row.createCell(columnCount++);
            cell.setCellValue(id_art_vt);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(descripcion);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(cFechaOrdenada);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(precio_art);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(und_venta);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(total_linea);
 
        }
    }
 
     private String convertirFechaString(java.util.Date date) {
        return new SimpleDateFormat("dd-MM-yyyy").format(date);
    }
    
} 
