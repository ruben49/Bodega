/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet;

import Persistencia.DAOempleados;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Manuel
 */
public class Reporte extends HttpServlet {

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
        
         String Buscar = request.getParameter("buscar");
        DAOempleados Listado1 = new DAOempleados();
        ResultSet Resultado = null;
          
        response.setContentType("text/html;charset=UTF-8");
       
        if(Buscar.isEmpty()){
        
        Resultado = Listado1.ListaGeneral();
                 
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ejemplo de Reporte</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> LISTADO GENERAL DE EMPLEADOS</h1>");
            out.println("<hr>");
            out.println("<br>");
            out.println("Rut               Apellidos           Nombres             Region           Genero");
            
                        
            try{
                while(Resultado.next()){
                
                     out.println("<p>" + Resultado.getInt(1) + "|" + Resultado.getString(2) + "|" + Resultado.getString(3) + "|" +Resultado.getString(15) +  "|" + Resultado.getString(17) );
                }
            }catch( SQLException ex){  }  
         
                     
            out.println("</body>");
            out.println("</html>");
        
        }
        }else{
            
         Resultado = Listado1.ListaCondicion(Buscar);
                 
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ejemplo de Reporte</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> LISTADO DE EMPLEADOS POR APELLIDOS </h1>");
            out.println("<hr>");
                        
            try{
                while(Resultado.next()){
                
                     out.println("<p>" + Resultado.getInt(1) + " " + Resultado.getString(2));
                }
            }catch( SQLException ex){  }  
         
                     
            out.println("</body>");
            out.println("</html>");
        
        }
                
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
