<%-- 
    Document   : editaremp
    Created on : 17-05-2014, 08:59:51 PM
    Author     : Manuel
--%>

<%@page import="Persistencia.DAOgenero"%>
<%@page import="Persistencia.DAOregion"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% ResultSet Resultado = (ResultSet) request.getAttribute("resultado"); %>
<% DAOregion Region = new DAOregion();%>
<% DAOgenero Genero = new DAOgenero();%>
<% ResultSet Lista1 = null; %>
<% ResultSet Lista2 = null; %>

        
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar empleados</title>
    </head>
    <body>
        <h1>Ingrese rut a Buscar...</h1>
        
        <form name="buscar" action="Buscaremp" method="POST">
            Rut <input type="text" name="id_empleado" value="" />
            <input type="submit" value="Buscar" name="boton1" />
        </form>
        
        <hr>
        
        <%if (Resultado != null) {%> 
        
        <% if (Resultado.next()) {%>
              
        <h1> Datos del empleado </h1>
        
        <% Lista1 = Region.ListaRegion(); %>
        <% Lista2 = Genero.ListaGenero(); %>
        <form name="editar" action="Borraremp" method="POST">
            
            Rut <input type="text" name="id_empleado" value= <%=Resultado.getString(1)%>  readonly />
            Apellidos <input type="text" name="apellidos" value= <%=Resultado.getString(2)%> readonly />
            Nombres <input type="text" name="nombres" value=<%=Resultado.getString(3)%> readonly /> 
            Domicilio <input type="text" name="domicilio" value=<%=Resultado.getString(4)%> readonly /> 
            Ciudad <input type="text" name="ciudad" value=<%=Resultado.getString(5)%> readonly />
            
            Region <select name="regiones">
                
            <% while (Lista1.next()) { %>    
            <option value=  <%=Lista1.getInt("id_region")%> > <%=Lista1.getString("detalle_region")%> </option>
                
            <%}%>    
            </select>
                
            <%Region.Cerrar_Region();%>
            
            fono <input type="text" name="fono" value=<%=Resultado.getString(7)%> /> 
            Celular <input type="text" name="celular" value=<%=Resultado.getString(8)%> />   
            
            <%String mFecha1 = Resultado.getString(9).trim();%>
            <%mFecha1 = mFecha1.substring(8) + "-" + mFecha1.substring(5, 7) + "-" + mFecha1.substring(0,4); %>
            
            <%String mFecha2 = Resultado.getString(12);%>
            <%mFecha2 = mFecha2.substring(8) + "-" + mFecha2.substring(5, 7) + "-" + mFecha2.substring(0,4); %>
            
            Fecha Nacimiento <input type="text" name="fecha_nacimiento" value=<%=mFecha1%>  readonly />    
            
             Genero <select name="genero">
                
            <% while (Lista2.next()) { %>    
            <option value=  <%=Lista2.getInt("id_genero")%> > <%=Lista2.getString("detalle_genero")%> </option>
                
            <%}%>    
            </select>
              
            <%Genero.Cerrar_Genero();%>
           
            Correo <input type="text" name="correo" value=<%=Resultado.getString(11)%>  readonly/>     
            Fecha Ingreso <input type="text" name="fecha_ingreso" value=<%=mFecha2%> readonly />   
            Sueldo Base <input type="text" name="sueldo_base" value=<%=Resultado.getString(13)%> readonly />     
                         
                
               
            <p>    <input type="submit" value="Confirmar" name="boton2" />
            
        </form>
        
        <%} else { %>
        
        <h1> Error, no existe el rut buscado.... </h1>
            
        <%}%>    
            
        <%}%>     
        
    </body>
</html>
