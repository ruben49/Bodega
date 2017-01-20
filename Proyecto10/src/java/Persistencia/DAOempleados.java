/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import Clases.Empleados;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Manuel
 */
public class DAOempleados {
    private Conexion Conectar;
    private ResultSet Resultado;
    
    
    public DAOempleados(){
       this.Conectar = new Conexion();
       this.Resultado = null;
   }
    
    public boolean Insertar_emp(Empleados Emp) {
        boolean ok = false;
               
        String Fecha1 = Emp.getFecha_nacimiento().substring(6) + "-" + Emp.getFecha_nacimiento().substring(3, 5) + "-" + Emp.getFecha_nacimiento().substring(0, 2);
        String Fecha2 = Emp.getFecha_ingreso().substring(6) + "-" + Emp.getFecha_ingreso().substring(3, 5) + "-" + Emp.getFecha_ingreso().substring(0, 2);
        
        Date oFecha1 = Date.valueOf(Fecha1);
        Date oFecha2 = Date.valueOf(Fecha2);
        
        String mSql = "insert into empleados(id_empleado, apellidos, nombres, domicilio, ciudad, id_region, fono, celular, " + 
           "fecha_nacimiento, id_genero, correo, fecha_ingreso, sueldo_base) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            this.Conectar.conectar();
            PreparedStatement st = (PreparedStatement) this.Conectar.getConexion().prepareStatement(mSql);
            st.setString(1, Emp.getId_empleado());
            st.setString(2, Emp.getApellidos());
            st.setString(3, Emp.getNombres());
            st.setString(4, Emp.getDomicilio());
            st.setString(5, Emp.getCiudad());
            st.setInt(6, Emp.getId_region());
            st.setString(7,Emp.getFono());
            st.setString(8, Emp.getCelular());
            st.setDate(9, oFecha1 );
            st.setInt(10, Emp.getId_genero());
            st.setString(11, Emp.getCorreo());
            st.setDate(12, oFecha2);
            st.setInt(13, Emp.getSueldo_base());
            
            st.executeUpdate();
            ok = true;
            this.Conectar.desconectar();
            
        } catch (SQLException | ClassNotFoundException ex) {
        }
             
        
        return ok;
    }
    
    public ResultSet Buscar_empleados(String mRut){
         String mSql = "SELECT * FROM empleados WHERE id_empleado = ?";
        
        try {
            
            this.Conectar.conectar();
            PreparedStatement st = (PreparedStatement) this.Conectar.getConexion().prepareStatement(mSql);
            st.setString(1, mRut);
            this.Resultado = st.executeQuery();
                               
                    
        } catch (SQLException | ClassNotFoundException ex) {
        }
               
        
        return this.Resultado;
    }

    
    public boolean Actualizar_emp(Empleados Emp){
        boolean ok = false;
               
        String Fecha1 = Emp.getFecha_nacimiento().substring(6) + "-" + Emp.getFecha_nacimiento().substring(3, 5) + "-" + Emp.getFecha_nacimiento().substring(0, 2);
        String Fecha2 = Emp.getFecha_ingreso().substring(6) + "-" + Emp.getFecha_ingreso().substring(3, 5) + "-" + Emp.getFecha_ingreso().substring(0, 2);
        
        Date oFecha1 = Date.valueOf(Fecha1);
        Date oFecha2 = Date.valueOf(Fecha2);
        
        String mSql = "UPDATE empleados SET apellidos= ?, nombres= ?, domicilio= ?, ciudad= ?, id_region=?, fono=?, celular=?, " + 
           "fecha_nacimiento=?, id_genero=?, correo=?, fecha_ingreso=?, sueldo_base=? WHERE id_empleado = ?";
        
        try {
            this.Conectar.conectar();
            PreparedStatement st = (PreparedStatement) this.Conectar.getConexion().prepareStatement(mSql);
            
            st.setString(1, Emp.getApellidos());
            st.setString(2, Emp.getNombres());
            st.setString(3, Emp.getDomicilio());
            st.setString(4, Emp.getCiudad());
            st.setInt(5, Emp.getId_region());
            st.setString(6,Emp.getFono());
            st.setString(7, Emp.getCelular());
            st.setDate(8, oFecha1 );
            st.setInt(9, Emp.getId_genero());
            st.setString(10, Emp.getCorreo());
            st.setDate(11, oFecha2);
            st.setInt(12, Emp.getSueldo_base());
            st.setString(13, Emp.getId_empleado());
            
            st.executeUpdate();
            ok = true;
            this.Conectar.desconectar();
            
        } catch (SQLException | ClassNotFoundException ex) {
        }
             
               
        return ok; 
        
    }
    
    
     public ResultSet ListaGeneral(){
       
        String mSql = "SELECT * FROM empleados, region, genero WHERE empleados.id_region = region.id_region AND " +
                      "empleados.id_genero = genero.id_genero";
        
        try {
            this.Conectar.conectar();
            PreparedStatement st = (PreparedStatement) this.Conectar.getConexion().prepareStatement(mSql);
            this.Resultado = st.executeQuery();
                                
                  
        } catch (SQLException | ClassNotFoundException ex) {
        }
               
        
        return this.Resultado;
        
    }
   
     public ResultSet ListaCondicion(String Buscar){
       
        String mSql = "SELECT * FROM empleados, region, genero WHERE id_empleado LIKE '" + Buscar + "%' ";
        
        try {
            this.Conectar.conectar();
            PreparedStatement st = (PreparedStatement) this.Conectar.getConexion().prepareStatement(mSql);
            this.Resultado = st.executeQuery();
                                
          //  Conectar.desconectar();
            
        } catch (SQLException | ClassNotFoundException ex) {
        }
               
        
        return this.Resultado;
        
    }
    
    public boolean Eliminar_emp(String mRut){
        String mSql = "DELETE FROM empleados WHERE id_empleado = ? ";
        boolean ok = false;
        
        
        try {
            this.Conectar.conectar();
            PreparedStatement st = (PreparedStatement) this.Conectar.getConexion().prepareStatement(mSql);
            st.setString(1, mRut);
            st.executeUpdate();
            ok = true;                    
               
        } catch (SQLException | ClassNotFoundException ex) {
        }
        
      return ok;  
    }
     
   
     
    
     public void Cerrar_Empleados() throws SQLException, ClassNotFoundException{
        
        Conectar.desconectar();
    } 

      
}
