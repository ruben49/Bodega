/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Manuel
 */
public class DAOgenero {
    private Conexion Conectar;
    private ResultSet Resultado;
    
    
    public DAOgenero(){
       this.Conectar = new Conexion();
       this.Resultado = null;
   }
    
    public ResultSet ListaGenero(){
       
        String mSql = "SELECT * FROM genero";
        
        try {
            this.Conectar.conectar();
            PreparedStatement st = (PreparedStatement) this.Conectar.getConexion().prepareStatement(mSql);
            this.Resultado = st.executeQuery();
                                
            } catch (SQLException | ClassNotFoundException ex) {
        }
               
        
        return this.Resultado;
        
    }
    
     public void Cerrar_Genero() throws SQLException, ClassNotFoundException{
        
        Conectar.desconectar();
    }
    
    
    
}
