<%-- 
    Document   : ingresoemp
    Created on : 10-05-2014, 11:53:36 PM
    Author     : Manuel
--%>

<%@page import="Persistencia.DAOgenero"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Persistencia.DAOregion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% DAOregion Region = new DAOregion();%>
<% DAOgenero Genero = new DAOgenero();%>
<% ResultSet Lista1 = null; %>
<% ResultSet Lista2 = null; %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ingreso de empleados</h1>
        
      <% Lista1 = Region.ListaRegion(); %>
      <% Lista2 = Genero.ListaGenero(); %>
        
       
        <form name="Ingreso_empleados" method="POST" action="Grabaemp">
            
            <p> Rut <input type="text" name="id_empleado" value="" /> </p>
            <p> Apellidos <input type="text" name="apellidos" value="" /> </p>  
            <p> Nombres <input type="text" name="nombres" value="" /> </p>  
            <p> Domicilio <input type="text" name="domicilio" value="" /> </p>
            <p> Ciudad <input type="text" name="ciudad" value="" />
            
            <p> Region <select name="regiones">
                
            <% while (Lista1.next()) { %>    
            <option value=  <%=Lista1.getInt("id_region")%> > <%=Lista1.getString("detalle_region")%> </option>
                
            <%}%>    
            </select>
            </p>    
            <%Region.Cerrar_Region();%>
            
            <p> fono <input type="text" name="fono" value="" /> </p>
            <p> Celular <input type="text" name="celular" value="" /> </p>  
            <p> Fecha Nacimiento <input type="text" name="fecha_nacimiento" value="" /> </p>    
            
            <p> Genero <select name="genero">
                
            <% while (Lista2.next()) { %>    
            <option value=  <%=Lista2.getInt("id_genero")%> > <%=Lista2.getString("detalle_genero")%> </option>
                
            <%}%>    
            </select>
            </p>    
            <%Genero.Cerrar_Genero();%>
           
            <p> Correo <input type="text" name="correo" value="" /> </p>    
            <p> Fecha Ingreso <input type="text" name="fecha_ingreso" value="" /> </p>  
            <p> Sueldo Base <input type="text" name="sueldo_base" value="" /> </p>
                <input type="hidden" name="sw" value="0">
            <input type="submit" value="Grabar" name="boton1" />
                        
        </form>
                
    </body>
</html>
