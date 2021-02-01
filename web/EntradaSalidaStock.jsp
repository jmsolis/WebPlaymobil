<%-- 
    Document   : ComprarArticulo
    Created on : 1-ene-2021, 14:13:53
    Author     : JuanMi
--%>
<%@page import="java.util.Iterator"%>
<%@page import="Clases.Cesta"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

 <!DOCTYPE html>
<html>
<script>
function validar(){
 
    if ( document.getElementById('articulo').value == "" ){
        alert("El dato NºArticulo, NO puede estar vacio.");
        }else {
            if( isNaN( document.getElementById('articulo').value) ){
                alert("El dato  NºArticulo, NO es un numero.");
		}else{
                    if ( document.getElementById('unidades').value == "" ){
                        alert("El datos Unidades, NO puede estar vacio.");
                    }else{
                        if ( isNaN( document.getElementById('unidades').value) ) {
                            alert("El dato Unidades, NO es un numero."); 
                        }else{
                            document.entSal.submit(); 
                   }
                }
            }
        }
}	

</script>   
    
<head>
    <title>COMPRA DE ARTICULO</title>
    <link rel="stylesheet" href="Fotos\style.css"> 
</head>
<body>
<h1>[ PLAYMOBIL - SEGUNDA MANO ( Entrada/Salida mercancía ) ]</h1>
<br><br>

<form id="entSal" name="entSal" action="ServletEntradaSalidaStock" method="POST">

<table BORDER ALIGN=“CENTER>
<TR>
<TD WIDTH=30 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Nº Articulo: <input type="text" id="articulo" name="articulo" size="10"><br> </TD>
<TD WIDTH=30 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Unidades: <input type="text" id="unidades" name="unidades" size="10"><br> </TD>
</TR>
</table>
<br><br>
<input type="button" name="BotonOK" value="Continuar" onclick="validar()">&nbsp;&nbsp;&nbsp;
<input type="button" name="BotonVolver" value="Volver" onclick="location.href='MenuAdmin.jsp'">

</form>

<br><br><br><br>

<h4> <p style="color:#FF0000";>[ Nota ]  [ &nbsp; Para dar salida al stock, poner la cantidad en negativo. &nbsp;] </p> </h4>

</body>
</html>
