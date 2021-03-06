/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Report;
import utilities.DatabaseDriver;
import utilities.DatabaseHandler;
import static web.report_servlet.count;
import model.Account;
import model.Student;

/**
 *
 * @author VeRTeXR
 */
public class permission extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        DatabaseDriver dbDriver = (DatabaseDriver)this.getServletContext().getAttribute("dbDriver");
        //System.out.println(request.getSession().getAttribute("a"));
        HttpSession session = request.getSession();
        session.setAttribute("id", request.getParameter("username"));
        try {
            DatabaseHandler dbHandler = new DatabaseHandler(dbDriver);
            Account mem = new Account();
            mem.setUsername(request.getParameter("username"));
            mem.setPassword(request.getParameter("password"));
            String sql = "select * from ACCOUNT where ID = "+mem.getUsername()+" and PASSWORD = "+"'"+mem.getPassword()+"'";
            ResultSet rs = dbHandler.query(sql);
            rs.next();
            if(rs.getBoolean("is_admin")){
                dbHandler.closeDatabase();
                this.getServletContext().setAttribute("stdid", request.getParameter("username"));
                request.getRequestDispatcher("adminpage.jsp").forward(request, response);
            }
            else {
                dbHandler.closeDatabase();
                this.getServletContext().setAttribute("stdid", request.getParameter("username"));
                request.getRequestDispatcher("show_infomation.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }catch (ClassCastException ex) { }
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
