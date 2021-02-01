<%-- 
    Document   : Comprara_Articulo
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
        alert("El Codigo de articulo, NO puede estar vacio.");
        }else {
            if( isNaN( document.getElementById('articulo').value) ){
                alert("El campo Articulo, NO es un numero.");
		}else{
                    if ( isNaN( document.getElementById('unidades').value) ) {
                        alert("El campo unidades, NO es un numero."); 
                    }else {
                    document.comprar.submit();  
                }
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
    
<head><title>COMPRA DE ARTICULO</title></head>

<h1>[ AMAZON LIGHT ( Compra de Articulo ) ]</h1>
<%
int nUsr = (Integer) request.getSession().getAttribute("nUsuario");
String cNom = (String) request.getSession().getAttribute("cNombre"); 
%>    
<h2>[  Usuario ]  [ &nbsp;<%=nUsr%> &nbsp; - &nbsp; <%=cNom%>&nbsp;]</h2><br><br>

<form id="comprar" name="comprar" action="ServletCompraArticulo" method="POST">

<table BORDER ALIGN=“CENTER>
<TR>
<TD WIDTH=30 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Nº Articulo: <input type="text" id="articulo" name="articulo" size="20"><br> </TD>
<TD WIDTH=30 ALIGN="LEFT" BGCOLOR="#FFF3CF"> Unidades: <input type="text" id="unidades" name="unidades" size="20"><br> </TD>
</TR>
</table>
<br><br>
<input type="button" name="BotonOK" value="Continuar Compra" onclick="add_cesta()">&nbsp;&nbsp;&nbsp;
<input type="button" name="BotonClear" value="Vaciar Cesta" onclick="clear_cesta()">&nbsp;&nbsp;&nbsp;
<input type="button" name="BotonFin" value="Finalizar Compra" onclick="fin_compra()">
<br><br>
<input type="button" name="BotonVolver" value="Volver Menu Usuario" onclick="location.href='Menu_Usuario.jsp'">

</form>

<br><br>

<br><br>
<h2>[ Cesta actual ]</h2>
<table border=1 ALIGN=“CENTER”>
<TR>
<TD WIDTH=50 ALIGN="CENTER" BGCOLOR="Brown">Id Articulo</TD> 
<TD WIDTH=200 ALIGN="CENTER" BGCOLOR="Brown">Titulo</TD>
<TD WIDTH=300 ALIGN="CENTER" BGCOLOR="Brown">Descripción</TD>
<TD WIDTH=150 ALIGN="CENTER" BGCOLOR="Brown">Foto</TD>
<TD WIDTH=50 ALIGN="CENTER" BGCOLOR="Brown">Cantidad</TD>
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
<td WIDTH=200 ALIGN="LEFT" BGCOLOR="#FFF3CF"><%=cesta_tmp.getTitulo()%></td>
<td WIDTH=300 ALIGN="LEFT" BGCOLOR="#FFF3CF"><%=cesta_tmp.getDescripcion()%></td>
<td WIDTH=150 ALIGN="CENTER" BGCOLOR="#FFF3CF"><img src='<%="Fotos/"+cesta_tmp.getFoto()%>'></td>
<td WIDTH=50 ALIGN="CENTER" BGCOLOR="#FFF3CF"><%=cesta_tmp.getCantidad()%></td>
<td WIDTH=50 ALIGN="RIGHT" BGCOLOR="#FFF3CF"><%=cesta_tmp.getPrecio()%></td>
<td WIDTH=50 ALIGN="RIGHT" BGCOLOR="#FFF3CF"><%=cesta_tmp.getTotal_linea()%></td>
</tr>
<%}
request.getSession().removeAttribute("ListaCesta");
%>
</table>
<table border=1 ALIGN=“CENTER”>
<tr><TD WIDTH=260 ALIGN="CENTER" BGCOLOR="Brown">Importe total cesta = </TD> <td WIDTH=100 ALIGN="CENTER" BGCOLOR="#FFF3CF"><%=nTotalCompra%></td>
</table>
<br>

</html>
