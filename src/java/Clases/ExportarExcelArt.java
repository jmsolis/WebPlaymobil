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
 
public class ExportarExcelArt {
 
     
    public void exportar() {
     
        String excelFilePath = "C:\\xampp\\tomcat\\webapps\\Excel\\articulos.xlsx";
      
        try {
            ConectaBD oBD2 = new ConectaBD();
            Connection oConexion2=null;
            oConexion2 = oBD2.conectar(0);
            
            PreparedStatement ps;
            String cConsulta2 = "SELECT * FROM articulos";
       
            PreparedStatement ct = oBD2.Preparar( cConsulta2 );
            ResultSet rExcel = ct.executeQuery();
           
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("articulos");
 
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
        headerCell.setCellValue("Id Articulo");
   
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Descripcion");
        
        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Precio");
 
        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("Stock");
 
        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("Foto");
    }
 
    private void writeDataLines(ResultSet result, XSSFWorkbook workbook,
            XSSFSheet sheet) throws SQLException {
        int rowCount = 1;
 
        while (result.next()) {
            int id_art = result.getInt("id_art");
            String descripcion = result.getString("descripcion");
            double precio = result.getDouble("precio");
            int stock = result.getInt("stock");
            String foto = result.getString("foto");
 
            Row row = sheet.createRow(rowCount++);
 
            int columnCount = 0;
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(id_art);
               
            cell = row.createCell(columnCount++);
            cell.setCellValue(descripcion);
       
            cell = row.createCell(columnCount++);
            cell.setCellValue(precio);
 
            cell = row.createCell(columnCount++);
            cell.setCellValue(stock);
 
            cell = row.createCell(columnCount);
            cell.setCellValue(foto);
 
        }
    }
 
} 
