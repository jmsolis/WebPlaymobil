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
function add_cesta(){
 
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
                            document.comprar.submit(); 
                   }
                }
            }
        }
}	

function del_articulo(){

        if ( document.getElementById('articulo').value == "" ){
        alert("El dato NºArticulo, NO puede estar vacio.");
        }else {
            if( isNaN( document.getElementById('articulo').value) ){
                   alert("El dato  NºArticulo, NO es un numero.");
		}else{
                   document.comprar.action="ServletEliminaArticulo";
                   document.comprar.method="POST";
                   document.comprar.submit();    
                }
            }
  
}	

function fin_compra(){
	
    document.comprar.action="ServletFinalizarCompra";
    document.comprar.method="POST";
    document.comprar.submit();  
  
}	

function clear_cesta(){
	
    document.comprar.action="ServletClearCesta";
    document.comprar.method="POST";
    document.comprar.submit();  
  
}	


</script>   
    
<head>
    <title>COMPRA DE ARTICULO</title>
    <link rel="stylesheet" href="Fotos\style.css"> 
</head>
<BODY>
<h1>[ PLAYMOBIL - SEGUNDA MANO ( Compra de Articulo ) ]</h1>
<%
String cUsr = (String) request.getSession().getAttribute("cUsuario");
String cNom = (String) request.getSession().getAttribute("cNombre"); 
%>    
<h2>[  Usuario ]  [ &nbsp;<%=cUsr%> &nbsp; - &nbsp; <%=cNom%>&nbsp;]</h2><br><br>

<form id="comprar" name="comprar" action="ServletCompraArticulo" method="POST">

<table BORDER ALIGN=“CENTER>
<TR>
<TD WIDTH=30 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Nº Articulo: <input type="text" id="articulo" name="articulo" size="10"><br> </TD>
<TD WIDTH=30 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Unidades: <input type="text" id="unidades" name="unidades" size="10"><br> </TD>
</TR>
</table>
<br><br>
<input type="button" name="BotonOK" value="Comprar" onclick="add_cesta()">&nbsp;&nbsp;&nbsp;
<input type="button" name="BotonDel" value="Eliminar articulo" onclick="del_articulo()">&nbsp;&nbsp;&nbsp;
<input type="button" name="BotonClear" value="Vaciar Cesta" onclick="clear_cesta()">&nbsp;&nbsp;&nbsp;
<input type="button" name="BotonFin" value="Finalizar Compra" onclick="fin_compra()">
<br><br>
<input type="button" name="BotonVolver" value="Volver Menu Usuario" onclick="location.href='MenuUsuario.jsp'">

</form>

<br><br>

<br><br>
<h2>[ Cesta actual ]</h2>
<table border=1 ALIGN=“CENTER”>
<TR>
<TD WIDTH=50 ALIGN="CENTER" BGCOLOR="Brown">Id Articulo</TD> 
<TD WIDTH=300 ALIGN="CENTER" BGCOLOR="Brown">Descripción</TD>
<TD WIDTH=100 ALIGN="CENTER" BGCOLOR="Brown">Foto</TD>
<TD WIDTH=50 ALIGN="CENTER" BGCOLOR="Brown">Unidades</TD>
<TD WIDTH=50 ALIGN="CENTER" BGCOLOR="Brown">Precio Unidad</TD>
<TD WIDTH=50 ALIGN="CENTER" BGCOLOR="Brown">Total Linea</TD>
</TR>
<%
ArrayList listaCesta = (ArrayList) request.getSession().getAttribute("listaCesta");
Iterator itListaCesta = listaCesta.iterator();

double nTotalCompra = 0;
while(itListaCesta.hasNext()){
    Cesta cesta_tmp = new Cesta();
    cesta_tmp = (Cesta) itListaCesta.next();
    nTotalCompra = nTotalCompra + cesta_tmp.getTotal_linea();
%> 
<tr>
<td WIDTH=50 ALIGN="CENTER" BGCOLOR="#FFF3CF"><%=cesta_tmp.getId_art()%></td>
<td WIDTH=300 ALIGN="LEFT" BGCOLOR="#FFF3CF"><%=cesta_tmp.getDescripcion()%></td>
<td WIDTH=100 ALIGN="CENTER" BGCOLOR="#FFF3CF"><img src='<%="Fotos/"+cesta_tmp.getFoto()%>' width='100' height='100'></td>
<td WIDTH=50 ALIGN="CENTER" BGCOLOR="#FFF3CF"><%=cesta_tmp.getUnd_cesta()%></td>
<td WIDTH=50 ALIGN="RIGHT" BGCOLOR="#FFF3CF"><%=cesta_tmp.getPrecio()%></td>
<td WIDTH=50 ALIGN="RIGHT" BGCOLOR="#FFF3CF"><%=cesta_tmp.getTotal_linea()%></td>
</tr>
<%}
request.getSession().removeAttribute("ListaCesta");
%>
</table>
<table border=1 ALIGN=“CENTER”>
<tr><TD WIDTH=588 ALIGN="RIGHT" BGCOLOR="Brown">Importe total cesta = &nbsp;&nbsp;</TD> <td WIDTH=50 ALIGN="RIGHT" BGCOLOR="#FFF3CF"><%=nTotalCompra%></td>
</table>
<br>

</BODY>
</html>
