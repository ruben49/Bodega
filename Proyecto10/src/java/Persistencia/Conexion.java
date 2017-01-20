/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Manuel
 */
public class Conexion {
    private String Url;
    private String Driver;
    private String User;
    private String Pass;
    private Connection conexion;
    
    
    public Conexion(){
        this.Url = "jdbc:mysql://localhost/empresa1";
        this.Driver = "com.mysql.jdbc.Driver";
        this.User = "root";
        this.Pass = "";
        this.conexion = null;
    }
    
    public void conectar() throws SQLException, ClassNotFoundException{
        Class.forName(this.Driver);
        this.conexion = DriverManager.getConnection(this.Url, this.User, this.Pass);
    }
    
    public void desconectar() throws SQLException  {
          
            this.conexion.close();
       }
    
    public Connection getConexion() {
        return this.conexion;
    }
    
    
}
