/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet;

import Clases.Empleados;
import Persistencia.DAOempleados;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Manuel
 */
public class Grabaemp extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Empleados Emp = new Empleados();
        DAOempleados Insertempleados = new DAOempleados();
        boolean algo;
        String Error=null;
        String Sw = request.getParameter("sw");
               
        Emp.setId_empleado(request.getParameter("id_empleado"));
        Emp.setApellidos(request.getParameter("apellidos"));
        Emp.setNombres(request.getParameter("nombres"));
        Emp.setDomicilio(request.getParameter("domicilio"));
        Emp.setCiudad(request.getParameter("ciudad"));
        Emp.setId_region(Integer.parseInt(request.getParameter("regiones")));
        Emp.setFono(request.getParameter("fono"));
        Emp.setCelular(request.getParameter("celular"));
        Emp.setFecha_nacimiento(request.getParameter("fecha_nacimiento"));
        Emp.setId_genero(Integer.parseInt(request.getParameter("genero")));
        Emp.setCorreo(request.getParameter("correo"));
        Emp.setFecha_ingreso(request.getParameter("fecha_ingreso"));
        Emp.setSueldo_base(Integer.parseInt(request.getParameter("sueldo_base")));
        
       
        if (Sw.equals("1")){
            
                   
            if (Insertempleados.Actualizar_emp(Emp)){
                Error = "Actualizacion correcta";
                
            }else{
                Error = "Error, al intentar actualizar";
            }
                    
        }else{
        
        
        if (Insertempleados.Insertar_emp(Emp)){
            Error = "Se guardo correctamente";
        }else{
            Error = "Error, al intentar guardar";
        }
                            
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Grabaemp</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + Error + "</h1>");
            out.println("<hr>");
            out.println("<a href=index.html> Volver al menu </a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
