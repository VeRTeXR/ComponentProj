/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import helperclasses.UpdatingRecord;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Student;
import model.StudentLogger;
import utilities.DatabaseDriver;
import utilities.DatabaseHandler;

/**
 *
 * @author KOKOKRUNCH
 */
public class create extends HttpServlet {

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
        HttpSession session = request.getSession();
        DatabaseDriver dbDriver = (DatabaseDriver) this.getServletContext().getAttribute("dbDriver");
        DatabaseHandler dbHandler;
        
        try {
            dbHandler = new DatabaseHandler(dbDriver);
            int id = Integer.parseInt(request.getParameter("id"));
            Student std = new Student();
            Account acc = new Account();
            std.setId(new Integer(request.getParameter("id")));
            std.setName(request.getParameter("name"));
            System.out.println(request.getParameter("name"));
            std.setAddress(request.getParameter("address"));
            std.setFaculty(request.getParameter("faculty"));
            acc.setPassword(request.getParameter("pwd"));
            synchronized(this.getServletContext()) {
                if (UpdatingRecord.isUpdating(this.getServletContext(), id)) {
                    dbHandler.closeDatabase();
                    request.getRequestDispatcher("notifylocked.jsp").forward(request, response);
                }
                int rowUpdated = 0;
                rowUpdated = StudentLogger.insertStudent(dbHandler, std,acc);
                System.out.println(rowUpdated);
                request.setAttribute("rowInserted", rowUpdated);
                request.getRequestDispatcher("CreateResult.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            
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
