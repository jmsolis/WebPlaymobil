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
 
public class ExportarExcel {
 
     
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
             
             
            int seleccion = JOptionPane.showOptionDialog(null,
            "C:/xampp/tomcat/webapp/Excel/articulos.xlsx", "¡¡ Fichero Excel generado !!",
            JOptionPane.YES_OPTION,
            JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Descargar Fichero" },null);
                       
            if (seleccion != -1){
               String cDocType =  "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0”+“Transitional//EN\">\n";
               out.println( cDocType + "<HTML>\n" + "<HEAD><TITLE>"+"</TITLE></HEAD>\n" +
               "<H1>" + "Prueba HTML " + "</H1>" + "\n" +
               "</BODY>" + "\n" +
               "</BODY>" + "\n" +
               "</HTML>" ); 
            } 
         
            
 
            
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
        headerCell.setCellValue("Titulo");
 
        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Descripcion");
        
        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("Precio");
 
        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("Cantidad");
 
        headerCell = headerRow.createCell(5);
        headerCell.setCellValue("Foto");
    }
 
    private void writeDataLines(ResultSet result, XSSFWorkbook workbook,
            XSSFSheet sheet) throws SQLException {
        int rowCount = 1;
 
        while (result.next()) {
            int id_art = result.getInt("id_art");
            String titulo = result.getString("titulo");
            String descripcion = result.getString("descripcion");
            double precio = result.getDouble("precio");
            int cantidad = result.getInt("cantidad");
            String foto = result.getString("foto");
 
            Row row = sheet.createRow(rowCount++);
 
            int columnCount = 0;
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(id_art);
 
            cell = row.createCell(columnCount++);
            cell.setCellValue(titulo);
            
            cell = row.createCell(columnCount++);
            cell.setCellValue(descripcion);
            
 
            cell = row.createCell(columnCount++);
            cell.setCellValue(precio);
            /*CellStyle cellStyle = workbook.createCellStyle();
            CreationHelper creationHelper = workbook.getCreationHelper();
            cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
            cell.setCellStyle(cellStyle);*/
 
            cell = row.createCell(columnCount++);
            cell.setCellValue(cantidad);
 
            cell = row.createCell(columnCount);
            cell.setCellValue(foto);
 
        }
    }
 
} 
