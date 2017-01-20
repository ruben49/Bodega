/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

/**
 *
 * @author Manuel
 */
public class Empleados {
    String Id_empleado;
    String Apellidos;
    String Nombres;
    String Domicilio;
    String Ciudad;
    int Id_region;
    String Fono;
    String Celular;
    String Fecha_nacimiento;
    int Id_genero;
    String Correo;
    String Fecha_ingreso;
    int Sueldo_base;

    public Empleados(String Id_empleado, String Apellidos, String Nombres, String Domicilio, String Ciudad, int Id_region, String Fono, String Celular, String Fecha_nacimiento, int Id_genero, String Correo, String Fecha_ingreso, int Sueldo_base) {
        this.Id_empleado = Id_empleado;
        this.Apellidos = Apellidos;
        this.Nombres = Nombres;
        this.Domicilio = Domicilio;
        this.Ciudad = Ciudad;
        this.Id_region = Id_region;
        this.Fono = Fono;
        this.Celular = Celular;
        this.Fecha_nacimiento = Fecha_nacimiento;
        this.Id_genero = Id_genero;
        this.Correo = Correo;
        this.Fecha_ingreso = Fecha_ingreso;
        this.Sueldo_base = Sueldo_base;
    }

    public Empleados() {
    }
    
    

    public String getId_empleado() {
        return Id_empleado;
    }

    public void setId_empleado(String Id_empleado) {
        this.Id_empleado = Id_empleado;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String Domicilio) {
        this.Domicilio = Domicilio;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public int getId_region() {
        return Id_region;
    }

    public void setId_region(int Id_region) {
        this.Id_region = Id_region;
    }

    public String getFono() {
        return Fono;
    }

    public void setFono(String Fono) {
        this.Fono = Fono;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getFecha_nacimiento() {
        return Fecha_nacimiento;
    }

    public void setFecha_nacimiento(String Fecha_nacimiento) {
        this.Fecha_nacimiento = Fecha_nacimiento;
    }

    public int getId_genero() {
        return Id_genero;
    }

    public void setId_genero(int Id_genero) {
        this.Id_genero = Id_genero;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getFecha_ingreso() {
        return Fecha_ingreso;
    }

    public void setFecha_ingreso(String Fecha_ingreso) {
        this.Fecha_ingreso = Fecha_ingreso;
    }

    public int getSueldo_base() {
        return Sueldo_base;
    }

    public void setSueldo_base(int Sueldo_base) {
        this.Sueldo_base = Sueldo_base;
    }
    
    
}
